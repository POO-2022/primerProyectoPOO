package logicadenegocios;

/**
 * ClaseInmueble
 * 
 * @author Derrick Acosta
 * @version 1.0
 */
public class BienInmueble extends Bien {
  // Atributos de la clase
  private Direccion direccion;
  private double areaTerreno;
  private int numPlano;
  private double montoAvaluo;

  /**
   * Constructor de la clase BienInmueble
   * 
   * @param pDireccion   direccion del bien
   * @param pAreaTerreno el area del terreno
   * @param pNumPlano    el numero de plano
   * @param pMontoAvaluo el monto de avaluo
   */
  public BienInmueble(String pNombre, Deudor pDeudor, Direccion pDireccion, Double pAreaTerreno, int pNumPlano,
      Double pMontoAvaluo) {
    super(pNombre, pDeudor);
    direccion = pDireccion;
    areaTerreno = pAreaTerreno;
    numPlano = pNumPlano;
    montoAvaluo = pMontoAvaluo;
  }

  public Direccion getDireccion() {
    return direccion;
  }

  public void setDireccion(Direccion pDireccion) {
    direccion = pDireccion;
  }

  public double getAreaTerreno() {
    return areaTerreno;
  }

  public void setAreaTerreno(double areaTerreno) {
    this.areaTerreno = areaTerreno;
  }

  public int getNumPlano() {
    return numPlano;
  }

  public void setNumPlano(int pNumPlano) {
    this.numPlano = pNumPlano;
  }

  public double getMontoAvaluo() {
    return montoAvaluo;
  }

  public void setMontoAvaluo(double montoAvaluo) {
    this.montoAvaluo = montoAvaluo;
  }

  // public String toString(){

  // }
}
