package com.azat_sabirov.andersen_homework_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnCountryFlags: Button
    private lateinit var btnPictureActivity: Button
    private lateinit var btnPictureAndroidActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        btnOnClickListeners()
    }

    private fun initViews() {
        btnCountryFlags = findViewById(R.id.btn_country_flags)
        btnPictureActivity = findViewById(R.id.btn_picture_activity)
        btnPictureAndroidActivity = findViewById(R.id.btn_picture_android_activity)
    }

    private fun btnOnClickListeners() {
        btnCountryFlags.setOnClickListener {
            val i = Intent(this, CountryFlagActivity::class.java)
            startActivity(i)
        }
        btnPictureActivity.setOnClickListener {
            val i = Intent(this, GlidePictureActivity::class.java)
            startActivity(i)
        }
        btnPictureAndroidActivity.setOnClickListener {
            val i = Intent(this, AndroidPictureActivity::class.java)
            startActivity(i)
        }
    }
}