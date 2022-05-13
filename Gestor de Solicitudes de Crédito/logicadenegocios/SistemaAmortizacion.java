package logicadenegocios;

/**
 * Sistema de Amortizacion
 * 
 * @author Andy Porras
 * @version 1.0
 */
public abstract class SistemaAmortizacion {
  protected double prestamoOtorgado;
  protected int plazoEnAnos;
  protected double tasaInteresAnual;

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
  public SistemaAmortizacion(double pPrestamoOtorgado, int pPlazoEnAnos, double pTasaInteresAnual) {
    this.prestamoOtorgado = pPrestamoOtorgado;
    this.plazoEnAnos = pPlazoEnAnos;
    this.tasaInteresAnual = pTasaInteresAnual;
  }

  // metodos accesores
  public double getPrestamoOtorgado() {
    return prestamoOtorgado;
  }

  public int getPlazoEnAnos() {
    return plazoEnAnos;
  }

  public double getTasaInteresAnual() {
    return tasaInteresAnual;
  }
}
