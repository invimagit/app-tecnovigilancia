/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.negocio;

import co.gov.invima.dto.TecnoRepCeroConsultaVO;
import co.gov.invima.dto.TecnoReporteCeroVO;
import co.gov.invima.dto.TecnoUsuarioInternetVO;
import java.util.List;

/**
 *
 * @author jgutierrezme
 */
/*********************************************************************************************/
/*********************************************************************************************/
/*********************************************************************************************/
/*********************************************************************************************/
/*********************************************************************************************/
/*********************************************************************************************/
public interface ServicioReporteCeroRemote 
{
    //**********************************************************************************************
    //**********************************************************************************************
    //**********************************************************************************************
    //**********************************************************************************************
    public java.util.ArrayList<Object> crearRegistroReporteCero (TecnoReporteCeroVO registroReporteCero);
    public TecnoReporteCeroVO consultarRegistroReporteCero (String radicado);
    public List<TecnoReporteCeroVO> obtenerListadoReportesCeroReportante (String reportante);
    public List<TecnoReporteCeroVO> obtenerListadoReportesCeroPeriodo (java.util.Date fechaInicial, java.util.Date fechaFinal);
    public List<TecnoReporteCeroVO> obtenerListadoReportesCeroTrimestre (int yearReporte, String trimestre);
    public List<TecnoReporteCeroVO> buscarReportesCero (String usuario, java.util.Date fechaInicial, java.util.Date fechaFinal, int yearReporte, String trimestreReporte);
    public TecnoUsuarioInternetVO obtenerDatosETSUsuarioSesion (String username);
    //**********************************************************************************************
    //**********************************************************************************************
    //**********************************************************************************************
    public List<TecnoRepCeroConsultaVO> generarConsultaReportesMasivosCero (java.util.Date fechaInicial, java.util.Date fechaFinal, String depto,String municipioSecretaria, String rol);
    public boolean verificarRegistroTrimestreReporteCero (String periodo, String year_reporte, String usuarioIps);
    public java.util.ArrayList<String> obtenerDivipolaUsuarioReporteCero (String nombreUsuario);
    //**********************************************************************************************
    //**********************************************************************************************
    //**********************************************************************************************
}
/*********************************************************************************************/
/*********************************************************************************************/
/*********************************************************************************************/
/*********************************************************************************************/
/*********************************************************************************************/
/*********************************************************************************************/
