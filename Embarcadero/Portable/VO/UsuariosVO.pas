unit UsuariosVO;

interface

uses
  System.Generics.Collections, System.JSON, System.SysUtils, UValidaciones;

type
  TUsuariosVO = class(TObject)
  private
    FidentificacionEmpresa: Integer;
    FnombreDpto: String;
    FcargoPersona: String;
    FnombrePersona: String;
    FcodMun: String;
    Frespuesta: String;
    FdireccionEmpresa: String;
    Ffax: String;
    FtelefonoEmpresa: String;
    FiDRolUsuario: Integer;
    FcodDepart: String;
    FemailPersona: String;
    FnombreEmpresa: String;
    FtipidentificacionPersona: String;
    FidRol: String;
    Factivo: Integer;
    Fpregunta: String;
    FnombrePais: String;
    FidentificacionPersona: Int64;
    Fpassword: String;
    FestadoPalabra: String;
    FestadoUsuario: Char;
    FemailEmpresa: String;
    FrolPalabra: String;
    Furl: String;
    Fusuario: String;
    FtelefonoPersona: String;
    FtipidentificacionEmpresa: String;
    FclasificacionUsuario: String;
    FnombreMpio: String;
    FfechaIngreso: TDateTime;
    FcdgPais: String;
    Fsession: String;

  public
    constructor CreateWithID(const AidentificacionEmpresa: Integer;
      const AnombreDpto: String; const AcargoPersona: String;
      const AnombrePersona: String; const AcodMun: String;
      const Arespuesta: String; const AdireccionEmpresa: String;
      const Afax: String; const AtelefonoEmpresa: String;
      const AiDRolUsuario: Integer; const AcodDepart: String;
      const AemailPersona: String; const AnombreEmpresa: String;
      const AtipidentificacionPersona: String; const AidRol: String;
      const Aactivo: Integer; const Apregunta: String;
      const AnombrePais: String; const AidentificacionPersona: Int64;
      const Apassword: String; const AestadoPalabra: String;
      const AestadoUsuario: Char; const AemailEmpresa: String;
      const ArolPalabra: String; const Aurl: String; const Ausuario: String;
      const AtelefonoPersona: String; const AtipidentificacionEmpresa: String;
      const AclasificacionUsuario: String; const AnombreMpio: String;
      const AfechaIngreso: TDateTime; const AcdgPais: String;
      const Asession: String);
    property identificacionEmpresa: Integer read FidentificacionEmpresa
      write FidentificacionEmpresa;

    property tipidentificacionEmpresa: String read FtipidentificacionEmpresa
      write FtipidentificacionEmpresa;

    property nombreEmpresa: String read FnombreEmpresa write FnombreEmpresa;

    property direccionEmpresa: String read FdireccionEmpresa
      write FdireccionEmpresa;

    property cdgPais: String read FcdgPais write FcdgPais;

    property codDepart: String read FcodDepart write FcodDepart;

    property codMun: String read FcodMun write FcodMun;

    property telefonoEmpresa: String read FtelefonoEmpresa
      write FtelefonoEmpresa;

    property emailEmpresa: String read FemailEmpresa write FemailEmpresa;

    property fax: String read Ffax write Ffax;

    property url: String read Furl write Furl;

    property identificacionPersona: Int64 read FidentificacionPersona
      write FidentificacionPersona;

    property tipidentificacionPersona: String read FtipidentificacionPersona
      write FtipidentificacionPersona;

    property nombrePersona: String read FnombrePersona write FnombrePersona;

    property cargoPersona: String read FcargoPersona write FcargoPersona;

    property telefonoPersona: String read FtelefonoPersona
      write FtelefonoPersona;

    property emailPersona: String read FemailPersona write FemailPersona;

    property usuario: String read Fusuario write Fusuario;

    property activo: Integer read Factivo write Factivo;

    property iDRolUsuario: Integer read FiDRolUsuario write FiDRolUsuario;

    property idRol: String read FidRol write FidRol;

    property pregunta: String read Fpregunta write Fpregunta;

    property respuesta: String read Frespuesta write Frespuesta;

    property fechaIngreso: TDateTime read FfechaIngreso write FfechaIngreso;

    property password: String read Fpassword write Fpassword;

    property session: String read Fsession write Fsession;

    property estadoUsuario: Char read FestadoUsuario write FestadoUsuario;

    property clasificacionUsuario: String read FclasificacionUsuario
      write FclasificacionUsuario;

    property estadoPalabra: String read FestadoPalabra write FestadoPalabra;

    property rolPalabra: String read FrolPalabra write FrolPalabra;

    property nombrePais: String read FnombrePais write FnombrePais;

    property nombreDpto: String read FnombreDpto write FnombreDpto;

    property nombreMpio: String read FnombreMpio write FnombreMpio;
  end;

  TUsuariosVOJSON = class
  public type
    TCabecera = record
    public const
      identificacionEmpresa = 'identificacionEmpresa';
      nombreDpto = 'nombreDpto';
      cargoPersona = 'cargoPersona';
      nombrePersona = 'nombrePersona';
      codMun = 'codMun';
      respuesta = 'respuesta';
      direccionEmpresa = 'direccionEmpresa';
      fax = 'fax';
      telefonoEmpresa = 'telefonoEmpresa';
      iDRolUsuario = 'iDRolUsuario';
      codDepart = 'codDepart';
      emailPersona = 'emailPersona';
      nombreEmpresa = 'nombreEmpresa';
      tipidentificacionPersona = 'tipidentificacionPersona';
      idRol = 'idRol';
      activo = 'activo';
      pregunta = 'pregunta';
      nombrePais = 'nombrePais';
      identificacionPersona = 'identificacionPersona';
      password = 'password';
      estadoPalabra = 'estadoPalabra';
      estadoUsuario = 'estadoUsuario';
      emailEmpresa = 'emailEmpresa';
      rolPalabra = 'rolPalabra';
      url = 'url';
      usuario = 'usuario';
      telefonoPersona = 'telefonoPersona';
      tipidentificacionEmpresa = 'tipidentificacionEmpresa';
      clasificacionUsuario = 'clasificacionUsuario';
      nombreMpio = 'nombreMpio';
      fechaIngreso = 'fechaIngreso';
      cdgPais = 'cdgPais';
      session = 'session';
    end;
  public
    class function UsuariosVO2JSON(const parametros: TUsuariosVO)
      : TJSONObject; static;
    class function JSON2UsuariosVO(const JSON: TJSONValue): TUsuariosVO; static;
    class function UsuariosLst2JSON(const AUsuarios: TList<TUsuariosVO>)
      : TJSONArray; static;
    class function JSON2UsuariosLst(const AJson: TJSONArray)
      : TList<TUsuariosVO>; static;
  end;

