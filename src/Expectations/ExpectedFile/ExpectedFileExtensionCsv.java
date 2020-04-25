package Expectations.ExpectedFile;

import Expectations.Expectation;

/**
 * Ожидается расширение файла csv
 */
public class ExpectedFileExtensionCsv implements Expectation {
	@Override
	public void checkValueCorrectness(String valueRaw) {
		if (! valueRaw.endsWith(".csv"))
			throw createInputError();
	}
	
	@Override
	public String getErrorMessage() {
		return "Файл должен быть расширения .csv";
	}
}
