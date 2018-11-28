package mp.animation;

import mp.clearance.BroadcastingClearanceManager;
import mp.factories.SingletonsCreator;
import mp.interfaces.AvatarInterface;
import util.annotations.Tags;

@Tags({"AnimatingCommand"})
public class AnimatingCommand implements AnimatingCommandInterface{

	AnimatorInterface animator;
	AvatarInterface avatar;
	boolean waiting = false;
	
	BroadcastingClearanceManager squencer = SingletonsCreator.produceClearanceManager();
	
	public AnimatingCommand(AnimatorInterface animator, AvatarInterface avatar, boolean waiting) {
		this.animator = animator;
		this.avatar = avatar;
		this.waiting = waiting;
	}
	
	public void run() {
		if(waiting) {
			squencer.waitForProceed();
		}
		animator.dance(avatar);
	}
}
