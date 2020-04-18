package Commands.CommandsWithNotEmptyCollection;

import Errors.IOErrors.IOError;
import Expected.Argument;
import Expected.ExpectedFile.*;
import Input.Flat;
import Input.Variable;
import Utils.Context;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommandSave extends CommandWithNotEmptyCollection {
	public CommandSave(Context context) {
		super(context);
	}
	
	@Override
	protected void addArgumentValidators(List<Argument> arguments) {
		arguments.add(new Argument(
				"file_name",
				new ExpectedFileExtensionCsv(),
				new ExpectedCreateFileIfNotExist(),
				new ExpectedFileExist(),
				new ExpectedFileRegular(),
				new ExpectedFileWritable()
		));
	}
	
	@Override
	public void execute(String[] commandArguments) {
		String filePath = commandArguments[0];
		
		try {
			FileWriter fileWriter = new FileWriter(filePath);
			CSVWriter csvWriter = new CSVWriter(fileWriter);
			
			List<String[]> data = getDataFromFlatCollection();
			
			csvWriter.writeAll(data);
			csvWriter.close();
			
			System.out.println("Коллекция сохранена в файл");
		} catch (IOException e) {
			throw new IOError();
		}
	}
	
	private List<String[]> getDataFromFlatCollection() {
		List<String[]> data = new ArrayList<>();
		data.add(Variable.headerRequired.getArray());
		
		for (Flat flat : context.collectionManager.getCollection()) {
			List<String> lineList = new ArrayList<>();
			
			lineList.add(String.valueOf(flat.getId()));
			lineList.add(flat.getFlatName());
			lineList.add(String.valueOf(flat.getX()));
			lineList.add(String.valueOf(flat.getY()));
			lineList.add(String.valueOf(flat.getCreationDate()));
			lineList.add(String.valueOf(flat.getArea()));
			lineList.add(String.valueOf(flat.getNumberOfRooms()));
			lineList.add(String.valueOf(flat.getHeight()));
			lineList.add(String.valueOf(flat.getIsNew()));
			lineList.add(String.valueOf(flat.getTransport()));
			lineList.add(flat.getHouseName());
			lineList.add(String.valueOf(flat.getYear()));
			lineList.add(String.valueOf(flat.getNumberOfFloors()));
			lineList.add(String.valueOf(flat.getNumberOfLifts()));
			
			String[] lineArray = lineList.toArray(new String[lineList.size()]);
			data.add(lineArray);
		}
		return data;
	}
	
	@Override
	public String getName() {
		return "save";
	}
	
	@Override
	public String getDescription() {
		return "сохранить коллекцию в файл";
	}
}
