package mp.table;

import java.util.ArrayList;
import java.util.List;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Table"})
@StructurePattern(StructurePatternNames.MAP_PATTERN)
public class Table<T> implements TableInterface<T>{
	
	List<String> keys = new ArrayList<>();
	List<T> objects = new ArrayList<>();
	
	//Constructors
	public Table() {
		
	}
	
	//Methods
	public T get(String key) {
		if(keys.indexOf(key) == -1) {
			return null;
		} else {
			return (T) objects.get(keys.get(0).indexOf(key));
		}
	}
	
	public void put(String key, T val) {
		if(get(key) == null) {
			keys.add(key);
			objects.add(val);
		} else {
			objects.set(keys.indexOf(key), val);
		}
	}
	
	public void print(String key) {
		System.out.println("Key: " + key + ", Value: " + this.get(key));
	}
	
	public void print() {
		for(String key:keys) {
			print(key);
		}
	}
}
