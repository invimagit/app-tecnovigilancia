/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoPacienteTemp;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class TecnoPacienteTempFacade implements TecnoPacienteTempFacadeLocal {
    @PersistenceContext(unitName = "TecnovigilanciaEJBPU")
    private EntityManager em;

    public void create(TecnoPacienteTemp tecnoDispositivo) {
        em.persist(tecnoDispositivo);
    }

    public void edit(TecnoPacienteTemp tecnoDispositivo) {
        em.merge(tecnoDispositivo);
    }

    public void remove(TecnoPacienteTemp tecnoDispositivo) {
        em.remove(em.merge(tecnoDispositivo));
    }

    public TecnoPacienteTemp find(Object id) {
        return em.find(TecnoPacienteTemp.class, id);
    }

    public List<TecnoPacienteTemp> findAll() {
        return em.createQuery("select object(o) from TecnoPacienteTemp as o").getResultList();
    }
}
