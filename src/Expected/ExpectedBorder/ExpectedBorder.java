package Expected.ExpectedBorder;

import Expected.Expected;

import java.math.BigDecimal;

public abstract class ExpectedBorder implements Expected {
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
