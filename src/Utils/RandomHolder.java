package Utils;

import java.util.Random;

public class RandomHolder {
	private static RandomHolder instance;
	public Random random;
	
	private RandomHolder() {
		this.random = new Random();
	}
	
	public static RandomHolder getInstance() {
		if (RandomHolder.instance == null)
			RandomHolder.instance = new RandomHolder();
		return RandomHolder.instance;
	}
}
