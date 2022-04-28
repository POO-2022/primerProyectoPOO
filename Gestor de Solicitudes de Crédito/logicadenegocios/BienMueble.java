package logicadenegocios;
/**
 * 
 * @author Derrick Acosta
 * @version 1.0
 */
public class BienMueble extends Bien
{
  //Atributos de la clase BienMueble
  private double valor;
  /**
   * Constructor de la clase BienMueble
   * @param pValor indica el valor
   */
  public BienMueble(double pValor){
      valor=pValor;
  }    
  
  public double getValor() {
    return valor;
  }
  public void setValor(double pValor) {
    this.valor = pValor;
  }

  public String toString(){
    String msg= "Valor: \n"+valor; 
    return msg;
  }
}