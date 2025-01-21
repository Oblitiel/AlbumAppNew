package com.example.albumapp.modelo

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.albumapp.R

data class Album(
    @StringRes val group : Int,
    @StringRes val name : Int,
    @DrawableRes val cover : Int,
    val duration : Int,
    val songCount : Int,
)

val albums = listOf(
    Album(R.string.extremoduro,R.string.agila ,R.drawable.agila, 46, 14),
    Album(R.string.extremoduro,R.string.ley_innata ,R.drawable.la_ley_innata, 45, 6),
    Album(R.string.extremoduro,R.string.yo_minoria_absoluta ,R.drawable.yo_minoria_absoluta, 42, 10),
    Album(R.string.extremoduro,R.string.rock_transgresivo ,R.drawable.rock_transgresivo, 52, 15),
    Album(R.string.extremoduro,R.string.deltoya ,R.drawable.deltoya, 79, 20),
    Album(R.string.nirvana,R.string.in_utero ,R.drawable.in_utero, 41, 12),
    Album(R.string.nirvana,R.string.nevermind ,R.drawable.nevermind, 49, 13),
    Album(R.string.nirvana,R.string.bleach ,R.drawable.bleach, 42, 13),
    Album(R.string.slowdive,R.string.everything_is_alive ,R.drawable.everything_is_alive, 41, 8),
    Album(R.string.slowdive,R.string.pygmalion,R.drawable.pygmalion, 106, 21),
    Album(R.string.slowdive,R.string.souvlaki,R.drawable.souvlaki, 40, 10),
    Album(R.string.slowdive,R.string.just_for_a_day,R.drawable.just_for_a_day, 104, 21),
    Album(R.string.radiohead,R.string.kid_a_mnesia,R.drawable.kid_a_mnesia, 125, 34),
    Album(R.string.radiohead,R.string.moon_shaped_pool,R.drawable.moon_shaped_pool, 52, 11),
    Album(R.string.radiohead,R.string.the_king_of_limbs,R.drawable.the_king_of_limbs, 37, 8),
    Album(R.string.radiohead,R.string.amnesiac,R.drawable.amnesiac, 43, 11),
    Album(R.string.radiohead,R.string.kid_a,R.drawable.kid_a, 47, 11),
    Album(R.string.robe,R.string.lo_que_aletea,R.drawable.lo_que_aletea_en_nuestras_cabezas, 43, 8),
    Album(R.string.hip,R.string.lcl_sea,R.drawable.lcl_sea, 29, 8),
    Album(R.string.soad,R.string.hypnotize,R.drawable.hypnotize, 39, 12),
    Album(R.string.soad,R.string.toxicity,R.drawable.toxicity, 44, 15),
    Album(R.string.soad,R.string.steal_this_album,R.drawable.steal_this_album, 43, 16),
    Album(R.string.type_o_negative,R.string.bloody_kisses,R.drawable.bloody_kisses, 73, 14),
    Album(R.string.type_o_negative,R.string.october_rust,R.drawable.october_rust, 73, 15),
    Album(R.string.type_o_negative,R.string.life_is_killing_me,R.drawable.life_is_killing_me, 74, 15),
    Album(R.string.kekth_arakh,R.string.night_n_love,R.drawable.night_and_love, 41, 13),
    Album(R.string.kekth_arakh,R.string.pale_swordsman,R.drawable.pale_swordsman, 31, 10),
    Album(R.string.the_cure,R.string.songs_of_a_lost_world,R.drawable.songs_of_a_lost_world, 49, 8),
    Album(R.string.the_cure,R.string.seventeen_seconds,R.drawable.seventeen_seconds, 35, 10),
    Album(R.string.psychonaut4,R.string.dipsomania,R.drawable.dipsomania, 67, 12),
    Album(R.string.psychonaut4,R.string.neurasthenia,R.drawable.neurasthenia, 73, 10),
    Album(R.string.psychonaut4,R.string.scrapes_from_the_past,R.drawable.scrapes_from_the_past, 78, 14),


)