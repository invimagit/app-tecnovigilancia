/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoEvaluacionCaso;
import co.gov.invima.entidad.TecnoPaciente;
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
public class TecnoPacienteFacade implements TecnoPacienteFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public void create(TecnoPaciente tecnoPaciente) {
        em.persist(tecnoPaciente);
    }

    public void edit(TecnoPaciente tecnoPaciente) {
        em.merge(tecnoPaciente);
    }

    public void remove(TecnoPaciente tecnoPaciente) {
        em.remove(em.merge(tecnoPaciente));
    }

    public TecnoPaciente find(Object id) {
        return em.find(TecnoPaciente.class, id);
    }

    public List<TecnoPaciente> findAll() {
        return em.createQuery("select object(o) from TecnoPaciente as o").getResultList();
    }
    
    public TecnoPaciente findByReporte(String consec) {
        Query q = em.createNamedQuery("TecnoPaciente.findByReporte");
        q.setParameter("reporte", consec);
        if(q.getResultList().size()>0){
            return (TecnoPaciente) q.getResultList().get(0);
        }
        else{
            return null;
        }
    }

}
