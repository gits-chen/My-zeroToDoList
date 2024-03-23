package com.example.myzerotodolist

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myzerotodolist.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton


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

        var selectIndex = 0
        binding.side.addOnButtonCheckedListener{ group, CheckedId ,isChecked ->
            val childcount = group.childCount
            for (index in 0 until  childcount){
                val button= group.getChildAt(index) as MaterialButton

                if(button.id==CheckedId){
                    selectIndex = index
                    button.setTextColor(Color.GREEN)
                    button.iconTint= ColorStateList.valueOf(Color.GREEN)
                }else{
                    button.setTextColor(Color.BLACK)
                    button.iconTint= ColorStateList.valueOf(Color.BLACK)
                }
            }
        }

        binding.side.check(R.id.notebook)
        switchFragment(selectIndex)
    }
    private fun switchFragment(selectIndex: Int) {
        val fragment = when (selectIndex){
            0 -> {
                if (notebookFragment)
            }
        }
    }
}