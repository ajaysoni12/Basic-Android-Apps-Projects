package com.devdroid.simpledicegame;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    public static Button btnRollDice;
    @SuppressLint("StaticFieldLeak")
    public static TextView txtWinnerName;
    @SuppressLint("StaticFieldLeak")
    public static ImageView imgPlayer1, imgPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // array to store dice images
        final int dice[] = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        // id's find
        btnRollDice = findViewById(R.id.btnRollDice);
        txtWinnerName = findViewById(R.id.txtWinnerName);
        imgPlayer1 = findViewById(R.id.imgPlayer1);
        imgPlayer2 = findViewById(R.id.imgPlayer2);

        btnRollDice.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                // generate two random numbers using Random function
                Random random1 = new Random();
                Random random2 = new Random();
                int num1 = random1.nextInt(6);
                int num2 = random1.nextInt(6);

                // the bigger number will be displayed in the textView as the winner otherwise draw..
                if (num1 > num2) {
                    txtWinnerName.setText("Player 1");
                } else if ( num2 > num1) {
                    txtWinnerName.setText("Player 2");
                } else {
                    txtWinnerName.setText("Drawn");
                }

                // set the images from the array by the index position of the numbers generated
                imgPlayer1.setImageResource(dice[num1]);
                imgPlayer2.setImageResource(dice[num2]);

            }
        }); // setOnClickListener

    } // onCreate
}