package logicadenegocios;

/**
 * Subclase derivada de la superclase BienInmueble
 * 
 * @author Andy Porras
 * @version 1.0
 */
public class ConstruccionVivienda extends BienInmueble {
  private TConstruccion tipoConstruccion;
  private double tamanoConstruccion;
  private int cantidadHabitaciones;
  private int cantidadBanios;
  private int cantidadEspacioParqueo;

  /**
   * Constructor de la clase
   * 
   * @param pNombre
   * @param pDeudor
   * @param pDireccion
   * @param pAreaTerreno
   * @param pNumPlano
   * @param pMontoAvaluo
   * @param pTipoConstruccion
   * @param pTamanoConstruccion
   * @param pCantidadHabitaciones
   * @param pCantidadBanios
   * @param pCantidadEspacioParqueo
   */
  public ConstruccionVivienda(String pNombre, Deudor pDeudor, Direccion pDireccion, double pAreaTerreno,
      int pNumPlano, double pMontoAvaluo, TConstruccion pTipoConstruccion, double pTamanoConstruccion,
      int pCantidadHabitaciones, int pCantidadBanios, int pCantidadEspacioParqueo) {
    super(pNombre, pDeudor, pDireccion, pAreaTerreno, pNumPlano, pMontoAvaluo);
    tipoConstruccion = pTipoConstruccion;
    tamanoConstruccion = pTamanoConstruccion;
    cantidadHabitaciones = pCantidadHabitaciones;
    cantidadBanios = pCantidadBanios;
    cantidadEspacioParqueo = pCantidadEspacioParqueo;
  }

  /**
   * Metodo que devuelve el tipo de construccion
   * 
   * @return tipoConstruccion
   */
  public TConstruccion getTipoConstruccion() {
    return tipoConstruccion;
  }

  /**
   * Metodo que devuelve el tamano de la construccion
   * 
   * @return tamanoConstruccion
   */
  public Double getTamanoConstruccion() {
    return tamanoConstruccion;
  }

  /**
   * Metodo que devuelve la cantidad de habitaciones
   * 
   * @return cantidadHabitaciones
   */
  public int getCantidadHabitaciones() {
    return cantidadHabitaciones;
  }

  /**
   * Metodo que devuelve la cantidad de baños
   * 
   * @return cantidadBanios
   */
  public int getCantidadBanios() {
    return cantidadBanios;
  }

  /**
   * Metodo que devuelve la cantidad de espacio de parqueo
   * 
   * @return cantidadEspacioParqueo
   */
  public int getCantidadEspacioParqueo() {
    return cantidadEspacioParqueo;
  }

  public void setTipoConstruccion(TConstruccion pTipoConstruccion) {
    tipoConstruccion = pTipoConstruccion;
  }

  public void setTamanoConstruccion(double pTamanoConstruccion) {
    tamanoConstruccion = pTamanoConstruccion;
  }

  public void setCantidadHabitaciones(int pCantidadHabitaciones) {
    cantidadHabitaciones = pCantidadHabitaciones;
  }

  public void setCantidadBanios(int pCantidadBanios) {
    cantidadBanios = pCantidadBanios;
  }

  public void setCantidadEspacioParqueo(int pCantidadEspacioParqueo) {
    cantidadEspacioParqueo = pCantidadEspacioParqueo;
  }

}
