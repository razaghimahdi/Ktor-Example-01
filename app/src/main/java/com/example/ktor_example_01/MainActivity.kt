package com.example.ktor_example_01

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktor_example_01.databinding.ActivityMainBinding
import com.example.ktor_example_01.networking.MainViewModel
import io.ktor.util.*

@KtorExperimentalAPI
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private val userAdapter = UserAdapter()


    private var _binding: ActivityMainBinding?=null
    private val binding get() = _binding!!



    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.users.observe(this, { users ->
            userAdapter.items = users
            userAdapter.notifyDataSetChanged()
            Log.i("TAG", "onCreate users: "+users.toList())
            binding.progressBar.visibility= View.GONE
        })

        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}