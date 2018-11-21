package mp.view;

import java.awt.Graphics2D;

import mp.interfaces.CircleInterface;
import mp.interfaces.ImageInterface;

public interface BackgroundViewInterface extends ViewInterface{
	public void draw(Graphics2D g, CircleInterface circle);
	public void draw(Graphics2D g, ImageInterface image);
}
