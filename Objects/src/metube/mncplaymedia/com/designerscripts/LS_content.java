package metube.mncplaymedia.com.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_content{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("pcontent").vw.setLeft((int)(0d));
views.get("pcontent").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("pcontent").vw.setTop((int)(0d));
views.get("pcontent").vw.setHeight((int)((100d / 100 * height) - (0d)));
views.get("patas").vw.setLeft((int)(0d));
views.get("patas").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("patas").vw.setTop((int)(0d));
views.get("patas").vw.setHeight((int)((10d / 100 * height) - (0d)));
views.get("ivvideo").vw.setLeft((int)(0d));
views.get("ivvideo").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("ivvideo").vw.setTop((int)((views.get("patas").vw.getTop() + views.get("patas").vw.getHeight())));
views.get("ivvideo").vw.setHeight((int)((50d / 100 * height) - ((views.get("patas").vw.getTop() + views.get("patas").vw.getHeight()))));
views.get("ivback").vw.setLeft((int)((2d / 100 * width)));
views.get("ivback").vw.setWidth((int)((10d / 100 * width) - ((2d / 100 * width))));
views.get("ivback").vw.setTop((int)((2d / 100 * height)));
views.get("ivback").vw.setHeight((int)((8d / 100 * height) - ((2d / 100 * height))));
views.get("ivmetube").vw.setLeft((int)((35d / 100 * width)));
views.get("ivmetube").vw.setWidth((int)((65d / 100 * width) - ((35d / 100 * width))));
views.get("ivmetube").vw.setTop((int)((2d / 100 * height)));
views.get("ivmetube").vw.setHeight((int)((8d / 100 * height) - ((2d / 100 * height))));
views.get("ivplay").vw.setLeft((int)((40d / 100 * width)));
views.get("ivplay").vw.setWidth((int)((60d / 100 * width) - ((40d / 100 * width))));
//BA.debugLineNum = 20;BA.debugLine="ivplay.SetTopAndBottom(20%y, 35%y)"[content/General script]
views.get("ivplay").vw.setTop((int)((20d / 100 * height)));
views.get("ivplay").vw.setHeight((int)((35d / 100 * height) - ((20d / 100 * height))));

}
}