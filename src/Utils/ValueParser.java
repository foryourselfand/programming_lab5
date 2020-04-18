package Utils;

import Input.Variable;
import SourseReaders.SourceReader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ValueParser {
	public static <T> T getParsedOrNull(LineReader lineReader, SourceReader sourceReader, Class<T> type, Variable variable, String methodName, Class parameterType) {
		String valueRaw = lineReader.readLine(sourceReader, variable);
		
		if (valueRaw.equals(""))
			return null;
		
		try {
			Method valueOf = type.getDeclaredMethod(methodName, parameterType);
			return (T) valueOf.invoke(new Object(), valueRaw);
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> T getParsedOrNull(LineReader lineReader, SourceReader sourceReader, Class<T> type, Variable variable) {
		return getParsedOrNull(lineReader, sourceReader, type, variable, "valueOf", String.class);
	}
	
	public static <T> T getParsedOrNull(LineReader lineReader, SourceReader sourceReader, Class<T> type, Variable variable, Class parameterType) {
		return getParsedOrNull(lineReader, sourceReader, type, variable, "valueOf", parameterType);
	}
	
	public static <T> T getParsedOrNull(LineReader lineReader, SourceReader sourceReader, Class<T> type, Variable variable, String methodName) {
		return getParsedOrNull(lineReader, sourceReader, type, variable, methodName, String.class);
	}
}
