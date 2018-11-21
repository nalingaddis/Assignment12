package mp.view;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;

import mp.factories.SingletonsCreator;
import mp.interfaces.BridgeSceneInterface;
import mp.interfaces.CircleInterface;
import mp.interfaces.ImageInterface;
import util.annotations.Tags;

//@Tags({"PaintListener"})
public class BackgroundView extends Component implements BackgroundViewInterface{
	
	private BridgeSceneInterface scene = SingletonsCreator.produceBridgeScene();
	
	public BackgroundView() {
		ConsoleSceneView.addBackgroundListener(scene, this);
		SingletonsCreator.produceObservableBridgeScenePainter().addPaintListener(this);
	}
	
	public void paint(Graphics2D g) {
		super.paint(g);
		draw(g, SingletonsCreator.produceBridgeScene().getGuardArea());
		draw(g, SingletonsCreator.produceBridgeScene().getKnightArea());
		draw(g, SingletonsCreator.produceBridgeScene().getGorge());
	}
	
	//Draw Circle
	public void draw(Graphics2D g, CircleInterface circle) {
		g.drawOval(circle.getX(), circle.getY(), circle.getWidth(), circle.getHeight());
	}
	
	//Draw Image
	public void draw(Graphics2D g, ImageInterface image) {
		Image img = Toolkit.getDefaultToolkit().getImage(image.getImageFileName());
		g.drawImage(img, image.getX(), image.getY(), ((ObservableBridgeScenePainter) SingletonsCreator.produceObservableBridgeScenePainter()));
	}

	public void propertyChange(PropertyChangeEvent evt) {
		((ObservableBridgeScenePainter) SingletonsCreator.produceObservableBridgeScenePainter()).repaint();
	}
}
