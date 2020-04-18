package Utils;

import Input.Flat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FlatRemover {
	private CollectionManager collectionManager;
	
	public FlatRemover(CollectionManager collectionManager) {
		this.collectionManager = collectionManager;
	}
	
	public void removeFlatsById(Long... idsToRemove) {
		Iterator<Flat> flatsToRemove = this.getFlatsToRemove(idsToRemove);
		flatsToRemove.forEachRemaining(flat->this.collectionManager.removeFlatFromCollection(flat));
	}
	
	public Iterator<Flat> getFlatsToRemove(Long... idsToRemoveArray) {
		Set<Flat> flatsToDelete = new HashSet<>();
		Set<Long> idsToDeleteSet = new HashSet<>(Arrays.asList(idsToRemoveArray));
		
		for (Flat flat : this.collectionManager.getCollection()) {
			long idCurrent = flat.getId();
			if (idsToDeleteSet.contains(idCurrent))
				flatsToDelete.add(flat);
		}
		return flatsToDelete.iterator();
	}
}
