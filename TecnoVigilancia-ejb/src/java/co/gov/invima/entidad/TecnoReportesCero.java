/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jgutierrezme
 */
@Entity
@Table(name = "tecno_reportes_cero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TecnoReportesCero.findAll", query = "SELECT t FROM TecnoReportesCero t")
    , @NamedQuery(name = "TecnoReportesCero.findByUsuarioId", query = "SELECT t FROM TecnoReportesCero t WHERE t.usuarioId = :usuarioId")
    , @NamedQuery(name = "TecnoReportesCero.findByObservacion", query = "SELECT t FROM TecnoReportesCero t WHERE t.observacion = :observacion")
    , @NamedQuery(name = "TecnoReportesCero.findByFechaReporte", query = "SELECT t FROM TecnoReportesCero t WHERE t.fechaReporte = :fechaReporte")
    , @NamedQuery(name = "TecnoReportesCero.findByTrimestre", query = "SELECT t FROM TecnoReportesCero t WHERE t.trimestre = :trimestre")
    , @NamedQuery(name = "TecnoReportesCero.findByYearTrimestre", query = "SELECT t FROM TecnoReportesCero t WHERE t.yearTrimestre = :yearTrimestre")
    , @NamedQuery(name = "TecnoReportesCero.findByFechaActualiza", query = "SELECT t FROM TecnoReportesCero t WHERE t.fechaActualiza = :fechaActualiza")
    , @NamedQuery(name = "TecnoReportesCero.findByIdregistro", query = "SELECT t FROM TecnoReportesCero t WHERE t.idregistro = :idregistro")
    , @NamedQuery(name = "TecnoReportesCero.findByRadicadocero", query = "SELECT t FROM TecnoReportesCero t WHERE t.radicadocero = :radicadocero")
    , @NamedQuery(name = "TecnoReportesCero.findByNotificacion", query = "SELECT t FROM TecnoReportesCero t WHERE t.notificacion = :notificacion")})
public class TecnoReportesCero implements Serializable {

    private static final long serialVersionUID = 1L;
    //****************************************************************
    //****************************************************************
    //****************************************************************
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="idregistro", nullable = false, insertable=false)
    private Integer idregistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String radicadocero;
    //****************************************************************
    //****************************************************************
    //****************************************************************
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usuario_id", nullable = false, length = 30)
    private String usuarioId;
    @Size(max = 4000)
    @Column(length = 4000)
    private String observacion;
    @Column(name = "fecha_reporte")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReporte;
    @Size(max = 2)
    @Column(length = 2)
    private String trimestre;
    @Column(name = "year_trimestre")
    private Short yearTrimestre;
    @Column(name = "fecha_actualiza")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualiza;
    //****************************************************************
    //****************************************************************
    @Size(max = 20)
    @Column(length = 20)
    private String notificacion;
    //****************************************************************
    //****************************************************************
    @Size(max = 2)
    @Column(length = 2)
    private String depto;
    //****************************************************************
    //****************************************************************
    @Size(max = 5)
    @Column(length = 5)
    private String municipio;
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    public TecnoReportesCero() {
    }

    public TecnoReportesCero(Integer idregistro) {
        this.idregistro = idregistro;
    }

    public TecnoReportesCero(Integer idregistro, String usuarioId, String radicadocero) {
        this.idregistro = idregistro;
        this.usuarioId = usuarioId;
        this.radicadocero = radicadocero;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(Date fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }

    public Short getYearTrimestre() {
        return yearTrimestre;
    }

    public void setYearTrimestre(Short yearTrimestre) {
        this.yearTrimestre = yearTrimestre;
    }

    public Date getFechaActualiza() {
        return fechaActualiza;
    }

    public void setFechaActualiza(Date fechaActualiza) {
        this.fechaActualiza = fechaActualiza;
    }

    public Integer getIdregistro() {
        return idregistro;
    }

    public void setIdregistro(Integer idregistro) {
        this.idregistro = idregistro;
    }

    public String getRadicadocero() {
        return radicadocero;
    }

    public void setRadicadocero(String radicadocero) {
        this.radicadocero = radicadocero;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }
    
    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoReportesCero[ idregistro=" + idregistro + " ]";
    }

    /**
     * @return the depto
     */
    public String getDepto() {
        return depto;
    }

    /**
     * @param depto the depto to set
     */
    public void setDepto(String depto) {
        this.depto = depto;
    }

    /**
     * @return the municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregistro != null ? idregistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoReportesCero)) {
            return false;
        }
        TecnoReportesCero other = (TecnoReportesCero) object;
        if ((this.idregistro == null && other.idregistro != null) || (this.idregistro != null && !this.idregistro.equals(other.idregistro))) {
            return false;
        }
        return true;
    }

    
}
