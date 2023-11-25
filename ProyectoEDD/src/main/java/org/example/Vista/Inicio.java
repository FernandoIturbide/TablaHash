package org.example.Vista;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Inicio extends JFrame implements ActionListener{//Bienvenido usuario 
    private JTextField textfield1;
    private JLabel label1, label2, label3, label4;
    private JButton boton1;
    public static String text="";
    public Inicio(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bienvenido");
        getContentPane().setBackground(new Color(0,35,53));
        setIconImage(new ImageIcon(getClass().getResource("images/Logo.png")).getImage());
        
        
    
        label2 = new JLabel("Sistema de Control ticket");
        label2.setBounds(55,135,300,30);
        label2.setFont(new Font("Andale Mono", 3, 18));
        label2.setForeground(new Color(255,255,255));
        add(label2);
    
        label3 = new JLabel("Ingrese su nombre");
        label3.setBounds(45,212,200,30);
        label3.setFont(new Font("Andale Mono", 1, 12));
        label3.setForeground(new Color(255,255,255));
        add(label3);
    
        label4 = new JLabel("@2022 The WAPYJ Company");
        label4.setBounds(85,375,300,30);
        label4.setFont(new Font("Andale Mono", 1, 12));
        label4.setForeground(new Color(255,255,255));
        add(label4);
    
        textfield1 = new JTextField ();
        textfield1.setBounds(45,240,255,25);
        textfield1.setBackground(new Color(224,224,224));
        textfield1.setFont(new Font("Andale Mono", 1, 14));
        textfield1.setForeground(new Color(0,35,53));
        add(textfield1);
    
        boton1 = new JButton("Ingresar");
        boton1.setBounds(125,280,100,30);
        boton1.setBackground(new Color(255,255,255));
        boton1.setFont(new Font("Andale Mono", 1, 14));
        boton1.setForeground(new Color(55,194,209));
        boton1.addActionListener(this);
        add(boton1);
        ImageIcon imagen = new ImageIcon(getClass().getResource("images/logo3.png"));
        label1 = new JLabel(imagen);
        label1.setBounds(25,15,300,150);
        add(label1);
      }
    
    
       public void actionPerformed(ActionEvent e){
         if(e.getSource() == boton1){
           text=textfield1.getText().trim();
           if (text.equals("")) {
             JOptionPane.showMessageDialog(null, "Debes ingresar tu nombre");
           }else{
            Interfaz interfaz = new Interfaz();
            interfaz.setBounds(0,0,600,360);
            interfaz.setVisible(true);
            interfaz.setResizable(false);
            interfaz.setLocationRelativeTo(null);
            this.setVisible(false);
           }
         }
       }
    
       
}
