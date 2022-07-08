/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.negocio;

import co.gov.invima.dto.ReportePrecol;
import co.gov.invima.dto.reports.*;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jgutierrezme
 */
@Local
public interface ConsultasTecnoRemote {

    public List<PojoReporteTecno> listarReportesCargados(java.util.Date fechaInicial, java.util.Date fechaFinal);

    public List<PojoDatosReporte> generarReporteReportesCargados(java.util.Date fechaInicial, java.util.Date fechaFinal, String depto);
    
    public List<PojoDatosReporte> generarReporteReportesParaSecretarias(java.util.Date fechaInicial, java.util.Date fechaFinal, String depto);
    
    

    public List<PojoDatosReporte> generarReporteReportesCargados(java.util.Date fechaInicial, java.util.Date fechaFinall, String idIPS, String depto);

    public List<PojoReporteDispoExpedientes> generarReporteDispoExpedientes(java.util.Date fechaInicial, java.util.Date fechaFinal);

    public List<PojoReporteInscripcionRed> generarReporteInscripcionRed(java.util.Date fechaInicial, java.util.Date fechaFinal);

    public List<PojoReporteMonitoreo> generarReporteMonitoreo(java.util.Date fechaInicial, java.util.Date fechaFinal);

    public List<PojoReporteAlertas> generarReporteAlertas(java.util.Date fechaInicial, java.util.Date fechaFinal);

    public List<PojoReporteAlertas> generarReporteAlertas(java.util.Date fechaInicial, java.util.Date fechaFinal, String idIPS);

    public List<PojoReporteConsecutivos> generarReporteConsecutivos(java.util.Date fechaInicial, java.util.Date fechaFinal);

    public List<PojoReporteUsuarios> generarReporteUsuarios(java.util.Date fechaInicial, java.util.Date fechaFinal);

    public List<PojoReportesUsuariosInternet> generarReporteUsuariosInternet(java.util.Date fechaInicial, java.util.Date fechaFinal);

    public List<String> obtenerNitsEmpresasReportantesSecretaria(String depto, String rolReportante);

    public List<ReportePrecol> generarReportePrecoles(java.util.Date fechaInicial, java.util.Date fechaFinal);

}
