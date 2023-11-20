package org.example.Modelo;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.swing.table.TableModel;
import javax.swing.event.TableModelListener;

import org.example.DBase.LibrosDAO;

public class ModeloLibros extends LibrosDAO implements TableModel{
    public static final int COLUMNAS=6;
    private LibrosDAO LDAO;
    private ArrayList <Libro> datos;

    public ModeloLibros() {
        LDAO=new LibrosDAO();
        datos=new ArrayList<>();
    }

    public ModeloLibros(ArrayList<Libro> datos) {
        this.datos = datos;
        LDAO=new LibrosDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "Id";
            case 1:
                return "Titulo";
            case 2:
                return "Autor";
            case 3:
                return "Genero";
            case 4:
                return "Anio";
            case 5:
                return "Precio";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return Integer.class;
            case 5:
                return Double.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Libro tmp=datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getTitulo();
            case 2:
                return tmp.getAutor();
            case 3:
                return tmp.getGenero();
            case 4:
                return tmp.getAnio();
            case 5:
                return tmp.getPrecio();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Libro tmp=datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                tmp.setId((int)aValue);
                break;
            case 1:
                tmp.setTitulo((String)aValue);
                break;
            case 2:
                tmp.setAutor((String)aValue);
                break;
            case 3:
                tmp.setGenero((String)aValue);
                break;
            case 4:
                tmp.setAnio((int)aValue);
                break;
            case 5:
                tmp.setPrecio((double)aValue);
                break;
        }
        try {
            LDAO.update(tmp);
        } catch (SQLException e) {
            System.out.println("No se modificó nada");
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }

    public void CargarDatos(){
        try {
            ArrayList<Libro> tirar=LDAO.obtenerTodo();
            System.out.println(tirar);
            datos=LDAO.obtenerTodo();
        }catch (SQLException sql){
            System.out.println(sql.getMessage());
        }

    }
    public boolean agregarBarco(Libro libros){
        boolean resultado=false;
        try {
            if(LDAO.insertar(libros)){
                datos.add(libros);
                resultado=true;
            }else{
                resultado=false;
            }
        }catch (SQLException sql){
            System.out.println(sql.getMessage());
        }
        return resultado;
    }

    public Libro getBarcosIndex(int index){
        return datos.get(index);
    }
}
