/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoRed;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface TecnoRedFacadeLocal {

    void create(TecnoRed tecnoRed);

    void edit(TecnoRed tecnoRed);

    void remove(TecnoRed tecnoRed);

    TecnoRed find(Object id);

    List<TecnoRed> findAll();

    int buscarMaxId();
    
    ArrayList<String> findAll_id();

}
