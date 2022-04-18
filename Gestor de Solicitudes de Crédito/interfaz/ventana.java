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
    registrarSolicitudCredito = new JButton("registrar solicitud credito");
    calcularCreditoHipotecarioEnColon = new JButton("calcular credito hipotecario en colon");
    calcularCreditoHipotecarioDolar = new JButton("calcular credito hipotecario en dolar");
    calculoCreditoFiduciarioDolar = new JButton("calcular credito fiduciario en dolar");
    calculoCreditoFiduciarioColon = new JButton("calcular credito fiduciario en colon");
    calculoCreditoPrendarioColor = new JButton("calcular credito prendario en color");
    calculoCreditoPrendarioDolar = new JButton("calcular credito prendario en dolar");
    calculoCreditoPersonalColor = new JButton("calcular credito personal en color");
    calculoCreditoPersonalDolar = new JButton("calcular credito personal en dolar");
    enviarCorreo = new JButton("enviar correo");
    crearPDF = new JButton("crear pdf");
    salir = new JButton("Salir");

    registrarSolicitante.setBounds(50, 50, 250, 50);
    registrarSolicitudCredito.setBounds(50, 150, 250, 50);
    calcularCreditoHipotecarioEnColon.setBounds(50, 250, 250, 50);
    calcularCreditoHipotecarioDolar.setBounds(50, 350, 250, 50);
    calculoCreditoFiduciarioColon.setBounds(50, 450, 250, 50);
    calculoCreditoFiduciarioDolar.setBounds(50, 550, 250, 50);
    calculoCreditoPrendarioColor.setBounds(350, 50, 250, 50);
    calculoCreditoPrendarioDolar.setBounds(350, 150, 250, 50);
    calculoCreditoPersonalDolar.setBounds(350, 250, 250, 50);
    calculoCreditoPersonalColor.setBounds(350, 350, 250, 50);
    enviarCorreo.setBounds(350, 450, 250, 50);
    crearPDF.setBounds(350, 550, 250, 50);
    salir.setBounds(280, 650, 100, 50);

    registrarSolicitante.setBackground(Color.white);
    registrarSolicitante.setForeground(Color.black);
    panel.add(registrarSolicitante);
    registrarSolicitudCredito.setBackground(Color.white);
    registrarSolicitudCredito.setForeground(Color.black);
    panel.add(registrarSolicitudCredito);
    calcularCreditoHipotecarioEnColon.setBackground(Color.white);
    calcularCreditoHipotecarioEnColon.setForeground(Color.black);
    panel.add(calcularCreditoHipotecarioEnColon);
    calcularCreditoHipotecarioDolar.setBackground(Color.white);
    calcularCreditoHipotecarioDolar.setForeground(Color.black);
    panel.add(calcularCreditoHipotecarioDolar);
    calculoCreditoFiduciarioColon.setBackground(Color.white);
    calculoCreditoFiduciarioColon.setForeground(Color.black);
    panel.add(calculoCreditoFiduciarioColon);
    calculoCreditoFiduciarioDolar.setBackground(Color.white);
    calculoCreditoFiduciarioDolar.setForeground(Color.black);
    panel.add(calculoCreditoFiduciarioDolar);
    calculoCreditoPrendarioColor.setBackground(Color.white);
    calculoCreditoPrendarioColor.setForeground(Color.black);
    panel.add(calculoCreditoPrendarioColor);
    calculoCreditoPrendarioDolar.setBackground(Color.white);
    calculoCreditoPrendarioDolar.setForeground(Color.black);
    panel.add(calculoCreditoPrendarioDolar);
    calculoCreditoPersonalDolar.setBackground(Color.white);
    calculoCreditoPersonalDolar.setForeground(Color.black);
    panel.add(calculoCreditoPersonalDolar);
    calculoCreditoPersonalColor.setBackground(Color.white);
    calculoCreditoPersonalColor.setForeground(Color.black);
    panel.add(calculoCreditoPersonalColor);
    enviarCorreo.setBackground(Color.white);
    enviarCorreo.setForeground(Color.black);
    panel.add(enviarCorreo);
    crearPDF.setBackground(Color.white);
    crearPDF.setForeground(Color.black);
    panel.add(crearPDF);
    salir.setBackground(Color.white);
    salir.setForeground(Color.black);
    panel.add(salir);

    registrarSolicitante.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

      }
    });
    registrarSolicitudCredito.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {

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
