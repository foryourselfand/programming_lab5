package Expectables.ExpectablesBorder;

import Expectables.Expectable;

import java.math.BigDecimal;

public abstract class ExpectableBorder implements Expectable {
	protected BigDecimal border;
	
	public ExpectableBorder(int border) {
		this.border = BigDecimal.valueOf(border);
	}
	
	@Override
	public void checkValueValidnes(String valueRaw) {
		BigDecimal valueNumeric = new BigDecimal(valueRaw);
		this.checkNumericValueValidnes(valueNumeric);
	}
	
	protected abstract void checkNumericValueValidnes(BigDecimal value);
}
