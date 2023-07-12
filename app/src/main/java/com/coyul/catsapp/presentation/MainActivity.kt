package com.coyul.catsapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coyul.catsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding
            .inflate(layoutInflater)
            .also { binding -> setContentView(binding.root) }
    }
}