/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoProfesion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class TecnoProfesionFacade implements TecnoProfesionFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public void create(TecnoProfesion tecnoProfesion) {
        em.persist(tecnoProfesion);
    }

    public void edit(TecnoProfesion tecnoProfesion) {
        em.merge(tecnoProfesion);
    }

    public void remove(TecnoProfesion tecnoProfesion) {
        em.remove(em.merge(tecnoProfesion));
    }

    public TecnoProfesion find(Object id) {
        return em.find(TecnoProfesion.class, id);
    }

    public List<TecnoProfesion> findAll() {
        return em.createQuery("select object(o) from TecnoProfesion as o").getResultList();
    }

}
