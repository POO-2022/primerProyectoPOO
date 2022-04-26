package logicadenegocios;

import java.time.LocalDate;

/**
 * Clase Credito 
 * 
 * @author Derrick Acosta
 * @version 19/04/2022
 */
public abstract class Credito
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
  public Credito(Deudor pCliente, double pMontoSolicitado, int pPlazoEnMeses,TMoneda pMoneda, 
          LocalDate pFechaSolicitud, String pNumSolicitud, double pTasaInteres, double pTasaBasicaPasiva, 
          double pComision, TCostosLegales pTipoCostosLegales,
          CuotaMensual pCuotaMensual, double pMontoFinal){
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
    amortizacion=null;
    tipoCostosLegales=pTipoCostosLegales;
    cuotaMensual=pCuotaMensual;
    montoFinal=pMontoFinal;
  }

    public Deudor getCliente() {
        return cliente;
    }

    public void setCliente(Deudor cliente) {
        this.cliente = cliente;
    }

    public double getMontoSolicitado() {
        return montoSolicitado;
    }

    public void setMontoSolicitado(double montoSolicitado) {
        this.montoSolicitado = montoSolicitado;
    }

    public int getPlazoEnMeses() {
        return plazoEnMeses;
    }

    public void setPlazoEnMeses(int plazoEnMeses) {
        this.plazoEnMeses = plazoEnMeses;
    }

    public TMoneda getMoneda() {
        return moneda;
    }

    public void setMoneda(TMoneda moneda) {
        this.moneda = moneda;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getNumSolicitud() {
        return numSolicitud;
    }

    public void setNumSolicitud(String numSolicitud) {
        this.numSolicitud = numSolicitud;
    }

    public double getTasaIntereses() {
        return tasaIntereses;
    }

    public void setTasaIntereses(double tasaIntereses) {
        this.tasaIntereses = tasaIntereses;
    }

    public double getTasaBasicaPasiva() {
        return tasaBasicaPasiva;
    }

    public void setTasaBasicaPasiva(double tasaBasicaPasiva) {
        this.tasaBasicaPasiva = tasaBasicaPasiva;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public SistemaAmortizacion getAmortizacion() {
        return amortizacion;
    }

    public void setAmortizacion(SistemaAmortizacion amortizacion) {
        this.amortizacion = amortizacion;
    }

    public TCostosLegales getTipoCostosLegales() {
        return tipoCostosLegales;
    }

    public void setTipoCostosLegales(TCostosLegales tipoCostosLegales) {
        this.tipoCostosLegales = tipoCostosLegales;
    }

    public CuotaMensual getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(CuotaMensual cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public static int getsNumSolicitud() {
        return sNumSolicitud;
    }

    public static void setsNumSolicitud(int sNumSolicitud) {
        Credito.sNumSolicitud = sNumSolicitud;
    }
  
  
  
  /**
   * Genera el numero de solicitud de cr�dito
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
   * Metodo abstracto para calcular el monto final que va solicitar
   */
  public abstract double calcularMontoFinalASolicitar();

  /**
   * Genera el estado del objeto en una cadena de caracteres
   * @return cadena de caracteres
   */
  public String toString() {
    String msg= "";
    msg += "N� Solicitud: " + numSolicitud + "\n";
    msg += "Cliente: " + cliente + "\n"; 
    msg += "Monto solicitado: " + montoSolicitado + "\n";
    msg += "Plazo (en meses): " + plazoEnMeses + "\n";
    msg += "Divisa: " + moneda + "\n";
    msg += "fechaSolicitud: " + fechaSolicitud + "\n";
    msg += "Tasa de Intereses: " + tasaIntereses + "\n";
    msg += "Tasa Basica Pasiva: " + tasaBasicaPasiva + "\n";
    msg += "Comision: " + comision + "\n";
    msg += "Amortizacion: " + amortizacion + "\n";
    msg += "Tipo de costos legales: " + tipoCostosLegales + "\n";
    msg += "Cuota Mensual: " + cuotaMensual + "\n";
    msg += "Monto Final: " + montoFinal + "\n";
    
    return msg;  
  }
  
  
}
