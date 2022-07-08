/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mgualdrond
 */
@Entity
@Table(name = "tecno_usuarios_internet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TecnoUsuariosInternet.findAll", query = "SELECT t FROM TecnoUsuariosInternet t"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByIdentificacionEmpresa", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.identificacionEmpresa = :identificacionEmpresa"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByTipidentificacionEmpresa", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.tipidentificacionEmpresa = :tipidentificacionEmpresa"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByNombreEmpresa", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.nombreEmpresa = :nombreEmpresa"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByDireccionEmpresa", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.direccionEmpresa = :direccionEmpresa"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByCdgPais", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.cdgPais = :cdgPais"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByCodDepart", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.codDepart = :codDepart"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByCodMun", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.codMun = :codMun"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByTelefonoEmpresa", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.telefonoEmpresa = :telefonoEmpresa"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByEmailEmpresa", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.emailEmpresa = :emailEmpresa"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByFax", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.fax = :fax"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByUrl", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.url = :url"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByIdentificacionPersona", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.identificacionPersona = :identificacionPersona"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByTipidentificacionPersona", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.tipidentificacionPersona = :tipidentificacionPersona"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByNombrePersona", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.nombrePersona = :nombrePersona"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByCargoPersona", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.cargoPersona = :cargoPersona"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByTelefonoPersona", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.telefonoPersona = :telefonoPersona"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByEmailPersona", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.emailPersona = :emailPersona"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByUsuario", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByActivo", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.activo = :activo"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByIDRolUsuario", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.iDRolUsuario = :iDRolUsuario"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByPregunta", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.pregunta = :pregunta"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByRespuesta", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.respuesta = :respuesta"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByFechaIngreso", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByPassword", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.password = :password"),
    @NamedQuery(name = "TecnoUsuariosInternet.findBySession", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.session = :session"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByEstadoUsuario", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.estadoUsuario = :estadoUsuario"),
    @NamedQuery(name = "TecnoUsuariosInternet.findByClasificacionUsuario", query = "SELECT t FROM TecnoUsuariosInternet t WHERE t.clasificacionUsuario = :clasificacionUsuario")})
public class TecnoUsuariosInternet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "identificacion_empresa")
    private long identificacionEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipidentificacion_empresa")
    private String tipidentificacionEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "direccion_empresa")
    private String direccionEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cdg_pais")
    private String cdgPais;
    @Size(max = 2)
    @Column(name = "cod_depart")
    private String codDepart;
    @Size(max = 5)
    @Column(name = "cod_mun")
    private String codMun;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "telefono_empresa")
    private String telefonoEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "email_empresa")
    private String emailEmpresa;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "fax")
    private String fax;
    @Size(max = 100)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Column(name = "identificacion_persona")
    private long identificacionPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipidentificacion_persona")
    private String tipidentificacionPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "nombre_persona")
    private String nombrePersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "cargo_persona")
    private String cargoPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "telefono_persona")
    private String telefonoPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "email_persona")
    private String emailPersona;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private short activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Rol_Usuario")
    private int iDRolUsuario;
    @Size(max = 100)
    @Column(name = "pregunta")
    private String pregunta;
    @Size(max = 100)
    @Column(name = "respuesta")
    private String respuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @Size(max = 64)
    @Column(name = "session")
    private String session;
    @Column(name = "estado_usuario")
    private Character estadoUsuario;
    @Size(max = 31)
    @Column(name = "clasificacion_usuario")
    private String clasificacionUsuario;

    public TecnoUsuariosInternet() {
    }

    public TecnoUsuariosInternet(String usuario) {
        this.usuario = usuario;
    }

    public TecnoUsuariosInternet(String usuario, long identificacionEmpresa, String tipidentificacionEmpresa, String nombreEmpresa, String direccionEmpresa, String cdgPais, String telefonoEmpresa, String emailEmpresa, String fax, long identificacionPersona, String tipidentificacionPersona, String nombrePersona, String cargoPersona, String telefonoPersona, String emailPersona, short activo, int iDRolUsuario, Date fechaIngreso, String password) {
        this.usuario = usuario;
        this.identificacionEmpresa = identificacionEmpresa;
        this.tipidentificacionEmpresa = tipidentificacionEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.cdgPais = cdgPais;
        this.telefonoEmpresa = telefonoEmpresa;
        this.emailEmpresa = emailEmpresa;
        this.fax = fax;
        this.identificacionPersona = identificacionPersona;
        this.tipidentificacionPersona = tipidentificacionPersona;
        this.nombrePersona = nombrePersona;
        this.cargoPersona = cargoPersona;
        this.telefonoPersona = telefonoPersona;
        this.emailPersona = emailPersona;
        this.activo = activo;
        this.iDRolUsuario = iDRolUsuario;
        this.fechaIngreso = fechaIngreso;
        this.password = password;
    }
    
    public int getCdgfuncionario(){
        int retorno = -1;
        try{
            try{
                retorno =  Integer.parseInt(identificacionPersona+"");
            }
            catch(Exception e){
                String temp = identificacionPersona+"";
                retorno =  Integer.parseInt(temp.substring(0, 8).trim());
            }
        }
        catch(Exception e2){     }
        return retorno;
    }

    public long getIdentificacionEmpresa() {
        return identificacionEmpresa;
    }

    public void setIdentificacionEmpresa(long identificacionEmpresa) {
        this.identificacionEmpresa = identificacionEmpresa;
    }

    public String getTipidentificacionEmpresa() {
        return tipidentificacionEmpresa;
    }

    public void setTipidentificacionEmpresa(String tipidentificacionEmpresa) {
        this.tipidentificacionEmpresa = tipidentificacionEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getCdgPais() {
        return cdgPais;
    }

    public void setCdgPais(String cdgPais) {
        this.cdgPais = cdgPais;
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

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getIdentificacionPersona() {
        return identificacionPersona;
    }

    public void setIdentificacionPersona(long identificacionPersona) {
        this.identificacionPersona = identificacionPersona;
    }

    public String getTipidentificacionPersona() {
        return tipidentificacionPersona;
    }

    public void setTipidentificacionPersona(String tipidentificacionPersona) {
        this.tipidentificacionPersona = tipidentificacionPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getCargoPersona() {
        return cargoPersona;
    }

    public void setCargoPersona(String cargoPersona) {
        this.cargoPersona = cargoPersona;
    }

    public String getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public String getEmailPersona() {
        return emailPersona;
    }

    public void setEmailPersona(String emailPersona) {
        this.emailPersona = emailPersona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    public int getIDRolUsuario() {
        return iDRolUsuario;
    }

    public void setIDRolUsuario(int iDRolUsuario) {
        this.iDRolUsuario = iDRolUsuario;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Character getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Character estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getClasificacionUsuario() {
        return clasificacionUsuario;
    }

    public void setClasificacionUsuario(String clasificacionUsuario) {
        this.clasificacionUsuario = clasificacionUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoUsuariosInternet)) {
            return false;
        }
        TecnoUsuariosInternet other = (TecnoUsuariosInternet) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoUsuariosInternet[ usuario=" + usuario + " ]";
    }
    
}
