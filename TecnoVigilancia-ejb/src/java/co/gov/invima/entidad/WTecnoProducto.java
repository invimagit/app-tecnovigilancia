/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonat
 */
@Entity
@Table(name = "w_tecno_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WTecnoProducto.findAll", query = "SELECT w FROM WTecnoProducto w")
    , @NamedQuery(name = "WTecnoProducto.findByNroexpediente", query = "SELECT w FROM WTecnoProducto w WHERE w.nroexpediente = :nroexpediente")
    , @NamedQuery(name = "WTecnoProducto.findByVidaUtil", query = "SELECT w FROM WTecnoProducto w WHERE w.vidaUtil = :vidaUtil")
    , @NamedQuery(name = "WTecnoProducto.findByMiembroscomprometidos", query = "SELECT w FROM WTecnoProducto w WHERE w.miembroscomprometidos = :miembroscomprometidos")
    , @NamedQuery(name = "WTecnoProducto.findByClasificacion", query = "SELECT w FROM WTecnoProducto w WHERE w.clasificacion = :clasificacion")
    , @NamedQuery(name = "WTecnoProducto.findByNivelRiesgo", query = "SELECT w FROM WTecnoProducto w WHERE w.nivelRiesgo = :nivelRiesgo")
    , @NamedQuery(name = "WTecnoProducto.findByObservaciones", query = "SELECT w FROM WTecnoProducto w WHERE w.observaciones = :observaciones")
    , @NamedQuery(name = "WTecnoProducto.findBySistemas", query = "SELECT w FROM WTecnoProducto w WHERE w.sistemas = :sistemas")
    , @NamedQuery(name = "WTecnoProducto.findByModeloAutorizado", query = "SELECT w FROM WTecnoProducto w WHERE w.modeloAutorizado = :modeloAutorizado")
    , @NamedQuery(name = "WTecnoProducto.findByTipoDispositivo", query = "SELECT w FROM WTecnoProducto w WHERE w.tipoDispositivo = :tipoDispositivo")
    , @NamedQuery(name = "WTecnoProducto.findByMarca", query = "SELECT w FROM WTecnoProducto w WHERE w.marca = :marca")
    , @NamedQuery(name = "WTecnoProducto.findByNroregsan", query = "SELECT w FROM WTecnoProducto w WHERE w.nroregsan = :nroregsan")
    , @NamedQuery(name = "WTecnoProducto.findByDesEstadoregistro", query = "SELECT w FROM WTecnoProducto w WHERE w.desEstadoregistro = :desEstadoregistro")})
public class WTecnoProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "nroexpediente")
    @Id
    private Long nroexpediente;
    
    @Size(max = 2147483647)
    @Column(name = "nmbproducto")
    private String nmbproducto;
    @Size(max = 10)
    @Column(name = "vida_util")
    private String vidaUtil;
    
    @Size(max = 2147483647)
    @Column(name = "usos")
    private String usos;
    
    @Size(max = 2147483647)
    @Column(name = "riesgo")
    private String riesgo;
    @Size(max = 50)
    @Column(name = "miembroscomprometidos")
    private String miembroscomprometidos;
    @Size(max = 2)
    @Column(name = "clasificacion")
    private String clasificacion;
    @Size(max = 5)
    @Column(name = "nivel_riesgo")
    private String nivelRiesgo;
    @Size(max = 8000)
    @Column(name = "observaciones")
    private String observaciones;
    
    @Size(max = 2147483647)
    @Column(name = "referencias")
    private String referencias;
    @Size(max = 255)
    @Column(name = "sistemas")
    private String sistemas;
    @Size(max = 255)
    @Column(name = "modelo_autorizado")
    private String modeloAutorizado;
    @Size(max = 100)
    @Column(name = "tipo_dispositivo")
    private String tipoDispositivo;
    @Size(max = 80)
    @Column(name = "marca")
    private String marca;
    @Size(max = 25)
    @Column(name = "nroregsan")
    private String nroregsan;
    
    @Size(max = 2147483647)
    @Column(name = "observacion")
    private String observacion;
    @Size(max = 60)
    @Column(name = "des_estadoregistro")
    private String desEstadoregistro;

    public WTecnoProducto() {
    }

    public Long getNroexpediente() {
        return nroexpediente;
    }

    public void setNroexpediente(Long nroexpediente) {
        this.nroexpediente = nroexpediente;
    }

    public String getNmbproducto() {
        return nmbproducto;
    }

    public void setNmbproducto(String nmbproducto) {
        this.nmbproducto = nmbproducto;
    }

    public String getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(String vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public String getUsos() {
        return usos;
    }

    public void setUsos(String usos) {
        this.usos = usos;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public String getMiembroscomprometidos() {
        return miembroscomprometidos;
    }

    public void setMiembroscomprometidos(String miembroscomprometidos) {
        this.miembroscomprometidos = miembroscomprometidos;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(String nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    public String getSistemas() {
        return sistemas;
    }

    public void setSistemas(String sistemas) {
        this.sistemas = sistemas;
    }

    public String getModeloAutorizado() {
        return modeloAutorizado;
    }

    public void setModeloAutorizado(String modeloAutorizado) {
        this.modeloAutorizado = modeloAutorizado;
    }

    public String getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(String tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNroregsan() {
        return nroregsan;
    }

    public void setNroregsan(String nroregsan) {
        this.nroregsan = nroregsan;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getDesEstadoregistro() {
        return desEstadoregistro;
    }

    public void setDesEstadoregistro(String desEstadoregistro) {
        this.desEstadoregistro = desEstadoregistro;
    }
    
}
