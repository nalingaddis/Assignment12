package mp.commands;

import mp.interfaces.AvatarInterface;
import util.annotations.Tags;

@Tags({"RotateLeftArmCommand"})
public class RotateLeftArmCommand implements Runnable{
	
	private int angle;
	private AvatarInterface avatar;
	
	public RotateLeftArmCommand(AvatarInterface avatar, int angle) {
		this.avatar = avatar;
		this.angle = angle;
	}
	
	public void run() {
		avatar.getArms().getLeftLine().setAngle(
				avatar.getArms().getLeftLine().getAngle() + angle);
	}
}
