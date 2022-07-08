/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Diana Silva
 */
@Embeddable
public class TecnoDatosExpedientesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "reporte")
    private String reporte;
    @Basic(optional = false)
    @Column(name = "nroexpediente")
    private long nroexpediente;

    public TecnoDatosExpedientesPK(String reporte, long nroexpediente) {
        this.reporte = reporte;
        this.nroexpediente = nroexpediente;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public long getNroexpediente() {
        return nroexpediente;
    }

    public void setNroexpediente(long nroexpediente) {
        this.nroexpediente = nroexpediente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reporte != null ? reporte.hashCode() : 0);
        hash += (int) nroexpediente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoDatosExpedientesPK)) {
            return false;
        }
        TecnoDatosExpedientesPK other = (TecnoDatosExpedientesPK) object;
        if ((this.reporte == null && other.reporte != null) || (this.reporte != null && !this.reporte.equals(other.reporte))) {
            return false;
        }
        if (this.nroexpediente != other.nroexpediente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoDatosExpedientesPK[reporte=" + reporte + ", nroexpediente=" + nroexpediente + "]";
    }

}
