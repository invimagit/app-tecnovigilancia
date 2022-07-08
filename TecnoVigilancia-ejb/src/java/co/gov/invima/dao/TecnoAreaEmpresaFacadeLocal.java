/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoAreaEmpresa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mgualdrond
 */
@Local
public interface TecnoAreaEmpresaFacadeLocal {

    void create(TecnoAreaEmpresa tecnoAreaEmpresa);

    void edit(TecnoAreaEmpresa tecnoAreaEmpresa);

    void remove(TecnoAreaEmpresa tecnoAreaEmpresa);

    TecnoAreaEmpresa find(Object id);

    List<TecnoAreaEmpresa> findAll();

    List<TecnoAreaEmpresa> findRange(int[] range);

    int count();
    
}
