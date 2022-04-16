package interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JFrame {
  private JButton boton1;
  private JButton boton2;
  private JButton boton3;
  private JButton boton4;
  private JButton boton5;
  private JButton boton6;
  private JButton boton7;
  private JButton boton8;
  private JButton boton9;
  private JButton boton10;
  private JButton boton11;
  private JButton boton12;
  private JButton salir;
  private JPanel panel;

  public Menu() {
    setBounds(350, 0, 700, 850);
    setTitle("Menu Principal");
    initComponents();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private void initComponents() {
    panel = new JPanel();
    panel.setLayout(null);
    this.add(panel);
    panel.setBackground(new Color(102, 255, 102));

    boton1 = new JButton("Agregar Cliente");
    boton1.setBounds(50, 50, 200, 50);
    boton1.setBackground(Color.white);
    boton1.setForeground(Color.black);
    panel.add(boton1);
    boton2 = new JButton("Agregar Producto");
    boton2.setBounds(50, 150, 200, 50);
    boton2.setBackground(Color.white);
    boton2.setForeground(Color.black);
    panel.add(boton2);
    boton3 = new JButton("Agregar Proveedor");
    boton3.setBounds(50, 250, 200, 50);
    boton3.setBackground(Color.white);
    boton3.setForeground(Color.black);
    panel.add(boton3);
    boton4 = new JButton("Agregar Factura");
    boton4.setBounds(50, 350, 200, 50);
    boton4.setBackground(Color.white);
    boton4.setForeground(Color.black);
    panel.add(boton4);
    boton5 = new JButton("Agregar Detalle Factura");
    boton5.setBounds(50, 450, 200, 50);
    boton5.setBackground(Color.white);
    boton5.setForeground(Color.black);
    panel.add(boton5);
    boton6 = new JButton("Agregar Producto a Proveedor");
    boton6.setBounds(50, 550, 200, 50);
    boton6.setBackground(Color.white);
    boton6.setForeground(Color.black);
    panel.add(boton6);
    boton7 = new JButton("Agregar Producto a Cliente");
    boton7.setBounds(50, 650, 200, 50);
    boton7.setBackground(Color.white);
    boton7.setForeground(Color.black);
    panel.add(boton7);
    boton8 = new JButton("Agregar Producto a Factura");
    boton8.setBounds(300, 50, 200, 50);
    boton8.setBackground(Color.white);
    boton8.setForeground(Color.black);
    panel.add(boton8);
    boton9 = new JButton("Agregar Producto a Detalle Factura");
    boton9.setBounds(300, 150, 200, 50);
    boton9.setBackground(Color.white);
    boton9.setForeground(Color.black);
    panel.add(boton9);
    boton10 = new JButton("Agregar Proveedor a Factura");
    boton10.setBounds(300, 250, 200, 50);
    boton10.setBackground(Color.white);
    boton10.setForeground(Color.black);
    panel.add(boton10);
    boton11 = new JButton("Agregar Cliente a Factura");
    boton11.setBounds(300, 350, 200, 50);
    boton11.setBackground(Color.white);
    boton11.setForeground(Color.black);
    panel.add(boton11);
    boton12 = new JButton("Agregar Detalle Factura a Factura");
    boton12.setBounds(300, 450, 200, 50);
    boton12.setBackground(Color.white);
    boton12.setForeground(Color.black);
    panel.add(boton12);
    salir = new JButton("Salir");
    salir.setBounds(300, 650, 200, 50);
    salir.setBackground(Color.white);
    salir.setForeground(Color.black);
    panel.add(salir);

    boton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    boton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    boton3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    boton4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    boton5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    boton6.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    boton7.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    boton8.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    boton9.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    boton10.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    boton11.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    boton12.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    salir.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        System.exit(0);
      }
    });
  }

  public void mostrarMenu() {
    setVisible(true);
  }

}
