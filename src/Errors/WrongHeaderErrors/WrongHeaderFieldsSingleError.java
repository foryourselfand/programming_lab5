package Errors.WrongHeaderErrors;

import java.util.Set;

public class WrongHeaderFieldsSingleError extends WrongHeaderError {
	public WrongHeaderFieldsSingleError(String message, Set<String> fields) {
		super(message + ": " + fields);
	}
}
