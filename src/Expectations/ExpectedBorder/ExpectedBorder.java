package Expectations.ExpectedBorder;

import Expectations.Expectation;

import java.math.BigDecimal;

/**
 * Ожидается граница (снизу или сверху)
 */
public abstract class ExpectedBorder implements Expectation {
	/**
	 * Для границы любога нумерического типа (Integer, Long etc)
	 */
	protected BigDecimal border;
	
	/**
	 * Создает ожидателя границы
	 *
	 * @param border граница
	 */
	public ExpectedBorder(long border) {
		this.border = BigDecimal.valueOf(border);
	}
	
	@Override
	public void checkValueCorrectness(String valueRaw) {
		if (valueRaw.equals(""))
			return;
		
		BigDecimal valueNumeric = new BigDecimal(valueRaw);
		this.checkValueCorrectnessNumeric(valueNumeric);
	}
	
	/**
	 * Проверяет приведенное значение на правильность (соответствие всем ожиданиям)
	 * Если приведенное значение не правильно (не соответствуем всем ожиданием) пробрасывается созданная ошибка ввода
	 *
	 * @param value значение для проверки
	 */
	protected abstract void checkValueCorrectnessNumeric(BigDecimal value);
}
