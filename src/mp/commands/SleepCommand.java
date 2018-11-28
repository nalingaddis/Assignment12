package mp.commands;

import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({"SleepCommand"})
public class SleepCommand implements Runnable{

	private long shleep;
	
	public SleepCommand(long shleep) {
		this.shleep = shleep;
	}
	
	public void run() {
		ThreadSupport.sleep(shleep);
	}
}
