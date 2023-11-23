package org.example.Vista;
import java.awt.*;
import javax.swing.*;

import org.example.Controlador.Productos;
import org.example.Controlador.TablaHashLibros;
import org.example.Modelo.Libro;
import org.example.Modelo.ModeloLibros;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Vista extends JFrame  implements ActionListener, ItemListener{
    private JMenuBar mb;
    private JMenu menuOpciones,menuAcercaDe,menuColorFondo;
    private JMenuItem miRojo,miNegro,miMorado,Original,miElCreador,miSalir,miNuevo;
    private JLabel labelLogo, labelBienvenido, labelinstruccion, labelcantidad, labeltipo,labelfooter, precio, labelCanComida, labelCanReposteria, labelTipoComida, labelTipoReposteria, labelprecio2, labelprecio3;
    private JButton sacarticket, guardar,borrar;
    private JComboBox comboproductos, comboComida, comboReposteria;
    private JTextField Libro1, Libro2, Libro3;
    private JScrollPane scrollpane1,scrollpane,scrollPane2, scrollPane3; 
    private JTextArea textarea,textarea1,textarea2, textarea3;
    private TablaHashLibros tablaHashLibros;
    private String temp="",nomAdmin="";
    private Productos productos = new Productos(); 
    private cobro ventanaPago;
    HashMap<String, Map<String, Double>> tabla = new HashMap<>();
    
    public Vista(String title) throws HeadlessException, SQLException{
        super(title);
        this.setLayout(null);
        this.setSize(650, 535);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0,35,53));
        setIconImage(new ImageIcon(getClass().getResource("images/ivono.png")).getImage());

        Inicio interfaz12=new Inicio();
        nomAdmin=interfaz12.text;
        
        mb = new JMenuBar();
        mb.setBackground(new Color(0,35,53));
        setJMenuBar(mb);

        menuOpciones = new JMenu("Opciones");
        menuOpciones.setBackground(new Color(0,35,53));
        menuOpciones.setFont(new Font("Andale Mono", 1, 14));
        menuOpciones.setForeground(new Color(255, 255, 255));
        mb.add(menuOpciones);

        menuAcercaDe = new JMenu("Acerca de");
        menuAcercaDe.setBackground(new Color(0,35,53));
        menuAcercaDe.setFont(new Font("Andale Mono", 1, 14));
        menuAcercaDe.setForeground(new Color(255, 255, 255));
        mb.add(menuAcercaDe);

        menuColorFondo = new JMenu("Color de fondo");
        menuColorFondo.setFont(new Font("Andale Mono", 1, 14));
        menuColorFondo.setForeground(new Color(0,35,53));
        menuOpciones.add(menuColorFondo);

        Original=new JMenuItem("Defecto");
        Original.setFont(new Font ("Andale Mono",1,14));
        Original.setForeground(new Color(0,35,53));
        menuColorFondo.add(Original);
        Original.addActionListener(this);
        

        miRojo = new JMenuItem("Rojo");
        miRojo.setFont(new Font("Andale Mono", 1, 14));
        miRojo.setForeground(new Color(0,35,53));
        menuColorFondo.add(miRojo);
        miRojo.addActionListener(this);
        

        miNegro = new JMenuItem("Negro");
        miNegro.setFont(new Font("Andale Mono", 1, 14));
        miNegro.setForeground(new Color(0,35,53));
        miNegro.addActionListener(this);
        menuColorFondo.add(miNegro);

        

        miMorado = new JMenuItem("Morado");
        miMorado.setFont(new Font("Andale Mono", 1, 14));
        miMorado.setForeground(new Color(0,35,53));
        menuColorFondo.add(miMorado);
        miMorado.addActionListener(this);
        

        miNuevo = new JMenuItem("Nuevo");
        miNuevo.setFont(new Font("Andale Mono", 1, 14));
        miNuevo.setForeground(new Color(0,35,53));
        menuOpciones.add(miNuevo);
        miNuevo.addActionListener(this);
        

        miElCreador = new JMenuItem("El creador");
        miElCreador.setFont(new Font("Andale Mono", 1, 14));
        miElCreador.setForeground(new Color(0,35,53));
        menuAcercaDe.add(miElCreador);
        miElCreador.addActionListener(this);

        miSalir = new JMenuItem("Salir");
        miSalir.setFont(new Font("Andale Mono", 1, 14));
        miSalir.setForeground(new Color(0,35,53));
        menuOpciones.add(miSalir);
        miSalir.addActionListener(this);
        

        ImageIcon imagen = new ImageIcon(getClass().getResource("images/logo3.png"));
        labelLogo = new JLabel(imagen);  
        labelLogo.setBounds(5,5,250,100);
        add(labelLogo);

            
        labelBienvenido = new JLabel("Bienvenido "+nomAdmin);  
        labelBienvenido.setBounds(250,30,400,50);
        labelBienvenido.setFont(new Font("Andale Mono", 1, 32));
        labelBienvenido.setForeground(new Color(255, 255, 255));
        add(labelBienvenido);

        labelinstruccion = new JLabel("Datos de la cantidad de productos vendidos");
        labelinstruccion.setBounds(65,100,500,25);
        labelinstruccion.setFont(new Font("Andale Mono", 0, 24));
        labelinstruccion.setForeground(new Color(255, 255, 255));
        add(labelinstruccion);


        labelcantidad = new JLabel("Titulo del libro:");
        labelcantidad.setBounds(25,135,180,25);
        labelcantidad.setFont(new Font("Andale Mono", 1, 12));
        labelcantidad.setForeground(new Color(255, 255, 255));
        add(labelcantidad);

        Libro1 = new JTextField();
        Libro1.setBounds(25,160,150,25);
        Libro1.setBackground(new java.awt.Color(224, 224, 224));
        Libro1.setFont(new java.awt.Font("Andale Mono", 1, 14));
        Libro1.setForeground(new java.awt.Color(0,35,53));
        Libro1.addActionListener(this);
        add(Libro1);

        labelCanComida=new JLabel("titulo del libro: ");
        labelCanComida.setBounds(25,200,180,25);
        labelCanComida.setFont(new Font("Andale Mono", 1, 12));
        labelCanComida.setForeground(new Color(255, 255, 255));
        add(labelCanComida);

        Libro2= new JTextField();
        Libro2.setBounds(25,225,150,25);
        Libro2.setBackground(new java.awt.Color(224, 224, 224));
        Libro2.setFont(new java.awt.Font("Andale Mono", 1, 14));
        Libro2.setForeground(new java.awt.Color(0,35,53));
        Libro2.addActionListener(this);
        add(Libro2);

        labelCanReposteria=new JLabel("titulo del libro: ");
        labelCanReposteria.setBounds(25,265,180,25);
        labelCanReposteria.setFont(new Font("Andale Mono", 1, 12));
        labelCanReposteria.setForeground(new Color(255, 255, 255));
        add(labelCanReposteria);

        Libro3= new JTextField();
        Libro3.setBounds(25,290,150,25);
        Libro3.setBackground(new java.awt.Color(224, 224, 224));
        Libro3.setFont(new java.awt.Font("Andale Mono", 1, 14));
        Libro3.setForeground(new java.awt.Color(0,35,53));
        Libro3.addActionListener(this);
        add(Libro3);

        labeltipo = new JLabel("Titulo: ");
        labeltipo.setBounds(220,135,180,25);
        labeltipo.setFont(new Font("Andale Mono", 1, 12));
        labeltipo.setForeground(new Color(255, 255, 255));
        add(labeltipo);

        comboproductos = new JComboBox();
        comboproductos.setBounds(220,160,220,25);
        comboproductos.setBackground(new java.awt.Color(224, 224, 224));
        comboproductos.setFont(new java.awt.Font("Andale Mono", 1, 14));
        comboproductos.setForeground(new java.awt.Color(0,35,53));
        add(comboproductos);
        comboproductos.addItem("");

        labelTipoComida = new JLabel("Titulo: ");
        labelTipoComida.setBounds(220,200,180,25);
        labelTipoComida.setFont(new Font("Andale Mono", 1, 12));
        labelTipoComida.setForeground(new Color(255, 255, 255));
        add(labelTipoComida);

        comboComida = new JComboBox();
        comboComida.setBounds(220,225,220,25);
        comboComida.setBackground(new java.awt.Color(224, 224, 224));
        comboComida.setFont(new java.awt.Font("Andale Mono", 1, 14));
        comboComida.setForeground(new java.awt.Color(0,35,53));
        add(comboComida);
        
        comboComida.addItem("");

        labelTipoReposteria = new JLabel("titulo: ");
        labelTipoReposteria.setBounds(220,265,200,25);
        labelTipoReposteria.setFont(new Font("Andale Mono", 1, 12));
        labelTipoReposteria.setForeground(new Color(255, 255, 255));
        add(labelTipoReposteria);

        comboReposteria = new JComboBox();
        comboReposteria.setBounds(220,290,220,25);
        comboReposteria.setBackground(new java.awt.Color(224, 224, 224));
        comboReposteria.setFont(new java.awt.Font("Andale Mono", 1, 14));
        comboReposteria.setForeground(new java.awt.Color(0,35,53));
        add(comboReposteria);
        comboReposteria.addItem("");

        precio=new JLabel("Precio: ");
        precio.setBounds(485,135,100,25);
        precio.setFont(new Font("Andale Mono", 1, 12));
        precio.setForeground(new Color(255, 255, 255));
        add(precio);

        textarea = new JTextArea();
        textarea.setEditable(false);
        textarea.setBackground(new Color(224, 224, 224));
        textarea.setFont(new Font("Andale Mono", 1, 14));
        textarea.setForeground(new Color(0, 143, 57));
        scrollpane1 = new JScrollPane(textarea);
        scrollpane1.setBounds(485,160,110,25);
        add(scrollpane1); 

        labelprecio2=new JLabel("Precio: ");
        labelprecio2.setBounds(485,200,100,25);
        labelprecio2.setFont(new Font("Andale Mono", 1, 12));
        labelprecio2.setForeground(new Color(255, 255, 255));
        add(labelprecio2);

        textarea1 = new JTextArea();
        textarea1.setEditable(false);
        textarea1.setBackground(new Color(224, 224, 224));
        textarea1.setFont(new Font("Andale Mono", 1, 14));
        textarea1.setForeground(new Color(0, 143, 57));
        scrollpane = new JScrollPane(textarea1);
        scrollpane.setBounds(485,225,110,25);
        add(scrollpane); 

        labelprecio2=new JLabel("Precio: ");
        labelprecio2.setBounds(485,265,100,25);
        labelprecio2.setFont(new Font("Andale Mono", 1, 12));
        labelprecio2.setForeground(new Color(255, 255, 255));
        add(labelprecio2);

        textarea2 = new JTextArea();
        textarea2.setEditable(false);
        textarea2.setBackground(new Color(224, 224, 224));
        textarea2.setFont(new Font("Andale Mono", 1, 14));
        scrollPane2 = new JScrollPane(textarea2);
        scrollPane2.setBounds(485,290,110,25);
        textarea2.setForeground(new Color(0, 143, 57));
        add(scrollPane2); 
        
        textarea3=new JTextArea();
        textarea3.setEditable(false);
        textarea3.setBackground(new Color(224, 224, 224));
        textarea3.setFont(new Font("Andale Mono", 1, 14));
        scrollPane3 = new JScrollPane(textarea3);
        scrollPane3.setBounds(25,375,570,60);
        textarea3.setForeground(new Color(0,0,0));
        textarea3.setText("Aqui apareceran los productos vendidos");
        add(scrollPane3); 

        labelfooter = new JLabel("@2022 The WAPYJ Company | Todos los derechos reservados");
        labelfooter.setBounds(135,440,500,30);
        labelfooter.setFont(new java.awt.Font("Andale Mono", 1, 12));
        labelfooter.setForeground(new java.awt.Color(255, 255, 255));
        add(labelfooter);

        guardar =new JButton("Guardar");
        guardar.setBounds(50,330,100,30);
        guardar.setBackground(new Color(255,255,255));
        guardar.setFont(new Font("Andale Mono", 1, 14));
        guardar.setForeground(new Color(0,35,53));
        guardar.addActionListener(this);
        guardar.setEnabled(false);
        add(guardar);

        sacarticket=new JButton("Cobrar");
        sacarticket.setBounds(255,330,150,30);
        sacarticket.setBackground(new Color(255,255,255));
        sacarticket.setFont(new Font("Andale Mono", 1, 14));
        sacarticket.setForeground(new Color(0,35,53));
        sacarticket.addActionListener(this);
        sacarticket.setEnabled(false);
        add(sacarticket);

        borrar=new JButton("Borrar");
        borrar.setBounds(485,330,110,30);
        borrar.setBackground(new Color(255,255,255));
        borrar.setFont(new Font("Andale Mono", 1, 14));
        borrar.setForeground(new Color(0,35,53));
        borrar.addActionListener(this);
        add(borrar);

        this.tablaHashLibros = new TablaHashLibros();


        // Obtener todos los libros de la base de datos
        ModeloLibros modeloLibros = new ModeloLibros();
        modeloLibros.CargarDatos();

        // Agregar libros a la tabla hash
        for (Libro libro : modeloLibros.obtenerTodo()) {
            tablaHashLibros.agregarLibro(libro);
        }


        comboproductos.addItemListener(this);
        comboComida.addItemListener(this);
        comboReposteria.addItemListener(this);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            Vista vista = new Vista("Ventana principal");
            vista.setResizable(false);
            vista.setLocationRelativeTo(null);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    public JMenuBar getMb() {
        return mb;
    }

    public void setMb(JMenuBar mb) {
        this.mb = mb;
    }

    public JMenu getMenuOpciones() {
        return menuOpciones;
    }

    public void setMenuOpciones(JMenu menuOpciones) {
        this.menuOpciones = menuOpciones;
    }

    public JMenu getMenuAcercaDe() {
        return menuAcercaDe;
    }

    public void setMenuAcercaDe(JMenu menuAcercaDe) {
        this.menuAcercaDe = menuAcercaDe;
    }

    public JMenu getMenuColorFondo() {
        return menuColorFondo;
    }

    public void setMenuColorFondo(JMenu menuColorFondo) {
        this.menuColorFondo = menuColorFondo;
    }

    public JMenuItem getMiRojo() {
        return miRojo;
    }

    public void setMiRojo(JMenuItem miRojo) {
        this.miRojo = miRojo;
    }

    public JMenuItem getMiNegro() {
        return miNegro;
    }

    public void setMiNegro(JMenuItem miNegro) {
        this.miNegro = miNegro;
    }

    public JMenuItem getMiMorado() {
        return miMorado;
    }

    public void setMiMorado(JMenuItem miMorado) {
        this.miMorado = miMorado;
    }

    public JMenuItem getOriginal() {
        return Original;
    }

    public void setOriginal(JMenuItem original) {
        Original = original;
    }

    public JMenuItem getMiElCreador() {
        return miElCreador;
    }

    public void setMiElCreador(JMenuItem miElCreador) {
        this.miElCreador = miElCreador;
    }

    public JMenuItem getMiSalir() {
        return miSalir;
    }

    public void setMiSalir(JMenuItem miSalir) {
        this.miSalir = miSalir;
    }

    public JMenuItem getMiNuevo() {
        return miNuevo;
    }

    public void setMiNuevo(JMenuItem miNuevo) {
        this.miNuevo = miNuevo;
    }

    public JLabel getLabelLogo() {
        return labelLogo;
    }

    public void setLabelLogo(JLabel labelLogo) {
        this.labelLogo = labelLogo;
    }

    public JLabel getLabelBienvenido() {
        return labelBienvenido;
    }

    public void setLabelBienvenido(JLabel labelBienvenido) {
        this.labelBienvenido = labelBienvenido;
    }

    public JLabel getLabelinstruccion() {
        return labelinstruccion;
    }

    public void setLabelinstruccion(JLabel labelinstruccion) {
        this.labelinstruccion = labelinstruccion;
    }

    public JLabel getLabelcantidad() {
        return labelcantidad;
    }

    public void setLabelcantidad(JLabel labelcantidad) {
        this.labelcantidad = labelcantidad;
    }

    public JLabel getLabeltipo() {
        return labeltipo;
    }

    public void setLabeltipo(JLabel labeltipo) {
        this.labeltipo = labeltipo;
    }

    public JLabel getLabelfooter() {
        return labelfooter;
    }

    public void setLabelfooter(JLabel labelfooter) {
        this.labelfooter = labelfooter;
    }

    public JLabel getPrecio() {
        return precio;
    }

    public void setPrecio(JLabel precio) {
        this.precio = precio;
    }

    public JLabel getLabelCanComida() {
        return labelCanComida;
    }

    public void setLabelCanComida(JLabel labelCanComida) {
        this.labelCanComida = labelCanComida;
    }

    public JLabel getLabelCanReposteria() {
        return labelCanReposteria;
    }

    public void setLabelCanReposteria(JLabel labelCanReposteria) {
        this.labelCanReposteria = labelCanReposteria;
    }

    public JLabel getLabelTipoComida() {
        return labelTipoComida;
    }

    public void setLabelTipoComida(JLabel labelTipoComida) {
        this.labelTipoComida = labelTipoComida;
    }

    public JLabel getLabelTipoReposteria() {
        return labelTipoReposteria;
    }

    public void setLabelTipoReposteria(JLabel labelTipoReposteria) {
        this.labelTipoReposteria = labelTipoReposteria;
    }

    public JLabel getLabelprecio2() {
        return labelprecio2;
    }

    public void setLabelprecio2(JLabel labelprecio2) {
        this.labelprecio2 = labelprecio2;
    }

    public JLabel getLabelprecio3() {
        return labelprecio3;
    }

    public void setLabelprecio3(JLabel labelprecio3) {
        this.labelprecio3 = labelprecio3;
    }

    public JButton getSacarticket() {
        return sacarticket;
    }

    public void setSacarticket(JButton sacarticket) {
        this.sacarticket = sacarticket;
    }

    public JButton getGuardar() {
        return guardar;
    }

    public void setGuardar(JButton guardar) {
        this.guardar = guardar;
    }

    public JButton getBorrar() {
        return borrar;
    }

    public void setBorrar(JButton borrar) {
        this.borrar = borrar;
    }

    public JComboBox getComboproductos() {
        return comboproductos;
    }

    public void setComboproductos(JComboBox comboproductos) {
        this.comboproductos = comboproductos;
    }

    public JComboBox getComboComida() {
        return comboComida;
    }

    public void setComboComida(JComboBox comboComida) {
        this.comboComida = comboComida;
    }

    public JComboBox getComboReposteria() {
        return comboReposteria;
    }

    public void setComboReposteria(JComboBox comboReposteria) {
        this.comboReposteria = comboReposteria;
    }

    public JTextField getLibro1() {
        return Libro1;
    }

    public void setLibro1(JTextField libro1) {
        Libro1 = libro1;
    }

    public JTextField getLibro2() {
        return Libro2;
    }

    public void setLibro2(JTextField libro2) {
        Libro2 = libro2;
    }

    public JTextField getLibro3() {
        return Libro3;
    }

    public void setLibro3(JTextField libro3) {
        Libro3 = libro3;
    }

    public JScrollPane getScrollpane1() {
        return scrollpane1;
    }

    public void setScrollpane1(JScrollPane scrollpane1) {
        this.scrollpane1 = scrollpane1;
    }

    public JScrollPane getScrollpane() {
        return scrollpane;
    }

    public void setScrollpane(JScrollPane scrollpane) {
        this.scrollpane = scrollpane;
    }

    public JScrollPane getScrollPane2() {
        return scrollPane2;
    }

    public void setScrollPane2(JScrollPane scrollPane2) {
        this.scrollPane2 = scrollPane2;
    }

    public JScrollPane getScrollPane3() {
        return scrollPane3;
    }

    public void setScrollPane3(JScrollPane scrollPane3) {
        this.scrollPane3 = scrollPane3;
    }

    public JTextArea getTextarea() {
        return textarea;
    }

    public void setTextarea(JTextArea textarea) {
        this.textarea = textarea;
    }

    public JTextArea getTextarea1() {
        return textarea1;
    }

    public void setTextarea1(JTextArea textarea1) {
        this.textarea1 = textarea1;
    }

    public JTextArea getTextarea2() {
        return textarea2;
    }

    public void setTextarea2(JTextArea textarea2) {
        this.textarea2 = textarea2;
    }

    public JTextArea getTextarea3() {
        return textarea3;
    }

    public void setTextarea3(JTextArea textarea3) {
        this.textarea3 = textarea3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Libro1) {
            // Obtener el texto ingresado en el JTextField correspondiente
            String textoLibro = ((JTextField) e.getSource()).getText();

            // Limpiar y luego agregar los elementos al JComboBox
            comboproductos.removeAllItems();

            // Buscar los posibles resultados y agregarlos al JComboBox
            for (Libro libro : tablaHashLibros.buscarLibroPorTitulo(textoLibro)) {
                comboproductos.addItem(libro.getTitulo());
            }
            revalidate();
            repaint();
            
            

            Libro1.setText("");
            
        }else if (e.getSource() == Libro2) {
            // Obtener el texto ingresado en el JTextField correspondiente
            String textoLibro = ((JTextField) e.getSource()).getText();

            // Limpiar y luego agregar los elementos al JComboBox
            comboComida.removeAllItems();

            // Buscar los posibles resultados y agregarlos al JComboBox
            for (Libro libro : tablaHashLibros.buscarLibroPorTitulo(textoLibro)) {
                comboComida.addItem(libro.getTitulo());
            }
            revalidate();
            repaint();
            Libro2.setText("");
        } else if(e.getSource()==Libro3){
            String textoLibro = ((JTextField) e.getSource()).getText();

            // Limpiar y luego agregar los elementos al JComboBox
            comboReposteria.removeAllItems();

            // Buscar los posibles resultados y agregarlos al JComboBox
            for (Libro libro : tablaHashLibros.buscarLibroPorTitulo(textoLibro)) {
                comboReposteria.addItem(libro.getTitulo());
            }
            revalidate();
            repaint();
            Libro3.setText("");
        } else if (e.getSource() == borrar) {
            tablaHashLibros.imprimirTabla();
        }

        if (e.getSource() == miRojo){
            getContentPane().setBackground(new Color(255,0,0));
        }
        if (e.getSource() == miNegro){
            getContentPane().setBackground(new Color(0,0,0));
        }
    	if (e.getSource() == miMorado){
            getContentPane().setBackground(new Color(51,0,51));
        }
        if (e.getSource() == Original){
            getContentPane().setBackground(new Color(0,35,53));
        }
        if (e.getSource() == miElCreador){
            JOptionPane.showMessageDialog(null, "Desarrollado por WAPYJ \n        www.wapyj.com");
        }
        if (e.getSource() == miSalir){
            Inicio interfaz11 = new Inicio();
         interfaz11.setBounds(0,0,350,450);
         interfaz11.setVisible(true);
         interfaz11.setResizable(false);
         interfaz11.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        if (e.getSource() == miNuevo){
            Libro1.setText("");
            Libro2.setText("");
            Libro3.setText("");
            comboproductos.setSelectedIndex(0);
            comboComida.setSelectedIndex(0);
            comboReposteria.setSelectedIndex(0);
            textarea.setText("");
            textarea1.setText("");
            textarea2.setText("");
            textarea3.setText("Aqui apareceran los productos vendidos");
        }
        if (e.getSource() == guardar) {
            boolean alMenosUnCasoExitoso = false;
            
            if (comboproductos.getSelectedItem() != null && comboproductos.getSelectedItem().toString() != "") {
                if (comboproductos.getSelectedItem().toString() != "") {
                    if (Libro1.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos");
                    } else {
                        try {
                            double precio = Double.parseDouble(textarea.getText());
                            int cantidad = Integer.parseInt(Libro1.getText());
            
                            String titulo = comboproductos.getSelectedItem().toString();
            
                            // Verificar si el título ya está en la tabla
                            if (tabla.containsKey(titulo)) {
                                // Si está, actualiza la cantidad
                                double cantidadExistente = tabla.get(titulo).get("cantidad");
                                cantidad += cantidadExistente;
                            }
            
                            productos.agregarLibro(tabla, titulo, precio, cantidad);
                            temp += titulo + ". Vendidos: " + Libro1.getText() + "\n";
                            sacarticket.setEnabled(true);
                            alMenosUnCasoExitoso = true;
                            productos.imprimirTabla(tabla);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "El precio o la cantidad deben ser números válidos");
                            
                            System.out.println("Texto en Libro1: " + Libro1.getText());
                        }
                    }
                }
            }
        
            if (comboComida.getSelectedItem() != null && comboComida.getSelectedItem().toString() != "") {
                if (comboComida.getSelectedItem().toString() != "") {
                    if (Libro2.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos");
                    } else {
                        try {
                            double precio = Double.parseDouble(textarea1.getText());
                            int cantidad = Integer.parseInt(Libro2.getText());
            
                            String titulo = comboComida.getSelectedItem().toString();
            
                            // Verificar si el título ya está en la tabla
                            if (tabla.containsKey(titulo)) {
                                // Si está, actualiza la cantidad
                                double cantidadExistente = tabla.get(titulo).get("cantidad");
                                cantidad += cantidadExistente;
                            }
            
                            productos.agregarLibro(tabla, titulo, precio, cantidad);
                            temp += titulo + ". Vendidos: " + Libro2.getText() + "\n";
                            sacarticket.setEnabled(true);
                            alMenosUnCasoExitoso = true;
                            productos.imprimirTabla(tabla);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "El precio o la cantidad deben ser números válidos");
                            
                            System.out.println("Texto en Libro2: " + Libro2.getText());
                        }
                    }
                }
            }
        
            if (comboReposteria.getSelectedItem() != null && comboReposteria.getSelectedItem().toString() != "") {
                if (comboReposteria.getSelectedItem().toString() != "") {
                    if (Libro3.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos");
                    } else {
                        try {
                            double precio = Double.parseDouble(textarea2.getText());
                            int cantidad = Integer.parseInt(Libro3.getText());
            
                            String titulo = comboReposteria.getSelectedItem().toString();
            
                            // Verificar si el título ya está en la tabla
                            if (tabla.containsKey(titulo)) {
                                // Si está, actualiza la cantidad
                                double cantidadExistente = tabla.get(titulo).get("cantidad");
                                cantidad += cantidadExistente;
                            }
            
                            productos.agregarLibro(tabla, titulo, precio, cantidad);
                            temp += titulo + ". Vendidos: " + Libro3.getText() + "\n";
                            sacarticket.setEnabled(true);
                            alMenosUnCasoExitoso = true;
                            productos.imprimirTabla(tabla);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "El precio o la cantidad deben ser números válidos");
                            
                            System.out.println("Texto en Libro3: " + Libro3.getText());
                        }
                    }
                }
            }
        
            // Si al menos un caso fue exitoso, llama a Limpiar2
            if (alMenosUnCasoExitoso) {
                Limpiar2();
            }
        }
        if (e.getSource()==borrar) {
            
        }
        if (e.getSource() == sacarticket) {
            // Verifica si la ventana de pago ya está creada
            if (ventanaPago == null || !ventanaPago.isVisible()) {
                // Si no existe o no es visible, crea una nueva instancia de la ventana de pago
                ventanaPago = new cobro(tabla);
                ventanaPago.setBounds(400, 150, 300, 220);
                ventanaPago.setResizable(false);
            }

            // Actualiza el campo total
            ventanaPago.actualizarCampoTotal();

            // Hace visible la ventana de pago
            ventanaPago.setVisible(true);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==comboproductos) {
            
            // Obtener el elemento seleccionado en el JComboBox
            Object itemSeleccionado = comboproductos.getSelectedItem();

            // Verificar si el elemento seleccionado no es nulo
            if (itemSeleccionado != null) {
                // Convertir el elemento a String si es necesario
                String tituloSeleccionado = itemSeleccionado.toString();

                // Buscar el libro correspondiente en la tabla hash
                Libro libroSeleccionado = tablaHashLibros.buscarLibroPorTitulo(tituloSeleccionado).stream().findFirst().orElse(null);

                // Si se encuentra el libro, mostrar su precio en el JTextArea
                if (libroSeleccionado != null) {
                    textarea.setText(String.valueOf(libroSeleccionado.getPrecio()));
                } else {
                    textarea.setText("Libro no encontrado");
                }
            }

            labelcantidad.setText("Cantidad: ");
            Libro1.setBounds(25,160,50,25);
            
            comboproductos.setBounds(120,160,320,25);
        }
        if (e.getSource()==comboComida) {
            
            // Obtener el elemento seleccionado en el JComboBox
            Object itemSeleccionado = comboComida.getSelectedItem();

            // Verificar si el elemento seleccionado no es nulo
            if (itemSeleccionado != null) {
                // Convertir el elemento a String si es necesario
                String tituloSeleccionado = itemSeleccionado.toString();

                // Buscar el libro correspondiente en la tabla hash
                Libro libroSeleccionado = tablaHashLibros.buscarLibroPorTitulo(tituloSeleccionado).stream().findFirst().orElse(null);

                // Si se encuentra el libro, mostrar su precio en el JTextArea
                if (libroSeleccionado != null) {
                    textarea1.setText(String.valueOf(libroSeleccionado.getPrecio()));
                } else {
                    textarea1.setText("Libro no encontrado");
                }
            }
            labelCanComida.setText("Cantidad: ");
            Libro2.setBounds(25,225,50,25);
            comboComida.setBounds(120,225,320,25);

        }
        if (e.getSource()==comboReposteria) {
            
            // Obtener el elemento seleccionado en el JComboBox
            Object itemSeleccionado = comboReposteria.getSelectedItem();

            // Verificar si el elemento seleccionado no es nulo
            if (itemSeleccionado != null) {
                // Convertir el elemento a String si es necesario
                String tituloSeleccionado = itemSeleccionado.toString();

                // Buscar el libro correspondiente en la tabla hash
                Libro libroSeleccionado = tablaHashLibros.buscarLibroPorTitulo(tituloSeleccionado).stream().findFirst().orElse(null);

                // Si se encuentra el libro, mostrar su precio en el JTextArea
                if (libroSeleccionado != null) {
                    textarea2.setText(String.valueOf(libroSeleccionado.getPrecio()));
                } else {
                    textarea2.setText("Libro no encontrado");
                }
            }
            labelCanReposteria.setText("Cantidad: ");
            Libro3.setBounds(25,290,50,25);
            comboReposteria.setBounds(120,290,320,25);
        }

        
        
        guardar.setEnabled(true);
    }

    public void Limpiar2(){
            textarea3.setText(temp);
            comboproductos.removeAllItems();
            comboComida.removeAllItems();
            comboReposteria.removeAllItems();
            Libro1.setText("");
            Libro2.setText("");
            Libro3.setText("");
            textarea.setText("");
            textarea1.setText("");
            textarea2.setText("");
            labelcantidad.setText("Titulo del libro: ");
            labelCanComida.setText("Titulo del libro: ");
            labelCanReposteria.setText("Titulo del libro: ");
            Libro1.setBounds(25,160,150,25);
            Libro2.setBounds(25,225,150,25);
            Libro3.setBounds(25,290,150,25);
            guardar.setEnabled(false);
            comboproductos.setBounds(220,160,220,25);
            comboComida.setBounds(220,225,220,25);
            comboReposteria.setBounds(220,290,220,25);
    }

}

