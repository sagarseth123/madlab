package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    String uname,name,dept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView t1=(TextView) findViewById(R.id.textView4);
        TextView t2=(TextView) findViewById(R.id.textView5);
        TextView t3=(TextView) findViewById(R.id.textView6);
        Intent i2=getIntent();
        uname=i2.getStringExtra("usn_give");
        name=i2.getStringExtra("name_give");
        dept=i2.getStringExtra("dept_give");
        t1.setText(uname);
        t2.setText(name);
        t3.setText(dept);

    }
}