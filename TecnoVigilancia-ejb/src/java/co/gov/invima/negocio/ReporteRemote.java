/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.gov.invima.negocio;

import co.gov.invima.dto.MenusVO;
import co.gov.invima.dto.ReporteUsuarioVO;
import co.gov.invima.dto.ReporteVO;
import co.gov.invima.dto.UsuariosVO;
import co.gov.invima.entidad.Funcionarios;
import co.gov.invima.entidad.TecnoCausaProbable;
import co.gov.invima.entidad.TecnoExpAlertas;
import co.gov.invima.entidad.TecnoMonitoreo;
import co.gov.invima.entidad.TecnoRed;
import co.gov.invima.entidad.TecnoRolesReporte;
import co.gov.invima.entidad.TecnoTipodispositivo;
import co.gov.invima.entidad.TecnoUsuariosInternet;
import co.gov.invima.entidad.WTecnoProducto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diana Silva
 */
@Local
public interface ReporteRemote {

    ArrayList obtenerComboDpto();

    public java.util.ArrayList obtenerComboMunicipioPorDepto(java.lang.String idDepto);

    public void crearTecnodispositivo(co.gov.invima.entidad.TecnoDispositivo tecno, boolean editar);

    public java.util.List<TecnoCausaProbable> obtenerComboCausa();

    public java.util.ArrayList obtenerComboProfesion();

    public java.util.ArrayList obtenerComboTipoDoc();

    public java.util.ArrayList obtenerArregloDesenlace();

    public java.util.ArrayList obtenerArregloTipoAlerta();

    public java.util.ArrayList obtenerArregloPais();

    public java.util.ArrayList obtenerArregloRiesgos();

    public java.util.ArrayList obtenerArregloModalidades();

    public void crearTecnoExpAlertas(co.gov.invima.entidad.TecnoExpAlertas tecnoExpA, boolean editar);

    public void crearTecnoRepEventos(co.gov.invima.entidad.TecnoReporteEventos tecnoRepEve, boolean x);

    public void crearTecnoEvalCaso(co.gov.invima.entidad.TecnoEvaluacionCaso tecnoEvaluaCaso, boolean x);

    public void crearTecnoPaciente(co.gov.invima.entidad.TecnoPaciente tecnopaciente, boolean x);

    public void crearTecnoUsuario(co.gov.invima.entidad.TecnoUsuarios tecnousuario, boolean editar);

    public void crearTecnoRed(co.gov.invima.entidad.TecnoRed tecnored, boolean editar);

    public void actualizarParametros(co.gov.invima.entidad.Parametros param);
    
    public int  obtener_y_actualizar_consecutivo_risarh();

    public java.util.ArrayList obtenerConsecutivos();

    public void crearTecnoMonitoreo(co.gov.invima.entidad.TecnoMonitoreo tecnoMon, boolean editar);

    public int obtenerIdRed();

    public int obtenerIdUsuarios();

    public void crearTecnoUsuariosInternet(co.gov.invima.entidad.TecnoUsuariosInternet tecnousuariosinternet);

    public co.gov.invima.entidad.TecnoUsuariosInternet buscarUsuarioPorUsuario(java.lang.String usuario);

    public java.util.List<co.gov.invima.entidad.TecnoUsuariosInternet> buscarPorCedula(java.lang.String identificacionPersona);

    public java.util.List<co.gov.invima.entidad.TecnoUsuariosInternet> buscarPorNombrePersona(java.lang.String nombrePersona);

    public java.util.List<co.gov.invima.entidad.TecnoUsuariosInternet> buscarPorEstadoUsuario(java.lang.Character estadoUsuario);

    public void actualizarTecnoUsuariosInternet(co.gov.invima.entidad.TecnoUsuariosInternet tecno, boolean actualizaRol);

    public co.gov.invima.entidad.Paises buscarPaisesPorID(java.lang.String id);

    public co.gov.invima.entidad.Municipios buscarMunicipiosPorID(java.lang.String id);

    public co.gov.invima.entidad.Departamentos buscarDepartamentosPorID(java.lang.String id);

    public List<MenusVO> obtenerMenus(Integer rol);

    public UsuariosVO validarUsuarioFuncionario(String usuario, String clave);

    public UsuariosVO validarContrasenaInternet(String usuario, String clave);

    public String recuperarContrasena(UsuariosVO usuariosVO);

    public UsuariosVO buscarUsuarioPorNombreUSuario(String usuario);
    
    public ArrayList<String> lista_reportes_foreia();
    
    public ArrayList<String> lista_reportes_foreiu();
    
    public ArrayList<String> lista_reportes_red();
    
    public ReporteVO cargar_reporte_foreia(String consecutivo);
    
    public void actualizar_estado_reporte(String estado_reporte, String consecutivo);
    
    public ReporteUsuarioVO cargar_reporte_foreiu(int consecutivo);
    
    public TecnoRed cargar_reporte_red(int consecutivo);
    
    public List<TecnoTipodispositivo> obtenerCombotecnoTipodispositivo();
    
    public List<Funcionarios> obtenerComboFuncionarios();
    
     public List<TecnoExpAlertas> buscarTecnoExpAlertas(Long expediente);
     public List<WTecnoProducto> buscarDatosExpediente(Long expediente);
     
     public List<TecnoRolesReporte> buscarTecnoRolesReporte(Long expediente);
     
     public List<String> obtenerListaReportesRISARH(boolean solo_monitoreo);
     public TecnoMonitoreo buscarTecnoMonitoreo(String expediente);
     public TecnoExpAlertas buscarTecnoExpAlertas(String risarh);
     public List<TecnoUsuariosInternet> obtenerComboFuncionarios_usuariosinternet(boolean rol_invima, boolean rol_4) ;
     
     
   
    
}
