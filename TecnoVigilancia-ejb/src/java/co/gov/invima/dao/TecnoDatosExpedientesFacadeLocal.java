/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoDatosExpedientes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface TecnoDatosExpedientesFacadeLocal {

    void create(TecnoDatosExpedientes tecnoDatosExpedientes);

    void edit(TecnoDatosExpedientes tecnoDatosExpedientes);

    void remove(TecnoDatosExpedientes tecnoDatosExpedientes);

    TecnoDatosExpedientes find(Object id);

    List<TecnoDatosExpedientes> findAll();

}
