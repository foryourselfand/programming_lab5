package Utils;

import Errors.IOErrors.CsvError;
import Errors.IOErrors.FileNotExistError;
import Errors.IOErrors.IOError;
import Errors.InputErrors.InputErrorFull;
import Errors.WrongHeaderErrors.WrongHeaderError;
import Errors.WrongHeaderErrors.WrongHeaderFieldsBothError;
import Errors.WrongHeaderErrors.WrongHeaderFieldsSingleError;
import Errors.WrongLineElementsLengthError;
import Input.Flat;
import Input.Variable;
import SourseReaders.SourceReaderString;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CSVLoader {
	private Header headerRequired;
	
	private String[] line;
	private HashMap<String, Integer> fieldToIndex = new HashMap<>();
	
	public CSVLoader() {
		headerRequired = new Header(Variable.values());
	}
	
	private SourceReaderString createSourceReader(Variable variable) {
		return new SourceReaderString(line[fieldToIndex.get(variable.getVariableName())]);
	}
	
	public void createCollectionFromFile(String filePath, LineReader lineReader, CollectionManager collectionManager) {
		List<String[]> lines = getLines(filePath);
		
		Header headerActual = new Header(lines.get(0));
		
		checkHeader(headerActual.getSet());
		
		fieldToIndex = getFieldToIndex(headerActual.getSet(), headerActual.getList());
		
		for (int index = 1; index < lines.size(); index++) {
			line = lines.get(index);
			checkForLineElementsLength(line);
			
			try {
				Flat flat = new Flat();
				
				
				flat.setId(lineReader, createSourceReader(Variable.ID));
				flat.setFlatName(lineReader, createSourceReader(Variable.FLAT_NAME));
				
				flat.createCoordinates();
				flat.setX(lineReader, createSourceReader(Variable.X));
				flat.setY(lineReader, createSourceReader(Variable.Y));
				
				flat.setCreationDate(lineReader, createSourceReader(Variable.CREATION_DATE));
				flat.setArea(lineReader, createSourceReader(Variable.AREA));
				flat.setNumberOfRooms(lineReader, createSourceReader(Variable.NUMBER_OF_ROOMS));
				flat.setHeight(lineReader, createSourceReader(Variable.HEIGHT));
				flat.setIsNew(lineReader, createSourceReader(Variable.IS_NEW));
				flat.setTransport(lineReader, createSourceReader(Variable.TRANSPORT));
				
				flat.createHouse();
				flat.setHouseName(lineReader, createSourceReader(Variable.HOUSE_NAME));
				flat.setYear(lineReader, createSourceReader(Variable.YEAR));
				flat.setNumberOfFloors(lineReader, createSourceReader(Variable.NUMBER_OF_FLOORS));
				flat.setNumberOfLifts(lineReader, createSourceReader(Variable.NUMBER_OF_LIFTS));
				
				collectionManager.addFlatToCollection(flat);
			} catch (InputErrorFull inputErrorFull) {
				System.out.println(inputErrorFull.getMessage());
			}
		}
	}
	
	private List<String[]> getLines(String filePath) {
		try {
			FileReader fileReader = new FileReader(filePath);
			CSVReader csvReader = new CSVReader(fileReader);
			
			return csvReader.readAll();
		} catch (FileNotFoundException e) {
			throw new FileNotExistError();
		} catch (IOException e) {
			throw new IOError();
		} catch (CsvException e) {
			throw new CsvError();
		}
	}
	
	private Set<String> getMissingFields(Set<String> headerActual) {
		Set<String> missingFields = new HashSet<>(headerRequired.getSet());
		missingFields.removeAll(headerActual);
		return missingFields;
	}
	
	private Set<String> getExtraFields(Set<String> headerActual) {
		Set<String> extraFields = new HashSet<>(headerActual);
		extraFields.removeAll(headerRequired.getSet());
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
		if (headerRequired.getLength() != headerActualLength)
			throw new WrongLineElementsLengthError(line, headerRequired.getLength(), headerActualLength);
	}
}
