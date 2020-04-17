package Expected.ExpectedFile;

import Expected.Expected;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ExpectedFileWritable implements Expected {
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
