package Generators;

import Utils.RandomHolder;

import java.util.HashSet;
import java.util.Set;

/**
 * Генератор случайного Id
 */
public class IdGenerator {
	/**
	 * Сет id которые уже были сгенерированны
	 */
	private static final Set<Long> ids = new HashSet<>();
	
	/**
	 * Генерирует id
	 * Генерирует пока сгенерированный id не будет уникальным (нет в сете ids)
	 *
	 * @return сгенерированный id
	 */
	public static Long generateId() {
		long randomizedId;
		do {
			randomizedId = RandomHolder.getInstance().random.nextLong();
		} while (randomizedId <= 0 || ids.contains(randomizedId));
		
		ids.add(randomizedId);
		return randomizedId;
	}
	
	/**
	 * Очищает сет ids
	 */
	public static void clear() {
		ids.clear();
	}
	
	/**
	 * Возвращается содержится ли id в сете ids
	 *
	 * @param id id для проверки
	 * @return содержится ли id в сете ids
	 */
	public static boolean containsId(long id) {
		return ids.contains(id);
	}
	
	/**
	 * Добавляет id в сет ids
	 *
	 * @param id id для добавления
	 */
	public static void addId(long id) {
		ids.add(id);
	}
	
	/**
	 * Удаляет id из сета ids
	 *
	 * @param id id для удаления
	 */
	public static void removeId(Long id) {
		ids.remove(id);
	}
}
