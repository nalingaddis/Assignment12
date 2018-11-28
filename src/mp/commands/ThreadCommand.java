package mp.commands;

import mp.factories.SingletonsCreator;
import util.annotations.Tags;

@Tags({"ThreadCommand"})
public class ThreadCommand implements Runnable{
	
	private String name;
	
	public ThreadCommand(String name) {
		this.name = name;
	}
	
	public void run() {
		Thread thread = new Thread(SingletonsCreator.produceEnvironment().get(name));
		thread.start();
	}
}
