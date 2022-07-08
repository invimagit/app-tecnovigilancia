/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.Departamentos;
import co.gov.invima.negocio.ReporteBean;
import java.util.List;
import org.apache.log4j.Logger;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class DepartamentosFacade implements DepartamentosFacadeLocal 
{
    
    private final static Logger logEJBTecno = Logger.getLogger(DepartamentosFacade.class.getName());
    
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    @Override
    public void create(Departamentos departamentos) {
        em.persist(departamentos);
    }

    @Override
    public void edit(Departamentos departamentos) {
        em.merge(departamentos);
    }

    @Override
    public void remove(Departamentos departamentos) {
        em.remove(em.merge(departamentos));
    }

    @Override
    public Departamentos find(Object id) {
        return em.find(Departamentos.class, id);
    }
    /*************************************************************************/
    /*************************************************************************/
    /*************************************************************************/
    @Override
    public List<Departamentos> findAll() {
        
        //logEJBTecno.info ("*********************************************");
        //logEJBTecno.info ("*********************************************");
        //logEJBTecno.info ("ESTADO DEL EM = " + em);
        List<Departamentos> registros = null;
        
        if (em != null)
        {
            registros = em.createQuery("select object(o) from Departamentos as o").getResultList();
        }
        
        //logEJBTecno.info ("Estado de los registros = " + registros);
        //logEJBTecno.info ("*********************************************");
        //logEJBTecno.info ("*********************************************");
        return (registros);
    }
    /*************************************************************************/
    /*************************************************************************/
    /*************************************************************************/
}
