package logicadenegocios;

import java.math.*;
import java.util.ArrayList;

/**
 * Clase extendida de la superclase SistemaAmortizacion
 * Pretende simular el funcionamiento de un sistema de amortizacion francés
 * 
 * @author Andy Porras
 * @author Kevin Salazar
 * @version 2.0
 */
public class SistemaFrances extends SistemaAmortizacion {
  private ArrayList<Double> cuotasInteres; //sk
  private ArrayList<Double> montoCuotas;  //ck
  private ArrayList<Double> amortizacion; //vk
  private ArrayList<Double> deudas; //v

  public SistemaFrances(double pPrestamoOtorgado, int pPlazoEnAnos, double pTasaInteresAnual) {
    super(pPrestamoOtorgado, pPlazoEnAnos, pTasaInteresAnual);
    setCuotasIntereses();
    setMontoCuotas();
    setAmortizacion();
    setDeudas();
  }
  
  // metodos accesores

  public void setCuotasIntereses(){ //Sn
    cuotasInteres = new ArrayList<Double>();
    
    for(int x = 1; x<=super.getPlazoEnAnos(); x++){
      double sk = calcularCuotasInteres(x);
      cuotasInteres.add(sk);
    }
  }

  public void setMontoCuotas(){ //Cn
    montoCuotas = new ArrayList<Double>();

    for(int x = 1; x<=super.getPlazoEnAnos(); x++){
      double ck = (calcularCuotasInteres(x) + calcularAmortizacion(x)); //ck = sk+vk
      montoCuotas.add(ck);
    }
  }

  public void setAmortizacion(){ //Vn
    amortizacion = new ArrayList<Double>();
    
    for(int x = 1; x<=super.getPlazoEnAnos(); x++){
      double sk = calcularAmortizacion(x);
      amortizacion.add(sk);
    }
  }

  public void setDeudas(){ //V
    deudas = new ArrayList<Double>();
    double deuda = super.getPrestamoOtorgado();
    ArrayList<Double> pagos = getAmortizacion();
    
    deudas.add(deuda);
    for(int x = 0; x<pagos.size(); x++){
      deudas.add(deuda-pagos.get(x));
    }
  }

  public ArrayList<Double> getCuotasInteres() {
    return cuotasInteres;
  }

  public ArrayList<Double> getMontoCuotas() {
    return montoCuotas;
  }

  public ArrayList<Double> getAmortizacion() {
    return amortizacion;
  }
  
  /**
   * Calcula el valor de cuota neceesario para el calculo de cuotas de interés
   */
  public double calcularCuota() { //C
    double i = super.getTasaInteresAnual();
    double v = super.getPrestamoOtorgado();
    double n = super.getPlazoEnAnos();
    
    return (v*i)/(1-Math.pow((1+i), (n*-1)));
  }
  
  /**
   * Calcula el monto por cuota de interes dependiendo el año
   * @param k año del plazo
   * @return concepto por cuota de interes
   */
  public double calcularCuotasInteres(int k) { //sk
    double c=calcularCuota();
    double n = super.getPlazoEnAnos();
    double i = super.getTasaInteresAnual();
    
    return c*(1-(1/Math.pow(1+i, (n+1-k))));
  }
  
  /**
   * Calcula el monto por cuota de amortizacion dependiendo el año
   * @param k año del plazo
   * @return concepto por cuota de amortizacion
   */
  public double calcularAmortizacion(int k) {  //vk
    double n = super.getPlazoEnAnos();
    double i = super.getTasaInteresAnual();
    double c = calcularCuota();

    return (c/Math.pow((1+i),(n+1-k)));
  }
}
