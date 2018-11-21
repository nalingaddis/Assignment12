package mp.tokens;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Word"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})

public class Word extends Token implements WordTokenInterface{
	
	private String value = "";
	
	public Word(String s) {
		super(s);
		value = s.toLowerCase();
	}
	
	public String getValue() {
		return value;
	}
}
