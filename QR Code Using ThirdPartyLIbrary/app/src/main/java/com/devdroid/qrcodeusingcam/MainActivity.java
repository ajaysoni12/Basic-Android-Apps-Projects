package com.devdroid.qrcodeusingcam;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.jetbrains.annotations.Nullable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button scanBtn;
    TextView txtContent, txtMessageFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scanBtn = findViewById(R.id.scanBtn);
        txtContent = findViewById(R.id.txtContent);
        txtMessageFormat = findViewById(R.id.txtFormat);

        scanBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setPrompt("Scan a Barcode or QR Code");
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.initiateScan();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent Data){
        super.onActivityResult(requestCode, resultCode, Data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, Data);
        if(intentResult!=null){
            if(intentResult.getContents() == null) {
                Toast.makeText(this, "Cancelled--!", Toast.LENGTH_SHORT).show();
            } else {
                txtContent.setText(intentResult.getContents());
                txtMessageFormat.setText(intentResult.getFormatName());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, Data);
        }
    }

}