/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoCausaProbable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface TecnoCausaProbableFacadeLocal {

    void create(TecnoCausaProbable tecnoCausaProbable);

    void edit(TecnoCausaProbable tecnoCausaProbable);

    void remove(TecnoCausaProbable tecnoCausaProbable);

    TecnoCausaProbable find(Object id);

    List<TecnoCausaProbable> findAll();

}
