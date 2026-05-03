package com.example.lifehackmyth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/* * Student Name: Ethar Aboyounes
 * Student Number: ST10539495
 * Reference: IEEE - Android Developers Documentation, 2024.
 */

class MainActivity : AppCompatActivity() {

    private val TAG = "LifeHackApp_Main"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart)

        // Using intent to navigate from Welcome Screen to Quiz Screen
        btnStart.setOnClickListener {
            Log.i(TAG, "Navigating from Welcome Screen to QuizActivity")
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
    }
}