package Expectations.ExpectedType;

/**
 * Ожидается Boolean
 */
public class ExpectedBoolean extends ExpectedType {
	@Override
	public Class getNumberClass() {
		return Boolean.class;
	}
}
