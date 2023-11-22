package org.example.Controlador;

import java.awt.event.MouseAdapter;

import org.example.Modelo.ModeloLibros;
import org.example.Vista.Vista;

public class ControladorTabla extends MouseAdapter{
    private Vista view;
    private ModeloLibros modelo;
    private int index;
    private String titulo, autor, genero, anio, precio;

    public ControladorTabla(Vista view, ModeloLibros modelo) {
        this.view = view;
        modelo = new ModeloLibros();
        this.view.getSacarticket().addMouseListener(this);
        this.view.getGuardar().addMouseListener(this);
        this.view.getBorrar().addMouseListener(this);
    }
    
    
}
