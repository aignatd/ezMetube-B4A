package metube.mncplaymedia.com;

import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class utama extends Activity implements B4AActivity{
	public static utama mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new BA(this.getApplicationContext(), null, null, "metube.mncplaymedia.com", "metube.mncplaymedia.com.utama");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (utama).");
				p.finish();
			}
		}
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
		BA.handler.postDelayed(new WaitForLayout(), 5);

	}
	private static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "metube.mncplaymedia.com", "metube.mncplaymedia.com.utama");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "metube.mncplaymedia.com.utama", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (utama) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (utama) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEvent(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return utama.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (utama) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (utama) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}

public anywheresoftware.b4a.keywords.Common __c = null;
public flm.b4a.betterdialogs.BetterDialogs _bdmain = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _svutama = null;
public static int _itampil = 0;
public anywheresoftware.b4a.objects.PanelWrapper _psemua = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ivmenu = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ivsearch = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ivclose = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ivsetting = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblbrowse = null;
public anywheresoftware.b4a.objects.ListViewWrapper _lvbrowse = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _svlist = null;
public anywheresoftware.b4a.objects.ListViewWrapper _lvvideo = null;
public anywheresoftware.b4a.objects.ListViewWrapper _lvcate = null;
public anywheresoftware.b4a.objects.ListViewWrapper _lvmanage = null;
public flm.media.browser.MediaBrowser _mb = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _picmusic = null;
public anywheresoftware.b4a.objects.collections.Map _mapcover = null;
public de.amberhome.viewpager.AHPageContainer _container = null;
public de.amberhome.viewpager.AHViewPager _pager = null;
public anywheresoftware.b4a.objects.PanelWrapper _pcoverflow = null;
public anywheresoftware.b4a.objects.Timer _tcover = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _picvideo = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _piclain = null;
public anywheresoftware.b4a.objects.collections.List _lstfilter = null;
public static int _currpage = 0;
public static int _arah = 0;
public anywheresoftware.b4a.objects.LabelWrapper _lblmost = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ivgaris = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ivgambar1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ivgambar4 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ivmore = null;
public static int _itampil1 = 0;
public static int _itampil2 = 0;
public anywheresoftware.b4a.objects.PanelWrapper _ptop = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etsearch = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbljudul1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbllogin = null;
public it.giuseppe.salvi.PhotoFlowActivity _coverflow = null;
public anywheresoftware.b4a.objects.ButtonWrapper _blogin = null;
public anywheresoftware.b4a.objects.ButtonWrapper _bmore = null;
public static int _pos_cflow = 0;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.Timer _timer_cflow = null;
public static int _a = 0;
public static int _b = 0;
public metube.mncplaymedia.com.main _main = null;
public metube.mncplaymedia.com.login _login = null;
public metube.mncplaymedia.com.register _register = null;
public metube.mncplaymedia.com.fungsi _fungsi = null;
public metube.mncplaymedia.com.mncutils2service _mncutils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"a",_a,"Activity",mostCurrent._activity,"arah",_arah,"b",_b,"BDMain",mostCurrent._bdmain,"bLogin",mostCurrent._blogin,"bMore",mostCurrent._bmore,"container",mostCurrent._container,"coverflow",mostCurrent._coverflow,"CurrPage",_currpage,"etSearch",mostCurrent._etsearch,"Fungsi",Debug.moduleToString(metube.mncplaymedia.com.fungsi.class),"iTampil",_itampil,"iTampil1",_itampil1,"iTampil2",_itampil2,"ivClose",mostCurrent._ivclose,"ivGambar1",mostCurrent._ivgambar1,"ivGambar4",mostCurrent._ivgambar4,"ivGaris",mostCurrent._ivgaris,"ivMenu",mostCurrent._ivmenu,"ivMore",mostCurrent._ivmore,"ivSearch",mostCurrent._ivsearch,"ivSetting",mostCurrent._ivsetting,"lblBrowse",mostCurrent._lblbrowse,"lblJudul1",mostCurrent._lbljudul1,"lblLogin",mostCurrent._lbllogin,"lblMost",mostCurrent._lblmost,"Login",Debug.moduleToString(metube.mncplaymedia.com.login.class),"lstFilter",mostCurrent._lstfilter,"lvBrowse",mostCurrent._lvbrowse,"lvCate",mostCurrent._lvcate,"lvManage",mostCurrent._lvmanage,"lvVideo",mostCurrent._lvvideo,"Main",Debug.moduleToString(metube.mncplaymedia.com.main.class),"mapCover",mostCurrent._mapcover,"MB",mostCurrent._mb,"MNCUtils2Service",Debug.moduleToString(metube.mncplaymedia.com.mncutils2service.class),"pager",mostCurrent._pager,"panel1",mostCurrent._panel1,"pCoverFlow",mostCurrent._pcoverflow,"picLain",mostCurrent._piclain,"picMusic",mostCurrent._picmusic,"picVideo",mostCurrent._picvideo,"pos_cflow",_pos_cflow,"pSemua",mostCurrent._psemua,"pTop",mostCurrent._ptop,"Register",Debug.moduleToString(metube.mncplaymedia.com.register.class),"svList",mostCurrent._svlist,"svUtama",mostCurrent._svutama,"tCover",mostCurrent._tcover,"timer_cflow",mostCurrent._timer_cflow};
}

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,65);
int _i = 0;
anywheresoftware.b4a.objects.PanelWrapper _panepg = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cdback = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _tombol = null;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 65;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 68;BA.debugLine="Activity.LoadLayout(\"Utama\")";
Debug.ShouldStop(8);
mostCurrent._activity.LoadLayout("Utama",mostCurrent.activityBA);
 BA.debugLineNum = 70;BA.debugLine="Fungsi.SetDirProg(\"\")";
Debug.ShouldStop(32);
mostCurrent._fungsi._setdirprog(mostCurrent.activityBA,"");
 BA.debugLineNum = 71;BA.debugLine="Fungsi.DataConfig.FolderDBS = Fungsi.DirDBS";
Debug.ShouldStop(64);
mostCurrent._fungsi._dataconfig.FolderDBS = mostCurrent._fungsi._dirdbs;
 BA.debugLineNum = 72;BA.debugLine="Fungsi.BacaFileConfig";
Debug.ShouldStop(128);
mostCurrent._fungsi._bacafileconfig(mostCurrent.activityBA);
 BA.debugLineNum = 74;BA.debugLine="MB.Initialize(\"MB\")";
Debug.ShouldStop(512);
mostCurrent._mb.Initialize(processBA,"MB");
 BA.debugLineNum = 75;BA.debugLine="mapCover.Initialize";
Debug.ShouldStop(1024);
mostCurrent._mapcover.Initialize();
 BA.debugLineNum = 77;BA.debugLine="If tCover.IsInitialized = False Then tCover.Initialize(\"tCover\", 1000)";
Debug.ShouldStop(4096);
if (mostCurrent._tcover.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
Debug.DebugWarningEngine.CheckInitialize(mostCurrent._tcover);mostCurrent._tcover.Initialize(processBA,"tCover",(long) (1000));};
 BA.debugLineNum = 78;BA.debugLine="tCover.Enabled = False";
Debug.ShouldStop(8192);
mostCurrent._tcover.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 BA.debugLineNum = 79;BA.debugLine="DoEvents";
Debug.ShouldStop(16384);
anywheresoftware.b4a.keywords.Common.DoEvents();
 BA.debugLineNum = 82;BA.debugLine="If File.Exists(File.DirAssets, \"config.json\") Then";
