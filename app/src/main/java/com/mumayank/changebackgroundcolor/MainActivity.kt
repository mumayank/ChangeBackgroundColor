package com.mumayank.changebackgroundcolor

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import java.security.SecureRandom

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colorChangeViewModel = ViewModelProviders.of(this)[ColorChangeViewModel::class.java]
        colorChangeViewModel.colorResource.observe(this, Observer<Int> {
            parentLayout.setBackgroundColor(it)
        })

        button.setOnClickListener {
            colorChangeViewModel.colorResource.value = generateRandomColor()
        }
    }

    private fun generateRandomColor(): Int {
        val random = SecureRandom()
        return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
    }
}
