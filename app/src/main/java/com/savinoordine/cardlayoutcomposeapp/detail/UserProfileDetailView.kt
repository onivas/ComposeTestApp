package com.savinoordine.cardlayoutcomposeapp.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.savinoordine.cardlayoutcomposeapp.AppBar
import com.savinoordine.cardlayoutcomposeapp.ProfileContent
import com.savinoordine.cardlayoutcomposeapp.ProfilePicture
import com.savinoordine.cardlayoutcomposeapp.model.UserProfile
import com.savinoordine.cardlayoutcomposeapp.model.userProfileList
import com.savinoordine.cardlayoutcomposeapp.ui.theme.MyTheme

@Composable
fun UserDetailScreen(userProfile: UserProfile = userProfileList.first()) {
    Scaffold(topBar = { AppBar() }) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.LightGray
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfilePicture(
                    pictureUrl = userProfile.pictureUrl,
                    onlineStatus = userProfile.status,
                    240.dp
                )
                ProfileContent(name = userProfile.name, onlineStatus = userProfile.status)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun UserDetailPreview() {
    MyTheme {
        UserDetailScreen()
    }
}