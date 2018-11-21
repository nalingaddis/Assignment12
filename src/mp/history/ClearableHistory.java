package mp.history;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"ClearableHistory"})
@StructurePattern(StructurePatternNames.VECTOR_PATTERN)

public class ClearableHistory extends BaseStringHistory implements ClearableHistoryInterface{
	public ClearableHistory() {
		super();
	}
	
	@Tags({"Clear"})
	public void clear() {
		size = 0;
	}
}
