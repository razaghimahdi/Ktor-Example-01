package com.example.ktor_example_01

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.ktor_example_01.networking.dto.User
import com.example.ktor_example_01.theme.AppTheme

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
public fun UserListScreen(
    isDarkTheme: Boolean,
    users: List<User>
) {

    val TAG="UserListScreen"

    var showProgress = users.isEmpty()

    val scaffoldState = rememberScaffoldState()


    Log.i(TAG, "UserListScreen users: $users")

    AppTheme(
        darkTheme = isDarkTheme,
        displayProgressBar = showProgress,
        scaffoldState = scaffoldState,
    ) {

        Scaffold(
            scaffoldState = scaffoldState,

            ) {
            Box(
                modifier = Modifier
                    .background(color = MaterialTheme.colors.surface)
            ) {

                LazyColumn {
                    itemsIndexed(
                        items = users
                    ) { index, user ->
                        UserCard(
                            user = user,
                        )
                    }
                }


            }
        }


    }


}


