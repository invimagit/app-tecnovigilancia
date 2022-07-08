/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.negocio;

import co.gov.invima.dto.ReportePrecol;
import co.gov.invima.entidad.*;
import java.util.List;

/**
 *
 * @author jgutierrezme
 */
public interface ServicioReporteTrimestralRemote 
{
    //********************************************************
    //********************************************************
    //********************************************************
    public String obtenerCodigoDeptoPorNombre (String nombreDepto);
    public String obtenerNombreDeptoPorCodigo (String codigo);
    //********************************************************
    //********************************************************
    public String obtenerCodigoMunicipioPorNombre (String codigoDepto,String nombreMunicipio);
    public String obtenerNombreMunicipioPorCodigo (String codigo);
    //********************************************************
    //********************************************************
    //********************************************************
    public boolean crearRegistroTecnoReporteEventosCol (TecnoReporteEventos registroTRE, String codigoColDefinitivo);
    public boolean crearRegistroTecnoDispositivoCol (TecnoDispositivo registroDispositivo, String codigoColDefinitivo);
    public boolean crearRegistroTecnoPacienteCol (TecnoPaciente registroPaciente, String codigoColDefinitivo);
    public boolean crearRegistroTecnoEvaluacionCasoCol (TecnoEvaluacionCaso registroEvaluacionCaso, String codigoColDefinitivo);
    //********************************************************
    //********************************************************
    //********************************************************
    public boolean crearRegistroTecnoReporteEventos (TecnoReporteEventosTemp registroTRE, String codigoPrecol);
    public boolean crearRegistroTecnoDispositivo (TecnoDispositivoTemp registroDispositivo, String codigoPrecol);
    public boolean crearRegistroTecnoPaciente (TecnoPacienteTemp registroPaciente, String codigoPrecol);
    public boolean crearRegistroTecnoEvaluacionCaso (TecnoEvaluacionCasoTemp registroEvaluacionCaso, String codigoPrecol);
    //********************************************************
    //********************************************************
    //Cambiar el estado del registro de precol de pendiente a aprobado (cambiándolo de 0 a 1.  0 = Pendiente, 1 = Aprobado)
    public boolean modificarRegistroTecnoReporteEventosTemporalEstadoAprobacion (TecnoReporteEventosTemp registroTRE, String codigoColDefinitivo);
    //********************************************************
    //********************************************************
    //********************************************************
    public String obtenerPrecolSecuenciaCargue ();
    public String obtenerSiguienteColSecuenciaSistema();
    public String obtenerExpedientePorRegistroSanitario(String registroSanitario);
    //********************************************************
    //********************************************************
    public void limpiarTablaCargueMasivo (String nombreTabla);
    //********************************************************
    //********************************************************
    //Combos
    public String obtenerCodigoEventoDeteccion (String nombreEvento);
    public String obtenerCodigoTipoDesenlace (String descripcion);
    public String obtenerCodigoTipoIdentificacionReportante (String nombreTipoDocumento);
    public String obtenerCodigoCargos (String descripcion);
    public String obtenerCodigoTipoDeReportante (String nombreTipoReportante);
    public String obtenerCodigoCausaProbable (String descripcion);
    public String obtenerCodigoTipoDispositivo (String nombreTipoDispositivo);
    //********************************************************
    //********************************************************
    public String obtenerNombreEventoDeteccionPorCodigo (String codigoEvento);
    public String obtenerNombreTipoDesenlacePorCodigo (String codigo);
    public String obtenerNombreTipoIdentificacionReportantePorCodigo (String codigoTipoDocumento);
    public String obtenerNombreCargosPorCodigo (String codigo);
    public String obtenerNombreTipoDeReportantePorCodigo (String codigoTipoReportante);
    public String obtenerNombreCausaProbablePorCodigo (String codigo);
    public String obtenerNombreTipoDispositivo (String codigoTipoDispositivo);
    //********************************************************
    //********************************************************
    public List<String> obtenerListadoDepartamentos();
    public List<String> obtenerListadoDepartamentos(String deptoActivo);
    public List<String> obtenerListadoMunicipios(String codigoDepto);
    public List<String> obtenerListadoMunicipiosControlDistrito(String codigoDepto, String idDistrito);
    public List<String> obtenerListadoMunicipiosSoloDistrito(String codigoDepto, String idDistrito);
    //********************************************************
    //********************************************************
    public List<String> obtenerListadoCargos();
    public List<String> obtenerListaCausasProbables();
    public List<String> obtenerListaDesenlaces();
    public List<String> obtenerListaDetecciones();
    public List<String> obtenerListaTipoDocReportante();
    public List<String> obtenerListaCargos();
    public List<String> obtenerListaTipoReportes();
    public List<String> obtenerListaTipoReportantes();
    public List<String> obtenerListaTipoDispositivos();
    //********************************************************
    //********************************************************
    //********************************************************
    //********************************************************
    //Rol ETS aprobadora de precols
    public List<String> obtenerListadoUsuariosIPS();
    public List<String> obtenerListadoUsuariosIPS(String tipo);
    public List<String> obtenerListadoUsuariosIPS(String tipo, String depto);
    public List<String> obtenerListadoUsuariosIPS(String tipo, String depto, String idMunicipio, boolean esDistrito); 
    public List<String> obtenerListadoTODOSUsuariosIPS(); 
    public List<ReportePrecol> buscarReportesMasivosTrimestralesPorIPS (String depto, String municipio, String idIPS);
    public List<ReportePrecol> buscarReportesMasivosTrimestralesPorIPS (String depto, String municipio, java.util.Date fechaIni, java.util.Date fechaFin);
    public List<ReportePrecol> buscarReportesMasivosTrimestralesPorIPS (String depto, String municipio, java.util.Date fechaIni, java.util.Date fechaFin, String idIps, String idRol, String municipioSecretaria, boolean usuarioInvima);
    //********************************************************
    //********************************************************
    public TecnoReporteEventosTemp consultarRegistroTecnoReporteEventosTemp (String codigoPrecol);
    public TecnoPacienteTemp consultarRegistroTecnoPacienteTemp (String codigoPrecol);
    public TecnoDispositivoTemp consultarRegistroTecnoDispositivoTemp (TecnoDispositivoTempPK llaveCombinada);
    public TecnoEvaluacionCasoTemp consultarRregistroTecnoEvaluacionCasoTemp (String codigoPrecol);
    //********************************************************
    //********************************************************
    //********************************************************
    //********************************************************
    public TecnoReporteEventos consultarRegistroTecnoReporteEventos (String codigoCol);
    public TecnoPaciente consultarRegistroTecnoPaciente (String codigoCol);
    public TecnoDispositivo consultarRegistroTecnoDispositivo (String llaveCombinada);
    public TecnoEvaluacionCaso consultarRregistroTecnoEvaluacionCaso (String codigoCol);
    //********************************************************
    //********************************************************
    public String obtenerCodigoRegistroSanitarioPorPrecol (String codigoPrecol);
    public String obtenerCodigoRegistroSanitarioPorCOL(String codigoCOL);
    //********************************************************
    //********************************************************
    //********************************************************
    public boolean eliminarRegistroTecnoReporteEventos (TecnoReporteEventosTemp registroTRE, String codigoPrecol);
    public boolean eliminarRegistroTecnoDispositivo (TecnoDispositivoTemp registroDispositivo, String codigoPrecol);
    public boolean eliminarRegistroTecnoPaciente (TecnoPacienteTemp registroPaciente, String codigoPrecol);
    public boolean eliminarRegistroTecnoEvaluacionCaso (TecnoEvaluacionCasoTemp registroEvaluacionCaso, String codigoPrecol);
    //********************************************************
    //********************************************************
    public String verificarExpedienteDispositivoPorRegistroSanitario (String codigoRegistroSanitario);
    //********************************************************
    //********************************************************
    public String obtenerIdRolUsuarioPorNIT(String nitEmpresa);
    public String obtenerCorreoEmpresaPorNIT (String nitEmpresa);
    public String obtenerNombreEmpresaIPSPorNit (String nitEmpresa);
    //********************************************************
    //********************************************************
    public String obtenerCodigoFuncionarioInvima (String nombreUsuario);
    public String obtenerNombreFuncionario (String idFuncionario);
    public String obtenerNombreFuncionarioSecretaria (String idFuncionario);
    //********************************************************
    //********************************************************
    public boolean modificarRegistroTecnoReporteEventos (TecnoReporteEventosTemp registroTRE, String codigoPrecol);
    public boolean modificarRegistroTecnoDispositivo (TecnoDispositivoTemp registroDispositivo, String codigoPrecol);
    public boolean modificarRegistroTecnoPaciente (TecnoPacienteTemp registroPaciente, String codigoPrecol);
    public boolean modificarRegistroTecnoEvaluacionCaso (TecnoEvaluacionCasoTemp registroEvaluacionCaso, String codigoPrecol);
    //********************************************************
    //********************************************************
    //********************************************************
    //********************************************************
    //********************************************************
}
