package Expectables;

public class ExpectedNotNull implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
		if (valueRaw.length() == 0) {
			throw createInputError();
		}
	}
	
	@Override
	public String getErrorMessage() {
		return "Должно быть не null";
	}
}
