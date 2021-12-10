package com.azat_sabirov.andersen_homework_3

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class GlidePictureActivity : AppCompatActivity() {
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
            Glide
                .with(this)
                .load(etTakePicture.text.toString())
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        Toast.makeText(this@GlidePictureActivity, e?.message, Toast.LENGTH_LONG)
                             .show()
                         return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }
                })
                .into(ivPicture)
        }
    }
}