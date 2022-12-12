package com.example.practice_mad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{ Manifest.permission.SET_ALARM}, 1);
    }

    public void onSetBtnClick(View v) {
        requestPermission();

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SET_ALARM) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission not granted!", Toast.LENGTH_LONG).show();
            return;
        }

        TimePicker timePicker = findViewById(R.id.timePicker);
        @SuppressLint({"NewApi", "LocalSuppress"}) Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_HOUR, timePicker.getHour())
                .putExtra(AlarmClock.EXTRA_MINUTES, timePicker.getMinute())
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Alarm created by AlarmApp")
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        startActivity(intent);
        Toast.makeText(this, "Set the alarm!", Toast.LENGTH_LONG).show();
    }
}