package mp.shapes;

import java.beans.PropertyChangeEvent;

import mp.interfaces.StringShapeInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"StringShape"})
@StructurePattern(StructurePatternNames.STRING_PATTERN)
@PropertyNames({"X", "Y", "Text"})
@EditablePropertyNames({"X", "Y", "Text"})

public class StringShape extends Locatable implements StringShapeInterface{
	private String text = "";
	
	
	//Constructors
	public StringShape() {
		
	}
	
	public StringShape(String s) {
		setText(s);
	}
	
	public StringShape(int x, int y, String s) {
		super(x,y);
		setText(s);
	}
	
	//Getters
	public String getText() {return text;}
	
	//Setters
	public void setText(String s) {
		String oldText = getText();
		
		text = s;
		
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Text", oldText, getText()));
	}

}
