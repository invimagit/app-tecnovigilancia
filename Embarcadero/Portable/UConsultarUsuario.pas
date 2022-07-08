unit UConsultarUsuario;

interface

uses
  System.SysUtils, System.Types, System.UITypes, System.Classes, System.Variants,
  FMX.Types, FMX.Controls, FMX.Forms, FMX.Graphics, FMX.Dialogs, FMX.Objects,
  FMX.Controls.Presentation, FMX.StdCtrls, FMX.Edit,UEncripcionUtils;

type
  TfrmConsultaUsuario = class(TForm)
    top: TRectangle;
    main: TRectangle;
    right: TRectangle;
    left: TRectangle;
    bottom: TRectangle;
    lblTitulo: TLabel;
    lblNumeroCedula: TLabel;
    txtNumeroCedula: TEdit;
    btnSincronizarXCedula: TButton;
    btnCancelar: TButton;
    btnIniciar: TButton;
    Edit1: TEdit;
    Edit2: TEdit;
    Edit3: TEdit;
    Button1: TButton;
    Edit4: TEdit;
    procedure Button1Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  frmConsultaUsuario: TfrmConsultaUsuario;

implementation

{$R *.fmx}

procedure TfrmConsultaUsuario.Button1Click(Sender: TObject);
begin
      Edit2.Text:=TEncripcionUtils.encripcion(Edit1.Text);
      Edit4.Text:=TEncripcionUtils.desEncriptar(Edit3.Text);
      ShowMessage(length(Edit2.Text).ToString);
end;

end.
