/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.entidad;

import java.io.Serializable;
import java.lang.reflect.Field;
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
@Table(name = "tecno_modalidad")
@NamedQueries({@NamedQuery(name = "TecnoModalidad.findAll", query = "SELECT t FROM TecnoModalidad t"), @NamedQuery(name = "TecnoModalidad.findByCdgModalidad", query = "SELECT t FROM TecnoModalidad t WHERE t.cdgModalidad = :cdgModalidad"), @NamedQuery(name = "TecnoModalidad.findByDescripcion", query = "SELECT t FROM TecnoModalidad t WHERE t.descripcion = :descripcion")})
public class TecnoModalidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cdg_modalidad")
    private Integer cdgModalidad;
    @Column(name = "descripcion")
    private String descripcion;

    public TecnoModalidad() {
    }

    public TecnoModalidad(Integer cdgModalidad) {
        this.cdgModalidad = cdgModalidad;
    }

    public Integer getCdgModalidad() {
        return cdgModalidad;
    }

    public void setCdgModalidad(Integer cdgModalidad) {
        this.cdgModalidad = cdgModalidad;
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
        hash += (cdgModalidad != null ? cdgModalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoModalidad)) {
            return false;
        }
        TecnoModalidad other = (TecnoModalidad) object;
        if ((this.cdgModalidad == null && other.cdgModalidad != null) || (this.cdgModalidad != null && !this.cdgModalidad.equals(other.cdgModalidad))) {
            return false;
        }
        return true;
    }

    /*
    @Override
    public String toString() {
        return "co.gov.invima.entidad.TecnoModalidad[cdgModalidad=" + cdgModalidad + "]";
    }
*/
    
            @Override
    public String toString() {
  StringBuilder result = new StringBuilder();
  String newLine = System.getProperty("line.separator");
  String valor = "";
  result.append( this.getClass().getName() );
  result.append( " Object {" );
  result.append(newLine);

  //determine fields declared in this class only (no fields of superclass)
  Field[] fields = this.getClass().getDeclaredFields();

  //print field names paired with their values
  for ( Field field : fields  ) {
    result.append("  ");
    try {
        valor = String.valueOf(field.get(this));
      result.append( field.getName() );
      result.append(": ");
      result.append( field.get(this) );
      result.append(" - Longitud del campo: ");
      result.append(valor.length());
      //requires access to private field:
    } catch ( IllegalAccessException ex ) {
       ex.printStackTrace();
    }
    result.append(newLine);
  }
  result.append("}");

  return result.toString();
}


}
