/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoUsuariosInternet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Priority;

/**
 *
 * @author Administrador
 */
@Stateless
public class TecnoUsuariosInternetFacade extends AbstractTecnoVickilanciaFacade<TecnoUsuariosInternet> implements TecnoUsuariosInternetFacadeLocal {

    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public TecnoUsuariosInternetFacade() {
        super(TecnoUsuariosInternet.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public TecnoUsuariosInternet buscarPorUsuario(String usu) {
        TecnoUsuariosInternet internet = null;
        try {
            Query q = em.createNativeQuery("SELECT * FROM tecno_usuarios_internet where UPPER(usuario)=UPPER(:usuario)",
                     TecnoUsuariosInternet.class);
            //"SELECT t FROM TecnoUsuariosInternet t WHERE t.usuario = :usuario");
            q.setParameter("usuario", usu);
            List<TecnoUsuariosInternet> internets = q.getResultList();
            if (internets != null && !internets.isEmpty()) {
                internet = internets.get(0);
            }
        } catch (Exception e) {
            Logger.getLogger(TecnoUsuariosInternetFacade.class.getName()).log(Priority.ERROR, "Error al obtener datos de usuario", e);
        } finally {
            return internet;
        }
    }

    @Override
    public List<TecnoUsuariosInternet> buscarPorCedula(String identificacionPersona) {
        Query q = em.createQuery("SELECT t FROM TecnoUsuariosInternet t WHERE t.identificacionPersona = :identificacionPersona ORDER BY t.nombrePersona ASC");
        q.setParameter("identificacionPersona", Long.parseLong(identificacionPersona));
        return q.getResultList();
    }

    @Override
    public List<TecnoUsuariosInternet> buscarPorNombrePersona(String nombrePersona) {
        nombrePersona = "%" + nombrePersona + "%";
        Query q = em.createQuery("SELECT t FROM TecnoUsuariosInternet t WHERE t.nombrePersona like :nombrePersona ORDER BY t.nombrePersona ASC");
        q.setParameter("nombrePersona", nombrePersona);
        return q.getResultList();
    }

    @Override
    public List<TecnoUsuariosInternet> buscarPorEstadoUsuario(Character estadoUsuario) {
        String consulta = "";
        Query q = null;
        if (estadoUsuario != null) {
            consulta = "SELECT t FROM TecnoUsuariosInternet t WHERE t.estadoUsuario = :estadoUsuario ORDER BY t.nombrePersona ASC";
            q = em.createQuery(consulta);
            q.setParameter("estadoUsuario", estadoUsuario);
        } else {
            consulta = "SELECT t FROM TecnoUsuariosInternet t WHERE t.estadoUsuario is null ORDER BY t.nombrePersona ASC";
            q = em.createQuery(consulta);
        }
        return q.getResultList();
    }

    @Override
    public boolean esUsuarioDeBD(String usuario, String clave, String conexion) {

        try {
            // *****************************************************************
            // En las siguientes líneas remueva el comentario de la línea
            // 'Class.forName' según la versión de jConnect que vaya a usar:
            // *****************************************************************

            // Para usar jConnect 4.2:
            //Class.forName("com.sybase.jdbc.SybDriver");
            // Para usar jConnect 5.2:
            //Class.forName("com.sybase.jdbc2.jdbc.SybDriver");
            // Para usar jConnect 6.0:
            //Class.forName("com.sybase.jdbc3.jdbc.SybDriver");
            // Para usar SQL Server:
            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            // *****************************************************************
            // En las siguientes líneas se definen las propiedades de la
            // conexión. Reemplace:
            // <user>: Usuario en la base de datos
            // <passwd>: Contraseña
            // Puede incluir otras propiedades, como CHARSET, HOSTNAME,
            // APPLICATIONNAME, etc.
            // *****************************************************************
            Properties props = new Properties();
            props.put("user", usuario);
            props.put("password", clave);

            // *****************************************************************
            // En la siguiente línea se define el URL (dirección) del servidor
            // de base de datos. Reemplace:
            // <host>: Dirección IP o nombre de la máquina donde corre la base de datos
            // <port>: Puerto del servidor de base de datos
            // *****************************************************************
            //String url = "jdbc:sybase:Tds:172.27.113.187:5000";
            //String url = "jdbc:sybase:Tds:" + conexion;
            String url = "jdbc:jtds:sqlserver://" + conexion;
            /*
            //logEJBTecno.info  ("URI CONEXION SYBASE = " + url);
            //logEJBTecno.info  ("user = " + usuario);
            //logEJBTecno.info  ("clave = " + clave);
            */
            // *****************************************************************
            // En la siguiente línea se establece la conexión, usando la
            // dirección y propiedades previamente definidas:
            // *****************************************************************
            Connection conn = DriverManager.getConnection(url, props);

            // *****************************************************************
            // En las siguientes líneas se crea y ejecuta la sentencia SQL. La
            // ejecución crea también un conjunto resultado.
            // *****************************************************************
            //Statement stmt = conn.createStatement();
            //ResultSet rs = stmt.executeQuery( "SELECT emp_id, emp_name, emp_lastname FROM employee");
            // *****************************************************************
            // En las siguientes líneas se procesa el conjunto resultado, fila
            // por fila:
            // *****************************************************************
            //while ( rs.next( ) ) {
            //logEJBTecno.info ( "ID: " + rs.getString(1) + " Nombre: " + rs.getString(2) + " Apellido: " + rs.getString(3) );
            //}
            // *****************************************************************
            // Finalmente, se liberan los recursos y se cierra la conexión:
            // *****************************************************************
            //rs.close();
            //stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(TecnoUsuariosInternetFacade.class.getName()).log(Priority.INFO, "Autenticación fallida en TecnoUsuariosInternetFacade.esUsuarioDeBD,"+e.getStackTrace()[0] );
            return false;
        }
        return true;
    }
    
    @Override
    public List<TecnoUsuariosInternet> findAll_funcionarios(boolean rol_invima, boolean rol_4) {
        String condicion_rol="";
        if(rol_4){
            condicion_rol+=" t.iDRolUsuario = 4 ";
        }
        
        if(rol_4 && rol_invima){
            condicion_rol+=" OR ";
        }
        
        if(rol_invima){
            condicion_rol+=" t.iDRolUsuario = 1 ";
        }
        
        Query q = em.createQuery("SELECT t FROM TecnoUsuariosInternet t WHERE ("+condicion_rol+") AND t.estadoUsuario = 'A' ORDER BY t.nombrePersona ASC");
        return q.getResultList();
    }

}
