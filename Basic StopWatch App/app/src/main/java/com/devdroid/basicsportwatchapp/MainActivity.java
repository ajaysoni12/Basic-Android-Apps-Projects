package com.devdroid.basicsportwatchapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity{

    private int Seconds = 0; // Number of Second
    private boolean Running, wasRunning; // is the StopWatch running


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            Seconds = savedInstanceState.getInt("Seconds");
            Running = savedInstanceState.getBoolean("Running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("Seconds", Seconds);
        savedInstanceState.putBoolean("Running", Running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = Running;
        Running = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            Running = true;
        }
    }

    public void onClickStart(View view) {
        Running = true;
    }

    public void onClickStop(View view) {
        Running = false;
    }

    public void onClickReset(View view) {
        Running = false;
        Seconds = 0;
    }

    private void runTimer() {

        final TextView timeView = (TextView) findViewById(R.id.txtSpotTime);

        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {

                int hours = Seconds / 3600;
                int minutes = (Seconds % 3600) / 60;
                int secs = Seconds % 60;

                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);

                timeView.setText(time);

                if (Running) {
                    Seconds++;
                }

                handler.postDelayed(this, 1000);
            }
        });
    }
}