package Expectables.ExpectablesType;

import Errors.InputError;
import Expectables.Expectable;

public class ExpectedDouble implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
		try {
			double valueDouble = Double.parseDouble(valueRaw);
		} catch (NumberFormatException exception) {
			throw new InputError("Ожидалось double");
		}
	}
}
