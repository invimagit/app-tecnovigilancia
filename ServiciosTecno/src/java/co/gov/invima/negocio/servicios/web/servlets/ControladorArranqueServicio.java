/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.negocio.servicios.web.servlets;

import co.gov.invima.presentacion.utilerias.CargadorPropiedades;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import org.apache.log4j.Logger;
/*****************************************************************************/
/*****************************************************************************/
/*****************************************************************************/
/*****************************************************************************/
/*****************************************************************************/
/*****************************************************************************/
/**
 *
 * @author JGutierrez
 */
public class ControladorArranqueServicio implements ServletContextListener {

    private final Logger log = Logger.getLogger(ControladorArranqueServicio.class);

    //****************************************************************
    //****************************************************************
    //****************************************************************
    public ControladorArranqueServicio() {
        log.info("**********************************************");
        log.info("**********************************************");
        log.info("INICIANDO CONSTRUCTOR DE LA CLASE DEL LISTENER " + this.getClass().getCanonicalName());
        log.info("**********************************************");
        log.info("**********************************************");
    }

    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        HashMap<String, String> mapaPropiedades = new HashMap<String, String>();
        String rutaWS = "";
        CargadorPropiedades cargadorPropiedades = null;

        try {
            System.out.println("((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))");
            System.out.println("((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))");
            System.out.println("((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))");
            ServletContext ctx = sce.getServletContext();
            System.out.println("CONTEXTO DEL SERVLET CONTEXT = " + ctx);
            //*********************************************************
            //*********************************************************
            cargadorPropiedades = new CargadorPropiedades();
            log.info("**********************************************");
            log.info("**********************************************");
            log.info("Arrancando contexto de la aplicación para cargue de Propiedades de la clase " + this.getClass().getCanonicalName());
            rutaWS = cargadorPropiedades.obtenerRutaArchivos();
            log.info("Ruta del Ws = " + rutaWS);
            log.info("Mapa de propiedades: " + mapaPropiedades);
            mapaPropiedades.put("servicioToken", rutaWS);
            System.out.println("((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))");
            System.out.println("((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))");
            log.info("SETEANDO EN LA SESIÓN EL MAPA DE PROPIEDADES " + mapaPropiedades);
            ctx.setAttribute("mapaPropiedades", mapaPropiedades);
            System.out.println("((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))");
            System.out.println("((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))");
            System.out.println("((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))");
        } 
        
        catch (Exception error) 
        {
            error.printStackTrace();
        }
    }

    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        FacesContext context = null;

        try {
            //********************************************************************************
            //********************************************************************************
            context = FacesContext.getCurrentInstance();
            log.info("CONTEXTO ACTUAL DEL WEBAPP DEL SERVICIO = " + context);
            //********************************************************************************
            //********************************************************************************
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
    //****************************************************************
}
/*****************************************************************************/
/*****************************************************************************/
/*****************************************************************************/
/*****************************************************************************/
/*****************************************************************************/
/*****************************************************************************/
