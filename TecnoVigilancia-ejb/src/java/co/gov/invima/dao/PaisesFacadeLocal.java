/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.Paises;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface PaisesFacadeLocal {

    void create(Paises paises);

    void edit(Paises paises);

    void remove(Paises paises);

    Paises find(Object id);

    List<Paises> findAll();

}
