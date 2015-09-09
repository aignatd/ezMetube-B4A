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

	Private pLogin 		As Panel
	Private pBadan 		As Panel
	Private lblNama 	As Label
	Private lblEmail 	As Label
	Private etEmail 	As EditText
	Private lblPass 	As Label
	Private etPass 		As EditText
	Private bLogin 		As Button
	Private lblOr 		As Label
	Private lblRegister As Label
	Private lblForgot 	As Label
	Private BDLogin		As BetterDialogs

	Private lblLogin As Label
	Private iv2 As ImageView
	Private iv1 As ImageView
	Private iv4 As ImageView
	Private iv3 As ImageView
	
	Private ivFacebook As ImageView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("Login")

		#Region Cek File Config.json
	If File.Exists(File.DirAssets, "config.json") Then
		If Fungsi.CacahJSON(File.ReadString(File.DirAssets, "config.json"), "NextArray") = False Then
			BDLogin.Msgbox("Error", "Reading config failed !", "OK", "", "", Fungsi.GetDrawable("ic_action_warning"))
			ExitApplication
		End If
	Else
		BDLogin.Msgbox("Error", "Load config failed !", "OK", "", "", Fungsi.GetDrawable("ic_action_warning"))
		ExitApplication
	End If
	#End Region
	
		#Region Set Background
	Dim cdBack 	As ColorDrawable	
	Dim bPanel  As ColorDrawable
	cdBack.Initialize(Colors.RGB(252, 252, 252), 5)	
	bPanel.Initialize(Colors.RGB(243, 243, 243), 0)
	iv1.Background = Fungsi.GetDrawable("users81")
	iv2.Background = cdBack
	iv3.Background = Fungsi.GetDrawable("lock24")
	iv4.Background = cdBack
	etEmail.Background = cdBack
	etPass.Background = cdBack
	pBadan.Background = bPanel
	#End Region

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
Sub bLogin_Click
      
		Dim HomeJob As MNChttpjob
		Dim	strEnc	As String
		Dim Gen		As JSONGenerator
		Dim mlogin	As Map
		Dim mlist 	As List
		Dim mMap	As Map
		

		HomeJob.Initialize("Login", Me)

		Try
			HomeJob.Tag = "Login"
			Log((Fungsi.mpList.Get("key1a")) & "&" & Fungsi.mpList.Get("key2a"))
			HomeJob.PostString(Fungsi.mpList.Get("LoginURL"), Fungsi.mpList.Get("key1a") & etEmail.text & "&" & Fungsi.mpList.Get("key2a") & etPass.Text )
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
			Msgbox2("Offline Connection or Server Down", "Moviebay", "OK", "", "", LoadBitmap(File.DirAssets, "warning.png"))
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
Sub lblRegister_Click
	StartActivity("Register")
End Sub
Sub ivOkezone_Click
	Dim p As PhoneIntents

	StartActivity(p.OpenBrowser("http://www.okezone.com/"))		

	Return
End Sub
Sub ivFacebook_Click
	
		Dim HomeJob As MNChttpjob
		Dim	strEnc	As String
		Dim Gen		As JSONGenerator
		Dim mlogin	As Map
		Dim mlist 	As List
		Dim mMap	As Map
		

		HomeJob.Initialize("LoginFB", Me)

		Try
			HomeJob.Tag = "LoginFB"
			Log((Fungsi.mpList.Get("key1a")) & "&" & Fungsi.mpList.Get("key2a"))
			HomeJob.PostString(Fungsi.mpList.Get("FacebookURL"), Fungsi.mpList.Get("FB_id") & etEmail.text & "&" & Fungsi.mpList.Get("key2a") & etPass.Text )
			HomeJob.GetRequest.Timeout = DateTime.TicksPerSecond * 60
		Catch
			Msgbox2("Login Failure !", "MeTube", "OK", "", "", LoadBitmap(File.DirAssets, "warning.png"))
		End Try
End Sub