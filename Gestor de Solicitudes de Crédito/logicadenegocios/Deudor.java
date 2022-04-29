package logicadenegocios;

import java.util.ArrayList;

/**
 * Clase que representa una persona deudora
 * 
 * @author Kevin Salazar
 * @version 1.0
 */
public class Deudor {
  private String primerNombre;
  private String segundoNombre;
  private String primerApellido;
  private String segundoApellido;
  private int cedula;
  private String telefono;
  private double salarioBruto;
  private double salarioLiquido;
  private String correoElectronico;
  private Direccion direccion;
  private ArrayList<Fiador> fiadores;

  /**
   * Constructor principal de la clase
   * 
   * Conjunto de parametros:
   * Indican el nombre completo del deudor
   * 
   * @param pPrimerNombre
   * @param pSegundoNombre
   * @param pPrimerApellido
   * @param pSegundoApellido
   * 
   * @param pCedula:            indica la cedula del deudor
   * @param pDireccion:         indica la direccion del deudor
   * @param pTelefono:          indica el numero de telefono del deudor
   * @param pCorreoElectronico: indica el correo electronico del deudor
   * @param pSalarioBruto:      salario bruto (sin deducciones) del deudor
   * @param pSalarioLiquido:    salario liquido (con deducciones) del deudor
   * @param fiadores:           son los fiadores del deudor
   */
  public Deudor(String pPrimerNombre, String pSegundoNombre, String pPrimerApellido,
      String pSegundoApellido, int pCedula, Direccion pDireccion, String pTelefono, String pCorreoElectronico,
      double pSalarioBruto,
      double pSalarioLiquido) {
    this.primerNombre = pPrimerNombre;
    this.segundoNombre = pSegundoNombre;
    this.primerApellido = pPrimerApellido;
    this.segundoApellido = pSegundoApellido;
    this.cedula = pCedula;
    direccion = pDireccion;
    this.telefono = pTelefono;
    correoElectronico = pCorreoElectronico;
    this.salarioBruto = pSalarioBruto;
    this.salarioLiquido = pSalarioLiquido;
    this.fiadores = new ArrayList<Fiador>();
  }

  // m?todos accesores
  public String getPrimerNombre() {
    return primerNombre;
  }

  public void setPrimerNombre(String pPrimerNombre) {
    this.primerNombre = pPrimerNombre;
  }

  public String getSegundoNombre() {
    return segundoNombre;
  }

  public void setSegundoNombre(String pSegundoNombre) {
    this.segundoNombre = pSegundoNombre;
  }

  public String getPrimerApellido() {
    return primerApellido;
  }

  public void setPrimerApellido(String pPrimerApellido) {
    this.primerApellido = pPrimerApellido;
  }

  public String getSegundoApellido() {
    return segundoApellido;
  }

  public void setSegundoApellido(String pSegundoApellido) {
    this.segundoApellido = pSegundoApellido;
  }

  public int getCedula() {
    return cedula;
  }

  public void setCedula(int pCedula) {
    this.cedula = pCedula;
  }

  public Direccion getDireccion() {
    return direccion;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String pTelefono) {
    this.telefono = pTelefono;
  }

  public String getCorreoElectronico() {
    return correoElectronico;
  }

  public double getSalarioBruto() {
    return salarioBruto;
  }

  public void setSalarioBruto(double pSalarioBruto) {
    this.salarioBruto = pSalarioBruto;
  }

  public double getSalarioLiquido() {
    return salarioLiquido;
  }

  public void setSalarioLiquido(double pSalarioLiquido) {
    this.salarioLiquido = pSalarioLiquido;
  }

  public ArrayList<Fiador> getFiadores() {
    return fiadores;
  }

  public String getFiadoresV2() {
    String losFiadores = "";
    for (Fiador actual : fiadores) {
      losFiadores += actual;
    }
    return losFiadores;
  }

  /**
   * Genera el estado del objeto en una cadena de caracteres
   * 
   * @return cadena de caracteres
   */
  public String toString() {
    String msg = "Fiador: \n";
    msg += "C?dula: " + cedula + "\n";
    msg += "Nombre: " + primerNombre + " " + segundoNombre + " " + primerApellido + " " + segundoApellido + "\n";
    msg += "Telefono: " + telefono + "\n";
    msg += "Salario Bruto: " + salarioBruto + "\n";
    msg += "Salario l?quido: " + salarioLiquido + "\n";
    msg += "Fiador(es): \n" + getFiadoresV2() + "\n";

    return msg;
  }
}
