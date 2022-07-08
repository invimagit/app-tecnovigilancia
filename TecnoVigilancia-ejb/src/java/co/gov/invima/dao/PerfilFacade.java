/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.dao;

import co.gov.invima.entidad.Perfil;
import org.apache.log4j.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Priority;

/**
 *
 * @author mgualdrond
 */
@Stateless
public class PerfilFacade extends AbstractTecnoVickilanciaFacade<Perfil> implements PerfilFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    private final static Logger logEJBTecno = Logger.getLogger(PerfilFacade.class.getName());
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerfilFacade() {
        super(Perfil.class);
    }
    
    /**
     * Obtiene el perfil por nombre
     * @param nmbPerfil: nombre del perfil
     * @return Objeto con el contenido del perfil
     */
    @Override
    public Perfil obtenerPErfilPorNombre(String nmbPerfil){
        Perfil p = null;
        try {
            String consulta = "SELECT p FROM Perfil p WHERE UPPER(p.nmbPerfil) = :nmbPerfil";
            Query q = em.createQuery(consulta);
            q.setParameter("nmbPerfil", nmbPerfil);
            p = (Perfil) q.getSingleResult();
        } catch (Exception e) {
            logEJBTecno.log(Priority.ERROR, "Error al obtener Perfil: ", e);
        } finally {
            return p;
        }
    }
}
