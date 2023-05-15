package com.example.database_ex5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText) findViewById(R.id.edit1);
        e2=(EditText) findViewById(R.id.edit2);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);

        SQLiteDatabase db=openOrCreateDatabase("mydb",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS detail(name TEXT,roll TEXT);");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=e1.getText().toString();
                String r=e2.getText().toString();
                try {
                    db.execSQL("INSERT INTO detail VALUES('"+n+"','"+r+"')");
                    Toast.makeText(getApplicationContext(), "Inserted Succesfully", Toast.LENGTH_LONG).show();
                    e1.setText("");
                    e2.setText("");
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Error while Inserting", Toast.LENGTH_LONG).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
    }
}