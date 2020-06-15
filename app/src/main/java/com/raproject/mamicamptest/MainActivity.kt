package com.raproject.mamicamptest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.raproject.mamicamptest.view.ui.listBook.ListBookActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = Handler()
        handler.postDelayed({
            startActivity(Intent(this@MainActivity, ListBookActivity::class.java))
            finish()
        }, 2000L)
    }
}