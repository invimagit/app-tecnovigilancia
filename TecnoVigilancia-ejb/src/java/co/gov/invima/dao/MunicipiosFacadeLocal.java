/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.Municipios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface MunicipiosFacadeLocal {

    void create(Municipios municipios);

    void edit(Municipios municipios);

    void remove(Municipios municipios);

    Municipios find(Object id);

    List<Municipios> findAll();

    public java.util.List<co.gov.invima.entidad.Municipios> buscarPorDepartamento(java.lang.String idDepto);

}
