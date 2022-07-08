/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoDesenlace;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class TecnoDesenlaceFacade implements TecnoDesenlaceFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public void create(TecnoDesenlace tecnoDesenlace) {
        em.persist(tecnoDesenlace);
    }

    public void edit(TecnoDesenlace tecnoDesenlace) {
        em.merge(tecnoDesenlace);
    }

    public void remove(TecnoDesenlace tecnoDesenlace) {
        em.remove(em.merge(tecnoDesenlace));
    }

    public TecnoDesenlace find(Object id) {
        return em.find(TecnoDesenlace.class, id);
    }

    public List<TecnoDesenlace> findAll() {
        return em.createQuery("select object(o) from TecnoDesenlace as o").getResultList();
    }

}
