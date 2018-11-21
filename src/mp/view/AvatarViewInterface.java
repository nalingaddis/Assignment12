package mp.view;

import java.awt.Graphics2D;

import mp.interfaces.AvatarInterface;
import mp.interfaces.ImageInterface;
import mp.interfaces.RotatingLineInterface;
import mp.interfaces.StringShapeInterface;

public interface AvatarViewInterface extends ViewInterface{
	public void draw(Graphics2D g, AvatarInterface avatar);
	public void draw(Graphics2D g, RotatingLineInterface line);
	public void draw(Graphics2D g, StringShapeInterface stringShape);
	public void draw(Graphics2D g, ImageInterface image);
}
