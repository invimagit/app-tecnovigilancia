/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoConsec;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class TecnoConsecFacade implements TecnoConsecFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    @Override
    public void create(TecnoConsec tecnoConsec) {
        em.persist(tecnoConsec);
    }

    @Override
    public void edit(TecnoConsec tecnoConsec) {
        em.merge(tecnoConsec);
    }

    @Override
    public void remove(TecnoConsec tecnoConsec) {
        em.remove(em.merge(tecnoConsec));
    }

    @Override
    public TecnoConsec find(Object id) {
        return em.find(TecnoConsec.class, id);
    }

    @Override
    public List<TecnoConsec> findAll() {
        return em.createQuery("select object(o) from TecnoConsec as o").getResultList();
    }

}
