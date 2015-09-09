package metube.mncplaymedia.com.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_listkiri{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("lblnama").vw.setLeft((int)((2d / 100 * width)));
views.get("lblnama").vw.setWidth((int)((65d / 100 * width) - ((2d / 100 * width))));
views.get("lblnama").vw.setTop((int)((2d / 100 * height)));
views.get("lblnama").vw.setHeight((int)((10d / 100 * height) - ((2d / 100 * height))));
views.get("lvkiri").vw.setLeft((int)((2d / 100 * width)));
views.get("lvkiri").vw.setWidth((int)((65d / 100 * width) - ((2d / 100 * width))));
views.get("lvkiri").vw.setTop((int)((12d / 100 * height)));
views.get("lvkiri").vw.setHeight((int)((100d / 100 * height) - ((12d / 100 * height))));

}
}