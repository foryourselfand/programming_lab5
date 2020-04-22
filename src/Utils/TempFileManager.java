package Utils;

import Errors.IOErrors.IOError;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TempFileManager {
	public static final Path TEMP_FILE_PATH = Paths.get("res/collections/temp.csv");
	
	public static boolean isTempFileExist() {
		return Files.exists(TEMP_FILE_PATH);
	}
	
	public static void deleteTempFile() {
		try {
			Files.delete(TEMP_FILE_PATH);
		} catch (IOException e) {
			throw new IOError();
		}
	}
	
	public static String getTempFilePath() {
		return TEMP_FILE_PATH.toString();
	}
}
