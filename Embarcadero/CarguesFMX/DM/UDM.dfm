object DM: TDM
  OldCreateOrder = False
  Height = 419
  Width = 1066
  object dsReporteEventos: TDataSource
    DataSet = TblTecnoReporteEventos
    Left = 336
    Top = 8
  end
  object dsEvaluacionCaso: TDataSource
    DataSet = TblTecnoEvaluacionCaso
    Left = 336
    Top = 56
  end
  object dsPaciente: TDataSource
    DataSet = TblTecnoPaciente
    Left = 336
    Top = 112
  end
  object dsDispositivo: TDataSource
    DataSet = TblTecnoDispositivo
    Left = 336
    Top = 160
  end
  object ConectaRegistroFD: TFDConnection
    Params.Strings = (
      'Database=sivicos'
      'Server=SANDIEGO\SRVPRU122'
      'ApplicationName=Enterprise/Architect/Ultimate '
      'User_Name=murread'
      'Password=12345678'
      'DriverID=MSSQL')
    LoginPrompt = False
    Transaction = FDTransaccion
    UpdateTransaction = FDTransaccion
    Left = 776
    Top = 8
  end
  object FDTransaccion: TFDTransaction
    Connection = ConectaRegistroFD
    Left = 680
    Top = 8
  end
  object FDMSSQLDriver: TFDPhysMSSQLDriverLink
    ODBCDriver = 'SQL Server Native Client 11.0'
    Left = 576
    Top = 8
  end
  object TblTecnoReporteEventos: TFDTable
    IndexFieldNames = 'reporte'
    Connection = ConectaRegistroFD
    Transaction = FDTransaccion
    UpdateOptions.UpdateTableName = 'sivicos.dbo.tecno_reporte_eventos'
    TableName = 'sivicos.dbo.tecno_reporte_eventos'
    Left = 456
    Top = 8
    object TblTecnoReporteEventosreporte: TStringField
      FieldName = 'reporte'
      Origin = 'reporte'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
      Required = True
      Size = 15
    end
    object TblTecnoReporteEventosfechevento: TSQLTimeStampField
      FieldName = 'fechevento'
      Origin = 'fechevento'
    end
    object TblTecnoReporteEventosdescripcion_evento: TMemoField
      FieldName = 'descripcion_evento'
      Origin = 'descripcion_evento'
      Required = True
      BlobType = ftMemo
    end
    object TblTecnoReporteEventoscdg_eventodeteccion: TIntegerField
      FieldName = 'cdg_eventodeteccion'
      Origin = 'cdg_eventodeteccion'
    end
    object TblTecnoReporteEventoscdg_tiporeporte: TIntegerField
      FieldName = 'cdg_tiporeporte'
      Origin = 'cdg_tiporeporte'
    end
    object TblTecnoReporteEventoscdg_desenlace: TIntegerField
      FieldName = 'cdg_desenlace'
      Origin = 'cdg_desenlace'
    end
    object TblTecnoReporteEventosfechreporte_evento: TSQLTimeStampField
      FieldName = 'fechreporte_evento'
      Origin = 'fechreporte_evento'
    end
    object TblTecnoReporteEventoscdg_origenreporte: TIntegerField
      FieldName = 'cdg_origenreporte'
      Origin = 'cdg_origenreporte'
    end
    object TblTecnoReporteEventoscdg_tipoeventoincidente: TIntegerField
      FieldName = 'cdg_tipoeventoincidente'
      Origin = 'cdg_tipoeventoincidente'
    end
    object TblTecnoReporteEventoscdg_seriedad: TIntegerField
      FieldName = 'cdg_seriedad'
      Origin = 'cdg_seriedad'
    end
    object TblTecnoReporteEventosdesenlace_otro: TStringField
      FieldName = 'desenlace_otro'
      Origin = 'desenlace_otro'
      Size = 524
    end
    object TblTecnoReporteEventosinternet: TStringField
      FieldName = 'internet'
      Origin = 'internet'
      Size = 1
    end
    object TblTecnoReporteEventosfechaingreso: TSQLTimeStampField
      FieldName = 'fechaingreso'
      Origin = 'fechaingreso'
    end
    object TblTecnoReporteEventosreportado: TStringField
      FieldName = 'reportado'
      Origin = 'reportado'
      Size = 1
    end
  end
  object TblTecnoEvaluacionCaso: TFDTable
    IndexFieldNames = 'reporte'
    Connection = ConectaRegistroFD
    Transaction = FDTransaccion
    UpdateOptions.UpdateTableName = 'sivicos.dbo.tecno_evaluacion_caso'
    TableName = 'sivicos.dbo.tecno_evaluacion_caso'
    Left = 456
    Top = 57
    object TblTecnoEvaluacionCasoreporte: TStringField
      FieldName = 'reporte'
      Origin = 'reporte'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
      Required = True
      Size = 15
    end
    object TblTecnoEvaluacionCasocdg_causa: TIntegerField
      FieldName = 'cdg_causa'
      Origin = 'cdg_causa'
    end
    object TblTecnoEvaluacionCasonumero: TIntegerField
      FieldName = 'numero'
      Origin = 'numero'
    end
    object TblTecnoEvaluacionCasoacciones: TMemoField
      FieldName = 'acciones'
      Origin = 'acciones'
      BlobType = ftMemo
    end
    object TblTecnoEvaluacionCasoexp_alertas: TBCDField
      FieldName = 'exp_alertas'
      Origin = 'exp_alertas'
      Precision = 15
      Size = 0
    end
    object TblTecnoEvaluacionCasodescripcion_alerta: TMemoField
      FieldName = 'descripcion_alerta'
      Origin = 'descripcion_alerta'
      BlobType = ftMemo
    end
    object TblTecnoEvaluacionCasocdg_tipoalerta: TIntegerField
      FieldName = 'cdg_tipoalerta'
      Origin = 'cdg_tipoalerta'
    end
    object TblTecnoEvaluacionCasoestado_caso: TStringField
      FieldName = 'estado_caso'
      Origin = 'estado_caso'
      Size = 2
    end
    object TblTecnoEvaluacionCasoseguimiento: TMemoField
      FieldName = 'seguimiento'
      Origin = 'seguimiento'
      BlobType = ftMemo
    end
    object TblTecnoEvaluacionCasocdgfuncionario: TBCDField
      FieldName = 'cdgfuncionario'
      Origin = 'cdgfuncionario'
      Precision = 4
      Size = 0
    end
    object TblTecnoEvaluacionCasomedida_ejecutada: TStringField
      FieldName = 'medida_ejecutada'
      Origin = 'medida_ejecutada'
      Size = 1
    end
    object TblTecnoEvaluacionCasonotificacion: TStringField
      FieldName = 'notificacion'
      Origin = 'notificacion'
      Size = 2
    end
    object TblTecnoEvaluacionCasofecha_notificacion: TSQLTimeStampField
      FieldName = 'fecha_notificacion'
      Origin = 'fecha_notificacion'
    end
    object TblTecnoEvaluacionCasofecha_importador: TSQLTimeStampField
      FieldName = 'fecha_importador'
      Origin = 'fecha_importador'
    end
    object TblTecnoEvaluacionCasodispositivo_evaluacion: TStringField
      FieldName = 'dispositivo_evaluacion'
      Origin = 'dispositivo_evaluacion'
      Size = 2
    end
    object TblTecnoEvaluacionCasoenviado_importador: TStringField
      FieldName = 'enviado_importador'
      Origin = 'enviado_importador'
      Size = 2
    end
  end
  object TblTecnoPaciente: TFDTable
    IndexFieldNames = 'reporte'
    Connection = ConectaRegistroFD
    Transaction = FDTransaccion
    UpdateOptions.UpdateTableName = 'sivicos.dbo.tecno_paciente'
    TableName = 'sivicos.dbo.tecno_paciente'
    Left = 456
    Top = 112
    object TblTecnoPacientereporte: TStringField
      FieldName = 'reporte'
      Origin = 'reporte'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
      Required = True
      Size = 15
    end
    object TblTecnoPacienteidentificacion: TStringField
      FieldName = 'identificacion'
      Origin = 'identificacion'
      Size = 11
    end
    object TblTecnoPacientetipidentificacion: TStringField
      FieldName = 'tipidentificacion'
      Origin = 'tipidentificacion'
      Size = 2
    end
    object TblTecnoPacienteedad: TStringField
      FieldName = 'edad'
      Origin = 'edad'
      Size = 64
    end
    object TblTecnoPacientegenero: TStringField
      FieldName = 'genero'
      Origin = 'genero'
      Size = 1
    end
    object TblTecnoPacientediagnostico_paciente: TMemoField
      FieldName = 'diagnostico_paciente'
      Origin = 'diagnostico_paciente'
      BlobType = ftMemo
    end
    object TblTecnoPacienteedad_en: TStringField
      FieldName = 'edad_en'
      Origin = 'edad_en'
      Size = 1
    end
    object TblTecnoPacienteinstitucion_reportente: TStringField
      FieldName = 'institucion_reportente'
      Origin = 'institucion_reportente'
      Size = 128
    end
    object TblTecnoPacientenaturaleza: TStringField
      FieldName = 'naturaleza'
      Origin = 'naturaleza'
      Size = 2
    end
    object TblTecnoPacientedireccion_reportante: TStringField
      FieldName = 'direccion_reportante'
      Origin = 'direccion_reportante'
      Size = 128
    end
    object TblTecnoPacientecod_mun: TStringField
      FieldName = 'cod_mun'
      Origin = 'cod_mun'
      Size = 5
    end
    object TblTecnoPacientetelefono_reportante: TFMTBCDField
      FieldName = 'telefono_reportante'
      Origin = 'telefono_reportante'
      Precision = 30
      Size = 0
    end
    object TblTecnoPacienteemail_reportante: TStringField
      FieldName = 'email_reportante'
      Origin = 'email_reportante'
      Size = 128
    end
    object TblTecnoPacientecontacto_reportante: TStringField
      FieldName = 'contacto_reportante'
      Origin = 'contacto_reportante'
      Size = 128
    end
    object TblTecnoPacientecod_depart: TStringField
      FieldName = 'cod_depart'
      Origin = 'cod_depart'
      Size = 2
    end
    object TblTecnoPacienteinstitucion_incidente: TStringField
      FieldName = 'institucion_incidente'
      Origin = 'institucion_incidente'
      Size = 128
    end
    object TblTecnoPacientecod_mun1: TStringField
      FieldName = 'cod_mun1'
      Origin = 'cod_mun1'
      Size = 5
    end
    object TblTecnoPacienteidentificacion1: TStringField
      FieldName = 'identificacion1'
      Origin = 'identificacion1'
      Size = 11
    end
    object TblTecnoPacientenivel_complejidad: TStringField
      FieldName = 'nivel_complejidad'
      Origin = 'nivel_complejidad'
    end
    object TblTecnoPacientecargo_inst: TIntegerField
      FieldName = 'cargo_inst'
      Origin = 'cargo_inst'
    end
    object TblTecnoPacientefecha_notif: TSQLTimeStampField
      FieldName = 'fecha_notif'
      Origin = 'fecha_notif'
    end
    object TblTecnoPacientecod_depart1: TStringField
      FieldName = 'cod_depart1'
      Origin = 'cod_depart1'
      Size = 2
    end
    object TblTecnoPacienteautorizacion: TStringField
      FieldName = 'autorizacion'
      Origin = 'autorizacion'
      Size = 2
    end
    object TblTecnoPacientetipo_reportante: TIntegerField
      FieldName = 'tipo_reportante'
      Origin = 'tipo_reportante'
    end
  end
  object TblTecnoDispositivo: TFDTable
    IndexFieldNames = 'reporte;expediente'
    Connection = ConectaRegistroFD
    Transaction = FDTransaccion
    UpdateOptions.UpdateTableName = 'sivicos.dbo.tecno_dispositivo'
    TableName = 'sivicos.dbo.tecno_dispositivo'
    Left = 456
    Top = 168
    object TblTecnoDispositivoreporte: TStringField
      FieldName = 'reporte'
      Origin = 'reporte'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
      Required = True
      Size = 15
    end
    object TblTecnoDispositivonombre_dispositivo: TStringField
      FieldName = 'nombre_dispositivo'
      Origin = 'nombre_dispositivo'
      Size = 255
    end
    object TblTecnoDispositivonroregsan: TStringField
      FieldName = 'nroregsan'
      Origin = 'nroregsan'
      Size = 25
    end
    object TblTecnoDispositivolote: TStringField
      FieldName = 'lote'
      Origin = 'lote'
      Size = 64
    end
    object TblTecnoDispositivoreferencia: TStringField
      FieldName = 'referencia'
      Origin = 'referencia'
      Size = 128
    end
    object TblTecnoDispositivomodelo: TStringField
      FieldName = 'modelo'
      Origin = 'modelo'
      Size = 128
    end
    object TblTecnoDispositivoserial: TStringField
      FieldName = 'serial'
      Origin = 'serial'
      Size = 64
    end
    object TblTecnoDispositivocdg_unicodispositivo: TIntegerField
      FieldName = 'cdg_unicodispositivo'
      Origin = 'cdg_unicodispositivo'
    end
    object TblTecnoDispositivofabricante_usuario: TStringField
      FieldName = 'fabricante_usuario'
      Origin = 'fabricante_usuario'
      Size = 255
    end
    object TblTecnoDispositivodistribuidor_usuario: TStringField
      FieldName = 'distribuidor_usuario'
      Origin = 'distribuidor_usuario'
      Size = 255
    end
    object TblTecnoDispositivoexpediente: TIntegerField
      FieldName = 'expediente'
      Origin = 'expediente'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
      Required = True
    end
    object TblTecnoDispositivocdg_tipodispositivo: TIntegerField
      FieldName = 'cdg_tipodispositivo'
      Origin = 'cdg_tipodispositivo'
    end
    object TblTecnoDispositivoarea_funciona: TStringField
      FieldName = 'area_funciona'
      Origin = 'area_funciona'
      Size = 128
    end
    object TblTecnoDispositivoutilizado: TStringField
      FieldName = 'utilizado'
      Origin = 'utilizado'
      Size = 2
    end
    object TblTecnoDispositivonombre_comercial: TStringField
      FieldName = 'nombre_comercial'
      Origin = 'nombre_comercial'
      Size = 255
    end
  end
  object QryParametros: TFDQuery
    Connection = ConectaRegistroFD
    Transaction = FDTransaccion
    SQL.Strings = (
      'select consec_dispositivo from parametros')
    Left = 440
    Top = 224
  end
  object QryTipoDispositivo: TFDQuery
    Connection = ConectaRegistroFD
    Transaction = FDTransaccion
    SQL.Strings = (
      
        'select cdg_tipodispositivo,descripcion from tecno_tipodispositiv' +
        'o where UPPER(descripcion)=UPPER(:dato)')
    Left = 440
    Top = 280
    ParamData = <
      item
        Name = 'DATO'
        DataType = ftString
        ParamType = ptInput
        Value = Null
      end>
    object QryTipoDispositivocdg_tipodispositivo: TIntegerField
      FieldName = 'cdg_tipodispositivo'
      Origin = 'cdg_tipodispositivo'
      Required = True
    end
    object QryTipoDispositivodescripcion: TStringField
      FieldName = 'descripcion'
      Origin = 'descripcion'
      Size = 255
    end
  end
  object QryCiudadesDpto: TFDQuery
    Connection = ConectaRegistroFD
    Transaction = FDTransaccion
    SQL.Strings = (
      
        'select m.cod_mun,d.cod_depart from municipios m inner join depar' +
        'tamentos d on m.cod_depart=d.cod_depart '
      
        '  and (UPPER(m.descripcion)=UPPER(:ciudad) and UPPER(d.descripci' +
        'on)=UPPER(:departamento))')
    Left = 440
    Top = 344
    ParamData = <
      item
        Name = 'CIUDAD'
        DataType = ftString
        ParamType = ptInput
        Value = Null
      end
      item
        Name = 'DEPARTAMENTO'
        DataType = ftString
        ParamType = ptInput
        Value = Null
      end>
    object QryCiudadesDptocod_mun: TStringField
      FieldName = 'cod_mun'
      Origin = 'cod_mun'
      Required = True
      Size = 5
    end
    object QryCiudadesDptocod_depart: TStringField
      FieldName = 'cod_depart'
      Origin = 'cod_depart'
      Required = True
      Size = 2
    end
  end
  object QryTipoDesenlace: TFDQuery
    Connection = ConectaRegistroFD
    Transaction = FDTransaccion
    SQL.Strings = (
      
        'select cdg_desenlace,descripcion from tecno_desenlace where UPPE' +
        'R(descripcion)=UPPER(:dato)')
    Left = 536
    Top = 224
    ParamData = <
      item
        Name = 'DATO'
        DataType = ftString
        ParamType = ptInput
        Value = Null
      end>
    object QryTipoDesenlacecdg_desenlace: TIntegerField
      FieldName = 'cdg_desenlace'
      Origin = 'cdg_desenlace'
      Required = True
    end
    object QryTipoDesenlacedescripcion: TStringField
      FieldName = 'descripcion'
      Origin = 'descripcion'
      Size = 255
    end
  end
  object QryOperaciones: TFDQuery
    Connection = ConectaRegistroFD
    Transaction = FDTransaccion
    Left = 536
    Top = 280
  end
  object QryProfesion: TFDQuery
    Connection = ConectaRegistroFD
    Transaction = FDTransaccion
    SQL.Strings = (
      
        'select cdg_profesion,descripcion from tecno_profesion where UPPE' +
        'R(descripcion)=UPPER(:profesion)')
    Left = 536
    Top = 344
    ParamData = <
      item
        Name = 'PROFESION'
        DataType = ftString
        ParamType = ptInput
        Value = Null
      end>
    object QryProfesioncdg_profesion: TIntegerField
      FieldName = 'cdg_profesion'
      Origin = 'cdg_profesion'
      Required = True
    end
    object QryProfesiondescripcion: TStringField
      FieldName = 'descripcion'
      Origin = 'descripcion'
      Size = 128
    end
  end
  object QryFuncionario: TFDQuery
    Connection = ConectaRegistroFD
    SQL.Strings = (
      
        'select cdgfuncionario,nmbfuncionario,login_name from funcionario' +
        's where login_name=:login')
    Left = 624
    Top = 232
    ParamData = <
      item
        Name = 'LOGIN'
        DataType = ftString
        ParamType = ptInput
        Value = Null
      end>
    object QryFuncionariocdgfuncionario: TBCDField
      FieldName = 'cdgfuncionario'
      Origin = 'cdgfuncionario'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
      Required = True
      Precision = 4
      Size = 0
    end
    object QryFuncionarionmbfuncionario: TStringField
      FieldName = 'nmbfuncionario'
      Origin = 'nmbfuncionario'
      Size = 60
    end
    object QryFuncionariologin_name: TStringField
      FieldName = 'login_name'
      Origin = 'login_name'
      Size = 30
    end
  end
  object QryCausaProbable: TFDQuery
    Connection = ConectaRegistroFD
    SQL.Strings = (
      
        'select cdg_causa,termino_ea from tecno_causa_probable where term' +
        'ino_ea=:termino')
    Left = 624
    Top = 304
    ParamData = <
      item
        Name = 'TERMINO'
        DataType = ftString
        ParamType = ptInput
        Value = Null
      end>
    object QryCausaProbablecdg_causa: TIntegerField
      FieldName = 'cdg_causa'
      Origin = 'cdg_causa'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
      Required = True
    end
    object QryCausaProbabletermino_ea: TStringField
      FieldName = 'termino_ea'
      Origin = 'termino_ea'
      Size = 255
    end
  end
end
