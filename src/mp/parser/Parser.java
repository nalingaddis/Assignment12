package mp.parser;

import mp.commands.ApproachCommand;
import mp.commands.CommandList;
import mp.commands.CommandListInterface;
import mp.commands.FailCommand;
import mp.commands.MoveCommand;
import mp.commands.PassCommand;
import mp.commands.RepeatCommand;
import mp.commands.SayCommand;
import mp.factories.SingletonsCreator;
import mp.history.ClearableHistoryInterface;
import mp.interfaces.AvatarInterface;
import mp.interfaces.BridgeSceneInterface;
import mp.scanner.ScannerBeanInterface;
import mp.table.TableInterface;
import mp.tokens.Approach;
import mp.tokens.End;
import mp.tokens.Fail;
import mp.tokens.Minus;
import mp.tokens.Move;
import mp.tokens.Number;
import mp.tokens.NumberTokenInterface;
import mp.tokens.Pass;
import mp.tokens.Plus;
import mp.tokens.Quote;
import mp.tokens.Redo;
import mp.tokens.Repeat;
import mp.tokens.Say;
import mp.tokens.Start;
import mp.tokens.TokenInterface;
import mp.tokens.Word;
import mp.tokens.WordTokenInterface;

public class Parser implements ParserInterface{
	
	private String commandText = "", errors = "";
	private ScannerBeanInterface scanner = SingletonsCreator.produceScannerBean();
	private TableInterface table = SingletonsCreator.produceAvatarTable();
	private BridgeSceneInterface scene = SingletonsCreator.produceBridgeScene();
	
	private Runnable errorReturn = new Thread();
	
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
	public Runnable parseCommand() {
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
		} else {
			illegalCommand();
			return errorReturn;
		}
	}

	public Runnable parseSayCommand() {
		next = safeNext();
		
		if(next instanceof Quote) {
			return new SayCommand(scene, next.getInput());
		} else {
			expectedToken(new Quote("  "), next);
			return errorReturn;
		}
	}

	public Runnable parseMoveCommand() {
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
		
		return new MoveCommand(avatar, x, y);
	}
	
	public int parseNumber() {
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

	public Runnable parseApproachCommand() {
		next = safeNext();
		
		if(next instanceof Word) {
			AvatarInterface avatar = (AvatarInterface) table.get(((WordTokenInterface) next).getValue());
			return new ApproachCommand(scene, avatar);
		} else {
			expectedToken(new Word(""), next);
			return errorReturn;
		}
	}

	public Runnable parsePassCommand() {
		return new PassCommand(scene);
	}

	public Runnable parseFailCommand() {
		return new FailCommand(scene);
	}

	public CommandListInterface parseCommandList() {
		CommandListInterface commandList = new CommandList();
		
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
	}

	public Runnable parseRepeatCommand() {
		next = safeNext();
		
		if(next instanceof Number) {
			return new RepeatCommand(((NumberTokenInterface) next).getValue(), parseCommand());
		} else {
			expectedToken(new Number("0"), next);
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
		
		return parseCommand();
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
