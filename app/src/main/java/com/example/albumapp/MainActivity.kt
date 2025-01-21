package com.example.albumapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.albumapp.modelo.Album
import com.example.albumapp.modelo.albums
import com.example.albumapp.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface {
                    AlbumApp()
                }
            }
        }
    }
}

@Composable
fun AlbumApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            AlbumTopBar()
        }

    ) { innerPadding ->

        Column {
            LazyRow(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),

                verticalAlignment = Alignment.CenterVertically
            ) {
                items(albums) {
                    AlbumItem(
                        album = it,
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
                    )
                }
            }
        }

    }
}

@Composable
fun AlbumItem(
    album: Album,
    modifier: Modifier = Modifier,
){
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.primaryContainer
        else MaterialTheme.colorScheme.secondaryContainer
    )
    val size by animateDpAsState(
        targetValue = if (expanded) dimensionResource(R.dimen.image_expanded)
        else dimensionResource(R.dimen.image_size)
    )
    Card(
        modifier = modifier
    ) {
        Column (
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .width(size)
                .background(color = color)
        ){
            Image(
                painter = painterResource(album.cover),
                contentDescription = stringResource(album.name),
                modifier = Modifier
                    .size(size)
                    .padding(dimensionResource(R.dimen.padding_small))
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                AlbumInformation(album.name, album.group)
                Spacer(modifier = Modifier.weight(1f))
                ExpandButton(
                    expanded = expanded,
                    onClick = {expanded = !expanded}
                )
            }
            if (expanded){
                AlbumInformationExpanded(album.songCount, album.duration)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlbumTopBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        modifier = modifier,
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.logo_size))
                        .padding(dimensionResource(R.dimen.padding_small)),
                    // TODO: Por alguna razon la previes no se corre si ponemos aqui el icono cuando pueda investigo y si no png y a tomar por culo, dejad el place holder
                    painter = painterResource(R.drawable.place_holder),
                    contentDescription = null,
                )
                Text(
                    text = stringResource(R.string.app_name)
                )
            }
        }
    )
}

@Composable
fun AlbumInformation(
    @StringRes albumname: Int,
    @StringRes albumgroup: Int,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ){
        Text(
            text = stringResource(albumname),
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
        )
        Text(
            text = stringResource(albumgroup)
        )
    }
} 

@Composable
fun AlbumInformationExpanded(
     @StringRes songCount : Int,
     @StringRes duration: Int,
     modifier: Modifier = Modifier
){
    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_small)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(R.string.songCount, songCount)
        )
        Text(
            text = stringResource(R.string.duration, duration)
        )
    }
}

@Composable
fun ExpandButton(
    expanded : Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_desc),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}
@Preview(showBackground = true)
@Composable
fun AlbumAppPreview() {
    AppTheme  {
        AlbumApp()
    }
}