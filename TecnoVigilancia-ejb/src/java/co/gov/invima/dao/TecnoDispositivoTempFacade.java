/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoDispositivoTemp;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class TecnoDispositivoTempFacade implements TecnoDispositivoTempFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public void create(TecnoDispositivoTemp tecnoDispositivo) {
        em.persist(tecnoDispositivo);
    }

    public void edit(TecnoDispositivoTemp tecnoDispositivo) {
        em.merge(tecnoDispositivo);
    }

    public void remove(TecnoDispositivoTemp tecnoDispositivo) {
        em.remove(em.merge(tecnoDispositivo));
    }

    public TecnoDispositivoTemp find(Object id) {
        return em.find(TecnoDispositivoTemp.class, id);
    }

    public List<TecnoDispositivoTemp> findAll() {
        return em.createQuery("select object(o) from TecnoDispositivoTemp as o").getResultList();
    }
}
