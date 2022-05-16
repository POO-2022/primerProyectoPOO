package utilies;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;

import org.json.*;

import logicadenegocios.Credito;
import logicadenegocios.CreditoFiduciario;
import logicadenegocios.CreditoPersonal;
import logicadenegocios.Deudor;
import logicadenegocios.Fiador;

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
    if (contenido.equals("")) {
      return "";
    } else {
      return contenido;
    }
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

  public boolean agregarCreditoFiduciario(CreditoFiduciario pCreditoFiduciario) {
    JSONObject creditosFiduciarios = new JSONObject(leerJson("creditosFiduciarios"));
    JSONObject creditoFiduciario = new JSONObject();
    String contenido = creditosFiduciarios.toString();
    try {
      creditosFiduciarios.get(pCreditoFiduciario.getNumSolicitud());
      JOptionPane.showMessageDialog(null, "Ya existe un credito fiduciario con ese numero de credito");
      return false;
    } catch (Exception e) {
      creditoFiduciario.put("monto Solicitado", pCreditoFiduciario.getMontoSolicitado());
      creditoFiduciario.put("plazo en meses", pCreditoFiduciario.getPlazoEnMeses());
      creditoFiduciario.put("Moneda del credito", pCreditoFiduciario.getMoneda());
      creditoFiduciario.put("fecha de la solicitud", pCreditoFiduciario.getFechaSolicitud());
      creditoFiduciario.put("tasa de interes", pCreditoFiduciario.getTasaIntereses());
      creditoFiduciario.put("tasa basica pasiva", pCreditoFiduciario.getTasaBasicaPasiva());
      creditoFiduciario.put("comision", pCreditoFiduciario.getComision());
      creditoFiduciario.put("tipo costo legales", pCreditoFiduciario.getTipoCostosLegales());
      creditoFiduciario.put("cedula del deudor", pCreditoFiduciario.getCedulaDeudor());
      System.out.println(pCreditoFiduciario.getFiadores().size());
      if (pCreditoFiduciario.getFiadores().size() <= 1) {
        creditoFiduciario.put("fiador 1", pCreditoFiduciario.getFiadores().get(0).getCedula());
        creditoFiduciario.put("fiador 2", "");
        contenido = contenido.substring(0, contenido.length() - 1);
        creditosFiduciarios.put(pCreditoFiduciario.getNumSolicitud(), creditoFiduciario.toString());
        if (contenido.length() > 2) {
          contenido += ",";
        }
        contenido += "\"" + pCreditoFiduciario.getNumSolicitud() + "\":"
            + creditosFiduciarios.get(pCreditoFiduciario.getNumSolicitud()).toString().replace("\\", "") + "}";
        actualizarJson("creditosFiduciarios", contenido);
        JOptionPane.showMessageDialog(null, "Credito fiduciario a sido agregado con exito a la base de datos");
        return true;
      } else {
        creditoFiduciario.put("fiador 1", pCreditoFiduciario.getFiadores().get(0).getCedula());
        creditoFiduciario.put("fiador 2", pCreditoFiduciario.getFiadores().get(1).getCedula());
        contenido = contenido.substring(0, contenido.length() - 1);
        creditosFiduciarios.put(pCreditoFiduciario.getNumSolicitud(), creditoFiduciario.toString());
        if (contenido.length() > 2) {
          contenido += ",";
        }
        contenido += "\"" + pCreditoFiduciario.getNumSolicitud() + "\":"
            + creditosFiduciarios.get(pCreditoFiduciario.getNumSolicitud()).toString().replace("\\", "") + "}";
        actualizarJson("creditosFiduciarios", contenido);
        JOptionPane.showMessageDialog(null, "Credito fiduciario a sido agregado con exito a la base de datos");
        return true;
      }
    }
  }

  public boolean agregarFiador(Fiador pFiador) {
    JSONObject fiadores = new JSONObject(leerJson("fiadores"));
    JSONObject fiador = new JSONObject();
    String contenido = fiadores.toString();
    try {
      fiadores.get(pFiador.getCedula());
      JOptionPane.showMessageDialog(null, "Ya existe un fiador con ese numero de cedula");
      return false;
    } catch (Exception e) {
      fiador.put("nombre", pFiador.getNombre());
      fiador.put("telefono", pFiador.getTelefono());
      fiador.put("salario Bruto", pFiador.getSalarioBruto());
      fiador.put("salario Liquido", pFiador.getSalarioLiquido());
      contenido = contenido.substring(0, contenido.length() - 1);
      fiadores.put(pFiador.getCedula(), fiador.toString());
      if (contenido.length() > 2) {
        contenido += ",";
      }
      contenido += "\"" + pFiador.getCedula() + "\":"
          + fiadores.get(pFiador.getCedula()).toString().replace("\\", "") + "}";
      actualizarJson("fiadores", contenido);
      JOptionPane.showMessageDialog(null, "Fiador a sido agregado con exito a la base de datos");
      return true;
    }
  }

  public boolean agregarCreditoPersonal(CreditoPersonal pCreditoPersonal) {
    JSONObject creditosPersonales = new JSONObject(leerJson("creditosPersonal"));
    JSONObject creditoPersonal = new JSONObject();
    String contenido = creditosPersonales.toString();
    try {
      creditosPersonales.get(pCreditoPersonal.getNumSolicitud());
      JOptionPane.showMessageDialog(null, "Ya existe un credito personal con esa solicitud");
      return false;
    } catch (Exception e) {
      creditoPersonal.put("monto Solicitado", pCreditoPersonal.getMontoSolicitado());
      creditoPersonal.put("plazo en meses", pCreditoPersonal.getPlazoEnMeses());
      creditoPersonal.put("Moneda del credito", pCreditoPersonal.getMoneda());
      creditoPersonal.put("fecha de la solicitud", pCreditoPersonal.getFechaSolicitud());
      creditoPersonal.put("tasa de interes", pCreditoPersonal.getTasaIntereses());
      creditoPersonal.put("tasa basica pasiva", pCreditoPersonal.getTasaBasicaPasiva());
      creditoPersonal.put("comision", pCreditoPersonal.getComision());
      creditoPersonal.put("tipo costo legales", pCreditoPersonal.getTipoCostosLegales());
      creditoPersonal.put("cedula del deudor", pCreditoPersonal.getCedulaDeudor());
      creditoPersonal.put("motivo de uso", pCreditoPersonal.getMotivoUso());
      contenido = contenido.substring(0, contenido.length() - 1);
      creditosPersonales.put(pCreditoPersonal.getNumSolicitud(), creditoPersonal.toString());
      if (contenido.length() > 2) {
        contenido += ",";
      }
      contenido += "\"" + pCreditoPersonal.getNumSolicitud() + "\":"
          + creditosPersonales.get(pCreditoPersonal.getNumSolicitud()).toString().replace("\\", "") + "}";
      actualizarJson("creditosPersonal", contenido);
      JOptionPane.showMessageDialog(null, "Credito personal a sido agregado con exito a la base de datos");
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
