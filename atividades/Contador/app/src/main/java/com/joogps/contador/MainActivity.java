package com.joogps.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.joogps.contador.R;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;

    Integer i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        textView.setText(Integer.toString(i));
    }

    public void contar(View v) {
        i++;
        textView.setText(Integer.toString(i));
    }
}