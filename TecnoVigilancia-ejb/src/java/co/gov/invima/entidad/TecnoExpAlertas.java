/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.entidad;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tecno_exp_alertas")
@NamedQueries({
    @NamedQuery(name = "TecnoExpAlertas.findAll", query = "SELECT t FROM TecnoExpAlertas t"), 
    @NamedQuery(name = "TecnoExpAlertas.findByExpedienteDm", query = "SELECT t FROM TecnoExpAlertas t WHERE t.expedienteDm = :expedienteDm"), 
    @NamedQuery(name = "TecnoExpAlertas.findByCdgTipoalerta", query = "SELECT t FROM TecnoExpAlertas t WHERE t.cdgTipoalerta = :cdgTipoalerta"), @NamedQuery(name = "TecnoExpAlertas.findByRisarh", query = "SELECT t FROM TecnoExpAlertas t WHERE t.risarh = :risarh"), @NamedQuery(name = "TecnoExpAlertas.findByFechaRadicado", query = "SELECT t FROM TecnoExpAlertas t WHERE t.fechaRadicado = :fechaRadicado"), @NamedQuery(name = "TecnoExpAlertas.findByRadicado", query = "SELECT t FROM TecnoExpAlertas t WHERE t.radicado = :radicado"), @NamedQuery(name = "TecnoExpAlertas.findByNroregsan", query = "SELECT t FROM TecnoExpAlertas t WHERE t.nroregsan = :nroregsan"), @NamedQuery(name = "TecnoExpAlertas.findByFechaIngreso", query = "SELECT t FROM TecnoExpAlertas t WHERE t.fechaIngreso = :fechaIngreso"), @NamedQuery(name = "TecnoExpAlertas.findByNombreDm", query = "SELECT t FROM TecnoExpAlertas t WHERE t.nombreDm = :nombreDm"), @NamedQuery(name = "TecnoExpAlertas.findByMarca", query = "SELECT t FROM TecnoExpAlertas t WHERE t.marca = :marca"), @NamedQuery(name = "TecnoExpAlertas.findByModelo", query = "SELECT t FROM TecnoExpAlertas t WHERE t.modelo = :modelo"), @NamedQuery(name = "TecnoExpAlertas.findByCdgGravedad", query = "SELECT t FROM TecnoExpAlertas t WHERE t.cdgGravedad = :cdgGravedad"), @NamedQuery(name = "TecnoExpAlertas.findByCdgRiesgo", query = "SELECT t FROM TecnoExpAlertas t WHERE t.cdgRiesgo = :cdgRiesgo"), @NamedQuery(name = "TecnoExpAlertas.findByCdgFrecuencia", query = "SELECT t FROM TecnoExpAlertas t WHERE t.cdgFrecuencia = :cdgFrecuencia"), @NamedQuery(name = "TecnoExpAlertas.findByCdgAreas", query = "SELECT t FROM TecnoExpAlertas t WHERE t.cdgAreas = :cdgAreas"), @NamedQuery(name = "TecnoExpAlertas.findByCdgPriorizacion", query = "SELECT t FROM TecnoExpAlertas t WHERE t.cdgPriorizacion = :cdgPriorizacion"), @NamedQuery(name = "TecnoExpAlertas.findByEstado", query = "SELECT t FROM TecnoExpAlertas t WHERE t.estado = :estado"), @NamedQuery(name = "TecnoExpAlertas.findByCausas", query = "SELECT t FROM TecnoExpAlertas t WHERE t.causas = :causas"), @NamedQuery(name = "TecnoExpAlertas.findByMedidasTomadas", query = "SELECT t FROM TecnoExpAlertas t WHERE t.medidasTomadas = :medidasTomadas"), @NamedQuery(name = "TecnoExpAlertas.findByLote", query = "SELECT t FROM TecnoExpAlertas t WHERE t.lote = :lote"), @NamedQuery(name = "TecnoExpAlertas.findByTipodisposivito", query = "SELECT t FROM TecnoExpAlertas t WHERE t.tipodisposivito = :tipodisposivito"), @NamedQuery(name = "TecnoExpAlertas.findBySerial", query = "SELECT t FROM TecnoExpAlertas t WHERE t.serial = :serial"), @NamedQuery(name = "TecnoExpAlertas.findByUsoDm", query = "SELECT t FROM TecnoExpAlertas t WHERE t.usoDm = :usoDm"), @NamedQuery(name = "TecnoExpAlertas.findByCodMun", query = "SELECT t FROM TecnoExpAlertas t WHERE t.codMun = :codMun"), @NamedQuery(name = "TecnoExpAlertas.findByCodDepart", query = "SELECT t FROM TecnoExpAlertas t WHERE t.codDepart = :codDepart"), @NamedQuery(name = "TecnoExpAlertas.findByConsecutivoReporte", query = "SELECT t FROM TecnoExpAlertas t WHERE t.consecutivoReporte = :consecutivoReporte"), @NamedQuery(name = "TecnoExpAlertas.findByTipoNotificante", query = "SELECT t FROM TecnoExpAlertas t WHERE t.tipoNotificante = :tipoNotificante"), @NamedQuery(name = "TecnoExpAlertas.findByFuente", query = "SELECT t FROM TecnoExpAlertas t WHERE t.fuente = :fuente"), @NamedQuery(name = "TecnoExpAlertas.findByRazonSocialNotificante", query = "SELECT t FROM TecnoExpAlertas t WHERE t.razonSocialNotificante = :razonSocialNotificante"), @NamedQuery(name = "TecnoExpAlertas.findByNit", query = "SELECT t FROM TecnoExpAlertas t WHERE t.nit = :nit"), @NamedQuery(name = "TecnoExpAlertas.findByDireccion", query = "SELECT t FROM TecnoExpAlertas t WHERE t.direccion = :direccion"), @NamedQuery(name = "TecnoExpAlertas.findByPais", query = "SELECT t FROM TecnoExpAlertas t WHERE t.pais = :pais"), @NamedQuery(name = "TecnoExpAlertas.findByTelefono", query = "SELECT t FROM TecnoExpAlertas t WHERE t.telefono = :telefono"), @NamedQuery(name = "TecnoExpAlertas.findByCdgProfesion", query = "SELECT t FROM TecnoExpAlertas t WHERE t.cdgProfesion = :cdgProfesion"), @NamedQuery(name = "TecnoExpAlertas.findByEmail", query = "SELECT t FROM TecnoExpAlertas t WHERE t.email = :email"), @NamedQuery(name = "TecnoExpAlertas.findByEstadoDm", query = "SELECT t FROM TecnoExpAlertas t WHERE t.estadoDm = :estadoDm"), @NamedQuery(name = "TecnoExpAlertas.findByReporteEventos", query = "SELECT t FROM TecnoExpAlertas t WHERE t.reporteEventos = :reporteEventos"), @NamedQuery(name = "TecnoExpAlertas.findByCuantosEventos", query = "SELECT t FROM TecnoExpAlertas t WHERE t.cuantosEventos = :cuantosEventos"), @NamedQuery(name = "TecnoExpAlertas.findByCodDepart1", query = "SELECT t FROM TecnoExpAlertas t WHERE t.codDepart1 = :codDepart1"), @NamedQuery(name = "TecnoExpAlertas.findByCodMun1", query = "SELECT t FROM TecnoExpAlertas t WHERE t.codMun1 = :codMun1"), @NamedQuery(name = "TecnoExpAlertas.findByFechaHurto", query = "SELECT t FROM TecnoExpAlertas t WHERE t.fechaHurto = :fechaHurto"), @NamedQuery(name = "TecnoExpAlertas.findByFiscalia", query = "SELECT t FROM TecnoExpAlertas t WHERE t.fiscalia = :fiscalia"), @NamedQuery(name = "TecnoExpAlertas.findByAutorizacion", query = "SELECT t FROM TecnoExpAlertas t WHERE t.autorizacion = :autorizacion"), @NamedQuery(name = "TecnoExpAlertas.findByMedidasInvima", query = "SELECT t FROM TecnoExpAlertas t WHERE t.medidasInvima = :medidasInvima"), @NamedQuery(name = "TecnoExpAlertas.findByNombreNotificante", query = "SELECT t FROM TecnoExpAlertas t WHERE t.nombreNotificante = :nombreNotificante"), @NamedQuery(name = "TecnoExpAlertas.findByValorPrioriza", query = "SELECT t FROM TecnoExpAlertas t WHERE t.valorPrioriza = :valorPrioriza"), @NamedQuery(name = "TecnoExpAlertas.findByInternet", query = "SELECT t FROM TecnoExpAlertas t WHERE t.internet = :internet"), @NamedQuery(name = "TecnoExpAlertas.findByNombreAgencia", query = "SELECT t FROM TecnoExpAlertas t WHERE t.nombreAgencia = :nombreAgencia"), @NamedQuery(name = "TecnoExpAlertas.findByOtroEstadodm", query = "SELECT t FROM TecnoExpAlertas t WHERE t.otroEstadodm = :otroEstadodm")})
