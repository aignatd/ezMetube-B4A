package metube.mncplaymedia.com;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class fungsi {
private static fungsi mostCurrent = new fungsi();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.collections.Map _mplist = null;
public static String _dirdbs = "";
public static metube.mncplaymedia.com.fungsi._formatconfig _dataconfig = null;
public static anywheresoftware.b4a.randomaccessfile.RandomAccessFile _raf = null;
public static String _szandroidid = "";
public static String _szrefserial = "";
public static String _szimei = "";
public static String _szimsi = "";
public static String _szmanufacturer = "";
public static String _szmodel = "";
public static String _szproduct = "";
public static String _szsubsid = "";
public static int _apiver = 0;
public static anywheresoftware.b4a.agraham.reflection.Reflection _refl = null;
public static anywheresoftware.b4a.phone.Phone _myphone = null;
public static anywheresoftware.b4a.phone.Phone.PhoneId _thisphone = null;
public static anywheresoftware.b4a.objects.collections.Map _mkoneksi = null;
public static String _boundary = "";
public static anywheresoftware.b4a.objects.collections.Map _catemap = null;
public static anywheresoftware.b4a.objects.collections.Map _moviesmap = null;
public static anywheresoftware.b4a.objects.collections.Map _channelmap = null;
public static anywheresoftware.b4a.objects.collections.Map _seriesmap = null;
public static anywheresoftware.b4a.objects.collections.Map _trailermap = null;
public static String _initfail = "";
public static String _titlebox = "";
public static String _btnok = "";
public static String _btncancel = "";
public static String _btnno = "";
public static String _loadfail = "";
public static String _nokoneksi = "";
public static String _lblhome = "";
public static String _lblbrowse = "";
public static String _lbllogin = "";
public static String _lblexit = "";
public static String _icwarning = "";
public static String _ichome = "";
public static String _icbrowse = "";
public static String _iclogin = "";
public static String _ictopheader = "";
public static String _icpanelinfo = "";
public static String _icmenupilih = "";
public static String _iccaridata = "";
public static String _icpanelkiri = "";
public static String _ictutup = "";
public static String _icpanahnext = "";
public static String _icsetting = "";
public metube.mncplaymedia.com.main _main = null;
public metube.mncplaymedia.com.login _login = null;
public metube.mncplaymedia.com.utama _utama = null;
public metube.mncplaymedia.com.register _register = null;
public metube.mncplaymedia.com.mncutils2service _mncutils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"APIver",_apiver,"boundary",_boundary,"btnCancel",_btncancel,"btnNO",_btnno,"btnOK",_btnok,"CateMap",_catemap,"ChannelMap",_channelmap,"DataConfig",_dataconfig,"DirDBS",_dirdbs,"icBrowse",_icbrowse,"iccaridata",_iccaridata,"icHome",_ichome,"icLogin",_iclogin,"icMenuPilih",_icmenupilih,"icPanahNext",_icpanahnext,"icPanelInfo",_icpanelinfo,"icPanelKiri",_icpanelkiri,"icSetting",_icsetting,"icTopHeader",_ictopheader,"icTutup",_ictutup,"icWarning",_icwarning,"InitFail",_initfail,"LblBrowse",_lblbrowse,"lblExit",_lblexit,"LblHome",_lblhome,"LblLogin",_lbllogin,"LoadFail",_loadfail,"Login",Debug.moduleToString(metube.mncplaymedia.com.login.class),"Main",Debug.moduleToString(metube.mncplaymedia.com.main.class),"mKoneksi",_mkoneksi,"MNCUtils2Service",Debug.moduleToString(metube.mncplaymedia.com.mncutils2service.class),"MoviesMap",_moviesmap,"mpList",_mplist,"myPhone",_myphone,"NoKoneksi",_nokoneksi,"raf",_raf,"refl",_refl,"Register",Debug.moduleToString(metube.mncplaymedia.com.register.class),"SeriesMap",_seriesmap,"szAndroidID",_szandroidid,"szIMEI",_szimei,"szIMSI",_szimsi,"szManufacturer",_szmanufacturer,"szModel",_szmodel,"szProduct",_szproduct,"szRefSerial",_szrefserial,"szSubsID",_szsubsid,"thisPhone",_thisphone,"TitleBox",_titlebox,"TrailerMap",_trailermap,"Utama",Debug.moduleToString(metube.mncplaymedia.com.utama.class)};
}
public static class _formatconfig{
public boolean IsInitialized;
public String aid;
public String rsn;
public String imei;
public String sTab;
public String MacAddr;
public String FolderDBS;
public String Username;
public String Password;
public String Token;
public String sStorage;
public String FolderMedia;
public void Initialize() {
IsInitialized = true;
aid = "";
rsn = "";
imei = "";
sTab = "";
MacAddr = "";
FolderDBS = "";
Username = "";
Password = "";
Token = "";
sStorage = "";
FolderMedia = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _filedata{
public boolean IsInitialized;
public String Dir;
public String FileName;
public String KeyName;
public String ContentType;
public void Initialize() {
IsInitialized = true;
Dir = "";
FileName = "";
KeyName = "";
ContentType = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _adjustbitmap(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp,int _width,int _height) throws Exception{
try {
		Debug.PushSubsStack("AdjustBitmap (fungsi) ","fungsi",4,_ba,mostCurrent,302);
float _ratiobmp = 0f;
float _ratioiv = 0f;
float _diviseur = 0f;
;
Debug.locals.put("bmp", _bmp);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 302;BA.debugLine="Public Sub AdjustBitmap(bmp As Bitmap, Width As Int, Height As Int) As Bitmap";
Debug.ShouldStop(8192);
 BA.debugLineNum = 303;BA.debugLine="Dim RatioBmp, RatioIV As Float";
Debug.ShouldStop(16384);
_ratiobmp = 0f;Debug.locals.put("RatioBmp", _ratiobmp);
_ratioiv = 0f;Debug.locals.put("RatioIV", _ratioiv);
 BA.debugLineNum = 304;BA.debugLine="RatioBmp = bmp.Width / bmp.Height";
Debug.ShouldStop(32768);
_ratiobmp = (float) (_bmp.getWidth()/(double)_bmp.getHeight());Debug.locals.put("RatioBmp", _ratiobmp);
 BA.debugLineNum = 305;BA.debugLine="RatioIV = Width / Height";
Debug.ShouldStop(65536);
_ratioiv = (float) (_width/(double)_height);Debug.locals.put("RatioIV", _ratioiv);
 BA.debugLineNum = 306;BA.debugLine="Dim Diviseur As Float";
Debug.ShouldStop(131072);
_diviseur = 0f;Debug.locals.put("Diviseur", _diviseur);
 BA.debugLineNum = 307;BA.debugLine="If RatioIV > RatioBmp Then";
Debug.ShouldStop(262144);
if (_ratioiv>_ratiobmp) { 
 BA.debugLineNum = 308;BA.debugLine="Diviseur = bmp.Height / Height";
Debug.ShouldStop(524288);
_diviseur = (float) (_bmp.getHeight()/(double)_height);Debug.locals.put("Diviseur", _diviseur);
 BA.debugLineNum = 309;BA.debugLine="bmp = CreateScaledBitmap(bmp, Round(bmp.Width / Diviseur / Density), Round(Height / Density))";
Debug.ShouldStop(1048576);
_bmp = _createscaledbitmap(_ba,_bmp,(int) (anywheresoftware.b4a.keywords.Common.Round(_bmp.getWidth()/(double)_diviseur/(double)anywheresoftware.b4a.keywords.Common.Density)),(int) (anywheresoftware.b4a.keywords.Common.Round(_height/(double)anywheresoftware.b4a.keywords.Common.Density)));Debug.locals.put("bmp", _bmp);
 }else {
 BA.debugLineNum = 311;BA.debugLine="Diviseur = bmp.Width / Width";
Debug.ShouldStop(4194304);
_diviseur = (float) (_bmp.getWidth()/(double)_width);Debug.locals.put("Diviseur", _diviseur);
 BA.debugLineNum = 312;BA.debugLine="bmp = CreateScaledBitmap(bmp, Round(Width / Density), Round(bmp.Height / Diviseur / Density))";
Debug.ShouldStop(8388608);
_bmp = _createscaledbitmap(_ba,_bmp,(int) (anywheresoftware.b4a.keywords.Common.Round(_width/(double)anywheresoftware.b4a.keywords.Common.Density)),(int) (anywheresoftware.b4a.keywords.Common.Round(_bmp.getHeight()/(double)_diviseur/(double)anywheresoftware.b4a.keywords.Common.Density)));Debug.locals.put("bmp", _bmp);
 };
 BA.debugLineNum = 314;BA.debugLine="Return bmp";
Debug.ShouldStop(33554432);
if (true) return _bmp;
 BA.debugLineNum = 315;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return null;
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _adjustimageview(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ImageViewWrapper _imv,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _img) throws Exception{
try {
		Debug.PushSubsStack("AdjustImageView (fungsi) ","fungsi",4,_ba,mostCurrent,317);
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
int _delta = 0;
int _height = 0;
int _width = 0;
;
Debug.locals.put("Imv", _imv);
Debug.locals.put("Img", _img);
 BA.debugLineNum = 317;BA.debugLine="Sub AdjustImageView(Imv As ImageView, Img As Bitmap)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 318;BA.debugLine="Private bmp As Bitmap = Img";
Debug.ShouldStop(536870912);
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp = _img;Debug.locals.put("bmp", _bmp);Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 320;BA.debugLine="Dim Delta, Height, Width As Int";
Debug.ShouldStop(-2147483648);
_delta = 0;Debug.locals.put("Delta", _delta);
_height = 0;Debug.locals.put("Height", _height);
_width = 0;Debug.locals.put("Width", _width);
 BA.debugLineNum = 321;BA.debugLine="If bmp.Width / bmp.Height > Imv.Width / Imv.Height Then";
Debug.ShouldStop(1);
if (_bmp.getWidth()/(double)_bmp.getHeight()>_imv.getWidth()/(double)_imv.getHeight()) { 
 BA.debugLineNum = 322;BA.debugLine="Height = bmp.Height / bmp.Width * Imv.Width";
Debug.ShouldStop(2);
_height = (int) (_bmp.getHeight()/(double)_bmp.getWidth()*_imv.getWidth());Debug.locals.put("Height", _height);
 BA.debugLineNum = 323;BA.debugLine="Delta = (Imv.Height - Height) / 2";
Debug.ShouldStop(4);
_delta = (int) ((_imv.getHeight()-_height)/(double)2);Debug.locals.put("Delta", _delta);
 BA.debugLineNum = 324;BA.debugLine="Imv.Height = Height";
Debug.ShouldStop(8);
_imv.setHeight(_height);
 BA.debugLineNum = 325;BA.debugLine="Imv.Top = Imv.Top + Delta";
Debug.ShouldStop(16);
_imv.setTop((int) (_imv.getTop()+_delta));
 }else {
 BA.debugLineNum = 327;BA.debugLine="Width = bmp.Width / bmp.Height * Imv.Height";
Debug.ShouldStop(64);
_width = (int) (_bmp.getWidth()/(double)_bmp.getHeight()*_imv.getHeight());Debug.locals.put("Width", _width);
 BA.debugLineNum = 328;BA.debugLine="Delta = (Imv.Width - Width) / 2";
Debug.ShouldStop(128);
_delta = (int) ((_imv.getWidth()-_width)/(double)2);Debug.locals.put("Delta", _delta);
 BA.debugLineNum = 329;BA.debugLine="Imv.Width = Width";
Debug.ShouldStop(256);
_imv.setWidth(_width);
 BA.debugLineNum = 330;BA.debugLine="Imv.Left = Imv.Left + Delta";
Debug.ShouldStop(512);
_imv.setLeft((int) (_imv.getLeft()+_delta));
 };
 BA.debugLineNum = 332;BA.debugLine="Imv.Gravity = Gravity.FILL";
Debug.ShouldStop(2048);
_imv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 BA.debugLineNum = 333;BA.debugLine="Imv.Bitmap = bmp";
Debug.ShouldStop(4096);
_imv.setBitmap((android.graphics.Bitmap)(_bmp.getObject()));
 BA.debugLineNum = 334;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static boolean  _bacafileconfig(anywheresoftware.b4a.BA _ba) throws Exception{
try {
		Debug.PushSubsStack("BacaFileConfig (fungsi) ","fungsi",4,_ba,mostCurrent,163);
anywheresoftware.b4a.objects.collections.Map _mptemp = null;
;
 BA.debugLineNum = 163;BA.debugLine="Sub BacaFileConfig As Boolean";
Debug.ShouldStop(4);
 BA.debugLineNum = 164;BA.debugLine="Dim mpTemp	As Map";
Debug.ShouldStop(8);
_mptemp = new anywheresoftware.b4a.objects.collections.Map();Debug.locals.put("mpTemp", _mptemp);
 BA.debugLineNum = 166;BA.debugLine="mpTemp.Initialize";
Debug.ShouldStop(32);
_mptemp.Initialize();
 BA.debugLineNum = 167;BA.debugLine="mpTemp.Clear";
Debug.ShouldStop(64);
_mptemp.Clear();
 BA.debugLineNum = 169;BA.debugLine="InfoDevice";
Debug.ShouldStop(256);
_infodevice(_ba);
 BA.debugLineNum = 171;BA.debugLine="If File.Exists(DirDBS, \"setting\") = False Then";
Debug.ShouldStop(1024);
if (anywheresoftware.b4a.keywords.Common.File.Exists(_dirdbs,"setting")==anywheresoftware.b4a.keywords.Common.False) { 
 BA.debugLineNum = 172;BA.debugLine="If SetFileConfig = False Then ExitApplication";
Debug.ShouldStop(2048);
if (_setfileconfig(_ba)==anywheresoftware.b4a.keywords.Common.False) { 
anywheresoftware.b4a.keywords.Common.ExitApplication();};
 };
 BA.debugLineNum = 175;BA.debugLine="Try";
Debug.ShouldStop(16384);
try { BA.debugLineNum = 176;BA.debugLine="raf.Initialize(DirDBS, \"setting\", False)";
Debug.ShouldStop(32768);
_raf.Initialize(_dirdbs,"setting",anywheresoftware.b4a.keywords.Common.False);
 BA.debugLineNum = 177;BA.debugLine="mpTemp = raf.ReadEncryptedObject(szAndroidID & szRefSerial & szIMEI, raf.CurrentPosition)";
Debug.ShouldStop(65536);
_mptemp.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_raf.ReadEncryptedObject(_szandroidid+_szrefserial+_szimei,_raf.CurrentPosition)));
 BA.debugLineNum = 178;BA.debugLine="raf.Flush";
Debug.ShouldStop(131072);
_raf.Flush();
 BA.debugLineNum = 179;BA.debugLine="raf.Close";
Debug.ShouldStop(262144);
_raf.Close();
 } 
       catch (Exception e135) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e135); BA.debugLineNum = 181;BA.debugLine="Msgbox2(\"Invalid Application !\", \"ezSchool\", \"OK\", \"\", \"\", LoadBitmap(File.DirAssets, \"Warning.png\"))";
Debug.ShouldStop(1048576);
anywheresoftware.b4a.keywords.Common.Msgbox2("Invalid Application !","ezSchool","OK","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Warning.png").getObject()),_ba);
 BA.debugLineNum = 182;BA.debugLine="If File.Exists(DirDBS, \"setting\") Then File.Delete(DirDBS, \"setting\")";
Debug.ShouldStop(2097152);
if (anywheresoftware.b4a.keywords.Common.File.Exists(_dirdbs,"setting")) { 
anywheresoftware.b4a.keywords.Common.File.Delete(_dirdbs,"setting");};
 BA.debugLineNum = 183;BA.debugLine="Return False";
Debug.ShouldStop(4194304);
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 BA.debugLineNum = 186;BA.debugLine="DataConfig = mpTemp.Get(\"DataConfig\")";
Debug.ShouldStop(33554432);
_dataconfig = (metube.mncplaymedia.com.fungsi._formatconfig)(_mptemp.Get((Object)("DataConfig")));
 BA.debugLineNum = 187;BA.debugLine="Return True";
Debug.ShouldStop(67108864);
if (true) return anywheresoftware.b4a.keywords.Common.True;
 BA.debugLineNum = 188;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return false;
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static boolean  _cacahjson(anywheresoftware.b4a.BA _ba,String _datajson,String _status) throws Exception{
try {
		Debug.PushSubsStack("CacahJSON (fungsi) ","fungsi",4,_ba,mostCurrent,430);
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _root = null;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
String _ipaddr0 = "";
String _ipaddr1 = "";
String _ipaddr2 = "";
String _ipaddr3 = "";
String _ipaddr4 = "";
String _port0 = "";
String _port1 = "";
anywheresoftware.b4a.objects.collections.List _authentication = null;
anywheresoftware.b4a.objects.collections.Map _colauthentication = null;
anywheresoftware.b4a.objects.collections.List _menulist = null;
anywheresoftware.b4a.objects.collections.Map _colmenu = null;
anywheresoftware.b4a.objects.collections.List _movielist = null;
anywheresoftware.b4a.objects.collections.Map _colmovies = null;
anywheresoftware.b4a.objects.collections.List _trailerlist = null;
anywheresoftware.b4a.objects.collections.Map _coltrailer = null;
anywheresoftware.b4a.objects.collections.List _channellist = null;
anywheresoftware.b4a.objects.collections.Map _colchannel = null;
anywheresoftware.b4a.objects.collections.List _serieslist = null;
anywheresoftware.b4a.objects.collections.Map _colseries = null;
anywheresoftware.b4a.objects.collections.List _registerlist = null;
anywheresoftware.b4a.objects.collections.Map _colregister = null;
anywheresoftware.b4a.objects.collections.List _loginlist = null;
anywheresoftware.b4a.objects.collections.Map _collogin = null;
anywheresoftware.b4a.objects.collections.List _facebooklist = null;
anywheresoftware.b4a.objects.collections.Map _colfacebook = null;
anywheresoftware.b4a.objects.collections.List _categorylist = null;
anywheresoftware.b4a.objects.collections.Map _colcategory = null;
anywheresoftware.b4a.objects.collections.List _pilihcatelist = null;
anywheresoftware.b4a.objects.collections.Map _colpilihcate = null;
anywheresoftware.b4a.objects.collections.List _movieslist = null;
anywheresoftware.b4a.objects.collections.Map _colcatemovies = null;
anywheresoftware.b4a.objects.collections.List _slidecatelist = null;
anywheresoftware.b4a.objects.collections.Map _colslidecate = null;
anywheresoftware.b4a.objects.collections.List _sluglist = null;
anywheresoftware.b4a.objects.collections.Map _colslugpage = null;
;
Debug.locals.put("DataJSON", _datajson);
Debug.locals.put("Status", _status);
 BA.debugLineNum = 430;BA.debugLine="Sub CacahJSON(DataJSON As String, Status As String) As Boolean";
Debug.ShouldStop(8192);
 BA.debugLineNum = 431;BA.debugLine="Dim parser 	As JSONParser";
Debug.ShouldStop(16384);
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();Debug.locals.put("parser", _parser);
 BA.debugLineNum = 433;BA.debugLine="CateMap.Initialize";
Debug.ShouldStop(65536);
_catemap.Initialize();
 BA.debugLineNum = 434;BA.debugLine="CateMap.Clear";
Debug.ShouldStop(131072);
_catemap.Clear();
 BA.debugLineNum = 435;BA.debugLine="MoviesMap.Initialize";
Debug.ShouldStop(262144);
_moviesmap.Initialize();
 BA.debugLineNum = 436;BA.debugLine="MoviesMap.Clear";
Debug.ShouldStop(524288);
_moviesmap.Clear();
 BA.debugLineNum = 437;BA.debugLine="ChannelMap.Initialize";
Debug.ShouldStop(1048576);
_channelmap.Initialize();
 BA.debugLineNum = 438;BA.debugLine="ChannelMap.Clear";
Debug.ShouldStop(2097152);
_channelmap.Clear();
 BA.debugLineNum = 439;BA.debugLine="SeriesMap.Initialize";
Debug.ShouldStop(4194304);
_seriesmap.Initialize();
 BA.debugLineNum = 440;BA.debugLine="SeriesMap.Clear";
Debug.ShouldStop(8388608);
_seriesmap.Clear();
 BA.debugLineNum = 441;BA.debugLine="TrailerMap.Initialize";
Debug.ShouldStop(16777216);
_trailermap.Initialize();
 BA.debugLineNum = 442;BA.debugLine="TrailerMap.Clear";
Debug.ShouldStop(33554432);
_trailermap.Clear();
 BA.debugLineNum = 445;BA.debugLine="Try";
Debug.ShouldStop(268435456);
try { BA.debugLineNum = 446;BA.debugLine="parser.Initialize(DataJSON)";
Debug.ShouldStop(536870912);
_parser.Initialize(_datajson);
 } 
       catch (Exception e357) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e357); BA.debugLineNum = 448;BA.debugLine="Msgbox2(\"Process Failure !\", \"IKR Playbox\", \"OK\", \"\", \"\", LoadBitmap(File.DirAssets, \"warning.png\"))";
Debug.ShouldStop(-2147483648);
anywheresoftware.b4a.keywords.Common.Msgbox2("Process Failure !","IKR Playbox","OK","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"warning.png").getObject()),_ba);
 BA.debugLineNum = 449;BA.debugLine="Return False";
Debug.ShouldStop(1);
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 BA.debugLineNum = 452;BA.debugLine="Select Status";
Debug.ShouldStop(8);
switch (BA.switchObjectToInt(_status,"NextArray")) {
case 0:
 BA.debugLineNum = 454;BA.debugLine="Try";
Debug.ShouldStop(32);
try { BA.debugLineNum = 455;BA.debugLine="Dim root As List = parser.NextArray";
Debug.ShouldStop(64);
_root = new anywheresoftware.b4a.objects.collections.List();
_root = _parser.NextArray();Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 } 
       catch (Exception e365) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e365); BA.debugLineNum = 457;BA.debugLine="Return False";
Debug.ShouldStop(256);
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 BA.debugLineNum = 461;BA.debugLine="For Each colroot As Map In root";
Debug.ShouldStop(4096);
_colroot = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group367 = _root;
final int groupLen367 = group367.getSize();
for (int index367 = 0;index367 < groupLen367 ;index367++){
_colroot.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group367.Get(index367)));
Debug.locals.put("colroot", _colroot);
 BA.debugLineNum = 462;BA.debugLine="Dim IPAddr0 As String = colroot.Get(\"IPAddr0\")";
Debug.ShouldStop(8192);
_ipaddr0 = BA.ObjectToString(_colroot.Get((Object)("IPAddr0")));Debug.locals.put("IPAddr0", _ipaddr0);Debug.locals.put("IPAddr0", _ipaddr0);
 BA.debugLineNum = 463;BA.debugLine="Dim IPAddr1 As String = colroot.Get(\"IPAddr1\")";
Debug.ShouldStop(16384);
_ipaddr1 = BA.ObjectToString(_colroot.Get((Object)("IPAddr1")));Debug.locals.put("IPAddr1", _ipaddr1);Debug.locals.put("IPAddr1", _ipaddr1);
 BA.debugLineNum = 464;BA.debugLine="Dim IPAddr2 As String = colroot.Get(\"IPAddr2\")";
Debug.ShouldStop(32768);
_ipaddr2 = BA.ObjectToString(_colroot.Get((Object)("IPAddr2")));Debug.locals.put("IPAddr2", _ipaddr2);Debug.locals.put("IPAddr2", _ipaddr2);
 BA.debugLineNum = 465;BA.debugLine="Dim IPAddr3 As String = colroot.Get(\"IPAddr3\")";
Debug.ShouldStop(65536);
_ipaddr3 = BA.ObjectToString(_colroot.Get((Object)("IPAddr3")));Debug.locals.put("IPAddr3", _ipaddr3);Debug.locals.put("IPAddr3", _ipaddr3);
 BA.debugLineNum = 466;BA.debugLine="Dim IPAddr4 As String = colroot.Get(\"IPAddr4\")";
Debug.ShouldStop(131072);
_ipaddr4 = BA.ObjectToString(_colroot.Get((Object)("IPAddr4")));Debug.locals.put("IPAddr4", _ipaddr4);Debug.locals.put("IPAddr4", _ipaddr4);
 BA.debugLineNum = 467;BA.debugLine="Dim Port0	As String = colroot.Get(\"Port0\")";
Debug.ShouldStop(262144);
_port0 = BA.ObjectToString(_colroot.Get((Object)("Port0")));Debug.locals.put("Port0", _port0);Debug.locals.put("Port0", _port0);
 BA.debugLineNum = 468;BA.debugLine="Dim Port1	As String = colroot.Get(\"Port1\")";
Debug.ShouldStop(524288);
_port1 = BA.ObjectToString(_colroot.Get((Object)("Port1")));Debug.locals.put("Port1", _port1);Debug.locals.put("Port1", _port1);
 BA.debugLineNum = 470;BA.debugLine="Dim Authentication As List = colroot.Get(\"Authentication\")";
Debug.ShouldStop(2097152);
_authentication = new anywheresoftware.b4a.objects.collections.List();
_authentication.setObject((java.util.List)(_colroot.Get((Object)("Authentication"))));Debug.locals.put("Authentication", _authentication);
 BA.debugLineNum = 471;BA.debugLine="For Each colAuthentication As Map In Authentication";
Debug.ShouldStop(4194304);
_colauthentication = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group376 = _authentication;
final int groupLen376 = group376.getSize();
for (int index376 = 0;index376 < groupLen376 ;index376++){
_colauthentication.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group376.Get(index376)));
Debug.locals.put("colauthentication", _colauthentication);
 BA.debugLineNum = 472;BA.debugLine="mpList.Put(\"ugc_username\", colAuthentication.Get(\"ugc_username\"))";
Debug.ShouldStop(8388608);
_mplist.Put((Object)("ugc_username"),_colauthentication.Get((Object)("ugc_username")));
 BA.debugLineNum = 473;BA.debugLine="mpList.Put(\"ugc_password\", colAuthentication.Get(\"ugc_password\"))";
Debug.ShouldStop(16777216);
_mplist.Put((Object)("ugc_password"),_colauthentication.Get((Object)("ugc_password")));
 BA.debugLineNum = 474;BA.debugLine="mpList.Put(\"Username\", colAuthentication.Get(\"Username\"))";
Debug.ShouldStop(33554432);
_mplist.Put((Object)("Username"),_colauthentication.Get((Object)("Username")));
 BA.debugLineNum = 475;BA.debugLine="mpList.Put(\"Password\", colAuthentication.Get(\"Password\"))";
Debug.ShouldStop(67108864);
_mplist.Put((Object)("Password"),_colauthentication.Get((Object)("Password")));
 }
Debug.locals.put("colauthentication", _colauthentication);
;
 BA.debugLineNum = 478;BA.debugLine="Dim MenuList As List = colroot.Get(\"MenuCategory\")";
Debug.ShouldStop(536870912);
_menulist = new anywheresoftware.b4a.objects.collections.List();
_menulist.setObject((java.util.List)(_colroot.Get((Object)("MenuCategory"))));Debug.locals.put("MenuList", _menulist);
 BA.debugLineNum = 479;BA.debugLine="For Each colMenu As Map In MenuList";
Debug.ShouldStop(1073741824);
_colmenu = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group383 = _menulist;
final int groupLen383 = group383.getSize();
for (int index383 = 0;index383 < groupLen383 ;index383++){
_colmenu.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group383.Get(index383)));
Debug.locals.put("colmenu", _colmenu);
 BA.debugLineNum = 480;BA.debugLine="CateMap.Put(\"Cate0\", colMenu.Get(\"Cate0\"))";
Debug.ShouldStop(-2147483648);
_catemap.Put((Object)("Cate0"),_colmenu.Get((Object)("Cate0")));
 BA.debugLineNum = 481;BA.debugLine="CateMap.Put(\"Cate1\", colMenu.Get(\"Cate1\"))";
Debug.ShouldStop(1);
_catemap.Put((Object)("Cate1"),_colmenu.Get((Object)("Cate1")));
 BA.debugLineNum = 482;BA.debugLine="CateMap.Put(\"Cate2\", colMenu.Get(\"Cate2\"))";
Debug.ShouldStop(2);
_catemap.Put((Object)("Cate2"),_colmenu.Get((Object)("Cate2")));
 }
Debug.locals.put("colmenu", _colmenu);
;
 BA.debugLineNum = 485;BA.debugLine="Dim MovieList As List = colroot.Get(\"MenuMovies\")";
Debug.ShouldStop(16);
_movielist = new anywheresoftware.b4a.objects.collections.List();
_movielist.setObject((java.util.List)(_colroot.Get((Object)("MenuMovies"))));Debug.locals.put("MovieList", _movielist);
 BA.debugLineNum = 486;BA.debugLine="For Each colMovies As Map In MovieList";
Debug.ShouldStop(32);
_colmovies = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group389 = _movielist;
final int groupLen389 = group389.getSize();
for (int index389 = 0;index389 < groupLen389 ;index389++){
_colmovies.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group389.Get(index389)));
Debug.locals.put("colmovies", _colmovies);
 BA.debugLineNum = 487;BA.debugLine="MoviesMap.Put(\"Movies0\", colMovies.Get(\"Movies0\"))";
Debug.ShouldStop(64);
_moviesmap.Put((Object)("Movies0"),_colmovies.Get((Object)("Movies0")));
 BA.debugLineNum = 488;BA.debugLine="MoviesMap.Put(\"Movies1\", colMovies.Get(\"Movies1\"))";
Debug.ShouldStop(128);
_moviesmap.Put((Object)("Movies1"),_colmovies.Get((Object)("Movies1")));
 BA.debugLineNum = 489;BA.debugLine="MoviesMap.Put(\"Movies2\", colMovies.Get(\"Movies2\"))";
Debug.ShouldStop(256);
_moviesmap.Put((Object)("Movies2"),_colmovies.Get((Object)("Movies2")));
 BA.debugLineNum = 490;BA.debugLine="MoviesMap.Put(\"Movies3\", colMovies.Get(\"Movies3\"))";
Debug.ShouldStop(512);
_moviesmap.Put((Object)("Movies3"),_colmovies.Get((Object)("Movies3")));
 }
