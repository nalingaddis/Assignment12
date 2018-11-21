package mp.view;

import java.awt.Graphics2D;

import mp.factories.SingletonsCreator;
import util.annotations.Tags;

//@Tags({"PaintListener"})
public class GalahadView extends AvatarView implements AvatarViewInterface{
	public GalahadView() {
		super(SingletonsCreator.produceBridgeScene().getGalahad());
	}
	
	@Override
	public void paint(Graphics2D g) {
		super.paint(g);
		draw(g, SingletonsCreator.produceBridgeScene().getGalahad());
	}
}
