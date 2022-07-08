unit UClienteServicio;

interface

uses
  System.SysUtils, System.Types, System.UITypes, System.Classes,
  System.Variants, System.Generics.Collections,
  FMX.Types, FMX.Controls, FMX.Forms, FMX.Graphics, FMX.Dialogs, IPPeerClient,
  REST.Client, Data.Bind.Components, Data.Bind.ObjectScope, UToken, REST.Json,
  FMX.StdCtrls, System.Json, REST.Authenticator.OAuth, REST.Types, UUtilidad;

type
  TConsumir = class(TObject)
    RestConsumirToken: TRESTClient;
    RestRqToken: TRESTRequest;
    RESTRsToken: TRESTResponse;
    RestEjecutarMetodo: TRESTClient;
    RqMetodo: TRESTRequest;
    RsMetodo: TRESTResponse;
    OAuth2Autnetica: TOAuth2Authenticator;
  private

  public
    function obtenerToken(user, clave: String): TTokenAutoriza;
    function obtenerRespuestametodo(token: TTokenAutoriza;
      URL, tipoMetodo: String; nombreParametro, parametro: String): String;
    function obtenerRepuestaMetodoPost(token: TTokenAutoriza;
      URL, tipoMetodo: String; nombreParametro, parametro: String): String;
    function obtenerRespuestaMetodoPost(token: TTokenAutoriza;
      URL, tipoMetodo: String;
      nombreParametro, parametro: TList<String>): String;
  end;

implementation

{ TConsumir }

function TConsumir.obtenerRepuestaMetodoPost(token: TTokenAutoriza;
  URL, tipoMetodo, nombreParametro, parametro: String): String;
begin
  tipoMetodo := 'POST';
  if (URL.Trim <> EmptyStr) AND (token <> nil) AND (tipoMetodo.Trim <> EmptyStr)
  then
  begin
    RestEjecutarMetodo := TRESTClient.Create(URL);
    OAuth2Autnetica := TOAuth2Authenticator.Create(RestEjecutarMetodo);
    OAuth2Autnetica.AccessToken := token.AccessToken;
    OAuth2Autnetica.RefreshToken := token.RefreshToken;
    OAuth2Autnetica.TokenType := TOAuth2TokenType.ttBEARER;
    RestEjecutarMetodo.Authenticator := OAuth2Autnetica;
    RestEjecutarMetodo.Accept := 'application/json, text/plain; q=0.9, text/' +
      'html;q=0.8,';
    RestEjecutarMetodo.AcceptCharset := 'UTF-8, *;q=0.8';
    RestEjecutarMetodo.AcceptEncoding := 'identity';
    RqMetodo := TRESTRequest.Create(RestEjecutarMetodo);
    RqMetodo.Timeout := 300000;
    RqMetodo.AcceptCharset := 'UTF-8, *;q=0.8';
    RqMetodo.Client := RestEjecutarMetodo;
    /// poner el tipo de metodo
    if tipoMetodo = 'GET' then
    begin
      RqMetodo.Method := TRESTRequestMethod.rmGET;
    end
    else
    begin
      if tipoMetodo = 'PUT' then
      begin
        RqMetodo.Method := TRESTRequestMethod.rmPUT;
      end
      else
      begin
        if tipoMetodo = 'POST' then
        begin
          RqMetodo.Method := TRESTRequestMethod.rmPOST;
        end
        else
        begin
          if tipoMetodo = 'DELETE' then
          begin
            RqMetodo.Method := TRESTRequestMethod.rmDELETE;
          end;
        end;
      end;
    end;
    /// Pendiente los parametros
    if tipoMetodo = 'POST' then
    begin
      RqMetodo.AddBody(parametro, ctAPPLICATION_JSON);
    end;
    /// Response
    RsMetodo := TRESTResponse.Create(RestEjecutarMetodo);
    RsMetodo.ContentType := 'application/json';
    RsMetodo.ContentEncoding := 'UTF-8, *;q=0.8';
    /// Request
    RqMetodo.Response := RsMetodo;
    RqMetodo.Execute;
    if RsMetodo.StatusCode = 200 then
    begin
      Result := RsMetodo.Content;
    end
    else
    begin
      Result := 'No hay respuesta consulte el administrador';
    end;
  end
  else
  begin
    Result := 'No hay datos sufientes para ejecutar Operación';
  end;
