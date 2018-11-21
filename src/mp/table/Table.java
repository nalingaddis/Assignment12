package mp.table;

import java.util.ArrayList;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Table"})
@StructurePattern(StructurePatternNames.MAP_PATTERN)
public class Table implements TableInterface{
	
	ArrayList<ArrayList<Object>> table = new ArrayList<>();
	
	//Constructors
	public Table() {
		table.add(new ArrayList<Object>());
		table.add(new ArrayList<Object>());
	}
	
	//Methods
	public Object get(String key) {
		if(table.get(0).indexOf(key) == -1) {
			return null;
		} else {
			return table.get(1).get(table.get(0).indexOf(key));
		}
	}
	
	public void put(String key, Object val) {
		if(get(key) == null) {
			table.get(0).add(key);
			table.get(1).add(val);
		} else {
			table.get(1).set(table.get(0).indexOf(key), val);
		}
	}
	
	public void print(String key) {
		System.out.println("Key: " + key + ", Value: " + this.get(key));
	}
	
	public void print() {
		for(int i = 0; i < table.get(0).size(); i++) {
			print((String) table.get(0).get(i));
		}
	}
}
