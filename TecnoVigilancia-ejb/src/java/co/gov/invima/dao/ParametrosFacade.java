/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.Parametros;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class ParametrosFacade implements ParametrosFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    @Override
    public void create(Parametros parametros) {
        em.persist(parametros);
    }

    @Override
    public void edit(Parametros parametros) {
        em.merge(parametros);
    }

    @Override
    public void remove(Parametros parametros) {
        em.remove(em.merge(parametros));
    }

    @Override
    public Parametros find(Object id) {
        return em.find(Parametros.class, id);
    }

    @Override
    public List<Parametros> findAll() {
        return em.createQuery("select object(o) from Parametros as o").getResultList();
    }

}
