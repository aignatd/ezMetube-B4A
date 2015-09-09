package metube.mncplaymedia.com.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_daftarisi{

public static void LS_320x480_1(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("pdaftarisi").vw.setHeight((int)((20d / 100 * height)));
views.get("ivvideo").vw.setHeight((int)((views.get("pdaftarisi").vw.getHeight())-(3d / 100 * height)));
views.get("ivvideo").vw.setTop((int)((views.get("pdaftarisi").vw.getHeight())/2d - (views.get("ivvideo").vw.getHeight() / 2)));
views.get("ivvideo").vw.setWidth((int)((34d / 100 * width)));
views.get("ivdetailisi").vw.setLeft((int)((views.get("pdaftarisi").vw.getWidth())-(10d / 100 * width)));
views.get("ivdetailisi").vw.setWidth((int)((views.get("pdaftarisi").vw.getWidth()) - ((views.get("pdaftarisi").vw.getWidth())-(10d / 100 * width))));
views.get("ivdetailisi").vw.setTop((int)(0d));
views.get("ivdetailisi").vw.setHeight((int)((views.get("pdaftarisi").vw.getHeight())/2d - (0d)));
views.get("ivdetailisi").vw.setTop((int)((views.get("pdaftarisi").vw.getHeight())/2d - (views.get("ivdetailisi").vw.getHeight() / 2)));
views.get("lblinformasi").vw.setHeight((int)((views.get("ivvideo").vw.getHeight())));
views.get("lblinformasi").vw.setTop((int)((views.get("ivvideo").vw.getTop())));
views.get("lblinformasi").vw.setLeft((int)((views.get("ivvideo").vw.getLeft() + views.get("ivvideo").vw.getWidth())+(2d / 100 * width)));
views.get("lblinformasi").vw.setWidth((int)((views.get("pdaftarisi").vw.getWidth())-(views.get("ivdetailisi").vw.getWidth()) - ((views.get("ivvideo").vw.getLeft() + views.get("ivvideo").vw.getWidth())+(2d / 100 * width))));

}
public static void LS_480x320_1(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("pdaftarisi").vw.setHeight((int)((30d / 100 * height)));
views.get("ivvideo").vw.setHeight((int)((views.get("pdaftarisi").vw.getHeight())-(4d / 100 * height)));
views.get("ivvideo").vw.setTop((int)((views.get("pdaftarisi").vw.getHeight())/2d - (views.get("ivvideo").vw.getHeight() / 2)));
views.get("ivvideo").vw.setWidth((int)((30d / 100 * width)));
views.get("ivdetailisi").vw.setLeft((int)((views.get("pdaftarisi").vw.getWidth())-(10d / 100 * width)));
views.get("ivdetailisi").vw.setWidth((int)((views.get("pdaftarisi").vw.getWidth()) - ((views.get("pdaftarisi").vw.getWidth())-(10d / 100 * width))));
views.get("ivdetailisi").vw.setTop((int)(0d));
views.get("ivdetailisi").vw.setHeight((int)((views.get("pdaftarisi").vw.getHeight())/2d - (0d)));
views.get("ivdetailisi").vw.setTop((int)((views.get("pdaftarisi").vw.getHeight())/2d - (views.get("ivdetailisi").vw.getHeight() / 2)));
views.get("lblinformasi").vw.setHeight((int)((views.get("ivvideo").vw.getHeight())));
views.get("lblinformasi").vw.setTop((int)((views.get("ivvideo").vw.getTop())));
views.get("lblinformasi").vw.setLeft((int)((views.get("ivvideo").vw.getLeft() + views.get("ivvideo").vw.getWidth())+(2d / 100 * width)));
views.get("lblinformasi").vw.setWidth((int)((views.get("pdaftarisi").vw.getWidth())-(views.get("ivdetailisi").vw.getWidth()) - ((views.get("ivvideo").vw.getLeft() + views.get("ivvideo").vw.getWidth())+(2d / 100 * width))));

}
public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("pdaftarisi").vw.setLeft((int)(0d));
views.get("pdaftarisi").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("pdaftarisi").vw.setTop((int)(0d));
views.get("ivvideo").vw.setLeft((int)((2d / 100 * width)));

}
}