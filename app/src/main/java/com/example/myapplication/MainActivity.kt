package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.AdapterView
import android.widget.ArrayAdapter


class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var course: Double = 74.0
        var icon:String = "$"

        convert.setOnClickListener {
            var money = textInputEditText.text.toString().toDouble()
            dollars.setText("${money/course} ${icon}")
        }


        refresh.setOnClickListener{

            if (icon == "$" && course == 74.0){
                textInputEditText.setHint("Введите количество долларов")
                icon = "рублей"
            }else{
                textInputEditText.setHint("Введите количество рублей")
                icon = "$"
            }

            course = 1/course
            textInputEditText.setText("")
        }



        //Выпадающий список валют
        var values = arrayOf("dollar")

        currency.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values)

        currency.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                when(id){
                    0L -> {
                        course = 74.0
                        icon = "$"
                    }


                }
            }
        }

         //Реализация подсказки в поле ввода
    }

}






