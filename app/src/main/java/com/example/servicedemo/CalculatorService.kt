@file:Suppress("DEPRECATION")

package com.example.servicedemo

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.util.Log

class CalculatorService : IntentService("CalculatorService") {

    companion object {
        private const val CALC_SERVICE_DATA_EXTRA = "extra"

        fun getIntent(context: Context, num: Int): Intent {
            val intent2 = Intent(context, CalculatorService::class.java)
            intent2.putExtra(CALC_SERVICE_DATA_EXTRA, num)
            return intent2
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onHandleIntent(intent: Intent?) {      // his works in WorkerThread
        Log.d(
            "happySDK", "CalculatorService.onHandleIntent " +
                    "${Thread.currentThread().name} " +
                    "${Thread.currentThread().id}"
        )

        try {
            if (intent != null && intent.hasExtra(CALC_SERVICE_DATA_EXTRA)) {
                val num = intent.getIntExtra(CALC_SERVICE_DATA_EXTRA, 0)
                Log.d("happySDK", "square ${num * num}")
            }
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}