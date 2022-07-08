/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoDesenlace;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface TecnoDesenlaceFacadeLocal {

    void create(TecnoDesenlace tecnoDesenlace);

    void edit(TecnoDesenlace tecnoDesenlace);

    void remove(TecnoDesenlace tecnoDesenlace);

    TecnoDesenlace find(Object id);

    List<TecnoDesenlace> findAll();

}
