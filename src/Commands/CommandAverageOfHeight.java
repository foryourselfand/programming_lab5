package Commands;

import Expected.Argument;
import Input.Flat;
import Utils.Context;

import java.util.List;

public class CommandAverageOfHeight extends CommandWithNotEmptyCollection {
	public CommandAverageOfHeight(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		int heightTotal = 0;
		
		for (Flat flat : this.context.collectionManager.getCollection()) {
			int heightCurrent = flat.getHeight();
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
