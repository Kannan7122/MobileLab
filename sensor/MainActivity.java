package com.example.sensor_ex13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    EditText e1;
    SensorManager sm;
    Sensor tm;
    Boolean tempAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText) findViewById(R.id.editTextTextPersonName);
        sm=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(sm.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)!=null)
        {
            tm=sm.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            tempAvailable=true;
        }
        else
        {
            e1.setText("Temperature not available");
            tempAvailable=false;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        e1.setText(event.values[0]+"C");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onPause(){
        super.onPause();
        if(tempAvailable)
        {
            sm.unregisterListener(this);
        }
    }

    @Override
    protected void onPostResume(){
        super.onPostResume();
        if(tempAvailable)
        {
            sm.registerListener(this,tm,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
}