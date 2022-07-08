/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author mgualdrond
 */
@Entity
@Table(name = "tecno_areas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TecnoAreas.findAll", query = "SELECT t FROM TecnoAreas t"),
    @NamedQuery(name = "TecnoAreas.findByCdgAreas", query = "SELECT t FROM TecnoAreas t WHERE t.cdgAreas = :cdgAreas"),
    @NamedQuery(name = "TecnoAreas.findByDescripcion", query = "SELECT t FROM TecnoAreas t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TecnoAreas.findByPeso", query = "SELECT t FROM TecnoAreas t WHERE t.peso = :peso")})
public class TecnoAreas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cdg_areas")
    private Integer cdgAreas;
    @Size(max = 128)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "peso")
    private Integer peso;

    public TecnoAreas() {
    }

    public TecnoAreas(Integer cdgAreas) {
        this.cdgAreas = cdgAreas;
    }

    public Integer getCdgAreas() {
        return cdgAreas;
    }

    public void setCdgAreas(Integer cdgAreas) {
        this.cdgAreas = cdgAreas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdgAreas != null ? cdgAreas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoAreas)) {
            return false;
        }
        TecnoAreas other = (TecnoAreas) object;
        if ((this.cdgAreas == null && other.cdgAreas != null) || (this.cdgAreas != null && !this.cdgAreas.equals(other.cdgAreas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoAreas[ cdgAreas=" + cdgAreas + " ]";
    }
    
}
