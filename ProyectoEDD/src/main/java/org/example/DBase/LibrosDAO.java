package org.example.DBase;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.example.Modelo.Libro;

import java.sql.ResultSet;

public class LibrosDAO implements IntefazDAO{
        public LibrosDAO() {
        }
    
        @Override
        public boolean insertar(Object o) throws SQLException {
            String sql = "INSERT INTO Libros (Titulo, Autor, Genero, Anio, Precio) VALUES (?,?,?,?,?);";
            int rowCount=0;
            PreparedStatement pstm= Singleton.getInstance("Libros.db").getConnection().prepareStatement(sql);
            pstm.setString(1,((Libro)o).getTitulo());
            pstm.setString(2,((Libro)o).getAutor());
            pstm.setString(3,((Libro)o).getGenero());
            pstm.setInt(4,((Libro)o).getAnio());
            pstm.setDouble(5,((Libro)o).getPrecio());
            rowCount=pstm.executeUpdate();
            return rowCount>0;

        }
    
        @Override
        public boolean update(Object o) throws SQLException{
            String sql = "UPDATE Libros SET Titulo=?, Autor=?, Genero=?, Anio=?, Precio=?  WHERE id=?;";
            int rowCount=0;
            PreparedStatement pstm= Singleton.getInstance("Libros.db").getConnection().prepareStatement(sql);
            pstm.setString(1,((Libro)o).getTitulo());
            pstm.setString(2,((Libro)o).getAutor());
            pstm.setString(3,((Libro)o).getGenero());
            pstm.setInt(4,((Libro)o).getAnio());
            pstm.setDouble(5,((Libro)o).getPrecio());
            pstm.setInt(6,((Libro)o).getId());
            rowCount=pstm.executeUpdate();
            return rowCount>0;
        }
    
        @Override
        public boolean delete(String o) throws SQLException {
            String sql = "DELETE FROM Productos WHERE id=?;";
            int rowCount=0;
            PreparedStatement pstm= Singleton.getInstance("Libros.db").getConnection().prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(o));
            rowCount=pstm.executeUpdate();
            return rowCount>0;
        }
        public ArrayList obtenerTodo() throws SQLException {
            String sql = "SELECT * FROM Productos";
            ArrayList<Libro> libros=new ArrayList<>();
            PreparedStatement pstm= Singleton.getInstance("Libros.db").getConnection().prepareStatement(sql);
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                libros.add(new Libro(rs.getInt("id"),rs.getString("Titulo"),rs.getString("Autor"),rs.getString("Genero"),rs.getInt("Anio"),rs.getDouble("Precio")));
            }
            return libros;
        }
    
        @Override
        public Object buscarPorID(String id)  throws SQLException {
            String sql = "SELECT * FROM Libros WHERE id=?;";
            Libro libro=null;
            PreparedStatement pstm= Singleton.getInstance("Libros.db").getConnection().prepareStatement(sql);
            pstm.setString(1,id);
            ResultSet rs=pstm.executeQuery();
            while (rs.next()){
                libro=new Libro(rs.getInt("id"),rs.getString("Titulo"),rs.getString("Autor"),rs.getString("Genero"),rs.getInt("Anio"),rs.getDouble("Precio"));
                return libro;
            }
            return null;
        }
    
}
