/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoMonitoreo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class TecnoMonitoreoFacade implements TecnoMonitoreoFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public void create(TecnoMonitoreo tecnoMonitoreo) {
        em.persist(tecnoMonitoreo);
    }

    public void edit(TecnoMonitoreo tecnoMonitoreo) {
        em.merge(tecnoMonitoreo);
    }

    public void remove(TecnoMonitoreo tecnoMonitoreo) {
        em.remove(em.merge(tecnoMonitoreo));
    }

    public TecnoMonitoreo find(Object id) {
        return em.find(TecnoMonitoreo.class, id);
    }

    public List<TecnoMonitoreo> findAll() {
        return em.createQuery("select object(o) from TecnoMonitoreo as o").getResultList();
    }

}
