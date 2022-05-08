package logicadenegocios;

import java.util.ArrayList;

/**
 * class SistemaFrances
 * 
 * @author Andy Porras
 * @version 28/04/2022
 */
public class SistemaFrances extends SistemaAmortizacion {
  private ArrayList<Double> cuotasInteres;
  private ArrayList<Double> montoCuotas;
  private ArrayList<Double> amortizacion;

  public SistemaFrances(double pPrestamoOtorgado, double pPlazoEnAnos, double pTasaInteresAnual) {
    super(pPrestamoOtorgado, pPlazoEnAnos, pTasaInteresAnual);
    cuotasInteres = new ArrayList<Double>();
    montoCuotas = new ArrayList<Double>();
    amortizacion = new ArrayList<Double>();
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

  // Ck cuota
  // Vk cuota de amortizacion
  // Sk cuota de interes
  // V monto del prestamo
  // n plazo en años
  // i tasa de interes anual
  public void calcularCuotas() {// C
    for (int i = 0; i < super.getPlazoEnAnos(); i++) {
      double valor = (super.getPrestamoOtorgado() * super.getTasaInteresAnual())
          / (1 - (Math.pow(1 + super.getTasaInteresAnual(), -super.getPlazoEnAnos())));
      montoCuotas.add(valor);
    }
  }

  public void calcularCuotasInteres() {// S
    for (int i = 0; i < super.getPlazoEnAnos(); i++) {
      double valor = montoCuotas.get(i)
          * (1 - 1 / (Math.pow(1 + super.getTasaInteresAnual(), super.getPlazoEnAnos() + 1 - i)));
      cuotasInteres.add(valor);
    }
  }

  public void calcularAmortizacion() {// V
    for (int i = 0; i < super.getPlazoEnAnos(); i++) {
      double valor = montoCuotas.get(i) / ((Math.pow(1 + super.getTasaInteresAnual(), super.getPlazoEnAnos() + 1 - i)));
      amortizacion.add(valor);
    }
  }
}
