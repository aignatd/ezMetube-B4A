Type=Activity
Version=4
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private BDMain			As BetterDialogs	
	Private svUtama 		As ScrollView
	Private iTampil 		As Int=0
	Private pSemua 			As Panel
	Private ivMenu 			As ImageView
	Private ivSearch	 	As ImageView
	Private ivClose 		As ImageView
	Private ivSetting 		As ImageView
	Private lblBrowse 		As Label
	Private lvBrowse 		As ListView
	Private svList 			As ScrollView
	Private lvVideo 		As ListView
	Private lvCate 			As ListView
	Private lvManage 		As ListView
	Private MB 				As MediaBrowser
	Private picMusic		As Bitmap
	Private mapCover		As Map
	Private container 		As AHPageContainer
	Private pager 			As AHViewPager
	Private pCoverFlow 		As Panel
	Private tCover			As Timer
	Private picMusic		As Bitmap
	Private picVideo		As Bitmap
	Private picLain			As Bitmap
	Private lstFilter 		As List
	Private CurrPage 		As Int = 0
	Private arah			As Int = 0
'	Private cv 				As CostumListView
	Private lblMost 		As Label
	Private ivGaris 		As ImageView
	Private ivGambar1 		As ImageView
	Private ivGambar4 		As ImageView
	Private ivMore 			As ImageView
	Private iTampil1 		As Int=0
	Private iTampil2 		As Int=0
	Private pTop 			As Panel
	Private etSearch 		As EditText
	Private lblJudul1 		As Label
	Private lblLogin  		As Label
	
	Dim coverflow 		As PhotoFlow
	Private bLogin 		As Button
	Private bMore 		As Button
	Dim pos_cflow 		As Int
	Dim panel1 			As Panel
	Dim timer_cflow		As Timer
	Dim a, b			As Int
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	'Activity.LoadLayout("Layout1")
	Activity.LoadLayout("Utama")

	Fungsi.SetDirProg("")
	Fungsi.DataConfig.FolderDBS = Fungsi.DirDBS
	Fungsi.BacaFileConfig	
	
	MB.Initialize("MB")
	mapCover.Initialize

	If tCover.IsInitialized = False Then tCover.Initialize("tCover", 1000)
	tCover.Enabled = False
	DoEvents
	
	#Region Cek File Config.json
	If File.Exists(File.DirAssets, "config.json") Then
		If Fungsi.CacahJSON(File.ReadString(File.DirAssets, "config.json"), "NextArray") = False Then
			BDMain.Msgbox(Fungsi.TitleBox, Fungsi.InitFail, Fungsi.btnOK, "", "", Fungsi.GetDrawable(Fungsi.icWarning))
			ExitApplication
		End If
	Else
		BDMain.Msgbox(Fungsi.TitleBox, Fungsi.LoadFail, Fungsi.btnOK, "", "", Fungsi.GetDrawable(Fungsi.icWarning))
		ExitApplication
	End If
#End Region

	For i=0 To 2
		Dim PanEPG 		As Panel
						
		
		PanEPG.Initialize("")
		PanEPG.LoadLayout("smartphone")
		'svUtama.Panel.AddView(PanEPG, 0, i * lblMost.Height, svUtama.Width, lblMost.Height)
		svUtama.Panel.AddView(PanEPG,  0 , i * 100%y, svUtama.Width, 100%y)
		
		svUtama.Panel.Width  = 100%x
		svUtama.Panel.Height = 350%y
		
	Next
	
	svList.Panel.LoadLayout("list")

	
	svList.Panel.Width  = 100%x
	svList.Panel.Height = 120%y
	
	#Region Set Background
	Dim cdBack 	As ColorDrawable	
	Dim tombol As ColorDrawable
	cdBack.Initialize(Colors.RGB(238, 238, 238), 5)	
	tombol.Initialize(Colors.RGB(243, 243, 243), 5)
	etSearch.Background = cdBack
	bMore.Background = tombol
	#End Region''
	
	'Activity.LoadLayout("pcoverflow")
	coverflow.InitializeCoverflow("coverflow")
	pCoverFlow.AddView(coverflow, 0%x, 0%y, 100%x, 100%y)
	coverflow.Width =100%x 
	coverflow.Height=30%y
	coverflow.Left=0%x
	coverflow.Top=0%x
	coverflow.Spacing= -400
	coverflow.ItemWidth = pCoverFlow.Width + 5%y
	coverflow.ItemHeight = pCoverFlow.Height + 20%y
	coverflow.AnimationDuration=1500
	coverflow.FadingEdgeLength=0
	coverflow.Carousel=False
	coverflow.Reverse=False
	
	coverflow.PopulatePhotoFlowFromAssets("a")	
	coverflow.AddImageAt(0, File.DirAssets, "okezone.jpg")
	coverflow.AddImageAt(1, File.DirAssets, "mnc.jpg")
	coverflow.AddImageAt(2, File.DirAssets, "moviebay.png")
	

