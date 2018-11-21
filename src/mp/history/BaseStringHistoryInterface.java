package mp.history;

import mp.tokens.TokenInterface;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.VECTOR_PATTERN)


public interface BaseStringHistoryInterface {
	public void addElement(TokenInterface element);
	public TokenInterface elementAt (int index); 
	public int size();
}
