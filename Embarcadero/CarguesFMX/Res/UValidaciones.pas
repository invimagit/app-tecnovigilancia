unit UValidaciones;

interface

uses
  System.SysUtils, System.Classes;

type

  TValidar = class
  public
    class function convertiraFecha(fecStr: String; op: String)
      : TDateTime; static;
    class function convertiraSoloFecha(fecStr: String): TDate; static;
    class function validarCaracter(cad: String): Char; static;
    class function validarEntero(cad: String): Integer; static;
    class function validarFecha(cad: String): TDateTime; static;
    class function validarExtended(cad: String): Extended; static;
    class function fecha2Cadena(fecha: TDateTime): String; static;
    class function fecha2CadenaJSON(fecha: TDateTime): String; static;
  end;

implementation

uses
  FMX.DialogService;

{ TValidar }

class function TValidar.convertiraFecha(fecStr: String; op: String): TDateTime;
var
  format: TFormatSettings;
  list, listhora: TStrings;
  hora, fecha: String;
begin
  if trim(fecStr) <> '' then
  begin
    // Formato Fecha

    format := TFormatSettings.Create;
    format.DateSeparator := '-';
    format.ShortDateFormat := 'yyyy-mm-dd';
    if op = 'L' then
    begin
      listhora := TStringList.Create;
      ExtractStrings([' '], [], PChar(fecStr), listhora);
      if listhora.Count = 2 then
      begin
        hora := listhora[1];
        fecha := listhora[0];
        list := TStringList.Create;
        ExtractStrings(['/'], [], PChar(fecha), list);
        if list.Count > 1 then
        begin
          fecStr := list[2] + '-' + list[1] + '-' + list[0] + ' ' + hora
        end
        else
        begin
          fecStr := fecStr;
        end;
      end
      else
      begin
        list := TStringList.Create;
        ExtractStrings(['/'], [], PChar(fecStr), list);
        if list.Count = 1 then
          fecStr := list[0]
        else
          fecStr := list[2] + '-' + list[1] + '-' + list[0];
      end;
    end;
    format.TimeSeparator := ':';
    format.LongTimeFormat := 'hh:nn:ss';
    Result := StrToDateTime(fecStr, format);
  end
  else
  begin
    Result := 0;
  end;

end;

class function TValidar.convertiraSoloFecha(fecStr: String): TDate;
var
  format: TFormatSettings;
begin
  if trim(fecStr) <> '' then
  begin
    // Formato Fecha
    format := TFormatSettings.Create;
    format.DateSeparator := '/';
    format.ShortDateFormat := 'mm-dd-yyyy';
    // format.TimeSeparator := ':';
    // format.LongTimeFormat := 'hh:nn:ss';
    Result := StrToDate(fecStr, format);
  end
  else
  begin
    Result := 0;
  end;
end;

class function TValidar.fecha2Cadena(fecha: TDateTime): String;
var
  format: TFormatSettings;
begin
  if (fecha >= MinDateTime) AND (fecha <= MaxDateTime) then
  begin
    format := TFormatSettings.Create;
    format.DateSeparator := '/';
    format.ShortDateFormat := 'yyyy/mm/dd';
    format.TimeSeparator := ':';
    format.LongTimeFormat := 'hh:nn:ss';
    Result := FormatDateTime('dd/mm/yyyy hh:nn:ss', fecha, format)
  end
  else
  begin
    Result := '';
  end;
end;

class function TValidar.fecha2CadenaJSON(fecha: TDateTime): String;
var
  format: TFormatSettings;
begin
  if (fecha >= MinDateTime) AND (fecha <= MaxDateTime) then
  begin
    format := TFormatSettings.Create;
    format.DateSeparator := '-';
    format.ShortDateFormat := 'yyyy-mm-dd';
    format.TimeSeparator := ':';
    format.LongTimeFormat := 'hh:nn:ss';
    Result := FormatDateTime('dd/mm/yyyy hh:nn:ss', fecha, format)
  end
  else
  begin
    Result := '';
  end;
end;



class function TValidar.validarCaracter(cad: String): Char;
begin
  if trim(cad) <> '' then
  begin
{$IF DEFINED(ANDROID)}
    Result := cad[0];
{$ENDIF}
{$IF DEFINED(MSWINDOWS)}
    Result := cad[1];
{$ENDIF}
  end
  else
  begin
    begin
      Result := #0;
    end;
  end;
end;

class function TValidar.validarEntero(cad: String): Integer;
var
  numeor: Integer;
begin
  if not TryStrToInt(cad, numeor) then
    numeor := 0;
  Result := numeor;
end;

class function TValidar.validarFecha(cad: String): TDateTime;
var
  tiempo: TDateTime;
begin
  if Not TryStrToDateTime(cad, tiempo) then
    tiempo := now;
  Result := tiempo;
end;

class function TValidar.validarExtended(cad: String): Extended;
var
  numero: Extended;
begin
{$IF DEFINED(MSWINDOWS)}
  if AnsiPos(',', cad) > 0 then
    cad := StringReplace(cad, ',', '.', [rfReplaceAll]);
{$ENDIF}
{$IF DEFINED(ANDROID)}
  if AnsiPos(',', cad) > 0 then
    cad := StringReplace(cad, ',', '.', [rfReplaceAll]);
{$ENDIF}
  if Not TryStrToFloat(cad, numero) then
    numero := 0.0;
  Result := numero;

end;

end.
