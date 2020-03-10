package Expectables.ExpectablesType;

import Errors.InputError;
import Expectables.Expectable;

public class ExpectedFloat implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
		try {
			float valueFloat = Float.parseFloat(valueRaw);
		} catch (NumberFormatException exception) {
			throw new InputError("Ожилалось float");
		}
	}
}
