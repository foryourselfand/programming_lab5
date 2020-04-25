package Utils;

import Input.Variable;
import SourseReaders.SourceReader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Чтец значений и конвертации к нужному типу
 */
public class ValueReader {
	/**
	 * Возвращает считанное и приведенное к нужному типу значение
	 * Если считанная строка - пустая, возвращает null
	 *
	 * @param lineReader    чтец строк
	 * @param sourceReader  источник ввода
	 * @param typeReturn    класс возвращаемого типа
	 * @param variable      переменная
	 * @param methodName    имя метода конвертации
	 * @param typeParameter параметр аргумента метода конвертации
	 * @param <T>           возвращаемый тип
	 * @return считанное и приведенное к нужному типу значение. Если считанная строка - пустая, возвращает null
	 */
	public static <T> T getRead(LineReader lineReader, SourceReader sourceReader, Class<T> typeReturn, Variable variable, String methodName, Class typeParameter) {
		String valueRaw = lineReader.readLine(sourceReader, variable);
		
		if (valueRaw.equals(""))
			return null;
		
		try {
			Method method = typeReturn.getDeclaredMethod(methodName, typeParameter);
			return (T) method.invoke(new Object(), valueRaw);
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Возвращает считанное и приведенное к нужному типу значение
	 * Если считанная строка - пустая, возвращает null
	 * Имя метода конвертации - valueOf
	 *
	 * @param lineReader    чтец строк
	 * @param sourceReader  источник ввода
	 * @param typeReturn    класс возвращаемого типа
	 * @param variable      переменная
	 * @param typeParameter параметр аргумента метода конвертации
	 * @param <T>           возвращаемый тип
	 * @return считанное и приведенное к нужному типу значение. Если считанная строка - пустая, возвращает null
	 */
	public static <T> T getRead(LineReader lineReader, SourceReader sourceReader, Class<T> typeReturn, Variable variable, Class typeParameter) {
		return getRead(lineReader, sourceReader, typeReturn, variable, "valueOf", typeParameter);
	}
	
	/**
	 * Возвращает считанное и приведенное к нужному типу значение
	 * Если считанная строка - пустая, возвращает null
	 * Имя метода конвертации - valueOf
	 * параметр аргумента метода конвертации - String
	 *
	 * @param lineReader   чтец строк
	 * @param sourceReader источник ввода
	 * @param typeReturn   класс возвращаемого типа
	 * @param variable     переменная
	 * @param <T>          озвращаемый тип
	 * @return считанное и приведенное к нужному типу значение. Если считанная строка - пустая, возвращает null
	 */
	public static <T> T getRead(LineReader lineReader, SourceReader sourceReader, Class<T> typeReturn, Variable variable) {
		return getRead(lineReader, sourceReader, typeReturn, variable, "valueOf", String.class);
	}
}
