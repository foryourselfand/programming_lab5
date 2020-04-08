package Utils;

import Errors.*;
import Input.Flat;
import Input.Variable;
import SourseReader.SourceReaderString;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVLoader {
	private static List<String> headerRequiredList;
	private static Set<String> headerRequiredSet;
	private static int headerRequiredLength;
	
	static {
		headerRequiredList = new ArrayList<>();
		for (Variable variable : Variable.values())
			headerRequiredList.add(variable.getVariableName());
		headerRequiredSet = new HashSet<>(headerRequiredList);
		headerRequiredLength = headerRequiredList.size();
	}
	
	private String[] line;
	
	private HashMap<String, Integer> fieldToIndex = new HashMap<>();
	
	private SourceReaderString createSourceReader(Variable variable) {
		return new SourceReaderString(line[fieldToIndex.get(variable.getVariableName())]);
	}
	
	public void createCollectionFromCSVFile(String filePath) throws IOException, CsvException {
		List<String[]> lines = getLines(filePath);
		
		String[] headerActualArray = lines.get(0);
		List<String> headerActualList = Arrays.asList(headerActualArray);
		Set<String> headerActualSet = new HashSet<>(headerActualList);
		
		checkHeader(headerActualSet);
		
		fieldToIndex = getFieldToIndex(headerActualSet, headerActualList);
		
		LinkedHashSet<Flat> collection = new LinkedHashSet<>();
		
		for (int index = 1; index < lines.size(); index++) {
			line = lines.get(index);
			checkForLineElementsLength(line);
			
			try {
				Flat flat = new Flat();
				
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
				
				collection.add(flat);
			} catch (InputError inputError) {
				System.out.println(inputError.getMessage());
			}
		}
		
		for (Flat flat : collection)
			System.out.println(flat.toString());
	}
	
	private List<String[]> getLines(String filePath) throws IOException, CsvException {
		FileReader fileReader = new FileReader(filePath);
		CSVReader csvReader = new CSVReader(fileReader);
		return csvReader.readAll();
	}
	
	private Set<String> getMissingFields(Set<String> headerActual) {
		Set<String> missingFields = new HashSet<>(headerRequiredSet);
		missingFields.removeAll(headerActual);
		return missingFields;
	}
	
	private Set<String> getExtraFields(Set<String> headerActual) {
		Set<String> extraFields = new HashSet<>(headerActual);
		extraFields.removeAll(headerRequiredSet);
		return extraFields;
	}
	
	private void checkHeader(Set<String> headerActualSet) {
		Set<String> missingFieldsSet = getMissingFields(headerActualSet);
		int missingFieldsSize = missingFieldsSet.size();
		
		Set<String> extraFieldsSet = getExtraFields(headerActualSet);
		int extraFieldsSize = extraFieldsSet.size();
		
		if (missingFieldsSize != 0 && extraFieldsSize != 0)
			throw new WrongHeaderFieldsBothError(missingFieldsSet, extraFieldsSet);
		else if (missingFieldsSize != 0)
			throw new WrongHeaderFieldsSingleError(WrongHeaderError.MESSAGE_MISSING, missingFieldsSet);
		else if (extraFieldsSize != 0)
			throw new WrongHeaderFieldsSingleError(WrongHeaderError.MESSAGE_EXTRA, extraFieldsSet);
	}
	
	private HashMap<String, Integer> getFieldToIndex(Set<String> headerSet, List<String> headerList) {
		HashMap<String, Integer> fieldToIndex = new HashMap<>();
		for (String fieldActual : headerSet)
			fieldToIndex.put(fieldActual, headerList.indexOf(fieldActual));
		return fieldToIndex;
	}
	
	private void checkForLineElementsLength(String[] line) {
		int headerActualLength = line.length;
		if (headerRequiredLength != headerActualLength)
			throw new WrongLineElementsLengthError(line, headerRequiredLength, headerActualLength);
	}
}
