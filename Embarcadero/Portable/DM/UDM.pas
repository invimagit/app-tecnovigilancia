unit UDM;

interface

uses
  System.SysUtils, System.Classes, FireDAC.Stan.Intf, FireDAC.Stan.Option,
  FireDAC.Stan.Error, FireDAC.UI.Intf, FireDAC.Phys.Intf, FireDAC.Stan.Def,
  FireDAC.Stan.Pool, FireDAC.Stan.Async, FireDAC.Phys, FireDAC.FMXUI.Wait,
  Data.DB, FireDAC.Comp.Client, FireDAC.Phys.FBDef, FireDAC.Phys.IBBase,
  FireDAC.Phys.FB, FireDAC.Stan.Param, FireDAC.DatS, FireDAC.DApt.Intf,
  FireDAC.DApt, FireDAC.Comp.DataSet;

type
  TDM = class(TDataModule)
    FDConexion: TFDConnection;
    FBDriver: TFDPhysFBDriverLink;
    TblTecnoPersonaInternet: TFDTable;
    TblTecnoPersonaInternetIDENTIFICACION_EMPRESA: TLargeintField;
    TblTecnoPersonaInternetTIPIDENTIFICACION_EMPRESA: TWideStringField;
    TblTecnoPersonaInternetNOMBRE_EMPRESA: TWideStringField;
    TblTecnoPersonaInternetDIRECCION_EMPRESA: TWideStringField;
    TblTecnoPersonaInternetCDG_PAIS: TWideStringField;
    TblTecnoPersonaInternetCOD_MUN: TWideStringField;
    TblTecnoPersonaInternetTELEFONO_EMPRESA: TWideStringField;
    TblTecnoPersonaInternetEMAIL_EMPRESA: TWideStringField;
    TblTecnoPersonaInternetFAX: TWideStringField;
    TblTecnoPersonaInternetURL: TWideStringField;
    TblTecnoPersonaInternetIDENTIFICACION_PERSONA: TLargeintField;
    TblTecnoPersonaInternetTIPIDENTIFICACION_PERSONA: TWideStringField;
    TblTecnoPersonaInternetNOMBRE_PERSONA: TWideStringField;
    TblTecnoPersonaInternetCARGO_PERSONA: TWideStringField;
    TblTecnoPersonaInternetTELEFONO_PERSONA: TWideStringField;
    TblTecnoPersonaInternetEMAIL_PERSONA: TWideStringField;
    TblTecnoPersonaInternetUSUARIO: TWideStringField;
    TblTecnoPersonaInternetACTIVO: TSmallintField;
    TblTecnoPersonaInternetID_ROL_USUARIO: TIntegerField;
    TblTecnoPersonaInternetPREGUNTA: TWideStringField;
    TblTecnoPersonaInternetRESPUESTA: TWideStringField;
    TblTecnoPersonaInternetFECHA_INGRESO: TSQLTimeStampField;
    TblTecnoPersonaInternetPASSWORD: TWideStringField;
    TblTecnoPersonaInternetSESSION: TWideStringField;
    TblTecnoPersonaInternetESTADO_USUARIO: TWideStringField;
    TblTecnoPersonaInternetCLASIFICACION_USUARIO: TWideStringField;
    TblTecnoPersonaInternetCOD_DEPART: TWideStringField;
    TblTecnoUsuarios: TFDTable;
    TblTecnoUsuariosCONSECUTIVO: TIntegerField;
    TblTecnoUsuariosREPORTE: TWideStringField;
    TblTecnoUsuariosNOMBRE_REPORTANTE: TWideStringField;
    TblTecnoUsuariosSEXO: TWideStringField;
    TblTecnoUsuariosEDAD: TSmallintField;
    TblTecnoUsuariosEDAD_EN: TWideStringField;
    TblTecnoUsuariosDIRECCION_REPORTANTE: TWideStringField;
    TblTecnoUsuariosTELEFONO: TWideStringField;
    TblTecnoUsuariosPAIS: TWideStringField;
    TblTecnoUsuariosCOD_DEPART: TWideStringField;
    TblTecnoUsuariosCOD_MUN: TWideStringField;
    TblTecnoUsuariosEMAIL: TWideStringField;
    TblTecnoUsuariosNOMBRE_DM: TWideStringField;
    TblTecnoUsuariosNOMBRE_COMERCIAL: TWideStringField;
    TblTecnoUsuariosNROREGSAN: TWideStringField;
    TblTecnoUsuariosLOTE: TWideStringField;
    TblTecnoUsuariosREFERENCIA: TWideStringField;
    TblTecnoUsuariosNOMBRE_FABRICANTE: TWideStringField;
    TblTecnoUsuariosNOMBRE_DISTRIB_IMPORT: TWideStringField;
    TblTecnoUsuariosFECHA_EVENTO: TSQLTimeStampField;
    TblTecnoUsuariosFECHA_NOTIFICACION: TSQLTimeStampField;
    TblTecnoUsuariosCDG_EVENTODETECCION: TIntegerField;
    TblTecnoUsuariosDESCRIPCION_EVENTO: TMemoField;
    TblTecnoUsuariosCDGFUNCIONARIO: TSmallintField;
    TblTecnoUsuariosREVISADO: TWideStringField;
    FDTable1: TFDTable;
    FDTable2: TFDTable;
    FDTable3: TFDTable;
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
