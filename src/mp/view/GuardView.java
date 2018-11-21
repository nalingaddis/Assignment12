package mp.view;

import java.awt.Graphics2D;

import mp.factories.SingletonsCreator;
import util.annotations.Tags;

//@Tags({"PaintListener"})
public class GuardView extends AvatarView implements AvatarViewInterface{
	public GuardView() {
		super(SingletonsCreator.produceBridgeScene().getGuard());
	}
	
	@Override
	public void paint(Graphics2D g) {
		super.paint(g);
		draw(g, SingletonsCreator.produceBridgeScene().getGuard());
	}
}
