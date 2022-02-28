package com.example.counterapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.counterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        private const val KEY_COUNT = "key_count"
    }

    private lateinit var binding: ActivityMainBinding

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            buttonIncrement.setOnClickListener {
                count++
                tvCount.text = count.toString()
            }

            buttonDecrement.setOnClickListener {
                if (count > 0) {
                    count--
                }
                tvCount.text = count.toString()
            }

            buttonReset.setOnClickListener {
                count = 0
                tvCount.text = count.toString()
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val existingCount = savedInstanceState.getInt(KEY_COUNT,0)
        count = existingCount
        binding.tvCount.text = count.toString()
    }
}