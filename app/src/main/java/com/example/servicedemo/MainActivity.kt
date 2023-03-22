package com.example.servicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private var data: Int = 0
    private lateinit var input: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.calculate)
        input  = findViewById(R.id.input)

        button.setOnClickListener() {
            sendCommand()
        }
    }

    private fun sendCommand() {
//        val myIntent = Intent(this@MainActivity, MyService::class.java)
        data = input.text.toString().toInt()

//        val myIntent = MyService.getIntent(this, data)
        val myIntent = CalculatorService.getIntent(this, data)

//        myIntent.putExtra(MyService.SERVICE_DATA_EXTRA, data)
        startService(myIntent)
    }
}