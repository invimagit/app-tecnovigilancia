/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.presentacion.utilerias;

import co.gov.invima.negocio.ConsultasTecnoRemote;
import co.gov.invima.negocio.ReporteRemote;
import co.gov.invima.negocio.ServicioUsuariosRemote;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Diana Silva
 */
public class ServiceLocator 
{
    //*********************************************************************************
    //*********************************************************************************
    //*********************************************************************************
    private Context contexto;
    private Properties props = new Properties();
    //*********************************************************************************
    //*********************************************************************************
    //*********************************************************************************
    public ServiceLocator()
    {
//        PropertiesReader pr = new PropertiesReader("co.gov.invima.util.recursos");
//        String maquina = pr.getProperty("maquina");
//        props.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
//        props.put(Context.PROVIDER_URL, maquina);
        try {
            contexto = new InitialContext();

        } catch (NamingException ex) {
            Logger.getLogger(ServiceLocator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //*********************************************************************************
    //*********************************************************************************
    //*********************************************************************************
    public ServicioUsuariosRemote getEjbRemoto()
    {
        ServicioUsuariosRemote remoto =null;
        PropertiesReader pr = new PropertiesReader("co.gov.invima.presentacion.utilerias.recursos");
        String ServicioUsuariosTecnoEJB = pr.getProperty("ServicioUsuariosTecnoEJB");
        System.out.println ("***************************************************************");
        System.out.println ("***************************************************************");
        System.out.println ("EJB REMOTO = " + ServicioUsuariosTecnoEJB);
        System.out.println ("***************************************************************");
        System.out.println ("***************************************************************");
        try {
            remoto = (ServicioUsuariosRemote) contexto.lookup("java:global/" +ServicioUsuariosTecnoEJB);
        } catch (NamingException ex) {
            Logger.getLogger(ServiceLocator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return remoto;
    }
    //*********************************************************************************
    //*********************************************************************************
    //*********************************************************************************
    //*********************************************************************************
    //*********************************************************************************
    public ConsultasTecnoRemote getEjbRemotoReportes()
    {
        ConsultasTecnoRemote remoto =null;
        PropertiesReader pr = new PropertiesReader("co.gov.invima.presentacion.utilerias.recursos");
        String servicioReportesTecnoEJB = pr.getProperty("ServicioReportesTecnoEJB");
        System.out.println ("***************************************************************");
        System.out.println ("***************************************************************");
        System.out.println ("EJB REMOTO = " + servicioReportesTecnoEJB);
        System.out.println ("***************************************************************");
        System.out.println ("***************************************************************");
        try {
            remoto = (ConsultasTecnoRemote) contexto.lookup("java:global/" +servicioReportesTecnoEJB);
        } catch (NamingException ex) {
            Logger.getLogger(ServiceLocator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return remoto;
    }
    //*********************************************************************************
    //*********************************************************************************
    //*********************************************************************************
    //*********************************************************************************
    //*********************************************************************************
    //*********************************************************************************
}
