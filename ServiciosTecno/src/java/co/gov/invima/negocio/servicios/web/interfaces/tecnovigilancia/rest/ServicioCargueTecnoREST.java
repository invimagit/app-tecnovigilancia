/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.negocio.servicios.web.interfaces.tecnovigilancia.rest;

import co.gov.invima.dto.PersonaInternetVO;
import co.gov.invima.negocio.ServicioUsuariosRemote;
import co.gov.invima.presentacion.utilerias.ManejadorTokenSeguridadInvima;
import co.gov.invima.presentacion.utilerias.ServiceLocator;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jgutierrezme
 */
@Path("serviciocarguetecno")
@Produces({MediaType.APPLICATION_JSON })
@Consumes({MediaType.APPLICATION_JSON })
public class ServicioCargueTecnoREST 
{
    private final static Logger logWebService = Logger.getLogger(ServicioCargueTecnoREST.class.getName());
    /*****************************************************************/
    /*****************************************************************/
    /*****************************************************************/
    private ServicioUsuariosRemote servicioUsuariosEjb;
    
    private TransformadorObjetosRestWS transformadorObjetos;
    /*****************************************************************/
    /*****************************************************************/
    private String direccionIp;
    /*****************************************************************/
    /*****************************************************************/
    public ServicioCargueTecnoREST()
    {
        //ManejoContexto manejadorContexto = new ManejoContexto();
        logWebService.info("**************************************************");
        logWebService.info("**************************************************");
        logWebService.info("Conectandose al contexto");
        ServiceLocator service = new ServiceLocator();
        servicioUsuariosEjb = service.getEjbRemoto();
        logWebService.info("Estado del WS REST CARGUE TECNO de Catalogos: " + this.servicioUsuariosEjb);
        logWebService.info("**************************************************");
        logWebService.info("**************************************************");
    }
    //******************************************************************************
    //******************************************************************************
    //******************************************************************************
    @GET
    @Path("/obtenerDatosUsuarioInternetPorDocumento")
    public Response obtenerDatosUsuarioInternetPorDocumento(@QueryParam("documento") String documento, 
    @QueryParam("userToken") String userToken,
    @QueryParam("claveToken") String claveToken,
    @Context HttpServletRequest req) throws JSONException, IllegalArgumentException, IllegalAccessException 
    {
        PersonaInternetVO registro = null;
    	Response respuestaServicio = null;
        JSONObject json = new JSONObject();
        JSONArray array=new JSONArray();
        boolean seListaron = false;
        String rutaWebService = "";
        String token = "";
        transformadorObjetos = new TransformadorObjetosRestWS();
        
        try
        {
            rutaWebService = obtenerRutaServicio(req);
            logWebService.info ("RUTA DEL WS DE AUTENTICACION POR TOKEN = " + rutaWebService);
            logWebService.info ("USUARIO DEL WS PARA AUTENTICAR = " + userToken);
            //logWebService.info ("CLAVE DEL WS PARA AUTENTICAR = " + claveToken);
            
            if (rutaWebService != null && userToken != null && claveToken != null)
            {
                logWebService.info ("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                logWebService.info ("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                logWebService.info ("ESTADO DEL EJB = " + servicioUsuariosEjb);
                logWebService.info ("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                logWebService.info ("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                this.setDireccionIp(req.getRemoteHost());
                logWebService.info ("DIRECCION DEL HOST EN WS REST = " + this.getDireccionIp());
                //*****************************************************************************
                //*****************************************************************************
                ManejadorTokenSeguridadInvima controladorSeguridadWS = new ManejadorTokenSeguridadInvima();
                token = controladorSeguridadWS.generarTokenPortlet(userToken,claveToken,rutaWebService);
                logWebService.info ("TOKEN DE AUTENTICACION GENERADO = " + token);
                //*****************************************************************************
                //*****************************************************************************
                if (!token.equals("sintoken"))
                {
                    logWebService.info ("********************************************************");
                    logWebService.info ("********************************************************");
                    logWebService.info ("********************************************************");
                    logWebService.info ("Trayendo colección de entidades del WS REST con documento: " + documento);
                    registro = servicioUsuariosEjb.obtenerDatosUsuarioInternetPorDocumento(documento);

                    if (registro != null)
                    {
                        logWebService.info ("Registros a retornar desde el EJB = " + registro);
                        json = transformadorObjetos.obtenerJSONPojoPersonaInternetTecnoCargue(registro);
                        array.put(json);
                        respuestaServicio = Response.status(200).entity(array.toString()).
                        header("Access-Control-Allow-Origin", "*").
                        header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
                        header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
                        logWebService.info  ("Respuesta de listarTodosRegistrosAtcTopN: " + respuestaServicio);
                        seListaron = true;
                    }
                    else
                    {
                        seListaron = false;
                    }

                    logWebService.info ("********************************************************");
                    logWebService.info ("********************************************************");
                    logWebService.info ("********************************************************");
                }
                else
                {
                    logWebService.info ("NO SE PUEDE REALIZAR LA AUTENTICACION");
                    JSONObject jsonVacio = new JSONObject();
                    java.util.ArrayList<String> datosArreglo = new java.util.ArrayList<String>();
                    datosArreglo.add("error_autenticacion");
                    datosArreglo.add("NO AUTENTICADO");
                    datosArreglo.add("mensaje_error");
                    datosArreglo.add("Las credenciales de autenticación del WS de Tecnovigilancia no son las correctas");
                    jsonVacio = transformadorObjetos.obtenerJSONArreglo(datosArreglo);
                    array.put(jsonVacio);
                    respuestaServicio = Response.status(200).entity(array.toString()).
                    header("Access-Control-Allow-Origin", "*").
                    header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
                    header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
                }
            }
            else
            {
                    logWebService.info ("************************************************");
                    logWebService.info ("************************************************");
                    logWebService.info ("NO SE OBTUVO LA URI DEL WS DE AUTENTICACION");
                    logWebService.info ("************************************************");
                    logWebService.info ("************************************************");
                    JSONObject jsonVacio = new JSONObject();
                    java.util.ArrayList<String> datosArreglo = new java.util.ArrayList<String>();
                    datosArreglo.add("error_autenticacion");
                    datosArreglo.add("NO AUTENTICADO");
                    datosArreglo.add("mensaje_error");
                    datosArreglo.add("El Servicio Web interno de Autenticación no fue proporcionado al WS de Operaciones de Negocio");
                    jsonVacio = transformadorObjetos.obtenerJSONArreglo(datosArreglo);
                    array.put(jsonVacio);
                    respuestaServicio = Response.status(200).entity(array.toString()).
                    header("Access-Control-Allow-Origin", "*").
                    header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
                    header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
            }
        }
        
        catch (Exception errorlistarTodosRegistrosAtcTopN)
        {
                    logWebService.info ("Control de Error --> *******************************************************************");
                    logWebService.info ("****************************************************************************************");
                    logWebService.info ("****************************************************************************************");
                    JSONObject jsonVacio = new JSONObject();
                    java.util.ArrayList<String> datosArreglo2 = new java.util.ArrayList<String>();
                    datosArreglo2.add("error_autenticacion");
                    datosArreglo2.add("NO AUTENTICADO");
                    datosArreglo2.add("mensaje_error");
                    datosArreglo2.add("El Servicio Web interno de Autenticación no fue proporcionado al WS de Operaciones de Negocio");
                    logWebService.info ("ARREGLO = " + datosArreglo2);
                    jsonVacio = transformadorObjetos.obtenerJSONArreglo(datosArreglo2);
                    array.put(jsonVacio);
                    respuestaServicio = Response.status(200).entity(array.toString()).
                    header("Access-Control-Allow-Origin", "*").
                    header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").
                    header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
                    logWebService.info ("Error en el método buscarRegistrosAtc WS REST: " + errorlistarTodosRegistrosAtcTopN.getMessage());
                    logWebService.info ("****************************************************************************************");
                    logWebService.info ("****************************************************************************************");
                    errorlistarTodosRegistrosAtcTopN.printStackTrace();
                    return (respuestaServicio);
        }
        
        return (respuestaServicio);
    }
    //******************************************************************************
    //******************************************************************************
    //******************************************************************************
    private String obtenerRutaServicio (HttpServletRequest request)
    {
        String rutaServicio = "";
        HashMap<String, String> mapaMemoria = new HashMap<String, String>();
        
        try
        {
                    ServletContext servletContext = request.getSession().getServletContext();
                    logWebService.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    logWebService.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    logWebService.info("SERVLET CONTEXT DEL REQUEST = " + servletContext);
                    logWebService.info("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
                    //imprimirParametrosServletContext(servletContext);
                    mapaMemoria = (HashMap<String, String>)servletContext.getAttribute("mapaPropiedades");
                    rutaServicio = mapaMemoria.get("servicioToken");
                    logWebService.info("Ruta del Servicio = " + rutaServicio);
                    logWebService.info("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
                    logWebService.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    logWebService.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        }
        
        catch (Exception errorRequest)
        {
            errorRequest.printStackTrace();
            return (null);
        }
        
        return (rutaServicio);
    }
    //******************************************************************************
    //******************************************************************************
    //******************************************************************************
    private PersonaInternetVO generarRegistroVacio()
    {
        PersonaInternetVO vacio = new PersonaInternetVO();
        java.util.Date fecha = new java.util.Date();
        
        vacio.setActivo("0");
        vacio.setCargo_persona("SIN REGISTRO");
        vacio.setCdg_pais("0");
        vacio.setClasificacion_usuario("0");
        vacio.setCod_depart("0");
        vacio.setCod_mun("0");
        vacio.setDireccion_empresa("0");
        vacio.setEmail_empresa("0");
        vacio.setEmail_persona("0");
        vacio.setEstado_usuario("0");
        vacio.setFax("0");
        vacio.setFecha_ingreso("0000-00-00");
        vacio.setID_Rol_Usuario("0");
        vacio.setIdentificacion_empresa("0");
        vacio.setIdentificacion_persona("0");
        vacio.setNombre_empresa("0");
        vacio.setNombre_persona("0");
        vacio.setPassword("0");
        vacio.setPregunta("0");
        vacio.setRespuesta("0");
        vacio.setSession("0");
        vacio.setTelefono_empresa("0");
        vacio.setTelefono_persona("0");
        vacio.setTipidentificacion_empresa("0");
        vacio.setTipidentificacion_persona("0");
        vacio.setUrl("0");
        vacio.setUsuario("0");
        
        logWebService.info ("ESTADO DEL BEAN VACIO = " + vacio);
        
        return (vacio);
    }
    //******************************************************************************
    //******************************************************************************
    //******************************************************************************
    //******************************************************************************
    //******************************************************************************
    //******************************************************************************
    /**
     * @return the direccionIp
     */
    public String getDireccionIp() {
        return direccionIp;
    }

    /**
     * @param direccionIp the direccionIp to set
     */
    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }
    
    
}