public class TecnoExpAlertas implements Serializable {
    private static final long serialVersionUID = 1L;


    @Column(name = "expediente_dm")
    private Long expedienteDm;

    @Basic(optional = false)
    @Column(name = "cdg_tipoalerta")
    private char cdgTipoalerta;

    @Id
    @Basic(optional = false)
    @Column(name = "risarh")
    private String risarh;

    @Column(name = "fecha_radicado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRadicado;

    @Column(name = "radicado")
    private Long radicado;

    @Column(name = "nroregsan")
    private String nroregsan;

    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;

    @Column(name = "nombre_dm")
    private String nombreDm;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "cdg_gravedad")
    private Integer cdgGravedad;
    @Column(name = "cdg_riesgo")

    private String cdgRiesgo;
    @Column(name = "cdg_frecuencia")

    private Integer cdgFrecuencia;
    @Column(name = "cdg_areas")

    private Integer cdgAreas;
    @Column(name = "cdg_priorizacion")

    private Integer cdgPriorizacion;
    @Column(name = "estado")

    private Character estado;
    @Column(name = "causas")
    private String causas;

    @Column(name = "medidas_tomadas")
    private String medidasTomadas;

    @Column(name = "lote")
    private String lote;

    @Column(name = "tipodisposivito")
    private String tipodisposivito;

