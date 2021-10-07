package com.lazarovstudio.traffic_light

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lazarovstudio.traffic_light.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var play: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnTrafficLight.setOnClickListener {
            startActivity(Intent(this, TrafficLight::class.java))
        }

        binding.btnSound.setOnClickListener {
            play = MediaPlayer.create(this, R.raw.kryakva1)
            play.start()
        }
    }

    override fun onStop() {
        super.onStop()
        play.stop()
    }
}