Debug.locals.put("colmovies", _colmovies);
;
 BA.debugLineNum = 493;BA.debugLine="Dim TrailerList As List = colroot.Get(\"MenuTrailer\")";
Debug.ShouldStop(4096);
_trailerlist = new anywheresoftware.b4a.objects.collections.List();
_trailerlist.setObject((java.util.List)(_colroot.Get((Object)("MenuTrailer"))));Debug.locals.put("TrailerList", _trailerlist);
 BA.debugLineNum = 494;BA.debugLine="For Each colTrailer As Map In TrailerList";
Debug.ShouldStop(8192);
_coltrailer = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group396 = _trailerlist;
final int groupLen396 = group396.getSize();
for (int index396 = 0;index396 < groupLen396 ;index396++){
_coltrailer.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group396.Get(index396)));
Debug.locals.put("coltrailer", _coltrailer);
 BA.debugLineNum = 495;BA.debugLine="TrailerMap.Put(\"Trailer0\", colTrailer.Get(\"Trailer0\"))";
Debug.ShouldStop(16384);
_trailermap.Put((Object)("Trailer0"),_coltrailer.Get((Object)("Trailer0")));
 }
Debug.locals.put("coltrailer", _coltrailer);
;
 BA.debugLineNum = 498;BA.debugLine="Dim ChannelList As List = colroot.Get(\"MenuChannel\")";
