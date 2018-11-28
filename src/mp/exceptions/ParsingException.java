package mp.exceptions;

import java.io.IOException;

import util.annotations.Tags;

@Tags({"ParsingException"})
public class ParsingException extends IOException{
	public ParsingException(String message) {
		super(message);
	}
}
