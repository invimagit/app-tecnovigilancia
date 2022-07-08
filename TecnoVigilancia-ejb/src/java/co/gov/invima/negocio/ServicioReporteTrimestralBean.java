/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.negocio;

import co.gov.invima.dao.TecnoDispositivoFacadeLocal;
import co.gov.invima.dao.TecnoDispositivoTempFacadeLocal;
import co.gov.invima.dao.TecnoEvaluacionCasoFacadeLocal;
import co.gov.invima.dao.TecnoEvaluacionCasoTempFacadeLocal;
import co.gov.invima.dao.TecnoPacienteFacadeLocal;
import co.gov.invima.dao.TecnoPacienteTempFacadeLocal;
import co.gov.invima.dao.TecnoReporteEventosFacadeLocal;
import co.gov.invima.dao.TecnoReporteEventosTempFacadeLocal;
import co.gov.invima.dto.ReportePrecol;
import co.gov.invima.entidad.TecnoDispositivo;
import co.gov.invima.entidad.TecnoDispositivoTemp;
import co.gov.invima.entidad.TecnoDispositivoTempPK;
import co.gov.invima.entidad.TecnoEvaluacionCaso;
import co.gov.invima.entidad.TecnoEvaluacionCasoTemp;
import co.gov.invima.entidad.TecnoPaciente;
import co.gov.invima.entidad.TecnoPacienteTemp;
import co.gov.invima.entidad.TecnoReporteEventos;
import co.gov.invima.entidad.TecnoReporteEventosTemp;
import static co.gov.invima.negocio.MaestrosTecnoBean.getlog;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 *
 * @author jgutierrezme
 */
@Stateless
public class ServicioReporteTrimestralBean implements ServicioReporteTrimestralRemote {

    private static Logger logEJBTecno = Logger.getLogger(MaestrosTecnoBean.class.getName());
    //************************************************************************************************
    //************************************************************************************************
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager ServicioReporteTrimestralBean;
    //************************************************************************************************
    //************************************************************************************************
    @Resource
    private EJBContext contextoBean;
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @EJB
    private TecnoReporteEventosTempFacadeLocal ejbTecnoReporteEventosTemp;
    @EJB
    private TecnoDispositivoTempFacadeLocal ejbTecnoDispositivoTemp;
    @EJB
    private TecnoPacienteTempFacadeLocal ejbTecnoPacienteTemp;
    @EJB
    private TecnoEvaluacionCasoTempFacadeLocal ejbTecnoEvaluacionCasoTemp;
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @EJB
    private TecnoReporteEventosFacadeLocal ejbTecnoReporteEventos;
    @EJB
    private TecnoDispositivoFacadeLocal ejbTecnoDispositivo;
    @EJB
    private TecnoPacienteFacadeLocal ejbTecnoPaciente;
    @EJB
    private TecnoEvaluacionCasoFacadeLocal ejbTecnoEvaluacionCaso;

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
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<String> obtenerListadoDepartamentos() {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            consulta = "select dep.cod_depart, dep.descripcion from dbo.departamentos dep where dep.cod_depart <> '00' order by dep.descripcion asc ";
            //logEJBTecno.info ("Consulta del obtenerListadoDepartamentos = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<String>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    comboDatos.add(cursor.getString(1));
                    comboDatos.add(cursor.getString(2));
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerListadoDepartamentos = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                //logEJBTecno.info ("Error de sql de obtenerListadoDepartamentos = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                comboDatosVacio.add("SIN VALOR");
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<String> obtenerListadoDepartamentos(String deptoActivo) {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            consulta = "select dep.cod_depart, dep.descripcion from dbo.departamentos dep where dep.cod_depart <> '00' and dep.cod_depart = ? order by dep.descripcion asc ";
            //logEJBTecno.info ("Consulta del obtenerListadoDepartamentos = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, deptoActivo);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<String>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    comboDatos.add(cursor.getString(1));
                    comboDatos.add(cursor.getString(2));
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerListadoDepartamentos = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                //logEJBTecno.info ("Error de sql de obtenerListadoDepartamentos = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                comboDatosVacio.add("SIN VALOR");
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<String> obtenerListadoMunicipios(String codigoDepto) {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            consulta = "select ciu.cod_mun, ciu.ciudad from dbo.ciudades ciu where substring(ciu.cod_mun,1,2) = ? order by ciu.ciudad asc ";
            //logEJBTecno.info ("Consulta del obtenerListadoMunicipios = " + consulta);
            //logEJBTecno.info ("ID DE DEPARTAMENTO PARA SUS MUNICIPIOS = " + codigoDepto);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, codigoDepto);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<String>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    comboDatos.add(cursor.getString(1));
                    comboDatos.add(cursor.getString(2));
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerListadoMunicipios = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                //logEJBTecno.info ("Error de sql de obtenerListadoMunicipios = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                comboDatosVacio.add("SIN VALOR");
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<String> obtenerListadoMunicipiosControlDistrito(String codigoDepto, String idDistrito) {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";
        String idMunicipio = "";
        String nombreMunicipio = "";

        try {
            //***************************************************************
            //***************************************************************
            consulta = "select ciu.cod_mun, ciu.ciudad from dbo.ciudades ciu where substring(ciu.cod_mun,1,2) = ? order by ciu.cod_mun  asc ";
            //logEJBTecno.info ("Consulta del obtenerListadoMunicipios = " + consulta);
            //logEJBTecno.info ("ID DE DEPARTAMENTO PARA SUS MUNICIPIOS = " + codigoDepto);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, codigoDepto);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<String>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    idMunicipio = cursor.getString(1);
                    nombreMunicipio = cursor.getString(2);
                    //logEJBTecno.info ("ID MUNICIPIO = " + idMunicipio + " - ID DISTRITO QUE NO SE DEBE MOSTRAR = " + idDistrito);
                    //*******************************************
                    if (!idMunicipio.equals(idDistrito)) {
                        comboDatos.add(idMunicipio);
                        comboDatos.add(nombreMunicipio);
                    }
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerListadoMunicipios = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                //logEJBTecno.info ("Error de sql de obtenerListadoMunicipios = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                comboDatosVacio.add("SIN VALOR");
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<String> obtenerListadoMunicipiosSoloDistrito(String codigoDepto, String idDistrito) {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";
        String idMunicipio = "";
        String nombreMunicipio = "";

        try {
            //***************************************************************
            //***************************************************************
            consulta = "select ciu.cod_mun, ciu.ciudad from dbo.ciudades ciu where substring(ciu.cod_mun,1,2) = ? order by ciu.cod_mun  asc ";
            //logEJBTecno.info ("Consulta del obtenerListadoMunicipios = " + consulta);
            //logEJBTecno.info ("ID DE DEPARTAMENTO PARA SUS MUNICIPIOS = " + codigoDepto);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, codigoDepto);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<String>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    idMunicipio = cursor.getString(1);
                    nombreMunicipio = cursor.getString(2);
                    //logEJBTecno.info ("ID MUNICIPIO = " + idMunicipio + " - ID DISTRITO QUE NO SE DEBE MOSTRAR = " + idDistrito);
                    //*******************************************
                    if (idMunicipio.equals(idDistrito)) {
                        comboDatos.add(idMunicipio);
                        comboDatos.add(nombreMunicipio);
                    }
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerListadoMunicipios = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                //logEJBTecno.info ("Error de sql de obtenerListadoMunicipios = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                comboDatosVacio.add("SIN VALOR");
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<String> obtenerListadoCargos() {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            consulta = "select tc.cdg_cargos, tc.descripcion from dbo.tecno_cargos tc order by tc.cdg_cargos asc ";
            //logEJBTecno.info ("Consulta del obtenerListadoCargos = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<String>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    comboDatos.add(cursor.getString(1));
                    comboDatos.add(cursor.getString(2));
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerListadoCargos = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                //logEJBTecno.info ("Error de sql de obtenerListadoCargos = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                comboDatosVacio.add("SIN VALOR");
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<String> obtenerListaCausasProbables() {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            consulta = "select tcpr.cdg_causa, tcpr.termino_ea from dbo.tecno_causa_probable tcpr order by tcpr.cdg_causa asc ";
            //logEJBTecno.info ("Consulta del obtenerListaCausasProbables = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<String>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    comboDatos.add(cursor.getString(1));
                    comboDatos.add(cursor.getString(2));
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerListaCausasProbables = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                //logEJBTecno.info ("Error de sql de obtenerListaCausasProbables = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                comboDatosVacio.add("SIN VALOR");
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<String> obtenerListaDesenlaces() {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            consulta = "select d.cdg_desenlace, d.descripcion from dbo.tecno_desenlace d order by d.cdg_desenlace asc ";
            //logEJBTecno.info ("Consulta del obtenerListaDesenlaces = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<String>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    comboDatos.add(cursor.getString(1));
                    comboDatos.add(cursor.getString(2));
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerListaDesenlaces = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                //logEJBTecno.info ("Error de sql de obtenerListaDesenlaces = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                comboDatosVacio.add("SIN VALOR");
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerCodigoDeptoPorNombre(String nombreDepto) {
        String codigo = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Nombre departamento enviado = " + nombreDepto);
            consulta = "select dep.cod_depart from dbo.departamentos dep where dep.descripcion like ? ";
            //logEJBTecno.info ("Consulta del obtenerCodigoDeptoPorNombre = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, nombreDepto);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    codigo = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerCodigoDeptoPorNombre = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            return ("0");
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
                //logEJBTecno.info ("Error de sql de obtenerCodigoDeptoPorNombre = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("0");
            }
        }

        return (codigo);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerNombreDeptoPorCodigo(String codigo) {
        String nombre = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("CODIGO DE DEPARTAMENTO ENVIADO = " + codigo);
            consulta = "select dep.descripcion from dbo.departamentos dep where dep.cod_depart = ? ";
            //logEJBTecno.info ("Consulta del obtenerCodigoDeptoPorNombre = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, codigo);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nombre = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerCodigoDeptoPorNombre = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            return ("SIN DEPARTAMENTO");
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
                //logEJBTecno.info ("Error de sql de obtenerCodigoDeptoPorNombre = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("SIN DEPARTAMENTO");
            }
        }

        return (nombre);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerNombreMunicipioPorCodigo(String codigo) {
        String nombre = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("CODIGO DE DEPARTAMENTO ENVIADO = " + codigo);
            consulta = "select mun.descripcion from dbo.municipios mun where mun.cod_mun = ? ";
            //logEJBTecno.info ("Consulta del obtenerNombreMunicipioPorCodigo = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, codigo);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nombre = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerNombreMunicipioPorCodigo = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            return ("SIN MUNICIPIO");
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
                //logEJBTecno.info ("Error de sql de obtenerNombreMunicipioPorCodigo = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("SIN MUNICIPIO");
            }
        }

        return (nombre);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerCodigoMunicipioPorNombre(String codigoDepto, String nombreMunicipio) {
        String codigo = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("codigoDepto = " + codigoDepto);
            //logEJBTecno.info ("Nombre del municipio a consultar = " + nombreMunicipio);
            consulta = "select mun.cod_mun from dbo.municipios mun where mun.descripcion like ? and mun.cod_depart = ? ";
            //logEJBTecno.info ("Consulta del obtenerCodigoMunicipioPorNombre = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, nombreMunicipio);
            sentencia.setString(2, codigoDepto);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    codigo = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerCodigoMunicipioPorNombre = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            return ("0");
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
                //logEJBTecno.info ("Error de sql de obtenerCodigoMunicipioPorNombre = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("0");
            }
        }

        return (codigo);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public boolean crearRegistroTecnoReporteEventos(TecnoReporteEventosTemp registroTRE, String codigoPrecol) {
        boolean seInserta = false;

        try {
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("Ejecutando método crearRegistroTecnoReporteEventos");
            ejbTecnoReporteEventosTemp.create(registroTRE);
            seInserta = true;
            //logEJBTecno.info ("Se generó la inserción del registro del registroTRE = " + seInserta + " con precol = " + codigoPrecol);
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
        } catch (Exception errorcrearRegistroTecnoReporteEventos) {
            //logEJBTecno.info ("ERROR en el método crearRegistroTecnoReporteEventos = " + errorcrearRegistroTecnoReporteEventos.getLocalizedMessage());
            errorcrearRegistroTecnoReporteEventos.printStackTrace();
            return (false);
        }

        return (seInserta);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public boolean crearRegistroTecnoDispositivo(TecnoDispositivoTemp registroDispositivo, String codigoPrecol) {
        boolean seInserta = false;

        try {
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("Ejecutando método crearRegistroTecnoDispositivo");
            ejbTecnoDispositivoTemp.create(registroDispositivo);
            seInserta = true;
            //logEJBTecno.info ("Se generó la inserción del registro del registroDispositivo = " + seInserta);
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
        } catch (Exception errorcrearRegistroTecnoDispositivo) {
            //logEJBTecno.info ("ERROR en el método crearRegistroTecnoDispositivo = " + errorcrearRegistroTecnoDispositivo.getLocalizedMessage());
            errorcrearRegistroTecnoDispositivo.printStackTrace();
            return (false);
        }

        return (seInserta);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public boolean crearRegistroTecnoPaciente(TecnoPacienteTemp registroPaciente, String codigoPrecol) {
        boolean seInserta = false;

        try {
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("Ejecutando método crearRegistroTecnoPaciente");
            ejbTecnoPacienteTemp.create(registroPaciente);
            seInserta = true;
            //logEJBTecno.info ("Se generó la inserción del registro del registroDispositivo = " + seInserta);
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
        } catch (Exception errorcrearRegistroTecnoPaciente) {
            //logEJBTecno.info ("ERROR en el método crearRegistroTecnoPaciente = " + errorcrearRegistroTecnoPaciente.getLocalizedMessage());
            errorcrearRegistroTecnoPaciente.printStackTrace();
            return (false);
        }

        return (seInserta);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public boolean crearRegistroTecnoEvaluacionCaso(TecnoEvaluacionCasoTemp registroEvaluacionCaso, String codigoPrecol) {
        boolean seInserta = false;

        try {
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("Ejecutando método crearRegistroTecnoEvaluacionCaso");
            ejbTecnoEvaluacionCasoTemp.create(registroEvaluacionCaso);
            seInserta = true;
            //logEJBTecno.info ("Se generó la inserción del registro del registroEvaluacionCaso = " + seInserta + " con precol = " + codigoPrecol);
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
        } catch (Exception errorcrearRegistroTecnoEvaluacionCaso) {
            //logEJBTecno.info ("ERROR en el método crearRegistroTecnoEvaluacionCaso = " + errorcrearRegistroTecnoEvaluacionCaso.getLocalizedMessage());
            errorcrearRegistroTecnoEvaluacionCaso.printStackTrace();
            return (false);
        }

        return (seInserta);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerPrecolSecuenciaCargue() {
        String nuevoPrecol = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("EJECUTANDO MÉTODO PARA OBTENER EL ÚLTIMO PRECOL");
            //***************************************************************
            //***************************************************************
            //consulta = "select max(cast(substring(reporte,4,len(reporte)-1) as int))+1 as nuevoPrecol from dbo.tecno_reporte_eventos ";
            consulta = "select max(cast(substring(reporte,7,len(reporte)-1) as int))+1 as nuevoPrecol from dbo.tecno_reporte_eventos_temp ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerPrecolSecuenciaCargue = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info  ("rs de precol = " + cursor);
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nuevoPrecol = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }

                //logEJBTecno.info  ("---->");
                //logEJBTecno.info  ("NUEVO PRECOL OBTENIDO = " + nuevoPrecol);
                //logEJBTecno.info  ("---->");
                if (nuevoPrecol != null) {
                    if (nuevoPrecol.equals("")) {
                        nuevoPrecol = "000000001";
                    }
                } else {
                    nuevoPrecol = "000000001";
                }
            } else {
                nuevoPrecol = "000000001";
            }
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("---------------------------------------------------------");
            //logEJBTecno.info ("SECUENCIA DE PRECOL OBTENIDO = " + nuevoPrecol);
            //logEJBTecno.info ("---------------------------------------------------------");
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerPrecolSecuenciaCargue = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            return ("000000001");
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
                //logEJBTecno.info ("Error de sql de obtenerPrecolSecuenciaCargue = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("000000001");
            }
        }

        return (nuevoPrecol);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerSiguienteColSecuenciaSistema() {
        String nuevoPrecol = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("EJECUTANDO MÉTODO PARA OBTENER EL ÚLTIMO PRECOL");
            //***************************************************************
            //***************************************************************
            consulta = "select max(cast(substring(reporte,4,len(reporte)-1) as int))+1 as nuevoCol from dbo.tecno_reporte_eventos ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerSiguienteColSecuenciaSistema = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info  ("rs de precol = " + cursor);

            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nuevoPrecol = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }

                //logEJBTecno.info  ("---->");
                //logEJBTecno.info  ("NUEVO COL OBTENIDO = " + nuevoPrecol);
                //logEJBTecno.info  ("---->");
                if (nuevoPrecol != null) {
                    if (nuevoPrecol.equals("")) {
                        nuevoPrecol = "000000001";
                    }
                } else {
                    nuevoPrecol = "000000001";
                }
            } else {
                nuevoPrecol = "000000001";
            }
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("---------------------------------------------------------");
            //logEJBTecno.info ("SECUENCIA DE PRECOL OBTENIDO = " + nuevoPrecol);
            //logEJBTecno.info ("---------------------------------------------------------");
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerSiguienteColSecuenciaSistema = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            return ("000000001");
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
                //logEJBTecno.info ("Error de sql de obtenerSiguienteColSecuenciaSistema = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("000000001");
            }
        }

        return (nuevoPrecol);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerExpedientePorRegistroSanitario(String registroSanitario) {
        String codigoExpediente = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";
        String codigo = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("EJECUTANDO MÉTODO PARA OBTENER EL EXPEDIENTE POR EL CODIGO DE REGISTRO SANITARIO no. " + registroSanitario);
            consulta
                    = "SELECT "
                    + "expe.nroexpediente "
                    + "from "
                    + "registro.dbo.registro_sanitario rg, "
                    + "registro.dbo.expedientes expe "
                    + "where (rg.cdgregsan = expe.cdgregsan and "
                    + "rg.cdgexpediente = expe.cdgexpediente) "
                    + "and rg.nroregsan like ? ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerExpedientePorRegistroSanitario");
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info (consulta);
            //logEJBTecno.info ("----------------------------------------------------");
            //Desactivar y reemplazar consulta con LIKE de registro mas aproximado
            //codigo = "INVIMA " + registroSanitario;
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, "%" + codigo + "%");
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    codigoExpediente = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }
                //**********************************************
                //**********************************************
                if (codigoExpediente.equals("")) {
                    codigoExpediente = "000000000";
                }
                //**********************************************
                //**********************************************
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerPrecolSecuenciaCargue = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            return ("000000000");
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
                //logEJBTecno.info ("Error de sql de obtenerPrecolSecuenciaCargue = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("000000000");
            }
        }