implementation

{ TUsuariosVO }

constructor TUsuariosVO.CreateWithID(const AidentificacionEmpresa: Integer;
  const AnombreDpto, AcargoPersona, AnombrePersona, AcodMun, Arespuesta,
  AdireccionEmpresa, Afax, AtelefonoEmpresa: String;
  const AiDRolUsuario: Integer; const AcodDepart, AemailPersona, AnombreEmpresa,
  AtipidentificacionPersona, AidRol: String; const Aactivo: Integer;
  const Apregunta, AnombrePais: String; const AidentificacionPersona: Int64;
  const Apassword, AestadoPalabra: String; const AestadoUsuario: Char;
  const AemailEmpresa, ArolPalabra, Aurl, Ausuario, AtelefonoPersona,
  AtipidentificacionEmpresa, AclasificacionUsuario, AnombreMpio: String;
  const AfechaIngreso: TDateTime; const AcdgPais, Asession: String);
begin
  FidentificacionEmpresa := AidentificacionEmpresa;
  FnombreDpto := AnombreDpto;
  FcargoPersona := AcargoPersona;
  FnombrePersona := AnombrePersona;
  FcodMun := AcodMun;
  Frespuesta := Arespuesta;
  FdireccionEmpresa := AdireccionEmpresa;
  Ffax := Afax;
  FtelefonoEmpresa := AtelefonoEmpresa;
  FiDRolUsuario := AiDRolUsuario;
  FcodDepart := AcodDepart;
  FemailPersona := AemailPersona;
  FnombreEmpresa := AnombreEmpresa;
  FtipidentificacionPersona := AtipidentificacionPersona;
  FidRol := AidRol;
  Factivo := Aactivo;
  Fpregunta := Apregunta;
  FnombrePais := AnombrePais;
  FidentificacionPersona := AidentificacionPersona;
  Fpassword := Apassword;
  FestadoPalabra := AestadoPalabra;
  FestadoUsuario := AestadoUsuario;
  FemailEmpresa := AemailEmpresa;
  FrolPalabra := ArolPalabra;
  Furl := Aurl;
  Fusuario := Ausuario;
  FtelefonoPersona := AtelefonoPersona;
  FtipidentificacionEmpresa := AtipidentificacionEmpresa;
  FclasificacionUsuario := AclasificacionUsuario;
  FnombreMpio := AnombreMpio;
  FfechaIngreso := AfechaIngreso;
  FcdgPais := AcdgPais;
  Fsession := Asession;
