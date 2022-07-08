/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.dao;

import co.gov.invima.entidad.Funcionarios;
import java.util.logging.Level;
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
public class FuncionariosFacade extends AbstractTecnoVickilanciaFacade<Funcionarios> implements FuncionariosFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    private final static Logger logEJBTecno = Logger.getLogger(FuncionariosFacade.class.getName());
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FuncionariosFacade() {
        super(Funcionarios.class);
    }
    
    /**
     * Obtiene la información del usuario registrado en SIVICOS Standalone
     * @param loginName: nombre de Usuario
     * @return Objeto con los datos del funcionario
     */
    @Override
    public Funcionarios obtenerUsuarioPorLogin(String loginName){
        Funcionarios funcionarios = null;
        try {
            Query q = em.createNamedQuery("Funcionarios.findByLoginName");
            q.setParameter("loginName", loginName);
            funcionarios = (Funcionarios) q.getSingleResult();
            //logEJBTecno.info  ("PERFIL ENCONTRADO = " + funcionarios.getLoginName());
            
        } catch (Exception e) {
            logEJBTecno.log(Priority.ERROR, "No se encontro Login Name: ", e);
        } finally {
            return funcionarios;
        }
    }
}