Debug.ShouldStop(131072);
_channellist = new anywheresoftware.b4a.objects.collections.List();
_channellist.setObject((java.util.List)(_colroot.Get((Object)("MenuChannel"))));Debug.locals.put("ChannelList", _channellist);
 BA.debugLineNum = 499;BA.debugLine="For Each colChannel As Map In ChannelList";
Debug.ShouldStop(262144);
_colchannel = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group400 = _channellist;
final int groupLen400 = group400.getSize();
for (int index400 = 0;index400 < groupLen400 ;index400++){
_colchannel.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group400.Get(index400)));
Debug.locals.put("colchannel", _colchannel);
 BA.debugLineNum = 500;BA.debugLine="ChannelMap.Put(\"Channel0\", colChannel.Get(\"Channel0\"))";
Debug.ShouldStop(524288);
_channelmap.Put((Object)("Channel0"),_colchannel.Get((Object)("Channel0")));
 }
Debug.locals.put("colchannel", _colchannel);
;
 BA.debugLineNum = 503;BA.debugLine="Dim SeriesList As List = colroot.Get(\"MenuSeries\")";
Debug.ShouldStop(4194304);
_serieslist = new anywheresoftware.b4a.objects.collections.List();
_serieslist.setObject((java.util.List)(_colroot.Get((Object)("MenuSeries"))));Debug.locals.put("SeriesList", _serieslist);
 BA.debugLineNum = 504;BA.debugLine="For Each colSeries As Map In SeriesList";
Debug.ShouldStop(8388608);
_colseries = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group404 = _serieslist;
final int groupLen404 = group404.getSize();
for (int index404 = 0;index404 < groupLen404 ;index404++){
_colseries.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group404.Get(index404)));
Debug.locals.put("colseries", _colseries);
 BA.debugLineNum = 505;BA.debugLine="SeriesMap.Put(\"Series0\", colSeries.Get(\"Series0\"))";
Debug.ShouldStop(16777216);
_seriesmap.Put((Object)("Series0"),_colseries.Get((Object)("Series0")));
 }
Debug.locals.put("colseries", _colseries);
;
 BA.debugLineNum = 508;BA.debugLine="Dim RegisterList As List = colroot.Get(\"Register\")";
Debug.ShouldStop(134217728);
_registerlist = new anywheresoftware.b4a.objects.collections.List();
_registerlist.setObject((java.util.List)(_colroot.Get((Object)("Register"))));Debug.locals.put("RegisterList", _registerlist);
 BA.debugLineNum = 509;BA.debugLine="For Each colRegister As Map In RegisterList";
Debug.ShouldStop(268435456);
_colregister = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group408 = _registerlist;
final int groupLen408 = group408.getSize();
for (int index408 = 0;index408 < groupLen408 ;index408++){
_colregister.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group408.Get(index408)));
Debug.locals.put("colregister", _colregister);
 BA.debugLineNum = 510;BA.debugLine="mpList.Put(\"RegisterURL\", colRegister.Get(\"RegisterURL\"))";
Debug.ShouldStop(536870912);
_mplist.Put((Object)("RegisterURL"),_colregister.Get((Object)("RegisterURL")));
 BA.debugLineNum = 511;BA.debugLine="mpList.Put(\"firstname\", colRegister.Get(\"firstname\"))";
Debug.ShouldStop(1073741824);
_mplist.Put((Object)("firstname"),_colregister.Get((Object)("firstname")));
 BA.debugLineNum = 512;BA.debugLine="mpList.Put(\"lastname\", colRegister.Get(\"lastname\"))";
Debug.ShouldStop(-2147483648);
_mplist.Put((Object)("lastname"),_colregister.Get((Object)("lastname")));
 BA.debugLineNum = 513;BA.debugLine="mpList.Put(\"regemail\", colRegister.Get(\"regemail\"))";
Debug.ShouldStop(1);
_mplist.Put((Object)("regemail"),_colregister.Get((Object)("regemail")));
 BA.debugLineNum = 514;BA.debugLine="mpList.Put(\"regpass\", colRegister.Get(\"regpass\"))";
Debug.ShouldStop(2);
_mplist.Put((Object)("regpass"),_colregister.Get((Object)("regpass")));
 }
Debug.locals.put("colregister", _colregister);
;
 BA.debugLineNum = 517;BA.debugLine="Dim LoginList As List = colroot.Get(\"Login\")";
Debug.ShouldStop(16);
_loginlist = new anywheresoftware.b4a.objects.collections.List();
_loginlist.setObject((java.util.List)(_colroot.Get((Object)("Login"))));Debug.locals.put("LoginList", _loginlist);
 BA.debugLineNum = 518;BA.debugLine="For Each colLogin As Map In LoginList";
Debug.ShouldStop(32);
_collogin = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group416 = _loginlist;
final int groupLen416 = group416.getSize();
for (int index416 = 0;index416 < groupLen416 ;index416++){
_collogin.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group416.Get(index416)));
Debug.locals.put("collogin", _collogin);
 BA.debugLineNum = 519;BA.debugLine="mpList.Put(\"LoginURL\", colLogin.Get(\"LoginURL\"))";
Debug.ShouldStop(64);
_mplist.Put((Object)("LoginURL"),_collogin.Get((Object)("LoginURL")));
 BA.debugLineNum = 520;BA.debugLine="mpList.Put(\"key1\", colLogin.Get(\"key1\"))";
Debug.ShouldStop(128);
_mplist.Put((Object)("key1"),_collogin.Get((Object)("key1")));
 BA.debugLineNum = 521;BA.debugLine="mpList.Put(\"key1a\", colLogin.Get(\"key1a\"))";
Debug.ShouldStop(256);
_mplist.Put((Object)("key1a"),_collogin.Get((Object)("key1a")));
 BA.debugLineNum = 522;BA.debugLine="mpList.Put(\"key2a\", colLogin.Get(\"key2a\"))";
Debug.ShouldStop(512);
_mplist.Put((Object)("key2a"),_collogin.Get((Object)("key2a")));
 BA.debugLineNum = 523;BA.debugLine="mpList.Put(\"value\", colLogin.Get(\"value\"))";
Debug.ShouldStop(1024);
_mplist.Put((Object)("value"),_collogin.Get((Object)("value")));
 }
Debug.locals.put("collogin", _collogin);
;
 BA.debugLineNum = 526;BA.debugLine="Dim FacebookList As List = colroot.Get(\"LoginFB\")";
Debug.ShouldStop(8192);
_facebooklist = new anywheresoftware.b4a.objects.collections.List();
_facebooklist.setObject((java.util.List)(_colroot.Get((Object)("LoginFB"))));Debug.locals.put("FacebookList", _facebooklist);
 BA.debugLineNum = 527;BA.debugLine="For Each colFacebook As Map In FacebookList";
Debug.ShouldStop(16384);
_colfacebook = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group424 = _facebooklist;
final int groupLen424 = group424.getSize();
for (int index424 = 0;index424 < groupLen424 ;index424++){
_colfacebook.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group424.Get(index424)));
Debug.locals.put("colfacebook", _colfacebook);
 BA.debugLineNum = 528;BA.debugLine="mpList.Put(\"FacebookURL\", colFacebook.Get(\"FacebookURL\"))";
Debug.ShouldStop(32768);
_mplist.Put((Object)("FacebookURL"),_colfacebook.Get((Object)("FacebookURL")));
 BA.debugLineNum = 529;BA.debugLine="mpList.Put(\"FB_id\", colFacebook.Get(\"FB_id\"))";
Debug.ShouldStop(65536);
_mplist.Put((Object)("FB_id"),_colfacebook.Get((Object)("FB_id")));
 BA.debugLineNum = 530;BA.debugLine="mpList.Put(\"FB_photo\", colFacebook.Get(\"FB_photo\"))";
Debug.ShouldStop(131072);
_mplist.Put((Object)("FB_photo"),_colfacebook.Get((Object)("FB_photo")));
 BA.debugLineNum = 531;BA.debugLine="mpList.Put(\"FB_display\", colFacebook.Get(\"FB_display\"))";
Debug.ShouldStop(262144);
_mplist.Put((Object)("FB_display"),_colfacebook.Get((Object)("FB_display")));
 BA.debugLineNum = 532;BA.debugLine="mpList.Put(\"FB_mail\", colFacebook.Get(\"FB_mail\"))";
Debug.ShouldStop(524288);
_mplist.Put((Object)("FB_mail"),_colfacebook.Get((Object)("FB_mail")));
 BA.debugLineNum = 533;BA.debugLine="mpList.Put(\"FB_mail\", colFacebook.Get(\"FB_mail\"))";
Debug.ShouldStop(1048576);
_mplist.Put((Object)("FB_mail"),_colfacebook.Get((Object)("FB_mail")));
 }
Debug.locals.put("colfacebook", _colfacebook);
;
 BA.debugLineNum = 536;BA.debugLine="Dim CategoryList As List = colroot.Get(\"GetListVideo\")";
Debug.ShouldStop(8388608);
_categorylist = new anywheresoftware.b4a.objects.collections.List();
_categorylist.setObject((java.util.List)(_colroot.Get((Object)("GetListVideo"))));Debug.locals.put("CategoryList", _categorylist);
 BA.debugLineNum = 537;BA.debugLine="For Each colCategory As Map In CategoryList";
Debug.ShouldStop(16777216);
_colcategory = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group433 = _categorylist;
final int groupLen433 = group433.getSize();
for (int index433 = 0;index433 < groupLen433 ;index433++){
_colcategory.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group433.Get(index433)));
Debug.locals.put("colcategory", _colcategory);
 BA.debugLineNum = 538;BA.debugLine="mpList.Put(\"ListURL\", colCategory.Get(\"ListURL\"))";
Debug.ShouldStop(33554432);
_mplist.Put((Object)("ListURL"),_colcategory.Get((Object)("ListURL")));
 BA.debugLineNum = 539;BA.debugLine="mpList.Put(\"List\", colCategory.Get(\"List\"))";
Debug.ShouldStop(67108864);
_mplist.Put((Object)("List"),_colcategory.Get((Object)("List")));
 BA.debugLineNum = 540;BA.debugLine="mpList.Put(\"Jumlah\", colCategory.Get(\"Jumlah\"))";
Debug.ShouldStop(134217728);
_mplist.Put((Object)("Jumlah"),_colcategory.Get((Object)("Jumlah")));
 BA.debugLineNum = 541;BA.debugLine="mpList.Put(\"Halaman\", colCategory.Get(\"Halaman\"))";
Debug.ShouldStop(268435456);
_mplist.Put((Object)("Halaman"),_colcategory.Get((Object)("Halaman")));
 }
Debug.locals.put("colcategory", _colcategory);
;
 BA.debugLineNum = 544;BA.debugLine="Dim PilihCateList As List = colroot.Get(\"PilihCategory\")";
Debug.ShouldStop(-2147483648);
_pilihcatelist = new anywheresoftware.b4a.objects.collections.List();
_pilihcatelist.setObject((java.util.List)(_colroot.Get((Object)("PilihCategory"))));Debug.locals.put("PilihCateList", _pilihcatelist);
 BA.debugLineNum = 545;BA.debugLine="For Each colPilihCate As Map In PilihCateList";
Debug.ShouldStop(1);
_colpilihcate = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group440 = _pilihcatelist;
final int groupLen440 = group440.getSize();
for (int index440 = 0;index440 < groupLen440 ;index440++){
_colpilihcate.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group440.Get(index440)));
Debug.locals.put("colpilihcate", _colpilihcate);
 BA.debugLineNum = 546;BA.debugLine="mpList.Put(\"ListCateURL\", colPilihCate.Get(\"ListCateURL\"))";
