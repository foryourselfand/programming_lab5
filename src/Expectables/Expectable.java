package Expectables;

import Errors.InputErrorFull;
import Errors.InputErrorShort;

public interface Expectable {
	void checkValueValidnes(String valueRaw);
	
	String getErrorMessage();
	
	default InputErrorShort createInputError() {
		return new InputErrorShort(getErrorMessage());
	}
}
