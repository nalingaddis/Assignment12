package mp.parser;

import mp.commands.CommandListInterface;
import mp.exceptions.ParsingException;
import mp.tokens.TokenInterface;

public interface ParserInterface {
	public Runnable parseCommand() throws ParsingException;
	public Runnable parseSayCommand() throws ParsingException;
	public Runnable parseMoveCommand() throws ParsingException;
	public Runnable parseApproachCommand() throws ParsingException;
	public Runnable parsePassCommand() throws ParsingException;
	public Runnable parseFailCommand() throws ParsingException;
	public CommandListInterface parseCommandList() throws ParsingException;
	public Runnable parseRepeatCommand() throws ParsingException;
	
	public int parseNumber() throws ParsingException;
	
	public String getCommandText();
	public void setCommandText(String s);
	
	public Runnable getCommandObject();
	
	public String getErrors();
	
	public TokenInterface next();
	public TokenInterface peek();
	public boolean hasNext();
	public void reset();
}
