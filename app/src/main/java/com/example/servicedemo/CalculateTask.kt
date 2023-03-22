package com.example.servicedemo

import android.os.AsyncTask
import android.util.Log

class CalculateTask : AsyncTask<Void, Void, Int>() {
    private var n: Int = 0

    fun calculateTaskNum(n: Int) {
        this.n = n
    }

    override fun doInBackground(vararg params: Void?): Int {
        return n*n
    }

    override fun onPostExecute(result: Int?) {
        Log.d("happySDK TASK", result.toString())
    }
}