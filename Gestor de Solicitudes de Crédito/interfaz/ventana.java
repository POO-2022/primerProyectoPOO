package interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ventana extends JFrame {
  private JButton registrarSolicitante;
  private JButton registrarSolicitudCredito;
  private JButton calcularCreditoHipotecarioEnColon;
  private JButton calcularCreditoHipotecarioDolar;
  private JButton calculoCreditoFiduciarioColon;
  private JButton calculoCreditoFiduciarioDolar;
  private JButton calculoCreditoPrendarioColor;
  private JButton calculoCreditoPrendarioDolar;
  private JButton calculoCreditoPersonalColor;
  private JButton calculoCreditoPersonalDolar;
  private JButton enviarCorreo;
  private JButton crearPDF;
  private JButton salir;
  private JPanel panel;

  public ventana() {
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

    registrarSolicitante = new JButton("registrar solicitante");
    registrarSolicitante.setBounds(50, 50, 200, 50);
    registrarSolicitante.setBackground(Color.white);
    registrarSolicitante.setForeground(Color.black);
    panel.add(registrarSolicitante);
    registrarSolicitudCredito = new JButton("registrar solicitud credito");
    registrarSolicitudCredito.setBounds(50, 150, 200, 50);
    registrarSolicitudCredito.setBackground(Color.white);
    registrarSolicitudCredito.setForeground(Color.black);
    panel.add(registrarSolicitudCredito);
    calcularCreditoHipotecarioEnColon = new JButton("calcular credito hipotecario en colon");
    calcularCreditoHipotecarioEnColon.setBounds(50, 250, 200, 50);
    calcularCreditoHipotecarioEnColon.setBackground(Color.white);
    calcularCreditoHipotecarioEnColon.setForeground(Color.black);
    panel.add(calcularCreditoHipotecarioEnColon);
    calcularCreditoHipotecarioDolar = new JButton("calcular credito hipotecario en dolar");
    calcularCreditoHipotecarioDolar.setBounds(50, 350, 200, 50);
    calcularCreditoHipotecarioDolar.setBackground(Color.white);
    calcularCreditoHipotecarioDolar.setForeground(Color.black);
    panel.add(calcularCreditoHipotecarioDolar);
    calculoCreditoFiduciarioColon = new JButton("calcular credito fiduciario en colon");
    calculoCreditoFiduciarioColon.setBounds(50, 450, 200, 50);
    calculoCreditoFiduciarioColon.setBackground(Color.white);
    calculoCreditoFiduciarioColon.setForeground(Color.black);
    panel.add(calculoCreditoFiduciarioColon);
    calculoCreditoFiduciarioDolar = new JButton("calcular credito fiduciario en dolar");
    calculoCreditoFiduciarioDolar.setBounds(50, 550, 200, 50);
    calculoCreditoFiduciarioDolar.setBackground(Color.white);
    calculoCreditoFiduciarioDolar.setForeground(Color.black);
    panel.add(calculoCreditoFiduciarioDolar);
    calculoCreditoPrendarioColor = new JButton("calcular credito prendario en color");
    calculoCreditoPrendarioColor.setBounds(50, 650, 200, 50);
    calculoCreditoPrendarioColor.setBackground(Color.white);
    calculoCreditoPrendarioColor.setForeground(Color.black);
    panel.add(calculoCreditoPrendarioColor);
    calculoCreditoPrendarioDolar = new JButton("calcular credito prendario en dolar");
    calculoCreditoPrendarioDolar.setBounds(300, 50, 200, 50);
    calculoCreditoPrendarioDolar.setBackground(Color.white);
    calculoCreditoPrendarioDolar.setForeground(Color.black);
    panel.add(calculoCreditoPrendarioDolar);
    calculoCreditoPersonalDolar = new JButton("calcular credito personal en dolar");
    calculoCreditoPersonalDolar.setBounds(300, 150, 200, 50);
    calculoCreditoPersonalDolar.setBackground(Color.white);
    calculoCreditoPersonalDolar.setForeground(Color.black);
    panel.add(calculoCreditoPersonalDolar);
    calculoCreditoPersonalColor = new JButton("");
    calculoCreditoPersonalColor.setBounds(300, 250, 200, 50);
    calculoCreditoPersonalColor.setBackground(Color.white);
    calculoCreditoPersonalColor.setForeground(Color.black);
    panel.add(calculoCreditoPersonalColor);
    enviarCorreo = new JButton("");
    enviarCorreo.setBounds(300, 350, 200, 50);
    enviarCorreo.setBackground(Color.white);
    enviarCorreo.setForeground(Color.black);
    panel.add(enviarCorreo);
    crearPDF = new JButton("");
    crearPDF.setBounds(300, 450, 200, 50);
    crearPDF.setBackground(Color.white);
    crearPDF.setForeground(Color.black);
    panel.add(crearPDF);
    salir = new JButton("Salir");
    salir.setBounds(300, 650, 200, 50);
    salir.setBackground(Color.white);
    salir.setForeground(Color.black);
    panel.add(salir);

    registrarSolicitante.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    registrarSolicitudCredito.addActionListener(new ActionListener() {
      public void actszionPerformed(ActionEvent evt) {

      }
    });
    calcularCreditoHipotecarioEnColon.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    calcularCreditoHipotecarioDolar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    calculoCreditoFiduciarioColon.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    calculoCreditoFiduciarioDolar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    calculoCreditoPrendarioColor.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    calculoCreditoPrendarioDolar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    calculoCreditoPersonalDolar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    calculoCreditoPersonalColor.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    enviarCorreo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    crearPDF.addActionListener(new ActionListener() {
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

