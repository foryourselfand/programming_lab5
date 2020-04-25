package Utils;

import Input.Flat;

import java.util.*;

/**
 * Удаляет квартиры
 */
public class FlatRemover {
	/**
	 * Управленец коллекцией
	 */
	private final CollectionManager collectionManager;
	
	public FlatRemover(CollectionManager collectionManager) {
		this.collectionManager = collectionManager;
	}
	
	/**
	 * Удаляет квартиры из коллекции
	 *
	 * @param idsToRemove лист id элементов коллекции, подлежащих удалению
	 */
	public void removeFlatsById(List<Long> idsToRemove) {
		Iterator<Flat> flatsToRemove = this.getFlatsToRemove(idsToRemove);
		flatsToRemove.forEachRemaining(this.collectionManager::removeFlatFromCollection);
	}
	
	/**
	 * Удаляет квартиру из коллекции
	 *
	 * @param idToRemove id элемента коллекции, подлежащего удалению
	 */
	public void removeFlatsById(Long idToRemove) {
		this.removeFlatsById(Collections.singletonList(idToRemove));
	}
	
	/**
	 * Возвращает итератор квартир подлежащих удалению
	 *
	 * @param idsToRemove лист id элементов коллекции, подлежащих удалению
	 * @return итератор квартир подлежащих удалению
	 */
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
