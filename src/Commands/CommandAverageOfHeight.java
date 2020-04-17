package Commands;

import Utils.Context;

public class CommandAverageOfHeight extends Command {
	public CommandAverageOfHeight(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
	
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
