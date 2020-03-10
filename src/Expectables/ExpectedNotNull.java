package Expectables;

import Errors.InputError;

public class ExpectedNotNull implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
		if (valueRaw.length() == 0) {
			throw new InputError("Поле не может быть null");
		}
	}
}
