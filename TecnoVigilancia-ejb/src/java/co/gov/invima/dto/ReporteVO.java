
package co.gov.invima.dto;

import java.math.BigInteger;
import java.util.Date;

/**
 * Clase que mapea los datos del formulario de fabricantes a las 4 tablas donde se 
 * guarda el reporte
 * @author GRUPO ASD
 */
public class ReporteVO {

    /*tecno_paciente*/
    private String institucionIncidente;
    private String codMun1;
    private String codDepart1;
    private String identificacion1;
    private String nivelComplejidad;
    private String naturaleza;
    private String tipoId;
    private String identificacion;
    private String genero;
    private String edad;
    private String edadEn;
    private String diagnosticoPaciente;

    /*tecno_dispositivo*/
    private String nombreDispositivo;
    private String nombreComercial;
    private String nroRegSan;
    private String lote;
    private String modelo;
    private String referencia;
    private String serial;
    private String fabricanteUsuario;
    private String distribuidorUsuario;
    private String areaFunciona;
    private String utilizado;

    /*tecno_evaluacion_caso*/
    private int cdgCausa;
    private String acciones="";
    private String notificacion="";
    private Date fechaNotificacion;
    private String dispositivoEvaluacion="";
    private String envioDispositivo="";
    private Date fechaImportador;
    private String estadoCaso;
    

    /*tecno_reporte_eventos*/
    private String nombreInstitucion;
    private Date fechaEvento;
    private Date fechaReporteEvento;
    private int codigoEventoDeteccion;
    private int codigoTipoEventoIncidente;
    private String descripcionEvento;
    private int codigoDesenlace;
    private String desenlaceOtro;
    private Character reportado;

    /*tecno_paciente*/
    private String contactoReportante;
    private int cargoInst;
    private String institucionReportante;
    private String direccionReportante;
    private BigInteger telefonoReportante;
    private String codMun;
    private String codDepart;
    private String emailReportante;
    private Date fechaNotif = new Date();
    private String autorizacion;
    private String tipoReportante;
    private int cdgOrigenreporte;
    private int cdg_tiporeporte;
    private int expediente;
    private int cdg_unicodispositivo;
    private int cdg_tipodispositivo;
    int tipo_roles = 0;
    
    String seguimiento;
    String medidaEjecutada;
    BigInteger cdgfuncionario;
    
    String consecutivo="";
    int CdgTipoalerta;
    String descripcionAlerta;
    int numero;
    int expAlertas;
    
    String reportepre ="";
    String idIPS ="";
    String estadoReporte="";

    public ReporteVO() {
    }

    public String getReportepre() {
        return reportepre;
    }

    public void setReportepre(String reportepre) {
        this.reportepre = reportepre;
    }

    public String getIdIPS() {
        return idIPS;
    }

    public void setIdIPS(String idIPS) {
        this.idIPS = idIPS;
    }
    

    
    public int getCdg_tiporeporte() {
        return cdg_tiporeporte;
    }

    public int getTipo_roles() {
        return tipo_roles;
    }

    public void setTipo_roles(int tipo_roles) {
        this.tipo_roles = tipo_roles;
    }

    
    public void setCdg_tiporeporte(int cdg_tiporeporte) {
        this.cdg_tiporeporte = cdg_tiporeporte;
    }

    public int getExpAlertas() {
        return expAlertas;
    }

