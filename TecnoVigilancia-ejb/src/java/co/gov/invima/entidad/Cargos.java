/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mgualdrond
 */
@Entity
@Table(name = "cargos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargos.findAll", query = "SELECT c FROM Cargos c"),
    @NamedQuery(name = "Cargos.findByCdgcargo", query = "SELECT c FROM Cargos c WHERE c.cdgcargo = :cdgcargo"),
    @NamedQuery(name = "Cargos.findByDescripcion", query = "SELECT c FROM Cargos c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Cargos.findByCargoFijo", query = "SELECT c FROM Cargos c WHERE c.cargoFijo = :cargoFijo")})
public class Cargos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cdgcargo")
    private Integer cdgcargo;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 80)
    @Column(name = "cargo_fijo")
    private String cargoFijo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdgcargo")
    private List<Funcionarios> funcionariosList;

    public Cargos() {
    }

    public Cargos(Integer cdgcargo) {
        this.cdgcargo = cdgcargo;
    }

    public Integer getCdgcargo() {
        return cdgcargo;
    }

    public void setCdgcargo(Integer cdgcargo) {
        this.cdgcargo = cdgcargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCargoFijo() {
        return cargoFijo;
    }

    public void setCargoFijo(String cargoFijo) {
        this.cargoFijo = cargoFijo;
    }

    @XmlTransient
    public List<Funcionarios> getFuncionariosList() {
        return funcionariosList;
    }

    public void setFuncionariosList(List<Funcionarios> funcionariosList) {
        this.funcionariosList = funcionariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdgcargo != null ? cdgcargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargos)) {
            return false;
        }
        Cargos other = (Cargos) object;
        if ((this.cdgcargo == null && other.cdgcargo != null) || (this.cdgcargo != null && !this.cdgcargo.equals(other.cdgcargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.dao.Cargos[ cdgcargo=" + cdgcargo + " ]";
    }
    
}
