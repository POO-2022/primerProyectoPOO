package logicadenegocios;

import java.time.LocalDate;

/**
 * Subclase derivada de la superclase Credito
 * Representa la abstraccion de un credito prendario
 * @author KEVIN SALAZAR
 * @version 1.0
 */
public class CreditoPrendario extends Credito{
  private BienMueble prenda;
  private double gastoFormalizacion;
  private static final double COSTO_FORMALIZACION = 0.03;
  
  public CreditoPrendario(Deudor pCliente, double pMontoSolicitado, int pPlazoEnMeses,TMoneda pMoneda, 
  LocalDate pFechaSolicitud, String pNumSolicitud, double pTasaInteres, double pTasaBasicaPasiva, double pComision,
  SistemaAmortizacion pAmortizacion,TCostosLegales pTipoCostosLegales,CuotaMensual pCuotaMensual, double pMontoFinal, 
  BienMueble pPrenda){
    super(pCliente, pMontoSolicitado, pPlazoEnMeses, pMoneda, pFechaSolicitud, pNumSolicitud, pTasaInteres, pTasaBasicaPasiva, pComision, pAmortizacion, pTipoCostosLegales, pCuotaMensual, pMontoFinal);
    setGastoFormalizacion();
    setPrenda(pPrenda);
    //super.setAmortizacion()
  }
  
  public BienMueble getPrenda(){
    return prenda;  
  }
  
  public void setPrenda(BienMueble pPrenda){
    this.prenda = pPrenda;  
  }
  
  public double getGastoFormalizacion() {
    return gastoFormalizacion;
  }

  public void setGastoFormalizacion() {
    this.gastoFormalizacion = super.getMontoSolicitado()*COSTO_FORMALIZACION;
  }
  
  public double calcularMontoFinalASolicitar(){
    return 0;
  }
}
