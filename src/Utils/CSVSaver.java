package Utils;

import Errors.IOErrors.IOError;
import Input.Flat;
import Input.Variable;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class CSVSaver {
	public void saveCollectionCSV(LinkedHashSet<Flat> collection, String filePath) {
		try {
			FileWriter fileWriter = new FileWriter(filePath);
			CSVWriter csvWriter = new CSVWriter(fileWriter);
			
			List<String[]> data = getDataFromFlatCollection(collection);
			
			csvWriter.writeAll(data);
			csvWriter.close();
		} catch (IOException e) {
			throw new IOError();
		}
	}
	
	public void saveCollectionCSV(LinkedHashSet<Flat> collection) {
		this.saveCollectionCSV(collection, "res/collections/temp.csv");
	}
	
	
	private List<String[]> getDataFromFlatCollection(LinkedHashSet<Flat> collection) {
		List<String[]> data = new ArrayList<>();
		data.add(Variable.headerRequired.getArray());
		
		for (Flat flat : collection) {
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
}
