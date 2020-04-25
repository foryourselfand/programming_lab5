package SourseReaders;

import java.util.Scanner;

/**
 * Источник ввода из стринга
 */
public class SourceReaderString extends SourceReader {
	/**
	 * Строковое представление источника
	 */
	private final String source;
	
	/**
	 * Создает источник ввода из стринга
	 *
	 * @param value значение для считывания
	 */
	public SourceReaderString(String value) {
		this.source = value;
		this.scanner = new Scanner(value);
	}
	
	/**
	 * Возвращает не имеет ли что читать
	 *
	 * @return не имеет ли что читать
	 */
	@Override
	public boolean notHasSomethingToRead() {
		return ! scanner.hasNextLine();
	}
	
	/**
	 * Возвращает считанную строку и перенос на новую линию
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
		return source;
	}
}
