/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoRolesReporte;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jonat
 */
@Stateless
public class TecnoRolesReporteFacade extends AbstractFacade<TecnoRolesReporte> {

    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TecnoRolesReporteFacade() {
        super(TecnoRolesReporte.class);
    }
    
    public List<TecnoRolesReporte> findByExpediente(Long expediente) {
        Query q = em.createNamedQuery("TecnoRolesReporte.findByNroexpediente");
        q.setParameter("nroexpediente", expediente);
        return q.getResultList();
    }
    
}
