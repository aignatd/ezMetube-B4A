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

public class login extends Activity implements B4AActivity{
	public static login mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "metube.mncplaymedia.com", "metube.mncplaymedia.com.login");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (login).");
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
		activityBA = new BA(this, layout, processBA, "metube.mncplaymedia.com", "metube.mncplaymedia.com.login");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "metube.mncplaymedia.com.login", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (login) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (login) Resume **");
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
		return login.class;
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
        BA.LogInfo("** Activity (login) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (login) Resume **");
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
public anywheresoftware.b4a.objects.PanelWrapper _plogin = null;
public anywheresoftware.b4a.objects.PanelWrapper _pbadan = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblnama = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblemail = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etemail = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblpass = null;
public anywheresoftware.b4a.objects.EditTextWrapper _etpass = null;
public anywheresoftware.b4a.objects.ButtonWrapper _blogin = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblor = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblregister = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblforgot = null;
public flm.b4a.betterdialogs.BetterDialogs _bdlogin = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbllogin = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _iv2 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _iv1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _iv4 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _iv3 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ivfacebook = null;
public metube.mncplaymedia.com.main _main = null;
public metube.mncplaymedia.com.utama _utama = null;
public metube.mncplaymedia.com.register _register = null;
public metube.mncplaymedia.com.fungsi _fungsi = null;
public metube.mncplaymedia.com.mncutils2service _mncutils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",mostCurrent._activity,"BDLogin",mostCurrent._bdlogin,"bLogin",mostCurrent._blogin,"etEmail",mostCurrent._etemail,"etPass",mostCurrent._etpass,"Fungsi",Debug.moduleToString(metube.mncplaymedia.com.fungsi.class),"iv1",mostCurrent._iv1,"iv2",mostCurrent._iv2,"iv3",mostCurrent._iv3,"iv4",mostCurrent._iv4,"ivFacebook",mostCurrent._ivfacebook,"lblEmail",mostCurrent._lblemail,"lblForgot",mostCurrent._lblforgot,"lblLogin",mostCurrent._lbllogin,"lblNama",mostCurrent._lblnama,"lblOr",mostCurrent._lblor,"lblPass",mostCurrent._lblpass,"lblRegister",mostCurrent._lblregister,"Main",Debug.moduleToString(metube.mncplaymedia.com.main.class),"MNCUtils2Service",Debug.moduleToString(metube.mncplaymedia.com.mncutils2service.class),"pBadan",mostCurrent._pbadan,"pLogin",mostCurrent._plogin,"Register",Debug.moduleToString(metube.mncplaymedia.com.register.class),"Utama",Debug.moduleToString(metube.mncplaymedia.com.utama.class)};
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
		Debug.PushSubsStack("Activity_Create (login) ","login",1,mostCurrent.activityBA,mostCurrent,39);
anywheresoftware.b4a.objects.drawable.ColorDrawable _cdback = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _bpanel = null;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 39;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(64);
 BA.debugLineNum = 41;BA.debugLine="Activity.LoadLayout(\"Login\")";
Debug.ShouldStop(256);
mostCurrent._activity.LoadLayout("Login",mostCurrent.activityBA);
 BA.debugLineNum = 44;BA.debugLine="If File.Exists(File.DirAssets, \"config.json\") Then";
