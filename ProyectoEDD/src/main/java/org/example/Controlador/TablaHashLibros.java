package org.example.Controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public List<String> obtenerTitulosLibros() {
        List<String> titulos = new ArrayList<>();
        for (Libro libro : tablaHash.values()) {
            titulos.add(libro.getTitulo());
        }
        return titulos;
    }

    public List<Libro> buscarLibroPorTitulo(String titulo) {
        List<Libro> librosEncontrados = new ArrayList<>();

        for (Libro libro : tablaHash.values()) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                librosEncontrados.add(libro);
            }
        }

        return librosEncontrados;
    }

    

}
