package com.example.mvp_architecture.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mvp_architecture.CounterContract
import com.example.mvp_architecture.CounterPresenter
import com.example.mvp_architecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterContract {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val presenter = CounterPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        presenter.attachContract(this)
        initViews()
    }

    private fun initViews() {
        binding.apply {
            btnPlus.setOnClickListener {
                presenter.onIncrement()
            }
            btnMinus.setOnClickListener {
                presenter.onDecrement()
            }
        }
    }

    override fun showResult(count: Int) {
        binding.tvCount.text = count.toString()
    }

    override fun changeColor(color: Int) {
        binding.tvCount.setTextColor(color)
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachContract()
    }

}