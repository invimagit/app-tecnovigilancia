/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoRoles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mgualdrond
 */
@Local
public interface TecnoRolesFacadeLocal {

    void create(TecnoRoles tecnoRoles);

    void edit(TecnoRoles tecnoRoles);

    void remove(TecnoRoles tecnoRoles);

    TecnoRoles find(Object id);

    List<TecnoRoles> findAll();

    List<TecnoRoles> findRange(int[] range);

    int count();
    
}
