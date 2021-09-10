package com.example.diceapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/*
This activity is referred as MainActivity because its the first thing that loads up in my application
This allows the user to roll the dice and show the result
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the button1 in the layout
        val rollButton: Button = findViewById(R.id.button)
        //onClickListener method tells the button what to do
        rollButton.setOnClickListener { rollDice() }

        //Rolls the dice on startup just to give user the information what is about to happen
        rollDice()

    }

    /*
    It will roll the dice and displays it on the screen
     */
    private fun rollDice() {
        // Creates the object/instance of the class dice and rolls it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Another Object of dice and roll
        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()
        // Displays the dice Image on Screen
       val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)


        // used this way because thing got repetitive and return the id of the correct image
       val drawableResource = when(diceRoll){
           1->R.drawable.dice_1
           2->R.drawable.dice_2
           3->R.drawable.dice_3
           4->R.drawable.dice_4
           5->R.drawable.dice_5

           else -> R.drawable.dice_6
       }

        val drawableResource2 = when(diceRoll2){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5

            else -> R.drawable.dice_6
        }
        //Display the correct image acc to the dice roll
        diceImage.setImageResource(drawableResource)

        diceImage2.setImageResource(drawableResource2)
        //For Screen Readers
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()
    }
}

/*
Class Dice which contains the method of roll
 */
class Dice(private val numSides: Int) {
    //Returns the random value from 1 to 6
    fun roll(): Int {
        return (1..numSides).random()
    }
}


