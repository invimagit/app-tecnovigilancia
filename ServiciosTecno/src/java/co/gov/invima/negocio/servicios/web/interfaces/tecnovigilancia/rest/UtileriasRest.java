/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.negocio.servicios.web.interfaces.tecnovigilancia.rest;
import org.apache.log4j.Logger;

/**
 *
 * @author jgutierrezme
 */
public class UtileriasRest 
{
    private final Logger log = Logger.getLogger(TransformadorObjetosRestWS.class);
    
    //*********************************************************
    //*********************************************************
    //*********************************************************
    //*********************************************************
    //*********************************************************
    //*********************************************************
    //*********************************************************
    public String decodificarDato (String cadenaEnviada)
    {
        return (cadenaEnviada.replace("%22","\""));
    }
    //*********************************************************
    //*********************************************************
    //*********************************************************
    public java.util.Date obtenerFechaFormato (String fechaCadena)
    {
        int year = 0;
        int mes = 0;
        int dia = 0;
        int hora = 0;
        int minuto = 0;
        int segundo = 0;
        
        for (int i  = 0;  i < fechaCadena.length();  i++)
        {
            log.info (fechaCadena.charAt(i) + " posicion = " + i);
        }
        
        //Mon May 02 16-04-08 COT 2016
        log.info ("Fecha cadena = " + fechaCadena);
        year = Integer.parseInt(fechaCadena.substring((24),(28)));
        mes = obtenerNumeroMes(fechaCadena.substring((4),(7)));
        dia = Integer.parseInt(fechaCadena.substring((8),(10)));
        
        hora = Integer.parseInt(fechaCadena.substring((11),(13)));
        minuto = Integer.parseInt(fechaCadena.substring((14),(16)));
        segundo = Integer.parseInt(fechaCadena.substring((17),(19)));
        
        log.info ("year = " + year);
        log.info ("mes = " + mes);
        log.info ("dia = " + dia);
        log.info ("hora = " + hora);
        log.info ("minuto = " + minuto);
        log.info ("segundo = " + segundo);
        
        
        java.util.Date fechaConstruir = new java.util.Date(year-1900,mes,dia,hora,minuto,segundo);
        
        return (fechaConstruir);
    }
    //*********************************************************
    //*********************************************************
    //*********************************************************
    public int obtenerNumeroMes (String nombre)
    {
        int mes = 0;
        
            if (nombre.equals("Jan"))
                mes = 0;
            else
            if (nombre.equals("Feb"))
                mes = 1;
            else
            if (nombre.equals("Mar"))
                mes = 2;
            else
            if (nombre.equals("Apr"))
                mes = 3;
            else
            if (nombre.equals("May"))
                mes = 4;
            else
            if (nombre.equals("Jun"))
                mes = 5;
            else
            if (nombre.equals("Jul"))
                mes = 6;
            else
            if (nombre.equals("Aug"))
                mes = 7;
            else
            if (nombre.equals("Sep"))
                mes = 8;
            else
            if (nombre.equals("Oct"))
                mes = 9;
            else
            if (nombre.equals("Nov"))
                mes = 10;
            else
                mes = 11;
            
        
        return (mes);
        
    }
    //*********************************************************
    //*********************************************************
    //*********************************************************
    public String obtenerDatoArreglado (String valor)
    {
        String normalizado = "";
        //log.info ("DATO = " + valor);
        normalizado = valor.substring(valor.indexOf('"')+1,valor.lastIndexOf('"'));
        return (normalizado);
    }
    //*********************************************************
    //*********************************************************
    //*********************************************************
    //*********************************************************
    //*********************************************************
    //*********************************************************
}
