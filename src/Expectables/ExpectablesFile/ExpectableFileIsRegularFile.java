package Expectables.ExpectablesFile;

import Expectables.Expectable;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ExpectableFileIsRegularFile implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
		if (! Files.isRegularFile(Paths.get(valueRaw))) {
			throw createInputError();
		}
	}
	
	@Override
	public String getErrorMessage() {
		return "Файл должен быть обычным файлом (не директорией, не ссылкой)";
	}
}
