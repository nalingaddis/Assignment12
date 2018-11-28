package mp.commands;

import mp.factories.SingletonsCreator;
import util.annotations.Tags;

@Tags({"RedoCommand"})
public class RedoCommand implements Runnable{
	
	public RedoCommand() {
		
	}
	
	public void run() {
		SingletonsCreator.produceDoHistory().redo();
	}
}
