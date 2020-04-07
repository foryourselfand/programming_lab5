import Errors.InputError;
import Input.Flat;
import Input.Variable;
import SourseReader.SourceReaderString;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.*;

public class TestingFromFile {
	private HashMap<String, Integer> fieldToIndex = new HashMap<>();
	private String[] row;
	
	public TestingFromFile() {
	}
	
	public static void main(String[] args) {
		new TestingFromFile().readDataLineByLine("/Users/foryourselfand/Documents/java/itmo/programming_lab5/res/example.csv");
	}
	
	public SourceReaderString createSourceReader(Variable variable) {
//		System.out.println(fieldToIndex);
//		System.out.println(fieldToIndex.get(variable.getVariableName()));
		return new SourceReaderString(row[fieldToIndex.get(variable.getVariableName())]);
	}
	
	public void readDataLineByLine(String file) {
		Set<String> headerRequired = new HashSet<>();
		for (Variable variable : Variable.values())
			headerRequired.add(variable.getVariableName());
		
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
			
			this.fieldToIndex.clear();
			
			for (String fieldActual : headerActual)
				fieldToIndex.put(fieldActual, headerRead.indexOf(fieldActual));
			
			
			for (int index = 1; index < allData.size(); index++) {
				this.row = allData.get(index);
				
				Flat flat = new Flat();
				
				try {
					flat.setId(createSourceReader(Variable.ID));
					flat.setFlatName(createSourceReader(Variable.FLAT_NAME));
					flat.createCoordinates();
					flat.setX(createSourceReader(Variable.X));
					flat.setY(createSourceReader(Variable.Y));
					flat.setCreationDate(createSourceReader(Variable.CREATION_DATE));
					flat.setArea(createSourceReader(Variable.AREA));
					flat.setNumberOfRooms(createSourceReader(Variable.NUMBER_OF_ROOMS));
					flat.setHeight(createSourceReader(Variable.HEIGHT));
					flat.setIsNew(createSourceReader(Variable.IS_NEW));
					flat.setTransport(createSourceReader(Variable.TRANSPORT));
					flat.createHouse();
					flat.setHouseName(createSourceReader(Variable.HOUSE_NAME));
					flat.setYear(createSourceReader(Variable.YEAR));
					flat.setNumberOfFloors(createSourceReader(Variable.NUMBER_OF_FLOORS));
					flat.setNumberOfLifts(createSourceReader(Variable.NUMBER_OF_LIFTS));
					
					System.out.println(flat);
					
					
				} catch (InputError inputError) {
					System.out.println(inputError.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
