package logicadenegocios;
import java.time.LocalDate;

/**
 * Clase Credito 
 * 
 * @author Derrick Acosta
 * @version 19/04/2022
 */
public class Credito
{
  //atributos de la clase
  private Deudor cliente;
  private double montoSolicitado;
  private int plazoEnMeses;
  private TMoneda moneda;
  private LocalDate fechaSolicitud;
  private String numSolicitud;
  private double tasaIntereses;
  private double tasaBasicaPasiva;
  private double comision;
  private SistemaAmortizacion amortizacion;
  private TCostosLegales tipoCostosLegales;
  private CuotaMensual cuotaMensual;
  private double montoFinal;
  private static int sNumSolicitud = 0;
  /**
   * Constructor de la clase Credito
   * @param pCliente: es nombre del cliente
   * @param pMontoSolicitado: el monto de la cuota solicitado
   * @param pPlazoEnMeses: cantidad del plazo en meses
   * @param pMoneda: tipo de moneda
   * @param pFechaSolicitud: la fecha de la solicitud
   * @param pNumSolicitud: el numero de la solicitud
   * @param pTasaInteres: la tasa de intereses
   * @param pTasaBasicaPasiva: la tasa basica pasiva
   * @param pComision: la comision del credito
   * @param pAmortizacion: la amortizacion del credito
   * @param pTipoCostosLegales: el tipo de costps legales
   * @param pCuotaMensual: la cuota mensual
   * @param pMontoFinal: el monto final
   * @param pSNumSolicitud: el numero de solicitud indicado por el sistema
   */
  public Credito(Deudor pCliente, double pMontoSolicitado, int pPlazoEnMeses,TMoneda pMoneda, LocalDate pFechaSolicitud, String pNumSolicitud, double pTasaInteres, double pTasaBasicaPasiva, double pComision, SistemaAmortizacion pAmortizacion,TCostosLegales pTipoCostosLegales,CuotaMensual pCuotaMensual, double pMontoFinal){
    sNumSolicitud++;
    cliente=pCliente;
    montoSolicitado=pMontoSolicitado;
    plazoEnMeses=pPlazoEnMeses;
    moneda=pMoneda;
    fechaSolicitud=pFechaSolicitud;
    numSolicitud=generarNumSolicitud();
    tasaIntereses=pTasaInteres;
    tasaBasicaPasiva=pTasaBasicaPasiva;
    comision=pComision;
    amortizacion=pAmortizacion;
    tipoCostosLegales=pTipoCostosLegales;
    cuotaMensual=pCuotaMensual;
    montoFinal=pMontoFinal;
  }
  
  /**
   * Genera el numero de solicitud de crédito
   * @return cadena de caracteres con el codigo
   */  
  private String generarNumSolicitud(){
    String numeroSolic = "CRE";
    if(sNumSolicitud>=1000){
      numeroSolic += sNumSolicitud;
      return numeroSolic;
    }
    if(sNumSolicitud>=100){
      numeroSolic += "0" + sNumSolicitud;
      return numeroSolic;  
    }
    if(sNumSolicitud>=10){
      numeroSolic += "00" + sNumSolicitud;
      return numeroSolic;  
    }
    else{
      numeroSolic += "000" + sNumSolicitud;
      return numeroSolic;  
    }  
  }
  
  /**
   * Metodo para calcular la tasa pasiva 
   * 
   */
  public void calcularTasaPasiva(){
    
  }
  /**
   * Metodo para calcular el monto final que va solicitar
   */
  public double calcularMontoFinalASolicitar(){
    
  }
}
