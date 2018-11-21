package mp.tokens;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Token"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input"})
@EditablePropertyNames({"Input"})

public abstract class Token implements TokenInterface{
	private String input = "";
	
	//Constructors
	public Token(String s) {
		input = s;
	}
	
	//Getters
	public String getInput() {
		return input;
	}
	
	//Setters
	public void setInput(String s) {
		input = s;
	}
}
