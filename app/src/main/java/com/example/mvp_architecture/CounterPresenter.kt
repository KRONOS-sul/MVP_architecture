package com.example.mvp_architecture

import android.graphics.Color

class CounterPresenter {

    private val model = CounterEntity()
    private var contract: CounterContract? = null

    fun attachContract(contract: CounterContract) {
        this.contract = contract
        contract.showResult(model.count)
    }

    fun onIncrement() {
        model.increment()
        contract?.showResult(model.count)
        updateView()
    }

    fun onDecrement() {
        model.decrement()
        contract?.showResult(model.count)
        updateView()
    }

    private fun updateView() {
        when (model.count) {
            15 -> contract?.showToast("Поздравляем")
            10 -> contract?.changeColor(Color.GREEN)
            else -> contract?.changeColor(Color.BLACK)
        }
    }

    fun detachContract() {
        contract = null
    }
}
