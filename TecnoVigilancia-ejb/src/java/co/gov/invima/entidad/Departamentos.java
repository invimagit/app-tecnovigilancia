/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Diana Silva
 */
@Entity
@Table(name = "departamentos")
@NamedQueries({@NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d"), @NamedQuery(name = "Departamentos.findByCodDepart", query = "SELECT d FROM Departamentos d WHERE d.codDepart = :codDepart"), @NamedQuery(name = "Departamentos.findByDescripcion", query = "SELECT d FROM Departamentos d WHERE d.descripcion = :descripcion"), @NamedQuery(name = "Departamentos.findByCdgTerritorio", query = "SELECT d FROM Departamentos d WHERE d.cdgTerritorio = :cdgTerritorio"), @NamedQuery(name = "Departamentos.findByIso31662", query = "SELECT d FROM Departamentos d WHERE d.iso31662 = :iso31662")})
public class Departamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_depart")
    private String codDepart;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cdg_territorio")
    private String cdgTerritorio;
    @Column(name = "iso31662")
    private String iso31662;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDepart")
    private Collection<Municipios> municipiosCollection;

    public Departamentos() {
    }

    public Departamentos(String codDepart) {
        this.codDepart = codDepart;
    }

    public Departamentos(String codDepart, String descripcion) {
        this.codDepart = codDepart;
        this.descripcion = descripcion;
    }

    public String getCodDepart() {
        return codDepart;
    }

    public void setCodDepart(String codDepart) {
        this.codDepart = codDepart;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCdgTerritorio() {
        return cdgTerritorio;
    }

    public void setCdgTerritorio(String cdgTerritorio) {
        this.cdgTerritorio = cdgTerritorio;
    }

    public String getIso31662() {
        return iso31662;
    }

    public void setIso31662(String iso31662) {
        this.iso31662 = iso31662;
    }

    public Collection<Municipios> getMunicipiosCollection() {
        return municipiosCollection;
    }

    public void setMunicipiosCollection(Collection<Municipios> municipiosCollection) {
        this.municipiosCollection = municipiosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDepart != null ? codDepart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.codDepart == null && other.codDepart != null) || (this.codDepart != null && !this.codDepart.equals(other.codDepart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.Departamentos[codDepart=" + codDepart + "]";
    }

}
