package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var questions: ArrayList<Question>
    private var position = 0
    private lateinit var btYes: Button
    private lateinit var btNo: Button
    private lateinit var btNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btYes = findViewById<Button>(R.id.btYes)
        btNo = findViewById<Button>(R.id.btNo)
        btNext = findViewById<Button>(R.id.btNext)
        loadQuestion()
        setupViews()
    }

    private fun loadQuestion(){
        questions = ArrayList()
        var question = Question("¿Es Lima la capital de Chile?", false)
        var question2 = Question("¿Es Lima la capital de Peru?", true)
        questions.add(question)
        questions.add(question2)
    }
    private fun setupViews(){

        showSentence()

        btYes.setOnClickListener{
            if (questions[position].answer){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
            }
        }

        btNo.setOnClickListener{
            if (!questions[position].answer){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show()
            }
        }

        btNext.setOnClickListener {
            position++
            showSentence()
        }

    }

    private fun showSentence(){
        val tvSentence = findViewById<TextView>(R.id.tvSentence)
        tvSentence.text = questions[position].sentence
    }
}