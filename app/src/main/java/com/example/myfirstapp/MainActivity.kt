package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var textEditView: TextView
    private lateinit var myObserver: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)

        myObserver = MyObserver()
        lifecycle.addObserver(myObserver)

        textEditView = findViewById(R.id.textEditView)
    }

    override fun onStart() {
        super.onStart()
        toastMeState("ON_START")
    }

    override fun onResume() {
        super.onResume()
        toastMeState("ON_RESUME")
    }

    override fun onPostResume() {
        super.onPostResume()
        toastMeState("onPostResume")
    }

    override fun onPause() {
        super.onPause()
        toastMeState("ON_PAUSE")
    }

    override fun onStop() {
        super.onStop()
        toastMeState("ON_STOP")
    }

    override fun onRestart() {
        super.onRestart()
        toastMeState("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        toastMeState("ON_DESTROY")
    }

    fun toastMe(view: View) {
            // Show toast
        Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT).show()
    }

    private fun toastMeState(message: String) {
            // Show toast demonstrating current activity state
        Toast.makeText(this, "${lifecycle.currentState}, $message", Toast.LENGTH_LONG).show()
    }

    fun randomMe(view: View) {
            // Create Intent for start secondActivity
        val randomIntent = Intent(this, SecondActivity::class.java)
            // Get text of textView element from activity
        val countString = textView.text.toString()
            // Convert to int
        val count = Integer.parseInt(countString)
            // Append count to extra for randomIntent
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)
            // Start secondActivity
        startActivity(randomIntent)
    }

    fun countMe (view: View) {
            // Get text of textView element from activity
        val countString = textView.text.toString()
            // Convert to int and add 1
        var count: Int = Integer.parseInt(countString)
        count++
            // Set textView value
        textView.text = count.toString()
    }
}