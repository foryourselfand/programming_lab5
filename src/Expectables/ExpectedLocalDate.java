package Expectables;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ExpectedLocalDate implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
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
