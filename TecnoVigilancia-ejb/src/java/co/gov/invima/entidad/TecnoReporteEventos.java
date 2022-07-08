/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.entidad;

import java.io.Serializable;
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
 * @author Diana Silva
 */
@Entity
@Table(name = "tecno_reporte_eventos")
@NamedQueries({
    @NamedQuery(name = "TecnoReporteEventos.findAll", query = "SELECT t FROM TecnoReporteEventos t"), 
    @NamedQuery(name = "TecnoReporteEventos.findByReporte", query = "SELECT t FROM TecnoReporteEventos t WHERE t.reporte = :reporte"), 
    @NamedQuery(name = "TecnoReporteEventos.findByFechevento", query = "SELECT t FROM TecnoReporteEventos t WHERE t.fechevento = :fechevento"), 
    @NamedQuery(name = "TecnoReporteEventos.findByCdgEventodeteccion", query = "SELECT t FROM TecnoReporteEventos t WHERE t.cdgEventodeteccion = :cdgEventodeteccion"), 
    @NamedQuery(name = "TecnoReporteEventos.findByCdgTiporeporte", query = "SELECT t FROM TecnoReporteEventos t WHERE t.cdgTiporeporte = :cdgTiporeporte"), 
    @NamedQuery(name = "TecnoReporteEventos.findByCdgDesenlace", query = "SELECT t FROM TecnoReporteEventos t WHERE t.cdgDesenlace = :cdgDesenlace"), 
    @NamedQuery(name = "TecnoReporteEventos.findByFechreporteEvento", query = "SELECT t FROM TecnoReporteEventos t WHERE t.fechreporteEvento = :fechreporteEvento"), 
    @NamedQuery(name = "TecnoReporteEventos.findByCdgOrigenreporte", query = "SELECT t FROM TecnoReporteEventos t WHERE t.cdgOrigenreporte = :cdgOrigenreporte"), @NamedQuery(name = "TecnoReporteEventos.findByCdgTipoeventoincidente", query = "SELECT t FROM TecnoReporteEventos t WHERE t.cdgTipoeventoincidente = :cdgTipoeventoincidente"), @NamedQuery(name = "TecnoReporteEventos.findByCdgSeriedad", query = "SELECT t FROM TecnoReporteEventos t WHERE t.cdgSeriedad = :cdgSeriedad"), @NamedQuery(name = "TecnoReporteEventos.findByDesenlaceOtro", query = "SELECT t FROM TecnoReporteEventos t WHERE t.desenlaceOtro = :desenlaceOtro"), @NamedQuery(name = "TecnoReporteEventos.findByInternet", query = "SELECT t FROM TecnoReporteEventos t WHERE t.internet = :internet"), @NamedQuery(name = "TecnoReporteEventos.findByFechaingreso", query = "SELECT t FROM TecnoReporteEventos t WHERE t.fechaingreso = :fechaingreso"), @NamedQuery(name = "TecnoReporteEventos.findByReportado", query = "SELECT t FROM TecnoReporteEventos t WHERE t.reportado = :reportado")})
