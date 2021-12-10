package com.azat_sabirov.andersen_homework_3

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.net.URL
import kotlin.concurrent.thread

class AndroidPictureActivity : AppCompatActivity() {
    private lateinit var ivPicture: ImageView
    private lateinit var etTakePicture: EditText
    private lateinit var btnTakePicture: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_picture)
        initViews()
        btnOnClickListener()
    }

    private fun initViews() {
        ivPicture = findViewById(R.id.iv_picture)
        etTakePicture = findViewById(R.id.et_take_picture)
        btnTakePicture = findViewById(R.id.btn_take_picture)
    }


    private fun btnOnClickListener() {
        btnTakePicture.setOnClickListener {
            thread(start = true) {
                val uiHandler = Handler(Looper.getMainLooper())
                val bitmap = downLoadBitmap(etTakePicture.text.toString())
                uiHandler.post {
                    ivPicture.setImageBitmap(bitmap)
                }
            }
        }
    }

    private fun downLoadBitmap(imageUrl: String): Bitmap? {
        return try {
            val connection = URL(imageUrl).openConnection()
            connection.connect()
            val inputStream = connection.getInputStream()
            val bitmap = BitmapFactory.decodeStream(inputStream)
            inputStream.close()
            return bitmap
        } catch (e: Exception) {
            runOnUiThread {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
            null
        }
    }
}