end;

function TConsumir.obtenerRespuestametodo(token: TTokenAutoriza;
  URL, tipoMetodo: String; nombreParametro, parametro: String): String;
begin
  if (URL.Trim <> EmptyStr) AND (token <> nil) AND (tipoMetodo.Trim <> EmptyStr)
  then
  begin
    RestEjecutarMetodo := TRESTClient.Create(URL);
    OAuth2Autnetica := TOAuth2Authenticator.Create(RestEjecutarMetodo);
    OAuth2Autnetica.TokenType := TOAuth2TokenType.ttBEARER;
    OAuth2Autnetica.AccessToken := token.AccessToken;
    OAuth2Autnetica.RefreshToken := token.RefreshToken;
    RestEjecutarMetodo.Authenticator := OAuth2Autnetica;
    RestEjecutarMetodo.Accept := 'application/json, text/plain; q=0.9, text/' +
      'html;q=0.8,';
    RestEjecutarMetodo.AcceptCharset := 'UTF-8, *;q=0.8';
    RestEjecutarMetodo.AcceptEncoding := 'identity';
    RqMetodo := TRESTRequest.Create(RestEjecutarMetodo);
    RqMetodo.Timeout := 300000;
    RqMetodo.AcceptCharset := 'UTF-8, *;q=0.8';
    RqMetodo.Client := RestEjecutarMetodo;
    /// poner el tipo de metodo
    if tipoMetodo = 'GET' then
    begin
      RqMetodo.Method := TRESTRequestMethod.rmGET;
    end
    else
    begin
      if tipoMetodo = 'PUT' then
      begin
        RqMetodo.Method := TRESTRequestMethod.rmPUT;
      end
      else
      begin
        if tipoMetodo = 'POST' then
        begin
          RqMetodo.Method := TRESTRequestMethod.rmPOST;
        end
        else
        begin
          if tipoMetodo = 'DELETE' then
          begin
            RqMetodo.Method := TRESTRequestMethod.rmDELETE;
          end;
        end;
      end;
    end;
    /// Pendiente los parametros
    if tipoMetodo = 'POST' then
    begin
      RqMetodo.Params.AddItem('Content-Type', 'application/json',
        TRESTRequestParameterKind.pkHTTPHEADER);
      RqMetodo.Params.AddItem('Authorization', 'Bearer ' + token.AccessToken,
        TRESTRequestParameterKind.pkHTTPHEADER);
      RqMetodo.Params.AddItem(nombreParametro, parametro,
        TRESTRequestParameterKind.pkREQUESTBODY);

    end;
    /// Response
    RsMetodo := TRESTResponse.Create(RestEjecutarMetodo);
    RsMetodo.ContentType := 'application/json';
    RsMetodo.ContentEncoding := 'UTF-8, *;q=0.8';
    /// Request
    RqMetodo.Response := RsMetodo;
    RqMetodo.Execute;
    if RsMetodo.StatusCode = 200 then
    begin
      Result := RsMetodo.Content;
    end
    else
    begin
      Result := 'No hay respuesta consulte el administrador';
    end;
  end
  else
  begin
    Result := 'No hay datos sufientes para ejecutar Operación';
  end;
end;

function TConsumir.obtenerRespuestaMetodoPost(token: TTokenAutoriza;
  URL, tipoMetodo: String; nombreParametro, parametro: TList<String>): String;
var
  parametroItem: String;