public class TecnoReporteEventos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "reporte")
    private String reporte;
    @Column(name = "fechevento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechevento;
    @Basic(optional = false)
    @Column(name = "descripcion_evento")
    private String descripcionEvento;
    @Column(name = "cdg_eventodeteccion")
    private Integer cdgEventodeteccion;
    @Column(name = "cdg_tiporeporte")
    private Integer cdgTiporeporte;
    @Column(name = "cdg_desenlace")
    private Integer cdgDesenlace;
    @Column(name = "fechreporte_evento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechreporteEvento;
    @Column(name = "cdg_origenreporte")
    private Integer cdgOrigenreporte;
    @Column(name = "cdg_tipoeventoincidente")
    private Integer cdgTipoeventoincidente;
    @Column(name = "cdg_seriedad")
    private Integer cdgSeriedad;
    @Column(name = "desenlace_otro")
    private String desenlaceOtro;
    @Column(name = "internet")
    private Character internet;
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingreso;
    @Column(name = "reportado")
    private Character reportado;
    @Column(name = "estado_reporte")
    private String estado_reporte;
    
    
    //*********************************************************************
    //*********************************************************************
    //*********************************************************************
    //*********************************************************************
    @Column(name = "idips")
    private String idIps;
    //*********************************************************************
    //*********************************************************************
    @Column(name = "idrol")
    private Integer idRol;
    //*********************************************************************
    //*********************************************************************
    @Column(name = "reportepre")
    private String reportepre;
    //*********************************************************************
    //*********************************************************************
    //*********************************************************************
    //*********************************************************************
    //*********************************************************************
    //*********************************************************************
    //*********************************************************************
    //*********************************************************************
    //*********************************************************************
    //*********************************************************************
    public TecnoReporteEventos() {
    }

    public TecnoReporteEventos(String reporte) {
        this.reporte = reporte;
    }

    public TecnoReporteEventos(String reporte, String descripcionEvento) {
        this.reporte = reporte;
        this.descripcionEvento = descripcionEvento;
    }

    public String getEstado_reporte() {
        return estado_reporte;
    }

    public void setEstado_reporte(String estado_reporte) {
        this.estado_reporte = estado_reporte;
    }

    
    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public Date getFechevento() {
        return fechevento;
    }

    public void setFechevento(Date fechevento) {
        this.fechevento = fechevento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public Integer getCdgEventodeteccion() {
        return cdgEventodeteccion;
    }

    public void setCdgEventodeteccion(Integer cdgEventodeteccion) {
        this.cdgEventodeteccion = cdgEventodeteccion;
    }

    public Integer getCdgTiporeporte() {
        return cdgTiporeporte;
    }

    public void setCdgTiporeporte(Integer cdgTiporeporte) {
        this.cdgTiporeporte = cdgTiporeporte;
    }

    public Integer getCdgDesenlace() {
        return cdgDesenlace;
    }

    public void setCdgDesenlace(Integer cdgDesenlace) {
        this.cdgDesenlace = cdgDesenlace;
    }

    public Date getFechreporteEvento() {
        return fechreporteEvento;
    }

    public void setFechreporteEvento(Date fechreporteEvento) {
        this.fechreporteEvento = fechreporteEvento;
    }

    public Integer getCdgOrigenreporte() {
        return cdgOrigenreporte;
    }

    public void setCdgOrigenreporte(Integer cdgOrigenreporte) {
        this.cdgOrigenreporte = cdgOrigenreporte;
    }

    public Integer getCdgTipoeventoincidente() {
        return cdgTipoeventoincidente;
    }

    public void setCdgTipoeventoincidente(Integer cdgTipoeventoincidente) {
        this.cdgTipoeventoincidente = cdgTipoeventoincidente;
    }

    public Integer getCdgSeriedad() {
        return cdgSeriedad;
    }

    public void setCdgSeriedad(Integer cdgSeriedad) {
        this.cdgSeriedad = cdgSeriedad;
    }

    public String getDesenlaceOtro() {
        return desenlaceOtro;
    }

    public void setDesenlaceOtro(String desenlaceOtro) {
        this.desenlaceOtro = desenlaceOtro;
    }

    public Character getInternet() {
        return internet;
    }

    public void setInternet(Character internet) {
        this.internet = internet;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Character getReportado() {
        return reportado;
    }

    public void setReportado(Character reportado) {
        this.reportado = reportado;
    }
    
    /**
     * @return the idIps
     */
    public String getIdIps() {
        return idIps;
    }

    /**
     * @param idIps the idIps to set
     */
    public void setIdIps(String idIps) {
        this.idIps = idIps;
    }

    /**
     * @return the idRol
     */
    public Integer getIdRol() {
        return idRol;
    }

    /**
     * @param idRol the idRol to set
     */
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    /**
     * @return the reportepre
     */
    public String getReportepre() {
        return reportepre;
    }

    /**
     * @param reportepre the reportepre to set
     */
    public void setReportepre(String reportepre) {
        this.reportepre = reportepre;
    }
    //******************************************************************************
    //******************************************************************************
    //******************************************************************************
    //******************************************************************************
    //******************************************************************************
    //******************************************************************************
    //******************************************************************************
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reporte != null ? reporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoReporteEventos)) {
            return false;
        }
        TecnoReporteEventos other = (TecnoReporteEventos) object;
        if ((this.reporte == null && other.reporte != null) || (this.reporte != null && !this.reporte.equals(other.reporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoReporteEventos[reporte=" + reporte + "]";
    }
    //******************************************************************************
    //******************************************************************************
    //******************************************************************************
    //******************************************************************************
    //******************************************************************************
    //******************************************************************************
    //******************************************************************************
}
