/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoTipoalertas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class TecnoTipoalertasFacade implements TecnoTipoalertasFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public void create(TecnoTipoalertas tecnoTipoalertas) {
        em.persist(tecnoTipoalertas);
    }

    public void edit(TecnoTipoalertas tecnoTipoalertas) {
        em.merge(tecnoTipoalertas);
    }

    public void remove(TecnoTipoalertas tecnoTipoalertas) {
        em.remove(em.merge(tecnoTipoalertas));
    }

    public TecnoTipoalertas find(Object id) {
        return em.find(TecnoTipoalertas.class, id);
    }

    public List<TecnoTipoalertas> findAll() {
        return em.createQuery("select object(o) from TecnoTipoalertas as o").getResultList();
    }

}
