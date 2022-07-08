/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.negocio;

import co.gov.invima.dto.PersonaInternetVO;
import javax.ejb.Local;

/**
 *
 * @author jgutierrezme
 */
@Local
public interface ServicioUsuariosRemote 
{
    //*****************************************************************************
    //*****************************************************************************
    public PersonaInternetVO obtenerDatosUsuarioInternetPorDocumento(String documento);
    //*****************************************************************************
    //*****************************************************************************
}
