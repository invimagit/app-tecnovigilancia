/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoEvaluacionCasoTemp;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class TecnoEvaluacionCasoTempFacade implements TecnoEvaluacionCasoTempFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public void create(TecnoEvaluacionCasoTemp tecnoDispositivo) {
        em.persist(tecnoDispositivo);
    }

    public void edit(TecnoEvaluacionCasoTemp tecnoDispositivo) {
        em.merge(tecnoDispositivo);
    }

    public void remove(TecnoEvaluacionCasoTemp tecnoDispositivo) {
        em.remove(em.merge(tecnoDispositivo));
    }

    public TecnoEvaluacionCasoTemp find(Object id) {
        return em.find(TecnoEvaluacionCasoTemp.class, id);
    }

    public List<TecnoEvaluacionCasoTemp> findAll() {
        return em.createQuery("select object(o) from TecnoEvaluacionCasoTemp as o").getResultList();
    }
}
