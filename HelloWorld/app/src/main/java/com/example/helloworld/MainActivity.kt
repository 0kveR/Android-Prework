package com.example.helloworld

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n") // No clue what this does specifically, the IDE added it
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Variables used to see if the text color or theme has been changed.
        var colorChanged = false
        var themeChanged = false

        findViewById<Button>(R.id.textColorBtn).setOnClickListener {
            Log.i("Text", "Button 1")

            // Checks if the theme has been changed
            if (!themeChanged) {
                // Checks if the color has already been changed
                if (!colorChanged) {
                    colorChanged = true
                    findViewById<TextView>(R.id.text).setTextColor(resources.getColor(R.color.teal_200))
                } else {
                    colorChanged = false
                    findViewById<TextView>(R.id.text).setTextColor(resources.getColor(R.color.black))
                }
            } else { // If the theme was already changed, different colors will be used
                if (!colorChanged) {
                    colorChanged = true
                    findViewById<TextView>(R.id.text).setTextColor(resources.getColor(R.color.teal_700))
                } else {
                    colorChanged = false
                    findViewById<TextView>(R.id.text).setTextColor(resources.getColor(R.color.white))
                }
            }
        }

        // Converts text in the EditText to a string and changes the TextView
        findViewById<Button>(R.id.changeTextBtn).setOnClickListener {
            val changedText: String= findViewById<EditText>(R.id.editText).text.toString()
            if (changedText.isNotBlank()) {
                findViewById<TextView>(R.id.text).text = changedText
            } else {
                findViewById<TextView>(R.id.text).text = "Hello From Krrish!"
            }
        }

        findViewById<Button>(R.id.themeBtn).setOnClickListener {
            Log.i("Theme", "Button Clicked")

            // Checks if the theme was already changed
            if (!themeChanged) {
                themeChanged = true
                findViewById<ConstraintLayout>(R.id.layout).setBackgroundColor(resources.getColor(R.color.darkBackground))
                findViewById<TextView>(R.id.text).setTextColor(resources.getColor(R.color.white))
                findViewById<EditText>(R.id.editText).setTextColor(resources.getColor(R.color.white))
                colorChanged = false
            } else { // If already changed, reverts to default theme
                themeChanged = false
                findViewById<ConstraintLayout>(R.id.layout).setBackgroundColor(resources.getColor(R.color.lightBackground))
                findViewById<TextView>(R.id.text).setTextColor(resources.getColor(R.color.black))
                findViewById<EditText>(R.id.editText).setTextColor(resources.getColor(R.color.black))
                colorChanged = false
            }
        }

        // Resets all values to default
        findViewById<ConstraintLayout>(R.id.layout).setOnClickListener {
            themeChanged = false
            findViewById<ConstraintLayout>(R.id.layout).setBackgroundColor(resources.getColor(R.color.lightBackground))
            findViewById<TextView>(R.id.text).setTextColor(resources.getColor(R.color.black))
            findViewById<EditText>(R.id.editText).setTextColor(resources.getColor(R.color.black))
            colorChanged = false
            findViewById<TextView>(R.id.text).text = "Hello From Krrish!"
        }
    }
}