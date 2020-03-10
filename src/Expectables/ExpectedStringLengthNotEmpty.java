package Expectables;

import Errors.InputError;

public class ExpectedStringLengthNotEmpty implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
		if (valueRaw.length() == 0) {
			throw new InputError("Строка не может быть пустой");
		}
	}
}
