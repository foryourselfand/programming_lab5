package Expectables.ExpectablesFile;

import Expectables.Expectable;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ExpectableFileReadable implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
		if (! Files.isReadable(Paths.get(valueRaw))) {
			throw createInputError();
		}
	}
	
	@Override
	public String getErrorMessage() {
		return "Файл должен быть доступен для чтения";
	}
}
