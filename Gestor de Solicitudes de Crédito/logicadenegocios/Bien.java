package logicadenegocios;

/**
 * Bien
 * 
 * @author Andy Porras
 * @version 1.0
 */
public class Bien {
  String nombre;
  Deudor deudor;

  /**
   * Constructor for objects of class Bien
   * 
   * @param pNombre
   *                String
   * @param pDeudor
   *                Deudor
   */
  public Bien(String pNombre, Deudor pDeudor) {
    this.nombre = pNombre;
    this.deudor = pDeudor;
  }

  public String getNombre() {
    return nombre;
  }

  public Deudor getDeudor() {
    return deudor;
  }

  public String toString() {
    String datos = "";
    datos += "Nombre: " + nombre + "\n";
    datos += deudor.toString();
    return datos;
  }
}
