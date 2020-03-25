package Expectables.ExpectablesFile;

import Errors.FileErrors.FileNotExistError;
import Expectables.Expectable;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ExpectableFileExist implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
		if (Files.notExists(Paths.get(valueRaw))) {
			throw new FileNotExistError(valueRaw);
		}
	}
}
