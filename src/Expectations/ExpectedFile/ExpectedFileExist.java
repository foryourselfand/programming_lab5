package Expectations.ExpectedFile;

import Expectations.Expectation;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Ожидается существование файла
 */
public class ExpectedFileExist implements Expectation {
	@Override
	public void checkValueCorrectness(String valueRaw) {
		if (Files.notExists(Paths.get(valueRaw))) {
			throw createInputError();
		}
	}
	
	@Override
	public String getErrorMessage() {
		return "Файл должен существовать";
	}
}
