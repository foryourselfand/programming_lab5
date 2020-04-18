package Utils;

import Input.Variable;
import SourseReaders.SourceReader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ValueReader {
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
	
	public static <T> T getRead(LineReader lineReader, SourceReader sourceReader, Class<T> type, Variable variable) {
		return getRead(lineReader, sourceReader, type, variable, "valueOf", String.class);
	}
	
	public static <T> T getRead(LineReader lineReader, SourceReader sourceReader, Class<T> type, Variable variable, Class parameterType) {
		return getRead(lineReader, sourceReader, type, variable, "valueOf", parameterType);
	}
	
	public static <T> T getRead(LineReader lineReader, SourceReader sourceReader, Class<T> type, Variable variable, String methodName) {
		return getRead(lineReader, sourceReader, type, variable, methodName, String.class);
	}
}
