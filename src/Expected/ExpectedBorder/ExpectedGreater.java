package Expected.ExpectedBorder;

import java.math.BigDecimal;

public class ExpectedGreater extends ExpectedBorder {
	public ExpectedGreater(int border) {
		super(border);
	}
	
	@Override
	protected void checkValueCorrectnessNumeric(BigDecimal value) {
		if (value.compareTo(this.border) < 0)
			throw createInputError();
	}
	
	@Override
	public String getErrorMessage() {
		return "Должно быть больше " + this.border;
	}
}
