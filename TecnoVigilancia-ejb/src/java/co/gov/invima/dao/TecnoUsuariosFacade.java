/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoUsuarios;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
public class TecnoUsuariosFacade implements TecnoUsuariosFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public void create(TecnoUsuarios tecnoUsuarios) {
        em.persist(tecnoUsuarios);
    }

    public void edit(TecnoUsuarios tecnoUsuarios) {
        em.merge(tecnoUsuarios);
    }

    public void remove(TecnoUsuarios tecnoUsuarios) {
        em.remove(em.merge(tecnoUsuarios));
    }

    public TecnoUsuarios find(Object id) {
        return em.find(TecnoUsuarios.class, id);
    }

    public List<TecnoUsuarios> findAll() {
        return em.createQuery("select object(o) from TecnoUsuarios as o").getResultList();
    }
    public int buscarMaxId(){
        int respuesta;
        Query q = em.createQuery("SELECT max(tr.consecutivo) from TecnoUsuarios as tr");
        if(q.getSingleResult()==null)
            respuesta=0;
        else
            respuesta = (Integer)q.getSingleResult();
        return respuesta;
    }
    
    public ArrayList<String> findAll_id() {
        ArrayList<String> retorno = new ArrayList <String>();
        try {
            String sqlString = "SELECT DISTINCT TOP (100) consecutivo FROM tecno_usuarios order by consecutivo desc";
            Query q = em.createNativeQuery(sqlString);

            List list = q.getResultList();

            for(Object q1 : list){
                String temp = ((int)q1)+"";
                retorno.add(temp);
            }
                System.out.println("TecnoUsuariosFacade, findAll_id retorno.size(): "+retorno.size());
            
        } catch (Exception e) {
            System.out.println("TecnoUsuariosFacade, findAll_id CAtch: "+e);
        } finally {
            return retorno;
        }
    }
}
