package com.devdroid.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtResult;
    EditText edtNum1, edtNum2;
    Button btnSum, btnSub, btnMul, btnDiv, btnPercent, btnMod;

    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find id's
        txtResult = findViewById(R.id.txtResult);
        edtNum1 = findViewById(R.id.edtInputNum1);
        edtNum2 = findViewById(R.id.edtInputNum2);
        btnSum = findViewById(R.id.btnSum);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnPercent = findViewById(R.id.btnPercentage);
        btnMod = findViewById(R.id.btnMod);

        // OnClickListener
        btnSum.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMod.setOnClickListener(this);
        btnPercent.setOnClickListener(this);


    } // OnCreate

    public boolean getNumbers() {

        String s1 = "", s2 = "";
        s1 = edtNum1.getText().toString();
        s2 = edtNum2.getText().toString();

        if (s1.equals("") && s2.equals("")) {
            edtNum1.setText("Please enter value 1");
            edtNum2.setText("Please enter value 2");
            return false;
        } else if (s1.equals("")) {
            edtNum1.setText("Please enter value 1");
            return false;
        } else if (s2.equals("")) {
            edtNum2.setText("Please enter value 2");
            return false;
        } else {
            num1 = Integer.parseInt(s1);
            num2 = Integer.parseInt(s2);
        }
        return true;

    } // getNumber Method

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btnSum) {
            doSum(view);
        } else if (id == R.id.btnSub) {
            doSub(view);
        } else if (id == R.id.btnMul) {
            doMul(view);
        } else if (id == R.id.btnDiv) {
            doDiv(view);
        } else if (id == R.id.btnPercentage) {
            doPercentage(view);
        } else if (id == R.id.btnMod) {
            doMod(view);
        } // if-else block
    } // onClick

    @SuppressLint("SetTextI18n")
    public void doPercentage(View v) {
        if (getNumbers()) {
            double per = num1 / 100.0;
            txtResult.setText(Double.toString(per));
        }
    }

    @SuppressLint("SetTextI18n")
    public void doMod(View v) {
        if (getNumbers()) {
            double mod = num1 % num2;
            txtResult.setText(Double.toString(mod));
        }
    }

    @SuppressLint("SetTextI18n")
    public void doDiv(View v) {
        if (getNumbers()) {
            double div = num1 / (num2 * 1.0);
            txtResult.setText(Double.toString(div));
        }
    }

    @SuppressLint("SetTextI18n")
    public void doMul(View v) {
        if (getNumbers()) {
            int sum = num1 * num2;
            txtResult.setText(Integer.toString(sum));
        }
    }

    @SuppressLint("SetTextI18n")
    public void doSub(View view) {
        if (getNumbers()) {
            int sub = num1 - num2;
            txtResult.setText(Integer.toString(sub));
        }
    }

    public void cleaTextNum1(View view) {
        edtNum1.getText().clear();
    }

    public void cleaTextNum2(View view) {
        edtNum1.getText().clear();
    }

    @SuppressLint("SetTextI18n")
    public void doSum(View view) {

        if (getNumbers()) {
            int sum = num1 + num2;
            txtResult.setText(Integer.toString(sum));
        }
    }


}