package Generators;

import Utils.RandomHolder;

import java.util.HashSet;
import java.util.Set;

public class IdGenerator {
	private static Set<Long> ids = new HashSet<>();
	
	public static Long generateId() {
		long randomizedId;
		do {
			randomizedId = RandomHolder.getInstance().random.nextLong();
		} while (randomizedId <= 0 && ids.contains(randomizedId));
		
		ids.add(randomizedId);
		return randomizedId;
	}
	
	public static void reset() {
		ids.clear();
	}
}
