package Expectables.ExpectablesType;

import Errors.InputError;
import Expectables.Expectable;

public class ExpectedLong implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
		try {
			long valueLong = Long.parseLong(valueRaw);
		} catch (NumberFormatException exception){
			throw new InputError("Ожидалось long");
		}
	}
}
