package mp.interfaces;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"StringShape", "Locatable"})
@StructurePattern(StructurePatternNames.STRING_PATTERN)
@PropertyNames({"X", "Y", "Text"})
@EditablePropertyNames({"X", "Y", "Text"})

public interface StringShapeInterface extends LocatableInterface{
	//Getters
	public String getText();
	
	//Setters
	public void setText(String s);
}
