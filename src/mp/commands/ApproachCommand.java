package mp.commands;

import mp.interfaces.AvatarInterface;
import mp.interfaces.BridgeSceneInterface;
import util.annotations.Tags;

@Tags({"ApproachCommand"})
public class ApproachCommand implements Runnable{
	
	private BridgeSceneInterface scene;
	private AvatarInterface avatar;
	
	public ApproachCommand(BridgeSceneInterface scene, AvatarInterface avatar) {
		this.scene = scene;
		this.avatar = avatar;
	}
	
	public void run() {
		scene.approach(avatar);
	}
}
