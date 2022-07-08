
package co.gov.invima.dto;

import java.lang.reflect.Field;
import java.util.Date;
/**
 * Clase que mapea los datos del formulario de RISARH a las 2 tablas donde se 
 * guarda el reporte
 * @author GRUPO ASD
 */
public class ReporteRisarhVO {
    private String risarh = "";
    private String tipoAlerta="";
    private String regSan="";
    private String nombreDM ="";
    private String marca="";
    private String modelo = "";
    private String descripcionAlerta="";
    private String descripcionCausas ="";
    private String descripcionMedidas ="";
    private String lote="";
    private String serial="";
    private String riesgo="";
    private String codMun="";
    private String descripcion="";
    private String codDepart="";
    private int tipoNotificante;
    private int fuente;
    private String razonSocialN="";
    private long nit=0;
    private String direccion="";
    private String pais="";
    private String telefono="";
    private int profesion=0;
    private String email="";
    private int estadoDM;
    private String reporteEve="";
    private int cuantosEventos;
    private String descripcionEvento="";
    private String codDepart1="";
    private String codMun1="";
    private Date fechaHurto;
    private String fiscalia="";
    private String autorizacion="";
    private String descripcionHurto="";
    private String nombreNotificante="";
    private String agencia="";
    private Date fecha;
    private String otroEstado;
    private int funcionarioMonitoreo;
    
    Date FechaIngreso;
    String Estado ="";
    Long ExpedienteDm ;
    Date FechaRadicado;
    int MedidasInvima;
    Long Radicado;
    String Seguimiento =("");
    String Tipodisposivito = ("");
    String ValorPrioriza = ("");
    String PaginaWeb = ("");
    String Aplica = ("");
    String Internet = ("");
    int frecuencia;
    int gravedad;
    int areas;
    int cdgpriorizacion;

    public int getFuncionarioMonitoreo() {
        return funcionarioMonitoreo;
    }

    public void setFuncionarioMonitoreo(int funcionarioMonitoreo) {
        this.funcionarioMonitoreo = funcionarioMonitoreo;
    }

    public int getCdgpriorizacion() {
        return cdgpriorizacion;
    }

    public void setCdgpriorizacion(int cdgpriorizacion) {
        this.cdgpriorizacion = cdgpriorizacion;
    }

    public int getAreas() {
        return areas;
    }

