package com.fiz.lock

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import android.graphics.Color
import android.view.Gravity

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        window.decorView.systemUiVisibility = (
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
            View.SYSTEM_UI_FLAG_FULLSCREEN or
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        )

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setBackgroundColor(Color.BLACK)

        val title = TextView(this)
        title.text = "SYSTEM LOCKED"
        title.setTextColor(Color.RED)
        title.textSize = 32f
        layout.addView(title)

        val etPin = EditText(this)
        etPin.hint = "Masukkan PIN"
        etPin.setTextColor(Color.WHITE)
        layout.addView(etPin)

        val btn = Button(this)
        btn.text = "BUKA KUNCI"
        btn.setOnClickListener {
            if (etPin.text.toString() == "666") {
                finishAffinity()
            } else {
                Toast.makeText(this, "PIN SALAH!", Toast.LENGTH_SHORT).show()
            }
        }
        layout.addView(btn)

        setContentView(layout)
    }

    override fun onBackPressed() {}
}
