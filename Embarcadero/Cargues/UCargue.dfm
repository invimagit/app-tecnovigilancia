object Form1: TForm1
  Left = 0
  Top = 0
  Caption = 'Form1'
  ClientHeight = 596
  ClientWidth = 1036
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 13
  object btnAbrir: TButton
    Left = 48
    Top = 136
    Width = 75
    Height = 25
    Caption = 'Abrir'
    TabOrder = 0
    OnClick = btnAbrirClick
  end
  object OpenDialogExcel: TOpenDialog
    Left = 56
    Top = 48
  end
end
