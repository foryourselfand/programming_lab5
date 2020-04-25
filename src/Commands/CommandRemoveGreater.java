package Commands;

import Input.Flat;
import Utils.Context;
import Utils.FlatCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * Команда удаления из коллекции элементов, превышающих заданный
 */
public class CommandRemoveGreater extends CommandWithNotEmptyCollectionSaveAfterExecute {
	public CommandRemoveGreater(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		Flat flatNew = getCreatedFlat();
		List<Long> idsToRemove = getIdsOfFlatsGreaterThatFlat(flatNew);
		removeFlatsGreaterThatFlat(idsToRemove);
	}
	
	/**
	 * Возвращает созданную квартиру
	 *
	 * @return созданную квартиру
	 */
	private Flat getCreatedFlat() {
		Flat createdFlat = FlatCreator.getCreatedFlatFromTerminal(context.lineReader);
		System.out.println("Созданный элемент для сравнения " + createdFlat.toString());
		return createdFlat;
	}
	
	/**
	 * Возвращает лист id квартир больших чем созданная
	 *
	 * @param flatNew созданная квартира
	 * @return лист id квартир больших чем созданная
	 */
	private List<Long> getIdsOfFlatsGreaterThatFlat(Flat flatNew) {
		List<Long> idsToRemove = new ArrayList<>();
		for (Flat flatCurrent : context.collectionManager.getCollection()) {
			if (flatCurrent.compareTo(flatNew) > 0)
				idsToRemove.add(flatCurrent.getId());
		}
		return idsToRemove;
	}
	
	/**
	 * Возвращает id квартир подлежащих удалению
	 *
	 * @param idsToRemove id квартир подлежащих удалению
	 */
	private void removeFlatsGreaterThatFlat(List<Long> idsToRemove) {
		context.flatRemover.removeFlatsById(idsToRemove);
	}
	
	@Override
	public String getName() {
		return "remove_greater";
	}
	
	@Override
	public String getDescription() {
		return "удалить из коллекции все элементы, превышающие заданный";
	}
}
