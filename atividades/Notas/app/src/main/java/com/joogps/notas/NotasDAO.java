package com.joogps.notas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotasDAO {
    SQLiteDatabase db;

    NotasDAO(Context c) {
        db = c.openOrCreateDatabase("banco", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, conteudo TEXT)");
    }

    public Nota insertNota(Nota nota) {
        ContentValues values = new ContentValues();
        values.put("titulo", nota.getTitulo());
        values.put("conteudo", nota.getConteudo());

        long insertedId = db.insert("notas", null, values);
        if (insertedId != -1) {
            nota.setId((int) insertedId); // Set the ID of the inserted note
            return nota;
        } else {
            return null; // Insertion failed
        }
    }

    public boolean updateNota(Nota nota) {
        ContentValues values = new ContentValues();
        values.put("titulo", nota.getTitulo());
        values.put("conteudo", nota.getConteudo());

        int rowsAffected = db.update("notas", values, "id = ?", new String[]{String.valueOf(nota.getId())});

        return rowsAffected > 0;
    }

    public boolean deleteNota(Nota nota) {
        int rowsAffected = db.delete("notas", "id = ?", new String[]{String.valueOf(nota.getId())});
        return rowsAffected > 0;
    }

    public Nota getNota(int notaId) {
        Cursor cursor = db.query("notas", null, "id = ?", new String[]{String.valueOf(notaId)}, null, null, null);

        if (cursor.moveToFirst()) {
            int idColumnIndex = cursor.getColumnIndex("id");
            int tituloColumnIndex = cursor.getColumnIndex("titulo");
            int conteudoColumnIndex = cursor.getColumnIndex("conteudo");

            int id = cursor.getInt(idColumnIndex);
            String titulo = cursor.getString(tituloColumnIndex);
            String conteudo = cursor.getString(conteudoColumnIndex);

            cursor.close();
            return new Nota(id, titulo, conteudo);
        } else {
            cursor.close();
            return null;
        }
    }

    public ArrayList<Nota> getNotas() {
        ArrayList<Nota> notasList = new ArrayList<>();
        Cursor cursor = db.query("notas", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int idColumnIndex = cursor.getColumnIndex("id");
            int tituloColumnIndex = cursor.getColumnIndex("titulo");
            int conteudoColumnIndex = cursor.getColumnIndex("conteudo");

            do {
                int id = cursor.getInt(idColumnIndex);
                String titulo = cursor.getString(tituloColumnIndex);
                String conteudo = cursor.getString(conteudoColumnIndex);
                notasList.add(new Nota(id, titulo, conteudo));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return notasList;
    }
}
