package mp.commands;

import mp.interfaces.BridgeSceneInterface;
import util.annotations.Tags;

@Tags({"FailCommand"})
public class FailCommand implements Runnable{
	
	private BridgeSceneInterface scene;
	
	public FailCommand(BridgeSceneInterface scene) {
		this.scene = scene;
	}
	
	public void run() {
		scene.failed();
	}
}
