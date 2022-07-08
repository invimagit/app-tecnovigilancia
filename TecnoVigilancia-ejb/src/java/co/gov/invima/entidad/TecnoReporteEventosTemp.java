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
@Table(name = "tecno_reporte_eventos_temp")
@NamedQueries({@NamedQuery(name = "TecnoReporteEventosTemp.findAll", query = "SELECT t FROM TecnoReporteEventosTemp t"), @NamedQuery(name = "TecnoReporteEventosTemp.findByReporte", query = "SELECT t FROM TecnoReporteEventosTemp t WHERE t.reporte = :reporte"), @NamedQuery(name = "TecnoReporteEventosTemp.findByFechevento", query = "SELECT t FROM TecnoReporteEventosTemp t WHERE t.fechevento = :fechevento"), @NamedQuery(name = "TecnoReporteEventosTemp.findByCdgEventodeteccion", query = "SELECT t FROM TecnoReporteEventosTemp t WHERE t.cdgEventodeteccion = :cdgEventodeteccion"), @NamedQuery(name = "TecnoReporteEventosTemp.findByCdgTiporeporte", query = "SELECT t FROM TecnoReporteEventosTemp t WHERE t.cdgTiporeporte = :cdgTiporeporte"), @NamedQuery(name = "TecnoReporteEventosTemp.findByCdgDesenlace", query = "SELECT t FROM TecnoReporteEventosTemp t WHERE t.cdgDesenlace = :cdgDesenlace"), @NamedQuery(name = "TecnoReporteEventosTemp.findByFechreporteEvento", query = "SELECT t FROM TecnoReporteEventosTemp t WHERE t.fechreporteEvento = :fechreporteEvento"), @NamedQuery(name = "TecnoReporteEventosTemp.findByCdgOrigenreporte", query = "SELECT t FROM TecnoReporteEventosTemp t WHERE t.cdgOrigenreporte = :cdgOrigenreporte"), @NamedQuery(name = "TecnoReporteEventosTemp.findByCdgTipoeventoincidente", query = "SELECT t FROM TecnoReporteEventosTemp t WHERE t.cdgTipoeventoincidente = :cdgTipoeventoincidente"), @NamedQuery(name = "TecnoReporteEventosTemp.findByCdgSeriedad", query = "SELECT t FROM TecnoReporteEventosTemp t WHERE t.cdgSeriedad = :cdgSeriedad"), @NamedQuery(name = "TecnoReporteEventosTemp.findByDesenlaceOtro", query = "SELECT t FROM TecnoReporteEventosTemp t WHERE t.desenlaceOtro = :desenlaceOtro"), @NamedQuery(name = "TecnoReporteEventosTemp.findByInternet", query = "SELECT t FROM TecnoReporteEventosTemp t WHERE t.internet = :internet"), @NamedQuery(name = "TecnoReporteEventosTemp.findByFechaingreso", query = "SELECT t FROM TecnoReporteEventosTemp t WHERE t.fechaingreso = :fechaingreso"), @NamedQuery(name = "TecnoReporteEventosTemp.findByReportado", query = "SELECT t FROM TecnoReporteEventosTemp t WHERE t.reportado = :reportado")})
public class TecnoReporteEventosTemp implements Serializable {
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
    //*********************************************************************
    public TecnoReporteEventosTemp() {
    }

    public TecnoReporteEventosTemp(String reporte) {
        this.reporte = reporte;
    }

    public TecnoReporteEventosTemp(String reporte, String descripcionEvento) {
        this.reporte = reporte;
        this.descripcionEvento = descripcionEvento;
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
    
    //********************************************************************************
    //********************************************************************************
    //********************************************************************************
    //********************************************************************************
    //********************************************************************************
    //********************************************************************************
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reporte != null ? reporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoReporteEventosTemp)) {
            return false;
        }
        TecnoReporteEventosTemp other = (TecnoReporteEventosTemp) object;
        if ((this.reporte == null && other.reporte != null) || (this.reporte != null && !this.reporte.equals(other.reporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoReporteEventosTemp[reporte=" + reporte + "]";
    }
    //********************************************************************************
    //********************************************************************************
    //********************************************************************************
    //********************************************************************************
    //********************************************************************************
    //********************************************************************************
}
