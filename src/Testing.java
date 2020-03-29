import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.List;

public class Testing {
	public static void readDataLineByLine(String file) {
		try {
			FileReader filereader = new FileReader(file);

			CSVReader csvReader = new CSVReader(filereader);
			
			List<String[]> allData = csvReader.readAll();
			 
			for (String[] row : allData) {
				for (String cell : row) {
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
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
