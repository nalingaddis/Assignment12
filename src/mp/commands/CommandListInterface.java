package mp.commands;

public interface CommandListInterface extends Runnable{
	public void add(Runnable runner);
}
