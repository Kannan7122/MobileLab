package com.example.sd_card_ex_6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    EditText e;
    Button b1,b2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e=(EditText) findViewById(R.id.edit);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File f;
                try {
                    f=new File("/sdcard/output.txt");
                    f.createNewFile();
                    FileOutputStream fout=new FileOutputStream(f);
                    String str=e.getText().toString();
                    fout.write(str.getBytes());
                    Toast.makeText(getApplicationContext(), "File created Succesfully", Toast.LENGTH_SHORT).show();
                    e.setText("");
                }
                catch (Exception err){
                    Toast.makeText(getApplicationContext(), err.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    File f=new File("/sdcard/output.txt");
                    FileInputStream fin=new FileInputStream(f);
                    BufferedReader bf=new BufferedReader(new InputStreamReader(fin));
                    String value="";
                    String msg;
                    while((msg= bf.readLine())!=null){
                        value+=msg;
                    }
                    e.setText(value);
                    Toast.makeText(getApplicationContext(), "Read Successful", Toast.LENGTH_SHORT).show();
                }
                catch (Exception err) {
                    Toast.makeText(getApplicationContext(), err.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}