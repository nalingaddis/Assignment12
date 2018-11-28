package mp.history;

import java.util.ArrayList;
import java.util.List;

import mp.commands.UndoCommandInterface;

public class DoHistory implements DoHistoryInterface{
	private List<UndoCommandInterface> history =  new ArrayList<UndoCommandInterface>();
	private int pointer = -1;
			
	public DoHistory() {
		
	}
	
	public void add(UndoCommandInterface command) {
		history.subList(pointer + 1, history.size()).clear();
		history.add(command);
		pointer++;
	}
	
	public void undo() {
		if(pointer > -1) {
			history.get(pointer).undo();
			pointer--;
		} else {
			System.out.println("Nothing to undo.");
		}
	}
	
	public void redo() {
		if(pointer < history.size()) {
			pointer++;
			history.get(pointer).run();
		} else {
			System.out.println("Nothing to redo.");
		}
	}
}
