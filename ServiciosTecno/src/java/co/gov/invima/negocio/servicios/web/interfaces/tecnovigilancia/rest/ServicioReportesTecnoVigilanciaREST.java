/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.negocio.servicios.web.interfaces.tecnovigilancia.rest;

/**
 *
 * @author jgutierrezme
 */

import co.gov.invima.dto.reports.*;
import co.gov.invima.negocio.ConsultasTecnoRemote;
import co.gov.invima.presentacion.utilerias.ServiceLocator;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jgutierrezme
 */
//@Controller
/*
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
*/
@Path("servicioresttecnovig")
@Produces({MediaType.APPLICATION_JSON })
@Consumes({MediaType.APPLICATION_JSON })
public class ServicioReportesTecnoVigilanciaREST 
{
    private final static Logger log = Logger.getLogger(ServicioReportesTecnoVigilanciaREST.class.getName());
    /*****************************************************************/
    /*****************************************************************/
    /*****************************************************************/
    private ConsultasTecnoRemote servicioReportesTecnoEjb;
    /*****************************************************************/
    /*****************************************************************/
    /*****************************************************************/
    private TransformadorObjetosRestWS transformadorObjetos;
    /*****************************************************************/
    /*****************************************************************/
    private String direccionIp;
    /*****************************************************************/
    /*****************************************************************/
    public ServicioReportesTecnoVigilanciaREST()
    {
        //ManejoContexto manejadorContexto = new ManejoContexto();
        log.info("**************************************************");
        log.info("**************************************************");
        log.info("Conectandose al contexto");
        ServiceLocator service = new ServiceLocator();
        servicioReportesTecnoEjb = service.getEjbRemotoReportes();
        log.info("Estado del WS REST REPORTE TECNO de Catalogos: " + this.servicioReportesTecnoEjb);
        log.info("**************************************************");
        log.info("**************************************************");
    }
    /*****************************************************************/
    /**
     * @param fechaInicial*
     * @param fechaFinal*
     * @param req*
     * @return ************************************************************/
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @GET
    @Path("/listarReportesCargados")
    public Response listarReportesCargados (@QueryParam("fechaInicial") RESTDateParam fechaInicial, 
    @QueryParam("fechaFinal") RESTDateParam fechaFinal, @Context HttpServletRequest req) throws JSONException
    {
        List<PojoReporteTecno> registros = null;
    	Response respuestaServicio = null;
        JSONObject json = new JSONObject();
        JSONArray array=new JSONArray();
        boolean seListaron = false;
        
        try
        {
            /*
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateObj = sdf.parse(date);            
            */
            
            this.direccionIp = req.getRemoteHost();
            log.info ("DIRECCION DEL HOST EN WS REST = " + this.direccionIp);
            //******************************************************
            //******************************************************
            //******************************************************
            transformadorObjetos = new TransformadorObjetosRestWS();
            registros = new ArrayList<PojoReporteTecno>();
            //******************************************************
            //******************************************************
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("Trayendo colección de entidades del WS REST entre la fecha " + fechaInicial + " y la fecha final " + fechaFinal);
            registros = servicioReportesTecnoEjb.listarReportesCargados(fechaInicial.getDate(),fechaFinal.getDate());
            //******************************************************
            //******************************************************
            if (registros != null)
            {
                log.info ("Registros a retornar desde el EJB = " + registros);
                log.info ("Longitud del arreglo de pojos a retornar = " + registros.size());
                array = transformadorObjetos.obtenerArrayJSONPojoReporteTecno(registros);
                respuestaServicio = Response.status(200).entity(array.toString()).
                header("Access-Control-Allow-Origin", "*").
                header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
                header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
                log.info  ("entidades retornados por el EJB: " + registros);
                log.info  ("Respuesta de listarTodosRegistrosAtcTopN: " + respuestaServicio);
                seListaron = true;
            }
            else
            {
                seListaron = false;
            }
            //******************************************************
            //******************************************************
            /*
            servicioAuditoriaSistema.insertarRegistroAuditoria
            ("listado límite","Listar todos los registros con límite de ATC - Servicio Web REST",
            new java.util.Date(),"usuario","Aplicacion",obtenerResultado(seListaron),
            "AtcLeaf (ATC)","Se listaron los registros de la tabla AtcLeaf (ATC) con un valor límite","Servicio Web REST",this.direccionIp,null,null);
            */  
            //******************************************************
            //******************************************************
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("********************************************************");
            //******************************************************
            //******************************************************
            //******************************************************
        }
        
        catch (Exception errorlistarTodosRegistrosAtcTopN)
        {
            log.info ("Control de Error --> *******************************************************************");
            log.info ("****************************************************************************************");
            log.info ("****************************************************************************************");
            JSONObject jsonVacio = new JSONObject();
            PojoReporteTecno registroConsultar = generarRegistroVacio();
            jsonVacio = transformadorObjetos.obtenerJSONPojoReporteTecno(registroConsultar);
            array.put(jsonVacio);
            respuestaServicio = Response.status(200).entity(array.toString()).
            header("Access-Control-Allow-Origin", "*").
            header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
            header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
            log.info ("Error en el método buscarRegistrosAtc WS REST: " + errorlistarTodosRegistrosAtcTopN.getMessage());
            errorlistarTodosRegistrosAtcTopN.printStackTrace();
            log.info ("****************************************************************************************");
            log.info ("****************************************************************************************");
            List<PojoReporteTecno> registrosVacios = new ArrayList<PojoReporteTecno>();
            return (respuestaServicio);
        }
        
        return (respuestaServicio);
    }
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @GET
    @Path("/generarReporteReportesCargados")
    public Response generarReporteReportesCargados (@QueryParam("fechaInicial") RESTDateParam fechaInicial,
    @QueryParam("fechaFinal") RESTDateParam fechaFinal, @Context HttpServletRequest req) throws JSONException
    {
        List<PojoDatosReporte> registros = null;
    	Response respuestaServicio = null;
        JSONObject json = new JSONObject();
        JSONArray array=new JSONArray();
        boolean seListaron = false;
        
        try
        {
            /*
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateObj = sdf.parse(date);            
            */
            
            this.direccionIp = req.getRemoteHost();
            log.info ("DIRECCION DEL HOST EN WS REST = " + this.direccionIp);
            //******************************************************
            //******************************************************
            //******************************************************
            transformadorObjetos = new TransformadorObjetosRestWS();
            registros = new ArrayList<PojoDatosReporte>();
            //******************************************************
            //******************************************************
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("Trayendo colección de entidades del WS REST entre la fecha " + fechaInicial + " y la fecha final " + fechaFinal);
            registros = servicioReportesTecnoEjb.generarReporteReportesCargados(fechaInicial.getDate(),fechaFinal.getDate(),"");
            //******************************************************
            //******************************************************
            if (registros != null)
            {
                log.info ("Registros a retornar desde el EJB = " + registros);
                log.info ("Longitud del arreglo de pojos a retornar = " + registros.size());
                array = transformadorObjetos.obtenerArrayJSONPojoDatosReporte(registros);
                respuestaServicio = Response.status(200).entity(array.toString()).
                header("Access-Control-Allow-Origin", "*").
                header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
                header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
                log.info  ("entidades retornados por el EJB: " + registros);
                log.info  ("Respuesta de listarTodosRegistrosAtcTopN: " + respuestaServicio);
                seListaron = true;
            }
            else
            {
                seListaron = false;
            }
            //******************************************************
            //******************************************************
            /*
            servicioAuditoriaSistema.insertarRegistroAuditoria
            ("listado límite","Listar todos los registros con límite de ATC - Servicio Web REST",
            new java.util.Date(),"usuario","Aplicacion",obtenerResultado(seListaron),
            "AtcLeaf (ATC)","Se listaron los registros de la tabla AtcLeaf (ATC) con un valor límite","Servicio Web REST",this.direccionIp,null,null);
            */  
            //******************************************************
            //******************************************************
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("********************************************************");
            //******************************************************
            //******************************************************
            //******************************************************
        }
        
        catch (Exception errorlistarTodosRegistrosAtcTopN)
        {
            log.info ("Control de Error --> *******************************************************************");
            log.info ("****************************************************************************************");
            log.info ("****************************************************************************************");
            JSONObject jsonVacio = new JSONObject();
            PojoReporteTecno registroConsultar = generarRegistroVacio();
            jsonVacio = transformadorObjetos.obtenerJSONPojoReporteTecno(registroConsultar);
            array.put(jsonVacio);
            respuestaServicio = Response.status(200).entity(array.toString()).
            header("Access-Control-Allow-Origin", "*").
            header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
            header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
            log.info ("Error en el método buscarRegistrosAtc WS REST: " + errorlistarTodosRegistrosAtcTopN.getMessage());
            errorlistarTodosRegistrosAtcTopN.printStackTrace();
            log.info ("****************************************************************************************");
            log.info ("****************************************************************************************");
            return (respuestaServicio);
        }
        
        return (respuestaServicio);
    }
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @GET
    @Path("/generarReporteDispoExpedientes")
    public Response generarReporteDispoExpedientes (@QueryParam("fechaInicial") RESTDateParam fechaInicial,
    @QueryParam("fechaFinal") RESTDateParam fechaFinal, @Context HttpServletRequest req) throws JSONException
    {
        List<PojoReporteDispoExpedientes> registros = null;
    	Response respuestaServicio = null;
        JSONObject json = new JSONObject();
        JSONArray array=new JSONArray();
        boolean seListaron = false;
        
        try
        {
            /*
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateObj = sdf.parse(date);            
            */
            
            this.direccionIp = req.getRemoteHost();
            log.info ("DIRECCION DEL HOST EN WS REST = " + this.direccionIp);
            //******************************************************
            //******************************************************
            //******************************************************
            transformadorObjetos = new TransformadorObjetosRestWS();
            registros = new ArrayList<PojoReporteDispoExpedientes>();
            //******************************************************
            //******************************************************
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("Trayendo colección de entidades del WS REST entre la fecha " + fechaInicial + " y la fecha final " + fechaFinal);
            registros = servicioReportesTecnoEjb.generarReporteDispoExpedientes(fechaInicial.getDate(),fechaFinal.getDate());
            //******************************************************
            //******************************************************
            if (registros != null)
            {
                log.info ("Registros a retornar desde el EJB = " + registros);
                log.info ("Longitud del arreglo de pojos a retornar = " + registros.size());
                array = transformadorObjetos.obtenerArrayJSONPojoReporteDispoExpedientes(registros);
                respuestaServicio = Response.status(200).entity(array.toString()).
                header("Access-Control-Allow-Origin", "*").
                header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
                header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
                log.info  ("entidades retornados por el EJB: " + registros);
                log.info  ("Respuesta de listarTodosRegistrosAtcTopN: " + respuestaServicio);
                seListaron = true;
            }
            else
            {
                seListaron = false;
            }
            //******************************************************
            //******************************************************
            /*
            servicioAuditoriaSistema.insertarRegistroAuditoria
            ("listado límite","Listar todos los registros con límite de ATC - Servicio Web REST",
            new java.util.Date(),"usuario","Aplicacion",obtenerResultado(seListaron),
            "AtcLeaf (ATC)","Se listaron los registros de la tabla AtcLeaf (ATC) con un valor límite","Servicio Web REST",this.direccionIp,null,null);
            */  
            //******************************************************
            //******************************************************
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("********************************************************");
            //************************
            //******************************************************
            //******************************************************
        }
        
        catch (Exception errorlistarTodosRegistrosAtcTopN)
        {
            log.info ("Control de Error --> *******************************************************************");
            log.info ("****************************************************************************************");
            log.info ("****************************************************************************************");
            JSONObject jsonVacio = new JSONObject();
            PojoReporteTecno registroConsultar = generarRegistroVacio();
            jsonVacio = transformadorObjetos.obtenerJSONPojoReporteTecno(registroConsultar);
            array.put(jsonVacio);
            respuestaServicio = Response.status(200).entity(array.toString()).
            header("Access-Control-Allow-Origin", "*").
            header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
            header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
            log.info ("Error en el método buscarRegistrosAtc WS REST: " + errorlistarTodosRegistrosAtcTopN.getMessage());
            errorlistarTodosRegistrosAtcTopN.printStackTrace();
            log.info ("****************************************************************************************");
            log.info ("****************************************************************************************");
            return (respuestaServicio);
        }
        
        return (respuestaServicio);
    }
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @GET
    @Path("/generarReporteInscripcionRed")
    public Response generarReporteInscripcionRed (@QueryParam("fechaInicial") RESTDateParam fechaInicial,
    @QueryParam("fechaFinal") RESTDateParam fechaFinal, @Context HttpServletRequest req) throws JSONException
    {
        List<PojoReporteInscripcionRed> registros = null;
    	Response respuestaServicio = null;
        JSONObject json = new JSONObject();
        JSONArray array=new JSONArray();
        boolean seListaron = false;
        
        try
        {
            /*
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateObj = sdf.parse(date);            
            */
            
            this.direccionIp = req.getRemoteHost();
            log.info ("DIRECCION DEL HOST EN WS REST = " + this.direccionIp);
            //******************************************************
            //******************************************************
            //******************************************************
            transformadorObjetos = new TransformadorObjetosRestWS();
            registros = new ArrayList<PojoReporteInscripcionRed>();
            //******************************************************
            //******************************************************
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("Trayendo colección de entidades del WS REST entre la fecha " + fechaInicial + " y la fecha final " + fechaFinal);
            registros = servicioReportesTecnoEjb.generarReporteInscripcionRed(fechaInicial.getDate(),fechaFinal.getDate());
            //******************************************************
            //******************************************************
            if (registros != null)
            {
                log.info ("Registros a retornar desde el EJB = " + registros);
                log.info ("Longitud del arreglo de pojos a retornar = " + registros.size());
                array = transformadorObjetos.obtenerArrayJSONPojoReporteInscripcionRed(registros);
                respuestaServicio = Response.status(200).entity(array.toString()).
                header("Access-Control-Allow-Origin", "*").
                header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
                header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
                log.info  ("entidades retornados por el EJB: " + registros);
                log.info  ("Respuesta de listarTodosRegistrosAtcTopN: " + respuestaServicio);
                seListaron = true;
            }
            else
            {
                seListaron = false;
            }
            //******************************************************
            //******************************************************
            /*
            servicioAuditoriaSistema.insertarRegistroAuditoria
            ("listado límite","Listar todos los registros con límite de ATC - Servicio Web REST",
            new java.util.Date(),"usuario","Aplicacion",obtenerResultado(seListaron),
            "AtcLeaf (ATC)","Se listaron los registros de la tabla AtcLeaf (ATC) con un valor límite","Servicio Web REST",this.direccionIp,null,null);
            */  
            //******************************************************
            //******************************************************
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("********************************************************");
            //************************
            //******************************************************
            //******************************************************
        }
        
        catch (Exception errorlistarTodosRegistrosAtcTopN)
        {
            log.info ("Control de Error --> *******************************************************************");
            log.info ("****************************************************************************************");
            log.info ("****************************************************************************************");
            JSONObject jsonVacio = new JSONObject();
            PojoReporteTecno registroConsultar = generarRegistroVacio();
            jsonVacio = transformadorObjetos.obtenerJSONPojoReporteTecno(registroConsultar);
            array.put(jsonVacio);
            respuestaServicio = Response.status(200).entity(array.toString()).
            header("Access-Control-Allow-Origin", "*").
            header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
            header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
            log.info ("Error en el método buscarRegistrosAtc WS REST: " + errorlistarTodosRegistrosAtcTopN.getMessage());
            errorlistarTodosRegistrosAtcTopN.printStackTrace();
            log.info ("****************************************************************************************");
            log.info ("****************************************************************************************");
            return (respuestaServicio);
        }
        
        return (respuestaServicio);
    }
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @GET
    @Path("/generarReporteMonitoreo")
    public Response generarReporteMonitoreo (@QueryParam("fechaInicial") RESTDateParam fechaInicial,
    @QueryParam("fechaFinal") RESTDateParam fechaFinal, @Context HttpServletRequest req) throws JSONException
    {
        List<PojoReporteMonitoreo> registros = null;
    	Response respuestaServicio = null;
        JSONObject json = new JSONObject();
        JSONArray array=new JSONArray();
        boolean seListaron = false;
        
        try
        {
            /*
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateObj = sdf.parse(date);            
            */
            
            this.direccionIp = req.getRemoteHost();
            log.info ("DIRECCION DEL HOST EN WS REST = " + this.direccionIp);
            //******************************************************
            //******************************************************
            //******************************************************
            transformadorObjetos = new TransformadorObjetosRestWS();
            registros = new ArrayList<PojoReporteMonitoreo>();
            //******************************************************
            //******************************************************
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("Trayendo colección de entidades del WS REST entre la fecha " + fechaInicial + " y la fecha final " + fechaFinal);
            registros = servicioReportesTecnoEjb.generarReporteMonitoreo(fechaInicial.getDate(),fechaFinal.getDate());
            //******************************************************
            //******************************************************
            if (registros != null)
            {
                log.info ("Registros a retornar desde el EJB = " + registros);
                log.info ("Longitud del arreglo de pojos a retornar = " + registros.size());
                array = transformadorObjetos.obtenerArrayJSONPojoReporteMonitoreo(registros);
                respuestaServicio = Response.status(200).entity(array.toString()).
                header("Access-Control-Allow-Origin", "*").
                header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
                header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
                log.info  ("entidades retornados por el EJB: " + registros);
                log.info  ("Respuesta de listarTodosRegistrosAtcTopN: " + respuestaServicio);
                seListaron = true;
            }
            else
            {
                seListaron = false;
            }
            //******************************************************
            //******************************************************
            /*
            servicioAuditoriaSistema.insertarRegistroAuditoria
            ("listado límite","Listar todos los registros con límite de ATC - Servicio Web REST",
            new java.util.Date(),"usuario","Aplicacion",obtenerResultado(seListaron),
            "AtcLeaf (ATC)","Se listaron los registros de la tabla AtcLeaf (ATC) con un valor límite","Servicio Web REST",this.direccionIp,null,null);
            */  
            //******************************************************
            //******************************************************
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("********************************************************");
            //************************
            //******************************************************
            //******************************************************
        }
        
        catch (Exception errorlistarTodosRegistrosAtcTopN)
        {
            log.info ("Control de Error --> *******************************************************************");
            log.info ("****************************************************************************************");
            log.info ("****************************************************************************************");
            JSONObject jsonVacio = new JSONObject();
            PojoReporteTecno registroConsultar = generarRegistroVacio();
            jsonVacio = transformadorObjetos.obtenerJSONPojoReporteTecno(registroConsultar);
            array.put(jsonVacio);
            respuestaServicio = Response.status(200).entity(array.toString()).
            header("Access-Control-Allow-Origin", "*").
            header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
            header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
            log.info ("Error en el método buscarRegistrosAtc WS REST: " + errorlistarTodosRegistrosAtcTopN.getMessage());
            errorlistarTodosRegistrosAtcTopN.printStackTrace();
            log.info ("****************************************************************************************");
            log.info ("****************************************************************************************");
            return (respuestaServicio);
        }
        
        return (respuestaServicio);
    }
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @GET
    @Path("/generarReporteConsecutivos")
    public Response generarReporteConsecutivos (@QueryParam("fechaInicial") RESTDateParam fechaInicial,
    @QueryParam("fechaFinal") RESTDateParam fechaFinal, @Context HttpServletRequest req) throws JSONException
    {
        List<PojoReporteConsecutivos> registros = null;
    	Response respuestaServicio = null;
        JSONObject json = new JSONObject();
        JSONArray array=new JSONArray();
        boolean seListaron = false;
        
        try
        {
            /*
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateObj = sdf.parse(date);            
            */
            
            this.direccionIp = req.getRemoteHost();
            log.info ("DIRECCION DEL HOST EN WS REST = " + this.direccionIp);
            //******************************************************
            //******************************************************
            //******************************************************
            transformadorObjetos = new TransformadorObjetosRestWS();
            registros = new ArrayList<PojoReporteConsecutivos>();
            //******************************************************
            //******************************************************
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("Trayendo colección de entidades del WS REST entre la fecha " + fechaInicial + " y la fecha final " + fechaFinal);
            registros = servicioReportesTecnoEjb.generarReporteConsecutivos(fechaInicial.getDate(),fechaFinal.getDate());
            //******************************************************
            //******************************************************
            if (registros != null)
            {
                log.info ("Registros a retornar desde el EJB = " + registros);
                log.info ("Longitud del arreglo de pojos a retornar = " + registros.size());
                array = transformadorObjetos.obtenerArrayJSONPojoReporteConsecutivos(registros);
                respuestaServicio = Response.status(200).entity(array.toString()).
                header("Access-Control-Allow-Origin", "*").
                header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
                header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
                log.info  ("entidades retornados por el EJB: " + registros);
                log.info  ("Respuesta de listarTodosRegistrosAtcTopN: " + respuestaServicio);
                seListaron = true;
            }
            else
            {
                seListaron = false;
            }
            //******************************************************
            //******************************************************
            /*
            servicioAuditoriaSistema.insertarRegistroAuditoria
            ("listado límite","Listar todos los registros con límite de ATC - Servicio Web REST",
            new java.util.Date(),"usuario","Aplicacion",obtenerResultado(seListaron),
            "AtcLeaf (ATC)","Se listaron los registros de la tabla AtcLeaf (ATC) con un valor límite","Servicio Web REST",this.direccionIp,null,null);
            */  
            //******************************************************
            //******************************************************
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("********************************************************");
            //************************
            //******************************************************
            //******************************************************
        }
        
        catch (Exception errorlistarTodosRegistrosAtcTopN)
        {
            log.info ("Control de Error --> *******************************************************************");
            log.info ("****************************************************************************************");
            log.info ("****************************************************************************************");
            JSONObject jsonVacio = new JSONObject();
            PojoReporteTecno registroConsultar = generarRegistroVacio();
            jsonVacio = transformadorObjetos.obtenerJSONPojoReporteTecno(registroConsultar);
            array.put(jsonVacio);
            respuestaServicio = Response.status(200).entity(array.toString()).
            header("Access-Control-Allow-Origin", "*").
            header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
            header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
            log.info ("Error en el método buscarRegistrosAtc WS REST: " + errorlistarTodosRegistrosAtcTopN.getMessage());
            errorlistarTodosRegistrosAtcTopN.printStackTrace();
            log.info ("****************************************************************************************");
            log.info ("****************************************************************************************");
            return (respuestaServicio);
        }
        
        return (respuestaServicio);
    }
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @GET
    @Path("/generarReporteUsuarios")
    public Response generarReporteUsuarios (@QueryParam("fechaInicial") RESTDateParam fechaInicial,
    @QueryParam("fechaFinal") RESTDateParam fechaFinal, @Context HttpServletRequest req) throws JSONException
    {
        List<PojoReporteUsuarios> registros = null;
    	Response respuestaServicio = null;
        JSONObject json = new JSONObject();
        JSONArray array=new JSONArray();
        boolean seListaron = false;
        
        try
        {
            /*
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateObj = sdf.parse(date);            
            */
            
            this.direccionIp = req.getRemoteHost();
            log.info ("DIRECCION DEL HOST EN WS REST = " + this.direccionIp);
            //******************************************************
            //******************************************************
            //******************************************************
            transformadorObjetos = new TransformadorObjetosRestWS();
            registros = new ArrayList<PojoReporteUsuarios>();
            //******************************************************
            //******************************************************
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("Trayendo colección de entidades del WS REST entre la fecha " + fechaInicial + " y la fecha final " + fechaFinal);
            registros = servicioReportesTecnoEjb.generarReporteUsuarios(fechaInicial.getDate(),fechaFinal.getDate());
            //******************************************************
            //******************************************************
            if (registros != null)
            {
                log.info ("Registros a retornar desde el EJB = " + registros);
                log.info ("Longitud del arreglo de pojos a retornar = " + registros.size());
                array = transformadorObjetos.obtenerArrayJSONPojoReporteUsuarios(registros);
                respuestaServicio = Response.status(200).entity(array.toString()).
                header("Access-Control-Allow-Origin", "*").
                header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
                header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
                log.info  ("entidades retornados por el EJB: " + registros);
                log.info  ("Respuesta de listarTodosRegistrosAtcTopN: " + respuestaServicio);
                seListaron = true;
            }
            else
            {
                seListaron = false;
            }
            //******************************************************
            //******************************************************
            /*
            servicioAuditoriaSistema.insertarRegistroAuditoria
            ("listado límite","Listar todos los registros con límite de ATC - Servicio Web REST",
            new java.util.Date(),"usuario","Aplicacion",obtenerResultado(seListaron),
            "AtcLeaf (ATC)","Se listaron los registros de la tabla AtcLeaf (ATC) con un valor límite","Servicio Web REST",this.direccionIp,null,null);
            */  
            //******************************************************
            //******************************************************
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("********************************************************");
            //************************
            //******************************************************
            //******************************************************
        }
        
        catch (Exception errorlistarTodosRegistrosAtcTopN)
        {
            log.info ("Control de Error --> *******************************************************************");
            log.info ("****************************************************************************************");
            log.info ("****************************************************************************************");
            JSONObject jsonVacio = new JSONObject();
            PojoReporteTecno registroConsultar = generarRegistroVacio();
            jsonVacio = transformadorObjetos.obtenerJSONPojoReporteTecno(registroConsultar);
            array.put(jsonVacio);
            respuestaServicio = Response.status(200).entity(array.toString()).
            header("Access-Control-Allow-Origin", "*").
            header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
            header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
            log.info ("Error en el método buscarRegistrosAtc WS REST: " + errorlistarTodosRegistrosAtcTopN.getMessage());
            errorlistarTodosRegistrosAtcTopN.printStackTrace();
            log.info ("****************************************************************************************");
            log.info ("****************************************************************************************");
            return (respuestaServicio);
        }
        
        return (respuestaServicio);
    }
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    @GET
    @Path("/generarReporteUsuariosInternet")
    public Response generarReporteUsuariosInternet (@QueryParam("fechaInicial") RESTDateParam fechaInicial,
    @QueryParam("fechaFinal") RESTDateParam fechaFinal, @Context HttpServletRequest req) throws JSONException
    {
        List<PojoReportesUsuariosInternet> registros = null;
    	Response respuestaServicio = null;
        JSONObject json = new JSONObject();
        JSONArray array=new JSONArray();
        boolean seListaron = false;
        
        try
        {
            /*
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateObj = sdf.parse(date);            
            */
            
            this.direccionIp = req.getRemoteHost();
            log.info ("DIRECCION DEL HOST EN WS REST = " + this.direccionIp);
            //******************************************************
            //******************************************************
            //******************************************************
            transformadorObjetos = new TransformadorObjetosRestWS();
            registros = new ArrayList<PojoReportesUsuariosInternet>();
            //******************************************************
            //******************************************************
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("********************************************************");
            //log.info ("Trayendo colección de entidades del WS REST entre la fecha " + fechaInicial + " y la fecha final " + fechaFinal);
            registros = servicioReportesTecnoEjb.generarReporteUsuariosInternet(fechaInicial.getDate(),fechaFinal.getDate());
            //******************************************************
            //******************************************************
            if (registros != null)
            {
                log.info ("Registros a retornar desde el EJB = " + registros);
                log.info ("Longitud del arreglo de pojos a retornar = " + registros.size());
                array = transformadorObjetos.obtenerArrayJSONPojoReporteUsuariosInternet(registros);
                respuestaServicio = Response.status(200).entity(array.toString()).
                header("Access-Control-Allow-Origin", "*").
                header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
                header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
                log.info  ("entidades retornados por el EJB: " + registros);
                log.info  ("Respuesta de listarTodosRegistrosAtcTopN: " + respuestaServicio);
                seListaron = true;
            }
            else
            {
                seListaron = false;
            }
            //******************************************************
            //******************************************************
            /*
            servicioAuditoriaSistema.insertarRegistroAuditoria
            ("listado límite","Listar todos los registros con límite de ATC - Servicio Web REST",
            new java.util.Date(),"usuario","Aplicacion",obtenerResultado(seListaron),
            "AtcLeaf (ATC)","Se listaron los registros de la tabla AtcLeaf (ATC) con un valor límite","Servicio Web REST",this.direccionIp,null,null);
            */  
            //******************************************************
            //******************************************************
            log.info ("********************************************************");
            log.info ("********************************************************");
            log.info ("********************************************************");
            //************************
            //******************************************************
            //******************************************************
        }
        
        catch (Exception errorlistarTodosRegistrosAtcTopN)
        {
            log.info ("Control de Error --> *******************************************************************");
            log.info ("****************************************************************************************");
            log.info ("****************************************************************************************");
            JSONObject jsonVacio = new JSONObject();
            PojoReporteTecno registroConsultar = generarRegistroVacio();
            jsonVacio = transformadorObjetos.obtenerJSONPojoReporteTecno(registroConsultar);
            array.put(jsonVacio);
            respuestaServicio = Response.status(200).entity(array.toString()).
            header("Access-Control-Allow-Origin", "*").
            header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
            header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
            log.info ("Error en el método buscarRegistrosAtc WS REST: " + errorlistarTodosRegistrosAtcTopN.getMessage());
            errorlistarTodosRegistrosAtcTopN.printStackTrace();
            log.info ("****************************************************************************************");
            log.info ("****************************************************************************************");
            return (respuestaServicio);
        }
        
        return (respuestaServicio);
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
    private PojoReporteTecno generarRegistroVacio()
    {
        PojoReporteTecno vacio = new PojoReporteTecno();
        java.util.Date fecha = new java.util.Date();
        
        vacio.setReporte("0");
        vacio.setCdg_desenlace("0");
        vacio.setCdg_eventodeteccion("0");
        vacio.setCdg_origenreporte("0");
        vacio.setCdg_seriedad("0");
        vacio.setCdg_tipoeventoincidente("0");
        vacio.setCdg_tiporeporte("0");
        vacio.setDescripcion_evento("0");
        vacio.setDesenlace_otro("0");
        vacio.setFechaingreso(fecha);
        vacio.setFechevento(fecha);
        vacio.setFechreporte_evento(new java.util.Date());
        vacio.setInternet("0");
        vacio.setReportado("0");
        
        log.info ("ESTADO DEL BEAN VACIO = " + vacio);
        
        return (vacio);
    }
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
}
