package Expectables.ExpectablesFile;

import Expectables.Expectable;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ExpectableFileExist implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
		if (Files.notExists(Paths.get(valueRaw))) {
			throw createInputError();
		}
	}
	
	@Override
	public String getErrorMessage() {
		return "Файл должен существовать";
	}
}
