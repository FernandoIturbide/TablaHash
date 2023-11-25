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

public class Vista extends JFrame  implements ActionListener, ItemListener{ //Ventana principal, nolo gramos separar metodos y la vista 
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
    
    public Vista(String title) throws HeadlessException, SQLException{//Inicializacion de la ventana y sus elementos
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


        
        ModeloLibros modeloLibros = new ModeloLibros();//Carga los datos de la base de datos a la tabla hash
        modeloLibros.CargarDatos();

        for (Libro libro : modeloLibros.obtenerTodo()) {//Otra tabla hash
            tablaHashLibros.agregarLibro(libro);
        }


        comboproductos.addItemListener(this);
        comboComida.addItemListener(this);
        comboReposteria.addItemListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Libro1) {
            String textoLibro = ((JTextField) e.getSource()).getText();
            comboproductos.removeAllItems();
            for (Libro libro : tablaHashLibros.buscarLibroPorTitulo(textoLibro)) {
                comboproductos.addItem(libro.getTitulo());
            }
            revalidate();
            repaint();
            //Se da enter, se utiliza el metodo buscarLibroPorTitulo de la tabla hash y se agregan los libros al combobox si tienen las palabras iguales o similares.
            

            Libro1.setText("");
            
        }else if (e.getSource() == Libro2) {
            String textoLibro = ((JTextField) e.getSource()).getText();
            comboComida.removeAllItems();
            for (Libro libro : tablaHashLibros.buscarLibroPorTitulo(textoLibro)) {
                comboComida.addItem(libro.getTitulo());
            }
            revalidate();
            repaint();
            Libro2.setText("");
        } else if(e.getSource()==Libro3){
            String textoLibro = ((JTextField) e.getSource()).getText();
            comboReposteria.removeAllItems();
            for (Libro libro : tablaHashLibros.buscarLibroPorTitulo(textoLibro)) {
                comboReposteria.addItem(libro.getTitulo());
            }
            revalidate();
            repaint();
            Libro3.setText("");
        } else if (e.getSource() == borrar) {
            tablaHashLibros.imprimirTabla(); //Prueba de impresion de tabla, botón sin función util
        }
 //Colores de fondo
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
        if (e.getSource() == miElCreador){//Creador
            JOptionPane.showMessageDialog(null, "Desarrollado por WAPYJ \n        www.wapyj.com");
        }
        if (e.getSource() == miSalir){//Inicio
            Inicio interfaz11 = new Inicio();
         interfaz11.setBounds(0,0,350,450);
         interfaz11.setVisible(true);
         interfaz11.setResizable(false);
         interfaz11.setLocationRelativeTo(null);
            this.setVisible(false);
        }//No funciona
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
                        JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos"); //EN caso de que no se llene el campo de cantidad del JCombo mBox correspondiente
                    } else {
                        try {
                            double precio = Double.parseDouble(textarea.getText());
                            int cantidad = Integer.parseInt(Libro1.getText()); //Se extraen los datos 
                            String titulo = comboproductos.getSelectedItem().toString();
                            if (tabla.containsKey(titulo)) {
                                double cantidadExistente = tabla.get(titulo).get("cantidad");
                                cantidad += cantidadExistente; //Se suma la cantidad existente con la nueva cantidad
                            }
            
                            productos.agregarLibro(tabla, titulo, precio, cantidad); //SE agrega a la tabla hash productios
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
                            if (tabla.containsKey(titulo)) {
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
                            if (tabla.containsKey(titulo)) {
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
            if (alMenosUnCasoExitoso) {
                Limpiar2();
            }
        }
        if (e.getSource()==borrar) {
            
        }
        if (e.getSource() == sacarticket) {
            if (ventanaPago == null || !ventanaPago.isVisible()) {
                ventanaPago = new cobro(tabla);
                ventanaPago.setBounds(400, 150, 300, 220);
                ventanaPago.setResizable(false);
            }

            ventanaPago.actualizarCampoTotal();
            ventanaPago.setVisible(true); 
            //Abre la ventana de pago y realiza el pago, se hace el PDF y se limpian las areas.
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {//metodo para que al seleccionar un item del combobox se muestre el precio y se habilita el boton guardar, además de modificar el label de titulo del libro por cantidad de acuerdo al JComboBox seleccionado
        if (e.getSource()==comboproductos) {
            Object itemSeleccionado = comboproductos.getSelectedItem();
            if (itemSeleccionado != null) {
                String tituloSeleccionado = itemSeleccionado.toString();
                Libro libroSeleccionado = tablaHashLibros.buscarLibroPorTitulo(tituloSeleccionado).stream().findFirst().orElse(null);
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
            Object itemSeleccionado = comboComida.getSelectedItem();
            if (itemSeleccionado != null) {
                String tituloSeleccionado = itemSeleccionado.toString();
                Libro libroSeleccionado = tablaHashLibros.buscarLibroPorTitulo(tituloSeleccionado).stream().findFirst().orElse(null);
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
            Object itemSeleccionado = comboReposteria.getSelectedItem();
            if (itemSeleccionado != null) {
                String tituloSeleccionado = itemSeleccionado.toString();
                Libro libroSeleccionado = tablaHashLibros.buscarLibroPorTitulo(tituloSeleccionado).stream().findFirst().orElse(null);
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

