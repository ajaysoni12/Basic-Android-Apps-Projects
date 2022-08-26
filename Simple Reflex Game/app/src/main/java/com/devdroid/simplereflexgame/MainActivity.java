package com.devdroid.simplereflexgame;

import static com.devdroid.simplereflexgame.R.color.green;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public ConstraintLayout constraintLayout;
    public Button btnStart, btnStop;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            constraintLayout.setBackgroundResource(green);

            final long time = (long) System.currentTimeMillis();

            btnStop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    long timeStart = System.currentTimeMillis();
                    Toast.makeText(MainActivity.this, "Your Reflexes takes " + (timeStart - time) + " time to work", Toast.LENGTH_SHORT).show();
                    constraintLayout.setBackgroundResource(0);
                }
            }); // setOnClickListener
        }
    };  // Runnable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.constraintLayout);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int randomNum = random.nextInt(10);
                Handler handler = new Handler();
                handler.postDelayed(runnable, randomNum * 1000);
            }
        }); // setOnClickListener
    }
}