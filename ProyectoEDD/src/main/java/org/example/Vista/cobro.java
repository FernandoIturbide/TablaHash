package org.example.Vista;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
public class cobro extends JFrame implements ActionListener, ChangeListener{
    private JRadioButton trjeta, efectivo;
    private ButtonGroup group1;
    private JButton cancelar, siguiente;
    private JLabel titulo, metodoPago,dineroIng,fecha,CVC;
    private JTextArea aTextArea;
    private JScrollPane scrollPane23;
    private JTextField jTextField1,fechaField,CVCField;
    private boolean isEfectivo = false;
    double ToPagar=0, dinero=0;
    String ToPagar1="";
    private HashMap<String, Map<String, Double>> tablaProductos;

    
    
    public cobro(HashMap<String, Map<String, Double>> tablaProductos){
        this.tablaProductos = tablaProductos;
        setLayout(null);

        setTitle("Pago");
        getContentPane().setBackground(new Color(0,35,53));
        setIconImage(new ImageIcon(getClass().getResource("images/ivono.png")).getImage());
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        

        group1=new ButtonGroup();
        titulo =new JLabel("Total: ");
        titulo.setBounds(20,5,100,30);
        titulo.setFont(new Font("Andale Mono", 1, 18));
        titulo.setForeground(new Color(255, 255, 255));
        add(titulo);
        
        aTextArea=new JTextArea("");
        aTextArea.setEditable(false);
        aTextArea.setBackground(new Color(224, 224, 224));
        aTextArea.setFont(new Font("Andale Mono", 1, 18));
        aTextArea.setForeground(new Color(0, 143, 57));
        aTextArea.setText(ToPagar1);
        scrollPane23 = new JScrollPane(aTextArea);
        scrollPane23.setBounds(130,5,130,30);
        add(scrollPane23);
        

        metodoPago =new JLabel("Elige el metodo de pago: ");
        metodoPago.setBounds(20,35,300,30);
        metodoPago.setFont(new Font("Andale Mono", 1, 18));
        metodoPago.setForeground(new Color(255, 255, 255));
        add(metodoPago);

        trjeta = new JRadioButton("Tarjeta de credito");
        trjeta.setBounds(20,75,245,30);
        trjeta.addChangeListener(this);
        add(trjeta);
        group1.add(trjeta);

        efectivo=new JRadioButton("Efectivo");
        efectivo.setBounds(20, 115, 245, 30);
        efectivo.addChangeListener(this);
        add(efectivo);
        group1.add(efectivo);

        siguiente=new JButton("Siguiente");
        siguiente.setBounds(180, 310,120,30);
        siguiente.addActionListener(this);
        siguiente.setVisible(false);
        add(siguiente);

        dineroIng=new JLabel("Ingrese el dinero: ");
        dineroIng.setBounds(40,190,300,30);
        dineroIng.setFont(new Font("Andale Mono", 1, 18));
        dineroIng.setForeground(new Color(255, 255, 255));
        dineroIng.setVisible(false);
        add(dineroIng);

        jTextField1=new JTextField();
        jTextField1.setBounds(140,180,200,40);
        jTextField1.setBackground(new Color(224, 224, 224));
        jTextField1.setFont(new Font("Andale Mono", 1, 18));
        jTextField1.setForeground(new Color(0, 143, 57));
        jTextField1.setVisible(true);
        add(jTextField1);

        fecha=new JLabel("Fecha de expiración: ");
        fecha.setBounds(40,240,300,30);
        fecha.setFont(new Font("Andale Mono", 1, 18));
        fecha.setForeground(new Color(255, 255, 255));
        fecha.setVisible(false);
        add(fecha);

        fechaField=new JTextField();
        fechaField.setBounds(240,240,200,40);
        fechaField.setBackground(new Color(224, 224, 224));
        fechaField.setFont(new Font("Andale Mono", 1, 18));
        fechaField.setForeground(new Color(0, 143, 57));
        fechaField.setVisible(false);
        add(fechaField);

        CVC=new JLabel("CVC: ");
        CVC.setBounds(40,290,300,30);
        CVC.setFont(new Font("Andale Mono", 1, 18));
        CVC.setForeground(new Color(255, 255, 255));
        CVC.setVisible(false);
        add(CVC);

        CVCField=new JTextField();
        CVCField.setBounds(140,290,200,40);
        CVCField.setBackground(new Color(224, 224, 224));
        CVCField.setFont(new Font("Andale Mono", 1, 18));
        CVCField.setForeground(new Color(0, 143, 57));
        CVCField.setVisible(false);
        add(CVCField);


    }
    public void stateChanged(ChangeEvent e) { 
        if(efectivo.isSelected()){
            setSize(500,400);
            efectivo.setBounds(20, 115, 445, 30);
            trjeta.setBounds(20,75,445,30);
            siguiente.setVisible(true);
            scrollPane23.setBounds(330,5,130,30);
            jTextField1.setBounds(230,180,200,40);
            siguiente.setBounds(180, 310,120,30);
            dineroIng.setVisible(true);
            dineroIng.setText("Ingrese el dinero: ");
            isEfectivo = true;
            fecha.setVisible(false);
            fechaField.setVisible(false);
            CVC.setVisible(false);
            CVCField.setVisible(false);
            jTextField1.setText("");
        }
        if (trjeta.isSelected()){
            setSize(600,500);
            trjeta.setBounds(20,75,545,30);
            efectivo.setBounds(20, 115, 545, 30);
            scrollPane23.setBounds(410,5,130,30);
            jTextField1.setBounds(350,180,200,40);
            siguiente.setBounds(240, 340, 120,30);
            siguiente.setVisible(true);
            dineroIng.setVisible(true);
            dineroIng.setText("Número de tarjeta:");
            jTextField1.setText("");
            fecha.setVisible(true);
            fechaField.setVisible(true);
            CVC.setVisible(true);
            CVCField.setVisible(true);
            isEfectivo = false;
        }
    }
    private double calcularPrecioTotal() {
        double precioTotal = 0;

        for (Map.Entry<String, Map<String, Double>> entry : tablaProductos.entrySet()) {
            double precioUnitario = entry.getValue().get("precio");
            double cantidad = entry.getValue().get("cantidad");

            precioTotal += precioUnitario * cantidad;
        }

        return precioTotal;
    }

