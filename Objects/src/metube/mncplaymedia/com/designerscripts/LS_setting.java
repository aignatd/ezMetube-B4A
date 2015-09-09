package metube.mncplaymedia.com.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_setting{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("psemua").vw.setLeft((int)(0d));
views.get("psemua").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("psemua").vw.setTop((int)(0d));
views.get("psemua").vw.setHeight((int)((100d / 100 * height) - (0d)));
views.get("patas").vw.setLeft((int)(0d));
views.get("patas").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("patas").vw.setTop((int)(0d));
views.get("patas").vw.setHeight((int)((10d / 100 * height) - (0d)));
views.get("ivback").vw.setLeft((int)((2d / 100 * width)));
views.get("ivback").vw.setWidth((int)((18d / 100 * width) - ((2d / 100 * width))));
views.get("ivback").vw.setTop((int)((2d / 100 * height)));
views.get("ivback").vw.setHeight((int)((8d / 100 * height) - ((2d / 100 * height))));
views.get("lblsetting").vw.setLeft((int)((20d / 100 * width)));
views.get("lblsetting").vw.setWidth((int)((80d / 100 * width) - ((20d / 100 * width))));
views.get("lblsetting").vw.setTop((int)((2d / 100 * height)));
views.get("lblsetting").vw.setHeight((int)((8d / 100 * height) - ((2d / 100 * height))));
views.get("lvsetting").vw.setLeft((int)(0d));
views.get("lvsetting").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("lvsetting").vw.setTop((int)((views.get("patas").vw.getTop() + views.get("patas").vw.getHeight())));
views.get("lvsetting").vw.setHeight((int)((100d / 100 * height) - ((views.get("patas").vw.getTop() + views.get("patas").vw.getHeight()))));

}
}