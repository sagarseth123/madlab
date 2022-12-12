package com.example.exercise8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView lat, lon;
    Button click;
    LocationManager locMg;
    LocationListener lis;


    @SuppressLint({"MissingPermission", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lat = (TextView) findViewById(R.id.lat);
        lon = (TextView) findViewById(R.id.lon);
        click = (Button) findViewById(R.id.gps);
        locMg = (LocationManager) getSystemService(LOCATION_SERVICE);
        lis = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                lat.setText(""+location.getLatitude());
                lon.setText(""+location.getLongitude());
            }
        };
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        click.setOnClickListener(view -> {
            locMg.requestLocationUpdates("gps", 5000, 0, lis);
        });
    }
}

