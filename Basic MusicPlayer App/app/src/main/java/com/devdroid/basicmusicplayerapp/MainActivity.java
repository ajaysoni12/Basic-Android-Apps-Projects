package com.devdroid.basicmusicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        music = MediaPlayer.create(this, R.raw.sound);
        Button btnPlay = findViewById(R.id.btnPlay);
        Button btnStop = findViewById(R.id.btnStop);
        Button btnPause = findViewById(R.id.btnPause);
        btnPause.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);


    } // onCreate

    public void playSong(View view){
        music.start();
    }

    public void pauseSong(View view){
        music.pause();
    }

    public void stopSong(View view){
        music.stop();
        music = MediaPlayer.create(this, R.raw.sound);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.btnPlay)
            playSong(view);
        else if(id == R.id.btnPause)
            pauseSong(view);
        else if(id == R.id.btnStop)
            stopSong(view);
    }
}