Debug.ShouldStop(2048);
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"config.json")) { 
 BA.debugLineNum = 45;BA.debugLine="If Fungsi.CacahJSON(File.ReadString(File.DirAssets, \"config.json\"), \"NextArray\") = False Then";
Debug.ShouldStop(4096);
if (mostCurrent._fungsi._cacahjson(mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"config.json"),"NextArray")==anywheresoftware.b4a.keywords.Common.False) { 
 BA.debugLineNum = 46;BA.debugLine="BDLogin.Msgbox(\"Error\", \"Reading config failed !\", \"OK\", \"\", \"\", Fungsi.GetDrawable(\"ic_action_warning\"))";
Debug.ShouldStop(8192);
mostCurrent._bdlogin.MsgBox("Error","Reading config failed !","OK","","",mostCurrent._fungsi._getdrawable(mostCurrent.activityBA,"ic_action_warning"),mostCurrent.activityBA);
 BA.debugLineNum = 47;BA.debugLine="ExitApplication";
Debug.ShouldStop(16384);
anywheresoftware.b4a.keywords.Common.ExitApplication();
 };
 }else {
 BA.debugLineNum = 50;BA.debugLine="BDLogin.Msgbox(\"Error\", \"Load config failed !\", \"OK\", \"\", \"\", Fungsi.GetDrawable(\"ic_action_warning\"))";
Debug.ShouldStop(131072);
mostCurrent._bdlogin.MsgBox("Error","Load config failed !","OK","","",mostCurrent._fungsi._getdrawable(mostCurrent.activityBA,"ic_action_warning"),mostCurrent.activityBA);
 BA.debugLineNum = 51;BA.debugLine="ExitApplication";
Debug.ShouldStop(262144);
anywheresoftware.b4a.keywords.Common.ExitApplication();
 };
 BA.debugLineNum = 56;BA.debugLine="Dim cdBack 	As ColorDrawable";
Debug.ShouldStop(8388608);
_cdback = new anywheresoftware.b4a.objects.drawable.ColorDrawable();Debug.locals.put("cdBack", _cdback);
 BA.debugLineNum = 57;BA.debugLine="Dim bPanel  As ColorDrawable";
Debug.ShouldStop(16777216);
_bpanel = new anywheresoftware.b4a.objects.drawable.ColorDrawable();Debug.locals.put("bPanel", _bpanel);
 BA.debugLineNum = 58;BA.debugLine="cdBack.Initialize(Colors.RGB(252, 252, 252), 5)";
Debug.ShouldStop(33554432);
_cdback.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (252),(int) (252),(int) (252)),(int) (5));
 BA.debugLineNum = 59;BA.debugLine="bPanel.Initialize(Colors.RGB(243, 243, 243), 0)";
Debug.ShouldStop(67108864);
_bpanel.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (243),(int) (243),(int) (243)),(int) (0));
 BA.debugLineNum = 60;BA.debugLine="iv1.Background = Fungsi.GetDrawable(\"users81\")";
Debug.ShouldStop(134217728);
mostCurrent._iv1.setBackground((android.graphics.drawable.Drawable)(mostCurrent._fungsi._getdrawable(mostCurrent.activityBA,"users81")));
 BA.debugLineNum = 61;BA.debugLine="iv2.Background = cdBack";
Debug.ShouldStop(268435456);
mostCurrent._iv2.setBackground((android.graphics.drawable.Drawable)(_cdback.getObject()));
 BA.debugLineNum = 62;BA.debugLine="iv3.Background = Fungsi.GetDrawable(\"lock24\")";
Debug.ShouldStop(536870912);
mostCurrent._iv3.setBackground((android.graphics.drawable.Drawable)(mostCurrent._fungsi._getdrawable(mostCurrent.activityBA,"lock24")));
 BA.debugLineNum = 63;BA.debugLine="iv4.Background = cdBack";
Debug.ShouldStop(1073741824);
mostCurrent._iv4.setBackground((android.graphics.drawable.Drawable)(_cdback.getObject()));
 BA.debugLineNum = 64;BA.debugLine="etEmail.Background = cdBack";
Debug.ShouldStop(-2147483648);
mostCurrent._etemail.setBackground((android.graphics.drawable.Drawable)(_cdback.getObject()));
 BA.debugLineNum = 65;BA.debugLine="etPass.Background = cdBack";
Debug.ShouldStop(1);
mostCurrent._etpass.setBackground((android.graphics.drawable.Drawable)(_cdback.getObject()));
 BA.debugLineNum = 66;BA.debugLine="pBadan.Background = bPanel";
