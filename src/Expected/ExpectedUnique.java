package Expected;

import Generators.IdGenerator;

public class ExpectedUnique implements Expected {
	@Override
	public void checkValueCorrectness(String valueRaw) {
		long valueLong = Long.parseLong(valueRaw);
		if (IdGenerator.containsId(valueLong))
			throw createInputError();
	}
	
	@Override
	public String getErrorMessage() {
		return "Должно быть уникальным";
	}
}
