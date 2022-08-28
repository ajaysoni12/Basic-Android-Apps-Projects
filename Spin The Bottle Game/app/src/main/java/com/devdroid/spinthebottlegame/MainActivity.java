package com.devdroid.spinthebottlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imgBottle;
    private Random rand = new Random();
    private boolean spin;
    private int lstDr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBottle = findViewById(R.id.imgBottle);

    }

    public void spinBottle(View view) {
        if(!spin){
            int num = rand.nextInt(1800);
            float pivotX = (float) (imgBottle.getWidth() / 2.0);
            float pivotY = (float) (imgBottle.getHeight() / 2.0);

            Animation rotateAnim = new RotateAnimation(lstDr, num, pivotX, pivotY);
            rotateAnim.setDuration(2500);
            rotateAnim.setFillAfter(true);
            rotateAnim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spin = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spin = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            lstDr = num;
            imgBottle.startAnimation(rotateAnim);
        }
    }
}