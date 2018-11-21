package mp.interfaces;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Avatar"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"StringShape", "Head", "Arms", "Legs", "Torso"})
@EditablePropertyNames({})

public interface AvatarInterface {
	//Getters
	public StringShapeInterface getStringShape();
	public ImageInterface getHead();
	public AngleInterface getArms();
	public AngleInterface getLegs();
	public RotatingLineInterface getTorso();
	
	//Methods
	@Tags({"move"})
	public void move(int x, int y);
	
	public void redraw();
	public void setText(String s);
	public void changeLegAngle(int angle);
	@Tags({"scale"})
	public void scale(double scale);
}
