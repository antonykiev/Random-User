package com.example.randomuser.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.randomuser.R
import com.example.randomuser.presentation.viewmodel.RandomUserViewModel

class MainActivity : AppCompatActivity() {

    private val randomUserViewModel by lazy { ViewModelProvider(this)[RandomUserViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomUserViewModel.randomUser.observe(this) {
            Log.e("randomuser", it.toString())
        }
    }

}