/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.entidad;

import java.io.Serializable;
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
 * @author Administrator
 */
@Entity
@Table(name = "tecno_paciente")
@NamedQueries({@NamedQuery(name = "TecnoPaciente.findAll", query = "SELECT t FROM TecnoPaciente t"), 
    @NamedQuery(name = "TecnoPaciente.findByReporte", query = "SELECT t FROM TecnoPaciente t WHERE t.reporte = :reporte"), @NamedQuery(name = "TecnoPaciente.findByIdentificacion", query = "SELECT t FROM TecnoPaciente t WHERE t.identificacion = :identificacion"), @NamedQuery(name = "TecnoPaciente.findByTipidentificacion", query = "SELECT t FROM TecnoPaciente t WHERE t.tipidentificacion = :tipidentificacion"), @NamedQuery(name = "TecnoPaciente.findByEdad", query = "SELECT t FROM TecnoPaciente t WHERE t.edad = :edad"), @NamedQuery(name = "TecnoPaciente.findByGenero", query = "SELECT t FROM TecnoPaciente t WHERE t.genero = :genero"), @NamedQuery(name = "TecnoPaciente.findByEdadEn", query = "SELECT t FROM TecnoPaciente t WHERE t.edadEn = :edadEn"), @NamedQuery(name = "TecnoPaciente.findByInstitucionReportente", query = "SELECT t FROM TecnoPaciente t WHERE t.institucionReportente = :institucionReportente"), @NamedQuery(name = "TecnoPaciente.findByNaturaleza", query = "SELECT t FROM TecnoPaciente t WHERE t.naturaleza = :naturaleza"), @NamedQuery(name = "TecnoPaciente.findByDireccionReportante", query = "SELECT t FROM TecnoPaciente t WHERE t.direccionReportante = :direccionReportante"), @NamedQuery(name = "TecnoPaciente.findByCodMun", query = "SELECT t FROM TecnoPaciente t WHERE t.codMun = :codMun"), @NamedQuery(name = "TecnoPaciente.findByTelefonoReportante", query = "SELECT t FROM TecnoPaciente t WHERE t.telefonoReportante = :telefonoReportante"), @NamedQuery(name = "TecnoPaciente.findByEmailReportante", query = "SELECT t FROM TecnoPaciente t WHERE t.emailReportante = :emailReportante"), @NamedQuery(name = "TecnoPaciente.findByContactoReportante", query = "SELECT t FROM TecnoPaciente t WHERE t.contactoReportante = :contactoReportante"), @NamedQuery(name = "TecnoPaciente.findByCodDepart", query = "SELECT t FROM TecnoPaciente t WHERE t.codDepart = :codDepart"), @NamedQuery(name = "TecnoPaciente.findByInstitucionIncidente", query = "SELECT t FROM TecnoPaciente t WHERE t.institucionIncidente = :institucionIncidente"), @NamedQuery(name = "TecnoPaciente.findByCodMun1", query = "SELECT t FROM TecnoPaciente t WHERE t.codMun1 = :codMun1"), @NamedQuery(name = "TecnoPaciente.findByIdentificacion1", query = "SELECT t FROM TecnoPaciente t WHERE t.identificacion1 = :identificacion1"), @NamedQuery(name = "TecnoPaciente.findByNivelComplejidad", query = "SELECT t FROM TecnoPaciente t WHERE t.nivelComplejidad = :nivelComplejidad"), @NamedQuery(name = "TecnoPaciente.findByCargoInst", query = "SELECT t FROM TecnoPaciente t WHERE t.cargoInst = :cargoInst"), @NamedQuery(name = "TecnoPaciente.findByFechaNotif", query = "SELECT t FROM TecnoPaciente t WHERE t.fechaNotif = :fechaNotif"), @NamedQuery(name = "TecnoPaciente.findByCodDepart1", query = "SELECT t FROM TecnoPaciente t WHERE t.codDepart1 = :codDepart1"), @NamedQuery(name = "TecnoPaciente.findByAutorizacion", query = "SELECT t FROM TecnoPaciente t WHERE t.autorizacion = :autorizacion"), @NamedQuery(name = "TecnoPaciente.findByTipoReportante", query = "SELECT t FROM TecnoPaciente t WHERE t.tipoReportante = :tipoReportante")})
