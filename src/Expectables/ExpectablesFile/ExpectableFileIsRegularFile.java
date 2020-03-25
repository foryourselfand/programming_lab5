package Expectables.ExpectablesFile;

import Errors.FileErrors.FileNotRegularFileError;
import Expectables.Expectable;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ExpectableFileIsRegularFile implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
		if (! Files.isRegularFile(Paths.get(valueRaw))) {
			throw new FileNotRegularFileError(valueRaw);
		}
	}
}
