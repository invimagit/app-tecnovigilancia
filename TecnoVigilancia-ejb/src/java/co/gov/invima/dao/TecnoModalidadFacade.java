/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoModalidad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class TecnoModalidadFacade implements TecnoModalidadFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public void create(TecnoModalidad tecnoModalidad) {
        em.persist(tecnoModalidad);
    }

    public void edit(TecnoModalidad tecnoModalidad) {
        em.merge(tecnoModalidad);
    }

    public void remove(TecnoModalidad tecnoModalidad) {
        em.remove(em.merge(tecnoModalidad));
    }

    public TecnoModalidad find(Object id) {
        return em.find(TecnoModalidad.class, id);
    }

    public List<TecnoModalidad> findAll() {
        return em.createQuery("select object(o) from TecnoModalidad as o").getResultList();
    }

}
