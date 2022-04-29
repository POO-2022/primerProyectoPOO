package logicadenegocios;

/**
 * class SistemaFrances
 * 
 * @author Andy Porras
 * @version 28/04/2022
 */
public class SistemaFrances extends SistemaAmortizacion {
  private double cuotasInteres;
  private double montoCuotas;
  private double amortizacion;

  public SistemaFrances(double pPrestamoOtorgado, double pPlazoEnAnos, double pTasaInteresAnual, double pCuotasInteres,
      double pMontoCuotas, double pAmortazacion) {
    super(pPrestamoOtorgado, pPlazoEnAnos, pTasaInteresAnual);
    this.cuotasInteres = pCuotasInteres;
    this.montoCuotas = pMontoCuotas;
    this.amortizacion = pAmortazacion;
  }

  public double getCuotasInteres() {
    return cuotasInteres;
  }

  public double getMontoCuotas() {
    return montoCuotas;
  }

  public double getAmortazacion() {
    return amortizacion;
  }

  // no implementada correctamente
  public void calcularAmortizacion() {
    amortizacion = prestamoOtorgado / plazoEnAnos;
  }

}