begin
  tipoMetodo := 'POST';
  if (URL.Trim <> EmptyStr) AND (token <> nil) AND (tipoMetodo.Trim <> EmptyStr)
  then
  begin
    RestEjecutarMetodo := TRESTClient.Create(URL);
    OAuth2Autnetica := TOAuth2Authenticator.Create(RestEjecutarMetodo);
    OAuth2Autnetica.AccessToken := token.AccessToken;
    OAuth2Autnetica.RefreshToken := token.RefreshToken;
    OAuth2Autnetica.TokenType := TOAuth2TokenType.ttBEARER;
    RestEjecutarMetodo.Authenticator := OAuth2Autnetica;
    RestEjecutarMetodo.Accept := 'application/json, text/plain; q=0.9, text/' +
      'html;q=0.8,';
    RestEjecutarMetodo.AcceptCharset := 'UTF-8, *;q=0.8';
    RestEjecutarMetodo.AcceptEncoding := 'identity';
    RqMetodo := TRESTRequest.Create(RestEjecutarMetodo);
    RqMetodo.Timeout := 300000;
    RqMetodo.AcceptCharset := 'UTF-8, *;q=0.8';
    RqMetodo.Client := RestEjecutarMetodo;
    /// poner el tipo de metodo
    if tipoMetodo = 'GET' then
    begin
      RqMetodo.Method := TRESTRequestMethod.rmGET;
    end
    else
    begin
      if tipoMetodo = 'PUT' then
      begin
        RqMetodo.Method := TRESTRequestMethod.rmPUT;
      end
      else
      begin
        if tipoMetodo = 'POST' then
        begin
          RqMetodo.Method := TRESTRequestMethod.rmPOST;
        end
        else
        begin
          if tipoMetodo = 'DELETE' then
          begin
            RqMetodo.Method := TRESTRequestMethod.rmDELETE;
          end;
        end;
      end;
    end;
    /// Pendiente los parametros
    if tipoMetodo = 'POST' then
    begin
      if parametro.Count > 0 then
      begin
        for parametroItem in parametro do
        begin
          RqMetodo.AddBody(parametroItem, ctAPPLICATION_JSON);
        end;
      end;
    end;
    /// Response
    RsMetodo := TRESTResponse.Create(RestEjecutarMetodo);
    RsMetodo.ContentType := 'application/json';
    RsMetodo.ContentEncoding := 'UTF-8, *;q=0.8';
    /// Request
    RqMetodo.Response := RsMetodo;
    RqMetodo.Execute;
    if RsMetodo.StatusCode = 200 then
    begin
      Result := RsMetodo.Content;
    end
    else
    begin
      Result := 'No hay respuesta consulte el administrador';
    end;
  end
  else
  begin
    Result := 'No hay datos sufientes para ejecutar Operación';
  end;
end;

function TConsumir.obtenerToken(user, clave: String): TTokenAutoriza;
var
  token: TTokenAutoriza;
  URL, server, usuarioParam, claveParam: String;
  resultado: String;
  resp: TJSONValue;
  objecto: TJsonObject;
begin
  if (user <> EmptyStr) AND (clave <> EmptyStr) then
  begin
    server := TUtilidad.obtenerKey('Servicios', 'URL');
    usuarioParam := TUtilidad.obtenerKey('Servicios', 'usuarioToken');
    claveParam := TUtilidad.obtenerKey('Servicios', 'claveToken');
    URL := server + '/ServicioCertificacionPuertos/oauth/token';
    RestConsumirToken := TRESTClient.Create(URL);
    RestConsumirToken.Accept := 'application/json, text/plain; q=0.9, text/' +
      'html;q=0.8,';
    RestConsumirToken.AcceptCharset := 'UTF-8, *;q=0.8';
    RestConsumirToken.AcceptEncoding := 'identity';
    RestRqToken := TRESTRequest.Create(RestConsumirToken);
    RestRqToken.Client := RestConsumirToken;
    RestRqToken.AddParameter('grant_type', 'password');
    RestRqToken.AddParameter('client_id', 'my-trusted-client');
    RestRqToken.AddParameter('username', usuarioParam);
    RestRqToken.AddParameter('password', claveParam);
    RESTRsToken := TRESTResponse.Create(RestConsumirToken);
    RestRqToken.Response := RESTRsToken;
    RestRqToken.SynchronizedEvents := false;
    RestRqToken.Execute;
    if RESTRsToken.StatusCode = 200 then
    begin
      resultado := RESTRsToken.Content;
      resp := RESTRsToken.JSONValue;
      objecto := TJsonObject.ParseJSONValue(TEncoding.ASCII.GetBytes(resultado),
        0) as TJsonObject;
      token := TTokenAutoriza.Create;
      token.AccessToken := resp.GetValue('access_token', '');
      token.TokenType := resp.GetValue('token_type', '');
      token.RefreshToken := resp.GetValue('refresh_token', '');
      token.expiresIn := StrToInt(resp.GetValue('expires_in', ''));
      token.scope := resp.GetValue('scope', '');
      token.user := user;
      token.clave := clave;
      Result := token;
    end
    else
    begin
      Result := nil;
    end;
  end
  else
  begin
    Result := nil;
  end;

end;

end.

