package logicadenegocios;

import java.time.LocalDate;

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
      LocalDate pFechaSolicitud, String pNumSolicitud, double pTasaInteres, double pTasaBasicaPasiva,
      double pComision, TCostosLegales pTipoCostosLegales,
      CuotaMensual pCuotaMensual, double pMontoFinal, String pMotivoUso) {
    super(pCliente, pMontoSolicitado, pPlazoEnMeses, pMoneda, pFechaSolicitud, pNumSolicitud, pTasaInteres,
        pTasaBasicaPasiva, pComision, pTipoCostosLegales, pCuotaMensual, pMontoFinal);
    motivoUso = pMotivoUso;
    gastoFormalizacion = pMontoSolicitado * COSTO_FORMALIZACION;
    // super.setAmortizacion()
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

  public void setGastoFormalizacion(double gastoFormalizacion) {
    this.gastoFormalizacion = gastoFormalizacion;
  }

  /**
   * @Override
   *           Sobreescritura del metodo toString de la superClase Credito
   * @return cadena de caracteres con el estado del objeto
   */

  public double calcularMontoFinalASolicitar() {
    return 0;
  }
}