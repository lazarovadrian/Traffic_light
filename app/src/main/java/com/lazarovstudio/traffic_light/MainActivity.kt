package com.lazarovstudio.traffic_light

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.*

class MainActivity : Activity() {
    //значала объявляем пустую переменную
    var bgTrafficLight: ImageView? = null
    var clickStartStop: ImageView? = null

    var counter: Int = 0
    var timer: Timer? = null
    var is_run: Boolean = false
    var imageArray: IntArray = intArrayOf(R.drawable.semafor_red,R.drawable.semafor_yellow,R.drawable.semafor_green)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//добавляем в переменные
        bgTrafficLight = findViewById(R.id.bg_traffic_light)
        clickStartStop = findViewById(R.id.btn_click_traffic_light)
    }

    fun onClickStartStop(view: View) {
//        bgTrafficLight?.setImageResource(R.drawable.semafor_green)//если не пустое, запускаем функцию,выбираем картинку, меняем при нажатие
        view as ImageButton//view превращаем в ImageButton, для получение метода setImageResource
        if (!is_run){
            startStop()
            view.setImageResource(R.drawable.button_stop)
            is_run = true
        }else{
//            bgTrafficLight?.setImageResource(R.drawable.semafor_green)
            view.setImageResource(R.drawable.button_start)
            counter = 0
            timer?.cancel()
            is_run = false
        }
    }
    fun startStop(){
        timer = Timer()
        timer?.schedule(object : TimerTask(){
            override fun run() {
                bgTrafficLight?.setImageResource(imageArray[counter])
                counter++
                if (counter == 3) counter = 0
            }

        }, 0, 1000)
    }
}