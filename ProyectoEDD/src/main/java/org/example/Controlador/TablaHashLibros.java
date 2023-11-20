package org.example.Controlador;

import java.util.HashMap;
import java.util.Map;

import org.example.Modelo.Libro;

public class TablaHashLibros {
    private Map<Integer, Libro> tablaHash;

    public TablaHashLibros() {
        tablaHash = new HashMap<>();
    }

    public void agregarLibro(Libro libro) {
        tablaHash.put(libro.getId(), libro);
    }

    public Libro buscarLibroPorId(int id) {
        return tablaHash.get(id);
    }

    public void eliminarLibro(int id) {
        tablaHash.remove(id);
    }

    public void imprimirTabla() {
        for (Map.Entry<Integer, Libro> entry : tablaHash.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Libro: " + entry.getValue());
        }
    }
}
