program CargueExcel;

uses
  Vcl.Forms,
  UCargue in 'UCargue.pas' {Form1};

{$R *.res}

begin
  Application.Initialize;
  Application.MainFormOnTaskbar := True;
  Application.CreateForm(TForm1, Form1);
  Application.Run;
end.
