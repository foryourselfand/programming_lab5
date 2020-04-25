package Utils;

import java.util.Random;

/**
 * Держатель рандома, что бы по всей программе не создавать другие экземпляры рандома
 */
public class RandomHolder {
	/**
	 * Инстанция синглтона
	 */
	private static RandomHolder instance;
	
	/**
	 * Рандом
	 */
	public Random random;
	
	private RandomHolder() {
		this.random = new Random();
	}
	
	/**
	 * @return инстанцию синглота
	 */
	public static RandomHolder getInstance() {
		if (RandomHolder.instance == null)
			RandomHolder.instance = new RandomHolder();
		return RandomHolder.instance;
	}
}
