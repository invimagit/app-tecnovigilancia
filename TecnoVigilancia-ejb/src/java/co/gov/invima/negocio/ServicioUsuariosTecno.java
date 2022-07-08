/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.negocio;

import co.gov.invima.dao.TecnoUsuariosInternetFacadeLocal;
import co.gov.invima.dto.PersonaInternetVO;
import co.gov.invima.entidad.TecnoUsuariosInternet;
import co.gov.invima.utils.EncripcionUtils;
import co.gov.invima.utils.ManejadorDatos;
import java.util.List;
import org.apache.log4j.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jgutierrezme
 */
@Stateless
public class ServicioUsuariosTecno implements ServicioUsuariosRemote 
{
    //************************************************************
    //************************************************************
    //************************************************************
    private final static Logger logEJBTecno = Logger.getLogger(ServicioReporteCero.class.getName());
    //************************************************************
    //************************************************************
    //************************************************************
    //************************************************************
    @EJB
    private TecnoUsuariosInternetFacadeLocal tecnoUsuariosInternet;
    //************************************************************
    //************************************************************
    @Override
    public PersonaInternetVO obtenerDatosUsuarioInternetPorDocumento(String documento) 
    {
        List<TecnoUsuariosInternet> usuarios = null;
        TecnoUsuariosInternet registro = null;
        PersonaInternetVO registroWebService = null;
        PersonaInternetVO vacio = new PersonaInternetVO();
        ManejadorDatos validadorDatos = new ManejadorDatos();
        
        try
        {
            //logEJBTecno.info  ("Ejecutando búsqueda por documento en el EJB");
            usuarios = tecnoUsuariosInternet.buscarPorCedula(documento);
            
            if (usuarios != null)
            {
                if (usuarios.size() > 0)
                {
                    registro = usuarios.get(0);
                    //********************************************************
                    //********************************************************
                    //********************************************************
                    registroWebService = new PersonaInternetVO();
                    //*****************************************************
                    //*****************************************************
                    registroWebService.setIdentificacion_empresa(validadorDatos.validarDatoCampoBaseDatos(registro.getIdentificacionEmpresa(),"cadena"));
                    registroWebService.setTipidentificacion_empresa(validadorDatos.validarDatoCampoBaseDatos(registro.getTipidentificacionEmpresa(),"cadena"));
                    registroWebService.setNombre_empresa(validadorDatos.validarDatoCampoBaseDatos(registro.getNombreEmpresa(),"cadena"));
                    registroWebService.setDireccion_empresa(validadorDatos.validarDatoCampoBaseDatos(registro.getDireccionEmpresa(),"cadena"));
                    registroWebService.setCdg_pais(validadorDatos.validarDatoCampoBaseDatos(registro.getCdgPais(),"numero"));
                    registroWebService.setCod_mun(validadorDatos.validarDatoCampoBaseDatos(registro.getCodMun(),"numero"));
                    registroWebService.setTelefono_empresa(validadorDatos.validarDatoCampoBaseDatos(registro.getTelefonoEmpresa(),"cadena"));
                    registroWebService.setEmail_empresa(validadorDatos.validarDatoCampoBaseDatos(registro.getEmailEmpresa(),"cadena"));
                    registroWebService.setFax(validadorDatos.validarDatoCampoBaseDatos(registro.getFax(),"cadena"));
                    registroWebService.setUrl(validadorDatos.validarDatoCampoBaseDatos(registro.getUrl(),"cadena"));
                    registroWebService.setIdentificacion_persona(validadorDatos.validarDatoCampoBaseDatos(registro.getIdentificacionPersona(),"cadena"));
                    registroWebService.setTipidentificacion_persona(validadorDatos.validarDatoCampoBaseDatos(registro.getTipidentificacionPersona(),"cadena"));
                    registroWebService.setNombre_persona(validadorDatos.validarDatoCampoBaseDatos(registro.getNombrePersona(),"cadena"));
                    registroWebService.setCargo_persona(validadorDatos.validarDatoCampoBaseDatos(registro.getCargoPersona(),"cadena"));
                    registroWebService.setTelefono_persona(validadorDatos.validarDatoCampoBaseDatos(registro.getTelefonoPersona(),"cadena"));
                    registroWebService.setEmail_persona(validadorDatos.validarDatoCampoBaseDatos(registro.getEmailPersona(),"cadena"));
                    registroWebService.setUsuario(validadorDatos.validarDatoCampoBaseDatos(registro.getUsuario(),"cadena"));
                    registroWebService.setActivo(validadorDatos.validarDatoCampoBaseDatos(registro.getActivo(),"cadena"));
                    registroWebService.setID_Rol_Usuario(validadorDatos.validarDatoCampoBaseDatos(registro.getIDRolUsuario(),"cadena"));
                    registroWebService.setPregunta(validadorDatos.validarDatoCampoBaseDatos(registro.getPregunta(),"cadena"));
                    registroWebService.setRespuesta(generateHash(validadorDatos.validarDatoCampoBaseDatos(registro.getRespuesta(),"cadena")));
                    registroWebService.setFecha_ingreso(validadorDatos.validarDatoCampoBaseDatos(registro.getFechaIngreso(),"cadena"));
                    registroWebService.setPassword(generateHash(validadorDatos.validarDatoCampoBaseDatos(registro.getPassword(),"cadena")));
                    registroWebService.setSession(validadorDatos.validarDatoCampoBaseDatos(registro.getSession(),"cadena"));
                    registroWebService.setEstado_usuario(validadorDatos.validarDatoCampoBaseDatos(registro.getEstadoUsuario(),"cadena"));
                    registroWebService.setClasificacion_usuario(validadorDatos.validarDatoCampoBaseDatos(registro.getClasificacionUsuario(),"cadena"));
                    registroWebService.setCod_depart(validadorDatos.validarDatoCampoBaseDatos(registro.getCodDepart(),"numero"));
                    //**************************************************************************************
                    //**************************************************************************************
                    //**************************************************************************************
                    //**************************************************************************************
                    //logEJBTecno.info  ("Registro generado: " + registroWebService);
                }
            }
        }
        
        catch (Exception errorBusqueda)
        {
                //logEJBTecno.info  ("Error en la consulta: " + errorBusqueda.getLocalizedMessage());
                errorBusqueda.printStackTrace();
                return (vacio);
        }
        
        finally
        {
            try
            {
            }
            
            catch (Exception errorFinally)
            {
                //logEJBTecno.info  ("Error en la consulta sql: " + errorFinally.getLocalizedMessage());
                errorFinally.printStackTrace();
                return (vacio);
            }
        }
        
        return (registroWebService);
    }
    //************************************************************
    //************************************************************
    //************************************************************
    private String generateHash(String cadenaCodificar)
    {
	   String hashCifrado = "";
	   EncripcionUtils manejadorCifrado = new EncripcionUtils();	
	   
	   try
	   {
		   hashCifrado = manejadorCifrado.encripcion(cadenaCodificar);
		   //***********************************************************
		   //***********************************************************
		   //logEJBTecno.info ("CLAVE CIFRADA WS = " + hashCifrado);
		   //***********************************************************
		   //***********************************************************
	   }
	   
	   catch (Exception error)
	   {
		   //logEJBTecno.info ("Error generando hash = " + error.getLocalizedMessage());
		   return ("00000000000000000000000000000000000000000000000000000");
	   }

	   return (hashCifrado);
    }
    //************************************************************
    //************************************************************
    //************************************************************
    //************************************************************
    //************************************************************
    //************************************************************
}
