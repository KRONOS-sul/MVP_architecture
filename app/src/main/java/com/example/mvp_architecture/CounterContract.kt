package com.example.mvp_architecture

interface CounterContract {
    fun showResult(count: Int)
    fun changeColor(color: Int)
    fun showToast(message: String)
}