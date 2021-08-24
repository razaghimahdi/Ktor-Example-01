package com.example.ktor_example_01.networking

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktor_example_01.networking.dto.User
import io.ktor.util.*
import kotlinx.coroutines.launch

@KtorExperimentalAPI
class MainViewModel : ViewModel() {

    val users: MutableState<List<User>> = mutableStateOf(ArrayList())

    init {
        viewModelScope.launch {
            users.value = NetworkApi.getUser()
        }
    }

}