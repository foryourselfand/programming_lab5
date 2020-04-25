package Expectations.ExpectedType;

/**
 * Ожидается Integer
 */
public class ExpectedInteger extends ExpectedType {
	@Override
	public Class getNumberClass() {
		return Integer.class;
	}
}