public class TecnoPaciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "reporte")
    private String reporte;
    @Column(name = "identificacion")
    private String identificacion;
    @Column(name = "tipidentificacion")
    private String tipidentificacion;
    @Column(name = "edad")
    private String edad;
    @Column(name = "genero")
    private Character genero;
    
    @Column(name = "diagnostico_paciente")
    private String diagnosticoPaciente;
    @Column(name = "edad_en")
    private Character edadEn;
    @Column(name = "institucion_reportente")
    private String institucionReportente;
    @Column(name = "naturaleza")
    private String naturaleza;
    @Column(name = "direccion_reportante")
    private String direccionReportante;
    @Column(name = "cod_mun")
    private String codMun;
    @Column(name = "telefono_reportante")
    private BigInteger telefonoReportante;
    @Column(name = "email_reportante")
    private String emailReportante;
    @Column(name = "contacto_reportante")
    private String contactoReportante;
    @Column(name = "cod_depart")
    private String codDepart;
    @Column(name = "institucion_incidente")
    private String institucionIncidente;
    @Column(name = "cod_mun1")
    private String codMun1;
    @Column(name = "identificacion1")
    private String identificacion1;
    @Column(name = "nivel_complejidad")
    private String nivelComplejidad;
    @Column(name = "cargo_inst")
    private Integer cargoInst;
    @Column(name = "fecha_notif")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNotif;
    @Column(name = "cod_depart1")
    private String codDepart1;
    @Column(name = "autorizacion")
    private String autorizacion;
    @Column(name = "tipo_reportante")
    private Integer tipoReportante;

    public TecnoPaciente() {
    }

    public TecnoPaciente(String reporte) {
        this.reporte = reporte;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipidentificacion() {
        return tipidentificacion;
    }

    public void setTipidentificacion(String tipidentificacion) {
        this.tipidentificacion = tipidentificacion;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getDiagnosticoPaciente() {
        return diagnosticoPaciente;
    }

    public void setDiagnosticoPaciente(String diagnosticoPaciente) {
        this.diagnosticoPaciente = diagnosticoPaciente;
    }

    public Character getEdadEn() {
        return edadEn;
    }

    public void setEdadEn(Character edadEn) {
        this.edadEn = edadEn;
    }

    public String getInstitucionReportente() {
        return institucionReportente;
    }

    public void setInstitucionReportente(String institucionReportente) {
        this.institucionReportente = institucionReportente;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    public String getDireccionReportante() {
        return direccionReportante;
    }

    public void setDireccionReportante(String direccionReportante) {
        this.direccionReportante = direccionReportante;
    }

    public String getCodMun() {
        return codMun;
    }

    public void setCodMun(String codMun) {
        this.codMun = codMun;
    }

    public BigInteger getTelefonoReportante() {
        return telefonoReportante;
    }

    public void setTelefonoReportante(BigInteger telefonoReportante) {
        this.telefonoReportante = telefonoReportante;
    }

    public String getEmailReportante() {
        return emailReportante;
    }

    public void setEmailReportante(String emailReportante) {
        this.emailReportante = emailReportante;
    }

    public String getContactoReportante() {
        return contactoReportante;
    }

    public void setContactoReportante(String contactoReportante) {
        this.contactoReportante = contactoReportante;
    }

    public String getCodDepart() {
        return codDepart;
    }

    public void setCodDepart(String codDepart) {
        this.codDepart = codDepart;
    }

    public String getInstitucionIncidente() {
        return institucionIncidente;
    }

    public void setInstitucionIncidente(String institucionIncidente) {
        this.institucionIncidente = institucionIncidente;
    }

    public String getCodMun1() {
        return codMun1;
    }

    public void setCodMun1(String codMun1) {
        this.codMun1 = codMun1;
    }

    public String getIdentificacion1() {
        return identificacion1;
    }

    public void setIdentificacion1(String identificacion1) {
        this.identificacion1 = identificacion1;
    }

    public String getNivelComplejidad() {
        return nivelComplejidad;
    }

    public void setNivelComplejidad(String nivelComplejidad) {
        this.nivelComplejidad = nivelComplejidad;
    }

    public Integer getCargoInst() {
        return cargoInst;
    }

    public void setCargoInst(Integer cargoInst) {
        this.cargoInst = cargoInst;
    }

    public Date getFechaNotif() {
        return fechaNotif;
    }

    public void setFechaNotif(Date fechaNotif) {
        this.fechaNotif = fechaNotif;
    }

    public String getCodDepart1() {
        return codDepart1;
    }

    public void setCodDepart1(String codDepart1) {
        this.codDepart1 = codDepart1;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Integer getTipoReportante() {
        return tipoReportante;
    }

    public void setTipoReportante(Integer tipoReportante) {
        this.tipoReportante = tipoReportante;
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
        if (!(object instanceof TecnoPaciente)) {
            return false;
        }
        TecnoPaciente other = (TecnoPaciente) object;
        if ((this.reporte == null && other.reporte != null) || (this.reporte != null && !this.reporte.equals(other.reporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoPaciente[reporte=" + reporte + "]";
    }

}
