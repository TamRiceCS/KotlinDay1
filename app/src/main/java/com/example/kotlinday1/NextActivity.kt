package com.example.kotlinday1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class NextActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val username = intent.getStringExtra("userName")
        val textView = findViewById<TextView>(R.id.textView)

        textView.text = "$username, you're on the next page now"


    }
}