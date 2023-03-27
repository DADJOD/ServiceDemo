package com.example.servicedemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var receiver: MyReceiver
    private lateinit var filter: IntentFilter
    private var data: Int = 0
    lateinit var input: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.calculate)
        input  = findViewById(R.id.input)

        button.setOnClickListener() {
            sendCommand()
        }

        filter = IntentFilter()
        filter.addAction(CalculatorService.MY_COOL_SQUARE_ACTION)

        receiver = MyReceiver()
        registerReceiver(receiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(receiver)
    }

    private fun sendCommand() {
//        val myIntent = Intent(this@MainActivity, MyService::class.java)
        data = input.text.toString().toInt()

//        val myIntent = MyService.getIntent(this, data)
        val myIntent = CalculatorService.getIntent(this, data)

//        myIntent.putExtra(MyService.SERVICE_DATA_EXTRA, data)
        startService(myIntent)
    }

    open class MyReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            Log.d("happySDK", "Receiver ")
            val square = intent.getIntExtra(CalculatorService.CALC_SERVICE_DATA_EXTRA, 1).toString()

//            val inputMain = MainActivity()
//            inputMain.input.setText(square)       // doesn't work
            Log.d("happySDK", "squareReceiver $square")
        }
    }
}