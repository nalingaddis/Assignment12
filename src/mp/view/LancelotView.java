package mp.view;

import java.awt.Graphics2D;

import mp.factories.SingletonsCreator;
import util.annotations.Tags;

//@Tags({"PaintListener"})
public class LancelotView extends AvatarView implements AvatarViewInterface{
	public LancelotView() {
		super(SingletonsCreator.produceBridgeScene().getLancelot());
	}
	
	@Override
	public void paint(Graphics2D g) {
		super.paint(g);
		draw(g, SingletonsCreator.produceBridgeScene().getLancelot());
	}
}