#Region Set Background
	'pAction.Background = Fungsi.GetDrawable(Fungsi.icTopHeader)
	
	'pInfo.Background = Fungsi.GetDrawable(Fungsi.icPanelInfo)
	ivMenu.Background = Fungsi.GetDrawable(Fungsi.icMenuPilih)
	ivSearch.Background = Fungsi.GetDrawable(Fungsi.iccaridata)
	'pMenuKiri.Background = Fungsi.GetDrawable(Fungsi.icPanelKiri)	
	ivClose.Background = Fungsi.GetDrawable(Fungsi.icTutup)	
	ivSetting.Background = Fungsi.GetDrawable(Fungsi.icSetting)
	
#End Region

	
'	init_catefilm
'	DoEvents
	init_Browse	
	DoEvents
	init_Video
	DoEvents
	init_Category
	DoEvents
	init_Media
	DoEvents
	
		'ProsesFileOffline
		DoEvents
		ProsesCoverFlowStorage	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
Sub ivMenu_Click
	Slide_Menu	
End Sub

Sub Slide_Menu
	DoEvents
	
	If iTampil=0 Then
		iTampil = 1
		pSemua.SetLayoutAnimated(800, 0%x, 0, 165%x, 100%y)
		
	Else
		iTampil = 0
		pSemua.SetLayoutAnimated(800, -65%x, 0, 165%x, 100%y)
	End If
End Sub
Sub Activity_KeyPress (KeyCode As Int) As Boolean 'return true if you want To consume the event
	If KeyCode = 4 Then
	'	If iTampil = 1 Then Slide_Menu
		
		If BDMain.Msgbox(Fungsi.TitleBox, Fungsi.lblExit, Fungsi.btnOK, Fungsi.btnNO, "", Fungsi.GetDrawable("ic_action_warning")) = DialogResponse.POSITIVE Then
			ExitApplication
		End If
		
		Return True
	End If		
End Sub
Sub init_Browse	
	
'	Dim TimeFont1 As Typeface
'	
'	TimeFont1 = Typeface.LoadFromAssets ("gotham-medium.ttf")

	lvBrowse.Clear
	Fungsi.SetDivider(lvBrowse, Colors.Transparent, 1dip)
	
	lvBrowse.FastScrollEnabled = False
	
	lvBrowse.AddTwoLinesAndBitmap("Channel", "", LoadBitmap(File.DirAssets,("movie44.png")))
	lvBrowse.AddTwoLinesAndBitmap("Sub Channel", "", LoadBitmap(File.DirAssets,("movie44.png")))
	lvBrowse.AddTwoLinesAndBitmap("Top Uploader", "", LoadBitmap(File.DirAssets,("movie44.png")))
	 
	lvBrowse.TwoLinesAndBitmap.Label.TextColor = Colors.White
	lvBrowse.TwoLinesAndBitmap.Label.TextSize = 15
	lvBrowse.TwoLinesAndBitmap.Label.Gravity = Gravity.FILL
	lvBrowse.TwoLinesAndBitmap.ImageView.Height = 18dip
	lvBrowse.TwoLinesAndBitmap.ImageView.Width = 18dip
	lvBrowse.TwoLinesAndBitmap.ItemHeight = 30dip
'	lvUtama.TwoLinesAndBitmap.ImageView.Height = 60dip
'	lvUtama.TwoLinesAndBitmap.ImageView.Width = 35dip	
'	lvMenuKiri.AddSingleLine("CHANNEL")
'	lvMenuKiri.AddSingleLine("MOVIES")
'	lvMenuKiri.AddSingleLine("SERIES")
''	lvCateFilm.AddSingleLine("KIDS")
'	lvMenuKiri.SingleLineLayout.Label.TextColor = Colors.White
'	lvMenuKiri.SingleLineLayout.Label.Gravity = Gravity.CENTER
'	lvMenuKiri.SingleLineLayout.Label.TextSize = 14
'	lvMenuKiri.SingleLineLayout.ItemHeight = 50dip
'	'lvMenuKiri.SingleLineLayout.Label.Typeface = TimeFont1
'	lvMenuKiri.SingleLineLayout.Label.Left = 20
End Sub
Sub init_Video	
	
