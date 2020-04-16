package Expectables;

import Generators.IdGenerator;

public class ExpectedUnique implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
		long valueLong = Long.parseLong(valueRaw);
		if (IdGenerator.containsId(valueLong))
			throw createInputError();
	}
	
	@Override
	public String getErrorMessage() {
		return "Должно быть уникальным";
	}
}
