package Commands;

import Input.Flat;
import Utils.Context;
import Utils.FlatCreator;

/**
 * Команда добавления элемента в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
 */
public class CommandAddIfMax extends CommandSaveAfterExecute {
	public CommandAddIfMax(Context context) {
		super(context);
	}
	
	/**
	 * Создает новую квартиру
	 * Если пустая - добавляет в коллекцию
	 * Если не пустая - сравнивает созданный элемент с максимальным, и добавляет только если превышает
	 *
	 * @param commandArguments аргументы
	 */
	@Override
	public void execute(String[] commandArguments) {
		Flat flatNew = getFlatNew();
		
		if (context.collectionManager.getIsCollectionEmpty()) {
			context.collectionManager.addFlatToCollection(flatNew);
		} else {
			Flat flatMax = getFlatMax();
			addFlatNewToCollectionIfGreaterThatFlatMax(flatNew, flatMax);
		}
	}
	
	/**
	 * Возвращает созданную квартиру
	 * Выводит сообщение и создании
	 *
	 * @return созданную квартиру
	 */
	private Flat getFlatNew() {
		Flat flatNew = FlatCreator.getCreatedFlatFromTerminal(this.context.lineReader);
		System.out.println("Новый элемент " + flatNew.toString());
		return flatNew;
	}
	
	/**
	 * Возвращает максимальный элемент коллекции
	 * Выводит сообщение о максимальном элементе коллекции
	 *
	 * @return максимальный элемент коллекции
	 */
	private Flat getFlatMax() {
		Flat flatMax = context.collectionManager.getFlatMax();
		System.out.println("Наибольший элемент коллекции " + flatMax.toString());
		return flatMax;
	}
	
	/**
	 * Добавляет новую квартиру в коллекцию если она больше максимальной
	 *
	 * @param flatNew квартира новая
	 * @param flatMax квартира максимальная
	 */
	private void addFlatNewToCollectionIfGreaterThatFlatMax(Flat flatNew, Flat flatMax) {
		if (flatNew.compareTo(flatMax) > 0)
			addFlatNewToCollection(flatNew);
		else
			dontAddFlatNewToCollection();
	}
	
	/**
	 * Добавляет новую квартиру в коллекцию
	 *
	 * @param flatNew новая квартира
	 */
	private void addFlatNewToCollection(Flat flatNew) {
		System.out.println("Значение нового элемента превышает значение наибольшего элемента коллекции");
		context.collectionManager.addFlatToCollection(flatNew);
	}
	
	/**
	 * Не добавляет новую квартиру в коллекцию
	 */
	private void dontAddFlatNewToCollection() {
		System.out.println("Значение нового элемента не превышает значение наибольшего элемента коллекции");
		System.out.println("В коллекцию элемент не добавлен");
	}
	
	@Override
	public String getName() {
		return "add_if_max";
	}
	
	@Override
	public String getDescription() {
		return "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
	}
}