'	Dim TimeFont1 As Typeface
'	
'	TimeFont1 = Typeface.LoadFromAssets ("gotham-medium.ttf")

	lvVideo.Clear
	Fungsi.SetDivider(lvVideo, Colors.Transparent, 1dip)
	
	lvVideo.FastScrollEnabled = False
	
	lvVideo.AddTwoLinesAndBitmap("Watch to Watch", "", LoadBitmap(File.DirAssets,("bright2.png")))
	lvVideo.AddTwoLinesAndBitmap("Most Popular", "", LoadBitmap(File.DirAssets,("soccer-cup.png")))
	
	
	lvVideo.TwoLinesAndBitmap.Label.TextColor = Colors.White
	lvVideo.TwoLinesAndBitmap.Label.TextSize = 15
	lvVideo.TwoLinesAndBitmap.Label.Gravity = Gravity.FILL
	lvVideo.TwoLinesAndBitmap.ImageView.Height = 20dip
	lvVideo.TwoLinesAndBitmap.ImageView.Width = 20dip
	lvVideo.TwoLinesAndBitmap.ItemHeight = 30dip
'	lvUtama.TwoLinesAndBitmap.ImageView.Height = 60dip
'	lvUtama.TwoLinesAndBitmap.ImageView.Width = 35dip	

'	lvMenuKiri.SingleLineLayout.Label.TextColor = Colors.White
'	lvMenuKiri.SingleLineLayout.Label.Gravity = Gravity.CENTER
'	lvMenuKiri.SingleLineLayout.Label.TextSize = 14
'	lvMenuKiri.SingleLineLayout.ItemHeight = 50dip
'	'lvMenuKiri.SingleLineLayout.Label.Typeface = TimeFont1
'	lvMenuKiri.SingleLineLayout.Label.Left = 20
End Sub
Sub init_Category
	
'	Dim TimeFont1 As Typeface
'	
'	TimeFont1 = Typeface.LoadFromAssets ("gotham-medium.ttf")

	lvCate.Clear
	Fungsi.SetDivider(lvCate, Colors.Transparent, 1dip)
	
	lvCate.FastScrollEnabled = False
	
	lvCate.AddTwoLinesAndBitmap("General", "", LoadBitmap(File.DirAssets,("square234.png")))
	lvCate.AddTwoLinesAndBitmap("Music", "", LoadBitmap(File.DirAssets,("note55.png")))
	lvCate.AddTwoLinesAndBitmap("Autos & Vehicles", "", LoadBitmap(File.DirAssets,("road22.png")))
	lvCate.AddTwoLinesAndBitmap("Education", "", LoadBitmap(File.DirAssets,("draw21.png")))
	lvCate.AddTwoLinesAndBitmap("Entertainment", "", LoadBitmap(File.DirAssets,("camera2.png")))
	lvCate.AddTwoLinesAndBitmap("Gaming", "", LoadBitmap(File.DirAssets,("controller2.png")))
	lvCate.AddTwoLinesAndBitmap("Fashion & Beauty", "", LoadBitmap(File.DirAssets,("controller2.png")))
		
	lvCate.TwoLinesAndBitmap.Label.TextColor = Colors.White
	lvCate.TwoLinesAndBitmap.Label.TextSize = 15
	lvCate.TwoLinesAndBitmap.Label.Gravity = Gravity.FILL
	lvCate.TwoLinesAndBitmap.ImageView.Height = 16dip
	lvCate.TwoLinesAndBitmap.ImageView.Width = 16dip
	lvCate.TwoLinesAndBitmap.ItemHeight = 30dip
'	lvUtama.TwoLinesAndBitmap.ImageView.Height = 60dip
'	lvUtama.TwoLinesAndBitmap.ImageView.Width = 35dip	

'	lvMenuKiri.SingleLineLayout.Label.TextColor = Colors.White
'	lvMenuKiri.SingleLineLayout.Label.Gravity = Gravity.CENTER
'	lvMenuKiri.SingleLineLayout.Label.TextSize = 14
'	lvMenuKiri.SingleLineLayout.ItemHeight = 50dip
'	'lvMenuKiri.SingleLineLayout.Label.Typeface = TimeFont1
'	lvMenuKiri.SingleLineLayout.Label.Left = 20
End Sub
Sub init_Media
	