Debug.ShouldStop(2);
mostCurrent._pbadan.setBackground((android.graphics.drawable.Drawable)(_bpanel.getObject()));
 BA.debugLineNum = 69;BA.debugLine="End Sub";
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
public static String  _activity_pause(boolean _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (login) ","login",1,mostCurrent.activityBA,mostCurrent,75);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 75;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("Activity_Resume (login) ","login",1,mostCurrent.activityBA,mostCurrent,71);
 BA.debugLineNum = 71;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(64);
 BA.debugLineNum = 73;BA.debugLine="End Sub";
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
public static String  _blogin_click() throws Exception{
try {
		Debug.PushSubsStack("bLogin_Click (login) ","login",1,mostCurrent.activityBA,mostCurrent,78);
metube.mncplaymedia.com.mnchttpjob _homejob = null;
String _strenc = "";
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _gen = null;
anywheresoftware.b4a.objects.collections.Map _mlogin = null;
anywheresoftware.b4a.objects.collections.List _mlist = null;
anywheresoftware.b4a.objects.collections.Map _mmap = null;
 BA.debugLineNum = 78;BA.debugLine="Sub bLogin_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 80;BA.debugLine="Dim HomeJob As MNChttpjob";
Debug.ShouldStop(32768);
_homejob = new metube.mncplaymedia.com.mnchttpjob();Debug.locals.put("HomeJob", _homejob);
 BA.debugLineNum = 81;BA.debugLine="Dim	strEnc	As String";
Debug.ShouldStop(65536);
_strenc = "";Debug.locals.put("strEnc", _strenc);
 BA.debugLineNum = 82;BA.debugLine="Dim Gen		As JSONGenerator";
Debug.ShouldStop(131072);
_gen = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();Debug.locals.put("Gen", _gen);
 BA.debugLineNum = 83;BA.debugLine="Dim mlogin	As Map";
Debug.ShouldStop(262144);
_mlogin = new anywheresoftware.b4a.objects.collections.Map();Debug.locals.put("mlogin", _mlogin);
 BA.debugLineNum = 84;BA.debugLine="Dim mlist 	As List";
Debug.ShouldStop(524288);
_mlist = new anywheresoftware.b4a.objects.collections.List();Debug.locals.put("mlist", _mlist);
 BA.debugLineNum = 85;BA.debugLine="Dim mMap	As Map";
Debug.ShouldStop(1048576);
_mmap = new anywheresoftware.b4a.objects.collections.Map();Debug.locals.put("mMap", _mmap);
 BA.debugLineNum = 88;BA.debugLine="HomeJob.Initialize(\"Login\", Me)";
Debug.ShouldStop(8388608);
_homejob._initialize(processBA,"Login",login.getObject());
 BA.debugLineNum = 90;BA.debugLine="Try";
Debug.ShouldStop(33554432);
try { BA.debugLineNum = 91;BA.debugLine="HomeJob.Tag = \"Login\"";
Debug.ShouldStop(67108864);
_homejob._tag = (Object)("Login");Debug.locals.put("HomeJob", _homejob);
 BA.debugLineNum = 92;BA.debugLine="Log((Fungsi.mpList.Get(\"key1a\")) & \"&\" & Fungsi.mpList.Get(\"key2a\"))";
Debug.ShouldStop(134217728);
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString((mostCurrent._fungsi._mplist.Get((Object)("key1a"))))+"&"+BA.ObjectToString(mostCurrent._fungsi._mplist.Get((Object)("key2a"))));
 BA.debugLineNum = 93;BA.debugLine="HomeJob.PostString(Fungsi.mpList.Get(\"LoginURL\"), Fungsi.mpList.Get(\"key1a\") & etEmail.text & \"&\" & Fungsi.mpList.Get(\"key2a\") & etPass.Text )";
Debug.ShouldStop(268435456);
_homejob._poststring(BA.ObjectToString(mostCurrent._fungsi._mplist.Get((Object)("LoginURL"))),BA.ObjectToString(mostCurrent._fungsi._mplist.Get((Object)("key1a")))+mostCurrent._etemail.getText()+"&"+BA.ObjectToString(mostCurrent._fungsi._mplist.Get((Object)("key2a")))+mostCurrent._etpass.getText());
 BA.debugLineNum = 94;BA.debugLine="HomeJob.GetRequest.Timeout = DateTime.TicksPerSecond * 60";
Debug.ShouldStop(536870912);
_homejob._getrequest().setTimeout((int) (anywheresoftware.b4a.keywords.Common.DateTime.TicksPerSecond*60));
 } 
       catch (Exception e63) {
			processBA.setLastException(e63); BA.debugLineNum = 96;BA.debugLine="Msgbox2(\"Login Failure !\", \"MeTube\", \"OK\", \"\", \"\", LoadBitmap(File.DirAssets, \"warning.png\"))";
Debug.ShouldStop(-2147483648);
anywheresoftware.b4a.keywords.Common.Msgbox2("Login Failure !","MeTube","OK","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"warning.png").getObject()),mostCurrent.activityBA);
 };
 BA.debugLineNum = 98;BA.debugLine="End Sub";
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
public static String  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 17;BA.debugLine="Private pLogin 		As Panel";
mostCurrent._plogin = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private pBadan 		As Panel";
mostCurrent._pbadan = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private lblNama 	As Label";
mostCurrent._lblnama = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private lblEmail 	As Label";
mostCurrent._lblemail = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private etEmail 	As EditText";
mostCurrent._etemail = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private lblPass 	As Label";
mostCurrent._lblpass = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private etPass 		As EditText";
mostCurrent._etpass = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private bLogin 		As Button";
mostCurrent._blogin = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private lblOr 		As Label";
mostCurrent._lblor = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private lblRegister As Label";
mostCurrent._lblregister = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Private lblForgot 	As Label";
mostCurrent._lblforgot = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Private BDLogin		As BetterDialogs";
mostCurrent._bdlogin = new flm.b4a.betterdialogs.BetterDialogs();
 //BA.debugLineNum = 30;BA.debugLine="Private lblLogin As Label";
mostCurrent._lbllogin = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Private iv2 As ImageView";
mostCurrent._iv2 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private iv1 As ImageView";
mostCurrent._iv1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private iv4 As ImageView";
mostCurrent._iv4 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private iv3 As ImageView";
mostCurrent._iv3 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private ivFacebook As ImageView";
mostCurrent._ivfacebook = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public static String  _ivfacebook_click() throws Exception{
try {
		Debug.PushSubsStack("ivFacebook_Click (login) ","login",1,mostCurrent.activityBA,mostCurrent,169);
metube.mncplaymedia.com.mnchttpjob _homejob = null;
String _strenc = "";
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _gen = null;
anywheresoftware.b4a.objects.collections.Map _mlogin = null;
anywheresoftware.b4a.objects.collections.List _mlist = null;
anywheresoftware.b4a.objects.collections.Map _mmap = null;
 BA.debugLineNum = 169;BA.debugLine="Sub ivFacebook_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 171;BA.debugLine="Dim HomeJob As MNChttpjob";
Debug.ShouldStop(1024);
_homejob = new metube.mncplaymedia.com.mnchttpjob();Debug.locals.put("HomeJob", _homejob);
 BA.debugLineNum = 172;BA.debugLine="Dim	strEnc	As String";
Debug.ShouldStop(2048);
_strenc = "";Debug.locals.put("strEnc", _strenc);
 BA.debugLineNum = 173;BA.debugLine="Dim Gen		As JSONGenerator";
Debug.ShouldStop(4096);
_gen = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();Debug.locals.put("Gen", _gen);
 BA.debugLineNum = 174;BA.debugLine="Dim mlogin	As Map";
Debug.ShouldStop(8192);
_mlogin = new anywheresoftware.b4a.objects.collections.Map();Debug.locals.put("mlogin", _mlogin);
 BA.debugLineNum = 175;BA.debugLine="Dim mlist 	As List";
Debug.ShouldStop(16384);
_mlist = new anywheresoftware.b4a.objects.collections.List();Debug.locals.put("mlist", _mlist);
 BA.debugLineNum = 176;BA.debugLine="Dim mMap	As Map";
Debug.ShouldStop(32768);
_mmap = new anywheresoftware.b4a.objects.collections.Map();Debug.locals.put("mMap", _mmap);
 BA.debugLineNum = 179;BA.debugLine="HomeJob.Initialize(\"LoginFB\", Me)";
Debug.ShouldStop(262144);
_homejob._initialize(processBA,"LoginFB",login.getObject());
 BA.debugLineNum = 181;BA.debugLine="Try";
Debug.ShouldStop(1048576);
try { BA.debugLineNum = 182;BA.debugLine="HomeJob.Tag = \"LoginFB\"";
Debug.ShouldStop(2097152);
_homejob._tag = (Object)("LoginFB");Debug.locals.put("HomeJob", _homejob);
 BA.debugLineNum = 183;BA.debugLine="Log((Fungsi.mpList.Get(\"key1a\")) & \"&\" & Fungsi.mpList.Get(\"key2a\"))";
Debug.ShouldStop(4194304);
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString((mostCurrent._fungsi._mplist.Get((Object)("key1a"))))+"&"+BA.ObjectToString(mostCurrent._fungsi._mplist.Get((Object)("key2a"))));
 BA.debugLineNum = 184;BA.debugLine="HomeJob.PostString(Fungsi.mpList.Get(\"FacebookURL\"), Fungsi.mpList.Get(\"FB_id\") & etEmail.text & \"&\" & Fungsi.mpList.Get(\"key2a\") & etPass.Text )";
Debug.ShouldStop(8388608);
_homejob._poststring(BA.ObjectToString(mostCurrent._fungsi._mplist.Get((Object)("FacebookURL"))),BA.ObjectToString(mostCurrent._fungsi._mplist.Get((Object)("FB_id")))+mostCurrent._etemail.getText()+"&"+BA.ObjectToString(mostCurrent._fungsi._mplist.Get((Object)("key2a")))+mostCurrent._etpass.getText());
 BA.debugLineNum = 185;BA.debugLine="HomeJob.GetRequest.Timeout = DateTime.TicksPerSecond * 60";
Debug.ShouldStop(16777216);
_homejob._getrequest().setTimeout((int) (anywheresoftware.b4a.keywords.Common.DateTime.TicksPerSecond*60));
 } 
       catch (Exception e132) {
			processBA.setLastException(e132); BA.debugLineNum = 187;BA.debugLine="Msgbox2(\"Login Failure !\", \"MeTube\", \"OK\", \"\", \"\", LoadBitmap(File.DirAssets, \"warning.png\"))";
Debug.ShouldStop(67108864);
anywheresoftware.b4a.keywords.Common.Msgbox2("Login Failure !","MeTube","OK","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"warning.png").getObject()),mostCurrent.activityBA);
 };
 BA.debugLineNum = 189;BA.debugLine="End Sub";
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
public static String  _ivokezone_click() throws Exception{
try {
		Debug.PushSubsStack("ivOkezone_Click (login) ","login",1,mostCurrent.activityBA,mostCurrent,162);
anywheresoftware.b4a.phone.Phone.PhoneIntents _p = null;
 BA.debugLineNum = 162;BA.debugLine="Sub ivOkezone_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 163;BA.debugLine="Dim p As PhoneIntents";
Debug.ShouldStop(4);
_p = new anywheresoftware.b4a.phone.Phone.PhoneIntents();Debug.locals.put("p", _p);
 BA.debugLineNum = 165;BA.debugLine="StartActivity(p.OpenBrowser(\"http://www.okezone.com/\"))";
Debug.ShouldStop(16);
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(_p.OpenBrowser("http://www.okezone.com/")));
 BA.debugLineNum = 167;BA.debugLine="Return";
Debug.ShouldStop(64);
if (true) return "";
 BA.debugLineNum = 168;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("JobDone (login) ","login",1,mostCurrent.activityBA,mostCurrent,99);
adr.stringfunctions.stringfunctions _sf = null;
String _stmp = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _mresult = null;
byte[] _btmp = null;
anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bctmp = null;
anywheresoftware.b4a.objects.StringUtils _su = null;
Debug.locals.put("MNChttp", _mnchttp);
 BA.debugLineNum = 99;BA.debugLine="Sub JobDone (MNChttp As MNChttpjob)";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="Dim sf			As StringFunctions";
Debug.ShouldStop(8);
_sf = new adr.stringfunctions.stringfunctions();Debug.locals.put("sf", _sf);
 BA.debugLineNum = 101;BA.debugLine="Dim sTmp 		As String";
Debug.ShouldStop(16);
_stmp = "";Debug.locals.put("sTmp", _stmp);
 BA.debugLineNum = 102;BA.debugLine="Dim parser 		As JSONParser";
Debug.ShouldStop(32);
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();Debug.locals.put("parser", _parser);
 BA.debugLineNum = 103;BA.debugLine="Dim mresult		As Map";
Debug.ShouldStop(64);
_mresult = new anywheresoftware.b4a.objects.collections.Map();Debug.locals.put("mresult", _mresult);
 BA.debugLineNum = 104;BA.debugLine="Dim bTmp()		As Byte";
Debug.ShouldStop(128);
_btmp = new byte[(int) (0)];
;Debug.locals.put("bTmp", _btmp);
 BA.debugLineNum = 105;BA.debugLine="Dim bcTmp		As ByteConverter";
Debug.ShouldStop(256);
_bctmp = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();Debug.locals.put("bcTmp", _bctmp);
 BA.debugLineNum = 106;BA.debugLine="Dim su 			As StringUtils";
Debug.ShouldStop(512);
_su = new anywheresoftware.b4a.objects.StringUtils();Debug.locals.put("su", _su);
 BA.debugLineNum = 108;BA.debugLine="Log((MNChttp.GetString))";
Debug.ShouldStop(2048);
anywheresoftware.b4a.keywords.Common.Log((_mnchttp._getstring()));
 BA.debugLineNum = 110;BA.debugLine="If MNChttp.Success = False Then";
Debug.ShouldStop(8192);
if (_mnchttp._success==anywheresoftware.b4a.keywords.Common.False) { 
 BA.debugLineNum = 111;BA.debugLine="If (sf.InString(MNChttp.ErrorMessage, \"timed out\") > 0) OR (sf.InString(MNChttp.ErrorMessage, \"refused\") > 0) OR _ 			 (sf.InString(MNChttp.ErrorMessage, \"Unable to resolve host\") > 0) OR (sf.InString(MNChttp.ErrorMessage, \"UnknownHostException\") > 0) OR _ 			 (sf.InString(MNChttp.ErrorMessage, \"FileNotFound\") > 0) Then";
Debug.ShouldStop(16384);
if ((_sf._vvv4(_mnchttp._errormessage,"timed out")>0) || (_sf._vvv4(_mnchttp._errormessage,"refused")>0) || (_sf._vvv4(_mnchttp._errormessage,"Unable to resolve host")>0) || (_sf._vvv4(_mnchttp._errormessage,"UnknownHostException")>0) || (_sf._vvv4(_mnchttp._errormessage,"FileNotFound")>0)) { 
 BA.debugLineNum = 115;BA.debugLine="Msgbox2(\"Offline Connection or Server Down\", \"Moviebay\", \"OK\", \"\", \"\", LoadBitmap(File.DirAssets, \"warning.png\"))";
Debug.ShouldStop(262144);
anywheresoftware.b4a.keywords.Common.Msgbox2("Offline Connection or Server Down","Moviebay","OK","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"warning.png").getObject()),mostCurrent.activityBA);
 }else {
 BA.debugLineNum = 117;BA.debugLine="If sf.InString(MNChttp.ErrorMessage, \"Not Found\") < 0 Then";
Debug.ShouldStop(1048576);
if (_sf._vvv4(_mnchttp._errormessage,"Not Found")<0) { 
 BA.debugLineNum = 119;BA.debugLine="Msgbox2(\"Unknown Error\", \"MeTube\", \"OK\", \"\", \"\", LoadBitmap(File.DirAssets, \"warning.png\"))";
Debug.ShouldStop(4194304);
anywheresoftware.b4a.keywords.Common.Msgbox2("Unknown Error","MeTube","OK","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"warning.png").getObject()),mostCurrent.activityBA);
 };
 };
 BA.debugLineNum = 123;BA.debugLine="Fungsi.mpList.Put(\"Koneksi\", \"Offline\")";
Debug.ShouldStop(67108864);
mostCurrent._fungsi._mplist.Put((Object)("Koneksi"),(Object)("Offline"));
 BA.debugLineNum = 124;BA.debugLine="MNChttp.Release";
Debug.ShouldStop(134217728);
_mnchttp._release();
 }else {
 BA.debugLineNum = 129;BA.debugLine="Try";
Debug.ShouldStop(1);
try { BA.debugLineNum = 132;BA.debugLine="parser.Initialize(MNChttp.GetString)";
Debug.ShouldStop(8);
_parser.Initialize(_mnchttp._getstring());
 BA.debugLineNum = 133;BA.debugLine="MNChttp.Release";
Debug.ShouldStop(16);
_mnchttp._release();
 } 
       catch (Exception e90) {
			processBA.setLastException(e90); BA.debugLineNum = 135;BA.debugLine="Msgbox2(\"Process Failure !\", \"MeTube\", \"OK\", \"\", \"\", LoadBitmap(File.DirAssets, \"warning.png\"))";
Debug.ShouldStop(64);
anywheresoftware.b4a.keywords.Common.Msgbox2("Process Failure !","MeTube","OK","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"warning.png").getObject()),mostCurrent.activityBA);
 BA.debugLineNum = 136;BA.debugLine="Return";
Debug.ShouldStop(128);
if (true) return "";
 };
 BA.debugLineNum = 139;BA.debugLine="Try";
Debug.ShouldStop(1024);
try { BA.debugLineNum = 140;BA.debugLine="mresult.Initialize";
Debug.ShouldStop(2048);
_mresult.Initialize();
 BA.debugLineNum = 141;BA.debugLine="mresult = parser.NextObject";
Debug.ShouldStop(4096);
_mresult = _parser.NextObject();Debug.locals.put("mresult", _mresult);
 } 
       catch (Exception e97) {
			processBA.setLastException(e97); BA.debugLineNum = 143;BA.debugLine="Msgbox2(\"Process Failure !\", \"MeTube\", \"OK\", \"\", \"\", LoadBitmap(File.DirAssets, \"warning.png\"))";
Debug.ShouldStop(16384);
anywheresoftware.b4a.keywords.Common.Msgbox2("Process Failure !","MeTube","OK","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"warning.png").getObject()),mostCurrent.activityBA);
 BA.debugLineNum = 144;BA.debugLine="Return";
Debug.ShouldStop(32768);
if (true) return "";
 };
 BA.debugLineNum = 147;BA.debugLine="If mresult.Get(\"error_code\") <> \"0\" Then";
Debug.ShouldStop(262144);
if ((_mresult.Get((Object)("error_code"))).equals((Object)("0")) == false) { 
 BA.debugLineNum = 148;BA.debugLine="Msgbox2(mresult.Get(\"error_msg\"), \"MeTube\", \"OK\", \"\", \"\", LoadBitmap(File.DirAssets, \"warning.png\"))";
Debug.ShouldStop(524288);
anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToString(_mresult.Get((Object)("error_msg"))),"MeTube","OK","","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"warning.png").getObject()),mostCurrent.activityBA);
 }else {
 BA.debugLineNum = 150;BA.debugLine="Fungsi.mpList.Put(\"Koneksi\", \"Online\")";
Debug.ShouldStop(2097152);
mostCurrent._fungsi._mplist.Put((Object)("Koneksi"),(Object)("Online"));
 BA.debugLineNum = 151;BA.debugLine="MNChttp.Release";
Debug.ShouldStop(4194304);
_mnchttp._release();
 BA.debugLineNum = 153;BA.debugLine="Select MNChttp.JobName";
Debug.ShouldStop(16777216);
switch (BA.switchObjectToInt(_mnchttp._jobname)) {
}
;
 };
 };
 BA.debugLineNum = 158;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static String  _lblregister_click() throws Exception{
try {
		Debug.PushSubsStack("lblRegister_Click (login) ","login",1,mostCurrent.activityBA,mostCurrent,159);
 BA.debugLineNum = 159;BA.debugLine="Sub lblRegister_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 160;BA.debugLine="StartActivity(\"Register\")";
Debug.ShouldStop(-2147483648);
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)("Register"));
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
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
}
