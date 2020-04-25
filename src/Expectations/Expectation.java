package Expectations;

import Errors.InputErrors.InputError;

public interface Expectation {
	void checkValueCorrectness(String valueRaw);
	
	String getErrorMessage();
	
	default InputError createInputError() {
		return new InputError(getErrorMessage());
	}
}
