unit ULogin;

interface

uses
  System.SysUtils, System.Types, System.UITypes, System.Classes,
  System.Variants,
  FMX.Types, FMX.Controls, FMX.Forms, FMX.Graphics, FMX.StdCtrls,
  IPPeerClient,
  FMX.Controls.Presentation, FMX.Edit, UDM, UUtilidad, Uparametros,
  FMX.DialogService, FMX.Styles,
  FMX.Objects;

type
  TfrmLogin = class(TForm)
    txtUsuario: TEdit;
    txtClave: TEdit;
    btnIngreso: TButton;
    RectangleTop: TRectangle;
    RectangleBottom: TRectangle;
    RectangleRight: TRectangle;
    RectangleLeft: TRectangle;
    RectangleMain: TRectangle;
    lblUsuario: TLabel;
    lblContrasenia: TLabel;
    Image1: TImage;
    lblVersion: TLabel;
    procedure btnIngresoClick(Sender: TObject);
    procedure FormCloseQuery(Sender: TObject; var CanClose: Boolean);
    procedure FormCreate(Sender: TObject);
  private
    { Private declarations }
    function validarRol(const usuario: String): Boolean;
{$IF DEFINED(ANDROID)}
    function getVersion: String;
{$ENDIF}
{$IF DEFINED(MSWINDOWS)}
    function getVersionWin: String;
    procedure GetBuildInfo(var V1, V2, V3, V4: word);
{$ENDIF}
  public
    { Public declarations }
  end;

var
  frmLogin: TfrmLogin;

implementation

{$R *.fmx}

{$IF DEFINED(MSWINDOWS)}
uses UCargue, Winapi.Windows;
{$ENDIF}

{$IF DEFINED(ANDROID)}
uses UCargue;
{$ENDIF}

type
  TAction = (aSuccess, aTryAgain, aGiveup, aWrongPassword, aPasswordExpired);

procedure TfrmLogin.btnIngresoClick(Sender: TObject);
var
  cadena: String;
  param: TStrings;
  queHacer: TAction;
begin
  if txtUsuario.Text <> '' then
  begin
    if txtClave.Text <> '' then
    begin
      With DM do
      begin
        { DriverName=ASE
          HostName=sivicos
          User_Name=sa
          Password=*****
          Database=sivicos
          DriverID=TDBX }
        //ConectaRegistro.Params.Clear;
        ConectaRegistroFD.Params.Clear;
        // ConectaRegistro.Params.Add('DriverID=TDBX');
        (*ConectaRegistro.Params.Add('DriverName=ASE');
        ConectaRegistro.Params.Add('HostName=' + TUtilidad.obtenerKey
          ('Conexion', 'ServerName'));
        ConectaRegistro.Params.Add('DataBase=sivicos');
        ConectaRegistro.Params.Add('User_Name=' + txtUsuario.Text);
        ConectaRegistro.Params.Add('Password=' + txtClave.Text);
        ConectaRegistro.Params.Add('BlobSize=-1');
        ConectaRegistro.Params.Add('ErrorResourceFile=');
        ConectaRegistro.Params.Add('LocaleCode=0000');
        ConectaRegistro.Params.Add('IsolationLevel=ReadCommitted');*)
        //FD SQL Server
        ConectaRegistroFD.Params.Add('DriverID=MSSQL');
        ConectaRegistroFD.Params.Add('OSAuthent=No');
        ConectaRegistroFD.Params.Add('Server=' + TUtilidad.obtenerKey
          ('Conexion', 'ServerName'));
        ConectaRegistroFD.Params.Add('DataBase=sivicos');
        ConectaRegistroFD.Params.Add('User_Name=' + txtUsuario.Text);
        ConectaRegistroFD.Params.Add('Password=' + txtClave.Text);
        (*ConectaRegistroFD.Params.Add('BlobSize=-1');
        ConectaRegistroFD.Params.Add('ErrorResourceFile=');
        ConectaRegistroFD.Params.Add('LocaleCode=0000');
        ConectaRegistroFD.Params.Add('IsolationLevel=ReadCommitted');*)
        try
          ConectaRegistroFD.Connected := true;
          parametros := TParametros.Create;
          parametros.Params := ConectaRegistroFD.Params;
          parametros.usuario := txtUsuario.Text;
        except
          on E: Exception do
          begin
            TDialogService.ShowMessage(E.Message);
          end;
        end;
        if Not(DM.ConectaRegistroFD.Connected) then
          queHacer := aGiveup;
        case queHacer of
          aWrongPassword:
            begin
              TDialogService.ShowMessage('Usuario o Contraseña errados, intente nuevamente');
              queHacer := aTryAgain;
            end;
          aGiveup:
            begin
              TDialogService.ShowMessage('Usuario o Contraseña errados, intente nuevamente');
              queHacer := aTryAgain;
            end;
        else
          queHacer := aSuccess;
        end;
        if NOT(queHacer in [aSuccess, aTryAgain]) then
        begin
          Application.Terminate;
        end
        else
        begin
          // ingresar a la solucion
          if queHacer = aSuccess then
          begin
            // Validar si el usario tiene el rol
            if Self.validarRol(txtUsuario.Text) then
            begin
              frmLogin.Tag := 1;
              Self.Hide;
              frmCargueTecno := TfrmCargueTecno.Create(Application);
              frmCargueTecno.Show;
              frmLogin.Destroy;
            end
            else
            begin
              TDialogService.ShowMessage('Usuario no posee permisos para esta aplicación');
            end;
          end;
        end;
      end
    end
    else
    begin
      TDialogService.ShowMessage('Por favor digite la contraseña');
    end;
  end
  else
  begin
    TDialogService.ShowMessage('Por favor digite el Nombre de Usuario');
  end;
