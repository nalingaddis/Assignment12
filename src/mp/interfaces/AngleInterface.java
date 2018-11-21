package mp.interfaces;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Angle", "BoundedShape"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"RightLine", "LeftLine"})
@EditablePropertyNames({})

public interface AngleInterface{
	//Getters
	public RotatingLineInterface getLeftLine();
	public RotatingLineInterface getRightLine();
	
	//Methods
	@Tags({"move"})
	public void move(int x, int y);
}
