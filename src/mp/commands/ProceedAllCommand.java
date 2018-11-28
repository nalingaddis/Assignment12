package mp.commands;

import mp.factories.SingletonsCreator;
import util.annotations.Tags;

@Tags({"ProceedAllCommand"})
public class ProceedAllCommand implements Runnable{
	
	public ProceedAllCommand() {
		
	}
	
	public void run() {
		SingletonsCreator.produceClearanceManager().proceedAll();
	}
}
