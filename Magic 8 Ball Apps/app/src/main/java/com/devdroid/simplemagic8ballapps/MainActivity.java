package com.devdroid.simplemagic8ballapps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imgEightBall = (ImageView) findViewById(R.id.imgEightBall);
        Button btnAsk =  (Button) findViewById(R.id.btnAsk);

        final int[] ball = {
                R.drawable.ball_1,
                R.drawable.ball_2,
                R.drawable.ball_3,
                R.drawable.ball_4,
                R.drawable.ball_5
        };
        btnAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int x = random.nextInt(4);
                imgEightBall.setImageResource(ball[x]);
            }
        });
    }
}