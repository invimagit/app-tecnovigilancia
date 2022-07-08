/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoMenus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mgualdrond
 */
@Local
public interface TecnoMenusFacadeLocal {

    void create(TecnoMenus tecnoMenus);

    void edit(TecnoMenus tecnoMenus);

    void remove(TecnoMenus tecnoMenus);

    TecnoMenus find(Object id);

    List<TecnoMenus> findAll();

    List<TecnoMenus> findRange(int[] range);

    int count();

    public List<TecnoMenus> obtenerMenusPorRol(Integer rol);
    
}