Debug.ShouldStop(2);
_mplist.Put((Object)("ListCateURL"),_colpilihcate.Get((Object)("ListCateURL")));
 BA.debugLineNum = 547;BA.debugLine="mpList.Put(\"slidng1\", colPilihCate.Get(\"sliding1\"))";
Debug.ShouldStop(4);
_mplist.Put((Object)("slidng1"),_colpilihcate.Get((Object)("sliding1")));
 }
Debug.locals.put("colpilihcate", _colpilihcate);
;
 BA.debugLineNum = 550;BA.debugLine="Dim MoviesList As List = colroot.Get(\"CateMovies\")";
Debug.ShouldStop(32);
_movieslist = new anywheresoftware.b4a.objects.collections.List();
_movieslist.setObject((java.util.List)(_colroot.Get((Object)("CateMovies"))));Debug.locals.put("MoviesList", _movieslist);
 BA.debugLineNum = 551;BA.debugLine="For Each colCateMovies As Map In MoviesList";
Debug.ShouldStop(64);
_colcatemovies = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group445 = _movieslist;
final int groupLen445 = group445.getSize();
for (int index445 = 0;index445 < groupLen445 ;index445++){
_colcatemovies.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group445.Get(index445)));
Debug.locals.put("colcatemovies", _colcatemovies);
 BA.debugLineNum = 552;BA.debugLine="mpList.Put(\"MoviesURL\", colCateMovies.Get(\"MoviesURL\"))";
Debug.ShouldStop(128);
_mplist.Put((Object)("MoviesURL"),_colcatemovies.Get((Object)("MoviesURL")));
 BA.debugLineNum = 553;BA.debugLine="mpList.Put(\"slug\", colCateMovies.Get(\"slug\"))";
Debug.ShouldStop(256);
_mplist.Put((Object)("slug"),_colcatemovies.Get((Object)("slug")));
 }
Debug.locals.put("colcatemovies", _colcatemovies);
;
 BA.debugLineNum = 556;BA.debugLine="Dim SlideCateList As List = colroot.Get(\"SlideCate\")";
Debug.ShouldStop(2048);
_slidecatelist = new anywheresoftware.b4a.objects.collections.List();
_slidecatelist.setObject((java.util.List)(_colroot.Get((Object)("SlideCate"))));Debug.locals.put("SlideCateList", _slidecatelist);
 BA.debugLineNum = 557;BA.debugLine="For Each colSlideCate As Map In SlideCateList";
Debug.ShouldStop(4096);
_colslidecate = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group450 = _slidecatelist;
final int groupLen450 = group450.getSize();
for (int index450 = 0;index450 < groupLen450 ;index450++){
_colslidecate.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group450.Get(index450)));
Debug.locals.put("colslidecate", _colslidecate);
 BA.debugLineNum = 558;BA.debugLine="mpList.Put(\"SlideURL\", colSlideCate.Get(\"SlideURL\"))";
Debug.ShouldStop(8192);
_mplist.Put((Object)("SlideURL"),_colslidecate.Get((Object)("SlideURL")));
 BA.debugLineNum = 559;BA.debugLine="mpList.Put(\"Variabel\", colSlideCate.Get(\"Variabel\"))";
Debug.ShouldStop(16384);
_mplist.Put((Object)("Variabel"),_colslidecate.Get((Object)("Variabel")));
 }
Debug.locals.put("colslidecate", _colslidecate);
;
 BA.debugLineNum = 562;BA.debugLine="Dim slugList As List = colroot.Get(\"SlugPager\")";
Debug.ShouldStop(131072);
_sluglist = new anywheresoftware.b4a.objects.collections.List();
_sluglist.setObject((java.util.List)(_colroot.Get((Object)("SlugPager"))));Debug.locals.put("slugList", _sluglist);
 BA.debugLineNum = 563;BA.debugLine="For Each colSlugPage As Map In slugList";
Debug.ShouldStop(262144);
_colslugpage = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group455 = _sluglist;
final int groupLen455 = group455.getSize();
for (int index455 = 0;index455 < groupLen455 ;index455++){
_colslugpage.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group455.Get(index455)));
Debug.locals.put("colslugpage", _colslugpage);
 BA.debugLineNum = 564;BA.debugLine="mpList.Put(\"SlugURL\", colSlugPage.Get(\"SlugURL\"))";
Debug.ShouldStop(524288);
_mplist.Put((Object)("SlugURL"),_colslugpage.Get((Object)("SlugURL")));
 BA.debugLineNum = 565;BA.debugLine="mpList.Put(\"Variabel\", colSlugPage.Get(\"Variabel\"))";
Debug.ShouldStop(1048576);
_mplist.Put((Object)("Variabel"),_colslugpage.Get((Object)("Variabel")));
 BA.debugLineNum = 566;BA.debugLine="mpList.Put(\"Slug\", colSlugPage.Get(\"Slug\"))";
Debug.ShouldStop(2097152);
_mplist.Put((Object)("Slug"),_colslugpage.Get((Object)("Slug")));
 }
Debug.locals.put("colslugpage", _colslugpage);
;
 }
Debug.locals.put("colroot", _colroot);
;
 BA.debugLineNum = 570;BA.debugLine="mKoneksi = colroot";
Debug.ShouldStop(33554432);
_mkoneksi = _colroot;
 break;
}
;
 BA.debugLineNum = 573;BA.debugLine="Return True";
Debug.ShouldStop(268435456);
if (true) return anywheresoftware.b4a.keywords.Common.True;
 BA.debugLineNum = 574;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return false;
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper  _createpostrequest(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.Map _namevalues,anywheresoftware.b4a.objects.collections.List _files) throws Exception{
try {
		Debug.PushSubsStack("CreatePostRequest (fungsi) ","fungsi",4,_ba,mostCurrent,587);
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _stream = null;
String _eol = "";
byte[] _b = null;
String _key = "";
String _value = "";
int _i = 0;
metube.mncplaymedia.com.fungsi._filedata _fd = null;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
;
Debug.locals.put("NameValues", _namevalues);
Debug.locals.put("Files", _files);
 BA.debugLineNum = 587;BA.debugLine="Sub CreatePostRequest(NameValues As Map, Files As List) As OutputStream";
Debug.ShouldStop(1024);
 BA.debugLineNum = 588;BA.debugLine="boundary = \"---------------------------1461124740692\"";
Debug.ShouldStop(2048);
_boundary = "---------------------------1461124740692";
 BA.debugLineNum = 589;BA.debugLine="Dim stream As OutputStream";
Debug.ShouldStop(4096);
_stream = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();Debug.locals.put("stream", _stream);
 BA.debugLineNum = 590;BA.debugLine="stream.InitializeToBytesArray(20)";
Debug.ShouldStop(8192);
_stream.InitializeToBytesArray((int) (20));
 BA.debugLineNum = 591;BA.debugLine="Dim EOL As String";
Debug.ShouldStop(16384);
_eol = "";Debug.locals.put("EOL", _eol);
 BA.debugLineNum = 592;BA.debugLine="EOL = Chr(13) & Chr(10) 'CRLF constant matches Android end of line character which is chr(10).";
Debug.ShouldStop(32768);
_eol = BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (13)))+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (10)));Debug.locals.put("EOL", _eol);
 BA.debugLineNum = 593;BA.debugLine="Dim b() As Byte";
Debug.ShouldStop(65536);
_b = new byte[(int) (0)];
;Debug.locals.put("b", _b);
 BA.debugLineNum = 594;BA.debugLine="If NameValues <> Null AND NameValues.IsInitialized Then";
