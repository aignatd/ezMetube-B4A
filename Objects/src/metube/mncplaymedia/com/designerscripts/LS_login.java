package metube.mncplaymedia.com.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_login{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("plogin").vw.setLeft((int)(0d));
views.get("plogin").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("plogin").vw.setTop((int)(0d));
views.get("plogin").vw.setHeight((int)((100d / 100 * height) - (0d)));
views.get("ivokezone").vw.setLeft((int)((20d / 100 * width)));
views.get("ivokezone").vw.setWidth((int)((50d / 100 * height) - ((20d / 100 * width))));
views.get("ivokezone").vw.setTop((int)((2d / 100 * height)));
views.get("ivokezone").vw.setHeight((int)((14d / 100 * height) - ((2d / 100 * height))));
views.get("lbllogin").vw.setLeft((int)((2d / 100 * width)));
views.get("lbllogin").vw.setWidth((int)((18d / 100 * height) - ((2d / 100 * width))));
views.get("lbllogin").vw.setTop((int)((18d / 100 * height)));
views.get("lbllogin").vw.setHeight((int)((22d / 100 * height) - ((18d / 100 * height))));
views.get("lblid").vw.setLeft((int)((views.get("lbllogin").vw.getLeft() + views.get("lbllogin").vw.getWidth())-(10d / 100 * width)));
views.get("lblid").vw.setWidth((int)((50d / 100 * width) - ((views.get("lbllogin").vw.getLeft() + views.get("lbllogin").vw.getWidth())-(10d / 100 * width))));
views.get("lblid").vw.setTop((int)((18d / 100 * height)));
views.get("lblid").vw.setHeight((int)((22d / 100 * height) - ((18d / 100 * height))));
views.get("pbadan").vw.setLeft((int)((2d / 100 * width)));
views.get("pbadan").vw.setWidth((int)((98d / 100 * width) - ((2d / 100 * width))));
views.get("pbadan").vw.setTop((int)((24d / 100 * height)));
views.get("pbadan").vw.setHeight((int)((70d / 100 * height) - ((24d / 100 * height))));
views.get("lblnama").vw.setLeft((int)((2d / 100 * width)));
views.get("lblnama").vw.setWidth((int)((90d / 100 * width) - ((2d / 100 * width))));
views.get("lblnama").vw.setTop((int)((1d / 100 * height)));
views.get("lblnama").vw.setHeight((int)((6d / 100 * height) - ((1d / 100 * height))));
views.get("lblemail").vw.setLeft((int)((2d / 100 * width)));
views.get("lblemail").vw.setWidth((int)((24d / 100 * width) - ((2d / 100 * width))));
views.get("lblemail").vw.setTop((int)((6.5d / 100 * height)));
views.get("lblemail").vw.setHeight((int)((12d / 100 * height) - ((6.5d / 100 * height))));
views.get("iv1").vw.setLeft((int)((4d / 100 * width)));
views.get("iv1").vw.setWidth((int)((10d / 100 * width) - ((4d / 100 * width))));
//BA.debugLineNum = 26;BA.debugLine="iv1.SetTopAndBottom(lblEmail.Bottom + 2%y,18%y)"[login/General script]
views.get("iv1").vw.setTop((int)((views.get("lblemail").vw.getTop() + views.get("lblemail").vw.getHeight())+(2d / 100 * height)));
views.get("iv1").vw.setHeight((int)((18d / 100 * height) - ((views.get("lblemail").vw.getTop() + views.get("lblemail").vw.getHeight())+(2d / 100 * height))));
//BA.debugLineNum = 28;BA.debugLine="iv2.SetLeftAndRight(2%x,10%x)"[login/General script]
views.get("iv2").vw.setLeft((int)((2d / 100 * width)));
views.get("iv2").vw.setWidth((int)((10d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 29;BA.debugLine="iv2.SetTopAndBottom(lblEmail.Bottom,20%y)"[login/General script]
views.get("iv2").vw.setTop((int)((views.get("lblemail").vw.getTop() + views.get("lblemail").vw.getHeight())));
views.get("iv2").vw.setHeight((int)((20d / 100 * height) - ((views.get("lblemail").vw.getTop() + views.get("lblemail").vw.getHeight()))));
//BA.debugLineNum = 31;BA.debugLine="etEmail.SetLeftAndRight(iv1.Right - 1.5%x, 90%x)"[login/General script]
views.get("etemail").vw.setLeft((int)((views.get("iv1").vw.getLeft() + views.get("iv1").vw.getWidth())-(1.5d / 100 * width)));
views.get("etemail").vw.setWidth((int)((90d / 100 * width) - ((views.get("iv1").vw.getLeft() + views.get("iv1").vw.getWidth())-(1.5d / 100 * width))));
//BA.debugLineNum = 32;BA.debugLine="etEmail.SetTopAndBottom(lblEmail.Bottom,20%y)"[login/General script]
views.get("etemail").vw.setTop((int)((views.get("lblemail").vw.getTop() + views.get("lblemail").vw.getHeight())));
views.get("etemail").vw.setHeight((int)((20d / 100 * height) - ((views.get("lblemail").vw.getTop() + views.get("lblemail").vw.getHeight()))));
//BA.debugLineNum = 34;BA.debugLine="lblPass.SetLeftAndRight(2%x, 24%x)"[login/General script]
views.get("lblpass").vw.setLeft((int)((2d / 100 * width)));
views.get("lblpass").vw.setWidth((int)((24d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 35;BA.debugLine="lblPass.SetTopAndBottom(21.5%y,25%y)"[login/General script]
views.get("lblpass").vw.setTop((int)((21.5d / 100 * height)));
views.get("lblpass").vw.setHeight((int)((25d / 100 * height) - ((21.5d / 100 * height))));
//BA.debugLineNum = 37;BA.debugLine="iv3.SetLeftAndRight(4%x,10%x)"[login/General script]
views.get("iv3").vw.setLeft((int)((4d / 100 * width)));
views.get("iv3").vw.setWidth((int)((10d / 100 * width) - ((4d / 100 * width))));
//BA.debugLineNum = 38;BA.debugLine="iv3.SetTopAndBottom(lblPass.Bottom + 2%y,30.5%y)"[login/General script]
views.get("iv3").vw.setTop((int)((views.get("lblpass").vw.getTop() + views.get("lblpass").vw.getHeight())+(2d / 100 * height)));
views.get("iv3").vw.setHeight((int)((30.5d / 100 * height) - ((views.get("lblpass").vw.getTop() + views.get("lblpass").vw.getHeight())+(2d / 100 * height))));
//BA.debugLineNum = 40;BA.debugLine="iv4.SetLeftAndRight(2%x,10%x)"[login/General script]
views.get("iv4").vw.setLeft((int)((2d / 100 * width)));
views.get("iv4").vw.setWidth((int)((10d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 41;BA.debugLine="iv4.SetTopAndBottom(lblPass.Bottom,32%y)"[login/General script]
views.get("iv4").vw.setTop((int)((views.get("lblpass").vw.getTop() + views.get("lblpass").vw.getHeight())));
views.get("iv4").vw.setHeight((int)((32d / 100 * height) - ((views.get("lblpass").vw.getTop() + views.get("lblpass").vw.getHeight()))));
//BA.debugLineNum = 43;BA.debugLine="etPass.SetLeftAndRight(iv3.Right - 1.5%x, 90%x)"[login/General script]
views.get("etpass").vw.setLeft((int)((views.get("iv3").vw.getLeft() + views.get("iv3").vw.getWidth())-(1.5d / 100 * width)));
views.get("etpass").vw.setWidth((int)((90d / 100 * width) - ((views.get("iv3").vw.getLeft() + views.get("iv3").vw.getWidth())-(1.5d / 100 * width))));
//BA.debugLineNum = 44;BA.debugLine="etPass.SetTopAndBottom(lblPass.Bottom,32%y)"[login/General script]
views.get("etpass").vw.setTop((int)((views.get("lblpass").vw.getTop() + views.get("lblpass").vw.getHeight())));
views.get("etpass").vw.setHeight((int)((32d / 100 * height) - ((views.get("lblpass").vw.getTop() + views.get("lblpass").vw.getHeight()))));
//BA.debugLineNum = 46;BA.debugLine="bLogin.SetLeftAndRight(2%x, 24%x)"[login/General script]
views.get("blogin").vw.setLeft((int)((2d / 100 * width)));
views.get("blogin").vw.setWidth((int)((24d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 47;BA.debugLine="bLogin.SetTopAndBottom(38%y, 45%y)"[login/General script]
views.get("blogin").vw.setTop((int)((38d / 100 * height)));
views.get("blogin").vw.setHeight((int)((45d / 100 * height) - ((38d / 100 * height))));
//BA.debugLineNum = 49;BA.debugLine="lblOr.SetLeftAndRight(bLogin.Right,30%x)"[login/General script]
views.get("lblor").vw.setLeft((int)((views.get("blogin").vw.getLeft() + views.get("blogin").vw.getWidth())));
views.get("lblor").vw.setWidth((int)((30d / 100 * width) - ((views.get("blogin").vw.getLeft() + views.get("blogin").vw.getWidth()))));
//BA.debugLineNum = 50;BA.debugLine="lblOr.SetTopAndBottom(37%y, 45%y)"[login/General script]
views.get("lblor").vw.setTop((int)((37d / 100 * height)));
views.get("lblor").vw.setHeight((int)((45d / 100 * height) - ((37d / 100 * height))));
//BA.debugLineNum = 52;BA.debugLine="lblRegister.SetLeftAndRight(lblOr.Right,48%x)"[login/General script]
views.get("lblregister").vw.setLeft((int)((views.get("lblor").vw.getLeft() + views.get("lblor").vw.getWidth())));
views.get("lblregister").vw.setWidth((int)((48d / 100 * width) - ((views.get("lblor").vw.getLeft() + views.get("lblor").vw.getWidth()))));
//BA.debugLineNum = 53;BA.debugLine="lblRegister.SetTopAndBottom(37%y, 45%y)"[login/General script]
views.get("lblregister").vw.setTop((int)((37d / 100 * height)));
views.get("lblregister").vw.setHeight((int)((45d / 100 * height) - ((37d / 100 * height))));
//BA.debugLineNum = 55;BA.debugLine="lblForgot.SetLeftAndRight(62%x,94%x)"[login/General script]
views.get("lblforgot").vw.setLeft((int)((62d / 100 * width)));
views.get("lblforgot").vw.setWidth((int)((94d / 100 * width) - ((62d / 100 * width))));
//BA.debugLineNum = 56;BA.debugLine="lblForgot.SetTopAndBottom(37%y, 45%y)"[login/General script]
views.get("lblforgot").vw.setTop((int)((37d / 100 * height)));
views.get("lblforgot").vw.setHeight((int)((45d / 100 * height) - ((37d / 100 * height))));
//BA.debugLineNum = 58;BA.debugLine="ivFacebook.SetLeftAndRight(2%x, 95%x)"[login/General script]
views.get("ivfacebook").vw.setLeft((int)((2d / 100 * width)));
views.get("ivfacebook").vw.setWidth((int)((95d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 59;BA.debugLine="ivfacebook.SetTopAndBottom(pbadan.Bottom + 2%y, 80%y)"[login/General script]
views.get("ivfacebook").vw.setTop((int)((views.get("pbadan").vw.getTop() + views.get("pbadan").vw.getHeight())+(2d / 100 * height)));
views.get("ivfacebook").vw.setHeight((int)((80d / 100 * height) - ((views.get("pbadan").vw.getTop() + views.get("pbadan").vw.getHeight())+(2d / 100 * height))));

}
}