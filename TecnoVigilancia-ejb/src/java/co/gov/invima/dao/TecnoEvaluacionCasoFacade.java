/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoEvaluacionCaso;
import java.util.ArrayList;
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
public class TecnoEvaluacionCasoFacade implements TecnoEvaluacionCasoFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public void create(TecnoEvaluacionCaso tecnoEvaluacionCaso) {
        em.persist(tecnoEvaluacionCaso);
    }

    public void edit(TecnoEvaluacionCaso tecnoEvaluacionCaso) {
        em.merge(tecnoEvaluacionCaso);
    }

    public void remove(TecnoEvaluacionCaso tecnoEvaluacionCaso) {
        em.remove(em.merge(tecnoEvaluacionCaso));
    }

    public TecnoEvaluacionCaso find(Object id) {
        return em.find(TecnoEvaluacionCaso.class, id);
    }

    public List<TecnoEvaluacionCaso> findAll() {
        return em.createQuery("select object(o) from TecnoEvaluacionCaso as o").getResultList();
    }
    
    public ArrayList<String> findAll_id() {
        ArrayList<String> retorno = new ArrayList <String>();
        try {
            String sqlString = "SELECT DISTINCT TOP (100)   reporte FROM (SELECT reporte FROM tecno_reporte_eventos  UNION SELECT reporte FROM  tecno_evaluacion_caso UNION SELECT reporte FROM tecno_paciente  UNION SELECT reporte FROM tecno_dispositivo) a order by reporte desc";
            Query q = em.createNativeQuery(sqlString);

            List<String> list = q.getResultList();

            for(String q1 : list){
                String temp = q1.toString();
                retorno.add(temp);
            }
                System.out.println("TecnoEvaluacionCasoFacade, findAll_id retorno.size(): "+retorno.size());
            
        } catch (Exception e) {
            System.out.println("TecnoEvaluacionCasoFacade, findAll_id CAtch: "+e);
        } finally {
            return retorno;
        }
    }
    
    public TecnoEvaluacionCaso findByReporte(String consec) {
        Query q = em.createNamedQuery("TecnoEvaluacionCaso.findByReporte");
        q.setParameter("reporte", consec);
        if(q.getResultList().size()>0){
            return (TecnoEvaluacionCaso) q.getResultList().get(0);
        }
        else{
            return null;
        }   
    }

}
