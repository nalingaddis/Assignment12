package mp.table;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Table"})
@StructurePattern(StructurePatternNames.MAP_PATTERN)

public interface TableInterface {
	public Object get(String key);
	public void put(String key, Object val);
	
	public void print(String key);
	public void print();
}
