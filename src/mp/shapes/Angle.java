package mp.shapes;

import mp.interfaces.AngleInterface;
import mp.interfaces.RotatingLineInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Angle"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"RightLine", "LeftLine"})
@EditablePropertyNames({})

public class Angle implements AngleInterface{

	//Variables
	private RotatingLineInterface leftLine = new RotatingLine(40, 5, 40, 60);
	private RotatingLineInterface rightLine = new RotatingLine(40, 5, 40, 120);
	
	//Constructors
	public Angle() {
		
	}
	
	public Angle(RotatingLineInterface leftLine, RotatingLineInterface rightLine) {
		this.leftLine = leftLine;
		
		rightLine.setX(leftLine.getX());
		rightLine.setY(leftLine.getY());
		this.rightLine = rightLine;
	}
	
	//Getters
	public RotatingLineInterface getLeftLine() {
		return (RotatingLine) leftLine;
	}

	
	public RotatingLineInterface getRightLine() {
		return (RotatingLine) rightLine;
	}
	
	//Methods
	@Tags({"move"})
	public void move(int x, int y) {		
		leftLine.setX(leftLine.getX() + x);
		rightLine.setX(rightLine.getX() + x);
		
		leftLine.setY(leftLine.getY() + y);
		rightLine.setY(rightLine.getY() + y);
	}
}
