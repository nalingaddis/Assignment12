package mp.animation;

import mp.clearance.BroadcastingClearanceManager;
import mp.factories.SingletonsCreator;
import util.annotations.Tags;

@Tags({"AnimatingCommand"})
public class AnimatingCommand implements AnimatingCommandInterface{

	AnimatorInterface animator;
	boolean waiting = false;
	BroadcastingClearanceManager squencer = SingletonsCreator.produceClearanceManager();
	
	public AnimatingCommand(AnimatorInterface animator, boolean waiting) {
		this.animator = animator;
		this.waiting = waiting;
	}
	
	public void run() {
		if(waiting) {
			squencer.waitForProceed();
		}
		animator.dance();
	}
}
