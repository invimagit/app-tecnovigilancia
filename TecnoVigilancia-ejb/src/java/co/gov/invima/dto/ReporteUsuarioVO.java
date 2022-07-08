
package co.gov.invima.dto;

import java.util.Date;

/**
 * Clase que mapea los datos del formulario de usurios a la tabla donde se 
 * guarda el reporte
 * @author GRUPO ASD
 */
public class ReporteUsuarioVO {
    
    private int  codigo; 
    private String nombreReportante; 
    private Character sexo; 
    private int edad;
    private Character edad_en;
    private String direccionReportante;
    private String telefono;
    private String pais;
    private String codDepart;
    private String codMun;
    private String email;
    private String nombreDm;
    private String nombreComercial;
    private String nroregsan;
    private String lote;
    private String referencia;
    private String nombreFabricante;
    private String nombreDistribImport;
    private Date fechaEvento;
    private Date fechaNotificacion;
    private int cdgEventodeteccion;
    private String descripcionEvento;
    String reporte;
    int cdgfuncionario;
    char revisado;
    boolean es_un_registro_nuevo = true;

    public boolean isEs_un_registro_nuevo() {
        return es_un_registro_nuevo;
    }

    public void setEs_un_registro_nuevo(boolean es_un_registro_nuevo) {
        this.es_un_registro_nuevo = es_un_registro_nuevo;
    }
    
    

    public char getRevisado() {
        return revisado;
    }

    public void setRevisado(char revisado) {
        this.revisado = revisado;
    }
    
    

    public int getCdgfuncionario() {
        return cdgfuncionario;
    }

    public void setCdgfuncionario(int cdgfuncionario) {
        this.cdgfuncionario = cdgfuncionario;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    
    public int getCdgEventodeteccion() {
        return cdgEventodeteccion;
    }

    public void setCdgEventodeteccion(int cdgEventodeteccion) {
        this.cdgEventodeteccion = cdgEventodeteccion;
    }

    public String getCodDepart() {
        return codDepart;
    }

    public void setCodDepart(String codDepart) {
        this.codDepart = codDepart;
    }

    public String getCodMun() {
        return codMun;
    }

    public void setCodMun(String codMun) {
        this.codMun = codMun;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public String getDireccionReportante() {
        return direccionReportante;
    }

    public void setDireccionReportante(String direccionReportante) {
        this.direccionReportante = direccionReportante;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Character getEdad_en() {
        return edad_en;
    }

    public void setEdad_en(Character edad_en) {
        this.edad_en = edad_en;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNombreDistribImport() {
        return nombreDistribImport;
    }

    public void setNombreDistribImport(String nombreDistribImport) {
        this.nombreDistribImport = nombreDistribImport;
    }

    public String getNombreDm() {
        return nombreDm;
    }

    public void setNombreDm(String nombreDm) {
        this.nombreDm = nombreDm;
    }

    public String getNombreFabricante() {
        return nombreFabricante;
    }

    public void setNombreFabricante(String nombreFabricante) {
        this.nombreFabricante = nombreFabricante;
    }

    public String getNombreReportante() {
        return nombreReportante;
    }

    public void setNombreReportante(String nombreReportante) {
        this.nombreReportante = nombreReportante;
    }

    public String getNroregsan() {
        return nroregsan;
    }

    public void setNroregsan(String nroregsan) {
        this.nroregsan = nroregsan;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    
}
