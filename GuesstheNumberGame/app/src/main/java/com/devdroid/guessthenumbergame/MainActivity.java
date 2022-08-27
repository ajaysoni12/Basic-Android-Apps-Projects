package com.devdroid.guessthenumbergame;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int min = 1, max = 100;
        result = getRandomNumber(min, max);

    }

    public int getRandomNumber(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public void makeToast(String str) {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }

    public void clickFunction(View view) {
        EditText edtInput = findViewById(R.id.edtInput);
        if (edtInput != null) {
            int userGuessingNum;
            userGuessingNum = Integer.parseInt(edtInput.getText().toString());
            if (userGuessingNum < result) {
                makeToast("Think of Higher Number, Try Again!");
            } else if (userGuessingNum > result) {
                makeToast("Think of Lower Number, Try Again!");
            } else {
                makeToast("Congratulation," + " You got the number");
            }
        }
        else {
            Toast.makeText(this, "Enter Number!", Toast.LENGTH_SHORT).show();
        }
    }

}