package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollBtn: Button = findViewById(R.id.button)
        rollBtn.setOnClickListener {
            updateDiceImage(rollDice(6).toString())
        }

        updateDiceImage(rollDice(6).toString())
    }

    /**
    * Roll a new dice of given number of sides and return the result.
    */
    private fun rollDice(numberOfSides: Int): Int {
        return Dice(numberOfSides).roll()
    }

    /**
     * Get and set the text value of our TextView that shows dice rolls.
     */
    private fun updateDiceImage(text: String) {
        val diceImage: ImageView = findViewById(R.id.imageView)

        val drawableResource = when (text){
            "1" -> R.drawable.dice_1
            "2" -> R.drawable.dice_2
            "3" -> R.drawable.dice_3
            "4" -> R.drawable.dice_4
            "5" -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = text;
    }
}

class Dice(private var sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}