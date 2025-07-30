package com.example.uipractice.RYGEnum

enum class TrafficCommand {
    STOP,WAIT,MOVE;
    fun next(): TrafficCommand{
        return when(this){
            STOP -> WAIT
            WAIT -> MOVE
            MOVE -> STOP
        }
    }
}