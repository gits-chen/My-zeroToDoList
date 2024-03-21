package com.example.myzerotodolist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myzerotodolist.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val contentView = binding.root
        setContentView(contentView)

        binding.notebook.setOnClickListener {
            Toast.makeText(this,"你点了笔记",Toast.LENGTH_SHORT).show()
        }
        binding.list.setOnClickListener {
            Toast.makeText(this,"你点了待办",Toast.LENGTH_SHORT).show()
        }
        binding.mine.setOnClickListener {
            val uri = Uri.parse("https://ys.mihoyo.com/")
            val intent = Intent()

            intent.data = uri

            startActivity(intent)
        }
    }
}