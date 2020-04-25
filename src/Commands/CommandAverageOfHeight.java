package Commands;

import Input.Flat;
import Utils.Context;

/**
 * Команда вывода среднего значения поля height для всех эллементов коллекции
 */
public class CommandAverageOfHeight extends CommandWithNotEmptyCollection {
	public CommandAverageOfHeight(Context context) {
		super(context);
	}
	
	/**
	 * Проходит по всем элементам коллекции
	 * Пропускает если высота null
	 * Если не null добавляет к общей высоте
	 * Выводит среднее значение
	 * @param commandArguments аргументы
	 */
	@Override
	public void execute(String[] commandArguments) {
		int heightTotal = 0;
		
		for (Flat flat : this.context.collectionManager.getCollection()) {
			Integer heightCurrent = flat.getHeight();
			if (heightCurrent == null)
				continue;
			heightTotal += heightCurrent;
		}
		
		int itemsTotal = this.context.collectionManager.getCollectionSize();
		float heightAverage = (float) heightTotal / itemsTotal;
		
		System.out.format("Среднее значение поля height для всех элементов коллекции: %.2f\n", heightAverage);
	}
	
	@Override
	public String getName() {
		return "average_of_height";
	}
	
	@Override
	public String getDescription() {
		return "вывести среднее значение поля height для всех элементов коллекции";
	}
}
