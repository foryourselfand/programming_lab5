package Generators;

import java.time.LocalDate;

/**
 * Генератор даты создания
 */
public class CreationDateGenerator {
	/**
	 * Возвоащает дату создания
	 *
	 * @return дату создания
	 */
	public static LocalDate generateCreationDate() {
		return LocalDate.now();
	}
}
