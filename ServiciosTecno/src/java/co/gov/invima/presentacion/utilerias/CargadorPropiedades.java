/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.presentacion.utilerias;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
/**
 *
 * @author jgutierrezme
 */
public class CargadorPropiedades 
{
      private final Logger logBean = Logger.getLogger(CargadorPropiedades.class);
      //***********************************************************
      //***********************************************************
      //***********************************************************
      private String rutaArchivos;
      //***********************************************************
      //***********************************************************
      public String obtenerRutaArchivos()
      {
          Properties p = null;
          String pathJboss = "";
          String rutaCompleta = "";
          
          try
          {
        	  //****************************************************************************
        	  //****************************************************************************
        	  pathJboss = System.getProperty("jboss.server.base.dir");
        	  System.out.println("JBoss Home: " + pathJboss);
        	  rutaCompleta = pathJboss + "/deployments/propiedadesTecnoVigilancia.properties";
        	  System.out.println("Ruta completa del Properties: " + rutaCompleta);
        	  //****************************************************************************
        	  //****************************************************************************
              p = new Properties();
              p.load(new FileInputStream(new File(rutaCompleta)));
              this.rutaArchivos = p.getProperty("rutaWebServiceToken");
              logBean.info ("Ruta para el archivo de reportes = " + this.rutaArchivos);
        	  //****************************************************************************
        	  //****************************************************************************
          }
          
          catch (Exception errorLectura)
          {
              logBean.info ("Error de carga = "  + errorLectura.getMessage());
              errorLectura.printStackTrace();
          }
          
          return (rutaArchivos);
      }
      //***********************************************************
      //***********************************************************
      //***********************************************************

    /**
     * @return the rutaArchivos
     */
    public String getRutaArchivos() {
        return rutaArchivos;
    }

    /**
     * @param rutaArchivos the rutaArchivos to set
     */
    public void setRutaArchivos(String rutaArchivos) {
        this.rutaArchivos = rutaArchivos;
    }
    
}
