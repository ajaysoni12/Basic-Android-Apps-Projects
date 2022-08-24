package com.devdroid.videoplayer;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {

    VideoView videoView;
    ArrayList<Integer> videoList = new ArrayList<>();
    int currVideo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);

        videoView.setMediaController(new MediaController(this));
        videoView.setOnCompletionListener(this);

        videoList.add(R.raw.video2);
        videoList.add(R.raw.video1);
        setVideo(videoList.get(0));

    } // onCreate

    public void setVideo(int ind) {
        String uriPath
                = "android.resource://"
                + getPackageName() + "/" + ind;
        Uri videoUri = Uri.parse(uriPath);
        videoView.setVideoURI(videoUri);
        videoView.start();
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        AlertDialog.Builder obj = new AlertDialog.Builder(this);
        obj.setTitle("Playback Finished!");
        obj.setIcon(R.mipmap.ic_launcher);
        MyListener m = new MyListener();
        obj.setPositiveButton("Replay", m);
        obj.setNegativeButton("Next", m);
        obj.setMessage("Want to replay or play next video?");
        obj.show();
    }

    class MyListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            if (which == -1) {
                videoView.seekTo(0);
                videoView.start();
            }
            else {
                ++currVideo;
                if (currVideo == videoList.size())
                    currVideo = 0;
                setVideo(videoList.get(currVideo));
            }
        } // onclick
    } // MyListener

}