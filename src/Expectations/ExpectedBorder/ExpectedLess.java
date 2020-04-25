package Expectations.ExpectedBorder;

import java.math.BigDecimal;

/**
 * Ожидается меньше
 */
public class ExpectedLess extends ExpectedBorder {
	public ExpectedLess(int border) {
		super(border);
	}
	
	@Override
	protected void checkValueCorrectnessNumeric(BigDecimal value) {
		if (value.compareTo(this.border) >= 0)
			throw createInputError();
	}
	
	@Override
	public String getErrorMessage() {
		return "Должно быть меньше " + this.border;
	}
}
