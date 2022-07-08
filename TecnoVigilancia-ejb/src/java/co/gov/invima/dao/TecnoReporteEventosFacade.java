/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoReporteEventos;
import co.gov.invima.entidad.TecnoUsuariosInternet;
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
public class TecnoReporteEventosFacade implements TecnoReporteEventosFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public void create(TecnoReporteEventos tecnoReporteEventos) {
        em.persist(tecnoReporteEventos);
    }

    public void edit(TecnoReporteEventos tecnoReporteEventos) {
        em.merge(tecnoReporteEventos);
    }

    public void remove(TecnoReporteEventos tecnoReporteEventos) {
        em.remove(em.merge(tecnoReporteEventos));
    }

    public TecnoReporteEventos find(Object id) {
        return em.find(TecnoReporteEventos.class, id);
    }

    public List<TecnoReporteEventos> findAll() {
        return em.createQuery("select object(o) from TecnoReporteEventos as o").getResultList();
    }
    
    public TecnoReporteEventos findByReporte(String consec) {
        Query q = em.createNamedQuery("TecnoReporteEventos.findByReporte");
        q.setParameter("reporte", consec);
        if(q.getResultList().size()>0){
            return (TecnoReporteEventos) q.getResultList().get(0);
        }
        else{
            return null;
        }
    }
    
    public void actualizarRol(TecnoUsuariosInternet tecnoUsuariosInternet){
        
        String nuevoRol = tecnoUsuariosInternet.getIDRolUsuario()+"";
        String idEmpresa = tecnoUsuariosInternet.getIdentificacionEmpresa()+"";

        String update="UPDATE [dbo].[tecno_reporte_eventos] SET [idrol] = "+nuevoRol+" WHERE idips = '"+idEmpresa+"'";
        System.out.println("actualizarRol, query = "+update);
        Query q = em.createNativeQuery(update);
        int result = q.executeUpdate();
        System.out.println("actualizarRol, result = "+result);
        em.flush();
    }

}
