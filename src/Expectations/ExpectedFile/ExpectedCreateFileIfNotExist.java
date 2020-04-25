package Expectations.ExpectedFile;

import Errors.IOErrors.IOError;
import Expectations.Expectation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Не ожидается существование файла
 * Если файла не существует, он будет создан
 * Если существует - ничего
 */
public class ExpectedCreateFileIfNotExist implements Expectation {
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
