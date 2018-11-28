package mp.animation;

import mp.interfaces.AvatarInterface;

public class CoordinatedAnimationCommand extends AnimatingCommand implements CoordinatedAnimationCommandInterface{
	
	
	public CoordinatedAnimationCommand(AnimatorInterface animator, AvatarInterface avatar) {
		super(animator, avatar, false);
	}
}
