package logicadenegocios;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Subclase derivada de la superclase Credito
 * Representa la abstraccion de un credito fiduciario
 * 
 * @author KEVIN SALAZAR
 * @version 1.0
 */
public class CreditoFiduciario extends Credito {
  private ArrayList<Fiador> fiadores;
  private double gastoFormalizacion;
  private static final double COSTO_FORMALIZACION = 0.03;
  private SistemaFrances amortizacion;

  public CreditoFiduciario(Deudor pCliente, double pMontoSolicitado, int pPlazoEnMeses, TMoneda pMoneda,
      double pTasaInteres, double pTasaBasicaPasiva,
      double pComision, TCostosLegales pTipoCostosLegales,
      CuotaMensual pCuotaMensual, ArrayList<Fiador> pFiadores) {
    super(pCliente, pMontoSolicitado, pPlazoEnMeses, pMoneda, pTasaInteres,
        pTasaBasicaPasiva, pComision, pTipoCostosLegales, pCuotaMensual);
    fiadores = pFiadores;
    setGastoFormalizacion();
    amortizacion = new SistemaFrances(calcularMontoFinalASolicitar(), pPlazoEnMeses, pTasaInteres);
  }

  public void setCodigoCredito(String pCodigoCredito) {
    super.setNumSolicitud(pCodigoCredito);
  }

  public String getCedulaDeudor() {
    return super.getCliente().getCedula();
  }

  public void setFechaSolicitud(LocalDate pFechaSolicitud) {
    super.setFechaSolicitud(pFechaSolicitud);
  }

  public SistemaFrances getAmortizacion() {
    return amortizacion;
  }

  public double getGastoFormalizacion() {
    return gastoFormalizacion;
  }

  public void setGastoFormalizacion() {
    this.gastoFormalizacion = super.getMontoSolicitado() * COSTO_FORMALIZACION;
  }

  public double calcularMontoFinalASolicitar() {
    double result = 0;
    result += super.getMontoSolicitado() * COSTO_FORMALIZACION;
    result += super.getMontoSolicitado();
    super.setMontoFinal(result);
    return result;
  }

  public ArrayList<Fiador> getFiadores() {
    return fiadores;
  }

  public void agregarFiador(Fiador pFiador) {
    fiadores.add(pFiador);
  }
}
