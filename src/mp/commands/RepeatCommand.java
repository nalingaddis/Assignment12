package mp.commands;

import util.annotations.Tags;

@Tags({"RepeatCommand"})
public class RepeatCommand implements Runnable{
	
	private Runnable runner;
	private int count;
	
	public RepeatCommand(int count, Runnable runner) {
		this.count = count;
		this.runner = runner;
	}
	
	public void run() {
		for(int i = 0; i < count; i++) {
			runner.run();
		}
	}
}
