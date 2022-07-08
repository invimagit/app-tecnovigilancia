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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Diana Silva
 */
@Entity
@Table(name = "tecno_causa_probable")
@NamedQueries({@NamedQuery(name = "TecnoCausaProbable.findAll", query = "SELECT t FROM TecnoCausaProbable t"), @NamedQuery(name = "TecnoCausaProbable.findByCdgCausa", query = "SELECT t FROM TecnoCausaProbable t WHERE t.cdgCausa = :cdgCausa"), @NamedQuery(name = "TecnoCausaProbable.findByTerminoEa", query = "SELECT t FROM TecnoCausaProbable t WHERE t.terminoEa = :terminoEa")})
public class TecnoCausaProbable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cdg_causa")
    private Integer cdgCausa;
    @Column(name = "termino_ea")
    private String terminoEa;
    
    @Column(name = "descripcion_ea")
    private String descripcionEa;

    public TecnoCausaProbable() {
    }

    public TecnoCausaProbable(Integer cdgCausa) {
        this.cdgCausa = cdgCausa;
    }

    public Integer getCdgCausa() {
        return cdgCausa;
    }

    public void setCdgCausa(Integer cdgCausa) {
        this.cdgCausa = cdgCausa;
    }

    public String getTerminoEa() {
        return terminoEa;
    }

    public void setTerminoEa(String terminoEa) {
        this.terminoEa = terminoEa;
    }

    public String getDescripcionEa() {
        return descripcionEa;
    }

    public void setDescripcionEa(String descripcionEa) {
        this.descripcionEa = descripcionEa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdgCausa != null ? cdgCausa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoCausaProbable)) {
            return false;
        }
        TecnoCausaProbable other = (TecnoCausaProbable) object;
        if ((this.cdgCausa == null && other.cdgCausa != null) || (this.cdgCausa != null && !this.cdgCausa.equals(other.cdgCausa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoCausaProbable[cdgCausa=" + cdgCausa + "]";
    }

}
