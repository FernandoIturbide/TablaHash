package org.example.Controlador;

import java.util.HashMap;
import java.util.Map;

public class Productos {

    // Método para agregar un libro a la tabla
    public static void agregarLibro(HashMap<String, Map<String, Double>> tabla, String titulo, double precio, int cantidad) {
        Map<String, Double> datosLibro = new HashMap<>();
        datosLibro.put("precio", precio);
        datosLibro.put("cantidad", (double) cantidad);
        tabla.put(titulo, datosLibro);
    }

    // Método para obtener el precio de un libro
    public static double obtenerPrecio(HashMap<String, Map<String, Double>> tabla, String titulo) {
        // Verificar si la tabla contiene el título
        if (tabla.containsKey(titulo)) {
            // Obtener y devolver el precio asociado al título
            return tabla.get(titulo).get("precio");
        } else {
            // Devolver -1 si el título no se encuentra en la tabla
            return -1;
        }
    }

    public static void imprimirTabla(HashMap<String, Map<String, Double>> tabla) {
        System.out.println("Contenido de la tabla:");
        for (Map.Entry<String, Map<String, Double>> entry : tabla.entrySet()) {
            String titulo = entry.getKey();
            double precio = entry.getValue().get("precio");
            double cantidad = entry.getValue().get("cantidad");

            System.out.println("Título: " + titulo + ", Precio: " + precio + ", Cantidad: " + cantidad);
        }
    }
}


