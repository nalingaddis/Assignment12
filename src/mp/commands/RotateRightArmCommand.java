package mp.commands;

import mp.interfaces.AvatarInterface;
import util.annotations.Tags;

@Tags({"RotateRightArmCommand"})
public class RotateRightArmCommand implements Runnable{
	
	private int angle;
	private AvatarInterface avatar;
	
	public RotateRightArmCommand(AvatarInterface avatar, int angle) {
		this.avatar = avatar;
		this.angle = angle;
	}
	
	public void run() {
		avatar.getArms().getRightLine().setAngle(
				avatar.getArms().getRightLine().getAngle() + angle);
	}
}
