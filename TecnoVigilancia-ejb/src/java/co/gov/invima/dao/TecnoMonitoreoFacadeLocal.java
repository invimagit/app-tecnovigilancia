/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoMonitoreo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface TecnoMonitoreoFacadeLocal {

    void create(TecnoMonitoreo tecnoMonitoreo);

    void edit(TecnoMonitoreo tecnoMonitoreo);

    void remove(TecnoMonitoreo tecnoMonitoreo);

    TecnoMonitoreo find(Object id);

    List<TecnoMonitoreo> findAll();

}
