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
    private fun generateRandomNum(): Int {
        var random = Random()
        var min = 1
        var max = 20

        randomNum = random.nextInt(max + 1 - min) + min

        return randomNum
    }

    /**
     * Once random number is generated, make the global randomNum # variable equal to it
     */
    private fun assignRandomNum() {
        randomNum = generateRandomNum()
    }

    /**
     * Give values to each number. Every number will match a respective fortune once.
     * There are 20 fortunes for numbers 1-20
     */
    private fun generateFortune(): String {

        var answer = ""

        when(randomNum) {


            1 -> answer = "It is certain"
            2 -> answer = "It is decidedly so"
            3 -> answer = "Without a doubt"
            4 -> answer = "Yes definitely!"
            5 -> answer = "You may rely on it"
            6 -> answer = "As I see it, yes..."
            7 -> answer = "Most likely"
            8 -> answer = "Outlook good"
            9 -> answer = "YAS"
            10 -> answer = "Signs point to --> yes <--"
            11 -> answer = "Reply hazy try again"
            12 -> answer = "Yawn...Ask again later..."
            13 -> answer = "Better not tell you now"
            14 -> answer = "Cannot predict now"
            15 -> answer = "Concentrate Padawan and ask again"
            16 -> answer = "Don't count on it"
            17 -> answer = "My reply is NO"
            18 -> answer = "My sources say no sorry"
            19 -> answer = "Outlook good not so"
            20 -> answer = "Very doubtful"

            else -> { //Note the block
                answer = "ERROR! Please take a break and shake again"
            } // end of else statement

        } // end of when/switch statement

        return answer
    }

    /**
     * Save the question so it can be saved and passed --> intent to the next activity:EightBallResultScreen
     */
    private fun saveQuestion(): String {
        var question:String = questionTextBox.getText().toString()

        return question
    }

    /**
     *
     */
    private fun setOnClickListenerForButton(){

        askBttn.setOnClickListener{

            val intent = Intent("com.asfoor.magic8ball.EightBallResultScreen")
            intent.putExtra("FortuneResult" , generateFortune())
            intent.putExtra("FortuneQuestion" , saveQuestion())
            startActivity(intent)
        }
    }

    //End of WORKING functions for MainActivity class


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

}
