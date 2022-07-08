
package co.gov.invima.dto;

import java.util.Date;

/**
 * Clase que mapea los datos del formulario de Inscripcion en la red de 
 * tecnovigilancia
 * @author GRUPO ASD
 */
public class InscripcionRedVO {
    private int  id;
    private Date fechaSolicitud;
    private String nombreInstitucion;
    private int cdgModalidad;
    private Character caracter;
    private String nombreSolic;
    private String complejidad;
    private String direccionOrganizacion;
    private String nit;
    private String areaEmpresa; 
    private String cargos;
    private int cdgProfesion;
    private String direccionSolicitante;
    private String telefonoSolic;
    private String emailPersonal;
    private String paisSolic;
    private String celularSolic;
    private String codMun;
    private String codDepart;
    private String emailCorporativo;
    private long cdgFuncionario;
    private String cedulaSolicitante;
    private String telefonoOrganiz;
    private String faxOrganiz;
    private String paisOrganiz;
    private String codMun1;
    private String codDepart1;

    public String getAreaEmpresa() {
        return areaEmpresa;
    }

    public void setAreaEmpresa(String areaEmpresa) {
        this.areaEmpresa = areaEmpresa;
    }

    public Character getCaracter() {
        return caracter;
    }

    public void setCaracter(Character caracter) {
        this.caracter = caracter;
    }

    public String getCargos() {
        return cargos;
    }

    public void setCargos(String cargos) {
        this.cargos = cargos;
    }

    public long getCdgFuncionario() {
        return cdgFuncionario;
    }

    public void setCdgFuncionario(long cdgFuncionario) {
        this.cdgFuncionario = cdgFuncionario;
    }

    public int getCdgModalidad() {
        return cdgModalidad;
    }

    public void setCdgModalidad(int cdgModalidad) {
        this.cdgModalidad = cdgModalidad;
    }

    public int getCdgProfesion() {
        return cdgProfesion;
    }

    public void setCdgProfesion(int cdgProfesion) {
        this.cdgProfesion = cdgProfesion;
    }

    public String getCedulaSolicitante() {
        return cedulaSolicitante;
    }

    public void setCedulaSolicitante(String cedulaSolicitante) {
        this.cedulaSolicitante = cedulaSolicitante;
    }

    public String getCelularSolic() {
        return celularSolic;
    }

    public void setCelularSolic(String celularSolic) {
        this.celularSolic = celularSolic;
    }

    public String getCodDepart() {
        return codDepart;
    }

    public void setCodDepart(String codDepart) {
        this.codDepart = codDepart;
    }

    public String getCodDepart1() {
        return codDepart1;
    }

    public void setCodDepart1(String codDepart1) {
        this.codDepart1 = codDepart1;
    }

    public String getCodMun() {
        return codMun;
    }

    public void setCodMun(String codMun) {
        this.codMun = codMun;
    }

    public String getCodMun1() {
        return codMun1;
    }

    public void setCodMun1(String codMun1) {
        this.codMun1 = codMun1;
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

    public String getDireccionSolicitante() {
        return direccionSolicitante;
    }

    public void setDireccionSolicitante(String direccionSolicitante) {
        this.direccionSolicitante = direccionSolicitante;
    }

    public String getEmailCorporativo() {
        return emailCorporativo;
    }

    public void setEmailCorporativo(String emailCorporativo) {
        this.emailCorporativo = emailCorporativo;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getFaxOrganiz() {
        return faxOrganiz;
    }

    public void setFaxOrganiz(String faxOrganiz) {
        this.faxOrganiz = faxOrganiz;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getNombreSolic() {
        return nombreSolic;
    }

    public void setNombreSolic(String nombreSolic) {
        this.nombreSolic = nombreSolic;
    }

    public String getPaisOrganiz() {
        return paisOrganiz;
    }

    public void setPaisOrganiz(String paisOrganiz) {
        this.paisOrganiz = paisOrganiz;
    }

    public String getPaisSolic() {
        return paisSolic;
    }

    public void setPaisSolic(String paisSolic) {
        this.paisSolic = paisSolic;
    }

    public String getTelefonoOrganiz() {
        return telefonoOrganiz;
    }

    public void setTelefonoOrganiz(String telefonoOrganiz) {
        this.telefonoOrganiz = telefonoOrganiz;
    }

    public String getTelefonoSolic() {
        return telefonoSolic;
    }

    public void setTelefonoSolic(String telefonoSolic) {
        this.telefonoSolic = telefonoSolic;
    }
    
    
    
}
