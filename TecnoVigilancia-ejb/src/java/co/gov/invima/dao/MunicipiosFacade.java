/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.Municipios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class MunicipiosFacade implements MunicipiosFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    @Override
    public void create(Municipios municipios) {
        em.persist(municipios);
    }

    @Override
    public void edit(Municipios municipios) {
        em.merge(municipios);
    }

    @Override
    public void remove(Municipios municipios) {
        em.remove(em.merge(municipios));
    }

    @Override
    public Municipios find(Object id) {
        return em.find(Municipios.class, id);
    }

    @Override
    public List<Municipios> findAll() {
        return em.createQuery("select object(o) from Municipios as o").getResultList();
    }

    @Override
    public List<Municipios> buscarPorDepartamento(String idDepto){
        Query q = em.createQuery("select object(o) from Municipios as o where o.codDepart.codDepart = :valor");
        q.setParameter("valor", idDepto);
        return q.getResultList();
    }

}
