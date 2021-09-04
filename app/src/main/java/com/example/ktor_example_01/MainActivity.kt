package com.example.ktor_example_01

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktor_example_01.databinding.ActivityMainBinding
import com.example.ktor_example_01.networking.MainViewModel
import com.example.ktor_example_01.networking.dto.User
import io.ktor.util.*

@KtorExperimentalAPI
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel


    @ExperimentalComposeUiApi
    @ExperimentalMaterialApi
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

            val users = viewModel.users.value

            UserListScreen(users=users, isDarkTheme = false)


        }


    }


}
