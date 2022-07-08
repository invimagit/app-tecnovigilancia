/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.negocio.servicios.web.interfaces.tecnovigilancia.rest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Set;
import java.util.logging.Logger;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author JGutierrez
 */
@ApplicationPath("webresources")
public class ApplicationConfig extends Application 
{
    private final static Logger log = Logger.getLogger(ApplicationConfig.class.getName());
    //*********************************************************************
    //*********************************************************************
    public ApplicationConfig()
    {
        log.info ("*****************************************************************");
        log.info ("*****************************************************************");
        log.info ("Iniciando constructor de la configuración de Servicios REST: " + this.getClass().getCanonicalName());
        log.info ("*****************************************************************");
        log.info ("*****************************************************************");
    }
    //*********************************************************************
    //*********************************************************************
    //*********************************************************************
    @Override
    public Set<Class<?>> getClasses() 
    {
        Set resources = new java.util.HashSet();
        addRestResourceClasses(resources);
        return resources;
    }
    //*********************************************************************
    //*********************************************************************
    //*********************************************************************
    private void addRestResourceClasses(Set<Class<?>> resources) 
    {
        resources.add (co.gov.invima.negocio.servicios.web.interfaces.tecnovigilancia.rest.ServicioCargueTecnoREST.class);
        resources.add(co.gov.invima.negocio.servicios.web.interfaces.tecnovigilancia.rest.ServicioReportesTecnoVigilanciaREST.class);
    }    
    //*********************************************************************
    //*********************************************************************
    //*********************************************************************
} 

