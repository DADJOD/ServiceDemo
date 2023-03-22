package com.example.servicedemo

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service(){

//    fun getIntent(context: Context, num: Int): Intent {
//        val intent2 = Intent(context, MyService::class.java)
//        intent2.putExtra(SERVICE_DATA_EXTRA, num)
//        return intent2
//    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null && intent.hasExtra(SERVICE_DATA_EXTRA)) {
            var num = intent.getIntExtra(SERVICE_DATA_EXTRA, 0)
            // gonna square it
            num *= num

            Log.d("happySDK", num.toString())
        }

        return START_NOT_STICKY
    }

    companion object {
        const val SERVICE_DATA_EXTRA = "extra"

        fun getIntent(context: Context, num: Int): Intent {
            val intent2 = Intent(context, MyService::class.java)
            intent2.putExtra(SERVICE_DATA_EXTRA, num)
            return intent2
        }
    }
}