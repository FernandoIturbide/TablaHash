package org.example.Modelo;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;


public class Modelos implements ComboBoxModel<String> {
    private ArrayList<String> titulosLibros;
    private String selected;

    public Modelos(ArrayList<String> titulosLibros) {
        this.titulosLibros = titulosLibros;
    }

    @Override
    public void setSelectedItem(Object o) {
        this.selected = (String) o;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }

    @Override
    public int getSize() {
        return titulosLibros.size();
    }

    @Override
    public String getElementAt(int index) {
        return titulosLibros.get(index);
    }

    @Override

    public void addListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addListDataListener'");
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeListDataListener'");
    }
}

