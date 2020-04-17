package Expected;

import Generators.IdGenerator;

public class ExpectedIdExist implements Expected {
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
