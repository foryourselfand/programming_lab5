package Expectations;

/**
 * Ожидается строка с ненулевой длинной
 */
public class ExpectedStringLengthNotEmpty implements Expectation {
	@Override
	public void checkValueCorrectness(String valueRaw) {
		if (valueRaw.length() == 0) {
			throw createInputError();
		}
	}
	
	@Override
	public String getErrorMessage() {
		return "Строка должна быть не пустой";
	}
}
