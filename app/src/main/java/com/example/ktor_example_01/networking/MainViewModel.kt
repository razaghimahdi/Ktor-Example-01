package com.example.ktor_example_01.networking

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktor_example_01.networking.dto.User
import io.ktor.util.*
import kotlinx.coroutines.launch

@KtorExperimentalAPI
class MainViewModel : ViewModel() {

    val users = MutableLiveData<List<User>>()

    init {
        viewModelScope.launch {
            users.value = NetworkApi.getUser()
        }
    }

}