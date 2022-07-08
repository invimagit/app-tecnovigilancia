package co.gov.invima.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "px_w_persona_roles_tecno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TecnoRolesReporte.findAll", query = "SELECT t FROM TecnoRolesReporte t")
    , @NamedQuery(name = "TecnoRolesReporte.findByNroexpediente", query = "SELECT t FROM TecnoRolesReporte t WHERE t.nroexpediente = :nroexpediente and t.cdgrol2 in (2,3)")
    , @NamedQuery(name = "TecnoRolesReporte.findByCdgrol1", query = "SELECT t FROM TecnoRolesReporte t WHERE t.cdgrol1 = :cdgrol1")
    , @NamedQuery(name = "TecnoRolesReporte.findByNombre1", query = "SELECT t FROM TecnoRolesReporte t WHERE t.nombre1 = :nombre1")
    , @NamedQuery(name = "TecnoRolesReporte.findByPais1", query = "SELECT t FROM TecnoRolesReporte t WHERE t.pais1 = :pais1")
    , @NamedQuery(name = "TecnoRolesReporte.findByCiudad1", query = "SELECT t FROM TecnoRolesReporte t WHERE t.ciudad1 = :ciudad1")
    , @NamedQuery(name = "TecnoRolesReporte.findByDireccion1", query = "SELECT t FROM TecnoRolesReporte t WHERE t.direccion1 = :direccion1")
    , @NamedQuery(name = "TecnoRolesReporte.findByCdgrol2", query = "SELECT t FROM TecnoRolesReporte t WHERE t.cdgrol2 = :cdgrol2")
    , @NamedQuery(name = "TecnoRolesReporte.findByPais2", query = "SELECT t FROM TecnoRolesReporte t WHERE t.pais2 = :pais2")
    , @NamedQuery(name = "TecnoRolesReporte.findByCiudad2", query = "SELECT t FROM TecnoRolesReporte t WHERE t.ciudad2 = :ciudad2")
    , @NamedQuery(name = "TecnoRolesReporte.findByDireccion2", query = "SELECT t FROM TecnoRolesReporte t WHERE t.direccion2 = :direccion2")
})
public class TecnoRolesReporte implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "nroexpediente")
    private long nroexpediente;
    @Column(name = "cdgrol1")
    private Integer cdgrol1;
    @Size(max = 128)
    @Column(name = "nombretitular")
    private String nombre1;
    @Size(max = 128)
    @Column(name = "paistitular")
    private String pais1;
    @Size(max = 128)
    @Column(name = "ciudadtitular")
    private String ciudad1;
    @Size(max = 128)
    @Column(name = "direcciontitular")
    private String direccion1;
    @Column(name = "cdgrol")
    private Integer cdgrol2;
    @Size(max = 128)
    @Column(name = "pais")
    private String pais2;
    @Size(max = 128)
    @Column(name = "ciudad")
    private String ciudad2;
    @Size(max = 128)
    @Column(name = "direccion")
    private String direccion2;
    @Id
    @Column(name = "nombre")
    private String nombre;

    public TecnoRolesReporte() {
    }

    public long getNroexpediente() {
        return nroexpediente;
    }

    public void setNroexpediente(long nroexpediente) {
        this.nroexpediente = nroexpediente;
    }

    public Integer getCdgrol1() {
        return cdgrol1;
    }

    public void setCdgrol1(Integer cdgrol1) {
        this.cdgrol1 = cdgrol1;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getPais1() {
        return pais1;
    }

    public void setPais1(String pais1) {
        this.pais1 = pais1;
    }

    public String getCiudad1() {
        return ciudad1;
    }

    public void setCiudad1(String ciudad1) {
        this.ciudad1 = ciudad1;
    }

    public String getDireccion1() {
        return direccion1;
    }

    public void setDireccion1(String direccion1) {
        this.direccion1 = direccion1;
    }

    public Integer getCdgrol2() {
        return cdgrol2;
    }

    public void setCdgrol2(Integer cdgrol2) {
        this.cdgrol2 = cdgrol2;
    }

    public String getPais2() {
        return pais2;
    }

    public void setPais2(String pais2) {
        this.pais2 = pais2;
    }

    public String getCiudad2() {
        return ciudad2;
    }

    public void setCiudad2(String ciudad2) {
        this.ciudad2 = ciudad2;
    }

    public String getDireccion2() {
        return direccion2;
    }

    public void setDireccion2(String direccion2) {
        this.direccion2 = direccion2;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   
}
