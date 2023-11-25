package org.example.Controlador;

import java.util.HashMap;
import java.util.Map;

public class Productos {

    // No usado
    public static void agregarLibro(HashMap<String, Map<String, Double>> tabla, String titulo, double precio, int cantidad) {
        Map<String, Double> datosLibro = new HashMap<>();
        datosLibro.put("precio", precio);
        datosLibro.put("cantidad", (double) cantidad);
        tabla.put(titulo, datosLibro);
    }

    // Obtiene el total de la venta de libros
    public static double obtenerPrecio(HashMap<String, Map<String, Double>> tabla, String titulo) {
        if (tabla.containsKey(titulo)) {
            return tabla.get(titulo).get("precio");
        } else {
            //No hace nada o retorna un error
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
    //Me ayuda a ver si los datos de SQL se cargaron de manera correcta
}