'	Dim TimeFont1 As Typeface
'	
'	TimeFont1 = Typeface.LoadFromAssets ("gotham-medium.ttf")

	lvManage.Clear
	Fungsi.SetDivider(lvManage, Colors.Transparent, 1dip)
	
	lvManage.FastScrollEnabled = False
	
	lvManage.AddTwoLinesAndBitmap("Upload Video", "", LoadBitmap(File.DirAssets,("up_arrows16.png")))
	lvManage.AddTwoLinesAndBitmap("My Videos", "", LoadBitmap(File.DirAssets,("start3.png")))
	lvManage.AddTwoLinesAndBitmap("My Playlits", "", LoadBitmap(File.DirAssets,("road22.png")))
	lvManage.AddTwoLinesAndBitmap("My Channel", "", LoadBitmap(File.DirAssets,("movie44.png")))
	lvManage.AddTwoLinesAndBitmap("My Subcription", "", LoadBitmap(File.DirAssets,("wifi-signal1.png")))
	lvManage.AddTwoLinesAndBitmap("Subcribers", "", LoadBitmap(File.DirAssets,("favorite21.png")))
		
	lvManage.TwoLinesAndBitmap.Label.TextColor = Colors.White
	lvManage.TwoLinesAndBitmap.Label.TextSize = 15
	lvManage.TwoLinesAndBitmap.Label.Gravity = Gravity.FILL
	lvManage.TwoLinesAndBitmap.ImageView.Height = 16dip
	lvManage.TwoLinesAndBitmap.ImageView.Width = 16dip
	lvManage.TwoLinesAndBitmap.ItemHeight = 30dip
'	lvUtama.TwoLinesAndBitmap.ImageView.Height = 60dip
'	lvUtama.TwoLinesAndBitmap.ImageView.Width = 35dip	

'	lvMenuKiri.SingleLineLayout.Label.TextColor = Colors.White
'	lvMenuKiri.SingleLineLayout.Label.Gravity = Gravity.CENTER
'	lvMenuKiri.SingleLineLayout.Label.TextSize = 14
'	lvMenuKiri.SingleLineLayout.ItemHeight = 50dip
'	'lvMenuKiri.SingleLineLayout.Label.Typeface = TimeFont1
'	lvMenuKiri.SingleLineLayout.Label.Left = 20
End Sub
Sub ivSetting_Click
	'StartActivity("Setting")
End Sub
Sub ivClose_Click
	Activity_KeyPress(4)
End Sub
Sub ProsesCoverFlowStorage
'	Dim k	As Int
'
'  
'	For k = 0 To mapCover.Size - 1
'		Dim ivpicCover 	As ImageView
'		ivpicCover.Initialize("")
'		ivpicCover.RemoveView
'		ivpicCover.Gravity = Gravity.FILL
'		
'		ivpicCover.Bitmap = mapCover.GetValueAt(k)
'		container.AddPage(ivpicCover, k)	
'	Next
'
'	If mapCover.Size <> 0 Then tCover.Enabled = True
End Sub
Sub tCover_Tick
'	If arah = 0 Then
'		CurrPage = CurrPage + 1
'		pager.GotoPage(CurrPage, True)
'		If CurrPage = container.Count-1 Then arah = 1
'	Else
'		CurrPage = CurrPage - 1
'		pager.GotoPage(CurrPage, True)
'		If CurrPage = 0 Then arah = 0
'	End If
End Sub
Sub ivSearch_Click
	If iTampil2 = 0 Then 
		iTampil2 = 1
		etSearch.SetLayoutAnimated(500, 0, 10%y, pTop.Width, 18%y - pTop.Height)
	Else	
		iTampil2 = 0
		etSearch.SetLayoutAnimated(500, 0, pTop.Height, pTop.Width, 0)
	End If		
End Sub
Sub lvBrowse_ItemClick (Position As Int, Value As Object)
	Slide_Menu
End Sub
Sub lvVideo_ItemClick (Position As Int, Value As Object)
	Slide_Menu
End Sub
Sub lvCate_ItemClick (Position As Int, Value As Object)
	Slide_Menu
End Sub
Sub lvManage_ItemClick (Position As Int, Value As Object)
	Slide_Menu
End Sub
Sub lblLogin_Click
'	Dim p As PhoneIntents
'
'	'BD.CloseDialog(DialogResponse.CANCEL)
'	StartActivity(p.OpenBrowser("https://id.okezone.com/users/sign_in"))		
'
'	Return

	StartActivity("Login")
End Sub

Sub bMore_Click
	
End Sub
Sub Coverflow_ItemClick(Position As Int, Value As Object)
'	================Click Item Coverflow=================
    coverflow.GetItem(b)
	'Log(coverflow.GetItem(b))
