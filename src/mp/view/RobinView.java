package mp.view;

import java.awt.Graphics2D;

import mp.factories.SingletonsCreator;
import util.annotations.Tags;

//@Tags({"PaintListener"})
public class RobinView extends AvatarView implements AvatarViewInterface{
	public RobinView() {
		super(SingletonsCreator.produceBridgeScene().getRobin());
	}
	
	@Override
	public void paint(Graphics2D g) {
		super.paint(g);
		draw(g, SingletonsCreator.produceBridgeScene().getRobin());
	}
}
