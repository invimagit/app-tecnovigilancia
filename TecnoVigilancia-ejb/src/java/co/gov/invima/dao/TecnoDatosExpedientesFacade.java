/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoDatosExpedientes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class TecnoDatosExpedientesFacade implements TecnoDatosExpedientesFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public void create(TecnoDatosExpedientes tecnoDatosExpedientes) {
        em.persist(tecnoDatosExpedientes);
    }

    public void edit(TecnoDatosExpedientes tecnoDatosExpedientes) {
        em.merge(tecnoDatosExpedientes);
    }

    public void remove(TecnoDatosExpedientes tecnoDatosExpedientes) {
        em.remove(em.merge(tecnoDatosExpedientes));
    }

    public TecnoDatosExpedientes find(Object id) {
        return em.find(TecnoDatosExpedientes.class, id);
    }

    public List<TecnoDatosExpedientes> findAll() {
        return em.createQuery("select object(o) from TecnoDatosExpedientes as o").getResultList();
    }

}
