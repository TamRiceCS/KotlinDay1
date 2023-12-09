package com.example.kotlinday1

import android.content.Intent
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

// main activity inherits component activity class
class MainActivity : ComponentActivity() {
    private var enteredName = "";

    // on create is the entry point of the app
    override fun onCreate(savedInstanceState: Bundle?) {
        // worry about this later
        super.onCreate(savedInstanceState)
        // sets the activity's layout
        setContentView(R.layout.activity_main);

        val greetingTextView = findViewById<TextView>(R.id.tvHello);
        val inputField = findViewById<EditText>(R.id.editTextText);
        val submit = findViewById<Button>(R.id.button);

        val next = findViewById<Button>(R.id.button2);

        // on click listener to allow submit button to do stuff
        submit.setOnClickListener {
            enteredName = inputField.text.toString();

            if(enteredName == "") {
                next.visibility = INVISIBLE;
                greetingTextView.text = "Unknown name..."
                inputField.text.clear();
                Toast.makeText(this, "Hey, where's your name", Toast.LENGTH_SHORT).show();
            }

            else {
                val message = "Welcome, $enteredName";
                greetingTextView.text = message;
                inputField.text.clear();
                next.visibility = VISIBLE;
            }


        }

        next.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java);
            intent.putExtra("userName", enteredName);
            startActivity(intent);
        }

    }
}
