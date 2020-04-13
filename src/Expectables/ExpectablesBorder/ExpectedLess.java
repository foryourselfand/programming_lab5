package Expectables.ExpectablesBorder;

import java.math.BigDecimal;

public class ExpectedLess extends ExpectableBorder {
	public ExpectedLess(int border) {
		super(border);
	}
	
	@Override
	protected void checkNumericValueValidnes(BigDecimal value) {
		if (value.compareTo(this.border) > 0)
			throw createInputError();
	}
	
	@Override
	public String getErrorMessage() {
		return "Должно быть меньше " + this.border;
	}
}
