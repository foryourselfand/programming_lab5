package Expectables.ExpectablesBorder;

import java.math.BigDecimal;

public class ExpectedGreater extends ExpectableBorder {
	public ExpectedGreater(int border) {
		super(border);
	}
	
	@Override
	protected void checkNumericValueValidnes(BigDecimal value) {
		if (value.compareTo(this.border) < 0)
			throw createInputError();
	}
	
	@Override
	public String getErrorMessage() {
		return "Должно быть больше " + this.border;
	}
}
