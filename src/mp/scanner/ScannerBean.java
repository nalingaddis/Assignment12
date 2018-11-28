package mp.scanner;

import java.util.Iterator;

import mp.exceptions.ScanningException;
import mp.history.ClearableHistory;
import mp.history.ClearableHistoryInterface;
import mp.tokens.Approach;
import mp.tokens.Call;
import mp.tokens.Define;
import mp.tokens.End;
import mp.tokens.Fail;
import mp.tokens.Minus;
import mp.tokens.Move;
import mp.tokens.Number;
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
import mp.tokens.Wait;
import mp.tokens.Word;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"ScannerBean"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"ScannedString", "Tokens", "Errors", "TokenList"})
@EditablePropertyNames({"ScannedString"})

public class ScannerBean implements ScannerBeanInterface{

	private String scannedString = "";
	private TokenInterface tokens[] = new TokenInterface[0];
	private String errors = "";
	private ClearableHistoryInterface tokenList = new ClearableHistory();
	
	private int maxArrayLength = 100;
	private TokenInterface largeArray[] = new TokenInterface[maxArrayLength];
	private int tokenCounter = 0;

	
	public ScannerBean() {
		tokenList.clear();
	}
	
	public String getScannedString() {
		return scannedString;
	}
	
	public ClearableHistoryInterface getTokenList() {
		return tokenList;
	}
		
	public void setScannedString(String s) {
		scannedString = s;
		
		largeArray = new TokenInterface[maxArrayLength];
		tokenCounter = 0;
		
		try {
			scanString(scannedString);	
		} catch (ScanningException e) {
			errors = e.toString();
		}
		
		tokens = new TokenInterface[tokenCounter];
		for(int i = 0; i < tokenCounter; i++) {
			tokens[i] = largeArray[i];
		}
	}
	
	public TokenInterface[] getTokens() {
		return tokens;
	}
	
	public String getErrors() {
		return errors;
	}
	
	private void scanString(String s) throws ScanningException{
		tokenList.clear();
		
		//A temporary var to hold the value of next token
		String temp;
		
		//The boolean that will be set false AT THE END OF THE LOOP 
		//if scanner does not have a next value
		boolean isHasNext = true;
		
		//The instance of the ScanningIterator class
		//Uses the string value passed into this method on call
		Iterator<String> scanner = new ScanningIterator(s);
		
		while(isHasNext) {
			//Fetches next token
			temp = scanner.next();
			
			//Determines what type of token it is and prints out the proper format
			if(Character.isLetter(temp.charAt(0))) {
				
				if("move".equalsIgnoreCase(temp)) {
					largeArray[tokenCounter] = new Move(temp);
					tokenList.addElement(new Move(temp));
					tokenCounter++;
				} else if("say".equalsIgnoreCase(temp)) {
					largeArray[tokenCounter] = new Say(temp);
					tokenList.addElement(new Say(temp));
					tokenCounter++;
				} else if("repeat".equalsIgnoreCase(temp)) {
					largeArray[tokenCounter] = new Repeat(temp);
					tokenList.addElement(new Repeat(temp));
					tokenCounter++;
				} else if("approach".equalsIgnoreCase(temp)) {
					largeArray[tokenCounter] = new Approach(temp);
					tokenList.addElement(new Approach(temp));
					tokenCounter++;
				} else if("passed".equalsIgnoreCase(temp)) {
					largeArray[tokenCounter] = new Pass(temp);
					tokenList.addElement(new Pass(temp));
					tokenCounter++;
				} else if("failed".equalsIgnoreCase(temp)) {
					largeArray[tokenCounter] = new Fail(temp);
					tokenList.addElement(new Fail(temp));
					tokenCounter++;
				} else if("rotateleftarm".equalsIgnoreCase(temp)) {
					largeArray[tokenCounter] = new RotateLeftArm(temp);
					tokenList.addElement(new RotateLeftArm(temp));
					tokenCounter++;
				} else if("rotaterightarm".equalsIgnoreCase(temp)) {
					largeArray[tokenCounter] = new RotateRightArm(temp);
					tokenList.addElement(new RotateRightArm(temp));
					tokenCounter++;
				} else if("define".equalsIgnoreCase(temp)) {
					largeArray[tokenCounter] = new Define(temp);
					tokenList.addElement(new Define(temp));
					tokenCounter++;
				} else if("call".equalsIgnoreCase(temp)) {
					largeArray[tokenCounter] = new Call(temp);
					tokenList.addElement(new Call(temp));
					tokenCounter++;
				} else if("thread".equalsIgnoreCase(temp)) {
					largeArray[tokenCounter] = new Thread(temp);
					tokenList.addElement(new Thread(temp));
					tokenCounter++;
				} else if("wait".equalsIgnoreCase(temp)) {
					largeArray[tokenCounter] = new Wait(temp);
					tokenList.addElement(new Wait(temp));
					tokenCounter++;
				} else if("proceedall".equalsIgnoreCase(temp)) {
					largeArray[tokenCounter] = new ProceedAll(temp);
					tokenList.addElement(new ProceedAll(temp));
					tokenCounter++;
				} else if("sleep".equalsIgnoreCase(temp)) {
					largeArray[tokenCounter] = new Sleep(temp);
					tokenList.addElement(new Sleep(temp));
					tokenCounter++;
				} else if("undo".equalsIgnoreCase(temp)) {
					largeArray[tokenCounter] = new Undo(temp);
					tokenList.addElement(new Undo(temp));
					tokenCounter++;
				} else if("redo".equalsIgnoreCase(temp)) {
					largeArray[tokenCounter] = new Redo(temp);
					tokenList.addElement(new Redo(temp));
					tokenCounter++;
				} else {
					largeArray[tokenCounter] = new Word(temp);
					tokenList.addElement(new Word(temp));
					tokenCounter++;
				}
				
			} else if(Character.isDigit(temp.charAt(0))) {
				largeArray[tokenCounter] = new Number(temp);
				tokenList.addElement(new Number(temp));
				tokenCounter++;
			} else if(temp.charAt(0) == '+'){
				largeArray[tokenCounter] = new Plus(temp);
				tokenList.addElement(new Plus(temp));
				tokenCounter++;
			} else if(temp.charAt(0) == '-'){
				largeArray[tokenCounter] = new Minus(temp);
				tokenList.addElement(new Minus(temp));
				tokenCounter++;
			} else if(temp.charAt(0) == '"'){
				largeArray[tokenCounter] = new Quote(temp);
				tokenList.addElement(new Quote(temp));
				tokenCounter++;
			} else if(temp.charAt(0) == '{'){
				largeArray[tokenCounter] = new Start(temp);
				tokenList.addElement(new Start(temp));
				tokenCounter++;
			} else if(temp.charAt(0) == '}'){
				largeArray[tokenCounter] = new End(temp);
				tokenList.addElement(new End(temp));
				tokenCounter++;
			} else {
				throw new ScanningException("This token does not match any proper formats.");
			}
			
			//Checks to see if there is another token
			isHasNext = scanner.hasNext();
		}
	}
}
