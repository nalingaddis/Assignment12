package mp.animation;

public class CoordinatingAnimatingCommand extends AnimatingCommand implements CoordinatingAnimatingCommandInterface{

	public CoordinatingAnimatingCommand(AnimatorInterface animator) {
		super(animator, false);
	}
}
