/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoAreas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mgualdrond
 */
@Local
public interface TecnoAreasFacadeLocal {

    void create(TecnoAreas tecnoAreas);

    void edit(TecnoAreas tecnoAreas);

    void remove(TecnoAreas tecnoAreas);

    TecnoAreas find(Object id);

    List<TecnoAreas> findAll();

    List<TecnoAreas> findRange(int[] range);

    int count();
    
}
