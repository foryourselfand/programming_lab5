package Commands;

import Utils.Context;

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
		return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
	}
}
