package mp.parser;

import mp.commands.ApproachCommand;
import mp.commands.CallCommand;
import mp.commands.CommandList;
import mp.commands.CommandListInterface;
import mp.commands.DefineCommand;
import mp.commands.FailCommand;
import mp.commands.MoveCommand;
import mp.commands.PassCommand;
import mp.commands.ProceedAllCommand;
import mp.commands.RedoCommand;
import mp.commands.RepeatCommand;
import mp.commands.RotateLeftArmCommand;
import mp.commands.RotateRightArmCommand;
import mp.commands.SayCommand;
import mp.commands.SleepCommand;
import mp.commands.ThreadCommand;
import mp.commands.UndoCommand;
import mp.commands.UndoCommandInterface;
import mp.exceptions.ParsingException;
import mp.factories.SingletonsCreator;
import mp.history.ClearableHistoryInterface;
import mp.interfaces.AvatarInterface;
import mp.interfaces.BridgeSceneInterface;
import mp.scanner.ScannerBeanInterface;
import mp.table.TableInterface;
import mp.tokens.Approach;
import mp.tokens.Call;
import mp.tokens.Define;
import mp.tokens.End;
import mp.tokens.Fail;
import mp.tokens.Minus;
import mp.tokens.Move;
import mp.tokens.Number;
import mp.tokens.NumberTokenInterface;
import mp.tokens.Pass;
import mp.tokens.Plus;
import mp.tokens.ProceedAll;
import mp.tokens.Quote;
import mp.tokens.Redo;
import mp.tokens.Repeat;
import mp.tokens.RotateLeftArm;
import mp.tokens.RotateRightArm;
import mp.tokens.Say;
import mp.tokens.Sleep;
import mp.tokens.Start;
import mp.tokens.Thread;
import mp.tokens.TokenInterface;
import mp.tokens.Undo;
import mp.tokens.Word;
import mp.tokens.WordTokenInterface;

public class Parser implements ParserInterface{
	
	private String commandText = "", errors = "";
	private ScannerBeanInterface scanner = SingletonsCreator.produceScannerBean();
	private TableInterface<AvatarInterface> table = SingletonsCreator.produceAvatarTable();
	private BridgeSceneInterface scene = SingletonsCreator.produceBridgeScene();
	private TableInterface<Runnable> environment = SingletonsCreator.produceEnvironment();
	
	private Runnable errorReturn = new java.lang.Thread();
	
	//Iteration
	private int index = -1;
	private ClearableHistoryInterface tokens = scanner.getTokenList();
	private TokenInterface next;
	
	public TokenInterface next() {
		TokenInterface token = peek();
		index++;
		return token;
	}
	
	public TokenInterface peek() {
		return tokens.elementAt(index + 1);
	}
	
