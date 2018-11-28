package mp.commands;

import mp.factories.SingletonsCreator;
import util.annotations.Tags;

@Tags({"DefineCommand"})
public class DefineCommand implements Runnable{
	
	private String name;
	private Runnable command;
	
	public DefineCommand(String name, Runnable command) {
		this.name = name;
		this.command = command;
	}
	
	public void run() {
		SingletonsCreator.produceEnvironment().put(name, command);
	}
}
