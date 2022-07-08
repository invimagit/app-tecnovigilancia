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
@Table(name = "tecno_red")
@NamedQueries({@NamedQuery(name = "TecnoRed.findAll", query = "SELECT t FROM TecnoRed t"), @NamedQuery(name = "TecnoRed.findById", query = "SELECT t FROM TecnoRed t WHERE t.id = :id"), @NamedQuery(name = "TecnoRed.findByFechaSolicitud", query = "SELECT t FROM TecnoRed t WHERE t.fechaSolicitud = :fechaSolicitud"), @NamedQuery(name = "TecnoRed.findByNombreInstitucion", query = "SELECT t FROM TecnoRed t WHERE t.nombreInstitucion = :nombreInstitucion"), @NamedQuery(name = "TecnoRed.findByCdgModalidad", query = "SELECT t FROM TecnoRed t WHERE t.cdgModalidad = :cdgModalidad"), @NamedQuery(name = "TecnoRed.findByCaracter", query = "SELECT t FROM TecnoRed t WHERE t.caracter = :caracter"), @NamedQuery(name = "TecnoRed.findByNombreSolic", query = "SELECT t FROM TecnoRed t WHERE t.nombreSolic = :nombreSolic"), @NamedQuery(name = "TecnoRed.findByComplejidad", query = "SELECT t FROM TecnoRed t WHERE t.complejidad = :complejidad"), @NamedQuery(name = "TecnoRed.findByDireccionOrganizacion", query = "SELECT t FROM TecnoRed t WHERE t.direccionOrganizacion = :direccionOrganizacion"), @NamedQuery(name = "TecnoRed.findByNit", query = "SELECT t FROM TecnoRed t WHERE t.nit = :nit"), @NamedQuery(name = "TecnoRed.findByAreaEmpresa", query = "SELECT t FROM TecnoRed t WHERE t.areaEmpresa = :areaEmpresa"), @NamedQuery(name = "TecnoRed.findByCargos", query = "SELECT t FROM TecnoRed t WHERE t.cargos = :cargos"), @NamedQuery(name = "TecnoRed.findByCdgProfesion", query = "SELECT t FROM TecnoRed t WHERE t.cdgProfesion = :cdgProfesion"), @NamedQuery(name = "TecnoRed.findByDireccionSolicitante", query = "SELECT t FROM TecnoRed t WHERE t.direccionSolicitante = :direccionSolicitante"), @NamedQuery(name = "TecnoRed.findByTelefonoSolic", query = "SELECT t FROM TecnoRed t WHERE t.telefonoSolic = :telefonoSolic"), @NamedQuery(name = "TecnoRed.findByEmailPersonal", query = "SELECT t FROM TecnoRed t WHERE t.emailPersonal = :emailPersonal"), @NamedQuery(name = "TecnoRed.findByPaisSolic", query = "SELECT t FROM TecnoRed t WHERE t.paisSolic = :paisSolic"), @NamedQuery(name = "TecnoRed.findByCelularSolic", query = "SELECT t FROM TecnoRed t WHERE t.celularSolic = :celularSolic"), @NamedQuery(name = "TecnoRed.findByCodMun", query = "SELECT t FROM TecnoRed t WHERE t.codMun = :codMun"), @NamedQuery(name = "TecnoRed.findByCodDepart", query = "SELECT t FROM TecnoRed t WHERE t.codDepart = :codDepart"), @NamedQuery(name = "TecnoRed.findByEmailCorporativo", query = "SELECT t FROM TecnoRed t WHERE t.emailCorporativo = :emailCorporativo"), @NamedQuery(name = "TecnoRed.findByCdgFuncionario", query = "SELECT t FROM TecnoRed t WHERE t.cdgFuncionario = :cdgFuncionario"), @NamedQuery(name = "TecnoRed.findByCedulaSolicitante", query = "SELECT t FROM TecnoRed t WHERE t.cedulaSolicitante = :cedulaSolicitante"), @NamedQuery(name = "TecnoRed.findByTelefonoOrganiz", query = "SELECT t FROM TecnoRed t WHERE t.telefonoOrganiz = :telefonoOrganiz"), @NamedQuery(name = "TecnoRed.findByFaxOrganiz", query = "SELECT t FROM TecnoRed t WHERE t.faxOrganiz = :faxOrganiz"), @NamedQuery(name = "TecnoRed.findByPaisOrganiz", query = "SELECT t FROM TecnoRed t WHERE t.paisOrganiz = :paisOrganiz"), @NamedQuery(name = "TecnoRed.findByCodMun1", query = "SELECT t FROM TecnoRed t WHERE t.codMun1 = :codMun1"), @NamedQuery(name = "TecnoRed.findByCodDepart1", query = "SELECT t FROM TecnoRed t WHERE t.codDepart1 = :codDepart1")})
public class TecnoRed implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;
    @Column(name = "nombre_institucion")
    private String nombreInstitucion;
    @Column(name = "cdg_modalidad")
    private Integer cdgModalidad;
    @Column(name = "caracter")
    private Character caracter;
    @Column(name = "nombre_solic")
    private String nombreSolic;
    @Column(name = "complejidad")
    private String complejidad;
    @Column(name = "direccion_organizacion")
    private String direccionOrganizacion;
    @Column(name = "nit")
    private String nit;
    @Column(name = "area_empresa")
    private String areaEmpresa;
    @Column(name = "cargos")
    private String cargos;
    @Column(name = "cdg_profesion")
    private Integer cdgProfesion;
    @Column(name = "direccion_solicitante")
    private String direccionSolicitante;
    @Column(name = "telefono_solic")
    private String telefonoSolic;
    @Column(name = "email_personal")
    private String emailPersonal;
    @Column(name = "pais_solic")
    private String paisSolic;
    @Column(name = "celular_solic")
    private String celularSolic;
    @Column(name = "cod_mun")
    private String codMun;
    @Column(name = "cod_depart")
    private String codDepart;
    @Column(name = "email_corporativo")
    private String emailCorporativo;
    @Column(name = "cdg_funcionario")
    private long cdgFuncionario;
    @Column(name = "cedula_solicitante")
    private String cedulaSolicitante;
    @Column(name = "telefono_organiz")
    private String telefonoOrganiz;
    @Column(name = "fax_organiz")
    private String faxOrganiz;
    @Column(name = "pais_organiz")
    private String paisOrganiz;
    @Column(name = "cod_mun1")
    private String codMun1;
    @Column(name = "cod_depart1")
    private String codDepart1;

    public TecnoRed() {
    }

    public TecnoRed(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
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

    public String getNombreSolic() {
        return nombreSolic;
    }

    public void setNombreSolic(String nombreSolic) {
        this.nombreSolic = nombreSolic;
    }

    public String getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(String complejidad) {
        this.complejidad = complejidad;
    }

    public String getDireccionOrganizacion() {
        return direccionOrganizacion;
    }

    public void setDireccionOrganizacion(String direccionOrganizacion) {
        this.direccionOrganizacion = direccionOrganizacion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getAreaEmpresa() {
        return areaEmpresa;
    }

    public void setAreaEmpresa(String areaEmpresa) {
        this.areaEmpresa = areaEmpresa;
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

    public String getDireccionSolicitante() {
        return direccionSolicitante;
    }

    public void setDireccionSolicitante(String direccionSolicitante) {
        this.direccionSolicitante = direccionSolicitante;
    }

    public String getTelefonoSolic() {
        return telefonoSolic;
    }

    public void setTelefonoSolic(String telefonoSolic) {
        this.telefonoSolic = telefonoSolic;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getPaisSolic() {
        return paisSolic;
    }

    public void setPaisSolic(String paisSolic) {
        this.paisSolic = paisSolic;
    }

    public String getCelularSolic() {
        return celularSolic;
    }

    public void setCelularSolic(String celularSolic) {
        this.celularSolic = celularSolic;
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

    public String getEmailCorporativo() {
        return emailCorporativo;
    }

    public void setEmailCorporativo(String emailCorporativo) {
        this.emailCorporativo = emailCorporativo;
    }

    public long getCdgFuncionario() {
        return cdgFuncionario;
    }

    public void setCdgFuncionario(long cdgFuncionario) {
        this.cdgFuncionario = cdgFuncionario;
    }

    public String getCedulaSolicitante() {
        return cedulaSolicitante;
    }

    public void setCedulaSolicitante(String cedulaSolicitante) {
        this.cedulaSolicitante = cedulaSolicitante;
    }

    public String getTelefonoOrganiz() {
        return telefonoOrganiz;
    }

    public void setTelefonoOrganiz(String telefonoOrganiz) {
        this.telefonoOrganiz = telefonoOrganiz;
    }

    public String getFaxOrganiz() {
        return faxOrganiz;
    }

    public void setFaxOrganiz(String faxOrganiz) {
        this.faxOrganiz = faxOrganiz;
    }

    public String getPaisOrganiz() {
        return paisOrganiz;
    }

    public void setPaisOrganiz(String paisOrganiz) {
        this.paisOrganiz = paisOrganiz;
    }

    public String getCodMun1() {
        return codMun1;
    }

    public void setCodMun1(String codMun1) {
        this.codMun1 = codMun1;
    }

    public String getCodDepart1() {
        return codDepart1;
    }

    public void setCodDepart1(String codDepart1) {
        this.codDepart1 = codDepart1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoRed)) {
            return false;
        }
        TecnoRed other = (TecnoRed) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoRed[id=" + id + "]";
    }

}
