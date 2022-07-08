/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoCausaProbable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class TecnoCausaProbableFacade implements TecnoCausaProbableFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    @Override
    public void create(TecnoCausaProbable tecnoCausaProbable) {
        em.persist(tecnoCausaProbable);
    }

    @Override
    public void edit(TecnoCausaProbable tecnoCausaProbable) {
        em.merge(tecnoCausaProbable);
    }

    @Override
    public void remove(TecnoCausaProbable tecnoCausaProbable) {
        em.remove(em.merge(tecnoCausaProbable));
    }

    @Override
    public TecnoCausaProbable find(Object id) {
        return em.find(TecnoCausaProbable.class, id);
    }

    @Override
    public List<TecnoCausaProbable> findAll() {
        return em.createQuery("select object(o) from TecnoCausaProbable as o").getResultList();
    }

}
