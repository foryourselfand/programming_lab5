package Expectables.ExpectablesFile;

import Errors.FileErrors.FileNotWritableError;
import Expectables.Expectable;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ExpectableFileWritable implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
		if (! Files.isWritable(Paths.get(valueRaw)))
			throw new FileNotWritableError(valueRaw);
	}
}