Debug.ShouldStop(131072);
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"config.json")) { 
 BA.debugLineNum = 83;BA.debugLine="If Fungsi.CacahJSON(File.ReadString(File.DirAssets, \"config.json\"), \"NextArray\") = False Then";
Debug.ShouldStop(262144);
if (mostCurrent._fungsi._cacahjson(mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"config.json"),"NextArray")==anywheresoftware.b4a.keywords.Common.False) { 
 BA.debugLineNum = 84;BA.debugLine="BDMain.Msgbox(Fungsi.TitleBox, Fungsi.InitFail, Fungsi.btnOK, \"\", \"\", Fungsi.GetDrawable(Fungsi.icWarning))";
Debug.ShouldStop(524288);
mostCurrent._bdmain.MsgBox(mostCurrent._fungsi._titlebox,mostCurrent._fungsi._initfail,mostCurrent._fungsi._btnok,"","",mostCurrent._fungsi._getdrawable(mostCurrent.activityBA,mostCurrent._fungsi._icwarning),mostCurrent.activityBA);
 BA.debugLineNum = 85;BA.debugLine="ExitApplication";
Debug.ShouldStop(1048576);
anywheresoftware.b4a.keywords.Common.ExitApplication();
 };
 }else {
 BA.debugLineNum = 88;BA.debugLine="BDMain.Msgbox(Fungsi.TitleBox, Fungsi.LoadFail, Fungsi.btnOK, \"\", \"\", Fungsi.GetDrawable(Fungsi.icWarning))";
Debug.ShouldStop(8388608);
mostCurrent._bdmain.MsgBox(mostCurrent._fungsi._titlebox,mostCurrent._fungsi._loadfail,mostCurrent._fungsi._btnok,"","",mostCurrent._fungsi._getdrawable(mostCurrent.activityBA,mostCurrent._fungsi._icwarning),mostCurrent.activityBA);
 BA.debugLineNum = 89;BA.debugLine="ExitApplication";
Debug.ShouldStop(16777216);
anywheresoftware.b4a.keywords.Common.ExitApplication();
 };
 BA.debugLineNum = 93;BA.debugLine="For i=0 To 2";
Debug.ShouldStop(268435456);
{
final int step68 = 1;
final int limit68 = (int) (2);
for (_i = (int) (0); (step68 > 0 && _i <= limit68) || (step68 < 0 && _i >= limit68); _i = ((int)(0 + _i + step68))) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 94;BA.debugLine="Dim PanEPG 		As Panel";
Debug.ShouldStop(536870912);
_panepg = new anywheresoftware.b4a.objects.PanelWrapper();Debug.locals.put("PanEPG", _panepg);
 BA.debugLineNum = 97;BA.debugLine="PanEPG.Initialize(\"\")";
Debug.ShouldStop(1);
_panepg.Initialize(mostCurrent.activityBA,"");
 BA.debugLineNum = 98;BA.debugLine="PanEPG.LoadLayout(\"smartphone\")";
Debug.ShouldStop(2);
_panepg.LoadLayout("smartphone",mostCurrent.activityBA);
 BA.debugLineNum = 100;BA.debugLine="svUtama.Panel.AddView(PanEPG,  0 , i * 100%y, svUtama.Width, 100%y)";
Debug.ShouldStop(8);
mostCurrent._svutama.getPanel().AddView((android.view.View)(_panepg.getObject()),(int) (0),(int) (_i*anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)),mostCurrent._svutama.getWidth(),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 BA.debugLineNum = 102;BA.debugLine="svUtama.Panel.Width  = 100%x";
Debug.ShouldStop(32);
mostCurrent._svutama.getPanel().setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 BA.debugLineNum = 103;BA.debugLine="svUtama.Panel.Height = 350%y";
Debug.ShouldStop(64);
mostCurrent._svutama.getPanel().setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (350),mostCurrent.activityBA));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 107;BA.debugLine="svList.Panel.LoadLayout(\"list\")";
Debug.ShouldStop(1024);
mostCurrent._svlist.getPanel().LoadLayout("list",mostCurrent.activityBA);
 BA.debugLineNum = 110;BA.debugLine="svList.Panel.Width  = 100%x";
Debug.ShouldStop(8192);
mostCurrent._svlist.getPanel().setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 BA.debugLineNum = 111;BA.debugLine="svList.Panel.Height = 120%y";
Debug.ShouldStop(16384);
mostCurrent._svlist.getPanel().setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (120),mostCurrent.activityBA));
 BA.debugLineNum = 114;BA.debugLine="Dim cdBack 	As ColorDrawable";
Debug.ShouldStop(131072);
_cdback = new anywheresoftware.b4a.objects.drawable.ColorDrawable();Debug.locals.put("cdBack", _cdback);
 BA.debugLineNum = 115;BA.debugLine="Dim tombol As ColorDrawable";
Debug.ShouldStop(262144);
_tombol = new anywheresoftware.b4a.objects.drawable.ColorDrawable();Debug.locals.put("tombol", _tombol);
 BA.debugLineNum = 116;BA.debugLine="cdBack.Initialize(Colors.RGB(238, 238, 238), 5)";
Debug.ShouldStop(524288);
_cdback.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (238),(int) (238),(int) (238)),(int) (5));
 BA.debugLineNum = 117;BA.debugLine="tombol.Initialize(Colors.RGB(243, 243, 243), 5)";
Debug.ShouldStop(1048576);
_tombol.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (243),(int) (243),(int) (243)),(int) (5));
 BA.debugLineNum = 118;BA.debugLine="etSearch.Background = cdBack";
Debug.ShouldStop(2097152);
mostCurrent._etsearch.setBackground((android.graphics.drawable.Drawable)(_cdback.getObject()));
 BA.debugLineNum = 119;BA.debugLine="bMore.Background = tombol";
Debug.ShouldStop(4194304);
mostCurrent._bmore.setBackground((android.graphics.drawable.Drawable)(_tombol.getObject()));
 BA.debugLineNum = 123;BA.debugLine="coverflow.InitializeCoverflow(\"coverflow\")";
Debug.ShouldStop(67108864);
mostCurrent._coverflow.InitializeCoverflow(mostCurrent.activityBA,"coverflow");
 BA.debugLineNum = 124;BA.debugLine="pCoverFlow.AddView(coverflow, 0%x, 0%y, 100%x, 100%y)";
Debug.ShouldStop(134217728);
mostCurrent._pcoverflow.AddView((android.view.View)(mostCurrent._coverflow.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 BA.debugLineNum = 125;BA.debugLine="coverflow.Width =100%x";
Debug.ShouldStop(268435456);
mostCurrent._coverflow.setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 BA.debugLineNum = 126;BA.debugLine="coverflow.Height=30%y";
Debug.ShouldStop(536870912);
mostCurrent._coverflow.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (30),mostCurrent.activityBA));
 BA.debugLineNum = 127;BA.debugLine="coverflow.Left=0%x";
Debug.ShouldStop(1073741824);
mostCurrent._coverflow.setLeft(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 BA.debugLineNum = 128;BA.debugLine="coverflow.Top=0%x";
Debug.ShouldStop(-2147483648);
mostCurrent._coverflow.setTop(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA));
 BA.debugLineNum = 129;BA.debugLine="coverflow.Spacing= -400";
Debug.ShouldStop(1);
mostCurrent._coverflow.setSpacing((int) (-400));
 BA.debugLineNum = 130;BA.debugLine="coverflow.ItemWidth = pCoverFlow.Width + 5%y";
Debug.ShouldStop(2);
mostCurrent._coverflow.setItemWidth((int) (mostCurrent._pcoverflow.getWidth()+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (5),mostCurrent.activityBA)));
 BA.debugLineNum = 131;BA.debugLine="coverflow.ItemHeight = pCoverFlow.Height + 20%y";
Debug.ShouldStop(4);
mostCurrent._coverflow.setItemHeight((int) (mostCurrent._pcoverflow.getHeight()+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA)));
 BA.debugLineNum = 132;BA.debugLine="coverflow.AnimationDuration=1500";
Debug.ShouldStop(8);
mostCurrent._coverflow.setAnimationDuration((int) (1500));
 BA.debugLineNum = 133;BA.debugLine="coverflow.FadingEdgeLength=0";
Debug.ShouldStop(16);
mostCurrent._coverflow.setFadingEdgeLength((int) (0));
 BA.debugLineNum = 134;BA.debugLine="coverflow.Carousel=False";
Debug.ShouldStop(32);
mostCurrent._coverflow.setCarousel(anywheresoftware.b4a.keywords.Common.False);
 BA.debugLineNum = 135;BA.debugLine="coverflow.Reverse=False";
Debug.ShouldStop(64);
mostCurrent._coverflow.setReverse(anywheresoftware.b4a.keywords.Common.False);
 BA.debugLineNum = 137;BA.debugLine="coverflow.PopulatePhotoFlowFromAssets(\"a\")";
