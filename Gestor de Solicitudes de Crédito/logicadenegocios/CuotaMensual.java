package logicadenegocios;

/**
 * class CuotaMensual
 * 
 * @author Andy Porras
 * @version 1.0
 */
public class CuotaMensual {
  double principal;
  double interesAcumulado;

  public CuotaMensual(double pPrincipal, double pInteresAcumulado) {
    this.principal = pPrincipal;
    this.interesAcumulado = pInteresAcumulado;
  }

  public double getPrincipal() {
    return principal;
  }

  public double getInteresAcumulado() {
    return interesAcumulado;
  }

  public String toString() {
    String datos = "";
    datos += "Principal: " + principal + "\n";
    datos += "Intereses Acumulados: " + interesAcumulado + "\n";
    return datos;
  }
}
