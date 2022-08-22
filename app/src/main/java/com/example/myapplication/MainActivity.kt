package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.*
import com.example.myapplication.viewmodel.SavedStateViewModel
import androidx.fragment.app.activityViewModels
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    val savedStateViewModel by viewModels<SavedStateViewModel>()

    var localCounter:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener({
            savedStateViewModel.incrementCount()
        })

        savedStateViewModel.count.observe(this,{
            binding.textView.text = "count: $it"
        })

        binding.button2.setOnClickListener({
            localCounter++
            binding.textView4.text = "count: $localCounter"
        })


    }
}