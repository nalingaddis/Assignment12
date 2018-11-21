package mp.view;

import java.awt.Component;

import mp.factories.SingletonsCreator;
import util.annotations.Tags;

@Tags({"DelegatingBridgeSceneView"})
public class DelegatingBridgeSceneView implements DelegatingBridgeSceneViewInterface{
	private ObservableBridgeScenePainterInterface scene = SingletonsCreator.produceObservableBridgeScenePainter();
	private ViewInterface arthurView, galahadView, guardView, lancelotView, robinView, backgroundView;
	
	public DelegatingBridgeSceneView() {
		backgroundView = new BackgroundView();
		arthurView = new ArthurView();
		galahadView = new GalahadView();
		guardView = new GuardView();
		lancelotView = new LancelotView();
		robinView = new RobinView();
		
		scene.addPaintListener(backgroundView);
		scene.addPaintListener(arthurView);
		scene.addPaintListener(galahadView);
		scene.addPaintListener(guardView);
		scene.addPaintListener(lancelotView);
		scene.addPaintListener(robinView);
	}
}
