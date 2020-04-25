package Expectations.ExpectedType;

/**
 * Ожидается Long
 */
public class ExpectedLong extends ExpectedType {
	@Override
	public Class getNumberClass() {
		return Long.class;
	}
}
