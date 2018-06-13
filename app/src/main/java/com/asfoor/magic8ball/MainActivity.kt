package com.asfoor.magic8ball

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var randomNum = 0 //global randomNum int this is the number that the user must guess

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Call worker functions
        assignRandomNum()
        generateFortune()

        //Call Button Listeners
        setOnClickListenerForButton()

    }

    /**
     * Generate a random number (fortune) for the 20 different 8-ball fortunes
     */
    fun generateRandomNum(): Int {
        var random = Random()
        var min = 1
        var max = 20

        randomNum = random.nextInt(max + 1 - min) + min

        return randomNum
    }

    /**
     * Once random number is generated, make the global randomNum # variable equal to it
     */
    fun assignRandomNum() {
        randomNum = generateRandomNum()
    }

    /**
     * Give values to each number. Every number will match a respective fortune once.
     * There are 20 fortunes for numbers 1-20
     */
    fun generateFortune(): String {

        var answer = ""

        when(randomNum) {


            1 -> answer = "It is certain"
            2 -> answer = "It is decidedly so"

            else -> { //Note the block
                print("RandomNum is neither 1 or 2")

            }
        } // end of when/switch statement

        return answer
    }

    /**
     *
     */
    private fun setOnClickListenerForButton(){

        askBttn.setOnClickListener{

            val intent = Intent("com.asfoor.magic8ball.EightBallResultScreen")
            intent.putExtra("FortuneResult",generateFortune())
            startActivity(intent)
        }




    }

    //End of functions for MainActivity class



    /*


     ////////////////////Functions not used, this is for more functionality and code practice

    /**
     *
     */
    private fun giveFortune():String {
        val question = questionTextBox.getText().toString()
        return question
    }



    private fun askQuestionBttn(): {

    }

     */



} // end of mainActivity class
