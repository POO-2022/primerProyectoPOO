package logicadenegocios;

/**
 * Sistema de Amortizacion
 * 
 * @author Andy Porras
 * @version 1.0
 */
public class SistemaAmortizacion {
  double prestamoOtorgado;
  double plazoEnAnos;
  double tasaInteresAnual;

  /**
   * Constructor for objects of class SistemaAmortizacion
   * 
   * @param pPrestamoOtorgado
   *                          prestamo otorgado
   * @param pPlazoEnAnos
   *                          plazo en anos
   * @param pTasaInteresAnual
   *                          tasa de interes anual
   */
  public SistemaAmortizacion(double pPrestamoOtorgado, double pPlazoEnAnos, double pTasaInteresAnual) {
    this.prestamoOtorgado = pPrestamoOtorgado;
    this.plazoEnAnos = pPlazoEnAnos;
    this.tasaInteresAnual = pTasaInteresAnual;
  }

  /**
   * retorna el prestamo otorgado
   * 
   * @return prestamoOtorgado
   */
  public double getPrestamoOtorgado() {
    return prestamoOtorgado;
  }

  /**
   * retorna el plazo en anos
   * 
   * @return plazoEnAnos
   */
  public double getPlazoEnAnos() {
    return plazoEnAnos;
  }

  /**
   * retorna la tasa de interes anual
   * 
   * @return tasaInteresAnual
   */
  public double getTasaInteresAnual() {
    return tasaInteresAnual;
  }

  public void calcularPlazoEnAnios() {
    plazoEnAnos = prestamoOtorgado / (tasaInteresAnual / 100);
  }

  // no implementada correctamente
  public void calcularAmortizacion() {

  }

  /**
   * retorna los datos del sistema de amortizacion
   * 
   * @return datos del sistema de amortizacion
   */
  public String toString() {
    String datos = "";
    datos += "Prestamo Otorgado: " + prestamoOtorgado + "\n";
    datos += "Plazo en Años: " + plazoEnAnos + "\n";
    datos += "Tasa de Interes Anual: " + tasaInteresAnual + "\n";
    return datos;
  }
}
