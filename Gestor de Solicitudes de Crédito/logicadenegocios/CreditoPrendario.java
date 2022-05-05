package logicadenegocios;

/**
 * Subclase derivada de la superclase Credito
 * Representa la abstraccion de un credito prendario
 * 
 * @author KEVIN SALAZAR
 * @version 1.0
 */
public class CreditoPrendario extends Credito {
  private BienMueble prenda;
  private double gastoFormalizacion;
  private static final double COSTO_FORMALIZACION = 0.03;

  public CreditoPrendario(Deudor pCliente, double pMontoSolicitado, int pPlazoEnMeses, TMoneda pMoneda,
      double pTasaInteres, double pTasaBasicaPasiva,
      double pComision, TCostosLegales pTipoCostosLegales,
      CuotaMensual pCuotaMensual, BienMueble pPrenda) {
    super(pCliente, pMontoSolicitado, pPlazoEnMeses, pMoneda, pTasaInteres,
        pTasaBasicaPasiva,
        pComision, pTipoCostosLegales, pCuotaMensual);
    setGastoFormalizacion();
    setPrenda(pPrenda);
    // super.setAmortizacion()
  }

  public BienMueble getPrenda() {
    return prenda;
  }

  public void setPrenda(BienMueble pPrenda) {
    this.prenda = pPrenda;
  }

  public double getGastoFormalizacion() {
    return gastoFormalizacion;
  }

  public void setGastoFormalizacion() {
    this.gastoFormalizacion = super.getMontoSolicitado() * COSTO_FORMALIZACION;
  }

  public double calcularMontoFinalASolicitar() {
    return 0;
  }
}
