package Expectations.ExpectedDate;

import Expectations.Expectation;
import Utils.Context;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Ожидается дата не позднее чем дата инициализация контекста (сейчас)
 */
public class ExpectedNoLaterThanNow implements Expectation {
	@Override
	public void checkValueCorrectness(String valueRaw) {
		LocalDate dateNow = Context.INITIALIZATION_DATE;
		LocalDate dateChecked = LocalDate.parse(valueRaw, DateTimeFormatter.ISO_DATE);
		if (dateChecked.isAfter(dateNow))
			throw createInputError();
	}
	
	@Override
	public String getErrorMessage() {
		return "Дата должна быть не позже чем сейчас";
	}
}
