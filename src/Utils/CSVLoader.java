package Utils;

import Errors.WrongHeaderError;
import Errors.WrongHeaderFieldsBothError;
import Errors.WrongHeaderFieldsSingleError;
import Errors.WrongLineElementsLengthError;
import Input.Flat;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVLoader {
	private static String[] headerRequiredArray = {"flatName", "x", "y", "area", "numberOfRooms", "height", "isNew", "transport", "houseName", "year", "numberOfFloors", "numberOfLifts"};
	private static Set<String> headerRequiredSet = new HashSet<>(Arrays.asList(headerRequiredArray));
	private static int headerRequiredLength = headerRequiredArray.length;
	
	private void getCollectionFromCSVFile(String filePath) throws IOException, CsvException {
		List<String[]> lines = getLines(filePath);
		
		String[] headerActualArray = lines.get(0);
		List<String> headerActualList = Arrays.asList(headerActualArray);
		Set<String> headerActualSet = new HashSet<>(headerActualList);
		
		checkHeader(headerActualSet);
		
		HashMap<String, Integer> fieldToIndex = getFieldToIndex(headerActualSet, headerActualList);
		
		LinkedHashSet<Flat> collection = new LinkedHashSet<>();
		
		for (String[] line: lines) {
			checkForLineElementsLength(line);
			
		}
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
		
		if (missingFieldsSize == 0 && extraFieldsSize == 0)
			throw new WrongHeaderFieldsBothError(missingFieldsSet, extraFieldsSet);
		else if (missingFieldsSize == 0)
			throw new WrongHeaderFieldsSingleError(WrongHeaderError.MESSAGE_MISSING, missingFieldsSet);
		else if (extraFieldsSize == 0)
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
