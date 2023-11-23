package org.example;

import org.example.Vista.Inicio;


public class Main {
    public static void main(String[] args) {
        Inicio interfaz11 = new Inicio();
         interfaz11.setBounds(0,0,350,450);
         interfaz11.setVisible(true);
         interfaz11.setResizable(false);
         interfaz11.setLocationRelativeTo(null);
        /* 
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
        tablaHashLibros.imprimirTabla();*/
    }
}


