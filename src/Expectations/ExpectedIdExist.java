package Expectations;

import Generators.IdGenerator;

/**
 * Ожидается существующий id
 */
public class ExpectedIdExist implements Expectation {
	@Override
	public void checkValueCorrectness(String valueRaw) {
		long id = Long.parseLong(valueRaw);
		if (! IdGenerator.containsId(id))
			throw createInputError();
	}
	
	@Override
	public String getErrorMessage() {
		return "Элемент с id должен находится коллекции";
	}
}
