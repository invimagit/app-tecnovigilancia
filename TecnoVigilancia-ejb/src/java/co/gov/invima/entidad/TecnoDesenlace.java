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
@Table(name = "tecno_desenlace")
@NamedQueries({@NamedQuery(name = "TecnoDesenlace.findAll", query = "SELECT t FROM TecnoDesenlace t"), @NamedQuery(name = "TecnoDesenlace.findByCdgDesenlace", query = "SELECT t FROM TecnoDesenlace t WHERE t.cdgDesenlace = :cdgDesenlace"), @NamedQuery(name = "TecnoDesenlace.findByDescripcion", query = "SELECT t FROM TecnoDesenlace t WHERE t.descripcion = :descripcion")})
public class TecnoDesenlace implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cdg_desenlace")
    private Integer cdgDesenlace;
    @Column(name = "descripcion")
    private String descripcion;

    public TecnoDesenlace() {
    }

    public TecnoDesenlace(Integer cdgDesenlace) {
        this.cdgDesenlace = cdgDesenlace;
    }

    public Integer getCdgDesenlace() {
        return cdgDesenlace;
    }

    public void setCdgDesenlace(Integer cdgDesenlace) {
        this.cdgDesenlace = cdgDesenlace;
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
        hash += (cdgDesenlace != null ? cdgDesenlace.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoDesenlace)) {
            return false;
        }
        TecnoDesenlace other = (TecnoDesenlace) object;
        if ((this.cdgDesenlace == null && other.cdgDesenlace != null) || (this.cdgDesenlace != null && !this.cdgDesenlace.equals(other.cdgDesenlace))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoDesenlace[cdgDesenlace=" + cdgDesenlace + "]";
    }

}
