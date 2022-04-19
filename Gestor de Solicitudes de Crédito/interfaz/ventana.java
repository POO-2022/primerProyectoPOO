package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
          if (tipoCredito.equals("Credito Personal")) {

          }
          if (tipoCredito.equals("Credito Fiduciario")) {

          }
          if (tipoCredito.equals("Credito Hipotecario")) {

          }
          if (tipoCredito.equals("Credito Prendario")) {

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
}
