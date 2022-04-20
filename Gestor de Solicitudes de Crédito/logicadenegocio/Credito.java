package logicadenegocio;
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
  private double sNumSolicitud;
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
   * @param pSNumSolicitud: el numero de solicitud
   */
  public Credito(Deudor pCliente, double pMontoSolicitado, int pPlazoEnMeses,TMoneda pMoneda, LocalDate pFechaSolicitud, String pNumSolicitud, double pTasaInteres, double pTasaBasicaPasiva, double pComision, SistemaAmortizacion pAmortizacion,TCostosLegales pTipoCostosLegales,CuotaMensual pCuotaMensual, double pMontoFinal, double pSNumSolicitud){
    cliente=pCliente;
    montoSolicitado=pMontoSolicitado;
    plazoEnMeses=pPlazoEnMeses;
    moneda=pMoneda;
    fechaSolicitud=pFechaSolicitud;
    numSolicitud=pNumSolicitud;
    tasaIntereses=pTasaInteres;
    tasaBasicaPasiva=pTasaBasicaPasiva;
    comision=pComision;
    amortizacion=pAmortizacion;
    tipoCostosLegales=pTipoCostosLegales;
    cuotaMensual=pCuotaMensual;
    montoFinal=pMontoFinal;
    sNumSolicitud=pSNumSolicitud;
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
