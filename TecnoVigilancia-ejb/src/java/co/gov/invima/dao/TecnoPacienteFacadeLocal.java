/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoPaciente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface TecnoPacienteFacadeLocal {

    void create(TecnoPaciente tecnoPaciente);

    void edit(TecnoPaciente tecnoPaciente);

    void remove(TecnoPaciente tecnoPaciente);

    TecnoPaciente find(Object id);

    List<TecnoPaciente> findAll();
    
    TecnoPaciente findByReporte(String consec);

}
