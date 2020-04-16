package Utils;

import Input.Flat;

import java.time.LocalDate;
import java.util.LinkedHashSet;

public class CollectionManager {
	private LinkedHashSet<Flat> collection;
	private LocalDate initializationDate;
	
	public CollectionManager() {
		this.collection = new LinkedHashSet<>();
		this.initializationDate = LocalDate.now();
	}
	
	public void setCollection(LinkedHashSet<Flat> collection) {
		this.collection = collection;
		this.changeInitializationDate(collection);
	}
	
	public void addFlatToCollection(Flat flat) {
		this.collection.add(flat);
	}
	
	public void printCollection() {
		for (Flat flat : this.collection)
			System.out.println(flat);
	}
	
	private void changeInitializationDate(LinkedHashSet<Flat> collection) {
		if (collection.size() != 0)
			this.initializationDate = this.getInitializationDateMin(collection);
		else
			this.initializationDate = LocalDate.now();
	}
	
	private LocalDate getInitializationDateMin(LinkedHashSet<Flat> collection) {
		LocalDate initializationLocalDate = LocalDate.MAX;
		for (Flat flat : collection) {
			LocalDate flatLocalDate = flat.getCreationDate();
			if (flatLocalDate.compareTo(initializationLocalDate) < 0) {
				initializationLocalDate = flatLocalDate;
			}
		}
		return initializationLocalDate;
	}
	
	public LocalDate getInitializationDate() {
		return this.initializationDate;
	}
	
	public String getCollectionType() {
		return LinkedHashSet.class.getSimpleName();
	}
	
	public String getCollectionElementType() {
		return Flat.class.getSimpleName();
	}
	
	public int getCollectionSize() {
		return this.collection.size();
	}
}
