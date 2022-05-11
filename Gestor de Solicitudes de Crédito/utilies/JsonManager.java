package utilies;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;

import org.json.*;

import logicadenegocios.Credito;
import logicadenegocios.Deudor;
import logicadenegocios.Direccion;

public class JsonManager {
  public JsonManager() {

  }

  public boolean getJson(String json) {
    return true;
    // return false;
  }

  public String crearJson(String pNombre) {
    try {
      String ruta = "./data/" + pNombre + ".json";
      // String contenido = "Contenido de ejemplo";
      File file = new File(ruta);
      // Si el archivo no existe es creado
      if (!file.exists()) {
        file.createNewFile();
      }
      // FileWriter fw = new FileWriter(file);
      // BufferedWriter bw = new BufferedWriter(fw);
      // bw.write(contenido);
      // bw.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return pNombre;
  }
  public String leerJson(String pFile) {
    String ruta = "./data/" + pFile + ".json";
    String contenido = "";
    try {
      FileReader fr = new FileReader(ruta);
      BufferedReader br = new BufferedReader(fr);
      String linea;
      while ((linea = br.readLine()) != null) {
        contenido += linea;
      }
      br.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return contenido;
  }

  public boolean agregarDeudor(Deudor pDeudor) {
    JSONObject deudores = new JSONObject(leerJson("deudores"));
    JSONObject deudor = new JSONObject();
    String contenido = deudores.toString();

    try {
      deudores.get(pDeudor.getCedula());
      JOptionPane.showMessageDialog(null, "Ya existe un deudor con esa cedula");
      return false;
    } catch (Exception e) {
      // deudor.put("cedula", pDeudor.getCedula());
      deudor.put("primerNombre", pDeudor.getPrimerNombre());
      deudor.put("segundoNombre", pDeudor.getSegundoNombre());
      deudor.put("primerApellido", pDeudor.getPrimerApellido());
      deudor.put("segundoApellido", pDeudor.getSegundoApellido());
      deudor.put("provincia", pDeudor.getDireccion().getProvincia());
      deudor.put("canton", pDeudor.getDireccion().getCanton());
      deudor.put("distrito", pDeudor.getDireccion().getDistrito());
      deudor.put("senas", pDeudor.getDireccion().getSenas());
      deudor.put("telefono", pDeudor.getTelefono());
      deudor.put("correo", pDeudor.getCorreoElectronico());
      deudor.put("salario Bruto", pDeudor.getSalarioBruto());
      deudor.put("salario Liquido", pDeudor.getSalarioLiquido());
      // deudor.put("Fiadores", pDeudor.getFiadores());
      contenido = contenido.substring(0, contenido.length() - 1);
      deudores.put(pDeudor.getCedula(), deudor.toString());
      if (contenido.length() > 2) {
        contenido += ",";
      }
      contenido += "\"" + pDeudor.getCedula() + "\":"
          + deudores.get(pDeudor.getCedula()).toString().replace("\\", "") + "}";
      actualizarJson("deudores", contenido);

      JOptionPane.showMessageDialog(null, "Deudor a sido agregado con exito a la base de datos");
      return true;
    }

  }

  public boolean agregarDireccion(Direccion pDireccion) {
    JSONObject direcciones = new JSONObject(leerJson("direcciones"));
    JSONObject direccion = new JSONObject();
    String contenido = direcciones.toString();
    try {
      direcciones.get(pDireccion.getCodigoPostal());
      JOptionPane.showMessageDialog(null, "La Direccion ya ha cido registrada ya ha sido registrada.");
      return false;
    } catch (Exception e) {
      direccion.put("provincia", pDireccion.getProvincia());
      direccion.put("canto", pDireccion.getCanton());
      direccion.put("distrito", pDireccion.getDistrito());
      direccion.put("senas", pDireccion.getSenas());
      // for (int i = 0; i < pDireccion.getEspecialidades().size(); i++) {
      // direccion.put("especialidad" + i,
      // pDireccion.getEspecialidades().get(i).getEspecialidad());
      // }
      contenido = contenido.substring(0, contenido.length() - 1);
      direcciones.put(pDireccion.getCodigoPostal(), direccion.toString());
      if (contenido.length() > 2) {
        contenido += ",";
      }
      contenido += "\"" + pDireccion.getCodigoPostal() + "\":"
          + direcciones.get(pDireccion.getCodigoPostal()).toString().replace("\\", "") + "}";

      actualizarJson("direcciones", contenido);
      JOptionPane.showMessageDialog(null, "La direcciones ha sido registrado con éxito.");
      return true;
    }
  }

  public boolean agregarCredito(Credito pCredito) {
    JSONObject creditos = new JSONObject(leerJson("creditos"));
    JSONObject credito = new JSONObject();
    String contenido = creditos.toString();
    System.out.println(contenido);
    try {
      creditos.get(pCredito.getNumSolicitud());
      JOptionPane.showMessageDialog(null, "El credito ya ha sido registrado.");
      return false;
    } catch (Exception e) {
      credito.put("monto", pCredito.getMontoSolicitado());
      credito.put("plazo", pCredito.getPlazoEnMeses());
      credito.put("moneda", pCredito.getMoneda());
      credito.put("fecha de la solicitud", pCredito.getFechaSolicitud());
      contenido = contenido.substring(0, contenido.length() - 1);
      creditos.put(pCredito.getNumSolicitud(), credito.toString());
      if (contenido.length() > 2) {
        contenido += ",";
      }
      contenido += "\"" + pCredito.getNumSolicitud() + "\":"
          + creditos.get(pCredito.getNumSolicitud()).toString().replace("\\", "") + "}";
      actualizarJson("creditos", contenido);
      JOptionPane.showMessageDialog(null, "El credito ha sido registrados con éxito.");
      return true;
    }
  }
  public boolean actualizarJson(String pFile, String pContent) {
    String ruta = "./data/" + pFile + ".json";
    try {
      FileWriter fw = new FileWriter(ruta);
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(pContent);
      bw.close();
    } catch (Exception e) {
      System.out.println("Error al actualizar el archivo");
      return false;
    }
    return true;
  }

  public boolean buscarEnJson(String pFile, String pIdentificacion) {
    JSONObject json = new JSONObject(leerJson(pFile));
    try {
      json.get(pIdentificacion);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public JSONObject obtenerObjeto(String pFile, String pIdentificacion) {
    JSONObject json = new JSONObject(leerJson(pFile));
    try {
      JSONObject result = new JSONObject(json.get(pIdentificacion).toString());
      return result;
    } catch (Exception e) {
      return null;
    }
  }
}