Debug.ShouldStop(256);
mostCurrent._coverflow.PopulatePhotoFlowFromAssets("a");
 BA.debugLineNum = 138;BA.debugLine="coverflow.AddImageAt(0, File.DirAssets, \"okezone.jpg\")";
Debug.ShouldStop(512);
mostCurrent._coverflow.AddImageAt((int) (0),anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"okezone.jpg");
 BA.debugLineNum = 139;BA.debugLine="coverflow.AddImageAt(1, File.DirAssets, \"mnc.jpg\")";
Debug.ShouldStop(1024);
mostCurrent._coverflow.AddImageAt((int) (1),anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"mnc.jpg");
 BA.debugLineNum = 140;BA.debugLine="coverflow.AddImageAt(2, File.DirAssets, \"moviebay.png\")";
Debug.ShouldStop(2048);
mostCurrent._coverflow.AddImageAt((int) (2),anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"moviebay.png");
 BA.debugLineNum = 147;BA.debugLine="ivMenu.Background = Fungsi.GetDrawable(Fungsi.icMenuPilih)";
Debug.ShouldStop(262144);
mostCurrent._ivmenu.setBackground((android.graphics.drawable.Drawable)(mostCurrent._fungsi._getdrawable(mostCurrent.activityBA,mostCurrent._fungsi._icmenupilih)));
 BA.debugLineNum = 148;BA.debugLine="ivSearch.Background = Fungsi.GetDrawable(Fungsi.iccaridata)";
Debug.ShouldStop(524288);
mostCurrent._ivsearch.setBackground((android.graphics.drawable.Drawable)(mostCurrent._fungsi._getdrawable(mostCurrent.activityBA,mostCurrent._fungsi._iccaridata)));
 BA.debugLineNum = 150;BA.debugLine="ivClose.Background = Fungsi.GetDrawable(Fungsi.icTutup)";
Debug.ShouldStop(2097152);
mostCurrent._ivclose.setBackground((android.graphics.drawable.Drawable)(mostCurrent._fungsi._getdrawable(mostCurrent.activityBA,mostCurrent._fungsi._ictutup)));
 BA.debugLineNum = 151;BA.debugLine="ivSetting.Background = Fungsi.GetDrawable(Fungsi.icSetting)";
Debug.ShouldStop(4194304);
mostCurrent._ivsetting.setBackground((android.graphics.drawable.Drawable)(mostCurrent._fungsi._getdrawable(mostCurrent.activityBA,mostCurrent._fungsi._icsetting)));
 BA.debugLineNum = 158;BA.debugLine="init_Browse";
Debug.ShouldStop(536870912);
_init_browse();
 BA.debugLineNum = 159;BA.debugLine="DoEvents";
Debug.ShouldStop(1073741824);
anywheresoftware.b4a.keywords.Common.DoEvents();
 BA.debugLineNum = 160;BA.debugLine="init_Video";
Debug.ShouldStop(-2147483648);
_init_video();
 BA.debugLineNum = 161;BA.debugLine="DoEvents";
Debug.ShouldStop(1);
anywheresoftware.b4a.keywords.Common.DoEvents();
 BA.debugLineNum = 162;BA.debugLine="init_Category";
Debug.ShouldStop(2);
_init_category();
 BA.debugLineNum = 163;BA.debugLine="DoEvents";
Debug.ShouldStop(4);
anywheresoftware.b4a.keywords.Common.DoEvents();
 BA.debugLineNum = 164;BA.debugLine="init_Media";
Debug.ShouldStop(8);
_init_media();
 BA.debugLineNum = 165;BA.debugLine="DoEvents";
Debug.ShouldStop(16);
anywheresoftware.b4a.keywords.Common.DoEvents();
 BA.debugLineNum = 168;BA.debugLine="DoEvents";
Debug.ShouldStop(128);
anywheresoftware.b4a.keywords.Common.DoEvents();
 BA.debugLineNum = 169;BA.debugLine="ProsesCoverFlowStorage";
Debug.ShouldStop(256);
_prosescoverflowstorage();
 BA.debugLineNum = 170;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static boolean  _activity_keypress(int _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,195);
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 195;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean 'return true if you want To consume the event";
Debug.ShouldStop(4);
 BA.debugLineNum = 196;BA.debugLine="If KeyCode = 4 Then";
