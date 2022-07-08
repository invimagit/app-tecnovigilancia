/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoUsuarios;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface TecnoUsuariosFacadeLocal {

    void create(TecnoUsuarios tecnoUsuarios);

    void edit(TecnoUsuarios tecnoUsuarios);

    void remove(TecnoUsuarios tecnoUsuarios);

    TecnoUsuarios find(Object id);

    List<TecnoUsuarios> findAll();

    public int buscarMaxId();
    
    ArrayList<String> findAll_id();

}
