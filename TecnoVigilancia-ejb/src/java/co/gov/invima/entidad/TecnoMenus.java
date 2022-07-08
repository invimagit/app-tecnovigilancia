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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "tecno_menus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TecnoMenus.findAll", query = "SELECT t FROM TecnoMenus t"),
    @NamedQuery(name = "TecnoMenus.findByMostrarMenu", query = "SELECT t FROM TecnoMenus t WHERE t.mostrarMenu = :mostrarMenu"),
    @NamedQuery(name = "TecnoMenus.findBySolucionMenu", query = "SELECT t FROM TecnoMenus t WHERE t.solucionMenu = :solucionMenu"),
    @NamedQuery(name = "TecnoMenus.findByAccionMenu", query = "SELECT t FROM TecnoMenus t WHERE t.accionMenu = :accionMenu"),
    @NamedQuery(name = "TecnoMenus.findByDescripcionMenu", query = "SELECT t FROM TecnoMenus t WHERE t.descripcionMenu = :descripcionMenu"),
    @NamedQuery(name = "TecnoMenus.findByUrlMenu", query = "SELECT t FROM TecnoMenus t WHERE t.urlMenu = :urlMenu"),
    @NamedQuery(name = "TecnoMenus.findByPermitidoMenu", query = "SELECT t FROM TecnoMenus t WHERE t.permitidoMenu = :permitidoMenu"),
    @NamedQuery(name = "TecnoMenus.findByIdopcion", query = "SELECT t FROM TecnoMenus t WHERE t.idopcion = :idopcion")})
public class TecnoMenus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mostrar_menu")
    private Character mostrarMenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "solucion_menu")
    private Character solucionMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "accion_menu")
    private String accionMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion_menu")
    private String descripcionMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "url_menu")
    private String urlMenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "permitido_menu")
    private int permitidoMenu;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idopcion")
    private Integer idopcion;
    @JoinTable(name = "tecno_roles_menu", joinColumns = {
        @JoinColumn(name = "ID_OPCION_MENU", referencedColumnName = "idopcion")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_ROL", referencedColumnName = "IDROL")})
    @ManyToMany
    private List<TecnoRoles> tecnoRolesList;

    public TecnoMenus() {
    }

    public TecnoMenus(Integer idopcion) {
        this.idopcion = idopcion;
    }

    public TecnoMenus(Integer idopcion, Character mostrarMenu, Character solucionMenu, String accionMenu, String descripcionMenu, String urlMenu, int permitidoMenu) {
        this.idopcion = idopcion;
        this.mostrarMenu = mostrarMenu;
        this.solucionMenu = solucionMenu;
        this.accionMenu = accionMenu;
        this.descripcionMenu = descripcionMenu;
        this.urlMenu = urlMenu;
        this.permitidoMenu = permitidoMenu;
    }

    public Character getMostrarMenu() {
        return mostrarMenu;
    }

    public void setMostrarMenu(Character mostrarMenu) {
        this.mostrarMenu = mostrarMenu;
    }

    public Character getSolucionMenu() {
        return solucionMenu;
    }

    public void setSolucionMenu(Character solucionMenu) {
        this.solucionMenu = solucionMenu;
    }

    public String getAccionMenu() {
        return accionMenu;
    }

    public void setAccionMenu(String accionMenu) {
        this.accionMenu = accionMenu;
    }

    public String getDescripcionMenu() {
        return descripcionMenu;
    }

    public void setDescripcionMenu(String descripcionMenu) {
        this.descripcionMenu = descripcionMenu;
    }

    public String getUrlMenu() {
        return urlMenu;
    }

    public void setUrlMenu(String urlMenu) {
        this.urlMenu = urlMenu;
    }

    public int getPermitidoMenu() {
        return permitidoMenu;
    }

    public void setPermitidoMenu(int permitidoMenu) {
        this.permitidoMenu = permitidoMenu;
    }

    public Integer getIdopcion() {
        return idopcion;
    }

    public void setIdopcion(Integer idopcion) {
        this.idopcion = idopcion;
    }

    @XmlTransient
    public List<TecnoRoles> getTecnoRolesList() {
        return tecnoRolesList;
    }

    public void setTecnoRolesList(List<TecnoRoles> tecnoRolesList) {
        this.tecnoRolesList = tecnoRolesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idopcion != null ? idopcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoMenus)) {
            return false;
        }
        TecnoMenus other = (TecnoMenus) object;
        if ((this.idopcion == null && other.idopcion != null) || (this.idopcion != null && !this.idopcion.equals(other.idopcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoMenus[ idopcion=" + idopcion + " ]";
    }
    
}
