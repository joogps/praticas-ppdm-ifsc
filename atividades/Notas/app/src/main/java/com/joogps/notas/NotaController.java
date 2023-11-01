package com.joogps.notas;

import android.content.Context;

import java.util.ArrayList;

public class NotaController {
    NotasDAO dao;

    NotaController(Context c) {
        dao = new NotasDAO(c);
    }

    Nota addNota(Nota nota) {
        return dao.insertNota(nota);
    }

    boolean updateNota(Nota nota) {
        return dao.updateNota(nota);
    }

    boolean deleteNota(Nota nota) {
        return dao.deleteNota(nota);
    }

    ArrayList<Nota> getNotas() {
        return dao.getNotas();
    }
}
