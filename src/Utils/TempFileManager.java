package Utils;

import Errors.IOErrors.IOError;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TempFileManager {
	/**
	 * Путь к временному файлу
	 */
	public static final Path TEMP_FILE_PATH = Paths.get("res/collections/temp.csv");
	
	/**
	 * возвращает существует ли временный файл
	 *
	 * @return существует ли временный файл
	 */
	public static boolean isTempFileExist() {
		return Files.exists(TEMP_FILE_PATH);
	}
	
	/**
	 * Удаляет временный файл
	 */
	public static void deleteTempFile() {
		try {
			Files.delete(TEMP_FILE_PATH);
		} catch (IOException e) {
			throw new IOError();
		}
	}
	
	/**
	 * возвращает строковое представление пути временного файла
	 *
	 * @return строковое представление пути временного файла
	 */
	public static String getTempFilePath() {
		return TEMP_FILE_PATH.toString();
	}
}
