package com.example.demoservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demoservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val DATA_INTENT = "DATA_INTENT"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMainStartService.setOnClickListener {
            startService()
        }

        binding.btnMainStopService.setOnClickListener {
            stopService()
        }
    }

    private fun startService() {
        val intent = Intent(this, MyService::class.java)
        intent.putExtra(DATA_INTENT, binding.edtMainContent.text.toString())
        startService(intent)
        binding.edtMainContent.clearFocus()
        binding.edtMainContent.setText("")
    }

    private fun stopService() {
        val intent = Intent(this, MyService::class.java)
        stopService(intent)
    }
}
