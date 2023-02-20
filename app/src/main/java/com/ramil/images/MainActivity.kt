package com.ramil.images

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.facebook.drawee.backends.pipeline.Fresco

class MainActivity : AppCompatActivity() {

    private lateinit var frameLayout : FrameLayout
    private var fragment : Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Fresco.initialize(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frameLayout = findViewById(R.id.frameLayout)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        button1.setOnClickListener {
            toGlide()
        }

        button2.setOnClickListener {
            toFresco()
        }

        button3.setOnClickListener {
            toExoPlayer()
        }
    }

    private fun toGlide(){
        fragment = ImageFragment()
        fragment?.let {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, it.apply {
                arguments = Bundle().apply {
                    putBoolean(ImageFragment.IMAGE_LOADER, false)
                }
            }).commit()
        }
    }

    private fun toFresco(){
        fragment = ImageFragment()
        fragment?.let {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, it.apply {
                arguments = Bundle().apply {
                    putBoolean(ImageFragment.IMAGE_LOADER, true)
                }
            }).commit()
        }
    }

    private fun toExoPlayer(){
        fragment = ExoPlayerFragment()
        fragment?.let {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, it).commit()
        }
    }

    override fun onBackPressed() {
        if (fragment != null){
            fragment?.let {
                supportFragmentManager.beginTransaction().remove(it).commit()
            }
            fragment = null
        } else {
            super.onBackPressed()
        }
    }

}