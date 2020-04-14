package Utils;

import Input.Flat;

import java.util.LinkedHashSet;

public class CollectionManager {
	private LinkedHashSet<Flat> collection;
	
	public CollectionManager() {
		this.collection = new LinkedHashSet<>();
	}
	
	public void setCollection(LinkedHashSet<Flat> collection) {
		this.collection = collection;
		printCollection();
	}
	
	public void addFlatToCollection(Flat flat) {
		this.collection.add(flat);
		printCollection();
	}
	
	public void printCollection() {
		for (Flat flat : this.collection)
			System.out.println(flat);
	}
}
