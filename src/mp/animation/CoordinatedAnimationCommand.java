package mp.animation;

public class CoordinatedAnimationCommand extends AnimatingCommand implements CoordinatedAnimationCommandInterface{
	
	
	public CoordinatedAnimationCommand(AnimatorInterface animator) {
		super(animator, false);
	}
}
