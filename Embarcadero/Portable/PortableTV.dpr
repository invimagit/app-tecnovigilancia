program PortableTV;

uses
  System.StartUpCopy,
  FMX.Forms,
  UInicial in 'UInicial.pas' {FrmInicial},
  UConsultarUsuario in 'UConsultarUsuario.pas' {frmConsultaUsuario},
  UsuariosVO in 'VO\UsuariosVO.pas',
  UDM in 'DM\UDM.pas' {DM: TDataModule},
  UToken in 'UToken.pas',
  UUtilidad in 'Res\UUtilidad.pas',
  UValidaciones in 'Res\UValidaciones.pas',
  UClienteServicio in 'Servicios\UClienteServicio.pas',
  UEncripcionUtils in 'Res\UEncripcionUtils.pas';

{$R *.res}

begin
  Application.Initialize;
  Application.CreateForm(TfrmConsultaUsuario, frmConsultaUsuario);
  Application.CreateForm(TDM, DM);
  Application.Run;
end.
