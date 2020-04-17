package Expected.ExpectedFile;

import Expected.Expected;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ExpectedFileExist implements Expected {
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
