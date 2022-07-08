unit UParametros;

interface

uses
  System.classes;

type
  TParametros = class
  private
    Fparams: TStrings;
    Fusuario: String;

  public
    property params: TStrings read Fparams write Fparams;
    property usuario: String read Fusuario write Fusuario;
  end;

var
  parametros: TParametros;

implementation

end.
