package mp.history;

import mp.commands.UndoCommandInterface;

public interface DoHistoryInterface{
	public void add(UndoCommandInterface command);
	public void undo();
	public void redo();
}
