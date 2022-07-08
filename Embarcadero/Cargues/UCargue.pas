unit UCargue;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Data.DB, Vcl.Grids, Vcl.DBGrids,
  Vcl.StdCtrls;

type
  TForm1 = class(TForm)
    OpenDialogExcel: TOpenDialog;
    btnAbrir: TButton;
    procedure btnAbrirClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

{$R *.dfm}

procedure TForm1.btnAbrirClick(Sender: TObject);
var
  Excel:OleVariant;
  fileName:String;
begin
  OpenDialogExcel.Execute;
  fileName:=OpenDialogExcel.FileName;
  Excel:=OleVariant('Excel.Application');
  Excel.Workbooks.Open(FileName);

end;

end.
