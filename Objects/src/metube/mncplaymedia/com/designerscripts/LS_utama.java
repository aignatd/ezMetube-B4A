package metube.mncplaymedia.com.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_utama{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("psemua").vw.setLeft((int)(0-(65d / 100 * width)));
views.get("psemua").vw.setWidth((int)((100d / 100 * width) - (0-(65d / 100 * width))));
views.get("psemua").vw.setTop((int)(0d));
views.get("psemua").vw.setHeight((int)((100d / 100 * height) - (0d)));
views.get("pmenukiri").vw.setLeft((int)(0d));
views.get("pmenukiri").vw.setWidth((int)((65d / 100 * width) - (0d)));
views.get("pmenukiri").vw.setTop((int)(0d));
views.get("pmenukiri").vw.setHeight((int)((100d / 100 * height) - (0d)));
views.get("patas").vw.setLeft((int)(0d));
views.get("patas").vw.setWidth((int)((views.get("pmenukiri").vw.getWidth()) - (0d)));
views.get("patas").vw.setTop((int)(0d));
views.get("patas").vw.setHeight((int)((10d / 100 * height) - (0d)));
views.get("ivclose").vw.setLeft((int)((2d / 100 * width)));
views.get("ivclose").vw.setWidth((int)((10d / 100 * width) - ((2d / 100 * width))));
views.get("ivclose").vw.setTop((int)((3d / 100 * width)));
views.get("ivclose").vw.setHeight((int)((7d / 100 * height) - ((3d / 100 * width))));
views.get("ivsetting").vw.setLeft((int)((55d / 100 * width)));
views.get("ivsetting").vw.setWidth((int)((64d / 100 * width) - ((55d / 100 * width))));
views.get("ivsetting").vw.setTop((int)((3d / 100 * width)));
views.get("ivsetting").vw.setHeight((int)((7d / 100 * height) - ((3d / 100 * width))));
views.get("lbllogin").vw.setLeft((int)((2d / 100 * width)));
views.get("lbllogin").vw.setWidth((int)((views.get("pmenukiri").vw.getWidth()) - ((2d / 100 * width))));
views.get("lbllogin").vw.setTop((int)((views.get("patas").vw.getTop() + views.get("patas").vw.getHeight())));
views.get("lbllogin").vw.setHeight((int)((18d / 100 * height) - ((views.get("patas").vw.getTop() + views.get("patas").vw.getHeight()))));
views.get("svlist").vw.setLeft((int)((0d / 100 * width)));
views.get("svlist").vw.setWidth((int)((65d / 100 * width) - ((0d / 100 * width))));
views.get("svlist").vw.setTop((int)((views.get("lbllogin").vw.getTop() + views.get("lbllogin").vw.getHeight())+(1d / 100 * height)));
views.get("svlist").vw.setHeight((int)((100d / 100 * height) - ((views.get("lbllogin").vw.getTop() + views.get("lbllogin").vw.getHeight())+(1d / 100 * height))));
views.get("ivgaris").vw.setLeft((int)(0d));
views.get("ivgaris").vw.setWidth((int)((views.get("pmenukiri").vw.getWidth()) - (0d)));
views.get("ivgaris").vw.setTop((int)((views.get("lbllogin").vw.getTop() + views.get("lbllogin").vw.getHeight())));
views.get("ivgaris").vw.setHeight((int)((views.get("svlist").vw.getTop()) - ((views.get("lbllogin").vw.getTop() + views.get("lbllogin").vw.getHeight()))));
views.get("ptop").vw.setLeft((int)((views.get("pmenukiri").vw.getLeft() + views.get("pmenukiri").vw.getWidth())));
views.get("ptop").vw.setWidth((int)((views.get("psemua").vw.getWidth()) - ((views.get("pmenukiri").vw.getLeft() + views.get("pmenukiri").vw.getWidth()))));
views.get("ptop").vw.setTop((int)(0d));
views.get("ptop").vw.setHeight((int)((10d / 100 * height) - (0d)));
views.get("ivmenu").vw.setLeft((int)((2d / 100 * width)));
views.get("ivmenu").vw.setWidth((int)((10d / 100 * width) - ((2d / 100 * width))));
views.get("ivmenu").vw.setTop((int)((2d / 100 * height)));
views.get("ivmenu").vw.setHeight((int)((7d / 100 * height) - ((2d / 100 * height))));
views.get("ivsearch").vw.setLeft((int)((88d / 100 * width)));
views.get("ivsearch").vw.setWidth((int)((96d / 100 * width) - ((88d / 100 * width))));
views.get("ivsearch").vw.setTop((int)((2d / 100 * height)));
views.get("ivsearch").vw.setHeight((int)((7d / 100 * height) - ((2d / 100 * height))));
views.get("ivmetube").vw.setLeft((int)((30d / 100 * width)));
views.get("ivmetube").vw.setWidth((int)((65d / 100 * width) - ((30d / 100 * width))));
views.get("ivmetube").vw.setTop((int)((2d / 100 * height)));
views.get("ivmetube").vw.setHeight((int)((8d / 100 * height) - ((2d / 100 * height))));
views.get("pcoverflow").vw.setLeft((int)((views.get("pmenukiri").vw.getLeft() + views.get("pmenukiri").vw.getWidth())));
views.get("pcoverflow").vw.setWidth((int)((views.get("psemua").vw.getWidth()) - ((views.get("pmenukiri").vw.getLeft() + views.get("pmenukiri").vw.getWidth()))));
views.get("pcoverflow").vw.setTop((int)((views.get("ptop").vw.getTop() + views.get("ptop").vw.getHeight())));
views.get("pcoverflow").vw.setHeight((int)((40d / 100 * height) - ((views.get("ptop").vw.getTop() + views.get("ptop").vw.getHeight()))));
views.get("svutama").vw.setLeft((int)((views.get("pmenukiri").vw.getLeft() + views.get("pmenukiri").vw.getWidth())));
views.get("svutama").vw.setWidth((int)((views.get("psemua").vw.getWidth()) - ((views.get("pmenukiri").vw.getLeft() + views.get("pmenukiri").vw.getWidth()))));
views.get("svutama").vw.setTop((int)((views.get("pcoverflow").vw.getTop() + views.get("pcoverflow").vw.getHeight())));
views.get("svutama").vw.setHeight((int)((100d / 100 * height) - ((views.get("pcoverflow").vw.getTop() + views.get("pcoverflow").vw.getHeight()))));
views.get("etsearch").vw.setTop((int)((views.get("ptop").vw.getTop() + views.get("ptop").vw.getHeight())));
views.get("etsearch").vw.setHeight((int)((views.get("ptop").vw.getTop() + views.get("ptop").vw.getHeight()) - ((views.get("ptop").vw.getTop() + views.get("ptop").vw.getHeight()))));
views.get("etsearch").vw.setLeft((int)(0d));
views.get("etsearch").vw.setWidth((int)((100d / 100 * width) - (0d)));

}
}