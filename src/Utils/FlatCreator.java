package Utils;

import Input.Flat;
import Input.Variable;
import SourseReaders.SourceReader;
import SourseReaders.SourceReaderString;

import java.util.Map;

/**
 * Создает квартиры
 */
public class FlatCreator {
	/**
	 * @param lineReader источник ввода
	 * @return созданную квартиру считанную из терминала
	 */
	public static Flat getCreatedFlatFromTerminal(LineReader lineReader) {
		lineReader.setRepeatOnException(true);
		SourceReader sourceReaderActive = lineReader.getSourceReaderActive();
		
		Flat flat = new Flat();
		
		flat.generateId();
		flat.setFlatName(lineReader, sourceReaderActive);
		
		flat.createCoordinates();
		flat.setX(lineReader, sourceReaderActive);
		flat.setY(lineReader, sourceReaderActive);
		
		flat.generateCreationDate();
		flat.setArea(lineReader, sourceReaderActive);
		flat.setNumberOfRooms(lineReader, sourceReaderActive);
		flat.setHeight(lineReader, sourceReaderActive);
		flat.setIsNew(lineReader, sourceReaderActive);
		flat.setTransport(lineReader, sourceReaderActive);
		
		flat.createHouse();
		flat.setHouseName(lineReader, sourceReaderActive);
		flat.setYear(lineReader, sourceReaderActive);
		flat.setNumberOfFloors(lineReader, sourceReaderActive);
		flat.setNumberOfLifts(lineReader, sourceReaderActive);
		
		lineReader.setRepeatOnException(false);
		
		return flat;
	}
	
	/**
	 * Возвращает созданную квартиру считанную из csv файла
	 *
	 * @param lineReader   источник ввода
	 * @param line         Считанная и разбитая линия csv файла
	 * @param fieldToIndex Словарь. Ключ: имя переменной квартиры из csv файла. Значение: номер столбца со значением поля квартиры из csv файла
	 * @return созданную квартиру считанную из csv файла
	 */
	public static Flat getCreatedFlatFromFile(LineReader lineReader, String[] line, Map<String, Integer> fieldToIndex) {
		Flat flat = new Flat();
		
		flat.setId(lineReader, createSourceReader(line, fieldToIndex, Variable.ID));
		flat.setFlatName(lineReader, createSourceReader(line, fieldToIndex, Variable.FLAT_NAME));
		
		flat.createCoordinates();
		flat.setX(lineReader, createSourceReader(line, fieldToIndex, Variable.X));
		flat.setY(lineReader, createSourceReader(line, fieldToIndex, Variable.Y));
		
		flat.setCreationDate(lineReader, createSourceReader(line, fieldToIndex, Variable.CREATION_DATE));
		flat.setArea(lineReader, createSourceReader(line, fieldToIndex, Variable.AREA));
		flat.setNumberOfRooms(lineReader, createSourceReader(line, fieldToIndex, Variable.NUMBER_OF_ROOMS));
		flat.setHeight(lineReader, createSourceReader(line, fieldToIndex, Variable.HEIGHT));
		flat.setIsNew(lineReader, createSourceReader(line, fieldToIndex, Variable.IS_NEW));
		flat.setTransport(lineReader, createSourceReader(line, fieldToIndex, Variable.TRANSPORT));
		
		flat.createHouse();
		flat.setHouseName(lineReader, createSourceReader(line, fieldToIndex, Variable.HOUSE_NAME));
		flat.setYear(lineReader, createSourceReader(line, fieldToIndex, Variable.YEAR));
		flat.setNumberOfFloors(lineReader, createSourceReader(line, fieldToIndex, Variable.NUMBER_OF_FLOORS));
		flat.setNumberOfLifts(lineReader, createSourceReader(line, fieldToIndex, Variable.NUMBER_OF_LIFTS));
		
		return flat;
	}
	
	/**
	 * Возвращает создает источник чтения из строки
	 *
	 * @param line         Считанная и разбитая линия csv файла
	 * @param fieldToIndex Словарь. Ключ: имя переменной квартиры из csv файла. Значение: номер столбца со значением поля квартиры из csv файла
	 * @param variable     Имя переменной квартиры
	 * @return источник чтения из строки
	 */
	private static SourceReaderString createSourceReader(String[] line, Map<String, Integer> fieldToIndex, Variable variable) {
		return new SourceReaderString(line[fieldToIndex.get(variable.getVariableName())]);
	}
}
