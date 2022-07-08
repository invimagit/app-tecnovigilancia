/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoConsec;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface TecnoConsecFacadeLocal {

    void create(TecnoConsec tecnoConsec);

    void edit(TecnoConsec tecnoConsec);

    void remove(TecnoConsec tecnoConsec);

    TecnoConsec find(Object id);

    List<TecnoConsec> findAll();

}
