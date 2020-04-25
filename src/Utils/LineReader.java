package Utils;

import Errors.InputErrors.InputErrorFull;
import Errors.ScriptAlreadyExecutedError;
import Expectations.Argument;
import Input.Variable;
import SourseReaders.SourceReader;
import SourseReaders.SourceReaderTerminal;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Считыватель строк
 */
public class LineReader {
	/**
	 * Сет строковых источников из источников ввода
	 */
	private final Set<String> sourceReaderSources;
	
	/**
	 * Стэк источников ввода
	 */
	private final Stack<SourceReader> sourceReaderStack;
	
	/**
	 * Текущий источник ввода
	 */
	private SourceReader sourceReaderActive;
	
	/**
	 * Нужно ли повторик ввод при исключении
	 */
	private boolean repeatOnException;
	
	/**
	 * Создает сет строковых источников из источников ввода
	 * Стэк источников ввода
	 * Добавляет созданный из терминала источник ввода
	 */
	public LineReader() {
		this.sourceReaderSources = new HashSet<>();
		this.sourceReaderStack = new Stack<>();
		this.addSourceReader(new SourceReaderTerminal());
	}
	
	/**
	 * Возвращает считанную строку
	 *
	 * @param sourceReader источник ввода
	 * @param prefix       префикс
	 * @param argument     аргумент
	 * @return считанную строку
	 */
	public String readLine(SourceReader sourceReader, String prefix, Argument argument) {
		while (this.hasSomethingToRead()) {
			if (sourceReader.notHasSomethingToRead())
				sourceReader = getSourceReaderActive();
			
			System.out.print(prefix);
			
			try {
				String lineRead = sourceReader.getLineReadPrintPostfix();
				argument.checkArgument(lineRead);
				
				return lineRead;
			} catch (InputErrorFull inputErrorFull) {
				if (! this.repeatOnException)
					throw inputErrorFull;
				System.out.println(inputErrorFull.getMessage());
			}
		}
		
		return "";
	}
	
	public String readLine(String prefix) {
		return readLine(this.sourceReaderActive, prefix, new Argument(""));
	}
	
	public String readLine(SourceReader sourceReader, Variable variable) {
		Argument argument = Variable.variableToArgument.get(variable);
		return this.readLine(sourceReader, variable.getVariableNameWithExpectationsMessage(argument), argument);
	}
	
	/**
	 * Возвращает истину так как всегда найдется источник ввода способный считывать
	 * Меняет источники ввода пока активному источнику сможет что то считывать
	 *
	 * @return истину так как всегда найдется источник ввода способный считывать
	 */
	public boolean hasSomethingToRead() {
		while (this.sourceReaderActive.notHasSomethingToRead()) {
			SourceReader sourceReader = this.sourceReaderStack.pop();
			String sourceReaderFilePath = sourceReader.getSource();
			this.sourceReaderSources.remove(sourceReaderFilePath);
			
			this.sourceReaderActive = sourceReaderStack.peek();
		}
		
		return true;
	}
	
	/**
	 * Добавляет источник ввода
	 * Устанавливает активный источник ввода на добавленный
	 * Если источник ввода уже добавлялся, пробрасывает ошибку для предотвращения рекурсии
	 *
	 * @param sourceReaderToAdd источник ввода который нужно добавить
	 */
	public void addSourceReader(SourceReader sourceReaderToAdd) {
		String sourceReaderSource = sourceReaderToAdd.getSource();
		
		if (this.sourceReaderSources.contains(sourceReaderSource))
			throw new ScriptAlreadyExecutedError();
		this.sourceReaderSources.add(sourceReaderSource);
		
		this.sourceReaderStack.add(sourceReaderToAdd);
		this.sourceReaderActive = sourceReaderStack.peek();
	}
	
	/**
	 * Возвращает активный источник ввода
	 *
	 * @return активный источник ввода
	 */
	public SourceReader getSourceReaderActive() {
		return sourceReaderActive;
	}
	
	/**
	 * Устанавливает нужно ли повторик ввод при исключении
	 *
	 * @param repeatOnException Нужно ли повторик ввод при исключении
	 */
	public void setRepeatOnException(boolean repeatOnException) {
		this.repeatOnException = repeatOnException;
	}
	
}
