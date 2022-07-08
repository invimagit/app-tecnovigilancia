/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.Parametros;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface ParametrosFacadeLocal {

    void create(Parametros parametros);

    void edit(Parametros parametros);

    void remove(Parametros parametros);

    Parametros find(Object id);

    List<Parametros> findAll();

}
