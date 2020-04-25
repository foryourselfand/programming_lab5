package Expectations;

import Generators.IdGenerator;

/**
 * Ожидается уникальный id
 */
public class ExpectedIdUnique implements Expectation {
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
