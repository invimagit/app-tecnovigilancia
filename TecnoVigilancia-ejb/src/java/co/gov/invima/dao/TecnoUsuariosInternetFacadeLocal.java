/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoUsuariosInternet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface TecnoUsuariosInternetFacadeLocal {

    void create(TecnoUsuariosInternet tecnoUsuariosInternet);

    void edit(TecnoUsuariosInternet tecnoUsuariosInternet);

    void remove(TecnoUsuariosInternet tecnoUsuariosInternet);

    TecnoUsuariosInternet find(Object id);

    List<TecnoUsuariosInternet> findAll();

    public TecnoUsuariosInternet buscarPorUsuario(String usu);

    public boolean esUsuarioDeBD(String usuario, String clave, String conexion);

    public List<TecnoUsuariosInternet> buscarPorCedula(String identificacionPersona);

    public List<TecnoUsuariosInternet> buscarPorNombrePersona(String nombrePersona);

    public List<TecnoUsuariosInternet> buscarPorEstadoUsuario(Character estadoUsuario);
    
    List<TecnoUsuariosInternet> findAll_funcionarios(boolean rol_invima, boolean rol_4);

}