end;

procedure TfrmLogin.FormCloseQuery(Sender: TObject; var CanClose: Boolean);
var
  msg: String;
  b: Boolean;
begin
  msg := 'Realmente Deseas salir?';
  TDialogService.MessageDialog(msg, TMsgDlgType.mtInformation,
    [TMsgDlgBtn.mbYes, TMsgDlgBtn.mbNo], TMsgDlgBtn.mbNo, 0,
    procedure(const AResult: TModalResult)
    begin
      if AResult = mrYes then
      begin
        b := true;
      end
      else
      begin
        b := false
      end;
    end);
  if b then
  begin
    CanClose := true; { FIXME: don't want to work on Android }
    Application.Terminate;
  end
  else
  begin
    CanClose := false;
  end;
end;

procedure TfrmLogin.FormCreate(Sender: TObject);
var
  EST: TFmxObject;
  nom_estilo: string;
begin
{$IF DEFINED(MSWINDOWS)  }
  nom_estilo := 'windows_style';
  // nom_estilo := '';
  // EST :=  TStyleManager.LoadFromResource(HInstance,nom_estilo,RT_RCDATA);
  EST := TStyleManager.GetStyleResource(nom_estilo);
  lblVersion.Text := 'Versión ' + Self.getVersionWin + ' (INVIMA)';
{$ENDIF}
  if Assigned(EST) then
    TStyleManager.SetStyle(EST);
end;

function TfrmLogin.validarRol(const usuario: String): Boolean;
var
  cadena: String;
  valor, sw: Boolean;
begin
  with DM do
  begin
    valor := false;
    cadena := 'exec sp_helprotect ' + usuario;
    { QryPermisos.SQL.Clear;
      QryPermisos.SQL.Text := cadena;
      QryPermisos.Open;
      if Not QryPermisos.IsEmpty then
      begin
      sw := false;
      while (Not QryPermisos.Eof) AND (Not sw) do
      begin
      if QryPermisos.FieldByName('grantee').AsString = TUtilidad.obtenerKey
      ('Conexion', 'Role') then
      sw := true;
      QryPermisos.Next;
      end;
      if sw then
      valor := true;
      end;
      QryPermisos.Close; }
    // Temporal
    valor := true;
  end;
  Result := valor;
end;

{$IF DEFINED(MSWINDOWS)}

function TfrmLogin.getVersionWin: String;
var
  V1, V2, V3, V4: word;
begin
  GetBuildInfo(V1, V2, V3, V4);
  Result := IntToStr(V1) + '.' + IntToStr(V2) + '.' + IntToStr(V3) + '.' +
    IntToStr(V4);
end;

procedure TfrmLogin.GetBuildInfo(var V1, V2, V3, V4: word);
var
  VerInfoSize, VerValueSize, Dummy: DWORD;
  VerInfo: Pointer;
  VerValue: PVSFixedFileInfo;
begin
  VerInfoSize := GetFileVersionInfoSize(PChar(ParamStr(0)), Dummy);
  if VerInfoSize > 0 then
  begin
    GetMem(VerInfo, VerInfoSize);
    try
      if GetFileVersionInfo(PChar(ParamStr(0)), 0, VerInfoSize, VerInfo) then
      begin
        VerQueryValue(VerInfo, '\', Pointer(VerValue), VerValueSize);
        with VerValue^ do
        begin
          V1 := dwFileVersionMS shr 16;
          V2 := dwFileVersionMS and $FFFF;
          V3 := dwFileVersionLS shr 16;
          V4 := dwFileVersionLS and $FFFF;
        end;
      end;
    finally
      FreeMem(VerInfo, VerInfoSize);
    end;
  end;
end;
{$ENDIF}
{$IF DEFINED(ANDROID)}

function TfrmLogin.getVersion: String;
begin
  Result := JStringToString(SharedActivityContext.getPackageManager.
    getPackageInfo(SharedActivityContext.getPackageName, 0).versionName);
end;
{$ENDIF}

end.
