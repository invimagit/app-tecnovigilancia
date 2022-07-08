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
@Table(name = "tecno_consec")
@NamedQueries({@NamedQuery(name = "TecnoConsec.findAll", query = "SELECT t FROM TecnoConsec t"), @NamedQuery(name = "TecnoConsec.findByConsecutivo", query = "SELECT t FROM TecnoConsec t WHERE t.consecutivo = :consecutivo"), @NamedQuery(name = "TecnoConsec.findByConsec", query = "SELECT t FROM TecnoConsec t WHERE t.consec = :consec"), @NamedQuery(name = "TecnoConsec.findByFechaConsec", query = "SELECT t FROM TecnoConsec t WHERE t.fechaConsec = :fechaConsec"), @NamedQuery(name = "TecnoConsec.findByNombreInstitucion", query = "SELECT t FROM TecnoConsec t WHERE t.nombreInstitucion = :nombreInstitucion"), @NamedQuery(name = "TecnoConsec.findByCdgModalidad", query = "SELECT t FROM TecnoConsec t WHERE t.cdgModalidad = :cdgModalidad"), @NamedQuery(name = "TecnoConsec.findByCaracter", query = "SELECT t FROM TecnoConsec t WHERE t.caracter = :caracter"), @NamedQuery(name = "TecnoConsec.findByComplejidad", query = "SELECT t FROM TecnoConsec t WHERE t.complejidad = :complejidad"), @NamedQuery(name = "TecnoConsec.findByNombreSolic", query = "SELECT t FROM TecnoConsec t WHERE t.nombreSolic = :nombreSolic"), @NamedQuery(name = "TecnoConsec.findByApellidosSolic", query = "SELECT t FROM TecnoConsec t WHERE t.apellidosSolic = :apellidosSolic"), @NamedQuery(name = "TecnoConsec.findByApelativo", query = "SELECT t FROM TecnoConsec t WHERE t.apelativo = :apelativo"), @NamedQuery(name = "TecnoConsec.findByCdgareaEmpresa", query = "SELECT t FROM TecnoConsec t WHERE t.cdgareaEmpresa = :cdgareaEmpresa"), @NamedQuery(name = "TecnoConsec.findByCargos", query = "SELECT t FROM TecnoConsec t WHERE t.cargos = :cargos"), @NamedQuery(name = "TecnoConsec.findByCdgProfesion", query = "SELECT t FROM TecnoConsec t WHERE t.cdgProfesion = :cdgProfesion"), @NamedQuery(name = "TecnoConsec.findByDireccion", query = "SELECT t FROM TecnoConsec t WHERE t.direccion = :direccion"), @NamedQuery(name = "TecnoConsec.findByTelefono", query = "SELECT t FROM TecnoConsec t WHERE t.telefono = :telefono"), @NamedQuery(name = "TecnoConsec.findByEmail", query = "SELECT t FROM TecnoConsec t WHERE t.email = :email"), @NamedQuery(name = "TecnoConsec.findByCodMun", query = "SELECT t FROM TecnoConsec t WHERE t.codMun = :codMun"), @NamedQuery(name = "TecnoConsec.findByCodDepart", query = "SELECT t FROM TecnoConsec t WHERE t.codDepart = :codDepart"), @NamedQuery(name = "TecnoConsec.findByProyecto", query = "SELECT t FROM TecnoConsec t WHERE t.proyecto = :proyecto"), @NamedQuery(name = "TecnoConsec.findByCdgFuncionario", query = "SELECT t FROM TecnoConsec t WHERE t.cdgFuncionario = :cdgFuncionario"), @NamedQuery(name = "TecnoConsec.findByEncargado", query = "SELECT t FROM TecnoConsec t WHERE t.encargado = :encargado")})
public class TecnoConsec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "consecutivo")
    private String consecutivo;
    @Column(name = "consec")
    private Long consec;
    @Column(name = "fecha_consec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaConsec;
    @Column(name = "nombre_institucion")
    private String nombreInstitucion;
    @Column(name = "cdg_modalidad")
    private Integer cdgModalidad;
    @Column(name = "caracter")
    private Character caracter;
    @Column(name = "complejidad")
    private String complejidad;
    @Column(name = "nombre_solic")
    private String nombreSolic;
    @Column(name = "apellidos_solic")
    private String apellidosSolic;
    @Column(name = "apelativo")
    private Character apelativo;
    @Column(name = "cdgarea_empresa")
    private Integer cdgareaEmpresa;
    @Column(name = "cargos")
    private String cargos;
    @Column(name = "cdg_profesion")
    private Integer cdgProfesion;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "cod_mun")
    private String codMun;
    @Column(name = "cod_depart")
    private String codDepart;
    @Basic(optional = false)
    @Column(name = "proyecto")
    private String proyecto;
    @Basic(optional = false)
    @Column(name = "cdg_funcionario")
    private int cdgFuncionario;
    @Column(name = "encargado")
    private String encargado;

    public TecnoConsec() {
    }

    public TecnoConsec(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public TecnoConsec(String consecutivo, String proyecto, int cdgFuncionario) {
        this.consecutivo = consecutivo;
        this.proyecto = proyecto;
        this.cdgFuncionario = cdgFuncionario;
    }

    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Long getConsec() {
        return consec;
    }

    public void setConsec(Long consec) {
        this.consec = consec;
    }

    public Date getFechaConsec() {
        return fechaConsec;
    }

    public void setFechaConsec(Date fechaConsec) {
        this.fechaConsec = fechaConsec;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public Integer getCdgModalidad() {
        return cdgModalidad;
    }

    public void setCdgModalidad(Integer cdgModalidad) {
        this.cdgModalidad = cdgModalidad;
    }

    public Character getCaracter() {
        return caracter;
    }

    public void setCaracter(Character caracter) {
        this.caracter = caracter;
    }

    public String getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(String complejidad) {
        this.complejidad = complejidad;
    }

    public String getNombreSolic() {
        return nombreSolic;
    }

    public void setNombreSolic(String nombreSolic) {
        this.nombreSolic = nombreSolic;
    }

    public String getApellidosSolic() {
        return apellidosSolic;
    }

    public void setApellidosSolic(String apellidosSolic) {
        this.apellidosSolic = apellidosSolic;
    }

    public Character getApelativo() {
        return apelativo;
    }

    public void setApelativo(Character apelativo) {
        this.apelativo = apelativo;
    }

    public Integer getCdgareaEmpresa() {
        return cdgareaEmpresa;
    }

    public void setCdgareaEmpresa(Integer cdgareaEmpresa) {
        this.cdgareaEmpresa = cdgareaEmpresa;
    }

    public String getCargos() {
        return cargos;
    }

    public void setCargos(String cargos) {
        this.cargos = cargos;
    }

    public Integer getCdgProfesion() {
        return cdgProfesion;
    }

    public void setCdgProfesion(Integer cdgProfesion) {
        this.cdgProfesion = cdgProfesion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodMun() {
        return codMun;
    }

    public void setCodMun(String codMun) {
        this.codMun = codMun;
    }

    public String getCodDepart() {
        return codDepart;
    }

    public void setCodDepart(String codDepart) {
        this.codDepart = codDepart;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public int getCdgFuncionario() {
        return cdgFuncionario;
    }

    public void setCdgFuncionario(int cdgFuncionario) {
        this.cdgFuncionario = cdgFuncionario;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
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
        if (!(object instanceof TecnoConsec)) {
            return false;
        }
        TecnoConsec other = (TecnoConsec) object;
        if ((this.consecutivo == null && other.consecutivo != null) || (this.consecutivo != null && !this.consecutivo.equals(other.consecutivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoConsec[consecutivo=" + consecutivo + "]";
    }

}