end;

{ TUsuariosVOJSON }

class function TUsuariosVOJSON.JSON2UsuariosLst(const AJson: TJSONArray)
  : TList<TUsuariosVO>;
var
  Value: TJSONValue;
  lista: TList<TUsuariosVO>;
begin
  lista := TList<TUsuariosVO>.Create;
  try
    for Value in AJson do
    begin
      lista.Add(TUsuariosVOJSON.JSON2UsuariosVO(Value));
    end;
    Result := lista;
  finally
    // lista.Free;
  end;
end;

class function TUsuariosVOJSON.JSON2UsuariosVO(const JSON: TJSONValue)
  : TUsuariosVO;
var
  identificacionEmpresa, activo, iDRolUsuario: Integer;
  identificacionPersona: Int64;
  fechaIngreso: TDateTime;
  estadoUsuario: Char;
begin
  identificacionEmpresa := TValidar.validarEntero
    (JSON.GetValue(TCabecera.identificacionEmpresa, ''));
  activo := TValidar.validarEntero(JSON.GetValue(TCabecera.activo, ''));
  iDRolUsuario := TValidar.validarEntero
    (JSON.GetValue(TCabecera.iDRolUsuario, ''));
  identificacionPersona := TValidar.validarEntero
    (JSON.GetValue(TCabecera.identificacionPersona, ''));
  estadoUsuario := TValidar.validarCaracter
    (JSON.GetValue(TCabecera.estadoUsuario, ''));
  fechaIngreso := TValidar.convertiraFecha
    (JSON.GetValue(TCabecera.fechaIngreso, ''), 'W');
  Result := TUsuariosVO.CreateWithID(identificacionEmpresa,
    JSON.GetValue(TCabecera.nombreDpto, ''),
    JSON.GetValue(TCabecera.cargoPersona, ''),
    JSON.GetValue(TCabecera.nombrePersona, ''), JSON.GetValue(TCabecera.codMun,
    ''), JSON.GetValue(TCabecera.respuesta, ''),
    JSON.GetValue(TCabecera.direccionEmpresa, ''), JSON.GetValue(TCabecera.fax,
    ''), JSON.GetValue(TCabecera.telefonoEmpresa, ''), iDRolUsuario,
    JSON.GetValue(TCabecera.codDepart, ''),
    JSON.GetValue(TCabecera.emailPersona, ''),
    JSON.GetValue(TCabecera.nombreEmpresa, ''),
    JSON.GetValue(TCabecera.tipidentificacionPersona, ''),
    JSON.GetValue(TCabecera.idRol, ''), activo,
    JSON.GetValue(TCabecera.pregunta, ''), JSON.GetValue(TCabecera.nombrePais,
    ''), identificacionPersona, JSON.GetValue(TCabecera.password, ''),
    JSON.GetValue(TCabecera.estadoPalabra, ''), estadoUsuario,
    JSON.GetValue(TCabecera.emailEmpresa, ''),
    JSON.GetValue(TCabecera.rolPalabra, ''), JSON.GetValue(TCabecera.url, ''),
    JSON.GetValue(TCabecera.usuario, ''),
    JSON.GetValue(TCabecera.telefonoPersona, ''),
    JSON.GetValue(TCabecera.tipidentificacionEmpresa, ''),
    JSON.GetValue(TCabecera.clasificacionUsuario, ''),
    JSON.GetValue(TCabecera.nombreMpio, ''), fechaIngreso,
    JSON.GetValue(TCabecera.cdgPais, ''), JSON.GetValue(TCabecera.session, ''));
