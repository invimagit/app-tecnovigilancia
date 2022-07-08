/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.VTiposdocumentos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class VTiposdocumentosFacade implements VTiposdocumentosFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public void create(VTiposdocumentos vTiposdocumentos) {
        em.persist(vTiposdocumentos);
    }

    public void edit(VTiposdocumentos vTiposdocumentos) {
        em.merge(vTiposdocumentos);
    }

    public void remove(VTiposdocumentos vTiposdocumentos) {
        em.remove(em.merge(vTiposdocumentos));
    }

    public VTiposdocumentos find(Object id) {
        return em.find(VTiposdocumentos.class, id);
    }

    public List<VTiposdocumentos> findAll() {
        return em.createQuery("select object(o) from VTiposdocumentos as o").getResultList();
    }

}
