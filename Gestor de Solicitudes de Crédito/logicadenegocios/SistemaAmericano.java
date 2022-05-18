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
  private ArrayList<Double> cuotasAmortizacion; // vk
  private double cuotasInteres; // sk
  private ArrayList<Double> deudas; // V
  private ArrayList<Double> cuotas; // ck

  public SistemaAmericano(double pPrestamoOtorgado, int pPlazoEnAnios, double pTasaInteresAnual) {
    super(pPrestamoOtorgado, pPlazoEnAnios, pTasaInteresAnual);
    cuotasAmortizacion = new ArrayList<Double>();
    deudas = new ArrayList<Double>();
    cuotas = new ArrayList<Double>();
    cuotasInteres = 0;
    calcularInteres();
    calculoAmortizacion();
    calculoCuotas();
  }

  // metodos accesores
  public ArrayList<Double> getCuotasAmortizacion() {
    return cuotasAmortizacion;
  }

  public double getCuotasInteres() {
    return cuotasInteres;
  }

  public ArrayList<Double> getDeudas() {
    return deudas;
  }

  public ArrayList<Double> getCuotas() {
    return cuotas;
  }

  /**
   * Calcula el monto de interes en el plazo de pago
   * dicho monto es constante
   */
  public void calcularInteres() {
    cuotasInteres = super.getPrestamoOtorgado() * super.getTasaInteresAnual();
  }

  /**
   * setea el calculo de amortizaciones en el plazo otorgado
   * Segun el sistema americano, todas las amortizaciones son nulas, excepto la
   * ultima, que corresponde al monto otorgado
   */
  public void calculoAmortizacion() {
    int n = super.getPlazoEnAnos();
    for (int i = 0; i < n - 1; i++) {
      cuotasAmortizacion.add(0.0); // vk = 0
      deudas.add(super.getPrestamoOtorgado());
    }
    cuotasAmortizacion.add(super.getPrestamoOtorgado());
    deudas.add(0.0);
  }

  /**
   * Calcula el monto de cada cuota en el plazo de años correspondiente
   */
  public void calculoCuotas() {
    for (int i = 0; i < super.getPlazoEnAnos(); i++) {
      cuotas.add(getCuotasAmortizacion().get(i) + getCuotasInteres());
    }
  }
  public String toString () {
    String result = "";
    result += "numero de cuuota \t" + "monto de cuota \t"  + "interes \t"+ "amortizacion: \t"+ "deuda\n";
    int monto = 0;
    int interes = 0;
    int amortizacion = 0;
    monto = (int) getPrestamoOtorgado();
    for (int i = 0; i < super.getPlazoEnAnos(); i++) {
      result += i + 1 + "\t" +cuotas.get(i) + "\t" + cuotasInteres + "\t" + cuotasAmortizacion.get(i) + "\t" + deudas.get(i) + "\n";
      interes += (int) cuotasInteres;
      amortizacion = (int) (amortizacion +cuotasAmortizacion.get(i));
      monto = (int) (monto -deudas.get(i));

    }
    result += "total\t\t" + interes + "\t" + amortizacion + "\t" + monto;
    return result;
  }
}
