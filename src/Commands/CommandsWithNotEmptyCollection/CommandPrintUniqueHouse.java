package Commands.CommandsWithNotEmptyCollection;

import Utils.Context;

public class CommandPrintUniqueHouse extends CommandWithNotEmptyCollection {
	public CommandPrintUniqueHouse(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
	
	}
	
	@Override
	public String getName() {
		return "print_unique_house";
	}
	
	@Override
	public String getDescription() {
		return "вывести уникальные значения поля house";
	}
}
