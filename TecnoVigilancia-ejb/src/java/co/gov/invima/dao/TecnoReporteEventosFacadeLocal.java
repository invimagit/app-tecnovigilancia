/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoReporteEventos;
import co.gov.invima.entidad.TecnoUsuariosInternet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface TecnoReporteEventosFacadeLocal {

    void create(TecnoReporteEventos tecnoReporteEventos);

    void edit(TecnoReporteEventos tecnoReporteEventos);

    void remove(TecnoReporteEventos tecnoReporteEventos);

    TecnoReporteEventos find(Object id);

    List<TecnoReporteEventos> findAll();
    
    TecnoReporteEventos findByReporte(String consec);
    
    void actualizarRol(TecnoUsuariosInternet tecnoUsuariosInternet);

}
