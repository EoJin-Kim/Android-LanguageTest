package com.ej.languagetest

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        val btnEn = findViewById<Button>(R.id.btn_en)
        val btnLt = findViewById<Button>(R.id.btn_lt)
        val textView = findViewById<TextView>(R.id.tv_hello)
        btnEn.setOnClickListener {
            (application as MyApp).updateLocale(Locale("en", "US"))
            val strEn = this.updateLocale(Locale("en", "US")).getString(R.string.hello)
            val str = getString(R.string.hello)
            textView.text = strEn
//            restartActivity()
        }

        btnLt.setOnClickListener {
            (application as MyApp).updateLocale(Locale("lt", "LT"))
            this.updateLocale(Locale("lt", "LT"))
            restartActivity()
        }
    }


    private fun restartActivity() {
        val intent = Intent(this, this::class.java)
        startActivity(intent)
        finish()
    }

    override fun attachBaseContext(newBase: Context) {
        val locale = Locale.getDefault()
        super.attachBaseContext(newBase.updateLocale(locale))
    }
}