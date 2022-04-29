package logicadenegocios;

/**
 * Subclase derivada de la superclase BienInmueble
 * 
 * @author Andy Porras
 * @version 28/04/2022
 */
public class AdquisicionTerreno extends BienInmueble {

  /**
   * Constructor de la clase
   * 
   * @param pNombre
   * @param pDeudor
   * @param pDireccion
   * @param pAreaTerreno
   * @param pNumPlano
   * @param pMontoAvaluo
   */
  public AdquisicionTerreno(String pNombre, Deudor pDeudor, Direccion pDireccion, double pAreaTerreno, int pNumPlano,
      double pMontoAvaluo) {
    super(pNombre, pDeudor, pDireccion, pAreaTerreno, pNumPlano, pMontoAvaluo);
  }

  public Direccion getDireccion() {
    return super.getDireccion();
  }

  public double getAreaTerreno() {
    return super.getAreaTerreno();
  }

  public int getNumPlano() {
    return super.getNumPlano();
  }

  public double getMontoAvaluo() {
    return super.getMontoAvaluo();
  }
}
