package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var right_course = 0.0 //все курсы относительно рубля
        var left_course = 0.0 //не знаю как реализовать lateinit в данной ситуации
        var icon_right: String = "$"
        val toast = Toast.makeText(getApplicationContext(),
            "Введите желаемое количество валюты", Toast.LENGTH_SHORT)

        convert.setOnClickListener {

            if (textInputEditText.length() == 0){
                toast.show()
            }else{
                var course = left_course / right_course
                var money = textInputEditText.text.toString().toDouble()
                dollars.setText("${Math.round(money * course * 100.0) / 100.0} ${icon_right}")

            }

        }


        //Выпадающий список валют справа
        var values = arrayOf("рубль", "доллар", "евро", "иена")

        currency.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values)

        currency.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                when (id) {
                    0L -> {
                        right_course = 1.0
                        icon_right = "рублей"
                    }
                    1L -> {
                        right_course = 74.0
                        icon_right = "$"
                    }

                    2L -> {
                        right_course = 80.53
                        icon_right = "евро"
                    }
                    3L -> {
                        right_course = 0.64
                        icon_right = "иен"
                    }

                }
            }
        }


        //Выпадающий список слева
        currency2.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values)


        currency2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (id) {
                    0L -> {
                        left_course = 1.0
                        textInputEditText.setHint("Введите количество рублей")
                    }
                    1L -> {
                        left_course = 74.0
                        textInputEditText.setHint("Введите количество долларов")
                    }
                    2L -> {
                        left_course = 80.53
                        textInputEditText.setHint("Введите количество евро")
                    }
                    3L -> {
                        left_course = 0.64
                        textInputEditText.setHint("Введите количество иен")

                    }


                }
            }

        }
    }
}






