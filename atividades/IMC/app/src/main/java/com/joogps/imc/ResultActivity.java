package com.joogps.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView textViewPeso, textViewAltura, textViewIMC;
    private ImageView imageViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewPeso = findViewById(R.id.textViewPeso);
        textViewAltura = findViewById(R.id.textViewAltura);
        textViewIMC = findViewById(R.id.textViewIMC);

        imageViewResult = findViewById(R.id.imageViewResult);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            double peso = bundle.getDouble("peso");
            double altura = bundle.getDouble("altura");
            double imc = bundle.getDouble("imc");

            textViewPeso.setText(String.format("Peso: %.2f kg", peso));
            textViewAltura.setText(String.format("Altura: %.2f m", altura));
            textViewIMC.setText(String.format("IMC: %.2f", imc));

            imageViewResult.setImageResource(bundle.getInt("recurso"));
        }
    }
}