    public void setAreas(int areas) {
        this.areas = areas;
    }

    
    public int getGravedad() {
        return gravedad;
    }

    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }

    
    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }
    
    

    public Date getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(Date FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public Long getExpedienteDm() {
        return ExpedienteDm;
    }

    public void setExpedienteDm(Long ExpedienteDm) {
        this.ExpedienteDm = ExpedienteDm;
    }

    public Date getFechaRadicado() {
        return FechaRadicado;
    }

    public void setFechaRadicado(Date FechaRadicado) {
        this.FechaRadicado = FechaRadicado;
    }

    public int getMedidasInvima() {
        return MedidasInvima;
    }

    public void setMedidasInvima(int MedidasInvima) {
        this.MedidasInvima = MedidasInvima;
    }

    public Long getRadicado() {
        return Radicado;
    }

    public void setRadicado(Long Radicado) {
        this.Radicado = Radicado;
    }

    public String getSeguimiento() {
        return Seguimiento;
    }

    public void setSeguimiento(String Seguimiento) {
        this.Seguimiento = Seguimiento;
    }

    public String getTipodisposivito() {
        return Tipodisposivito;
    }

    public void setTipodisposivito(String Tipodisposivito) {
        this.Tipodisposivito = Tipodisposivito;
    }

    public String getValorPrioriza() {
        return ValorPrioriza;
    }

    public void setValorPrioriza(String ValorPrioriza) {
        this.ValorPrioriza = ValorPrioriza;
    }

    public String getPaginaWeb() {
        return PaginaWeb;
    }

    public void setPaginaWeb(String PaginaWeb) {
        this.PaginaWeb = PaginaWeb;
    }

    public String getAplica() {
        return Aplica;
    }

    public void setAplica(String Aplica) {
        this.Aplica = Aplica;
    }

    public String getInternet() {
        return Internet;
    }

    public void setInternet(String Internet) {
        this.Internet = Internet;
    }
    
    

    public ReporteRisarhVO() {
    }

    public String getRisarh() {
        return risarh;
    }

    public void setRisarh(String risarh) {
        this.risarh = risarh;
    }

    public String getOtroEstado() {
        return otroEstado;
    }

    public void setOtroEstado(String otroEstado) {
        this.otroEstado = otroEstado;
    }

    
    
    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public String getCodDepart() {
        return codDepart;
    }

    public void setCodDepart(String codDepart) {
        this.codDepart = codDepart;
    }

    public String getCodDepart1() {
        return codDepart1;
    }

    public void setCodDepart1(String codDepart1) {
        this.codDepart1 = codDepart1;
    }

    public String getCodMun() {
        return codMun;
    }

    public void setCodMun(String codMun) {
        this.codMun = codMun;
    }

    public String getCodMun1() {
        return codMun1;
    }

    public void setCodMun1(String codMun1) {
        this.codMun1 = codMun1;
    }

    public int getCuantosEventos() {
        return cuantosEventos;
    }

    public void setCuantosEventos(int cuantosEventos) {
        this.cuantosEventos = cuantosEventos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcionAlerta() {
        return descripcionAlerta;
    }

    public void setDescripcionAlerta(String descripcionAlerta) {
        this.descripcionAlerta = descripcionAlerta;
    }

    public String getDescripcionCausas() {
        return descripcionCausas;
    }

    public void setDescripcionCausas(String descripcionCausas) {
        this.descripcionCausas = descripcionCausas;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public String getDescripcionHurto() {
        return descripcionHurto;
    }

    public void setDescripcionHurto(String descripcionHurto) {
        this.descripcionHurto = descripcionHurto;
    }

    public String getDescripcionMedidas() {
        return descripcionMedidas;
    }

    public void setDescripcionMedidas(String descripcionMedidas) {
        this.descripcionMedidas = descripcionMedidas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEstadoDM() {
        return estadoDM;
    }

    public void setEstadoDM(int estadoDM) {
        this.estadoDM = estadoDM;
    }

    public Date getFechaHurto() {
        return fechaHurto;
    }

    public void setFechaHurto(Date fechaHurto) {
        this.fechaHurto = fechaHurto;
    }

    public String getFiscalia() {
        return fiscalia;
    }

    public void setFiscalia(String fiscalia) {
        this.fiscalia = fiscalia;
    }

    public int getFuente() {
        return fuente;
    }

    public void setFuente(int fuente) {
        this.fuente = fuente;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    public String getNombreDM() {
        return nombreDM;
    }

    public void setNombreDM(String nombreDM) {
        this.nombreDM = nombreDM;
    }

    public String getNombreNotificante() {
        return nombreNotificante;
    }

    public void setNombreNotificante(String nombreNotificante) {
        this.nombreNotificante = nombreNotificante;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getProfesion() {
        return profesion;
    }

    public void setProfesion(int profesion) {
        this.profesion = profesion;
    }

    public String getRazonSocialN() {
        return razonSocialN;
    }

    public void setRazonSocialN(String razonSocialN) {
        this.razonSocialN = razonSocialN;
    }

    public String getRegSan() {
        return regSan;
    }

    public void setRegSan(String regSan) {
        this.regSan = regSan;
    }

    public String getReporteEve() {
        return reporteEve;
    }

    public void setReporteEve(String reporteEve) {
        this.reporteEve = reporteEve;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public int getTipoNotificante() {
        return tipoNotificante;
    }

    public void setTipoNotificante(int tipoNotificante) {
        this.tipoNotificante = tipoNotificante;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    
        @Override
    public String toString() {
  StringBuilder result = new StringBuilder();
  String newLine = System.getProperty("line.separator");
  String valor = "";
  result.append( this.getClass().getName() );
  result.append( " Object {" );
  result.append(newLine);

  //determine fields declared in this class only (no fields of superclass)
  Field[] fields = this.getClass().getDeclaredFields();

  //print field names paired with their values
  for ( Field field : fields  ) {
    result.append("  ");
    try {
        valor = String.valueOf(field.get(this));
      result.append( field.getName() );
      result.append(": ");
      result.append( field.get(this) );
      result.append(" - Longitud del campo: ");
      result.append(valor.length());
      //requires access to private field:
    } catch ( IllegalAccessException ex ) {
      ex.printStackTrace();
    }
    result.append(newLine);
  }
  result.append("}");

  return result.toString();
}

    
    
    
}
