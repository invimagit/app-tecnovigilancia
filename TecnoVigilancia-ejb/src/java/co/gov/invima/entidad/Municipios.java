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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Diana Silva
 */
@Entity
@Table(name = "municipios")
@NamedQueries({@NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m"), @NamedQuery(name = "Municipios.findByCodMun", query = "SELECT m FROM Municipios m WHERE m.codMun = :codMun"), @NamedQuery(name = "Municipios.findByDescripcion", query = "SELECT m FROM Municipios m WHERE m.descripcion = :descripcion"), @NamedQuery(name = "Municipios.findByCategoria", query = "SELECT m FROM Municipios m WHERE m.categoria = :categoria")})
public class Municipios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_mun")
    private String codMun;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "categoria")
    private Character categoria;
    @JoinColumn(name = "cod_depart", referencedColumnName = "cod_depart")
    @ManyToOne(optional = false)
    private Departamentos codDepart;

    public Municipios() {
    }

    public Municipios(String codMun) {
        this.codMun = codMun;
    }

    public Municipios(String codMun, String descripcion) {
        this.codMun = codMun;
        this.descripcion = descripcion;
    }

    public String getCodMun() {
        return codMun;
    }

    public void setCodMun(String codMun) {
        this.codMun = codMun;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getCategoria() {
        return categoria;
    }

    public void setCategoria(Character categoria) {
        this.categoria = categoria;
    }

    public Departamentos getCodDepart() {
        return codDepart;
    }

    public void setCodDepart(Departamentos codDepart) {
        this.codDepart = codDepart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMun != null ? codMun.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.codMun == null && other.codMun != null) || (this.codMun != null && !this.codMun.equals(other.codMun))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.Municipios[codMun=" + codMun + "]";
    }

}
