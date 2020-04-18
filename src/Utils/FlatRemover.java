package Utils;

import Input.Flat;

import java.util.*;

public class FlatRemover {
	private CollectionManager collectionManager;
	
	public FlatRemover(CollectionManager collectionManager) {
		this.collectionManager = collectionManager;
	}
	
	public void removeFlatsById(List<Long> idsToRemove) {
		Iterator<Flat> flatsToRemove = this.getFlatsToRemove(idsToRemove);
		flatsToRemove.forEachRemaining(flat->this.collectionManager.removeFlatFromCollection(flat));
	}
	
	public void removeFlatsById(Long idToRemove) {
		this.removeFlatsById(Collections.singletonList(idToRemove));
	}
	
	private Iterator<Flat> getFlatsToRemove(List<Long> idsToRemove) {
		Set<Flat> flatsToDelete = new HashSet<>();
		Set<Long> idsToDeleteSet = new HashSet<>(idsToRemove);
		
		for (Flat flat : this.collectionManager.getCollection()) {
			long idCurrent = flat.getId();
			if (idsToDeleteSet.contains(idCurrent))
				flatsToDelete.add(flat);
		}
		return flatsToDelete.iterator();
	}
}
