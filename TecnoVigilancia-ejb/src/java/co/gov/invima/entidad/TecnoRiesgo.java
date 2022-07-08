/*
 * To change this template, choose Tools | Templates
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

/**
 *
 * @author Diana Silva
 */
@Entity
@Table(name = "tecno_riesgo")
@NamedQueries({@NamedQuery(name = "TecnoRiesgo.findAll", query = "SELECT t FROM TecnoRiesgo t"), @NamedQuery(name = "TecnoRiesgo.findByCdgRiesgo", query = "SELECT t FROM TecnoRiesgo t WHERE t.cdgRiesgo = :cdgRiesgo"), @NamedQuery(name = "TecnoRiesgo.findByDescripcion", query = "SELECT t FROM TecnoRiesgo t WHERE t.descripcion = :descripcion"), @NamedQuery(name = "TecnoRiesgo.findByPeso", query = "SELECT t FROM TecnoRiesgo t WHERE t.peso = :peso")})
public class TecnoRiesgo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cdg_riesgo")
    private Integer cdgRiesgo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "peso")
    private Integer peso;

    public TecnoRiesgo() {
    }

    public TecnoRiesgo(Integer cdgRiesgo) {
        this.cdgRiesgo = cdgRiesgo;
    }

    public Integer getCdgRiesgo() {
        return cdgRiesgo;
    }

    public void setCdgRiesgo(Integer cdgRiesgo) {
        this.cdgRiesgo = cdgRiesgo;
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
        hash += (cdgRiesgo != null ? cdgRiesgo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoRiesgo)) {
            return false;
        }
        TecnoRiesgo other = (TecnoRiesgo) object;
        if ((this.cdgRiesgo == null && other.cdgRiesgo != null) || (this.cdgRiesgo != null && !this.cdgRiesgo.equals(other.cdgRiesgo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoRiesgo[cdgRiesgo=" + cdgRiesgo + "]";
    }

}
