package com.joogps.notas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class NotaAdapter extends ArrayAdapter<Nota> {
    private Context context;
    private int resource;

    public NotaAdapter(Context context, int resource, List<Nota> notas) {
        super(context, resource, notas);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        Nota nota = getItem(position);

        if (nota != null) {
            TextView text = view.findViewById(android.R.id.text1);
            text.setText(nota.getTitulo());
        }

        return view;
    }


}
