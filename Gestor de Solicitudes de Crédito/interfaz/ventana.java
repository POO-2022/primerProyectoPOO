package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import logicadenegocios.Credito;
import logicadenegocios.CreditoPersonal;
import logicadenegocios.Deudor;
import logicadenegocios.Direccion;
import logicadenegocios.TMoneda;

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
  private ArrayList<Deudor> solicitantes;
  private ArrayList<Credito> creditos;
  private static int numeroCredito = 0;

  public ventana() {
    solicitantes = new ArrayList<Deudor>();
    creditos = new ArrayList<Credito>();
    setBounds(350, 0, 700, 850);
    setTitle("Gestion de Creditos");
    initComponents();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private void initComponents() {
    panel = new JPanel();
    panel.setLayout(null);
    this.add(panel);
    panel.setBackground(new Color(102, 205, 170));

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

    registrarSolicitante.setBounds(50, 50, 270, 50);
    registrarSolicitudCredito.setBounds(50, 150, 270, 50);
    calcularCreditoHipotecarioEnColon.setBounds(50, 250, 270, 50);
    calcularCreditoHipotecarioDolar.setBounds(50, 350, 270, 50);
    calculoCreditoFiduciarioColon.setBounds(50, 450, 270, 50);
    calculoCreditoFiduciarioDolar.setBounds(50, 550, 270, 50);
    calculoCreditoPrendarioColor.setBounds(350, 50, 270, 50);
    calculoCreditoPrendarioDolar.setBounds(350, 150, 270, 50);
    calculoCreditoPersonalDolar.setBounds(350, 250, 270, 50);
    calculoCreditoPersonalColor.setBounds(350, 350, 270, 50);
    enviarCorreo.setBounds(350, 450, 270, 50);
    crearPDF.setBounds(350, 550, 270, 50);
    salir.setBounds(280, 650, 100, 50);

    registrarSolicitante.setFont(new Font("Times New Roman", 3, 14));
    registrarSolicitante.setForeground(new Color(0, 0, 0));
    registrarSolicitante.setBackground(new Color(135, 206, 250));
    panel.add(registrarSolicitante);

    registrarSolicitudCredito.setFont(new Font("Times New Roman", 3, 14));
    registrarSolicitudCredito.setForeground(new Color(0, 0, 0));
    registrarSolicitudCredito.setBackground(new Color(135, 206, 250));
    panel.add(registrarSolicitudCredito);

    calcularCreditoHipotecarioEnColon.setFont(new Font("Times New Roman", 3, 14));
    calcularCreditoHipotecarioEnColon.setForeground(new Color(0, 0, 0));
    calcularCreditoHipotecarioEnColon.setBackground(new Color(135, 206, 250));
    panel.add(calcularCreditoHipotecarioEnColon);

    calcularCreditoHipotecarioDolar.setFont(new Font("Times New Roman", 3, 14));
    calcularCreditoHipotecarioDolar.setForeground(new Color(0, 0, 0));
    calcularCreditoHipotecarioDolar.setBackground(new Color(135, 206, 250));
    panel.add(calcularCreditoHipotecarioDolar);

    calculoCreditoFiduciarioDolar.setFont(new Font("Times New Roman", 3, 14));
    calculoCreditoFiduciarioDolar.setForeground(new Color(0, 0, 0));
    calculoCreditoFiduciarioDolar.setBackground(new Color(135, 206, 250));
    panel.add(calculoCreditoFiduciarioDolar);

    calculoCreditoFiduciarioColon.setFont(new Font("Times New Roman", 3, 14));
    calculoCreditoFiduciarioColon.setForeground(new Color(0, 0, 0));
    calculoCreditoFiduciarioColon.setBackground(new Color(135, 206, 250));
    panel.add(calculoCreditoFiduciarioColon);

    calculoCreditoPrendarioColor.setFont(new Font("Times New Roman", 3, 14));
    calculoCreditoPrendarioColor.setForeground(new Color(0, 0, 0));
    calculoCreditoPrendarioColor.setBackground(new Color(135, 206, 250));
    panel.add(calculoCreditoPrendarioColor);

    calculoCreditoPrendarioDolar.setFont(new Font("Times New Roman", 3, 14));
    calculoCreditoPrendarioDolar.setForeground(new Color(0, 0, 0));
    calculoCreditoPrendarioDolar.setBackground(new Color(135, 206, 250));
    panel.add(calculoCreditoPrendarioDolar);

    calculoCreditoPersonalColor.setFont(new Font("Times New Roman", 3, 14));
    calculoCreditoPersonalColor.setForeground(new Color(0, 0, 0));
    calculoCreditoPersonalColor.setBackground(new Color(135, 206, 250));
    panel.add(calculoCreditoPersonalColor);

    calculoCreditoPersonalDolar.setFont(new Font("Times New Roman", 3, 14));
    calculoCreditoPersonalDolar.setForeground(new Color(0, 0, 0));
    calculoCreditoPersonalDolar.setBackground(new Color(135, 206, 250));
    panel.add(calculoCreditoPersonalDolar);

    enviarCorreo.setFont(new Font("Times New Roman", 3, 16));
    enviarCorreo.setForeground(new Color(0, 0, 0));
    enviarCorreo.setBackground(new Color(135, 206, 250));
    panel.add(enviarCorreo);

    crearPDF.setFont(new Font("Times New Roman", 3, 16));
    crearPDF.setForeground(new Color(0, 0, 0));
    crearPDF.setBackground(new Color(135, 206, 250));
    panel.add(crearPDF);

    salir.setFont(new Font("Times New Roman", 3, 16));
    salir.setForeground(new Color(0, 0, 0));
    salir.setBackground(new Color(135, 206, 250));
    panel.add(salir);

    registrarSolicitante.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        menuRegistrarSolicitante();
        panel.setVisible(false);
      }
    });
    registrarSolicitudCredito.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        menuRegistrarSolicitudCredito();
        panel.setVisible(false);
      }
    });
    calcularCreditoHipotecarioEnColon.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        menuCacularCreditoHipotecarioEnColon();
        panel.setVisible(false);
      }
    });
    calcularCreditoHipotecarioDolar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        menuCacularCreditoHipotecarioEnDolar();
        panel.setVisible(false);
      }
    });
    calculoCreditoFiduciarioColon.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        menuCacularCreditoFiduciarioEnColon();
        panel.setVisible(false);
      }
    });
    calculoCreditoFiduciarioDolar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        menuCalcularCreditoFiduciarioEnDolar();
        panel.setVisible(false);
      }
    });
    calculoCreditoPrendarioColor.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        menuCalcularCreditoPrendarioEnColon();
        panel.setVisible(false);
      }
    });
    calculoCreditoPrendarioDolar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        menuCalcularCreditoPrendarioDolar();
        panel.setVisible(false);
      }
    });
    calculoCreditoPersonalDolar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        menuCalcularCreditoPersonalEnDolar();
        panel.setVisible(false);
      }
    });
    calculoCreditoPersonalColor.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        menuCalcularCreditoPersonalEnColones();
        panel.setVisible(false);
      }
    });
    enviarCorreo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        menuEnviarCorreo();
        panel.setVisible(false);
      }
    });
    crearPDF.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        // menuCrearPDF();
        // panel.setVisible(false);
      }
    });
    salir.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        System.exit(0);
      }
    });

  }

  private void menuRegistrarSolicitante() {
    JPanel panel2 = new JPanel();
    JButton registrarSolicitante = new JButton("Registrar Solicitante");
    JButton regresar = new JButton("Regresar");
    JLabel primerNombre = new JLabel("1° Nombre");
    JLabel segundoNombre = new JLabel("2° Nombre");
    JLabel primerApellido = new JLabel("1° Apellido");
    JLabel segundoApellido = new JLabel("2° Apellido");
    JLabel cedula = new JLabel("Cedula");
    JLabel telefono = new JLabel("Telefono");
    JLabel correo = new JLabel("Correo");
    JLabel direccion = new JLabel("Direccion");
    JLabel provincia = new JLabel("Provincia");
    JLabel canton = new JLabel("Canton");
    JLabel distrito = new JLabel("Distrito");
    JLabel senas = new JLabel("Señas");
    JLabel salarioBruto = new JLabel("Salario Bruto");
    JLabel salarioLiquido = new JLabel("Salario Liquido");
    JTextField primerNombreText = new JTextField();
    JTextField segundoNombreText = new JTextField();
    JTextField primerApellidoText = new JTextField();
    JTextField segundoApellidoText = new JTextField();
    JTextField cedulaText = new JTextField();
    JTextField telefonoText = new JTextField();
    JTextField correoText = new JTextField();
    JTextField provinciaText = new JTextField();
    JTextField cantonText = new JTextField();
    JTextField distritoText = new JTextField();
    JTextField senasText = new JTextField();
    JTextField salarioBrutoText = new JTextField();
    JTextField salarioLiquidoText = new JTextField();

    panel2.setLayout(null);
    this.add(panel2);
    panel2.setBounds(0, 0, 800, 600);
    panel2.setBackground(new Color(102, 205, 170));

    primerNombre.setBounds(50, 50, 100, 20);
    primerNombre.setBackground(new Color(0, 153, 153));
    primerNombre.setFont(new Font("Times new Roman", Font.BOLD, 14));
    panel2.add(primerNombre);

    segundoNombre.setBounds(50, 100, 100, 20);
    segundoNombre.setBackground(new Color(0, 153, 153));
    segundoNombre.setFont(new Font("Times new Roman", Font.BOLD, 14));
    panel2.add(segundoNombre);

    primerApellido.setBounds(50, 150, 100, 20);
    primerApellido.setBackground(new Color(0, 153, 153));
    primerApellido.setFont(new Font("Times new Roman", Font.BOLD, 14));
    panel2.add(primerApellido);

    segundoApellido.setBounds(50, 200, 100, 20);
    segundoApellido.setBackground(new Color(0, 153, 153));
    segundoApellido.setFont(new Font("Times new Roman", Font.BOLD, 14));
    panel2.add(segundoApellido);

    cedula.setBounds(50, 250, 100, 20);
    cedula.setBackground(new Color(0, 153, 153));
    cedula.setFont(new Font("Times new Roman", Font.BOLD, 14));
    panel2.add(cedula);

    telefono.setBounds(50, 300, 100, 20);
    telefono.setBackground(new Color(0, 153, 153));
    telefono.setFont(new Font("Times new Roman", Font.BOLD, 14));
    panel2.add(telefono);

    correo.setBounds(50, 350, 100, 20);
    correo.setBackground(new Color(0, 153, 153));
    correo.setFont(new Font("Times new Roman", Font.BOLD, 14));
    panel2.add(correo);

    direccion.setBounds(50, 400, 100, 20);
    direccion.setBackground(new Color(0, 153, 153));
    direccion.setFont(new Font("Times new Roman", Font.BOLD, 14));
    panel2.add(direccion);

    provincia.setBounds(50, 450, 100, 20);
    provincia.setBackground(new Color(0, 153, 153));
    provincia.setFont(new Font("Times new Roman", Font.BOLD, 14));
    panel2.add(provincia);

    canton.setBounds(50, 500, 100, 20);
    canton.setBackground(new Color(0, 153, 153));
    canton.setFont(new Font("Times new Roman", Font.BOLD, 14));
    panel2.add(canton);

    distrito.setBounds(50, 550, 100, 20);
    distrito.setBackground(new Color(0, 153, 153));
    distrito.setFont(new Font("Times new Roman", Font.BOLD, 14));
    panel2.add(distrito);

    senas.setBounds(50, 600, 100, 20);
    senas.setBackground(new Color(0, 153, 153));
    senas.setFont(new Font("Times new Roman", Font.BOLD, 14));
    panel2.add(senas);

    salarioBruto.setBounds(310, 50, 100, 20);
    salarioBruto.setBackground(new Color(0, 153, 153));
    salarioBruto.setFont(new Font("Times new Roman", Font.BOLD, 14));
    panel2.add(salarioBruto);

    salarioLiquido.setBounds(310, 100, 100, 20);
    salarioLiquido.setBackground(new Color(0, 153, 153));
    salarioLiquido.setFont(new Font("Times new Roman", Font.BOLD, 14));
    panel2.add(salarioLiquido);

    primerNombreText.setBounds(200, 50, 100, 20);
    panel2.add(primerNombreText);

    segundoNombreText.setBounds(200, 100, 100, 20);
    panel2.add(segundoNombreText);

    primerApellidoText.setBounds(200, 150, 100, 20);
    panel2.add(primerApellidoText);

    segundoApellidoText.setBounds(200, 200, 100, 20);
    panel2.add(segundoApellidoText);

    cedulaText.setBounds(200, 250, 100, 20);
    panel2.add(cedulaText);

    telefonoText.setBounds(200, 300, 100, 20);
    panel2.add(telefonoText);

    correoText.setBounds(200, 350, 250, 20);
    panel2.add(correoText);

    provinciaText.setBounds(200, 450, 100, 20);
    panel2.add(provinciaText);

    cantonText.setBounds(200, 500, 100, 20);
    panel2.add(cantonText);

    distritoText.setBounds(200, 550, 100, 20);
    panel2.add(distritoText);

    senasText.setBounds(200, 600, 250, 20);
    panel2.add(senasText);

    salarioBrutoText.setBounds(500, 50, 100, 20);
    panel2.add(salarioBrutoText);

    salarioLiquidoText.setBounds(500, 100, 100, 20);
    panel2.add(salarioLiquidoText);

    regresar.setBounds(50, 650, 150, 40);
    regresar.setBackground(new Color(135, 206, 250));
    regresar.setFont(new Font("Times new Roman", Font.BOLD, 16));
    regresar.setForeground(new Color(0, 0, 0));
    panel2.add(regresar);
    regresar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        panel2.setVisible(false);
        panel.setVisible(true);
      }
    });

    registrarSolicitante.setBounds(300, 650, 190, 40);
    registrarSolicitante.setBackground(new Color(135, 206, 250));
    registrarSolicitante.setFont(new Font("Times new Roman", Font.BOLD, 16));
    registrarSolicitante.setForeground(new Color(0, 0, 0));
    panel2.add(registrarSolicitante);
    registrarSolicitante.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String pPrimerNombre = primerNombreText.getText();
        String pSegundoNombre = segundoNombreText.getText();
        String pPrimerApellido = primerApellidoText.getText();
        String pSegundoApellido = segundoApellidoText.getText();
        String pCedula = cedulaText.getText();
        String pTelefono = telefonoText.getText();
        String pCorreo = correoText.getText();
        String pProvincia = provinciaText.getText();
        String pCanton = cantonText.getText();
        String pDistrito = distritoText.getText();
        String pSenas = senasText.getText();
        String pSalarioBruto = salarioBrutoText.getText();
        String pSalarioLiquido = salarioLiquidoText.getText();
        if (!pPrimerNombre.equals("") && !pSegundoNombre.equals("") && !pPrimerApellido.equals("")
            && !pSegundoApellido.equals("") && !pCedula.equals("") && !pTelefono.equals("") && !pCorreo.equals("")
            && !pProvincia.equals("") && !pCanton.equals("") && !pDistrito.equals("") && !pSenas.equals("")
            && !pSalarioBruto.equals("") && !pSalarioLiquido.equals("")) {
          if (pCedula.length() == 10) {
            double pSalarioBrutoI = Double.parseDouble(pSalarioBruto);
            double pSalarioLiquidoI = Double.parseDouble(pSalarioLiquido);
            Direccion direccion = new Direccion(pProvincia, pCanton, pDistrito, pSenas);
            Deudor solicitante = new Deudor(pPrimerNombre, pSegundoNombre, pPrimerApellido, pSegundoApellido, pCedula,
                direccion, pTelefono, pCorreo, pSalarioBrutoI, pSalarioLiquidoI);
            solicitantes.add(solicitante);
            // aqui va el codigo para guardar en la base de datos
            JOptionPane.showMessageDialog(null, "Solicitante registrado");
            panel2.setVisible(false);
            panel.setVisible(true);
          } else {
            JOptionPane.showMessageDialog(null, "La cedula debe tener 10 digitos");
          }
        } else {
          JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
        }
      }
    });

  }

  private void menuRegistrarSolicitudCredito() {
    JPanel panel2 = new JPanel();
    JButton registraSolicitudCredito = new JButton("Registrar Solicitud de Credito");
    JButton regresar = new JButton("Regresar");
    JLabel etiquetaTipoCredito = new JLabel("Tipo de Credito");
    JLabel etiquetaMonto = new JLabel("Monto");
    JLabel etiquetaMoneda = new JLabel("Moneda");
    JLabel etiquetaFechaSolicitud = new JLabel("Fecha de Solicitud");
    JLabel etiquetaNumeroSolicitud = new JLabel("Numero de Solicitud");
    JComboBox<String> tipoCreditoBox = new JComboBox<String>();
    JComboBox<String> tipoMonedaBox = new JComboBox<String>();
    JTextField montoTexT = new JTextField();
    JTextField numeroSolicitudText = new JTextField();
    JTextField fechaSolicitudText = new JTextField();

    tipoCreditoBox.addItem("Credito Personal");
    tipoCreditoBox.addItem("Credito Fiduciario");
    tipoCreditoBox.addItem("Credito Hipotecario");
    tipoCreditoBox.addItem("Credito Prendario");
    tipoMonedaBox.addItem("Colon");
    tipoMonedaBox.addItem("Dolar");

    panel2.setLayout(null);
    this.add(panel2);
    panel2.setBounds(0, 0, 700, 700);
    panel2.setBackground(new Color(102, 205, 170));

    etiquetaTipoCredito.setBounds(50, 50, 200, 30);
    etiquetaTipoCredito.setBackground(new Color(0, 153, 153));
    etiquetaTipoCredito.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(etiquetaTipoCredito);

    etiquetaMonto.setBounds(50, 100, 100, 30);
    etiquetaMonto.setBackground(new Color(0, 153, 153));
    etiquetaMonto.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(etiquetaMonto);

    etiquetaMoneda.setBounds(50, 150, 100, 30);
    etiquetaMoneda.setBackground(new Color(0, 153, 153));
    etiquetaMoneda.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(etiquetaMoneda);

    etiquetaFechaSolicitud.setBounds(50, 200, 200, 30);
    etiquetaFechaSolicitud.setBackground(new Color(0, 153, 153));
    etiquetaFechaSolicitud.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(etiquetaFechaSolicitud);

    etiquetaNumeroSolicitud.setBounds(50, 250, 200, 30);
    etiquetaNumeroSolicitud.setBackground(new Color(0, 153, 153));
    etiquetaNumeroSolicitud.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(etiquetaNumeroSolicitud);

    tipoCreditoBox.setBounds(250, 50, 200, 30);
    tipoCreditoBox.setBackground(new Color(255, 255, 255));
    tipoCreditoBox.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(tipoCreditoBox);

    montoTexT.setBounds(250, 100, 200, 30);
    montoTexT.setBackground(new Color(255, 255, 255));
    montoTexT.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(montoTexT);

    tipoMonedaBox.setBounds(250, 150, 200, 30);
    tipoMonedaBox.setBackground(new Color(255, 255, 255));
    tipoMonedaBox.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(tipoMonedaBox);

    fechaSolicitudText.setBounds(250, 200, 200, 30);
    fechaSolicitudText.setBackground(new Color(255, 255, 255));
    fechaSolicitudText.setFont(new Font("Times new Roman", Font.BOLD, 15));
    fechaSolicitudText.setText(getFechaActual());
    panel2.add(fechaSolicitudText);

    numeroSolicitudText.setBounds(250, 250, 200, 30);
    numeroSolicitudText.setBackground(new Color(255, 255, 255));
    numeroSolicitudText.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(numeroSolicitudText);
    numeroSolicitudText.setText("CD" + numeroCredito);

    regresar.setBounds(50, 650, 150, 40);
    regresar.setBackground(new Color(135, 206, 250));
    regresar.setFont(new Font("Times new Roman", Font.BOLD, 16));
    regresar.setForeground(new Color(0, 0, 0));
    panel2.add(regresar);
    regresar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        panel2.setVisible(false);
        panel.setVisible(true);
      }
    });

    registraSolicitudCredito.setBounds(300, 650, 280, 40);
    registraSolicitudCredito.setBackground(new Color(135, 206, 250));
    registraSolicitudCredito.setFont(new Font("Times new Roman", Font.BOLD, 16));
    registraSolicitudCredito.setForeground(new Color(0, 0, 0));
    panel2.add(registraSolicitudCredito);
    registraSolicitudCredito.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String tipoCredito = tipoCreditoBox.getSelectedItem().toString();
        String monto = montoTexT.getText();
        String moneda = tipoMonedaBox.getSelectedItem().toString();
        String fechaSolicitud = fechaSolicitudText.getText();
        String numeroSolicitud = numeroSolicitudText.getText();
        if (!tipoCredito.equals("") && !monto.equals("") && !moneda.equals("") && !fechaSolicitud.equals("")
            && !numeroSolicitud.equals("")) {
          if ("Colon".equals(moneda)) {
            if (tipoCredito.equals("Credito Personal")) {
              // CreditoPersonal creditoPersonal = new CreditoPersonal(monto, TMoneda.COLONES,
              // fechaSolicitud, numeroSolicitud);
            }
            if (tipoCredito.equals("Credito Fiduciario")) {

            }
            if (tipoCredito.equals("Credito Hipotecario")) {

            }
            if (tipoCredito.equals("Credito Prendario")) {

            }
          } else {
            if (tipoCredito.equals("Credito Personal")) {
              // C reditoPersonal creditoPersonal = new CreditoPersonal(monto,TMoneda.DOLARES
              /// fechaSolicitud, numeroSolicitud);
            }
            if (tipoCredito.equals("Credito Fiduciario")) {

            }
            if (tipoCredito.equals("Credito Hipotecario")) {

            }
            if (tipoCredito.equals("Credito Prendario")) {

            }
          }

        } else {
          JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }
      }
    });
  }

  private String getFechaActual() {
    Date fecha = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    return formato.format(fecha);
  }

  private void menuCacularCreditoHipotecarioEnColon() {
    JPanel panel2 = new JPanel();
    JButton regresar = new JButton("Regresar");
    JLabel labelCredito = new JLabel("Calculo del Credito Hipotecario en colones  con tasa indexada");
    JTextArea textArea = new JTextArea();
    JLabel labelMonto = new JLabel(" Monto inicial ");
    JLabel labelMonto2 = new JLabel(" a solicitar ");
    JLabel labelCosto = new JLabel(" Costo de avalúo ");
    JLabel labelCosto2 = new JLabel(" para creditos");
    JLabel labelCosto3 = new JLabel("hipotecarios ");
    JLabel labelFormalizacion = new JLabel("Formalización");
    JLabel labelHonorarios = new JLabel("Honorarios legales con");
    JLabel labelHonorarios2 = new JLabel("respecto al monto incial a");
    JLabel labelHonorarios3 = new JLabel("solicitar ");
    JLabel labelMontoFinal = new JLabel("Monto final a solicitar");
    JButton calcular = new JButton("Calcular");
    JComboBox<String> creditoHipotecario = new JComboBox<String>();

    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 153, 153));
    panel2.setBounds(0, 0, 800, 700);
    this.add(panel2);
    setBounds(350, 0, 800, 850);

    labelCredito.setBounds(50, 50, 500, 20);
    labelCredito.setBackground(new Color(0, 153, 153));
    labelCredito.setFont(new Font("Times new Roman", Font.BOLD, 20));
    panel2.add(labelCredito);

    creditoHipotecario.setBounds(50, 100, 200, 30);
    creditoHipotecario.setBackground(new Color(255, 255, 255));
    creditoHipotecario.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(creditoHipotecario);

    labelMonto.setBounds(50, 150, 200, 20);
    labelMonto.setBackground(new Color(0, 153, 153));
    labelMonto.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMonto);

    labelMonto2.setBounds(50, 180, 200, 20);
    labelMonto2.setBackground(new Color(0, 153, 153));
    labelMonto2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMonto2);

    labelCosto.setBounds(200, 150, 200, 20);
    labelCosto.setBackground(new Color(0, 153, 153));
    labelCosto.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto);

    labelCosto2.setBounds(200, 180, 200, 20);
    labelCosto2.setBackground(new Color(0, 153, 153));
    labelCosto2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto2);

    labelCosto3.setBounds(200, 210, 200, 20);
    labelCosto3.setBackground(new Color(0, 153, 153));
    labelCosto3.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto3);

    labelFormalizacion.setBounds(350, 150, 200, 20);
    labelFormalizacion.setBackground(new Color(0, 153, 153));
    labelFormalizacion.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelFormalizacion);

    labelHonorarios.setBounds(450, 150, 200, 20);
    labelHonorarios.setBackground(new Color(0, 153, 153));
    labelHonorarios.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios);

    labelHonorarios2.setBounds(450, 180, 200, 20);
    labelHonorarios2.setBackground(new Color(0, 153, 153));
    labelHonorarios2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios2);

    labelHonorarios3.setBounds(450, 210, 200, 20);
    labelHonorarios3.setBackground(new Color(0, 153, 153));
    labelHonorarios3.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios3);

    labelMontoFinal.setBounds(600, 150, 200, 20);
    labelMontoFinal.setBackground(new Color(0, 153, 153));
    labelMontoFinal.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMontoFinal);

    textArea.setBounds(50, 250, 700, 300);
    textArea.setBackground(new Color(255, 255, 255));
    textArea.setFont(new Font("Times new Roman", Font.BOLD, 15));

    panel2.add(textArea);

    calcular.setBounds(50, 620, 200, 30);
    calcular.setBackground(new Color(135, 206, 250));
    calcular.setFont(new Font("Times new Roman", Font.BOLD, 16));
    calcular.setForeground(new Color(0, 0, 0));
    panel2.add(calcular);

    regresar.setBounds(50, 720, 150, 40);
    regresar.setBackground(new Color(135, 206, 250));
    regresar.setFont(new Font("Times new Roman", Font.BOLD, 16));
    regresar.setForeground(new Color(0, 0, 0));
    panel2.add(regresar);

    calcular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String datos = "";
        textArea.setText(datos);
      }
    });

    regresar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }
    });

  }

  // debo editar las etiquetas para que sean mas faciles de leer
  private void menuCacularCreditoHipotecarioEnDolar() {
    JPanel panel2 = new JPanel();
    JButton regresar = new JButton("Regresar");
    JLabel labelCredito = new JLabel("Calculo del Credito Hipotecario en dolares con tasa indexada");
    JTextArea textArea = new JTextArea();
    JLabel labelMonto = new JLabel(" Monto inicial ");
    JLabel labelMonto2 = new JLabel(" a solicitar ");
    JLabel labelCosto = new JLabel(" Costo de avalúo ");
    JLabel labelCosto2 = new JLabel(" para creditos");
    JLabel labelCosto3 = new JLabel("hipotecarios ");
    JLabel labelFormalizacion = new JLabel("Formalización");
    JLabel labelHonorarios = new JLabel("Honorarios legales con");
    JLabel labelHonorarios2 = new JLabel("respecto al monto incial a");
    JLabel labelHonorarios3 = new JLabel("solicitar ");
    JLabel labelMontoFinal = new JLabel("Monto final a solicitar");
    JButton calcular = new JButton("Calcular");
    JComboBox<String> creditoHipotecario = new JComboBox<String>();

    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 153, 153));
    panel2.setBounds(0, 0, 800, 700);
    this.add(panel2);
    setBounds(350, 0, 800, 850);

    labelCredito.setBounds(50, 50, 500, 20);
    labelCredito.setBackground(new Color(0, 153, 153));
    labelCredito.setFont(new Font("Times new Roman", Font.BOLD, 20));
    panel2.add(labelCredito);

    creditoHipotecario.setBounds(50, 100, 200, 30);
    creditoHipotecario.setBackground(new Color(255, 255, 255));
    creditoHipotecario.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(creditoHipotecario);

    labelMonto.setBounds(50, 150, 200, 20);
    labelMonto.setBackground(new Color(0, 153, 153));
    labelMonto.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMonto);

    labelMonto2.setBounds(50, 180, 200, 20);
    labelMonto2.setBackground(new Color(0, 153, 153));
    labelMonto2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMonto2);

    labelCosto.setBounds(200, 150, 200, 20);
    labelCosto.setBackground(new Color(0, 153, 153));
    labelCosto.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto);

    labelCosto2.setBounds(200, 180, 200, 20);
    labelCosto2.setBackground(new Color(0, 153, 153));
    labelCosto2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto2);

    labelCosto3.setBounds(200, 210, 200, 20);
    labelCosto3.setBackground(new Color(0, 153, 153));
    labelCosto3.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto3);

    labelFormalizacion.setBounds(350, 150, 200, 20);
    labelFormalizacion.setBackground(new Color(0, 153, 153));
    labelFormalizacion.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelFormalizacion);

    labelHonorarios.setBounds(450, 150, 200, 20);
    labelHonorarios.setBackground(new Color(0, 153, 153));
    labelHonorarios.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios);

    labelHonorarios2.setBounds(450, 180, 200, 20);
    labelHonorarios2.setBackground(new Color(0, 153, 153));
    labelHonorarios2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios2);

    labelHonorarios3.setBounds(450, 210, 200, 20);
    labelHonorarios3.setBackground(new Color(0, 153, 153));
    labelHonorarios3.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios3);

    labelMontoFinal.setBounds(600, 150, 200, 20);
    labelMontoFinal.setBackground(new Color(0, 153, 153));
    labelMontoFinal.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMontoFinal);

    textArea.setBounds(50, 250, 700, 300);
    textArea.setBackground(new Color(255, 255, 255));
    textArea.setFont(new Font("Times new Roman", Font.BOLD, 15));

    panel2.add(textArea);

    calcular.setBounds(50, 620, 200, 30);
    calcular.setBackground(new Color(135, 206, 250));
    calcular.setFont(new Font("Times new Roman", Font.BOLD, 16));
    calcular.setForeground(new Color(0, 0, 0));
    panel2.add(calcular);

    regresar.setBounds(50, 720, 150, 40);
    regresar.setBackground(new Color(135, 206, 250));
    regresar.setFont(new Font("Times new Roman", Font.BOLD, 16));
    regresar.setForeground(new Color(0, 0, 0));
    panel2.add(regresar);

    calcular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String datos = "";
        textArea.setText(datos);
      }
    });

    regresar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }
    });
  }

  // debo editar las etiqueta
  private void menuCacularCreditoFiduciarioEnColon() {
    JPanel panel2 = new JPanel();
    JButton regresar = new JButton("Regresar");
    JLabel labelCredito = new JLabel("Calculo del Credito Fiduciario en Colón con tasa fija");
    JTextArea textArea = new JTextArea();
    JLabel labelMonto = new JLabel(" Monto inicial ");
    JLabel labelMonto2 = new JLabel(" a solicitar ");
    JLabel labelCosto = new JLabel(" Costo de avalúo ");
    JLabel labelCosto2 = new JLabel(" para creditos");
    JLabel labelCosto3 = new JLabel("hipotecarios ");
    JLabel labelFormalizacion = new JLabel("Formalización");
    JLabel labelHonorarios = new JLabel("Honorarios legales con");
    JLabel labelHonorarios2 = new JLabel("respecto al monto incial a");
    JLabel labelHonorarios3 = new JLabel("solicitar ");
    JLabel labelMontoFinal = new JLabel("Monto final a solicitar");
    JButton calcular = new JButton("Calcular");
    JComboBox<String> creditoHipotecario = new JComboBox<String>();

    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 153, 153));
    panel2.setBounds(0, 0, 800, 700);
    this.add(panel2);
    setBounds(350, 0, 800, 850);

    labelCredito.setBounds(50, 50, 500, 20);
    labelCredito.setBackground(new Color(0, 153, 153));
    labelCredito.setFont(new Font("Times new Roman", Font.BOLD, 20));
    panel2.add(labelCredito);

    creditoHipotecario.setBounds(50, 100, 200, 30);
    creditoHipotecario.setBackground(new Color(255, 255, 255));
    creditoHipotecario.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(creditoHipotecario);

    labelMonto.setBounds(50, 150, 200, 20);
    labelMonto.setBackground(new Color(0, 153, 153));
    labelMonto.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMonto);

    labelMonto2.setBounds(50, 180, 200, 20);
    labelMonto2.setBackground(new Color(0, 153, 153));
    labelMonto2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMonto2);

    labelCosto.setBounds(200, 150, 200, 20);
    labelCosto.setBackground(new Color(0, 153, 153));
    labelCosto.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto);

    labelCosto2.setBounds(200, 180, 200, 20);
    labelCosto2.setBackground(new Color(0, 153, 153));
    labelCosto2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto2);

    labelCosto3.setBounds(200, 210, 200, 20);
    labelCosto3.setBackground(new Color(0, 153, 153));
    labelCosto3.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto3);

    labelFormalizacion.setBounds(350, 150, 200, 20);
    labelFormalizacion.setBackground(new Color(0, 153, 153));
    labelFormalizacion.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelFormalizacion);

    labelHonorarios.setBounds(450, 150, 200, 20);
    labelHonorarios.setBackground(new Color(0, 153, 153));
    labelHonorarios.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios);

    labelHonorarios2.setBounds(450, 180, 200, 20);
    labelHonorarios2.setBackground(new Color(0, 153, 153));
    labelHonorarios2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios2);

    labelHonorarios3.setBounds(450, 210, 200, 20);
    labelHonorarios3.setBackground(new Color(0, 153, 153));
    labelHonorarios3.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios3);

    labelMontoFinal.setBounds(600, 150, 200, 20);
    labelMontoFinal.setBackground(new Color(0, 153, 153));
    labelMontoFinal.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMontoFinal);

    textArea.setBounds(50, 250, 700, 300);
    textArea.setBackground(new Color(255, 255, 255));
    textArea.setFont(new Font("Times new Roman", Font.BOLD, 15));

    panel2.add(textArea);

    calcular.setBounds(50, 620, 200, 30);
    calcular.setBackground(new Color(135, 206, 250));
    calcular.setFont(new Font("Times new Roman", Font.BOLD, 16));
    calcular.setForeground(new Color(0, 0, 0));
    panel2.add(calcular);

    regresar.setBounds(50, 720, 150, 40);
    regresar.setBackground(new Color(135, 206, 250));
    regresar.setFont(new Font("Times new Roman", Font.BOLD, 16));
    regresar.setForeground(new Color(0, 0, 0));
    panel2.add(regresar);

    calcular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String datos = "";
        textArea.setText(datos);
      }
    });

    regresar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }
    });
  }

  private void menuCalcularCreditoFiduciarioEnDolar() {
    JPanel panel2 = new JPanel();
    JButton regresar = new JButton("Regresar");
    JLabel labelCredito = new JLabel("Calculo del Credito Fiduciario en dolar con tasa fija");
    JTextArea textArea = new JTextArea();
    JLabel labelMonto = new JLabel(" Monto inicial ");
    JLabel labelMonto2 = new JLabel(" a solicitar ");
    JLabel labelCosto = new JLabel(" Costo de avalúo ");
    JLabel labelCosto2 = new JLabel(" para creditos");
    JLabel labelCosto3 = new JLabel("hipotecarios ");
    JLabel labelFormalizacion = new JLabel("Formalización");
    JLabel labelHonorarios = new JLabel("Honorarios legales con");
    JLabel labelHonorarios2 = new JLabel("respecto al monto incial a");
    JLabel labelHonorarios3 = new JLabel("solicitar ");
    JLabel labelMontoFinal = new JLabel("Monto final a solicitar");
    JButton calcular = new JButton("Calcular");
    JComboBox<String> creditoHipotecario = new JComboBox<String>();

    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 153, 153));
    panel2.setBounds(0, 0, 800, 700);
    this.add(panel2);
    setBounds(350, 0, 800, 850);

    labelCredito.setBounds(50, 50, 500, 20);
    labelCredito.setBackground(new Color(0, 153, 153));
    labelCredito.setFont(new Font("Times new Roman", Font.BOLD, 20));
    panel2.add(labelCredito);

    creditoHipotecario.setBounds(50, 100, 200, 30);
    creditoHipotecario.setBackground(new Color(255, 255, 255));
    creditoHipotecario.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(creditoHipotecario);

    labelMonto.setBounds(50, 150, 200, 20);
    labelMonto.setBackground(new Color(0, 153, 153));
    labelMonto.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMonto);

    labelMonto2.setBounds(50, 180, 200, 20);
    labelMonto2.setBackground(new Color(0, 153, 153));
    labelMonto2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMonto2);

    labelCosto.setBounds(200, 150, 200, 20);
    labelCosto.setBackground(new Color(0, 153, 153));
    labelCosto.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto);

    labelCosto2.setBounds(200, 180, 200, 20);
    labelCosto2.setBackground(new Color(0, 153, 153));
    labelCosto2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto2);

    labelCosto3.setBounds(200, 210, 200, 20);
    labelCosto3.setBackground(new Color(0, 153, 153));
    labelCosto3.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto3);

    labelFormalizacion.setBounds(350, 150, 200, 20);
    labelFormalizacion.setBackground(new Color(0, 153, 153));
    labelFormalizacion.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelFormalizacion);

    labelHonorarios.setBounds(450, 150, 200, 20);
    labelHonorarios.setBackground(new Color(0, 153, 153));
    labelHonorarios.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios);

    labelHonorarios2.setBounds(450, 180, 200, 20);
    labelHonorarios2.setBackground(new Color(0, 153, 153));
    labelHonorarios2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios2);

    labelHonorarios3.setBounds(450, 210, 200, 20);
    labelHonorarios3.setBackground(new Color(0, 153, 153));
    labelHonorarios3.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios3);

    labelMontoFinal.setBounds(600, 150, 200, 20);
    labelMontoFinal.setBackground(new Color(0, 153, 153));
    labelMontoFinal.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMontoFinal);

    textArea.setBounds(50, 250, 700, 300);
    textArea.setBackground(new Color(255, 255, 255));
    textArea.setFont(new Font("Times new Roman", Font.BOLD, 15));

    panel2.add(textArea);

    calcular.setBounds(50, 620, 200, 30);
    calcular.setBackground(new Color(135, 206, 250));
    calcular.setFont(new Font("Times new Roman", Font.BOLD, 16));
    calcular.setForeground(new Color(0, 0, 0));
    panel2.add(calcular);

    regresar.setBounds(50, 720, 150, 40);
    regresar.setBackground(new Color(135, 206, 250));
    regresar.setFont(new Font("Times new Roman", Font.BOLD, 16));
    regresar.setForeground(new Color(0, 0, 0));
    panel2.add(regresar);

    calcular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String datos = "";
        textArea.setText(datos);
      }
    });

    regresar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }
    });
  }

  private void menuCalcularCreditoPrendarioEnColon() {
    JPanel panel2 = new JPanel();
    JButton regresar = new JButton("Regresar");
    JLabel labelCredito = new JLabel("Calculo del Credito prendario en colones con tasa fija");
    JTextArea textArea = new JTextArea();
    JLabel labelMonto = new JLabel(" Monto inicial ");
    JLabel labelMonto2 = new JLabel(" a solicitar ");
    JLabel labelCosto = new JLabel(" Costo de avalúo ");
    JLabel labelCosto2 = new JLabel(" para creditos");
    JLabel labelCosto3 = new JLabel("hipotecarios ");
    JLabel labelFormalizacion = new JLabel("Formalización");
    JLabel labelHonorarios = new JLabel("Honorarios legales con");
    JLabel labelHonorarios2 = new JLabel("respecto al monto incial a");
    JLabel labelHonorarios3 = new JLabel("solicitar ");
    JLabel labelMontoFinal = new JLabel("Monto final a solicitar");
    JButton calcular = new JButton("Calcular");
    JComboBox<String> creditoHipotecario = new JComboBox<String>();

    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 153, 153));
    panel2.setBounds(0, 0, 800, 700);
    this.add(panel2);
    setBounds(350, 0, 800, 850);

    labelCredito.setBounds(50, 50, 500, 20);
    labelCredito.setBackground(new Color(0, 153, 153));
    labelCredito.setFont(new Font("Times new Roman", Font.BOLD, 20));
    panel2.add(labelCredito);

    creditoHipotecario.setBounds(50, 100, 200, 30);
    creditoHipotecario.setBackground(new Color(255, 255, 255));
    creditoHipotecario.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(creditoHipotecario);

    labelMonto.setBounds(50, 150, 200, 20);
    labelMonto.setBackground(new Color(0, 153, 153));
    labelMonto.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMonto);

    labelMonto2.setBounds(50, 180, 200, 20);
    labelMonto2.setBackground(new Color(0, 153, 153));
    labelMonto2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMonto2);

    labelCosto.setBounds(200, 150, 200, 20);
    labelCosto.setBackground(new Color(0, 153, 153));
    labelCosto.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto);

    labelCosto2.setBounds(200, 180, 200, 20);
    labelCosto2.setBackground(new Color(0, 153, 153));
    labelCosto2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto2);

    labelCosto3.setBounds(200, 210, 200, 20);
    labelCosto3.setBackground(new Color(0, 153, 153));
    labelCosto3.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto3);

    labelFormalizacion.setBounds(350, 150, 200, 20);
    labelFormalizacion.setBackground(new Color(0, 153, 153));
    labelFormalizacion.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelFormalizacion);

    labelHonorarios.setBounds(450, 150, 200, 20);
    labelHonorarios.setBackground(new Color(0, 153, 153));
    labelHonorarios.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios);

    labelHonorarios2.setBounds(450, 180, 200, 20);
    labelHonorarios2.setBackground(new Color(0, 153, 153));
    labelHonorarios2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios2);

    labelHonorarios3.setBounds(450, 210, 200, 20);
    labelHonorarios3.setBackground(new Color(0, 153, 153));
    labelHonorarios3.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios3);

    labelMontoFinal.setBounds(600, 150, 200, 20);
    labelMontoFinal.setBackground(new Color(0, 153, 153));
    labelMontoFinal.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMontoFinal);

    textArea.setBounds(50, 250, 700, 300);
    textArea.setBackground(new Color(255, 255, 255));
    textArea.setFont(new Font("Times new Roman", Font.BOLD, 15));

    panel2.add(textArea);

    calcular.setBounds(50, 620, 200, 30);
    calcular.setBackground(new Color(135, 206, 250));
    calcular.setFont(new Font("Times new Roman", Font.BOLD, 16));
    calcular.setForeground(new Color(0, 0, 0));
    panel2.add(calcular);

    regresar.setBounds(50, 720, 150, 40);
    regresar.setBackground(new Color(135, 206, 250));
    regresar.setFont(new Font("Times new Roman", Font.BOLD, 16));
    regresar.setForeground(new Color(0, 0, 0));
    panel2.add(regresar);

    calcular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String datos = "";
        textArea.setText(datos);
      }
    });

    regresar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }
    });
  }

  private void menuCalcularCreditoPrendarioDolar() {
    JPanel panel2 = new JPanel();
    JButton regresar = new JButton("Regresar");
    JLabel labelCredito = new JLabel("Calculo del Credito prendario en dolares con tasa fija");
    JTextArea textArea = new JTextArea();
    JLabel labelMonto = new JLabel(" Monto inicial ");
    JLabel labelMonto2 = new JLabel(" a solicitar ");
    JLabel labelCosto = new JLabel(" Costo de avalúo ");
    JLabel labelCosto2 = new JLabel(" para creditos");
    JLabel labelCosto3 = new JLabel("hipotecarios ");
    JLabel labelFormalizacion = new JLabel("Formalización");
    JLabel labelHonorarios = new JLabel("Honorarios legales con");
    JLabel labelHonorarios2 = new JLabel("respecto al monto incial a");
    JLabel labelHonorarios3 = new JLabel("solicitar ");
    JLabel labelMontoFinal = new JLabel("Monto final a solicitar");
    JButton calcular = new JButton("Calcular");
    JComboBox<String> creditoHipotecario = new JComboBox<String>();

    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 153, 153));
    panel2.setBounds(0, 0, 800, 700);
    this.add(panel2);
    setBounds(350, 0, 800, 850);

    labelCredito.setBounds(50, 50, 500, 20);
    labelCredito.setBackground(new Color(0, 153, 153));
    labelCredito.setFont(new Font("Times new Roman", Font.BOLD, 20));
    panel2.add(labelCredito);

    creditoHipotecario.setBounds(50, 100, 200, 30);
    creditoHipotecario.setBackground(new Color(255, 255, 255));
    creditoHipotecario.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(creditoHipotecario);

    labelMonto.setBounds(50, 150, 200, 20);
    labelMonto.setBackground(new Color(0, 153, 153));
    labelMonto.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMonto);

    labelMonto2.setBounds(50, 180, 200, 20);
    labelMonto2.setBackground(new Color(0, 153, 153));
    labelMonto2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMonto2);

    labelCosto.setBounds(200, 150, 200, 20);
    labelCosto.setBackground(new Color(0, 153, 153));
    labelCosto.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto);

    labelCosto2.setBounds(200, 180, 200, 20);
    labelCosto2.setBackground(new Color(0, 153, 153));
    labelCosto2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto2);

    labelCosto3.setBounds(200, 210, 200, 20);
    labelCosto3.setBackground(new Color(0, 153, 153));
    labelCosto3.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto3);

    labelFormalizacion.setBounds(350, 150, 200, 20);
    labelFormalizacion.setBackground(new Color(0, 153, 153));
    labelFormalizacion.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelFormalizacion);

    labelHonorarios.setBounds(450, 150, 200, 20);
    labelHonorarios.setBackground(new Color(0, 153, 153));
    labelHonorarios.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios);

    labelHonorarios2.setBounds(450, 180, 200, 20);
    labelHonorarios2.setBackground(new Color(0, 153, 153));
    labelHonorarios2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios2);

    labelHonorarios3.setBounds(450, 210, 200, 20);
    labelHonorarios3.setBackground(new Color(0, 153, 153));
    labelHonorarios3.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios3);

    labelMontoFinal.setBounds(600, 150, 200, 20);
    labelMontoFinal.setBackground(new Color(0, 153, 153));
    labelMontoFinal.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMontoFinal);

    textArea.setBounds(50, 250, 700, 300);
    textArea.setBackground(new Color(255, 255, 255));
    textArea.setFont(new Font("Times new Roman", Font.BOLD, 15));

    panel2.add(textArea);

    calcular.setBounds(50, 620, 200, 30);
    calcular.setBackground(new Color(135, 206, 250));
    calcular.setFont(new Font("Times new Roman", Font.BOLD, 16));
    calcular.setForeground(new Color(0, 0, 0));
    panel2.add(calcular);

    regresar.setBounds(50, 720, 150, 40);
    regresar.setBackground(new Color(135, 206, 250));
    regresar.setFont(new Font("Times new Roman", Font.BOLD, 16));
    regresar.setForeground(new Color(0, 0, 0));
    panel2.add(regresar);

    calcular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String datos = "";
        textArea.setText(datos);
      }
    });

    regresar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }
    });
  }

  private void menuCalcularCreditoPersonalEnColones() {
    JPanel panel2 = new JPanel();
    JButton regresar = new JButton("Regresar");
    JLabel labelCredito = new JLabel("Calculo del Credito Personal en colones con tasa fija");
    JTextArea textArea = new JTextArea();
    JLabel labelMonto = new JLabel(" Monto inicial ");
    JLabel labelMonto2 = new JLabel(" a solicitar ");
    JLabel labelCosto = new JLabel(" Costo de avalúo ");
    JLabel labelCosto2 = new JLabel(" para creditos");
    JLabel labelCosto3 = new JLabel("hipotecarios ");
    JLabel labelFormalizacion = new JLabel("Formalización");
    JLabel labelHonorarios = new JLabel("Honorarios legales con");
    JLabel labelHonorarios2 = new JLabel("respecto al monto incial a");
    JLabel labelHonorarios3 = new JLabel("solicitar ");
    JLabel labelMontoFinal = new JLabel("Monto final a solicitar");
    JButton calcular = new JButton("Calcular");
    JComboBox<String> creditoHipotecario = new JComboBox<String>();

    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 153, 153));
    panel2.setBounds(0, 0, 800, 700);
    this.add(panel2);
    setBounds(350, 0, 800, 850);

    labelCredito.setBounds(50, 50, 500, 20);
    labelCredito.setBackground(new Color(0, 153, 153));
    labelCredito.setFont(new Font("Times new Roman", Font.BOLD, 20));
    panel2.add(labelCredito);

    creditoHipotecario.setBounds(50, 100, 200, 30);
    creditoHipotecario.setBackground(new Color(255, 255, 255));
    creditoHipotecario.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(creditoHipotecario);

    labelMonto.setBounds(50, 150, 200, 20);
    labelMonto.setBackground(new Color(0, 153, 153));
    labelMonto.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMonto);

    labelMonto2.setBounds(50, 180, 200, 20);
    labelMonto2.setBackground(new Color(0, 153, 153));
    labelMonto2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMonto2);

    labelCosto.setBounds(200, 150, 200, 20);
    labelCosto.setBackground(new Color(0, 153, 153));
    labelCosto.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto);

    labelCosto2.setBounds(200, 180, 200, 20);
    labelCosto2.setBackground(new Color(0, 153, 153));
    labelCosto2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto2);

    labelCosto3.setBounds(200, 210, 200, 20);
    labelCosto3.setBackground(new Color(0, 153, 153));
    labelCosto3.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto3);

    labelFormalizacion.setBounds(350, 150, 200, 20);
    labelFormalizacion.setBackground(new Color(0, 153, 153));
    labelFormalizacion.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelFormalizacion);

    labelHonorarios.setBounds(450, 150, 200, 20);
    labelHonorarios.setBackground(new Color(0, 153, 153));
    labelHonorarios.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios);

    labelHonorarios2.setBounds(450, 180, 200, 20);
    labelHonorarios2.setBackground(new Color(0, 153, 153));
    labelHonorarios2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios2);

    labelHonorarios3.setBounds(450, 210, 200, 20);
    labelHonorarios3.setBackground(new Color(0, 153, 153));
    labelHonorarios3.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios3);

    labelMontoFinal.setBounds(600, 150, 200, 20);
    labelMontoFinal.setBackground(new Color(0, 153, 153));
    labelMontoFinal.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMontoFinal);

    textArea.setBounds(50, 250, 700, 300);
    textArea.setBackground(new Color(255, 255, 255));
    textArea.setFont(new Font("Times new Roman", Font.BOLD, 15));

    panel2.add(textArea);

    calcular.setBounds(50, 620, 200, 30);
    calcular.setBackground(new Color(135, 206, 250));
    calcular.setFont(new Font("Times new Roman", Font.BOLD, 16));
    calcular.setForeground(new Color(0, 0, 0));
    panel2.add(calcular);

    regresar.setBounds(50, 720, 150, 40);
    regresar.setBackground(new Color(135, 206, 250));
    regresar.setFont(new Font("Times new Roman", Font.BOLD, 16));
    regresar.setForeground(new Color(0, 0, 0));
    panel2.add(regresar);

    calcular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String datos = "";
        textArea.setText(datos);
      }
    });

    regresar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }
    });
  }

  private void menuCalcularCreditoPersonalEnDolar() {
    JPanel panel2 = new JPanel();
    JButton regresar = new JButton("Regresar");
    JLabel labelCredito = new JLabel("Calculo del Credito Personal en dolares con tasa fija");
    JTextArea textArea = new JTextArea();
    JLabel labelMonto = new JLabel(" Monto inicial ");
    JLabel labelMonto2 = new JLabel(" a solicitar ");
    JLabel labelCosto = new JLabel(" Costo de avalúo ");
    JLabel labelCosto2 = new JLabel(" para creditos");
    JLabel labelCosto3 = new JLabel("hipotecarios ");
    JLabel labelFormalizacion = new JLabel("Formalización");
    JLabel labelHonorarios = new JLabel("Honorarios legales con");
    JLabel labelHonorarios2 = new JLabel("respecto al monto incial a");
    JLabel labelHonorarios3 = new JLabel("solicitar ");
    JLabel labelMontoFinal = new JLabel("Monto final a solicitar");
    JButton calcular = new JButton("Calcular");
    JComboBox<String> creditoHipotecario = new JComboBox<String>();

    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 153, 153));
    panel2.setBounds(0, 0, 800, 700);
    this.add(panel2);
    setBounds(350, 0, 800, 850);

    labelCredito.setBounds(50, 50, 500, 20);
    labelCredito.setBackground(new Color(0, 153, 153));
    labelCredito.setFont(new Font("Times new Roman", Font.BOLD, 20));
    panel2.add(labelCredito);

    creditoHipotecario.setBounds(50, 100, 200, 30);
    creditoHipotecario.setBackground(new Color(255, 255, 255));
    creditoHipotecario.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(creditoHipotecario);

    labelMonto.setBounds(50, 150, 200, 20);
    labelMonto.setBackground(new Color(0, 153, 153));
    labelMonto.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMonto);

    labelMonto2.setBounds(50, 180, 200, 20);
    labelMonto2.setBackground(new Color(0, 153, 153));
    labelMonto2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMonto2);

    labelCosto.setBounds(200, 150, 200, 20);
    labelCosto.setBackground(new Color(0, 153, 153));
    labelCosto.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto);

    labelCosto2.setBounds(200, 180, 200, 20);
    labelCosto2.setBackground(new Color(0, 153, 153));
    labelCosto2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto2);

    labelCosto3.setBounds(200, 210, 200, 20);
    labelCosto3.setBackground(new Color(0, 153, 153));
    labelCosto3.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCosto3);

    labelFormalizacion.setBounds(350, 150, 200, 20);
    labelFormalizacion.setBackground(new Color(0, 153, 153));
    labelFormalizacion.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelFormalizacion);

    labelHonorarios.setBounds(450, 150, 200, 20);
    labelHonorarios.setBackground(new Color(0, 153, 153));
    labelHonorarios.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios);

    labelHonorarios2.setBounds(450, 180, 200, 20);
    labelHonorarios2.setBackground(new Color(0, 153, 153));
    labelHonorarios2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios2);

    labelHonorarios3.setBounds(450, 210, 200, 20);
    labelHonorarios3.setBackground(new Color(0, 153, 153));
    labelHonorarios3.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelHonorarios3);

    labelMontoFinal.setBounds(600, 150, 200, 20);
    labelMontoFinal.setBackground(new Color(0, 153, 153));
    labelMontoFinal.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelMontoFinal);

    textArea.setBounds(50, 250, 700, 300);
    textArea.setBackground(new Color(255, 255, 255));
    textArea.setFont(new Font("Times new Roman", Font.BOLD, 15));

    panel2.add(textArea);

    calcular.setBounds(50, 620, 200, 30);
    calcular.setBackground(new Color(135, 206, 250));
    calcular.setFont(new Font("Times new Roman", Font.BOLD, 16));
    calcular.setForeground(new Color(0, 0, 0));
    panel2.add(calcular);

    regresar.setBounds(50, 720, 150, 40);
    regresar.setBackground(new Color(135, 206, 250));
    regresar.setFont(new Font("Times new Roman", Font.BOLD, 16));
    regresar.setForeground(new Color(0, 0, 0));
    panel2.add(regresar);

    calcular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String datos = "";
        textArea.setText(datos);
      }
    });

    regresar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }
    });
  }

  private void menuEnviarCorreo() {
    JPanel panel2 = new JPanel();
    JLabel label = new JLabel("Enviar correo");
    JLabel label2 = new JLabel("Para: ");
    JLabel label3 = new JLabel("Asunto: ");
    JLabel label4 = new JLabel("Mensaje: ");
    JTextField textField = new JTextField();
    JTextField textField2 = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton enviar = new JButton("Enviar");
    JButton regresar = new JButton("Regresar");

    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 153, 153));
    panel2.setBounds(0, 0, 800, 700);
    this.add(panel2);
    setBounds(350, 0, 800, 850);

    label.setBounds(50, 50, 500, 20);
    label.setBackground(new Color(0, 153, 153));
    label.setFont(new Font("Times new Roman", Font.BOLD, 20));
    panel2.add(label);

    label2.setBounds(50, 100, 200, 20);
    label2.setBackground(new Color(0, 153, 153));
    label2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(label2);

    label3.setBounds(50, 150, 200, 20);
    label3.setBackground(new Color(0, 153, 153));
    label3.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(label3);

    label4.setBounds(50, 200, 200, 20);
    label4.setBackground(new Color(0, 153, 153));
    label4.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(label4);

    textField.setBounds(50, 130, 200, 20);
    textField.setBackground(new Color(255, 255, 255));
    textField.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(textField);

    textField2.setBounds(50, 170, 200, 20);
    textField2.setBackground(new Color(255, 255, 255));
    textField2.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(textField2);

    textArea.setBounds(50, 220, 700, 300);
    textArea.setBackground(new Color(255, 255, 255));
    textArea.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(textArea);

    enviar.setBounds(50, 620, 200, 30);
    enviar.setBackground(new Color(135, 206, 250));
    enviar.setFont(new Font("Times new Roman", Font.BOLD, 16));
    enviar.setForeground(new Color(0, 0, 0));
    panel2.add(enviar);

    regresar.setBounds(50, 720, 150, 40);
    regresar.setBackground(new Color(135, 206, 250));
    regresar.setFont(new Font("Times new Roman", Font.BOLD, 16));
    regresar.setForeground(new Color(0, 0, 0));
    panel2.add(regresar);

    enviar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String datos = "";
        textArea.setText(datos);
      }
    });

    regresar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setBounds(350, 0, 700, 850);
        panel.setVisible(true);
        panel2.setVisible(false);
      }
    });

  }

  private void menuCrearPDF() {

  }

}