package Expectables.ExpectablesType;

import Expectables.Expectable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ExpectableType implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
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
	
	abstract public Class getNumberClass();
	
	@Override
	public String getErrorMessage() {
		return "Должно быть " + getNumberClass().getSimpleName();
	}
}
