package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e;
    Button b;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e=(EditText) findViewById(R.id.edit);
        b=(Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i=new Intent(MainActivity.this,MainActivity2.class);
                    PendingIntent pi=PendingIntent.getActivity(MainActivity.this,0,i,0);
                    Notification not=new Notification.Builder(MainActivity.this)
                            .setContentInfo("New Message")
                            .setContentText(e.getText().toString())
                            .setSmallIcon(R.drawable.ic_launcher_background)
                            .setContentIntent(pi).build();
                    NotificationManager manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    not.flags=Notification.FLAG_AUTO_CANCEL;
                    manager.notify(0,not);
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}