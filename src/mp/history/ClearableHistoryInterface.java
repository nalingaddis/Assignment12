package mp.history;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"ClearableHistory"})
@StructurePattern(StructurePatternNames.VECTOR_PATTERN)

public interface ClearableHistoryInterface extends BaseStringHistoryInterface{
	@Tags({"Clear"})
	public void clear();
}
