package Expectations.ExpectedBorder;

import Expectations.Expectation;

import java.math.BigDecimal;

public abstract class ExpectedBorder implements Expectation {
	protected BigDecimal border;
	
	public ExpectedBorder(int border) {
		this.border = BigDecimal.valueOf(border);
	}
	
	@Override
	public void checkValueCorrectness(String valueRaw) {
		if (valueRaw.equals(""))
			return;
		
		BigDecimal valueNumeric = new BigDecimal(valueRaw);
		this.checkValueCorrectnessNumeric(valueNumeric);
	}
	
	protected abstract void checkValueCorrectnessNumeric(BigDecimal value);
}
