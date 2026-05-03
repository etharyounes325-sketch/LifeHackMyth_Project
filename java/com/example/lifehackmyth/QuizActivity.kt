package com.example.lifehackmyth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/* * Student Name: Ethar Aboyounes
 * Student Number: ST10539495
 * This activity manages the quiz logic, score tracking, and logging.
 */
class QuizActivity : AppCompatActivity() {

    private val TAG = "LifeHack_QuizActivity"

    private lateinit var tvQuestion: TextView
    private lateinit var tvFeedback: TextView
    private lateinit var btnHack: Button
    private lateinit var btnMyth: Button
    private lateinit var btnNext: Button

    private var currentQuestionIndex = 0
    private var score = 0

    // Updated list to match your Hack data class properties
    private val questions = listOf(
        Hack("Putting a phone in rice fixes water damage.", false, "Myth! Air circulation is more effective than rice."),
        Hack("Batteries last longer if kept in the fridge.", false, "Myth! Humidity can damage components."),
        Hack("Using a straw prevents teeth staining.", true, "Hack! It minimizes contact with enamel."),
        Hack("WD-40 can remove sticker residue easily.", true, "Hack! It is a very effective solvent.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        tvQuestion = findViewById(R.id.tvQuestion)
        tvFeedback = findViewById(R.id.tvFeedback)
        btnHack = findViewById(R.id.btnHack)
        btnMyth = findViewById(R.id.btnMyth)
        btnNext = findViewById(R.id.btnNext)

        displayQuestion()

        btnHack.setOnClickListener { checkAnswer(true) }
        btnMyth.setOnClickListener { checkAnswer(false) }

        btnNext.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                displayQuestion()
            } else {
                Log.d(TAG, "Quiz Finalized. Final Score: $score")
                finishQuiz()
            }
        }
    }

    private fun displayQuestion() {
        tvQuestion.text = questions[currentQuestionIndex].statement
        tvFeedback.text = ""
        btnNext.visibility = View.INVISIBLE
        Log.i(TAG, "Displaying question index: $currentQuestionIndex")
    }

    private fun checkAnswer(userChoice: Boolean) {
        // Changed .isTrue to .isReal to match your data class in Hack.kt
        val correctAnswer = questions[currentQuestionIndex].isReal

        if (userChoice == correctAnswer) {
            score++
            tvFeedback.text = "Correct! ${questions[currentQuestionIndex].explanation}"
        } else {
            tvFeedback.text = "Incorrect. ${questions[currentQuestionIndex].explanation}"
        }

        btnNext.visibility = View.VISIBLE
    }

    private fun finishQuiz() {
        // Navigation logic required by the rubric
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra("SCORE", score)
        intent.putExtra("TOTAL", questions.size)
        startActivity(intent)
        finish()
    }
}