package com.joogps.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextPeso, editTextAltura;
    private Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPeso = findViewById(R.id.peso);
        editTextAltura = findViewById(R.id.altura);
        buttonCalcular = findViewById(R.id.button);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcular();
            }
        });
    }

    private void calcular() {
        double peso = Double.parseDouble(editTextPeso.getText().toString());
        double altura = Double.parseDouble(editTextAltura.getText().toString());

        double imc = peso / (altura * altura);

        int recurso = classificar(imc);

        Bundle bundle = new Bundle();
        bundle.putDouble("peso", peso);
        bundle.putDouble("altura", altura);
        bundle.putDouble("imc", imc);
        bundle.putInt("recurso", recurso);

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private int classificar(double bmi) {
        if (bmi < 18.5) {
            return R.drawable.abaixopeso;
        } else if (bmi < 25) {
            return R.drawable.normal;
        } else if (bmi < 30) {
            return R.drawable.sobrepeso;
        } else if (bmi < 35) {
            return R.drawable.obesidade1;
        } else if (bmi < 40) {
            return R.drawable.obesidade2;
        } else {
            return R.drawable.obesidade3;
        }
    }
}