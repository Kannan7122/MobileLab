package com.example.database_ex5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    Cursor rs;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        e1=(EditText) findViewById(R.id.edit1);
        e2=(EditText) findViewById(R.id.edit2);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);

        SQLiteDatabase db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        try {
            rs=db.rawQuery("SELECT * FROM detail",null);
            rs.moveToFirst();
            String name=rs.getString(0);
            String roll=rs.getString(1);
            e1.setText(name);
            e2.setText(roll);
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error while fetching", Toast.LENGTH_LONG).show();
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    rs.moveToNext();
                    String name=rs.getString(0);
                    String roll=rs.getString(1);
                    e1.setText(name);
                    e2.setText(roll);
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Last record reached", Toast.LENGTH_LONG).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    rs.moveToPrevious();
                    String name=rs.getString(0);
                    String roll=rs.getString(1);
                    e1.setText(name);
                    e2.setText(roll);
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "First record reached", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}