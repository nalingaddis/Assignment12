package mp.animation;

import mp.interfaces.AvatarInterface;

public class CoordinatingAnimatingCommand extends AnimatingCommand implements CoordinatingAnimatingCommandInterface{

	public CoordinatingAnimatingCommand(AnimatorInterface animator, AvatarInterface avatar) {
		super(animator, avatar, false);
	}
}
