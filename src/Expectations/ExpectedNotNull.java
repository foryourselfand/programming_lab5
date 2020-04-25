package Expectations;

/**
 * Ожидается не null
 */
public class ExpectedNotNull implements Expectation {
	@Override
	public void checkValueCorrectness(String valueRaw) {
		if (valueRaw.length() == 0) {
			throw createInputError();
		}
	}
	
	@Override
	public String getErrorMessage() {
		return "Должно быть не null";
	}
}
