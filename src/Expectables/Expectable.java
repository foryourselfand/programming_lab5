package Expectables;

import Errors.InputError;

public interface Expectable {
	void checkValueValidnes(String valueRaw);
	
	String getErrorMessage();
	
	default InputError createInputError() {
		return new InputError(getErrorMessage());
	}
}
