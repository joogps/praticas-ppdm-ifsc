package com.joogps.notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NotaActivity extends AppCompatActivity {
    NotaController controller;
    Nota nota;

    TextView tituloText, conteudoText;
    Button salvarButton, excluirButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);

        tituloText = findViewById(R.id.tituloText);
        conteudoText = findViewById(R.id.conteudoText);
        salvarButton = findViewById(R.id.salvarButton);
        excluirButton = findViewById(R.id.excluirButton);

        controller = new NotaController(getBaseContext());

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int id = bundle.getInt("id");
            refresh(id);
        }

        salvarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nota.setTitulo(tituloText.getText().toString());
                nota.setConteudo(conteudoText.getText().toString());

                if (controller.updateNota(nota)) {
                    Toast.makeText(NotaActivity.this, "Nota salva", Toast.LENGTH_SHORT).show();
                    if (bundle != null) {
                        int id = bundle.getInt("id");
                        refresh(id);
                    }
                }
            }
        });

        excluirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.deleteNota(nota);
                Intent intent = new Intent(NotaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    void refresh(int id) {
        nota = controller.getNota(id);
        if (nota != null) {
            tituloText.setText(nota.getTitulo());
            conteudoText.setText(nota.getConteudo());
        }
    }
}