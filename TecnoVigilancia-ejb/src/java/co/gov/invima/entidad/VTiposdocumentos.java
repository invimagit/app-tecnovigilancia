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
@Table(name = "VTipos_documentos")
@NamedQueries({@NamedQuery(name = "VTiposdocumentos.findAll", query = "SELECT v FROM VTiposdocumentos v"), @NamedQuery(name = "VTiposdocumentos.findByCdgDoc", query = "SELECT v FROM VTiposdocumentos v WHERE v.cdgDoc = :cdgDoc"), @NamedQuery(name = "VTiposdocumentos.findByNmbDoc", query = "SELECT v FROM VTiposdocumentos v WHERE v.nmbDoc = :nmbDoc")})
public class VTiposdocumentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cdg_doc")
    private String cdgDoc;
    @Column(name = "nmb_doc")
    private String nmbDoc;

    public VTiposdocumentos() {
    }

    public VTiposdocumentos(String cdgDoc) {
        this.cdgDoc = cdgDoc;
    }

    public String getCdgDoc() {
        return cdgDoc;
    }

    public void setCdgDoc(String cdgDoc) {
        this.cdgDoc = cdgDoc;
    }

    public String getNmbDoc() {
        return nmbDoc;
    }

    public void setNmbDoc(String nmbDoc) {
        this.nmbDoc = nmbDoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdgDoc != null ? cdgDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VTiposdocumentos)) {
            return false;
        }
        VTiposdocumentos other = (VTiposdocumentos) object;
        if ((this.cdgDoc == null && other.cdgDoc != null) || (this.cdgDoc != null && !this.cdgDoc.equals(other.cdgDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.VTiposdocumentos[cdgDoc=" + cdgDoc + "]";
    }

}
