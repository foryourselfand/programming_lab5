package Errors;

import java.util.Set;

public class WrongHeaderFieldsBothError extends WrongHeaderError {
	public WrongHeaderFieldsBothError(Set<String> missingFields, Set<String> extraFields) {
		super(WrongHeaderError.MESSAGE_MISSING + missingFields + "\n"
				+ WrongHeaderError.MESSAGE_EXTRA + extraFields);
	}
}
