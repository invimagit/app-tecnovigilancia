/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoMenus;
import java.util.ArrayList;
import java.util.List;
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
public class TecnoMenusFacade extends AbstractTecnoVickilanciaFacade<TecnoMenus> implements TecnoMenusFacadeLocal {

    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TecnoMenusFacade() {
        super(TecnoMenus.class);
    }

    /**
     * Obtiene las opcines dle menu.
     * @param rol
     * @return
     */
    @Override
    public List<TecnoMenus> obtenerMenusPorRol(Integer rol) {
        List<TecnoMenus> opciones = null;
        try {
            String consulta = "select tm.* from tecno_menus tm inner join tecno_roles_menu trm on tm.idopcion=trm.ID_OPCION_MENU and trm.ID_ROL=:rol\n"
                    + "where tm.permitido_menu=1 order by idopcion asc ";
            Query q = em.createNativeQuery(consulta, TecnoMenus.class);
            q.setParameter("rol", rol);
            opciones = q.getResultList();
        } catch (Exception e) {
            Logger.getLogger(TecnoMenusFacade.class.getName()).log(Priority.ERROR, "Error", e);
        } finally {
            return opciones;
        }
    }
}
