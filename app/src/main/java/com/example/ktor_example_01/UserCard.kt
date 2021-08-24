package com.example.ktor_example_01

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.ktor_example_01.networking.dto.User

@Composable
fun UserCard(user: User) {

    val fullname = user.name.title + "." + user.name.first + " " + user.name.last

    Card(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {

        Row (modifier = Modifier.padding(8.dp)){

            /*CoilImage(
                data = user.picture.medium,
                contentDescription = fullname,
                modifier = Modifier
                    .width(75.dp)
                    .height(75.dp),
                contentScale = ContentScale.Crop,
            )*/

            Image(
                painter = rememberImagePainter(
                    data = user.picture.medium,
                    builder = {
                        transformations(CircleCropTransformation())
                    }
                ),
                contentDescription = null,
                modifier = Modifier.size(75.dp)
            )

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding( start = 8.dp, end = 8.dp)
            ) {

                Text(text = fullname)

                Text(text = user.gender)

                Text(text = user.email)

                Text(text = user.phone)



            }

        }


    }


}