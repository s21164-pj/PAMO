package com.project.bmi2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var button1: Button? = null
    private var button2: Button? = null
    private var button3: Button? = null
    private var button4: Button? = null
    private var button5: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById<View>(R.id.button1) as Button
        button2 = findViewById<View>(R.id.button2) as Button
        button3 = findViewById<View>(R.id.button3) as Button
        button4 = findViewById<View>(R.id.button4) as Button
        button5 = findViewById<View>(R.id.button5) as Button
        button1!!.setOnClickListener { openActivity1() }
        button2!!.setOnClickListener { openActivity2() }
        button3!!.setOnClickListener { openActivity3() }
        button4!!.setOnClickListener { openActivity4() }
        button5!!.setOnClickListener { openActivity5() }
    }

    fun openActivity1() {
        val intent = Intent(this, Activity1::class.java)
        startActivity(intent)
    }

    fun openActivity2() {
        val intent = Intent(this, Activity2::class.java)
        startActivity(intent)
    }

    fun openActivity3() {
        val intent = Intent(this, Activity3::class.java)
        startActivity(intent)
    }

    fun openActivity4() {
        val intent = Intent(this, Activity4::class.java)
        startActivity(intent)
    }

    fun openActivity5() {
        val intent = Intent(this, Activity5::class.java)
        startActivity(intent)
    }
}