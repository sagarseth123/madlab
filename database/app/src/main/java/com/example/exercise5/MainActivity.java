package com.example.exercise5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Roll_no,Name,Marks;
    Button Insert,Delete,Update,View,View_all;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Roll_no = (EditText) findViewById(R.id.roll_no);
        Name=(EditText) findViewById(R.id.name);
        Marks=(EditText) findViewById(R.id.marks);
        Insert=(Button) findViewById(R.id.insert);
        Delete=(Button) findViewById(R.id.delete);
        Update=(Button) findViewById(R.id.update);
        View=(Button) findViewById(R.id.view);
        View_all=(Button) findViewById(R.id.view_all);

        Insert.setOnClickListener(this);
        Delete.setOnClickListener(this);
        Update.setOnClickListener(this);
        View.setOnClickListener(this);
        View_all.setOnClickListener(this);
        db=openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(rollno VARCHAR,name VARCHAR,marks VARCHAR)");

    }
    @Override
    public void onClick(View v) {
        if(v==Insert){
            if(Roll_no.getText().toString().trim().length()==0 || Marks.getText().toString().trim().length()==0 ||
                    Name.getText().toString().trim().length()==0){
                showMessage("error","Enter all values");
                return;
            }
            else{
                db.execSQL("INSERT INTO student VALUES('"+Roll_no.getText()+"','"+Name.getText()+"','"+Marks.getText()+"')");
                showMessage("success","Record Added!!");
                clearText();
            }
        }
        else if(v==Delete){
            if(Roll_no.getText().toString().trim().length()==0){
                showMessage("Error","Enter Roll No");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM student WHERE rollno='"+Roll_no.getText()+"'",null);
            if(c.moveToFirst()){
                db.execSQL("DELETE FROM student WHERE rollno='"+Roll_no.getText()+"'");
                showMessage("Success","Record Deleted");
            }
            else{
                showMessage("Error","Invalid Roll Number");

            }
            clearText();
        }
        else if(v==Update){
            if(Roll_no.getText().toString().trim().length()==0 || Marks.getText().toString().trim().length()==0 ||
                    Name.getText().toString().trim().length()==0){
                showMessage("error","Enter all values");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM student WHERE rollno='"+Roll_no.getText()+"'",null);
            if(c.moveToFirst()){
                db.execSQL("UPDATE student set name='"+Name.getText()+"',marks='"+Marks.getText()+"' WHERE rollno='"+Roll_no.getText()+"'");
                showMessage("Success","Record Modified");
            }
            else{
                showMessage("Error","Invalid Roll Number");

            }
            clearText();
        }
        else if(v==View){
            if(Roll_no.getText().toString().trim().length()==0){
                showMessage("Error","Enter Roll No");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM student WHERE rollno='"+Roll_no.getText()+"'",null);
            if(c.moveToFirst()){
                Name.setText(c.getString(1));
                Marks.setText(c.getString(2));
            }
            else{
                showMessage("Error","Invalid Roll No");
                clearText();
            }

        }
        else if(v==View_all){
            Cursor c=db.rawQuery("SELECT * FROM student",null);
            if(c.getCount()==0){
                showMessage("Error", "No records found");
                return ;
            }
            StringBuffer sb=new StringBuffer();
            while(c.moveToNext()){
                sb.append("Roll No: "+c.getString(0)+"\n");
                sb.append("Name: "+c.getString(1)+"" +"\n");
                sb.append("Marks: "+c.getString(2)+"\n");
            }
            showMessage("Student Details",sb.toString());
        }
    }

    private void clearText() {
        Roll_no.setText("");
        Name.setText("");
        Marks.setText("");
        Roll_no.requestFocus();
    }

    private void showMessage(String error, String message) {
        Builder msg=new Builder(this);
        msg.setCancelable(true);
        msg.setTitle(error);
        msg.setMessage(message);
        msg.show();
    }
}