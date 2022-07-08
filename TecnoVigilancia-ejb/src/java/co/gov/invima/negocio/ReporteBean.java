/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.invima.negocio;

import co.gov.invima.dao.CiudadesFacadeLocal;
import co.gov.invima.dao.DepartamentosFacadeLocal;
import co.gov.invima.dao.FuncionariosFacadeLocal;
import co.gov.invima.entidad.Funcionarios;
import co.gov.invima.dao.MunicipiosFacadeLocal;
import co.gov.invima.dao.PaisesFacadeLocal;
import co.gov.invima.dao.ParametrosFacadeLocal;
import co.gov.invima.dao.PerfilFacadeLocal;
import co.gov.invima.entidad.Perfil;
import co.gov.invima.dao.TecnoCausaProbableFacadeLocal;
import co.gov.invima.dao.TecnoDesenlaceFacadeLocal;
import co.gov.invima.dao.TecnoDispositivoFacadeLocal;
import co.gov.invima.dao.TecnoEvaluacionCasoFacadeLocal;
import co.gov.invima.dao.TecnoExpAlertasFacadeLocal;
import co.gov.invima.dao.TecnoMenusFacadeLocal;
import co.gov.invima.dao.TecnoModalidadFacadeLocal;
import co.gov.invima.dao.TecnoMonitoreoFacadeLocal;
import co.gov.invima.dao.TecnoPacienteFacadeLocal;
import co.gov.invima.dao.TecnoProfesionFacadeLocal;
import co.gov.invima.dao.TecnoRedFacadeLocal;
import co.gov.invima.dao.TecnoReporteEventosFacadeLocal;
import co.gov.invima.dao.TecnoRiesgoFacadeLocal;
import co.gov.invima.dao.TecnoRolesReporteFacade;
import co.gov.invima.dao.TecnoTipoalertasFacadeLocal;
import co.gov.invima.dao.TecnoUsuariosFacadeLocal;
import co.gov.invima.dao.TecnoUsuariosInternetFacadeLocal;
import co.gov.invima.dao.VTiposdocumentosFacadeLocal;
import co.gov.invima.dao.WTecnoProductoFacade;
import co.gov.invima.dto.MenusVO;
import co.gov.invima.dto.ReporteUsuarioVO;
import co.gov.invima.dto.ReporteVO;
import co.gov.invima.dto.UsuariosVO;
import co.gov.invima.entidad.Ciudades;
import co.gov.invima.entidad.Departamentos;
import co.gov.invima.entidad.Paises;
import co.gov.invima.entidad.Parametros;
import co.gov.invima.entidad.TecnoCausaProbable;
import co.gov.invima.entidad.TecnoDispositivo;
import co.gov.invima.entidad.TecnoEvaluacionCaso;
import co.gov.invima.entidad.TecnoExpAlertas;
import co.gov.invima.entidad.TecnoMenus;
import co.gov.invima.entidad.TecnoMonitoreo;
import co.gov.invima.entidad.TecnoPaciente;
import co.gov.invima.entidad.TecnoRed;
import co.gov.invima.entidad.TecnoReporteEventos;
import co.gov.invima.entidad.TecnoRolesReporte;
import co.gov.invima.entidad.TecnoTipodispositivo;
import co.gov.invima.entidad.TecnoUsuarios;
import co.gov.invima.entidad.TecnoUsuariosInternet;
import co.gov.invima.entidad.WTecnoProducto;
import co.gov.invima.utils.CorreoElectronico;
import co.gov.invima.utils.PropertiesReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.apache.log4j.Priority;

/**
 *
 * @author Diana Silva
 */
@Stateless
public class ReporteBean implements ReporteRemote 
{
    //***************************************************************
    //***************************************************************
    //***************************************************************
    private final static Logger logEJBTecno = Logger.getLogger(ReporteBean.class.getName());
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @EJB
    private DepartamentosFacadeLocal dep;
    @EJB
    private MunicipiosFacadeLocal mun;
    @EJB
    private CiudadesFacadeLocal ciudadesDAO;
    @EJB
    private TecnoDispositivoFacadeLocal tec;
    @EJB
    private TecnoCausaProbableFacadeLocal tecCausaProb;
    @EJB
    private TecnoProfesionFacadeLocal tecnoProfesion;
    @EJB
    private VTiposdocumentosFacadeLocal tipoDocumento;
    @EJB
    private TecnoDesenlaceFacadeLocal tencoDesenlace;
    @EJB
    private TecnoTipoalertasFacadeLocal tencnoTipoAlertas;
    @EJB
    private PaisesFacadeLocal paises;
    @EJB
    private TecnoRiesgoFacadeLocal tecnoRiesgo;
    @EJB
    private TecnoModalidadFacadeLocal tecnoModalidad;
    @EJB
    private TecnoExpAlertasFacadeLocal tecnoExpAlertas;
    @EJB
    private TecnoRolesReporteFacade tecnoRolesReporteFacade;
    @EJB
    private WTecnoProductoFacade wTecnoProductoFacade;
    @EJB
    private TecnoReporteEventosFacadeLocal tecnoReporteEventos;
    @EJB
    private TecnoEvaluacionCasoFacadeLocal tecnoEvalCaso;
    @EJB
    private TecnoPacienteFacadeLocal tecnoPaciente;
    @EJB
    private TecnoUsuariosFacadeLocal tecnoUsuarios;
    @EJB
    private TecnoRedFacadeLocal tecnoRed;
    @EJB
    private ParametrosFacadeLocal parametros;
    @EJB
    private TecnoMonitoreoFacadeLocal tecnoMonitoreo;
    @EJB
    private TecnoUsuariosInternetFacadeLocal tecnoUsuariosInternet;
    @EJB
    private TecnoMenusFacadeLocal tecnoMenusDAO;
    @EJB
    private FuncionariosFacadeLocal funcionariosDAO;
    @EJB
    private PerfilFacadeLocal perfilDAO;
    @EJB
    private co.gov.invima.dao.TecnoTipodispositivoFacade tecnoTipodispositivoFacade;
    //***************************************************************
    //***************************************************************
    //***************************************************************
    //***************************************************************
    //***************************************************************
    //***************************************************************
    
