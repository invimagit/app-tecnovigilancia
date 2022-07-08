/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.presentacion.utilerias;

import co.gov.invima.negocio.servicios.web.interfaces.tecnovigilancia.rest.ServicioCargueTecnoREST;
import java.util.HashMap;
import java.util.logging.Logger;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import javax.json.Json;
import javax.json.JsonObject;
/**
 *
 * @author jgutierrezme
 */
public class ManejadorTokenSeguridadInvima 
{
    //**************************************************************************************************    
    //**************************************************************************************************    
    //**************************************************************************************************    
    //**************************************************************************************************    
    private final static Logger logBean = Logger.getLogger(ServicioCargueTecnoREST.class.getName());
    //**************************************************************************************************    
    //**************************************************************************************************    
    //**************************************************************************************************    
    public ManejadorTokenSeguridadInvima()
    {
    }
    //**************************************************************************************************    
    //**************************************************************************************************    
    //**************************************************************************************************    
    public String generarTokenPortlet (String username, String clave, String servicioAutenticacion)
    {
            String tokenEndpoint = "";
            String uriServicioToken = "";
            String uriServicioTokenSeg = "";
            int status = 0;

            try
            {
                    //*****************************************************************
                    //*****************************************************************
                    /*
                    uriServicioToken =
                    "http://ivcpuertos.invima.gov.co/ServicioCertificacionPuertos/oauth/token?grant_type=password"+
                    "&client_id=my-trusted-client&username=" + username + "&password="+clave;
                    */
                    //*****************************************************************
                    //*****************************************************************
                    /*
                    ExternalContext extcontextP = FacesContext.getCurrentInstance().getExternalContext();
                    PortletRequest portletRequestP = (PortletRequest) extcontextP.getRequest();
                    HttpServletRequest myRequestP = PortalUtil.getHttpServletRequest(portletRequestP);
                    logBean.info("REQUEST = " + myRequestP);
                    ServletContext servletContext = myRequestP.getSession().getServletContext();
                    logBean.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    logBean.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    logBean.info("SERVLET CONTEXT DEL REQUEST = " + servletContext);
                    logBean.info("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
                    //imprimirParametrosServletContext(servletContext);
                    logBean.info("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
                    logBean.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    logBean.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    mapaMemoria = (HashMap<String, String>)servletContext.getAttribute("mapaPropiedades");
                    logBean.info("MAPA RECUPERADO DE LA SESIÓN = " + mapaMemoria);
                    uriServicioToken = mapaMemoria.get("servicioToken");
                    */
                    //*****************************************************************
                    //*****************************************************************
                    uriServicioToken = servicioAutenticacion;
                    logBean.info ("URI DEL WS = " + uriServicioToken);
                    uriServicioTokenSeg = uriServicioToken + "&username=" + username + "&password="+clave;
                    logBean.info ("URI DEL WS CON SEGURIDAD = " + uriServicioTokenSeg);
                    logBean.info("***********************************************************************");
                    logBean.info("***********************************************************************");
                    logBean.info("***********************************************************************");
                    logBean.info("***********************************************************************");
                    CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(new SSLConnectionSocketFactory(SSLContexts.custom().loadTrustMaterial
                    (null, new TrustSelfSignedStrategy()).build(), NoopHostnameVerifier.INSTANCE)).build();
                    logBean.info("Getting configuration...");
                    HttpGet configurationRequest = new HttpGet(uriServicioTokenSeg);
                    CloseableHttpResponse configurationResponse = client.execute(configurationRequest);
                    logBean.info ("RESPONSE = " + configurationResponse);
                    JsonObject configurarionObject = Json.createReader(configurationResponse.getEntity().getContent()).readObject();
                    logBean.info ("TOKEN GENERADO = " + configurarionObject);
                    status = configurationResponse.getStatusLine().getStatusCode();
                    logBean.info ("CODIGO HTTP DE LA PETICION = " + status);
                    if (status == 200)
                    {
                        tokenEndpoint = configurarionObject.getString("access_token");
                        logBean.info("TOKEN GENERADO CORRECTAMENTE = " + tokenEndpoint);
                    }
                    else
                    {
                        tokenEndpoint = "sintoken";
                        logBean.info("NO SE PUDO GENERAR TOKEN POR LA AUTENTICACION = " + tokenEndpoint);
                    }
                    configurationResponse.close();
                    logBean.info("***********************************************************************");
                    logBean.info("***********************************************************************");
            }

            catch (Exception errorClave)
            {
                    logBean.info("ERROR DE AUTENTICACION = " + errorClave.toString());
                    errorClave.printStackTrace();
                    return ("sintoken");
            }

            return (tokenEndpoint);
    }
    //**************************************************************************************************    
    //**************************************************************************************************    
    //**************************************************************************************************    
    //**************************************************************************************************    
    //**************************************************************************************************    
    //**************************************************************************************************    
}
