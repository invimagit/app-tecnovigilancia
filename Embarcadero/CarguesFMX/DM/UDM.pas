unit UDM;

interface

uses
  System.SysUtils, System.Classes, Data.DbxSybaseASE, Data.FMTBcd, Data.DB,
  Data.SqlExpr, FireDAC.Stan.Intf, FireDAC.Stan.Option, FireDAC.Stan.Error,
  FireDAC.UI.Intf, FireDAC.Phys.Intf, FireDAC.Stan.Def, FireDAC.Stan.Pool,
  FireDAC.Stan.Async, FireDAC.Phys, FireDAC.FMXUI.Wait, FireDAC.Comp.Client,
  FireDAC.Phys.TDBX, FireDAC.Phys.TDBXDef, FireDAC.Phys.MSSQL,
  FireDAC.Phys.MSSQLDef, FireDAC.Phys.ODBCBase, FireDAC.Stan.Param,
  FireDAC.DatS, FireDAC.DApt.Intf, FireDAC.DApt, FireDAC.Comp.DataSet;

type
  TDM = class(TDataModule)
    dsReporteEventos: TDataSource;
    dsEvaluacionCaso: TDataSource;
    dsPaciente: TDataSource;
    dsDispositivo: TDataSource;
    ConectaRegistroFD: TFDConnection;
    FDTransaccion: TFDTransaction;
    FDMSSQLDriver: TFDPhysMSSQLDriverLink;
    TblTecnoReporteEventos: TFDTable;
    TblTecnoEvaluacionCaso: TFDTable;
    TblTecnoPaciente: TFDTable;
    TblTecnoDispositivo: TFDTable;
    QryParametros: TFDQuery;
    QryTipoDispositivo: TFDQuery;
    QryCiudadesDpto: TFDQuery;
    TblTecnoReporteEventosreporte: TStringField;
    TblTecnoReporteEventosfechevento: TSQLTimeStampField;
    TblTecnoReporteEventosdescripcion_evento: TMemoField;
    TblTecnoReporteEventoscdg_eventodeteccion: TIntegerField;
    TblTecnoReporteEventoscdg_tiporeporte: TIntegerField;
    TblTecnoReporteEventoscdg_desenlace: TIntegerField;
    TblTecnoReporteEventosfechreporte_evento: TSQLTimeStampField;
    TblTecnoReporteEventoscdg_origenreporte: TIntegerField;
    TblTecnoReporteEventoscdg_tipoeventoincidente: TIntegerField;
    TblTecnoReporteEventoscdg_seriedad: TIntegerField;
    TblTecnoReporteEventosdesenlace_otro: TStringField;
    TblTecnoReporteEventosinternet: TStringField;
    TblTecnoReporteEventosfechaingreso: TSQLTimeStampField;
    TblTecnoReporteEventosreportado: TStringField;
    TblTecnoEvaluacionCasoreporte: TStringField;
    TblTecnoEvaluacionCasocdg_causa: TIntegerField;
    TblTecnoEvaluacionCasonumero: TIntegerField;
    TblTecnoEvaluacionCasoacciones: TMemoField;
    TblTecnoEvaluacionCasoexp_alertas: TBCDField;
    TblTecnoEvaluacionCasodescripcion_alerta: TMemoField;
    TblTecnoEvaluacionCasocdg_tipoalerta: TIntegerField;
    TblTecnoEvaluacionCasoestado_caso: TStringField;
    TblTecnoEvaluacionCasoseguimiento: TMemoField;
    TblTecnoEvaluacionCasocdgfuncionario: TBCDField;
    TblTecnoEvaluacionCasomedida_ejecutada: TStringField;
    TblTecnoEvaluacionCasonotificacion: TStringField;
    TblTecnoEvaluacionCasofecha_notificacion: TSQLTimeStampField;
    TblTecnoEvaluacionCasofecha_importador: TSQLTimeStampField;
    TblTecnoEvaluacionCasodispositivo_evaluacion: TStringField;
    TblTecnoEvaluacionCasoenviado_importador: TStringField;
    TblTecnoPacientereporte: TStringField;
    TblTecnoPacienteidentificacion: TStringField;
    TblTecnoPacientetipidentificacion: TStringField;
    TblTecnoPacienteedad: TStringField;
    TblTecnoPacientegenero: TStringField;
    TblTecnoPacientediagnostico_paciente: TMemoField;
    TblTecnoPacienteedad_en: TStringField;
    TblTecnoPacienteinstitucion_reportente: TStringField;
    TblTecnoPacientenaturaleza: TStringField;
    TblTecnoPacientedireccion_reportante: TStringField;
    TblTecnoPacientecod_mun: TStringField;
    TblTecnoPacientetelefono_reportante: TFMTBCDField;
    TblTecnoPacienteemail_reportante: TStringField;
    TblTecnoPacientecontacto_reportante: TStringField;
    TblTecnoPacientecod_depart: TStringField;
    TblTecnoPacienteinstitucion_incidente: TStringField;
    TblTecnoPacientecod_mun1: TStringField;
    TblTecnoPacienteidentificacion1: TStringField;
    TblTecnoPacientenivel_complejidad: TStringField;
    TblTecnoPacientecargo_inst: TIntegerField;
    TblTecnoPacientefecha_notif: TSQLTimeStampField;
    TblTecnoPacientecod_depart1: TStringField;
    TblTecnoPacienteautorizacion: TStringField;
    TblTecnoPacientetipo_reportante: TIntegerField;
    TblTecnoDispositivoreporte: TStringField;
    TblTecnoDispositivonombre_dispositivo: TStringField;
    TblTecnoDispositivonroregsan: TStringField;
    TblTecnoDispositivolote: TStringField;
    TblTecnoDispositivoreferencia: TStringField;
    TblTecnoDispositivomodelo: TStringField;
    TblTecnoDispositivoserial: TStringField;
    TblTecnoDispositivocdg_unicodispositivo: TIntegerField;
    TblTecnoDispositivofabricante_usuario: TStringField;
    TblTecnoDispositivodistribuidor_usuario: TStringField;
    TblTecnoDispositivoexpediente: TIntegerField;
    TblTecnoDispositivocdg_tipodispositivo: TIntegerField;
    TblTecnoDispositivoarea_funciona: TStringField;
    TblTecnoDispositivoutilizado: TStringField;
    TblTecnoDispositivonombre_comercial: TStringField;
    QryTipoDispositivocdg_tipodispositivo: TIntegerField;
    QryTipoDispositivodescripcion: TStringField;
    QryCiudadesDptocod_mun: TStringField;
    QryCiudadesDptocod_depart: TStringField;
    QryTipoDesenlace: TFDQuery;
    QryOperaciones: TFDQuery;
    QryProfesion: TFDQuery;
    QryTipoDesenlacecdg_desenlace: TIntegerField;
    QryTipoDesenlacedescripcion: TStringField;
    QryProfesioncdg_profesion: TIntegerField;
    QryProfesiondescripcion: TStringField;
    QryFuncionario: TFDQuery;
    QryFuncionariocdgfuncionario: TBCDField;
    QryFuncionarionmbfuncionario: TStringField;
    QryFuncionariologin_name: TStringField;
    QryCausaProbable: TFDQuery;
    QryCausaProbablecdg_causa: TIntegerField;
    QryCausaProbabletermino_ea: TStringField;
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  DM: TDM;

implementation

{%CLASSGROUP 'FMX.Controls.TControl'}

{$R *.dfm}

end.
