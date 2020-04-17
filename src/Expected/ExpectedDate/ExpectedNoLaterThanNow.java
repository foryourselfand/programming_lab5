package Expected.ExpectedDate;

import Expected.Expected;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExpectedNoLaterThanNow implements Expected {
	@Override
	public void checkValueCorrectness(String valueRaw) {
		LocalDate dateNow = LocalDate.now();
		LocalDate dateChecked = LocalDate.parse(valueRaw, DateTimeFormatter.ISO_DATE);
		if (dateChecked.isAfter(dateNow))
			throw createInputError();
	}
	
	@Override
	public String getErrorMessage() {
		return "Дата должна быть не позже чем сейчас";
	}
}
