package com.example.hesapmakinesi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hesapmakinesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentInput = ""
    private var total = 0
    private var isLastOperator = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numberButtons = listOf(
            binding.btn0, binding.btn1, binding.btn2, binding.btn3, binding.btn4,
            binding.btn5, binding.btn6, binding.btn7, binding.btn8, binding.btn9
        )

        numberButtons.forEach { button ->
            button.setOnClickListener {
                val digit = button.text.toString()
                currentInput += digit
                binding.textResult.text = currentInput
                isLastOperator = false
            }
        }

        binding.btnAdd.setOnClickListener {
            if (currentInput.isNotEmpty() && !isLastOperator) {
                total += currentInput.toInt()
                binding.textResult.text = total.toString()
                currentInput = ""
                isLastOperator = true
            }
        }

        binding.btnEqual.setOnClickListener {
            if (currentInput.isNotEmpty()) {
                total += currentInput.toInt()
                binding.textResult.text = total.toString()
                currentInput = ""
                isLastOperator = true
            }
        }

        binding.btnC.setOnClickListener {
            total = 0
            currentInput = ""
            binding.textResult.text = "0"
            isLastOperator = false
        }
    }
}
