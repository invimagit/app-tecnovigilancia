/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Diana Silva
 */
@Entity
@Table(name = "tecno_dispositivo_temp")
@NamedQueries({@NamedQuery(name = "TecnoDispositivoTemp.findAll", query = "SELECT t FROM TecnoDispositivoTemp t"), @NamedQuery(name = "TecnoDispositivoTemp.findByReporte", query = "SELECT t FROM TecnoDispositivoTemp t WHERE t.tecnoDispositivoPK.reporte = :reporte"), @NamedQuery(name = "TecnoDispositivoTemp.findByNombreDispositivo", query = "SELECT t FROM TecnoDispositivoTemp t WHERE t.nombreDispositivo = :nombreDispositivo"), @NamedQuery(name = "TecnoDispositivoTemp.findByNroregsan", query = "SELECT t FROM TecnoDispositivoTemp t WHERE t.nroregsan = :nroregsan"), @NamedQuery(name = "TecnoDispositivoTemp.findByLote", query = "SELECT t FROM TecnoDispositivoTemp t WHERE t.lote = :lote"), @NamedQuery(name = "TecnoDispositivoTemp.findByReferencia", query = "SELECT t FROM TecnoDispositivoTemp t WHERE t.referencia = :referencia"), @NamedQuery(name = "TecnoDispositivoTemp.findByModelo", query = "SELECT t FROM TecnoDispositivoTemp t WHERE t.modelo = :modelo"), @NamedQuery(name = "TecnoDispositivoTemp.findBySerial", query = "SELECT t FROM TecnoDispositivoTemp t WHERE t.serial = :serial"), @NamedQuery(name = "TecnoDispositivoTemp.findByCdgUnicodispositivo", query = "SELECT t FROM TecnoDispositivoTemp t WHERE t.cdgUnicodispositivo = :cdgUnicodispositivo"), @NamedQuery(name = "TecnoDispositivoTemp.findByFabricanteUsuario", query = "SELECT t FROM TecnoDispositivoTemp t WHERE t.fabricanteUsuario = :fabricanteUsuario"), @NamedQuery(name = "TecnoDispositivoTemp.findByDistribuidorUsuario", query = "SELECT t FROM TecnoDispositivoTemp t WHERE t.distribuidorUsuario = :distribuidorUsuario"), @NamedQuery(name = "TecnoDispositivoTemp.findByExpediente", query = "SELECT t FROM TecnoDispositivoTemp t WHERE t.tecnoDispositivoPK.expediente = :expediente"), @NamedQuery(name = "TecnoDispositivoTemp.findByCdgTipodispositivo", query = "SELECT t FROM TecnoDispositivoTemp t WHERE t.cdgTipodispositivo = :cdgTipodispositivo"), @NamedQuery(name = "TecnoDispositivoTemp.findByAreaFunciona", query = "SELECT t FROM TecnoDispositivoTemp t WHERE t.areaFunciona = :areaFunciona"), @NamedQuery(name = "TecnoDispositivoTemp.findByUtilizado", query = "SELECT t FROM TecnoDispositivoTemp t WHERE t.utilizado = :utilizado"), @NamedQuery(name = "TecnoDispositivoTemp.findByNombreComercial", query = "SELECT t FROM TecnoDispositivoTemp t WHERE t.nombreComercial = :nombreComercial")})
public class TecnoDispositivoTemp implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TecnoDispositivoTempPK tecnoDispositivoPK;
    @Column(name = "nombre_dispositivo")
    private String nombreDispositivo;
    @Column(name = "nroregsan")
    private String nroregsan;
    @Column(name = "lote")
    private String lote;
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "serial")
    private String serial;
    @Column(name = "cdg_unicodispositivo")
    private Integer cdgUnicodispositivo;
    @Column(name = "fabricante_usuario")
    private String fabricanteUsuario;
    @Column(name = "distribuidor_usuario")
    private String distribuidorUsuario;
    @Column(name = "cdg_tipodispositivo")
    private Integer cdgTipodispositivo;
    @Column(name = "area_funciona")
    private String areaFunciona;
    @Column(name = "utilizado")
    private String utilizado;
    @Column(name = "nombre_comercial")
    private String nombreComercial;

    public TecnoDispositivoTemp() {
    }

    public TecnoDispositivoTemp(TecnoDispositivoTempPK tecnoDispositivoPK) {
        this.tecnoDispositivoPK = tecnoDispositivoPK;
    }

    public TecnoDispositivoTemp(String reporte, int expediente) {
        this.tecnoDispositivoPK = new TecnoDispositivoTempPK(reporte, expediente);
    }

    public TecnoDispositivoTempPK getTecnoDispositivoTempPK() {
        return tecnoDispositivoPK;
    }

    public void setTecnoDispositivoTempPK(TecnoDispositivoTempPK tecnoDispositivoPK) {
        this.tecnoDispositivoPK = tecnoDispositivoPK;
    }

    public String getNombreDispositivo() {
        return nombreDispositivo;
    }

    public void setNombreDispositivo(String nombreDispositivo) {
        this.nombreDispositivo = nombreDispositivo;
    }

    public String getNroregsan() {
        return nroregsan;
    }

    public void setNroregsan(String nroregsan) {
        this.nroregsan = nroregsan;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Integer getCdgUnicodispositivo() {
        return cdgUnicodispositivo;
    }

    public void setCdgUnicodispositivo(Integer cdgUnicodispositivo) {
        this.cdgUnicodispositivo = cdgUnicodispositivo;
    }

    public String getFabricanteUsuario() {
        return fabricanteUsuario;
    }

    public void setFabricanteUsuario(String fabricanteUsuario) {
        this.fabricanteUsuario = fabricanteUsuario;
    }

    public String getDistribuidorUsuario() {
        return distribuidorUsuario;
    }

    public void setDistribuidorUsuario(String distribuidorUsuario) {
        this.distribuidorUsuario = distribuidorUsuario;
    }

    public Integer getCdgTipodispositivo() {
        return cdgTipodispositivo;
    }

    public void setCdgTipodispositivo(Integer cdgTipodispositivo) {
        this.cdgTipodispositivo = cdgTipodispositivo;
    }

    public String getAreaFunciona() {
        return areaFunciona;
    }

    public void setAreaFunciona(String areaFunciona) {
        this.areaFunciona = areaFunciona;
    }

    public String getUtilizado() {
        return utilizado;
    }

    public void setUtilizado(String utilizado) {
        this.utilizado = utilizado;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tecnoDispositivoPK != null ? tecnoDispositivoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoDispositivoTemp)) {
            return false;
        }
        TecnoDispositivoTemp other = (TecnoDispositivoTemp) object;
        if ((this.tecnoDispositivoPK == null && other.tecnoDispositivoPK != null) || (this.tecnoDispositivoPK != null && !this.tecnoDispositivoPK.equals(other.tecnoDispositivoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoDispositivoTemp[tecnoDispositivoPK=" + tecnoDispositivoPK + "]";
    }

}
