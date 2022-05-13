package logicadenegocios;

/**
 * Abstraccion del concepto de un fiador
 * 
 * @author Kevin Salazar
 * @version 1.0
 */
public class Fiador {
  private String cedula;
  private String nombre;
  private String telefono;
  private double salarioBruto;
  private double salarioLiquido;

  /**
   * Constructor principal de la clase Fiador
   * 
   * @param pCedula:         cedula del fiador
   * @param pNombre:         nombre y apellidos del fiador
   * @param pTelefono:       telefono del fiador
   * @param pSalarioBruto:   salario bruto (sin deducciones) del fiador
   * @param pSalarioLiquido: salario liquido (con deducciones) del fiador
   */
  public Fiador(String pCedula, String pNombre, String pTelefono, double pSalarioBruto, double pSalarioLiquido) {
    this.cedula = pCedula;
    this.nombre = pNombre;
    this.telefono = pTelefono;
    this.salarioBruto = pSalarioBruto;
    this.salarioLiquido = pSalarioLiquido;
  }

  // m?todos accesores
  public String getCedula() {
    return cedula;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String pTelefono) {
    this.telefono = pTelefono;
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

  /**
   * Genera el estado del objeto en una cadena de caracteres
   * 
   * @return cadena de caracteres
   */
  public String toString() {
    String msg = "Fiador: \n";
    msg += "C?dula: " + cedula + "\n";
    msg += "Nombre: " + nombre + "\n";
    msg += "Telefono: " + telefono + "\n";
    msg += "Salario Bruto: " + salarioBruto + "\n";
    msg += "Salario l?quido: " + salarioLiquido + "\n";
    return msg;
  }
}
