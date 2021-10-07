package com.lazarovstudio.traffic_light

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import com.lazarovstudio.traffic_light.databinding.ActivityTrafficLightBinding
import java.util.*

class TrafficLight : Activity() {
    private lateinit var binding: ActivityTrafficLightBinding

    //значала объявляем пустую переменную
    lateinit var bgTrafficLight: ImageView
    private lateinit var clickStartStop: ImageView
    var counter: Int = 0
    private lateinit var timer: Timer
    private var isRun: Boolean = false
    var imageArray: IntArray =
        intArrayOf(R.drawable.semafor_red,R.drawable.semafor_yellow,R.drawable.semafor_green)

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTrafficLightBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//добавляем в переменные
        bgTrafficLight = binding.bgTrafficLight
        clickStartStop = binding.btnClickTrafficLight
        bgTrafficLight.setImageResource(imageArray[counter])
    }

    fun onClickStartStop(view: View){
//        bgTrafficLight?.setImageResource(R.drawable.semafor_green)//если не пустое, запускаем функцию,выбираем картинку, меняем при нажатие
        view as ImageButton//view превращаем в ImageButton, для получение метода setImageResource
        if (!isRun){
            startStop()
            view.setImageResource(R.drawable.button_stop)
            isRun = true
        }else{
//            bgTrafficLight?.setImageResource(R.drawable.semafor_green)
            view.setImageResource(R.drawable.button_start)
            counter = 0
            bgTrafficLight.setImageResource(imageArray[0])
            timer.cancel()
            isRun = false
        }
    }
    private fun startStop(){
        timer = Timer()
        timer.schedule(object : TimerTask(){
            override fun run() {
                runOnUiThread {
                    bgTrafficLight.setImageResource(imageArray[counter])
                    counter++
                    if (counter == 3) counter = 0
                }
            }

        }, 0, 800)
    }
}