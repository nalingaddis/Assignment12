package mp.commands;

import mp.interfaces.BridgeSceneInterface;
import util.annotations.Tags;

@Tags({"SayCommand"})
public class SayCommand implements Runnable{
	
	private BridgeSceneInterface scene;
	private String s;
	
	public SayCommand(BridgeSceneInterface scene, String s) {
		this.scene = scene;
		this.s = s;
	}
	
	public void run() {
		scene.say(s);
	}
}
