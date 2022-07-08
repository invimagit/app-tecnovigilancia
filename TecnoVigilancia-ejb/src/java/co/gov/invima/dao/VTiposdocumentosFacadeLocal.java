/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.dao;

import co.gov.invima.entidad.VTiposdocumentos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface VTiposdocumentosFacadeLocal {

    void create(VTiposdocumentos vTiposdocumentos);

    void edit(VTiposdocumentos vTiposdocumentos);

    void remove(VTiposdocumentos vTiposdocumentos);

    VTiposdocumentos find(Object id);

    List<VTiposdocumentos> findAll();

}
