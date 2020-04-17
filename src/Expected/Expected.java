package Expected;

import Errors.InputErrors.InputError;

public interface Expected {
	void checkValueCorrectness(String valueRaw);
	
	String getErrorMessage();
	
	default InputError createInputError() {
		return new InputError(getErrorMessage());
	}
}
