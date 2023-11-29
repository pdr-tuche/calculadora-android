package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetocalculadora.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    // Variable to store the current operand
    private var currentOperand: Double = 0.0
    // Variable to store the current operator
    private var currentOperator: String = ""

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set click listeners for number buttons
        binding.btn0.setOnClickListener { numberClick("0") }
        binding.btn0.setOnClickListener { numberClick("0") }
        binding.btn1.setOnClickListener { numberClick("1") }
        binding.btn2.setOnClickListener { numberClick("2") }
        binding.btn3.setOnClickListener { numberClick("3") }
        binding.btn4.setOnClickListener { numberClick("4") }
        binding.btn5.setOnClickListener { numberClick("5") }
        binding.btn6.setOnClickListener { numberClick("6") }
        binding.btn7.setOnClickListener { numberClick("7") }
        binding.btn8.setOnClickListener { numberClick("8") }
        binding.btn9.setOnClickListener { numberClick("9") }

        // Set click listeners for operator buttons
        binding.btnPlus.setOnClickListener { operatorClick("+") }
        binding.btnMinus.setOnClickListener { operatorClick("-") }
        binding.btnMultiply.setOnClickListener { operatorClick("*") }
        binding.btnDivide.setOnClickListener { operatorClick("/") }

        // Set click listener for equals button
        binding.btnEquals.setOnClickListener { calculateResult() }

        // Set click listener for clear button
        binding.btnClear.setOnClickListener { clearCalculator() }
    }

    // Function to handle number button clicks
    @SuppressLint("SetTextI18n")
    private fun numberClick(number: String) {
        val currentText = binding.txtResult.text.toString()
        binding.txtResult.text = currentText + number
    }

    // Function to handle operator button clicks
    private fun operatorClick(operator: String) {
        currentOperator = operator
        currentOperand = binding.txtResult.text.toString().toDouble()
        binding.txtResult.text = ""
    }

    // Function to calculate and display the result
    private fun calculateResult() {
        val operand2 = binding.txtResult.text.toString().toDouble()
        var result = 0.0

        when (currentOperator) {
            "+" -> result = currentOperand + operand2
            "-" -> result = currentOperand - operand2
            "*" -> result = currentOperand * operand2
            "/" -> result = currentOperand / operand2
        }

        binding.txtResult.text = result.toString()
    }

    // Function to clear the calculator
    private fun clearCalculator() {
        binding.txtResult.text = ""
        currentOperand = 0.0
        currentOperator = ""
    }
}