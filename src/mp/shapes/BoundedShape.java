package mp.shapes;

import java.beans.PropertyChangeEvent;

import mp.interfaces.BoundedShapeInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"BoundedShape"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"X", "Y", "Width", "Height"})
@EditablePropertyNames({"X", "Y", "Width", "Height"})

public abstract class BoundedShape extends Locatable implements BoundedShapeInterface{
	private int width, height = 0;
	
	//Constructors
	public BoundedShape() {
		super();
	}
	
	public BoundedShape(int x, int y) {
		setWidth(x);
		setHeight(y);
	}
	
	public BoundedShape(int x, int y, int width, int height) {
		super(x,y);
		setWidth(width);
		setHeight(height);
	}
	
	//Getters
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	
	//Setters
	public void setWidth(int x) {
		int oldWidth = getWidth();
		this.width = x;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Width", oldWidth, x));
	}
	
	public void setHeight(int y) {
		int oldHeight = getHeight();
		this.height = y;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Height", oldHeight, y));
	}
}
