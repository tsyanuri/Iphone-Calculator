package com.tsyanuri.android.iphonecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClickNumber(view: View) {
        if (isNewOp){
            showNumbers.setText("")
        }
            isNewOp=false

        val buSelect = view as Button
        var buClickedValue: String = showNumbers.text.toString()

        when (buSelect.id) {
            butZero.id -> {
                buClickedValue += "0"
            }
            butOne.id -> {
                buClickedValue += "1"
            }
            butTwo.id -> {
                buClickedValue += "2"
            }
            butThree.id -> {
                buClickedValue += "3"
            }
            butFour.id -> {
                buClickedValue += "4"
            }
            butFive.id -> {
                buClickedValue += "5"
            }
            butSix.id -> {
                buClickedValue += "6"
            }
            butSeven.id -> {
                buClickedValue += "7"
            }
            butEight.id -> {
                buClickedValue += "8"
            }
            butNine.id -> {
                buClickedValue += "9"
            }
            butDot.id -> {
                //TODO : preventing add more than 1 dot
                buClickedValue = "."
            }
            butPlusminus.id -> {
                buClickedValue = "-" + buClickedValue
            }
        }
        showNumbers.setText(buClickedValue)
    }

    var op = "*"
    var oldNumber = ""
    var isNewOp = true
    fun buttonClickOp(view: View) {

        val buSelect = view as Button
        when (buSelect.id) {
            butMulti.id -> {
                op="*"
            }
            butDiv.id -> {
                op="/"
            }
            butSub.id -> {
                op="-"
            }
            butSum.id -> {
                op="+"
            }
        }
        oldNumber= showNumbers.text.toString()
        isNewOp = true
    }

    fun buttonClickEqual(view: View){
        val newNumber = showNumbers.text.toString()
        var finalNumber : Double? = null
        when(op){
            "*" ->{
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" ->{
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "-" ->{
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+" ->{
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        showNumbers.setText(finalNumber.toString())
        isNewOp=true
    }

    fun buttonClickPersen(view: View){
        val number : Double = showNumbers.text.toString().toDouble()/100

        showNumbers.setText(number.toString())
    }
    fun buttonClickClean(view: View){
        showNumbers.setText("0")
        isNewOp = true
    }
}