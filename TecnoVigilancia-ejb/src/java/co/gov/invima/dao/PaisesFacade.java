/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.Paises;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class PaisesFacade implements PaisesFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    @Override
    public void create(Paises paises) {
        em.persist(paises);
    }

    @Override
    public void edit(Paises paises) {
        em.merge(paises);
    }

    @Override
    public void remove(Paises paises) {
        em.remove(em.merge(paises));
    }

    @Override
    public Paises find(Object id) {
        return em.find(Paises.class, id);
    }

    @Override
    public List<Paises> findAll() {
        return em.createQuery("select object(o) from Paises as o").getResultList();
    }

}
