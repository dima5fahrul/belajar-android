package com.example.belajar_android

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var sayHelloButton: Button
    private lateinit var sayHelloTextView: TextView

    private fun initComponents() {
        nameEditText = findViewById(R.id.nameEditText)
        sayHelloButton = findViewById(R.id.sayHelloButton)
        sayHelloTextView = findViewById(R.id.sayHelloText)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_world)

        initComponents()

        sayHelloTextView.text = "Hello World!"
        sayHelloTextView.text = "${nameEditText.text}!"

        sayHelloButton.setOnClickListener {
            val name = nameEditText.text.toString()
            sayHelloTextView.text = "Hello $name!"
        }
    }
}