package com.project.bmi2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity1 : AppCompatActivity() {
    private var weight = 0.0
    private var height = 0.15

    //TextViews definitions
    private var heightTextView: TextView? = null
    private var weightTextView: TextView? = null
    private var totalTextView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)
        weightTextView = findViewById<View>(R.id.weightTextView) as TextView
        heightTextView = findViewById<View>(R.id.heightTextView) as TextView
        totalTextView = findViewById<View>(R.id.totalTextView) as TextView
        totalTextView!!.text = String.format(0.toString() + "")
        val weightEditText = findViewById<View>(R.id.weightEditText) as EditText
        weightEditText.addTextChangedListener(weightEditTextWatcher)
        val heightEditText = findViewById<View>(R.id.heightEditText) as EditText
        heightEditText.addTextChangedListener(heightEditTextWatcher)
    }

    private fun calculate() {
        val total = weight / (height * height)
        totalTextView!!.text = String.format(total.toString() + "")
    }

    private val weightEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            try {
                weight = s.toString().toDouble() / 100.0
                weightTextView!!.text = String.format(weight.toString() + "")
            } catch (e: NumberFormatException) {
                weightTextView!!.text = ""
                weight = 0.0
            }
            calculate()
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
        }
    }
    private val heightEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun onTextChanged(s: CharSequence, start: Int,
                                   before: Int, count: Int) {
            try {
                height = s.toString().toDouble() / 100.0
                heightTextView!!.text = String.format(height.toString() + "")
            } catch (e: NumberFormatException) {
                heightTextView!!.text = ""
                height = 0.0
            }
            calculate()
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int, after: Int) {
        }
    }
}