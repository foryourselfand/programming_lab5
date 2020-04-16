package Utils;

import Generators.IdGenerator;
import Input.Flat;

import java.time.LocalDate;
import java.util.LinkedHashSet;

public class CollectionManager {
	private LinkedHashSet<Flat> collection;
	private LocalDate initializationDate;
	
	public CollectionManager() {
		this.collection = new LinkedHashSet<>();
		this.initializationDate = Context.INITIALIZATION_DATE;
	}
	
	public void clearCollection() {
		this.collection.clear();
	}
	
	public void addFlatToCollection(Flat flat) {
		this.collection.add(flat);
		IdGenerator.addId(flat.getId());
		System.out.println("В коллекцию добавлен элемент " + flat.toString());
		System.out.println();
	}
	
	public void showCollection() {
		if (this.collection.isEmpty()) {
			System.out.println("Коллекция пустая");
			return;
		}
		for (Flat flat : this.collection)
			System.out.println(flat);
	}
	
	public void changeInitializationDate() {
		if (! collection.isEmpty())
			this.initializationDate = this.getInitializationDateMin();
		else
			this.initializationDate = Context.INITIALIZATION_DATE;
	}
	
	public LocalDate getInitializationDate() {
		return initializationDate;
	}
	
	private LocalDate getInitializationDateMin() {
		LocalDate initializationLocalDate = LocalDate.MAX;
		for (Flat flat : this.collection) {
			LocalDate flatLocalDate = flat.getCreationDate();
			if (flatLocalDate.compareTo(initializationLocalDate) < 0) {
				initializationLocalDate = flatLocalDate;
			}
		}
		return initializationLocalDate;
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
