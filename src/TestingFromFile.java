import Errors.InputError;
import Utils.CSVLoader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;

public class TestingFromFile {
	public static void main(String[] args) {
		CSVLoader loader = new CSVLoader();
		try {
			loader.createCollectionFromCSVFile("/Users/foryourselfand/Documents/java/itmo/programming_lab5/res/example.csv");
			
		} catch (InputError inputError) {
			System.out.println(inputError.getMessage());
		} catch (IOException | CsvException e) {
			e.printStackTrace();
		}
	}
}