End Sub

Sub timer_cflow_Tick
'	===============Timer Coverflow 6 Second Change Item================
	If b <= coverflow.Length-1 Then
		coverflow.Selection=b
		a=1
		b=b+a
	Else
		b=0
		coverflow.Selection=b
	End If
	'Log(b)
End Sub

'Sub Coverflow_ItemLongClick (Position As Int, Value As Object)
'	
'End Sub

Sub Coverflow_ItemSelected(Position As Int, Value As Object)
'	===============Item Selected Coverflow============================
	b = Position
	timer_cflow.Initialize("timer_cflow", 1000)
	timer_cflow.Enabled=True
End Sub
Sub lblMost_Click
		
		Dim HomeJob As MNChttpjob
		Dim	strEnc	As String
		Dim Gen		As JSONGenerator
		Dim mlogin	As Map
		Dim mlist 	As List
		Dim mMap	As Map
		

		HomeJob.Initialize("GetListVideo", Me)

		Try
			HomeJob.Tag = "GetListVideo"
			'Log(Fungsi.mpList.Get("List") & "&" & Fungsi.mpList.Get("Jumlah") & "&" & Fungsi.mpList.Get("Halaman"))
			HomeJob.PostString(Fungsi.mpList.Get("ListURL"), Fungsi.mpList.Get("List") & lblMost.text & "&" & Fungsi.mpList.Get("Jumlah") & "&" & Fungsi.mpList.Get("Halaman"))
			HomeJob.GetRequest.Timeout = DateTime.TicksPerSecond * 60
		Catch
			Msgbox2("Login Failure !", "MeTube", "OK", "", "", LoadBitmap(File.DirAssets, "warning.png"))
		End Try
End Sub
Sub JobDone (MNChttp As MNChttpjob)
	Dim sf			As StringFunctions
	Dim sTmp 		As String
	Dim parser 		As JSONParser	
	Dim mresult		As Map
	Dim bTmp()		As Byte
	Dim bcTmp		As ByteConverter
	Dim su 			As StringUtils

	Log((MNChttp.GetString))
	#Region HTTP Gagal
	If MNChttp.Success = False Then
		If (sf.InString(MNChttp.ErrorMessage, "timed out") > 0) OR (sf.InString(MNChttp.ErrorMessage, "refused") > 0) OR _
			 (sf.InString(MNChttp.ErrorMessage, "Unable to resolve host") > 0) OR (sf.InString(MNChttp.ErrorMessage, "UnknownHostException") > 0) OR _
			 (sf.InString(MNChttp.ErrorMessage, "FileNotFound") > 0) Then
'			ctoast.Show4("Error", "Offline Connection or Server Down", LoadBitmap(File.DirAssets, "warning.png"))
			Msgbox2("Offline Connection or Server Down", "MeTube", "OK", "", "", LoadBitmap(File.DirAssets, "warning.png"))
		Else
			If sf.InString(MNChttp.ErrorMessage, "Not Found") < 0 Then
'				ctoast.Show4("Error", "Unknown Error", LoadBitmap(File.DirAssets, "warning.png"))
				Msgbox2("Unknown Error", "MeTube", "OK", "", "", LoadBitmap(File.DirAssets, "warning.png"))
			End If
		End If

		Fungsi.mpList.Put("Koneksi", "Offline")
		MNChttp.Release
	#End Region
	#Region HTTP Sukses
	Else

		Try
	'		bTmp = su.DecodeBase64(MNChttp.GetString)
	'		sTmp = bcTmp.StringFromBytes(bTmp, "UTF8")
			parser.Initialize(MNChttp.GetString)
			MNChttp.Release
		Catch
			Msgbox2("Process Failure !", "MeTube", "OK", "", "", LoadBitmap(File.DirAssets, "warning.png"))			
			Return
		End Try
		
		Try
			mresult.Initialize
			mresult = parser.NextObject
		Catch
			Msgbox2("Process Failure !", "MeTube", "OK", "", "", LoadBitmap(File.DirAssets, "warning.png"))			
			Return
		End Try
		
		If mresult.Get("error_code") <> "0" Then
			Msgbox2(mresult.Get("error_msg"), "MeTube", "OK", "", "", LoadBitmap(File.DirAssets, "warning.png"))			
		Else
			Fungsi.mpList.Put("Koneksi", "Online")
			MNChttp.Release

			Select MNChttp.JobName			
		
			End Select
		End If
	End If	
End Sub