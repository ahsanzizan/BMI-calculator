package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var gender = "Laki - laki"
    private val calculateBtn = findViewById<Button>(R.id.calculateBtn)
    private val editTextheight = findViewById<EditText>(R.id.editTextHeight)
    private val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
    private val genders = findViewById<RadioGroup>(R.id.radioGroupGender)
    private val resultText = findViewById<TextView>(R.id.result)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateBtn.setOnClickListener { calculate() }
    }

    private fun calculate() {
        val height = editTextheight.text.toString().toDouble()
        val weight = editTextWeight.text.toString().toDouble()

        val selectedGender = genders.checkedRadioButtonId

        gender = when (selectedGender) {
            R.id.radioButtonMale -> "Laki-laki"
            R.id.radioButtonFemale -> "Perempuan"
            else -> "Laki-laki"
        }

        val bmi = when (gender) {
            "Laki-laki" -> weight / ((height / 100) * (height / 100))
            "Perempuan" -> weight / ((height / 100) * (height / 100)) * 0.9
            else -> 0.0
        }

        val result = "Hasil " + when {
            bmi < 18.5 -> "Kekurangan gizi"
            bmi >= 18.5 && bmi < 24.9 -> "Normal"
            bmi >= 25 && bmi < 29.9 -> "Kelebihan gizi"
            else -> "Obesitas"
        }

        resultText.text = result
    }
}