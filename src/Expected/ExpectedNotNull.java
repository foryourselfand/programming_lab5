package Expected;

public class ExpectedNotNull implements Expected {
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
