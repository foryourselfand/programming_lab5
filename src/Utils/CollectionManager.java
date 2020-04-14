package Utils;

import Input.Flat;

import java.util.LinkedHashSet;

public class CollectionManager {
	private LinkedHashSet<Flat> collection;
	
	public void initializeCollection(LinkedHashSet<Flat> collection) {
		this.collection = collection;
		System.out.println("Коллекция инициализированна");
		for (Flat flat : collection)
			System.out.println(flat);
	}
}
