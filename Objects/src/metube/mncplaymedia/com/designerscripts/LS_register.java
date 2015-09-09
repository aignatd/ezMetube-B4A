package metube.mncplaymedia.com.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_register{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("preg").vw.setLeft((int)(0d));
views.get("preg").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("preg").vw.setTop((int)(0d));
views.get("preg").vw.setHeight((int)((100d / 100 * height) - (0d)));
views.get("ivoke").vw.setLeft((int)((2d / 100 * width)));
views.get("ivoke").vw.setWidth((int)((40d / 100 * width) - ((2d / 100 * width))));
views.get("ivoke").vw.setTop((int)((2d / 100 * height)));
views.get("ivoke").vw.setHeight((int)((10d / 100 * height) - ((2d / 100 * height))));
views.get("lblregister").vw.setLeft((int)((2d / 100 * width)));
views.get("lblregister").vw.setWidth((int)((20d / 100 * width) - ((2d / 100 * width))));
views.get("lblregister").vw.setTop((int)((views.get("ivoke").vw.getTop() + views.get("ivoke").vw.getHeight())+(1d / 100 * height)));
views.get("lblregister").vw.setHeight((int)((14d / 100 * height) - ((views.get("ivoke").vw.getTop() + views.get("ivoke").vw.getHeight())+(1d / 100 * height))));
views.get("puser").vw.setLeft((int)((2d / 100 * width)));
views.get("puser").vw.setWidth((int)((95d / 100 * width) - ((2d / 100 * width))));
views.get("puser").vw.setTop((int)((views.get("lblregister").vw.getTop() + views.get("lblregister").vw.getHeight())+(1d / 100 * height)));
views.get("puser").vw.setHeight((int)((96d / 100 * height) - ((views.get("lblregister").vw.getTop() + views.get("lblregister").vw.getHeight())+(1d / 100 * height))));
views.get("lbluser").vw.setLeft((int)((2d / 100 * width)));
views.get("lbluser").vw.setWidth((int)((20d / 100 * width) - ((2d / 100 * width))));
views.get("lbluser").vw.setTop((int)((1d / 100 * height)));
views.get("lbluser").vw.setHeight((int)((8d / 100 * height) - ((1d / 100 * height))));
views.get("iv1").vw.setLeft((int)((4d / 100 * width)));
views.get("iv1").vw.setWidth((int)((10d / 100 * width) - ((4d / 100 * width))));
views.get("iv1").vw.setTop((int)((views.get("lbluser").vw.getTop() + views.get("lbluser").vw.getHeight())+(1d / 100 * height)));
views.get("iv1").vw.setHeight((int)((12d / 100 * height) - ((views.get("lbluser").vw.getTop() + views.get("lbluser").vw.getHeight())+(1d / 100 * height))));
views.get("iv2").vw.setLeft((int)((2d / 100 * width)));
views.get("iv2").vw.setWidth((int)((10d / 100 * width) - ((2d / 100 * width))));
views.get("iv2").vw.setTop((int)((views.get("lbluser").vw.getTop() + views.get("lbluser").vw.getHeight())));
views.get("iv2").vw.setHeight((int)((14d / 100 * height) - ((views.get("lbluser").vw.getTop() + views.get("lbluser").vw.getHeight()))));
views.get("etuser").vw.setLeft((int)((views.get("iv1").vw.getLeft() + views.get("iv1").vw.getWidth())-(1.5d / 100 * width)));
views.get("etuser").vw.setWidth((int)((90d / 100 * width) - ((views.get("iv1").vw.getLeft() + views.get("iv1").vw.getWidth())-(1.5d / 100 * width))));
views.get("etuser").vw.setTop((int)((views.get("lbluser").vw.getTop() + views.get("lbluser").vw.getHeight())));
views.get("etuser").vw.setHeight((int)((14d / 100 * height) - ((views.get("lbluser").vw.getTop() + views.get("lbluser").vw.getHeight()))));
views.get("lblfirst").vw.setLeft((int)((2d / 100 * width)));
views.get("lblfirst").vw.setWidth((int)((40d / 100 * width) - ((2d / 100 * width))));
views.get("lblfirst").vw.setTop((int)((views.get("etuser").vw.getTop() + views.get("etuser").vw.getHeight())+(1d / 100 * height)));
views.get("lblfirst").vw.setHeight((int)((20d / 100 * height) - ((views.get("etuser").vw.getTop() + views.get("etuser").vw.getHeight())+(1d / 100 * height))));
views.get("lbllast").vw.setLeft((int)((50d / 100 * width)));
views.get("lbllast").vw.setWidth((int)((90d / 100 * width) - ((50d / 100 * width))));
views.get("lbllast").vw.setTop((int)((views.get("etuser").vw.getTop() + views.get("etuser").vw.getHeight())+(1d / 100 * height)));
views.get("lbllast").vw.setHeight((int)((20d / 100 * height) - ((views.get("etuser").vw.getTop() + views.get("etuser").vw.getHeight())+(1d / 100 * height))));
views.get("etfirst").vw.setLeft((int)((2d / 100 * width)));
views.get("etfirst").vw.setWidth((int)((44d / 100 * width) - ((2d / 100 * width))));
views.get("etfirst").vw.setTop((int)((views.get("lblfirst").vw.getTop() + views.get("lblfirst").vw.getHeight())+(1d / 100 * height)));
views.get("etfirst").vw.setHeight((int)((28d / 100 * height) - ((views.get("lblfirst").vw.getTop() + views.get("lblfirst").vw.getHeight())+(1d / 100 * height))));
views.get("etlast").vw.setLeft((int)((48d / 100 * width)));
views.get("etlast").vw.setWidth((int)((90d / 100 * width) - ((48d / 100 * width))));
views.get("etlast").vw.setTop((int)((views.get("lblfirst").vw.getTop() + views.get("lblfirst").vw.getHeight())+(1d / 100 * height)));
views.get("etlast").vw.setHeight((int)((28d / 100 * height) - ((views.get("lblfirst").vw.getTop() + views.get("lblfirst").vw.getHeight())+(1d / 100 * height))));
views.get("lblmail").vw.setLeft((int)((2d / 100 * width)));
views.get("lblmail").vw.setWidth((int)((44d / 100 * width) - ((2d / 100 * width))));
views.get("lblmail").vw.setTop((int)((30d / 100 * height)));
views.get("lblmail").vw.setHeight((int)((34d / 100 * height) - ((30d / 100 * height))));
views.get("iv3").vw.setLeft((int)((4d / 100 * width)));
views.get("iv3").vw.setWidth((int)((10d / 100 * width) - ((4d / 100 * width))));
views.get("iv3").vw.setTop((int)((views.get("lblmail").vw.getTop() + views.get("lblmail").vw.getHeight())+(1d / 100 * height)));
views.get("iv3").vw.setHeight((int)((38d / 100 * height) - ((views.get("lblmail").vw.getTop() + views.get("lblmail").vw.getHeight())+(1d / 100 * height))));
views.get("iv4").vw.setLeft((int)((2d / 100 * width)));
views.get("iv4").vw.setWidth((int)((10d / 100 * width) - ((2d / 100 * width))));
views.get("iv4").vw.setTop((int)((views.get("lblmail").vw.getTop() + views.get("lblmail").vw.getHeight())));
views.get("iv4").vw.setHeight((int)((40d / 100 * height) - ((views.get("lblmail").vw.getTop() + views.get("lblmail").vw.getHeight()))));
views.get("etmail").vw.setLeft((int)((views.get("iv3").vw.getLeft() + views.get("iv3").vw.getWidth())-(1.5d / 100 * width)));
views.get("etmail").vw.setWidth((int)((90d / 100 * width) - ((views.get("iv3").vw.getLeft() + views.get("iv3").vw.getWidth())-(1.5d / 100 * width))));
views.get("etmail").vw.setTop((int)((34d / 100 * height)));
views.get("etmail").vw.setHeight((int)((40d / 100 * height) - ((34d / 100 * height))));
views.get("lblpass").vw.setLeft((int)((2d / 100 * width)));
views.get("lblpass").vw.setWidth((int)((40d / 100 * width) - ((2d / 100 * width))));
views.get("lblpass").vw.setTop((int)((42d / 100 * height)));
views.get("lblpass").vw.setHeight((int)((46d / 100 * height) - ((42d / 100 * height))));
views.get("iv5").vw.setLeft((int)((4d / 100 * width)));
views.get("iv5").vw.setWidth((int)((10d / 100 * width) - ((4d / 100 * width))));
views.get("iv5").vw.setTop((int)((views.get("lblpass").vw.getTop() + views.get("lblpass").vw.getHeight())+(1d / 100 * height)));
views.get("iv5").vw.setHeight((int)((50d / 100 * height) - ((views.get("lblpass").vw.getTop() + views.get("lblpass").vw.getHeight())+(1d / 100 * height))));
views.get("iv8").vw.setLeft((int)((2d / 100 * width)));
views.get("iv8").vw.setWidth((int)((10d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 59;BA.debugLine="iv8.SetTopAndBottom(lblPass.Bottom,52%y)"[register/General script]
views.get("iv8").vw.setTop((int)((views.get("lblpass").vw.getTop() + views.get("lblpass").vw.getHeight())));
views.get("iv8").vw.setHeight((int)((52d / 100 * height) - ((views.get("lblpass").vw.getTop() + views.get("lblpass").vw.getHeight()))));
//BA.debugLineNum = 61;BA.debugLine="etPass.SetLeftAndRight(iv5.Right - 1.5%x,90%x)"[register/General script]
views.get("etpass").vw.setLeft((int)((views.get("iv5").vw.getLeft() + views.get("iv5").vw.getWidth())-(1.5d / 100 * width)));
views.get("etpass").vw.setWidth((int)((90d / 100 * width) - ((views.get("iv5").vw.getLeft() + views.get("iv5").vw.getWidth())-(1.5d / 100 * width))));
//BA.debugLineNum = 62;BA.debugLine="etPass.SetTopAndBottom(46%y,52%y)"[register/General script]
views.get("etpass").vw.setTop((int)((46d / 100 * height)));
views.get("etpass").vw.setHeight((int)((52d / 100 * height) - ((46d / 100 * height))));
//BA.debugLineNum = 64;BA.debugLine="lblUlang.SetLeftAndRight(2%x,40%x)"[register/General script]
views.get("lblulang").vw.setLeft((int)((2d / 100 * width)));
views.get("lblulang").vw.setWidth((int)((40d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 65;BA.debugLine="lblUlang.SetTopAndBottom(54%y,57%y)"[register/General script]
views.get("lblulang").vw.setTop((int)((54d / 100 * height)));
views.get("lblulang").vw.setHeight((int)((57d / 100 * height) - ((54d / 100 * height))));
//BA.debugLineNum = 67;BA.debugLine="iv6.SetLeftAndRight(4%x,10%x)"[register/General script]
views.get("iv6").vw.setLeft((int)((4d / 100 * width)));
views.get("iv6").vw.setWidth((int)((10d / 100 * width) - ((4d / 100 * width))));
//BA.debugLineNum = 68;BA.debugLine="iv6.SetTopAndBottom(lblUlang.Bottom + 2%y,62%y)"[register/General script]
views.get("iv6").vw.setTop((int)((views.get("lblulang").vw.getTop() + views.get("lblulang").vw.getHeight())+(2d / 100 * height)));
views.get("iv6").vw.setHeight((int)((62d / 100 * height) - ((views.get("lblulang").vw.getTop() + views.get("lblulang").vw.getHeight())+(2d / 100 * height))));
//BA.debugLineNum = 70;BA.debugLine="iv7.SetLeftAndRight(2%x,10%x)"[register/General script]
views.get("iv7").vw.setLeft((int)((2d / 100 * width)));
views.get("iv7").vw.setWidth((int)((10d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 71;BA.debugLine="iv7.SetTopAndBottom(lblUlang.Bottom,64%y)"[register/General script]
views.get("iv7").vw.setTop((int)((views.get("lblulang").vw.getTop() + views.get("lblulang").vw.getHeight())));
views.get("iv7").vw.setHeight((int)((64d / 100 * height) - ((views.get("lblulang").vw.getTop() + views.get("lblulang").vw.getHeight()))));
//BA.debugLineNum = 73;BA.debugLine="etUlang.SetLeftAndRight(iv6.Right - 1.5%x,90%x)"[register/General script]
views.get("etulang").vw.setLeft((int)((views.get("iv6").vw.getLeft() + views.get("iv6").vw.getWidth())-(1.5d / 100 * width)));
views.get("etulang").vw.setWidth((int)((90d / 100 * width) - ((views.get("iv6").vw.getLeft() + views.get("iv6").vw.getWidth())-(1.5d / 100 * width))));
//BA.debugLineNum = 74;BA.debugLine="etUlang.SetTopAndBottom(lblUlang.Bottom, 64%y)"[register/General script]
views.get("etulang").vw.setTop((int)((views.get("lblulang").vw.getTop() + views.get("lblulang").vw.getHeight())));
views.get("etulang").vw.setHeight((int)((64d / 100 * height) - ((views.get("lblulang").vw.getTop() + views.get("lblulang").vw.getHeight()))));
//BA.debugLineNum = 76;BA.debugLine="cbCek.SetLeftAndRight(0%x,8%x)"[register/General script]
views.get("cbcek").vw.setLeft((int)((0d / 100 * width)));
views.get("cbcek").vw.setWidth((int)((8d / 100 * width) - ((0d / 100 * width))));
//BA.debugLineNum = 77;BA.debugLine="cbCek.SetTopAndBottom(66%y, 70%y)"[register/General script]
views.get("cbcek").vw.setTop((int)((66d / 100 * height)));
views.get("cbcek").vw.setHeight((int)((70d / 100 * height) - ((66d / 100 * height))));
//BA.debugLineNum = 79;BA.debugLine="lblCek.SetLeftAndRight(cbCek.Right + 1%x, 70%x)"[register/General script]
views.get("lblcek").vw.setLeft((int)((views.get("cbcek").vw.getLeft() + views.get("cbcek").vw.getWidth())+(1d / 100 * width)));
views.get("lblcek").vw.setWidth((int)((70d / 100 * width) - ((views.get("cbcek").vw.getLeft() + views.get("cbcek").vw.getWidth())+(1d / 100 * width))));
//BA.debugLineNum = 80;BA.debugLine="lblCek.SetTopAndBottom(66%y, 70%y)"[register/General script]
views.get("lblcek").vw.setTop((int)((66d / 100 * height)));
views.get("lblcek").vw.setHeight((int)((70d / 100 * height) - ((66d / 100 * height))));
//BA.debugLineNum = 82;BA.debugLine="bSimpan.SetLeftAndRight(2%x,30%x)"[register/General script]
views.get("bsimpan").vw.setLeft((int)((2d / 100 * width)));
views.get("bsimpan").vw.setWidth((int)((30d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 83;BA.debugLine="bSimpan.SetTopAndBottom(72%y, 80%y)"[register/General script]
views.get("bsimpan").vw.setTop((int)((72d / 100 * height)));
views.get("bsimpan").vw.setHeight((int)((80d / 100 * height) - ((72d / 100 * height))));
//BA.debugLineNum = 85;BA.debugLine="lblOr.SetLeftAndRight(bSimpan.Right + 1%x,40%x)"[register/General script]
views.get("lblor").vw.setLeft((int)((views.get("bsimpan").vw.getLeft() + views.get("bsimpan").vw.getWidth())+(1d / 100 * width)));
views.get("lblor").vw.setWidth((int)((40d / 100 * width) - ((views.get("bsimpan").vw.getLeft() + views.get("bsimpan").vw.getWidth())+(1d / 100 * width))));
//BA.debugLineNum = 86;BA.debugLine="lblOr.SetTopAndBottom(72%y, 80%y)"[register/General script]
views.get("lblor").vw.setTop((int)((72d / 100 * height)));
views.get("lblor").vw.setHeight((int)((80d / 100 * height) - ((72d / 100 * height))));
//BA.debugLineNum = 88;BA.debugLine="lblLogin.SetLeftAndRight(lblOr.Right + 1%x,70%x)"[register/General script]
views.get("lbllogin").vw.setLeft((int)((views.get("lblor").vw.getLeft() + views.get("lblor").vw.getWidth())+(1d / 100 * width)));
views.get("lbllogin").vw.setWidth((int)((70d / 100 * width) - ((views.get("lblor").vw.getLeft() + views.get("lblor").vw.getWidth())+(1d / 100 * width))));
//BA.debugLineNum = 89;BA.debugLine="lblLogin.SetTopAndBottom(72%y, 80%y)"[register/General script]
views.get("lbllogin").vw.setTop((int)((72d / 100 * height)));
views.get("lbllogin").vw.setHeight((int)((80d / 100 * height) - ((72d / 100 * height))));

}
}