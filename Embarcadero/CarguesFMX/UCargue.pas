unit UCargue;

interface

uses
  System.SysUtils, System.Types, System.UITypes, System.Classes,
  System.Variants, System.Generics.Collections, System.Threading,
  FMX.Types, FMX.Controls, FMX.Forms, FMX.Graphics, FMX.Dialogs,
  FMX.Controls.Presentation, FMX.StdCtrls, FMX.TMSBaseControl, FMX.TMSGridCell,
  FMX.TMSGridOptions, FMX.TMSGridData, FMX.TMSCustomGrid, FMX.TMSGrid,
  FMX.GridExcelIO, UDM, UParametros, FMX.DialogService, UValidaciones;

type
  TfrmCargueTecno = class(TForm)
    OpenDialogExcel: TOpenDialog;
    btnAbrir: TButton;
    GridExcelIO: TTMSFMXGridExcelIO;
    pnlPrincipal: TPanel;
    PnlBotones: TPanel;
    GridExcel: TTMSFMXGrid;
    btnCargar: TButton;
    lblUsuario: TLabel;
    SaveDialogExcel: TSaveDialog;
    btnSalvarExcel: TButton;
    AniIndicator1: TAniIndicator;
    lblNombreUsuario: TLabel;
    procedure btnAbrirClick(Sender: TObject);
    procedure btnCargarClick(Sender: TObject);
    procedure FormCreate(Sender: TObject);
    procedure FormCloseQuery(Sender: TObject; var CanClose: Boolean);
    procedure btnSalvarExcelClick(Sender: TObject);
  private
    { Private declarations }
    function generarNumReporte: String;
    function cargarEventos: String;
  public
    { Public declarations }
  end;

var
  frmCargueTecno: TfrmCargueTecno;
  fileName: String;

implementation

{$R *.fmx}

procedure TfrmCargueTecno.btnAbrirClick(Sender: TObject);
var
  aTask: ITask;
begin
  OpenDialogExcel.Title := 'Abrir excel a cargar';
  OpenDialogExcel.Filter := 'Microsoft Excel|*.xls';
  OpenDialogExcel.DefaultExt := 'xls';
  OpenDialogExcel.FilterIndex := 1;
  aTask := TTask.Create(
    procedure()
    begin
      AniIndicator1.Visible := true;
      AniIndicator1.Enabled := true;
      fileName := OpenDialogExcel.fileName;
      TThread.Synchronize(nil,
        procedure()
        begin
          GridExcelIO.XLSImport(OpenDialogExcel.fileName,
            'Plantilla de cargue');
        end);
      AniIndicator1.Visible := false;
      AniIndicator1.Enabled := true;
    end);
  if OpenDialogExcel.Execute then
  begin
    aTask.Start;
  end;
end;

procedure TfrmCargueTecno.btnCargarClick(Sender: TObject);
begin
  TDialogService.ShowMessage(self.cargarEventos);
end;

procedure TfrmCargueTecno.btnSalvarExcelClick(Sender: TObject);
var
  aTask: ITask;
begin
  SaveDialogExcel.Title := 'Almacenar Excel resultante';
  SaveDialogExcel.Filter := 'Microsoft Excel|*.xls';
  SaveDialogExcel.DefaultExt := 'xls';
  SaveDialogExcel.FilterIndex := 1;
  aTask := TTask.Create(
    procedure()
    begin
      AniIndicator1.Visible := true;
      AniIndicator1.Enabled := true;
      TThread.Synchronize(nil,
        procedure()
        begin
          GridExcelIO.XLSExport(SaveDialogExcel.fileName);
          TDialogService.ShowMessage('Almacenada correctamente');
        end);
      AniIndicator1.Visible := false;
      AniIndicator1.Enabled := true;
    end);
  if SaveDialogExcel.Execute then
  begin
    aTask.Start;

  end;
end;

function TfrmCargueTecno.cargarEventos: String;
var
  reporte, insertar: String;
  row, col: Integer;
  I, dato, FoundIndex: Integer;
  tipoidentificacion, edadEn, genero, naturaleza, estadoCaso: TArray<String>;
