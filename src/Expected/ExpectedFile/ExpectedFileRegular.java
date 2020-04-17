package Expected.ExpectedFile;

import Expected.Expected;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ExpectedFileRegular implements Expected {
	@Override
	public void checkValueCorrectness(String valueRaw) {
		if (! Files.isRegularFile(Paths.get(valueRaw))) {
			throw createInputError();
		}
	}
	
	@Override
	public String getErrorMessage() {
		return "Файл должен быть обычным файлом (не директорией, не ссылкой)";
	}
}
