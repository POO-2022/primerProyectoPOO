package logicadenegocios;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Subclase derivada de la superclase Credito
 * Representa la abstraccion de un credito fiduciario
 * @author KEVIN SALAZAR
 * @version 1.0
 */
public class CreditoFiduciario extends Credito{
  private ArrayList<Fiador> fiadores;
  private double gastoFormalizacion;
  private static final double COSTO_FORMALIZACION = 0.03;
  
  public CreditoFiduciario(Deudor pCliente, double pMontoSolicitado, int pPlazoEnMeses,TMoneda pMoneda, 
  LocalDate pFechaSolicitud, String pNumSolicitud, double pTasaInteres, double pTasaBasicaPasiva, double pComision,
  SistemaAmortizacion pAmortizacion,TCostosLegales pTipoCostosLegales,CuotaMensual pCuotaMensual, double pMontoFinal){
    super(pCliente, pMontoSolicitado, pPlazoEnMeses, pMoneda, pFechaSolicitud, pNumSolicitud, pTasaInteres, pTasaBasicaPasiva, pComision, pAmortizacion, pTipoCostosLegales, pCuotaMensual, pMontoFinal);
    setGastoFormalizacion();
    //super.setAmortizacion()
    fiadores = new ArrayList<Fiador>()
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

  public ArrayList<Fiador> getFiadores() {
    return fiadores;
  }

  public void agregarFiador(Fiador pFiador) {
    fiadores.add(pFiador);
  }
}
