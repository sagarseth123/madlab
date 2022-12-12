package com.example.exercise3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    EditText e1,e2;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText) findViewById(R.id.editTextTextPersonName);
        e2=(EditText) findViewById(R.id.editTextTextPersonName2);
        Button add=(Button) findViewById(R.id.button);
        Button sub=(Button) findViewById(R.id.button3);
        Button mul=(Button) findViewById(R.id.button2);
        Button div=(Button) findViewById(R.id.button5);
        t1=(TextView) findViewById(R.id.textView);
        System.out.println(this);
//        add.setOnClickListener(this);
//        sub.setOnClickListener(this);
//        mul.setOnClickListener(this);
//        div.setOnClickListener(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(e1.getText().toString()) || TextUtils.isEmpty(e2.getText().toString())){
                    t1.setText("Enter both the values!");
                    return;
                }
                float n1=Float.parseFloat(e1.getText().toString());
                float n2=Float.parseFloat(e2.getText().toString());
                String oper="";
                float ans=n1+n2;
                oper="+";
                t1.setText(n1+" "+ oper +" "+n2 +" = "+ ans);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(e1.getText().toString()) || TextUtils.isEmpty(e2.getText().toString())){
                    t1.setText("Enter both the values!");
                    return;
                }
                float n1=Float.parseFloat(e1.getText().toString());
                float n2=Float.parseFloat(e2.getText().toString());
                String oper="";
                float ans=n1-n2;
                oper="+";
                t1.setText(n1+" "+ oper +" "+n2 +" = "+ ans);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(e1.getText().toString()) || TextUtils.isEmpty(e2.getText().toString())){
                    t1.setText("Enter both the values!");
                    return;
                }
                float n1=Float.parseFloat(e1.getText().toString());
                float n2=Float.parseFloat(e2.getText().toString());
                String oper="";
                float ans=n1*n2;
                oper="+";
                t1.setText(n1+" "+ oper +" "+n2 +" = "+ ans);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(e1.getText().toString()) || TextUtils.isEmpty(e2.getText().toString())){
                    t1.setText("Enter both the values!");
                    return;
                }
                float n1=Float.parseFloat(e1.getText().toString());
                float n2=Float.parseFloat(e2.getText().toString());
                String oper="";
                float ans=n1/n2;
                oper="+";
                t1.setText(n1+" "+ oper +" "+n2 +" = "+ ans);
            }
        });
    }
//    @Override
//    public void onClick(View view){
//        t1.setText("success!!");
//    }
//    @Override
//    public void onClick(View view) {
//
//    }
}