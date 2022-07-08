unit UInicial;

interface

uses
  System.SysUtils, System.Types, System.UITypes, System.Classes, System.Variants,
  FMX.Types, FMX.Controls, FMX.Forms, FMX.Graphics, FMX.Dialogs, FMX.Objects,
  FMX.Controls.Presentation, FMX.StdCtrls;

type
  TFrmInicial = class(TForm)
    Top: TRectangle;
    botom: TRectangle;
    left: TRectangle;
    right: TRectangle;
    Main: TRectangle;
    lblMensaje: TLabel;
    btnContinuar: TButton;
    procedure FormCreate(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  FrmInicial: TFrmInicial;

implementation

{$R *.fmx}

procedure TFrmInicial.FormCreate(Sender: TObject);
begin
    lblMensaje.Text:='Bienvenidos al Sistema Portable de Tecnovigilancia'
                    +'configurado para la identificaci�n, recolecci�n, evaluaci�n,'
                    +' gesti�n y divulgaci�n de los eventos e incidentes adversos, '
                    +'que presentan los dispositivos m�dicos durante su uso, con '
                    +'el fin de mejorar la protecci�n de la salud y la seguridad de los pacientes,'
                    + ' usuarios y todo aquel que se vea implicado directa o '
                    +'indirectamente con la utilizaci�n de esta tecnolog�a sanitaria.'
                    +#13+#13+'Encontrar� en la barra izquierda las opciones disponibles'
                    +' de acuerdo a cada actor del Programa: Fabricantes e importadores '
                    +'y Prestadores de Servicios de Salud con el proposito de verificar '
                    +'y codificar la informaci�n por parte de los Entes Territoriales '
                    +'de Salud y los administradores del Grupo de Tecnovigilancia del Invima.'
                    +#13+#13
                    +'Como primer paso deber� realizar la inicializaci�n del usuario '
                    +'para acceder a los servicios de reporte. Recuerde que deber�'
                    +' estar inscrito en el Aplicativo Web de Tecnovigilancia para'
                    +' continuar con el proceso de inicializaci�n.  Clic en siguiente.';
end;

end.
