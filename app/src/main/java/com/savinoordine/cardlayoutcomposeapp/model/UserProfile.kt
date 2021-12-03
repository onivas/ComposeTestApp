package com.savinoordine.cardlayoutcomposeapp.model

import com.savinoordine.cardlayoutcomposeapp.R

data class UserProfile(
    val name: String,
    val status: Boolean,
    val drawableId: Int,
)

val userProfileMocks = arrayListOf(
    UserProfile(name = "Gino Pilotino", status = true, drawableId = R.drawable.profile_picture),
    UserProfile(name = "Mario Kart", status = false, drawableId = R.drawable.profile_picture),
)