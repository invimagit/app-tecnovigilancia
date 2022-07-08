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
@Table(name = "parametros")
@NamedQueries({@NamedQuery(name = "Parametros.findAll", query = "SELECT p FROM Parametros p"), @NamedQuery(name = "Parametros.findByConsecFarmaco", query = "SELECT p FROM Parametros p WHERE p.consecFarmaco = :consecFarmaco"), @NamedQuery(name = "Parametros.findByEmailFarmaco", query = "SELECT p FROM Parametros p WHERE p.emailFarmaco = :emailFarmaco"), @NamedQuery(name = "Parametros.findByEmailSivicos", query = "SELECT p FROM Parametros p WHERE p.emailSivicos = :emailSivicos"), @NamedQuery(name = "Parametros.findByPrefijo", query = "SELECT p FROM Parametros p WHERE p.prefijo = :prefijo"), @NamedQuery(name = "Parametros.findByVersionCie", query = "SELECT p FROM Parametros p WHERE p.versionCie = :versionCie"), @NamedQuery(name = "Parametros.findByPrefijoFarmaco", query = "SELECT p FROM Parametros p WHERE p.prefijoFarmaco = :prefijoFarmaco"), @NamedQuery(name = "Parametros.findByFirmanteFarmaco", query = "SELECT p FROM Parametros p WHERE p.firmanteFarmaco = :firmanteFarmaco"), @NamedQuery(name = "Parametros.findByCargoFarmaco", query = "SELECT p FROM Parametros p WHERE p.cargoFarmaco = :cargoFarmaco"), @NamedQuery(name = "Parametros.findByCdgfirmanteFarmaco", query = "SELECT p FROM Parametros p WHERE p.cdgfirmanteFarmaco = :cdgfirmanteFarmaco"), @NamedQuery(name = "Parametros.findByVersionAtc", query = "SELECT p FROM Parametros p WHERE p.versionAtc = :versionAtc"), @NamedQuery(name = "Parametros.findByVersionWho", query = "SELECT p FROM Parametros p WHERE p.versionWho = :versionWho"), @NamedQuery(name = "Parametros.findByRutaHtml", query = "SELECT p FROM Parametros p WHERE p.rutaHtml = :rutaHtml"), @NamedQuery(name = "Parametros.findByConsecBpc", query = "SELECT p FROM Parametros p WHERE p.consecBpc = :consecBpc"), @NamedQuery(name = "Parametros.findByConsecDispositivo", query = "SELECT p FROM Parametros p WHERE p.consecDispositivo = :consecDispositivo"), @NamedQuery(name = "Parametros.findByConsecRisarh", query = "SELECT p FROM Parametros p WHERE p.consecRisarh = :consecRisarh"), @NamedQuery(name = "Parametros.findById", query = "SELECT p FROM Parametros p WHERE p.id = :id")})
public class Parametros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "consec_farmaco")
    private long consecFarmaco;
    @Column(name = "email_farmaco")
    private String emailFarmaco;
    @Column(name = "email_sivicos")
    private String emailSivicos;
    @Column(name = "prefijo")
    private String prefijo;
    @Column(name = "version_cie")
    private String versionCie;
    @Column(name = "prefijo_farmaco")
    private String prefijoFarmaco;
    @Column(name = "firmante_farmaco")
    private String firmanteFarmaco;
    @Column(name = "cargo_farmaco")
    private String cargoFarmaco;
    @Column(name = "cdgfirmante_farmaco")
    private Integer cdgfirmanteFarmaco;
    @Basic(optional = false)
    @Column(name = "version_atc")
    private String versionAtc;
    @Column(name = "version_who")
    private String versionWho;
    @Column(name = "ruta_html")
    private String rutaHtml;
    @Basic(optional = false)
    @Column(name = "consec_bpc")
    private long consecBpc;
    @Column(name = "consec_dispositivo")
    private Long consecDispositivo;
    @Column(name = "consec_risarh")
    private Integer consecRisarh;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    public Parametros() {
    }

    public Parametros(Integer id) {
        this.id = id;
    }

    public Parametros(Integer id, long consecFarmaco, String versionAtc, long consecBpc) {
        this.id = id;
        this.consecFarmaco = consecFarmaco;
        this.versionAtc = versionAtc;
        this.consecBpc = consecBpc;
    }

    public long getConsecFarmaco() {
        return consecFarmaco;
    }

    public void setConsecFarmaco(long consecFarmaco) {
        this.consecFarmaco = consecFarmaco;
    }

    public String getEmailFarmaco() {
        return emailFarmaco;
    }

    public void setEmailFarmaco(String emailFarmaco) {
        this.emailFarmaco = emailFarmaco;
    }

    public String getEmailSivicos() {
        return emailSivicos;
    }

    public void setEmailSivicos(String emailSivicos) {
        this.emailSivicos = emailSivicos;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getVersionCie() {
        return versionCie;
    }

    public void setVersionCie(String versionCie) {
        this.versionCie = versionCie;
    }

    public String getPrefijoFarmaco() {
        return prefijoFarmaco;
    }

    public void setPrefijoFarmaco(String prefijoFarmaco) {
        this.prefijoFarmaco = prefijoFarmaco;
    }

    public String getFirmanteFarmaco() {
        return firmanteFarmaco;
    }

    public void setFirmanteFarmaco(String firmanteFarmaco) {
        this.firmanteFarmaco = firmanteFarmaco;
    }

    public String getCargoFarmaco() {
        return cargoFarmaco;
    }

    public void setCargoFarmaco(String cargoFarmaco) {
        this.cargoFarmaco = cargoFarmaco;
    }

    public Integer getCdgfirmanteFarmaco() {
        return cdgfirmanteFarmaco;
    }

    public void setCdgfirmanteFarmaco(Integer cdgfirmanteFarmaco) {
        this.cdgfirmanteFarmaco = cdgfirmanteFarmaco;
    }

    public String getVersionAtc() {
        return versionAtc;
    }

    public void setVersionAtc(String versionAtc) {
        this.versionAtc = versionAtc;
    }

    public String getVersionWho() {
        return versionWho;
    }

    public void setVersionWho(String versionWho) {
        this.versionWho = versionWho;
    }

    public String getRutaHtml() {
        return rutaHtml;
    }

    public void setRutaHtml(String rutaHtml) {
        this.rutaHtml = rutaHtml;
    }

    public long getConsecBpc() {
        return consecBpc;
    }

    public void setConsecBpc(long consecBpc) {
        this.consecBpc = consecBpc;
    }

    public Long getConsecDispositivo() {
        return consecDispositivo;
    }

    public void setConsecDispositivo(Long consecDispositivo) {
        this.consecDispositivo = consecDispositivo;
    }

    public Integer getConsecRisarh() {
        return consecRisarh;
    }

    public void setConsecRisarh(Integer consecRisarh) {
        this.consecRisarh = consecRisarh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametros)) {
            return false;
        }
        Parametros other = (Parametros) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.invima.entidad.Parametros[id=" + id + "]";
    }

}
