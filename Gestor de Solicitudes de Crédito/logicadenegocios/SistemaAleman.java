package logicadenegocios;

import java.util.ArrayList;

/**
 * class SistemaAleman
 * 
 * @author Andy Porras
 * @version 28/04/2022
 */
public class SistemaAleman extends SistemaAmortizacion {
  private ArrayList<Double> cuotasInteres;
  private ArrayList<Double> montoCuotas;
  private ArrayList<Double> amortazacion;

  public SistemaAleman(double pPrestamoOtorgado, int pPlazoEnAnos, double pTasaInteresAnual) {
    super(pPrestamoOtorgado, pPlazoEnAnos, pTasaInteresAnual);
    cuotasInteres = new ArrayList<Double>();
    montoCuotas = new ArrayList<Double>();
    amortazacion = new ArrayList<Double>();
  }

  // Ck cuota
  // Vk cuota de amortizacion
  // Sk cuota de interes
  // V monto del prestamo
  // n plazo en años
  // i tasa de interes anual
  public void calcularCuotas() {// C
    double valor = super.getPrestamoOtorgado() / super.getPlazoEnAnos()
        + super.getTasaInteresAnual() * super.getPrestamoOtorgado();
    montoCuotas.add(valor);
    for (int i = 1; i < super.getPlazoEnAnos(); i++) {
      valor = valor - super.getTasaInteresAnual() * (super.getPrestamoOtorgado() / super.getPlazoEnAnos());
      montoCuotas.add(valor);
    }
  }

  public void calcularCuotasInteres() {// S
    for (int i = 0; i < super.getPlazoEnAnos(); i++) {
      double valor = (super.getPlazoEnAnos() - i + 1)
          * ((super.getPrestamoOtorgado() * super.getTasaInteresAnual()) / super.getPlazoEnAnos());
      cuotasInteres.add(valor);
    }
  }

  public void calcularAmortizacion() {// V
    for (int i = 0; i < super.getPlazoEnAnos(); i++) {
      double valor = super.getPrestamoOtorgado() / super.getPlazoEnAnos();
      amortazacion.add(valor);
    }
  }

  public ArrayList<Double> getCuotasInteres() {
    return cuotasInteres;
  }

  public ArrayList<Double> getMontoCuotas() {
    return montoCuotas;
  }

  public ArrayList<Double> getAmortizacion() {
    return amortazacion;
  }
}
