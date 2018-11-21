package mp.commands;

import java.util.ArrayList;
import java.util.List;

import util.annotations.Tags;

@Tags({"CommandList"})
public class CommandList implements CommandListInterface{
	
	private List<Runnable> runners = new ArrayList<Runnable>();
	
	public CommandList() {
		
	}
	
	@Tags({"add"})
	public void add(Runnable runner) {
		runners.add(runner);
	}
	
	public void run() {
		for(Runnable runner:runners) {
			runner.run();
		}
	}
}
