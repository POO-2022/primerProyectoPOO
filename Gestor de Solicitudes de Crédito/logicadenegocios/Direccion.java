package logicadenegocios;

/**
 * class Direccion
 * 
 * @author Andy Porras
 */
public class Direccion {
  String provincia;
  String canton;
  String distrito;
  String senas;

  public Direccion(String pProvincia, String pCanton, String pDistrito, String pSenas) {
    this.provincia = pProvincia;
    this.canton = pCanton;
    this.distrito = pDistrito;
    this.senas = pSenas;
  }

  public String getProvincia() {
    return provincia;
  }

  public String getCanton() {
    return canton;
  }

  public String getDistrito() {
    return distrito;
  }

  public String getSenas() {
    return senas;
  }

  public String toString() {
    String datos = "";
    datos += "Provincia: " + provincia + "\n";
    datos += "Canton: " + canton + "\n";
    datos += "Distrito: " + distrito + "\n";
    datos += "Senas: " + senas + "\n";
    return datos;
  }
}
