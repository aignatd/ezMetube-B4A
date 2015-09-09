package metube.mncplaymedia.com.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_coba{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[coba/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 4;BA.debugLine="lblBrowse.SetLeftAndRight(2%x,30%x)"[coba/General script]
views.get("lblbrowse").vw.setLeft((int)((2d / 100 * width)));
views.get("lblbrowse").vw.setWidth((int)((30d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 5;BA.debugLine="lblBrowse.SetTopAndBottom(2%y,6%y)"[coba/General script]
views.get("lblbrowse").vw.setTop((int)((2d / 100 * height)));
views.get("lblbrowse").vw.setHeight((int)((6d / 100 * height) - ((2d / 100 * height))));
//BA.debugLineNum = 7;BA.debugLine="lvBrowse.SetLeftAndRight(2%x,100%x)"[coba/General script]
views.get("lvbrowse").vw.setLeft((int)((2d / 100 * width)));
views.get("lvbrowse").vw.setWidth((int)((100d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 8;BA.debugLine="lvBrowse.SetTopAndBottom(lblBrowse.Bottom + 1%y, 25%y)"[coba/General script]
views.get("lvbrowse").vw.setTop((int)((views.get("lblbrowse").vw.getTop() + views.get("lblbrowse").vw.getHeight())+(1d / 100 * height)));
views.get("lvbrowse").vw.setHeight((int)((25d / 100 * height) - ((views.get("lblbrowse").vw.getTop() + views.get("lblbrowse").vw.getHeight())+(1d / 100 * height))));
//BA.debugLineNum = 10;BA.debugLine="lblVideo.SetLeftAndRight(2%x,30%x)"[coba/General script]
views.get("lblvideo").vw.setLeft((int)((2d / 100 * width)));
views.get("lblvideo").vw.setWidth((int)((30d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 11;BA.debugLine="lblVideo.SetTopAndBottom(lvBrowse.Bottom + 1%y, 30%y)"[coba/General script]
views.get("lblvideo").vw.setTop((int)((views.get("lvbrowse").vw.getTop() + views.get("lvbrowse").vw.getHeight())+(1d / 100 * height)));
views.get("lblvideo").vw.setHeight((int)((30d / 100 * height) - ((views.get("lvbrowse").vw.getTop() + views.get("lvbrowse").vw.getHeight())+(1d / 100 * height))));
//BA.debugLineNum = 13;BA.debugLine="lvVideo.SetLeftAndRight(2%x,100%x)"[coba/General script]
views.get("lvvideo").vw.setLeft((int)((2d / 100 * width)));
views.get("lvvideo").vw.setWidth((int)((100d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 14;BA.debugLine="lvVideo.SetTopAndBottom(lblVideo.Bottom +1%y, 44%y)"[coba/General script]
views.get("lvvideo").vw.setTop((int)((views.get("lblvideo").vw.getTop() + views.get("lblvideo").vw.getHeight())+(1d / 100 * height)));
views.get("lvvideo").vw.setHeight((int)((44d / 100 * height) - ((views.get("lblvideo").vw.getTop() + views.get("lblvideo").vw.getHeight())+(1d / 100 * height))));
//BA.debugLineNum = 16;BA.debugLine="lblCategories.SetLeftAndRight(2%x,38%x)"[coba/General script]
views.get("lblcategories").vw.setLeft((int)((2d / 100 * width)));
views.get("lblcategories").vw.setWidth((int)((38d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 17;BA.debugLine="lblCategories.SetTopAndBottom(lvVideo.Bottom + 1%y, 49%y)"[coba/General script]
views.get("lblcategories").vw.setTop((int)((views.get("lvvideo").vw.getTop() + views.get("lvvideo").vw.getHeight())+(1d / 100 * height)));
views.get("lblcategories").vw.setHeight((int)((49d / 100 * height) - ((views.get("lvvideo").vw.getTop() + views.get("lvvideo").vw.getHeight())+(1d / 100 * height))));
//BA.debugLineNum = 19;BA.debugLine="lvCate.SetLeftAndRight(2%x,100%x)"[coba/General script]
views.get("lvcate").vw.setLeft((int)((2d / 100 * width)));
views.get("lvcate").vw.setWidth((int)((100d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 20;BA.debugLine="lvCate.SetTopAndBottom(lblCategories.Bottom +1%y, 88%y)"[coba/General script]
views.get("lvcate").vw.setTop((int)((views.get("lblcategories").vw.getTop() + views.get("lblcategories").vw.getHeight())+(1d / 100 * height)));
views.get("lvcate").vw.setHeight((int)((88d / 100 * height) - ((views.get("lblcategories").vw.getTop() + views.get("lblcategories").vw.getHeight())+(1d / 100 * height))));

}
}