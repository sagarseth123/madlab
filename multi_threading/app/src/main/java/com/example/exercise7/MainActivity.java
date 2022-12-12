package com.example.exercise7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=(Button) findViewById(R.id.button);
        Button b2=(Button) findViewById(R.id.button2);
        ImageView i=(ImageView) findViewById(R.id.imageView2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        i.post(new Runnable() {
                            @Override
                            public void run() {
                                i.setImageResource(R.drawable.india1);
                            }
                        });
                    }
                }).start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        i.post(new Runnable() {
                            @Override
                            public void run() {
                                i.setImageResource(R.drawable.india2);
                            }
                        });
                    }
                }).start();
            }
        });
    }
}