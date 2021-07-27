package com.example.acuclass

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.util.Pair as UtilPair

class SplashActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        //Agregar animaciones
        val animacionArriba = AnimationUtils.loadAnimation (this, R.anim.desplazamiento_arriba)
        val animacionAbajo = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo)

        val logo = findViewById<ImageView>(R.id.logoImageView)
        val de = findViewById<TextView>(R.id.fromTextView)
        val nombreApp = findViewById<TextView>(R.id.nameAppTextView)

        logo.startAnimation(animacionArriba)
        de.startAnimation(animacionAbajo)
        nombreApp.startAnimation(animacionAbajo)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(this,
                UtilPair.create(logo, "logoImageTrans"),
                UtilPair.create(nombreApp, "textTrans")
            )
            startActivity(intent, options.toBundle())
            finish()
        }, 4000)
    }
}