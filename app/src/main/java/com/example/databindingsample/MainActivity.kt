package com.example.databindingsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.databindingsample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.sampleButton.setOnClickListener {
            binding.sampleTextView.text = "Hello, Binding!"

        }


//        val sampleTextView: TextView = findViewById(R.id.sample_text_view)
//        sampleTextView.text = "Hello Android"


    }
}