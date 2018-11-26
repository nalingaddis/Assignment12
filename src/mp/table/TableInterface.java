package mp.table;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Table"})
@StructurePattern(StructurePatternNames.MAP_PATTERN)

public interface TableInterface<T> {
	public T get(String key);
	public void put(String key, T val);
	
	public void print(String key);
	public void print();
}
