import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.*;

public class Testing {
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


//			for (String[] row : allData) {
//				for (String cell : row) {
//					System.out.print(cell + "\t");
//				}
//				System.out.println();
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		String value = "9223372036854775807";
//
//		Expectable expectedType = new ExpectedType(Long.class);
//		Expectable expectedBoarder = new ExpectedGreater(50);
//		try {
//			expectedType.checkValueValidnes(value);
//			expectedBoarder.checkValueValidnes(value);
//		} catch (Error e) {
//			System.out.println(e.getMessage());
//		}
		
		readDataLineByLine("/Users/foryourselfand/Documents/java/itmo/programming_lab5/res/example.csv");
	}
}
