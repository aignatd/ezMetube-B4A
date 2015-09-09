package metube.mncplaymedia.com.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_smartphone{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("lblmost").vw.setLeft((int)((2d / 100 * width)));
views.get("lblmost").vw.setWidth((int)((50d / 100 * width) - ((2d / 100 * width))));
views.get("lblmost").vw.setTop((int)((2d / 100 * height)));
views.get("lblmost").vw.setHeight((int)((10d / 100 * height) - ((2d / 100 * height))));
views.get("ivgaris").vw.setLeft((int)((2d / 100 * width)));
views.get("ivgaris").vw.setWidth((int)((95d / 100 * width) - ((2d / 100 * width))));
views.get("ivgaris").vw.setTop((int)((views.get("lblmost").vw.getTop() + views.get("lblmost").vw.getHeight())+(1d / 100 * height)));
views.get("ivgaris").vw.setHeight((int)((11.5d / 100 * height) - ((views.get("lblmost").vw.getTop() + views.get("lblmost").vw.getHeight())+(1d / 100 * height))));
views.get("ivgambar1").vw.setLeft((int)((2d / 100 * width)));
views.get("ivgambar1").vw.setWidth((int)((40d / 100 * width) - ((2d / 100 * width))));
views.get("ivgambar1").vw.setTop((int)((views.get("ivgaris").vw.getTop() + views.get("ivgaris").vw.getHeight())+(5d / 100 * height)));
views.get("ivgambar1").vw.setHeight((int)((40d / 100 * height) - ((views.get("ivgaris").vw.getTop() + views.get("ivgaris").vw.getHeight())+(5d / 100 * height))));
views.get("lbljudul1").vw.setLeft((int)((2d / 100 * width)));
views.get("lbljudul1").vw.setWidth((int)((40d / 100 * width) - ((2d / 100 * width))));
views.get("lbljudul1").vw.setTop((int)((views.get("ivgambar1").vw.getTop() + views.get("ivgambar1").vw.getHeight())+(1d / 100 * height)));
views.get("lbljudul1").vw.setHeight((int)((46d / 100 * height) - ((views.get("ivgambar1").vw.getTop() + views.get("ivgambar1").vw.getHeight())+(1d / 100 * height))));
views.get("label1").vw.setLeft((int)((views.get("lbljudul1").vw.getLeft())));
views.get("label1").vw.setWidth((int)((10d / 100 * width) - ((views.get("lbljudul1").vw.getLeft()))));
views.get("label1").vw.setTop((int)((views.get("lbljudul1").vw.getTop() + views.get("lbljudul1").vw.getHeight())));
views.get("label1").vw.setHeight((int)((50d / 100 * height) - ((views.get("lbljudul1").vw.getTop() + views.get("lbljudul1").vw.getHeight()))));
views.get("label6").vw.setLeft((int)((views.get("label1").vw.getLeft() + views.get("label1").vw.getWidth())));
views.get("label6").vw.setWidth((int)((views.get("lbljudul1").vw.getLeft() + views.get("lbljudul1").vw.getWidth()) - ((views.get("label1").vw.getLeft() + views.get("label1").vw.getWidth()))));
views.get("label6").vw.setTop((int)((views.get("lbljudul1").vw.getTop() + views.get("lbljudul1").vw.getHeight())));
views.get("label6").vw.setHeight((int)((50d / 100 * height) - ((views.get("lbljudul1").vw.getTop() + views.get("lbljudul1").vw.getHeight()))));
views.get("label9").vw.setLeft((int)((views.get("label1").vw.getLeft())));
views.get("label9").vw.setWidth((int)((24d / 100 * width) - ((views.get("label1").vw.getLeft()))));
views.get("label9").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())-(1.5d / 100 * height)));
views.get("label9").vw.setHeight((int)((54d / 100 * height) - ((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())-(1.5d / 100 * height))));
views.get("ivbulet").vw.setLeft((int)((views.get("label9").vw.getLeft() + views.get("label9").vw.getWidth())-(2d / 100 * width)));
views.get("ivbulet").vw.setWidth((int)((24d / 100 * width) - ((views.get("label9").vw.getLeft() + views.get("label9").vw.getWidth())-(2d / 100 * width))));
views.get("ivbulet").vw.setTop((int)((views.get("label6").vw.getTop() + views.get("label6").vw.getHeight())+(1d / 100 * height)));
views.get("ivbulet").vw.setHeight((int)((52d / 100 * height) - ((views.get("label6").vw.getTop() + views.get("label6").vw.getHeight())+(1d / 100 * height))));
views.get("lblview").vw.setLeft((int)((views.get("ivbulet").vw.getLeft() + views.get("ivbulet").vw.getWidth())+(1d / 100 * width)));
views.get("lblview").vw.setWidth((int)((34d / 100 * width) - ((views.get("ivbulet").vw.getLeft() + views.get("ivbulet").vw.getWidth())+(1d / 100 * width))));
views.get("lblview").vw.setTop((int)((views.get("label6").vw.getTop() + views.get("label6").vw.getHeight())-(1.5d / 100 * height)));
views.get("lblview").vw.setHeight((int)((54d / 100 * height) - ((views.get("label6").vw.getTop() + views.get("label6").vw.getHeight())-(1.5d / 100 * height))));
views.get("ivgambar2").vw.setLeft((int)((56d / 100 * width)));
views.get("ivgambar2").vw.setWidth((int)((95d / 100 * width) - ((56d / 100 * width))));
views.get("ivgambar2").vw.setTop((int)((views.get("ivgaris").vw.getTop() + views.get("ivgaris").vw.getHeight())+(5d / 100 * height)));
views.get("ivgambar2").vw.setHeight((int)((40d / 100 * height) - ((views.get("ivgaris").vw.getTop() + views.get("ivgaris").vw.getHeight())+(5d / 100 * height))));
views.get("lbljudul2").vw.setLeft((int)((56d / 100 * width)));
views.get("lbljudul2").vw.setWidth((int)((95d / 100 * width) - ((56d / 100 * width))));
views.get("lbljudul2").vw.setTop((int)((views.get("ivgambar2").vw.getTop() + views.get("ivgambar2").vw.getHeight())+(1d / 100 * height)));
views.get("lbljudul2").vw.setHeight((int)((46d / 100 * height) - ((views.get("ivgambar2").vw.getTop() + views.get("ivgambar2").vw.getHeight())+(1d / 100 * height))));
views.get("ivgambar3").vw.setLeft((int)((2d / 100 * width)));
views.get("ivgambar3").vw.setWidth((int)((40d / 100 * width) - ((2d / 100 * width))));
views.get("ivgambar3").vw.setTop((int)((58d / 100 * height)));
views.get("ivgambar3").vw.setHeight((int)((80d / 100 * height) - ((58d / 100 * height))));
views.get("lbljudul3").vw.setLeft((int)((2d / 100 * width)));
views.get("lbljudul3").vw.setWidth((int)((40d / 100 * width) - ((2d / 100 * width))));
views.get("lbljudul3").vw.setTop((int)((views.get("ivgambar3").vw.getTop() + views.get("ivgambar3").vw.getHeight())+(1d / 100 * height)));
views.get("lbljudul3").vw.setHeight((int)((86d / 100 * height) - ((views.get("ivgambar3").vw.getTop() + views.get("ivgambar3").vw.getHeight())+(1d / 100 * height))));
views.get("ivgambar4").vw.setLeft((int)((56d / 100 * width)));
views.get("ivgambar4").vw.setWidth((int)((95d / 100 * width) - ((56d / 100 * width))));
views.get("ivgambar4").vw.setTop((int)((58d / 100 * height)));
views.get("ivgambar4").vw.setHeight((int)((80d / 100 * height) - ((58d / 100 * height))));
views.get("lbljudul4").vw.setLeft((int)((56d / 100 * width)));
views.get("lbljudul4").vw.setWidth((int)((95d / 100 * width) - ((56d / 100 * width))));
views.get("lbljudul4").vw.setTop((int)((views.get("ivgambar4").vw.getTop() + views.get("ivgambar4").vw.getHeight())+(1d / 100 * height)));
views.get("lbljudul4").vw.setHeight((int)((86d / 100 * height) - ((views.get("ivgambar4").vw.getTop() + views.get("ivgambar4").vw.getHeight())+(1d / 100 * height))));
views.get("bmore").vw.setLeft((int)((2d / 100 * width)));
views.get("bmore").vw.setWidth((int)((95d / 100 * width) - ((2d / 100 * width))));
views.get("bmore").vw.setTop((int)((92d / 100 * height)));
views.get("bmore").vw.setHeight((int)((100d / 100 * height) - ((92d / 100 * height))));

}
}