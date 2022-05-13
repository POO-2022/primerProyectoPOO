package pruebas;

import logicadenegocios.*;
import utilies.*;

/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test{
  public static void main(String[] args) throws Exception {
    try {
      JsonManager jsonManager = new JsonManager();
      Direccion direccion = new Direccion("Limon", "talamanca", "sixaola", "frente al...");
      Deudor deudor = new Deudor("Andy", "Andrey", "Porras", "Romero", "2021067834", direccion, "123456789",
          "andyporras@gmail",
          120000, 120000);
      CuotaMensual cuota = new CuotaMensual(2332.44, 23.44);
      CreditoPersonal credito = new CreditoPersonal(deudor, 2120000.5, 12, TMoneda.COLONES, 5.5, 4.3, 1200,
          TCostosLegales.TRASPASO, cuota, "carro");
      Credito credito2 = new CreditoPersonal(deudor, 212000.5, 12, TMoneda.DOLARES, 5.5, 4.3, 1200,
          TCostosLegales.TRASPASO, cuota, "carro");
      jsonManager.agregarCreditoPersonal(credito);
      //jsonManager.agregarCredito(credito2);
      // jsonManager.agregarDireccion(direccion);
      jsonManager.agregarDeudor(deudor);
      System.out.println(jsonManager.leerJson("deudores"));
      String datos = jsonManager.leerJson("deudores");
      
      int i = datos.indexOf("primerNombre") + 16;
      // int i2 = datos.indexOf("primerNombre", i + 1);
      System.out.println(datos.substring(i, datos.indexOf("\"", i)));
      i = datos.indexOf("segundoNombre") + 17;
      System.out.println(datos.substring(i, datos.indexOf("\"", i)));
      i = datos.indexOf("primerApellido") + 18;
      System.out.println(datos.substring(i, datos.indexOf("\"", i)));
      i = datos.indexOf("segundoApellido") + 19;
      System.out.println(datos.substring(i, datos.indexOf("\"", i)));
      i = datos.indexOf("salario Bruto") + 16;
      System.out.println(datos.substring(i, datos.indexOf(",", i)));
      i = datos.indexOf("salario Liquido") + 18;
      System.out.println(datos.substring(i, datos.indexOf(",", i)));
      i = datos.indexOf("correo") + 10;
      System.out.println(datos.substring(i, datos.indexOf("\"", i)));
      i = datos.indexOf("telefono") + 12;
      System.out.println(datos.substring(i, datos.indexOf("\"", i)));
      i = datos.indexOf("provincia") + 13;
      System.out.println(datos.substring(i, datos.indexOf("\"", i)));
      i = datos.indexOf("canton") + 10;
      System.out.println(datos.substring(i, datos.indexOf("\"", i)));
      i = datos.indexOf("distrito") + 12;
      System.out.println(datos.substring(i, datos.indexOf("\"", i)));
      // jsonManager.agregarDeudor(deudor);
      i = datos.indexOf("\"");
      String cedula = datos.substring(i+1, datos.indexOf(":", i)-1);
      System.out.println(cedula);

    } finally {
      System.out.println("Fin del programa");
    }

  }
}