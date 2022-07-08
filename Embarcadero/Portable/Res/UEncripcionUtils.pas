unit UEncripcionUtils;

interface

uses
  System.types,System.SysUtils,System.StrUtils;

type

  TEncripcionUtils = class
  private
    class function spaces(cantidad: Integer): String; static;
  public
    class function desEncriptar(as_str: String): String; static;
    class function encripcion(as_str: String): String; static;
  end;

implementation

{ TEncripcionUtils }

class function TEncripcionUtils.desEncriptar(as_str: String): String;
var
    i,j,li_llave, c1, c2, c3, c4, t1, t2, t3, t4, t5,t:Integer;
    ls_enc,ls_cadena, ls_cad, cadena1, cadena2, cadena3, cadena4, cadena5,c, cadena, ls_cad2:String;
    a,b,cx,d:TIntegerDynArray;
begin
        ls_enc := '';
        a := TIntegerDynArray.Create(0, 15, 200, 41, 38, 27, 12, 46, -15, -50, 12, 38, 21, 43, 90, 12, 101, 150, 180, 24, 13, 18, 19, 56, 1, 17, 29, -41, 47, 63, 81);
        b := TIntegerDynArray.Create(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        cx := TIntegerDynArray.Create(0, 12, 45, 67, -24, 87, 68, 25, 46, 101, 250, 34, 56, -18, 24, 56, 98, 135, 156, -12, 1, 10, 56, 23, 10, 19, 54, 145, 189, 206, 30);
        d := TIntegerDynArray.Create(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        ls_cad := '/' + as_str.trim();
        cadena1 := '/';
        cadena2 := '/';
        cadena3 := '/';
        cadena4 := '/';
        cadena5 := '/';
        cadena := '/';
        ls_cad2 := '/';
        t1 := 1;
        t:=1;
        while t <= 90 do
        begin
            b[t1] :=  StrToInt(ls_cad.substring(t, 3));
            if (b[t1] > 700) then begin
                b[t1] := (b[t1] * -1) + 700;
            end;
            inc(t1);
            Inc(t,3);
        end;

        ls_enc := '/';
        cadena := '/';
        for t:= 1 to 30 do
        begin
            b[t] := b[t] - cx[t];
        end;

        t1 := 1;
        for t := 30 downto 1 do begin
            d[t] := b[t] - a[t1];
            inc(t1);
        end;

        ls_cad2 := '/';
        for t := 1 to 30 do
        begin
            c1 := d[t] - a[t];
            c := chr(c1) + '';
            ls_cad2 := ls_cad2+ c;
        end;

        cadena1 := '/' + ls_cad2.substring(19, 6);
        cadena2 := ls_cad2.substring(13,  6);
        cadena3 := ls_cad2.substring(25, 6);
        cadena4 := ls_cad2.substring(1, 6);
        cadena5 := ls_cad2.substring(7, 6);
        ls_cad := cadena1 + cadena2 + cadena3 + cadena4 + cadena5;
        cadena := '';
        cadena2 := '/' + cadena2;
        cadena3 := '/' + cadena3;
        cadena4 := '/' + cadena4;
        cadena5 := '/' + cadena5;
        t1 := 6;
        t2 := 6;
        t3 := 6;
        t4 := 6;
        t5 := 6;
        for t := 30 downto 2 do begin
            if (t = 29) then begin
                c := cadena4.substring(t4, 1);
                cadena := c + cadena;
                dec(t4);
                continue;
            end;
            if (t = 23) then begin
                c := cadena3.substring(t3, 1);
                cadena := c + cadena;
                dec(t3);
                continue;
            end;
            if (t = 19) then begin
                c := cadena5.substring(t5, 1);
                cadena := c + cadena;
                dec(t5);
                continue;
            end;
            if (t = 17) then begin
                c := cadena4.substring(t4, 1);
                cadena := c + cadena;
                dec(t4);
                continue;
            end;
            if (t = 13) then begin
                c := cadena3.substring(t3, 1);
                cadena := c + cadena;
                dec(t3);
                continue;
            end;
            if (t = 11) then begin
                c := cadena2.substring(t2, 1);
                cadena := c + cadena;
                dec(t2);
                continue;
            end;
            if (t = 7) then begin
                c := cadena1.substring(t1, 1);
                cadena := c + cadena;
                dec(t1);
                continue;
            end;
            if (t mod 6 = 0) then begin
                c := cadena1.substring(t1,  1);
                cadena := c + cadena;
                dec(t1);
                continue;
            end;
            if (t mod 5 = 0) then begin
                c := cadena2.substring(t2, 1);
                cadena := c + cadena;
                dec(t2);
                continue;
            end;
            if (t mod 4 = 0) then begin
                c := cadena3.substring(t3, 1);
                cadena := c + cadena;
                dec(t3);
                continue;
            end;
            if (t mod 3 = 0) then begin
                c := cadena4.substring(t4, 1);
                cadena := c + cadena;
                dec(t4);
                continue;
            end;
            if (t mod 2 = 0) then begin
                c := cadena5.substring(t5, 1);
                cadena := c + cadena;
                dec(t5);
                continue;
            end;
        end;
        cadena := cadena5.substring(1, 1) + cadena;
        cadena := '/' + cadena;
        ls_enc := '';
        for t := 1 TO 30 do begin
            c := copy(cadena,t+1,1);
            if (c<>' ') then begin
                ls_enc :=ls_enc+ c;
            end;
        end;

        Result:=ls_enc;
end;

class function TEncripcionUtils.encripcion(as_str: String): String;
var
  i, j, li_llave, c1, c2, c3, t1, t: Integer;
  ls_enc, ls_cadena, ls_cad, cadena1, cadena2, cadena3, cadena4, cadena5, c,
    cadena,fmt: String;
  a, b, cx: TIntegerDynArray;
  car:char;
begin
  ls_enc := '';
  a := TIntegerDynArray.Create(0, 15, 200, 41, 38, 27, 12, 46, -15, -50, 12, 38,
    21, 43, 90, 12, 101, 150, 180, 24, 13, 18, 19, 56, 1, 17, 29, -41,
    47, 63, 81);
  b := TIntegerDynArray.Create(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
  cx := TIntegerDynArray.Create(0, 12, 45, 67, -24, 87, 68, 25, 46, 101, 250,
    34, 56, -18, 24, 56, 98, 135, 156, -12, 1, 10, 56, 23, 10, 19, 54, 145,
    189, 206, 30);
  ls_cad := as_str;
  li_llave := Length(ls_cad);
  cadena := as_str + spaces(30 - li_llave);
  ls_cad := '/' + cadena;
  cadena1 := '';
  cadena2 := '';
  cadena3 := '';
  cadena4 := '';
  cadena5 := '';
  cadena5 := cadena5 + copy(ls_cad, 2, 1);
  //for t := 2 TO 30 do
  for t := 2 TO 30 do
  begin
    c := copy(ls_cad, t+1, 1);
    if (t mod 6 = 0) then
    begin
      cadena1 := cadena1 + c;
      continue;
    end;
    if (t mod 5 = 0) then
    begin
      cadena2 := cadena2 + c;
      continue;
    end;
    if (t mod 4 = 0) then
    begin
      cadena3 := cadena3 + c;
      continue;
    end;
    if (t mod 3 = 0) then
    begin
      cadena4 := cadena4 + c;
      continue;
    end;
    if (t mod 2 = 0) then
    begin
      cadena5 := cadena5 + c;
      continue;
    end;
    if (t = 7) then
    begin
      cadena1 := cadena1 + c;
      continue;
    end;
    if (t = 11) then
    begin
      cadena2 := cadena2 + c;
      continue;
    end;
    if (t = 13) then
    begin
      cadena3 := cadena3 + c;
      continue;
    end;
    if (t = 17) then
    begin
      cadena4 := cadena4 + c;
      continue;
    end;
    if (t = 19) then
    begin
      cadena5 := cadena5 + c;
      continue;
    end;
    if (t = 23) then
    begin
      cadena3 := cadena3 + c;
      continue;
    end;
    if (t = 29) then
    begin
      cadena4 := cadena4 + c;
      continue;
    end;
  end;

  cadena := '';
  cadena := '/' + cadena4 + cadena5 + cadena2 + cadena1 + cadena3;
  for t := 1 TO 30 do
  begin
    c := copy(cadena, t+1, 1);
    car:=c[1];
    c1 := (ord(car)) + a[t];
    b[t] := c1;
  end;

  t1 := 30;
  for t := 1 TO 30 do
  begin
    c1 := b[t] + a[t1];
    b[t] := c1;
    dec(t1);
  end;

  ls_enc := '';
  for t := 1 to 30 do
  begin
    c1:= b[t] + cx[t];
    if (c1 < 0) then
    begin
      fmt:=Format('%.*d', [3,((c1 * -1) + 700)]);
      ls_enc :=ls_enc+ fmt; // String.format("%s",Integer.toString((c1 * -1) + 700));
    end
    else
    begin
      fmt:= Format('%.*d', [3,c1]);
      ls_enc :=ls_enc+ fmt; // String.format("%s",Integer.toString(c1));
    end;
    fmt:='';
  end;

  Result := ls_enc;
end;

class function TEncripcionUtils.spaces(cantidad: Integer): String;
var
  espacios: String;
  i: Integer;
begin
  espacios := '';
  for i := 0 to cantidad - 1 do
  begin
    espacios := espacios+ ' ';
  end;
  Result := espacios;
end;

end.
