package Expectations.ExpectedType;

/**
 * Ожидается Double
 */
public class ExpectedDouble extends ExpectedType {
	@Override
	public Class getNumberClass() {
		return Double.class;
	}
}
