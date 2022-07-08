/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Diana Silva
 */
@Entity
@Table(name = "tecno_evaluacion_caso")
@NamedQueries({
    @NamedQuery(name = "TecnoEvaluacionCaso.findAll", query = "SELECT t FROM TecnoEvaluacionCaso t"), 
    @NamedQuery(name = "TecnoEvaluacionCaso.findByReporte", query = "SELECT t FROM TecnoEvaluacionCaso t WHERE t.reporte = :reporte"), @NamedQuery(name = "TecnoEvaluacionCaso.findByCdgCausa", query = "SELECT t FROM TecnoEvaluacionCaso t WHERE t.cdgCausa = :cdgCausa"), @NamedQuery(name = "TecnoEvaluacionCaso.findByNumero", query = "SELECT t FROM TecnoEvaluacionCaso t WHERE t.numero = :numero"), @NamedQuery(name = "TecnoEvaluacionCaso.findByExpAlertas", query = "SELECT t FROM TecnoEvaluacionCaso t WHERE t.expAlertas = :expAlertas"), @NamedQuery(name = "TecnoEvaluacionCaso.findByCdgTipoalerta", query = "SELECT t FROM TecnoEvaluacionCaso t WHERE t.cdgTipoalerta = :cdgTipoalerta"), @NamedQuery(name = "TecnoEvaluacionCaso.findByEstadoCaso", query = "SELECT t FROM TecnoEvaluacionCaso t WHERE t.estadoCaso = :estadoCaso"), @NamedQuery(name = "TecnoEvaluacionCaso.findByCdgfuncionario", query = "SELECT t FROM TecnoEvaluacionCaso t WHERE t.cdgfuncionario = :cdgfuncionario"), @NamedQuery(name = "TecnoEvaluacionCaso.findByMedidaEjecutada", query = "SELECT t FROM TecnoEvaluacionCaso t WHERE t.medidaEjecutada = :medidaEjecutada"), @NamedQuery(name = "TecnoEvaluacionCaso.findByNotificacion", query = "SELECT t FROM TecnoEvaluacionCaso t WHERE t.notificacion = :notificacion"), @NamedQuery(name = "TecnoEvaluacionCaso.findByFechaNotificacion", query = "SELECT t FROM TecnoEvaluacionCaso t WHERE t.fechaNotificacion = :fechaNotificacion"), @NamedQuery(name = "TecnoEvaluacionCaso.findByFechaImportador", query = "SELECT t FROM TecnoEvaluacionCaso t WHERE t.fechaImportador = :fechaImportador"), @NamedQuery(name = "TecnoEvaluacionCaso.findByDispositivoEvaluacion", query = "SELECT t FROM TecnoEvaluacionCaso t WHERE t.dispositivoEvaluacion = :dispositivoEvaluacion"), @NamedQuery(name = "TecnoEvaluacionCaso.findByEnviadoImportador", query = "SELECT t FROM TecnoEvaluacionCaso t WHERE t.enviadoImportador = :enviadoImportador")})
public class TecnoEvaluacionCaso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "reporte")
    private String reporte;
    @Column(name = "cdg_causa")
    private Integer cdgCausa;
    @Column(name = "numero")
    private Integer numero;
    
    @Column(name = "acciones")
    private String acciones;
    @Column(name = "exp_alertas")
    private Integer expAlertas;
    
    @Column(name = "descripcion_alerta")
    private String descripcionAlerta;
    @Column(name = "cdg_tipoalerta")
    private Integer cdgTipoalerta;
    @Column(name = "estado_caso")
    private String estadoCaso;
    
    
    @Column(name = "seguimiento")
    private String seguimiento;
    
    @Column(name = "cdgfuncionario")
    private BigInteger cdgfuncionario;
    
    
    @Column(name = "medida_ejecutada")
    private Character medidaEjecutada;
    @Column(name = "notificacion")
    private String notificacion;
    @Column(name = "fecha_notificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNotificacion;
    @Column(name = "fecha_importador")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaImportador;
    @Column(name = "dispositivo_evaluacion")
    private String dispositivoEvaluacion;
    @Column(name = "enviado_importador")
    private String enviadoImportador;

    public TecnoEvaluacionCaso() {
    }

    public TecnoEvaluacionCaso(String reporte) {
        this.reporte = reporte;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public Integer getCdgCausa() {
        return cdgCausa;
    }

    public void setCdgCausa(Integer cdgCausa) {
        this.cdgCausa = cdgCausa;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getAcciones() {
        return acciones;
    }

    public void setAcciones(String acciones) {
        this.acciones = acciones;
    }

    public Integer getExpAlertas() {
        return expAlertas;
    }

    public void setExpAlertas(Integer expAlertas) {
        this.expAlertas = expAlertas;
    }

    public String getDescripcionAlerta() {
        return descripcionAlerta;
    }

    public void setDescripcionAlerta(String descripcionAlerta) {
        this.descripcionAlerta = descripcionAlerta;
    }

    public Integer getCdgTipoalerta() {
        return cdgTipoalerta;
    }

    public void setCdgTipoalerta(Integer cdgTipoalerta) {
        this.cdgTipoalerta = cdgTipoalerta;
    }

    public String getEstadoCaso() {
        return estadoCaso;
    }

    public void setEstadoCaso(String estadoCaso) {
        this.estadoCaso = estadoCaso;
    }

    public String getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(String seguimiento) {
        this.seguimiento = seguimiento;
    }

    public BigInteger getCdgfuncionario() {
        return cdgfuncionario;
    }

    public void setCdgfuncionario(BigInteger cdgfuncionario) {
        this.cdgfuncionario = cdgfuncionario;
    }
    
    

    public Character getMedidaEjecutada() {
        return medidaEjecutada;
    }

    public void setMedidaEjecutada(Character medidaEjecutada) {
        this.medidaEjecutada = medidaEjecutada;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }

    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public Date getFechaImportador() {
        return fechaImportador;
    }

    public void setFechaImportador(Date fechaImportador) {
        this.fechaImportador = fechaImportador;
    }

    public String getDispositivoEvaluacion() {
        return dispositivoEvaluacion;
    }

    public void setDispositivoEvaluacion(String dispositivoEvaluacion) {
        this.dispositivoEvaluacion = dispositivoEvaluacion;
    }

    public String getEnviadoImportador() {
        return enviadoImportador;
    }

    public void setEnviadoImportador(String enviadoImportador) {
        this.enviadoImportador = enviadoImportador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reporte != null ? reporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoEvaluacionCaso)) {
            return false;
        }
        TecnoEvaluacionCaso other = (TecnoEvaluacionCaso) object;
        if ((this.reporte == null && other.reporte != null) || (this.reporte != null && !this.reporte.equals(other.reporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoEvaluacionCaso[reporte=" + reporte + "]";
    }

    
    /*
    public BigDecimal getCdgfuncionario() {
        return cdgfuncionario;
    }

    public void setCdgfuncionario(BigDecimal cdgfuncionario) {
        this.cdgfuncionario = cdgfuncionario;
    }
    */

}
