package logicadenegocios;

/**
 * Subclase derivada de la superclase Credito
 * Representa la abstraccion de un cr�dito personal
 * 
 * @author KEVIN SALAZAR
 * @version 1.0
 */

public class CreditoPersonal extends Credito {
  private String motivoUso;
  private double gastoFormalizacion;
  private static final double COSTO_FORMALIZACION = 0.03;
  private SistemaAleman amortizacion;

  /**
   * Constructor heredado de la clase CreditoPersonal
   * 
   * @param pMotivoUso          el motivo por el cual se solicita el crédito
   * @param gastoFormalizacion  representa los gastos para la formalizacion del
   *                            crédito
   * @param COSTO_FORMALIZACION representa el porcentaje que se asigna por
   *                            concepto de gastos de la formalizacion
   */
  public CreditoPersonal(Deudor pCliente, double pMontoSolicitado, int pPlazoEnMeses, TMoneda pMoneda,
      double pTasaInteres, double pTasaBasicaPasiva,
      double pComision, TCostosLegales pTipoCostosLegales,
      CuotaMensual pCuotaMensual, String pMotivoUso) {
    super(pCliente, pMontoSolicitado, pPlazoEnMeses, pMoneda, pTasaInteres,
        pTasaBasicaPasiva, pComision, pTipoCostosLegales, pCuotaMensual);
    motivoUso = pMotivoUso;
    gastoFormalizacion = pMontoSolicitado * COSTO_FORMALIZACION;
    amortizacion = new SistemaAleman(calcularMontoFinalASolicitar(), pPlazoEnMeses, pTasaInteres);
    // super.setAmortizacion()
  }

  public SistemaAleman getAmortizacion() {
    return amortizacion;
  }

  public String getMotivoUso() {
    return motivoUso;
  }

  public void setMotivoUso(String motivoUso) {
    this.motivoUso = motivoUso;
  }

  public double getGastoFormalizacion() {
    return gastoFormalizacion;
  }

  public String getCedulaDeudor() {
    return super.getCliente().getCedula();
  }

  public void setGastoFormalizacion(double gastoFormalizacion) {
    this.gastoFormalizacion = gastoFormalizacion;
  }

  /**
   * @Override
   *           Sobreescritura del metodo toString de la superClase Credito
   * @return cadena de caracteres con el estado del objeto
   */

  public double calcularMontoFinalASolicitar() {
    double result = 0;
    result += gastoFormalizacion;
    result += super.getMontoSolicitado();
    return result;
  }
  public String toString() {
    String resul  = "";
    resul += "Credito Personal\n";
    resul += super.toString();
    resul += "Motivo de Uso: " + motivoUso + "\n";
    resul += "tabla de amortizacion: \n";
    resul += amortizacion.toString();
    return resul; 
  }
}