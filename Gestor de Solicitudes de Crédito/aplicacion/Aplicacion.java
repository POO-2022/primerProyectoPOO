package aplicacion;

import interfaz.*;

public class Aplicacion {
  public static void main(String[] args) {
    try{
      ventana ventana = new ventana();
      ventana.setVisible(true);
    }catch(Exception e){
      System.out.println("Error");
    }
  }

}
