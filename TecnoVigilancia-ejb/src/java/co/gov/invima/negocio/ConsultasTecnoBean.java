/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.negocio;

import co.gov.invima.dto.ReportePrecol;
import co.gov.invima.dto.reports.PojoDatosReporte;
import co.gov.invima.dto.reports.PojoReporteAlertas;
import co.gov.invima.dto.reports.PojoReporteConsecutivos;
import co.gov.invima.dto.reports.PojoReporteDispoExpedientes;
import co.gov.invima.dto.reports.PojoReporteInscripcionRed;
import co.gov.invima.dto.reports.PojoReporteMonitoreo;
import co.gov.invima.dto.reports.PojoReporteTecno;
import co.gov.invima.dto.reports.PojoReporteUsuarios;
import co.gov.invima.dto.reports.PojoReportesUsuariosInternet;
import co.gov.invima.entidad.TecnoReporteEventos;
import co.gov.invima.utils.ManejadorDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

/**
 *
 * @author jgutierrezme
 */
@Stateless
public class ConsultasTecnoBean implements ConsultasTecnoRemote {

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    private final static Logger logEJBTecno = Logger.getLogger(ConsultasTecnoBean.class.getName());
    //************************************************************************************************
    //************************************************************************************************
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager manejadorEntidadesDireccion;
    //************************************************************************************************
    //************************************************************************************************
    @Resource
    private EJBContext contextoBean;

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    private java.sql.Connection obtenerConexionDataSource() {
        java.sql.Connection conexionBD = null;
        try {
            DataSource dataSourceJBoss = null;
            Context ctx = new InitialContext();
            dataSourceJBoss = (DataSource) ctx.lookup("java:/jboss/SybaseTecno");
            //logEJBTecno.info ("Datasource del contenedor: " + dataSourceJBoss);
            conexionBD = dataSourceJBoss.getConnection();
        } catch (SQLException errorConexionSQL) {
            errorConexionSQL.printStackTrace();
        } catch (NamingException errorConexionDS) {
            errorConexionDS.printStackTrace();
        }
        return (conexionBD);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    private static java.sql.Date obtenerFechaTimeStamp(java.util.Date fechaOriginal) {
        // 1) create a java calendar instance
        // 2) get a java.util.Date from the calendar instance.
        //    this date will represent the current instant, or "now".
        // 3) a java current time (now) instance
        java.sql.Date currentTimestamp = new java.sql.Date(fechaOriginal.getTime());
        return (currentTimestamp);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<PojoReporteTecno> listarReportesCargados(java.util.Date fechaInicial, java.util.Date fechaFinal) {
        List<PojoReporteTecno> resultadosBusqueda = null;
        List<PojoReporteTecno> vacios = null;
        int i = 0;
        TecnoReporteEventos registro = null;
        PojoReporteTecno registroWebService = null;
        ManejadorDatos validadorDatos = new ManejadorDatos();

        try {
            //*****************************************************
            //*****************************************************
            //*****************************************************
            //*****************************************************
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("FECHA INICIAL EN EL EJB = " + fechaInicial);
            //logEJBTecno.info ("FECHA FINAL EN EL EJB = " + fechaFinal);
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            String hql = "SELECT t FROM TecnoReporteEventos t WHERE (t.fechaingreso >= :fechaingreso AND t.fechaingreso <= :fechaingreso2) ";
            //logEJBTecno.info ("CONSULTA HQL = " + hql);
            Query query = getManejadorEntidadesDireccion().createQuery(hql);
            query.setParameter("fechaingreso", fechaInicial);
            query.setParameter("fechaingreso2", fechaFinal);
            //*****************************************************
            //*****************************************************
            List<TecnoReporteEventos> listaRegistros = query.getResultList();
            //*****************************************************
            //*****************************************************
            //*****************************************************
            //*****************************************************
            if (listaRegistros != null) {
                resultadosBusqueda = new ArrayList<PojoReporteTecno>();

                for (i = 0; i < listaRegistros.size(); i++) {
                    registro = (TecnoReporteEventos) listaRegistros.get(i);
                    //*********************************************************************
                    //*********************************************************************
                    //*********************************************************************
                    //*********************************************************************
                    registroWebService = new PojoReporteTecno();
                    //*********************************************************************
                    //*********************************************************************
                    registroWebService.setReporte(validadorDatos.validarDatoCampoBaseDatos(registro.getReporte(), "cadena"));
                    registroWebService.setCdg_desenlace(validadorDatos.validarDatoCampoBaseDatos(registro.getCdgDesenlace(), "numero"));
                    registroWebService.setCdg_eventodeteccion(validadorDatos.validarDatoCampoBaseDatos(registro.getCdgEventodeteccion(), "numero"));
                    registroWebService.setCdg_origenreporte(validadorDatos.validarDatoCampoBaseDatos(registro.getCdgOrigenreporte(), "numero"));
                    registroWebService.setCdg_seriedad(validadorDatos.validarDatoCampoBaseDatos(registro.getCdgSeriedad(), "numero"));
                    registroWebService.setCdg_tipoeventoincidente(validadorDatos.validarDatoCampoBaseDatos(registro.getCdgTipoeventoincidente(), "numero"));
                    registroWebService.setCdg_tiporeporte(validadorDatos.validarDatoCampoBaseDatos(registro.getCdgTiporeporte(), "numero"));
                    registroWebService.setDescripcion_evento(validadorDatos.validarDatoCampoBaseDatos(registro.getDescripcionEvento(), "cadena"));
                    registroWebService.setDesenlace_otro(validadorDatos.validarDatoCampoBaseDatos(registro.getDesenlaceOtro(), "cadena"));
                    registroWebService.setFechaingreso(validadorDatos.validarCapturaFechaBaseDatos(registro.getFechaingreso()));
                    registroWebService.setFechevento(validadorDatos.validarCapturaFechaBaseDatos(registro.getFechevento()));
                    registroWebService.setFechreporte_evento(validadorDatos.validarCapturaFechaBaseDatos(registro.getFechreporteEvento()));
                    registroWebService.setInternet(validadorDatos.validarDatoCampoBaseDatos(registro.getInternet(), "cadena"));
                    registroWebService.setReportado(validadorDatos.validarDatoCampoBaseDatos(registro.getReportado(), "cadena"));
                    //**********************************************************
                    //**********************************************************
                    resultadosBusqueda.add(registroWebService);
                }
            } else {
                resultadosBusqueda = new ArrayList<PojoReporteTecno>();
                vacios = new ArrayList<PojoReporteTecno>();
            }
            //logEJBTecno.info ("*******************************************************************");
            //logEJBTecno.info ("*******************************************************************");
            //logEJBTecno.info ("Resultados búsqueda: " + resultadosBusqueda);
            //logEJBTecno.info ("*******************************************************************");
            //logEJBTecno.info ("*******************************************************************");
        } catch (Exception errorobtenerCodigoDireccionPorNombre) {
            //logEJBTecno.info ("Control de Error --> *******************************************************************");
            //logEJBTecno.info ("****************************************************************************************");
            //logEJBTecno.info ("****************************************************************************************");
            vacios = new ArrayList<PojoReporteTecno>();
            //logEJBTecno.info ("Error en el método buscarRegistrosDireccionPorCriterio: " + errorobtenerCodigoDireccionPorNombre.getMessage());
            errorobtenerCodigoDireccionPorNombre.printStackTrace();
            //logEJBTecno.info ("****************************************************************************************");
            //logEJBTecno.info ("****************************************************************************************");
            return (vacios);
        } finally {
            try {
                //logEJBTecno.info ("*************************************************");
                //logEJBTecno.info ("*************************************************");
                //logEJBTecno.info ("CERRANDO TRANSACCION DE listarReportesCargados(java.util.Date fechaInicial, java.util.Date fechaFinal) ");
                //logEJBTecno.info ("*************************************************");
                //logEJBTecno.info ("*************************************************");
            } catch (Exception errorSQL) {
                vacios = new ArrayList<PojoReporteTecno>();
                //logEJBTecno.info ("Control de Error --> *******************************************************************");
                //logEJBTecno.info ("****************************************************************************************");
                //logEJBTecno.info ("****************************************************************************************");
                //logEJBTecno.info ("Error en base de datos de buscarRegistrosDireccionPorCriterio: " + errorSQL.getMessage());
                errorSQL.printStackTrace();
                //logEJBTecno.info ("****************************************************************************************");
                //logEJBTecno.info ("****************************************************************************************");
                return (vacios);
            }
        }

        return (resultadosBusqueda);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    /**
     *
     * @param fechaInicial
     * @param fechaFinal
     * @return
     */
    @Override
    public List<PojoDatosReporte> generarReporteReportesCargados(java.util.Date fechaInicial, java.util.Date fechaFinal, String depto) {
        List<PojoDatosReporte> reporteDatos = null;
        PojoDatosReporte registroIndividual = null;
        try {
            Query query1 = getManejadorEntidadesDireccion().createNamedQuery("reporteRegistrosCargados");
            fechaInicial.setHours(0);
            fechaInicial.setMinutes(0);
            fechaInicial.setSeconds(0);
            fechaFinal.setHours(23);
            fechaFinal.setMinutes(59);
            fechaFinal.setSeconds(59);
            query1.setParameter(1, fechaInicial);
            query1.setParameter(2, fechaFinal);
            List<Object> cursor = query1.getResultList();

            if (cursor != null) {
                reporteDatos = new ArrayList<PojoDatosReporte>();
                Iterator iteradorRegistros = cursor.iterator();
                while (iteradorRegistros.hasNext()) {
                    Object[] tupla = (Object[]) iteradorRegistros.next();
                    registroIndividual = new PojoDatosReporte();
                    registroIndividual.setReporte(String.valueOf(tupla[0]));
                    registroIndividual.setFechevento(String.valueOf(tupla[1]));
                    registroIndividual.setDescripcion_evento(String.valueOf(tupla[2]));
                    registroIndividual.setCdg_eventodeteccion(String.valueOf(tupla[3]));
                    registroIndividual.setCdg_tiporeporte(String.valueOf(tupla[4]));
                    registroIndividual.setFechreporte_evento(String.valueOf(tupla[5]));
                    registroIndividual.setCdg_origenreporte(String.valueOf(tupla[6]));
                    registroIndividual.setCdg_tipoeventoincidente(String.valueOf(tupla[7]));
                    registroIndividual.setInternet(String.valueOf(tupla[8]));
                    registroIndividual.setFechaingreso(String.valueOf(tupla[9]));
                    registroIndividual.setReportado(String.valueOf(tupla[10]));
                    registroIndividual.setDesenlace_otro(String.valueOf(tupla[11]));
                    registroIndividual.setDescripcion(String.valueOf(tupla[12]));
                    registroIndividual.setExpediente(String.valueOf(tupla[13]));
                    registroIndividual.setNroregsan(String.valueOf(tupla[14]));
                    registroIndividual.setNombre_dispositivo(String.valueOf(tupla[15]));
                    registroIndividual.setNombre_comercial(String.valueOf(tupla[16]));
                    registroIndividual.setLote(String.valueOf(tupla[17]));
                    registroIndividual.setReferencia(String.valueOf(tupla[18]));
                    registroIndividual.setModelo(String.valueOf(tupla[19]));
                    registroIndividual.setSerial(String.valueOf(tupla[20]));
                    registroIndividual.setCdg_unicodispositivo(String.valueOf(tupla[21]));
                    registroIndividual.setFabricante_usuario(String.valueOf(tupla[22]));
                    registroIndividual.setDistribuidor_usuario(String.valueOf(tupla[23]));
                    registroIndividual.setUtilizado(String.valueOf(tupla[24]));
                    registroIndividual.setArea_funciona(String.valueOf(tupla[25]));
                    registroIndividual.setDescripcion2(String.valueOf(tupla[26]));
                    registroIndividual.setTipidentificacion(String.valueOf(tupla[27]));
                    registroIndividual.setIdentificacion(String.valueOf(tupla[28]));
                    registroIndividual.setEdad(String.valueOf(tupla[29]));
                    registroIndividual.setEdad_en(String.valueOf(tupla[30]));
                    registroIndividual.setGenero(String.valueOf(tupla[31]));
                    registroIndividual.setDiagnostico_paciente(String.valueOf(tupla[32]));
                    registroIndividual.setInstitucion_reportente(String.valueOf(tupla[33]));
                    registroIndividual.setNaturaleza(String.valueOf(tupla[34]));
                    registroIndividual.setDireccion_reportante(String.valueOf(tupla[35]));
                    registroIndividual.setDescripcion3(String.valueOf(tupla[36]));
                    registroIndividual.setDescripcion4(String.valueOf(tupla[37]));
                    registroIndividual.setTelefono_reportante(String.valueOf(tupla[38]));
                    registroIndividual.setEmail_reportante(String.valueOf(tupla[39]));
                    registroIndividual.setContacto_reportante(String.valueOf(tupla[40]));
                    registroIndividual.setInstitucion_incidente(String.valueOf(tupla[41]));
                    registroIndividual.setIdentificacion1(String.valueOf(tupla[42]));
                    registroIndividual.setDescripcion5(String.valueOf(tupla[43]));
                    registroIndividual.setDescripcion6(String.valueOf(tupla[44]));
                    registroIndividual.setNivel_complejidad(String.valueOf(tupla[45]));
                    registroIndividual.setDescripcion7(String.valueOf(tupla[46]));
                    registroIndividual.setFecha_notif(String.valueOf(tupla[47]));
                    registroIndividual.setAutorizacion(String.valueOf(tupla[48]));
                    registroIndividual.setTipo_reportante(String.valueOf(tupla[49]));
                    registroIndividual.setTermino_ea(String.valueOf(tupla[50]));
                    registroIndividual.setAcciones(String.valueOf(tupla[51]));
                    registroIndividual.setExp_alertas(String.valueOf(tupla[52]));
                    registroIndividual.setDescripcion_alerta(String.valueOf(tupla[53]));
                    registroIndividual.setEstado_caso(String.valueOf(tupla[54]));
                    registroIndividual.setNumero(String.valueOf(tupla[55]));
                    registroIndividual.setRisarh(String.valueOf(tupla[56]));
                    registroIndividual.setDescripcion_alerta1(String.valueOf(tupla[57]));
                    registroIndividual.setExpediente_dm(String.valueOf(tupla[58]));
                    registroIndividual.setDescripcion8(String.valueOf(tupla[59]));
                    registroIndividual.setSeguimiento(String.valueOf(tupla[60]));
                    registroIndividual.setMedida_ejecutada(String.valueOf(tupla[61]));
                    registroIndividual.setNotificacion(String.valueOf(tupla[62]));
                    registroIndividual.setFecha_notificacion(String.valueOf(tupla[63]));
                    registroIndividual.setFecha_importador(String.valueOf(tupla[64]));
                    registroIndividual.setDispositivo_evaluacion(String.valueOf(tupla[65]));
                    registroIndividual.setEnviado_importador(String.valueOf(tupla[66]));
                    registroIndividual.setNmbfuncionario(String.valueOf(tupla[67]));
                    registroIndividual.setNit_reportante(String.valueOf(tupla[68]));
                    registroIndividual.setId_rol(String.valueOf(tupla[69]));
                    registroIndividual.setPrecolCaso(String.valueOf(tupla[70]));
                    registroIndividual.setHabilitado(String.valueOf(tupla[71]));
                    reporteDatos.add(registroIndividual);
                }
            }
        } catch (Exception errorGeneracionMUID) {
            errorGeneracionMUID.printStackTrace();
            List<PojoDatosReporte> vacio = new ArrayList<PojoDatosReporte>();
            return (vacio);
        }
        return (reporteDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<PojoDatosReporte> generarReporteReportesParaSecretarias(java.util.Date fechaInicial, java.util.Date fechaFinal, String depto) {
        List<PojoDatosReporte> reporteDatos = null;
        PojoDatosReporte registroIndividual = null;
        try {
            Query query1 = getManejadorEntidadesDireccion().createNamedQuery("reporteRegistrosCargadosPORdept");
            fechaInicial.setHours(0);
            fechaInicial.setMinutes(0);
            fechaInicial.setSeconds(0);
            fechaFinal.setHours(23);
            fechaFinal.setMinutes(59);
            fechaFinal.setSeconds(59);
            query1.setParameter(1, fechaInicial);
            query1.setParameter(2, fechaFinal);
            query1.setParameter(3, depto);
            logEJBTecno.info ("generarReporteReportesParaSecretarias, query = "+query1.toString());
            List<Object> cursor = query1.getResultList();

            if (cursor != null) {
                reporteDatos = new ArrayList<PojoDatosReporte>();
                Iterator iteradorRegistros = cursor.iterator();
                while (iteradorRegistros.hasNext()) {
                    Object[] tupla = (Object[]) iteradorRegistros.next();
                    registroIndividual = new PojoDatosReporte();
                    registroIndividual.setReporte(String.valueOf(tupla[0]));
                    registroIndividual.setFechevento(String.valueOf(tupla[1]));
                    registroIndividual.setDescripcion_evento(String.valueOf(tupla[2]));
                    registroIndividual.setCdg_eventodeteccion(String.valueOf(tupla[3]));
                    registroIndividual.setCdg_tiporeporte(String.valueOf(tupla[4]));
                    registroIndividual.setFechreporte_evento(String.valueOf(tupla[5]));
                    registroIndividual.setCdg_origenreporte(String.valueOf(tupla[6]));
                    registroIndividual.setCdg_tipoeventoincidente(String.valueOf(tupla[7]));
                    registroIndividual.setInternet(String.valueOf(tupla[8]));
                    registroIndividual.setFechaingreso(String.valueOf(tupla[9]));
                    registroIndividual.setReportado(String.valueOf(tupla[10]));
                    registroIndividual.setDesenlace_otro(String.valueOf(tupla[11]));
                    registroIndividual.setDescripcion(String.valueOf(tupla[12]));
                    registroIndividual.setExpediente(String.valueOf(tupla[13]));
                    registroIndividual.setNroregsan(String.valueOf(tupla[14]));
                    registroIndividual.setNombre_dispositivo(String.valueOf(tupla[15]));
                    registroIndividual.setNombre_comercial(String.valueOf(tupla[16]));
                    registroIndividual.setLote(String.valueOf(tupla[17]));
                    registroIndividual.setReferencia(String.valueOf(tupla[18]));
                    registroIndividual.setModelo(String.valueOf(tupla[19]));
                    registroIndividual.setSerial(String.valueOf(tupla[20]));
                    registroIndividual.setCdg_unicodispositivo(String.valueOf(tupla[21]));
                    registroIndividual.setFabricante_usuario(String.valueOf(tupla[22]));
                    registroIndividual.setDistribuidor_usuario(String.valueOf(tupla[23]));
                    registroIndividual.setUtilizado(String.valueOf(tupla[24]));
                    registroIndividual.setArea_funciona(String.valueOf(tupla[25]));
                    registroIndividual.setDescripcion2(String.valueOf(tupla[26]));
                    registroIndividual.setTipidentificacion(String.valueOf(tupla[27]));
                    registroIndividual.setIdentificacion(String.valueOf(tupla[28]));
                    registroIndividual.setEdad(String.valueOf(tupla[29]));
                    registroIndividual.setEdad_en(String.valueOf(tupla[30]));
                    registroIndividual.setGenero(String.valueOf(tupla[31]));
                    registroIndividual.setDiagnostico_paciente(String.valueOf(tupla[32]));
                    registroIndividual.setInstitucion_reportente(String.valueOf(tupla[33]));
                    registroIndividual.setNaturaleza(String.valueOf(tupla[34]));
                    registroIndividual.setDireccion_reportante(String.valueOf(tupla[35]));
                    registroIndividual.setDescripcion3(String.valueOf(tupla[36]));
                    registroIndividual.setDescripcion4(String.valueOf(tupla[37]));
                    registroIndividual.setTelefono_reportante(String.valueOf(tupla[38]));
                    registroIndividual.setEmail_reportante(String.valueOf(tupla[39]));
                    registroIndividual.setContacto_reportante(String.valueOf(tupla[40]));
                    registroIndividual.setInstitucion_incidente(String.valueOf(tupla[41]));
                    registroIndividual.setIdentificacion1(String.valueOf(tupla[42]));
                    registroIndividual.setDescripcion5(String.valueOf(tupla[43]));
                    registroIndividual.setDescripcion6(String.valueOf(tupla[44]));
                    registroIndividual.setNivel_complejidad(String.valueOf(tupla[45]));
                    registroIndividual.setDescripcion7(String.valueOf(tupla[46]));
                    registroIndividual.setFecha_notif(String.valueOf(tupla[47]));
                    registroIndividual.setAutorizacion(String.valueOf(tupla[48]));
                    registroIndividual.setTipo_reportante(String.valueOf(tupla[49]));
                    registroIndividual.setTermino_ea(String.valueOf(tupla[50]));
                    registroIndividual.setAcciones(String.valueOf(tupla[51]));
                    registroIndividual.setExp_alertas(String.valueOf(tupla[52]));
                    registroIndividual.setDescripcion_alerta(String.valueOf(tupla[53]));
                    registroIndividual.setEstado_caso(String.valueOf(tupla[54]));
                    registroIndividual.setNumero(String.valueOf(tupla[55]));
                    registroIndividual.setRisarh(String.valueOf(tupla[56]));
                    registroIndividual.setDescripcion_alerta1(String.valueOf(tupla[57]));
                    registroIndividual.setExpediente_dm(String.valueOf(tupla[58]));
                    registroIndividual.setDescripcion8(String.valueOf(tupla[59]));
                    registroIndividual.setSeguimiento(String.valueOf(tupla[60]));
                    registroIndividual.setMedida_ejecutada(String.valueOf(tupla[61]));
                    registroIndividual.setNotificacion(String.valueOf(tupla[62]));
                    registroIndividual.setFecha_notificacion(String.valueOf(tupla[63]));
                    registroIndividual.setFecha_importador(String.valueOf(tupla[64]));
                    registroIndividual.setDispositivo_evaluacion(String.valueOf(tupla[65]));
                    registroIndividual.setEnviado_importador(String.valueOf(tupla[66]));
                    registroIndividual.setNmbfuncionario(String.valueOf(tupla[67]));
                    registroIndividual.setNit_reportante(String.valueOf(tupla[68]));
                    registroIndividual.setId_rol(String.valueOf(tupla[69]));
                    registroIndividual.setPrecolCaso(String.valueOf(tupla[70]));
                    //registroIndividual.setHabilitado(String.valueOf(tupla[71]));
                    reporteDatos.add(registroIndividual);
                }
            }
        } catch (Exception errorGeneracionMUID) {
            errorGeneracionMUID.printStackTrace();
            List<PojoDatosReporte> vacio = new ArrayList<PojoDatosReporte>();
            return (vacio);
        }
        return (reporteDatos);
    }
    
    //************************************************************************************************
    @Override
    public List<PojoDatosReporte> generarReporteReportesCargados(java.util.Date fechaInicial, java.util.Date fechaFinal, String idIPS, String depto) {
        List<PojoDatosReporte> reporteDatos = null;
        PojoDatosReporte registroIndividual = null;
        int i = 0;

        try {
            getManejadorEntidadesDireccion().flush();
            Query query1 = getManejadorEntidadesDireccion().createNamedQuery("reporteRegistrosCargadosIPSSOLOPRESTADORES");
            
            
            //**************************************************************
            //**************************************************************
            fechaInicial.setHours(0);
            fechaInicial.setMinutes(0);
            fechaInicial.setSeconds(0);
            //**************************************************************
            fechaFinal.setHours(23);
            fechaFinal.setMinutes(59);
            fechaFinal.setSeconds(59);
            //**************************************************************
            //**************************************************************
            //logEJBTecno.info ("FECHA INICIAL EN EL EJB = " + fechaInicial);
            //logEJBTecno.info ("FECHA FINAL EN EL EJB = " + fechaFinal);
            //logEJBTecno.info ("NIT IPS REPORTANTE = " + idIPS);
            //**************************************************************
            //**************************************************************
            query1.setParameter(1, fechaInicial);
            query1.setParameter(2, fechaFinal);
            query1.setParameter(3, idIPS);
            query1.setParameter(4, depto);
            //**************************************************************
            //**************************************************************
            //logEJBTecno.info ("OBJETO DEL QUERY = "+ query1.toString());
            //logEJBTecno.info ("TAMAÑO DEL QUERY = "+ query1.getMaxResults());
            List<Object> cursor = query1.getResultList();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                reporteDatos = new ArrayList<PojoDatosReporte>();
                //logEJBTecno.info ("TAMAÑO DEL CURSOR = " + cursor.size());
                Iterator iteradorRegistros = cursor.iterator();

                while (iteradorRegistros.hasNext()) {
                    Object[] tupla = (Object[]) iteradorRegistros.next();
                    registroIndividual = new PojoDatosReporte();
                    //********************************************************************
                    //********************************************************************
                    registroIndividual.setReporte(String.valueOf(tupla[0]));
                    registroIndividual.setFechevento(String.valueOf(tupla[1]));
                    registroIndividual.setDescripcion_evento(String.valueOf(tupla[2]));
                    registroIndividual.setCdg_eventodeteccion(String.valueOf(tupla[3]));
                    registroIndividual.setCdg_tiporeporte(String.valueOf(tupla[4]));
                    registroIndividual.setFechreporte_evento(String.valueOf(tupla[5]));
                    registroIndividual.setCdg_origenreporte(String.valueOf(tupla[6]));
                    registroIndividual.setCdg_tipoeventoincidente(String.valueOf(tupla[7]));
                    registroIndividual.setInternet(String.valueOf(tupla[8]));
                    registroIndividual.setFechaingreso(String.valueOf(tupla[9]));
                    registroIndividual.setReportado(String.valueOf(tupla[10]));
                    registroIndividual.setDesenlace_otro(String.valueOf(tupla[11]));
                    registroIndividual.setDescripcion(String.valueOf(tupla[12]));
                    registroIndividual.setExpediente(String.valueOf(tupla[13]));
                    registroIndividual.setNroregsan(String.valueOf(tupla[14]));
                    registroIndividual.setNombre_dispositivo(String.valueOf(tupla[15]));
                    registroIndividual.setNombre_comercial(String.valueOf(tupla[16]));
                    registroIndividual.setLote(String.valueOf(tupla[17]));
                    registroIndividual.setReferencia(String.valueOf(tupla[18]));
                    registroIndividual.setModelo(String.valueOf(tupla[19]));
                    registroIndividual.setSerial(String.valueOf(tupla[20]));
                    registroIndividual.setCdg_unicodispositivo(String.valueOf(tupla[21]));
                    registroIndividual.setFabricante_usuario(String.valueOf(tupla[22]));
                    registroIndividual.setDistribuidor_usuario(String.valueOf(tupla[23]));
                    registroIndividual.setUtilizado(String.valueOf(tupla[24]));
                    registroIndividual.setArea_funciona(String.valueOf(tupla[25]));
                    registroIndividual.setDescripcion2(String.valueOf(tupla[26]));
                    registroIndividual.setTipidentificacion(String.valueOf(tupla[27]));
                    registroIndividual.setIdentificacion(String.valueOf(tupla[28]));
                    registroIndividual.setEdad(String.valueOf(tupla[29]));
                    registroIndividual.setEdad_en(String.valueOf(tupla[30]));
                    registroIndividual.setGenero(String.valueOf(tupla[31]));
                    registroIndividual.setDiagnostico_paciente(String.valueOf(tupla[32]));
                    registroIndividual.setInstitucion_reportente(String.valueOf(tupla[33]));
                    registroIndividual.setNaturaleza(String.valueOf(tupla[34]));
                    registroIndividual.setDireccion_reportante(String.valueOf(tupla[35]));
                    registroIndividual.setDescripcion3(String.valueOf(tupla[36]));
                    registroIndividual.setDescripcion4(String.valueOf(tupla[37]));
                    registroIndividual.setTelefono_reportante(String.valueOf(tupla[38]));
                    registroIndividual.setEmail_reportante(String.valueOf(tupla[39]));
                    registroIndividual.setContacto_reportante(String.valueOf(tupla[40]));
                    registroIndividual.setInstitucion_incidente(String.valueOf(tupla[41]));
                    registroIndividual.setIdentificacion1(String.valueOf(tupla[42]));
                    registroIndividual.setDescripcion5(String.valueOf(tupla[43]));
                    registroIndividual.setDescripcion6(String.valueOf(tupla[44]));
                    registroIndividual.setNivel_complejidad(String.valueOf(tupla[45]));
                    registroIndividual.setDescripcion7(String.valueOf(tupla[46]));
                    registroIndividual.setFecha_notif(String.valueOf(tupla[47]));
                    registroIndividual.setAutorizacion(String.valueOf(tupla[48]));
                    registroIndividual.setTipo_reportante(String.valueOf(tupla[49]));
                    registroIndividual.setTermino_ea(String.valueOf(tupla[50]));
                    registroIndividual.setAcciones(String.valueOf(tupla[51]));
                    registroIndividual.setExp_alertas(String.valueOf(tupla[52]));
                    registroIndividual.setDescripcion_alerta(String.valueOf(tupla[53]));
                    registroIndividual.setEstado_caso(String.valueOf(tupla[54]));
                    registroIndividual.setNumero(String.valueOf(tupla[55]));
                    registroIndividual.setRisarh(String.valueOf(tupla[56]));
                    registroIndividual.setDescripcion_alerta1(String.valueOf(tupla[57]));
                    registroIndividual.setExpediente_dm(String.valueOf(tupla[58]));
                    registroIndividual.setDescripcion8(String.valueOf(tupla[59]));
                    registroIndividual.setSeguimiento(String.valueOf(tupla[60]));
                    registroIndividual.setMedida_ejecutada(String.valueOf(tupla[61]));
                    registroIndividual.setNotificacion(String.valueOf(tupla[62]));
                    registroIndividual.setFecha_notificacion(String.valueOf(tupla[63]));
                    registroIndividual.setFecha_importador(String.valueOf(tupla[64]));
                    registroIndividual.setDispositivo_evaluacion(String.valueOf(tupla[65]));
                    registroIndividual.setEnviado_importador(String.valueOf(tupla[66]));
                    registroIndividual.setNmbfuncionario(String.valueOf(tupla[67]));
                    registroIndividual.setNit_reportante(String.valueOf(tupla[68]));
                    registroIndividual.setId_rol(String.valueOf(tupla[69]));
                    registroIndividual.setPrecolCaso(String.valueOf(tupla[70]));
                    //***************************************************************
                    //***************************************************************
                    reporteDatos.add(registroIndividual);
                }
            }
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("---------------------------------------------->");
            //logEJBTecno.info ("TOTAL DE REGISTROS DEL REPORTE BASADO EN NATIVE QUERY = " + reporteDatos.size());
            //logEJBTecno.info ("---------------------------------------------->");
            //***************************************************************
            //***************************************************************
        } catch (Exception errorGeneracionMUID) {
            //logEJBTecno.info ("Error en la generación del método generarReporteReportesCargados = " + errorGeneracionMUID.getLocalizedMessage());
            errorGeneracionMUID.printStackTrace();
            List<PojoDatosReporte> vacio = new ArrayList<PojoDatosReporte>();
            return (vacio);
        } finally {
            try {
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("CERRANDO TRANSACCION DE NATIVE QUERY del método generarReporteReportesCargados");
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("***********************************************");
            } catch (Exception errorSQL) {
                //logEJBTecno.info ("Error de sql en el método generarReporteReportesCargados = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
            }
        }

        return (reporteDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<PojoReporteDispoExpedientes> generarReporteDispoExpedientes(java.util.Date fechaInicial, java.util.Date fechaFinal) {
        List<PojoReporteDispoExpedientes> reporteDatos = null;
        PojoReporteDispoExpedientes registroIndividual = null;
        int i = 0;

        try {
            //logEJBTecno.info ("****-----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("EJECUTANDO EL MÉTODO EN EL EJB generarReporteDispoExpedientes ");
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("VALOR = " + getManejadorEntidadesDireccion().getProperties());
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("*-********************************************************");
            Query query1 = getManejadorEntidadesDireccion().createNamedQuery("reporteDispositivosExpedientes");
            //**************************************************************
            //**************************************************************
            fechaInicial.setHours(0);
            fechaInicial.setMinutes(0);
            fechaInicial.setSeconds(0);
            //**************************************************************
            fechaFinal.setHours(23);
            fechaFinal.setMinutes(59);
            fechaFinal.setSeconds(59);
            //**************************************************************
            //**************************************************************
            //logEJBTecno.info ("FECHA INICIAL EN EL EJB = " + fechaInicial);
            //logEJBTecno.info ("FECHA FINAL EN EL EJB = " + fechaFinal);
            query1.setParameter(1, fechaInicial);
            query1.setParameter(2, fechaFinal);
            //logEJBTecno.info ("OBJETO DEL QUERY = "+ query1.toString());
            //logEJBTecno.info ("TAMAÑO DEL QUERY = "+ query1.getMaxResults());
            List<Object> cursor = query1.getResultList();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                reporteDatos = new ArrayList<PojoReporteDispoExpedientes>();
                //logEJBTecno.info ("TAMAÑO DEL CURSOR = " + cursor.size());
                Iterator iteradorRegistros = cursor.iterator();

                while (iteradorRegistros.hasNext()) {
                    Object[] tupla = (Object[]) iteradorRegistros.next();
                    registroIndividual = new PojoReporteDispoExpedientes();
                    //********************************************************************
                    //********************************************************************
                    registroIndividual.setReporte(String.valueOf(tupla[0]));
                    registroIndividual.setFechaingreso(String.valueOf(tupla[1]));
                    registroIndividual.setExpediente(String.valueOf(tupla[2]));
                    registroIndividual.setNroregsan(String.valueOf(tupla[3]));
                    registroIndividual.setNombre_dispositivo(String.valueOf(tupla[4]));
                    registroIndividual.setNombre_comercial(String.valueOf(tupla[5]));
                    registroIndividual.setLote(String.valueOf(tupla[6]));
                    registroIndividual.setReferencia(String.valueOf(tupla[7]));
                    registroIndividual.setModelo(String.valueOf(tupla[8]));
                    registroIndividual.setSerial(String.valueOf(tupla[9]));
                    registroIndividual.setCdg_unicodispositivo(String.valueOf(tupla[10]));
                    registroIndividual.setFabricante_usuario(String.valueOf(tupla[11]));
                    registroIndividual.setDistribuidor_usuario(String.valueOf(tupla[12]));
                    registroIndividual.setUtilizado(String.valueOf(tupla[13]));
                    registroIndividual.setArea_funciona(String.valueOf(tupla[14]));
                    registroIndividual.setDescripcion(String.valueOf(tupla[15]));
                    registroIndividual.setNroexpediente(String.valueOf(tupla[16]));
                    registroIndividual.setNombre_producto(String.valueOf(tupla[17]));
                    registroIndividual.setNroregsan(String.valueOf(tupla[18]));
                    registroIndividual.setRiesgo(String.valueOf(tupla[19]));
                    registroIndividual.setMiembroscomprometidos(String.valueOf(tupla[20]));
                    registroIndividual.setClasificacion(String.valueOf(tupla[21]));
                    registroIndividual.setNivel_riesgo(String.valueOf(tupla[22]));
                    registroIndividual.setObservacion(String.valueOf(tupla[23]));
                    registroIndividual.setReferencias(String.valueOf(tupla[24]));
                    registroIndividual.setSistemas(String.valueOf(tupla[25]));
                    registroIndividual.setModelo_autorizado(String.valueOf(tupla[26]));
                    registroIndividual.setTipo_dispositivo(String.valueOf(tupla[27]));
                    registroIndividual.setFabricante(String.valueOf(tupla[28]));
                    registroIndividual.setImportador(String.valueOf(tupla[29]));
                    registroIndividual.setMarca(String.valueOf(tupla[30]));
                    registroIndividual.setTitular(String.valueOf(tupla[31]));
                    registroIndividual.setUso(String.valueOf(tupla[32]));
                    registroIndividual.setNroexpediente(String.valueOf(tupla[33]));
                    registroIndividual.setCdgrol1(String.valueOf(tupla[34]));
                    registroIndividual.setNombre1(String.valueOf(tupla[35]));
                    registroIndividual.setPais1(String.valueOf(tupla[36]));
                    registroIndividual.setCiudad1(String.valueOf(tupla[37]));
                    registroIndividual.setDireccion1(String.valueOf(tupla[38]));
                    registroIndividual.setCdgrol2(String.valueOf(tupla[39]));
                    registroIndividual.setNombre2(String.valueOf(tupla[40]));
                    registroIndividual.setPais2(String.valueOf(tupla[41]));
                    registroIndividual.setCiudad2(String.valueOf(tupla[42]));
                    registroIndividual.setDireccion2(String.valueOf(tupla[43]));
                    registroIndividual.setNumero(String.valueOf(tupla[44]));
                    //***************************************************************
                    //***************************************************************
                    reporteDatos.add(registroIndividual);
                }
            }
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("---------------------------------------------->");
            //logEJBTecno.info ("TOTAL DE REGISTROS DEL REPORTE BASADO EN NATIVE QUERY = " + reporteDatos.size());
            //logEJBTecno.info ("---------------------------------------------->");
            //***************************************************************
            //***************************************************************
        } catch (Exception errorGeneracionMUID) {
            //logEJBTecno.info ("Error en la generación del método generarReporteDispoExpedientes = " + errorGeneracionMUID.getLocalizedMessage());
            errorGeneracionMUID.printStackTrace();
            List<PojoReporteDispoExpedientes> vacio = new ArrayList<PojoReporteDispoExpedientes>();
            return (vacio);
        } finally {
            try {
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("CERRANDO TRANSACCION DE NATIVE QUERY del método generarReporteDispoExpedientes");
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("***********************************************");
            } catch (Exception errorSQL) {
                //logEJBTecno.info ("Error de sql en el método generarReporteDispoExpedientes = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
            }
        }

        return (reporteDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<PojoReporteInscripcionRed> generarReporteInscripcionRed(java.util.Date fechaInicial, java.util.Date fechaFinal) {
        List<PojoReporteInscripcionRed> reporteDatos = null;
        PojoReporteInscripcionRed registroIndividual = null;
        int i = 0;

        try {
            //logEJBTecno.info ("****-----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("EJECUTANDO EL MÉTODO EN EL EJB generarReporteInscripcionRed ");
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("VALOR = " + getManejadorEntidadesDireccion().getProperties());
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("*-********************************************************");
            Query query1 = getManejadorEntidadesDireccion().createNamedQuery("reporteInscripcionRed");
            //**************************************************************
            //**************************************************************
            fechaInicial.setHours(0);
            fechaInicial.setMinutes(0);
            fechaInicial.setSeconds(0);
            //**************************************************************
            fechaFinal.setHours(23);
            fechaFinal.setMinutes(59);
            fechaFinal.setSeconds(59);
            //**************************************************************
            //**************************************************************
            //logEJBTecno.info ("FECHA INICIAL EN EL EJB = " + fechaInicial);
            //logEJBTecno.info ("FECHA FINAL EN EL EJB = " + fechaFinal);
            query1.setParameter(1, fechaInicial);
            query1.setParameter(2, fechaFinal);
            //logEJBTecno.info ("OBJETO DEL QUERY = "+ query1.toString());
            //logEJBTecno.info ("TAMAÑO DEL QUERY = "+ query1.getMaxResults());
            List<Object> cursor = query1.getResultList();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                reporteDatos = new ArrayList<PojoReporteInscripcionRed>();
                //logEJBTecno.info ("TAMAÑO DEL CURSOR = " + cursor.size());
                Iterator iteradorRegistros = cursor.iterator();

                while (iteradorRegistros.hasNext()) {
                    Object[] tupla = (Object[]) iteradorRegistros.next();
                    registroIndividual = new PojoReporteInscripcionRed();
                    //********************************************************************
                    //********************************************************************
                    registroIndividual.setId(String.valueOf(tupla[0]));
                    registroIndividual.setFecha_solicitud(String.valueOf(tupla[1]));
                    registroIndividual.setNit(String.valueOf(tupla[2]));
                    registroIndividual.setNombre_institucion(String.valueOf(tupla[3]));
                    registroIndividual.setDireccion_organizacion(String.valueOf(tupla[4]));
                    registroIndividual.setDescripcion(String.valueOf(tupla[5]));
                    registroIndividual.setPais(String.valueOf(tupla[6]));
                    registroIndividual.setDescripcion1(String.valueOf(tupla[7]));
                    registroIndividual.setDescripcion2(String.valueOf(tupla[8]));
                    registroIndividual.setCaracter(String.valueOf(tupla[9]));
                    registroIndividual.setComplejidad(String.valueOf(tupla[10]));
                    registroIndividual.setEmail_corporativo(String.valueOf(tupla[11]));
                    registroIndividual.setTelefono_organiz(String.valueOf(tupla[12]));
                    registroIndividual.setFax_organiz(String.valueOf(tupla[13]));
                    registroIndividual.setArea_empresa(String.valueOf(tupla[14]));
                    registroIndividual.setCargos(String.valueOf(tupla[15]));
                    registroIndividual.setNombre_solic(String.valueOf(tupla[16]));
                    registroIndividual.setDireccion_solicitante(String.valueOf(tupla[17]));
                    registroIndividual.setDescripcion3(String.valueOf(tupla[18]));
                    registroIndividual.setCedula_solicitante(String.valueOf(tupla[19]));
                    registroIndividual.setPais(String.valueOf(tupla[20]));
                    registroIndividual.setDescripcion4(String.valueOf(tupla[21]));
                    registroIndividual.setDescripcion5(String.valueOf(tupla[22]));
                    registroIndividual.setTelefono_solic(String.valueOf(tupla[23]));
                    registroIndividual.setCelular_solic(String.valueOf(tupla[24]));
                    registroIndividual.setEmail_personal(String.valueOf(tupla[25]));
                    registroIndividual.setNmbfuncionario(String.valueOf(tupla[26]));
                    //***************************************************************
                    //***************************************************************
                    reporteDatos.add(registroIndividual);
                }
            }
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("---------------------------------------------->");
            //logEJBTecno.info ("TOTAL DE REGISTROS DEL REPORTE BASADO EN NATIVE QUERY = " + reporteDatos.size());
            //logEJBTecno.info ("---------------------------------------------->");
            //***************************************************************
            //***************************************************************
        } catch (Exception errorGeneracionMUID) {
            //logEJBTecno.info ("Error en la generación del método generarReporteInscripcionRed = " + errorGeneracionMUID.getLocalizedMessage());
            errorGeneracionMUID.printStackTrace();
            List<PojoReporteInscripcionRed> vacio = new ArrayList<PojoReporteInscripcionRed>();
            return (vacio);
        } finally {
            try {
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("CERRANDO TRANSACCION DE NATIVE QUERY del método generarReporteInscripcionRed");
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("***********************************************");
            } catch (Exception errorSQL) {
                //logEJBTecno.info ("Error de sql en el método generarReporteInscripcionRed = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
            }
        }

        return (reporteDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<PojoReporteMonitoreo> generarReporteMonitoreo(java.util.Date fechaInicial, java.util.Date fechaFinal) {
        List<PojoReporteMonitoreo> reporteDatos = null;
        PojoReporteMonitoreo registroIndividual = null;
        int i = 0;

        try {

            Query query1 = getManejadorEntidadesDireccion().createNamedQuery("reporteMonitoreo");
            fechaInicial.setHours(0);
            fechaInicial.setMinutes(0);
            fechaInicial.setSeconds(0);
            fechaFinal.setHours(23);
            fechaFinal.setMinutes(59);
            fechaFinal.setSeconds(59);

            query1.setParameter(1, fechaInicial);
            query1.setParameter(2, fechaFinal);
            List<Object> cursor = query1.getResultList();
            if (cursor != null) {
                reporteDatos = new ArrayList<PojoReporteMonitoreo>();
                Iterator iteradorRegistros = cursor.iterator();

                while (iteradorRegistros.hasNext()) {
                    Object[] tupla = (Object[]) iteradorRegistros.next();
                    registroIndividual = new PojoReporteMonitoreo();
                    registroIndividual.setRisarh(String.valueOf(tupla[0]));
                    registroIndividual.setFecha_ingreso(String.valueOf(tupla[1]));
                    registroIndividual.setDescripcion(String.valueOf(tupla[2]));
                    registroIndividual.setFuente(String.valueOf(tupla[3]));
                    registroIndividual.setDetalles(String.valueOf(tupla[4]));
                    registroIndividual.setAplica(String.valueOf(tupla[5]));
                    registroIndividual.setNmbfuncionario(String.valueOf(tupla[6]));
                    registroIndividual.setPagina_web(String.valueOf(tupla[7]));
                    registroIndividual.setInternet(String.valueOf(tupla[8]));
                    reporteDatos.add(registroIndividual);
                }
            }
        } catch (Exception errorGeneracionMUID) {
            errorGeneracionMUID.printStackTrace();
            List<PojoReporteMonitoreo> vacio = new ArrayList<PojoReporteMonitoreo>();
            return (vacio);
        }

        return (reporteDatos);
    }

    @Override
    public List<PojoReporteAlertas> generarReporteAlertas(java.util.Date fechaInicial, java.util.Date fechaFinal) {
        List<PojoReporteAlertas> reporteDatos = null;
        PojoReporteAlertas registroIndividual = null;

        try {
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("EJECUTANDO EL MÉTODO EN EL EJB generarReporteAlertas ");
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("VALOR = " + getManejadorEntidadesDireccion().getProperties());
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("*-********************************************************");
            Query query1 = getManejadorEntidadesDireccion().createNamedQuery("reporteAlertas");
            //**************************************************************
            //**************************************************************
            fechaInicial.setHours(0);
            fechaInicial.setMinutes(0);
            fechaInicial.setSeconds(0);
            //**************************************************************
            fechaFinal.setHours(23);
            fechaFinal.setMinutes(59);
            fechaFinal.setSeconds(59);
            //**************************************************************
            //**************************************************************
            //logEJBTecno.info ("FECHA INICIAL EN EL EJB = " + fechaInicial);
            //logEJBTecno.info ("FECHA FINAL EN EL EJB = " + fechaFinal);
            query1.setParameter(1, fechaInicial);
            query1.setParameter(2, fechaFinal);
            //logEJBTecno.info ("OBJETO DEL QUERY = "+ query1.toString());
            //logEJBTecno.info ("TAMAÑO DEL QUERY = "+ query1.getMaxResults());
            List<Object> cursor = query1.getResultList();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                reporteDatos = new ArrayList<PojoReporteAlertas>();
                //logEJBTecno.info ("TAMAÑO DEL CURSOR = " + cursor.size());
                Iterator iteradorRegistros = cursor.iterator();

                while (iteradorRegistros.hasNext()) {
                    Object[] tupla = (Object[]) iteradorRegistros.next();
                    registroIndividual = new PojoReporteAlertas();
                    //********************************************************************
                    //********************************************************************
                    registroIndividual.setRisarh(String.valueOf(tupla[0]));
                    registroIndividual.setFecha_radicado(String.valueOf(tupla[1]));
                    registroIndividual.setDescripcion(String.valueOf(tupla[2]));
                    registroIndividual.setExpediente_dm(String.valueOf(tupla[3]));
                    registroIndividual.setNroregsan(String.valueOf(tupla[4]));
                    registroIndividual.setFecha_ingreso(String.valueOf(tupla[5]));
                    registroIndividual.setNombre_dm(String.valueOf(tupla[6]));
                    registroIndividual.setMarca(String.valueOf(tupla[7]));
                    registroIndividual.setModelo(String.valueOf(tupla[8]));
                    registroIndividual.setCdg_priorizacion(String.valueOf(tupla[9]));
                    registroIndividual.setEstado(String.valueOf(tupla[10]));
                    registroIndividual.setCausas(String.valueOf(tupla[11]));
                    registroIndividual.setMedidas_tomadas(String.valueOf(tupla[12]));
                    registroIndividual.setLote(String.valueOf(tupla[13]));
                    registroIndividual.setTipodisposivito(String.valueOf(tupla[14]));
                    registroIndividual.setSerial(String.valueOf(tupla[15]));
                    registroIndividual.setDescripcion2(String.valueOf(tupla[16]));
                    registroIndividual.setPais(String.valueOf(tupla[17]));
                    registroIndividual.setDescripcion3(String.valueOf(tupla[18]));
                    registroIndividual.setDescripcion4(String.valueOf(tupla[19]));
                    registroIndividual.setSeguimiento(String.valueOf(tupla[20]));
                    registroIndividual.setConsecutivo_reporte(String.valueOf(tupla[21]));
                    registroIndividual.setRazon_social_notificante(String.valueOf(tupla[22]));
                    registroIndividual.setNit(String.valueOf(tupla[23]));
                    registroIndividual.setDireccion(String.valueOf(tupla[24]));
                    registroIndividual.setTelefono(String.valueOf(tupla[25]));
                    registroIndividual.setDescripcion5(String.valueOf(tupla[26]));
                    registroIndividual.setEmail(String.valueOf(tupla[27]));
                    registroIndividual.setEstado_dm(String.valueOf(tupla[28]));
                    registroIndividual.setReporte_eventos(String.valueOf(tupla[29]));
                    registroIndividual.setCuantos_eventos(String.valueOf(tupla[30]));
                    registroIndividual.setDescripcion_evento(String.valueOf(tupla[31]));
                    registroIndividual.setDescripcion6(String.valueOf(tupla[32]));
                    registroIndividual.setDescripcion7(String.valueOf(tupla[33]));
                    registroIndividual.setDescripcion8(String.valueOf(tupla[34]));
                    registroIndividual.setDescripcion9(String.valueOf(tupla[35]));
                    registroIndividual.setDescripcion10(String.valueOf(tupla[36]));
                    registroIndividual.setFecha_hurto(String.valueOf(tupla[37]));
                    registroIndividual.setFiscalia(String.valueOf(tupla[38]));
                    registroIndividual.setAutorizacion(String.valueOf(tupla[39]));
                    registroIndividual.setDescripcion_hurto(String.valueOf(tupla[40]));
                    registroIndividual.setMedidas_invima(String.valueOf(tupla[41]));
                    registroIndividual.setNombre_notificante(String.valueOf(tupla[42]));
                    registroIndividual.setValor_prioriza(String.valueOf(tupla[43]));
                    registroIndividual.setNombre_agencia(String.valueOf(tupla[44]));
                    registroIndividual.setInternet(String.valueOf(tupla[45]));
                    registroIndividual.setOtro_estadodm(String.valueOf(tupla[46]));
                    registroIndividual.setCdg_riesgo(String.valueOf(tupla[47]));
                    registroIndividual.setNit_reportante(String.valueOf(tupla[48]));
                    registroIndividual.setAplica(String.valueOf(tupla[49]));
                    //***************************************************************
                    //***************************************************************
                    reporteDatos.add(registroIndividual);
                }
            }
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("---------------------------------------------->");
            //logEJBTecno.info ("TOTAL DE REGISTROS DEL REPORTE BASADO EN NATIVE QUERY = " + reporteDatos.size());
            //logEJBTecno.info ("---------------------------------------------->");
            //***************************************************************
            //***************************************************************
        } catch (Exception errorGeneracionMUID) {
            //logEJBTecno.info ("Error en la generación del método generarReporteAlertas = " + errorGeneracionMUID.getLocalizedMessage());
            errorGeneracionMUID.printStackTrace();
            List<PojoReporteAlertas> vacio = new ArrayList<PojoReporteAlertas>();
            return (vacio);
        } finally {
            try {
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("CERRANDO TRANSACCION DE NATIVE QUERY del método generarReporteAlertas");
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("***********************************************");
            } catch (Exception errorSQL) {
                //logEJBTecno.info ("Error de sql en el método generarReporteAlertas = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
            }
        }

        return (reporteDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<PojoReporteAlertas> generarReporteAlertas(java.util.Date fechaInicial, java.util.Date fechaFinal, String idIPS) {
        List<PojoReporteAlertas> reporteDatos = null;
        PojoReporteAlertas registroIndividual = null;

        try {
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("EJECUTANDO EL MÉTODO EN EL EJB generarReporteAlertas con NIT de IPS");
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("VALOR = " + getManejadorEntidadesDireccion().getProperties());
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("*-********************************************************");
            Query query1 = getManejadorEntidadesDireccion().createNamedQuery("reporteAlertasIPS");
            //**************************************************************
            //**************************************************************
            fechaInicial.setHours(0);
            fechaInicial.setMinutes(0);
            fechaInicial.setSeconds(0);
            //**************************************************************
            fechaFinal.setHours(23);
            fechaFinal.setMinutes(59);
            fechaFinal.setSeconds(59);
            //**************************************************************
            //**************************************************************
            //logEJBTecno.info ("FECHA INICIAL EN EL EJB = " + fechaInicial);
            //logEJBTecno.info ("FECHA FINAL EN EL EJB = " + fechaFinal);
            //logEJBTecno.info ("NIT DE IPS PARA EL QUERY = " + idIPS);
            //**************************************************************
            //**************************************************************
            query1.setParameter(1, fechaInicial);
            query1.setParameter(2, fechaFinal);
            query1.setParameter(3, idIPS);
            //**************************************************************
            //**************************************************************
            //logEJBTecno.info ("OBJETO DEL QUERY = "+ query1.toString());
            //logEJBTecno.info ("TAMAÑO DEL QUERY = "+ query1.getMaxResults());
            List<Object> cursor = query1.getResultList();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                reporteDatos = new ArrayList<PojoReporteAlertas>();
                //logEJBTecno.info ("TAMAÑO DEL CURSOR = " + cursor.size());
                Iterator iteradorRegistros = cursor.iterator();

                while (iteradorRegistros.hasNext()) {
                    Object[] tupla = (Object[]) iteradorRegistros.next();
                    registroIndividual = new PojoReporteAlertas();
                    //********************************************************************
                    //********************************************************************
                    registroIndividual.setRisarh(String.valueOf(tupla[0]));
                    registroIndividual.setFecha_radicado(String.valueOf(tupla[1]));
                    registroIndividual.setDescripcion(String.valueOf(tupla[2]));
                    registroIndividual.setExpediente_dm(String.valueOf(tupla[3]));
                    registroIndividual.setNroregsan(String.valueOf(tupla[4]));
                    registroIndividual.setFecha_ingreso(String.valueOf(tupla[5]));
                    registroIndividual.setNombre_dm(String.valueOf(tupla[6]));
                    registroIndividual.setMarca(String.valueOf(tupla[7]));
                    registroIndividual.setModelo(String.valueOf(tupla[8]));
                    registroIndividual.setCdg_priorizacion(String.valueOf(tupla[9]));
                    registroIndividual.setEstado(String.valueOf(tupla[10]));
                    registroIndividual.setCausas(String.valueOf(tupla[11]));
                    registroIndividual.setMedidas_tomadas(String.valueOf(tupla[12]));
                    registroIndividual.setLote(String.valueOf(tupla[13]));
                    registroIndividual.setTipodisposivito(String.valueOf(tupla[14]));
                    registroIndividual.setSerial(String.valueOf(tupla[15]));
                    registroIndividual.setDescripcion2(String.valueOf(tupla[16]));
                    registroIndividual.setPais(String.valueOf(tupla[17]));
                    registroIndividual.setDescripcion3(String.valueOf(tupla[18]));
                    registroIndividual.setDescripcion4(String.valueOf(tupla[19]));
                    registroIndividual.setSeguimiento(String.valueOf(tupla[20]));
                    registroIndividual.setConsecutivo_reporte(String.valueOf(tupla[21]));
                    registroIndividual.setRazon_social_notificante(String.valueOf(tupla[22]));
                    registroIndividual.setNit(String.valueOf(tupla[23]));
                    registroIndividual.setDireccion(String.valueOf(tupla[24]));
                    registroIndividual.setTelefono(String.valueOf(tupla[25]));
                    registroIndividual.setDescripcion5(String.valueOf(tupla[26]));
                    registroIndividual.setEmail(String.valueOf(tupla[27]));
                    registroIndividual.setEstado_dm(String.valueOf(tupla[28]));
                    registroIndividual.setReporte_eventos(String.valueOf(tupla[29]));
                    registroIndividual.setCuantos_eventos(String.valueOf(tupla[30]));
                    registroIndividual.setDescripcion_evento(String.valueOf(tupla[31]));
                    registroIndividual.setDescripcion6(String.valueOf(tupla[32]));
                    registroIndividual.setDescripcion7(String.valueOf(tupla[33]));
                    registroIndividual.setDescripcion8(String.valueOf(tupla[34]));
                    registroIndividual.setDescripcion9(String.valueOf(tupla[35]));
                    registroIndividual.setDescripcion10(String.valueOf(tupla[36]));
                    registroIndividual.setFecha_hurto(String.valueOf(tupla[37]));
                    registroIndividual.setFiscalia(String.valueOf(tupla[38]));
                    registroIndividual.setAutorizacion(String.valueOf(tupla[39]));
                    registroIndividual.setDescripcion_hurto(String.valueOf(tupla[40]));
                    registroIndividual.setMedidas_invima(String.valueOf(tupla[41]));
                    registroIndividual.setNombre_notificante(String.valueOf(tupla[42]));
                    registroIndividual.setValor_prioriza(String.valueOf(tupla[43]));
                    registroIndividual.setNombre_agencia(String.valueOf(tupla[44]));
                    registroIndividual.setInternet(String.valueOf(tupla[45]));
                    registroIndividual.setOtro_estadodm(String.valueOf(tupla[46]));
                    registroIndividual.setCdg_riesgo(String.valueOf(tupla[47]));
                    registroIndividual.setNit_reportante(String.valueOf(tupla[48]));
                    registroIndividual.setAplica(String.valueOf(tupla[49]));
                    //***************************************************************
                    //***************************************************************
                    reporteDatos.add(registroIndividual);
                }
            }
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("---------------------------------------------->");
            //logEJBTecno.info ("TOTAL DE REGISTROS DEL REPORTE BASADO EN NATIVE QUERY = " + reporteDatos.size());
            //logEJBTecno.info ("---------------------------------------------->");
            //***************************************************************
            //***************************************************************
        } catch (Exception errorGeneracionMUID) {
            //logEJBTecno.info ("Error en la generación del método generarReporteAlertas = " + errorGeneracionMUID.getLocalizedMessage());
            errorGeneracionMUID.printStackTrace();
            List<PojoReporteAlertas> vacio = new ArrayList<PojoReporteAlertas>();
            return (vacio);
        } finally {
            try {
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("CERRANDO TRANSACCION DE NATIVE QUERY del método generarReporteAlertas");
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("***********************************************");
            } catch (Exception errorSQL) {
                //logEJBTecno.info ("Error de sql en el método generarReporteAlertas = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
            }
        }

        return (reporteDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<PojoReporteConsecutivos> generarReporteConsecutivos(java.util.Date fechaInicial, java.util.Date fechaFinal) {
        List<PojoReporteConsecutivos> reporteDatos = null;
        PojoReporteConsecutivos registroIndividual = null;

        try {
            //logEJBTecno.info ("****-----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("EJECUTANDO EL MÉTODO EN EL EJB generarReporteConsecutivos ");
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("VALOR = " + getManejadorEntidadesDireccion().getProperties());
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("*-********************************************************");
            Query query1 = getManejadorEntidadesDireccion().createNamedQuery("reporteConsecutivos");
            //**************************************************************
            //**************************************************************
            fechaInicial.setHours(0);
            fechaInicial.setMinutes(0);
            fechaInicial.setSeconds(0);
            //**************************************************************
            fechaFinal.setHours(23);
            fechaFinal.setMinutes(59);
            fechaFinal.setSeconds(59);
            //**************************************************************
            //**************************************************************
            //logEJBTecno.info ("FECHA INICIAL EN EL EJB = " + fechaInicial);
            //logEJBTecno.info ("FECHA FINAL EN EL EJB = " + fechaFinal);
            query1.setParameter(1, fechaInicial);
            query1.setParameter(2, fechaFinal);
            //logEJBTecno.info ("OBJETO DEL QUERY = "+ query1.toString());
            //logEJBTecno.info ("TAMAÑO DEL QUERY = "+ query1.getMaxResults());
            List<Object> cursor = query1.getResultList();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                reporteDatos = new ArrayList<PojoReporteConsecutivos>();
                //logEJBTecno.info ("TAMAÑO DEL CURSOR = " + cursor.size());
                Iterator iteradorRegistros = cursor.iterator();

                while (iteradorRegistros.hasNext()) {
                    Object[] tupla = (Object[]) iteradorRegistros.next();
                    registroIndividual = new PojoReporteConsecutivos();
                    //********************************************************************
                    //********************************************************************
                    registroIndividual.setId(String.valueOf(tupla[0]));
                    registroIndividual.setConsecutivo(String.valueOf(tupla[1]));
                    registroIndividual.setReporte(String.valueOf(tupla[2]));
                    registroIndividual.setNombre_solic(String.valueOf(tupla[3]));
                    registroIndividual.setApellidos_solic(String.valueOf(tupla[4]));
                    registroIndividual.setCargo(String.valueOf(tupla[5]));
                    registroIndividual.setRadicado(String.valueOf(tupla[6]));
                    registroIndividual.setFecha_radicado(String.valueOf(tupla[7]));
                    registroIndividual.setEntidad(String.valueOf(tupla[8]));
                    registroIndividual.setDireccion(String.valueOf(tupla[9]));
                    registroIndividual.setRespetado(String.valueOf(tupla[10]));
                    registroIndividual.setApelativo(String.valueOf(tupla[11]));
                    registroIndividual.setProyecto(String.valueOf(tupla[12]));
                    registroIndividual.setFecha_ingreso(String.valueOf(tupla[13]));
                    registroIndividual.setDescripcion(String.valueOf(tupla[14]));
                    registroIndividual.setDescripcion2(String.valueOf(tupla[15]));
                    //***************************************************************
                    //***************************************************************
                    reporteDatos.add(registroIndividual);
                }
            }
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("---------------------------------------------->");
            //logEJBTecno.info ("TOTAL DE REGISTROS DEL REPORTE BASADO EN NATIVE QUERY = " + reporteDatos.size());
            //logEJBTecno.info ("---------------------------------------------->");
            //***************************************************************
            //***************************************************************
        } catch (Exception errorGeneracionMUID) {
            //logEJBTecno.info ("Error en la generación del método generarReporteConsecutivos = " + errorGeneracionMUID.getLocalizedMessage());
            errorGeneracionMUID.printStackTrace();
            List<PojoReporteConsecutivos> vacio = new ArrayList<PojoReporteConsecutivos>();
            return (vacio);
        } finally {
            try {
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("CERRANDO TRANSACCION DE NATIVE QUERY del método generarReporteConsecutivos");
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("***********************************************");
            } catch (Exception errorSQL) {
                //logEJBTecno.info ("Error de sql en el método generarReporteConsecutivos = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
            }
        }

        return (reporteDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<PojoReporteUsuarios> generarReporteUsuarios(java.util.Date fechaInicial, java.util.Date fechaFinal) {
        List<PojoReporteUsuarios> reporteDatos = null;
        PojoReporteUsuarios registroIndividual = null;

        try {
            //logEJBTecno.info ("****-----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("EJECUTANDO EL MÉTODO EN EL EJB generarReporteUsuarios ");
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("VALOR = " + getManejadorEntidadesDireccion().getProperties());
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("*-********************************************************");
            Query query1 = getManejadorEntidadesDireccion().createNamedQuery("reporteUsuarios");
            //**************************************************************
            //**************************************************************
            fechaInicial.setHours(0);
            fechaInicial.setMinutes(0);
            fechaInicial.setSeconds(0);
            //**************************************************************
            fechaFinal.setHours(23);
            fechaFinal.setMinutes(59);
            fechaFinal.setSeconds(59);
            //**************************************************************
            //**************************************************************
            //logEJBTecno.info ("FECHA INICIAL EN EL EJB = " + fechaInicial);
            //logEJBTecno.info ("FECHA FINAL EN EL EJB = " + fechaFinal);
            query1.setParameter(1, fechaInicial);
            query1.setParameter(2, fechaFinal);
            //logEJBTecno.info ("OBJETO DEL QUERY = "+ query1.toString());
            //logEJBTecno.info ("TAMAÑO DEL QUERY = "+ query1.getMaxResults());
            List<Object> cursor = query1.getResultList();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                reporteDatos = new ArrayList<PojoReporteUsuarios>();
                //logEJBTecno.info ("TAMAÑO DEL CURSOR = " + cursor.size());
                Iterator iteradorRegistros = cursor.iterator();

                while (iteradorRegistros.hasNext()) {
                    Object[] tupla = (Object[]) iteradorRegistros.next();
                    registroIndividual = new PojoReporteUsuarios();
                    //********************************************************************
                    //********************************************************************
                    registroIndividual.setReporte(String.valueOf(tupla[0]));
                    registroIndividual.setFecha_notificacion(String.valueOf(tupla[1]));
                    registroIndividual.setNombre_dm(String.valueOf(tupla[2]));
                    registroIndividual.setNombre_comercial(String.valueOf(tupla[3]));
                    registroIndividual.setNroregsan(String.valueOf(tupla[4]));
                    registroIndividual.setLote(String.valueOf(tupla[5]));
                    registroIndividual.setReferencia(String.valueOf(tupla[6]));
                    registroIndividual.setNombre_fabricante(String.valueOf(tupla[7]));
                    registroIndividual.setNombre_distrib_import(String.valueOf(tupla[8]));
                    registroIndividual.setFecha_evento(String.valueOf(tupla[9]));
                    registroIndividual.setDescripcion_evento(String.valueOf(tupla[10]));
                    registroIndividual.setNombre_reportante(String.valueOf(tupla[11]));
                    registroIndividual.setDireccion_reportante(String.valueOf(tupla[12]));
                    registroIndividual.setTelefono(String.valueOf(tupla[13]));
                    registroIndividual.setSexo(String.valueOf(tupla[14]));
                    registroIndividual.setEdad(String.valueOf(tupla[15]));
                    registroIndividual.setEdad_en(String.valueOf(tupla[16]));
                    registroIndividual.setEmail(String.valueOf(tupla[17]));
                    registroIndividual.setPais(String.valueOf(tupla[18]));
                    registroIndividual.setDescripcion(String.valueOf(tupla[19]));
                    registroIndividual.setDescripcion2(String.valueOf(tupla[20]));
                    registroIndividual.setCdg_eventodeteccion(String.valueOf(tupla[21]));
                    registroIndividual.setConsecutivo(String.valueOf(tupla[22]));
                    registroIndividual.setNmbfuncionario(String.valueOf(tupla[23]));
                    registroIndividual.setRevisado(String.valueOf(tupla[24]));
                    //***************************************************************
                    //***************************************************************
                    reporteDatos.add(registroIndividual);
                }
            }
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("---------------------------------------------->");
            //logEJBTecno.info ("TOTAL DE REGISTROS DEL REPORTE BASADO EN NATIVE QUERY = " + reporteDatos.size());
            //logEJBTecno.info ("---------------------------------------------->");
            //***************************************************************
            //***************************************************************
        } catch (Exception errorGeneracionMUID) {
            //logEJBTecno.info ("Error en la generación del método generarReporteUsuarios = " + errorGeneracionMUID.getLocalizedMessage());
            errorGeneracionMUID.printStackTrace();
            List<PojoReporteUsuarios> vacio = new ArrayList<PojoReporteUsuarios>();
            return (vacio);
        } finally {
            try {
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("CERRANDO TRANSACCION DE NATIVE QUERY del método generarReporteUsuarios");
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("***********************************************");
            } catch (Exception errorSQL) {
                //logEJBTecno.info ("Error de sql en el método generarReporteUsuarios = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
            }
        }

        return (reporteDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<PojoReportesUsuariosInternet> generarReporteUsuariosInternet(java.util.Date fechaInicial, java.util.Date fechaFinal) {
        List<PojoReportesUsuariosInternet> reporteDatos = null;
        PojoReportesUsuariosInternet registroIndividual = null;

        try {
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("EJECUTANDO EL MÉTODO EN EL EJB generarReporteUsuariosInternet ");
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("VALOR = " + getManejadorEntidadesDireccion().getProperties());
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("*-********************************************************");
            Query query1 = getManejadorEntidadesDireccion().createNamedQuery("reporteUsuariosInternet");
            //**************************************************************
            //**************************************************************
            fechaInicial.setHours(0);
            fechaInicial.setMinutes(0);
            fechaInicial.setSeconds(0);
            //**************************************************************
            fechaFinal.setHours(23);
            fechaFinal.setMinutes(59);
            fechaFinal.setSeconds(59);
            //**************************************************************
            //**************************************************************
            //logEJBTecno.info ("FECHA INICIAL EN EL EJB = " + fechaInicial);
            //logEJBTecno.info ("FECHA FINAL EN EL EJB = " + fechaFinal);
            query1.setParameter(1, fechaInicial);
            query1.setParameter(2, fechaFinal);
            //logEJBTecno.info ("OBJETO DEL QUERY = "+ query1.toString());
            //logEJBTecno.info ("TAMAÑO DEL QUERY = "+ query1.getMaxResults());
            List<Object> cursor = query1.getResultList();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                reporteDatos = new ArrayList<PojoReportesUsuariosInternet>();
                //logEJBTecno.info ("TAMAÑO DEL CURSOR = " + cursor.size());
                Iterator iteradorRegistros = cursor.iterator();

                while (iteradorRegistros.hasNext()) {
                    Object[] tupla = (Object[]) iteradorRegistros.next();
                    registroIndividual = new PojoReportesUsuariosInternet();
                    //********************************************************************
                    //********************************************************************
                    registroIndividual.setIdentificacion_empresa(String.valueOf(tupla[0]));
                    registroIndividual.setTipidentificacion_empresa(String.valueOf(tupla[1]));
                    registroIndividual.setNombre_empresa(String.valueOf(tupla[2]));
                    registroIndividual.setDireccion_empresa(String.valueOf(tupla[3]));
                    registroIndividual.setCdg_pais(String.valueOf(tupla[4]));
                    registroIndividual.setCod_depart(String.valueOf(tupla[5]));
                    registroIndividual.setCod_mun(String.valueOf(tupla[6]));
                    registroIndividual.setTelefono_empresa(String.valueOf(tupla[7]));
                    registroIndividual.setEmail_empresa(String.valueOf(tupla[8]));
                    registroIndividual.setFax(String.valueOf(tupla[9]));
                    registroIndividual.setUrl(String.valueOf(tupla[10]));
                    registroIndividual.setIdentificacion_persona(String.valueOf(tupla[11]));
                    registroIndividual.setTipidentificacion_persona(String.valueOf(tupla[12]));
                    registroIndividual.setNombre_persona(String.valueOf(tupla[13]));
                    registroIndividual.setCargo_persona(String.valueOf(tupla[14]));
                    registroIndividual.setTelefono_persona(String.valueOf(tupla[15]));
                    registroIndividual.setEmail_persona(String.valueOf(tupla[16]));
                    registroIndividual.setUsuario(String.valueOf(tupla[17]));
                    registroIndividual.setActivo(String.valueOf(tupla[18]));
                    registroIndividual.setID_Rol_Usuario(String.valueOf(tupla[19]));
                    registroIndividual.setPregunta(String.valueOf(tupla[20]));
                    registroIndividual.setRespuesta(String.valueOf(tupla[21]));
                    registroIndividual.setFecha_ingreso(String.valueOf(tupla[22]));
                    registroIndividual.setPassword(String.valueOf(tupla[23]));
                    registroIndividual.setSession(String.valueOf(tupla[24]));
                    registroIndividual.setEstado_usuario(String.valueOf(tupla[25]));
                    registroIndividual.setClasificacion_usuario(String.valueOf(tupla[26]));
                    //***************************************************************
                    //***************************************************************
                    reporteDatos.add(registroIndividual);
                }
            }
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("---------------------------------------------->");
            //logEJBTecno.info ("TOTAL DE REGISTROS DEL REPORTE BASADO EN NATIVE QUERY = " + reporteDatos.size());
            //logEJBTecno.info ("---------------------------------------------->");
            //***************************************************************
            //***************************************************************
        } catch (Exception errorGeneracionMUID) {
            //logEJBTecno.info ("Error en la generación del método generarReporteUsuariosInternet = " + errorGeneracionMUID.getLocalizedMessage());
            errorGeneracionMUID.printStackTrace();
            List<PojoReportesUsuariosInternet> vacio = new ArrayList<PojoReportesUsuariosInternet>();
            return (vacio);
        } finally {
            try {
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("CERRANDO TRANSACCION DE NATIVE QUERY del método generarReporteUsuariosInternet");
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("***********************************************");
            } catch (Exception errorSQL) {
                //logEJBTecno.info ("Error de sql en el método generarReporteUsuariosInternet = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
            }
        }

        return (reporteDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    /**
     * @return the manejadorEntidadesDireccion
     */
    public EntityManager getManejadorEntidadesDireccion() {
        return manejadorEntidadesDireccion;
    }

    /**
     * @param manejadorEntidadesDireccion the manejadorEntidadesDireccion to set
     */
    public void setManejadorEntidadesDireccion(EntityManager manejadorEntidadesDireccion) {
        this.manejadorEntidadesDireccion = manejadorEntidadesDireccion;
    }

    /**
     * @return the contextoBean
     */
    public EJBContext getContextoBean() {
        return contextoBean;
    }

    /**
     * @param contextoBean the contextoBean to set
     */
    public void setContextoBean(EJBContext contextoBean) {
        this.contextoBean = contextoBean;
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<String> obtenerNitsEmpresasReportantesSecretaria(String depto, String rolReportante) {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Departamento de la secretaria = " + depto);
            //logEJBTecno.info ("ID ROL DE REPORTANTE DE LAS IPS DE LA SECRETARIA = " + rolReportante);
            consulta
                    = "select distinct identificacion_empresa "
                    + "from dbo.tecno_usuarios_internet tui, "
                    + "dbo.tecno_reporte_eventos datos "
                    + "where "
                    + "(datos.idips = CONVERT(varchar(30), tui.identificacion_empresa) ) and "
                    + "tui.cod_depart = ? and tui.ID_Rol_Usuario =  ? ";

            //logEJBTecno.info ("Consulta del obtenerNitsEmpresasReportantesSecretario = " + consulta);
            conexion = obtenerConexionDataSource();
            //***************************************************************
            //***************************************************************
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, depto);
            sentencia.setString(2, rolReportante);
            //***************************************************************
            //***************************************************************
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<String>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    comboDatos.add(cursor.getString(1));
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerNitsEmpresasReportantesSecretario = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            return (comboDatosVacio);
        } finally {
            try {
                if (cursor != null) {
                    cursor.close();
                }

                if (sentencia != null) {
                    sentencia.close();
                }

                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException errorSQL) {
                //logEJBTecno.info ("Error de sql = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<ReportePrecol> generarReportePrecoles(Date fechaInicial, Date fechaFinal) {
        List<ReportePrecol> comboDatos = null;
        List<ReportePrecol> comboDatosVacio = null;
        ReportePrecol registroIndividual = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";
        int i = 0;
        int j = 0;
        try {
            consulta
                    = "SELECT "
                    + "    datos.reporte as precol,  "
                    + "    (select dep.descripcion from dbo.departamentos dep where dep.cod_depart = paci.cod_depart) as departamento,  "
                    + "    (select mun.descripcion from dbo.municipios mun where mun.cod_mun = paci.cod_mun) as municipio,  "
                    + "    paci.institucion_reportente as nombre_reportante, "
                    + "    datos.idrol as id_rol, "
                    + "    datos.fechaingreso as fecha_ingreso, "
                    + "    datos.descripcion_evento as descripcionEvento,  "
                    + "    dispo.nombre_dispositivo as nombre_dispositivo, "
                    + "    datos.cdg_tipoeventoincidente, "
                    + "    evalua.cdg_causa as codigo_causa, "
                    + "    evalua.estado_caso as estado_caso, "
                    + "    paci.institucion_incidente as institucion_incidente, "
                    + "    paci.identificacion1 as nit_incidente, "
                    + "    dispo.nroregsan as registro_sanitario, "
                    + "    evalua.medida_ejecutada as medida_ejecutada, "
                    + "    CASE datos.cdg_seriedad  WHEN 1 then 'APROBADO' WHEN 0 THEN 'PENDIENTE' ELSE 'RECHAZADO ' END as codigo_seriedad "
                    + "    from   "
                    + "    dbo.tecno_reporte_eventos_temp datos,  "
                    + "    dbo.tecno_dispositivo_temp dispo, "
                    + "    dbo.tecno_paciente_temp paci, "
                    + "    dbo.tecno_evaluacion_caso_temp evalua "
                    + "    where "
                    + "    (datos.reporte = dispo.reporte) and "
                    + "    (datos.reporte = paci.reporte) and "
                    + "    (datos.reporte = evalua.reporte)  and "
                    + "    (datos.fechaingreso >= ? and datos.fechaingreso <= ?) ";
            logEJBTecno.info(consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setTimestamp(1, obtenerFechaTimeStamp(fechaInicial, "inicial"));
            sentencia.setTimestamp(2, obtenerFechaTimeStamp(fechaFinal, "final"));
            cursor = sentencia.executeQuery();
            
            if (cursor != null) {
                comboDatos = new ArrayList<ReportePrecol>();
                while (cursor.next()) {
                    registroIndividual = new ReportePrecol();
                    registroIndividual.setPrecol(cursor.getString(1));
                    registroIndividual.setDepartamento(cursor.getString(2));
                    registroIndividual.setMunicipio(cursor.getString(3));
                    registroIndividual.setNombre_reportante(cursor.getString(4));
                    registroIndividual.setId_rol(cursor.getString(5));
                    registroIndividual.setFecha_ingreso(cursor.getDate(6));
                    registroIndividual.setDescripcionEvento(cursor.getString(7));
                    registroIndividual.setNombre_dispositivo(cursor.getString(8));
                    registroIndividual.setTipo_reporte(cursor.getString(9));
                    registroIndividual.setCodigo_causa(cursor.getString(10));
                    registroIndividual.setEstadoCaso(cursor.getString(11));
                    registroIndividual.setEntidadIncidente(cursor.getString(12));
                    registroIndividual.setNitEntidadIncidente(cursor.getString(13));
                    registroIndividual.setRegistroSanitarioDisp(cursor.getString(14));
                    registroIndividual.setMedidaEjecutada(cursor.getString(15));
                    registroIndividual.setEstadoReporte(cursor.getString(16));
                    comboDatos.add(registroIndividual);
                }
            } else {
                comboDatos = new ArrayList<ReportePrecol>();
            }
        }//fin del try
        catch (Exception errorobtenerTiposDeSucursal) {
            errorobtenerTiposDeSucursal.printStackTrace();
            comboDatosVacio = new ArrayList<ReportePrecol>();
            return (comboDatosVacio);
        } finally {
            try {
                if (cursor != null) {
                    cursor.close();
                }

                if (sentencia != null) {
                    sentencia.close();
                }

                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException errorSQL) {
                //logEJBTecno.info ("Error de sql de generarReportePrecoles = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<ReportePrecol>();
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    private static java.sql.Timestamp obtenerFechaTimeStamp(java.util.Date fechaOriginal, String tipo) {
        // 1) create a java calendar instance
        // 2) get a java.util.Date from the calendar instance.
        //    this date will represent the current instant, or "now".
        // 3) a java current time (now) instance
        java.sql.Timestamp currentTimestamp = null;

        if (tipo.equals("inicial")) {
            fechaOriginal.setHours(0);
            fechaOriginal.setMinutes(0);
            fechaOriginal.setSeconds(0);
        } else {
            fechaOriginal.setHours(23);
            fechaOriginal.setMinutes(59);
            fechaOriginal.setSeconds(59);
        }

        currentTimestamp = new java.sql.Timestamp(fechaOriginal.getTime());
        //logEJBTecno.info  ("Fecha timestamp original = " + fechaOriginal.toString());
        //logEJBTecno.info  ("Fecha timestamp formateada = " + currentTimestamp.toString());

        return (currentTimestamp);
    }
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
}
