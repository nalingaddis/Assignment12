package mp.parser;

import mp.commands.CommandListInterface;
import mp.tokens.TokenInterface;

public interface ParserInterface {
	public Runnable parseCommand();
	public Runnable parseSayCommand();
	public Runnable parseMoveCommand();
	public Runnable parseApproachCommand();
	public Runnable parsePassCommand();
	public Runnable parseFailCommand();
	public CommandListInterface parseCommandList();
	public Runnable parseRepeatCommand();
	
	public int parseNumber();
	
	public String getCommandText();
	public void setCommandText(String s);
	
	public Runnable getCommandObject();
	
	public String getErrors();
	
	public TokenInterface next();
	public TokenInterface peek();
	public boolean hasNext();
	public void reset();
}
