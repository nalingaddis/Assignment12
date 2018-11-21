package mp.animation;

import mp.clearance.BroadcastingClearanceManager;
import util.annotations.Tags;

@Tags({"AnimatingCommand"})
public class AnimatingCommand implements AnimatingCommandInterface{

	AnimatorInterface animator;
	
	public AnimatingCommand(AnimatorInterface animator, BroadcastingClearanceManager sequencer) {
		this.animator = animator;
	}
	
	public void run() {
		animator.dance();
	}
}
