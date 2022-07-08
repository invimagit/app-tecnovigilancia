/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Diana Silva
 */
@Entity
@Table(name = "tecno_dispositivo")
@NamedQueries({
    @NamedQuery(name = "TecnoDispositivo.findAll", query = "SELECT t FROM TecnoDispositivo t"), 
    @NamedQuery(name = "TecnoDispositivo.findByReporte", query = "SELECT t FROM TecnoDispositivo t WHERE t.reporte = :reporte"),
    @NamedQuery(name = "TecnoDispositivo.findByNombreDispositivo",
            query = "SELECT t FROM TecnoDispositivo t WHERE t.nombreDispositivo = :nombreDispositivo"), 
    @NamedQuery(name = "TecnoDispositivo.findByNroregsan", query = "SELECT t FROM TecnoDispositivo t WHERE t.nroregsan = :nroregsan"), 
    @NamedQuery(name = "TecnoDispositivo.findByLote", query = "SELECT t FROM TecnoDispositivo t WHERE t.lote = :lote"), 
    @NamedQuery(name = "TecnoDispositivo.findByReferencia", query = "SELECT t FROM TecnoDispositivo t WHERE t.referencia = :referencia"), 
    @NamedQuery(name = "TecnoDispositivo.findByModelo", query = "SELECT t FROM TecnoDispositivo t WHERE t.modelo = :modelo"),
    @NamedQuery(name = "TecnoDispositivo.findBySerial", query = "SELECT t FROM TecnoDispositivo t WHERE t.serial = :serial"), 
    @NamedQuery(name = "TecnoDispositivo.findByCdgUnicodispositivo", query = "SELECT t FROM TecnoDispositivo t "
            + "WHERE t.cdgUnicodispositivo = :cdgUnicodispositivo"), 
    @NamedQuery(name = "TecnoDispositivo.findByFabricanteUsuario", query = "SELECT t FROM TecnoDispositivo t WHERE t.fabricanteUsuario = :fabricanteUsuario"), 
    @NamedQuery(name = "TecnoDispositivo.findByDistribuidorUsuario", query = "SELECT t FROM TecnoDispositivo t "
            + "WHERE t.distribuidorUsuario = :distribuidorUsuario"), 
    @NamedQuery(name = "TecnoDispositivo.findByExpediente", query = "SELECT t FROM TecnoDispositivo t "
            + "WHERE t.expediente = :expediente"), 
    @NamedQuery(name = "TecnoDispositivo.findByCdgTipodispositivo", query = "SELECT t FROM TecnoDispositivo t "
            + "WHERE t.cdgTipodispositivo = :cdgTipodispositivo"), 
    @NamedQuery(name = "TecnoDispositivo.findByAreaFunciona", query = "SELECT t FROM TecnoDispositivo t WHERE t.areaFunciona = :areaFunciona"), 
    @NamedQuery(name = "TecnoDispositivo.findByUtilizado", query = "SELECT t FROM TecnoDispositivo t WHERE t.utilizado = :utilizado"), 
    @NamedQuery(name = "TecnoDispositivo.findByNombreComercial", query = "SELECT t FROM TecnoDispositivo t WHERE t.nombreComercial = :nombreComercial")})
public class TecnoDispositivo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @Basic(optional = false)
    @Column(name = "reporte")
    private String reporte;
    @Column(name = "expediente")
    private int expediente;
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

    public TecnoDispositivo() {
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public int getExpediente() {
        return expediente;
    }

    public void setExpediente(int expediente) {
        this.expediente = expediente;
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

}
