package Expectables;

public class ExpectedStringLengthNotEmpty implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
		if (valueRaw.length() == 0) {
			throw createInputError();
		}
	}
	
	@Override
	public String getErrorMessage() {
		return "Строка должна быть не пустой";
	}
}
