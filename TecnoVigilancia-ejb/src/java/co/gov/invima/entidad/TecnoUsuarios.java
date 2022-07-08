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
 * @author Administrator
 */
@Entity
@Table(name = "tecno_usuarios")
@NamedQueries({@NamedQuery(name = "TecnoUsuarios.findAll", query = "SELECT t FROM TecnoUsuarios t"), @NamedQuery(name = "TecnoUsuarios.findByNombreReportante", query = "SELECT t FROM TecnoUsuarios t WHERE t.nombreReportante = :nombreReportante"), @NamedQuery(name = "TecnoUsuarios.findBySexo", query = "SELECT t FROM TecnoUsuarios t WHERE t.sexo = :sexo"), @NamedQuery(name = "TecnoUsuarios.findByEdad", query = "SELECT t FROM TecnoUsuarios t WHERE t.edad = :edad"), @NamedQuery(name = "TecnoUsuarios.findByEdadEn", query = "SELECT t FROM TecnoUsuarios t WHERE t.edadEn = :edadEn"), @NamedQuery(name = "TecnoUsuarios.findByDireccionReportante", query = "SELECT t FROM TecnoUsuarios t WHERE t.direccionReportante = :direccionReportante"), @NamedQuery(name = "TecnoUsuarios.findByTelefono", query = "SELECT t FROM TecnoUsuarios t WHERE t.telefono = :telefono"), @NamedQuery(name = "TecnoUsuarios.findByPais", query = "SELECT t FROM TecnoUsuarios t WHERE t.pais = :pais"), @NamedQuery(name = "TecnoUsuarios.findByCodDepart", query = "SELECT t FROM TecnoUsuarios t WHERE t.codDepart = :codDepart"), @NamedQuery(name = "TecnoUsuarios.findByCodMun", query = "SELECT t FROM TecnoUsuarios t WHERE t.codMun = :codMun"), @NamedQuery(name = "TecnoUsuarios.findByEmail", query = "SELECT t FROM TecnoUsuarios t WHERE t.email = :email"), @NamedQuery(name = "TecnoUsuarios.findByNombreDm", query = "SELECT t FROM TecnoUsuarios t WHERE t.nombreDm = :nombreDm"), @NamedQuery(name = "TecnoUsuarios.findByNombreComercial", query = "SELECT t FROM TecnoUsuarios t WHERE t.nombreComercial = :nombreComercial"), @NamedQuery(name = "TecnoUsuarios.findByNroregsan", query = "SELECT t FROM TecnoUsuarios t WHERE t.nroregsan = :nroregsan"), @NamedQuery(name = "TecnoUsuarios.findByLote", query = "SELECT t FROM TecnoUsuarios t WHERE t.lote = :lote"), @NamedQuery(name = "TecnoUsuarios.findByReferencia", query = "SELECT t FROM TecnoUsuarios t WHERE t.referencia = :referencia"), @NamedQuery(name = "TecnoUsuarios.findByNombreFabricante", query = "SELECT t FROM TecnoUsuarios t WHERE t.nombreFabricante = :nombreFabricante"), @NamedQuery(name = "TecnoUsuarios.findByNombreDistribImport", query = "SELECT t FROM TecnoUsuarios t WHERE t.nombreDistribImport = :nombreDistribImport"), @NamedQuery(name = "TecnoUsuarios.findByFechaEvento", query = "SELECT t FROM TecnoUsuarios t WHERE t.fechaEvento = :fechaEvento"), @NamedQuery(name = "TecnoUsuarios.findByFechaNotificacion", query = "SELECT t FROM TecnoUsuarios t WHERE t.fechaNotificacion = :fechaNotificacion"), @NamedQuery(name = "TecnoUsuarios.findByCdgEventodeteccion", query = "SELECT t FROM TecnoUsuarios t WHERE t.cdgEventodeteccion = :cdgEventodeteccion"), @NamedQuery(name = "TecnoUsuarios.findByConsecutivo", query = "SELECT t FROM TecnoUsuarios t WHERE t.consecutivo = :consecutivo"), @NamedQuery(name = "TecnoUsuarios.findByCdgfuncionario", query = "SELECT t FROM TecnoUsuarios t WHERE t.cdgfuncionario = :cdgfuncionario"), @NamedQuery(name = "TecnoUsuarios.findByRevisado", query = "SELECT t FROM TecnoUsuarios t WHERE t.revisado = :revisado"), @NamedQuery(name = "TecnoUsuarios.findByReporte", query = "SELECT t FROM TecnoUsuarios t WHERE t.reporte = :reporte")})
public class TecnoUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "nombre_reportante")
    private String nombreReportante;
    @Basic(optional = false)
    @Column(name = "sexo")
    private char sexo;
    @Basic(optional = false)
    @Column(name = "edad")
    private short edad;
    @Basic(optional = false)
    @Column(name = "edad_en")
    private char edadEn;
    @Basic(optional = false)
    @Column(name = "direccion_reportante")
    private String direccionReportante;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @Column(name = "cod_depart")
    private String codDepart;
    @Basic(optional = false)
    @Column(name = "cod_mun")
    private String codMun;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "nombre_dm")
    private String nombreDm;
    @Basic(optional = false)
    @Column(name = "nombre_comercial")
    private String nombreComercial;
    @Basic(optional = false)
    @Column(name = "nroregsan")
    private String nroregsan;
    @Basic(optional = false)
    @Column(name = "lote")
    private String lote;
    @Basic(optional = false)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "nombre_fabricante")
    private String nombreFabricante;
    @Basic(optional = false)
    @Column(name = "nombre_distrib_import")
    private String nombreDistribImport;
    @Basic(optional = false)
    @Column(name = "fecha_evento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEvento;
    @Basic(optional = false)
    @Column(name = "fecha_notificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNotificacion;
    @Basic(optional = false)
    @Column(name = "cdg_eventodeteccion")
    private int cdgEventodeteccion;
    @Basic(optional = false)
    @Column(name = "descripcion_evento")
    private String descripcionEvento;
    @Id
    @Basic(optional = false)
    @Column(name = "consecutivo")
    private Integer consecutivo;
    @Basic(optional = false)
    @Column(name = "cdgfuncionario")
    private Integer cdgfuncionario;
    @Basic(optional = false)
    @Column(name = "revisado")
    private char revisado;
    @Column(name = "reporte")
    private String reporte;

    public TecnoUsuarios() {
    }

    public TecnoUsuarios(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public TecnoUsuarios(Integer consecutivo, String nombreReportante, char sexo, short edad, char edadEn, String direccionReportante, String telefono, String pais, String codDepart, String codMun, String email, String nombreDm, String nombreComercial, String nroregsan, String lote, String referencia, String nombreFabricante, String nombreDistribImport, Date fechaEvento, Date fechaNotificacion, int cdgEventodeteccion, String descripcionEvento, int cdgfuncionario, char revisado) {
        this.consecutivo = consecutivo;
        this.nombreReportante = nombreReportante;
        this.sexo = sexo;
        this.edad = edad;
        this.edadEn = edadEn;
        this.direccionReportante = direccionReportante;
        this.telefono = telefono;
        this.pais = pais;
        this.codDepart = codDepart;
        this.codMun = codMun;
        this.email = email;
        this.nombreDm = nombreDm;
        this.nombreComercial = nombreComercial;
        this.nroregsan = nroregsan;
        this.lote = lote;
        this.referencia = referencia;
        this.nombreFabricante = nombreFabricante;
        this.nombreDistribImport = nombreDistribImport;
        this.fechaEvento = fechaEvento;
        this.fechaNotificacion = fechaNotificacion;
        this.cdgEventodeteccion = cdgEventodeteccion;
        this.descripcionEvento = descripcionEvento;
        this.cdgfuncionario = cdgfuncionario;
        this.revisado = revisado;
    }

    public String getNombreReportante() {
        return nombreReportante;
    }

    public void setNombreReportante(String nombreReportante) {
        this.nombreReportante = nombreReportante;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public char getEdadEn() {
        return edadEn;
    }

    public void setEdadEn(char edadEn) {
        this.edadEn = edadEn;
    }

    public String getDireccionReportante() {
        return direccionReportante;
    }

    public void setDireccionReportante(String direccionReportante) {
        this.direccionReportante = direccionReportante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodDepart() {
        return codDepart;
    }

    public void setCodDepart(String codDepart) {
        this.codDepart = codDepart;
    }

    public String getCodMun() {
        return codMun;
    }

    public void setCodMun(String codMun) {
        this.codMun = codMun;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreDm() {
        return nombreDm;
    }

    public void setNombreDm(String nombreDm) {
        this.nombreDm = nombreDm;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
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

    public String getNombreFabricante() {
        return nombreFabricante;
    }

    public void setNombreFabricante(String nombreFabricante) {
        this.nombreFabricante = nombreFabricante;
    }

    public String getNombreDistribImport() {
        return nombreDistribImport;
    }

    public void setNombreDistribImport(String nombreDistribImport) {
        this.nombreDistribImport = nombreDistribImport;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public int getCdgEventodeteccion() {
        return cdgEventodeteccion;
    }

    public void setCdgEventodeteccion(int cdgEventodeteccion) {
        this.cdgEventodeteccion = cdgEventodeteccion;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Integer getCdgfuncionario() {
        return cdgfuncionario;
    }

    public void setCdgfuncionario(Integer cdgfuncionario) {
        this.cdgfuncionario = cdgfuncionario;
    }

    public char getRevisado() {
        return revisado;
    }

    public void setRevisado(char revisado) {
        this.revisado = revisado;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consecutivo != null ? consecutivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoUsuarios)) {
            return false;
        }
        TecnoUsuarios other = (TecnoUsuarios) object;
        if ((this.consecutivo == null && other.consecutivo != null) || (this.consecutivo != null && !this.consecutivo.equals(other.consecutivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoUsuarios[consecutivo=" + consecutivo + "]";
    }

}
