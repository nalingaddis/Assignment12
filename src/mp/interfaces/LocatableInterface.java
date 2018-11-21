package mp.interfaces;

import java.beans.PropertyChangeListener;
import java.util.List;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

//@Tags({"Locatable"})
//@StructurePattern(StructurePatternNames.BEAN_PATTERN)
//@PropertyNames({"X", "Y"})
//@EditablePropertyNames({"X", "Y"})

public interface LocatableInterface extends PropertyListenerRegisterer{
	//Getters
	public int getX();
	public int getY();
	public List<PropertyChangeListener> getPropertyChangeListeners();
	
	//Setters
	public void setX(int x);
	public void setY(int y);
}
