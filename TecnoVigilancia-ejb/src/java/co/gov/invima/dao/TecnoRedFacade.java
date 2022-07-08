/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoRed;
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
public class TecnoRedFacade implements TecnoRedFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public void create(TecnoRed tecnoRed) {
        em.persist(tecnoRed);
    }

    public void edit(TecnoRed tecnoRed) {
        em.merge(tecnoRed);
    }

    public void remove(TecnoRed tecnoRed) {
        em.remove(em.merge(tecnoRed));
    }

    public TecnoRed find(Object id) {
        return em.find(TecnoRed.class, id);
    }

    public List<TecnoRed> findAll() {
        return em.createQuery("select object(o) from TecnoRed as o").getResultList();
    }
    public int buscarMaxId(){
        int respuesta;
        
        Query q = em.createQuery("SELECT max(tr.id) from TecnoRed as tr");
         if(q.getSingleResult()==null)
            respuesta=0;
        else
            respuesta =(Integer)q.getSingleResult();
        return respuesta;
    }
    
    public ArrayList<String> findAll_id() {
        ArrayList<String> retorno = new ArrayList <String>();
        try {
            String sqlString = "SELECT CAST(x.id as varchar(10)) FROM (SELECT DISTINCT TOP (100) id FROM tecno_red order by id desc) x";
            Query q = em.createNativeQuery(sqlString);

            List<String> list = q.getResultList();

            for(String q1 : list){
                String temp = q1.toString();
                retorno.add(temp);
            }
                System.out.println("TecnoRedFacade, findAll_id retorno.size(): "+retorno.size());
            
        } catch (Exception e) {
            System.out.println("TecnoRedFacade, findAll_id CAtch: "+e);
        } finally {
            return retorno;
        }
    }
}
