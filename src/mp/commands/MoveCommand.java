package mp.commands;

import mp.interfaces.AvatarInterface;
import util.annotations.Tags;

@Tags({"MoveCommand"})
public class MoveCommand implements UndoCommandInterface{

	private AvatarInterface avatar;
	private int x, y;
	
	public MoveCommand(AvatarInterface avatar, int x, int y) {
		this.avatar = avatar;
		this.x = x;
		this.y = y;
	}
	
	public void run() {
		avatar.move(x, y);
	}

	public void undo() {
		avatar.move(-x, -y);
	}
}
