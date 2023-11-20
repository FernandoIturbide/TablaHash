package org.example.Vista;
import java.awt.*;
import javax.swing.*;

import org.example.Modelo.ModeloLibros;

import java.awt.event.*;

public class Vista extends JFrame implements ActionListener, ItemListener{
    private JMenuBar mb;
    private JMenu menuOpciones,menuAcercaDe,menuColorFondo;
    private JMenuItem miRojo,miNegro,miMorado,Original,miElCreador,miSalir,miNuevo;
    private JLabel labelLogo, labelBienvenido, labelinstruccion, labelcantidad, labeltipo,labelfooter, precio, labelCanComida, labelCanReposteria, labelTipoComida, labelTipoReposteria, labelprecio2, labelprecio3;
    private JButton sacarticket, guardar,borrar;
    private JComboBox comboproductos, comboComida, comboReposteria;
    private JTextField Libro1, Libro2, Libro3;
    private JScrollPane scrollpane1,scrollpane,scrollPane2, scrollPane3; 
    private JTextArea textarea,textarea1,textarea2, textarea3;
    



    public Vista(String title) throws HeadlessException  {
        super(title);
        this.setLayout(null);
        this.setSize(650, 535);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0,35,53));
        setIconImage(new ImageIcon(getClass().getResource("images/ivono.png")).getImage());

        
        mb = new JMenuBar();
        mb.setBackground(new Color(255, 0, 0));
        setJMenuBar(mb);

        menuOpciones = new JMenu("Opciones");
        menuOpciones.setBackground(new Color(255, 0, 0));
        menuOpciones.setFont(new Font("Andale Mono", 1, 14));
        menuOpciones.setForeground(new Color(255, 255, 255));
        mb.add(menuOpciones);

        menuAcercaDe = new JMenu("Acerca de");
        menuAcercaDe.setBackground(new Color(255, 0, 0));
        menuAcercaDe.setFont(new Font("Andale Mono", 1, 14));
        menuAcercaDe.setForeground(new Color(255, 255, 255));
        mb.add(menuAcercaDe);

        menuColorFondo = new JMenu("Color de fondo");
        menuColorFondo.setFont(new Font("Andale Mono", 1, 14));
        menuColorFondo.setForeground(new Color(255, 0, 0));
        menuOpciones.add(menuColorFondo);

        Original=new JMenuItem("Defecto");
        Original.setFont(new Font ("Andale Mono",1,14));
        Original.setForeground(new Color(255, 0, 0));
        menuColorFondo.add(Original);
        Original.addActionListener(this);

        miRojo = new JMenuItem("Rojo");
        miRojo.setFont(new Font("Andale Mono", 1, 14));
        miRojo.setForeground(new Color(255, 0, 0));
        menuColorFondo.add(miRojo);
        miRojo.addActionListener(this);

        miNegro = new JMenuItem("Negro");
        miNegro.setFont(new Font("Andale Mono", 1, 14));
        miNegro.setForeground(new Color(255, 0, 0));
        menuColorFondo.add(miNegro);
        miNegro.addActionListener(this);

        miMorado = new JMenuItem("Morado");
        miMorado.setFont(new Font("Andale Mono", 1, 14));
        miMorado.setForeground(new Color(255, 0, 0));
        menuColorFondo.add(miMorado);
        miMorado.addActionListener(this);

        miNuevo = new JMenuItem("Nuevo");
        miNuevo.setFont(new Font("Andale Mono", 1, 14));
        miNuevo.setForeground(new Color(255, 0, 0));
        menuOpciones.add(miNuevo);
        miNuevo.addActionListener(this);

        miElCreador = new JMenuItem("El creador");
        miElCreador.setFont(new Font("Andale Mono", 1, 14));
        miElCreador.setForeground(new Color(255, 0, 0));
        menuAcercaDe.add(miElCreador);
        miElCreador.addActionListener(this);

        miSalir = new JMenuItem("Salir");
        miSalir.setFont(new Font("Andale Mono", 1, 14));
        miSalir.setForeground(new Color(255, 0, 0));
        menuOpciones.add(miSalir);
        miSalir.addActionListener(this);

        ImageIcon imagen = new ImageIcon("/images/logo3.png");
        labelLogo = new JLabel(imagen);  
        labelLogo.setBounds(5,5,250,100);
        add(labelLogo);

            
        labelBienvenido = new JLabel("Bienvenido ");  
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
        Libro1.setForeground(new java.awt.Color(255, 0, 0));
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
        Libro2.setForeground(new java.awt.Color(255, 0, 0));
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
        Libro3.setForeground(new java.awt.Color(255, 0, 0));
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
        comboproductos.setForeground(new java.awt.Color(255, 0, 0));
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
        comboComida.setForeground(new java.awt.Color(255, 0, 0));
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
        comboReposteria.setForeground(new java.awt.Color(255, 0, 0));
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


        this.setVisible(true);
    }

    public static void main(String[] args) {
        Vista vista=new Vista("Ventana principal");
        vista.setResizable(false);
        vista.setLocationRelativeTo(null);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'itemStateChanged'");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
    }
    
}