    public void actualizarCampoTotal() {
        ToPagar = calcularPrecioTotal();
        aTextArea.setText(String.valueOf(ToPagar));
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelar) {
            this.setVisible(false);
            System.exit(0);
        }
        if (e.getSource() == siguiente) {
            if (isEfectivo) {
                if (jTextField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ingrese el dinero");
                } else {
                    if (Double.valueOf(jTextField1.getText()) < ToPagar) {
                        double debe = ToPagar - Double.valueOf(jTextField1.getText());
                        JOptionPane.showMessageDialog(null, "Dinero insuficiente, debe: " + debe);
                    } else {
                        // Puedes realizar acciones adicionales después de completar el pago
                        JOptionPane.showMessageDialog(null, "Pago en efectivo realizado con éxito");
                        
                        this.setVisible(false);
                    }
                }
            } else { // Pago con tarjeta
                // Validar el número de tarjeta
                String numeroTarjeta = jTextField1.getText();
                if (numeroTarjeta.length() != 16 || !esNumero(numeroTarjeta)) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número de tarjeta válido de 16 dígitos");
                    return; // Salir del método si la tarjeta no es válida
                }
    
                // Validar la fecha de expiración
                String fechaExpiracion = fechaField.getText();
                if (!esFechaValida(fechaExpiracion)) {
                    JOptionPane.showMessageDialog(null, "Ingrese una fecha de expiración válida (MM/YY)");
                    return; // Salir del método si la fecha no es válida
                }
    
                // Validar el CVC
                String cvc = CVCField.getText();
                if (cvc.length() != 3 || !esNumero(cvc)) {
                    JOptionPane.showMessageDialog(null, "Ingrese un CVC válido de 3 dígitos");
                    return; // Salir del método si el CVC no es válido
                }
    
                // Puedes realizar acciones adicionales después de validar la tarjeta
                JOptionPane.showMessageDialog(null, "Pago con tarjeta realizado con éxito");
                this.setVisible(false);
            }
        }
    }
    private boolean esNumero(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    // Método para verificar si una cadena tiene el formato de fecha MM/YY
    private boolean esFechaValida(String fecha) {
        return fecha.matches("\\d{2}/\\d{2}");
    }
}
