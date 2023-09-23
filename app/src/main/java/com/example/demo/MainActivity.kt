package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.Animation
import android.widget.Toast
import com.example.demo.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    lateinit var bind:ActivityMainBinding
    var ch = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        if(supportActionBar != null){
            supportActionBar?.hide()
        }
        bind.war.visibility = View.GONE
        bind.fadeIn.setOnClickListener {
            bind.textView.visibility = View.VISIBLE
            val animationFadeIn = AnimationUtils.loadAnimation(this,R.anim.fadein)
            bind.textView.startAnimation(animationFadeIn)
            if(!ch){
                ch = true
                bind.war.visibility = View.GONE
                Toast.makeText(this,"FadeIn mode",Toast.LENGTH_SHORT).show()
            }
        }
        bind.fadeOut.setOnClickListener {
            val animationfadeout = AnimationUtils.loadAnimation(this,R.anim.fadeout)
            bind.textView.startAnimation(animationfadeout)
            Handler().postDelayed({
                bind.textView.visibility = View.GONE
            },1000)
            bind.war.visibility = View.VISIBLE
            ch = false
        }
        bind.zoomIn.setOnClickListener {
            val animationzoomin = AnimationUtils.loadAnimation(this,R.anim.zoomin)
            bind.textView.startAnimation(animationzoomin)
        }
        bind.zoomOut.setOnClickListener {
            val animationzoomout = AnimationUtils.loadAnimation(this,R.anim.zoomout)
            bind.textView.startAnimation(animationzoomout)
        }
        bind.slideUp.setOnClickListener {
            val animationslidein = AnimationUtils.loadAnimation(this,R.anim.slideup)
            bind.textView.startAnimation(animationslidein)
        }
        bind.slideDown.setOnClickListener {
            val animationslidedwon = AnimationUtils.loadAnimation(this,R.anim.slidedown)
            bind.textView.startAnimation(animationslidedwon)
        }
        bind.rotate.setOnClickListener {
            val aniroate = AnimationUtils.loadAnimation(this,R.anim.rotate)
            bind.textView.startAnimation(aniroate)
        }
        bind.bounce.setOnClickListener {
            val anibounce = AnimationUtils.loadAnimation(this,R.anim.bounce)
            bind.textView.startAnimation(anibounce)
        }
    }
}