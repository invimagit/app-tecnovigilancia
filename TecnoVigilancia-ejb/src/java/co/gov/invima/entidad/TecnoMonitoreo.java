/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.entidad;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Diana Silva
 */
@Entity
@Table(name = "tecno_monitoreo")
@NamedQueries({@NamedQuery(name = "TecnoMonitoreo.findAll", query = "SELECT t FROM TecnoMonitoreo t"), @NamedQuery(name = "TecnoMonitoreo.findByRisarh", query = "SELECT t FROM TecnoMonitoreo t WHERE t.risarh = :risarh"), @NamedQuery(name = "TecnoMonitoreo.findByFechaIngreso", query = "SELECT t FROM TecnoMonitoreo t WHERE t.fechaIngreso = :fechaIngreso"), @NamedQuery(name = "TecnoMonitoreo.findByFuente", query = "SELECT t FROM TecnoMonitoreo t WHERE t.fuente = :fuente"), @NamedQuery(name = "TecnoMonitoreo.findByAplica", query = "SELECT t FROM TecnoMonitoreo t WHERE t.aplica = :aplica"), @NamedQuery(name = "TecnoMonitoreo.findByTipo", query = "SELECT t FROM TecnoMonitoreo t WHERE t.tipo = :tipo"), @NamedQuery(name = "TecnoMonitoreo.findByFuncionarioMonitoreo", query = "SELECT t FROM TecnoMonitoreo t WHERE t.funcionarioMonitoreo = :funcionarioMonitoreo"), @NamedQuery(name = "TecnoMonitoreo.findByPaginaWeb", query = "SELECT t FROM TecnoMonitoreo t WHERE t.paginaWeb = :paginaWeb"), @NamedQuery(name = "TecnoMonitoreo.findByInternet", query = "SELECT t FROM TecnoMonitoreo t WHERE t.internet = :internet")})
public class TecnoMonitoreo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "risarh")
    private String risarh;
    @Basic(optional = false)
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Basic(optional = false)
    @Column(name = "fuente")
    private Integer fuente;
    @Basic(optional = false)
    @Column(name = "detalles")
    private String detalles;
    @Basic(optional = false)
    @Column(name = "aplica")
    private String aplica;
    @Basic(optional = false)
    @Column(name = "tipo")
    private char tipo;
    @Basic(optional = false)
    @Column(name = "funcionario_monitoreo")
    private Integer funcionarioMonitoreo;
    @Column(name = "pagina_web")
    private String paginaWeb;
    @Column(name = "internet")
    private Character internet;
    @Basic(optional = false)
    @Column(name = "agencia_sanitaria")
    private String agenciaSanitaria;
    
    public TecnoMonitoreo() {
    }
    
    public TecnoMonitoreo(Date fecha) {
        fechaIngreso = fecha;
    }

    public TecnoMonitoreo(String risarh) {
        this.risarh = risarh;
    }

    public TecnoMonitoreo(String risarh, Date fechaIngreso, Integer fuente, String detalles, String aplica, char tipo, Integer funcionarioMonitoreo) {
        this.risarh = risarh;
        this.fechaIngreso = fechaIngreso;
        this.fuente = fuente;
        this.detalles = detalles;
        this.aplica = aplica;
        this.tipo = tipo;
        this.funcionarioMonitoreo = funcionarioMonitoreo;
    }

    public String getRisarh() {
        return risarh;
    }

    public void setRisarh(String risarh) {
        this.risarh = risarh;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getFuente() {
        return fuente;
    }

    public void setFuente(Integer fuente) {
        this.fuente = fuente;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getAplica() {
        return aplica;
    }

    public void setAplica(String aplica) {
        this.aplica = aplica;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public Integer getFuncionarioMonitoreo() {
        return funcionarioMonitoreo;
    }

    public void setFuncionarioMonitoreo(Integer funcionarioMonitoreo) {
        System.out.println("setFuncionarioMonitoreo - funcionarioMonitoreo= "+funcionarioMonitoreo);
        this.funcionarioMonitoreo = funcionarioMonitoreo;
        System.out.println("setFuncionarioMonitoreo FIN - funcionarioMonitoreo= "+funcionarioMonitoreo);
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public Character getInternet() {
        return internet;
    }

    public void setInternet(Character internet) {
        this.internet = internet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (risarh != null ? risarh.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecnoMonitoreo)) {
            return false;
        }
        TecnoMonitoreo other = (TecnoMonitoreo) object;
        if ((this.risarh == null && other.risarh != null) || (this.risarh != null && !this.risarh.equals(other.risarh))) {
            return false;
        }
        return true;
    }

    public String getAgenciaSanitaria() {
        return agenciaSanitaria;
    }

    public void setAgenciaSanitaria(String agenciaSanitaria) {
        this.agenciaSanitaria = agenciaSanitaria;
    }

    
    /*
    public String toString() {
        return "co.gov.invima.entidad.TecnoMonitoreo[risarh=" + risarh + "]";
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
