package com.example.calculatordastanbakaev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num_0.setOnClickListener{setText("0")}
        num_1.setOnClickListener{setText("1")}
        num_2.setOnClickListener{setText("2")}
        num_3.setOnClickListener{setText("3")}
        num_4.setOnClickListener{setText("4")}
        num_5.setOnClickListener{setText("5")}
        num_6.setOnClickListener{setText("6")}
        num_7.setOnClickListener{setText("7")}
        num_8.setOnClickListener{setText("8")}
        num_9.setOnClickListener{setText("9")}
        minus.setOnClickListener{setText("-")}
        plus.setOnClickListener{setText("+")}
        multiplication.setOnClickListener{setText("*")}
        slash.setOnClickListener{setText("/")}
        left_bracket.setOnClickListener{setText("(")}
        right_bracket.setOnClickListener{setText(")")}
        dot.setOnClickListener{setText(".")}
        backspace.setOnClickListener{
            math_result.text=""
            math_operation.text=""
        }

        back.setOnClickListener{
            val str = math_operation.text.toString()
            if (str.isNotEmpty()){
                math_operation.text = str.substring(0, str.length-1)
                math_result.text=""
            }
        }
        equal.setOnClickListener{
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val res = ex.evaluate()
                val longRes = res.toLong()
                if (res==longRes.toDouble()){
                    math_result.text = longRes.toString()
                }else
                    math_result.text = res.toString()

            } catch (e:Exception){
                Log.d("Ошибка!", "Сообщение: ${e.message}")
            }
        }
    }
    fun setText(str: String) {
        math_operation.append(str)

    }
}