begin
  // Recorre desde la fila 1
  I := 1;
  // for I := 1 to GridExcel.RowCount do
  while GridExcel.Cells[1, I] <> '' do
  begin
    reporte := self.generarNumReporte;
    insertar :=
      'INSERT INTO tecno_reporte_eventos(reporte,fechevento,descripcion_evento,cdg_eventodeteccion,cdg_tiporeporte,fechreporte_evento,'
      + 'cdg_origenreporte,cdg_tipoeventoincidente,internet,fechaingreso,reportado,cdg_desenlace,desenlace_otro)'
      + 'values(' + QuotedStr(reporte) + ',' +
      QuotedStr(FormatDateTime('yyyy/mm/dd hh:nn:ss',
      TValidar.convertiraSoloFecha(GridExcel.Cells[1, I]))) + ',' +
      QuotedStr(GridExcel.Cells[2, I]) + ',' + GridExcel.Cells[3, I] + ',' +
      GridExcel.Cells[4, I] + ',' +
      QuotedStr(FormatDateTime('yyyy/mm/dd hh:nn:ss',
      TValidar.convertiraSoloFecha(GridExcel.Cells[5, I]))) + ',' +
      GridExcel.Cells[6, I] + ',' + GridExcel.Cells[7, I] + ',' +
      QuotedStr(GridExcel.Cells[8, I]) + ',' +
      QuotedStr(FormatDateTime('yyyy/mm/dd hh:nn:ss', now)) + ',' +
      QuotedStr('I') + ',';
    DM.QryTipoDesenlace.ParamByName('dato').AsString := GridExcel.Cells[12, I];
    DM.QryTipoDesenlace.Active := true;
    dato := DM.QryTipoDesenlace.FieldByName('cdg_desenlace').AsInteger;
    DM.QryTipoDesenlace.Close;
    insertar := insertar + IntToStr(dato) + ',';
    if GridExcel.Cells[12, I].StartsWith('Otro') then
    begin
      insertar := insertar + QuotedStr(GridExcel.Cells[11, I]);
    end
    else
    begin
      insertar := insertar + 'NULL';
    end;
    insertar := insertar + ')';
    DM.QryOperaciones.Close;
    DM.QryOperaciones.SQL.Clear;
    DM.QryOperaciones.SQL.Text := insertar;
    try
      DM.QryOperaciones.ExecSQL;
    finally
      DM.QryOperaciones.Close;
    end;
    // Insertar tecno_dispositivo
    insertar :=
      'INSERT INTO tecno_dispositivo(reporte,expediente,nroregsan,nombre_dispositivo,nombre_comercial,lote,referencia,'
      + 'modelo,serial,cdg_unicodispositivo,fabricante_usuario,distribuidor_usuario,utilizado,area_funciona,cdg_tipodispositivo)'
      + 'VALUES(' + QuotedStr(reporte) + ',' + GridExcel.Cells[13, I] + ',' +
      QuotedStr(GridExcel.Cells[14, I]) + ',' + QuotedStr(GridExcel.Cells[15, I]
      ) + ',' + QuotedStr(GridExcel.Cells[16, I]) + ',' +
      QuotedStr(GridExcel.Cells[17, I]) + ',' + QuotedStr(GridExcel.Cells[18, I]
      ) + ',' + QuotedStr(GridExcel.Cells[19, I]) + ',' +
      QuotedStr(GridExcel.Cells[20, I]) + ',' + GridExcel.Cells[21, I] + ',' +
      QuotedStr(GridExcel.Cells[22, I]) + ',' + QuotedStr(GridExcel.Cells[23, I]
      ) + ',UPPER(' + QuotedStr(GridExcel.Cells[24, I]) + '),' +
      QuotedStr(GridExcel.Cells[25, I]) + ',';
    DM.QryTipoDispositivo.ParamByName('dato').AsString :=
      GridExcel.Cells[26, I];
    DM.QryTipoDispositivo.Active := true;
    if Not DM.QryTipoDispositivo.IsEmpty then
    begin
      insertar := insertar + DM.QryTipoDispositivo.FieldByName
        ('cdg_tipodispositivo').AsString + ')'
    end
    else
    begin
      insertar := insertar + 'NULL)';
    end;
    DM.QryOperaciones.Close;
    DM.QryOperaciones.SQL.Clear;
    DM.QryOperaciones.SQL.Text := insertar;
    try
      DM.QryOperaciones.ExecSQL;
    finally
      DM.QryOperaciones.Close;
    end;
    // Insertar tecno_paciente
    tipoidentificacion := TArray<String>.Create('AI', 'CC', 'CE', 'HC', 'MI',
      'PS', 'RC', 'TI');
    insertar :=
      'INSERT INTO tecno_paciente(reporte,tipidentificacion,identificacion,edad,edad_en,genero,diagnostico_paciente,institucion_reportente,naturaleza,direccion_reportante,'
      + 'cod_mun1,cod_depart1,telefono_reportante,email_reportante,contacto_reportante,institucion_incidente,identificacion1,cod_depart,cod_mun,'
      + 'nivel_complejidad,cargo_inst,fecha_notif,autorizacion,tipo_reportante) VALUES('
      + QuotedStr(reporte) + ',';
    // Poner col en celda
    if TArray.BinarySearch(tipoidentificacion, GridExcel.Cells[27, I],
      FoundIndex) then
    begin
      insertar := insertar + QuotedStr(GridExcel.Cells[27, I]) + ',';
    end
    else
    begin
      insertar := insertar + 'NULL,';
    end;
    insertar := insertar + QuotedStr(GridExcel.Cells[28, I]) + ',' +
      QuotedStr(GridExcel.Cells[29, I]) + ',';
    edadEn := TArray<String>.Create('Años', 'Meses', 'Dias', 'Semana');
    if TArray.BinarySearch(edadEn, GridExcel.Cells[30, I], FoundIndex) then
    begin
      insertar := insertar + QuotedStr((GridExcel.Cells[30, I])[1]) + ',';
    end
    else
    begin
      insertar := insertar + 'NULL,';
    end;

    genero := TArray<String>.Create('FEMENINO', 'MASCULINO');
    if TArray.BinarySearch(genero, GridExcel.Cells[31, I], FoundIndex) then
    begin
      insertar := insertar + QuotedStr(GridExcel.Cells[31, I][1]) + ',';
    end
    else
    begin
      insertar := insertar + 'NULL,';
    end;
    insertar := insertar + QuotedStr(GridExcel.Cells[32, I]) + ',' +
      QuotedStr(GridExcel.Cells[33, I]) + ',';
    naturaleza := TArray<String>.Create('Publica', 'Privada', 'Mixta');
    if TArray.BinarySearch(naturaleza, GridExcel.Cells[34, I], FoundIndex) then
    begin
      insertar := insertar + QuotedStr(copy(GridExcel.Cells[34, I], 1, 2)
        .ToUpper) + ',';
    end
    else
    begin
      insertar := insertar + 'NULL,';
    end;
    insertar := insertar + QuotedStr(GridExcel.Cells[35, I]) + ',';
    DM.QryCiudadesDpto.ParamByName('ciudad').AsString := GridExcel.Cells[36, I];
    DM.QryCiudadesDpto.ParamByName('departamento').AsString :=
      GridExcel.Cells[37, I];
    DM.QryCiudadesDpto.Active := true;
    if Not DM.QryCiudadesDpto.IsEmpty then
    begin
      insertar := insertar + QuotedStr(DM.QryCiudadesDpto.FieldByName('cod_mun')
        .AsString) + ',' +
        QuotedStr(DM.QryCiudadesDpto.FieldByName('cod_depart').AsString) + ',';
    end
    else
    begin
      insertar := insertar + 'NULL,NULL,';
    end;
    DM.QryCiudadesDpto.Close;
    insertar := insertar + GridExcel.Cells[38, I] + ',' +
      QuotedStr(GridExcel.Cells[39, I]) + ',' + QuotedStr(GridExcel.Cells[40, I]
      ) + ',' + QuotedStr(GridExcel.Cells[41, I]) + ',' +
      QuotedStr(GridExcel.Cells[42, I]) + ',';
    DM.QryCiudadesDpto.ParamByName('ciudad').AsString := GridExcel.Cells[44, I];
    DM.QryCiudadesDpto.ParamByName('departamento').AsString :=
      GridExcel.Cells[43, I];
    DM.QryCiudadesDpto.Active := true;
    if Not DM.QryCiudadesDpto.IsEmpty then
    begin
      insertar := insertar +
        QuotedStr(DM.QryCiudadesDpto.FieldByName('cod_depart').AsString) + ',' +
        QuotedStr(DM.QryCiudadesDpto.FieldByName('cod_mun').AsString) + ',';
    end
    else
    begin
      insertar := insertar + 'NULL,NULL,';
    end;
    DM.QryCiudadesDpto.Close;
    insertar := insertar + QuotedStr(GridExcel.Cells[45, I]) + ',';
    // Profesion
    DM.QryProfesion.ParamByName('profesion').AsString := GridExcel.Cells[46, I];
    DM.QryProfesion.Active := true;
    if not DM.QryProfesion.IsEmpty then
    begin
      insertar := insertar +
        IntToStr(DM.QryProfesion.FieldByName('cdg_profesion').AsInteger) + ',';
    end
    else
    begin
      insertar := insertar + 'NULL,';
    end;
    DM.QryProfesion.Close;
    insertar := insertar + QuotedStr(FormatDateTime('yyyy-mm-dd hh:nn:ss',
      TValidar.convertiraSoloFecha(GridExcel.Cells[47, I]))) + ',' +
      QuotedStr(GridExcel.Cells[48, I]) + ',' + GridExcel.Cells[49, I] + ')';
    DM.QryOperaciones.Close;
    DM.QryOperaciones.SQL.Clear;
    DM.QryOperaciones.SQL.Text := insertar;
    try
      DM.QryOperaciones.ExecSQL;
    finally
      DM.QryOperaciones.Close;
    end;
    // Insertar tecno_evaluacion_caso
    insertar :=
      'INSERT INTO tecno_evaluacion_caso(reporte,cdg_causa,acciones,estado_caso,seguimiento,medida_ejecutada,'
      + 'notificacion,fecha_notificacion,fecha_importador,dispositivo_evaluacion,enviado_importador,cdgfuncionario)'
      + 'VALUES(' + QuotedStr(reporte) + ',';
    // obtener causa
    DM.QryCausaProbable.ParamByName('termino').AsString :=
      GridExcel.Cells[50, I];
    DM.QryCausaProbable.Active := true;
    if not DM.QryCausaProbable.IsEmpty then
    begin
      insertar := insertar +
        IntToStr(DM.QryCausaProbable.FieldByName('cdg_causa').AsInteger) + ',';
    end
    else
    begin
      insertar := insertar + 'NULL,';
    end;
    insertar := insertar + QuotedStr(GridExcel.Cells[51, 0]) + ',';
    estadoCaso := TArray<String>.Create('Abierto', 'Seguimiento', 'Cerrado');
    if TArray.BinarySearch(estadoCaso, GridExcel.Cells[54, I], FoundIndex) then
    begin
      insertar := insertar + QuotedStr(copy(GridExcel.Cells[54, I], 1,
        2)) + ',';
    end
    else
    begin
      insertar := insertar + 'NULL,';
    end;
    insertar := insertar + QuotedStr(GridExcel.Cells[60, I]) + ',' +
      QuotedStr(GridExcel.Cells[61, I]) + ',' + QuotedStr(GridExcel.Cells[62, I]
      ) + ',' + QuotedStr(FormatDateTime('yyyy/mm/dd hh:nn:ss',
      TValidar.convertiraSoloFecha(GridExcel.Cells[63, I]))) + ',' +
      QuotedStr(FormatDateTime('yyyy/mm/dd hh:nn:ss',
      TValidar.convertiraSoloFecha(GridExcel.Cells[64, I]))) + ',' +
      QuotedStr(GridExcel.Cells[65, I]) + ',' +
      QuotedStr(GridExcel.Cells[66, I]) + ',';
    DM.QryFuncionario.ParamByName('login').AsString := parametros.usuario;
    DM.QryFuncionario.Active := true;
    if not DM.QryFuncionario.IsEmpty then
    begin
      insertar := insertar +
        IntToStr(DM.QryFuncionario.FieldByName('cdgfuncionario')
        .AsInteger) + ')';
    end;
    DM.QryFuncionario.Close;
    DM.QryOperaciones.Close;
    DM.QryOperaciones.SQL.Clear;
    DM.QryOperaciones.SQL.Text := insertar;
    try
      DM.QryOperaciones.ExecSQL;
    finally
      DM.QryOperaciones.Close;
    end;
    GridExcel.Cells[0, I] := reporte;
    Inc(I);
  end;
  // aca se debe salvar el archivo
  // GridExcelIO.XLSExport(fileName);
  Result := 'OK';
