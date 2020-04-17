package Commands;

import Utils.Context;

public class CommandInfo extends Command {
	public CommandInfo(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		System.out.println("Тип коллекции: " + context.collectionManager.getCollectionType());
		System.out.println("Тип элементов коллекции: " + context.collectionManager.getCollectionElementType());
		System.out.println("Дата инициализации коллекции: " + context.collectionManager.getInitializationDate());
		System.out.println("Количество элементов в коллекции: " + context.collectionManager.getCollectionSize());
	}
	
	@Override
	public String getName() {
		return "info";
	}
	
	@Override
	public String getDescription() {
		return "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
	}
}
