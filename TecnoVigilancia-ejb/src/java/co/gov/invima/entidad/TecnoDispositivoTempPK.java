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
public class TecnoDispositivoTempPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "reporte")
    private String reporte;
    @Basic(optional = false)
    @Column(name = "expediente")
    private int expediente;

    public TecnoDispositivoTempPK()
    {
    }
    
    public TecnoDispositivoTempPK(String reporte, int expediente) {
        this.reporte = reporte;
        this.expediente = expediente;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public int getExpediente() {
        return expediente;
    }

    public void setExpediente(int expediente) {
        this.expediente = expediente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reporte != null ? reporte.hashCode() : 0);
        hash += (int) expediente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoDispositivoTempPK)) {
            return false;
        }
        TecnoDispositivoTempPK other = (TecnoDispositivoTempPK) object;
        if ((this.reporte == null && other.reporte != null) || (this.reporte != null && !this.reporte.equals(other.reporte))) {
            return false;
        }
        if (this.expediente != other.expediente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoDispositivoTempPK[reporte=" + reporte + ", expediente=" + expediente + "]";
    }

}
