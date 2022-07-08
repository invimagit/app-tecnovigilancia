object DM: TDM
  OldCreateOrder = False
  Height = 566
  Width = 1014
  object FDConexion: TFDConnection
    Params.Strings = (
      'User_Name=sysdba'
      'Database=C:\DB\TECNOVIGILANCIA.FDB'
      'DriverID=FB_Local')
    Connected = True
    Left = 144
    Top = 120
  end
  object FBDriver: TFDPhysFBDriverLink
    DriverID = 'FB_Local'
    VendorLib = 
      'E:\Proyectos\Tecnovigilancia\TecnoVigilancia\Embarcadero\Portabl' +
      'e\DB\fbclient.dll'
    Embedded = True
    Left = 144
    Top = 224
  end
  object TblTecnoPersonaInternet: TFDTable
    IndexFieldNames = 'USUARIO'
    Connection = FDConexion
    UpdateOptions.UpdateTableName = 'TECNO_USUARIOS_INTERNET'
    TableName = 'TECNO_USUARIOS_INTERNET'
    Left = 288
    Top = 80
    object TblTecnoPersonaInternetIDENTIFICACION_EMPRESA: TLargeintField
      FieldName = 'IDENTIFICACION_EMPRESA'
      Origin = 'IDENTIFICACION_EMPRESA'
      Required = True
    end
    object TblTecnoPersonaInternetTIPIDENTIFICACION_EMPRESA: TWideStringField
      FieldName = 'TIPIDENTIFICACION_EMPRESA'
      Origin = 'TIPIDENTIFICACION_EMPRESA'
      Required = True
      Size = 2
    end
    object TblTecnoPersonaInternetNOMBRE_EMPRESA: TWideStringField
      FieldName = 'NOMBRE_EMPRESA'
      Origin = 'NOMBRE_EMPRESA'
      Required = True
      Size = 128
    end
    object TblTecnoPersonaInternetDIRECCION_EMPRESA: TWideStringField
      FieldName = 'DIRECCION_EMPRESA'
      Origin = 'DIRECCION_EMPRESA'
      Required = True
      Size = 128
    end
    object TblTecnoPersonaInternetCDG_PAIS: TWideStringField
      FieldName = 'CDG_PAIS'
      Origin = 'CDG_PAIS'
      Required = True
      Size = 2
    end
    object TblTecnoPersonaInternetCOD_MUN: TWideStringField
      FieldName = 'COD_MUN'
      Origin = 'COD_MUN'
      Required = True
      Size = 5
    end
    object TblTecnoPersonaInternetTELEFONO_EMPRESA: TWideStringField
      FieldName = 'TELEFONO_EMPRESA'
      Origin = 'TELEFONO_EMPRESA'
      Required = True
      Size = 30
    end
    object TblTecnoPersonaInternetEMAIL_EMPRESA: TWideStringField
      FieldName = 'EMAIL_EMPRESA'
      Origin = 'EMAIL_EMPRESA'
      Required = True
      Size = 50
    end
    object TblTecnoPersonaInternetFAX: TWideStringField
      FieldName = 'FAX'
      Origin = 'FAX'
      Size = 30
    end
    object TblTecnoPersonaInternetURL: TWideStringField
      FieldName = 'URL'
      Origin = 'URL'
      Size = 100
    end
    object TblTecnoPersonaInternetIDENTIFICACION_PERSONA: TLargeintField
      FieldName = 'IDENTIFICACION_PERSONA'
      Origin = 'IDENTIFICACION_PERSONA'
      Required = True
    end
    object TblTecnoPersonaInternetTIPIDENTIFICACION_PERSONA: TWideStringField
      FieldName = 'TIPIDENTIFICACION_PERSONA'
      Origin = 'TIPIDENTIFICACION_PERSONA'
      Required = True
      Size = 2
    end
    object TblTecnoPersonaInternetNOMBRE_PERSONA: TWideStringField
      FieldName = 'NOMBRE_PERSONA'
      Origin = 'NOMBRE_PERSONA'
      Required = True
      Size = 128
    end
    object TblTecnoPersonaInternetCARGO_PERSONA: TWideStringField
      FieldName = 'CARGO_PERSONA'
      Origin = 'CARGO_PERSONA'
      Required = True
      Size = 60
    end
    object TblTecnoPersonaInternetTELEFONO_PERSONA: TWideStringField
      FieldName = 'TELEFONO_PERSONA'
      Origin = 'TELEFONO_PERSONA'
      Required = True
      Size = 30
    end
    object TblTecnoPersonaInternetEMAIL_PERSONA: TWideStringField
      FieldName = 'EMAIL_PERSONA'
      Origin = 'EMAIL_PERSONA'
      Required = True
      Size = 50
    end
    object TblTecnoPersonaInternetUSUARIO: TWideStringField
      FieldName = 'USUARIO'
      Origin = 'USUARIO'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
      Required = True
      Size = 30
    end
    object TblTecnoPersonaInternetACTIVO: TSmallintField
      FieldName = 'ACTIVO'
      Origin = 'ACTIVO'
      Required = True
    end
    object TblTecnoPersonaInternetID_ROL_USUARIO: TIntegerField
      FieldName = 'ID_ROL_USUARIO'
      Origin = 'ID_ROL_USUARIO'
    end
    object TblTecnoPersonaInternetPREGUNTA: TWideStringField
      FieldName = 'PREGUNTA'
      Origin = 'PREGUNTA'
      Size = 100
    end
    object TblTecnoPersonaInternetRESPUESTA: TWideStringField
      FieldName = 'RESPUESTA'
      Origin = 'RESPUESTA'
      Size = 100
    end
    object TblTecnoPersonaInternetFECHA_INGRESO: TSQLTimeStampField
      FieldName = 'FECHA_INGRESO'
      Origin = 'FECHA_INGRESO'
      Required = True
    end
    object TblTecnoPersonaInternetPASSWORD: TWideStringField
      FieldName = 'PASSWORD'
      Origin = '"PASSWORD"'
      Size = 100
    end
    object TblTecnoPersonaInternetSESSION: TWideStringField
      FieldName = 'SESSION'
      Origin = 'SESSION'
      Size = 64
    end
    object TblTecnoPersonaInternetESTADO_USUARIO: TWideStringField
      FieldName = 'ESTADO_USUARIO'
      Origin = 'ESTADO_USUARIO'
      Size = 1
    end
    object TblTecnoPersonaInternetCLASIFICACION_USUARIO: TWideStringField
      FieldName = 'CLASIFICACION_USUARIO'
      Origin = 'CLASIFICACION_USUARIO'
      Size = 31
    end
    object TblTecnoPersonaInternetCOD_DEPART: TWideStringField
      FieldName = 'COD_DEPART'
      Origin = 'COD_DEPART'
      Size = 5
    end
  end
  object TblTecnoUsuarios: TFDTable
    IndexFieldNames = 'CONSECUTIVO'
    Connection = FDConexion
    UpdateOptions.UpdateTableName = 'TECNO_USUARIOS'
    TableName = 'TECNO_USUARIOS'
    Left = 288
    Top = 136
    object TblTecnoUsuariosCONSECUTIVO: TIntegerField
      FieldName = 'CONSECUTIVO'
      Origin = 'CONSECUTIVO'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
      Required = True
    end
    object TblTecnoUsuariosREPORTE: TWideStringField
      FieldName = 'REPORTE'
      Origin = 'REPORTE'
      FixedChar = True
      Size = 15
    end
    object TblTecnoUsuariosNOMBRE_REPORTANTE: TWideStringField
      FieldName = 'NOMBRE_REPORTANTE'
      Origin = 'NOMBRE_REPORTANTE'
      Required = True
      FixedChar = True
      Size = 128
    end
    object TblTecnoUsuariosSEXO: TWideStringField
      FieldName = 'SEXO'
      Origin = 'SEXO'
      Required = True
      FixedChar = True
      Size = 1
    end
    object TblTecnoUsuariosEDAD: TSmallintField
      FieldName = 'EDAD'
      Origin = 'EDAD'
      Required = True
    end
    object TblTecnoUsuariosEDAD_EN: TWideStringField
      FieldName = 'EDAD_EN'
      Origin = 'EDAD_EN'
      Required = True
      FixedChar = True
      Size = 1
    end
    object TblTecnoUsuariosDIRECCION_REPORTANTE: TWideStringField
      FieldName = 'DIRECCION_REPORTANTE'
      Origin = 'DIRECCION_REPORTANTE'
      Required = True
      FixedChar = True
      Size = 128
    end
    object TblTecnoUsuariosTELEFONO: TWideStringField
      FieldName = 'TELEFONO'
      Origin = 'TELEFONO'
      Required = True
      FixedChar = True
    end
    object TblTecnoUsuariosPAIS: TWideStringField
      FieldName = 'PAIS'
      Origin = 'PAIS'
      Required = True
      FixedChar = True
      Size = 2
    end
    object TblTecnoUsuariosCOD_DEPART: TWideStringField
      FieldName = 'COD_DEPART'
      Origin = 'COD_DEPART'
      Required = True
      FixedChar = True
      Size = 2
    end
    object TblTecnoUsuariosCOD_MUN: TWideStringField
      FieldName = 'COD_MUN'
      Origin = 'COD_MUN'
      Required = True
      FixedChar = True
      Size = 5
    end
    object TblTecnoUsuariosEMAIL: TWideStringField
      FieldName = 'EMAIL'
      Origin = 'EMAIL'
      Required = True
      FixedChar = True
      Size = 128
    end
    object TblTecnoUsuariosNOMBRE_DM: TWideStringField
      FieldName = 'NOMBRE_DM'
      Origin = 'NOMBRE_DM'
      Required = True
      FixedChar = True
      Size = 255
    end
    object TblTecnoUsuariosNOMBRE_COMERCIAL: TWideStringField
      FieldName = 'NOMBRE_COMERCIAL'
      Origin = 'NOMBRE_COMERCIAL'
      Required = True
      FixedChar = True
      Size = 255
    end
    object TblTecnoUsuariosNROREGSAN: TWideStringField
      FieldName = 'NROREGSAN'
      Origin = 'NROREGSAN'
      Required = True
      FixedChar = True
    end
    object TblTecnoUsuariosLOTE: TWideStringField
      FieldName = 'LOTE'
      Origin = 'LOTE'
      Required = True
      FixedChar = True
      Size = 64
    end
    object TblTecnoUsuariosREFERENCIA: TWideStringField
      FieldName = 'REFERENCIA'
      Origin = 'REFERENCIA'
      Required = True
      FixedChar = True
      Size = 128
    end
    object TblTecnoUsuariosNOMBRE_FABRICANTE: TWideStringField
      FieldName = 'NOMBRE_FABRICANTE'
      Origin = 'NOMBRE_FABRICANTE'
      Required = True
      FixedChar = True
      Size = 128
    end
    object TblTecnoUsuariosNOMBRE_DISTRIB_IMPORT: TWideStringField
      FieldName = 'NOMBRE_DISTRIB_IMPORT'
      Origin = 'NOMBRE_DISTRIB_IMPORT'
      Required = True
      FixedChar = True
      Size = 128
    end
    object TblTecnoUsuariosFECHA_EVENTO: TSQLTimeStampField
      FieldName = 'FECHA_EVENTO'
      Origin = 'FECHA_EVENTO'
      Required = True
    end
    object TblTecnoUsuariosFECHA_NOTIFICACION: TSQLTimeStampField
      FieldName = 'FECHA_NOTIFICACION'
      Origin = 'FECHA_NOTIFICACION'
      Required = True
    end
    object TblTecnoUsuariosCDG_EVENTODETECCION: TIntegerField
      FieldName = 'CDG_EVENTODETECCION'
      Origin = 'CDG_EVENTODETECCION'
      Required = True
    end
    object TblTecnoUsuariosDESCRIPCION_EVENTO: TMemoField
      FieldName = 'DESCRIPCION_EVENTO'
      Origin = 'DESCRIPCION_EVENTO'
      Required = True
      BlobType = ftMemo
    end
    object TblTecnoUsuariosCDGFUNCIONARIO: TSmallintField
      FieldName = 'CDGFUNCIONARIO'
      Origin = 'CDGFUNCIONARIO'
      Required = True
    end
    object TblTecnoUsuariosREVISADO: TWideStringField
      FieldName = 'REVISADO'
      Origin = 'REVISADO'
      Required = True
      FixedChar = True
      Size = 1
    end
  end
  object FDTable1: TFDTable
    Connection = FDConexion
    Left = 288
    Top = 208
  end
  object FDTable2: TFDTable
    Connection = FDConexion
    Left = 288
    Top = 272
  end
  object FDTable3: TFDTable
    Connection = FDConexion
    Left = 288
    Top = 336
  end
end
