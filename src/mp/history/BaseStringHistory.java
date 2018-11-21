package mp.history;

import mp.tokens.TokenInterface;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.VECTOR_PATTERN)

public class BaseStringHistory implements BaseStringHistoryInterface {
	public static final int MAX_SIZE = 100;

	protected TokenInterface[] contents = new TokenInterface[MAX_SIZE];
	
	protected int size = 0;
     
	//Constructors
	public BaseStringHistory() {
		
	}
	
	public BaseStringHistory(int someParameter) {
		System.out.println("ABaseStringHistory Single-Parameter Constructor Called");
    }
	
	//Methods
	public int size() {
		return size;
	}
	
	public TokenInterface elementAt (int index) {
		return contents[index];
	}

	protected boolean isFull() {
		return size == MAX_SIZE;
	}
	
	public void addElement(TokenInterface element) {
		if (isFull()) {
			System.out.println("Cannot add item to a full history");
		} else {
			contents[size] = element;
			size++;
		}
	} 

	@Override
	public String toString() {
		String retVal = "";
		for (int i = 0; i < size; i++) {
			String separator = (i == 0)?"":":";
			retVal += separator + contents[i].getInput();
		}	
		return retVal;
	}
}
