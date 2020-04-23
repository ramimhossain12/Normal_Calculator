package com.example.normal_calculator


import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable

class MainActivity : AppCompatActivity() {


      lateinit var bt0: Button
     lateinit var bt1: Button
     lateinit var bt2: Button
     lateinit var btn3: Button
   lateinit var btn4: Button
      lateinit var btn5: Button
      lateinit var btn6: Button
      lateinit var btn7: Button
    lateinit var btn8: Button
      lateinit var btn9: Button

    lateinit var btnPercent: Button
    lateinit var btnPlus: Button
      lateinit var btnMinus: Button
      lateinit var btnMultiply: Button
    lateinit var btnDivision: Button

     lateinit var btnEqual: Button
      lateinit var btnClear: Button
      lateinit var btnDot: Button
      lateinit var btnBracket: Button
     lateinit var btR: Button


      lateinit var Input1: TextView
      lateinit var Output1: TextView

      lateinit var item: String

      var checkBracket = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt0 = findViewById(R.id.btn0)
        bt1 = findViewById(R.id.btn1)
        bt2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btR = findViewById(R.id.btR)

        btnPlus = findViewById(R.id.btnPlus)
        btnMinus = findViewById(R.id.btnMinus)
        btnDivision = findViewById(R.id.btnDivision)
        btnMultiply = findViewById(R.id.btnMultiply)

        btnEqual = findViewById(R.id.btnEqual)

        btnClear = findViewById(R.id.btnClear)
        btnDot = findViewById(R.id.btnDot)
        btnPercent = findViewById(R.id.btnPercent)
        btnBracket = findViewById(R.id.btnBracket)

        Input1 = findViewById(R.id.tvInput)
        Output1 = findViewById(R.id.tvOutput)




        btnClear.setOnClickListener {
            Input1.text = ""
            Output1.text = ""
        }


        bt0.setOnClickListener {
            item = Input1.text.toString()
            Input1.text = item + "0"
        }

        btR.setOnClickListener {
            var s = Input1.text.toString()
            s = s.substring(0, s.length - 1)
            Input1.text = s
        }


        bt1.setOnClickListener {
            item = Input1.text.toString()
            Input1.text = item + "1"
        }

        bt2.setOnClickListener {
            item = Input1.text.toString()
            Input1.text = item + "2"
        }

        btn3.setOnClickListener {
            item = Input1.text.toString()
            Input1.text = item + "3"
        }

        btn4.setOnClickListener {
            item = Input1.text.toString()
            Input1.text = item + "4"
        }

        btn5.setOnClickListener {
            item = Input1.text.toString()
            Input1.text = item + "5"
        }

        btn6.setOnClickListener {
            item = Input1.text.toString()
            Input1.text = item + "6"
        }

        btn6.setOnClickListener {
            item = Input1.text.toString()
            Input1.text = item + "6"
        }

        btn7.setOnClickListener {
            item = Input1.text.toString()
            Input1.text = item + "7"
        }

        btn8.setOnClickListener {
            item = Input1.text.toString()
            Input1.text = item + "8"
        }

        btn9.setOnClickListener {
            item = Input1.text.toString()
            Input1.text = item + "9"
        }



        btnPlus.setOnClickListener {
            item = Input1.text.toString()
            Input1.text = "$item+"
        }


        btnMinus.setOnClickListener {
            item = Input1.text.toString()
            Input1.text = "$item-"
        }

        btnMultiply.setOnClickListener {
            item = Input1.text.toString()
            Input1.text = "$item×"
        }

        btnDivision.setOnClickListener {
            item = Input1.text.toString()
            Input1.text = "$item÷"
        }

        btnDot.setOnClickListener {
            item = Input1.text.toString()
            Input1.text = "$item."
        }

        btnPercent.setOnClickListener {
            item = Input1.text.toString()
            Input1.text = "$item%"
        }

        btnBracket.setOnClickListener {
            if (checkBracket) {
                item = Input1.text.toString()
                Input1.text = "$item)"
                checkBracket = false
            } else {
                item = Input1.text.toString()
                Input1.text = "$item("
                checkBracket = true
            }
        }




        btnEqual.setOnClickListener {
            item = Input1.text.toString()

            item = item.replace("×".toRegex(), "*")
            item = item.replace("%".toRegex(), "/100")
            item = item.replace("÷".toRegex(), "/")

            val rhino = Context.enter()

            rhino.optimizationLevel = -1

            var finalResult = ""

            try {
                val scriptable = rhino.initStandardObjects()
                finalResult = rhino.evaluateString(scriptable, item, " Calculator", 1, null).toString()
            } catch (e: Exception) {
                finalResult = "00"
            }

            Output1.text = finalResult
        }


    }

    override fun onBackPressed() {

        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are You Sure You Want TO Exit ?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, which -> super@MainActivity.onBackPressed() }

                .setNegativeButton("No") { dialog, which -> dialog.cancel() }
        val alertDialog = builder.create()

        alertDialog.show()


    }


}
