package logicadenegocios;

import java.util.ArrayList;


/**
 * Clase extendida de la superclase SistemaAmortizacion
 * Pretende simular el funcionamiento de un sistema de amortizacion americano
 * 
 * @author Andy Porras
 * @author Kevin Salazar
 * @version 2.0
 */
public class SistemaAmericano extends SistemaAmortizacion {
  private ArrayList<Double> cuotasAmortizacion; //vk
  private double cuotasInteres; //sk
  private ArrayList<Double> deudas; //V
  private ArrayList<Double> cuotas; //ck

  public SistemaAmericano(double pPrestamoOtorgado, int pPlazoEnAnios, double pTasaInteresAnual) {
    super(pPrestamoOtorgado, pPlazoEnAnios, pTasaInteresAnual);
    cuotasInteres = calcularInteres();
    cuotasAmortizacion = calculoAmortizacion();
    cuotas = calculoCuotas();
  }
  
  //metodos accesores
  public ArrayList<Double> getCuotasAmortizacion() {
    return cuotasAmortizacion;
  }

  public double getCuotasInteres() {
    return cuotasInteres;
  }

  public ArrayList<Double> getDeudas(){
    return deudas;
  }

  /**
   * Calcula el monto de interes en el plazo de pago
   * dicho monto es constante
   */
  public void calcularInteres() {
    cuotasInteres = super.getPrestamoOtorgado()*super.getTasaInteresAnual();
  }
  
  /** 
   * setea el calculo de amortizaciones en el plazo otorgado
   * Segun el sistema americano, todas las amortizaciones son nulas, excepto la ultima, que corresponde al monto otorgado
  */
  public void calculoAmortizacion(){
    int n = super.getPlazoEnAnos();
    for(int i = 0; i<n-1;i++){
      cuotasAmortizacion.add(0.0); //vk = 0
      deudas.add(super.getPrestamoOtorgado()); 
    }
    cuotasAmortizacion.add(super.getPrestamoOtorgado());
    deudas.add(0.0); 
  }
  
  /**
   * Calcula el monto de cada cuota en el plazo de años correspondiente
   */
  public void calculoCuotas(){
    for(int i=0; i<super.getPlazoEnAnos(); i++){
      cuotas.add(getCuotasAmortizacion().get(i)+getCuotasInteres());
    }
  }
}
