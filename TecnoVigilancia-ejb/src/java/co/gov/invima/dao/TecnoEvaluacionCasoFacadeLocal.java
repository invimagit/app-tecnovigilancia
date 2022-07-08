/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.TecnoEvaluacionCaso;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface TecnoEvaluacionCasoFacadeLocal {

    void create(TecnoEvaluacionCaso tecnoEvaluacionCaso);

    void edit(TecnoEvaluacionCaso tecnoEvaluacionCaso);

    void remove(TecnoEvaluacionCaso tecnoEvaluacionCaso);

    TecnoEvaluacionCaso find(Object id);

    List<TecnoEvaluacionCaso> findAll();
    
    ArrayList<String> findAll_id();
    
    TecnoEvaluacionCaso findByReporte(String consec);

}
