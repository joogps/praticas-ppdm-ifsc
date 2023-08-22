package com.joogps.sorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView resultadoText;
    EditText editText1;
    EditText editText2;
    Button sortearButton;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultadoText = findViewById(R.id.resultadoText);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        sortearButton = findViewById(R.id.sortearButton);

        random = new Random();
    }

    public void sortear(View v) {
        String minString = editText1.getText().toString();
        String maxString = editText2.getText().toString();

        if (!minString.isEmpty() && !maxString.isEmpty()) {
            int minValue = Integer.parseInt(minString);
            int maxValue = Integer.parseInt(maxString);

            if (minValue <= maxValue) {
                int randomValue = random.nextInt(maxValue-minValue+1)+minValue;
                resultadoText.setText(String.valueOf(randomValue));
            } else {
                resultadoText.setText("O valor mínimo deve ser menor ou igual que o valor máximo.");
            }
        } else {
            resultadoText.setText("Insira valores válidos.");
        }
    }
}