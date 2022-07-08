/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoExpAlertas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface TecnoExpAlertasFacadeLocal {

    void create(TecnoExpAlertas tecnoExpAlertas);

    void edit(TecnoExpAlertas tecnoExpAlertas);

    void remove(TecnoExpAlertas tecnoExpAlertas);

    TecnoExpAlertas find(Object id);

    List<TecnoExpAlertas> findAll();
    
    List<TecnoExpAlertas> findByExpediente(Long expediente);
    
    List<String> findAll_id(boolean solo_monitoreo);

}
