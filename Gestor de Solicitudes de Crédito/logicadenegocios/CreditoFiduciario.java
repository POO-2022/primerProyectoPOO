package logicadenegocios;

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

  public CreditoFiduciario(Deudor pCliente, double pMontoSolicitado, int pPlazoEnMeses, TMoneda pMoneda,
      double pTasaInteres, double pTasaBasicaPasiva,
      double pComision, TCostosLegales pTipoCostosLegales,
      CuotaMensual pCuotaMensual, Fiador pFiador) {
    super(pCliente, pMontoSolicitado, pPlazoEnMeses, pMoneda, pTasaInteres,
        pTasaBasicaPasiva, pComision, pTipoCostosLegales, pCuotaMensual);
    fiadores = new ArrayList<Fiador>();
    fiadores.add(pFiador);
    setGastoFormalizacion();
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

  public ArrayList<Fiador> getFiadores() {
    return fiadores;
  }

  public void agregarFiador(Fiador pFiador) {
    fiadores.add(pFiador);
  }
}
