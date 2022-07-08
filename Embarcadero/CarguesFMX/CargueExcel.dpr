program CargueExcel;

{$R *.dres}

uses
  System.StartUpCopy,
  FMX.Forms,
  UCargue in 'UCargue.pas' {frmCargueTecno},
  UDM in 'DM\UDM.pas' {DM: TDataModule},
  ULogin in 'ULogin.pas' {frmLogin},
  UParametros in 'DM\UParametros.pas',
  UUtilidad in 'DM\UUtilidad.pas',
  UValidaciones in 'Res\UValidaciones.pas';

{$R *.res}

begin
  Application.Initialize;
  Application.CreateForm(TDM, DM);
  Application.CreateForm(TfrmLogin, frmLogin);
  Application.Run;
end.
