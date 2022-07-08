unit UUtilidad;

interface

uses
  System.types, System.Classes, System.SysUtils;

type

  TUtilidad = class
  private
    // NADA
  public
    class function obtenerKey(padre, hijo: String): String; static;
  end;

implementation

uses
  IniFiles, System.IOUtils;
{ TUtilidad }

class function TUtilidad.obtenerKey(padre, hijo: String): String;
var
  IniFile: TIniFile;
begin
  // Adnroid
{$IF DEFINED(ANDROID)}
  IniFile := TIniFile.Create(TPath.Combine(TPath.GetDocumentsPath,
    'parametros.ini'));
{$ENDIF}
  // Windows
{$IF DEFINED(MSWINDOWS)}
  IniFile := TIniFile.Create(ExtractFilePath(ParamStr(0)) + 'parametros.ini');
{$ENDIF}
  try
    Result := IniFile.ReadString(padre, hijo, '');
  finally
    IniFile.Free;
  end;
end;

end.