    @Column(name = "serial")
    private String serial;

    @Column(name = "uso_dm")
    private String usoDm;

    @Column(name = "cod_mun")
    private String codMun;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "seguimiento")
    private String seguimiento;
    
    @Column(name = "cod_depart")
    private String codDepart;

    @Column(name = "consecutivo_reporte")
    private String consecutivoReporte;

    @Column(name = "tipo_notificante")
    private Integer tipoNotificante;

    @Column(name = "fuente")
    private Integer fuente;

    @Column(name = "razon_social_notificante")
    private String razonSocialNotificante;

    @Column(name = "nit")
    private Long nit;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "pais")
    private String pais;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "cdg_profesion")
    private Integer cdgProfesion;

    @Column(name = "email")
    private String email;

    @Column(name = "estado_dm")
    private Integer estadoDm;

    @Column(name = "reporte_eventos")
    private String reporteEventos;

    @Column(name = "cuantos_eventos")
    private Integer cuantosEventos;
    
    @Column(name = "descripcion_evento")
    private String descripcionEvento;
    
    @Column(name = "cod_depart1")
    private String codDepart1;

    @Column(name = "cod_mun1")
    private String codMun1;

    @Column(name = "fecha_hurto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHurto;

    @Column(name = "fiscalia")
    private String fiscalia;

    @Column(name = "autorizacion")
    private String autorizacion;
    
    @Column(name = "descripcion_hurto")
    private String descripcionHurto;
    
    @Column(name = "medidas_invima")
    private Integer medidasInvima;

    @Column(name = "nombre_notificante")
    private String nombreNotificante;

    @Column(name = "valor_prioriza")
    private String valorPrioriza;

    @Column(name = "internet")
    private Character internet;

    @Column(name = "nombre_agencia")
    private String nombreAgencia;

    @Column(name = "otro_estadodm")
    private String otroEstadodm;

    public TecnoExpAlertas() {
    }

    public TecnoExpAlertas(String risarh) {
        this.risarh = risarh;
    }

    public TecnoExpAlertas(String risarh, char cdgTipoalerta) {
        this.risarh = risarh;
        this.cdgTipoalerta = cdgTipoalerta;
    }

    public Long getExpedienteDm() {
        return expedienteDm;
    }

    public void setExpedienteDm(Long expedienteDm) {
        this.expedienteDm = expedienteDm;
    }

    public char getCdgTipoalerta() {
        return cdgTipoalerta;
    }

    public void setCdgTipoalerta(char cdgTipoalerta) {
        this.cdgTipoalerta = cdgTipoalerta;
    }

    public String getRisarh() {
        return risarh;
    }

    public void setRisarh(String risarh) {
        this.risarh = risarh;
    }

    public Date getFechaRadicado() {
        return fechaRadicado;
    }

    public void setFechaRadicado(Date fechaRadicado) {
        this.fechaRadicado = fechaRadicado;
    }

    public Long getRadicado() {
        return radicado;
    }

    public void setRadicado(Long radicado) {
        this.radicado = radicado;
    }

    public String getNroregsan() {
        return nroregsan;
    }

    public void setNroregsan(String nroregsan) {
        this.nroregsan = nroregsan;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getNombreDm() {
        return nombreDm;
    }

    public void setNombreDm(String nombreDm) {
        this.nombreDm = nombreDm;
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

    public Integer getCdgGravedad() {
        return cdgGravedad;
    }

    public void setCdgGravedad(Integer cdgGravedad) {
        this.cdgGravedad = cdgGravedad;
    }

    public String getCdgRiesgo() {
        return cdgRiesgo;
    }

    public void setCdgRiesgo(String cdgRiesgo) {
        this.cdgRiesgo = cdgRiesgo;
    }

    public Integer getCdgFrecuencia() {
        return cdgFrecuencia;
    }

    public void setCdgFrecuencia(Integer cdgFrecuencia) {
        this.cdgFrecuencia = cdgFrecuencia;
    }

    public Integer getCdgAreas() {
        return cdgAreas;
    }

    public void setCdgAreas(Integer cdgAreas) {
        this.cdgAreas = cdgAreas;
    }

    public Integer getCdgPriorizacion() {
        return cdgPriorizacion;
    }

    public void setCdgPriorizacion(Integer cdgPriorizacion) {
        this.cdgPriorizacion = cdgPriorizacion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getCausas() {
        return causas;
    }

    public void setCausas(String causas) {
        this.causas = causas;
    }

    public String getMedidasTomadas() {
        return medidasTomadas;
    }

    public void setMedidasTomadas(String medidasTomadas) {
        this.medidasTomadas = medidasTomadas;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getTipodisposivito() {
        return tipodisposivito;
    }

    public void setTipodisposivito(String tipodisposivito) {
        this.tipodisposivito = tipodisposivito;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getUsoDm() {
        return usoDm;
    }

    public void setUsoDm(String usoDm) {
        this.usoDm = usoDm;
    }

    public String getCodMun() {
        return codMun;
    }

    public void setCodMun(String codMun) {
        this.codMun = codMun;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(String seguimiento) {
        this.seguimiento = seguimiento;
    }

    public String getCodDepart() {
        return codDepart;
    }

    public void setCodDepart(String codDepart) {
        this.codDepart = codDepart;
    }

    public String getConsecutivoReporte() {
        return consecutivoReporte;
    }

    public void setConsecutivoReporte(String consecutivoReporte) {
        this.consecutivoReporte = consecutivoReporte;
    }

    public Integer getTipoNotificante() {
        return tipoNotificante;
    }

    public void setTipoNotificante(Integer tipoNotificante) {
        this.tipoNotificante = tipoNotificante;
    }

    public Integer getFuente() {
        return fuente;
    }

    public void setFuente(Integer fuente) {
        this.fuente = fuente;
    }

    public String getRazonSocialNotificante() {
        return razonSocialNotificante;
    }

    public void setRazonSocialNotificante(String razonSocialNotificante) {
        this.razonSocialNotificante = razonSocialNotificante;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getCdgProfesion() {
        return cdgProfesion;
    }

    public void setCdgProfesion(Integer cdgProfesion) {
        this.cdgProfesion = cdgProfesion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEstadoDm() {
        return estadoDm;
    }

    public void setEstadoDm(Integer estadoDm) {
        this.estadoDm = estadoDm;
    }

    public String getReporteEventos() {
        return reporteEventos;
    }

    public void setReporteEventos(String reporteEventos) {
        this.reporteEventos = reporteEventos;
    }

    public Integer getCuantosEventos() {
        return cuantosEventos;
    }

    public void setCuantosEventos(Integer cuantosEventos) {
        this.cuantosEventos = cuantosEventos;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public String getCodDepart1() {
        return codDepart1;
    }

    public void setCodDepart1(String codDepart1) {
        this.codDepart1 = codDepart1;
    }

    public String getCodMun1() {
        return codMun1;
    }

    public void setCodMun1(String codMun1) {
        this.codMun1 = codMun1;
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

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public String getDescripcionHurto() {
        return descripcionHurto;
    }

    public void setDescripcionHurto(String descripcionHurto) {
        this.descripcionHurto = descripcionHurto;
    }

    public Integer getMedidasInvima() {
        return medidasInvima;
    }

    public void setMedidasInvima(Integer medidasInvima) {
        this.medidasInvima = medidasInvima;
    }

    public String getNombreNotificante() {
        return nombreNotificante;
    }

    public void setNombreNotificante(String nombreNotificante) {
        this.nombreNotificante = nombreNotificante;
    }

    public String getValorPrioriza() {
        return valorPrioriza;
    }

    public void setValorPrioriza(String valorPrioriza) {
        this.valorPrioriza = valorPrioriza;
    }

    public Character getInternet() {
        return internet;
    }

    public void setInternet(Character internet) {
        this.internet = internet;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getOtroEstadodm() {
        return otroEstadodm;
    }

    public void setOtroEstadodm(String otroEstadodm) {
        this.otroEstadodm = otroEstadodm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (risarh != null ? risarh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoExpAlertas)) {
            return false;
        }
        TecnoExpAlertas other = (TecnoExpAlertas) object;
        if ((this.risarh == null && other.risarh != null) || (this.risarh != null && !this.risarh.equals(other.risarh))) {
            return false;
        }
        return true;
    }

    /*
    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoExpAlertas[risarh=" + risarh + "]";
    }
*/
    /*
            @Override
    public String toString2() {
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
}*/

    @Override
    public String toString() {
        return "TecnoExpAlertas{" + "expedienteDm=" + expedienteDm + ", cdgTipoalerta=" + cdgTipoalerta + ", risarh=" + risarh + ", fechaRadicado=" + fechaRadicado + ", radicado=" + radicado + ", nroregsan=" + nroregsan + ", fechaIngreso=" + fechaIngreso + ", nombreDm=" + nombreDm + ", marca=" + marca + ", modelo=" + modelo + ", cdgGravedad=" + cdgGravedad + ", cdgRiesgo=" + cdgRiesgo + ", cdgFrecuencia=" + cdgFrecuencia + ", cdgAreas=" + cdgAreas + ", cdgPriorizacion=" + cdgPriorizacion + ", estado=" + estado + ", causas=" + causas + ", medidasTomadas=" + medidasTomadas + ", lote=" + lote + ", tipodisposivito=" + tipodisposivito + ", serial=" + serial + ", usoDm=" + usoDm + ", codMun=" + codMun + ", descripcion=" + descripcion + ", seguimiento=" + seguimiento + ", codDepart=" + codDepart + ", consecutivoReporte=" + consecutivoReporte + ", tipoNotificante=" + tipoNotificante + ", fuente=" + fuente + ", razonSocialNotificante=" + razonSocialNotificante + ", nit=" + nit + ", direccion=" + direccion + ", pais=" + pais + ", telefono=" + telefono + ", cdgProfesion=" + cdgProfesion + ", email=" + email + ", estadoDm=" + estadoDm + ", reporteEventos=" + reporteEventos + ", cuantosEventos=" + cuantosEventos + ", descripcionEvento=" + descripcionEvento + ", codDepart1=" + codDepart1 + ", codMun1=" + codMun1 + ", fechaHurto=" + fechaHurto + ", fiscalia=" + fiscalia + ", autorizacion=" + autorizacion + ", descripcionHurto=" + descripcionHurto + ", medidasInvima=" + medidasInvima + ", nombreNotificante=" + nombreNotificante + ", valorPrioriza=" + valorPrioriza + ", internet=" + internet + ", nombreAgencia=" + nombreAgencia + ", otroEstadodm=" + otroEstadodm + '}';
    }
    
    
    


}
