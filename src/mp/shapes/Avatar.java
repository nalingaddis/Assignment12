package mp.shapes;

import mp.interfaces.AngleInterface;
import mp.interfaces.AvatarInterface;
import mp.interfaces.ImageInterface;
import mp.interfaces.RotatingLineInterface;
import mp.interfaces.StringShapeInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Avatar"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"StringShape", "Head", "Arms", "Legs", "Torso"})
@EditablePropertyNames({})

public class Avatar implements AvatarInterface{
	private static final int LIMB_LENGTH = 40;
	private static final int LIMB_ANGLE = 60;
	private static final int BODY_ANGLE = 90;
	private static final int X = 0, Y = 0;
	
	private double scale = 1;
	
	private RotatingLineInterface leftArm = new RotatingLine(X, Y, scale*LIMB_LENGTH, BODY_ANGLE+LIMB_ANGLE/2);
	private RotatingLineInterface rightArm = new RotatingLine(X, Y, scale*LIMB_LENGTH, BODY_ANGLE-LIMB_ANGLE/2);
	
	private RotatingLineInterface leftLeg = new RotatingLine(X, (int)(Y+(scale*LIMB_LENGTH)), scale*LIMB_LENGTH, BODY_ANGLE+LIMB_ANGLE/2);
	private RotatingLineInterface rightLeg = new RotatingLine(X, (int)(Y+(scale*LIMB_LENGTH)), scale*LIMB_LENGTH, BODY_ANGLE-LIMB_ANGLE/2);
	
	private StringShapeInterface stringShape = new StringShape(X, Y, "Howdy!");
	private ImageInterface head = new Image("lancelot.jpg");
	private AngleInterface arms = new Angle(leftArm, rightArm);
	private AngleInterface legs = new Angle(leftLeg, rightLeg);
	private RotatingLineInterface torso = new RotatingLine(X, Y, scale*LIMB_LENGTH, BODY_ANGLE);
	
	//Constructors
	public Avatar() {
		redraw();
	}
	
	public Avatar(ImageInterface head) {
		this.head = head;
		redraw();
	}
	
	public Avatar(int x, int y, ImageInterface head) {
		this.head = head;
		
		head.setX(x);
		head.setY(y);
		
		redraw();
	}
	
	//Getters
	public StringShapeInterface getStringShape() {return stringShape;}

	public ImageInterface getHead() {return head;}

	public AngleInterface getArms() {return arms;}

	public AngleInterface getLegs() {return legs;}

	public RotatingLineInterface getTorso() {return torso;}
	
	//Methods
	@Tags({"move"})
	public void move(int x, int y) {
		head.setX(head.getX() + x);
		head.setY(head.getY() + y);
		redraw();
	}
	
	public void redraw() {
		int stringOffsetX = 5;
		int stringOffsetY = 0;
		
		int tempX = head.getX() + (int)(head.getWidth()/2);
		int tempY = head.getY() + head.getHeight();
		
		stringShape.setX(tempX + head.getWidth()/2 + stringOffsetX);
		stringShape.setY(tempY - head.getHeight()/2 + stringOffsetY);
		
		arms.move(tempX - arms.getLeftLine().getX(), tempY - arms.getLeftLine().getY());
		
		legs.move(tempX - legs.getLeftLine().getX(), tempY + (int)(torso.getRadius()) - legs.getLeftLine().getY());
		
		torso.setX(tempX);
		torso.setY(tempY);
	}
	
	@Tags({"setText"})
	public void setText(String s) {
		stringShape.setText(s);
	}
	
	public void changeLegAngle(int angle) {
		legs.getLeftLine().setAngle(BODY_ANGLE + angle/2);
		legs.getRightLine().setAngle(BODY_ANGLE - angle/2);
	}
	
	@Tags({"scale"})
	public void scale(double scale) {
		this.scale = scale;
		
		head.setWidth((int)(head.getWidth() * scale)); 
		head.setHeight((int)(head.getHeight() * scale)); 
		
		arms.getLeftLine().setRadius(scale*arms.getLeftLine().getRadius());
		arms.getRightLine().setRadius(scale*arms.getRightLine().getRadius());
		
		legs.getLeftLine().setRadius(scale*legs.getLeftLine().getRadius());
		legs.getRightLine().setRadius(scale*legs.getRightLine().getRadius());
		
		torso.setRadius(scale*torso.getRadius());
		
		redraw();
	}
}
