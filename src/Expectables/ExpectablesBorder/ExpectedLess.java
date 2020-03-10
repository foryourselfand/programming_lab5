package Expectables.ExpectablesBorder;

import Errors.InputError;

import java.math.BigDecimal;

public class ExpectedLess extends ExpectableBorder {
	public ExpectedLess(int border) {
		super(border);
	}
	
	@Override
	protected void checkNumericValueValidnes(BigDecimal value) {
		if (value.compareTo(this.border) > 0)
			throw new InputError("Значение поля должно быть меньше " + this.border);
	}
}
