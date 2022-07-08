/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javax.sql.DataSource;

/**
 *
 * @author jgutierrezme
 */
@Stateless
public class MaestrosTecnoBean implements MaestrosTecnoRemote 
{
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    private static Logger logEJBTecno = Logger.getLogger(MaestrosTecnoBean.class.getName());
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
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @Override
    public List<String> obtenerListadoRolesUsuario() 
    {
        List<String> comboDatos = null;
        List<String> comboDatosVacio = null;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        String consulta = "";
        
        try
        {
            //***************************************************************
            //***************************************************************
            consulta = "SELECT IDROL, nombre_rol from  dbo.tecno_roles WHERE idrol >= 2 ORDER BY IDROL ASC ";
            //logEJBTecno.info ("Consulta del obtenerListadoRolesUsuario = " + consulta);
            conexion = obtenerConexionDataSource();
            sentencia = conexion.prepareStatement(consulta);
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
            }
            //***************************************************************
            //***************************************************************
        }
        
        catch (Exception errorobtenerTiposDeSucursal)
        {
            //logEJBTecno.info ("Error en la generación del errorobtenerTiposDeSucursal = " + errorobtenerTiposDeSucursal.getLocalizedMessage());
            errorobtenerTiposDeSucursal.printStackTrace();
            comboDatosVacio = new ArrayList<String>();
            comboDatosVacio.add("0");
            comboDatosVacio.add("SIN VALOR");
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
                //logEJBTecno.info ("Error de sql = " + errorSQL.getLocalizedMessage());
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
    //************************************************************************************************
    //************************************************************************************************
    /**
     * @return the logEJBTecno
     */
    public static Logger getlog() {
        return logEJBTecno;
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    /**
     * @param alog the logEJBTecno to set
     */
    public static void setlog(Logger alog) {
        logEJBTecno = alog;
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    /**
     * @return the manejadorEntidadesDireccion
     */
    public EntityManager getManejadorEntidadesDireccion() {
        return manejadorEntidadesDireccion;
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    /**
     * @param manejadorEntidadesDireccion the manejadorEntidadesDireccion to set
     */
    public void setManejadorEntidadesDireccion(EntityManager manejadorEntidadesDireccion) {
        this.manejadorEntidadesDireccion = manejadorEntidadesDireccion;
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    /**
     * @return the contextoBean
     */
    public EJBContext getContextoBean() {
        return contextoBean;
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    /**
     * @param contextoBean the contextoBean to set
     */
    public void setContextoBean(EJBContext contextoBean) {
        this.contextoBean = contextoBean;
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    //***************************************************************
    //***************************************************************
    //***************************************************************
    //***************************************************************
    //***************************************************************
    //***************************************************************
}
