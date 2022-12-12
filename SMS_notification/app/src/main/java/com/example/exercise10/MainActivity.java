package com.example.exercise10;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private static final int CUSTOM_PERMISSION_SEND_SMS = 0;
    EditText smsContent;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        smsContent = findViewById(R.id.smsContent);

    }

    public void sendSMS() {
        String smsNumber = "9844258201";
        String sms = smsContent.getEditableText().toString();
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(smsNumber,null, sms, null, null);
            Toast.makeText(MainActivity.this, "SMS sent successfully!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Failed to send SMS.", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        return;
    }

    public void onSendBtnClick(View v) {
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
            sendSMS();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, CUSTOM_PERMISSION_SEND_SMS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CUSTOM_PERMISSION_SEND_SMS:
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    sendSMS();
                } else {
                    Toast.makeText(MainActivity.this, "Need permission to send SMS.", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }
}