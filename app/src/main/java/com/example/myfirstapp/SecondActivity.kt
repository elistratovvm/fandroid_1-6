package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class SecondActivity : AppCompatActivity() {

    private lateinit var textViewRandom: TextView
    private lateinit var textViewLabel: TextView

    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textViewRandom = findViewById(R.id.textViewRandom)
        textViewLabel = findViewById(R.id.textViewLabel)

        showRandomNumber()
    }

    private fun showRandomNumber() {
            // Get count value from Intent extra
        val count = intent.getIntExtra(TOTAL_COUNT, 0)
            // Generate random number
        val random = Random()
        var randomInt = 0

        if (count > 0) {
            randomInt = random.nextInt(count + 1)
        }
            // Set textViewRandom value
        textViewRandom.text = randomInt.toString()
            // Put count value in textViewLabel
        textViewLabel.text = getString(R.string.random_heading, count)
    }
}