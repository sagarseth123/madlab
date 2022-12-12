package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String user_name,name_str,dept_str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText usn=(EditText) findViewById(R.id.editTextTextPersonName);
        EditText name=(EditText) findViewById(R.id.editTextTextPersonName2);
        EditText dept=(EditText) findViewById(R.id.editTextTextPersonName3);
        Button submit=(Button) findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_name=usn.getText().toString();
                name_str=name.getText().toString();
                dept_str=dept.getText().toString();

                Intent i1=new Intent(MainActivity.this,MainActivity2.class);
                i1.putExtra("usn_give",user_name);
                i1.putExtra("name_give",name_str);
                i1.putExtra("dept_give",dept_str);
                startActivity(i1);
            }
        });
    }
}