Debug.ShouldStop(8);
if (_keycode==4) { 
 BA.debugLineNum = 199;BA.debugLine="If BDMain.Msgbox(Fungsi.TitleBox, Fungsi.lblExit, Fungsi.btnOK, Fungsi.btnNO, \"\", Fungsi.GetDrawable(\"ic_action_warning\")) = DialogResponse.POSITIVE Then";
Debug.ShouldStop(64);
if (mostCurrent._bdmain.MsgBox(mostCurrent._fungsi._titlebox,mostCurrent._fungsi._lblexit,mostCurrent._fungsi._btnok,mostCurrent._fungsi._btnno,"",mostCurrent._fungsi._getdrawable(mostCurrent.activityBA,"ic_action_warning"),mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 BA.debugLineNum = 200;BA.debugLine="ExitApplication";
Debug.ShouldStop(128);
anywheresoftware.b4a.keywords.Common.ExitApplication();
 };
 BA.debugLineNum = 203;BA.debugLine="Return True";
Debug.ShouldStop(1024);
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 BA.debugLineNum = 205;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return false;
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _activity_pause(boolean _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,176);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 176;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 178;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,172);
 BA.debugLineNum = 172;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2048);
 BA.debugLineNum = 174;BA.debugLine="End Sub";
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
public static String  _bmore_click() throws Exception{
try {
		Debug.PushSubsStack("bMore_Click (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,405);
 BA.debugLineNum = 405;BA.debugLine="Sub bMore_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 407;BA.debugLine="End Sub";
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
public static String  _coverflow_itemclick(int _position,Object _value) throws Exception{
try {
		Debug.PushSubsStack("Coverflow_ItemClick (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,408);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 408;BA.debugLine="Sub Coverflow_ItemClick(Position As Int, Value As Object)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 410;BA.debugLine="coverflow.GetItem(b)";
Debug.ShouldStop(33554432);
mostCurrent._coverflow.GetItem(_b);
 BA.debugLineNum = 412;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _coverflow_itemselected(int _position,Object _value) throws Exception{
try {
		Debug.PushSubsStack("Coverflow_ItemSelected (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,431);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 431;BA.debugLine="Sub Coverflow_ItemSelected(Position As Int, Value As Object)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 433;BA.debugLine="b = Position";
Debug.ShouldStop(65536);
_b = _position;
 BA.debugLineNum = 434;BA.debugLine="timer_cflow.Initialize(\"timer_cflow\", 1000)";
Debug.ShouldStop(131072);
Debug.DebugWarningEngine.CheckInitialize(mostCurrent._timer_cflow);mostCurrent._timer_cflow.Initialize(processBA,"timer_cflow",(long) (1000));
 BA.debugLineNum = 435;BA.debugLine="timer_cflow.Enabled=True";
Debug.ShouldStop(262144);
mostCurrent._timer_cflow.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 BA.debugLineNum = 436;BA.debugLine="End Sub";
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
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private BDMain			As BetterDialogs";
mostCurrent._bdmain = new flm.b4a.betterdialogs.BetterDialogs();
 //BA.debugLineNum = 17;BA.debugLine="Private svUtama 		As ScrollView";
mostCurrent._svutama = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private iTampil 		As Int=0";
_itampil = (int) (0);
 //BA.debugLineNum = 19;BA.debugLine="Private pSemua 			As Panel";
mostCurrent._psemua = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private ivMenu 			As ImageView";
mostCurrent._ivmenu = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private ivSearch	 	As ImageView";
mostCurrent._ivsearch = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private ivClose 		As ImageView";
mostCurrent._ivclose = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private ivSetting 		As ImageView";
mostCurrent._ivsetting = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private lblBrowse 		As Label";
mostCurrent._lblbrowse = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private lvBrowse 		As ListView";
mostCurrent._lvbrowse = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private svList 			As ScrollView";
mostCurrent._svlist = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private lvVideo 		As ListView";
mostCurrent._lvvideo = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private lvCate 			As ListView";
mostCurrent._lvcate = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private lvManage 		As ListView";
mostCurrent._lvmanage = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Private MB 				As MediaBrowser";
mostCurrent._mb = new flm.media.browser.MediaBrowser();
 //BA.debugLineNum = 31;BA.debugLine="Private picMusic		As Bitmap";
mostCurrent._picmusic = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private mapCover		As Map";
mostCurrent._mapcover = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 33;BA.debugLine="Private container 		As AHPageContainer";
mostCurrent._container = new de.amberhome.viewpager.AHPageContainer();
 //BA.debugLineNum = 34;BA.debugLine="Private pager 			As AHViewPager";
mostCurrent._pager = new de.amberhome.viewpager.AHViewPager();
 //BA.debugLineNum = 35;BA.debugLine="Private pCoverFlow 		As Panel";
mostCurrent._pcoverflow = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private tCover			As Timer";
mostCurrent._tcover = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 37;BA.debugLine="Private picMusic		As Bitmap";
mostCurrent._picmusic = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private picVideo		As Bitmap";
mostCurrent._picvideo = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 39;BA.debugLine="Private picLain			As Bitmap";
mostCurrent._piclain = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 40;BA.debugLine="Private lstFilter 		As List";
mostCurrent._lstfilter = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 41;BA.debugLine="Private CurrPage 		As Int = 0";
_currpage = (int) (0);
 //BA.debugLineNum = 42;BA.debugLine="Private arah			As Int = 0";
_arah = (int) (0);
 //BA.debugLineNum = 44;BA.debugLine="Private lblMost 		As Label";
mostCurrent._lblmost = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private ivGaris 		As ImageView";
mostCurrent._ivgaris = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private ivGambar1 		As ImageView";
mostCurrent._ivgambar1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 47;BA.debugLine="Private ivGambar4 		As ImageView";
mostCurrent._ivgambar4 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Private ivMore 			As ImageView";
mostCurrent._ivmore = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Private iTampil1 		As Int=0";
_itampil1 = (int) (0);
 //BA.debugLineNum = 50;BA.debugLine="Private iTampil2 		As Int=0";
_itampil2 = (int) (0);
 //BA.debugLineNum = 51;BA.debugLine="Private pTop 			As Panel";
mostCurrent._ptop = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 52;BA.debugLine="Private etSearch 		As EditText";
mostCurrent._etsearch = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 53;BA.debugLine="Private lblJudul1 		As Label";
mostCurrent._lbljudul1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 54;BA.debugLine="Private lblLogin  		As Label";
mostCurrent._lbllogin = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 56;BA.debugLine="Dim coverflow 		As PhotoFlow";
mostCurrent._coverflow = new it.giuseppe.salvi.PhotoFlowActivity();
 //BA.debugLineNum = 57;BA.debugLine="Private bLogin 		As Button";
mostCurrent._blogin = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 58;BA.debugLine="Private bMore 		As Button";
mostCurrent._bmore = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Dim pos_cflow 		As Int";
_pos_cflow = 0;
 //BA.debugLineNum = 60;BA.debugLine="Dim panel1 			As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Dim timer_cflow		As Timer";
mostCurrent._timer_cflow = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 62;BA.debugLine="Dim a, b			As Int";
_a = 0;
_b = 0;
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public static String  _init_browse() throws Exception{
try {
		Debug.PushSubsStack("init_Browse (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,206);
 BA.debugLineNum = 206;BA.debugLine="Sub init_Browse";
Debug.ShouldStop(8192);
 BA.debugLineNum = 212;BA.debugLine="lvBrowse.Clear";
Debug.ShouldStop(524288);
mostCurrent._lvbrowse.Clear();
 BA.debugLineNum = 213;BA.debugLine="Fungsi.SetDivider(lvBrowse, Colors.Transparent, 1dip)";
Debug.ShouldStop(1048576);
mostCurrent._fungsi._setdivider(mostCurrent.activityBA,mostCurrent._lvbrowse,anywheresoftware.b4a.keywords.Common.Colors.Transparent,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)));
 BA.debugLineNum = 215;BA.debugLine="lvBrowse.FastScrollEnabled = False";
Debug.ShouldStop(4194304);
mostCurrent._lvbrowse.setFastScrollEnabled(anywheresoftware.b4a.keywords.Common.False);
 BA.debugLineNum = 217;BA.debugLine="lvBrowse.AddTwoLinesAndBitmap(\"Channel\", \"\", LoadBitmap(File.DirAssets,(\"movie44.png\")))";
Debug.ShouldStop(16777216);
mostCurrent._lvbrowse.AddTwoLinesAndBitmap("Channel","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),("movie44.png")).getObject()));
 BA.debugLineNum = 218;BA.debugLine="lvBrowse.AddTwoLinesAndBitmap(\"Sub Channel\", \"\", LoadBitmap(File.DirAssets,(\"movie44.png\")))";
Debug.ShouldStop(33554432);
mostCurrent._lvbrowse.AddTwoLinesAndBitmap("Sub Channel","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),("movie44.png")).getObject()));
 BA.debugLineNum = 219;BA.debugLine="lvBrowse.AddTwoLinesAndBitmap(\"Top Uploader\", \"\", LoadBitmap(File.DirAssets,(\"movie44.png\")))";
Debug.ShouldStop(67108864);
mostCurrent._lvbrowse.AddTwoLinesAndBitmap("Top Uploader","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),("movie44.png")).getObject()));
 BA.debugLineNum = 221;BA.debugLine="lvBrowse.TwoLinesAndBitmap.Label.TextColor = Colors.White";
Debug.ShouldStop(268435456);
mostCurrent._lvbrowse.getTwoLinesAndBitmap().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 BA.debugLineNum = 222;BA.debugLine="lvBrowse.TwoLinesAndBitmap.Label.TextSize = 15";
Debug.ShouldStop(536870912);
mostCurrent._lvbrowse.getTwoLinesAndBitmap().Label.setTextSize((float) (15));
 BA.debugLineNum = 223;BA.debugLine="lvBrowse.TwoLinesAndBitmap.Label.Gravity = Gravity.FILL";
Debug.ShouldStop(1073741824);
mostCurrent._lvbrowse.getTwoLinesAndBitmap().Label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 BA.debugLineNum = 224;BA.debugLine="lvBrowse.TwoLinesAndBitmap.ImageView.Height = 18dip";
Debug.ShouldStop(-2147483648);
mostCurrent._lvbrowse.getTwoLinesAndBitmap().ImageView.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (18)));
 BA.debugLineNum = 225;BA.debugLine="lvBrowse.TwoLinesAndBitmap.ImageView.Width = 18dip";
Debug.ShouldStop(1);
mostCurrent._lvbrowse.getTwoLinesAndBitmap().ImageView.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (18)));
 BA.debugLineNum = 226;BA.debugLine="lvBrowse.TwoLinesAndBitmap.ItemHeight = 30dip";
Debug.ShouldStop(2);
mostCurrent._lvbrowse.getTwoLinesAndBitmap().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
 BA.debugLineNum = 239;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _init_category() throws Exception{
try {
		Debug.PushSubsStack("init_Category (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,271);
 BA.debugLineNum = 271;BA.debugLine="Sub init_Category";
Debug.ShouldStop(16384);
 BA.debugLineNum = 277;BA.debugLine="lvCate.Clear";
Debug.ShouldStop(1048576);
mostCurrent._lvcate.Clear();
 BA.debugLineNum = 278;BA.debugLine="Fungsi.SetDivider(lvCate, Colors.Transparent, 1dip)";
Debug.ShouldStop(2097152);
mostCurrent._fungsi._setdivider(mostCurrent.activityBA,mostCurrent._lvcate,anywheresoftware.b4a.keywords.Common.Colors.Transparent,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)));
 BA.debugLineNum = 280;BA.debugLine="lvCate.FastScrollEnabled = False";
Debug.ShouldStop(8388608);
mostCurrent._lvcate.setFastScrollEnabled(anywheresoftware.b4a.keywords.Common.False);
 BA.debugLineNum = 282;BA.debugLine="lvCate.AddTwoLinesAndBitmap(\"General\", \"\", LoadBitmap(File.DirAssets,(\"square234.png\")))";
Debug.ShouldStop(33554432);
mostCurrent._lvcate.AddTwoLinesAndBitmap("General","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),("square234.png")).getObject()));
 BA.debugLineNum = 283;BA.debugLine="lvCate.AddTwoLinesAndBitmap(\"Music\", \"\", LoadBitmap(File.DirAssets,(\"note55.png\")))";
Debug.ShouldStop(67108864);
mostCurrent._lvcate.AddTwoLinesAndBitmap("Music","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),("note55.png")).getObject()));
 BA.debugLineNum = 284;BA.debugLine="lvCate.AddTwoLinesAndBitmap(\"Autos & Vehicles\", \"\", LoadBitmap(File.DirAssets,(\"road22.png\")))";
Debug.ShouldStop(134217728);
mostCurrent._lvcate.AddTwoLinesAndBitmap("Autos & Vehicles","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),("road22.png")).getObject()));
 BA.debugLineNum = 285;BA.debugLine="lvCate.AddTwoLinesAndBitmap(\"Education\", \"\", LoadBitmap(File.DirAssets,(\"draw21.png\")))";
Debug.ShouldStop(268435456);
mostCurrent._lvcate.AddTwoLinesAndBitmap("Education","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),("draw21.png")).getObject()));
 BA.debugLineNum = 286;BA.debugLine="lvCate.AddTwoLinesAndBitmap(\"Entertainment\", \"\", LoadBitmap(File.DirAssets,(\"camera2.png\")))";
Debug.ShouldStop(536870912);
mostCurrent._lvcate.AddTwoLinesAndBitmap("Entertainment","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),("camera2.png")).getObject()));
 BA.debugLineNum = 287;BA.debugLine="lvCate.AddTwoLinesAndBitmap(\"Gaming\", \"\", LoadBitmap(File.DirAssets,(\"controller2.png\")))";
Debug.ShouldStop(1073741824);
mostCurrent._lvcate.AddTwoLinesAndBitmap("Gaming","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),("controller2.png")).getObject()));
 BA.debugLineNum = 288;BA.debugLine="lvCate.AddTwoLinesAndBitmap(\"Fashion & Beauty\", \"\", LoadBitmap(File.DirAssets,(\"controller2.png\")))";
Debug.ShouldStop(-2147483648);
mostCurrent._lvcate.AddTwoLinesAndBitmap("Fashion & Beauty","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),("controller2.png")).getObject()));
 BA.debugLineNum = 290;BA.debugLine="lvCate.TwoLinesAndBitmap.Label.TextColor = Colors.White";
Debug.ShouldStop(2);
mostCurrent._lvcate.getTwoLinesAndBitmap().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 BA.debugLineNum = 291;BA.debugLine="lvCate.TwoLinesAndBitmap.Label.TextSize = 15";
Debug.ShouldStop(4);
mostCurrent._lvcate.getTwoLinesAndBitmap().Label.setTextSize((float) (15));
 BA.debugLineNum = 292;BA.debugLine="lvCate.TwoLinesAndBitmap.Label.Gravity = Gravity.FILL";
Debug.ShouldStop(8);
mostCurrent._lvcate.getTwoLinesAndBitmap().Label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 BA.debugLineNum = 293;BA.debugLine="lvCate.TwoLinesAndBitmap.ImageView.Height = 16dip";
Debug.ShouldStop(16);
mostCurrent._lvcate.getTwoLinesAndBitmap().ImageView.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (16)));
 BA.debugLineNum = 294;BA.debugLine="lvCate.TwoLinesAndBitmap.ImageView.Width = 16dip";
Debug.ShouldStop(32);
mostCurrent._lvcate.getTwoLinesAndBitmap().ImageView.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (16)));
 BA.debugLineNum = 295;BA.debugLine="lvCate.TwoLinesAndBitmap.ItemHeight = 30dip";
Debug.ShouldStop(64);
mostCurrent._lvcate.getTwoLinesAndBitmap().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
 BA.debugLineNum = 305;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _init_media() throws Exception{
try {
		Debug.PushSubsStack("init_Media (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,306);
 BA.debugLineNum = 306;BA.debugLine="Sub init_Media";
Debug.ShouldStop(131072);
 BA.debugLineNum = 312;BA.debugLine="lvManage.Clear";
Debug.ShouldStop(8388608);
mostCurrent._lvmanage.Clear();
 BA.debugLineNum = 313;BA.debugLine="Fungsi.SetDivider(lvManage, Colors.Transparent, 1dip)";
Debug.ShouldStop(16777216);
mostCurrent._fungsi._setdivider(mostCurrent.activityBA,mostCurrent._lvmanage,anywheresoftware.b4a.keywords.Common.Colors.Transparent,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)));
 BA.debugLineNum = 315;BA.debugLine="lvManage.FastScrollEnabled = False";
Debug.ShouldStop(67108864);
mostCurrent._lvmanage.setFastScrollEnabled(anywheresoftware.b4a.keywords.Common.False);
 BA.debugLineNum = 317;BA.debugLine="lvManage.AddTwoLinesAndBitmap(\"Upload Video\", \"\", LoadBitmap(File.DirAssets,(\"up_arrows16.png\")))";
Debug.ShouldStop(268435456);
mostCurrent._lvmanage.AddTwoLinesAndBitmap("Upload Video","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),("up_arrows16.png")).getObject()));
 BA.debugLineNum = 318;BA.debugLine="lvManage.AddTwoLinesAndBitmap(\"My Videos\", \"\", LoadBitmap(File.DirAssets,(\"start3.png\")))";
Debug.ShouldStop(536870912);
mostCurrent._lvmanage.AddTwoLinesAndBitmap("My Videos","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),("start3.png")).getObject()));
 BA.debugLineNum = 319;BA.debugLine="lvManage.AddTwoLinesAndBitmap(\"My Playlits\", \"\", LoadBitmap(File.DirAssets,(\"road22.png\")))";
Debug.ShouldStop(1073741824);
mostCurrent._lvmanage.AddTwoLinesAndBitmap("My Playlits","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),("road22.png")).getObject()));
 BA.debugLineNum = 320;BA.debugLine="lvManage.AddTwoLinesAndBitmap(\"My Channel\", \"\", LoadBitmap(File.DirAssets,(\"movie44.png\")))";
Debug.ShouldStop(-2147483648);
mostCurrent._lvmanage.AddTwoLinesAndBitmap("My Channel","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),("movie44.png")).getObject()));
 BA.debugLineNum = 321;BA.debugLine="lvManage.AddTwoLinesAndBitmap(\"My Subcription\", \"\", LoadBitmap(File.DirAssets,(\"wifi-signal1.png\")))";
Debug.ShouldStop(1);
mostCurrent._lvmanage.AddTwoLinesAndBitmap("My Subcription","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),("wifi-signal1.png")).getObject()));
 BA.debugLineNum = 322;BA.debugLine="lvManage.AddTwoLinesAndBitmap(\"Subcribers\", \"\", LoadBitmap(File.DirAssets,(\"favorite21.png\")))";
Debug.ShouldStop(2);
mostCurrent._lvmanage.AddTwoLinesAndBitmap("Subcribers","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),("favorite21.png")).getObject()));
 BA.debugLineNum = 324;BA.debugLine="lvManage.TwoLinesAndBitmap.Label.TextColor = Colors.White";
Debug.ShouldStop(8);
mostCurrent._lvmanage.getTwoLinesAndBitmap().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 BA.debugLineNum = 325;BA.debugLine="lvManage.TwoLinesAndBitmap.Label.TextSize = 15";
Debug.ShouldStop(16);
mostCurrent._lvmanage.getTwoLinesAndBitmap().Label.setTextSize((float) (15));
 BA.debugLineNum = 326;BA.debugLine="lvManage.TwoLinesAndBitmap.Label.Gravity = Gravity.FILL";
Debug.ShouldStop(32);
mostCurrent._lvmanage.getTwoLinesAndBitmap().Label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 BA.debugLineNum = 327;BA.debugLine="lvManage.TwoLinesAndBitmap.ImageView.Height = 16dip";
Debug.ShouldStop(64);
mostCurrent._lvmanage.getTwoLinesAndBitmap().ImageView.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (16)));
 BA.debugLineNum = 328;BA.debugLine="lvManage.TwoLinesAndBitmap.ImageView.Width = 16dip";
Debug.ShouldStop(128);
mostCurrent._lvmanage.getTwoLinesAndBitmap().ImageView.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (16)));
 BA.debugLineNum = 329;BA.debugLine="lvManage.TwoLinesAndBitmap.ItemHeight = 30dip";
Debug.ShouldStop(256);
mostCurrent._lvmanage.getTwoLinesAndBitmap().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
 BA.debugLineNum = 339;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _init_video() throws Exception{
try {
		Debug.PushSubsStack("init_Video (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,240);
 BA.debugLineNum = 240;BA.debugLine="Sub init_Video";
Debug.ShouldStop(32768);
 BA.debugLineNum = 246;BA.debugLine="lvVideo.Clear";
Debug.ShouldStop(2097152);
mostCurrent._lvvideo.Clear();
 BA.debugLineNum = 247;BA.debugLine="Fungsi.SetDivider(lvVideo, Colors.Transparent, 1dip)";
Debug.ShouldStop(4194304);
mostCurrent._fungsi._setdivider(mostCurrent.activityBA,mostCurrent._lvvideo,anywheresoftware.b4a.keywords.Common.Colors.Transparent,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)));
 BA.debugLineNum = 249;BA.debugLine="lvVideo.FastScrollEnabled = False";
Debug.ShouldStop(16777216);
mostCurrent._lvvideo.setFastScrollEnabled(anywheresoftware.b4a.keywords.Common.False);
 BA.debugLineNum = 251;BA.debugLine="lvVideo.AddTwoLinesAndBitmap(\"Watch to Watch\", \"\", LoadBitmap(File.DirAssets,(\"bright2.png\")))";
Debug.ShouldStop(67108864);
mostCurrent._lvvideo.AddTwoLinesAndBitmap("Watch to Watch","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),("bright2.png")).getObject()));
 BA.debugLineNum = 252;BA.debugLine="lvVideo.AddTwoLinesAndBitmap(\"Most Popular\", \"\", LoadBitmap(File.DirAssets,(\"soccer-cup.png\")))";
Debug.ShouldStop(134217728);
mostCurrent._lvvideo.AddTwoLinesAndBitmap("Most Popular","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),("soccer-cup.png")).getObject()));
 BA.debugLineNum = 255;BA.debugLine="lvVideo.TwoLinesAndBitmap.Label.TextColor = Colors.White";
Debug.ShouldStop(1073741824);
mostCurrent._lvvideo.getTwoLinesAndBitmap().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 BA.debugLineNum = 256;BA.debugLine="lvVideo.TwoLinesAndBitmap.Label.TextSize = 15";
Debug.ShouldStop(-2147483648);
mostCurrent._lvvideo.getTwoLinesAndBitmap().Label.setTextSize((float) (15));
 BA.debugLineNum = 257;BA.debugLine="lvVideo.TwoLinesAndBitmap.Label.Gravity = Gravity.FILL";
Debug.ShouldStop(1);
mostCurrent._lvvideo.getTwoLinesAndBitmap().Label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 BA.debugLineNum = 258;BA.debugLine="lvVideo.TwoLinesAndBitmap.ImageView.Height = 20dip";
Debug.ShouldStop(2);
mostCurrent._lvvideo.getTwoLinesAndBitmap().ImageView.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 BA.debugLineNum = 259;BA.debugLine="lvVideo.TwoLinesAndBitmap.ImageView.Width = 20dip";
Debug.ShouldStop(4);
mostCurrent._lvvideo.getTwoLinesAndBitmap().ImageView.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 BA.debugLineNum = 260;BA.debugLine="lvVideo.TwoLinesAndBitmap.ItemHeight = 30dip";
Debug.ShouldStop(8);
mostCurrent._lvvideo.getTwoLinesAndBitmap().setItemHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
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
public static String  _ivclose_click() throws Exception{
try {
		Debug.PushSubsStack("ivClose_Click (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,343);
 BA.debugLineNum = 343;BA.debugLine="Sub ivClose_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 344;BA.debugLine="Activity_KeyPress(4)";
Debug.ShouldStop(8388608);
_activity_keypress((int) (4));
 BA.debugLineNum = 345;BA.debugLine="End Sub";
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
public static String  _ivmenu_click() throws Exception{
try {
		Debug.PushSubsStack("ivMenu_Click (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,179);
 BA.debugLineNum = 179;BA.debugLine="Sub ivMenu_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 180;BA.debugLine="Slide_Menu";
Debug.ShouldStop(524288);
_slide_menu();
 BA.debugLineNum = 181;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _ivsearch_click() throws Exception{
try {
		Debug.PushSubsStack("ivSearch_Click (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,373);
 BA.debugLineNum = 373;BA.debugLine="Sub ivSearch_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 374;BA.debugLine="If iTampil2 = 0 Then";
Debug.ShouldStop(2097152);
if (_itampil2==0) { 
 BA.debugLineNum = 375;BA.debugLine="iTampil2 = 1";
Debug.ShouldStop(4194304);
_itampil2 = (int) (1);
 BA.debugLineNum = 376;BA.debugLine="etSearch.SetLayoutAnimated(500, 0, 10%y, pTop.Width, 18%y - pTop.Height)";
Debug.ShouldStop(8388608);
mostCurrent._etsearch.SetLayoutAnimated((int) (500),(int) (0),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (10),mostCurrent.activityBA),mostCurrent._ptop.getWidth(),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (18),mostCurrent.activityBA)-mostCurrent._ptop.getHeight()));
 }else {
 BA.debugLineNum = 378;BA.debugLine="iTampil2 = 0";
Debug.ShouldStop(33554432);
_itampil2 = (int) (0);
 BA.debugLineNum = 379;BA.debugLine="etSearch.SetLayoutAnimated(500, 0, pTop.Height, pTop.Width, 0)";
Debug.ShouldStop(67108864);
mostCurrent._etsearch.SetLayoutAnimated((int) (500),(int) (0),mostCurrent._ptop.getHeight(),mostCurrent._ptop.getWidth(),(int) (0));
 };
 BA.debugLineNum = 381;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _ivsetting_click() throws Exception{
try {
		Debug.PushSubsStack("ivSetting_Click (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,340);
 BA.debugLineNum = 340;BA.debugLine="Sub ivSetting_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 342;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _jobdone(metube.mncplaymedia.com.mnchttpjob _mnchttp) throws Exception{
try {
		Debug.PushSubsStack("JobDone (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,458);
adr.stringfunctions.stringfunctions _sf = null;
String _stmp = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _mresult = null;
byte[] _btmp = null;
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bctmp = null;
anywheresoftware.b4a.objects.StringUtils _su = null;
Debug.locals.put("MNChttp", _mnchttp);
 BA.debugLineNum = 458;BA.debugLine="Sub JobDone (MNChttp As MNChttpjob)";
Debug.ShouldStop(512);
 BA.debugLineNum = 459;BA.debugLine="Dim sf			As StringFunctions";
Debug.ShouldStop(1024);
_sf = new adr.stringfunctions.stringfunctions();Debug.locals.put("sf", _sf);
 BA.debugLineNum = 460;BA.debugLine="Dim sTmp 		As String";
Debug.ShouldStop(2048);
_stmp = "";Debug.locals.put("sTmp", _stmp);
 BA.debugLineNum = 461;BA.debugLine="Dim parser 		As JSONParser";
Debug.ShouldStop(4096);
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();Debug.locals.put("parser", _parser);
 BA.debugLineNum = 462;BA.debugLine="Dim mresult		As Map";
Debug.ShouldStop(8192);
_mresult = new anywheresoftware.b4a.objects.collections.Map();Debug.locals.put("mresult", _mresult);
 BA.debugLineNum = 463;BA.debugLine="Dim bTmp()		As Byte";
Debug.ShouldStop(16384);
_btmp = new byte[(int) (0)];
;Debug.locals.put("bTmp", _btmp);
 BA.debugLineNum = 464;BA.debugLine="Dim bcTmp		As ByteConverter";
Debug.ShouldStop(32768);
_bctmp = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();Debug.locals.put("bcTmp", _bctmp);
 BA.debugLineNum = 465;BA.debugLine="Dim su 			As StringUtils";
Debug.ShouldStop(65536);
_su = new anywheresoftware.b4a.objects.StringUtils();Debug.locals.put("su", _su);
 BA.debugLineNum = 467;BA.debugLine="Log((MNChttp.GetString))";
Debug.ShouldStop(262144);
anywheresoftware.b4a.keywords.Common.Log((_mnchttp._getstring()));
 BA.debugLineNum = 469;BA.debugLine="If MNChttp.Success = False Then";
Debug.ShouldStop(1048576);
if (_mnchttp._success==anywheresoftware.b4a.keywords.Common.False) { 
 BA.debugLineNum = 470;BA.debugLine="If (sf.InString(MNChttp.ErrorMessage, \"timed out\") > 0) OR (sf.InString(MNChttp.ErrorMessage, \"refused\") > 0) OR _ 			 (sf.InString(MNChttp.ErrorMessage, \"Unable to resolve host\") > 0) OR (sf.InString(MNChttp.ErrorMessage, \"UnknownHostException\") > 0) OR _ 			 (sf.InString(MNChttp.ErrorMessage, \"FileNotFound\") > 0) Then";
Debug.ShouldStop(2097152);
if ((_sf._vvv4(_mnchttp._errormessage,"timed out")>0) || (_sf._vvv4(_mnchttp._errormessage,"refused")>0) || (_sf._vvv4(_mnchttp._errormessage,"Unable to resolve host")>0) || (_sf._vvv4(_mnchttp._errormessage,"UnknownHostException")>0) || (_sf._vvv4(_mnchttp._errormessage,"FileNotFound")>0)) { 
 BA.debugLineNum = 474;BA.debugLine="Msgbox2(\"Offline Connection or Server Down\", \"MeTube\", \"OK\", \"\", \"\", LoadBitmap(File.DirAssets, \"warning.png\"))";
Debug.ShouldStop(33554432);
anywheresoftware.b4a.keywords.Common.Msgbox2("Offline Connection or Server Down","MeTube","OK","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"warning.png").getObject()),mostCurrent.activityBA);
 }else {
 BA.debugLineNum = 476;BA.debugLine="If sf.InString(MNChttp.ErrorMessage, \"Not Found\") < 0 Then";
Debug.ShouldStop(134217728);
if (_sf._vvv4(_mnchttp._errormessage,"Not Found")<0) { 
 BA.debugLineNum = 478;BA.debugLine="Msgbox2(\"Unknown Error\", \"MeTube\", \"OK\", \"\", \"\", LoadBitmap(File.DirAssets, \"warning.png\"))";
Debug.ShouldStop(536870912);
anywheresoftware.b4a.keywords.Common.Msgbox2("Unknown Error","MeTube","OK","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"warning.png").getObject()),mostCurrent.activityBA);
 };
 };
 BA.debugLineNum = 482;BA.debugLine="Fungsi.mpList.Put(\"Koneksi\", \"Offline\")";
Debug.ShouldStop(2);
mostCurrent._fungsi._mplist.Put((Object)("Koneksi"),(Object)("Offline"));
 BA.debugLineNum = 483;BA.debugLine="MNChttp.Release";
Debug.ShouldStop(4);
_mnchttp._release();
 }else {
 BA.debugLineNum = 488;BA.debugLine="Try";
Debug.ShouldStop(128);
try { BA.debugLineNum = 491;BA.debugLine="parser.Initialize(MNChttp.GetString)";
Debug.ShouldStop(1024);
_parser.Initialize(_mnchttp._getstring());
 BA.debugLineNum = 492;BA.debugLine="MNChttp.Release";
Debug.ShouldStop(2048);
_mnchttp._release();
 } 
       catch (Exception e297) {
			processBA.setLastException(e297); BA.debugLineNum = 494;BA.debugLine="Msgbox2(\"Process Failure !\", \"MeTube\", \"OK\", \"\", \"\", LoadBitmap(File.DirAssets, \"warning.png\"))";
Debug.ShouldStop(8192);
anywheresoftware.b4a.keywords.Common.Msgbox2("Process Failure !","MeTube","OK","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"warning.png").getObject()),mostCurrent.activityBA);
 BA.debugLineNum = 495;BA.debugLine="Return";
Debug.ShouldStop(16384);
if (true) return "";
 };
 BA.debugLineNum = 498;BA.debugLine="Try";
Debug.ShouldStop(131072);
try { BA.debugLineNum = 499;BA.debugLine="mresult.Initialize";
Debug.ShouldStop(262144);
_mresult.Initialize();
 BA.debugLineNum = 500;BA.debugLine="mresult = parser.NextObject";
Debug.ShouldStop(524288);
_mresult = _parser.NextObject();Debug.locals.put("mresult", _mresult);
 } 
       catch (Exception e304) {
			processBA.setLastException(e304); BA.debugLineNum = 502;BA.debugLine="Msgbox2(\"Process Failure !\", \"MeTube\", \"OK\", \"\", \"\", LoadBitmap(File.DirAssets, \"warning.png\"))";
Debug.ShouldStop(2097152);
anywheresoftware.b4a.keywords.Common.Msgbox2("Process Failure !","MeTube","OK","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"warning.png").getObject()),mostCurrent.activityBA);
 BA.debugLineNum = 503;BA.debugLine="Return";
Debug.ShouldStop(4194304);
if (true) return "";
 };
 BA.debugLineNum = 506;BA.debugLine="If mresult.Get(\"error_code\") <> \"0\" Then";
Debug.ShouldStop(33554432);
if ((_mresult.Get((Object)("error_code"))).equals((Object)("0")) == false) { 
 BA.debugLineNum = 507;BA.debugLine="Msgbox2(mresult.Get(\"error_msg\"), \"MeTube\", \"OK\", \"\", \"\", LoadBitmap(File.DirAssets, \"warning.png\"))";
Debug.ShouldStop(67108864);
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToString(_mresult.Get((Object)("error_msg"))),"MeTube","OK","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"warning.png").getObject()),mostCurrent.activityBA);
 }else {
 BA.debugLineNum = 509;BA.debugLine="Fungsi.mpList.Put(\"Koneksi\", \"Online\")";
Debug.ShouldStop(268435456);
mostCurrent._fungsi._mplist.Put((Object)("Koneksi"),(Object)("Online"));
 BA.debugLineNum = 510;BA.debugLine="MNChttp.Release";
Debug.ShouldStop(536870912);
_mnchttp._release();
 BA.debugLineNum = 512;BA.debugLine="Select MNChttp.JobName";
Debug.ShouldStop(-2147483648);
switch (BA.switchObjectToInt(_mnchttp._jobname)) {
}
;
 };
 };
 BA.debugLineNum = 517;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _lbllogin_click() throws Exception{
try {
		Debug.PushSubsStack("lblLogin_Click (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,394);
 BA.debugLineNum = 394;BA.debugLine="Sub lblLogin_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 402;BA.debugLine="StartActivity(\"Login\")";
Debug.ShouldStop(131072);
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)("Login"));
 BA.debugLineNum = 403;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _lblmost_click() throws Exception{
try {
		Debug.PushSubsStack("lblMost_Click (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,437);
metube.mncplaymedia.com.mnchttpjob _homejob = null;
String _strenc = "";
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _gen = null;
anywheresoftware.b4a.objects.collections.Map _mlogin = null;
anywheresoftware.b4a.objects.collections.List _mlist = null;
anywheresoftware.b4a.objects.collections.Map _mmap = null;
 BA.debugLineNum = 437;BA.debugLine="Sub lblMost_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 439;BA.debugLine="Dim HomeJob As MNChttpjob";
Debug.ShouldStop(4194304);
_homejob = new metube.mncplaymedia.com.mnchttpjob();Debug.locals.put("HomeJob", _homejob);
 BA.debugLineNum = 440;BA.debugLine="Dim	strEnc	As String";
Debug.ShouldStop(8388608);
_strenc = "";Debug.locals.put("strEnc", _strenc);
 BA.debugLineNum = 441;BA.debugLine="Dim Gen		As JSONGenerator";
Debug.ShouldStop(16777216);
_gen = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();Debug.locals.put("Gen", _gen);
 BA.debugLineNum = 442;BA.debugLine="Dim mlogin	As Map";
Debug.ShouldStop(33554432);
_mlogin = new anywheresoftware.b4a.objects.collections.Map();Debug.locals.put("mlogin", _mlogin);
 BA.debugLineNum = 443;BA.debugLine="Dim mlist 	As List";
Debug.ShouldStop(67108864);
_mlist = new anywheresoftware.b4a.objects.collections.List();Debug.locals.put("mlist", _mlist);
 BA.debugLineNum = 444;BA.debugLine="Dim mMap	As Map";
Debug.ShouldStop(134217728);
_mmap = new anywheresoftware.b4a.objects.collections.Map();Debug.locals.put("mMap", _mmap);
 BA.debugLineNum = 447;BA.debugLine="HomeJob.Initialize(\"GetListVideo\", Me)";
Debug.ShouldStop(1073741824);
_homejob._initialize(processBA,"GetListVideo",utama.getObject());
 BA.debugLineNum = 449;BA.debugLine="Try";
Debug.ShouldStop(1);
try { BA.debugLineNum = 450;BA.debugLine="HomeJob.Tag = \"GetListVideo\"";
Debug.ShouldStop(2);
_homejob._tag = (Object)("GetListVideo");Debug.locals.put("HomeJob", _homejob);
 BA.debugLineNum = 452;BA.debugLine="HomeJob.PostString(Fungsi.mpList.Get(\"ListURL\"), Fungsi.mpList.Get(\"List\") & lblMost.text & \"&\" & Fungsi.mpList.Get(\"Jumlah\") & \"&\" & Fungsi.mpList.Get(\"Halaman\"))";
Debug.ShouldStop(8);
_homejob._poststring(BA.ObjectToString(mostCurrent._fungsi._mplist.Get((Object)("ListURL"))),BA.ObjectToString(mostCurrent._fungsi._mplist.Get((Object)("List")))+mostCurrent._lblmost.getText()+"&"+BA.ObjectToString(mostCurrent._fungsi._mplist.Get((Object)("Jumlah")))+"&"+BA.ObjectToString(mostCurrent._fungsi._mplist.Get((Object)("Halaman"))));
 BA.debugLineNum = 453;BA.debugLine="HomeJob.GetRequest.Timeout = DateTime.TicksPerSecond * 60";
Debug.ShouldStop(16);
_homejob._getrequest().setTimeout((int) (anywheresoftware.b4a.keywords.Common.DateTime.TicksPerSecond*60));
 } 
       catch (Exception e270) {
			processBA.setLastException(e270); BA.debugLineNum = 455;BA.debugLine="Msgbox2(\"Login Failure !\", \"MeTube\", \"OK\", \"\", \"\", LoadBitmap(File.DirAssets, \"warning.png\"))";
Debug.ShouldStop(64);
anywheresoftware.b4a.keywords.Common.Msgbox2("Login Failure !","MeTube","OK","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"warning.png").getObject()),mostCurrent.activityBA);
 };
 BA.debugLineNum = 457;BA.debugLine="End Sub";
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
public static String  _lvbrowse_itemclick(int _position,Object _value) throws Exception{
try {
		Debug.PushSubsStack("lvBrowse_ItemClick (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,382);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 382;BA.debugLine="Sub lvBrowse_ItemClick (Position As Int, Value As Object)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 383;BA.debugLine="Slide_Menu";
Debug.ShouldStop(1073741824);
_slide_menu();
 BA.debugLineNum = 384;BA.debugLine="End Sub";
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
public static String  _lvcate_itemclick(int _position,Object _value) throws Exception{
try {
		Debug.PushSubsStack("lvCate_ItemClick (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,388);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 388;BA.debugLine="Sub lvCate_ItemClick (Position As Int, Value As Object)";
Debug.ShouldStop(8);
 BA.debugLineNum = 389;BA.debugLine="Slide_Menu";
Debug.ShouldStop(16);
_slide_menu();
 BA.debugLineNum = 390;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _lvmanage_itemclick(int _position,Object _value) throws Exception{
try {
		Debug.PushSubsStack("lvManage_ItemClick (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,391);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 391;BA.debugLine="Sub lvManage_ItemClick (Position As Int, Value As Object)";
Debug.ShouldStop(64);
 BA.debugLineNum = 392;BA.debugLine="Slide_Menu";
Debug.ShouldStop(128);
_slide_menu();
 BA.debugLineNum = 393;BA.debugLine="End Sub";
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
public static String  _lvvideo_itemclick(int _position,Object _value) throws Exception{
try {
		Debug.PushSubsStack("lvVideo_ItemClick (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,385);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 385;BA.debugLine="Sub lvVideo_ItemClick (Position As Int, Value As Object)";
Debug.ShouldStop(1);
 BA.debugLineNum = 386;BA.debugLine="Slide_Menu";
Debug.ShouldStop(2);
_slide_menu();
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
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _prosescoverflowstorage() throws Exception{
try {
		Debug.PushSubsStack("ProsesCoverFlowStorage (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,346);
 BA.debugLineNum = 346;BA.debugLine="Sub ProsesCoverFlowStorage";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 361;BA.debugLine="End Sub";
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
public static String  _slide_menu() throws Exception{
try {
		Debug.PushSubsStack("Slide_Menu (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,183);
 BA.debugLineNum = 183;BA.debugLine="Sub Slide_Menu";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 184;BA.debugLine="DoEvents";
Debug.ShouldStop(8388608);
anywheresoftware.b4a.keywords.Common.DoEvents();
 BA.debugLineNum = 186;BA.debugLine="If iTampil=0 Then";
Debug.ShouldStop(33554432);
if (_itampil==0) { 
 BA.debugLineNum = 187;BA.debugLine="iTampil = 1";
Debug.ShouldStop(67108864);
_itampil = (int) (1);
 BA.debugLineNum = 188;BA.debugLine="pSemua.SetLayoutAnimated(800, 0%x, 0, 165%x, 100%y)";
Debug.ShouldStop(134217728);
mostCurrent._psemua.SetLayoutAnimated((int) (800),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (165),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 }else {
 BA.debugLineNum = 191;BA.debugLine="iTampil = 0";
Debug.ShouldStop(1073741824);
_itampil = (int) (0);
 BA.debugLineNum = 192;BA.debugLine="pSemua.SetLayoutAnimated(800, -65%x, 0, 165%x, 100%y)";
Debug.ShouldStop(-2147483648);
mostCurrent._psemua.SetLayoutAnimated((int) (800),(int) (-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (65),mostCurrent.activityBA)),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (165),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 };
 BA.debugLineNum = 194;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _tcover_tick() throws Exception{
try {
		Debug.PushSubsStack("tCover_Tick (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,362);
 BA.debugLineNum = 362;BA.debugLine="Sub tCover_Tick";
Debug.ShouldStop(512);
 BA.debugLineNum = 372;BA.debugLine="End Sub";
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
public static String  _timer_cflow_tick() throws Exception{
try {
		Debug.PushSubsStack("timer_cflow_Tick (utama) ","utama",2,mostCurrent.activityBA,mostCurrent,414);
 BA.debugLineNum = 414;BA.debugLine="Sub timer_cflow_Tick";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 416;BA.debugLine="If b <= coverflow.Length-1 Then";
Debug.ShouldStop(-2147483648);
if (_b<=mostCurrent._coverflow.getLength()-1) { 
 BA.debugLineNum = 417;BA.debugLine="coverflow.Selection=b";
Debug.ShouldStop(1);
mostCurrent._coverflow.setSelection(_b);
 BA.debugLineNum = 418;BA.debugLine="a=1";
Debug.ShouldStop(2);
_a = (int) (1);
 BA.debugLineNum = 419;BA.debugLine="b=b+a";
Debug.ShouldStop(4);
_b = (int) (_b+_a);
 }else {
 BA.debugLineNum = 421;BA.debugLine="b=0";
Debug.ShouldStop(16);
_b = (int) (0);
 BA.debugLineNum = 422;BA.debugLine="coverflow.Selection=b";
Debug.ShouldStop(32);
mostCurrent._coverflow.setSelection(_b);
 };
 BA.debugLineNum = 425;BA.debugLine="End Sub";
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
}
