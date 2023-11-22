package org.example;

import java.sql.SQLException;
import java.util.LinkedList;

import org.example.Controlador.TablaHashLibros;
import org.example.Modelo.Libro;
import org.example.Modelo.ModeloLibros;

public class Main {
    public static void main(String[] args) throws SQLException {
        // ... (código existente)

        // Crear instancia de la tabla hash
        TablaHashLibros tablaHashLibros = new TablaHashLibros();

        // Obtener todos los libros de la base de datos
        ModeloLibros modeloLibros = new ModeloLibros();
        modeloLibros.CargarDatos();

        // Agregar libros a la tabla hash
        for (Libro libro : modeloLibros.obtenerTodo()) {
            tablaHashLibros.agregarLibro(libro);
        }

        // Ejemplos de uso
        Libro libroEncontrado = tablaHashLibros.buscarLibroPorId(1);
        System.out.println("Libro encontrado: " + libroEncontrado);

        // Eliminar un libro de la tabla hash
        tablaHashLibros.eliminarLibro(2);

        // Imprimir la tabla hash
        tablaHashLibros.imprimirTabla();
    }
}


