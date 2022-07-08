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
@Table(name = "tecno_tipoalertas")
@NamedQueries({@NamedQuery(name = "TecnoTipoalertas.findAll", query = "SELECT t FROM TecnoTipoalertas t"), @NamedQuery(name = "TecnoTipoalertas.findByCdgTipoalertas", query = "SELECT t FROM TecnoTipoalertas t WHERE t.cdgTipoalertas = :cdgTipoalertas"), @NamedQuery(name = "TecnoTipoalertas.findByDescripcion", query = "SELECT t FROM TecnoTipoalertas t WHERE t.descripcion = :descripcion")})
public class TecnoTipoalertas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cdg_tipoalertas")
    private Character cdgTipoalertas;
    @Column(name = "descripcion")
    private String descripcion;

    public TecnoTipoalertas() {
    }

    public TecnoTipoalertas(Character cdgTipoalertas) {
        this.cdgTipoalertas = cdgTipoalertas;
    }

    public Character getCdgTipoalertas() {
        return cdgTipoalertas;
    }

    public void setCdgTipoalertas(Character cdgTipoalertas) {
        this.cdgTipoalertas = cdgTipoalertas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdgTipoalertas != null ? cdgTipoalertas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoTipoalertas)) {
            return false;
        }
        TecnoTipoalertas other = (TecnoTipoalertas) object;
        if ((this.cdgTipoalertas == null && other.cdgTipoalertas != null) || (this.cdgTipoalertas != null && !this.cdgTipoalertas.equals(other.cdgTipoalertas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoTipoalertas[cdgTipoalertas=" + cdgTipoalertas + "]";
    }

}
