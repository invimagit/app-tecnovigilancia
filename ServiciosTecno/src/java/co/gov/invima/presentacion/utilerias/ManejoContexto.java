/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.presentacion.utilerias;

import java.io.Serializable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;

/**
 *
 * @author jgutierrezme
 */
public class ManejoContexto implements Serializable
{
    private final static Logger log = Logger.getLogger(ManejoContexto.class.getName());
    //****************************************************************
    //****************************************************************
    //public String obtenerDireccionIpContexto (MessageContext contextoWebApp)
    public String obtenerDireccionIpContexto (WebServiceContext contextoWebApp)
    {
        String direccionIpClienteServicio = "";
        //HttpServletRequest request = null;
        
        try
        {
            /*
            log.info ("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            log.info ("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            log.info ("Contexto del WebService enviado por REST PARA VALIDACION: " + contextoWebApp);
            request = (HttpServletRequest)contextoWebApp.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            log.info ("REQUEST DEL WEB SERVICE = " + request);
            direccionIpClienteServicio = request.getRemoteHost();
            log.info ("DIRECCIÓN IP DEL CLIENTE = " + direccionIpClienteServicio);
            log.info ("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            log.info ("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            */
            
            /*
            Message message = PhaseInterceptorChain.getCurrentMessage();
            HttpServletRequest request = (HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);
            direccionIpClienteServicio = request.getRemoteHost();
            */
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
            direccionIpClienteServicio = request.getRemoteHost();
            
            log.info ("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            log.info ("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            log.info ("DIRECCIÓN IP DEL CLIENTE = " + direccionIpClienteServicio);
            log.info ("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            log.info ("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        }
        
        catch (Exception errorObteniendoContexto)
        {
            errorObteniendoContexto.printStackTrace();
            return ("127.0.0.1");
        }
        
        return (direccionIpClienteServicio);
    }
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    public String obtenerDireccionIPV4(String hostNameCliente)
    {
        String direccionIPV4 = "";
        
        try
        {
            //************************************************************
            //************************************************************
            /*
            log.info("DIRECCION ENVIADA PARA LA 4 = " + hostNameCliente);
            log.info(System.getProperty("java.home"));
            System.setProperty("java.net.preferIPv6Addresses", "true");
            log.info(System.getProperty("java.net.preferIPv6Addresses"));
            InetAddress[] addr = InetAddress.getAllByName(hostNameCliente);
            String direccion = "";
            String tarjeta = "";
            
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) 
                {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    direccion = inetAddress.getHostAddress();
                    tarjeta = intf.getName();
                    log.info("Indice = " +intf.getIndex() + " - " + intf.getName() + " - " + intf.getDisplayName()+" - "+ direccion);
                    
                    if (tarjeta.equals("eth1") || tarjeta.equals("eth0"))
                    {
                        if (!direccion.startsWith("127") && direccion.contains("."))
                        {
                            direccionIPV4 = direccion;
                            log.info ("DIRECCION IPV4 = " + direccion);
                            break;
                        }
                        else
                        {
                            log.info ("DIRECCION IPV6 = " + direccion);
                        }
                    
                    }
                }
            } 
            */
            //************************************************************
            //************************************************************
            String direccionip = "";
            String tarjetared = "";
            System.out.println ("************************************ -->");
            System.out.println ("************************************ -->");
            Enumeration e = NetworkInterface.getNetworkInterfaces();
            while(e.hasMoreElements())
            {
                NetworkInterface n = (NetworkInterface) e.nextElement();
                Enumeration ee = n.getInetAddresses();
                tarjetared = n.getName();
                
                if (tarjetared.equals("eth0") || tarjetared.equals("eth1"))
                {
                        while (ee.hasMoreElements())
                        {
                            InetAddress i = (InetAddress) ee.nextElement();
                            direccionip = i.getHostAddress();
                            System.out.println ("Direccion a = " + direccionip);

                            if (!direccionip.startsWith("127") && direccionip.contains("."))
                            {
                                direccionIPV4 = direccionip;
                                System.out.println ("Direccion correcta = " + direccionIPV4);
                                break;
                            }
                        }
                }
            }
            //************************************************************
            //************************************************************
            System.out.println ("************************************ -->");
            System.out.println ("************************************ -->");
        }
        
        catch (Exception errorIpv)
        {
            log.info ("Error de resolución = " + errorIpv.getLocalizedMessage());
            errorIpv.printStackTrace();
            return ("127.0.0.1");
        }
        
        return direccionIPV4;
    }
    //************************************************************************************************
    //************************************************************************************************
    //************************************************************************************************
    public String obtenerDireccionIPV6(String hostNameCliente)
    {
        String direccionIPV6 = "";
        
        try
        {
            //************************************************************
            //************************************************************
            /*
            log.info("DIRECCION ENVIADA PARA LA 6 = " + hostNameCliente);
            log.info(System.getProperty("java.home"));
            System.setProperty("java.net.preferIPv6Addresses", "true");
            log.info(System.getProperty("java.net.preferIPv6Addresses"));
            InetAddress[] addr = InetAddress.getAllByName(hostNameCliente);
            String direccion = "";
            String tarjeta = "";
            
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) 
                {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    direccion = inetAddress.getHostAddress();
                    tarjeta = intf.getName();
                    log.info("Indice 2 = " + intf.getIndex() + " - " + intf.getName() + " - " + intf.getDisplayName()+" - "+ direccion);
                    
                    if (tarjeta.equals("eth1") || tarjeta.equals("eth0"))
                    {
                        if (!direccion.startsWith("127") && direccion.contains("."))
                        {
                            log.info ("DIRECCION IPV4 = " + direccion);
                        }
                        else
                        {
                            direccionIPV6 = direccion;
                            log.info ("DIRECCION IPV6 = " + direccion);
                            break;
                        }
                    
                    }
                }
            }    
            */
            String direccionip = "";
            String tarjetared = "";
            System.out.println ("************************************ -->");
            System.out.println ("************************************ -->");
            Enumeration e = NetworkInterface.getNetworkInterfaces();
            while(e.hasMoreElements())
            {
                NetworkInterface n = (NetworkInterface) e.nextElement();
                Enumeration ee = n.getInetAddresses();
                tarjetared = n.getName();
                
                if (tarjetared.equals("eth0") || tarjetared.equals("eth1"))
                {
                        while (ee.hasMoreElements())
                        {
                            InetAddress i = (InetAddress) ee.nextElement();
                            direccionip = i.getHostAddress();
                            System.out.println ("Direccion correcta = " + direccionip);

                            if (!direccionip.startsWith("127") && !direccionip.contains("."))
                            {
                                direccionIPV6 = direccionip;
                                System.out.println ("Direccion correcta 2 = " + direccionIPV6);
                                break;
                            }
                        }
                }
            }
            //************************************************************
            //************************************************************
            System.out.println ("************************************ -->");
            System.out.println ("************************************ -->");
            //************************************************************
            //************************************************************
        }
        
        catch (Exception errorIpv)
        {
            log.info ("Error de resolución = " + errorIpv.getLocalizedMessage());
            errorIpv.printStackTrace();
            return ("127.0.0.1");
        }
        
        return direccionIPV6;
    }
    
}