package com.joogps.notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton novaNota;
    ListView listaNotas;

    NotaController controller;
    NotaAdapter adapter;
    ArrayList<Nota> notas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new NotaController(getBaseContext());
        notas = controller.getNotas();

        listaNotas = findViewById(R.id.listaNotas);
        adapter = new NotaAdapter(this, android.R.layout.simple_list_item_1, notas);
        listaNotas.setAdapter(adapter);

        novaNota = findViewById(R.id.novaNota);
        novaNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nota nota = new Nota("Nova nota", "");
                controller.addNota(nota);
                refresh();
            }
        });

        listaNotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                Nota nota = (Nota)parent.getItemAtPosition(position);
                bundle.putInt("id", nota.getId());

                Intent intent = new Intent(MainActivity.this, NotaActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        refresh();
    }

    void refresh() {
        notas = controller.getNotas();
        adapter = new NotaAdapter(this, android.R.layout.simple_list_item_1, notas);
        listaNotas.setAdapter(adapter);
    }
}