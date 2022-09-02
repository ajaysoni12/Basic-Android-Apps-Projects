package com.devdroid.dashboarduidesign;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imgBack, imgLogOut, btnProfile;
    MaterialButton btnTodoList, btnEditProfile;
    CardView contributeCard, practiceCard, learnCard, interestCard, helpCard, settingCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // id's find
        imgBack = findViewById(R.id.imgBack);
        imgLogOut = findViewById(R.id.imgLogOut);
        btnProfile = findViewById(R.id.btnProfile);
        btnTodoList = findViewById(R.id.btnTodoList);
        btnEditProfile = findViewById(R.id.btnEditProfile);
        contributeCard = findViewById(R.id.contributeCard);
        practiceCard = findViewById(R.id.practiceCard);
        learnCard = findViewById(R.id.learnCard);
        interestCard = findViewById(R.id.interestsCard);
        helpCard = findViewById(R.id.helpCard);
        settingCard = findViewById(R.id.settingsCard);

        imgBack.setOnClickListener(this);
        imgLogOut.setOnClickListener(this);
        btnProfile.setOnClickListener(this);
        btnTodoList.setOnClickListener(this);
        btnEditProfile.setOnClickListener(this);
        contributeCard.setOnClickListener(this);
        practiceCard.setOnClickListener(this);
        learnCard.setOnClickListener(this);
        interestCard.setOnClickListener(this);
        helpCard.setOnClickListener(this);
        settingCard.setOnClickListener(this);


    } // onCreate

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.imgBack) {
            Toast.makeText(this, "Back", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.imgLogOut) {
            Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.btnProfile) {
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.btnEditProfile) {
            Toast.makeText(this, "Edit Profile", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.btnTodoList) {
            Toast.makeText(this, "Todo List", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.contributeCard) {
            Toast.makeText(this, "Contribute Card", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.practiceCard) {
            Toast.makeText(this, "Practice Card", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.learnCard) {
            Toast.makeText(this, "Learn Card", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.interestsCard) {
            Toast.makeText(this, "Interest Card", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.helpCard) {
            Toast.makeText(this, "Help Card", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.settingsCard) {
            Toast.makeText(this, "Setting Card", Toast.LENGTH_SHORT).show();
        }
    }
}