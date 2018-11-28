package mp.animation;

import mp.factories.SingletonsCreator;
import mp.interfaces.AvatarInterface;
import util.annotations.Tags;
import util.misc.ThreadSupport;

public class CoordinatedAnimator extends Animator implements CoordinatedAnimatorInterface{

	public CoordinatedAnimator() {
		super();
	}
	
	@Override
	@Tags({"animateAvatar"})
	public synchronized void dance(AvatarInterface avatar) {
		for(int i = 0; i < jumps; i++) {
			SingletonsCreator.produceClearanceManager().waitForProceed();
			if(up) {
				avatar.getArms().getLeftLine().setAngle(flat);
				avatar.getArms().getRightLine().setAngle(0);
				up = false;
			} else {
				avatar.getArms().getLeftLine().setAngle(flat-angle);
				avatar.getArms().getRightLine().setAngle(angle);
				up = true;
			}
		}
	}
}
