/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.dao;

import co.gov.invima.entidad.WTecnoProducto;
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
public class WTecnoProductoFacade extends AbstractFacade<WTecnoProducto> {

    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WTecnoProductoFacade() {
        super(WTecnoProducto.class);
    }
    
    public List<WTecnoProducto> findByExpediente(Long expediente) {
        Query q = em.createNamedQuery("WTecnoProducto.findByNroexpediente");
        q.setParameter("nroexpediente", expediente);
        return q.getResultList();
    }
    
}
