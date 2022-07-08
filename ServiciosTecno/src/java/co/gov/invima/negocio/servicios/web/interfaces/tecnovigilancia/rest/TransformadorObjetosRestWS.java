/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.negocio.servicios.web.interfaces.tecnovigilancia.rest;

import co.gov.invima.dto.PersonaInternetVO;
import co.gov.invima.dto.reports.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jgutierrezme
 */
public class TransformadorObjetosRestWS implements Serializable 
{
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    private final static Logger logTransformador = Logger.getLogger(ServicioReportesTecnoVigilanciaREST.class.getName());
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    public JSONObject obtenerJSONArreglo (java.util.ArrayList arregloDatos) throws JSONException, IllegalArgumentException, IllegalAccessException
    {
        JSONObject json = null;
        json = new JSONObject();
        int i = 0;
        for (i = 0;  i < arregloDatos.size();  i+=2)
        {
            json.put((String)arregloDatos.get(i),(String)arregloDatos.get(i+1));
        }
        
        return (json);
    }
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    public JSONObject obtenerJSONPojoPersonaInternetTecnoCargue (PersonaInternetVO registro)
    {
        JSONObject json = null;
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        int j = 0;
        
        try
        {
            c1 = registro.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;

            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(registro);
                    json.put(nombreCampo,String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("DATOS DEL POJO INDIVIDUAL = " + json);
            }
        }
        
        catch (Exception errorEntidad)
        {
            errorEntidad.printStackTrace();
        }
        
        return (json);
    }
    //******************************************************************************************
    //******************************************************************************************
    public JSONArray obtenerArrayJSONPojoPersonaInternetTecnoCargue (List<PersonaInternetVO> entidadesBD) throws JSONException, IllegalArgumentException, IllegalAccessException
    {
        int i = 0, j= 0;
        PersonaInternetVO entidadIndividual = null;
        JSONObject json = null;
        JSONArray array=new JSONArray();
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        //logTransformador.info ("ENTIDADES = " + entidadesBD);
        
        for (i = 0;  i < entidadesBD.size();  i++)
        {
            entidadIndividual = (PersonaInternetVO)entidadesBD.get(i);

            c1 = entidadIndividual.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;
            
            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(entidadIndividual);
                    json.put(nombreCampo.toUpperCase(),String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("ARREGLO = " + json);
            }
            array.put(json);
        }
        
        return (array);
    }
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    public JSONObject obtenerJSONPojoReporteTecno (PojoReporteTecno registro)
    {
        JSONObject json = null;
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        int j = 0;
        
        try
        {
            c1 = registro.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;

            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(registro);
                    json.put(nombreCampo,String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("DATOS DEL POJO INDIVIDUAL = " + json);
            }
        }
        
        catch (Exception errorEntidad)
        {
            errorEntidad.printStackTrace();
        }
        
        return (json);
    }
    //******************************************************************************************
    //******************************************************************************************
    public JSONArray obtenerArrayJSONPojoReporteTecno (List<PojoReporteTecno> entidadesBD) throws JSONException, IllegalArgumentException, IllegalAccessException
    {
        int i = 0, j= 0;
        PojoReporteTecno entidadIndividual = null;
        JSONObject json = null;
        JSONArray array=new JSONArray();
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        logTransformador.info ("ENTIDADES = " + entidadesBD);
        
        for (i = 0;  i < entidadesBD.size();  i++)
        {
            entidadIndividual = (PojoReporteTecno)entidadesBD.get(i);

            c1 = entidadIndividual.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;
            
            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(entidadIndividual);
                    json.put(nombreCampo.toUpperCase(),String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("ARREGLO = " + json);
            }
            array.put(json);
        }
        
        return (array);
    }
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    public JSONObject obtenerJSONPojoDatosReporte (PojoDatosReporte registro)
    {
        JSONObject json = null;
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        int j = 0;
        
        try
        {
            c1 = registro.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;

            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(registro);
                    json.put(nombreCampo,String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("DATOS DEL POJO INDIVIDUAL = " + json);
            }
        }
        
        catch (Exception errorEntidad)
        {
            errorEntidad.printStackTrace();
        }
        
        return (json);
    }
    //******************************************************************************************
    //******************************************************************************************
    public JSONArray obtenerArrayJSONPojoDatosReporte (List<PojoDatosReporte> entidadesBD) throws JSONException, IllegalArgumentException, IllegalAccessException
    {
        int i = 0, j= 0;
        PojoDatosReporte entidadIndividual = null;
        JSONObject json = null;
        JSONArray array=new JSONArray();
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        logTransformador.info ("ENTIDADES = " + entidadesBD);
        
        for (i = 0;  i < entidadesBD.size();  i++)
        {
            entidadIndividual = (PojoDatosReporte)entidadesBD.get(i);

            c1 = entidadIndividual.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;
            
            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(entidadIndividual);
                    json.put(nombreCampo.toUpperCase(),String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("ARREGLO = " + json);
            }
            array.put(json);
        }
        
        return (array);
    }
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    public JSONObject obtenerJSONPojoReporteDispoExpedientes (PojoReporteDispoExpedientes registro)
    {
        JSONObject json = null;
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        int j = 0;
        
        try
        {
            c1 = registro.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;

            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(registro);
                    json.put(nombreCampo,String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("DATOS DEL POJO INDIVIDUAL = " + json);
            }
        }
        
        catch (Exception errorEntidad)
        {
            errorEntidad.printStackTrace();
        }
        
        return (json);
    }
    //******************************************************************************************
    //******************************************************************************************
    public JSONArray obtenerArrayJSONPojoReporteDispoExpedientes (List<PojoReporteDispoExpedientes> entidadesBD) throws JSONException, IllegalArgumentException, IllegalAccessException
    {
        int i = 0, j= 0;
        PojoReporteDispoExpedientes entidadIndividual = null;
        JSONObject json = null;
        JSONArray array=new JSONArray();
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        logTransformador.info ("ENTIDADES = " + entidadesBD);
        
        for (i = 0;  i < entidadesBD.size();  i++)
        {
            entidadIndividual = (PojoReporteDispoExpedientes)entidadesBD.get(i);

            c1 = entidadIndividual.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;
            
            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(entidadIndividual);
                    json.put(nombreCampo.toUpperCase(),String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("ARREGLO = " + json);
            }
            array.put(json);
        }
        
        return (array);
    }
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    public JSONObject obtenerJSONPojoReporteInscripcionRed (PojoReporteInscripcionRed registro)
    {
        JSONObject json = null;
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        int j = 0;
        
        try
        {
            c1 = registro.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;

            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(registro);
                    json.put(nombreCampo,String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("DATOS DEL POJO INDIVIDUAL = " + json);
            }
        }
        
        catch (Exception errorEntidad)
        {
            errorEntidad.printStackTrace();
        }
        
        return (json);
    }
    //******************************************************************************************
    //******************************************************************************************
    public JSONArray obtenerArrayJSONPojoReporteInscripcionRed (List<PojoReporteInscripcionRed> entidadesBD) throws JSONException, IllegalArgumentException, IllegalAccessException
    {
        int i = 0, j= 0;
        PojoReporteInscripcionRed entidadIndividual = null;
        JSONObject json = null;
        JSONArray array=new JSONArray();
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        logTransformador.info ("ENTIDADES = " + entidadesBD);
        
        for (i = 0;  i < entidadesBD.size();  i++)
        {
            entidadIndividual = (PojoReporteInscripcionRed)entidadesBD.get(i);

            c1 = entidadIndividual.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;
            
            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(entidadIndividual);
                    json.put(nombreCampo.toUpperCase(),String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("ARREGLO = " + json);
            }
            array.put(json);
        }
        
        return (array);
    }
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    public JSONObject obtenerJSONPojoReporteMonitoreo (PojoReporteMonitoreo registro)
    {
        JSONObject json = null;
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        int j = 0;
        
        try
        {
            c1 = registro.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;

            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(registro);
                    json.put(nombreCampo,String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("DATOS DEL POJO INDIVIDUAL = " + json);
            }
        }
        
        catch (Exception errorEntidad)
        {
            errorEntidad.printStackTrace();
        }
        
        return (json);
    }
    //******************************************************************************************
    //******************************************************************************************
    public JSONArray obtenerArrayJSONPojoReporteMonitoreo (List<PojoReporteMonitoreo> entidadesBD) throws JSONException, IllegalArgumentException, IllegalAccessException
    {
        int i = 0, j= 0;
        PojoReporteMonitoreo entidadIndividual = null;
        JSONObject json = null;
        JSONArray array=new JSONArray();
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        logTransformador.info ("ENTIDADES = " + entidadesBD);
        
        for (i = 0;  i < entidadesBD.size();  i++)
        {
            entidadIndividual = (PojoReporteMonitoreo)entidadesBD.get(i);

            c1 = entidadIndividual.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;
            
            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(entidadIndividual);
                    json.put(nombreCampo.toUpperCase(),String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("ARREGLO = " + json);
            }
            array.put(json);
        }
        
        return (array);
    }
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    public JSONObject obtenerJSONPojoReporteConsecutivos (PojoReporteConsecutivos registro)
    {
        JSONObject json = null;
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        int j = 0;
        
        try
        {
            c1 = registro.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;

            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(registro);
                    json.put(nombreCampo,String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("DATOS DEL POJO INDIVIDUAL = " + json);
            }
        }
        
        catch (Exception errorEntidad)
        {
            errorEntidad.printStackTrace();
        }
        
        return (json);
    }
    //******************************************************************************************
    //******************************************************************************************
    public JSONArray obtenerArrayJSONPojoReporteConsecutivos (List<PojoReporteConsecutivos> entidadesBD) throws JSONException, IllegalArgumentException, IllegalAccessException
    {
        int i = 0, j= 0;
        PojoReporteConsecutivos entidadIndividual = null;
        JSONObject json = null;
        JSONArray array=new JSONArray();
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        logTransformador.info ("ENTIDADES = " + entidadesBD);
        
        for (i = 0;  i < entidadesBD.size();  i++)
        {
            entidadIndividual = (PojoReporteConsecutivos)entidadesBD.get(i);

            c1 = entidadIndividual.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;
            
            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(entidadIndividual);
                    json.put(nombreCampo.toUpperCase(),String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("ARREGLO = " + json);
            }
            array.put(json);
        }
        
        return (array);
    }
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    public JSONObject obtenerJSONPojoReporteUsuarios (PojoReporteUsuarios registro)
    {
        JSONObject json = null;
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        int j = 0;
        
        try
        {
            c1 = registro.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;

            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(registro);
                    json.put(nombreCampo,String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("DATOS DEL POJO INDIVIDUAL = " + json);
            }
        }
        
        catch (Exception errorEntidad)
        {
            errorEntidad.printStackTrace();
        }
        
        return (json);
    }
    //******************************************************************************************
    //******************************************************************************************
    public JSONArray obtenerArrayJSONPojoReporteUsuarios (List<PojoReporteUsuarios> entidadesBD) throws JSONException, IllegalArgumentException, IllegalAccessException
    {
        int i = 0, j= 0;
        PojoReporteUsuarios entidadIndividual = null;
        JSONObject json = null;
        JSONArray array=new JSONArray();
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        logTransformador.info ("ENTIDADES = " + entidadesBD);
        
        for (i = 0;  i < entidadesBD.size();  i++)
        {
            entidadIndividual = (PojoReporteUsuarios)entidadesBD.get(i);

            c1 = entidadIndividual.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;
            
            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(entidadIndividual);
                    json.put(nombreCampo.toUpperCase(),String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("ARREGLO = " + json);
            }
            array.put(json);
        }
        
        return (array);
    }
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    public JSONObject obtenerJSONPojoReporteUsuariosInternet (PojoReportesUsuariosInternet registro)
    {
        JSONObject json = null;
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        int j = 0;
        
        try
        {
            c1 = registro.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;

            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(registro);
                    json.put(nombreCampo,String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("DATOS DEL POJO INDIVIDUAL = " + json);
            }
        }
        
        catch (Exception errorEntidad)
        {
            errorEntidad.printStackTrace();
        }
        
        return (json);
    }
    //******************************************************************************************
    //******************************************************************************************
    public JSONArray obtenerArrayJSONPojoReporteUsuariosInternet (List<PojoReportesUsuariosInternet> entidadesBD) throws JSONException, IllegalArgumentException, IllegalAccessException
    {
        int i = 0, j= 0;
        PojoReportesUsuariosInternet entidadIndividual = null;
        JSONObject json = null;
        JSONArray array=new JSONArray();
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        logTransformador.info ("ENTIDADES = " + entidadesBD);
        
        for (i = 0;  i < entidadesBD.size();  i++)
        {
            entidadIndividual = (PojoReportesUsuariosInternet)entidadesBD.get(i);

            c1 = entidadIndividual.getClass();
            //logTransformador.info("Class name got is:: " + c1.getNam
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;
            
            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(entidadIndividual);
                    json.put(nombreCampo.toUpperCase(),String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("ARREGLO = " + json);
            }
            array.put(json);
        }
        
        return (array);
    }
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    public JSONObject obtenerJSONPojoPersonaInternetTecno (PersonaInternetVO registro)
    {
        JSONObject json = null;
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        int j = 0;
        
        try
        {
            c1 = registro.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;

            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(registro);
                    json.put(nombreCampo,String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("DATOS DEL POJO INDIVIDUAL = " + json);
            }
        }
        
        catch (Exception errorEntidad)
        {
            errorEntidad.printStackTrace();
        }
        
        return (json);
    }
    //******************************************************************************************
    //******************************************************************************************
    public JSONArray obtenerArrayJSONPojoPersonaInternetTecno (List<PersonaInternetVO> entidadesBD) throws JSONException, IllegalArgumentException, IllegalAccessException
    {
        int i = 0, j= 0;
        PersonaInternetVO entidadIndividual = null;
        JSONObject json = null;
        JSONArray array=new JSONArray();
        Class c1 = null;
        Field[] fieldlist = null;
        Object valorCampo = null;
        String nombreCampo = "";
        logTransformador.info ("ENTIDADES = " + entidadesBD);
        
        for (i = 0;  i < entidadesBD.size();  i++)
        {
            entidadIndividual = (PersonaInternetVO)entidadesBD.get(i);

            c1 = entidadIndividual.getClass();
            //logTransformador.info("Class name got is:: " + c1.getName());
            fieldlist = c1.getDeclaredFields();
            valorCampo = null;
            
            json = new JSONObject();            
            for (j = 0;  j < fieldlist.length;  j++)
            {
                nombreCampo = fieldlist[j].getName();
                //logTransformador.info ("Campo actual = " + nombreCampo);
                /*
                if (!nombreCampo.equals("serialVersionUID") && 
                    !nombreCampo.startsWith("_") && 
                    (nombreCampo.indexOf("List")) == -1)
                {
                */
                    fieldlist[j].setAccessible(true);
                    //Type tipoDato = fieldlist[j].getType();
                    //logTransformador.info ("TIPO DE DATO DEL CAMPO ACTUAL = " + tipoDato);
                    //logTransformador.info ("DATO = " +fieldlist[j].get(entidadIndividual));
                    valorCampo = (Object)fieldlist[j].get(entidadIndividual);
                    json.put(nombreCampo.toUpperCase(),String.valueOf(valorCampo));
                    //logTransformador.info ("<<<<< atributo = " + nombreCampo + " y su valor = " + valorCampo);
                //}
                
                //logTransformador.info ("ARREGLO = " + json);
            }
            array.put(json);
        }
        
        return (array);
    }
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
    //******************************************************************************************
}
