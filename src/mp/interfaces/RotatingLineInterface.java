package mp.interfaces;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"RotatingLine", "Locatable"})
@StructurePattern(StructurePatternNames.LINE_PATTERN)
@PropertyNames({"X", "Y", "Height", "Width", "Radius", "Angle"})
@EditablePropertyNames({"X", "Y", "Radius", "Angle"})

public interface RotatingLineInterface extends LocatableInterface{
	
	//Getters	
	public int getHeight();
	
	public int getWidth();
	
	public double getRadius();
	
	public double getAngle();
	
	//Setters
	public void setRadius(double d);
	
	public void setAngle(double d);
	
	//Instance Methods
	@Tags({"rotate"})
	public void rotate(int i);
}
