ALTER TABLE [dbo].[tecno_usuarios_internet] ALTER COLUMN email_persona varchar(300); 
ALTER TABLE [dbo].[tecno_usuarios_internet] ALTER COLUMN email_empresa varchar(300); 
ALTER TABLE [dbo].[tecno_usuarios_internet] ALTER COLUMN cargo_persona varchar(300); 
ALTER TABLE [SIVICOS].[dbo].[tecno_exp_alertas] ALTER COLUMN medidas_tomadas text; 
ALTER TABLE [SIVICOS].[dbo].[tecno_red] ALTER COLUMN [cdg_funcionario] bigint; 
UPDATE [dbo].[tecno_modalidad]
   SET [descripcion] = 'ESTABLECIMIENTOS AAP USO DESFIBRILADORES AUTOMÁTICOS (DEA)'
 WHERE descripcion = 'NO APLICA';
INSERT INTO [dbo].[tecno_roles_menu]  ([ID_OPCION_MENU],[ID_ROL])   VALUES (4,4);

/*
INSERT INTO [dbo].[tecno_menus]
           ([mostrar_menu]
           ,[solucion_menu]
           ,[accion_menu]
           ,[descripcion_menu]
           ,[url_menu]
           ,[permitido_menu]
           ,[idopcion])
     VALUES
           ('S'
           ,'E'
           ,'null'
           ,'Reportes FOREIU'
           ,'pages/reporteForeiu.xhtml'
           ,1
           ,20);
		   
INSERT INTO [dbo].[tecno_roles_menu]
           ([ID_OPCION_MENU]
           ,[ID_ROL])
     VALUES
           (20

           ,1);
		   
ALTER TABLE [SIVICOS].[dbo].[tecno_monitoreo] ALTER COLUMN [funcionario_monitoreo] decimal(16,0) ; 
ALTER TABLE [SIVICOS].[dbo].[tecno_usuarios] ALTER COLUMN cdgfuncionario decimal(16,0) ; 

GRANT SELECT ON OBJECT:: [registro].[dbo].[marca_producto]TO usr_internet_sivicos; 
INSERT INTO [dbo].[tecno_menus]
           ([mostrar_menu]
           ,[solucion_menu]
           ,[accion_menu]
           ,[descripcion_menu]
           ,[url_menu]
           ,[permitido_menu]
           ,[idopcion])
     VALUES
           ('S'
           ,'E'
           ,'null'
           ,'Inscritos a la Red'
           ,'pages/inscribirRed.xhtml'
           ,1
           ,21);
INSERT INTO [dbo].[tecno_roles_menu]
([ID_OPCION_MENU]
,[ID_ROL])
     VALUES
           (21
           ,1);
*/

//************************************************
ALTER TABLE [dbo].[tecno_usuarios_internet] ALTER COLUMN email_persona varchar(300); 
ALTER TABLE [dbo].[tecno_usuarios_internet] ALTER COLUMN email_empresa varchar(300); 
ALTER TABLE [dbo].[tecno_usuarios_internet] ALTER COLUMN cargo_persona varchar(300); 
ALTER TABLE [SIVICOS].[dbo].[tecno_exp_alertas] ALTER COLUMN medidas_tomadas text; 
ALTER TABLE [SIVICOS].[dbo].[tecno_red] ALTER COLUMN [cdg_funcionario] bigint; 
UPDATE [dbo].[tecno_modalidad]
   SET [descripcion] = 'ESTABLECIMIENTOS AAP USO DESFIBRILADORES AUTOMÁTICOS (DEA)'
 WHERE descripcion = 'NO APLICA';
INSERT INTO [dbo].[tecno_roles_menu]  ([ID_OPCION_MENU],[ID_ROL])   VALUES        (4,4);


* ENVIAR CORREO A JENNY PARA MODIFICAR EL JOB 

Usuario Captacha
usuarioinvima@gmail.com
Invima2020.