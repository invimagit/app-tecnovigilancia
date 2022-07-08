unit UToken;

interface

type

  TTokenAutoriza = class(TObject)
  private
    FAccessToken: String;
    FRefreshToken: String;
    FTokenType: String;
    FExpiresIn: Integer;
    FScope: String;
    FClave: String;
    FUser: String;

  public
    property accessToken: String read FAccessToken write FAccessToken;
    property tokenType: String read FTokenType write FTokenType;
    property refreshToken: String read FRefreshToken write FRefreshToken;
    property expiresIn: Integer read FExpiresIn write FExpiresIn;
    property scope: String read FScope write FScope;
    property user:String read FUser write FUser;
    property clave:String read FClave write FClave;
  end;

implementation

end.
