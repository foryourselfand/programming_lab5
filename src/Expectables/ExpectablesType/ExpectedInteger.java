package Expectables.ExpectablesType;

import Errors.InputError;
import Expectables.Expectable;

public class ExpectedInteger implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
		try {
			int valueInt = Integer.parseInt(valueRaw);
		} catch (NumberFormatException exception) {
			throw new InputError("Ожилалось int");
		}
	}
}
