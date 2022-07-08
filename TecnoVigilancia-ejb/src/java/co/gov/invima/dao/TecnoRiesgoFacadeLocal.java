/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoRiesgo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface TecnoRiesgoFacadeLocal {

    void create(TecnoRiesgo tecnoRiesgo);

    void edit(TecnoRiesgo tecnoRiesgo);

    void remove(TecnoRiesgo tecnoRiesgo);

    TecnoRiesgo find(Object id);

    List<TecnoRiesgo> findAll();

}
