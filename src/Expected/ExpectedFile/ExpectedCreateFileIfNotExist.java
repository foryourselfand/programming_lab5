package Expected.ExpectedFile;

import Errors.IOErrors.IOError;
import Expected.Expected;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExpectedCreateFileIfNotExist implements Expected {
	@Override
	public void checkValueCorrectness(String valueRaw) {
		if (Files.notExists(Paths.get(valueRaw))) {
			File fileToCreate = new File(valueRaw);
			try {
				fileToCreate.createNewFile();
			} catch (IOException e) {
				throw new IOError();
			}
		}
	}
	
	@Override
	public String getErrorMessage() {
		return "Если файла не существует, он будет создан";
	}
}
