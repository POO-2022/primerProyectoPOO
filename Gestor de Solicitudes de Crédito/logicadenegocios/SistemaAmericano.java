package logicadenegocios;

import java.util.ArrayList;

/**
 * class SistemaAmericano
 * 
 * @author Andy Porras
 * @version 28/04/2022
 */
public class SistemaAmericano extends SistemaAmortizacion {
  private ArrayList<Double> cuotasInteres;

  public SistemaAmericano(double pPrestamoOtorgado, double pPlazoEnAnos, double pTasaInteresAnual,
      double pCuotasInteres) {
    super(pPrestamoOtorgado, pPlazoEnAnos, pTasaInteresAnual);
    cuotasInteres = new ArrayList<Double>();
  }

  // V monto del prestamo
  // n plazo en años
  // i tasa de interes anual
  public void calcularInteres() {
    for (int i = 0; i < super.getPlazoEnAnos(); i++) {
      double valor = super.getPrestamoOtorgado() * super.getTasaInteresAnual();
      cuotasInteres.add(valor);
    }
  }

  public ArrayList<Double> getAmortizacion() {
    ArrayList<Double> amortizacion = new ArrayList<Double>();
    for (int i = 0; i < super.getPlazoEnAnos() - 1; i++) {
      amortizacion.add(0.0);
    }
    double valor = super.getPrestamoOtorgado();
    amortizacion.add(valor);
    return amortizacion;
  }

  public ArrayList<Double> getCuotas() {
    ArrayList<Double> cuotas = new ArrayList<Double>();
    ArrayList<Double> amortizacion = getAmortizacion();
    ArrayList<Double> cuotasInteres = getCuotasInteres();
    for (int i = 0; i < super.getPlazoEnAnos(); i++) {
      double valor = amortizacion.get(i) + cuotasInteres.get(i);
      cuotas.add(valor);
    }
    return cuotas;
  }

  /**
   * @return double return the cuotasInteres
   */
  public ArrayList<Double> getCuotasInteres() {
    return cuotasInteres;
  }

}
