package Expectations.ExpectedFile;

import Expectations.Expectation;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Ожидается файл доступный для записи
 */
public class ExpectedFileWritable implements Expectation {
	@Override
	public void checkValueCorrectness(String valueRaw) {
		if (! Files.isWritable(Paths.get(valueRaw)))
			throw createInputError();
	}
	
	@Override
	public String getErrorMessage() {
		return "Файл должен быть доступен для записи";
	}
}
