package mp.view;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;

import mp.factories.SingletonsCreator;
import mp.interfaces.AvatarInterface;
import mp.interfaces.ImageInterface;
import mp.interfaces.RotatingLineInterface;
import mp.interfaces.StringShapeInterface;
import util.annotations.Tags;

//@Tags({"PaintListener"})
public class AvatarView extends Component implements AvatarViewInterface{
	
	public AvatarView() {
		
	}
	
	protected AvatarView(AvatarInterface avatar) {
		ConsoleSceneView.addAvatarListener(avatar, this);
		SingletonsCreator.produceObservableBridgeScenePainter().addPaintListener(this);
	}

	@Override
	public void paint(Graphics2D g) {
		super.paint(g);
	}
	
	//Draw Avatar
	public void draw(Graphics2D g, AvatarInterface avatar){
		draw(g, avatar.getHead());
		draw(g, avatar.getStringShape());
		
		draw(g, avatar.getArms().getLeftLine());
		draw(g, avatar.getArms().getRightLine());
		
		draw(g, avatar.getTorso());
		
		draw(g, avatar.getLegs().getLeftLine());
		draw(g, avatar.getLegs().getRightLine());
	}
	
	//Draw Line
	public void draw(Graphics2D g, RotatingLineInterface line) {
		g.drawLine(line.getX(), line.getY(), line.getX() + line.getWidth(), line.getY() + line.getHeight());
	}
	
	//Draw Image
	public void draw(Graphics2D g, ImageInterface image) {
		Image img = Toolkit.getDefaultToolkit().getImage(image.getImageFileName());
		g.drawImage(img, image.getX(), image.getY(), ((ObservableBridgeScenePainter) SingletonsCreator.produceObservableBridgeScenePainter()));
	}
	
	//Draw String
	public void draw(Graphics2D g, StringShapeInterface stringShape) {
		g.drawString(stringShape.getText(), stringShape.getX(), stringShape.getY());	
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		((ObservableBridgeScenePainter) SingletonsCreator.produceObservableBridgeScenePainter()).repaint();
	}
}
