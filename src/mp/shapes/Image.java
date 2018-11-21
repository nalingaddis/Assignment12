package mp.shapes;

import java.beans.PropertyChangeEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import mp.interfaces.ImageInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Image"})
@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
@PropertyNames({"X", "Y", "Height", "Width", "ImageFileName"})
@EditablePropertyNames({"X", "Y", "Height", "Width", "ImageFileName"})

public class Image extends BoundedShape implements ImageInterface{
	private String imageFileName = "";
	
	//Constructors
	public Image() {
		
	}
	
	public Image(String s) {
		Icon icon = new ImageIcon(s);
		
		setHeight(icon.getIconHeight());
		setWidth(icon.getIconWidth());
		
		setImageFileName(s);
	}
	
	public Image(int x, int y, String s) {
		Icon icon = new ImageIcon(s);
		setHeight(icon.getIconHeight());
		setWidth(icon.getIconWidth());
		setImageFileName(s);
		
		setX(x);
		setY(y);
	}
	
	public Image(int x, int y, int width, int height, String s) {
		super(x,y,width,height);
		setImageFileName(s);
	}
	
	//Getters
	public String getImageFileName() {return imageFileName;}
	
	//Setters
	public void setImageFileName(String s) {
		String oldFileName = getImageFileName();
		
		this.imageFileName = s;
		
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "ImageFileName", oldFileName, getImageFileName()));
	}
}
