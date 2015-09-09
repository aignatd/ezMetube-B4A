package metube.mncplaymedia.com.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_list{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("lblbrowse").vw.setLeft((int)((2d / 100 * width)));
views.get("lblbrowse").vw.setWidth((int)((30d / 100 * width) - ((2d / 100 * width))));
views.get("lblbrowse").vw.setTop((int)((2d / 100 * height)));
views.get("lblbrowse").vw.setHeight((int)((6d / 100 * height) - ((2d / 100 * height))));
views.get("lvbrowse").vw.setLeft((int)((2d / 100 * width)));
views.get("lvbrowse").vw.setWidth((int)((100d / 100 * width) - ((2d / 100 * width))));
views.get("lvbrowse").vw.setTop((int)((views.get("lblbrowse").vw.getTop() + views.get("lblbrowse").vw.getHeight())+(1d / 100 * height)));
views.get("lvbrowse").vw.setHeight((int)((25d / 100 * height) - ((views.get("lblbrowse").vw.getTop() + views.get("lblbrowse").vw.getHeight())+(1d / 100 * height))));
views.get("lblvideo").vw.setLeft((int)((2d / 100 * width)));
views.get("lblvideo").vw.setWidth((int)((30d / 100 * width) - ((2d / 100 * width))));
views.get("lblvideo").vw.setTop((int)((views.get("lvbrowse").vw.getTop() + views.get("lvbrowse").vw.getHeight())+(1d / 100 * height)));
views.get("lblvideo").vw.setHeight((int)((30d / 100 * height) - ((views.get("lvbrowse").vw.getTop() + views.get("lvbrowse").vw.getHeight())+(1d / 100 * height))));
views.get("lvvideo").vw.setLeft((int)((2d / 100 * width)));
views.get("lvvideo").vw.setWidth((int)((100d / 100 * width) - ((2d / 100 * width))));
views.get("lvvideo").vw.setTop((int)((views.get("lblvideo").vw.getTop() + views.get("lblvideo").vw.getHeight())+(1d / 100 * height)));
views.get("lvvideo").vw.setHeight((int)((44d / 100 * height) - ((views.get("lblvideo").vw.getTop() + views.get("lblvideo").vw.getHeight())+(1d / 100 * height))));
views.get("lblcategories").vw.setLeft((int)((2d / 100 * width)));
views.get("lblcategories").vw.setWidth((int)((38d / 100 * width) - ((2d / 100 * width))));
views.get("lblcategories").vw.setTop((int)((views.get("lvvideo").vw.getTop() + views.get("lvvideo").vw.getHeight())+(1d / 100 * height)));
views.get("lblcategories").vw.setHeight((int)((49d / 100 * height) - ((views.get("lvvideo").vw.getTop() + views.get("lvvideo").vw.getHeight())+(1d / 100 * height))));
views.get("lvcate").vw.setLeft((int)((2d / 100 * width)));
views.get("lvcate").vw.setWidth((int)((100d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 20;BA.debugLine="lvCate.SetTopAndBottom(lblCategories.Bottom +1%y, 92%y)"[list/General script]
views.get("lvcate").vw.setTop((int)((views.get("lblcategories").vw.getTop() + views.get("lblcategories").vw.getHeight())+(1d / 100 * height)));
views.get("lvcate").vw.setHeight((int)((92d / 100 * height) - ((views.get("lblcategories").vw.getTop() + views.get("lblcategories").vw.getHeight())+(1d / 100 * height))));
//BA.debugLineNum = 22;BA.debugLine="lblManage.SetLeftAndRight(2%x,70%x)"[list/General script]
views.get("lblmanage").vw.setLeft((int)((2d / 100 * width)));
views.get("lblmanage").vw.setWidth((int)((70d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 23;BA.debugLine="lblManage.SetTopAndBottom(lvCate.Bottom + 1%y, 98%y)"[list/General script]
views.get("lblmanage").vw.setTop((int)((views.get("lvcate").vw.getTop() + views.get("lvcate").vw.getHeight())+(1d / 100 * height)));
views.get("lblmanage").vw.setHeight((int)((98d / 100 * height) - ((views.get("lvcate").vw.getTop() + views.get("lvcate").vw.getHeight())+(1d / 100 * height))));
//BA.debugLineNum = 25;BA.debugLine="lvManage.SetLeftAndRight(2%x,100%x)"[list/General script]
views.get("lvmanage").vw.setLeft((int)((2d / 100 * width)));
views.get("lvmanage").vw.setWidth((int)((100d / 100 * width) - ((2d / 100 * width))));
//BA.debugLineNum = 26;BA.debugLine="lvManage.SetTopAndBottom(lblManage.Bottom +1%y ,200%y)"[list/General script]
views.get("lvmanage").vw.setTop((int)((views.get("lblmanage").vw.getTop() + views.get("lblmanage").vw.getHeight())+(1d / 100 * height)));
views.get("lvmanage").vw.setHeight((int)((200d / 100 * height) - ((views.get("lblmanage").vw.getTop() + views.get("lblmanage").vw.getHeight())+(1d / 100 * height))));

}
}