Sub GetQuijote()
Dim i As Integer
Dim q As String
Dim uf As String
For i = 0 To 35
    q = CStr(i)
    Range("B3").Select
    ActiveWorkbook.Worksheets.Add
    With ActiveSheet.QueryTables.Add(Connection:= _
        "URL;http://www.elmundo.es/quijote/capitulo.html?cual=" + q, Destination:=Range( _
        "$A$1"))
        .Name = "capitulo.html?cual=1"
        .FieldNames = True
        .RowNumbers = False
        .FillAdjacentFormulas = False
        .PreserveFormatting = True
        .RefreshOnFileOpen = False
        .BackgroundQuery = True
        .RefreshStyle = xlInsertDeleteCells
        .SavePassword = False
        .SaveData = True
        .AdjustColumnWidth = True
        .RefreshPeriod = 0
        .WebSelectionType = xlEntirePage
        .WebFormatting = xlWebFormattingNone
        .WebPreFormattedTextToColumns = True
        .WebConsecutiveDelimitersAsOne = True
        .WebSingleBlockTextImport = False
        .WebDisableDateRecognition = False
        .WebDisableRedirections = False
        .Refresh BackgroundQuery:=False
    End With
Range("A1:A38").EntireRow.Delete
uf = Cells(1048576, 1).End(xlUp).row
Cells(uf, 1).Delete
'ActiveWorkbook.SaveAs Filename:="C:\temp\Capitulo" + q + ".txt", _FileFormat:=xlText, CreateBackup:=False
Next i
End Sub
