package com.example.uipractice.RYGEnum

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.uipractice.R
import com.example.uipractice.databinding.ActivityEnumBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Enum_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEnumBinding
    private var currentLight = TrafficLight.RED
    private var currentCommand= TrafficCommand.STOP
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityEnumBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView.text="People ${currentCommand.name}"
        lifecycleScope.launch {
            while (true){
                changeLights()
                delay(3000)
                currentLight=currentLight.next()
                changeCommand()
                binding.textView.text="People ${currentCommand.name}"
            }
        }
        binding.changeLightBtn.setOnClickListener {
            currentLight=currentLight.next()
            changeLights()
            changeCommand()
            binding.textView.text="People ${currentCommand.name}"
        }
    }

    private fun changeCommand(){
        if (currentLight== TrafficLight.RED){
            currentCommand = TrafficCommand.STOP
        }else if(currentLight== TrafficLight.YELLOW){
            currentCommand = TrafficCommand.WAIT
        }else{
            currentCommand = TrafficCommand.MOVE
        }
    }
    private fun changeLights() {
        binding.redLight.setBackgroundResource(if (currentLight== TrafficLight.RED)R.drawable.circle_red else R.drawable.circle_off)
        binding.yellowLight.setBackgroundResource(if(currentLight== TrafficLight.YELLOW)R.drawable.circle_yellow else R.drawable.circle_off)
        binding.greenLight.setBackgroundResource(if(currentLight== TrafficLight.GREEN)R.drawable.circle_green else R.drawable.circle_off)
    }
}