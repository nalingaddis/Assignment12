package mp.shapes;

import java.beans.PropertyChangeEvent;

import mp.interfaces.RotatingLineInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"RotatingLine"})
@StructurePattern(StructurePatternNames.LINE_PATTERN)
@PropertyNames({"X", "Y", "Height", "Width", "Radius", "Angle"})
@EditablePropertyNames({"X", "Y", "Radius", "Angle"})

public class RotatingLine extends Locatable implements RotatingLineInterface{
	private double radius, angle = 0;
	
	//Constructors
	public RotatingLine() {
		
	}
	
	public RotatingLine(double radius, double angle) {
		setRadius(radius);
		setAngle(angle);
	}
	
	public RotatingLine(int x, int y, double radius, double angle) {
		setX(x);
		setY(y);
		setRadius(radius);
		setAngle(angle);
	}
	
	
	//Getters 
	public int getWidth() {return (int)(radius * Math.cos((Math.PI/180) * angle));}
	
	public int getHeight() {return (int)(radius * Math.sin((Math.PI/180) * angle));}
	
	public double getRadius() {return radius;}
	
	public double getAngle() {return angle;}
	
	//Setters
	public void setRadius(double d) {
		double oldRadius = getRadius();
		int oldWidth = getWidth();
		int oldHeight = getHeight();
		
		radius = d;
		
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Radius", oldRadius, radius));
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Width", oldWidth, getWidth()));
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Height", oldHeight, getHeight()));
	}
	
	public void setAngle(double d) {
		double oldAngle = getAngle();
		int oldWidth = getWidth();
		int oldHeight = getHeight();
		
		angle = d;
		
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Angle", oldAngle, angle));
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Width", oldWidth, getWidth()));
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Height", oldHeight, getHeight()));
	}
	
	//Instance Methods
	@Tags({"rotate"})
	public void rotate(int i) {
		int oldWidth = getWidth();
		int oldHeight = getHeight();
		
		setAngle(i);
		
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Width", oldWidth, getWidth()));
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Height", oldHeight, getHeight()));
	}
}
