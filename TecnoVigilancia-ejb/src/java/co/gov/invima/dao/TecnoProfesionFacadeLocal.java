/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoProfesion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface TecnoProfesionFacadeLocal {

    void create(TecnoProfesion tecnoProfesion);

    void edit(TecnoProfesion tecnoProfesion);

    void remove(TecnoProfesion tecnoProfesion);

    TecnoProfesion find(Object id);

    List<TecnoProfesion> findAll();

}
