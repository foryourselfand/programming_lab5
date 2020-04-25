package Expectations.ExpectedFile;

import Expectations.Expectation;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ExpectedFileReadable implements Expectation {
	@Override
	public void checkValueCorrectness(String valueRaw) {
		if (! Files.isReadable(Paths.get(valueRaw))) {
			throw createInputError();
		}
	}
	
	@Override
	public String getErrorMessage() {
		return "Файл должен быть доступен для чтения";
	}
}
