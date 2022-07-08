package co.gov.invima.utils;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Clase que se encarga del manejo del correo electronico
 *
 *
 *     
 */
public class CorreoElectronico {
    public static final String CHARSET_UTF8 = "UTF-8";
    public static final String CHARSET_ISO = "ISO-8859-1";
    private static CorreoElectronico instancia = null;
    
    /**
     * Enviar Correo a Tecno Validando Autenticacion
     * @param unDestinatario
     * @param unCC
     * @param unAsunto
     * @param unMensaje
     * @throws Exception 
     */
    public void enviarCorreoElectronicoTecno(String unDestinatario,
                        String unCC, String unAsunto, String unMensaje )throws Exception {
        PropertiesReader pr = new PropertiesReader("co.gov.invima.utils.recursos");
        String autenticacion = pr.getProperty("autenticacion");
        if (autenticacion != null && autenticacion.equals("true")) {
            enviarCorreoAutenticadoTecno(unDestinatario, unCC, unAsunto, unMensaje);
        }
        else{
            enviarCorreoSinAutTecno(unDestinatario, unCC, unAsunto, unMensaje);
        }
    }
    
    /**
     * Enviar correo a Tecno para un usuario Sin Autenticacion
     * @param unDestinatario
     * @param unCC
     * @param unAsunto
     * @param unMensaje
     * @throws Exception 
     */
    private void enviarCorreoSinAutTecno(String unDestinatario,
                        String unCC, String unAsunto, String unMensaje )throws Exception {
        PropertiesReader pr = new PropertiesReader("co.gov.invima.utils.recursos");
        String unServidorCorreo = pr.getProperty("servidor");
        String unRemitente = pr.getProperty("remitente");
        enviar( unServidorCorreo, unRemitente, unDestinatario,
                         unCC,  unAsunto,  unMensaje );
        
    }
    
    /**
     * Enviar correo a Tecno para un usuario autenticado
     * @param unDestinatario
     * @param unCC
     * @param unAsunto
     * @param unMensaje
     * @throws Exception 
     */
    private void enviarCorreoAutenticadoTecno(String unDestinatario,
                        String unCC, String unAsunto, String unMensaje )throws Exception {
        PropertiesReader pr = new PropertiesReader("co.gov.invima.utils.recursos");
        String unServidorCorreo = pr.getProperty("servidor");
        String unRemitente = pr.getProperty("remitente");
        String usuario = pr.getProperty("usuario");
        String password = pr.getProperty("password");
        enviar(unServidorCorreo, unRemitente, usuario, password, unDestinatario, unCC, unAsunto, unMensaje);
    }

    /**
     * 
     * metodo generico que envia un mensaje por correo electronico, sin autenticar
     *
     * @param unServidorCorreo
     * @param unRemitente
     * @param unDestinatario
     * @param unCC
     * @param unAsunto
     * @param unMensaje
     * @throws Exception
     */
    private void enviar( String unServidorCorreo, String unRemitente, String unDestinatario,
                        String unCC, String unAsunto, String unMensaje ) throws Exception {

        // Establecer las propiedades
        Properties misProp = System.getProperties();

        misProp.put("mail.smtp.host", unServidorCorreo);
        misProp.put("mail.transport.protocol", "smtp");
        misProp.put("mail.smtp.timeout", "4000");
        misProp.put("mail.smtp.connectiontimeout", "4000");
        misProp.put("mail.smtp.auth", "false");

        // Abrir la sesion con el servidor de correos
        Session miSesion = Session.getInstance(misProp, null);

        // COnstruir el mensaje del correo
        MimeMessage miMensaje = new MimeMessage(miSesion);

        miMensaje.setFrom(new InternetAddress(unRemitente));
        miMensaje.setRecipients(RecipientType.TO, InternetAddress.parse(unDestinatario, false));

        if ( !unCC.equals("") ) {
            miMensaje.setRecipients(RecipientType.BCC, InternetAddress.parse(unCC, false));
        }

        miMensaje.setSentDate(new Date());
        miMensaje.setSubject(unAsunto, CHARSET_ISO);
        //miMensaje.setText(unMensaje, CHARSET_ISO);
        miMensaje.setContent(unMensaje, "text/html");
        Transport.send(miMensaje);
    }
    
    /**
     * 
     * metodo que envia un mensaje por correo electronico, cuando se requere autenticacion
     *
     * @param unServidorCorreo
     * @param unRemitente
     * @param password
     * @param unDestinatario
     * @param unCC
     * @param unAsunto
     * @param unMensaje
     * @throws Exception
     */
    private void enviar( String unServidorCorreo, String unRemitente, String usuario, String password, String unDestinatario,
                        String unCC, String unAsunto, String unMensaje ) throws Exception {

        // Establecer las propiedades
        Properties misProp = System.getProperties();

        misProp.setProperty("mail.smtp.host", unServidorCorreo);
        misProp.setProperty("mail.transport.protocol", "smtp");
        misProp.setProperty("mail.smtp.timeout", "4000");
        misProp.setProperty("mail.smtp.connectiontimeout", "4000");
        misProp.setProperty("mail.smtp.user", usuario);
        misProp.setProperty("mail.smtp.auth", "true");

        // Abrir la sesion con el servidor de correos
        Session miSesion = Session.getInstance(misProp);
        // Construir el mensaje del correo
        MimeMessage miMensaje = new MimeMessage(miSesion);

        miMensaje.setFrom(new InternetAddress(unRemitente));
        miMensaje.setRecipients(RecipientType.TO, InternetAddress.parse(unDestinatario, false));

        if ( !unCC.equals("") ) {
            miMensaje.setRecipients(RecipientType.BCC, InternetAddress.parse(unCC, false));
        }

        miMensaje.setSentDate(new Date());
        miMensaje.setSubject(unAsunto, CHARSET_ISO);
        miMensaje.setContent(unMensaje, "text/html");
        //miMensaje.setText(unMensaje, "ISO-8859-1","html");
        Transport t = miSesion.getTransport("smtp");
        t.connect(unServidorCorreo,usuario,password);
        t.sendMessage(miMensaje,miMensaje.getAllRecipients());
        t.close();
    }

    //~--- get methods -----------------------------------------------------------------------------

    /**
     * Devuelve la instancia unica 
     *
     * @return
     */
    public synchronized static final CorreoElectronico getInstance( ) {
        if ( instancia==null ) {
            instancia = new CorreoElectronico();
        }

        return instancia;
    }
}
