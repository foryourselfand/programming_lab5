package Commands;

import Utils.Context;

/**
 * Команда вывода в стандартный поток всех элементов коллекции в строковом представлении
 */
public class CommandShow extends CommandWithNotEmptyCollection {
	public CommandShow(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		context.collectionManager.showCollection();
	}
	
	@Override
	public String getName() {
		return "show";
	}
	
	@Override
	public String getDescription() {
		return "вывести в стандартный поток все элементы коллекции в строковом представлении";
	}
}
