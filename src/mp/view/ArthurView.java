package mp.view;

import java.awt.Graphics2D;

import mp.factories.SingletonsCreator;
import util.annotations.Tags;

//@Tags({"PaintListener"})
public class ArthurView extends AvatarView implements AvatarViewInterface{
	public ArthurView() {
		super(SingletonsCreator.produceBridgeScene().getArthur());
	}
	
	@Override
	public void paint(Graphics2D g) {
		super.paint(g);
		draw(g, SingletonsCreator.produceBridgeScene().getArthur());
	}
}
