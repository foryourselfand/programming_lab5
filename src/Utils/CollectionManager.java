package Utils;

import Generators.IdGenerator;
import Input.Flat;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashSet;

/**
 * Управленец коллекцией
 * Предоставляет доступ ко всем операциям связанным с колекцией
 */
public class CollectionManager {
	/**
	 * Коллекция содержащая элементы Flat
	 */
	private final LinkedHashSet<Flat> collection;
	
	/**
	 * Дата инициализации коллекции
	 */
	private LocalDate initializationDate;
	
	public CollectionManager() {
		this.collection = new LinkedHashSet<>();
		this.initializationDate = Context.INITIALIZATION_DATE;
	}
	
	/**
	 * возвращает коллекцию
	 *
	 * @return коллекцию
	 */
	public LinkedHashSet<Flat> getCollection() {
		return collection;
	}
	
	/**
	 * возвращает максимальный эллемент коллекции
	 * спасибо Comparable
	 *
	 * @return максимальный эллемент коллекции
	 */
	public Flat getFlatMax() {
		return Collections.max(collection);
	}
	
	/**
	 * Очищает коллекцию
	 */
	public void clearCollection() {
		this.collection.clear();
	}
	
	/**
	 * Добавляет элемент квартиры в коллекцию
	 * Добавляет id добавляемого элемента квартиры в генератор id
	 * Выводит сообщение о добавлении
	 *
	 * @param flatToAdd элемент квартиры для добавления в коллекцию
	 */
	public void addFlatToCollection(Flat flatToAdd) {
		this.collection.add(flatToAdd);
		IdGenerator.addId(flatToAdd.getId());
		System.out.println("В коллекцию добавлен элемент " + flatToAdd.toString());
	}
	
	/**
	 * Удаляет элемент квартиры из коллекции
	 * Удаляет id удаляемого элемента квартиры в генератор id
	 * Выводит сообщение о удалении
	 *
	 * @param flatToRemove элемент квартиры для удаления из коллекции
	 */
	public void removeFlatFromCollection(Flat flatToRemove) {
		this.collection.remove(flatToRemove);
		IdGenerator.removeId(flatToRemove.getId());
		System.out.println("Из коллекции удален элемент " + flatToRemove.toString());
	}
	
	/**
	 * Выводит элементы коллекции в стандартный поток вывода
	 */
	public void showCollection() {
		for (Flat flat : this.collection)
			System.out.println(flat);
	}
	
	/**
	 * Меняет дату инициализации
	 * Если коллекция не пустая, то дата инициализации коллекции это минимальная дата создания среди всех элемнетов коллекции
	 * Если коллекция пустая, то дата инициализации коллекции это дата инициализация в контексте
	 */
	public void changeInitializationDate() {
		if (! collection.isEmpty())
			this.initializationDate = this.getInitializationDateMin();
		else
			this.initializationDate = Context.INITIALIZATION_DATE;
	}
	
	/**
	 * Возвращает дату инициализации коллекции
	 *
	 * @return дату инициализации коллекции
	 */
	public LocalDate getCollectionInitializationDate() {
		return initializationDate;
	}
	
	/**
	 * Возвращает минимальную дату создания среди всех элемнетов коллекции
	 *
	 * @return минимальную дату создания среди всех элемнетов коллекции
	 */
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
	
	/**
	 * Возвращает строковое представление типа коллекции
	 *
	 * @return строковое представление типа коллекции
	 */
	public String getCollectionType() {
		return LinkedHashSet.class.getSimpleName();
	}
	
	/**
	 * Возвращает строковое представление типа элементов коллекции
	 *
	 * @return строковое представление типа элементов коллекции
	 */
	public String getCollectionElementType() {
		return Flat.class.getSimpleName();
	}
	
	/**
	 * Возвращает количество элементов в коллекции
	 *
	 * @return количество элементов в коллекции
	 */
	public int getCollectionSize() {
		return this.collection.size();
	}
	
	
	/**
	 * Возвращает пуста ли коллекция
	 *
	 * @return пуста ли коллекция
	 */
	public boolean getIsCollectionEmpty() {
		return this.collection.isEmpty();
	}
}
