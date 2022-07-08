/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoDispositivo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class TecnoDispositivoFacade implements TecnoDispositivoFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public void create(TecnoDispositivo tecnoDispositivo) {
        em.persist(tecnoDispositivo);
    }

    public void edit(TecnoDispositivo tecnoDispositivo) {
        em.merge(tecnoDispositivo);
    }

    public void remove(TecnoDispositivo tecnoDispositivo) {
        em.remove(em.merge(tecnoDispositivo));
    }

    public TecnoDispositivo find(Object id) {
        return em.find(TecnoDispositivo.class, id);
    }

    public List<TecnoDispositivo> findAll() {
        return em.createQuery("select object(o) from TecnoDispositivo as o").getResultList();
    }
    
    public TecnoDispositivo findByReporte(String consec) {
        Query q = em.createNamedQuery("TecnoDispositivo.findByReporte");
        q.setParameter("reporte", consec);
        
        if(q.getResultList().size()>0){
            return (TecnoDispositivo) q.getResultList().get(0);
        }
        else{
            return null;
        }
    }

}
