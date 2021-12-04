package com.savinoordine.cardlayoutcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.savinoordine.cardlayoutcomposeapp.model.UserProfile
import com.savinoordine.cardlayoutcomposeapp.navigation.UserNavigation
import com.savinoordine.cardlayoutcomposeapp.ui.theme.MyTheme
import com.savinoordine.cardlayoutcomposeapp.utils.colorForOnlineUser
import com.savinoordine.cardlayoutcomposeapp.utils.stringStatusForOnlineUser

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                UserNavigation()
            }
        }
    }
}

@Composable
fun UserListScreen(userProfiles: List<UserProfile>, navController: NavHostController) {
    Scaffold(topBar = { AppBar() }) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.LightGray
        ) {
            LazyColumn {
                items(userProfiles) { userProfile ->
                    ProfileCard(userProfile = userProfile) {
                        navController.navigate("user_detail/${userProfile.id}")
                    }
                }
            }
        }
    }
}

@Composable
fun AppBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "",
                modifier = Modifier.padding(8.dp)
            )
        },
        title = { Text(text = "Application contact") })
}

@Composable
fun ProfileCard(userProfile: UserProfile, userClicked: (UserProfile) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 4.dp)
            .clickable { userClicked.invoke(userProfile) },
        elevation = 8.dp,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            ProfilePicture(userProfile.pictureUrl, userProfile.status, 72.dp)
            ProfileContent(userProfile.name, userProfile.status)
        }
    }
}

@Composable
fun ProfileContent(name: String, onlineStatus: Boolean) {
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.h5
        )
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = onlineStatus.stringStatusForOnlineUser(),
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Composable
fun ProfilePicture(pictureUrl: String, onlineStatus: Boolean, imageSize: Dp) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = onlineStatus.colorForOnlineUser(),
        ),
        modifier = Modifier
            .padding(16.dp),
        elevation = 6.dp,
    ) {
        Image(
            painter = rememberImagePainter(data = pictureUrl,
                builder = { transformations(CircleCropTransformation()) }
            ),
            contentDescription = null,
            modifier = Modifier.size(imageSize),
            contentScale = ContentScale.Crop,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun UserListPreview() {
    MyTheme {
        UserNavigation()
    }
}