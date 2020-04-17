package Expected.ExpectedDate;

import Expected.Expected;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ExpectedLocalDate implements Expected {
	@Override
	public void checkValueCorrectness(String valueRaw) {
		try {
			LocalDate.parse(valueRaw, DateTimeFormatter.ISO_DATE);
		} catch (DateTimeParseException exception) {
			throw createInputError();
		}
	}
	
	@Override
	public String getErrorMessage() {
		return "Дата должна быть в формате ISO (YYYY-MM-DD)";
	}
}
