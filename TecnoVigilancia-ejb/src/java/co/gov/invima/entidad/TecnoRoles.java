/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mgualdrond
 */
@Entity
@Table(name = "tecno_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TecnoRoles.findAll", query = "SELECT t FROM TecnoRoles t"),
    @NamedQuery(name = "TecnoRoles.findByIdrol", query = "SELECT t FROM TecnoRoles t WHERE t.idrol = :idrol"),
    @NamedQuery(name = "TecnoRoles.findByNombreRol", query = "SELECT t FROM TecnoRoles t WHERE t.nombreRol = :nombreRol")})
public class TecnoRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDROL")
    private Integer idrol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_rol")
    private String nombreRol;
    @ManyToMany(mappedBy = "tecnoRolesList")
    private List<TecnoMenus> tecnoMenusList;

    public TecnoRoles() {
    }

    public TecnoRoles(Integer idrol) {
        this.idrol = idrol;
    }

    public TecnoRoles(Integer idrol, String nombreRol) {
        this.idrol = idrol;
        this.nombreRol = nombreRol;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @XmlTransient
    public List<TecnoMenus> getTecnoMenusList() {
        return tecnoMenusList;
    }

    public void setTecnoMenusList(List<TecnoMenus> tecnoMenusList) {
        this.tecnoMenusList = tecnoMenusList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrol != null ? idrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoRoles)) {
            return false;
        }
        TecnoRoles other = (TecnoRoles) object;
        if ((this.idrol == null && other.idrol != null) || (this.idrol != null && !this.idrol.equals(other.idrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoRoles[ idrol=" + idrol + " ]";
    }
    
}
