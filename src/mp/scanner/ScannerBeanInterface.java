package mp.scanner;

import mp.history.ClearableHistoryInterface;
import mp.tokens.TokenInterface;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"ScannerBean"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"ScannedString", "Tokens", "Errors", "TokenList"})
@EditablePropertyNames({"ScannedString"})

public interface ScannerBeanInterface {
	public String getScannedString();
	public ClearableHistoryInterface getTokenList();
	public void setScannedString(String s);
	public TokenInterface[] getTokens();
	public String getErrors();
}
