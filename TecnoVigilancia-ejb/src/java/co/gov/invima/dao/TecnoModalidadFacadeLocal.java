/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoModalidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface TecnoModalidadFacadeLocal {

    void create(TecnoModalidad tecnoModalidad);

    void edit(TecnoModalidad tecnoModalidad);

    void remove(TecnoModalidad tecnoModalidad);

    TecnoModalidad find(Object id);

    List<TecnoModalidad> findAll();

}
