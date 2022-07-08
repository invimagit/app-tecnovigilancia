/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.negocio;

import co.gov.invima.dao.TecnoReportesCeroFacadeLocal;
import co.gov.invima.dao.TecnoUsuariosInternetFacadeLocal;
import co.gov.invima.dto.TecnoRepCeroConsultaVO;
import co.gov.invima.dto.TecnoReporteCeroVO;
import co.gov.invima.dto.TecnoUsuarioInternetVO;
import co.gov.invima.entidad.TecnoReportesCero;
import co.gov.invima.entidad.TecnoUsuariosInternet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import javax.ejb.EJB;
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
 * @author Diana Silva
 */
@Stateless
public class ServicioReporteCero implements ServicioReporteCeroRemote 
{
    //*******************************************************************************************
    //*******************************************************************************************
    private final static Logger logEJBTecno = Logger.getLogger(ServicioReporteCero.class.getName());
    //*******************************************************************************************
    //*******************************************************************************************
    @EJB
    private TecnoReportesCeroFacadeLocal ejbTecnoReporteCero;  
    //*******************************************************************************************
    //*******************************************************************************************
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager manejadorEntidadesDireccion;
    //*******************************************************************************************
    //*******************************************************************************************
    @EJB
    private TecnoUsuariosInternetFacadeLocal ejbTecnoUsuariosInternet;
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    private java.sql.Connection obtenerConexionDataSource()
    {
        java.sql.Connection conexionBD = null;
        try
        {
            DataSource dataSourceJBoss = null;
            Context ctx = new InitialContext();
            dataSourceJBoss = (DataSource)ctx.lookup("java:/jboss/SybaseTecno");
            //logEJBTecno.info ("Datasource del contenedor: " + dataSourceJBoss);
            conexionBD = dataSourceJBoss.getConnection();
        }

        catch (SQLException errorConexionSQL)
        {
            errorConexionSQL.printStackTrace();
        }
        
        catch (NamingException errorConexionDS)
        {
            errorConexionDS.printStackTrace();
        }
        return (conexionBD);
    }        
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //public boolean crearRegistroReporteCero(TecnoReporteCeroVO registroReporteCero) 
    @Override
    public java.util.ArrayList<Object> crearRegistroReporteCero(TecnoReporteCeroVO registroReporteCero) 
    {
        boolean seCreoReporte = false;
        TecnoReportesCero registro = null;
        //long id = 1L;
        int id = 0;
        String radicado = "";
        java.util.Date fechaSistema = null;
        java.util.ArrayList<Object> registros = new java.util.ArrayList<Object>();
        
        try
        {
            //logEJBTecno.info ("***************************************************************************************************************");
            //logEJBTecno.info ("***************************************************************************************************************");
            //logEJBTecno.info ("***************************************************************************************************************");
            //logEJBTecno.info ("************************************* EJECUTANDO crearRegistroReporteCero *************************************");
            fechaSistema = new java.util.Date();
            //logEJBTecno.info ("FECHA DE SISTEMA = " + fechaSistema);
            //id = ejbTecnoReporteCero.buscarMaxId();
            id = getEjbTecnoReporteCero().buscarMaxId();
            radicado = String.valueOf(fechaSistema.getYear()+1900) + "-" +
                       String.valueOf(fechaSistema.getMonth()+1) + "-" +
                       arreglarDia(fechaSistema.getDate()) + "-" + String.valueOf(id+1);
            
            //************************************************************************
            //************************************************************************
            /*
            TecnoReportesCeroPK llavePrimariaReporteCero = new TecnoReportesCeroPK();
            llavePrimariaReporteCero.setRadicadocero(radicado);
            */
            //llavePrimariaReporteCero.setIdregistro(1);
            //registro.setTecnoReportesCeroPK(llavePrimariaReporteCero);
            //************************************************************************
            //************************************************************************
            //************************************************************************
            //************************************************************************
            //************************************************************************
            //************************************************************************
            //registro.setIdregistro(1);
            registro = new TecnoReportesCero();
            registro.setRadicadocero(radicado);
            //registro.setTecnoReportesCeroPK(llavePrimariaReporteCero);
            registro.setFechaActualiza(registroReporteCero.getFecha_actualiza());
            registro.setFechaReporte(registroReporteCero.getFecha_reporte());
            registro.setObservacion(registroReporteCero.getObservacion());
            registro.setTrimestre(registroReporteCero.getTrimestre());
            registro.setUsuarioId(registroReporteCero.getUsuario_id());
            registro.setYearTrimestre(Short.valueOf(registroReporteCero.getYear_trimestre()));
            registro.setNotificacion(registroReporteCero.getNotificacion());
            registro.setDepto(registroReporteCero.getDepto());
            registro.setMunicipio(registroReporteCero.getMunicipio());
            //************************************************************************
            //************************************************************************
            //************************************************************************
            //************************************************************************
            //logEJBTecno.info ("OBJETO PARA ENVIAR A LA BD = " + registro);
            getEjbTecnoReporteCero().create(registro);
            seCreoReporte = true;
            //******************************************************************************************
            //******************************************************************************************
            //******************************************************************************************
            if (seCreoReporte == true)
            {
                registros.add(radicado);
                registros.add(new Boolean(seCreoReporte));
            }
            else
            {
                registros.add("SIN RADICADO ASIGNADO");
                registros.add(new Boolean(false));
            }
            //******************************************************************************************
            //******************************************************************************************
            //******************************************************************************************
            //logEJBTecno.info ("Se creo el registro del reporte con radicado " + radicado + ": " + seCreoReporte);
            //logEJBTecno.info ("***************************************************************************************************************");
            //logEJBTecno.info ("***************************************************************************************************************");
            //logEJBTecno.info ("***************************************************************************************************************");
        }
        
        catch (Exception errorReporteCero)
        {
            //logEJBTecno.info ("Error en el método crearRegistroReporteCero = " + errorReporteCero.getMessage());
            errorReporteCero.printStackTrace();
            registros.add("SIN RADICADO ASIGNADO");
            registros.add(new Boolean(false));
        }
        
        return (registros);
    }
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    private String arreglarDia (int valor)
    {
        String numero = "";
        
        if (valor < 10)
        {
            numero = "0" + String.valueOf(valor);
        }
        else
        {
            numero = String.valueOf(valor);
        }
        
        return (numero);
    }
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    @Override
    public List<TecnoReporteCeroVO> obtenerListadoReportesCeroReportante (String reportante)
    {
        List<TecnoReporteCeroVO> registros = null;
        List<TecnoReportesCero> registrosBD = null;
        int i = 0;
        String usuario = "";
        TecnoReportesCero registroIndividual = null;
        TecnoReporteCeroVO registroInsertar = null;
        
        try
        {
            //logEJBTecno.info ("EJECUTANDO CONSULTA DE REPORTES EN CERO DEL USUARIO = " + reportante);
            registrosBD = getEjbTecnoReporteCero().findAll();
            
            registros = new java.util.ArrayList<TecnoReporteCeroVO>();
            for (i = 0;  i < registrosBD.size();  i++)
            {
               registroIndividual = (TecnoReportesCero)registrosBD.get(i);
               usuario = registroIndividual.getUsuarioId();
               
               if (usuario.equals(reportante))
               {
                    //****************************************************************************
                    //****************************************************************************
                    registroInsertar = new TecnoReporteCeroVO();
                    //****************************************************************************
                    //****************************************************************************
                    registroInsertar.setFecha_actualiza(registroIndividual.getFechaActualiza());
                    registroInsertar.setFecha_reporte(registroIndividual.getFechaReporte());
                    registroInsertar.setObservacion(registroIndividual.getObservacion());
                    registroInsertar.setTrimestre(registroIndividual.getTrimestre());
                    registroInsertar.setUsuario_id(registroIndividual.getUsuarioId());
                    registroInsertar.setYear_trimestre(String.valueOf(registroIndividual.getYearTrimestre()));
                    registroInsertar.setIdregistro(String.valueOf(registroIndividual.getIdregistro()));
                    registroInsertar.setRadicadocero(registroIndividual.getRadicadocero());
                    //****************************************************************************
                    //****************************************************************************
                    registros.add(registroInsertar);
                    //****************************************************************************
                    //****************************************************************************
               }//Fin del if
            }//Fin del for
            
        }//Fin del try
        
        catch (Exception errorLista)
        {
            errorLista.printStackTrace();
            return (null);
        }
        
        return (registros);
    }
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    @Override
    public TecnoReporteCeroVO consultarRegistroReporteCero(String radicado) 
    {
        TecnoReportesCero registro = null;
        TecnoReporteCeroVO reporteSalida = null;
        
        try
        {
            //logEJBTecno.info ("***************************************************************************************************************");
            //logEJBTecno.info ("***************************************************************************************************************");
            //logEJBTecno.info ("***************************************************************************************************************");
            //logEJBTecno.info ("************************************* EJECUTANDO consultarRegistroReporteCero *************************************");
            registro = getEjbTecnoReporteCero().find(radicado);
            reporteSalida = new TecnoReporteCeroVO();
            //***************************************************************************************************
            //***************************************************************************************************
            reporteSalida.setFecha_actualiza(registro.getFechaActualiza());
            reporteSalida.setFecha_reporte(registro.getFechaReporte());
            reporteSalida.setObservacion(registro.getObservacion());
            reporteSalida.setTrimestre(registro.getTrimestre());
            reporteSalida.setUsuario_id(registro.getUsuarioId());
            reporteSalida.setYear_trimestre(String.valueOf(registro.getYearTrimestre()));
            reporteSalida.setIdregistro(String.valueOf(registro.getIdregistro()));
            reporteSalida.setRadicadocero(registro.getRadicadocero());
            //***************************************************************************************************
            //***************************************************************************************************
            //logEJBTecno.info ("***************************************************************************************************************");
            //logEJBTecno.info ("***************************************************************************************************************");
            //logEJBTecno.info ("OBJETO A RETORNAR DE LA LLAVE " + radicado + ": " + reporteSalida);
            //logEJBTecno.info ("***************************************************************************************************************");
            //logEJBTecno.info ("***************************************************************************************************************");
            //logEJBTecno.info ("***************************************************************************************************************");
        }
        
        catch (Exception errorReporteCero)
        {
            //logEJBTecno.info ("Error en el método crearRegistroReporteCero = " + errorReporteCero.getMessage());
            errorReporteCero.printStackTrace();
            return (null);
        }
        
        return (reporteSalida);
    }
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    @Override
    public List<TecnoReporteCeroVO> obtenerListadoReportesCeroPeriodo(Date fechaInicial, Date fechaFinal) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    @Override
    public List<TecnoReporteCeroVO> obtenerListadoReportesCeroTrimestre(int yearReporte, String trimestre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    @Override
    public List<TecnoReporteCeroVO> buscarReportesCero(String usuario, Date fechaInicial, Date fechaFinal, int yearReporte, String trimestreReporte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    @Override
    public TecnoUsuarioInternetVO obtenerDatosETSUsuarioSesion(String username) 
    {
        TecnoUsuarioInternetVO registro = null;
        TecnoUsuariosInternet valor = null;
        TecnoUsuarioInternetVO registroVacio = null;
        
        
        try
        {
            //logEJBTecno.info ("****************************************************************");
            //logEJBTecno.info ("****************************************************************");
            //logEJBTecno.info ("****************************************************************");
            valor = getEjbTecnoUsuariosInternet().buscarPorUsuario(username);
            //logEJBTecno.info ("USUARIO TRAIDO = " + valor);
            registro = new TecnoUsuarioInternetVO();
            registro.setNombreEmpresa(valor.getNombreEmpresa());
            registro.setIdentificacionEmpresa(String.valueOf(valor.getIdentificacionEmpresa()));
            //logEJBTecno.info ("****************************************************************");
            //logEJBTecno.info ("****************************************************************");
            //logEJBTecno.info ("****************************************************************");
        }
        
        catch (Exception errorUsuario)
        {
            errorUsuario.printStackTrace();
            registroVacio = new TecnoUsuarioInternetVO();
            return (registroVacio);
        }
        
        return (registro);
    }
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    @Override
    public List<TecnoRepCeroConsultaVO> generarConsultaReportesMasivosCero(Date fechaInicial, Date fechaFinal, String depto,String municipioSecretaria, String rol) 
    {
        List<TecnoRepCeroConsultaVO> reporteDatos = null;  
        TecnoRepCeroConsultaVO registroIndividual = null;
        String queryReporte = "";
        
        try
        {
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("EJECUTANDO EL MÉTODO EN EL EJB generarConsultaReportesMasivosCero");
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("VALOR = " + getManejadorEntidadesDireccion().getProperties());
            //logEJBTecno.info ("*-********************************************************");
            //logEJBTecno.info ("*-********************************************************");
            //***************************************************************
            //***************************************************************
            if (rol.equals("admin"))
            {
                queryReporte = "consultaReportesEnCeroGeneral";
            }
            else
            {
                queryReporte = "consultaReportesEnCero";
            }
            
            Query query1 = getManejadorEntidadesDireccion().createNamedQuery(queryReporte);
            fechaInicial.setHours(0);
            fechaInicial.setMinutes(0);
            fechaInicial.setSeconds(0);
            fechaFinal.setHours(23);
            fechaFinal.setMinutes(59);
            fechaFinal.setSeconds(59);
            
            query1.setParameter(1,fechaInicial);
            query1.setParameter(2,fechaFinal);
            
            if (!rol.equals("admin"))
            {
                query1.setParameter(3,depto);
            }
            List<Object> cursor = query1.getResultList();
            //***************************************************************
            //***************************************************************
            if (cursor != null)
            {
                reporteDatos = new ArrayList<TecnoRepCeroConsultaVO>();
                //logEJBTecno.info ("TAMAÑO DEL CURSOR = " + cursor.size());
                Iterator iteradorRegistros = cursor.iterator();
                
                while (iteradorRegistros.hasNext())
                {
                    Object[] tupla = (Object[]) iteradorRegistros.next();  
                    registroIndividual = new TecnoRepCeroConsultaVO();
                    registroIndividual.setNumero_radicado(String.valueOf(tupla[0]));
                    registroIndividual.setRazon_social(String.valueOf(tupla[1]));
                    registroIndividual.setNit_empresa(String.valueOf(tupla[2]));
                    registroIndividual.setDepartamento(String.valueOf(tupla[3]));
                    registroIndividual.setMunicipio(String.valueOf(tupla[4]));
                    registroIndividual.setTrimestre_reportado(String.valueOf(tupla[5]));
                    registroIndividual.setYear_trimestre(String.valueOf(tupla[6]));
                    registroIndividual.setTipo_actor(String.valueOf(tupla[7]));
                    registroIndividual.setNotificacion(String.valueOf(tupla[8]));
                    registroIndividual.setFecha_radicado(String.valueOf(tupla[9]));
                    registroIndividual.setObservacion_reportante(String.valueOf(tupla[10]));

                    
                    //BORRANDO REGISTROS SEGUN CONDICIONES DEPARTAMENTO-CIUDAD PRINCIPAL/DISTRITO ESPECIAL
                    if (!rol.equals("admin")) {
                        String codMunicipio = String.valueOf(tupla[11]);

                        if (depto.equals("08") || depto.equals("11") || depto.equals("13") || depto.equals("47") || depto.equals("76")) {

                            if (municipioSecretaria.equals("08001") || municipioSecretaria.equals("11001") || municipioSecretaria.equals("13001")
                                    || municipioSecretaria.equals("47001") || municipioSecretaria.equals("47001")) {
                                //Agregar si el registro es igual a la secretaria
                                if (codMunicipio.equals(municipioSecretaria)) {
                                    reporteDatos.add(registroIndividual);
                                }
                            } else {
                                //Agregar si el registro es diferente a la secretaria
                                if (!codMunicipio.equals("08001") && !codMunicipio.equals("11001") && !codMunicipio.equals("13001") && !codMunicipio.equals("47001") && !codMunicipio.equals("47001") ) {
                                    reporteDatos.add(registroIndividual);
                                }
                            }

                        } else {
                            reporteDatos.add(registroIndividual);
                        }
                    } else {
                        reporteDatos.add(registroIndividual);
                    }
                    
                }
            }
        }
        
        catch (Exception errorGeneracionMUID)
        {
            //logEJBTecno.info ("Error en la generación del método generarConsultaReportesMasivosCero = " + errorGeneracionMUID.getLocalizedMessage());
            errorGeneracionMUID.printStackTrace();
            List<TecnoRepCeroConsultaVO> vacio = new ArrayList<TecnoRepCeroConsultaVO>();
            return (vacio);
        }
        
        finally
        {
            try
            {
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("CERRANDO TRANSACCION DE NATIVE QUERY del método generarConsultaReportesMasivosCero");
                //logEJBTecno.info ("***********************************************");
                //logEJBTecno.info ("***********************************************");
            }
            
            catch (Exception errorSQL)
            {
                //logEJBTecno.info ("Error de sql en el método generarConsultaReportesMasivosCero = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                List<TecnoRepCeroConsultaVO> vaciobd = new ArrayList<TecnoRepCeroConsultaVO>();
                return (vaciobd);
            }
        }
        
        return (reporteDatos);
    }
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    @Override
    public boolean verificarRegistroTrimestreReporteCero(String periodo, String year_reporte, String usuarioIps) 
    {
        boolean yaEsta = false;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";
        String periodoBD = "";
        String yearBD = "";
        String usuarioBD = "";
        
        try
        {
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("EJECUTANDO METODO verificarRegistroTrimestreReporteCero EN EL EJB");
            //logEJBTecno.info ("PERIODO EN EL EJB = " + periodo);
            //logEJBTecno.info ("AÑO DEL REPORTE EN EL EJB = " + year_reporte);
            //logEJBTecno.info ("USUARIO DE IPS REPORTANTE = " + usuarioIps);
            //logEJBTecno.info ("****----------------------------------------------");
            //logEJBTecno.info ("****----------------------------------------------");
            //***************************************************************
            //***************************************************************
            consulta = 
                "select rc.trimestre, rc.year_trimestre, rc.usuario_id " +
                "from dbo.tecno_reportes_cero rc " +
                "where rc.trimestre = ? and rc.year_trimestre = ? and rc.usuario_id = ? ";
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("Consulta del Reporte de Registros de Incidentes = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1,periodo);
            sentencia.setString(2,year_reporte);
            sentencia.setString(3,usuarioIps);
            //***************************************************************
            //***************************************************************
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null)
            {
                while (cursor.next())
                {
                    periodoBD = cursor.getString(1);
                    yearBD = cursor.getString(2);
                    usuarioBD = cursor.getString(3);
                }
            }
            //***************************************************************
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("---------------------------------------------->");
            //logEJBTecno.info ("PERIODO PARAMETRO = " + periodo + " - PERIODO EN LA BASE = " + periodoBD);
            //logEJBTecno.info ("AÑO PARAMETRO = " + year_reporte + " - AÑO EN LA BASE = " + yearBD);
            //logEJBTecno.info ("USUARIO PARAMETRO = " + usuarioIps + " - USUARIO REPORTANTE BASE = " + usuarioBD);
            //***************************************************************
            //***************************************************************
            if (periodo.equals(periodoBD) && year_reporte.equals(yearBD) && usuarioBD.equals(usuarioIps))
            {
                //logEJBTecno.info ("EL PERIODO Y EL AÑO YA ESTÁN REGISTRADOS POR EL USUARIO = " + usuarioBD + ".  ERROR");
                yaEsta = true;
            }
            else
            {
                //logEJBTecno.info ("EL PERIODO Y EL AÑO NO ESTÁN REGISTRADOS.  SE PUEDE ALMACENAR");
                yaEsta = false;
            }
            //***************************************************************
            //***************************************************************
            //logEJBTecno.info ("NO SE PUEDE REGISTRAR = " + yaEsta);
            //logEJBTecno.info ("---------------------------------------------->");
            //***************************************************************
            //***************************************************************
            //***************************************************************
        }
        
        catch (Exception errorGeneracionMUID)
        {
            //logEJBTecno.info ("Error en la generación del MUID = " + errorGeneracionMUID.getLocalizedMessage());
            errorGeneracionMUID.printStackTrace();
            return (true);
        }
        
        finally
        {
            try
            {
                if (cursor != null)
                {
                    cursor.close();
                }

                if (sentencia != null)
                {
                    sentencia.close();
                }

                if (conexion != null)
                {
                    conexion.close();
                }
            }
            
            catch (SQLException errorSQL)
            {
                //logEJBTecno.info ("Error de sql = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                return (true);
            }
        }
        
        return (yaEsta);
    }
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    @Override
    public java.util.ArrayList<String> obtenerDivipolaUsuarioReporteCero(String nombreUsuario) 
    {
        java.util.ArrayList<String> comboDatos = null;
        java.util.ArrayList<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";
        
        try
        {
            //***************************************************************
            //***************************************************************
            consulta = "select cod_depart, cod_mun from dbo.tecno_usuarios_internet where usuario = ? ";
            //logEJBTecno.info ("Consulta del obtenerDivipolaUsuarioReporteCero = " + consulta);
            //logEJBTecno.info ("PARAMETRO DE USUARIO = " + nombreUsuario);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setString(1,nombreUsuario);
            //***************************************************************
            //***************************************************************
            //***************************************************************
            //***************************************************************
            cursor = sentencia.executeQuery();
            //***************************************************************
            //***************************************************************
            if (cursor != null)
            {
                comboDatos = new ArrayList<String>();
                while (cursor.next())
                {
                    //*******************************************
                    //*******************************************
                    comboDatos.add(cursor.getString(1));
                    comboDatos.add(cursor.getString(2));
                    //*******************************************
                    //*******************************************
                }
                
                //logEJBTecno.info ("ID DEPTO DEL USUARIO = " + (String)comboDatos.get(0));
                //logEJBTecno.info ("ID MUNICIPIO DEL USUARIO = " + (String)comboDatos.get(1));
            }
            //***************************************************************
            //***************************************************************
        }
        
        catch (Exception errorobtenerTiposDeSucursal)
        {
            //logEJBTecno.info ("Error en la generación del obtenerDivipolaUsuarioReporteCero = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("11");
            comboDatosVacio.add("11001");
            return (comboDatosVacio);
        }
        
        finally
        {
            try
            {
                if (cursor != null)
                {
                    cursor.close();
                }

                if (sentencia != null)
                {
                    sentencia.close();
                }

                if (conexion != null)
                {
                    conexion.close();
                }
            }
            
            catch (SQLException errorSQL)
            {
                //logEJBTecno.info ("Error de sql de obtenerDivipolaUsuarioReporteCero = " + errorSQL.getLocalizedMessage());
                errorSQL.printStackTrace();
                comboDatosVacio = new ArrayList<String>();
                comboDatosVacio.add("11");
                comboDatosVacio.add("11001");
                return (comboDatosVacio);
            }
        }
        
        return (comboDatos);
    }
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    /**
     * @return the ejbTecnoReporteCero
     */
    public TecnoReportesCeroFacadeLocal getEjbTecnoReporteCero() {
        return ejbTecnoReporteCero;
    }

    /**
     * @param ejbTecnoReporteCero the ejbTecnoReporteCero to set
     */
    public void setEjbTecnoReporteCero(TecnoReportesCeroFacadeLocal ejbTecnoReporteCero) {
        this.ejbTecnoReporteCero = ejbTecnoReporteCero;
    }

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
     * @return the ejbTecnoUsuariosInternet
     */
    public TecnoUsuariosInternetFacadeLocal getEjbTecnoUsuariosInternet() {
        return ejbTecnoUsuariosInternet;
    }

    /**
     * @param ejbTecnoUsuariosInternet the ejbTecnoUsuariosInternet to set
     */
    public void setEjbTecnoUsuariosInternet(TecnoUsuariosInternetFacadeLocal ejbTecnoUsuariosInternet) {
        this.ejbTecnoUsuariosInternet = ejbTecnoUsuariosInternet;
    }
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
}
