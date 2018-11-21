package mp.interfaces;

import shapes.Locatable;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

//@Tags({"BoundedShape", "Locatable"})
//@StructurePattern(StructurePatternNames.BEAN_PATTERN)
//@PropertyNames({"X", "Y", "Width", "Height"})
//@EditablePropertyNames({"X", "Y", "Width", "Height"})

public interface BoundedShapeInterface extends LocatableInterface{
	//Getters
	public int getWidth();
	public int getHeight();
	
	//Setters
	public void setWidth(int x);
	public void setHeight(int y);
}
