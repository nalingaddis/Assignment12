package mp.commands;

import mp.factories.SingletonsCreator;
import util.annotations.Tags;

@Tags({"UndoCommand"})
public class UndoCommand implements Runnable{
	
	public UndoCommand() {
		
	}
	
	public void run() {
		SingletonsCreator.produceDoHistory().undo();
	}
}