end;

class function TUsuariosVOJSON.UsuariosLst2JSON(const AUsuarios
  : TList<TUsuariosVO>): TJSONArray;
var
  usuario: TUsuariosVO;
  elemeto: TJSONObject;
  arreglo: TJSONArray;
begin
  arreglo := TJSONArray.Create;
  try
    for usuario in AUsuarios do
    begin
      elemeto := TUsuariosVOJSON.UsuariosVO2JSON(usuario);
      arreglo.Add(elemeto);
    end;
    Result := arreglo;
  finally
    // arreglo.Free;
  end;
end;

class function TUsuariosVOJSON.UsuariosVO2JSON(const parametros: TUsuariosVO)
  : TJSONObject;
begin
  Result := TJSONObject.Create;
  Result.AddPair(TCabecera.identificacionEmpresa,
    IntToStr(parametros.identificacionEmpresa));
  Result.AddPair(TCabecera.nombreDpto, parametros.nombreDpto);
  Result.AddPair(TCabecera.cargoPersona, parametros.cargoPersona);
  Result.AddPair(TCabecera.nombrePersona, parametros.nombrePersona);
  Result.AddPair(TCabecera.codMun, parametros.codMun);
  Result.AddPair(TCabecera.respuesta, parametros.respuesta);
  Result.AddPair(TCabecera.direccionEmpresa, parametros.direccionEmpresa);
  Result.AddPair(TCabecera.fax, parametros.fax);
  Result.AddPair(TCabecera.telefonoEmpresa, parametros.telefonoEmpresa);
  Result.AddPair(TCabecera.iDRolUsuario, IntToStr(parametros.iDRolUsuario));
  Result.AddPair(TCabecera.codDepart, parametros.codDepart);
  Result.AddPair(TCabecera.emailPersona, parametros.emailPersona);
  Result.AddPair(TCabecera.nombreEmpresa, parametros.nombreEmpresa);
  Result.AddPair(TCabecera.tipidentificacionPersona,
    parametros.tipidentificacionPersona);
  Result.AddPair(TCabecera.idRol, parametros.idRol);
  Result.AddPair(TCabecera.activo, IntToStr(parametros.activo));
  Result.AddPair(TCabecera.pregunta, parametros.pregunta);
  Result.AddPair(TCabecera.nombrePais, parametros.nombrePais);
  Result.AddPair(TCabecera.identificacionPersona,
    IntToStr(parametros.identificacionPersona));
  Result.AddPair(TCabecera.password, parametros.password);
  Result.AddPair(TCabecera.estadoPalabra, parametros.estadoPalabra);
  Result.AddPair(TCabecera.estadoUsuario, parametros.estadoUsuario);
  Result.AddPair(TCabecera.emailEmpresa, parametros.emailEmpresa);
  Result.AddPair(TCabecera.rolPalabra, parametros.rolPalabra);
  Result.AddPair(TCabecera.url, parametros.url);
  Result.AddPair(TCabecera.usuario, parametros.usuario);
  Result.AddPair(TCabecera.telefonoPersona, parametros.telefonoPersona);
  Result.AddPair(TCabecera.tipidentificacionEmpresa,
    parametros.tipidentificacionEmpresa);
  Result.AddPair(TCabecera.clasificacionUsuario,
    parametros.clasificacionUsuario);
  Result.AddPair(TCabecera.nombreMpio, parametros.nombreMpio);
  Result.AddPair(TCabecera.fechaIngreso,
    TValidar.fecha2CadenaJSON(parametros.fechaIngreso));
  Result.AddPair(TCabecera.cdgPais, parametros.cdgPais);
  Result.AddPair(TCabecera.session, parametros.session);
end;

end.