Debug.ShouldStop(131072);
if (_namevalues!= null && _namevalues.IsInitialized()) { 
 BA.debugLineNum = 596;BA.debugLine="Dim key, value As String";
Debug.ShouldStop(524288);
_key = "";Debug.locals.put("key", _key);
_value = "";Debug.locals.put("value", _value);
 BA.debugLineNum = 597;BA.debugLine="For i = 0 To NameValues.Size - 1";
Debug.ShouldStop(1048576);
{
final int step482 = 1;
final int limit482 = (int) (_namevalues.getSize()-1);
for (_i = (int) (0); (step482 > 0 && _i <= limit482) || (step482 < 0 && _i >= limit482); _i = ((int)(0 + _i + step482))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 598;BA.debugLine="key = NameValues.GetKeyAt(i)";
Debug.ShouldStop(2097152);
_key = BA.ObjectToString(_namevalues.GetKeyAt(_i));Debug.locals.put("key", _key);
 BA.debugLineNum = 599;BA.debugLine="value = NameValues.GetValueAt(i)";
Debug.ShouldStop(4194304);
_value = BA.ObjectToString(_namevalues.GetValueAt(_i));Debug.locals.put("value", _value);
 BA.debugLineNum = 600;BA.debugLine="b = (\"--\" & boundary & EOL & \"Content-Disposition: form-data; name=\" _  				& QUOTE & key & QUOTE & EOL & EOL & value & EOL).GetBytes(\"UTF8\")";
Debug.ShouldStop(8388608);
_b = ("--"+_boundary+_eol+"Content-Disposition: form-data; name="+anywheresoftware.b4a.keywords.Common.QUOTE+_key+anywheresoftware.b4a.keywords.Common.QUOTE+_eol+_eol+_value+_eol).getBytes("UTF8");Debug.locals.put("b", _b);
 BA.debugLineNum = 602;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
Debug.ShouldStop(33554432);
_stream.WriteBytes(_b,(int) (0),_b.length);
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 605;BA.debugLine="If Files <> Null AND Files.IsInitialized Then";
Debug.ShouldStop(268435456);
if (_files!= null && _files.IsInitialized()) { 
 BA.debugLineNum = 607;BA.debugLine="Dim FD As FileData";
Debug.ShouldStop(1073741824);
_fd = new metube.mncplaymedia.com.fungsi._filedata();Debug.locals.put("FD", _fd);
 BA.debugLineNum = 608;BA.debugLine="For i = 0 To Files.Size - 1";
Debug.ShouldStop(-2147483648);
{
final int step491 = 1;
final int limit491 = (int) (_files.getSize()-1);
for (_i = (int) (0); (step491 > 0 && _i <= limit491) || (step491 < 0 && _i >= limit491); _i = ((int)(0 + _i + step491))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 609;BA.debugLine="FD = Files.Get(i)";
Debug.ShouldStop(1);
_fd = (metube.mncplaymedia.com.fungsi._filedata)(_files.Get(_i));Debug.locals.put("FD", _fd);
 BA.debugLineNum = 610;BA.debugLine="b = (\"--\" & boundary & EOL & \"Content-Disposition: form-data; name=\" _  				& QUOTE & FD.KeyName & QUOTE & \"; filename=\" & QUOTE & FD.FileName & QUOTE _ 				& EOL & \"Content-Type: \"  & FD.ContentType & EOL & EOL).GetBytes(\"UTF8\")";
Debug.ShouldStop(2);
_b = ("--"+_boundary+_eol+"Content-Disposition: form-data; name="+anywheresoftware.b4a.keywords.Common.QUOTE+_fd.KeyName+anywheresoftware.b4a.keywords.Common.QUOTE+"; filename="+anywheresoftware.b4a.keywords.Common.QUOTE+_fd.FileName+anywheresoftware.b4a.keywords.Common.QUOTE+_eol+"Content-Type: "+_fd.ContentType+_eol+_eol).getBytes("UTF8");Debug.locals.put("b", _b);
 BA.debugLineNum = 613;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
Debug.ShouldStop(16);
_stream.WriteBytes(_b,(int) (0),_b.length);
 BA.debugLineNum = 614;BA.debugLine="Dim In As InputStream";
Debug.ShouldStop(32);
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();Debug.locals.put("In", _in);
 BA.debugLineNum = 615;BA.debugLine="In = File.OpenInput(FD.Dir, FD.FileName)";
Debug.ShouldStop(64);
_in = anywheresoftware.b4a.keywords.Common.File.OpenInput(_fd.Dir,_fd.FileName);Debug.locals.put("In", _in);
 BA.debugLineNum = 616;BA.debugLine="File.Copy2(In, stream) 'read the file and write it to the stream";
Debug.ShouldStop(128);
anywheresoftware.b4a.keywords.Common.File.Copy2((java.io.InputStream)(_in.getObject()),(java.io.OutputStream)(_stream.getObject()));
 BA.debugLineNum = 617;BA.debugLine="b = EOL.GetBytes(\"UTF8\")";
Debug.ShouldStop(256);
_b = _eol.getBytes("UTF8");Debug.locals.put("b", _b);
 BA.debugLineNum = 618;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
Debug.ShouldStop(512);
_stream.WriteBytes(_b,(int) (0),_b.length);
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 621;BA.debugLine="b = (EOL & \"--\" & boundary & \"--\" & EOL).GetBytes(\"UTF8\")";
Debug.ShouldStop(4096);
_b = (_eol+"--"+_boundary+"--"+_eol).getBytes("UTF8");Debug.locals.put("b", _b);
 BA.debugLineNum = 622;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
Debug.ShouldStop(8192);
_stream.WriteBytes(_b,(int) (0),_b.length);
 BA.debugLineNum = 623;BA.debugLine="Return stream";
Debug.ShouldStop(16384);
if (true) return _stream;
 BA.debugLineNum = 624;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return null;
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _createscaledbitmap(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _original,int _width,int _height) throws Exception{
try {
		Debug.PushSubsStack("CreateScaledBitmap (fungsi) ","fungsi",4,_ba,mostCurrent,259);
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _b = null;
;
Debug.locals.put("Original", _original);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 259;BA.debugLine="Sub CreateScaledBitmap(Original As Bitmap, Width As Int, Height As Int) As Bitmap";
Debug.ShouldStop(4);
 BA.debugLineNum = 260;BA.debugLine="Dim r As Reflector";
Debug.ShouldStop(8);
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();Debug.locals.put("r", _r);
 BA.debugLineNum = 261;BA.debugLine="Dim b As Bitmap";
Debug.ShouldStop(16);
_b = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();Debug.locals.put("b", _b);
 BA.debugLineNum = 262;BA.debugLine="b = r.RunStaticMethod(\"android.graphics.Bitmap\", \"createScaledBitmap\", _ 			Array As Object(Original, Width, Height, True), _ 			Array As String(\"android.graphics.Bitmap\", \"java.lang.int\", \"java.lang.int\", \"java.lang.boolean\"))";
Debug.ShouldStop(32);
_b.setObject((android.graphics.Bitmap)(_r.RunStaticMethod("android.graphics.Bitmap","createScaledBitmap",new Object[]{(Object)(_original.getObject()),(Object)(_width),(Object)(_height),(Object)(anywheresoftware.b4a.keywords.Common.True)},new String[]{"android.graphics.Bitmap","java.lang.int","java.lang.int","java.lang.boolean"})));
 BA.debugLineNum = 265;BA.debugLine="Return b";
Debug.ShouldStop(256);
if (true) return _b;
 BA.debugLineNum = 266;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return null;
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _createstatelistdrawable(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp,anywheresoftware.b4a.objects.ConcreteViewWrapper _cmd) throws Exception{
try {
		Debug.PushSubsStack("CreateStateListDrawable (fungsi) ","fungsi",4,_ba,mostCurrent,234);
anywheresoftware.b4a.objects.drawable.CanvasWrapper _c = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r1 = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _r2 = null;
anywheresoftware.b4a.objects.drawable.StateListDrawable _sld = null;
int _padding = 0;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bmd = null;
;
Debug.locals.put("bmp", _bmp);
Debug.locals.put("cmd", _cmd);
 BA.debugLineNum = 234;BA.debugLine="Sub CreateStateListDrawable(bmp As Bitmap,cmd As View )";
Debug.ShouldStop(512);
 BA.debugLineNum = 235;BA.debugLine="Dim C As Canvas";
Debug.ShouldStop(1024);
_c = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();Debug.locals.put("C", _c);
 BA.debugLineNum = 236;BA.debugLine="Dim r1 As Rect";
Debug.ShouldStop(2048);
_r1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();Debug.locals.put("r1", _r1);
 BA.debugLineNum = 237;BA.debugLine="Dim r2 As Rect";
Debug.ShouldStop(4096);
_r2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();Debug.locals.put("r2", _r2);
 BA.debugLineNum = 238;BA.debugLine="Dim sld As StateListDrawable";
Debug.ShouldStop(8192);
_sld = new anywheresoftware.b4a.objects.drawable.StateListDrawable();Debug.locals.put("sld", _sld);
 BA.debugLineNum = 239;BA.debugLine="Dim Padding As Int";
Debug.ShouldStop(16384);
_padding = 0;Debug.locals.put("Padding", _padding);
 BA.debugLineNum = 240;BA.debugLine="Padding = 0";
Debug.ShouldStop(32768);
_padding = (int) (0);Debug.locals.put("Padding", _padding);
 BA.debugLineNum = 242;BA.debugLine="C.Initialize(cmd)";
Debug.ShouldStop(131072);
_c.Initialize((android.view.View)(_cmd.getObject()));
 BA.debugLineNum = 243;BA.debugLine="r1.Initialize(0,0,cmd.Width,cmd.Height)";
Debug.ShouldStop(262144);
_r1.Initialize((int) (0),(int) (0),_cmd.getWidth(),_cmd.getHeight());
 BA.debugLineNum = 244;BA.debugLine="r2.Initialize(Padding,Padding,cmd.Width-Padding,cmd.height-Padding)";
Debug.ShouldStop(524288);
_r2.Initialize(_padding,_padding,(int) (_cmd.getWidth()-_padding),(int) (_cmd.getHeight()-_padding));
 BA.debugLineNum = 245;BA.debugLine="sld.Initialize";
Debug.ShouldStop(1048576);
_sld.Initialize();
 BA.debugLineNum = 247;BA.debugLine="C.DrawColor(Colors.RGB(58, 162, 203))";
Debug.ShouldStop(4194304);
_c.DrawColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (58),(int) (162),(int) (203)));
 BA.debugLineNum = 248;BA.debugLine="C.DrawBitmap(bmp,Null,r2)";
Debug.ShouldStop(8388608);
_c.DrawBitmap((android.graphics.Bitmap)(_bmp.getObject()),(android.graphics.Rect)(anywheresoftware.b4a.keywords.Common.Null),(android.graphics.Rect)(_r2.getObject()));
 BA.debugLineNum = 249;BA.debugLine="cmd.Invalidate";
Debug.ShouldStop(16777216);
_cmd.Invalidate();
 BA.debugLineNum = 250;BA.debugLine="sld.AddState(sld.State_Pressed,cmd.Background)";
Debug.ShouldStop(33554432);
_sld.AddState(_sld.State_Pressed,_cmd.getBackground());
 BA.debugLineNum = 252;BA.debugLine="Dim bmd As BitmapDrawable";
Debug.ShouldStop(134217728);
_bmd = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();Debug.locals.put("bmd", _bmd);
 BA.debugLineNum = 253;BA.debugLine="bmd.Initialize(bmp)";
Debug.ShouldStop(268435456);
_bmd.Initialize((android.graphics.Bitmap)(_bmp.getObject()));
 BA.debugLineNum = 254;BA.debugLine="sld.AddState(sld.State_Enabled, bmd)";
Debug.ShouldStop(536870912);
_sld.AddState(_sld.State_Enabled,(android.graphics.drawable.Drawable)(_bmd.getObject()));
 BA.debugLineNum = 256;BA.debugLine="cmd.Background = sld";
Debug.ShouldStop(-2147483648);
_cmd.setBackground((android.graphics.drawable.Drawable)(_sld.getObject()));
 BA.debugLineNum = 257;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _displaysize(anywheresoftware.b4a.BA _ba,double _sizeoct) throws Exception{
try {
		Debug.PushSubsStack("DisplaySize (fungsi) ","fungsi",4,_ba,mostCurrent,190);
String[] _txtunits = null;
int _unité = 0;
;
Debug.locals.put("SizeOct", _sizeoct);
 BA.debugLineNum = 190;BA.debugLine="Sub DisplaySize(SizeOct As Double) As String";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 191;BA.debugLine="Dim txtUnits(4) As String";
Debug.ShouldStop(1073741824);
_txtunits = new String[(int) (4)];
java.util.Arrays.fill(_txtunits,"");Debug.locals.put("txtUnits", _txtunits);
 BA.debugLineNum = 192;BA.debugLine="txtUnits = Array As String(\"bytes\", \"Kb\", \"Mb\", \"Gb\")";
Debug.ShouldStop(-2147483648);
_txtunits = new String[]{"bytes","Kb","Mb","Gb"};Debug.locals.put("txtUnits", _txtunits);
 BA.debugLineNum = 193;BA.debugLine="Dim Unité As Int";
Debug.ShouldStop(1);
_unité = 0;Debug.locals.put("Unité", _unité);
 BA.debugLineNum = 194;BA.debugLine="Unité = 0";
Debug.ShouldStop(2);
_unité = (int) (0);Debug.locals.put("Unité", _unité);
 BA.debugLineNum = 195;BA.debugLine="Do While SizeOct > 1024";
Debug.ShouldStop(4);
while (_sizeoct>1024) {
 BA.debugLineNum = 196;BA.debugLine="Unité = Unité + 1";
Debug.ShouldStop(8);
_unité = (int) (_unité+1);Debug.locals.put("Unité", _unité);
 BA.debugLineNum = 197;BA.debugLine="SizeOct = SizeOct / 1024";
Debug.ShouldStop(16);
_sizeoct = _sizeoct/(double)1024;Debug.locals.put("SizeOct", _sizeoct);
 }
;
 BA.debugLineNum = 199;BA.debugLine="If SizeOct <> Floor(SizeOct) Then";
Debug.ShouldStop(64);
if (_sizeoct!=anywheresoftware.b4a.keywords.Common.Floor(_sizeoct)) { 
 BA.debugLineNum = 200;BA.debugLine="Return NumberFormat(SizeOct, 1, 1) & \" \" & txtUnits(Unité)";
Debug.ShouldStop(128);
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_sizeoct,(int) (1),(int) (1))+" "+_txtunits[_unité];
 }else {
 BA.debugLineNum = 202;BA.debugLine="Return SizeOct & \" \" & txtUnits(Unité)";
Debug.ShouldStop(512);
if (true) return BA.NumberToString(_sizeoct)+" "+_txtunits[_unité];
 };
 BA.debugLineNum = 204;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _enkripdekrip(anywheresoftware.b4a.BA _ba,String _jenisenkripsi,String _katakunci,String _jenishash,String _isidata,String _pilihmetode) throws Exception{
try {
		Debug.PushSubsStack("EnkripDekrip (fungsi) ","fungsi",4,_ba,mostCurrent,389);
anywheresoftware.b4a.agraham.encryption.CipherWrapper.KeyGeneratorWrapper _kg = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper _md = null;
anywheresoftware.b4a.agraham.encryption.CipherWrapper _c = null;
byte[] _hasilnya = null;
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
anywheresoftware.b4a.objects.StringUtils _su = null;
;
Debug.locals.put("JenisEnkripsi", _jenisenkripsi);
Debug.locals.put("KataKunci", _katakunci);
Debug.locals.put("JenisHash", _jenishash);
Debug.locals.put("IsiData", _isidata);
Debug.locals.put("PilihMetode", _pilihmetode);
 BA.debugLineNum = 389;BA.debugLine="Sub EnkripDekrip(JenisEnkripsi As String, KataKunci As String, JenisHash As String, IsiData As String, PilihMetode As String) As String";
Debug.ShouldStop(16);
 BA.debugLineNum = 390;BA.debugLine="Dim kg 					As KeyGenerator";
Debug.ShouldStop(32);
_kg = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.KeyGeneratorWrapper();Debug.locals.put("kg", _kg);
 BA.debugLineNum = 391;BA.debugLine="Dim md 					As MessageDigest";
Debug.ShouldStop(64);
_md = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper();Debug.locals.put("md", _md);
 BA.debugLineNum = 392;BA.debugLine="Dim C 					As Cipher";
Debug.ShouldStop(128);
_c = new anywheresoftware.b4a.agraham.encryption.CipherWrapper();Debug.locals.put("C", _c);
 BA.debugLineNum = 393;BA.debugLine="Dim hasilnya() 			As Byte";
Debug.ShouldStop(256);
_hasilnya = new byte[(int) (0)];
;Debug.locals.put("hasilnya", _hasilnya);
 BA.debugLineNum = 394;BA.debugLine="Dim	bc					As ByteConverter";
Debug.ShouldStop(512);
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();Debug.locals.put("bc", _bc);
 BA.debugLineNum = 395;BA.debugLine="Dim su 					As StringUtils";
Debug.ShouldStop(1024);
_su = new anywheresoftware.b4a.objects.StringUtils();Debug.locals.put("su", _su);
 BA.debugLineNum = 397;BA.debugLine="kg.Initialize(JenisEnkripsi)";
Debug.ShouldStop(4096);
_kg.Initialize(_jenisenkripsi);
 BA.debugLineNum = 398;BA.debugLine="kg.KeyFromBytes(md.GetMessageDigest(KataKunci.GetBytes(\"UTF8\"), JenisHash))";
Debug.ShouldStop(8192);
_kg.KeyFromBytes(_md.GetMessageDigest(_katakunci.getBytes("UTF8"),_jenishash));
 BA.debugLineNum = 399;BA.debugLine="C.Initialize(JenisEnkripsi)";
Debug.ShouldStop(16384);
_c.Initialize(_jenisenkripsi);
 BA.debugLineNum = 401;BA.debugLine="Try";
Debug.ShouldStop(65536);
try { BA.debugLineNum = 402;BA.debugLine="If PilihMetode = \"Enkripsi\" OR PilihMetode = \"Encode\" Then";
Debug.ShouldStop(131072);
if ((_pilihmetode).equals("Enkripsi") || (_pilihmetode).equals("Encode")) { 
 BA.debugLineNum = 403;BA.debugLine="hasilnya = C.Encrypt(IsiData.GetBytes(\"UTF8\"), kg.Key, False)";
Debug.ShouldStop(262144);
_hasilnya = _c.Encrypt(_isidata.getBytes("UTF8"),(java.security.Key)(_kg.getKey()),anywheresoftware.b4a.keywords.Common.False);Debug.locals.put("hasilnya", _hasilnya);
 }else {
 BA.debugLineNum = 405;BA.debugLine="If PilihMetode = \"Decode\" Then";
Debug.ShouldStop(1048576);
if ((_pilihmetode).equals("Decode")) { 
 BA.debugLineNum = 406;BA.debugLine="hasilnya = su.DecodeBase64(IsiData)";
Debug.ShouldStop(2097152);
_hasilnya = _su.DecodeBase64(_isidata);Debug.locals.put("hasilnya", _hasilnya);
 BA.debugLineNum = 407;BA.debugLine="hasilnya = C.Decrypt(hasilnya, kg.Key, False)";
Debug.ShouldStop(4194304);
_hasilnya = _c.Decrypt(_hasilnya,(java.security.Key)(_kg.getKey()),anywheresoftware.b4a.keywords.Common.False);Debug.locals.put("hasilnya", _hasilnya);
 }else {
 BA.debugLineNum = 409;BA.debugLine="hasilnya = bc.HexToBytes(IsiData)";
Debug.ShouldStop(16777216);
_hasilnya = _bc.HexToBytes(_isidata);Debug.locals.put("hasilnya", _hasilnya);
 BA.debugLineNum = 410;BA.debugLine="hasilnya = C.Decrypt(hasilnya, kg.Key, False)";
Debug.ShouldStop(33554432);
_hasilnya = _c.Decrypt(_hasilnya,(java.security.Key)(_kg.getKey()),anywheresoftware.b4a.keywords.Common.False);Debug.locals.put("hasilnya", _hasilnya);
 };
 };
 } 
       catch (Exception e328) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e328); BA.debugLineNum = 414;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(536870912);
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 BA.debugLineNum = 415;BA.debugLine="DoEvents";
Debug.ShouldStop(1073741824);
anywheresoftware.b4a.keywords.Common.DoEvents();
 BA.debugLineNum = 416;BA.debugLine="Return False";
Debug.ShouldStop(-2147483648);
if (true) return BA.ObjectToString(anywheresoftware.b4a.keywords.Common.False);
 };
 BA.debugLineNum = 419;BA.debugLine="If PilihMetode = \"Enkripsi\" Then";
Debug.ShouldStop(4);
if ((_pilihmetode).equals("Enkripsi")) { 
 BA.debugLineNum = 420;BA.debugLine="Return bc.HexFromBytes(hasilnya)";
Debug.ShouldStop(8);
if (true) return _bc.HexFromBytes(_hasilnya);
 }else {
 BA.debugLineNum = 422;BA.debugLine="If PilihMetode = \"Encode\" Then";
Debug.ShouldStop(32);
if ((_pilihmetode).equals("Encode")) { 
 BA.debugLineNum = 423;BA.debugLine="Return su.EncodeBase64(hasilnya)";
Debug.ShouldStop(64);
if (true) return _su.EncodeBase64(_hasilnya);
 }else {
 BA.debugLineNum = 425;BA.debugLine="Return bc.StringFromBytes(hasilnya, \"UTF8\")";
Debug.ShouldStop(256);
if (true) return _bc.StringFromBytes(_hasilnya,"UTF8");
 };
 };
 BA.debugLineNum = 428;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static Object  _getdrawable(anywheresoftware.b4a.BA _ba,String _name) throws Exception{
try {
		Debug.PushSubsStack("GetDrawable (fungsi) ","fungsi",4,_ba,mostCurrent,223);
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
String _package = "";
int _id = 0;
;
Debug.locals.put("Name", _name);
 BA.debugLineNum = 223;BA.debugLine="Sub GetDrawable(Name As String) As Object";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 224;BA.debugLine="Dim r As Reflector";
Debug.ShouldStop(-2147483648);
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();Debug.locals.put("r", _r);
 BA.debugLineNum = 225;BA.debugLine="Dim package As String";
Debug.ShouldStop(1);
_package = "";Debug.locals.put("package", _package);
 BA.debugLineNum = 226;BA.debugLine="Dim id As Int";
Debug.ShouldStop(2);
_id = 0;Debug.locals.put("id", _id);
 BA.debugLineNum = 227;BA.debugLine="package = r.GetStaticField(\"anywheresoftware.b4a.BA\", \"packageName\")";
Debug.ShouldStop(4);
_package = BA.ObjectToString(_r.GetStaticField("anywheresoftware.b4a.BA","packageName"));Debug.locals.put("package", _package);
 BA.debugLineNum = 228;BA.debugLine="id = r.GetStaticField(package & \".R$drawable\", Name)";
Debug.ShouldStop(8);
_id = (int)(BA.ObjectToNumber(_r.GetStaticField(_package+".R$drawable",_name)));Debug.locals.put("id", _id);
 BA.debugLineNum = 229;BA.debugLine="r.Target = r.GetContext";
Debug.ShouldStop(16);
_r.Target = (Object)(_r.GetContext((_ba.processBA == null ? _ba : _ba.processBA)));Debug.locals.put("r", _r);
 BA.debugLineNum = 230;BA.debugLine="r.Target = r.RunMethod(\"getResources\")";
Debug.ShouldStop(32);
_r.Target = _r.RunMethod("getResources");Debug.locals.put("r", _r);
 BA.debugLineNum = 231;BA.debugLine="Return r.RunMethod2(\"getDrawable\", id, \"java.lang.int\")";
Debug.ShouldStop(64);
if (true) return _r.RunMethod2("getDrawable",BA.NumberToString(_id),"java.lang.int");
 BA.debugLineNum = 232;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return null;
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _getfileext(anywheresoftware.b4a.BA _ba,String _fullpath) throws Exception{
try {
		Debug.PushSubsStack("GetFileExt (fungsi) ","fungsi",4,_ba,mostCurrent,278);
;
Debug.locals.put("FullPath", _fullpath);
 BA.debugLineNum = 278;BA.debugLine="Sub GetFileExt(FullPath As String) As String";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 279;BA.debugLine="Return FullPath.SubString(FullPath.LastIndexOf(\".\")+1)";
Debug.ShouldStop(4194304);
if (true) return _fullpath.substring((int) (_fullpath.lastIndexOf(".")+1));
 BA.debugLineNum = 280;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _getfilename(anywheresoftware.b4a.BA _ba,String _fullpath) throws Exception{
try {
		Debug.PushSubsStack("GetFileName (fungsi) ","fungsi",4,_ba,mostCurrent,272);
String _strtemp = "";
;
Debug.locals.put("FullPath", _fullpath);
 BA.debugLineNum = 272;BA.debugLine="Sub GetFileName(FullPath As String) As String";
Debug.ShouldStop(32768);
 BA.debugLineNum = 273;BA.debugLine="Dim strTemp As String";
Debug.ShouldStop(65536);
_strtemp = "";Debug.locals.put("strTemp", _strtemp);
 BA.debugLineNum = 274;BA.debugLine="strTemp = GetFullName(FullPath)";
Debug.ShouldStop(131072);
_strtemp = _getfullname(_ba,_fullpath);Debug.locals.put("strTemp", _strtemp);
 BA.debugLineNum = 275;BA.debugLine="Return strTemp.SubString2(0, strTemp.LastIndexOf(\".\"))";
Debug.ShouldStop(262144);
if (true) return _strtemp.substring((int) (0),_strtemp.lastIndexOf("."));
 BA.debugLineNum = 276;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _getfullname(anywheresoftware.b4a.BA _ba,String _fullpath) throws Exception{
try {
		Debug.PushSubsStack("GetFullName (fungsi) ","fungsi",4,_ba,mostCurrent,268);
;
Debug.locals.put("FullPath", _fullpath);
 BA.debugLineNum = 268;BA.debugLine="Sub GetFullName(FullPath As String) As String";
Debug.ShouldStop(2048);
 BA.debugLineNum = 269;BA.debugLine="Return FullPath.SubString(FullPath.LastIndexOf(\"/\")+1)";
Debug.ShouldStop(4096);
if (true) return _fullpath.substring((int) (_fullpath.lastIndexOf("/")+1));
 BA.debugLineNum = 270;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static anywheresoftware.b4a.objects.ConcreteViewWrapper  _getparentpanel(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _myview,anywheresoftware.b4a.objects.PanelWrapper _mypanel) throws Exception{
try {
		Debug.PushSubsStack("GetParentPanel (fungsi) ","fungsi",4,_ba,mostCurrent,206);
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
anywheresoftware.b4a.objects.ConcreteViewWrapper _parent = null;
;
Debug.locals.put("MyView", _myview);
Debug.locals.put("MyPanel", _mypanel);
 BA.debugLineNum = 206;BA.debugLine="Sub GetParentPanel(MyView As View, MyPanel As Panel) As View";
Debug.ShouldStop(8192);
 BA.debugLineNum = 207;BA.debugLine="Dim r As Reflector";
Debug.ShouldStop(16384);
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();Debug.locals.put("r", _r);
 BA.debugLineNum = 208;BA.debugLine="Dim v, Parent As View";
Debug.ShouldStop(32768);
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();Debug.locals.put("v", _v);
_parent = new anywheresoftware.b4a.objects.ConcreteViewWrapper();Debug.locals.put("Parent", _parent);
 BA.debugLineNum = 210;BA.debugLine="r.Target = MyView";
Debug.ShouldStop(131072);
_r.Target = (Object)(_myview.getObject());Debug.locals.put("r", _r);
 BA.debugLineNum = 211;BA.debugLine="v = r.Target";
Debug.ShouldStop(262144);
_v.setObject((android.view.View)(_r.Target));
 BA.debugLineNum = 212;BA.debugLine="Parent = r.RunMethod(\"getParent\")";
Debug.ShouldStop(524288);
_parent.setObject((android.view.View)(_r.RunMethod("getParent")));
 BA.debugLineNum = 214;BA.debugLine="Do While Parent <> MyPanel";
Debug.ShouldStop(2097152);
while ((_parent).equals((android.view.View)(_mypanel.getObject())) == false) {
 BA.debugLineNum = 215;BA.debugLine="r.Target = Parent";
Debug.ShouldStop(4194304);
_r.Target = (Object)(_parent.getObject());Debug.locals.put("r", _r);
 BA.debugLineNum = 216;BA.debugLine="v = r.Target";
Debug.ShouldStop(8388608);
_v.setObject((android.view.View)(_r.Target));
 BA.debugLineNum = 217;BA.debugLine="Parent = r.RunMethod(\"getParent\")";
Debug.ShouldStop(16777216);
_parent.setObject((android.view.View)(_r.RunMethod("getParent")));
 }
;
 BA.debugLineNum = 220;BA.debugLine="Return v";
Debug.ShouldStop(134217728);
if (true) return _v;
 BA.debugLineNum = 221;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return null;
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _getparentpath(anywheresoftware.b4a.BA _ba,String _path) throws Exception{
try {
		Debug.PushSubsStack("GetParentPath (fungsi) ","fungsi",4,_ba,mostCurrent,282);
String _path1 = "";
int _l = 0;
;
Debug.locals.put("Path", _path);
 BA.debugLineNum = 282;BA.debugLine="Sub GetParentPath(Path As String) As String";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 283;BA.debugLine="Dim Path1 As String";
Debug.ShouldStop(67108864);
_path1 = "";Debug.locals.put("Path1", _path1);
 BA.debugLineNum = 284;BA.debugLine="Dim L 		 As Int";
Debug.ShouldStop(134217728);
_l = 0;Debug.locals.put("L", _l);
 BA.debugLineNum = 285;BA.debugLine="If Path = \"/\" Then";
Debug.ShouldStop(268435456);
if ((_path).equals("/")) { 
 BA.debugLineNum = 286;BA.debugLine="Return \"/\"";
Debug.ShouldStop(536870912);
if (true) return "/";
 };
 BA.debugLineNum = 288;BA.debugLine="L = Path.LastIndexOf(\"/\")";
Debug.ShouldStop(-2147483648);
_l = _path.lastIndexOf("/");Debug.locals.put("L", _l);
 BA.debugLineNum = 289;BA.debugLine="If L = Path.Length - 1 Then";
Debug.ShouldStop(1);
if (_l==_path.length()-1) { 
 BA.debugLineNum = 291;BA.debugLine="Path1 = Path.SubString2(0,L)";
Debug.ShouldStop(4);
_path1 = _path.substring((int) (0),_l);Debug.locals.put("Path1", _path1);
 }else {
 BA.debugLineNum = 293;BA.debugLine="Path1 = Path";
Debug.ShouldStop(16);
_path1 = _path;Debug.locals.put("Path1", _path1);
 };
 BA.debugLineNum = 295;BA.debugLine="L = Path.LastIndexOf(\"/\")";
Debug.ShouldStop(64);
_l = _path.lastIndexOf("/");Debug.locals.put("L", _l);
 BA.debugLineNum = 296;BA.debugLine="If L = 0 Then";
Debug.ShouldStop(128);
if (_l==0) { 
 BA.debugLineNum = 297;BA.debugLine="L = 1";
Debug.ShouldStop(256);
_l = (int) (1);Debug.locals.put("L", _l);
 };
 BA.debugLineNum = 299;BA.debugLine="Return Path1.SubString2(0,L)";
Debug.ShouldStop(1024);
if (true) return _path1.substring((int) (0),_l);
 BA.debugLineNum = 300;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _infodevice(anywheresoftware.b4a.BA _ba) throws Exception{
try {
		Debug.PushSubsStack("InfoDevice (fungsi) ","fungsi",4,_ba,mostCurrent,145);
;
 BA.debugLineNum = 145;BA.debugLine="Sub InfoDevice";
Debug.ShouldStop(65536);
 BA.debugLineNum = 147;BA.debugLine="APIver = refl.GetStaticField(\"android.os.Build$VERSION\", \"SDK_INT\")";
Debug.ShouldStop(262144);
_apiver = (int)(BA.ObjectToNumber(_refl.GetStaticField("android.os.Build$VERSION","SDK_INT")));
 BA.debugLineNum = 148;BA.debugLine="If APIver < 9 Then";
Debug.ShouldStop(524288);
if (_apiver<9) { 
 BA.debugLineNum = 149;BA.debugLine="szRefSerial = \"n/a\"";
Debug.ShouldStop(1048576);
_szrefserial = "n/a";
 }else {
 BA.debugLineNum = 151;BA.debugLine="szRefSerial = refl.GetStaticField(\"android.os.Build\", \"SERIAL\")";
Debug.ShouldStop(4194304);
_szrefserial = BA.ObjectToString(_refl.GetStaticField("android.os.Build","SERIAL"));
 };
 BA.debugLineNum = 154;BA.debugLine="szAndroidID = myPhone.GetSettings(\"android_id\")";
Debug.ShouldStop(33554432);
_szandroidid = _myphone.GetSettings("android_id");
 BA.debugLineNum = 155;BA.debugLine="szManufacturer = myPhone.Manufacturer";
Debug.ShouldStop(67108864);
_szmanufacturer = _myphone.getManufacturer();
 BA.debugLineNum = 156;BA.debugLine="szModel = myPhone.Model";
Debug.ShouldStop(134217728);
_szmodel = _myphone.getModel();
 BA.debugLineNum = 157;BA.debugLine="szProduct = myPhone.Product";
Debug.ShouldStop(268435456);
_szproduct = _myphone.getProduct();
 BA.debugLineNum = 158;BA.debugLine="szIMEI = thisPhone.GetDeviceId";
Debug.ShouldStop(536870912);
_szimei = _thisphone.GetDeviceId();
 BA.debugLineNum = 159;BA.debugLine="szIMSI = thisPhone.GetSimSerialNumber";
Debug.ShouldStop(1073741824);
_szimsi = _thisphone.GetSimSerialNumber();
 BA.debugLineNum = 160;BA.debugLine="szSubsID = thisPhone.GetSubscriberId";
Debug.ShouldStop(-2147483648);
_szsubsid = _thisphone.GetSubscriberId();
 BA.debugLineNum = 161;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _keygen(anywheresoftware.b4a.BA _ba) throws Exception{
try {
		Debug.PushSubsStack("Keygen (fungsi) ","fungsi",4,_ba,mostCurrent,354);
anywheresoftware.b4a.agraham.encryption.CipherWrapper.SecureRandomWrapper _sr = null;
String _gkey = "";
String _lcode = "";
String _rhead = "";
String _chararray = "";
int _i = 0;
int _length = 0;
;
 BA.debugLineNum = 354;BA.debugLine="Sub Keygen() As String";
Debug.ShouldStop(2);
 BA.debugLineNum = 355;BA.debugLine="Dim sr As SecureRandom";
Debug.ShouldStop(4);
_sr = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.SecureRandomWrapper();Debug.locals.put("sr", _sr);
 BA.debugLineNum = 356;BA.debugLine="Dim gkey, lCode, rHead, charArray As String";
Debug.ShouldStop(8);
_gkey = "";Debug.locals.put("gkey", _gkey);
_lcode = "";Debug.locals.put("lCode", _lcode);
_rhead = "";Debug.locals.put("rHead", _rhead);
_chararray = "";Debug.locals.put("charArray", _chararray);
 BA.debugLineNum = 357;BA.debugLine="Dim i, length As Int";
Debug.ShouldStop(16);
_i = 0;Debug.locals.put("i", _i);
_length = 0;Debug.locals.put("length", _length);
 BA.debugLineNum = 359;BA.debugLine="charArray = \"zyxwvutsrqponmlkjihgfedcba0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\"";
Debug.ShouldStop(64);
_chararray = "zyxwvutsrqponmlkjihgfedcba0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";Debug.locals.put("charArray", _chararray);
 BA.debugLineNum = 361;BA.debugLine="length = Rnd(10, 15)";
Debug.ShouldStop(256);
_length = anywheresoftware.b4a.keywords.Common.Rnd((int) (10),(int) (15));Debug.locals.put("length", _length);
 BA.debugLineNum = 362;BA.debugLine="lCode = Bit.ToHexString(length)";
Debug.ShouldStop(512);
_lcode = anywheresoftware.b4a.keywords.Common.Bit.ToHexString(_length);Debug.locals.put("lCode", _lcode);
 BA.debugLineNum = 364;BA.debugLine="For i = 0 To 2";
Debug.ShouldStop(2048);
{
final int step287 = 1;
final int limit287 = (int) (2);
for (_i = (int) (0); (step287 > 0 && _i <= limit287) || (step287 < 0 && _i >= limit287); _i = ((int)(0 + _i + step287))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 365;BA.debugLine="rHead = rHead&charArray.CharAt(Rnd(0,61))";
Debug.ShouldStop(4096);
_rhead = _rhead+BA.ObjectToString(_chararray.charAt(anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (61))));Debug.locals.put("rHead", _rhead);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 368;BA.debugLine="For i = 0 To length-1";
Debug.ShouldStop(32768);
{
final int step290 = 1;
final int limit290 = (int) (_length-1);
for (_i = (int) (0); (step290 > 0 && _i <= limit290) || (step290 < 0 && _i >= limit290); _i = ((int)(0 + _i + step290))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 369;BA.debugLine="gkey = gkey&charArray.CharAt(Rnd(0,61))";
Debug.ShouldStop(65536);
_gkey = _gkey+BA.ObjectToString(_chararray.charAt(anywheresoftware.b4a.keywords.Common.Rnd((int) (0),(int) (61))));Debug.locals.put("gkey", _gkey);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 372;BA.debugLine="gkey = rHead&lCode&gkey";
Debug.ShouldStop(524288);
_gkey = _rhead+_lcode+_gkey;Debug.locals.put("gkey", _gkey);
 BA.debugLineNum = 374;BA.debugLine="Return gkey";
Debug.ShouldStop(2097152);
if (true) return _gkey;
 BA.debugLineNum = 375;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Type FormatConfig(aid As String, rsn As String, imei As String, _ 	sTab As String, MacAddr As String, FolderDBS As String, _ 	Username As String, Password As String, Token As String, sStorage As String, FolderMedia As String)";
;
 //BA.debugLineNum = 11;BA.debugLine="Type FileData (Dir As String, FileName As String, KeyName As String, ContentType As String)";
;
 //BA.debugLineNum = 13;BA.debugLine="Dim	mpList					As Map";
_mplist = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 14;BA.debugLine="Dim	DirDBS					As String";
_dirdbs = "";
 //BA.debugLineNum = 15;BA.debugLine="Dim DataConfig				As FormatConfig";
_dataconfig = new metube.mncplaymedia.com.fungsi._formatconfig();
 //BA.debugLineNum = 16;BA.debugLine="Dim raf						As RandomAccessFile";
_raf = new anywheresoftware.b4a.randomaccessfile.RandomAccessFile();
 //BA.debugLineNum = 18;BA.debugLine="Dim szAndroidID 			As String";
_szandroidid = "";
 //BA.debugLineNum = 19;BA.debugLine="Dim szRefSerial 			As String";
_szrefserial = "";
 //BA.debugLineNum = 20;BA.debugLine="Dim szIMEI					As String";
_szimei = "";
 //BA.debugLineNum = 21;BA.debugLine="Dim szIMSI					As String";
_szimsi = "";
 //BA.debugLineNum = 22;BA.debugLine="Dim szManufacturer			As String";
_szmanufacturer = "";
 //BA.debugLineNum = 23;BA.debugLine="Dim szModel					As String";
_szmodel = "";
 //BA.debugLineNum = 24;BA.debugLine="Dim	szProduct				As String";
_szproduct = "";
 //BA.debugLineNum = 25;BA.debugLine="Dim	szSubsID				As String";
_szsubsid = "";
 //BA.debugLineNum = 27;BA.debugLine="Dim APIver 					As Int";
_apiver = 0;
 //BA.debugLineNum = 28;BA.debugLine="Dim refl 					As Reflector";
_refl = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 29;BA.debugLine="Dim myPhone 				As Phone";
_myphone = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 30;BA.debugLine="Dim thisPhone 				As PhoneId";
_thisphone = new anywheresoftware.b4a.phone.Phone.PhoneId();
 //BA.debugLineNum = 31;BA.debugLine="Dim mKoneksi 				As Map";
_mkoneksi = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 32;BA.debugLine="Dim boundary 				As String";
_boundary = "";
 //BA.debugLineNum = 34;BA.debugLine="Dim CateMap 				As Map";
_catemap = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 35;BA.debugLine="Dim MoviesMap	 			As Map";
_moviesmap = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 36;BA.debugLine="Dim ChannelMap 				As Map";
_channelmap = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 37;BA.debugLine="Dim SeriesMap 				As Map";
_seriesmap = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 38;BA.debugLine="Dim TrailerMap				As Map";
_trailermap = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 40;BA.debugLine="Dim InitFail				As String = \"Initialize failed !\"";
_initfail = "Initialize failed !";
 //BA.debugLineNum = 41;BA.debugLine="Dim TitleBox				As String = \"METube\"";
_titlebox = "METube";
 //BA.debugLineNum = 42;BA.debugLine="Dim btnOK					As String = \"OK\"";
_btnok = "OK";
 //BA.debugLineNum = 43;BA.debugLine="Dim btnCancel				As String = \"Cancel\"";
_btncancel = "Cancel";
 //BA.debugLineNum = 44;BA.debugLine="Dim btnNO						As String = \"NO\"";
_btnno = "NO";
 //BA.debugLineNum = 45;BA.debugLine="Dim LoadFail				As String = \"Load init failed !\"";
_loadfail = "Load init failed !";
 //BA.debugLineNum = 46;BA.debugLine="Dim NoKoneksi				As String = \"Offline Connection or Server Down\"";
_nokoneksi = "Offline Connection or Server Down";
 //BA.debugLineNum = 47;BA.debugLine="Dim LblHome					As String = \"Home\"";
_lblhome = "Home";
 //BA.debugLineNum = 48;BA.debugLine="Dim LblBrowse				As String = \"Browse\"";
_lblbrowse = "Browse";
 //BA.debugLineNum = 49;BA.debugLine="Dim LblLogin				As String = \"Login\"";
_lbllogin = "Login";
 //BA.debugLineNum = 50;BA.debugLine="Dim lblExit					As String = \"Do you want to exit ?\"";
_lblexit = "Do you want to exit ?";
 //BA.debugLineNum = 52;BA.debugLine="Dim icWarning				As String = \"ic_action_warning\"";
_icwarning = "ic_action_warning";
 //BA.debugLineNum = 53;BA.debugLine="Dim icHome					As String = \"home.png\"";
_ichome = "home.png";
 //BA.debugLineNum = 54;BA.debugLine="Dim icBrowse				As String = \"browse.png\"";
_icbrowse = "browse.png";
 //BA.debugLineNum = 55;BA.debugLine="Dim icLogin					As String = \"login.png\"";
_iclogin = "login.png";
 //BA.debugLineNum = 56;BA.debugLine="Dim icTopHeader				As String = \"topheader\"";
_ictopheader = "topheader";
 //BA.debugLineNum = 57;BA.debugLine="Dim icPanelInfo				As String = \"panelinfo\"";
_icpanelinfo = "panelinfo";
 //BA.debugLineNum = 58;BA.debugLine="Dim icMenuPilih				As String = \"menu_icon\"";
_icmenupilih = "menu_icon";
 //BA.debugLineNum = 59;BA.debugLine="Dim iccaridata				As String = \"search_icon\"";
_iccaridata = "search_icon";
 //BA.debugLineNum = 60;BA.debugLine="Dim icPanelKiri				As String = \"panelkiri\"";
_icpanelkiri = "panelkiri";
 //BA.debugLineNum = 61;BA.debugLine="Dim icTutup					As String = \"cancel_icon\"";
_ictutup = "cancel_icon";
 //BA.debugLineNum = 62;BA.debugLine="Dim icPanahNext				As String = \"arrownext\"";
_icpanahnext = "arrownext";
 //BA.debugLineNum = 63;BA.debugLine="Dim icSetting				As String = \"gear\"";
_icsetting = "gear";
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public static String  _prosesenkripsi(anywheresoftware.b4a.BA _ba,String _data) throws Exception{
try {
		Debug.PushSubsStack("ProsesEnkripsi (fungsi) ","fungsi",4,_ba,mostCurrent,336);
String _pekey = "";
String _pestrenc = "";
anywheresoftware.b4a.objects.StringUtils _pesutils = null;
;
Debug.locals.put("Data", _data);
 BA.debugLineNum = 336;BA.debugLine="Sub ProsesEnkripsi(Data As String) As String";
Debug.ShouldStop(32768);
 BA.debugLineNum = 337;BA.debugLine="Dim peKey 		As String";
Debug.ShouldStop(65536);
_pekey = "";Debug.locals.put("peKey", _pekey);
 BA.debugLineNum = 338;BA.debugLine="Dim pestrEnc 	As String";
Debug.ShouldStop(131072);
_pestrenc = "";Debug.locals.put("pestrEnc", _pestrenc);
 BA.debugLineNum = 339;BA.debugLine="Dim pesutils 	As StringUtils";
Debug.ShouldStop(262144);
_pesutils = new anywheresoftware.b4a.objects.StringUtils();Debug.locals.put("pesutils", _pesutils);
 BA.debugLineNum = 341;BA.debugLine="Try";
Debug.ShouldStop(1048576);
try { BA.debugLineNum = 342;BA.debugLine="peKey = Keygen";
Debug.ShouldStop(2097152);
_pekey = _keygen(_ba);Debug.locals.put("peKey", _pekey);
 BA.debugLineNum = 343;BA.debugLine="pestrEnc = Wrap(Data, peKey)";
Debug.ShouldStop(4194304);
_pestrenc = _wrap(_ba,_data,_pekey);Debug.locals.put("pestrEnc", _pestrenc);
 BA.debugLineNum = 344;BA.debugLine="pestrEnc = pesutils.EncodeBase64(pestrEnc.GetBytes(\"UTF8\"))";
Debug.ShouldStop(8388608);
_pestrenc = _pesutils.EncodeBase64(_pestrenc.getBytes("UTF8"));Debug.locals.put("pestrEnc", _pestrenc);
 } 
       catch (Exception e275) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e275); BA.debugLineNum = 347;BA.debugLine="Msgbox2(\"Process Failed !\", \"IKR Playbox\", \"OK\", \"\", \"\", LoadBitmap(File.DirAssets, \"warning.png\"))";
Debug.ShouldStop(67108864);
anywheresoftware.b4a.keywords.Common.Msgbox2("Process Failed !","IKR Playbox","OK","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"warning.png").getObject()),_ba);
 BA.debugLineNum = 348;BA.debugLine="Return \"Enkripsi Failed\"";
Debug.ShouldStop(134217728);
if (true) return "Enkripsi Failed";
 };
 BA.debugLineNum = 351;BA.debugLine="Return pestrEnc";
Debug.ShouldStop(1073741824);
if (true) return _pestrenc;
 BA.debugLineNum = 352;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _setdirprog(anywheresoftware.b4a.BA _ba,String _folderbaru) throws Exception{
try {
		Debug.PushSubsStack("SetDirProg (fungsi) ","fungsi",4,_ba,mostCurrent,67);
;
Debug.locals.put("FolderBaru", _folderbaru);
 BA.debugLineNum = 67;BA.debugLine="Sub SetDirProg(FolderBaru As String)";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="If File.ExternalWritable Then DirDBS = File.DirRootExternal Else DirDBS = File.DirInternal";
Debug.ShouldStop(8);
if (anywheresoftware.b4a.keywords.Common.File.getExternalWritable()) { 
_dirdbs = anywheresoftware.b4a.keywords.Common.File.getDirRootExternal();}
else {
_dirdbs = anywheresoftware.b4a.keywords.Common.File.getDirInternal();};
 BA.debugLineNum = 70;BA.debugLine="If (File.IsDirectory(DirDBS, FolderBaru) <> True) AND (FolderBaru.Trim <> \"\") Then";
Debug.ShouldStop(32);
if ((anywheresoftware.b4a.keywords.Common.File.IsDirectory(_dirdbs,_folderbaru)!=anywheresoftware.b4a.keywords.Common.True) && ((_folderbaru.trim()).equals("") == false)) { 
 BA.debugLineNum = 71;BA.debugLine="File.MakeDir(DirDBS, FolderBaru)";
Debug.ShouldStop(64);
anywheresoftware.b4a.keywords.Common.File.MakeDir(_dirdbs,_folderbaru);
 };
 BA.debugLineNum = 74;BA.debugLine="DirDBS = DirDBS & \"/\" & FolderBaru";
Debug.ShouldStop(512);
_dirdbs = _dirdbs+"/"+_folderbaru;
 BA.debugLineNum = 75;BA.debugLine="mpList.Initialize";
Debug.ShouldStop(1024);
_mplist.Initialize();
 BA.debugLineNum = 76;BA.debugLine="mpList.Remove(\"DirDBS\")";
Debug.ShouldStop(2048);
_mplist.Remove((Object)("DirDBS"));
 BA.debugLineNum = 77;BA.debugLine="mpList.Put(\"DirDBS\", DirDBS)";
Debug.ShouldStop(4096);
_mplist.Put((Object)("DirDBS"),(Object)(_dirdbs));
 BA.debugLineNum = 78;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _setdivider(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ListViewWrapper _lv,int _color,int _height) throws Exception{
try {
		Debug.PushSubsStack("SetDivider (fungsi) ","fungsi",4,_ba,mostCurrent,626);
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
;
Debug.locals.put("lv", _lv);
Debug.locals.put("Color", _color);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 626;BA.debugLine="Sub SetDivider(lv As ListView, Color As Int, Height As Int)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 627;BA.debugLine="Dim r As Reflector";
Debug.ShouldStop(262144);
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();Debug.locals.put("r", _r);
 BA.debugLineNum = 628;BA.debugLine="r.Target = lv";
Debug.ShouldStop(524288);
_r.Target = (Object)(_lv.getObject());Debug.locals.put("r", _r);
 BA.debugLineNum = 629;BA.debugLine="Dim CD As ColorDrawable";
Debug.ShouldStop(1048576);
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();Debug.locals.put("CD", _cd);
 BA.debugLineNum = 630;BA.debugLine="CD.Initialize(Color, 0)";
Debug.ShouldStop(2097152);
_cd.Initialize(_color,(int) (0));
 BA.debugLineNum = 631;BA.debugLine="r.RunMethod4(\"setDivider\", Array As Object(CD), Array As String(\"android.graphics.drawable.Drawable\"))";
Debug.ShouldStop(4194304);
_r.RunMethod4("setDivider",new Object[]{(Object)(_cd.getObject())},new String[]{"android.graphics.drawable.Drawable"});
 BA.debugLineNum = 632;BA.debugLine="r.RunMethod2(\"setDividerHeight\", Height, \"java.lang.int\")";
Debug.ShouldStop(8388608);
_r.RunMethod2("setDividerHeight",BA.NumberToString(_height),"java.lang.int");
 BA.debugLineNum = 633;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static boolean  _setfileconfig(anywheresoftware.b4a.BA _ba) throws Exception{
try {
		Debug.PushSubsStack("SetFileConfig (fungsi) ","fungsi",4,_ba,mostCurrent,80);
com.AB.ABWifi.ABWifi _mywifi = null;
String _strmac = "";
;
 BA.debugLineNum = 80;BA.debugLine="Sub SetFileConfig As Boolean";
Debug.ShouldStop(32768);
 BA.debugLineNum = 81;BA.debugLine="If File.Exists(DirDBS, \"setting\") = False Then";
Debug.ShouldStop(65536);
if (anywheresoftware.b4a.keywords.Common.File.Exists(_dirdbs,"setting")==anywheresoftware.b4a.keywords.Common.False) { 
 BA.debugLineNum = 82;BA.debugLine="Dim myWifi 		As ABWifi";
Debug.ShouldStop(131072);
_mywifi = new com.AB.ABWifi.ABWifi();Debug.locals.put("myWifi", _mywifi);
 BA.debugLineNum = 83;BA.debugLine="Dim strMAC		As String";
Debug.ShouldStop(262144);
_strmac = "";Debug.locals.put("strMAC", _strmac);
 BA.debugLineNum = 85;BA.debugLine="If myWifi.ABLoadWifi() = True Then";
Debug.ShouldStop(1048576);
if (_mywifi.ABLoadWifi((_ba.processBA == null ? _ba : _ba.processBA))==anywheresoftware.b4a.keywords.Common.True) { 
 BA.debugLineNum = 86;BA.debugLine="Try";
Debug.ShouldStop(2097152);
try { BA.debugLineNum = 87;BA.debugLine="strMAC = myWifi.ABGetCurrentWifiInfo().MacAddress";
Debug.ShouldStop(4194304);
_strmac = _mywifi.ABGetCurrentWifiInfo().MacAddress;Debug.locals.put("strMAC", _strmac);
 BA.debugLineNum = 88;BA.debugLine="strMAC = strMAC.Replace(\":\", \"-\")";
Debug.ShouldStop(8388608);
_strmac = _strmac.replace(":","-");Debug.locals.put("strMAC", _strmac);
 } 
       catch (Exception e69) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e69); BA.debugLineNum = 90;BA.debugLine="strMAC = \"00-00-00-00-00-00\"";
Debug.ShouldStop(33554432);
_strmac = "00-00-00-00-00-00";Debug.locals.put("strMAC", _strmac);
 };
 }else {
 BA.debugLineNum = 93;BA.debugLine="strMAC = \"00-00-00-00-00-00\"";
Debug.ShouldStop(268435456);
_strmac = "00-00-00-00-00-00";Debug.locals.put("strMAC", _strmac);
 };
 BA.debugLineNum = 96;BA.debugLine="DataConfig.aid  				= szAndroidID";
Debug.ShouldStop(-2147483648);
_dataconfig.aid = _szandroidid;
 BA.debugLineNum = 97;BA.debugLine="DataConfig.rsn  				= szRefSerial";
Debug.ShouldStop(1);
_dataconfig.rsn = _szrefserial;
 BA.debugLineNum = 98;BA.debugLine="DataConfig.imei 				= szIMEI";
Debug.ShouldStop(2);
_dataconfig.imei = _szimei;
 BA.debugLineNum = 99;BA.debugLine="DataConfig.Username	 			= \"Guest\"";
Debug.ShouldStop(4);
_dataconfig.Username = "Guest";
 BA.debugLineNum = 100;BA.debugLine="DataConfig.Password	 			= \"None\"";
Debug.ShouldStop(8);
_dataconfig.Password = "None";
 BA.debugLineNum = 101;BA.debugLine="DataConfig.MacAddr 				= strMAC";
Debug.ShouldStop(16);
_dataconfig.MacAddr = _strmac;
 BA.debugLineNum = 102;BA.debugLine="DataConfig.sTab					= \"Video\"";
Debug.ShouldStop(32);
_dataconfig.sTab = "Video";
 BA.debugLineNum = 103;BA.debugLine="DataConfig.FolderDBS			= DirDBS";
Debug.ShouldStop(64);
_dataconfig.FolderDBS = _dirdbs;
 BA.debugLineNum = 104;BA.debugLine="DataConfig.Token				= \"None\"";
Debug.ShouldStop(128);
_dataconfig.Token = "None";
 BA.debugLineNum = 105;BA.debugLine="DataConfig.sStorage				= \"Storage\"";
Debug.ShouldStop(256);
_dataconfig.sStorage = "Storage";
 BA.debugLineNum = 106;BA.debugLine="DataConfig.FolderMedia			= DirDBS";
Debug.ShouldStop(512);
_dataconfig.FolderMedia = _dirdbs;
 BA.debugLineNum = 118;BA.debugLine="Return TulisFileConfig(DataConfig)";
Debug.ShouldStop(2097152);
if (true) return _tulisfileconfig(_ba,_dataconfig);
 }else {
 BA.debugLineNum = 121;BA.debugLine="Return True";
Debug.ShouldStop(16777216);
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 BA.debugLineNum = 123;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return false;
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static boolean  _tulisfileconfig(anywheresoftware.b4a.BA _ba,metube.mncplaymedia.com.fungsi._formatconfig _isiconfig) throws Exception{
try {
		Debug.PushSubsStack("TulisFileConfig (fungsi) ","fungsi",4,_ba,mostCurrent,125);
anywheresoftware.b4a.objects.collections.Map _mptemp = null;
;
Debug.locals.put("IsiConfig", _isiconfig);
 BA.debugLineNum = 125;BA.debugLine="Sub TulisFileConfig(IsiConfig As FormatConfig) As Boolean";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 126;BA.debugLine="Dim mpTemp		As Map";
Debug.ShouldStop(536870912);
_mptemp = new anywheresoftware.b4a.objects.collections.Map();Debug.locals.put("mpTemp", _mptemp);
 BA.debugLineNum = 128;BA.debugLine="mpTemp.Initialize";
Debug.ShouldStop(-2147483648);
_mptemp.Initialize();
 BA.debugLineNum = 129;BA.debugLine="mpTemp.Clear";
Debug.ShouldStop(1);
_mptemp.Clear();
 BA.debugLineNum = 130;BA.debugLine="mpTemp.Put(\"DataConfig\", IsiConfig)";
Debug.ShouldStop(2);
_mptemp.Put((Object)("DataConfig"),(Object)(_isiconfig));
 BA.debugLineNum = 132;BA.debugLine="Try";
Debug.ShouldStop(8);
try { BA.debugLineNum = 133;BA.debugLine="File.Delete(DirDBS, \"setting\")";
Debug.ShouldStop(16);
anywheresoftware.b4a.keywords.Common.File.Delete(_dirdbs,"setting");
 BA.debugLineNum = 134;BA.debugLine="raf.Initialize(DirDBS, \"setting\", False)";
Debug.ShouldStop(32);
_raf.Initialize(_dirdbs,"setting",anywheresoftware.b4a.keywords.Common.False);
 BA.debugLineNum = 135;BA.debugLine="raf.WriteEncryptedObject(mpTemp, szAndroidID & szRefSerial & szIMEI, raf.CurrentPosition)";
Debug.ShouldStop(64);
_raf.WriteEncryptedObject((Object)(_mptemp.getObject()),_szandroidid+_szrefserial+_szimei,_raf.CurrentPosition);
 BA.debugLineNum = 136;BA.debugLine="raf.Close";
Debug.ShouldStop(128);
_raf.Close();
 } 
       catch (Exception e101) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e101); BA.debugLineNum = 138;BA.debugLine="Msgbox2(\"Init data failed\", \"ezSchool\", \"OK\", \"\", \"\", LoadBitmap(File.DirAssets, \"Warning.png\"))";
Debug.ShouldStop(512);
anywheresoftware.b4a.keywords.Common.Msgbox2("Init data failed","ezSchool","OK","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Warning.png").getObject()),_ba);
 BA.debugLineNum = 139;BA.debugLine="Return False";
Debug.ShouldStop(1024);
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 BA.debugLineNum = 142;BA.debugLine="Return True";
Debug.ShouldStop(8192);
if (true) return anywheresoftware.b4a.keywords.Common.True;
 BA.debugLineNum = 143;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return false;
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _unwrap(anywheresoftware.b4a.BA _ba,String _text) throws Exception{
try {
		Debug.PushSubsStack("UnWrap (fungsi) ","fungsi",4,_ba,mostCurrent,576);
String _truekey = "";
String _unwrapped = "";
int _len = 0;
;
Debug.locals.put("Text", _text);
 BA.debugLineNum = 576;BA.debugLine="Sub UnWrap(Text As String) As String";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 577;BA.debugLine="Dim truekey, unwrapped As String";
Debug.ShouldStop(1);
_truekey = "";Debug.locals.put("truekey", _truekey);
_unwrapped = "";Debug.locals.put("unwrapped", _unwrapped);
 BA.debugLineNum = 578;BA.debugLine="Dim len As Int";
Debug.ShouldStop(2);
_len = 0;Debug.locals.put("len", _len);
 BA.debugLineNum = 580;BA.debugLine="len = Bit.ParseInt(Text.CharAt(3),16)";
Debug.ShouldStop(8);
_len = anywheresoftware.b4a.keywords.Common.Bit.ParseInt(BA.ObjectToString(_text.charAt((int) (3))),(int) (16));Debug.locals.put("len", _len);
 BA.debugLineNum = 581;BA.debugLine="truekey = Text.SubString2(4,4+len)";
Debug.ShouldStop(16);
_truekey = _text.substring((int) (4),(int) (4+_len));Debug.locals.put("truekey", _truekey);
 BA.debugLineNum = 582;BA.debugLine="unwrapped = EnkripDekrip(\"AES\", truekey, \"MD5\", Text.SubString(4+len), \"Decode\")";
Debug.ShouldStop(32);
_unwrapped = _enkripdekrip(_ba,"AES",_truekey,"MD5",_text.substring((int) (4+_len)),"Decode");Debug.locals.put("unwrapped", _unwrapped);
 BA.debugLineNum = 584;BA.debugLine="Return unwrapped";
Debug.ShouldStop(128);
if (true) return _unwrapped;
 BA.debugLineNum = 585;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _wrap(anywheresoftware.b4a.BA _ba,String _text,String _vkey) throws Exception{
try {
		Debug.PushSubsStack("Wrap (fungsi) ","fungsi",4,_ba,mostCurrent,377);
String _truekey = "";
String _encrypted = "";
String _wrapped = "";
int _len = 0;
;
Debug.locals.put("Text", _text);
Debug.locals.put("vkey", _vkey);
 BA.debugLineNum = 377;BA.debugLine="Sub Wrap(Text As String, vkey As String) As String";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 378;BA.debugLine="Dim trueKey, encrypted, wrapped As String";
Debug.ShouldStop(33554432);
_truekey = "";Debug.locals.put("trueKey", _truekey);
_encrypted = "";Debug.locals.put("encrypted", _encrypted);
_wrapped = "";Debug.locals.put("wrapped", _wrapped);
 BA.debugLineNum = 379;BA.debugLine="Dim len As Int";
Debug.ShouldStop(67108864);
_len = 0;Debug.locals.put("len", _len);
 BA.debugLineNum = 381;BA.debugLine="len = Bit.ParseInt(vkey.CharAt(3),16)";
Debug.ShouldStop(268435456);
_len = anywheresoftware.b4a.keywords.Common.Bit.ParseInt(BA.ObjectToString(_vkey.charAt((int) (3))),(int) (16));Debug.locals.put("len", _len);
 BA.debugLineNum = 382;BA.debugLine="trueKey = vkey.SubString2(4,4+len)";
Debug.ShouldStop(536870912);
_truekey = _vkey.substring((int) (4),(int) (4+_len));Debug.locals.put("trueKey", _truekey);
 BA.debugLineNum = 383;BA.debugLine="encrypted = EnkripDekrip(\"AES\", trueKey, \"MD5\", Text, \"Encode\")";
Debug.ShouldStop(1073741824);
_encrypted = _enkripdekrip(_ba,"AES",_truekey,"MD5",_text,"Encode");Debug.locals.put("encrypted", _encrypted);
 BA.debugLineNum = 384;BA.debugLine="wrapped = vkey & encrypted";
Debug.ShouldStop(-2147483648);
_wrapped = _vkey+_encrypted;Debug.locals.put("wrapped", _wrapped);
 BA.debugLineNum = 386;BA.debugLine="Return wrapped";
Debug.ShouldStop(2);
if (true) return _wrapped;
 BA.debugLineNum = 387;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}
