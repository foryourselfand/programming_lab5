package Expectations.ExpectedType;

import Expectations.Expectation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Ожидается тип
 */
public abstract class ExpectedType implements Expectation {
	@Override
	public void checkValueCorrectness(String valueRaw) {
		if (valueRaw.equals(""))
			return;
		
		Class numberClass = getNumberClass();
		try {
			Method valueOf = numberClass.getDeclaredMethod("valueOf", String.class);
			valueOf.invoke(new Object(), valueRaw);
			
		} catch (InvocationTargetException | NumberFormatException e) {
			throw createInputError();
		} catch (NoSuchMethodException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return класс, наследник Numeric
	 */
	abstract public Class getNumberClass();
	
	@Override
	public String getErrorMessage() {
		return "Должно быть " + getNumberClass().getSimpleName();
	}
}
