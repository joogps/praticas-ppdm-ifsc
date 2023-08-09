package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Message", "onStart");

        Toast.makeText(this, "Torrada", Toast.LENGTH_LONG).show();
    }

    @Override
    protected  void onResume() {
        super.onResume();
        Log.d("Message", "onResume");
    }

    @Override
    protected  void onPause() {
        super.onPause();
        Log.d("Message", "onPause");
    }
    @Override
    protected  void onRestart() {
        super.onRestart();
        Log.d("Message", "onRestart");
    }
}