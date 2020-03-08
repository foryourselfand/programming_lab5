package Validators;

import Exceptions.ZeroLengthException;

public class StringLengthValidator extends ValueValidator {
	@Override
	public void isValueValid(String valueRaw) {
		if (valueRaw.length() == 0) {
			throw new ZeroLengthException();
		}
	}
}