    public void setExpAlertas(int expAlertas) {
        this.expAlertas = expAlertas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcionAlerta() {
        return descripcionAlerta;
    }

    public void setDescripcionAlerta(String descripcionAlerta) {
        this.descripcionAlerta = descripcionAlerta;
    }

    public int getCdgTipoalerta() {
        return CdgTipoalerta;
    }

    public void setCdgTipoalerta(int CdgTipoalerta) {
        this.CdgTipoalerta = CdgTipoalerta;
    }

    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(String seguimiento) {
        this.seguimiento = seguimiento;
    }

    public String getMedidaEjecutada() {
        return medidaEjecutada;
    }

    public void setMedidaEjecutada(String medidaEjecutada) {
        this.medidaEjecutada = medidaEjecutada;
    }

    public BigInteger getCdgfuncionario() {
        return cdgfuncionario;
    }

    public void setCdgfuncionario(BigInteger cdgfuncionario) {
        this.cdgfuncionario = cdgfuncionario;
    }
    
    

    public int getCdg_tipodispositivo() {
        return cdg_tipodispositivo;
    }

    public void setCdg_tipodispositivo(int cdg_tipodispositivo) {
        this.cdg_tipodispositivo = cdg_tipodispositivo;
    }

    public int getCdg_unicodispositivo() {
        return cdg_unicodispositivo;
    }

    public void setCdg_unicodispositivo(int cdg_unicodispositivo) {
        this.cdg_unicodispositivo = cdg_unicodispositivo;
    }

    public int getExpediente() {
        return expediente;
    }

    public void setExpediente(int expediente) {
        this.expediente = expediente;
    }

    public int getCdgOrigenreporte() {
        return cdgOrigenreporte;
    }

    public void setCdgOrigenreporte(int cdgOrigenreporte) {
        this.cdgOrigenreporte = cdgOrigenreporte;
    }


    public int getCodigoDesenlace() {
        return codigoDesenlace;
    }

    public void setCodigoDesenlace(int codigoDesenlace) {
        this.codigoDesenlace = codigoDesenlace;
    }

    public int getCodigoEventoDeteccion() {
        return codigoEventoDeteccion;
    }

    public void setCodigoEventoDeteccion(int codigoEventoDeteccion) {
        this.codigoEventoDeteccion = codigoEventoDeteccion;
    }

    public int getCodigoTipoEventoIncidente() {
        return codigoTipoEventoIncidente;
    }

    public void setCodigoTipoEventoIncidente(int codigoTipoEventoIncidente) {
        this.codigoTipoEventoIncidente = codigoTipoEventoIncidente;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public String getDesenlaceOtro() {
        return desenlaceOtro;
    }

    public void setDesenlaceOtro(String desenlaceOtro) {
        this.desenlaceOtro = desenlaceOtro;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public Date getFechaReporteEvento() {
        return fechaReporteEvento;
    }

    public void setFechaReporteEvento(Date fechaReporteEvento) {
        this.fechaReporteEvento = fechaReporteEvento;
    }


    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getAcciones() {
        return acciones;
    }

    public void setAcciones(String acciones) {
        this.acciones = acciones;
    }

    public String getAreaFunciona() {
        return areaFunciona;
    }

    public void setAreaFunciona(String areaFunciona) {
        this.areaFunciona = areaFunciona;
    }

    public String getUtilizado() {
        return utilizado;
    }

    public void setUtilizado(String utilizado) {
        this.utilizado = utilizado;
    }

    
    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public int getCargoInst() {
        return cargoInst;
    }

    public void setCargoInst(int cargoInst) {
        this.cargoInst = cargoInst;
    }

    public int getCdgCausa() {
        return cdgCausa;
    }

    public void setCdgCausa(int cdgCausa) {
        this.cdgCausa = cdgCausa;
    }

    public String getCodDepart() {
        return codDepart;
    }

    public void setCodDepart(String codDepart) {
        this.codDepart = codDepart;
    }

    public String getCodDepart1() {
        return codDepart1;
    }

    public void setCodDepart1(String codDepart1) {
        this.codDepart1 = codDepart1;
    }

    public String getCodMun() {
        return codMun;
    }

    public void setCodMun(String codMun) {
        this.codMun = codMun;
    }

    public String getCodMun1() {
        return codMun1;
    }

    public void setCodMun1(String codMun1) {
        this.codMun1 = codMun1;
    }

    public String getContactoReportante() {
        return contactoReportante;
    }

    public void setContactoReportante(String contactoReportante) {
        this.contactoReportante = contactoReportante;
    }

    public String getDiagnosticoPaciente() {
        return diagnosticoPaciente;
    }

    public void setDiagnosticoPaciente(String diagnosticoPaciente) {
        this.diagnosticoPaciente = diagnosticoPaciente;
    }

    public String getDireccionReportante() {
        return direccionReportante;
    }

    public void setDireccionReportante(String direccionReportante) {
        this.direccionReportante = direccionReportante;
    }

    public String getDispositivoEvaluacion() {
        return dispositivoEvaluacion;
    }

    public void setDispositivoEvaluacion(String dispositivoEvaluacion) {
        this.dispositivoEvaluacion = dispositivoEvaluacion;
    }

    public String getEnvioDispositivo() {
        return envioDispositivo;
    }

    public void setEnvioDispositivo(String envioDispositivo) {
        this.envioDispositivo = envioDispositivo;
    }

    public String getDistribuidorUsuario() {
        return distribuidorUsuario;
    }

    public void setDistribuidorUsuario(String distribuidorUsuario) {
        this.distribuidorUsuario = distribuidorUsuario;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEdadEn() {
        return edadEn;
    }

    public void setEdadEn(String edadEn) {
        this.edadEn = edadEn;
    }

    public String getEmailReportante() {
        return emailReportante;
    }

    public void setEmailReportante(String emailReportante) {
        this.emailReportante = emailReportante;
    }

    public String getFabricanteUsuario() {
        return fabricanteUsuario;
    }

    public void setFabricanteUsuario(String fabricanteUsuario) {
        this.fabricanteUsuario = fabricanteUsuario;
    }

    public Date getFechaImportador() {
        return fechaImportador;
    }

    public void setFechaImportador(Date fechaImportador) {
        this.fechaImportador = fechaImportador;
    }

    public Date getFechaNotif() {
        return fechaNotif;
    }

    public void setFechaNotif(Date fechaNotif) {
        this.fechaNotif = fechaNotif;
    }

    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificacion1() {
        return identificacion1;
    }

    public void setIdentificacion1(String identificacion1) {
        this.identificacion1 = identificacion1;
    }

    public String getInstitucionIncidente() {
        return institucionIncidente;
    }

    public void setInstitucionIncidente(String institucionIncidente) {
        this.institucionIncidente = institucionIncidente;
    }

    public String getInstitucionReportante() {
        return institucionReportante;
    }

    public void setInstitucionReportante(String institucionReportante) {
        this.institucionReportante = institucionReportante;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    public String getNivelComplejidad() {
        return nivelComplejidad;
    }

    public void setNivelComplejidad(String nivelComplejidad) {
        this.nivelComplejidad = nivelComplejidad;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNombreDispositivo() {
        return nombreDispositivo;
    }

    public void setNombreDispositivo(String nombreDispositivo) {
        this.nombreDispositivo = nombreDispositivo;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }

    public String getNroRegSan() {
        return nroRegSan;
    }

    public void setNroRegSan(String nroRegSan) {
        this.nroRegSan = nroRegSan;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public BigInteger getTelefonoReportante() {
        return telefonoReportante;
    }

    public void setTelefonoReportante(BigInteger telefonoReportante) {
        this.telefonoReportante = telefonoReportante;
    }

    public Character getReportado() {
        return reportado;
    }

    public void setReportado(Character reportado) {
        this.reportado = reportado;
    }

    public String getTipoReportante() {
        return tipoReportante;
    }

    public void setTipoReportante(String tipoReportante) {
        this.tipoReportante = tipoReportante;
    }

    /**
     * @return the estadoCaso
     */
    public String getEstadoCaso() {
        return estadoCaso;
    }

    /**
     * @param estadoCaso the estadoCaso to set
     */
    public void setEstadoCaso(String estadoCaso) {
        this.estadoCaso = estadoCaso;
    }

    public String getEstadoReporte() {
        return estadoReporte;
    }

    public void setEstadoReporte(String estadoReporte) {
        this.estadoReporte = estadoReporte;
    }
    
    public void print_datos(){
        System.out.println("institucionIncidente = "+institucionIncidente);
        System.out.println("codMun1 = "+codMun1);
        System.out.println("codDepart1 = "+codDepart1);
        System.out.println("identificacion1 = "+identificacion1);
        System.out.println("nivelComplejidad = "+nivelComplejidad);
        System.out.println("naturaleza = "+naturaleza);
        System.out.println("tipoId = "+tipoId);
        System.out.println("identificacion = "+identificacion);
        System.out.println("genero = "+genero);
        System.out.println("edad = "+edad);
        System.out.println("edadEn = "+edadEn);
        System.out.println("diagnosticoPaciente = "+diagnosticoPaciente);
        System.out.println("nombreDispositivo = "+nombreDispositivo);
        System.out.println("nombreComercial = "+nombreComercial);
        System.out.println("nroRegSan = "+nroRegSan);
        System.out.println("lote = "+lote);
        System.out.println("modelo = "+modelo);
        System.out.println("referencia = "+referencia);
        System.out.println("serial = "+serial);
        System.out.println("fabricanteUsuario = "+fabricanteUsuario);
        System.out.println("distribuidorUsuario = "+distribuidorUsuario);
        System.out.println("areaFunciona = "+areaFunciona);
        System.out.println("utilizado = "+utilizado);
        System.out.println("cdgCausa = "+cdgCausa);
        System.out.println("acciones = "+acciones);
        System.out.println("notificacion = "+notificacion);
        System.out.println("fechaNotificacion = "+fechaNotificacion);
        System.out.println("dispositivoEvaluacion = "+dispositivoEvaluacion);
        System.out.println("envioDispositivo = "+envioDispositivo);
        System.out.println("fechaImportador = "+fechaImportador);
        System.out.println("estadoCaso = "+estadoCaso);
        System.out.println("nombreInstitucion = "+nombreInstitucion);
        System.out.println("fechaEvento = "+fechaEvento);
        System.out.println("fechaReporteEvento = "+fechaReporteEvento);
        System.out.println("codigoEventoDeteccion = "+codigoEventoDeteccion);
        System.out.println("codigoTipoEventoIncidente = "+codigoTipoEventoIncidente);
        System.out.println("descripcionEvento = "+descripcionEvento);
        System.out.println("codigoDesenlace = "+codigoDesenlace);
        System.out.println("desenlaceOtro = "+desenlaceOtro);
        System.out.println("reportado = "+reportado);
        System.out.println("contactoReportante = "+contactoReportante);
        System.out.println("cargoInst = "+cargoInst);
        System.out.println("institucionReportante = "+institucionReportante);
        System.out.println("direccionReportante = "+direccionReportante);
        System.out.println("telefonoReportante = "+telefonoReportante);
        System.out.println("codMun = "+codMun);
        System.out.println("codDepart = "+codDepart);
        System.out.println("emailReportante = "+emailReportante);
        System.out.println("fechaNotif = "+fechaNotif);
        System.out.println("autorizacion = "+autorizacion);
        System.out.println("tipoReportante = "+tipoReportante);
        System.out.println("cdgOrigenreporte = "+cdgOrigenreporte);
        System.out.println("seguimiento = "+seguimiento);
        System.out.println("medidaEjecutada = "+medidaEjecutada);
        System.out.println("estadoCaso = "+estadoCaso);
        System.out.println("cdgfuncionario = "+cdgfuncionario);


    }
    
    
    
    
}
