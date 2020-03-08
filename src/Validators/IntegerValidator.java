package Validators;

public class IntegerValidator extends ValueValidator {
	@Override
	public void isValueValid(String valueRaw) {
		try {
			int valueInt = (int) Integer.parseInt(valueRaw);
		} catch (Exception e) {
			// throw Integer Expected error
		}
	}
}
