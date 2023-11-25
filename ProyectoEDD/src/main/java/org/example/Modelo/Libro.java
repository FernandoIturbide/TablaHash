package org.example.Modelo;

public class Libro {
    private int id;
    private String Titulo;
    private String Autor;
    private String Genero;
    private int Anio;
    private double precio;
    //Clase tipo libro para la tabla hash

    public Libro() {
    }

    public Libro(int id, String titulo, String autor, String genero, int anio, double precio) {
        this.id = id;
        Titulo = titulo;
        Autor = autor;
        Genero = genero;
        Anio = anio;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public int getAnio() {
        return Anio;
    }

    public void setAnio(int anio) {
        Anio = anio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", Titulo='" + Titulo + '\'' +
                ", Autor='" + Autor + '\'' +
                ", Genero='" + Genero + '\'' +
                ", Anio=" + Anio +
                ", precio=" + precio +
                '}';
    }
}
