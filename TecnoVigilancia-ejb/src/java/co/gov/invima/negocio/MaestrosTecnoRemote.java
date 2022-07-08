/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.negocio;

import co.gov.invima.dto.reports.PojoDatosReporte;
import co.gov.invima.dto.reports.PojoReporteAlertas;
import co.gov.invima.dto.reports.PojoReporteConsecutivos;
import co.gov.invima.dto.reports.PojoReporteDispoExpedientes;
import co.gov.invima.dto.reports.PojoReporteInscripcionRed;
import co.gov.invima.dto.reports.PojoReporteMonitoreo;
import co.gov.invima.dto.reports.PojoReporteTecno;
import co.gov.invima.dto.reports.PojoReporteUsuarios;
import co.gov.invima.dto.reports.PojoReportesUsuariosInternet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jgutierrezme
 */

@Local
public interface MaestrosTecnoRemote 
{
    //************************************************************************************************************
    //************************************************************************************************************
    //************************************************************************************************************
    public List<String> obtenerListadoRolesUsuario();
    //************************************************************************************************************
    //************************************************************************************************************
    //************************************************************************************************************
}
