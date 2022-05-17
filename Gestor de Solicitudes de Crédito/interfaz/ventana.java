package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.fontbox.type1.DamagedFontException;
import javax.mail.MessagingException;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import javax.mail.MessagingException;
import javax.naming.TimeLimitExceededException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import logicadenegocios.BienInmueble;
import logicadenegocios.BienMueble;
import logicadenegocios.CreditoFiduciario;
import logicadenegocios.CreditoHipotecario;
import logicadenegocios.CreditoPersonal;
import logicadenegocios.CreditoPrendario;
import logicadenegocios.CuotaMensual;
import logicadenegocios.Deudor;
import logicadenegocios.Direccion;
import logicadenegocios.Fiador;
import logicadenegocios.TCostosLegales;
import logicadenegocios.TMoneda;
import utilies.Email;
import utilies.JsonManager;
import utilies.PDF;

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
  private ArrayList<Fiador> fiadores;
  private ArrayList<CreditoPersonal> creditosPersonales;
  private ArrayList<CreditoHipotecario> creditosHipotecarios;
  private ArrayList<CreditoFiduciario> creditosFiduciarios;
  private ArrayList<CreditoPrendario> creditosPrendarios;
  private JsonManager jsonManager;
  private Email email;
  private PDF pdf;

  public ventana() {
    solicitantes = new ArrayList<Deudor>();
    creditosPersonales = new ArrayList<CreditoPersonal>();
    creditosHipotecarios = new ArrayList<CreditoHipotecario>();
    creditosFiduciarios = new ArrayList<CreditoFiduciario>();
    creditosPrendarios = new ArrayList<CreditoPrendario>();
    fiadores = new ArrayList<Fiador>();
    jsonManager = new JsonManager();
    email = new Email();
    pdf = new PDF();
    subirSolicitantes();
    subirFiadores();
    subirCreditosPersonales();
    subirCreditosFiduciarios();
    // subirCreditosHipotecarios();
    // CreditoPersonal creditoPersonal = new CreditoPersonal(solicitantes.get(0),
    // 1000000, 5, TMoneda.COLONES, 0.15,
    // 0.05, 0, TCostosLegales.TRASPASO, cuotaMensual, "compra de prenda");
    // creditosPersonales.add(creditoPersonal);
    // jsonManager.agregarCreditoPersonal(creditoPersonal);
    setBounds(350, 0, 700, 850);
    setTitle("Gestion de Creditos");
    initComponents();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public void subirFiadores() {
    String datos = jsonManager.leerJson("fiadores");
    if (datos != null) {
      while (datos.length() > 3) {
        if (datos.contains("{")) {
          int i = datos.indexOf("salario Bruto") + 16;
          double salarioBruto = Double.parseDouble(datos.substring(i, datos.indexOf(",", i)));
          i = datos.indexOf("salario Liquido") + 18;
          double salarioLiquido = Double.parseDouble(datos.substring(i, datos.indexOf(",", i)));
          i = datos.indexOf("nombre") + 10;
          String nombre = datos.substring(i, datos.indexOf("\"", i));
          i = datos.indexOf("telefono") + 12;
          String telefono = datos.substring(i, datos.indexOf("\"", i));
          i = datos.indexOf("\"");
          String cedula = datos.substring(i + 1, datos.indexOf(":", i) - 1);
          Fiador fiador = new Fiador(cedula, nombre, telefono, salarioBruto, salarioLiquido);
          fiadores.add(fiador);
          datos = datos.substring(datos.indexOf("}") + 1, datos.length());
        }
      }
    }
  }

  public void subirCreditosFiduciarios() {
    String datos = jsonManager.leerJson("creditosFiduciarios");
    if (datos != null) {
      while (datos.length() > 3) {
        if (datos.length() > 3) {
          int i = datos.indexOf("Moneda del credito") + 22;
          String moneda = datos.substring(i, datos.indexOf("\"", i));
          i = datos.indexOf("tasa basica pasiva") + 21;
          double tasaBasicaPasiva = Double.parseDouble(datos.substring(i, datos.indexOf(",", i)));
          i = datos.indexOf("tasa de interes") + 18;
          double tasaInteres = Double.parseDouble(datos.substring(i, datos.indexOf(",", i)));
          i = datos.indexOf("tipo costo legales") + 22;
          String tipoCostoLegales = datos.substring(i, datos.indexOf("\"", i));
          i = datos.indexOf("plazo en meses") + 17;
          int plazo = Integer.parseInt(datos.substring(i, datos.indexOf(",", i)));
          i = datos.indexOf("fecha de la solicitud") + 25;
          String fechaSolicitud = datos.substring(i, datos.indexOf("\"", i));
          i = datos.indexOf("comision") + 10;
          double comision = Double.parseDouble(datos.substring(i, datos.indexOf(",", i)));
          i = datos.indexOf("monto Solicitado") + 19;
          double montoSolicitado = Double.parseDouble(datos.substring(i, datos.indexOf(",", i)));
          i = datos.indexOf("cedula del deudor") + 21;
          String cedulaDeudor = datos.substring(i, datos.indexOf("\"", i));
          Deudor deudor = buscarCliente(cedulaDeudor);
          CuotaMensual cuotaMensual2 = null;
          i = datos.indexOf("fiador 1")+12;
          String cedulaFiador1 = datos.substring(i, datos.indexOf("\"", i));
          Fiador fiador1 = buscarFiador(cedulaFiador1);
          i = datos.indexOf("fiador 2")+12;
          String cedulaFiador2 = datos.substring(i, datos.indexOf("\"", i));
          Fiador fiador2 = buscarFiador(cedulaFiador2);
          i = datos.indexOf("\"");
          String codigoCredito = datos.substring(i + 1, datos.indexOf(":", i) - 1);
          ArrayList<Fiador> fiadoresAgregar = new ArrayList<Fiador>();
          fiadoresAgregar.add(fiador1);
          fiadoresAgregar.add(fiador2);
          TMoneda moneda2 = TMoneda.valueOf(moneda);
          TCostosLegales costosLegales = TCostosLegales.valueOf(tipoCostoLegales);
          CreditoFiduciario creditoFiduciario = new CreditoFiduciario(deudor,montoSolicitado,plazo,moneda2,tasaInteres,tasaBasicaPasiva, comision, costosLegales,cuotaMensual2,fiadoresAgregar );
          creditoFiduciario.setCodigoCredito(codigoCredito);
          DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate local_date = LocalDate.parse(fechaSolicitud, JEFormatter);
          creditoFiduciario.setFechaSolicitud(local_date);
          creditosFiduciarios.add(creditoFiduciario);
          datos = datos.substring(datos.indexOf("}") + 1, datos.length());
        }
      }
    }

  }
  public Fiador buscarFiador(String cedulaFiador) {
    for (Fiador fiador : fiadores) {
      if (fiador.getCedula().equals(cedulaFiador)) {
        return fiador;
      }
    }
    return null;
  }

  public void subirCreditosPersonales() {
    String datos = jsonManager.leerJson("creditosPersonal");
    if (datos != null) {
      while (datos.length() > 2) {
        if (datos.length() > 2) {
          int i = datos.indexOf("Moneda del credito") + 22;
          String moneda = datos.substring(i, datos.indexOf("\"", i));
          i = datos.indexOf("tasa basica pasiva") + 21;
          double tasaBasicaPasiva = Double.parseDouble(datos.substring(i, datos.indexOf(",", i)));
          i = datos.indexOf("tasa de interes") + 18;
          double tasaInteres = Double.parseDouble(datos.substring(i, datos.indexOf(",", i)));
          i = datos.indexOf("tipo costo legales") + 22;
          String tipoCostoLegales = datos.substring(i, datos.indexOf("\"", i));
          i = datos.indexOf("plazo en meses") + 17;
          int plazo = Integer.parseInt(datos.substring(i, datos.indexOf(",", i)));
          i = datos.indexOf("fecha de la solicitud") + 25;
          String fechaSolicitud = datos.substring(i, datos.indexOf("\"", i));
          i = datos.indexOf("comision") + 10;
          double comision = Double.parseDouble(datos.substring(i, datos.indexOf(",", i)));
          i = datos.indexOf("monto Solicitado") + 19;
          double montoSolicitado = Double.parseDouble(datos.substring(i, datos.indexOf(",", i)));
          i = datos.indexOf("cedula del deudor") + 21;
          String cedulaDeudor = datos.substring(i, datos.indexOf("\"", i));
          Deudor deudor = buscarCliente(cedulaDeudor);
          CuotaMensual cuotaMensual2 = null;
          i = datos.indexOf("movito de uso") + 17;
          String movitoUso = datos.substring(i, datos.indexOf("\"", i));
          CreditoPersonal creditoPersonal = new CreditoPersonal(deudor, montoSolicitado, plazo, TMoneda.valueOf(moneda),
              tasaBasicaPasiva, tasaInteres, comision, TCostosLegales.valueOf(tipoCostoLegales), cuotaMensual2,
              movitoUso);
          i = datos.indexOf("\"");
          String numSolicitud = datos.substring(i + 1, datos.indexOf(":", i) - 1);
          creditoPersonal.setNumSolicitud(numSolicitud);
          DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
          LocalDate local_date = LocalDate.parse(fechaSolicitud, JEFormatter);
          creditoPersonal.setFechaSolicitud(local_date);
          creditosPersonales.add(creditoPersonal);
          datos = datos.substring(datos.indexOf("}") + 1, datos.length());
        }
      }
    }

  }

  private void subirSolicitantes() {
    String datos = jsonManager.leerJson("deudores");
    if (datos != null) {
      while (datos.length() > 4) {
        if (datos.length() > 2) {
          int i = datos.indexOf("primerNombre") + 16;
          String primerNombre = datos.substring(i, datos.indexOf("\"", i));
          i = datos.indexOf("segundoNombre") + 17;
          String segundoNombre = datos.substring(i, datos.indexOf("\"", i));
          i = datos.indexOf("primerApellido") + 18;
          String primerApellido = datos.substring(i, datos.indexOf("\"", i));
          i = datos.indexOf("segundoApellido") + 19;
          String segundoApellido = datos.substring(i, datos.indexOf("\"", i));
          i = datos.indexOf("salario Bruto") + 16;
          String salarioBruto = datos.substring(i, datos.indexOf(",", i));
          i = datos.indexOf("salario Liquido") + 18;
          String salarioLiquido = datos.substring(i, datos.indexOf(",", i));
          i = datos.indexOf("correo") + 10;
          String correo = datos.substring(i, datos.indexOf("\"", i));
          i = datos.indexOf("telefono") + 12;
          String telefono = datos.substring(i, datos.indexOf("\"", i));
          i = datos.indexOf("provincia") + 13;
          String provincia = datos.substring(i, datos.indexOf("\"", i));
          i = datos.indexOf("canton") + 10;
          String canto = datos.substring(i, datos.indexOf("\"", i));
          i = datos.indexOf("distrito") + 12;
          String distrito = datos.substring(i, datos.indexOf("\"", i));
          i = datos.indexOf("senas") + 9;
          String senas = datos.substring(i, datos.indexOf("\"", i));
          i = datos.indexOf("\"");
          String cedula = datos.substring(i + 1, datos.indexOf(":", i) - 1);
          Direccion direccion = new Direccion(provincia, canto, distrito, senas);
          Deudor deudor = new Deudor(primerNombre, segundoNombre, primerApellido, segundoApellido,
              cedula, direccion, telefono, correo, Double.parseDouble(salarioBruto),
              Double.parseDouble(salarioLiquido));
          solicitantes.add(deudor);
          datos = datos.substring(datos.indexOf("}") + 1, datos.length());
        }
      }
    }
    // System.out.println(solicitantes.size());
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
            jsonManager.agregarDeudor(solicitante);
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
    JLabel etiquetaMoneda = new JLabel("Moneda");
    JLabel etiquetaFechaSolicitud = new JLabel("Fecha de Solicitud");
    JLabel labelTasaPasiva = new JLabel("Interes Pasivo");
    JLabel labelCostoLegales = new JLabel("Costo Legales");
    JLabel etiquetaCliente = new JLabel("Cedula del Cliente");
    JLabel etiquetaComision = new JLabel("Comision");
    JComboBox<String> tCostoLegalesBox = new JComboBox<String>();
    JComboBox<String> tipoCreditoBox = new JComboBox<String>();
    JComboBox<String> tipoMonedaBox = new JComboBox<String>();
    JComboBox<String> clienteBox = new JComboBox<String>();
    JTextField fechaSolicitudText = new JTextField();
    JTextField tasaPasivaText = new JTextField();
    JTextField comisionText = new JTextField();

    tipoCreditoBox.addItem("Credito Personal");
    tipoCreditoBox.addItem("Credito Fiduciario");
    tipoCreditoBox.addItem("Credito Hipotecario");
    tipoCreditoBox.addItem("Credito Prendario");
    tipoMonedaBox.addItem("Colon");
    tipoMonedaBox.addItem("Dolar");
    tCostoLegalesBox.addItem("Traspaso");
    tCostoLegalesBox.addItem("Inscripcion Bien ");
    for (Deudor cliente : solicitantes) {
      clienteBox.addItem(cliente.getCedula());
    }

    panel2.setLayout(null);
    this.add(panel2);
    panel2.setBounds(0, 0, 700, 700);
    panel2.setBackground(new Color(102, 205, 170));

    etiquetaTipoCredito.setBounds(50, 50, 200, 30);
    etiquetaTipoCredito.setBackground(new Color(0, 153, 153));
    etiquetaTipoCredito.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(etiquetaTipoCredito);

    etiquetaMoneda.setBounds(50, 150, 100, 30);
    etiquetaMoneda.setBackground(new Color(0, 153, 153));
    etiquetaMoneda.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(etiquetaMoneda);

    etiquetaFechaSolicitud.setBounds(50, 200, 200, 30);
    etiquetaFechaSolicitud.setBackground(new Color(0, 153, 153));
    etiquetaFechaSolicitud.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(etiquetaFechaSolicitud);

    etiquetaComision.setBounds(50, 250, 100, 30);
    etiquetaComision.setBackground(new Color(0, 153, 153));
    etiquetaComision.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(etiquetaComision);

    labelTasaPasiva.setBounds(50, 350, 200, 30);
    labelTasaPasiva.setBackground(new Color(0, 153, 153));
    labelTasaPasiva.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(labelTasaPasiva);

    labelCostoLegales.setBounds(50, 400, 200, 30);
    labelCostoLegales.setBackground(new Color(0, 153, 153));
    labelCostoLegales.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(labelCostoLegales);

    etiquetaCliente.setBounds(50, 450, 200, 30);
    etiquetaCliente.setBackground(new Color(0, 153, 153));
    etiquetaCliente.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(etiquetaCliente);

    tipoCreditoBox.setBounds(250, 50, 200, 30);
    tipoCreditoBox.setBackground(new Color(255, 255, 255));
    tipoCreditoBox.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(tipoCreditoBox);

    tipoMonedaBox.setBounds(250, 150, 200, 30);
    tipoMonedaBox.setBackground(new Color(255, 255, 255));
    tipoMonedaBox.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(tipoMonedaBox);

    fechaSolicitudText.setBounds(250, 200, 200, 30);
    fechaSolicitudText.setBackground(new Color(255, 255, 255));
    fechaSolicitudText.setFont(new Font("Times new Roman", Font.BOLD, 15));
    fechaSolicitudText.setText(getFechaActual());
    panel2.add(fechaSolicitudText);

    comisionText.setBounds(250, 250, 200, 30);
    comisionText.setBackground(new Color(255, 255, 255));
    comisionText.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(comisionText);

    tasaPasivaText.setBounds(250, 350, 200, 30);
    tasaPasivaText.setBackground(new Color(255, 255, 255));
    tasaPasivaText.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(tasaPasivaText);

    tasaPasivaText.setBounds(250, 350, 200, 30);
    tasaPasivaText.setBackground(new Color(255, 255, 255));
    tasaPasivaText.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(tasaPasivaText);

    tCostoLegalesBox.setBounds(250, 400, 200, 30);
    tCostoLegalesBox.setBackground(new Color(255, 255, 255));
    tCostoLegalesBox.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(tCostoLegalesBox);

    clienteBox.setBounds(250, 450, 200, 30);
    clienteBox.setBackground(new Color(255, 255, 255));
    clienteBox.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(clienteBox);

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
        String moneda = tipoMonedaBox.getSelectedItem().toString();
        String fechaSolicitud = fechaSolicitudText.getText();
        String cedulaCliente = clienteBox.getSelectedItem().toString();
        String tasaPasiva = tasaPasivaText.getText();
        String costoLegales = tCostoLegalesBox.getSelectedItem().toString();
        String comision = comisionText.getText();
        if (!tipoCredito.equals("") && !moneda.equals("") && !fechaSolicitud.equals("")
            && !cedulaCliente.equals("") && !tasaPasiva.equals("")
            && !costoLegales.equals("") && !comision.equals("")) {
          Deudor deudor = buscarCliente(cedulaCliente);
          Double tasaPasivaDouble = Double.parseDouble(tasaPasiva);
          Double comisionDouble = Double.parseDouble(comision);
          if (tipoCredito.equals("Credito Personal")) {
            panel2.setVisible(false);
            ventanaRegistrarCreditoPersonal(deudor, moneda, tasaPasiva, costoLegales, comision);
          }
          if (tipoCredito.equals("Credito Hipotecario")) {
            panel2.setVisible(false);
            ventanaRegistrarCreditoHipotecario(deudor, moneda, tasaPasiva, costoLegales, comision);
          }
          if (tipoCredito.equals("Credito Fiduciario")) {
            if (moneda.equals("Dolares")) {
              if (costoLegales.equals("Traspaso")) {
                panel2.setVisible(false);
                ventanaRegistrarCreditoFiduciario(deudor, TMoneda.DOLARES, tasaPasivaDouble, TCostosLegales.TRASPASO,
                    comisionDouble);
              } else {
                panel2.setVisible(false);
                ventanaRegistrarCreditoFiduciario(deudor, TMoneda.DOLARES, tasaPasivaDouble,
                    TCostosLegales.INSCRIPCION_BIEN, comisionDouble);
              }
            }else {
              if (costoLegales.equals("Traspaso")) {
                panel2.setVisible(false);
                ventanaRegistrarCreditoFiduciario(deudor, TMoneda.COLONES, tasaPasivaDouble, TCostosLegales.TRASPASO,
                    comisionDouble);
              } else {
                panel2.setVisible(false);
                ventanaRegistrarCreditoFiduciario(deudor, TMoneda.COLONES, tasaPasivaDouble,
                    TCostosLegales.INSCRIPCION_BIEN, comisionDouble);
              }
            }
          } 
          if (tipoCredito.equals("Credito Prendario")) {
            if (moneda.equals("Dolares")) {
              if (costoLegales.equals("Traspaso")) {
                panel2.setVisible(false);
                ventanaRegistrarCreditoPrendario(deudor, TMoneda.DOLARES, tasaPasivaDouble, TCostosLegales.TRASPASO,
                    comisionDouble);
              } else{
                panel2.setVisible(false);
                ventanaRegistrarCreditoPrendario(deudor, TMoneda.DOLARES, tasaPasivaDouble,
                TCostosLegales.INSCRIPCION_BIEN, comisionDouble);
              }
            }else{
              if (costoLegales.equals("Traspaso")) {
                panel2.setVisible(false);
                ventanaRegistrarCreditoPrendario(deudor, TMoneda.COLONES, tasaPasivaDouble, TCostosLegales.TRASPASO,
                    comisionDouble);
              } else{
                panel2.setVisible(false);
                ventanaRegistrarCreditoPrendario(deudor, TMoneda.COLONES, tasaPasivaDouble,
                TCostosLegales.INSCRIPCION_BIEN, comisionDouble);
              }
            }   
          }
           else {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
          }
        } else {
          JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }
      }
    });
  }
  private void ventanaRegistrarCreditoPrendario(Deudor pDeudor, TMoneda pMoneda, Double pTasaPasiva,
      TCostosLegales pCostoLegales, Double pComision) {
    JPanel panel2 = new JPanel();
    JLabel titulo = new JLabel("Registrar Credito Prendario");
    JLabel labelTasaInteres = new JLabel("Tasa de Interes");
    JLabel labelMonto = new JLabel("Monto");
    JLabel labelPlazo = new JLabel("Plazo en meses");
    JLabel labelNombreMueble = new JLabel("Nombre del BienMueble");
    JLabel labelValorDelBien = new JLabel("Valor del Bien");
    
    JTextField tasaInteresText = new JTextField();
    JTextField montoText = new JTextField();
    JTextField plazoText = new JTextField();
    JTextField nombreMuebleText = new JTextField();
    JTextField valorBienText = new JTextField();

    JButton registraCredito = new JButton("Registrar Credito");
    JButton cancelar = new JButton("Cancelar");

    panel2.setLayout(null);
    panel2.setBackground(new Color(135, 206, 250));
    panel2.setBounds(0, 0, 600, 700);
    this.add(panel2);
    setBounds(350, 0, 650, 800);

    titulo.setBounds(100, 20, 400, 40);
    titulo.setFont(new Font("Arial", Font.BOLD, 20));
    titulo.setForeground(new Color(0, 0, 0));
    panel2.add(titulo);

    labelTasaInteres.setBounds(50, 100, 200, 30);
    labelTasaInteres.setFont(new Font("Arial", Font.BOLD, 15));
    labelTasaInteres.setForeground(new Color(0, 0, 0));
    panel2.add(labelTasaInteres);

    labelMonto.setBounds(50, 150, 200, 30);
    labelMonto.setFont(new Font("Arial", Font.BOLD, 15));
    labelMonto.setForeground(new Color(0, 0, 0));
    panel2.add(labelMonto);

    labelPlazo.setBounds(50, 200, 200, 30);
    labelPlazo.setFont(new Font("Arial", Font.BOLD, 15));
    labelPlazo.setForeground(new Color(0, 0, 0));
    panel2.add(labelPlazo);

    labelNombreMueble.setBounds(50, 250, 200, 30);
    labelNombreMueble.setFont(new Font("Arial", Font.BOLD, 15));
    labelNombreMueble.setForeground(new Color(0, 0, 0));
    panel2.add(labelNombreMueble);

    labelValorDelBien.setBounds(50, 300, 200, 30);
    labelValorDelBien.setFont(new Font("Arial", Font.BOLD, 15));
    labelValorDelBien.setForeground(new Color(0, 0, 0));
    panel2.add(labelValorDelBien);

    tasaInteresText.setBounds(300, 100, 200, 30);
    tasaInteresText.setFont(new Font("Arial", Font.BOLD, 15));
    tasaInteresText.setForeground(new Color(0, 0, 0));
    panel2.add(tasaInteresText);

    montoText.setBounds(300, 150, 200, 30);
    montoText.setFont(new Font("Arial", Font.BOLD, 15));
    montoText.setForeground(new Color(0, 0, 0));
    panel2.add(montoText);

    plazoText.setBounds(300, 200, 200, 30);
    plazoText.setFont(new Font("Arial", Font.BOLD, 15));
    plazoText.setForeground(new Color(0, 0, 0));
    panel2.add(plazoText);
    
    nombreMuebleText.setBounds(300, 250, 200, 30);
    nombreMuebleText.setFont(new Font("Arial", Font.BOLD, 15));
    nombreMuebleText.setForeground(new Color(0, 0, 0));
    panel2.add(nombreMuebleText);

    valorBienText.setBounds(300, 300, 200, 30);
    valorBienText.setFont(new Font("Arial", Font.BOLD, 15));
    valorBienText.setForeground(new Color(0, 0, 0));
    panel2.add(valorBienText);

    registraCredito.setBounds(50, 400, 200, 30);
    registraCredito.setFont(new Font("Arial", Font.BOLD, 15));
    registraCredito.setForeground(new Color(0, 0, 0));
    panel2.add(registraCredito);

    cancelar.setBounds(300, 400, 200, 30);
    cancelar.setFont(new Font("Arial", Font.BOLD, 15));
    cancelar.setForeground(new Color(0, 0, 0));
    panel2.add(cancelar);

    cancelar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }
    });

    registraCredito.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String tasaInteres = tasaInteresText.getText();
        String monto = montoText.getText();
        String plazo = plazoText.getText();
        String nombreMueble = nombreMuebleText.getText();
        String valorBien = valorBienText.getText();
        if (tasaInteres.equals("") || monto.equals("") || plazo.equals("") || nombreMueble.equals("")
            || valorBien.equals("")) {
          JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        } else {
          Double tasaInteresDouble = Double.parseDouble(tasaInteres);
          Double montoDouble = Double.parseDouble(monto);
          int plazoInt = Integer.parseInt(plazo);
          Double valorBienDouble = Double.parseDouble(valorBien);
          if (pMoneda.compareTo(TMoneda.COLONES) == 0) {
            if (montoDouble <= 30000000 && montoDouble > 0 ) {
              if (tasaInteresDouble < 0.1 || tasaInteresDouble > 0.16) {
                JOptionPane.showMessageDialog(null, "La tasa debe estar entre 0.1 y 0.15");
              }
              if (plazoInt < 0 || plazoInt > 85) {
                JOptionPane.showMessageDialog(null, "El plazo debe estar entre 1 y 84");
              }else{
                BienMueble bien = new BienMueble(nombreMueble, pDeudor, valorBienDouble);
                CuotaMensual cuota = null;
                CreditoPrendario credito = new CreditoPrendario(pDeudor, montoDouble,plazoInt, pMoneda, tasaInteresDouble, pTasaPasiva, pComision, pCostoLegales, cuota, bien);
                if (jsonManager.agregarCreditoPrendario(credito)) {
                  creditosPrendarios.add(credito);
                  JOptionPane.showMessageDialog(null, "Credito registrado");
                  setBounds(350, 0, 700, 850);
                  panel2.setVisible(false);
                  panel.setVisible(true);
                }else{
                  JOptionPane.showMessageDialog(null, "Credito no registrado");
                }
              }
            } else {
              JOptionPane.showMessageDialog(null, "El monto debe estar entre 30,000,000 y 0, y la tasa debe estar entre 0 y 0.15");
            }
          }else{
            if (montoDouble < 45000 && montoDouble > 0 && tasaInteresDouble < 0.13 && tasaInteresDouble > 0){
              if (tasaInteresDouble < 0 || tasaInteresDouble > 0.14) {
                JOptionPane.showMessageDialog(null, "La tasa debe estar entre 0.1 y 0.13");
              }
              if(plazoInt < 0 || plazoInt > 85){
                JOptionPane.showMessageDialog(null, "El plazo debe estar entre 1 y 84"); 
              }else{
                BienMueble bien = new BienMueble(nombreMueble, pDeudor, valorBienDouble);
                CuotaMensual cuota = null;
                CreditoPrendario credito = new CreditoPrendario(pDeudor, montoDouble,plazoInt, pMoneda, tasaInteresDouble, pTasaPasiva, pComision, pCostoLegales, cuota, bien);
                if (jsonManager.agregarCreditoPrendario(credito)) {
                  creditosPrendarios.add(credito);
                  JOptionPane.showMessageDialog(null, "Credito registrado");
                  setBounds(350, 0, 700, 850);
                  panel2.setVisible(false);
                  panel.setVisible(true);
                }
                JOptionPane.showMessageDialog(null, "Credito no registrado");
              }
            }
          }
        }
      }
    });
  }

  private void ventanaRegistrarCreditoFiduciario(Deudor pDeudor, TMoneda pMoneda, Double pTasaPasiva,
      TCostosLegales pCostoLegales, Double pComision) {
    JPanel panel2 = new JPanel();
    JLabel titulo = new JLabel("Registrar Credito Fiduciario");
    JLabel labelTasaInteres = new JLabel("Tasa de Interes");
    JLabel etiquetaMonto = new JLabel("Monto");
    JLabel etiquetaPlazo = new JLabel("Plazo en meses");
    JLabel etiquetaFiador = new JLabel("Fiador");

    JTextField plazoText = new JTextField();
    JTextField tasaInteresText = new JTextField();
    JTextField montoText = new JTextField();
    JComboBox<String> fiadorBox = new JComboBox<String>();

    JButton salir = new JButton("Salir");
    JButton registrarCredito = new JButton("Registrar Credito");
    JButton agregarFiador = new JButton("Agregar Fiador");
    JButton crearFiador = new JButton("Crear Fiador");

    panel2.setLayout(null);
    panel2.setBackground(new Color(135, 206, 250));
    panel2.setBounds(0, 0, 600, 700);
    this.add(panel2);
    setBounds(350, 0, 600, 800);

    fiadorBox.addItem("Seleccione un fiador");
    for (Fiador fiador : fiadores) {
      fiadorBox.addItem(fiador.getCedula());
    }

    titulo.setBounds(200, 50, 400, 50);
    titulo.setFont(new Font("Times new Roman", Font.BOLD, 28));
    titulo.setForeground(new Color(0, 0, 0));
    panel2.add(titulo);

    labelTasaInteres.setBounds(50, 150, 200, 40);
    labelTasaInteres.setFont(new Font("Times new Roman", Font.BOLD, 20));
    labelTasaInteres.setForeground(new Color(0, 0, 0));
    panel2.add(labelTasaInteres);

    etiquetaMonto.setBounds(50, 200, 200, 40);
    etiquetaMonto.setFont(new Font("Times new Roman", Font.BOLD, 20));
    etiquetaMonto.setForeground(new Color(0, 0, 0));
    panel2.add(etiquetaMonto);

    etiquetaPlazo.setBounds(50, 250, 200, 40);
    etiquetaPlazo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    etiquetaPlazo.setForeground(new Color(0, 0, 0));
    panel2.add(etiquetaPlazo);

    etiquetaFiador.setBounds(50, 300, 200, 40);
    etiquetaFiador.setFont(new Font("Times new Roman", Font.BOLD, 20));
    etiquetaFiador.setForeground(new Color(0, 0, 0));
    panel2.add(etiquetaFiador);

    tasaInteresText.setBounds(250, 150, 200, 40);
    tasaInteresText.setFont(new Font("Times new Roman", Font.BOLD, 20));
    tasaInteresText.setForeground(new Color(0, 0, 0));
    panel2.add(tasaInteresText);

    montoText.setBounds(250, 200, 200, 40);
    montoText.setFont(new Font("Times new Roman", Font.BOLD, 20));
    montoText.setForeground(new Color(0, 0, 0));
    panel2.add(montoText);

    plazoText.setBounds(250, 250, 200, 40);
    plazoText.setFont(new Font("Times new Roman", Font.BOLD, 20));
    plazoText.setForeground(new Color(0, 0, 0));
    panel2.add(plazoText);

    fiadorBox.setBounds(250, 300, 200, 40);
    fiadorBox.setFont(new Font("Times new Roman", Font.BOLD, 20));
    fiadorBox.setForeground(new Color(0, 0, 0));
    panel2.add(fiadorBox);

    salir.setBounds(50, 500, 200, 40);
    salir.setFont(new Font("Times new Roman", Font.BOLD, 20));
    salir.setForeground(new Color(0, 0, 0));
    panel2.add(salir);

    registrarCredito.setBounds(270, 500, 200, 40);
    registrarCredito.setFont(new Font("Times new Roman", Font.BOLD, 20));
    registrarCredito.setForeground(new Color(0, 0, 0));
    panel2.add(registrarCredito);

    agregarFiador.setBounds(50, 560, 200, 40);
    agregarFiador.setFont(new Font("Times new Roman", Font.BOLD, 20));
    agregarFiador.setForeground(new Color(0, 0, 0));
    panel2.add(agregarFiador);

    crearFiador.setBounds(270, 560, 200, 40);
    crearFiador.setFont(new Font("Times new Roman", Font.BOLD, 20));
    crearFiador.setForeground(new Color(0, 0, 0));
    panel2.add(crearFiador);
    salir.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }
    });
    ArrayList<Fiador> fiadoresARegistrar = new ArrayList<Fiador>();

    registrarCredito.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (fiadoresARegistrar.size() == 0) {
          JOptionPane.showMessageDialog(null, "Debe agregar un fiador");
        } else {
          if (!tasaInteresText.getText().isEmpty() && !montoText.getText().isEmpty()
              && !plazoText.getText().isEmpty() && !fiadorBox.getSelectedItem().toString().isEmpty()) {
            Double tasaInteres = Double.parseDouble(tasaInteresText.getText());
            Double monto = Double.parseDouble(montoText.getText());
            int plazo = Integer.parseInt(plazoText.getText());
            CuotaMensual cuotaMensual = null;
            if (pMoneda.compareTo(TMoneda.COLONES) == 0) {
              if (monto < 40000000 && plazo < 96) {
                CreditoFiduciario credito = new CreditoFiduciario(pDeudor, monto, plazo, pMoneda, tasaInteres,
                    pTasaPasiva,
                    pComision, pCostoLegales, cuotaMensual, fiadoresARegistrar);
                if (jsonManager.agregarCreditoFiduciario(credito)) {
                  creditosFiduciarios.add(credito);
                  JOptionPane.showMessageDialog(null, "Credito registrado con exito");
                  setBounds(350, 0, 700, 850);
                  panel2.setVisible(false);
                  panel.setVisible(true);
                } else {
                  JOptionPane.showMessageDialog(null, "Error al registrar el credito");
                }
              } else {
                JOptionPane.showMessageDialog(null, "El monto debe ser menor a 40.000.000 y el plazo menor a 96 meses");
              }
            } else {
              if (monto < 60000 && plazo < 96) {
                CreditoFiduciario credito = new CreditoFiduciario(pDeudor, monto, plazo, pMoneda, tasaInteres,
                    pTasaPasiva,
                    pComision, pCostoLegales, cuotaMensual, fiadoresARegistrar);
                if (jsonManager.agregarCreditoFiduciario(credito)) {
                  creditosFiduciarios.add(credito);
                  JOptionPane.showMessageDialog(null, "Credito registrado con exito");
                  setBounds(350, 0, 700, 850);
                  panel2.setVisible(false);
                  panel.setVisible(true);
                } else {
                  JOptionPane.showMessageDialog(null, "Error al registrar el credito");
                }
              } else {
                JOptionPane.showMessageDialog(null, "El monto debe ser menor a $60 000 y el plazo menor a 96 meses");
              }
            }

          } else {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
          }
        }
      }
    });

    agregarFiador.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (fiadorBox.getSelectedItem().toString().equals("Seleccione un fiador")) {
          JOptionPane.showMessageDialog(null, "Debe seleccionar un fiador");
        } else {
          if (fiadores.size() < 3) {
            for (Fiador fiador : fiadores) {
              if (fiador.getCedula().equals(fiadorBox.getSelectedItem().toString())) {
                if (!fiadoresARegistrar.contains(fiador)) {
                  fiadoresARegistrar.add(fiador);
                  JOptionPane.showMessageDialog(null, "Fiador agregado");
                } else {
                  JOptionPane.showMessageDialog(null, "Fiador ya agregado");
                }
              }
            }
          } else {
            JOptionPane.showMessageDialog(null, "No se pueden agregar mas fiadores");
          }
        }
      }
    });

    crearFiador.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        panel2.setVisible(false);
        ventanaCrearFiador(pDeudor, pMoneda, pTasaPasiva, pCostoLegales, pComision);
      }
    });

  }

  private void ventanaCrearFiador(Deudor pdeudor, TMoneda pMoneda, Double pTasaPasiva,
      TCostosLegales pCostoLegales, Double pComision) {
    JPanel panel2 = new JPanel();
    JLabel titulo = new JLabel("Crear Fiador");
    JLabel etiquetaCedula = new JLabel("Cedula");
    JLabel etiquetaNombre = new JLabel("Nombre");
    JLabel etiquetaTelefono = new JLabel("Telefono");
    JLabel etiquetaSalarioBruto = new JLabel("Salario Bruto");
    JLabel etiquetaSalarioLiquido = new JLabel("Salario Liquido");

    JTextField cedulaText = new JTextField();
    JTextField nombreText = new JTextField();
    JTextField telefonoText = new JTextField();
    JTextField salarioBrutoText = new JTextField();
    JTextField salarioLiquidoText = new JTextField();

    JButton crearFiador = new JButton("Crear");
    JButton regresarButton = new JButton("Regresar");

    panel2.setLayout(null);
    panel2.setBackground(new Color(135, 206, 250));
    panel2.setBounds(0, 0, 600, 700);
    this.add(panel2);
    setBounds(350, 0, 600, 800);

    titulo.setBounds(200, 50, 200, 40);
    titulo.setFont(new Font("Times new Roman", Font.BOLD, 25));
    titulo.setForeground(new Color(0, 0, 0));
    panel2.add(titulo);

    etiquetaCedula.setBounds(50, 150, 200, 40);
    etiquetaCedula.setFont(new Font("Times new Roman", Font.BOLD, 20));
    etiquetaCedula.setForeground(new Color(0, 0, 0));
    panel2.add(etiquetaCedula);

    etiquetaNombre.setBounds(50, 200, 200, 40);
    etiquetaNombre.setFont(new Font("Times new Roman", Font.BOLD, 20));
    etiquetaNombre.setForeground(new Color(0, 0, 0));
    panel2.add(etiquetaNombre);

    etiquetaTelefono.setBounds(50, 250, 200, 40);
    etiquetaTelefono.setFont(new Font("Times new Roman", Font.BOLD, 20));
    etiquetaTelefono.setForeground(new Color(0, 0, 0));
    panel2.add(etiquetaTelefono);

    etiquetaSalarioBruto.setBounds(50, 300, 200, 40);
    etiquetaSalarioBruto.setFont(new Font("Times new Roman", Font.BOLD, 20));
    etiquetaSalarioBruto.setForeground(new Color(0, 0, 0));
    panel2.add(etiquetaSalarioBruto);

    etiquetaSalarioLiquido.setBounds(50, 350, 200, 40);
    etiquetaSalarioLiquido.setFont(new Font("Times new Roman", Font.BOLD, 20));
    etiquetaSalarioLiquido.setForeground(new Color(0, 0, 0));
    panel2.add(etiquetaSalarioLiquido);

    cedulaText.setBounds(200, 150, 200, 40);
    cedulaText.setFont(new Font("Times new Roman", Font.BOLD, 20));
    cedulaText.setForeground(new Color(0, 0, 0));
    panel2.add(cedulaText);

    nombreText.setBounds(200, 200, 200, 40);
    nombreText.setFont(new Font("Times new Roman", Font.BOLD, 20));
    nombreText.setForeground(new Color(0, 0, 0));
    panel2.add(nombreText);

    telefonoText.setBounds(200, 250, 200, 40);
    telefonoText.setFont(new Font("Times new Roman", Font.BOLD, 20));
    telefonoText.setForeground(new Color(0, 0, 0));
    panel2.add(telefonoText);

    salarioBrutoText.setBounds(200, 300, 200, 40);
    salarioBrutoText.setFont(new Font("Times new Roman", Font.BOLD, 20));
    salarioBrutoText.setForeground(new Color(0, 0, 0));
    panel2.add(salarioBrutoText);

    salarioLiquidoText.setBounds(200, 350, 200, 40);
    salarioLiquidoText.setFont(new Font("Times new Roman", Font.BOLD, 20));
    salarioLiquidoText.setForeground(new Color(0, 0, 0));
    panel2.add(salarioLiquidoText);

    crearFiador.setBounds(50, 450, 200, 40);
    crearFiador.setFont(new Font("Times new Roman", Font.BOLD, 20));
    crearFiador.setForeground(new Color(0, 0, 0));
    panel2.add(crearFiador);

    regresarButton.setBounds(300, 450, 200, 40);
    regresarButton.setFont(new Font("Times new Roman", Font.BOLD, 20));
    regresarButton.setForeground(new Color(0, 0, 0));
    panel2.add(regresarButton);

    crearFiador.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String cedula = cedulaText.getText();
        String nombre = nombreText.getText();
        String telefono = telefonoText.getText();
        String salarioBruto = salarioBrutoText.getText();
        String salarioLiquido = salarioLiquidoText.getText();
        if (cedula.equals("") || nombre.equals("") || telefono.equals("") || salarioBruto.equals("")
            || salarioLiquido.equals("")) {
          JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        } else {
          try {
            Double salarioBrutoDouble = Double.parseDouble(salarioBruto);
            Double salarioLiquidoDouble = Double.parseDouble(salarioLiquido);
            if (salarioBrutoDouble < salarioLiquidoDouble) {
              JOptionPane.showMessageDialog(null, "El salario liquido no puede ser mayor al salario bruto");
            } else {
              Fiador fiador = new Fiador(cedula, nombre, telefono, salarioBrutoDouble, salarioLiquidoDouble);
              fiadores.add(fiador);
              JOptionPane.showMessageDialog(null, "Fiador creado");
              jsonManager.agregarFiador(fiador);
              panel2.setVisible(false);
              ventanaRegistrarCreditoFiduciario(pdeudor, pMoneda, pTasaPasiva, pCostoLegales, pComision);
            }
          } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debe ingresar numeros en los campos de salario bruto y liquido");
          }
        }
      }
    });

    regresarButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        panel2.setVisible(false);
        ventanaRegistrarCreditoFiduciario(pdeudor, pMoneda, pTasaPasiva, pCostoLegales, pComision);
      }
    });

  }

  private void ventanaRegistrarCreditoHipotecario(Deudor pDeudor, String pMoneda, String pTasaPasiva,
      String pCostoLegales,
      String pComision) {
    JPanel panel3 = new JPanel();
    JLabel etiquetaTitulo = new JLabel("Registrar Credito Hipotecario");
    JLabel labelTasaInteres = new JLabel("Tasa de Interes");
    JLabel etiquetaMonto = new JLabel("Monto");
    JLabel etiquetaPlazo = new JLabel("Plazo en meses");
    JLabel etiquetaBienInmueble = new JLabel("Bien Inmueble");
    JLabel etiquetaNombreBien = new JLabel("Nombre del Bien");
    JLabel etiquetaAreaTerreno = new JLabel("Area del Terreno");
    JLabel etiquetaNumeroPlano = new JLabel("Numero del Plano");
    JLabel etiquetaMontoAvaluo = new JLabel("Monto del Avaluo");
    JLabel etiquetaDireccionBien = new JLabel("Direccion del Bien");
    JLabel etiquetaProvincia = new JLabel("Provincia");
    JLabel etiquetaCanton = new JLabel("Canton");
    JLabel etiquetaDistrito = new JLabel("Distrito");
    JLabel etitquetaSenas = new JLabel("Senas Particulares");

    JTextField plazoText = new JTextField();
    JTextField tasaInteresText = new JTextField();
    JTextField montoText = new JTextField();
    JTextField montoAvaluoText = new JTextField();
    JTextField numeroPlano = new JTextField();
    JTextField areaPlano = new JTextField();
    JTextField nombreBienText = new JTextField();
    JTextField provinciaText = new JTextField();
    JTextField cantonText = new JTextField();
    JTextField distritoText = new JTextField();
    JTextField senasText = new JTextField();
    JButton salir = new JButton("Salir");
    JButton registrarCredito = new JButton("Registrar Credito");

    panel3.setLayout(null);
    panel3.setBackground(new Color(135, 206, 250));
    panel3.setBounds(0, 0, 600, 700);
    this.add(panel3);
    setBounds(350, 0, 600, 800);

    etiquetaTitulo.setBounds(200, 50, 300, 30);
    etiquetaTitulo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    etiquetaTitulo.setForeground(new Color(0, 0, 0));
    panel3.add(etiquetaTitulo);

    labelTasaInteres.setBounds(50, 100, 200, 30);
    labelTasaInteres.setFont(new Font("Times new Roman", Font.BOLD, 15));
    labelTasaInteres.setForeground(new Color(0, 0, 0));
    panel3.add(labelTasaInteres);

    tasaInteresText.setBounds(250, 100, 200, 30);
    tasaInteresText.setBackground(new Color(255, 255, 255));
    tasaInteresText.setFont(new Font("Times new Roman", Font.BOLD, 15));
    tasaInteresText.setForeground(new Color(0, 0, 0));
    panel3.add(tasaInteresText);

    etiquetaMonto.setBounds(50, 150, 200, 30);
    etiquetaMonto.setFont(new Font("Times new Roman", Font.BOLD, 15));
    etiquetaMonto.setForeground(new Color(0, 0, 0));
    panel3.add(etiquetaMonto);

    montoText.setBounds(250, 150, 200, 30);
    montoText.setBackground(new Color(255, 255, 255));
    montoText.setFont(new Font("Times new Roman", Font.BOLD, 15));
    montoText.setForeground(new Color(0, 0, 0));
    panel3.add(montoText);

    etiquetaPlazo.setBounds(50, 200, 200, 30);
    etiquetaPlazo.setFont(new Font("Times new Roman", Font.BOLD, 15));
    etiquetaPlazo.setForeground(new Color(0, 0, 0));
    panel3.add(etiquetaPlazo);

    plazoText.setBounds(250, 200, 200, 30);
    plazoText.setBackground(new Color(255, 255, 255));
    plazoText.setFont(new Font("Times new Roman", Font.BOLD, 15));
    plazoText.setForeground(new Color(0, 0, 0));
    panel3.add(plazoText);

    etiquetaBienInmueble.setBounds(50, 250, 200, 30);
    etiquetaBienInmueble.setFont(new Font("Times new Roman", Font.BOLD, 15));
    etiquetaBienInmueble.setForeground(new Color(0, 0, 0));
    panel3.add(etiquetaBienInmueble);

    etiquetaNombreBien.setBounds(50, 300, 200, 30);
    etiquetaNombreBien.setFont(new Font("Times new Roman", Font.BOLD, 15));
    etiquetaNombreBien.setForeground(new Color(0, 0, 0));
    panel3.add(etiquetaNombreBien);

    nombreBienText.setBounds(250, 300, 200, 30);
    nombreBienText.setBackground(new Color(255, 255, 255));
    nombreBienText.setFont(new Font("Times new Roman", Font.BOLD, 15));
    nombreBienText.setForeground(new Color(0, 0, 0));
    panel3.add(nombreBienText);

    etiquetaAreaTerreno.setBounds(50, 350, 200, 30);
    etiquetaAreaTerreno.setFont(new Font("Times new Roman", Font.BOLD, 15));
    etiquetaAreaTerreno.setForeground(new Color(0, 0, 0));
    panel3.add(etiquetaAreaTerreno);

    areaPlano.setBounds(250, 350, 200, 30);
    areaPlano.setBackground(new Color(255, 255, 255));
    areaPlano.setFont(new Font("Times new Roman", Font.BOLD, 15));
    areaPlano.setForeground(new Color(0, 0, 0));
    panel3.add(areaPlano);

    etiquetaNumeroPlano.setBounds(50, 400, 200, 30);
    etiquetaNumeroPlano.setFont(new Font("Times new Roman", Font.BOLD, 15));
    etiquetaNumeroPlano.setForeground(new Color(0, 0, 0));
    panel3.add(etiquetaNumeroPlano);

    numeroPlano.setBounds(250, 400, 200, 30);
    numeroPlano.setBackground(new Color(255, 255, 255));
    numeroPlano.setFont(new Font("Times new Roman", Font.BOLD, 15));
    numeroPlano.setForeground(new Color(0, 0, 0));
    panel3.add(numeroPlano);

    etiquetaMontoAvaluo.setBounds(50, 450, 200, 30);
    etiquetaMontoAvaluo.setFont(new Font("Times new Roman", Font.BOLD, 15));
    etiquetaMontoAvaluo.setForeground(new Color(0, 0, 0));
    panel3.add(etiquetaMontoAvaluo);

    montoAvaluoText.setBounds(250, 450, 200, 30);
    montoAvaluoText.setBackground(new Color(255, 255, 255));
    montoAvaluoText.setFont(new Font("Times new Roman", Font.BOLD, 15));
    montoAvaluoText.setForeground(new Color(0, 0, 0));
    panel3.add(montoAvaluoText);

    etiquetaDireccionBien.setBounds(50, 500, 200, 30);
    etiquetaDireccionBien.setFont(new Font("Times new Roman", Font.BOLD, 15));
    etiquetaDireccionBien.setForeground(new Color(0, 0, 0));
    panel3.add(etiquetaDireccionBien);

    etiquetaProvincia.setBounds(50, 550, 200, 30);
    etiquetaProvincia.setFont(new Font("Times new Roman", Font.BOLD, 15));
    etiquetaProvincia.setForeground(new Color(0, 0, 0));
    panel3.add(etiquetaProvincia);

    etiquetaCanton.setBounds(50, 600, 200, 30);
    etiquetaCanton.setFont(new Font("Times new Roman", Font.BOLD, 15));
    etiquetaCanton.setForeground(new Color(0, 0, 0));
    panel3.add(etiquetaCanton);

    etiquetaDistrito.setBounds(50, 650, 200, 30);
    etiquetaDistrito.setFont(new Font("Times new Roman", Font.BOLD, 15));
    etiquetaDistrito.setForeground(new Color(0, 0, 0));
    panel3.add(etiquetaDistrito);

    etitquetaSenas.setBounds(50, 700, 200, 30);
    etitquetaSenas.setFont(new Font("Times new Roman", Font.BOLD, 15));
    etitquetaSenas.setForeground(new Color(0, 0, 0));
    panel3.add(etitquetaSenas);

    provinciaText.setBounds(250, 550, 200, 30);
    provinciaText.setBackground(new Color(255, 255, 255));
    provinciaText.setFont(new Font("Times new Roman", Font.BOLD, 15));
    provinciaText.setForeground(new Color(0, 0, 0));
    panel3.add(provinciaText);

    cantonText.setBounds(250, 600, 200, 30);
    cantonText.setBackground(new Color(255, 255, 255));
    cantonText.setFont(new Font("Times new Roman", Font.BOLD, 15));
    cantonText.setForeground(new Color(0, 0, 0));
    panel3.add(cantonText);

    distritoText.setBounds(250, 650, 200, 30);
    distritoText.setBackground(new Color(255, 255, 255));
    distritoText.setFont(new Font("Times new Roman", Font.BOLD, 15));
    distritoText.setForeground(new Color(0, 0, 0));
    panel3.add(distritoText);

    senasText.setBounds(250, 700, 200, 30);
    senasText.setBackground(new Color(255, 255, 255));
    senasText.setFont(new Font("Times new Roman", Font.BOLD, 15));
    senasText.setForeground(new Color(0, 0, 0));
    panel3.add(senasText);

    salir.setBounds(50, 750, 200, 30);
    salir.setFont(new Font("Times new Roman", Font.BOLD, 15));
    salir.setForeground(new Color(0, 0, 0));
    panel3.add(salir);

    registrarCredito.setBounds(250, 750, 200, 30);
    registrarCredito.setFont(new Font("Times new Roman", Font.BOLD, 15));
    registrarCredito.setForeground(new Color(0, 0, 0));
    panel3.add(registrarCredito);

    salir.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        panel3.setVisible(false);
        panel.setVisible(true);
      }
    });
    registrarCredito.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String plazo = plazoText.getText();
        String monto = montoText.getText();
        String area = areaPlano.getText();
        String numero = numeroPlano.getText();
        String provincia = provinciaText.getText();
        String canton = cantonText.getText();
        String distrito = distritoText.getText();
        String senas = senasText.getText();
        String montoAvaluo = montoAvaluoText.getText();
        String nombreBien = nombreBienText.getText();
        String tasaInteres = tasaInteresText.getText();
        if (plazo.equals("") || monto.equals("") || area.equals("") || numero.equals("") || provincia.equals("")
            || canton.equals("") || distrito.equals("") || senas.equals("") || montoAvaluo.equals("")) {
          JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        } else {
          int plazoInt = Integer.parseInt(plazo);
          int montoInt = Integer.parseInt(monto);
          Double areaInt = Double.parseDouble(area);
          int numeroInt = Integer.parseInt(numero);
          Double montoAvaluoInt = Double.parseDouble(montoAvaluo);
          double tasaInteresDouble = Double.parseDouble(tasaInteres);
          Double comisionInt = Double.parseDouble(pComision);
          double tasaPasiva = Double.parseDouble(pTasaPasiva);
          Direccion direccion = new Direccion(provincia, canton, distrito, senas);
          BienInmueble bien = new BienInmueble(nombreBien, pDeudor, direccion, areaInt, numeroInt,
              montoAvaluoInt);
          CuotaMensual cuota = null;
          if (plazoInt < 0 || montoInt < 0 || areaInt < 0 || numeroInt < 0 || montoAvaluoInt < 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar valores positivos");
          } else {
            if (pMoneda.equals("Dolares")) {
              if (montoInt < 230000 && plazoInt < 361) {
                if (pCostoLegales.equals("Traspaso")) { // Traspaso
                  CreditoHipotecario credito = new CreditoHipotecario(pDeudor, montoInt, plazoInt, TMoneda.DOLARES,
                      tasaInteresDouble, tasaPasiva, comisionInt, TCostosLegales.TRASPASO, cuota, bien);
                  creditosHipotecarios.add(credito);
                  JOptionPane.showMessageDialog(null, "Credito registrado");
                  panel3.setVisible(false);
                  panel.setVisible(true);
                } else { // No traspaso
                  CreditoHipotecario credito = new CreditoHipotecario(pDeudor, montoInt, plazoInt, TMoneda.DOLARES,
                      tasaInteresDouble, tasaPasiva, comisionInt, TCostosLegales.INSCRIPCION_BIEN, cuota, bien);
                  creditosHipotecarios.add(credito);
                  JOptionPane.showMessageDialog(null, "Credito registrado");
                  panel3.setVisible(false);
                  panel.setVisible(true);
                }
              } else {
                JOptionPane.showMessageDialog(null, "El monto debe ser menor a $230,000 y el plazo menor a 361 meses");
              }
            } else {
              if (montoInt < 150000000 && plazoInt < 361) {
                if (pCostoLegales.equals("Traspaso")) { // Traspaso
                  CreditoHipotecario credito = new CreditoHipotecario(pDeudor, montoInt, plazoInt, TMoneda.COLONES,
                      tasaInteresDouble, tasaPasiva, comisionInt, TCostosLegales.TRASPASO, cuota, bien);
                  creditosHipotecarios.add(credito);
                  JOptionPane.showMessageDialog(null, "Credito registrado");
                  panel3.setVisible(false);
                  panel.setVisible(true);
                } else { // No traspaso
                  CreditoHipotecario credito = new CreditoHipotecario(pDeudor, montoInt, plazoInt, TMoneda.COLONES,
                      tasaInteresDouble, tasaPasiva, comisionInt, TCostosLegales.INSCRIPCION_BIEN, cuota, bien);
                  creditosHipotecarios.add(credito);
                  JOptionPane.showMessageDialog(null, "Credito registrado");
                  panel3.setVisible(false);
                  panel.setVisible(true);
                }
              } else {
                JOptionPane.showMessageDialog(null,
                    "El monto debe ser menor a 150 000 000 y el plazo menor a 360 meses");
              }
            }
          }
        }
      }
    });

  }

  private void ventanaRegistrarCreditoPersonal(Deudor pDeudor, String pMoneda, String tasaPasiva, String costoLegales,
      String pComision) {
    JPanel panel2 = new JPanel();
    JLabel etiquetaCreditoPersonal = new JLabel("Regitrar Credito Personal");
    JLabel labelTasaInteres = new JLabel("Tasa de Interes");
    JLabel etiquetaMotivo = new JLabel("Motivo de uso del credito");
    JLabel etiquetaMonto = new JLabel("Monto");
    JLabel etiquetaPlazo = new JLabel("Plazo en meses");

    JTextArea motivoText = new JTextArea();
    JTextField plazoText = new JTextField();
    JTextField tasaInteresText = new JTextField();
    JTextField montoTexT = new JTextField();

    JButton salir = new JButton("Salir");
    JButton registrarCredito = new JButton("Registrar Credito");

    panel2.setLayout(null);
    panel2.setBackground(new Color(135, 206, 250));
    panel2.setBounds(0, 0, 600, 700);
    this.add(panel2);
    setBounds(350, 0, 600, 700);

    etiquetaCreditoPersonal.setBounds(200, 50, 200, 30);
    etiquetaCreditoPersonal.setBackground(new Color(0, 153, 153));
    etiquetaCreditoPersonal.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(etiquetaCreditoPersonal);

    labelTasaInteres.setBounds(50, 150, 200, 30);
    labelTasaInteres.setBackground(new Color(255, 255, 255));
    labelTasaInteres.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(labelTasaInteres);

    tasaInteresText.setBounds(250, 150, 200, 30);
    tasaInteresText.setBackground(new Color(255, 255, 255));
    tasaInteresText.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(tasaInteresText);

    etiquetaMotivo.setBounds(50, 200, 200, 30);
    etiquetaMotivo.setBackground(new Color(255, 255, 255));
    etiquetaMotivo.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(etiquetaMotivo);

    motivoText.setBounds(250, 200, 200, 30);
    motivoText.setBackground(new Color(255, 255, 255));
    motivoText.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(motivoText);

    etiquetaMonto.setBounds(50, 250, 200, 30);
    etiquetaMonto.setBackground(new Color(255, 255, 255));
    etiquetaMonto.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(etiquetaMonto);

    montoTexT.setBounds(250, 250, 200, 30);
    montoTexT.setBackground(new Color(255, 255, 255));
    montoTexT.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(montoTexT);

    etiquetaPlazo.setBounds(50, 300, 200, 30);
    etiquetaPlazo.setBackground(new Color(255, 255, 255));
    etiquetaPlazo.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(etiquetaPlazo);

    plazoText.setBounds(250, 300, 200, 30);
    plazoText.setBackground(new Color(255, 255, 255));
    plazoText.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(plazoText);

    salir.setBounds(300, 350, 230, 40);
    salir.setBackground(new Color(135, 206, 250));
    salir.setFont(new Font("Times new Roman", Font.BOLD, 16));
    salir.setForeground(new Color(0, 0, 0));
    panel2.add(salir);

    registrarCredito.setBounds(50, 350, 230, 40);
    registrarCredito.setBackground(new Color(135, 206, 250));
    registrarCredito.setFont(new Font("Times new Roman", Font.BOLD, 16));
    registrarCredito.setForeground(new Color(0, 0, 0));
    panel2.add(registrarCredito);

    salir.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }
    });

    registrarCredito.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String tasaInteres = tasaInteresText.getText();
        String motivo = motivoText.getText();
        String monto = montoTexT.getText();
        String plazo = plazoText.getText();
        if (!tasaInteres.equals("") && !motivo.equals("") && !monto.equals("")
            && !plazo.equals("")) {
          double tasa = Double.parseDouble(tasaInteres);
          double montoD = Double.parseDouble(monto);
          int plazoI = Integer.parseInt(plazo);
          double tasaBasicaPasiva = Double.parseDouble(tasaPasiva);
          double comision = Double.parseDouble(pComision);
          if (pMoneda.equals("Colon")) {
            if (costoLegales.equals("Traspaso")) {
              if (montoD < 3000000 && plazoI < 60) {
                CuotaMensual cuota = null;
                CreditoPersonal creditoPersonal = new CreditoPersonal(pDeudor, montoD, plazoI, TMoneda.COLONES, tasa,
                    tasaBasicaPasiva, comision, TCostosLegales.TRASPASO, cuota, motivo);
                creditosPersonales.add(creditoPersonal);
                JOptionPane.showMessageDialog(null, "Credito Personal Registrado");
                jsonManager.agregarCreditoPersonal(creditoPersonal);
                setBounds(350, 0, 700, 850);
                panel2.setVisible(false);
                panel.setVisible(true);
              } else {
                JOptionPane.showMessageDialog(null, "El monto debe ser menor a 3000000 y el plazo menor a 60 meses");
              }
            } else {
              if (montoD < 3000000 && plazoI < 60) {
                CuotaMensual cuota = null;
                CreditoPersonal creditoPersonal = new CreditoPersonal(pDeudor, montoD, plazoI, TMoneda.COLONES, tasa,
                    tasaBasicaPasiva,
                    comision, TCostosLegales.INSCRIPCION_BIEN, cuota, motivo);
                creditosPersonales.add(creditoPersonal);
                JOptionPane.showMessageDialog(null, "El credito ha sido registrado");
                jsonManager.agregarCreditoPersonal(creditoPersonal);
                setBounds(350, 0, 700, 850);
                panel2.setVisible(false);
                panel.setVisible(true);
              } else {
                JOptionPane.showMessageDialog(null, "El monto debe ser menor a 3000000 y el plazo menor a 60 meses");
              }
            }
          } else {
            if (costoLegales.equals("Traspaso")) {
              if (montoD < 5000 && plazoI < 60) {
                CuotaMensual cuota = null;
                CreditoPersonal creditoPersonal = new CreditoPersonal(pDeudor, montoD, plazoI, TMoneda.DOLARES, tasa,
                    tasaBasicaPasiva, comision, TCostosLegales.TRASPASO, cuota, motivo);
                creditosPersonales.add(creditoPersonal);
                setBounds(350, 0, 700, 850);
                JOptionPane.showMessageDialog(null, "Credito registrado");
                jsonManager.agregarCreditoPersonal(creditoPersonal);
                panel2.setVisible(false);
                panel.setVisible(true);
              } else {
                JOptionPane.showMessageDialog(null, "El monto debe ser menor a 5000 y el plazo menor a 60 meses");
              }
            } else {
              if (montoD < 5000 && plazoI < 60) {
                CuotaMensual cuota = null;
                CreditoPersonal creditoPersonal = new CreditoPersonal(pDeudor, montoD, plazoI, TMoneda.DOLARES, tasa,
                    tasaBasicaPasiva, comision, TCostosLegales.INSCRIPCION_BIEN, cuota, motivo);
                creditosPersonales.add(creditoPersonal);
                setBounds(350, 0, 700, 850);
                JOptionPane.showMessageDialog(null, "Credito registrado");
                jsonManager.agregarCreditoPersonal(creditoPersonal);
                panel2.setVisible(false);
                panel.setVisible(true);
              } else {
                JOptionPane.showMessageDialog(null, "El monto debe ser menor a 5000 y el plazo menor a 60 meses");
              }
            }
          }
        } else {
          JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }
      }
    });
  }

  private Deudor buscarCliente(String pNumeroSolicitud) {
    for (Deudor deudor : solicitantes) {
      if (deudor.getCedula().equals(pNumeroSolicitud)) {
        return deudor;
      }
    }
    return null;
  }

  private String getFechaActual() {
    Date fecha = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    return formato.format(fecha);
  }

  private void menuCacularCreditoHipotecarioEnColon() {

    // JFrame frame = new JFrame("Calcular credito personal en dolares");
    JPanel panel2 = new JPanel();
    JLabel codigo = new JLabel("numero de solicitud");
    JLabel titulo = new JLabel("Calcular credito hipotecario en colones");
    codigo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    codigo.setBackground(new Color(0, 153, 153));
    JComboBox<String> creditoPersonal = new JComboBox<String>();
    creditoPersonal.addItem("Seleccione");

    // frame.add(panel2);
    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 153, 153));
    panel2.setBounds(0, 0, 500, 500);
    this.add(panel2);

    setBounds(350, 0, 780, 850);

    titulo.setBounds(100, 10, 500, 40);
    titulo.setBackground(new Color(0, 153, 153));
    titulo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    panel2.add(titulo);

    codigo.setBounds(50, 100, 200, 40);
    codigo.setBackground(new Color(0, 153, 153));
    codigo.setFont(new Font("Times new Roman", Font.BOLD, 18));
    panel2.add(codigo);

    creditoPersonal.setFont(new Font("Times new Roman", Font.BOLD, 15));
    creditoPersonal.setBackground(new Color(255, 255, 255));
    creditoPersonal.setBounds(50, 150, 200, 30);
    panel2.add(creditoPersonal);

    for (CreditoHipotecario credito : creditosHipotecarios) {
      String numero = credito.getNumSolicitud();
      creditoPersonal.addItem(numero);
    }

    // frame.getContentPane().add(creditoPersonal, BorderLayout.NORTH);
    // frame.getContentPane().add(codigo, BorderLayout.SOUTH);

    // creamos el arreglo de objetos que contendra el
    // contenido de las columnas
    Object[] data = new Object[5]; // = new Object[5];

    // creamos el modelo de Tabla
    DefaultTableModel dtm = new DefaultTableModel();

    // se crea la Tabla con el modelo DefaultTableModel
    final JTable table = new JTable(dtm);

    // insertamos las columnas
    dtm.addColumn("No. de cuota ");
    dtm.addColumn("Monto Cuota ");
    dtm.addColumn("Interes ");
    dtm.addColumn("Amortizacion ");
    dtm.addColumn("Deuda ");

    // se define el tama�o
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));

    // Creamos un JscrollPane y le agregamos la JTable
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBounds(50, 250, 700, 300);
    scrollPane.setBackground(new Color(255, 255, 255));
    scrollPane.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(scrollPane);

    // });
    JButton calcular = new JButton("Calcular");
    calcular.setBounds(50, 620, 200, 30);
    calcular.setBackground(new Color(135, 206, 250));
    calcular.setFont(new Font("Times new Roman", Font.BOLD, 16));
    calcular.setForeground(new Color(0, 0, 0));
    panel2.add(calcular);
    // frame.getContentPane().add(calcular);
    calcular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String solicitud = creditoPersonal.getSelectedItem().toString();
        if (solicitud.equals("Seleccione")) {
          JOptionPane.showMessageDialog(null, "Seleccione una solicitud");
        } else {
          CreditoHipotecario credito = buscarCreditoHipotecario(solicitud);
          ArrayList<Double> cuotas = credito.getAmortizacion().getMontoCuotas();
          ArrayList<Double> intereses = credito.getAmortizacion().getCuotasInteres();
          ArrayList<Double> amortizacion = credito.getAmortizacion().getAmortizacion();
          double monto = credito.getMontoFinal();
          double interes = 0.0;
          double amortizacion1 = 0.0;
          for (int i = 0; i < credito.getAmortizacion().getPlazoEnAnos(); i++) {
            Object[] data = new Object[5];
            data[0] = i + 1;
            data[1] = cuotas.get(i);
            data[2] = intereses.get(i);
            data[3] = amortizacion.get(i);
            data[4] = monto;
            monto = monto - amortizacion.get(i);
            interes = interes + intereses.get(i);
            amortizacion1 = amortizacion1 + amortizacion.get(i);
            dtm.addRow(data);
          }
          data[0] = "Total";
          data[1] = "";
          data[2] = interes;
          data[3] = amortizacion1;
          data[4] = monto;
        }
      }
    });
    JButton button = new JButton("Salir");
    button.setBounds(50, 680, 200, 30);
    button.setBackground(new Color(135, 206, 250));
    button.setFont(new Font("Times new Roman", Font.BOLD, 16));
    button.setForeground(new Color(0, 0, 0));
    panel2.add(button);
    button.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        // frame.setVisible(false);
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }

    });
    // frame.getContentPane().add(button, BorderLayout.SOUTH);

  }

  // debo editar las etiquetas para que sean mas faciles de leer
  private void menuCacularCreditoHipotecarioEnDolar() {

    // JFrame frame = new JFrame("Calcular credito personal en dolares");
    JPanel panel2 = new JPanel();
    JLabel codigo = new JLabel("numero de solicitud");
    JLabel titulo = new JLabel("Calcular credito hipotecario en dolares");
    codigo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    codigo.setBackground(new Color(0, 153, 153));
    JComboBox<String> creditoPersonal = new JComboBox<String>();

    // frame.setSize(500, 500);
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setVisible(true);
    creditoPersonal.addItem("Seleccione");

    // frame.add(panel2);
    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 153, 153));
    panel2.setBounds(0, 0, 500, 500);
    this.add(panel2);

    setBounds(350, 0, 780, 850);

    titulo.setBounds(100, 10, 500, 40);
    titulo.setBackground(new Color(0, 153, 153));
    titulo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    panel2.add(titulo);

    codigo.setBounds(50, 100, 200, 40);
    codigo.setBackground(new Color(0, 153, 153));
    codigo.setFont(new Font("Times new Roman", Font.BOLD, 18));
    panel2.add(codigo);

    creditoPersonal.setFont(new Font("Times new Roman", Font.BOLD, 15));
    creditoPersonal.setBackground(new Color(255, 255, 255));
    creditoPersonal.setBounds(50, 150, 200, 30);
    panel2.add(creditoPersonal);

    for (CreditoHipotecario credito : creditosHipotecarios) {
      String numero = credito.getNumSolicitud();
      creditoPersonal.addItem(numero);
    }

    // creamos el arreglo de objetos que contendra el
    // contenido de las columnas
    Object[] data = new Object[5];

    // creamos el modelo de Tabla
    DefaultTableModel dtm = new DefaultTableModel();

    // se crea la Tabla con el modelo DefaultTableModel
    final JTable table = new JTable(dtm);

    // insertamos las columnas
    dtm.addColumn("No. de cuota ");
    dtm.addColumn("Monto Cuota ");
    dtm.addColumn("Interes ");
    dtm.addColumn("Amortizacion ");
    dtm.addColumn("Deuda ");

    // se define el tama�o
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));

    // Creamos un JscrollPane y le agregamos la JTable
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBounds(50, 250, 700, 300);
    scrollPane.setBackground(new Color(255, 255, 255));
    scrollPane.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(scrollPane);

    JButton calcular = new JButton("Calcular");
    calcular.setBounds(50, 620, 200, 30);
    calcular.setBackground(new Color(135, 206, 250));
    calcular.setFont(new Font("Times new Roman", Font.BOLD, 16));
    calcular.setForeground(new Color(0, 0, 0));
    panel2.add(calcular);
    // frame.getContentPane().add(calcular);
    calcular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String solicitud = creditoPersonal.getSelectedItem().toString();
        if (solicitud.equals("Seleccione")) {
          JOptionPane.showMessageDialog(null, "Seleccione una solicitud");
        } else {
          CreditoHipotecario credito = buscarCreditoHipotecario(solicitud);
          ArrayList<Double> cuotas = credito.getAmortizacion().getMontoCuotas();
          ArrayList<Double> intereses = credito.getAmortizacion().getCuotasInteres();
          ArrayList<Double> amortizacion = credito.getAmortizacion().getAmortizacion();
          double monto = credito.getMontoFinal();
          double interes = 0.0;
          double amortizacion1 = 0.0;
          for (int i = 0; i < credito.getAmortizacion().getPlazoEnAnos(); i++) {
            Object[] data = new Object[5];
            data[0] = i + 1;
            data[1] = cuotas.get(i);
            data[2] = intereses.get(i);
            data[3] = amortizacion.get(i);
            data[4] = monto;
            monto = monto - amortizacion.get(i);
            interes += intereses.get(i);
            amortizacion1 += amortizacion.get(i);
            dtm.addRow(data);
          }
          data[0] = "Total";
          data[1] = "";
          data[2] = interes;
          data[3] = amortizacion1;
          data[4] = monto;
        }
      }
    });
    JButton button = new JButton("Salir");
    button.setBounds(50, 680, 200, 30);
    button.setBackground(new Color(135, 206, 250));
    button.setFont(new Font("Times new Roman", Font.BOLD, 16));
    button.setForeground(new Color(0, 0, 0));
    panel2.add(button);
    button.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        // frame.setVisible(false);
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }

    });
    // frame.getContentPane().add(button, BorderLayout.SOUTH);
  }

  private CreditoHipotecario buscarCreditoHipotecario(String solicitud) {
    for (CreditoHipotecario credito : creditosHipotecarios) {
      if (credito.getNumSolicitud().equals(solicitud)) {
        return credito;
      }
    }
    return null;
  }

  // debo editar las etiqueta
  private void menuCacularCreditoFiduciarioEnColon() {

    // JFrame frame = new JFrame("Calcular credito personal en dolares");
    JPanel panel2 = new JPanel();
    JLabel codigo = new JLabel("numero de solicitud");
    JLabel titulo = new JLabel("Calcular credito fiduciario en colones");
    codigo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    codigo.setBackground(new Color(0, 153, 153));
    JComboBox<String> creditoPersonal = new JComboBox<String>();

    // frame.setSize(500, 500);
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setVisible(true);
    creditoPersonal.addItem("Seleccione");

    // frame.add(panel2);
    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 153, 153));
    panel2.setBounds(0, 0, 500, 500);
    this.add(panel2);

    setBounds(350, 0, 780, 850);

    titulo.setBounds(100, 10, 500, 40);
    titulo.setBackground(new Color(0, 153, 153));
    titulo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    panel2.add(titulo);

    codigo.setBounds(50, 100, 200, 40);
    codigo.setBackground(new Color(0, 153, 153));
    codigo.setFont(new Font("Times new Roman", Font.BOLD, 18));
    panel2.add(codigo);

    creditoPersonal.setFont(new Font("Times new Roman", Font.BOLD, 15));
    creditoPersonal.setBackground(new Color(255, 255, 255));
    creditoPersonal.setBounds(50, 150, 200, 30);
    panel2.add(creditoPersonal);

    for (CreditoFiduciario credito : creditosFiduciarios) {
      String numero = credito.getNumSolicitud();
      creditoPersonal.addItem(numero);
    }
    Object[] data = new Object[5]; // = new Object[5];

    // creamos el modelo de Tabla
    DefaultTableModel dtm = new DefaultTableModel();

    // se crea la Tabla con el modelo DefaultTableModel
    final JTable table = new JTable(dtm);

    // insertamos las columnas
    dtm.addColumn("No. de cuota ");
    dtm.addColumn("Monto Cuota ");
    dtm.addColumn("Interes ");
    dtm.addColumn("Amortizacion ");
    dtm.addColumn("Deuda ");

    // se define el tama�o
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));

    // Creamos un JscrollPane y le agregamos la JTable
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBounds(50, 250, 700, 300);
    scrollPane.setBackground(new Color(255, 255, 255));
    scrollPane.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(scrollPane);

    JButton calcular = new JButton("Calcular");
    calcular.setBounds(50, 620, 200, 30);
    calcular.setBackground(new Color(135, 206, 250));
    calcular.setFont(new Font("Times new Roman", Font.BOLD, 16));
    calcular.setForeground(new Color(0, 0, 0));
    panel2.add(calcular);
    // frame.getContentPane().add(calcular);
    calcular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String solicitud = creditoPersonal.getSelectedItem().toString();
        if (solicitud.equals("Seleccione")) {
          JOptionPane.showMessageDialog(null, "Seleccione una solicitud");
        } else {
          CreditoFiduciario credito = buscarCreditoFiduciario(solicitud);
          ArrayList<Double> cuotas = credito.getAmortizacion().getMontoCuotas();
          ArrayList<Double> intereses = credito.getAmortizacion().getCuotasInteres();
          ArrayList<Double> amortizacion = credito.getAmortizacion().getAmortizacion();
          // double monto = credito.;
          double monto = credito.calcularMontoFinalASolicitar();
          Double interes = 0.0;
          Double amortizacion1 = 0.0;
          for (int i = 0; i < credito.getAmortizacion().getPlazoEnAnos(); i++) {
            Object[] data = new Object[5];
            data[0] = i + 1;
            data[1] = cuotas.get(i);
            data[2] = intereses.get(i);
            data[3] = amortizacion.get(i);
            data[4] = monto;
            monto = monto - amortizacion.get(i);
            interes += intereses.get(i);
            amortizacion1 += amortizacion.get(i);
            dtm.addRow(data);
          }
          data[0] = "Total";
          data[1] = "";
          data[2] = interes;
          data[3] = amortizacion1;
          data[4] = monto;
          dtm.addRow(data);

        }
      }
    });
    JButton button = new JButton("Salir");
    button.setBounds(50, 680, 200, 30);
    button.setBackground(new Color(135, 206, 250));
    button.setFont(new Font("Times new Roman", Font.BOLD, 16));
    button.setForeground(new Color(0, 0, 0));
    panel2.add(button);
    button.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        // frame.setVisible(false);
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }

    });
    // frame.getContentPane().add(button, BorderLayout.SOUTH);
  }

  private CreditoFiduciario buscarCreditoFiduciario(String solicitud) {
    for (CreditoFiduciario credito : creditosFiduciarios) {
      if (credito.getNumSolicitud().equals(solicitud)) {
        return credito;
      }
    }
    return null;
  }

  private void menuCalcularCreditoFiduciarioEnDolar() {

    // JFrame frame = new JFrame("Calcular credito personal en dolares");
    JPanel panel2 = new JPanel();
    JLabel codigo = new JLabel("numero de solicitud");
    JLabel titulo = new JLabel("Calcular credito fiduciario en dolares");
    codigo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    codigo.setBackground(new Color(0, 153, 153));
    JComboBox<String> creditoPersonal = new JComboBox<String>();

    // frame.setSize(500, 500);
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setVisible(true);
    creditoPersonal.addItem("Seleccione");

    // frame.add(panel2);
    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 153, 153));
    panel2.setBounds(0, 0, 500, 500);
    this.add(panel2);

    setBounds(350, 0, 780, 850);

    titulo.setBounds(100, 10, 500, 40);
    titulo.setBackground(new Color(0, 153, 153));
    titulo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    panel2.add(titulo);

    codigo.setBounds(50, 100, 200, 40);
    codigo.setBackground(new Color(0, 153, 153));
    codigo.setFont(new Font("Times new Roman", Font.BOLD, 18));
    panel2.add(codigo);

    creditoPersonal.setFont(new Font("Times new Roman", Font.BOLD, 15));
    creditoPersonal.setBackground(new Color(255, 255, 255));
    creditoPersonal.setBounds(50, 150, 200, 30);
    panel2.add(creditoPersonal);

    for (CreditoFiduciario credito : creditosFiduciarios) {
      String numero = credito.getNumSolicitud();
      creditoPersonal.addItem(numero);
    }
    Object[] data = new Object[5]; // = new Object[5];

    // creamos el modelo de Tabla
    DefaultTableModel dtm = new DefaultTableModel();

    // se crea la Tabla con el modelo DefaultTableModel
    final JTable table = new JTable(dtm);

    // insertamos las columnas
    dtm.addColumn("No. de cuota ");
    dtm.addColumn("Monto Cuota ");
    dtm.addColumn("Interes ");
    dtm.addColumn("Amortizacion ");
    dtm.addColumn("Deuda ");

    // se define el tama�o
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));

    // Creamos un JscrollPane y le agregamos la JTable
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBounds(50, 250, 700, 300);
    scrollPane.setBackground(new Color(255, 255, 255));
    scrollPane.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(scrollPane);

    JButton calcular = new JButton("Calcular");
    calcular.setBounds(50, 620, 200, 30);
    calcular.setBackground(new Color(135, 206, 250));
    calcular.setFont(new Font("Times new Roman", Font.BOLD, 16));
    calcular.setForeground(new Color(0, 0, 0));
    panel2.add(calcular);
    // frame.getContentPane().add(calcular);
    calcular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String solicitud = creditoPersonal.getSelectedItem().toString();
        if (solicitud.equals("Seleccione")) {
          JOptionPane.showMessageDialog(null, "Seleccione una solicitud");
        } else {
          CreditoFiduciario credito = buscarCreditoFiduciario(solicitud);
          ArrayList<Double> cuotas = credito.getAmortizacion().getMontoCuotas();
          ArrayList<Double> intereses = credito.getAmortizacion().getCuotasInteres();
          ArrayList<Double> amortizacion = credito.getAmortizacion().getAmortizacion();
          double monto = credito.calcularMontoFinalASolicitar();
          double interes = 0;
          double amortizacion1 = 0;
          for (int i = 0; i < credito.getAmortizacion().getPlazoEnAnos(); i++) {
            Object[] data = new Object[5];
            data[0] = i + 1;
            data[1] = cuotas.get(i);
            data[2] = intereses.get(i);
            data[3] = amortizacion.get(i);
            data[4] = monto;
            monto = monto - amortizacion.get(i);
            interes += intereses.get(i);
            amortizacion1 += amortizacion.get(i);
            dtm.addRow(data);
          }
          data[0] = "Total";
          data[1] = "";
          data[2] = interes;
          data[3] = amortizacion1;
          data[4] = monto;
        }
      }
    });
    JButton button = new JButton("Salir");
    button.setBounds(50, 680, 200, 30);
    button.setBackground(new Color(135, 206, 250));
    button.setFont(new Font("Times new Roman", Font.BOLD, 16));
    button.setForeground(new Color(0, 0, 0));
    panel2.add(button);
    button.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        // frame.setVisible(false);
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }

    });
    // frame.getContentPane().add(button, BorderLayout.SOUTH);
  }

  private void menuCalcularCreditoPrendarioEnColon() {

    // JFrame frame = new JFrame("Calcular credito personal en dolares");
    JPanel panel2 = new JPanel();
    JLabel codigo = new JLabel("numero de solicitud");
    JLabel titulo = new JLabel("Calcular credito prendario en colones");
    codigo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    codigo.setBackground(new Color(0, 153, 153));
    JComboBox<String> creditoPersonal = new JComboBox<String>();

    // frame.setSize(500, 500);
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setVisible(true);
    creditoPersonal.addItem("Seleccione");

    // frame.add(panel2);
    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 153, 153));
    panel2.setBounds(0, 0, 500, 500);
    this.add(panel2);

    setBounds(350, 0, 780, 850);

    titulo.setBounds(100, 10, 500, 40);
    titulo.setBackground(new Color(0, 153, 153));
    titulo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    panel2.add(titulo);

    codigo.setBounds(50, 100, 200, 40);
    codigo.setBackground(new Color(0, 153, 153));
    codigo.setFont(new Font("Times new Roman", Font.BOLD, 18));
    panel2.add(codigo);

    creditoPersonal.setFont(new Font("Times new Roman", Font.BOLD, 15));
    creditoPersonal.setBackground(new Color(255, 255, 255));
    creditoPersonal.setBounds(50, 150, 200, 30);
    panel2.add(creditoPersonal);

    for (CreditoPersonal credito : creditosPersonales) {
      String numero = credito.getNumSolicitud();
      creditoPersonal.addItem(numero);
    }
    // creamos el arreglo de objetos que contendra el
    // contenido de las columnas
    Object[] data = new Object[5]; // = new Object[5];

    // creamos el modelo de Tabla
    DefaultTableModel dtm = new DefaultTableModel();

    // se crea la Tabla con el modelo DefaultTableModel
    final JTable table = new JTable(dtm);

    // insertamos las columnas
    dtm.addColumn("No. de cuota ");
    dtm.addColumn("Monto Cuota ");
    dtm.addColumn("Interes ");
    dtm.addColumn("Amortizacion ");
    dtm.addColumn("Deuda ");

    // se define el tama�o
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));

    // Creamos un JscrollPane y le agregamos la JTable
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBounds(50, 250, 700, 300);
    scrollPane.setBackground(new Color(255, 255, 255));
    scrollPane.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(scrollPane);

    JButton calcular = new JButton("Calcular");
    calcular.setBounds(50, 620, 200, 30);
    calcular.setBackground(new Color(135, 206, 250));
    calcular.setFont(new Font("Times new Roman", Font.BOLD, 16));
    calcular.setForeground(new Color(0, 0, 0));
    panel2.add(calcular);
    // frame.getContentPane().add(calcular);
    calcular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String solicitud = creditoPersonal.getSelectedItem().toString();
        if (solicitud.equals("Seleccione")) {
          JOptionPane.showMessageDialog(null, "Seleccione una solicitud");
        } else {
          CreditoPersonal credito = buscarCreditoPersonal(solicitud);
          credito.getAmortizacion().calcularCuotas();
          credito.getAmortizacion().calcularCuotasInteres();
          credito.getAmortizacion().calcularAmortizacion();
          ArrayList<Double> cuotas = credito.getAmortizacion().getMontoCuotas();
          ArrayList<Double> intereses = credito.getAmortizacion().getCuotasInteres();
          ArrayList<Double> amortizacion = credito.getAmortizacion().getAmortizacion();
          double monto = credito.getMontoFinal();
          double interes = 0.0;
          double amortizacion1 = 0.0;
          for (int i = 0; i < credito.getAmortizacion().getPlazoEnAnos(); i++) {
            Object[] data = new Object[5];
            data[0] = i + 1;
            data[1] = cuotas.get(i);
            data[2] = intereses.get(i);
            data[3] = amortizacion.get(i);
            data[4] = monto;
            monto = monto - amortizacion.get(i);
            interes += intereses.get(i);
            amortizacion1 += amortizacion.get(i);
            dtm.addRow(data);
          }
          data[0] = "Total";
          data[1] = "";
          data[2] = interes;
          data[3] = amortizacion1;
          data[4] = monto;
          dtm.addRow(data);
        }
      }
    });
    JButton button = new JButton("Salir");
    button.setBounds(50, 680, 200, 30);
    button.setBackground(new Color(135, 206, 250));
    button.setFont(new Font("Times new Roman", Font.BOLD, 16));
    button.setForeground(new Color(0, 0, 0));
    panel2.add(button);
    button.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        // frame.setVisible(false);
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }

    });
    // frame.getContentPane().add(button, BorderLayout.SOUTH);
  }

  private void menuCalcularCreditoPrendarioDolar() {

    // JFrame frame = new JFrame("Calcular credito personal en dolares");
    JPanel panel2 = new JPanel();
    JLabel codigo = new JLabel("numero de solicitud");
    JLabel titulo = new JLabel("Calcular credito prendario en dolares");
    codigo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    codigo.setBackground(new Color(0, 153, 153));
    JComboBox<String> creditoPersonal = new JComboBox<String>();

    // frame.setSize(500, 500);
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setVisible(true);
    creditoPersonal.addItem("Seleccione");

    // frame.add(panel2);
    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 153, 153));
    panel2.setBounds(0, 0, 500, 500);
    this.add(panel2);

    setBounds(350, 0, 780, 850);

    titulo.setBounds(100, 10, 500, 40);
    titulo.setBackground(new Color(0, 153, 153));
    titulo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    panel2.add(titulo);

    codigo.setBounds(50, 100, 200, 40);
    codigo.setBackground(new Color(0, 153, 153));
    codigo.setFont(new Font("Times new Roman", Font.BOLD, 18));
    panel2.add(codigo);

    creditoPersonal.setFont(new Font("Times new Roman", Font.BOLD, 15));
    creditoPersonal.setBackground(new Color(255, 255, 255));
    creditoPersonal.setBounds(50, 150, 200, 30);
    panel2.add(creditoPersonal);

    for (CreditoPersonal credito : creditosPersonales) {
      String numero = credito.getNumSolicitud();
      creditoPersonal.addItem(numero);
    }

    // frame.getContentPane().add(creditoPersonal, BorderLayout.NORTH);
    // frame.getContentPane().add(codigo, BorderLayout.SOUTH);

    // creamos el arreglo de objetos que contendra el
    // contenido de las columnas
    Object[] data = new Object[5]; // = new Object[5];

    // creamos el modelo de Tabla
    DefaultTableModel dtm = new DefaultTableModel();

    // se crea la Tabla con el modelo DefaultTableModel
    final JTable table = new JTable(dtm);

    // insertamos las columnas
    dtm.addColumn("No. de cuota ");
    dtm.addColumn("Monto Cuota ");
    dtm.addColumn("Interes ");
    dtm.addColumn("Amortizacion ");
    dtm.addColumn("Deuda ");

    // insertamos el contenido de las columnas
    for (int row = 0; row < 20; row++) {
      for (int column = 0; column < 5; column++) {
        data[column] = "Celda " + row + "," + column;
      }
      dtm.addRow(data);
    }

    // se define el tama�o
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));

    // Creamos un JscrollPane y le agregamos la JTable
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBounds(50, 250, 700, 300);
    scrollPane.setBackground(new Color(255, 255, 255));
    scrollPane.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(scrollPane);

    // Agregamos el JScrollPane al contenedor
    // frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

    // manejamos la salida

    // frame.addWindowListener(new WindowAdapter() {
    // public void windowClosing(WindowEvent e) {
    // System.exit(0);
    // }
    // });
    JButton calcular = new JButton("Calcular");
    calcular.setBounds(50, 620, 200, 30);
    calcular.setBackground(new Color(135, 206, 250));
    calcular.setFont(new Font("Times new Roman", Font.BOLD, 16));
    calcular.setForeground(new Color(0, 0, 0));
    panel2.add(calcular);
    // frame.getContentPane().add(calcular);
    calcular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String solicitud = creditoPersonal.getSelectedItem().toString();
        if (solicitud.equals("Seleccione")) {
          JOptionPane.showMessageDialog(null, "Seleccione una solicitud");
        } else {
          CreditoPersonal credito = buscarCreditoPersonal(solicitud);
          credito.getAmortizacion().calcularCuotas();
          credito.getAmortizacion().calcularCuotasInteres();
          credito.getAmortizacion().calcularAmortizacion();
          ArrayList<Double> cuotas = credito.getAmortizacion().getMontoCuotas();
          ArrayList<Double> intereses = credito.getAmortizacion().getCuotasInteres();
          ArrayList<Double> amortizacion = credito.getAmortizacion().getAmortizacion();
          double monto = credito.getMontoFinal();
          for (int i = 0; i < credito.getAmortizacion().getPlazoEnAnos(); i++) {
            Object[] data = new Object[5];
            data[0] = i + 1;
            data[1] = cuotas.get(i);
            data[2] = intereses.get(i);
            data[3] = amortizacion.get(i);
            data[4] = monto;
            monto = monto - amortizacion.get(i);
            dtm.addRow(data);
          }
        }
      }
    });
    JButton button = new JButton("Salir");
    button.setBounds(50, 680, 200, 30);
    button.setBackground(new Color(135, 206, 250));
    button.setFont(new Font("Times new Roman", Font.BOLD, 16));
    button.setForeground(new Color(0, 0, 0));
    panel2.add(button);
    button.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        // frame.setVisible(false);
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }

    });
    // frame.getContentPane().add(button, BorderLayout.SOUTH);
  }

  private void menuCalcularCreditoPersonalEnColones() {

    // JFrame frame = new JFrame("Calcular credito personal en dolares");
    JPanel panel2 = new JPanel();
    JLabel codigo = new JLabel("numero de solicitud");
    JLabel titulo = new JLabel("Calcular credito personal en colones");
    codigo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    codigo.setBackground(new Color(0, 153, 153));
    JComboBox<String> creditoPersonal = new JComboBox<String>();

    // frame.setSize(500, 500);
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setVisible(true);
    creditoPersonal.addItem("Seleccione");

    // frame.add(panel2);
    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 153, 153));
    panel2.setBounds(0, 0, 500, 500);
    this.add(panel2);

    setBounds(350, 0, 780, 850);

    titulo.setBounds(100, 10, 500, 40);
    titulo.setBackground(new Color(0, 153, 153));
    titulo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    panel2.add(titulo);

    codigo.setBounds(50, 100, 200, 40);
    codigo.setBackground(new Color(0, 153, 153));
    codigo.setFont(new Font("Times new Roman", Font.BOLD, 18));
    panel2.add(codigo);

    creditoPersonal.setFont(new Font("Times new Roman", Font.BOLD, 15));
    creditoPersonal.setBackground(new Color(255, 255, 255));
    creditoPersonal.setBounds(50, 150, 200, 30);
    panel2.add(creditoPersonal);

    for (CreditoPersonal credito : creditosPersonales) {
      String numero = credito.getNumSolicitud();
      creditoPersonal.addItem(numero);
    }

    // frame.getContentPane().add(creditoPersonal, BorderLayout.NORTH);
    // frame.getContentPane().add(codigo, BorderLayout.SOUTH);

    // creamos el arreglo de objetos que contendra el
    // contenido de las columnas
    Object[] data = new Object[5]; // = new Object[5];

    // creamos el modelo de Tabla
    DefaultTableModel dtm = new DefaultTableModel();

    // se crea la Tabla con el modelo DefaultTableModel
    final JTable table = new JTable(dtm);

    // insertamos las columnas
    dtm.addColumn("No. de cuota ");
    dtm.addColumn("Monto Cuota ");
    dtm.addColumn("Interes ");
    dtm.addColumn("Amortizacion ");
    dtm.addColumn("Deuda ");

    // insertamos el contenido de las columnas
    // for (int row = 0; row < 20; row++) {
    // for (int column = 0; column < 5; column++) {
    // data[column] = "Celda " + row + "," + column;
    // }
    // dtm.addRow(data);
    // }

    // se define el tama�o
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));

    // Creamos un JscrollPane y le agregamos la JTable
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBounds(50, 250, 700, 300);
    scrollPane.setBackground(new Color(255, 255, 255));
    scrollPane.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(scrollPane);

    // Agregamos el JScrollPane al contenedor
    // frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

    // manejamos la salida

    // frame.addWindowListener(new WindowAdapter() {
    // public void windowClosing(WindowEvent e) {
    // System.exit(0);
    // }
    // });
    JButton calcular = new JButton("Calcular");
    calcular.setBounds(50, 620, 200, 30);
    calcular.setBackground(new Color(135, 206, 250));
    calcular.setFont(new Font("Times new Roman", Font.BOLD, 16));
    calcular.setForeground(new Color(0, 0, 0));
    panel2.add(calcular);
    // frame.getContentPane().add(calcular);
    calcular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String solicitud = creditoPersonal.getSelectedItem().toString();
        if (solicitud.equals("Seleccione")) {
          JOptionPane.showMessageDialog(null, "Seleccione una solicitud");
        } else {
          CreditoPersonal credito = buscarCreditoPersonal(solicitud);
          ArrayList<Double> cuotas = credito.getAmortizacion().getMontoCuotas();
          ArrayList<Double> intereses = credito.getAmortizacion().getCuotasInteres();
          ArrayList<Double> amortizacion = credito.getAmortizacion().getAmortizacion();
          double monto = credito.getAmortizacion().calcularMontoFinalASolicitar();
          Double interes = 0.0;
          Double amortizacion1 = 0.0;
          for (int i = 0; i < credito.getAmortizacion().getPlazoEnAnos(); i++) {
            // Object[] data = new Object[5];
            data[0] = i + 1;
            data[1] = cuotas.get(i);
            data[2] = intereses.get(i);
            data[3] = amortizacion.get(i);
            data[4] = monto;
            monto -= amortizacion.get(i);
            interes += intereses.get(i);
            amortizacion1 += amortizacion.get(i);
            dtm.addRow(data);
            // System.out.println(data[0] + " " + data[1] + " " + data[2] + " " + data[3] +
            // " " + data[4]);
          }
          data[0] = "Total";
          data[1] = "";
          data[2] = interes;
          data[3] = amortizacion1;
          data[4] = monto;
          dtm.addRow(data);
        }
      }
    });
    JButton button = new JButton("Salir");
    button.setBounds(50, 680, 200, 30);
    button.setBackground(new Color(135, 206, 250));
    button.setFont(new Font("Times new Roman", Font.BOLD, 16));
    button.setForeground(new Color(0, 0, 0));
    panel2.add(button);
    button.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        // frame.setVisible(false);
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }

    });
    // frame.getContentPane().add(button, BorderLayout.SOUTH);
  }

  private void menuCalcularCreditoPersonalEnDolar() {

    // JFrame frame = new JFrame("Calcular credito personal en dolares");
    JPanel panel2 = new JPanel();
    JLabel codigo = new JLabel("numero de solicitud");
    JLabel titulo = new JLabel("Calcular credito personal en dolares");
    codigo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    codigo.setBackground(new Color(0, 153, 153));
    JComboBox<String> creditoPersonal = new JComboBox<String>();

    // frame.setSize(500, 500);
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setVisible(true);
    creditoPersonal.addItem("Seleccione");

    // frame.add(panel2);
    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 153, 153));
    panel2.setBounds(0, 0, 500, 500);
    this.add(panel2);

    setBounds(350, 0, 780, 850);

    titulo.setBounds(100, 10, 500, 40);
    titulo.setBackground(new Color(0, 153, 153));
    titulo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    panel2.add(titulo);

    codigo.setBounds(50, 100, 200, 40);
    codigo.setBackground(new Color(0, 153, 153));
    codigo.setFont(new Font("Times new Roman", Font.BOLD, 18));
    panel2.add(codigo);

    creditoPersonal.setFont(new Font("Times new Roman", Font.BOLD, 15));
    creditoPersonal.setBackground(new Color(255, 255, 255));
    creditoPersonal.setBounds(50, 150, 200, 30);
    panel2.add(creditoPersonal);

    for (CreditoPersonal credito : creditosPersonales) {
      String numero = credito.getNumSolicitud();
      creditoPersonal.addItem(numero);
    }

    // frame.getContentPane().add(creditoPersonal, BorderLayout.NORTH);
    // frame.getContentPane().add(codigo, BorderLayout.SOUTH);

    // creamos el arreglo de objetos que contendra el
    // contenido de las columnas
    Object[] data = new Object[5]; // = new Object[5];

    // creamos el modelo de Tabla
    DefaultTableModel dtm = new DefaultTableModel();

    // se crea la Tabla con el modelo DefaultTableModel
    final JTable table = new JTable(dtm);

    // insertamos las columnas
    dtm.addColumn("No. de cuota ");
    dtm.addColumn("Monto Cuota ");
    dtm.addColumn("Interes ");
    dtm.addColumn("Amortizacion ");
    dtm.addColumn("Deuda ");

    // se define el tama�o
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));

    // Creamos un JscrollPane y le agregamos la JTable
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBounds(50, 250, 700, 300);
    scrollPane.setBackground(new Color(255, 255, 255));
    scrollPane.setFont(new Font("Times new Roman", Font.BOLD, 15));
    panel2.add(scrollPane);

    // Agregamos el JScrollPane al contenedor
    // frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

    // manejamos la salida

    // frame.addWindowListener(new WindowAdapter() {
    // public void windowClosing(WindowEvent e) {
    // System.exit(0);
    // }
    // });
    JButton calcular = new JButton("Calcular");
    calcular.setBounds(50, 620, 200, 30);
    calcular.setBackground(new Color(135, 206, 250));
    calcular.setFont(new Font("Times new Roman", Font.BOLD, 16));
    calcular.setForeground(new Color(0, 0, 0));
    panel2.add(calcular);
    // frame.getContentPane().add(calcular);
    calcular.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String solicitud = creditoPersonal.getSelectedItem().toString();
        if (solicitud.equals("Seleccione")) {
          JOptionPane.showMessageDialog(null, "Seleccione una solicitud");
        } else {
          CreditoPersonal credito = buscarCreditoPersonal(solicitud);
          ArrayList<Double> cuotas = credito.getAmortizacion().getMontoCuotas();
          ArrayList<Double> intereses = credito.getAmortizacion().getCuotasInteres();
          ArrayList<Double> amortizacion = credito.getAmortizacion().getAmortizacion();
          double monto = credito.getAmortizacion().calcularMontoFinalASolicitar();
          for (int i = 0; i < credito.getAmortizacion().getPlazoEnAnos(); i++) {
            data[0] = i + 1;
            data[1] = cuotas.get(i);
            data[2] = intereses.get(i);
            data[3] = amortizacion.get(i);
            data[4] = monto;
            monto -= amortizacion.get(i);
            dtm.addRow(data);
          }
        }
      }
    });
    JButton button = new JButton("Salir");
    button.setBounds(50, 680, 200, 30);
    button.setBackground(new Color(135, 206, 250));
    button.setFont(new Font("Times new Roman", Font.BOLD, 16));
    button.setForeground(new Color(0, 0, 0));
    panel2.add(button);
    button.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        // frame.setVisible(false);
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }

    });
    // frame.getContentPane().add(button, BorderLayout.SOUTH);
  }

  private CreditoPersonal buscarCreditoPersonal(String pNumeroSolicitud) {
    for (CreditoPersonal credito : creditosPersonales) {
      if (credito.getNumSolicitud().equals(pNumeroSolicitud)) {
        return credito;
      }
    }
    return null;
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
        String destinatario = textField.getText();
        String asunto = textField2.getText();
        String mensaje = textArea.getText();
        try {
          email.enviarEmail(destinatario, asunto, mensaje);
          setBounds(350, 0, 700, 850);
          panel2.setVisible(false);
          panel.setVisible(true);
        } catch (MessagingException e1) {
          e1.printStackTrace();
        }
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
    JPanel panel2 = new JPanel();
    JLabel titulo = new JLabel("Crear PDF");
    JLabel labelNombre = new JLabel("Nombre del archivo: ");
    JLabel labelCredito = new JLabel("Credito: ");

    JTextField nombreText = new JTextField();
    JTextField creditoText = new JTextField();

    JButton crear = new JButton("Crear");
    JButton regresar = new JButton("Regresar");

    panel2.setLayout(null);
    panel2.setBackground(new Color(0, 153, 153));
    panel2.setBounds(0, 0, 800, 700);
    this.add(panel2);

    titulo.setBounds(50, 50, 500, 40);
    titulo.setBackground(new Color(0, 153, 153));
    titulo.setFont(new Font("Times new Roman", Font.BOLD, 20));
    panel2.add(titulo);

    labelNombre.setBounds(50, 100, 200, 20);
    labelNombre.setBackground(new Color(0, 153, 153));
    labelNombre.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelNombre);

    labelCredito.setBounds(50, 150, 200, 20);
    labelCredito.setBackground(new Color(0, 153, 153));
    labelCredito.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(labelCredito);

    nombreText.setBounds(50, 130, 200, 20);
    nombreText.setBackground(new Color(255, 255, 255));
    nombreText.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(nombreText);

    creditoText.setBounds(50, 170, 200, 20);
    creditoText.setBackground(new Color(255, 255, 255));
    creditoText.setFont(new Font("Times new Roman", Font.BOLD, 12));
    panel2.add(creditoText);

    crear.setBounds(50, 620, 200, 30);
    crear.setBackground(new Color(135, 206, 250));
    crear.setFont(new Font("Times new Roman", Font.BOLD, 16));
    crear.setForeground(new Color(0, 0, 0));
    panel2.add(crear);

    regresar.setBounds(50, 720, 150, 40);
    regresar.setBackground(new Color(135, 206, 250));
    regresar.setFont(new Font("Times new Roman", Font.BOLD, 16));
    regresar.setForeground(new Color(0, 0, 0));
    panel2.add(regresar);

    crear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String nombre = nombreText.getText();
        String credito = creditoText.getText();
        // pdf.crearPDF(nombre, credito);
        setBounds(350, 0, 700, 850);
        panel2.setVisible(false);
        panel.setVisible(true);
      }
    });

  }

}