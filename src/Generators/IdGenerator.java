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
		} while (randomizedId <= 0 || ids.contains(randomizedId));
		
		ids.add(randomizedId);
		return randomizedId;
	}
	
	public static void clear() {
		ids.clear();
	}
	
	public static boolean containsId(long id) {
		return ids.contains(id);
	}
	
	public static void addId(long id) {
		ids.add(id);
	}
}
