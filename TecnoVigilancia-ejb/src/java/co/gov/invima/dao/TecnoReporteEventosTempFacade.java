/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoReporteEventosTemp;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class TecnoReporteEventosTempFacade implements TecnoReporteEventosTempFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public void create(TecnoReporteEventosTemp tecnoDispositivo) {
        em.persist(tecnoDispositivo);
    }

    public void edit(TecnoReporteEventosTemp tecnoDispositivo) {
        em.merge(tecnoDispositivo);
    }

    public void remove(TecnoReporteEventosTemp tecnoDispositivo) {
        em.remove(em.merge(tecnoDispositivo));
    }

    public TecnoReporteEventosTemp find(Object id) {
        return em.find(TecnoReporteEventosTemp.class, id);
    }

    public List<TecnoReporteEventosTemp> findAll() {
        return em.createQuery("select object(o) from TecnoReporteEventosTemp as o").getResultList();
    }
}