end;

procedure TfrmCargueTecno.FormCloseQuery(Sender: TObject;
var CanClose: Boolean);
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

procedure TfrmCargueTecno.FormCreate(Sender: TObject);
begin
  lblUsuario.Text := parametros.usuario;
  DM.QryFuncionario.ParamByName('login').AsString := parametros.usuario;
  DM.QryFuncionario.Active := true;
  if not DM.QryFuncionario.IsEmpty then
  begin
    lblNombreUsuario.Text := DM.QryFuncionario.FieldByName
      ('nmbfuncionario').AsString;
  end;
  DM.QryFuncionario.Close;
end;

function TfrmCargueTecno.generarNumReporte: String;
var
  codigo, datosFecha, consulta: String;
  fecha: TDate;
  consecutivo: Integer;
begin
  fecha := Date;
  datosFecha := FormatDateTime('yymm', fecha);
  codigo := 'COL' + datosFecha;
  With DM do
  begin
    QryParametros.SQL.Clear;
    // QryParametros.SchemaName := 'dbo';
    QryParametros.SQL.Text := 'select consec_dispositivo from parametros';
    QryParametros.Active := true;
    if Not QryParametros.IsEmpty then
    begin
      consecutivo := QryParametros.FieldByName('consec_dispositivo').AsInteger;
      // Poner ceros antes del numero
      codigo := codigo + Format(Format('%%.%dd', [5]), [consecutivo]);
      // Actualizar parametros
      consulta := 'UPDATE parametros set consec_dispositivo=' +
        IntToStr(consecutivo + 1);
      consulta := consulta + ' where ID=1';
      QryOperaciones.Close;
      QryOperaciones.SQL.Clear;
      QryOperaciones.SQL.Text := consulta;
      try
        QryOperaciones.ExecSQL;
      finally
        QryOperaciones.Close;
      end;
    end
    else
    begin
      codigo := 'ERROR';
    end;
    QryParametros.Close;
  end;
  Result := codigo;
end;

end.
