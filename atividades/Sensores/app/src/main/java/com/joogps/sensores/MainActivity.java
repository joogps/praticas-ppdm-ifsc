package com.joogps.sensores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mSensor;

    private ConstraintLayout layout;
    private TextView lightLabel, lightValueLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        layout = findViewById(R.id.layout);
        lightLabel = findViewById(R.id.lightLabel);
        lightValueLabel = findViewById(R.id.lightValueLabel);
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        lightValueLabel.setText(String.valueOf(event.values[0]));

        Double value = event.values[0]/40000.0;

        int backgroundWhite = (int) (value*255);
        int backgroundColor = android.graphics.Color.rgb(backgroundWhite, backgroundWhite, backgroundWhite);
        layout.setBackgroundColor(backgroundColor);

        int textWhite = (int) (255-value*255);
        int textColor = android.graphics.Color.rgb(textWhite, textWhite, textWhite);
        lightLabel.setTextColor(textColor);
        lightValueLabel.setTextColor(textColor);
    }
}