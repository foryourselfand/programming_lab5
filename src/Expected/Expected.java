package Expected;

import Errors.InputErrors.InputErrorShort;

public interface Expected {
	void checkValueCorrectness(String valueRaw);
	
	String getErrorMessage();
	
	default InputErrorShort createInputError() {
		return new InputErrorShort(getErrorMessage());
	}
}
