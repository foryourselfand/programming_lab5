import Validators.IntegerValidator;

public class Testing {
	public static void main(String[] args) {
		IntegerValidator integerValidator = new IntegerValidator();
		try {
			integerValidator.isValueValid("");
		} catch (Error e) {
			System.out.println(e.getMessage());
		}
	}
}
