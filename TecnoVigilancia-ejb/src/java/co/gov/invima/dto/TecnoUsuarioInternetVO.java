/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.dto;

import java.util.Date;

/**
 *
 * @author Administrador
 */
public class TecnoUsuarioInternetVO {
    private String tipoIdentificacionEmpresa="";
    private String identificacionEmpresa="";
    private String nombreEmpresa="";
    private String PaisEmpresa="";
    private String departamentoEmpresa="";
    private String ciudadEmpresa="";
    private String direccionEmpresa="";
    private String telefonoEmpresa="";
    private String faxEmpresa="";
    private String correoEmpresa="";
    private String urlEmpresa="";
    private String tipoIdentificacionUsuario="";
    private String identificacionUsuario="";
    private String nombreUsuario="";
    private String cargoUsuario="";
    private String telefonoUsuario="";
    private String correoUsuario="";
    private String usuario="";
    private String password="";
    private String pregunta="";
    private String respuesta="";
    private boolean  activo;
    private Integer ID_Rol_Usuario;
    private Date fecha_ingreso;
    private Integer   estado_usuario;
    private String clasificacion_usuario;

    /**
     * @return the tipoIdentificacionEmpresa
     */
    public String getTipoIdentificacionEmpresa() {
        return tipoIdentificacionEmpresa;
    }

    /**
     * @param tipoIdentificacionEmpresa the tipoIdentificacionEmpresa to set
     */
    public void setTipoIdentificacionEmpresa(String tipoIdentificacionEmpresa) {
        this.tipoIdentificacionEmpresa = tipoIdentificacionEmpresa;
    }

    /**
     * @return the identificacionEmpresa
     */
    public String getIdentificacionEmpresa() {
        return identificacionEmpresa;
    }

    /**
     * @param identificacionEmpresa the identificacionEmpresa to set
     */
    public void setIdentificacionEmpresa(String identificacionEmpresa) {
        this.identificacionEmpresa = identificacionEmpresa;
    }

    /**
     * @return the nombreEmpresa
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * @param nombreEmpresa the nombreEmpresa to set
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     * @return the PaisEmpresa
     */
    public String getPaisEmpresa() {
        return PaisEmpresa;
    }

    /**
     * @param PaisEmpresa the PaisEmpresa to set
     */
    public void setPaisEmpresa(String PaisEmpresa) {
        this.PaisEmpresa = PaisEmpresa;
    }

    /**
     * @return the departamentoEmpresa
     */
    public String getDepartamentoEmpresa() {
        return departamentoEmpresa;
    }

    /**
     * @param departamentoEmpresa the departamentoEmpresa to set
     */
    public void setDepartamentoEmpresa(String departamentoEmpresa) {
        this.departamentoEmpresa = departamentoEmpresa;
    }

    /**
     * @return the ciudadEmpresa
     */
    public String getCiudadEmpresa() {
        return ciudadEmpresa;
    }

    /**
     * @param ciudadEmpresa the ciudadEmpresa to set
     */
    public void setCiudadEmpresa(String ciudadEmpresa) {
        this.ciudadEmpresa = ciudadEmpresa;
    }

    /**
     * @return the direccionEmpresa
     */
    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    /**
     * @param direccionEmpresa the direccionEmpresa to set
     */
    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    /**
     * @return the telefonoEmpresa
     */
    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    /**
     * @param telefonoEmpresa the telefonoEmpresa to set
     */
    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    /**
     * @return the faxEmpresa
     */
    public String getFaxEmpresa() {
        return faxEmpresa;
    }

    /**
     * @param faxEmpresa the faxEmpresa to set
     */
    public void setFaxEmpresa(String faxEmpresa) {
        this.faxEmpresa = faxEmpresa;
    }

    /**
     * @return the correoEmpresa
     */
    public String getCorreoEmpresa() {
        return correoEmpresa;
    }

    /**
     * @param correoEmpresa the correoEmpresa to set
     */
    public void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
    }

    /**
     * @return the urlEmpresa
     */
    public String getUrlEmpresa() {
        return urlEmpresa;
    }

    /**
     * @param urlEmpresa the urlEmpresa to set
     */
    public void setUrlEmpresa(String urlEmpresa) {
        this.urlEmpresa = urlEmpresa;
    }

    /**
     * @return the tipoIdentificacionUsuario
     */
    public String getTipoIdentificacionUsuario() {
        return tipoIdentificacionUsuario;
    }

    /**
     * @param tipoIdentificacionUsuario the tipoIdentificacionUsuario to set
     */
    public void setTipoIdentificacionUsuario(String tipoIdentificacionUsuario) {
        this.tipoIdentificacionUsuario = tipoIdentificacionUsuario;
    }

    /**
     * @return the identificacionUsuario
     */
    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    /**
     * @param identificacionUsuario the identificacionUsuario to set
     */
    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the cargoUsuario
     */
    public String getCargoUsuario() {
        return cargoUsuario;
    }

    /**
     * @param cargoUsuario the cargoUsuario to set
     */
    public void setCargoUsuario(String cargoUsuario) {
        this.cargoUsuario = cargoUsuario;
    }

    /**
     * @return the telefonoUsuario
     */
    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    /**
     * @param telefonoUsuario the telefonoUsuario to set
     */
    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    /**
     * @return the correoUsuario
     */
    public String getCorreoUsuario() {
        return correoUsuario;
    }

    /**
     * @param correoUsuario the correoUsuario to set
     */
    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the pregunta
     */
    public String getPregunta() {
        return pregunta;
    }

    /**
     * @param pregunta the pregunta to set
     */
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    /**
     * @return the respuesta
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * @return the ID_Rol_Usuario
     */
    public Integer getID_Rol_Usuario() {
        return ID_Rol_Usuario;
    }

    /**
     * @param ID_Rol_Usuario the ID_Rol_Usuario to set
     */
    public void setID_Rol_Usuario(Integer ID_Rol_Usuario) {
        this.ID_Rol_Usuario = ID_Rol_Usuario;
    }

    /**
     * @return the fecha_ingreso
     */
    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    /**
     * @param fecha_ingreso the fecha_ingreso to set
     */
    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    /**
     * @return the estado_usuario
     */
    public Integer getEstado_usuario() {
        return estado_usuario;
    }

    /**
     * @param estado_usuario the estado_usuario to set
     */
    public void setEstado_usuario(Integer estado_usuario) {
        this.estado_usuario = estado_usuario;
    }

    /**
     * @return the clasificacion_usuario
     */
    public String getClasificacion_usuario() {
        return clasificacion_usuario;
    }

    /**
     * @param clasificacion_usuario the clasificacion_usuario to set
     */
    public void setClasificacion_usuario(String clasificacion_usuario) {
        this.clasificacion_usuario = clasificacion_usuario;
    }
    
    

}
