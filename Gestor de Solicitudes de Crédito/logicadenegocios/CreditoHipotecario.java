package logicadenegocios;

/**
 * Subclase derivada de la superclase Credito
 * Representa la abstraccion de un credito hipotecario
 * 
 * @author KEVIN SALAZAR
 * @version 1.0
 */
public class CreditoHipotecario extends Credito {
  private BienInmueble hipoteca;
  private double honorario;
  private double gastoFormalizacion;
  private static final double AVALUO = 0.0065;
  private static final double COSTO_FORMALIZACION = 0.0075;
  private SistemaFrances amortizacion;

  public CreditoHipotecario(Deudor pCliente, double pMontoSolicitado, int pPlazoEnMeses, TMoneda pMoneda,
      double pTasaInteres, double pTasaBasicaPasiva,
      double pComision, TCostosLegales pTipoCostosLegales,
      CuotaMensual pCuotaMensual, BienInmueble pBienInmbueble) {
    super(pCliente, pMontoSolicitado, pPlazoEnMeses, pMoneda, pTasaInteres,
        pTasaBasicaPasiva, pComision, pTipoCostosLegales, pCuotaMensual);
    hipoteca = pBienInmbueble;
    aplicarHonorario();
    setGastoFormalizacion();
    amortizacion = new SistemaFrances(pMontoSolicitado, pPlazoEnMeses, pTasaInteres);
    // super.setAmortizacion()
  }

  public BienInmueble getHipoteca() {
    return hipoteca;
  }

  public void setHipoteca(BienInmueble hipoteca) {
    this.hipoteca = hipoteca;
  }

  public SistemaFrances getAmortizacion() {
    return amortizacion;
  }

  public double getHonorario() {
    return honorario;
  }

  public void setHonorario(double honorario) {
    this.honorario = honorario;
  }

  public double getGastoFormalizacion() {
    return gastoFormalizacion;
  }

  public String getNumSolicitud() {
    return super.getNumSolicitud();
  }

  public void setGastoFormalizacion() {
    this.gastoFormalizacion = super.getMontoSolicitado() * COSTO_FORMALIZACION;
  }

  /**
   * Valida si un prestamo es valido para su posterior aprobacion oficial
   * 
   * @return valor booleano que indica si es viable o no aprobar el credito
   */
  public boolean preAprobacion() {
    return true; // sin implementar
  }

  /**
   * Calcula el monto por concepto de honorarios del credito
   * 
   * El cobro procede de manera que, de los prestamos de hasta 11 mill constan de
   * 2% del prestamo
   * de prestamos entre 11 mill y 16.5 mill constan del 1.5%
   * de prestamos entre 16.5 mill y 33 mill constan del 1.25%
   * de prestamos de mas de 33 mill constan del 1%
   */
  public void aplicarHonorario() {
    double monto = super.getMontoSolicitado();
    if (monto <= 11000000) {
      this.honorario = monto * 0.02;
    }
    if (monto <= 16500000) {
      this.honorario = monto * 0.015;
    }
    if (monto <= 33000000) {
      this.honorario = monto * 0.0125;
    } else {
      this.honorario = monto * 0.01;
    }
  }

  public double calcularMontoFinalASolicitar() {
    double result = 0;
    result += super.getMontoSolicitado() * 0.065;
    result += super.getMontoSolicitado() * 0.75;
    result += super.getMontoSolicitado();
    super.setMontoFinal(result);
    return result;
  }
  public String toString() {
    String result = "Credito Hipotecario\n";
    result += super.toString();
    result += "Hipoteca: " + hipoteca.toString() + "\n";
    result += "Honorario: " + honorario + "\n";
    result += "Gasto de formalizacion: " + gastoFormalizacion + "\n";
    result += "Amortizacion: \n" + amortizacion.toString() + "\n";
    return result;
  }
}
