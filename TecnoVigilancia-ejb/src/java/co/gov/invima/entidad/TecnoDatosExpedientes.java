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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Diana Silva
 */
@Entity
@Table(name = "tecno_datos_expedientes")
@NamedQueries({@NamedQuery(name = "TecnoDatosExpedientes.findAll", query = "SELECT t FROM TecnoDatosExpedientes t"), @NamedQuery(name = "TecnoDatosExpedientes.findByReporte", query = "SELECT t FROM TecnoDatosExpedientes t WHERE t.tecnoDatosExpedientesPK.reporte = :reporte"), @NamedQuery(name = "TecnoDatosExpedientes.findByNroexpediente", query = "SELECT t FROM TecnoDatosExpedientes t WHERE t.tecnoDatosExpedientesPK.nroexpediente = :nroexpediente"), @NamedQuery(name = "TecnoDatosExpedientes.findByNroregsan", query = "SELECT t FROM TecnoDatosExpedientes t WHERE t.nroregsan = :nroregsan"), @NamedQuery(name = "TecnoDatosExpedientes.findByMiembroscomprometidos", query = "SELECT t FROM TecnoDatosExpedientes t WHERE t.miembroscomprometidos = :miembroscomprometidos"), @NamedQuery(name = "TecnoDatosExpedientes.findByClasificacion", query = "SELECT t FROM TecnoDatosExpedientes t WHERE t.clasificacion = :clasificacion"), @NamedQuery(name = "TecnoDatosExpedientes.findByNivelRiesgo", query = "SELECT t FROM TecnoDatosExpedientes t WHERE t.nivelRiesgo = :nivelRiesgo"), @NamedQuery(name = "TecnoDatosExpedientes.findByObservacion", query = "SELECT t FROM TecnoDatosExpedientes t WHERE t.observacion = :observacion"), @NamedQuery(name = "TecnoDatosExpedientes.findByReferencias", query = "SELECT t FROM TecnoDatosExpedientes t WHERE t.referencias = :referencias"), @NamedQuery(name = "TecnoDatosExpedientes.findBySistemas", query = "SELECT t FROM TecnoDatosExpedientes t WHERE t.sistemas = :sistemas"), @NamedQuery(name = "TecnoDatosExpedientes.findByModeloAutorizado", query = "SELECT t FROM TecnoDatosExpedientes t WHERE t.modeloAutorizado = :modeloAutorizado"), @NamedQuery(name = "TecnoDatosExpedientes.findByTipoDispositivo", query = "SELECT t FROM TecnoDatosExpedientes t WHERE t.tipoDispositivo = :tipoDispositivo"), @NamedQuery(name = "TecnoDatosExpedientes.findByFabricante", query = "SELECT t FROM TecnoDatosExpedientes t WHERE t.fabricante = :fabricante"), @NamedQuery(name = "TecnoDatosExpedientes.findByImportador", query = "SELECT t FROM TecnoDatosExpedientes t WHERE t.importador = :importador"), @NamedQuery(name = "TecnoDatosExpedientes.findByMarca", query = "SELECT t FROM TecnoDatosExpedientes t WHERE t.marca = :marca"), @NamedQuery(name = "TecnoDatosExpedientes.findByTitular", query = "SELECT t FROM TecnoDatosExpedientes t WHERE t.titular = :titular"), @NamedQuery(name = "TecnoDatosExpedientes.findByCdgPais", query = "SELECT t FROM TecnoDatosExpedientes t WHERE t.cdgPais = :cdgPais")})
public class TecnoDatosExpedientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TecnoDatosExpedientesPK tecnoDatosExpedientesPK;
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Column(name = "nroregsan")
    private String nroregsan;
    @Basic(optional = false)
    @Column(name = "uso")
    private String uso;
    @Column(name = "riesgo")
    private String riesgo;
    @Column(name = "miembroscomprometidos")
    private String miembroscomprometidos;
    @Column(name = "clasificacion")
    private String clasificacion;
    @Column(name = "nivel_riesgo")
    private String nivelRiesgo;
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "referencias")
    private String referencias;
    @Column(name = "sistemas")
    private String sistemas;
    @Column(name = "modelo_autorizado")
    private String modeloAutorizado;
    @Column(name = "tipo_dispositivo")
    private String tipoDispositivo;
    @Column(name = "fabricante")
    private String fabricante;
    @Column(name = "importador")
    private String importador;
    @Column(name = "marca")
    private String marca;
    @Column(name = "titular")
    private String titular;
    @Column(name = "cdg_pais")
    private String cdgPais;

    public TecnoDatosExpedientes() {
    }

    public TecnoDatosExpedientes(TecnoDatosExpedientesPK tecnoDatosExpedientesPK) {
        this.tecnoDatosExpedientesPK = tecnoDatosExpedientesPK;
    }

    public TecnoDatosExpedientes(TecnoDatosExpedientesPK tecnoDatosExpedientesPK, String uso) {
        this.tecnoDatosExpedientesPK = tecnoDatosExpedientesPK;
        this.uso = uso;
    }

    public TecnoDatosExpedientes(String reporte, long nroexpediente) {
        this.tecnoDatosExpedientesPK = new TecnoDatosExpedientesPK(reporte, nroexpediente);
    }

    public TecnoDatosExpedientesPK getTecnoDatosExpedientesPK() {
        return tecnoDatosExpedientesPK;
    }

    public void setTecnoDatosExpedientesPK(TecnoDatosExpedientesPK tecnoDatosExpedientesPK) {
        this.tecnoDatosExpedientesPK = tecnoDatosExpedientesPK;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNroregsan() {
        return nroregsan;
    }

    public void setNroregsan(String nroregsan) {
        this.nroregsan = nroregsan;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getImportador() {
        return importador;
    }

    public void setImportador(String importador) {
        this.importador = importador;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getCdgPais() {
        return cdgPais;
    }

    public void setCdgPais(String cdgPais) {
        this.cdgPais = cdgPais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tecnoDatosExpedientesPK != null ? tecnoDatosExpedientesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoDatosExpedientes)) {
            return false;
        }
        TecnoDatosExpedientes other = (TecnoDatosExpedientes) object;
        if ((this.tecnoDatosExpedientesPK == null && other.tecnoDatosExpedientesPK != null) || (this.tecnoDatosExpedientesPK != null && !this.tecnoDatosExpedientesPK.equals(other.tecnoDatosExpedientesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoDatosExpedientes[tecnoDatosExpedientesPK=" + tecnoDatosExpedientesPK + "]";
    }

}