    //***************************************************************
    //***************************************************************
    //***************************************************************
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public ArrayList obtenerComboDpto() {
        //logEJBTecno.info  ("OBTENIENDO COMBO DE DEPARTAMENTOS PARA EL FORMULARIO DE REGISTRO");
        ArrayList arreglo = (ArrayList) dep.findAll();
        return arreglo;
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public ArrayList obtenerComboMunicipioPorDepto(String idDepto) {
        ArrayList arreglo = (ArrayList) mun.buscarPorDepartamento(idDepto);
        return arreglo;
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public void crearTecnodispositivo(TecnoDispositivo tecno, boolean editar) 
    {
        if(editar){
            tec.edit(tecno);
        }else{
            tec.create(tecno);
        }
        
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public List<TecnoCausaProbable> obtenerComboCausa() 
    {
        List<TecnoCausaProbable> arreglo = tecCausaProb.findAll();
        return arreglo;
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public ArrayList obtenerComboProfesion() 
    {
        ArrayList arreglo = (ArrayList) tecnoProfesion.findAll();
        return arreglo;
    }
    //***************************************************************
    
    @Override
    public List<TecnoTipodispositivo> obtenerCombotecnoTipodispositivo() 
    {
        List<TecnoTipodispositivo> arreglo =  tecnoTipodispositivoFacade.findAll();
        return arreglo;
    }
    //***************************************************************
    @Override
    public List<Funcionarios> obtenerComboFuncionarios() 
    {
        List<Funcionarios> arreglo =  funcionariosDAO.findAll();
        return arreglo;
    }
    
    @Override
    public List<TecnoUsuariosInternet> obtenerComboFuncionarios_usuariosinternet(boolean rol_invima, boolean rol_4) 
    {
        List<TecnoUsuariosInternet> arreglo = tecnoUsuariosInternet.findAll_funcionarios(rol_invima, rol_4);
        return arreglo;
    }
    //***************************************************************
    //***************************************************************
    @Override
    public ArrayList obtenerComboTipoDoc() 
    {
        ArrayList arreglo = (ArrayList) tipoDocumento.findAll();
        return arreglo;
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public ArrayList obtenerArregloDesenlace() 
    {
        ArrayList arreglo = (ArrayList) tencoDesenlace.findAll();
        return arreglo;
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public ArrayList obtenerArregloTipoAlerta() 
    {
        ArrayList arreglo = (ArrayList) tencnoTipoAlertas.findAll();
        return arreglo;
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public ArrayList obtenerArregloPais() 
    {
        ArrayList arreglo = (ArrayList) paises.findAll();
        return arreglo;
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public ArrayList obtenerArregloRiesgos() 
    {
        ArrayList arreglo = (ArrayList) tecnoRiesgo.findAll();
        return arreglo;
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public ArrayList obtenerArregloModalidades() 
    {
        ArrayList arreglo = (ArrayList) tecnoModalidad.findAll();
        return arreglo;
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    /**
     * Inseta Exp Alerta
     * @param tecnoExpA
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void crearTecnoExpAlertas(TecnoExpAlertas tecnoExpA, boolean editar) 
    {
        logEJBTecno.info(tecnoExpA.toString());
        if(editar){
           tecnoExpAlertas.edit(tecnoExpA);
        }
        else{
            tecnoExpAlertas.create(tecnoExpA);
        }
    }
    //***************************************************************
    @Override
    public List<TecnoExpAlertas> buscarTecnoExpAlertas(Long expediente) {
        return tecnoExpAlertas.findByExpediente(expediente);
    }
    //***************************************************************
    @Override
    public List<WTecnoProducto> buscarDatosExpediente(Long expediente) {
        return wTecnoProductoFacade.findByExpediente(expediente);
    }
    //***************************************************************
    @Override
    public List<TecnoRolesReporte> buscarTecnoRolesReporte(Long expediente) {
        return tecnoRolesReporteFacade.findByExpediente(expediente);
    }
    
    
    
    
    
    //***************************************************************
    //***************************************************************
    @Override
    public void crearTecnoRepEventos(TecnoReporteEventos tecnoRepEve, boolean editar) {
        
        if(editar){
           tecnoReporteEventos.edit(tecnoRepEve);
        }
        else{
            tecnoReporteEventos.create(tecnoRepEve);
        }
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public void crearTecnoEvalCaso(TecnoEvaluacionCaso tecnoEvaluaCaso, boolean editar) 
    {
        if(editar){
            tecnoEvalCaso.edit(tecnoEvaluaCaso);
        }
        else{
            tecnoEvalCaso.create(tecnoEvaluaCaso);
        }
        
        
        
    }
    //***************************************************************
    @Override
    public ArrayList<String> lista_reportes_foreiu() 
    {
        return tecnoUsuarios.findAll_id();
    }
    //***************************************************************
    //***************************************************************
    @Override
    public ArrayList<String> lista_reportes_foreia() 
    {
        return tecnoEvalCaso.findAll_id();
    }
    //***************************************************************
    @Override
    public ReporteUsuarioVO cargar_reporte_foreiu(int consecutivo)
    {
        ReporteUsuarioVO reporte = new ReporteUsuarioVO();
        try{
            System.out.println("consecutivo = "+consecutivo);
            System.out.println("cargar_reporte_foreiu");
            TecnoUsuarios TecnoUsuarios_temp = tecnoUsuarios.find(consecutivo);
            
            reporte.setCodigo(TecnoUsuarios_temp.getConsecutivo()); 
            reporte.setNombreReportante(TecnoUsuarios_temp.getNombreReportante()); 
            reporte.setSexo(TecnoUsuarios_temp.getSexo()) ;
            reporte.setEdad(TecnoUsuarios_temp.getEdad());
            reporte.setEdad_en(TecnoUsuarios_temp.getEdadEn());
            reporte.setDireccionReportante(TecnoUsuarios_temp.getDireccionReportante());
            reporte.setTelefono(TecnoUsuarios_temp.getTelefono());
            reporte.setPais(TecnoUsuarios_temp.getPais());
            reporte.setCodDepart(TecnoUsuarios_temp.getCodDepart());
            reporte.setCodMun(TecnoUsuarios_temp.getCodMun());
            reporte.setEmail(TecnoUsuarios_temp.getEmail());
            reporte.setNombreDm(TecnoUsuarios_temp.getNombreDm());
            reporte.setNombreComercial(TecnoUsuarios_temp.getNombreComercial());
            reporte.setNroregsan(TecnoUsuarios_temp.getNroregsan());
            reporte.setLote(TecnoUsuarios_temp.getLote());
            reporte.setReferencia(TecnoUsuarios_temp.getReferencia());
            reporte.setNombreFabricante(TecnoUsuarios_temp.getNombreFabricante());
            reporte.setNombreDistribImport(TecnoUsuarios_temp.getNombreDistribImport());
            reporte.setFechaEvento(TecnoUsuarios_temp.getFechaEvento());
            reporte.setFechaNotificacion(TecnoUsuarios_temp.getFechaNotificacion());
            reporte.setCdgEventodeteccion(TecnoUsuarios_temp.getCdgEventodeteccion());
            reporte.setDescripcionEvento(TecnoUsuarios_temp.getDescripcionEvento());
            reporte.setReporte(TecnoUsuarios_temp.getReporte());
            reporte.setCdgfuncionario(TecnoUsuarios_temp.getCdgfuncionario());
            reporte.setRevisado(TecnoUsuarios_temp.getRevisado());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return reporte;
    }
    
    //***************************************************************
    @Override
    public void actualizar_estado_reporte(String estado_reporte, String consecutivo){
        TecnoReporteEventos tecnoReporte = tecnoReporteEventos.findByReporte(consecutivo);
        tecnoReporte.setEstado_reporte(estado_reporte);
        tecnoReporteEventos.edit(tecnoReporte);
    };
    @Override
    public ReporteVO cargar_reporte_foreia(String consecutivo)
    {
        ReporteVO reporte = new ReporteVO();
        try{
            System.out.println("consecutivo = "+consecutivo);
            System.out.println("TecnoReporteEventos");
            try{
            TecnoReporteEventos tecnoReporte = tecnoReporteEventos.findByReporte(consecutivo);
            
            reporte.setConsecutivo(consecutivo);
            
            try{reporte.setCodigoDesenlace(tecnoReporte.getCdgDesenlace());}catch(Exception e){}
            try{reporte.setCodigoEventoDeteccion(tecnoReporte.getCdgEventodeteccion());}catch(Exception e){}
            try{reporte.setCodigoTipoEventoIncidente(tecnoReporte.getCdgTipoeventoincidente());}catch(Exception e){}
            try{reporte.setDescripcionEvento(tecnoReporte.getDescripcionEvento());}catch(Exception e){}
            try{reporte.setDesenlaceOtro(tecnoReporte.getDesenlaceOtro());}catch(Exception e){}
            try{reporte.setFechaEvento(tecnoReporte.getFechevento());}catch(Exception e){}
            try{reporte.setFechaReporteEvento(tecnoReporte.getFechreporteEvento());}catch(Exception e){}
            try{reporte.setCdgOrigenreporte(tecnoReporte.getCdgOrigenreporte());}catch(Exception e){}
            try{reporte.setReportado(tecnoReporte.getReportado());}catch(Exception e){}
            try{reporte.setCdg_tiporeporte(tecnoReporte.getCdgTiporeporte());}catch(Exception e){}
            try{reporte.setTipo_roles(tecnoReporte.getIdRol());}catch(Exception e){}
            try{reporte.setReportepre(tecnoReporte.getReportepre());}catch(Exception e){}
            try{reporte.setIdIPS(tecnoReporte.getIdIps());}catch(Exception e){}
            try{reporte.setEstadoReporte(tecnoReporte.getEstado_reporte());}catch(Exception e){}
            try{reporte.setFechaNotif(tecnoReporte.getFechaingreso());}catch(Exception e){}
            
            }
            catch(Exception ex1){
                System.out.println("Catch TecnoReporteEventos = "+ex1.getMessage());
                ex1.printStackTrace();
            }

            try{
            System.out.println("TecnoEvaluacionCaso - consecutivo = "+consecutivo);
            TecnoEvaluacionCaso tecnoEvalua = tecnoEvalCaso.findByReporte(consecutivo);
            try{reporte.setAcciones(tecnoEvalua.getAcciones());}catch(Exception e){}
            try{reporte.setCdgCausa(tecnoEvalua.getCdgCausa());}catch(Exception e){}
            try{reporte.setEnvioDispositivo(tecnoEvalua.getEnviadoImportador());}catch(Exception e){}
            try{reporte.setNotificacion(tecnoEvalua.getNotificacion());}catch(Exception e){}
            try{reporte.setFechaImportador(tecnoEvalua.getFechaImportador());}catch(Exception e){}
            try{reporte.setFechaNotificacion(tecnoEvalua.getFechaNotificacion());}catch(Exception e){}
            try{reporte.setDispositivoEvaluacion(tecnoEvalua.getDispositivoEvaluacion());}catch(Exception e){}
            try{reporte.setEstadoCaso(tecnoEvalua.getEstadoCaso());}catch(Exception e){}
            try{reporte.setSeguimiento(tecnoEvalua.getSeguimiento());}catch(Exception e){}
            try{reporte.setMedidaEjecutada(tecnoEvalua.getMedidaEjecutada()+"");}catch(Exception e){}
            try{reporte.setCdgfuncionario(tecnoEvalua.getCdgfuncionario());}catch(Exception e){}
            try{reporte.setCdgTipoalerta(tecnoEvalua.getCdgTipoalerta());}catch(Exception e){}
            try{reporte.setDescripcionAlerta( tecnoEvalua.getDescripcionAlerta());}catch(Exception e){}
            try{reporte.setNumero(tecnoEvalua.getNumero());}catch(Exception e){}
            try{reporte.setExpAlertas(tecnoEvalua.getExpAlertas());}catch(Exception e){}

            }
            catch(Exception ex1){
                System.out.println("Catch TecnoEvaluacionCaso = "+ex1.getMessage());
            }

            try{
            System.out.println("TecnoPaciente");
            TecnoPaciente tecnoPaciente_ = tecnoPaciente.findByReporte(consecutivo);
            try{reporte.setAutorizacion(tecnoPaciente_.getAutorizacion());}catch(Exception e){}
            try{reporte.setCargoInst(tecnoPaciente_.getCargoInst());}catch(Exception e){}
            try{reporte.setCodDepart(tecnoPaciente_.getCodDepart());}catch(Exception e){}
            try{reporte.setCodDepart1(tecnoPaciente_.getCodDepart1());}catch(Exception e){}
            try{reporte.setCodMun(tecnoPaciente_.getCodMun());}catch(Exception e){}
            try{reporte.setCodMun1(tecnoPaciente_.getCodMun1());}catch(Exception e){}
            try{reporte.setContactoReportante(tecnoPaciente_.getContactoReportante());}catch(Exception e){}
            try{reporte.setDiagnosticoPaciente(tecnoPaciente_.getDiagnosticoPaciente());}catch(Exception e){}
            try{reporte.setDireccionReportante(tecnoPaciente_.getDireccionReportante());}catch(Exception e){}
            try{reporte.setEdad(tecnoPaciente_.getEdad());}catch(Exception e){}
            try{reporte.setEdadEn(tecnoPaciente_.getEdadEn()+"");}catch(Exception e){}
            try{reporte.setEmailReportante(tecnoPaciente_.getEmailReportante());}catch(Exception e){}
            try{reporte.setFechaNotif(tecnoPaciente_.getFechaNotif());}catch(Exception e){}
            try{reporte.setGenero(tecnoPaciente_.getGenero()+"");}catch(Exception e){}
            try{reporte.setIdentificacion(tecnoPaciente_.getIdentificacion());}catch(Exception e){}
            try{reporte.setIdentificacion1(tecnoPaciente_.getIdentificacion1());}catch(Exception e){}
            try{reporte.setInstitucionReportante(tecnoPaciente_.getInstitucionReportente());}catch(Exception e){}
            try{reporte.setNaturaleza(tecnoPaciente_.getNaturaleza());}catch(Exception e){}
            try{reporte.setNivelComplejidad(tecnoPaciente_.getNivelComplejidad());}catch(Exception e){}
            try{reporte.setTelefonoReportante(tecnoPaciente_.getTelefonoReportante());}catch(Exception e){}
            try{reporte.setTipoId(tecnoPaciente_.getTipidentificacion());}catch(Exception e){}
            try{reporte.setTipoReportante(tecnoPaciente_.getTipoReportante()+"");}catch(Exception e){}
            try{reporte.setInstitucionIncidente(tecnoPaciente_.getInstitucionIncidente());}catch(Exception e){}
            try{reporte.setTelefonoReportante(tecnoPaciente_.getTelefonoReportante());}catch(Exception e){}
            System.out.println("reporte.setInstitucionIncidente = "+reporte.getInstitucionIncidente());
            }
            catch(Exception ex1){
                System.out.println("Catch TecnoPaciente = "+ex1.getMessage());
            }
            
            try{
            TecnoDispositivo tecno = tec.findByReporte(consecutivo);
            try{reporte.setAreaFunciona(tecno.getAreaFunciona());}catch(Exception e){}
            try{reporte.setDistribuidorUsuario(tecno.getDistribuidorUsuario());}catch(Exception e){}
            try{reporte.setFabricanteUsuario(tecno.getFabricanteUsuario());}catch(Exception e){}       
            try{reporte.setLote(tecno.getLote());}catch(Exception e){}
            try{reporte.setModelo(tecno.getModelo());}catch(Exception e){}
            try{reporte.setNombreComercial(tecno.getNombreComercial());}catch(Exception e){}
            try{reporte.setNombreDispositivo(tecno.getNombreDispositivo());}catch(Exception e){}
            try{reporte.setNroRegSan(tecno.getNroregsan());}catch(Exception e){}
            try{reporte.setReferencia(tecno.getReferencia());}catch(Exception e){}
            try{reporte.setSerial(tecno.getSerial());}catch(Exception e){}
            try{reporte.setUtilizado(tecno.getUtilizado());}catch(Exception e){}
            try{reporte.setExpediente(tecno.getExpediente());}catch(Exception e){}
            try{reporte.setCdg_unicodispositivo(tecno.getCdgUnicodispositivo());}catch(Exception e){}
            try{reporte.setCdg_tipodispositivo(tecno.getCdgTipodispositivo());}catch(Exception e){}
            }
            catch(Exception ex1){
                System.out.println("Catch TecnoPaciente = "+ex1.getMessage());
            }
        }
        catch(Exception e){
            System.out.println("Catch ReporteBean cargar_reporte_foreia = "+e.getMessage());
            e.printStackTrace();
        }
        reporte.print_datos();
        return reporte;

    }

    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public void crearTecnoPaciente(TecnoPaciente tecnopaciente, boolean editar) {
        if(editar){
            tecnoPaciente.edit(tecnopaciente);
        }else{
            tecnoPaciente.create(tecnopaciente);
        }
        
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public void crearTecnoUsuario(TecnoUsuarios tecnousuario, boolean editar) {
        if(editar){
            tecnoUsuarios.edit(tecnousuario);
        }else{
            tecnoUsuarios.create(tecnousuario);
        }
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public void crearTecnoRed(TecnoRed tecnored, boolean editar) {
        if(editar){
            tecnoRed.edit(tecnored);
        }else{
            tecnoRed.create(tecnored);
        }
    }
    
    @Override
    public TecnoRed cargar_reporte_red(int consecutivo){
        return tecnoRed.find(consecutivo);
    }
    
    @Override
    public ArrayList<String> lista_reportes_red() {
        return tecnoRed.findAll_id();
    }
    
    
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public void actualizarParametros(Parametros param) {
        parametros.edit(param);
    }
    
    @Override
    public int obtener_y_actualizar_consecutivo_risarh() {       
        Parametros p = parametros.find(1);
        int retorno = p.getConsecRisarh() + 1;
        p.setConsecRisarh(retorno);
        parametros.edit(p);
        return retorno;
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public ArrayList obtenerConsecutivos() {
        ArrayList arreglo = (ArrayList) parametros.findAll();
        return arreglo;
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public void crearTecnoMonitoreo(TecnoMonitoreo tecnoMon, boolean editar) {
        if(editar){
           tecnoMonitoreo.edit(tecnoMon);
        }
        else{
            tecnoMonitoreo.create(tecnoMon);
        }
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public int obtenerIdRed() {
        return tecnoRed.buscarMaxId();
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public int obtenerIdUsuarios() {
        return tecnoUsuarios.buscarMaxId();
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public void crearTecnoUsuariosInternet(TecnoUsuariosInternet tecno) {
        tecnoUsuariosInternet.create(tecno);
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public co.gov.invima.entidad.TecnoUsuariosInternet buscarUsuarioPorUsuario(String usuario) {
        return tecnoUsuariosInternet.buscarPorUsuario(usuario);
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    /**
     * Valida la contraseña y el usuarionsi esta en la base de datos, y 
     * pertenece al rol de Tecnovigilancia
     * @param usuario: nombre usuario BD
     * @param clave: Clave usuario BD
     * @return Objeto Usuarios
     */
    @Override
    public UsuariosVO validarUsuarioFuncionario(String usuario, String clave) {
        UsuariosVO uvo = null;
        
        try {
            PropertiesReader pr = new PropertiesReader("co.gov.invima.utils.recursos");
            //**************************************************************************
            //**************************************************************************
            String conecta= pr.getProperty("urlBdUsuarios")+";instance="+pr.getProperty("urlInstanciaUsuarios");
            //Boolean connection = tecnoUsuariosInternet.esUsuarioDeBD(usrEsquema,claveEsquema,conecta);
            logEJBTecno.info  ("URI DE AUTENTICACION = " + conecta);
            
            Boolean connection = false;
            try{connection = tecnoUsuariosInternet.esUsuarioDeBD(usuario, clave,conecta);}catch(Exception e){}
            //logEJBTecno.info  ("Se pudo autenticar = " + connection);
            //**************************************************************************
            //**************************************************************************
            if (connection) 
            //if(true)
            {
                //**********************************************************************
                //**********************************************************************
                //Funcionarios f = funcionariosDAO.obtenerUsuarioPorLogin(usrEsquema);
                Funcionarios f = funcionariosDAO.obtenerUsuarioPorLogin(usuario);
                //**********************************************************************
                //**********************************************************************
                if (f != null) 
                {
                    //**********************************************************************
                    //**********************************************************************
                    //logEJBTecno.info  ("******************************************************");
                    //logEJBTecno.info  ("Se sesiono con usuario de la Entidad exitosamente: " + usuario);
                    //logEJBTecno.info  ("******************************************************");
                    //**********************************************************************
                    //**********************************************************************
                    String perfil = pr.getProperty("perfil");
                    //logEJBTecno.info  ("PERFIL PARA CONSULTAR = " + perfil);
                    Perfil p = perfilDAO.obtenerPErfilPorNombre(perfil.toUpperCase());
                    //************************************************************************
                    //************************************************************************
                    if (p != null) 
                    {
                        //valida los permisos
                        boolean sw = false;
                        for (Perfil p1 : f.getPerfilList()) {
                            if (p.getCdgPerfil().equals(p1.getCdgPerfil())) {
                                sw = true;
                                break;
                            }
                    }
                    //************************************************************************
                    //************************************************************************
                    if (sw) {
                            uvo = new UsuariosVO();
                            uvo.setNombrePersona(f.getNmbfuncionario());
                            uvo.setUsuario(usuario);
                            uvo.setRespuesta("OK");
                            uvo.setRolPalabra(perfil);
                            uvo.setIdRol("1");
                            uvo.setiDRolUsuario(1);
                        } else {
                            uvo = new UsuariosVO();
                            uvo.setRespuesta("Perfil TecnoVigilancia no asociado al usuario");
                        }
                    } else {
                        uvo = new UsuariosVO();
                        uvo.setRespuesta("Perfil no habilitado para este usuario");
                    }
                } else {
                    uvo = new UsuariosVO();
                    uvo.setRespuesta("Usuario No encontrado, contacte con el administrador del sistema");
                }
            } else 
            {
                //logEJBTecno.info  ("No se pudo realizar la autenticacion");
                uvo = new UsuariosVO();
                uvo.setRespuesta("Usuario o contraseña errados");
            }
        } catch (Exception e) {
            logEJBTecno.log(Priority.ERROR, "Error al validar funcionario: ", e);
        } 
        
        finally 
        {
            try
            {
                //logEJBTecno.info ("Cerrando transaccion de autenticacion usuario " + uvo);
            }
            
            catch (Exception errorFinally)
            {
                //logEJBTecno.info ("ERROR FINALY: " + errorFinally.toString());
                errorFinally.printStackTrace();
                return (null);
            }

            return (uvo);
        }
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    /**
     * Valida usuario y contraseña de los usuarios registrados por Internet
     *
     * @param usuario: nombre d eusuario registrado
     * @param clave: contraseña registrada
     * @return Objeto UsuariosVO con la información básica del usuario.
     */
    @Override
    public UsuariosVO validarContrasenaInternet(String usuario, String clave) {
        UsuariosVO uvo = null;
        TecnoUsuariosInternet rui = null;
        try 
        {
            //******************************************************
            //******************************************************
            //logEJBTecno.info ("---------------------------------------->");
            //logEJBTecno.info ("USUARIO PARA VERIFICAR EN BASE = " + usuario);
            rui = tecnoUsuariosInternet.buscarPorUsuario(usuario);
            //logEJBTecno.info ("USUARIO DE BASE DE DATOS CONSULTADO = " + rui);
            //logEJBTecno.info ("---------------------------------------->");
            //******************************************************
            //******************************************************
            if (rui != null) {
                if (rui.getPassword().equals(clave)) {
                    //logueado
                    if (rui.getEstadoUsuario().equals('A')) {
                        uvo = new UsuariosVO();
                        uvo.setActivo(rui.getActivo());
                        uvo.setCargoPersona(rui.getCargoPersona());
                        uvo.setCdgPais(rui.getCdgPais());
                        uvo.setClasificacionUsuario(rui.getClasificacionUsuario());
                        uvo.setCodDepart(rui.getCodDepart());
                        uvo.setCodMun(rui.getCodMun());
                        uvo.setDireccionEmpresa(rui.getDireccionEmpresa());
                        uvo.setEmailEmpresa(rui.getEmailEmpresa());
                        uvo.setEmailPersona(rui.getEmailPersona());
                        uvo.setEstadoPalabra("ACTIVO");
                        uvo.setEstadoUsuario(rui.getEstadoUsuario());
                        uvo.setFechaIngreso(rui.getFechaIngreso());
                        uvo.setIdRol(String.valueOf(rui.getIDRolUsuario()));
                        uvo.setIdentificacionEmpresa(rui.getIdentificacionEmpresa());
                        uvo.setIdentificacionPersona(rui.getIdentificacionPersona());
                        uvo.setNombreEmpresa(rui.getNombreEmpresa());
                        uvo.setNombrePersona(rui.getNombrePersona());
                        uvo.setPassword(rui.getPassword());
                        uvo.setPregunta(rui.getPregunta());
                        uvo.setRespuesta(rui.getRespuesta());
                        uvo.setRolPalabra("OK");
                        uvo.setTelefonoEmpresa(rui.getTelefonoEmpresa());
                        uvo.setTelefonoPersona(rui.getTelefonoPersona());
                        uvo.setTipidentificacionEmpresa(rui.getTipidentificacionEmpresa());
                        uvo.setTipidentificacionPersona(rui.getTipidentificacionPersona());
                        uvo.setUsuario(rui.getUsuario());
                        uvo.setiDRolUsuario(rui.getIDRolUsuario());
                        uvo.setNombrePais(this.obtenerPaisPorID(rui.getCdgPais()));
                        uvo.setNombreDpto(this.obtenerDptoPorID(rui.getCodDepart()));
                        uvo.setNombreMpio(this.obtenerNombreMpioPorID(rui.getCodDepart(), rui.getCodMun()));
                    } else {
                        uvo = new UsuariosVO();
                        uvo.setRespuesta("Usuario Inactivo");
                    }
                } else {
                    //contraseña errada
                    uvo = new UsuariosVO();
                    uvo.setRespuesta("Contraseña errada");
                }
            } else {
                //usuario no existe
                uvo = new UsuariosVO();
                uvo.setRespuesta("Usuario No encontrado");
            }
        } catch (Exception e) {
            logEJBTecno.log(Priority.ERROR, "Error al vaslidar usuario internet", e);
        } finally {
            return uvo;
        }
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public java.util.List<co.gov.invima.entidad.TecnoUsuariosInternet> buscarPorCedula(java.lang.String identificacionPersona) 
    {
        try {
            return tecnoUsuariosInternet.buscarPorCedula(identificacionPersona);
        } catch (Exception ex) {
            return null;
        }
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public java.util.List<co.gov.invima.entidad.TecnoUsuariosInternet> buscarPorNombrePersona(java.lang.String nombrePersona) 
    {
        try {
            return tecnoUsuariosInternet.buscarPorNombrePersona(nombrePersona);
        } catch (Exception ex) {
            return null;
        }
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public java.util.List<co.gov.invima.entidad.TecnoUsuariosInternet> buscarPorEstadoUsuario(java.lang.Character estadoUsuario) 
    {
        try {
            return tecnoUsuariosInternet.buscarPorEstadoUsuario(estadoUsuario);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public void actualizarTecnoUsuariosInternet(TecnoUsuariosInternet tecno, boolean actualizaRol) {
        try {
            tecnoUsuariosInternet.edit(tecno);

            if (actualizaRol) {
                tecnoReporteEventos.actualizarRol(tecno);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public co.gov.invima.entidad.Paises buscarPaisesPorID(String id) 
    {
        return paises.find(id);
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public co.gov.invima.entidad.Municipios buscarMunicipiosPorID(String id) 
    {
        return mun.find(id);
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public co.gov.invima.entidad.Departamentos buscarDepartamentosPorID(String id) {
        return dep.find(id);
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    @Override
    public List<MenusVO> obtenerMenus(Integer rol){
        List<MenusVO> opciones = null;
        try {
            List<TecnoMenus> menuses = tecnoMenusDAO.obtenerMenusPorRol(rol);
            if(menuses!=null && !menuses.isEmpty()){
              opciones = new ArrayList<>();
                for (TecnoMenus menuse : menuses) {
                    MenusVO mvo = new MenusVO();
                    mvo.setAccionMenu(menuse.getAccionMenu());
                    mvo.setDescripcionMenu(menuse.getDescripcionMenu());
                    mvo.setMostrar(menuse.getMostrarMenu().equals('S'));
                    mvo.setOpcionMenu(menuse.getIdopcion());
                    mvo.setPermitidoMenu(String.valueOf(menuse.getPermitidoMenu()));
                    mvo.setUrlMenu(menuse.getUrlMenu());
                    opciones.add(mvo);
                }
            }
        } catch (Exception e) {
            Logger.getLogger(ReporteBean.class.getName()).log(Priority.ERROR, "No se pueden obtener las opciones del menu",e);
        } finally{
            return opciones;
        }
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    private String obtenerPaisPorID(String codPais) {
        String pvo = "";
        try {
            Paises pais = paises.find(codPais);
            if (pais != null) {
                pvo = pais.getPais();
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        
        finally {
            return pvo;
        }
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    private String obtenerDptoPorID(String codDpto) {
        String dpto = "";
        try {
            Departamentos d = dep.find(codDpto);
            if (d != null) {
                dpto = d.getDescripcion();
            }
        } catch (Exception e) {
            logEJBTecno.log(Priority.ERROR, "Error al obtener nombre de departamento: ", e);
        } finally {
            return dpto;
        }
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
   private String obtenerNombreMpioPorID(String cdgDpto, String cdgMpio) 
   {
        String mpio = "";
        try {
            Departamentos d = dep.find(cdgDpto);
            Ciudades c = ciudadesDAO.obtenerCiudadPorDptoYCiudad(d.getCdgTerritorio(), cdgMpio);
            if (c != null) {
                mpio = c.getCiudadesPK().getCiudad();
            }
        } catch (Exception e) {
            logEJBTecno.log(Priority.ERROR, "Error al obtener nombre d eMunicipio: ", e);
        } finally {
            return mpio;
        }
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    /**
     * Obtiene y envia la respuesta dle correo electronico
     * @param usuariosVO
     * @return
     */
    @Override
    public String recuperarContrasena(UsuariosVO usuariosVO)
    {
        String respuesta = "";
        try {
            TecnoUsuariosInternet internet = tecnoUsuariosInternet.find(usuariosVO.getUsuario());
            if(internet!=null){
                if(internet.getRespuesta().toUpperCase().equals(usuariosVO.getRespuesta().toUpperCase())){
                    SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
                    Date fechaActual = new Date();
                    String correo ="<html>Bogotá D.C., "+sdf.format(fechaActual)+"<br><br>"
                            +"Doctor(a)<br>"+internet.getNombrePersona().toUpperCase()+"<br>"
                            +"<b>"+internet.getNombreEmpresa().toUpperCase()+"</b><br><br>"
                            +"<p align=\"justify\"> Por medio del presente se le hace entrega de sus credenciales de acceso al Programa NAcional de TecnoVigilancia.</p>"
                            +"<p align=\"justify\"> Nombre de usuario: <b>"+internet.getUsuario()+"</b><br>"
                            +"Contraseña: <b>"+internet.getPassword()+"</b></p><br><br>Cordialmente,<br><br>"
                            +"<p><b>Grupo de TecnoVigilancia<br>"
                            + "Dirección de Dispositivos Médicos y Otras Tecnologías<br>"
                            + "INVIMA<br>"
                            + "Tel: (57-1) 2948700 Ext. 3880</b></p></html>";
                    CorreoElectronico ce = new CorreoElectronico();
                    ce.enviarCorreoElectronicoTecno(internet.getEmailEmpresa(), internet.getEmailPersona(), "Recuperar Contraseña", correo);
                    respuesta = "Correo enviado Exitosamente";
                }else{
                    respuesta = "Su correo no ha sido enviado";
                }
            }
        } catch (Exception e) {
            logEJBTecno.log(Priority.ERROR, "error al recuperar clave: ", e);
            respuesta="Error al recuperar contraseña, Contacte con el administrador";
        } finally {
            return respuesta;
        }
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    /**
     * Obtiene el usuario
     * @param usuario
     * @return
     */
    @Override
    public UsuariosVO buscarUsuarioPorNombreUSuario(String usuario) 
    {
        UsuariosVO uvo = null;
        try {
            TecnoUsuariosInternet rui = tecnoUsuariosInternet.find(usuario);
            if (rui != null) {
                uvo = new UsuariosVO();
                uvo.setActivo(rui.getActivo());
                uvo.setCargoPersona(rui.getCargoPersona());
                uvo.setCdgPais(rui.getCdgPais());
                uvo.setClasificacionUsuario(rui.getClasificacionUsuario());
                uvo.setCodDepart(rui.getCodDepart());
                uvo.setCodMun(rui.getCodMun());
                uvo.setDireccionEmpresa(rui.getDireccionEmpresa());
                uvo.setEmailEmpresa(rui.getEmailEmpresa());
                uvo.setEmailPersona(rui.getEmailPersona());
                uvo.setEstadoUsuario(rui.getEstadoUsuario());
                uvo.setFax(rui.getFax());
                uvo.setFechaIngreso(rui.getFechaIngreso());
                uvo.setIdentificacionEmpresa(rui.getIdentificacionEmpresa());
                uvo.setIdentificacionPersona(rui.getIdentificacionPersona());
                uvo.setNombreEmpresa(rui.getNombreEmpresa());
                uvo.setNombrePersona(rui.getNombrePersona());
                uvo.setPassword(rui.getPassword());
                uvo.setPregunta(rui.getPregunta());
                uvo.setRespuesta("");
                uvo.setSession(rui.getSession());
                uvo.setTelefonoEmpresa(rui.getTelefonoEmpresa());
                uvo.setTelefonoPersona(rui.getTelefonoPersona());
                uvo.setTipidentificacionEmpresa(rui.getTipidentificacionEmpresa());
                uvo.setTipidentificacionPersona(rui.getTipidentificacionPersona());
                uvo.setUrl(rui.getUrl());
                uvo.setUsuario(rui.getUsuario());
                uvo.setiDRolUsuario(rui.getIDRolUsuario());
                uvo.setIdRol(Integer.toString(rui.getIDRolUsuario()));
            }
        } catch (Exception e) {
            logEJBTecno.log(Priority.ERROR, "Error al obtener usuario", e);
        } finally {
            return uvo;
        }
    }
    //***************************************************************
    @Override
    public List<String> obtenerListaReportesRISARH(boolean solo_monitoreo) {
        return tecnoExpAlertas.findAll_id(solo_monitoreo);
    }
    
    @Override
    public TecnoMonitoreo buscarTecnoMonitoreo(String risarh) {
        return tecnoMonitoreo.find(risarh);
    }
    @Override
    public TecnoExpAlertas buscarTecnoExpAlertas(String risarh) {
        return tecnoExpAlertas.find(risarh);
    }
    //***************************************************************
    //***************************************************************
    //***************************************************************
    //***************************************************************
    //***************************************************************
    //***************************************************************
    //***************************************************************
    //***************************************************************
}
