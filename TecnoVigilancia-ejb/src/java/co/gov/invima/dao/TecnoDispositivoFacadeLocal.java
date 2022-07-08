/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoDispositivo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface TecnoDispositivoFacadeLocal {

    void create(TecnoDispositivo tecnoDispositivo);

    void edit(TecnoDispositivo tecnoDispositivo);

    void remove(TecnoDispositivo tecnoDispositivo);

    TecnoDispositivo find(Object id);

    List<TecnoDispositivo> findAll();
    
    TecnoDispositivo findByReporte(String consec) ;

}
