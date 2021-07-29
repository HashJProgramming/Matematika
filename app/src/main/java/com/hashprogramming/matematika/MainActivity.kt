package com.hashprogramming.matematika

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import android.app.AlertDialog
import android.widget.SeekBar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Variables Hash - Programming
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val score = findViewById<TextView>(R.id.scoretxt)
        val txt1 = findViewById<TextView>(R.id.txt1)
        val txt2 = findViewById<TextView>(R.id.txt2)
        val txt3 = findViewById<TextView>(R.id.txt3)
        val tanker = findViewById<TextView>(R.id.txtanswer)
        val difficulty = findViewById<SeekBar>(R.id.seekBar)
        val tat =findViewById<TextView>(R.id.dtxt)
        var first : Int
        var second : Int
        var third : Int
        var gen : Int = 0


        difficulty.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tat.text = "1 to ${difficulty.progress}"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })



        //Button 1 "?"
        btn1.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setMessage("Joshua M. Ambalong")
            val alert = dialogBuilder.create()
            alert.setTitle("Developer")
            alert.show()
        }

        //Button 2 "Generate"
        btn2.setOnClickListener {
            if (difficulty.progress <= 19){
                Toast.makeText(applicationContext, "Difficulty can't be below 20!" , Toast.LENGTH_SHORT).show()
            }else{
                gen++
                if (gen >= 6){
                    val dialogBuilder = AlertDialog.Builder(this)
                    dialogBuilder.setMessage("Sigeg pangitag sayon diha answera nana!")
                    val alert = dialogBuilder.create()
                    alert.setTitle("HALAKA UY!")
                    alert.show()
                }else{
                    val hash1 = Random.nextInt(difficulty.progress)
                    val hash2 = Random.nextInt(difficulty.progress)
                    third = Random.nextInt(difficulty.progress)
                    txt1.text = hash1.toString()
                    txt2.text = hash2.toString()
                    txt3.text = third.toString()
                }

            }


        }

        //Button 3 "Solve"
        btn3.setOnClickListener {

            if(tanker.text.toString().isEmpty()){
                Toast.makeText(applicationContext, "You don't have an Answer!" , Toast.LENGTH_SHORT).show()
            }else{

                first = txt1.text.toString().toInt()
                second = txt2.text.toString().toInt()
                val result: Int = first * second - txt3.text.toString().toInt()
                val answer: Int = tanker.text.toString().toInt()

                if (result == answer){
                    gen = 0
                    val sc1: Int = score.text.toString().toInt()
                    val sc2: Int = sc1 + 1
                    score.text = sc2.toString()
                    Toast.makeText(applicationContext, "Correct!" , Toast.LENGTH_SHORT).show()
                    val hash1 = Random.nextInt(difficulty.progress)
                    val hash2 = Random.nextInt(difficulty.progress)
                    txt1.text = hash1.toString()
                    txt2.text = hash2.toString()
                    tanker.text = null
                }else{

                    val sc1: Int = score.text.toString().toInt()
                    val sc2: Int = sc1 + -1
                    score.text = sc2.toString()

                    Toast.makeText(applicationContext, "Wrong Answer: ${txt1.text.toString()} x ${txt2.text.toString()} - ${txt3.text.toString()} = $result" , Toast.LENGTH_SHORT).show()
                    val hash1 = Random.nextInt(difficulty.progress)
                    val hash2 = Random.nextInt(difficulty.progress)
                    third = Random.nextInt(difficulty.progress)
                    txt1.text = hash1.toString()
                    txt2.text = hash2.toString()
                    txt3.text = third.toString()
                    tanker.text = null

                }


            }
            



        }
    }
}