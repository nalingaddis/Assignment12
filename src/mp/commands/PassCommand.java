package mp.commands;

import mp.interfaces.BridgeSceneInterface;
import util.annotations.Tags;

@Tags({"PassCommand"})
public class PassCommand implements Runnable{
	
	private BridgeSceneInterface scene;
	
	public PassCommand(BridgeSceneInterface scene) {
		this.scene = scene;
	}
	
	public void run() {
		scene.passed();
	}
}
