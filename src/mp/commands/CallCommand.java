package mp.commands;

import mp.factories.SingletonsCreator;
import util.annotations.Tags;

@Tags({"CallCommand"})
public class CallCommand implements Runnable{
	
	private String name;
	
	public CallCommand(String name) {
		this.name = name;
	}
	
	public void run() {
		SingletonsCreator.produceEnvironment().get(name).run();
	}
}
