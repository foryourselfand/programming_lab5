package SourseReaders;

import Errors.IOErrors.FileNotExistError;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Источник ввода из файла
 */
public class SourceReaderFile extends SourceReader {
	private final String path;
	
	/**
	 * Создает источник ввода из файла
	 * Если файла не существует кидает ошибку ввода
	 *
	 * @param path путь к файлу
	 */
	public SourceReaderFile(String path) {
		this.path = path;
		try {
			this.scanner = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			throw new FileNotExistError();
		}
	}
	
	/**
	 * Возвращает не имеет ли что читать
	 *
	 * @return не имеет ли что читать
	 */
	@Override
	public boolean notHasSomethingToRead() {
		return ! this.scanner.hasNextLine();
	}
	
	/**
	 * Возвращает постфикс
	 *
	 * @param lineRead считанная строка
	 * @return постфикс
	 */
	@Override
	public String getPostfix(String lineRead) {
		return lineRead + "\n";
	}
	
	/**
	 * Возвращает источник
	 *
	 * @return источник
	 */
	@Override
	public String getSource() {
		return path;
	}
}
