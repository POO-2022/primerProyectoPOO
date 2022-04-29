package logicadenegocios;

/**
 * class SistemaAleman
 * 
 * @author Andy Porras
 * @version 28/04/2022
 */
public class SistemaAleman extends SistemaAmortizacion {
  private double cuotasInteres;
  private double montoCuotas;
  private double amortazacion;

  public SistemaAleman(double pPrestamoOtorgado, double pPlazoEnAnos, double pTasaInteresAnual, double pCuotasInteres,
      double pMontoCuotas, double pAmortazacion) {
    super(pPrestamoOtorgado, pPlazoEnAnos, pTasaInteresAnual);
    this.cuotasInteres = pCuotasInteres;
    this.montoCuotas = pMontoCuotas;
    this.amortazacion = pAmortazacion;
  }

  public double getCuotasInteres() {
    return cuotasInteres;
  }

  public double getMontoCuotas() {
    return montoCuotas;
  }

  public double getAmortazacion() {
    return amortazacion;
  }

  // no implementada correctamente
  public void calcularAmortizacion() {
    amortazacion = prestamoOtorgado / plazoEnAnos;
  }

}
