/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoTipoalertas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface TecnoTipoalertasFacadeLocal {

    void create(TecnoTipoalertas tecnoTipoalertas);

    void edit(TecnoTipoalertas tecnoTipoalertas);

    void remove(TecnoTipoalertas tecnoTipoalertas);

    TecnoTipoalertas find(Object id);

    List<TecnoTipoalertas> findAll();

}
