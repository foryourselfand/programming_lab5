package Expectations.ExpectedFile;

import Expectations.Expectation;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Ожидается обычный файл (не дирректория)
 */
public class ExpectedFileRegular implements Expectation {
	@Override
	public void checkValueCorrectness(String valueRaw) {
		if (! Files.isRegularFile(Paths.get(valueRaw))) {
			throw createInputError();
		}
	}
	
	@Override
	public String getErrorMessage() {
		return "Файл должен быть обычным файлом (не директорией)";
	}
}
