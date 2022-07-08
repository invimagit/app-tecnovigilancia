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
 * @author jonat
 */
@Entity
@Table(name = "tecno_tipodispositivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TecnoTipodispositivo.findAll", query = "SELECT t FROM TecnoTipodispositivo t")
    , @NamedQuery(name = "TecnoTipodispositivo.findByCdgTipodispositivo", query = "SELECT t FROM TecnoTipodispositivo t WHERE t.cdgTipodispositivo = :cdgTipodispositivo")
    , @NamedQuery(name = "TecnoTipodispositivo.findByDescripcion", query = "SELECT t FROM TecnoTipodispositivo t WHERE t.descripcion = :descripcion")})
public class TecnoTipodispositivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cdg_tipodispositivo")
    private Integer cdgTipodispositivo;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;

    public TecnoTipodispositivo() {
    }

    public TecnoTipodispositivo(Integer cdgTipodispositivo) {
        this.cdgTipodispositivo = cdgTipodispositivo;
    }

    public Integer getCdgTipodispositivo() {
        return cdgTipodispositivo;
    }

    public void setCdgTipodispositivo(Integer cdgTipodispositivo) {
        this.cdgTipodispositivo = cdgTipodispositivo;
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
        hash += (cdgTipodispositivo != null ? cdgTipodispositivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoTipodispositivo)) {
            return false;
        }
        TecnoTipodispositivo other = (TecnoTipodispositivo) object;
        if ((this.cdgTipodispositivo == null && other.cdgTipodispositivo != null) || (this.cdgTipodispositivo != null && !this.cdgTipodispositivo.equals(other.cdgTipodispositivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoTipodispositivo[ cdgTipodispositivo=" + cdgTipodispositivo + " ]";
    }
    
}
