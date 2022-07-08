/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoRiesgo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class TecnoRiesgoFacade implements TecnoRiesgoFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public void create(TecnoRiesgo tecnoRiesgo) {
        em.persist(tecnoRiesgo);
    }

    public void edit(TecnoRiesgo tecnoRiesgo) {
        em.merge(tecnoRiesgo);
    }

    public void remove(TecnoRiesgo tecnoRiesgo) {
        em.remove(em.merge(tecnoRiesgo));
    }

    public TecnoRiesgo find(Object id) {
        return em.find(TecnoRiesgo.class, id);
    }

    public List<TecnoRiesgo> findAll() {
        return em.createQuery("select object(o) from TecnoRiesgo as o").getResultList();
    }

}