        return (codigoExpediente);
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
    @Override
    public String obtenerCodigoEventoDeteccion(String nombreEvento) {
        String codigoConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO PARA OBTENER CODIGO DETECCION DEL NOMBRE = " + nombreEvento);
            consulta
                    = "select cdg_detec from dbo.tecno_deteccion where nombre_detec = ? ";

            //logEJBTecno.info ("Consulta del obtenerCodigoEventoDeteccion = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, nombreEvento);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    codigoConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }
                //********************************************
                //********************************************
                if (codigoConcepto.equals("")) {
                    codigoConcepto = "1";
                }
                //********************************************
                //********************************************
            }

            //logEJBTecno.info ("----------------------------------------------------------");
            //logEJBTecno.info ("Código de evento detección = " + codigoConcepto);
            //logEJBTecno.info ("----------------------------------------------------------");
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerCodigoEventoDeteccion = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("1");
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
                //logEJBTecno.info ("Error de sql de obtenerPrecolSecuenciaCargue = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("1");
            }
        }

        return (codigoConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerCodigoTipoDesenlace(String descripcion) {
        String codigoConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO PARA OBTENER CODIGO DE TIPO DE DESENLACE DEL NOMBRE = " + descripcion);
            consulta
                    = "select cdg_desenlace from dbo.tecno_desenlace where descripcion = ? ";

            //logEJBTecno.info ("Consulta del obtenerCodigoTipoDesenlace = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, descripcion);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    codigoConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }
                //*******************************************
                //*******************************************
                if (codigoConcepto.equals("")) {
                    codigoConcepto = "1";
                }
                //*******************************************
                //*******************************************
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoTipoDesenlace) {
            //logEJBTecno.info ("Error en la generación del obtenerCodigoTipoDesenlace = " + errorobtenerCodigoTipoDesenlace.getLocalizedMessage());
            errorobtenerCodigoTipoDesenlace.printStackTrace();
            return ("1");
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
                //logEJBTecno.info ("Error de sql de obtenerCodigoTipoDesenlace = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("1");
            }
        }

        return (codigoConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerCodigoTipoIdentificacionReportante(String nombreTipoDocumento) {
        String codigoConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO PARA OBTENER CODIGO DE TIPO DE IDENTIFICACIÓN DEL REPORTANTE DEL NOMBRE = " + nombreTipoDocumento);
            consulta
                    = "select cdg_tipodoc from dbo.tecno_tipodocident where nombre_tipodoc = ? ";

            //logEJBTecno.info ("Consulta del obtenerCodigoTipoIdentificacionReportante = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, nombreTipoDocumento);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    codigoConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }

                if (codigoConcepto.equals("")) {
                    codigoConcepto = "1";
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerCodigoTipoIdentificacionReportante = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("1");
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
                //logEJBTecno.info ("Error de sql de obtenerCodigoTipoIdentificacionReportante = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("1");
            }
        }

        return (codigoConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerCodigoCargos(String descripcion) {
        String codigoConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO PARA OBTENER CODIGO DE CARGO A PARTIR DEL NOMBRE = " + descripcion);
            consulta
                    = "select cdg_cargos from dbo.tecno_cargos where descripcion = ? ";

            //logEJBTecno.info ("Consulta del obtenerCodigoCargos = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, descripcion);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    codigoConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }

                if (codigoConcepto.equals("")) {
                    codigoConcepto = "1";
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerCodigoCargos = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("1");
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
                //logEJBTecno.info ("Error de sql de obtenerCodigoCargos = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("1");
            }
        }

        return (codigoConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerCodigoTipoDeReportante(String nombreTipoReportante) {
        String codigoConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO PARA OBTENER CODIGO DE TIPO DE REPORTANTE A PARTIR DEL NOMBRE = " + nombreTipoReportante);
            consulta
                    = "select cdg_tiporeportante from dbo.tecno_tiporeportante where nombre_tiporeportante = ? ";

            //logEJBTecno.info ("Consulta del obtenerCodigoTipoDeReportante = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, nombreTipoReportante);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    codigoConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }

                if (codigoConcepto.equals("")) {
                    codigoConcepto = "1";
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerCodigoTipoDeReportante = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("1");
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
                //logEJBTecno.info ("Error de sql de obtenerCodigoTipoDeReportante = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("1");
            }
        }

        return (codigoConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerCodigoCausaProbable(String descripcion) {
        String codigoConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO PARA OBTENER CODIGO DE CAUSA PROBABLE A PARTIR DEL NOMBRE = " + descripcion);
            consulta
                    = "select cdg_causa from dbo.tecno_causa_probable where termino_ea = ? ";

            //logEJBTecno.info ("Consulta del obtenerCodigoCausaProbable = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, descripcion);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    codigoConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }

                if (codigoConcepto.equals("")) {
                    codigoConcepto = "1";
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerCodigoCausaProbable = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("1");
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
                //logEJBTecno.info ("Error de sql de obtenerCodigoCausaProbable = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("1");
            }
        }

        return (codigoConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerCodigoTipoDispositivo(String nombreTipoDispositivo) {
        String codigoConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO PARA OBTENER CODIGO DE TIPO DE DISPOSITIVO A PARTIR DEL NOMBRE = " + nombreTipoDispositivo);
            consulta
                    = "select cdg_tipodispositivo from dbo.tecno_tipodispositivo where descripcion = ? ";

            //logEJBTecno.info ("Consulta del obtenerCodigoTipoDispositivo = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, nombreTipoDispositivo);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    codigoConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }

                if (codigoConcepto.equals("")) {
                    codigoConcepto = "1";
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerCodigoTipoDispositivo = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("1");
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
                //logEJBTecno.info ("Error de sql de obtenerCodigoTipoDispositivo = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("1");
            }
        }

        return (codigoConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public void limpiarTablaCargueMasivo(String nombreTabla) {
        java.sql.Connection conexionUpdate = null;
        //java.sql.Statement st = null;
        java.sql.PreparedStatement ps = null;

        //String consulta = "TRUNCATE " + nombreTabla;
        String consulta = "DELETE FROM " + nombreTabla;
        int resultado = 0;

        try {
            //logEJBTecno.info("***********************************************************************************");
            //logEJBTecno.info("***********************************************************************************");
            //logEJBTecno.info(consulta);
            //logEJBTecno.info("PROCESO DE LIMPIEZA DE LA TABLA " + nombreTabla);

            conexionUpdate = obtenerConexionDataSource();

            conexionUpdate.setAutoCommit(false);
            ps = conexionUpdate.prepareStatement(consulta);
            resultado = ps.executeUpdate();
            //logEJBTecno.info("RESULTADO " + resultado);

            if (resultado == 0) {
                //logEJBTecno.info("SE EJECUTÓ EL BORRADO DE LA TABLA " + nombreTabla);
                //logEJBTecno.info("TABLA TRUNCADA " + nombreTabla);
            }

            conexionUpdate.commit();

            //logEJBTecno.info("***********************************************************************************");
            //logEJBTecno.info("***********************************************************************************");
        } catch (Exception errorCargue) {
            //logEJBTecno.info("Error cargue: " + errorCargue.getMessage());
            errorCargue.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }

                if (conexionUpdate != null) {
                    conexionUpdate.close();
                }
            } catch (Exception errorsql) {
                //logEJBTecno.info("Error de base de datos: " + errorsql.getMessage());
                errorsql.printStackTrace();
            }

        }
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<String> obtenerListaDetecciones() {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            consulta
                    = "select cdg_detec as ID, "
                    + "nombre_detec as NOMBRE from "
                    + "dbo.tecno_deteccion order by cdg_detec asc ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerListaDetecciones = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<String>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    comboDatos.add(cursor.getString(1));
                    comboDatos.add(cursor.getString(2));
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerListaDetecciones) {
            //logEJBTecno.info ("Error en la generación del obtenerListaDetecciones = " + errorobtenerListaDetecciones.getLocalizedMessage());
            errorobtenerListaDetecciones.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                //logEJBTecno.info ("Error de sql de obtenerListaDetecciones = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                comboDatosVacio.add("SIN VALOR");
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<String> obtenerListaTipoDocReportante() {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            consulta
                    = "select "
                    + "cdg_tipodoc as ID, "
                    + "nombre_tipodoc as NOMBRE from "
                    + "dbo.tecno_tipodocident order by cdg_tipodoc asc ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerListaTipoIncidentes = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<String>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    comboDatos.add(cursor.getString(1));
                    comboDatos.add(cursor.getString(2));
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerListaDetecciones) {
            //logEJBTecno.info ("Error en la generación del obtenerListaTipoIncidentes = " + errorobtenerListaDetecciones.getLocalizedMessage());
            errorobtenerListaDetecciones.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                //logEJBTecno.info ("Error de sql de obtenerListaTipoIncidentes = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                comboDatosVacio.add("SIN VALOR");
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<String> obtenerListaCargos() {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            consulta
                    = "select "
                    + "cdg_cargos as ID, "
                    + "descripcion as NOMBRE from "
                    + "dbo.tecno_cargos order by cdg_cargos asc ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerListaCargos = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<String>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    comboDatos.add(cursor.getString(1));
                    comboDatos.add(cursor.getString(2));
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerListaDetecciones) {
            //logEJBTecno.info ("Error en la generación del obtenerListaCargos = " + errorobtenerListaDetecciones.getLocalizedMessage());
            errorobtenerListaDetecciones.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                //logEJBTecno.info ("Error de sql de obtenerListaCargos = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                comboDatosVacio.add("SIN VALOR");
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<String> obtenerListaTipoReportes() {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            consulta
                    = "select "
                    + "cdg_tiporep as ID, "
                    + "nombre_tiprep as NOMBRE from "
                    + "dbo.tecno_tiporeporte order by cdg_tiporep asc ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerListaTipoReportes = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<String>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    comboDatos.add(cursor.getString(1));
                    comboDatos.add(cursor.getString(2));
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerListaDetecciones) {
            //logEJBTecno.info ("Error en la generación del obtenerListaTipoReportes = " + errorobtenerListaDetecciones.getLocalizedMessage());
            errorobtenerListaDetecciones.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                //logEJBTecno.info ("Error de sql de obtenerListaTipoReportes = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                comboDatosVacio.add("SIN VALOR");
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<String> obtenerListaTipoReportantes() {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            consulta
                    = "select "
                    + "cdg_tiporeportante as ID, "
                    + "nombre_tiporeportante as NOMBRE from "
                    + "dbo.tecno_tiporeportante order by cdg_tiporeportante asc ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerListaTipoReportantes = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<String>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    comboDatos.add(cursor.getString(1));
                    comboDatos.add(cursor.getString(2));
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerListaDetecciones) {
            //logEJBTecno.info ("Error en la generación del obtenerListaTipoReportantes = " + errorobtenerListaDetecciones.getLocalizedMessage());
            errorobtenerListaDetecciones.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                //logEJBTecno.info ("Error de sql de obtenerListaTipoReportantes = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                comboDatosVacio.add("SIN VALOR");
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerNombreEventoDeteccionPorCodigo(String codigoEvento) {
        String nombreConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO PARA OBTENER NOMBRE DETECCION POR CODIGO = " + codigoEvento);
            consulta
                    = "select nombre_detec from  dbo.tecno_deteccion where cdg_detec = ? ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerNombreEventoDeteccionPorCodigo = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, codigoEvento);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nombreConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerNombreEventoDeteccionPorCodigo = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("SIN CONCEPTO");
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
                //logEJBTecno.info ("Error de sql de obtenerNombreEventoDeteccionPorCodigo = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("SIN CONCEPTO");
            }
        }

        return (nombreConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerNombreTipoDesenlacePorCodigo(String codigo) {
        String nombreConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO PARA OBTENER NOMBRE TIPO DE DESENLACE POR CODIGO = " + codigo);
            consulta
                    = "SELECT descripcion from dbo.tecno_desenlace where cdg_desenlace = ? ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerNombreTipoDesenlacePorCodigo = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, codigo);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nombreConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerNombreTipoDesenlacePorCodigo = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("SIN CONCEPTO");
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
                //logEJBTecno.info ("Error de sql de obtenerNombreTipoDesenlacePorCodigo = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("SIN CONCEPTO");
            }
        }

        return (nombreConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerNombreTipoIdentificacionReportantePorCodigo(String codigoTipoDocumento) {
        String nombreConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO PARA OBTENER NOMBRE TIPO DE IDENTIFICACION POR CODIGO = " + codigoTipoDocumento);
            consulta
                    = "select nombre_tipodoc from dbo.tecno_tipodocident where cdg_tipodoc = ? ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerNombreTipoIdentificacionReportantePorCodigo = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, codigoTipoDocumento);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nombreConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerNombreTipoIdentificacionReportantePorCodigo = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("SIN CONCEPTO");
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
                //logEJBTecno.info ("Error de sql de obtenerNombreTipoIdentificacionReportantePorCodigo = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("SIN CONCEPTO");
            }
        }

        return (nombreConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerNombreCargosPorCodigo(String codigo) {
        String nombreConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO PARA OBTENER NOMBRE CARGO POR CODIGO = " + codigo);
            consulta
                    = "select descripcion from dbo.tecno_cargos where cdg_cargos = ? ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerNombreCargosPorCodigo = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, codigo);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nombreConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerNombreCargosPorCodigo = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("SIN CONCEPTO");
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
                //logEJBTecno.info ("Error de sql de obtenerNombreCargosPorCodigo = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("SIN CONCEPTO");
            }
        }

        return (nombreConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerNombreTipoDeReportantePorCodigo(String codigoTipoReportante) {
        String nombreConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO PARA OBTENER TIPO DE REPORTANTE POR CODIGO = " + codigoTipoReportante);
            consulta
                    = "select nombre_tiporeportante from dbo.tecno_tiporeportante where cdg_tiporeportante = ? ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerNombreTipoDeReportantePorCodigo = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, codigoTipoReportante);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nombreConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerNombreTipoDeReportantePorCodigo = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("SIN CONCEPTO");
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
                //logEJBTecno.info ("Error de sql de obtenerNombreTipoDeReportantePorCodigo = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("SIN CONCEPTO");
            }
        }

        return (nombreConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerNombreCausaProbablePorCodigo(String codigo) {
        String nombreConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO PARA OBTENER CAUSA PROBABLE POR CODIGO = " + codigo);
            consulta
                    = "select termino_ea from dbo.tecno_causa_probable where cdg_causa = ? ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerNombreCausaProbablePorCodigo = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, codigo);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nombreConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerNombreCausaProbablePorCodigo = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("SIN CONCEPTO");
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
                //logEJBTecno.info ("Error de sql de obtenerNombreCausaProbablePorCodigo = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("SIN CONCEPTO");
            }
        }

        return (nombreConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerNombreTipoDispositivo(String codigoTipoDispositivo) {
        String nombreConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO PARA OBTENER NOMBRE TIPO DE DISPOSITIVO CODIGO = " + codigoTipoDispositivo);
            consulta
                    = "select descripcion from dbo.tecno_tipodispositivo where cdg_tipodispositivo = ? ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerNombreTipoDispositivo = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, codigoTipoDispositivo);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nombreConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerNombreTipoDispositivo = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("SIN CONCEPTO");
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
                //logEJBTecno.info ("Error de sql de obtenerNombreTipoDispositivo = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("SIN CONCEPTO");
            }
        }

        return (nombreConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<String> obtenerListaTipoDispositivos() {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            consulta
                    = "SELECT "
                    + "cdg_tipodispositivo as ID, "
                    + "descripcion as NOMBRE "
                    + "from dbo.tecno_tipodispositivo "
                    + "order by cdg_tipodispositivo asc ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerListaTipoDispositivos = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<String>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    comboDatos.add(cursor.getString(1));
                    comboDatos.add(cursor.getString(2));
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerListaTipoDispositivos = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                //logEJBTecno.info ("Error de sql de obtenerListaTipoDispositivos = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                comboDatosVacio.add("SIN VALOR");
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<String> obtenerListadoUsuariosIPS() {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            /*
            consulta = 
                "SELECT " +
                "datos.identificacion_empresa as ID, " +
                "datos.nombre_empresa as NOMBRE " +
                "from " +
                "dbo.tecno_usuarios_internet datos " + 
                "where datos.id_rol_usuario = 3 " +
                "order by datos.nombre_empresa asc ";  
             */
            //***************************************************************
            //***************************************************************
            //Solo se traen las empresas que tengan registros de precoles
            //en la tabla tecno_reporte_eventos_temp
            consulta
                    = "SELECT distinct "
                    + "  datos.identificacion_empresa as ID, "
                    + "  datos.nombre_empresa as NOMBRE "
                    + "  from "
                    + "  dbo.tecno_usuarios_internet datos, "
                    + "  tecno_reporte_eventos_temp registros "
                    + "  where "
                    + "  (datos.identificacion_empresa = registros.idips) and "
                    + "  datos.id_rol_usuario = 3 "
                    + "  order by datos.nombre_empresa asc ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerListadoUsuariosIPS = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<String>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    comboDatos.add(cursor.getString(1));
                    comboDatos.add(cursor.getString(2));
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerListadoUsuariosIPS = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                //logEJBTecno.info ("Error de sql de obtenerListadoUsuariosIPS = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                comboDatosVacio.add("SIN VALOR");
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************    
    @Override
    public List<String> obtenerListadoUsuariosIPS(String tipo) {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            /*
            consulta = 
                "SELECT " +
                "datos.identificacion_empresa as ID, " +
                "datos.nombre_empresa as NOMBRE " +
                "from " +
                "dbo.tecno_usuarios_internet datos " + 
                "where datos.id_rol_usuario = 3 " +
                "order by datos.nombre_empresa asc ";  
             */
            //***************************************************************
            //***************************************************************
            //Solo se traen las empresas que tengan registros de precoles
            //en la tabla tecno_reporte_eventos_temp
            /*
            if (tipo.equals("todos"))
            {
                consulta =
                    "SELECT distinct " +
                    "  datos.identificacion_empresa as ID, " +  
                    "  datos.nombre_empresa as NOMBRE " +  
                    "  from " +  
                    "  dbo.tecno_usuarios_internet datos, " +
                    "  tecno_reporte_eventos_temp registros " +
                    "  where " + 
                    "  (datos.identificacion_empresa = registros.idips) and " +
                    "  datos.id_rol_usuario in (2,3) " +  
                    "  order by datos.nombre_empresa asc ";
            }
            else
            {
                consulta =
                    "SELECT distinct " +
                    "  datos.identificacion_empresa as ID, " +  
                    "  datos.nombre_empresa as NOMBRE " +  
                    "  from " +  
                    "  dbo.tecno_usuarios_internet datos, " +
                    "  tecno_reporte_eventos_temp registros " +
                    "  where " + 
                    "  (datos.identificacion_empresa = registros.idips) and " +
                    "  datos.id_rol_usuario = 3 " +  
                    "  order by datos.nombre_empresa asc ";
            }
             */
            if (tipo.equals("todos")) {
                consulta
                        = "SELECT distinct "
                        + "  datos.identificacion_empresa as ID, "
                        + "  datos.nombre_empresa as NOMBRE "
                        + "  from "
                        + "  dbo.tecno_usuarios_internet datos, "
                        + "  tecno_reporte_eventos_temp registros "
                        + "  where "
                        + "  (datos.identificacion_empresa = registros.idips) and "
                        + "  datos.id_rol_usuario in (2,3) "
                        + "  order by datos.nombre_empresa asc ";
            } else {
                consulta
                        = "SELECT distinct "
                        + "  datos.identificacion_empresa as ID, "
                        + "  datos.nombre_empresa as NOMBRE "
                        + "  from "
                        + "  dbo.tecno_usuarios_internet datos, "
                        + "  tecno_reporte_eventos_temp registros "
                        + "  where "
                        + "  (datos.identificacion_empresa = registros.idips) and "
                        + "  datos.id_rol_usuario = 3 "
                        + "  order by datos.nombre_empresa asc ";
            }
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerListadoUsuariosIPS tipo = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<String>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    comboDatos.add(cursor.getString(1));
                    comboDatos.add(cursor.getString(2));
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerListadoUsuariosIPS = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                //logEJBTecno.info ("Error de sql de obtenerListadoUsuariosIPS = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                comboDatosVacio.add("SIN VALOR");
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************    
    @Override
    public List<ReportePrecol> buscarReportesMasivosTrimestralesPorIPS(String depto, String municipio, java.util.Date fechaIni, java.util.Date fechaFin) {
        List<ReportePrecol> comboDatos = null;
        List<ReportePrecol> comboDatosVacio = null;
        ReportePrecol registroIndividual = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("+++++++++++++++++++++++++++++++++++++");
            //logEJBTecno.info ("+++++++++++++++++++++++++++++++++++++");
            //logEJBTecno.info ("ID DEPARTAMENTO = " + depto);
            //logEJBTecno.info ("ID municipio = " + municipio);
            //logEJBTecno.info ("fecha inicial = " + fechaIni);
            //logEJBTecno.info ("fecha inicial = " + fechaFin);
            //logEJBTecno.info ("+++++++++++++++++++++++++++++++++++++");
            //logEJBTecno.info ("+++++++++++++++++++++++++++++++++++++");
            /*
            consulta = 
                "SELECT " +
                "datos.reporte as precol, " +
                "(select dep.descripcion from dbo.departamentos dep where dep.cod_depart = paci.cod_depart) as departamento, " +
                "(select mun.descripcion from dbo.municipios mun where mun.cod_mun = paci.cod_mun) as municipio, " +
                "datos.fechevento as fechaEvento, " +
                "datos.descripcion_evento as descripcionEvento, " +
                "(select tev.nombre_detec from dbo.tecno_deteccion tev where tev.cdg_detec = datos.cdg_eventodeteccion) as deteccion_evento, " +
                "datos.fechaingreso as fechaIngreso, " +
                "dispo.nombre_comercial as nombreComercial, " +
                "paci.identificacion as identificacion, " +
                "paci.diagnostico_paciente as diagnostico " +
                "from " + 
                "dbo.tecno_reporte_eventos_temp datos, " +
                "dbo.tecno_dispositivo_temp dispo, " +
                "dbo.tecno_paciente_temp paci " +
                "where " + 
                "(datos.reporte = dispo.reporte) and " +
                "(datos.reporte = paci.reporte) ";
             */
            //******************************************************************
            //******************************************************************
            //******************************************************************
            //******************************************************************
            consulta
                    = "SELECT "
                    + "    datos.reporte as precol,  "
                    + "    (select dep.descripcion from dbo.departamentos dep where dep.cod_depart = paci.cod_depart) as departamento,  "
                    + "    (select mun.descripcion from dbo.municipios mun where mun.cod_mun = paci.cod_mun) as municipio,  "
                    + "    paci.contacto_reportante as nombre_reportante, "
                    + "    datos.idrol as id_rol, "
                    + "    datos.fechaingreso as fecha_ingreso, "
                    + "    datos.descripcion_evento as descripcionEvento,  "
                    + "    dispo.nombre_dispositivo as nombre_dispositivo, "
                    + "    datos.cdg_tipoeventoincidente as tipo_reporte, "
                    + "    evalua.cdg_causa as codigo_causa "
                    + "    from   "
                    + "    dbo.tecno_reporte_eventos_temp datos,  "
                    + "    dbo.tecno_dispositivo_temp dispo, "
                    + "    dbo.tecno_paciente_temp paci, "
                    + "    dbo.tecno_evaluacion_caso_temp evalua "
                    + "    where "
                    + "    (datos.reporte = dispo.reporte) and "
                    + "    (datos.reporte = paci.reporte) and "
                    + "    (datos.reporte = evalua.reporte) ";
            //******************************************************************
            //******************************************************************
            //******************************************************************
            if (depto != null) {
                consulta
                        += "and paci.cod_depart = ? ";
                //"and paci.cod_depart = ? ";

                if (municipio != null) {
                    consulta
                            += "and paci.cod_mun = ? ";
                    //"and paci.cod_mun = ? ";

                    if (fechaIni != null) {
                        consulta
                                += "and datos.fechaingreso >= ? ";
                    }

                    if (fechaFin != null) {
                        consulta
                                += "and datos.fechaingreso <= ? ";
                    }
                } else {
                    if (fechaIni != null) {
                        consulta
                                += "and datos.fechaingreso >= ? ";
                    }

                    if (fechaFin != null) {
                        consulta
                                += "and datos.fechaingreso <= ? ";
                    }

                }
            } else {
                if (fechaIni != null) {
                    consulta
                            += "and datos.fechaingreso >= ? ";
                }

                if (fechaFin != null) {
                    consulta
                            += "and datos.fechaingreso <= ? ";
                }
            }
            //******************************************************************
            //******************************************************************
            //******************************************************************
            consulta
                    += "order by datos.reporte, paci.cod_depart, paci.cod_mun asc ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del buscarReportesMasivosTrimestralesPorIPS = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            //***************************************************************
            //***************************************************************
            if (depto != null) {
                sentencia.setString(1, depto);

                if (municipio != null) {
                    sentencia.setString(2, municipio);

                    if (fechaIni != null) {
                        sentencia.setTimestamp(3, obtenerFechaTimeStamp(fechaIni, "inicial"));
                    }

                    if (fechaFin != null) {
                        sentencia.setTimestamp(4, obtenerFechaTimeStamp(fechaFin, "final"));
                    }
                } else {
                    if (fechaIni != null) {
                        sentencia.setTimestamp(2, obtenerFechaTimeStamp(fechaIni, "inicial"));
                    }

                    if (fechaFin != null) {
                        sentencia.setTimestamp(3, obtenerFechaTimeStamp(fechaFin, "final"));
                    }
                }
            } else {
                if (fechaIni != null) {
                    sentencia.setTimestamp(1, obtenerFechaTimeStamp(fechaIni, "inicial"));
                }

                if (fechaFin != null) {
                    sentencia.setTimestamp(2, obtenerFechaTimeStamp(fechaFin, "final"));
                }
            }
            //******************************************************************
            //******************************************************************
            //***************************************************************
            //***************************************************************
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<ReportePrecol>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    registroIndividual = new ReportePrecol();
                    /*
                    registroIndividual.setPrecol (cursor.getString(1));
                    registroIndividual.setDepartamento (cursor.getString(2));
                    registroIndividual.setMunicipio (cursor.getString(3));
                    registroIndividual.setFechaEvento (cursor.getDate(4));
                    registroIndividual.setDescripcionEvento (cursor.getString(5));
                    registroIndividual.setDeteccion_evento (cursor.getString(6));
                    registroIndividual.setFechaIngreso (cursor.getDate(7));
                    registroIndividual.setNombreComercial (cursor.getString(8));
                    registroIndividual.setIdentificacion (cursor.getString(9));
                    registroIndividual.setDiagnostico (cursor.getString(10));
                     */
                    //*******************************************
                    //*******************************************
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
                    //*******************************************
                    //*******************************************
                    comboDatos.add(registroIndividual);
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del buscarReportesMasivosTrimestralesPorIPS = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
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
                //logEJBTecno.info ("Error de sql de buscarReportesMasivosTrimestralesPorIPS = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<ReportePrecol>();
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    public List<String> buscarNombreReportantes(String depto) {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        ReportePrecol registroIndividual = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";
        String deptoBuscar = "";
        String municipioBuscar = "";
        boolean seBusca = false;
        java.util.ArrayList<String> tiposDatos = null;
        java.util.ArrayList<String> parametrosBusqueda = null;
        java.util.ArrayList<Object> valoresParametros = null;
        int i = 0;
        int j = 0;
        boolean buscarConMunicipio = false;
        String valorMunicipio = "";
        try {

            consulta
                    = "SELECT DISTINCT"
                    + "    paci.institucion_reportente as nombre_reportante"       
                    + "    from   "
                    + "    dbo.tecno_reporte_eventos_temp datos,  "
                    + "    dbo.tecno_dispositivo_temp dispo, "
                    + "    dbo.tecno_paciente_temp paci, "
                    + "    dbo.tecno_evaluacion_caso_temp evalua "
                    + "    where "
                    + "    (datos.reporte = dispo.reporte) and "
                    + "    (datos.reporte = paci.reporte) and "
                    + "    (datos.reporte = evalua.reporte) ";
            
            tiposDatos = new ArrayList<String>();
            parametrosBusqueda = new ArrayList<String>();
            valoresParametros = new ArrayList<Object>();
            
            if (depto == null ) {
                seBusca = false;
            } else {
                seBusca = true;
                if (depto != null && !depto.equals("0")) {
                    consulta += "and paci.cod_depart = ? ";
                    parametrosBusqueda.add(consulta);
                    valoresParametros.add(depto);
                    tiposDatos.add("cadena");
                }
                consulta
                        += "  and datos.cdg_seriedad = 0";
            }
            logEJBTecno.info(consulta);
            String nombreParametro = "";
            String tipo = "";
            if (seBusca == true) {
                conexion = obtenerConexionDataSource();
                sentencia = conexion.prepareStatement(consulta);
                i = 1;
                j = 0;
                for (Object objeto : valoresParametros) {
                    if (objeto instanceof String) {
                        sentencia.setString(i, String.valueOf(objeto));
                         logEJBTecno.info("i="+i+" - "+" String.valueOf(objeto)="+String.valueOf(objeto));
                        i++;
                        j++;
                    } else if (objeto instanceof java.util.Date) {
                        java.util.Date fecha = (java.util.Date) objeto;
                        nombreParametro = (String) tiposDatos.get(j);
                        if (nombreParametro.equals("fechaInicial")) {
                            tipo = "inicial";
                        } else {
                            tipo = "final";
                        }
                        sentencia.setTimestamp(i, obtenerFechaTimeStamp(fecha, tipo));
                        logEJBTecno.info("i="+i+" - "+" obtenerFechaTimeStamp(fecha, tipo)="+obtenerFechaTimeStamp(fecha, tipo));
                        i++;
                        j++;
                    }
                }
                cursor = sentencia.executeQuery();
                
                if (cursor != null) {
                    comboDatos = new ArrayList<String>();
                    while (cursor.next()) {
                        comboDatos.add(cursor.getString(1));
                    }
                }
            } else {
                comboDatos = new ArrayList<String>();
            }
        }//fin del try
        catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del buscarReportesMasivosTrimestralesPorIPS = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
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
                //logEJBTecno.info ("Error de sql de buscarReportesMasivosTrimestralesPorIPS = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }
    
    //************************************************************************************************
    @Override
    public List<ReportePrecol> buscarReportesMasivosTrimestralesPorIPS(String depto, String municipio, java.util.Date fechaIni
            , java.util.Date fechaFin, String idIps, String idRol, String municipioSecretaria, boolean usuarioInvima) {
        List<ReportePrecol> comboDatos = null;
        List<ReportePrecol> comboDatosVacio = null;
        ReportePrecol registroIndividual = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";
        String deptoBuscar = "";
        String municipioBuscar = "";
        boolean seBusca = false;
        java.util.ArrayList<String> tiposDatos = null;
        java.util.ArrayList<String> parametrosBusqueda = null;
        java.util.ArrayList<Object> valoresParametros = null;
        int i = 0;
        int j = 0;
        boolean buscarConMunicipio = false;
        String valorMunicipio = "";
        try {
            logEJBTecno.info("buscarReportesMasivosTrimestralesPorIPS() ");
            logEJBTecno.info("ID DEPARTAMENTO = " + depto);
            logEJBTecno.info("ID MUNICIPIO COMBO = " + municipio);
            logEJBTecno.info("ID IPS FILTRO = " + idIps);
            logEJBTecno.info("fecha inicial = " + fechaIni);
            logEJBTecno.info("fecha inicial = " + fechaFin);
            logEJBTecno.info("ID ROL = " + idRol);
            logEJBTecno.info("ID MUNICIPIO SECRETARÍA = " + municipioSecretaria);
            logEJBTecno.info("ES USUARIO INVIMA = " + usuarioInvima);

            if (depto != null && municipio != null) {
                //logEJBTecno.info ("CONSULTANDO CUANDO DEPTO Y MUNICIPIO NO SON NULOS - CASO MUNICIPIO EN EL COMBO");
                municipioBuscar = " = ";
                buscarConMunicipio = true;
                valorMunicipio = municipio;
                
            } else {
                
                if (usuarioInvima){
                    buscarConMunicipio = false;
                }else{
                    //logEJBTecno.info ("Buscando por defecto con municipio de la sesión de la secretaría");
                    if (depto != null && municipioSecretaria != null) {
                        //logEJBTecno.info ("CONSULTANDO CUANDO DEPTO Y MUNICIPIO NO SON NULOS - CASO SESION");
                        buscarConMunicipio = false;

                        if (       (depto.equals("08") && municipioSecretaria.equals("08001"))
                                || (depto.equals("11") && municipioSecretaria.equals("11001"))
                                || (depto.equals("13") && municipioSecretaria.equals("13001"))
                                || (depto.equals("47") && municipioSecretaria.equals("47001"))
                                || (depto.equals("76") && municipioSecretaria.equals("76109"))) {

                            //logEJBTecno.info ("SE EJECUTARA CONSULTA SOBRE DISTRITO ESPECIAL ESPECIFICO = " + municipioSecretaria);
                            municipioBuscar = " = ";
                            buscarConMunicipio = true;
                            valorMunicipio = municipioSecretaria;

                        } else {
                            //logEJBTecno.info ("SE EJECUTARA CONSULTA SOBRE MUNICIPIOS DE LA SECRETARIA DEPARTAMENTAL EXCEPTO LA DEL DISTRITO ESPECIAL = " + municipioSecretaria);
                            municipioBuscar = " <> ";
                            buscarConMunicipio = true;
                            if (depto.equals("08")) {
                                valorMunicipio = "08001";
                            } else if (depto.equals("11")) {
                                valorMunicipio = "11001";
                            } else if (depto.equals("13")) {
                                valorMunicipio = "13001";
                            } else if (depto.equals("47")) {
                                valorMunicipio = "47001";
                            } else if (depto.equals("76")) {
                                valorMunicipio = "76109";
                            }
                        }
                    }
                }
            }
            
            logEJBTecno.info("SE DEBE BUSCAR CON MUNICIPIO = " + buscarConMunicipio);
            logEJBTecno.info("VALOR MUNICIPIO = " + valorMunicipio);

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
                    + "    datos.cdg_tipoeventoincidente as tipo_reporte, "
                    + "    evalua.cdg_causa as codigo_causa, "
                    + "    evalua.estado_caso as estado_caso, "
                    + "    paci.institucion_incidente as institucion_incidente, "
                    + "    paci.identificacion1 as nit_incidente, "
                    + "    dispo.nroregsan as registro_sanitario, "
                    + "    paci.tipidentificacion as tipidentificacion, "
                    + "    (select ttd.nombre_tipodoc from dbo.tecno_tipodocident ttd where ttd.cdg_tipodoc = paci.tipidentificacion) as nombre_tipodoc, "
                    + "    paci.genero as genero, "
                    + "    paci.identificacion as identificacion, "
                    + "    paci.edad as edad, "
                    + "    dispo.expediente as expediente, "
                    + "    dispo.lote as lote, "
                    + "    dispo.modelo as modelo, "
                    + "    dispo.referencia as referencia, "
                    + "    dispo.serial as serial, "
                    + "    datos.fechevento as fechevento, "
                    + "    datos.fechreporte_evento as fechreporte_evento, "
                    
                    + "    (select tcp.termino_ea from dbo.tecno_causa_probable tcp where tcp.cdg_causa = evalua.cdg_causa) as nombre_causa "
                    + "    from   "
                    + "    dbo.tecno_reporte_eventos_temp datos,  "
                    + "    dbo.tecno_dispositivo_temp dispo, "
                    + "    dbo.tecno_paciente_temp paci, "
                    + "    dbo.tecno_evaluacion_caso_temp evalua "
                    + "    where "
                    + "    (datos.reporte = dispo.reporte) and "
                    + "    (datos.reporte = paci.reporte) and "
                    + "    (datos.reporte = evalua.reporte) ";
            
            tiposDatos = new ArrayList<String>();
            parametrosBusqueda = new ArrayList<String>();
            valoresParametros = new ArrayList<Object>();
            
            if (depto == null && municipio == null && idIps == null && fechaIni == null && fechaFin == null && idRol == null) {
                seBusca = false;
            } else {
                seBusca = true;
                if (depto != null && !depto.equals("0")) {
                    consulta += "and paci.cod_depart = ? ";
                    parametrosBusqueda.add(consulta);
                    valoresParametros.add(depto);
                    tiposDatos.add("cadena");
                }
                
                if (!valorMunicipio.equals("") && buscarConMunicipio == true) {
                    consulta += "and paci.cod_mun " + municipioBuscar + " ? ";
                    parametrosBusqueda.add(consulta);
                    valoresParametros.add(valorMunicipio);
                    tiposDatos.add("cadena");
                }
                
                if (idIps != null && !idIps.equals("-1")) {
                    consulta += "and paci.institucion_reportente = ? "; 
                    parametrosBusqueda.add(consulta);
                    valoresParametros.add(idIps);
                    tiposDatos.add("cadena");
                }
                
                if (fechaIni != null) {
                    consulta += " and datos.fechaingreso >= ? ";
                    parametrosBusqueda.add(consulta);
                    valoresParametros.add(fechaIni);
                    tiposDatos.add("fechaInicial");
                }
                
                if (fechaFin != null) {
                    consulta += " and datos.fechaingreso <= ? ";
                    parametrosBusqueda.add(consulta);
                    valoresParametros.add(fechaFin);
                    tiposDatos.add("fechaFinal");
                }
                
                if (idRol != null) {
                    if (!idRol.equals("todos")) {
                        //logEJBTecno.info ("SE MOSTRARAN SOLO REGISTROS DE ENTIDADES IPS");
                        consulta += "and datos.idrol = ? ";
                        parametrosBusqueda.add(consulta);
                        valoresParametros.add(idRol);
                        tiposDatos.add("cadena");
                    } else {
                        //logEJBTecno.info ("SE MOSTRARAN TODOS LOS REGISTROS");
                    }
                } else {
                    //logEJBTecno.info ("SE MOSTRARAN SOLO REGISTROS DE ENTIDADES IPS");
                    consulta += "and datos.idrol = ? ";
                    parametrosBusqueda.add(consulta);
                    valoresParametros.add("3");
                    tiposDatos.add("cadena");
                }
                
                consulta
                        += "  and datos.cdg_seriedad = 0  ORDER BY datos.reporte, paci.cod_depart, paci.cod_mun asc ";
            }
            logEJBTecno.info(consulta);
            String nombreParametro = "";
            String tipo = "";
            if (seBusca == true) {
                conexion = obtenerConexionDataSource();
                sentencia = conexion.prepareStatement(consulta);
                i = 1;
                j = 0;
                for (Object objeto : valoresParametros) {
                    if (objeto instanceof String) {
                        sentencia.setString(i, String.valueOf(objeto));
                         logEJBTecno.info("i="+i+" - "+" String.valueOf(objeto)="+String.valueOf(objeto));
                        i++;
                        j++;
                    } else if (objeto instanceof java.util.Date) {
                        java.util.Date fecha = (java.util.Date) objeto;
                        nombreParametro = (String) tiposDatos.get(j);
                        if (nombreParametro.equals("fechaInicial")) {
                            tipo = "inicial";
                        } else {
                            tipo = "final";
                        }
                        sentencia.setTimestamp(i, obtenerFechaTimeStamp(fecha, tipo));
                        logEJBTecno.info("i="+i+" - "+" obtenerFechaTimeStamp(fecha, tipo)="+obtenerFechaTimeStamp(fecha, tipo));
                        i++;
                        j++;
                    }
                }
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
                        registroIndividual.setCodigo_causa(cursor.getString("nombre_causa"));
                        
                        TecnoPacienteTemp tecnoPacienteTemp = new TecnoPacienteTemp();
                        tecnoPacienteTemp.setReporte(registroIndividual.getPrecol());
                        tecnoPacienteTemp.setTipidentificacion(cursor.getString("tipidentificacion"));
                        tecnoPacienteTemp.setAutorizacion(cursor.getString("nombre_tipodoc"));
                        tecnoPacienteTemp.setGenero(cursor.getString("genero").charAt(0));
                        tecnoPacienteTemp.setIdentificacion(cursor.getString("identificacion"));
                        tecnoPacienteTemp.setEdad(cursor.getString("edad"));
                        registroIndividual.setRegistroTecnoPacienteTemp(tecnoPacienteTemp);
                        
                        TecnoDispositivoTemp tecnoDispositivoTemp = new TecnoDispositivoTemp();
                            TecnoDispositivoTempPK tecnoDispositivoTempPK = new TecnoDispositivoTempPK();
                            tecnoDispositivoTempPK.setExpediente(cursor.getInt("expediente"));
                            tecnoDispositivoTempPK.setReporte(registroIndividual.getPrecol());
                        tecnoDispositivoTemp.setTecnoDispositivoTempPK(tecnoDispositivoTempPK);
                        tecnoDispositivoTemp.setLote(cursor.getString("lote"));
                        tecnoDispositivoTemp.setModelo(cursor.getString("modelo"));
                        tecnoDispositivoTemp.setReferencia(cursor.getString("referencia"));
                        tecnoDispositivoTemp.setSerial(cursor.getString("serial"));
                        registroIndividual.setRegistroTecnoDispositivoTemp(tecnoDispositivoTemp);
                        
                        TecnoReporteEventosTemp tecnoReporteEventosTemp = new TecnoReporteEventosTemp();
                        tecnoReporteEventosTemp.setReporte(registroIndividual.getPrecol());
                        tecnoReporteEventosTemp.setFechevento(cursor.getDate("fechevento"));
                        tecnoReporteEventosTemp.setFechreporteEvento(cursor.getDate("fechreporte_evento"));     
                        registroIndividual.setRegistroTecnoReporteEventosTemp(tecnoReporteEventosTemp);
                          
                        registroIndividual.setTipo_reporte(obtenerNombreTipoReporte(registroIndividual.getTipo_reporte()));
                        
                        String idMedida;
                        if (registroIndividual.getMedidaEjecutada() != null) {  
                            idMedida = registroIndividual.getMedidaEjecutada();
                        } else {
                            idMedida = "1";
                        }
                        registroIndividual.setMedidaEjecutada(obtenerNombreMedidaEjecutada(idMedida));
                        
                        String sexo = registroIndividual.getRegistroTecnoPacienteTemp().getGenero()+"";
                        registroIndividual.getRegistroTecnoPacienteTemp().setNaturaleza(obtenerNombreSexo(sexo));
                        
                        comboDatos.add(registroIndividual);
                    }
                }
            } else {
                comboDatos = new ArrayList<ReportePrecol>();
                //logEJBTecno.info ("NO SE TRAE NADA EN LA CONSULTA");
            }
        }//fin del try
        catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del buscarReportesMasivosTrimestralesPorIPS = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
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
                //logEJBTecno.info ("Error de sql de buscarReportesMasivosTrimestralesPorIPS = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<ReportePrecol>();
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }
    
    public static String obtenerNombreSexo (String codigo) 
    {
        String valor = "";
        if (codigo.equals("M"))
        {
            valor = "Masculino";
        }
        else
        if (codigo.equals("F"))
        {
            valor = "Femenino";
        }
        else
        {
            valor = "Sin dato";
        }
        return (valor);
    }
    
    private String obtenerNombreMedidaEjecutada(String codigoMedida) {
        String valor = "";
        switch (codigoMedida) {
            case "1":
                valor = "Oficio de requerimiento";
                break;
            case "2":
                valor = "Visita IVC al Prestador de Servicio de Salud";
                break;
            case "3":
                valor = "Visita IVC al fabricante/importador";
                break;
            case "4":
                valor = "Visita IVC al distribuidor/comercializador";
                break;
            case "5":
                valor = "Actividades de IVC de la SDS con el INVIMA";
                break;
            case "6":
                valor = "Asistencia Técnica al fabricante/importador";
                break;
            case "7":
                valor = "Asistencia Técnica al Prestador de Servicio de Salud";
                break;
            case "8":
                valor = "Otro";
                break;
            case "9":
                valor = "Ninguna acción";
                break;
        }
        return (valor);
    }
    
    public String obtenerNombreTipoReporte(String codigoTipo) {
        String nombre = "";
        switch (codigoTipo) {
            case "1":
                nombre = "Evento adverso serio";
                break;
            case "2":
                nombre = "Evento adverso no serio";
                break;
            case "3":
                nombre = "Incidente adverso serio";
                break;
            case "4":
                nombre = "Incidente adverso no serio";
                break;
        }
        return (nombre);
    }
    
    @Override
    public List<ReportePrecol> buscarReportesMasivosTrimestralesPorIPS(String depto, String municipio, String idIPS) {
        List<ReportePrecol> comboDatos = null;
        List<ReportePrecol> comboDatosVacio = null;
        ReportePrecol registroIndividual = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
           
            consulta
                    = "SELECT "
                    + "    datos.reporte as precol,  "
                    + "    (select dep.descripcion from dbo.departamentos dep where dep.cod_depart = paci.cod_depart) as departamento,  "
                    + "    (select mun.descripcion from dbo.municipios mun where mun.cod_mun = paci.cod_mun) as municipio,  "
                    + "    paci.contacto_reportante as nombre_reportante, "
                    + "    datos.idrol as id_rol, "
                    + "    datos.fechaingreso as fecha_ingreso, "
                    + "    datos.descripcion_evento as descripcionEvento,  "
                    + "    dispo.nombre_dispositivo as nombre_dispositivo, "
                    + "    datos.cdg_tiporeporte as tipo_reporte, "
                    + "    evalua.cdg_causa as codigo_causa, "
                    + "    evalua.estado_caso as estado_caso "
                    + "    from   "
                    + "    dbo.tecno_reporte_eventos_temp datos,  "
                    + "    dbo.tecno_dispositivo_temp dispo, "
                    + "    dbo.tecno_paciente_temp paci, "
                    + "    dbo.tecno_evaluacion_caso_temp evalua "
                    + "    where "
                    + "    (datos.reporte = dispo.reporte) and "
                    + "    (datos.reporte = paci.reporte) and "
                    + "    (datos.reporte = evalua.reporte) ";
            //******************************************************************
            //******************************************************************
            //******************************************************************
            //******************************************************************
            if (depto != null) {
                //"and paci.cod_depart = ? ";
                consulta
                        += "and paci.cod_depart = ? ";

                if (municipio != null) {
                    //"and paci.cod_mun = ? ";
                    consulta
                            += "and paci.cod_mun = ? ";

                    if (idIPS != null) {
                        consulta
                                += "and datos.idips = ? ";
                    }
                } else {
                    if (idIPS != null) {
                        consulta
                                += "and datos.idips = ? ";
                    }
                }
            } else {
                if (idIPS != null) {
                    consulta
                            += "and datos.idips = ? ";
                }
            }
            //******************************************************************
            //******************************************************************
            //******************************************************************
            consulta
                    += "order by datos.reporte, paci.cod_depart, paci.cod_mun asc ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del buscarReportesMasivosTrimestralesPorIPS = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            //***************************************************************
            //***************************************************************
            if (depto != null) {
                sentencia.setString(1, depto);

                if (municipio != null) {
                    sentencia.setString(2, municipio);

                    if (idIPS != null) {
                        sentencia.setInt(3, Integer.valueOf(idIPS));
                    }
                } else {
                    if (idIPS != null) {
                        sentencia.setInt(2, Integer.valueOf(idIPS));
                    }
                }
            } else {
                if (idIPS != null) {
                    sentencia.setInt(1, Integer.valueOf(idIPS));
                }
            }
            //******************************************************************
            //******************************************************************
            //***************************************************************
            //***************************************************************
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                comboDatos = new ArrayList<ReportePrecol>();
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
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
                    //*******************************************
                    //*******************************************
                    /*
                    registroIndividual = new ReportePrecol();
                    registroIndividual.setPrecol (cursor.getString(1));
                    registroIndividual.setDepartamento (cursor.getString(2));
                    registroIndividual.setMunicipio (cursor.getString(3));
                    registroIndividual.setFechaEvento (cursor.getDate(4));
                    registroIndividual.setDescripcionEvento (cursor.getString(5));
                    registroIndividual.setDeteccion_evento (cursor.getString(6));
                    registroIndividual.setFechaIngreso (cursor.getDate(7));
                    registroIndividual.setNombreComercial (cursor.getString(8));
                    registroIndividual.setIdentificacion (cursor.getString(9));
                    registroIndividual.setDiagnostico (cursor.getString(10));
                     */
                    //*******************************************
                    //*******************************************
                    comboDatos.add(registroIndividual);
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del buscarReportesMasivosTrimestralesPorIPS = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
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
                //logEJBTecno.info ("Error de sql de buscarReportesMasivosTrimestralesPorIPS = " + errorSQL.getLocalizedMessage());
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
    @Override
    public TecnoReporteEventosTemp consultarRegistroTecnoReporteEventosTemp(String codigoPrecol) {
        return (ejbTecnoReporteEventosTemp.find(codigoPrecol));
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public TecnoPacienteTemp consultarRegistroTecnoPacienteTemp(String codigoPrecol) {
        return (ejbTecnoPacienteTemp.find(codigoPrecol));
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public TecnoDispositivoTemp consultarRegistroTecnoDispositivoTemp(TecnoDispositivoTempPK llaveCombinada) {
        return (ejbTecnoDispositivoTemp.find(llaveCombinada));
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public TecnoEvaluacionCasoTemp consultarRregistroTecnoEvaluacionCasoTemp(String codigoPrecol) {
        return (ejbTecnoEvaluacionCasoTemp.find(codigoPrecol));
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public TecnoReporteEventos consultarRegistroTecnoReporteEventos(String codigoCol) {
        return (ejbTecnoReporteEventos.find(codigoCol));
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public TecnoPaciente consultarRegistroTecnoPaciente(String codigoCol) {
        return (ejbTecnoPaciente.find(codigoCol));
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public TecnoDispositivo consultarRegistroTecnoDispositivo(String llaveCombinada) {
        return (ejbTecnoDispositivo.find(llaveCombinada));
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public TecnoEvaluacionCaso consultarRregistroTecnoEvaluacionCaso(String codigoCol) {
        return (ejbTecnoEvaluacionCaso.find(codigoCol));
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerCodigoRegistroSanitarioPorPrecol(String codigoPrecol) {
        String nombreConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO obtenerCodigoRegistroSanitarioPorPrecol = " + codigoPrecol);
            consulta
                    = "select expediente from dbo.tecno_dispositivo_temp where reporte = ? ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerNombreTipoDispositivo = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, codigoPrecol);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nombreConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }

                //logEJBTecno.info ("CODIGO REGISTRO SANITARIO = " + nombreConcepto);
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerCodigoRegistroSanitarioPorPrecol = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("SIN CONCEPTO");
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
                //logEJBTecno.info ("Error de sql de obtenerCodigoRegistroSanitarioPorPrecol = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("SIN CONCEPTO");
            }
        }

        return (nombreConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerCodigoRegistroSanitarioPorCOL(String codigoCOL) {
        String nombreConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO obtenerCodigoRegistroSanitarioPorCOL = " + codigoCOL);
            consulta
                    = "select expediente from dbo.tecno_dispositivo where reporte = ? ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerCodigoRegistroSanitarioPorCOL = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, codigoCOL);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nombreConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }

                if (nombreConcepto.equals("")) {
                    nombreConcepto = "1";
                }

                //logEJBTecno.info ("CODIGO REGISTRO SANITARIO POR COL = " + nombreConcepto);
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerCodigoRegistroSanitarioPorPrecol = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("SIN CONCEPTO");
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
                //logEJBTecno.info ("Error de sql de obtenerCodigoRegistroSanitarioPorPrecol = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("SIN CONCEPTO");
            }
        }

        return (nombreConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public boolean crearRegistroTecnoReporteEventosCol(TecnoReporteEventos registroTRE, String codigoColDefinitivo) {
        boolean seInserta = false;

        try {
            ejbTecnoReporteEventos.create(registroTRE);
            seInserta = true;
        } catch (Exception errorcrearRegistroTecnoReporteEventos) {
            errorcrearRegistroTecnoReporteEventos.printStackTrace();
            return (false);
        }

        return (seInserta);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public boolean crearRegistroTecnoDispositivoCol(TecnoDispositivo registroDispositivo, String codigoColDefinitivo) {
        boolean seInserta = false;

        try {
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("Ejecutando método crearRegistroTecnoDispositivo con COL");
            ejbTecnoDispositivo.create(registroDispositivo);
            seInserta = true;
            //logEJBTecno.info ("Se generó la inserción del registro del registroDispositivo = " + seInserta);
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
        } catch (Exception errorcrearRegistroTecnoDispositivo) {
            //logEJBTecno.info ("ERROR en el método crearRegistroTecnoDispositivo = " + errorcrearRegistroTecnoDispositivo.getLocalizedMessage());
            errorcrearRegistroTecnoDispositivo.printStackTrace();
            return (false);
        }

        return (seInserta);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public boolean crearRegistroTecnoPacienteCol(TecnoPaciente registroPaciente, String codigoColDefinitivo) {
        boolean seInserta = false;

        try {
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("Ejecutando método crearRegistroTecnoPaciente con COL");
            ejbTecnoPaciente.create(registroPaciente);
            seInserta = true;
            //logEJBTecno.info ("Se generó la inserción del registro del registroDispositivo = " + seInserta);
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
        } catch (Exception errorcrearRegistroTecnoPaciente) {
            //logEJBTecno.info ("ERROR en el método crearRegistroTecnoPaciente = " + errorcrearRegistroTecnoPaciente.getLocalizedMessage());
            errorcrearRegistroTecnoPaciente.printStackTrace();
            return (false);
        }

        return (seInserta);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public boolean crearRegistroTecnoEvaluacionCasoCol(TecnoEvaluacionCaso registroEvaluacionCaso, String codigoColDefinitivo) {
        boolean seInserta = false;

        try {
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("Ejecutando método crearRegistroTecnoEvaluacionCaso con COL");
            ejbTecnoEvaluacionCaso.create(registroEvaluacionCaso);
            seInserta = true;
            //logEJBTecno.info ("Se generó la inserción del registro del registroEvaluacionCaso = " + seInserta + " con COL  = " + codigoColDefinitivo);
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
        } catch (Exception errorcrearRegistroTecnoEvaluacionCaso) {
            //logEJBTecno.info ("ERROR en el método crearRegistroTecnoEvaluacionCaso = " + errorcrearRegistroTecnoEvaluacionCaso.getLocalizedMessage());
            errorcrearRegistroTecnoEvaluacionCaso.printStackTrace();
            return (false);
        }

        return (seInserta);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public boolean eliminarRegistroTecnoReporteEventos(TecnoReporteEventosTemp registroTRE, String codigoPrecol) {
        boolean seInserta = false;

        try {
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("Ejecutando método eliminarRegistroTecnoReporteEventos");
            ejbTecnoReporteEventosTemp.remove(registroTRE);
            seInserta = true;
            //logEJBTecno.info ("Se generó la eliminación del registro del registroTRE = " + seInserta + " con precol = " + codigoPrecol);
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
        } catch (Exception erroreliminarRegistroTecnoReporteEventos) {
            //logEJBTecno.info ("ERROR en el método eliminarRegistroTecnoReporteEventos = " + erroreliminarRegistroTecnoReporteEventos.getLocalizedMessage());
            erroreliminarRegistroTecnoReporteEventos.printStackTrace();
            return (false);
        }

        return (seInserta);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public boolean eliminarRegistroTecnoDispositivo(TecnoDispositivoTemp registroDispositivo, String codigoPrecol) {
        boolean seInserta = false;

        try {
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("Ejecutando método eliminarRegistroTecnoDispositivo");
            ejbTecnoDispositivoTemp.remove(registroDispositivo);
            seInserta = true;
            //logEJBTecno.info ("Se generó la eliminación del registro del registroDispositivo = " + seInserta);
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
        } catch (Exception erroreliminarRegistroTecnoDispositivo) {
            //logEJBTecno.info ("ERROR en el método eliminarRegistroTecnoDispositivo = " + erroreliminarRegistroTecnoDispositivo.getLocalizedMessage());
            erroreliminarRegistroTecnoDispositivo.printStackTrace();
            return (false);
        }

        return (seInserta);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public boolean eliminarRegistroTecnoPaciente(TecnoPacienteTemp registroPaciente, String codigoPrecol) {
        boolean seInserta = false;

        try {
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("Ejecutando método eliminarRegistroTecnoPaciente");
            ejbTecnoPacienteTemp.remove(registroPaciente);
            seInserta = true;
            //logEJBTecno.info ("Se generó la eliminación del registro del registroDispositivo = " + seInserta);
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
        } catch (Exception erroreliminarRegistroTecnoPaciente) {
            //logEJBTecno.info ("ERROR en el método eliminarRegistroTecnoPaciente = " + erroreliminarRegistroTecnoPaciente.getLocalizedMessage());
            erroreliminarRegistroTecnoPaciente.printStackTrace();
            return (false);
        }

        return (seInserta);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public boolean eliminarRegistroTecnoEvaluacionCaso(TecnoEvaluacionCasoTemp registroEvaluacionCaso, String codigoPrecol) {
        boolean seInserta = false;

        try {
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("Ejecutando método eliminarRegistroTecnoEvaluacionCaso");
            ejbTecnoEvaluacionCasoTemp.remove(registroEvaluacionCaso);
            seInserta = true;
            //logEJBTecno.info ("Se generó la eliminación del registro del registroEvaluacionCaso = " + seInserta + " con precol = " + codigoPrecol);
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
        } catch (Exception erroreliminarRegistroTecnoEvaluacionCaso) {
            //logEJBTecno.info ("ERROR en el método eliminarRegistroTecnoEvaluacionCaso = " + erroreliminarRegistroTecnoEvaluacionCaso.getLocalizedMessage());
            erroreliminarRegistroTecnoEvaluacionCaso.printStackTrace();
            return (false);
        }

        return (seInserta);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String verificarExpedienteDispositivoPorRegistroSanitario(String codigoRegistroSanitario) {
        String codigoExpedienteDispositivo = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";
        String parametro = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO verificarExpedienteDispositivoPorRegistroSanitario por codigo de Registro Sanitario INVIMA = " + codigoRegistroSanitario);
            consulta
                    = "SELECT "
                    + "expe.nroexpediente "
                    + "from "
                    + "registro.dbo.registro_sanitario rg, "
                    + "registro.dbo.expedientes expe "
                    + "where (rg.cdgregsan = expe.cdgregsan and "
                    + "rg.cdgexpediente = expe.cdgexpediente) "
                    + "and rg.nroregsan like ? ";

            parametro = "%" + codigoRegistroSanitario.trim() + "%";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del verificarExpedienteDispositivoPorRegistroSanitario = " + consulta);
            //logEJBTecno.info ("PARAMETRO BUSQUEDA = " + parametro);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, parametro);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    codigoExpedienteDispositivo = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }
                //*********************************************************
                //*********************************************************
                //logEJBTecno.info ("codigoExpedienteDispositivo = " + codigoExpedienteDispositivo);
                //*********************************************************
                //*********************************************************
                //*********************************************************
                if (codigoExpedienteDispositivo != null) {
                    if (codigoExpedienteDispositivo.length() > 0) {
                        //logEJBTecno.info ("CODIGO EXPEDIENTE = " + codigoExpedienteDispositivo);
                    } else {
                        codigoExpedienteDispositivo = "00000000";
                        //logEJBTecno.info ("CODIGO NULO = " + codigoExpedienteDispositivo);
                    }
                } else {
                    codigoExpedienteDispositivo = "00000000";
                    //logEJBTecno.info ("CODIGO NULO = " + codigoExpedienteDispositivo);
                }
                //*********************************************************
                //*********************************************************
                //*********************************************************
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorverificarExpedienteDispositivoPorRegistroSanitario) {
            //logEJBTecno.info ("Error en la generación del obtenerCodigoRegistroSanitarioPorPrecol = " + errorverificarExpedienteDispositivoPorRegistroSanitario.getLocalizedMessage());
            errorverificarExpedienteDispositivoPorRegistroSanitario.printStackTrace();
            return ("00000000");
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
                //logEJBTecno.info ("Error de sql de obtenerCodigoRegistroSanitarioPorPrecol = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("00000000");
            }
        }

        return (codigoExpedienteDispositivo);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerIdRolUsuarioPorNIT(String nitEmpresa) {
        String nombreConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO obtenerIdRolUsuarioPorNIT = " + nitEmpresa);
            consulta
                    = "select ID_Rol_Usuario from dbo.tecno_usuarios_internet where identificacion_empresa = ?  and estado_usuario = 'A' ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerCorreoEmpresaPorNIT = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, nitEmpresa);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nombreConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }

                //logEJBTecno.info ("ID ROL EMPRESA = " + nombreConcepto);
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerIdRolUsuarioPorNIT = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("3");
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
                //logEJBTecno.info ("Error de sql de obtenerIdRolUsuarioPorNIT = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("3");
            }
        }

        return (nombreConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerCorreoEmpresaPorNIT(String nitEmpresa) {
        String nombreConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO obtenerCorreoEmpresaPorNIT = " + nitEmpresa);
            consulta
                    = "select email_empresa from dbo.tecno_usuarios_internet where identificacion_empresa = ?  and estado_usuario = 'A' ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerCorreoEmpresaPorNIT = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, nitEmpresa);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nombreConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }

                //logEJBTecno.info ("EMAIL EMPRESA = " + nombreConcepto);
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerCodigoRegistroSanitarioPorPrecol = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("tecnovigilancia@invima.gov.co");
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
                //logEJBTecno.info ("Error de sql de obtenerCodigoRegistroSanitarioPorPrecol = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("tecnovigilancia@invima.gov.co");
            }
        }

        return (nombreConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerNombreEmpresaIPSPorNit(String nitEmpresa) {
        String nombreConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO obtenerNombreEmpresaIPSPorNit = " + nitEmpresa);
            consulta
                    = "select concat(identificacion_empresa,' - ',nombre_empresa) from dbo.tecno_usuarios_internet where identificacion_empresa = ? ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerNombreEmpresaIPSPorNit = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, nitEmpresa);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nombreConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }

                //logEJBTecno.info ("NIT Y NOMBRE EMPRESA = " + nombreConcepto);
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerNombreEmpresaIPSPorNit = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("tecnovigilancia@invima.gov.co");
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
                //logEJBTecno.info ("Error de sql de obtenerNombreEmpresaIPSPorNit = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("tecnovigilancia@invima.gov.co");
            }
        }

        return (nombreConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerCodigoFuncionarioInvima(String nombreUsuario) {
        String nombreConcepto = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("MÉTODO obtenerCodigoFuncionarioInvima = " + nombreUsuario);
            consulta
                    = "select cdgfuncionario from dbo.funcionarios where login_name = ? ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerCodigoFuncionarioInvima = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1, nombreUsuario);
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nombreConcepto = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }

                //logEJBTecno.info ("CODIGO DEL FUNCIONARIO " + nombreUsuario + " = " + nombreConcepto);
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerCodigoEventoDeteccion) {
            //logEJBTecno.info ("Error en la generación del obtenerNombreEmpresaIPSPorNit = " + errorobtenerCodigoEventoDeteccion.getLocalizedMessage());
            errorobtenerCodigoEventoDeteccion.printStackTrace();
            return ("938");
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
                //logEJBTecno.info ("Error de sql de obtenerNombreEmpresaIPSPorNit = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("938");
            }
        }

        return (nombreConcepto);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<String> obtenerListadoUsuariosIPS(String tipo, String depto) {
        return buscarNombreReportantes(depto);
    }
    
    @Override
    public List<String> obtenerListadoTODOSUsuariosIPS() {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            consulta
                    = "SELECT DISTINCT institucion_reportente as NOMBRE "
                    + "from   "
                    + " dbo.tecno_paciente_temp order by institucion_reportente asc ";

            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            cursor = sentencia.executeQuery();

            if (cursor != null) {
                comboDatos = new ArrayList<String>();
                while (cursor.next()) {
                    comboDatos.add(cursor.getString(1));
                    comboDatos.add(cursor.getString(1));
                }
            }
        } catch (Exception errorobtenerTiposDeSucursal) {
            errorobtenerTiposDeSucursal.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                comboDatosVacio.add("SIN VALOR");
                return (comboDatosVacio);
            }
        }
        return (comboDatos);
    }

    @Override
    public List<String> obtenerListadoUsuariosIPS(String tipo, String depto, String idMunicipio, boolean esDistrito) {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";
        String restomun = "";
        String prefijoDepto = "";

        try {
            prefijoDepto = idMunicipio.substring(0, 2);
            if (tipo.equals("todos")) {
                consulta
                        = "SELECT distinct   "
                        + " datos.idips as ID,   "
                        + "  (select top 1 dbo.tecno_usuarios_internet.nombre_empresa from dbo.tecno_usuarios_internet where dbo.tecno_usuarios_internet.identificacion_empresa = datos.idips group by dbo.tecno_usuarios_internet.nombre_empresa) as NOMBRE   "
                        + "from   "
                        + " dbo.tecno_paciente_temp registros,   "
                        + " dbo.tecno_reporte_eventos_temp datos  "
                        + "where   (datos.reporte = registros.reporte) and   "
                        + " registros.cod_depart1 = ? and   datos.idrol IN (2,3) and   "
                        + " datos.cdg_seriedad = 0   "
                        + " group by  datos.idips   order by datos.idips asc ";
            } else {

                if (esDistrito == true) {
                    //***************************************************************************
                    //***************************************************************************
                    consulta
                            = "SELECT distinct   "
                            + " datos.idips as ID,   "
                            + "  (select top 1 dbo.tecno_usuarios_internet.nombre_empresa from dbo.tecno_usuarios_internet where dbo.tecno_usuarios_internet.identificacion_empresa = datos.idips group by dbo.tecno_usuarios_internet.nombre_empresa) as NOMBRE   "
                            + "from   "
                            + " dbo.tecno_paciente_temp registros,   "
                            + " dbo.tecno_reporte_eventos_temp datos  "
                            + "where   (datos.reporte = registros.reporte) and   "
                            + " registros.cod_depart1 = ? and   datos.idrol = '3' and   "
                            + " datos.cdg_seriedad = 0   and "
                            + " registros.cod_mun1 = ? "
                            + " group by  datos.idips   order by datos.idips asc ";
                    //***************************************************************************
                    //***************************************************************************
                } else {
                    //***************************************************************************
                    //***************************************************************************
                    if (prefijoDepto.equals("08") || prefijoDepto.equals("11") || prefijoDepto.equals("13") || prefijoDepto.equals("47") || prefijoDepto.equals("76")) {
                        //logEJBTecno.info ("TRAYENDO IPS DEL DEPTO DISTINTAS AL DISTRITO ESPECIAL");
                        consulta
                                = "SELECT distinct   "
                                + " datos.idips as ID,   "
                                + "  (select top 1 dbo.tecno_usuarios_internet.nombre_empresa from dbo.tecno_usuarios_internet where dbo.tecno_usuarios_internet.identificacion_empresa = datos.idips group by dbo.tecno_usuarios_internet.nombre_empresa) as NOMBRE   "
                                + "from   "
                                + " dbo.tecno_paciente_temp registros,   "
                                + " dbo.tecno_reporte_eventos_temp datos  "
                                + "where   (datos.reporte = registros.reporte) and   "
                                + " registros.cod_depart1 = ? and   datos.idrol = '3' and   "
                                + " datos.cdg_seriedad = 0  and "
                                + " (registros.cod_mun1 like ? and registros.cod_mun1 <> ?) "
                                + " group by  datos.idips   order by datos.idips asc ";
                    } else {
                        //logEJBTecno.info ("TRAYENDO IPS DE TODO EL DEPARTAMENTO PORQUE NO ES DISTRITO ESPECIAL");
                        consulta
                                = "SELECT distinct   "
                                + " datos.idips as ID,   "
                                + "  (select top 1 dbo.tecno_usuarios_internet.nombre_empresa from dbo.tecno_usuarios_internet where dbo.tecno_usuarios_internet.identificacion_empresa = datos.idips group by dbo.tecno_usuarios_internet.nombre_empresa) as NOMBRE   "
                                + "from   "
                                + " dbo.tecno_paciente_temp registros,   "
                                + " dbo.tecno_reporte_eventos_temp datos  "
                                + "where   (datos.reporte = registros.reporte) and   "
                                + " registros.cod_depart1 = ? and   datos.idrol = '3' and   "
                                + " datos.cdg_seriedad = 0  and "
                                + " (registros.cod_mun1 like ?) "
                                + " group by  datos.idips   order by datos.idips asc ";
                    }
                    //***************************************************************************
                    //***************************************************************************
                }
                //***************************************************************************
                //***************************************************************************
            }
            //***************************************************************
            //***************************************************************
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerListadoUsuariosIPS tipo = " + consulta);
            conexion = obtenerConexionDataSource();
            //***************************************************************
            //***************************************************************
            sentencia = conexion.prepareStatement(consulta);
            //***************************************************************
            //***************************************************************
            if (tipo.equals("todos")) {
                sentencia.setString(1, depto);
            } else {
                if (esDistrito == true) {
                    sentencia.setString(1, depto);
                    sentencia.setString(2, idMunicipio);
                } else {
                    if (prefijoDepto.equals("08") || prefijoDepto.equals("11") || prefijoDepto.equals("13") || prefijoDepto.equals("47") || prefijoDepto.equals("76")) {
                        restomun = depto + "%";
                        sentencia.setString(1, depto);
                        sentencia.setString(2, restomun);
                        sentencia.setString(3, obtenerIdDistritoEspecial(depto));
                        //logEJBTecno.info ("restomun = " + restomun);
                        //logEJBTecno.info ("municipio descartar = " + obtenerIdDistritoEspecial(depto));
                    } else {
                        restomun = depto + "%";
                        sentencia.setString(1, depto);
                        sentencia.setString(2, restomun);
                        //logEJBTecno.info ("restomun = " + restomun);
                    }
                }
            }
            //***************************************************************
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
                    comboDatos.add(cursor.getString(2));
                    //*******************************************
                    //*******************************************
                }
            }
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerListadoUsuariosIPS = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                //logEJBTecno.info ("Error de sql de obtenerListadoUsuariosIPS = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("0");
                comboDatosVacio.add("SIN VALOR");
                return (comboDatosVacio);
            }
        }

        return (comboDatos);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    private String obtenerIdDistritoEspecial(String idDeptoMunicipio) {
        String idDistrito = "";

        if (idDeptoMunicipio.equals("08")) {
            idDistrito = "08001";
        } else if (idDeptoMunicipio.equals("11")) {
            idDistrito = "11001";
        } else if (idDeptoMunicipio.equals("13")) {
            idDistrito = "13001";
        } else if (idDeptoMunicipio.equals("47")) {
            idDistrito = "47001";
        } else if (idDeptoMunicipio.equals("76")) {
            idDistrito = "76109";
        }

        return (idDistrito);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public boolean modificarRegistroTecnoReporteEventosTemporalEstadoAprobacion(TecnoReporteEventosTemp registroTRE, String codigoColDefinitivo) {
        boolean seModifica = false;

        try {
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("Ejecutando método modificarRegistroTecnoReporteEventosTemporalEstadoAprobacion para actualizar codigo cdg_seriedad (marca de aprobación o pendiente)");
            ejbTecnoReporteEventosTemp.edit(registroTRE);
            seModifica = true;
            //logEJBTecno.info ("Se realizó la actualización del registro del registroTRE = " + seModifica + " con precol = " + codigoColDefinitivo);
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
        } catch (Exception errorcrearRegistroTecnoReporteEventos) {
            //logEJBTecno.info ("ERROR en el método modificarRegistroTecnoReporteEventosTemporalEstadoAprobacion = " + errorcrearRegistroTecnoReporteEventos.getLocalizedMessage());
            errorcrearRegistroTecnoReporteEventos.printStackTrace();
            return (false);
        }

        return (seModifica);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public boolean modificarRegistroTecnoReporteEventos(TecnoReporteEventosTemp registroTRE, String codigoPrecol) {
        boolean seModifica = false;

        try {
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("Ejecutando método crearRegistroTecnoReporteEventos");
            ejbTecnoReporteEventosTemp.edit(registroTRE);
            seModifica = true;
            //logEJBTecno.info ("Se generó la modificación del registro del registroTRE = " + seModifica + " con precol = " + codigoPrecol);
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
        } catch (Exception errormodificarRegistroTecnoReporteEventos) {
            //logEJBTecno.info ("ERROR en el método modificarRegistroTecnoReporteEventos = " + errormodificarRegistroTecnoReporteEventos.getLocalizedMessage());
            errormodificarRegistroTecnoReporteEventos.printStackTrace();
            return (false);
        }

        return (seModifica);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public boolean modificarRegistroTecnoDispositivo(TecnoDispositivoTemp registroDispositivo, String codigoPrecol) {
        boolean seModifica = false;

        try {
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("Ejecutando método modificarRegistroTecnoDispositivo");
            ejbTecnoDispositivoTemp.edit(registroDispositivo);
            seModifica = true;
            //logEJBTecno.info ("Se generó la modificación del registro del registroTRE = " + seModifica + " con precol = " + codigoPrecol);
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
        } catch (Exception errormodificarRegistroTecnoDispositivo) {
            //logEJBTecno.info ("ERROR en el método modificarRegistroTecnoDispositivo = " + errormodificarRegistroTecnoDispositivo.getLocalizedMessage());
            errormodificarRegistroTecnoDispositivo.printStackTrace();
            return (false);
        }

        return (seModifica);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public boolean modificarRegistroTecnoPaciente(TecnoPacienteTemp registroPaciente, String codigoPrecol) {
        boolean seModifica = false;

        try {
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("Ejecutando método modificarRegistroTecnoPaciente");
            ejbTecnoPacienteTemp.edit(registroPaciente);
            seModifica = true;
            //logEJBTecno.info ("Se generó la modificación del registro del registroPaciente = " + seModifica + " con precol = " + codigoPrecol);
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
        } catch (Exception errormodificarRegistroTecnoPaciente) {
            //logEJBTecno.info ("ERROR en el método modificarRegistroTecnoPaciente = " + errormodificarRegistroTecnoPaciente.getLocalizedMessage());
            errormodificarRegistroTecnoPaciente.printStackTrace();
            return (false);
        }

        return (seModifica);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public boolean modificarRegistroTecnoEvaluacionCaso(TecnoEvaluacionCasoTemp registroEvaluacionCaso, String codigoPrecol) {
        boolean seModifica = false;

        try {
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("Ejecutando método modificarRegistroTecnoEvaluacionCaso");
            ejbTecnoEvaluacionCasoTemp.edit(registroEvaluacionCaso);
            seModifica = true;
            //logEJBTecno.info ("Se generó la modificación del registro del registroEvaluacionCaso = " + seModifica + " con precol = " + codigoPrecol);
            //logEJBTecno.info ("----------------------------------------------------");
            //logEJBTecno.info ("----------------------------------------------------");
        } catch (Exception errormodificarRegistroTecnoEvaluacionCaso) {
            //logEJBTecno.info ("ERROR en el método modificarRegistroTecnoEvaluacionCaso = " + errormodificarRegistroTecnoEvaluacionCaso.getLocalizedMessage());
            errormodificarRegistroTecnoEvaluacionCaso.printStackTrace();
            return (false);
        }

        return (seModifica);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerNombreFuncionario(String idFuncionario) {
        String nombreFuncionario = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("EJECUTANDO MÉTODO PARA OBTENER EL ÚLTIMO PRECOL");
            //***************************************************************
            //***************************************************************
            consulta = "select concat(nmbfuncionario,' - ',login_name) as nbmfuncionario from dbo.funcionarios where cdgfuncionario = ? ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerPrecolSecuenciaCargue = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, Integer.valueOf(idFuncionario));
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info  ("rs de precol = " + cursor);
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nombreFuncionario = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }
                //logEJBTecno.info  ("---->");
                //logEJBTecno.info  ("NUEVO PRECOL OBTENIDO = " + nuevoPrecol);
                //logEJBTecno.info  ("---->");
            }
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("---------------------------------------------------------");
            //logEJBTecno.info ("SECUENCIA DE PRECOL OBTENIDO = " + nuevoPrecol);
            //logEJBTecno.info ("---------------------------------------------------------");
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerPrecolSecuenciaCargue = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            return ("FUNCIONARIO TECNOVIGILANCIA");
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
                //logEJBTecno.info ("Error de sql de obtenerPrecolSecuenciaCargue = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("FUNCIONARIO TECNOVIGILANCIA");
            }
        }

        return (nombreFuncionario);
    }

    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public String obtenerNombreFuncionarioSecretaria(String idFuncionario) {
        String nombreFuncionario = "";
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";

        try {
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("EJECUTANDO MÉTODO PARA OBTENER EL ÚLTIMO PRECOL");
            //***************************************************************
            //***************************************************************
            //consulta = "select top 1 concat (tecno_usuarios_internet.nombre_persona,' - ',tecno_usuarios_internet.usuario) as nbmfuncionario from dbo.tecno_usuarios_internet where tecno_usuarios_internet.identificacion_persona = ? ";
            consulta = "select top 1 tecno_usuarios_internet.nombre_persona as nbmfuncionario from dbo.tecno_usuarios_internet where tecno_usuarios_internet.identificacion_persona = ? ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del obtenerPrecolSecuenciaCargue = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, Integer.valueOf(idFuncionario));
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info  ("rs de precol = " + cursor);
            if (cursor != null) {
                while (cursor.next()) {
                    //*******************************************
                    //*******************************************
                    nombreFuncionario = cursor.getString(1);
                    //*******************************************
                    //*******************************************
                }
                //logEJBTecno.info  ("---->");
                //logEJBTecno.info  ("NUEVO PRECOL OBTENIDO = " + nuevoPrecol);
                //logEJBTecno.info  ("---->");
            }
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("---------------------------------------------------------");
            //logEJBTecno.info ("SECUENCIA DE PRECOL OBTENIDO = " + nuevoPrecol);
            //logEJBTecno.info ("---------------------------------------------------------");
            //***************************************************************
            //***************************************************************
        } catch (Exception errorobtenerTiposDeSucursal) {
            //logEJBTecno.info ("Error en la generación del obtenerPrecolSecuenciaCargue = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            return ("FUNCIONARIO SECRETARÍA DE SALUD");
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
                //logEJBTecno.info ("Error de sql de obtenerPrecolSecuenciaCargue = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return ("FUNCIONARIO SECRETARÍA DE SALUD");
            }
        }

        return (nombreFuncionario);
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
}
//*******************************************************************************
//*******************************************************************************
//*******************************************************************************
//*******************************************************************************
//*******************************************************************************
//*******************************************************************************
//*******************************************************************************
//*******************************************************************************
//*******************************************************************************

