package mp.tokens;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Number"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})


public class Number extends Token implements NumberTokenInterface{
	private int value = 0;
	
	public Number(String s) {
		super(s);
		value = Integer.parseInt(s);
	}

	public int getValue() {
		return value;
	}
}
