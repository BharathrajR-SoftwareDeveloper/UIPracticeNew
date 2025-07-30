package com.example.uipractice.RYGEnum

enum class TrafficLight {
    RED, YELLOW, GREEN;

    fun next(): TrafficLight {
        return when (this) {
            RED -> YELLOW
            YELLOW -> GREEN
            GREEN -> RED
        }
    }
}