	public boolean hasNext() {
		if(index + 1 < tokens.size()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void reset() {
		index = -1;
	}
	
	//Parsing
	public Runnable parseCommand() throws ParsingException{
		next = safeNext();
		
		if(next instanceof Say) {
			return parseSayCommand();
		} else if(next instanceof Move) {
			return parseMoveCommand();
		} else if(next instanceof Approach) {
			return parseApproachCommand();
		} else if(next instanceof Pass) {
			return parsePassCommand();
		} else if(next instanceof Fail) {
			return parseFailCommand();
		} else if(next instanceof Repeat) {
			return parseRepeatCommand();
		} else if(next instanceof Start) {
			return parseCommandList();
		} else if (next instanceof Undo) {
			return parseUndoCommand();
		} else if (next instanceof Redo) {
			return parseRedoCommand();
		} else if (next instanceof RotateLeftArm) {
			return parseRotateLeftArmCommand();
		} else if (next instanceof RotateRightArm) {
			return parseRotateRightArmCommand();
		} else if (next instanceof Sleep) {
			return parseSleepCommand();
		} else if (next instanceof Define) {
			return parseDefineCommand();
		} else if (next instanceof Call) {
			return parseCallCommand();
		} else if (next instanceof mp.tokens.Thread) {
			return parseThreadCommand();
		} else if (next instanceof ProceedAll) {
			return parseProceedAllCommand();
		} else {
			illegalCommand();
			return errorReturn;
		}
	}
	
	public Runnable parseProceedAllCommand() throws ParsingException{
		return new ProceedAllCommand();
	}
	
	public Runnable parseThreadCommand()  throws ParsingException{
		String name = next().getInput();
		return new ThreadCommand(name);
	}
	
	public Runnable parseCallCommand()  throws ParsingException{
		String name = next().getInput();
		return new CallCommand(name);
	}
	
	public Runnable parseDefineCommand()  throws ParsingException{
		String name = next().getInput();
		
		try {
			Runnable command = parseCommand();
			return new DefineCommand(name, command);
		} catch (ParsingException e) {
			errors = e.toString();
			return errorReturn;
		}
	}
	
	public Runnable parseSleepCommand()  throws ParsingException{
		int shleep = parseNumber();
		
		return new SleepCommand(shleep);
	}
	
	public Runnable parseRotateLeftArmCommand()  throws ParsingException{
		next = safeNext();
		
		AvatarInterface avatar = (AvatarInterface) table.get(((WordTokenInterface) next).getValue());
		int angle = parseNumber();
		
		return new RotateLeftArmCommand(avatar, angle);
	}
	
	public Runnable parseRotateRightArmCommand()  throws ParsingException{
		next = safeNext();
		
		AvatarInterface avatar = (AvatarInterface) table.get(((WordTokenInterface) next).getValue());
		int angle = parseNumber();
		
		return new RotateRightArmCommand(avatar, angle);
	}
	
	public Runnable parseRedoCommand()  throws ParsingException{
		return new RedoCommand();
	}
	
	public Runnable parseUndoCommand()  throws ParsingException{
		return new UndoCommand();
	}
	
	public Runnable parseSayCommand() throws ParsingException{
		next = safeNext();
		
		if(next instanceof Quote) {
			return new SayCommand(scene, next.getInput());
		} else {
			expectedToken(new Quote("  "), next);
			return errorReturn;
		}
	}

	public Runnable parseMoveCommand()  throws ParsingException{
		next = safeNext();
		
		AvatarInterface avatar;
		
		if(next instanceof Word) {
			avatar = (AvatarInterface) table.get(((WordTokenInterface) next).getValue());
		} else {
			expectedToken(new Word(""), next);
			return errorReturn;
		}
		
		int x = parseNumber();
		int y = parseNumber();
		
		UndoCommandInterface move = new MoveCommand(avatar, x, y);
		SingletonsCreator.produceDoHistory().add(move);
		
		return move;
	}
	
	public int parseNumber() throws ParsingException{
		next = safeNext();
		
		int out = 1;
		
		if(next instanceof Number) {
			return out * ((NumberTokenInterface) next).getValue();
		} else if(next instanceof Plus) {
			next = safeNext();
			if(next instanceof Number) {
				return out * ((NumberTokenInterface) next).getValue(); 
			} else {
				expectedToken(new Number("0"), next);
				return 0;
			}
		} else if(next instanceof Minus) {
			next = safeNext();
			out = -1;
			if(next instanceof Number) {
				return out * ((NumberTokenInterface) next).getValue(); 
			} else {
				expectedToken(new Number("0"), next);
				return 0;
			}
		} else {
			expectedToken(new Number("0"), next);
			return 0;
		}
	}

	public Runnable parseApproachCommand() throws ParsingException{
		next = safeNext();
		
		if(next instanceof Word) {
			AvatarInterface avatar = (AvatarInterface) table.get(((WordTokenInterface) next).getValue());
			return new ApproachCommand(scene, avatar);
		} else {
			expectedToken(new Word(""), next);
			return errorReturn;
		}
	}

	public Runnable parsePassCommand() throws ParsingException{
		return new PassCommand(scene);
	}

	public Runnable parseFailCommand() throws ParsingException{
		return new FailCommand(scene);
	}

	public CommandListInterface parseCommandList() throws ParsingException{
		CommandListInterface commandList = new CommandList();
		
		try {
			if(hasNext()) {
				while(hasNext() && !(peek() instanceof End)){
					commandList.add(parseCommand());
				}
			} else {
				noNext();
			}
			if(hasNext()) {
				next = safeNext();
			}
			return commandList;
		} catch (ParsingException e) {
			errors = e.toString();
			return commandList;
		}
	}

	public Runnable parseRepeatCommand() throws ParsingException{
		next = safeNext();
		
		try {
			if(next instanceof Number) {
				return new RepeatCommand(((NumberTokenInterface) next).getValue(), parseCommand());
			} else {
				expectedToken(new Number("0"), next);
				return errorReturn;
			}
		} catch (ParsingException e) {
			errors = e.toString();
			return errorReturn;
		}
	}

	//CommandText
	public String getCommandText() {
		return commandText;
	}

	public void setCommandText(String s) {
		this.commandText = s;
		getCommandObject().run();
	}

	//CommandObject
	public Runnable getCommandObject() {
		scanner.setScannedString(commandText);	
		tokens = scanner.getTokenList();
		reset();
		
		try {
			return parseCommand();
		} catch(ParsingException e) {
			errors = e.toString();
			return errorReturn;
		}
	}
	
	//Errors
	public String getErrors() {
		return errors;
	}
	
	private void expectedToken(TokenInterface expected, TokenInterface actual) {
		errors = errors + "Expected token " + expected + ", but recieved " + actual + ". \n";
	}

	private void noNext() {
		errors = errors + "Expected token, but recieved end of line. \n";
	}

	private void illegalCommand() {
		errors = errors + "Illegal Command Error. \n";
	}
	
	private TokenInterface safeNext() {
		if(!hasNext()) {
			noNext();
			return new Redo("");
		}
		
		return next();
	}
}
