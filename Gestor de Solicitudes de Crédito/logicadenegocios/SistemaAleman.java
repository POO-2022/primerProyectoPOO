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
    calcularAmortizacion();
    calcularCuotas();
    calcularCuotasInteres();
    calcularMontoFinalASolicitar();
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
    for (int i = 0; i < super.getPlazoEnAnos() + 1; i++) {
      double valor = (super.getPlazoEnAnos() - i + 1)
          * ((super.getPrestamoOtorgado() * super.getTasaInteresAnual()) / super.getPlazoEnAnos());
      if (i > 0) {
        cuotasInteres.add(valor);
      }
    }
  }

  public void calcularAmortizacion() {// V
    for (int i = 0; i < super.getPlazoEnAnos(); i++) {
      double valor = super.getPrestamoOtorgado() / super.getPlazoEnAnos();
      amortazacion.add(valor);
    }
  }

  public double calcularMontoFinalASolicitar() {
    double result = 0;
    result = super.getPrestamoOtorgado();
    return result;
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

  public String toString() {
    String result = "";
    result += "numero de cuuota \t" + "monto de cuota \t"  + "interes \t"+ "amortizacion: \t"+ "deuda\n";
    int monto = 0;
    int interes = 0;
    int amortizacion = 0;
    monto = (int) calcularMontoFinalASolicitar();
    for (int i = 0; i < super.getPlazoEnAnos(); i++) {
      result += i + 1 + "\t" + montoCuotas.get(i) + "\t" + cuotasInteres.get(i) + "\t" + amortazacion.get(i) + "\t"
          +monto+ "\n";
      monto = (int) (monto - amortazacion.get(i));
      interes = (int) (interes + cuotasInteres.get(i));
      amortizacion = (int) (amortizacion + amortazacion.get(i));
    }
    result += "total \t\t" + interes + "\t" + amortizacion + "\t" + monto;
    return result;
  }
}
