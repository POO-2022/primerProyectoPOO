package logicadenegocios;

/**
 * class SistemaAmericano
 * 
 * @author Andy Porras
 * @version 28/04/2022
 */
public class SistemaAmericano extends SistemaAmortizacion {
  private double cuotasInteres;

  public SistemaAmericano(double pPrestamoOtorgado, double pPlazoEnAnos, double pTasaInteresAnual,
      double pCuotasInteres) {
    super(pPrestamoOtorgado, pPlazoEnAnos, pTasaInteresAnual);
    this.cuotasInteres = pCuotasInteres;
  }

  // no implementada correctamente
  public void calcularAmortizacion() {

  }

  public double getCuotasInteres() {
    return cuotasInteres;
  }
}
