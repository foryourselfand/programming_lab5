import Errors.InputError;
import Input.Flat;
import SourseReader.SourceReader;
import SourseReader.SourceReaderFactory;
import SourseReader.SourceReaderString;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.*;

public class Testing {
//	static String flatName = "flatName";
	
	
	public static void readDataLineByLine(String file) {
		Set<String> headerRequired = new HashSet<>(Arrays.asList("flatName", "x", "y", "area", "numberOfRooms", "height", "isNew", "transport", "houseName", "year", "numberOfFloors", "numberOfLifts"));
		
		try {
			FileReader filereader = new FileReader(file);
			
			CSVReader csvReader = new CSVReader(filereader);
			
			List<String[]> allData = csvReader.readAll();
			List<String> headerRead = Arrays.asList(allData.get(0));
			Set<String> headerActual = new HashSet<>(headerRead);
			
			System.out.println("headerRequired" + headerRequired);
			System.out.println("headerActual" + headerActual);
			System.out.println();
			
			Set<String> missingFields = new HashSet<>(headerRequired);
			missingFields.removeAll(headerActual);
			
			Set<String> extraFields = new HashSet<>(headerActual);
			extraFields.removeAll(headerRequired);
			
			System.out.println("missingFields" + missingFields);
			System.out.println("extraFields" + extraFields);
			System.out.println();
			
			HashMap<String, Integer> fieldToIndex = new HashMap<>();
			
			for (String fieldActual : headerActual)
				fieldToIndex.put(fieldActual, headerRead.indexOf(fieldActual));
			
			for (int index = 1; index < allData.size(); index++) {
				String[] row = allData.get(index);
				
				Flat flat = new Flat();
				
				try {
					flat.setNumberOfRooms(new SourceReaderString(row[fieldToIndex.get("numberOfRooms")]));
					
				} catch (InputError inputError) {
					System.out.println(inputError.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Flat flat = new Flat();
		SourceReader sourceReaderTerminal = SourceReaderFactory.getSourceReaderTerminal();
		sourceReaderTerminal.setRepeatOnException(true);
		
		flat.setNumberOfRooms(sourceReaderTerminal);
	}
	
	public static void main(String[] args) {
		readDataLineByLine("/Users/foryourselfand/Documents/java/itmo/programming_lab5/res/example.csv");
	}
}
