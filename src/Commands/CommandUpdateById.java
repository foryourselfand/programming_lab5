package Commands;

import Expectations.Argument;
import Expectations.ExpectedIdExist;
import Expectations.ExpectedType.ExpectedLong;
import Input.Flat;
import Utils.Context;
import Utils.FlatCreator;

import java.util.List;

/**
 * Команда обновления значения элемента коллекции, id которого равен заданному
 */
public class CommandUpdateById extends CommandWithNotEmptyCollectionSaveAfterExecute {
	public CommandUpdateById(Context context) {
		super(context);
	}
	
	@Override
	protected void addArgumentValidators(List<Argument> arguments) {
		arguments.add(new Argument("id",
				new ExpectedLong(),
				new ExpectedIdExist()));
	}
	
	@Override
	public void execute(String[] commandArguments) {
		long idToRemove = Long.parseLong(commandArguments[0]);
		Flat flatNew = createFlatNew();
		removeFlatOld(idToRemove);
		addFlatNew(flatNew);
	}
	
	/**
	 * Возвращает  созданную квартиру
	 *
	 * @return созданную квартиру
	 */
	private Flat createFlatNew() {
		return FlatCreator.getCreatedFlatFromTerminal(this.context.lineReader);
	}
	
	/**
	 * Удаляет старую квартиру
	 *
	 * @param idToRemove id квартиры для удаоения
	 */
	private void removeFlatOld(long idToRemove) {
		context.flatRemover.removeFlatsById(idToRemove);
	}
	
	/**
	 * Добавляет новую квартиру
	 *
	 * @param flatNew квартира для добавления
	 */
	private void addFlatNew(Flat flatNew) {
		context.collectionManager.addFlatToCollection(flatNew);
	}
	
	@Override
	public String getName() {
		return "update_by_id";
	}
	
	@Override
	public String getDescription() {
		return "обновить значение элемента коллекции, id которого равен заданному";
	}
}
