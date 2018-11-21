package mp.scanner;

import java.util.Iterator;


public class ScanningIterator implements Iterator<String>{
	
	//String variable to hold the inputted string
	private String string;
	
	//Pointer is placed at the beginning of the token
	private int pointer = 0;
	//PointerTemp is placed at the end of the token
	private int pointerTemp = 0;
	
	
	public int indexOf(String s, char ch, int fromIndex) {
		//Starts at fromIndex and continues to end of string
		for(int i = fromIndex; i < s.length(); i++) {
			//Logic function to determine if the characters are equal
			if(s.charAt(i) == ch) {
				return i;
			}
		}
		return -1;
	}
	
	
	//Basically just indexOf with == changed to !=
	public int indexOfNot(String s, char ch, int fromIndex) {
		for(int i = fromIndex; i < s.length(); i++) {
			if(s.charAt(i) != ch) {
				return i;
			}
		}
		return -1;
	}
	
	public ScanningIterator(String s) {
		string = s;
		int quoteCounter = 0;
		
		//count the number of quotation marks
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == '"') {
				quoteCounter++;
			}
		}
		
		//if there is an odd number of quotation marks we know there is an error
		if(quoteCounter%2 == 1) {
			//if the extra quote is at the end we remove it
			if(string.charAt(string.length()-1) == '"'){
				System.out.println("Quote Error Detected, Removing Extra Quote");
				string = string.substring(0, string.length()-1);
			//otherwise we just append a closing quote
			} else {
				System.out.println("Quote Error Detected, Appending Closing Quote");
				string = string + "\"";
			}
		}
		//end space problem resolved
		string = string + "  ";
	}
	
	@Override
	public boolean hasNext() {
		//if there is anything other than a space character before the end of the string
		//this returns true, if there is only spaces before the end then it returns false
		return !(indexOfNot(string, ' ', pointerTemp) == -1);
	}

	@Override
	public String next() {
		//pointer gets moved to the end of the last token scanned
		pointer = pointerTemp;
		//pointer gets moved to the beginning of the next token
		pointer = indexOfNot(string, ' ', pointer);
		
		//tests to see if the next token will be a quote
		if(string.charAt(pointer) == '"') {
			//if it is a quote then we find the end of the quote and move the temp pointer
			//to the end of the quote token
			pointerTemp = indexOf(string, '"', pointer+1)+1;
			
			//Return that quote token substring
			return string.substring(pointer, pointerTemp);
		} else {
			//pointerTemp gets moved to the end of the non-quote token that pointer is on
			pointerTemp = indexOf(string, ' ', pointer);
		
			//return the substring between the begin of the token and the end of the token
			//AKA it returns the token
			return string.substring(pointer, pointerTemp);
		}
	}
}
