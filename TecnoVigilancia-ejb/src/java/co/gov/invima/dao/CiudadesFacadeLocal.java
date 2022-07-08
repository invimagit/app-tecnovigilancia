/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.dao;

import co.gov.invima.entidad.Ciudades;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mgualdrond
 */
@Local
public interface CiudadesFacadeLocal {

    void create(Ciudades ciudades);

    void edit(Ciudades ciudades);

    void remove(Ciudades ciudades);

    Ciudades find(Object id);

    List<Ciudades> findAll();

    List<Ciudades> findRange(int[] range);

    int count();

    public Ciudades obtenerCiudadPorDptoYNombre(String cdgterritorio, String ciudad);

    public Ciudades obtenerCiudadPorDptoYCiudad(String cdgTerritorio, String codMun);

    public List<Ciudades> obtenerCiudadPorDepartamento(String cdgTerritorio);
    
}
