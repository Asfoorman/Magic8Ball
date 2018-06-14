package com.asfoor.magic8ball

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_eight_ball_result_screen.*
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import com.asfoor.magic8ball.R.id.askBttn


/**
 * Where the 8-Ball Fortune is revealed to the user
 */
class EightBallResultScreen : AppCompatActivity() {



    /**
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eight_ball_result_screen)

        //Call worker functions
        showFortune()
        //findFortune()

        //Set Listeners
        //setExitListener()
        //setCheckAgainListener()
    }

    /**
     * Function that will display question and the corresponding fortune for the user's question
     */
    private fun showFortune() {

       var question = getIntent().getExtras().getString("FortuneQuestion")

        usrQuestion.setText(question) //Have the question appear in the fortune result screen


        var fortune = getIntent().getExtras().getString("FortuneResult")

        lblFortune.setText(fortune)
    }


//    /**
//     *
//     */
//    private fun findFortune() {
//
//    }

} //End of 8BallResultScreen - Where fortune is revealed
