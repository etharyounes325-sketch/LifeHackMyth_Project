package com.example.lifehackmyth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    private val TAG = "LifeHackApp_Score"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("SCORE", 0)
        val total = intent.getIntExtra("TOTAL", 4)

        val tvScoreNumber = findViewById<TextView>(R.id.tvScoreNumber)
        val tvFeedback = findViewById<TextView>(R.id.tvPersonalizedFeedback)
        val btnReview = findViewById<Button>(R.id.btnReview)

        tvScoreNumber.text = "$score / $total"

        // Personalized feedback logic based on final score
        if (score >= 3) {
            tvFeedback.text = "Master Hacker! High efficiency achieved."
        } else {
            tvFeedback.text = "Keep Practicing and Stay Safe Online!"
        }

        btnReview.setOnClickListener {
            Log.i(TAG, "Restarting application stack.")
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}