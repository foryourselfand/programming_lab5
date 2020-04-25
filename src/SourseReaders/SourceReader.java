package SourseReaders;

import java.util.Scanner;

/**
 * Источник ввода
 */
abstract public class SourceReader {
	/**
	 * Сканнер
	 */
	protected Scanner scanner;
	
	/**
	 * Возвращает считанную строку выводит постфикс
	 * @return считанную строку
	 */
	public String getLineReadPrintPostfix() {
		String lineRead = scanner.nextLine();
		
		String postfix = this.getPostfix(lineRead);
		System.out.print(postfix);
		
		return lineRead;
	}
	
	/**
	 * Возвращает не имеет ли что читать
	 *
	 * @return не имеет ли что читать
	 */
	abstract public boolean notHasSomethingToRead();
	
	/**
	 * Возвращает постфикс
	 *
	 * @param lineRead считанная строка
	 * @return постфикс
	 */
	abstract public String getPostfix(String lineRead);
	
	/**
	 * Возвращает источник
	 *
	 * @return источник
	 */
	public abstract String getSource();
}
