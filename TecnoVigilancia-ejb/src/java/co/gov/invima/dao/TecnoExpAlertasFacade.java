/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoExpAlertas;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/**
 *
 * @author Diana Silva
 * @version MIGD
 */


@Stateless
public class TecnoExpAlertasFacade implements TecnoExpAlertasFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;
    private static final Logger logEJBReactivo = Logger.getLogger(TecnoExpAlertasFacadeLocal.class.getName());

    @Override
    public void create(TecnoExpAlertas tecnoExpAlertas) {
        em.persist(tecnoExpAlertas);
    }

    @Override
    public void edit(TecnoExpAlertas tecnoExpAlertas) {
        em.merge(tecnoExpAlertas);
    }

    @Override
    public void remove(TecnoExpAlertas tecnoExpAlertas) {
        em.remove(em.merge(tecnoExpAlertas));
    }

    @Override
    public TecnoExpAlertas find(Object id) {
        return em.find(TecnoExpAlertas.class, id);
    }

    /**
     *
     * @return
     */
    @Override
    public List<TecnoExpAlertas> findAll() {
        return em.createQuery("select object(o) from TecnoExpAlertas as o").getResultList();
    }
    
    @Override
    public List<TecnoExpAlertas> findByExpediente(Long expediente) {
        Query q = em.createNamedQuery("TecnoExpAlertas.findByExpedienteDm");
        q.setParameter("expedienteDm", expediente);
        return q.getResultList();
    }
    
    @Override
    public List<String> findAll_id(boolean solo_monitoreo) {
        List<String> retorno = new ArrayList<String>();
        try {
            String sqlString;
            if(solo_monitoreo){
                sqlString = "SELECT TOP (100) risarh from (SELECT risarh,fecha_ingreso FROM tecno_monitoreo ) a order by fecha_ingreso desc";
            }
            else{
                sqlString = "SELECT TOP (100) risarh from" +
                            "   (SELECT risarh,format(fecha_ingreso,'yyyyMMdd') fecha_ingreso FROM tecno_exp_alertas UNION SELECT risarh,format(fecha_ingreso,'yyyyMMdd') fecha_ingreso FROM tecno_monitoreo ) a " +
                            " order by fecha_ingreso desc";
            }
            Query q = em.createNativeQuery(sqlString);

            List<String> list = q.getResultList();

            for(String q1 : list){
                String temp = q1.toString();
                retorno.add(temp);
            }
                logEJBReactivo.log(Priority.INFO, "TecnoExpAlertasFacadeLocal, findAll_id retorno.size(): "+retorno.size() );
 
        } catch (Exception e) {
            logEJBReactivo.log(Priority.ERROR, "TecnoExpAlertasFacadeLocal, findAll_id CAtch: ", e);
        } finally {
            return retorno;
        }
    }
    
    
            

}
