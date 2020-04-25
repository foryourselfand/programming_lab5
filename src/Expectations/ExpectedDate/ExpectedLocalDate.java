package Expectations.ExpectedDate;

import Expectations.Expectation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Ожидается формат даты
 */
public class ExpectedLocalDate implements Expectation {
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
