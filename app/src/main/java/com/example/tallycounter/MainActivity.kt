package com.example.tallycounter


import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setCount()
        buttonHandler()

        btnDel.setOnClickListener {

            count = 0
            countValueDisplay!!.text = Integer.toString(count)
            val sharedPreferences = getSharedPreferences("count", Context.MODE_PRIVATE)
            val preferences: Editor = sharedPreferences.edit()
                preferences.clear().commit()
        }
    }
 private fun setCount() {
       val sharedPreferences = getSharedPreferences("count", Context.MODE_PRIVATE)
        count = sharedPreferences.getInt("count", 0)
        if (count == 0) {
            countValueDisplay.text = "0"
        } else {
            countValueDisplay.text = Integer.toString(count)
        }
    }
    fun buttonHandler() {
        val sharedPreferences = getSharedPreferences("count", Context.MODE_PRIVATE)
        countValueDisplay.setOnClickListener {
            if (count == 0) {

                count = sharedPreferences.getInt("count", 0)
                count++
                countValueDisplay.text = Integer.toString(count)

            } else {
                count++
                countValueDisplay.text = Integer.toString(count)
            }
            sharedPreferences.edit().putInt("count", count).apply()
        }
    }
}


































//
//
//        xuLy()
//        setCount()
//
//    }
//
//    private fun setCount() {
//        val sharedPreferences: SharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
//        val count = sharedPreferences.getInt("count", 0)
//        if (count == 0) {
//            countValueDisplay.text = "0"
//        } else {
//            countValueDisplay.text = Integer.toString(count)
//        }
//    }
//    private fun xuLy() {
//        val sharedPreferences: SharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
//        countValueDisplay.setOnClickListener {
//            if (count != 0) {
//
//                count = sharedPreferences.getInt("count", 0)
//                count += 1
//                countValueDisplay.text = Integer.toString(count)
//            } else {
//                count += 1
//                countValueDisplay.text = Integer.toString(count)
//            }
//            sharedPreferences.edit().putInt("count", count).apply()
//        }
//    }
//
//}
//



