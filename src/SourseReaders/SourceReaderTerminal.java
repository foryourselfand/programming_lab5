package SourseReaders;

import java.util.Scanner;


/**
 * Источник ввода из терминала
 */
public class SourceReaderTerminal extends SourceReader {
	
	/**
	 * Создает источник ввода из терминала
	 */
	public SourceReaderTerminal() {
		this.scanner = new Scanner(System.in);
	}
	
	/**
	 * Возвращает ложь, т.к. терминалу всегда есть что считать
	 *
	 * @return ложь, т.к. терминалу всегда есть что считать
	 */
	@Override
	public boolean notHasSomethingToRead() {
		return false;
	}
	
	/**
	 * Возвращает пустую строку, т.к. в терминале все видно
	 *
	 * @param lineRead считанная строка
	 * @return пустую строку, т.к. в терминале все видно
	 */
	@Override
	public String getPostfix(String lineRead) {
		return "";
	}
	
	/**
	 * Возвращает источник
	 *
	 * @return источник
	 */
	@Override
	public String getSource() {
		return "Терминал";
	}
}
