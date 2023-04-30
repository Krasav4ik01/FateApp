package com.example.fateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var startButton: Button
    private lateinit var textView: TextView
    private var list = arrayOf("Да⭐️", "Нет🥲", "Возможно✊", "100%🔥", "Маловероятно🧿", "Определенно🚀", "50-50📊", "Не понял вопрос😑", "Повтори еще😣", "Несомненно🙌", "Ну как то💸")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.start_btn)
        textView = findViewById(R.id.textView)

        startButton.setOnClickListener {
            textView.setText("Думаю...")
            GlobalScope.launch {
                delay(3000)
                generateResponse(list)
            }
        }

    }

    fun generateResponse(strings: Array<String>): String {
        val randomIndex = (0 until strings.size).random()
        textView.setText(strings[randomIndex])
        return strings[randomIndex]
    }
}