package Expectations;

import Errors.InputErrors.InputError;
import Errors.WrongArgumentErrors.WrongArgumentError;
import Input.Variable;

import java.util.Arrays;
import java.util.List;

/**
 * Аргумент с именем и ожиданиями
 */
public class Argument {
	private final String name;
	private final List<Expectation> expectations;
	
	/**
	 * Создает аргумент с именем и ожиданиями
	 *
	 * @param name         имя
	 * @param expectations ожидания
	 */
	public Argument(String name, Expectation... expectations) {
		this.name = name;
		this.expectations = Arrays.asList(expectations);
	}
	
	/**
	 * Создает аргумент с именем и ожиданиями
	 *
	 * @param variable     переменная
	 * @param expectations ожидания
	 */
	public Argument(Variable variable, Expectation... expectations) {
		this(variable.getVariableName(), expectations);
	}
	
	/**
	 * Проверяет аргумент на корректность по каждому из ожиданий
	 * Если не соответствует ожиданиям, прорасывается ошибка с именем аргумента и информацией об ожидании
	 *
	 * @param valueForCheck значение для проверки
	 */
	public void checkArgument(String valueForCheck) {
		for (Expectation expectation : this.expectations) {
			try {
				expectation.checkValueCorrectness(valueForCheck);
			} catch (InputError inputError) {
				throw new WrongArgumentError(this.getName(), inputError.getMessage());
			}
		}
	}
	
	/**
	 * Возвращает сообщение об ожиданиях
	 *
	 * @return сообщение об ожиданиях
	 */
	public String getExpectationsMessage() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Expectation expectation : this.expectations) {
			stringBuilder.append(expectation.getErrorMessage());
			stringBuilder.append("; ");
		}
		stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
		
		return stringBuilder.toString();
	}
	
	/**
	 * Возвращает имя
	 *
	 * @return имя
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Возвращает ожидания
	 *
	 * @return ожидания
	 */
	public List<Expectation> getExpectations() {
		return expectations;
	}
}
