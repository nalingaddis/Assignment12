package mp.shapes;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import mp.history.PCLSupport;
import mp.history.PCLSupportInterface;
import mp.interfaces.LocatableInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Locatable"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"X", "Y", "PropertyChangeListeners"})
@EditablePropertyNames({"X", "Y"})

public abstract class Locatable implements LocatableInterface{
	private int x, y = 0;
	PCLSupportInterface propertySupport = new PCLSupport(); 
	
	//Constructors
	public Locatable() {
		
	}
	
	public Locatable(int x, int y) {
		setX(x);
		setY(y);
	}
	
	//Getters
	public int getX() {return x;}

	public int getY() {return y;}
	
	public List<PropertyChangeListener> getPropertyChangeListeners() {return propertySupport.get();}

	//Setters
	public void setX(int x) {
		int oldX = getX();
		this.x = x;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X", oldX, x));
	}

	public void setY(int y) {
		int oldY = getY();
		this.y = y;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y", oldY, y));
	}

	//Register Method
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.add(listener);
	}	
}
