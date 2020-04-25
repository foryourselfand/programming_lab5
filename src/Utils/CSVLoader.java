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
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Загрузчик коллекции из csv файда
 */
public class CSVLoader {
	
	
	/**
	 * Создает коллекцию из csv файла
	 * Если неправильный заголовок - кидает ошибку
	 * Не важно в каком порядке идут имена переменных из заголовка в csv файле
	 * Если возникает ошибка в проверке какого либо поля создаваемого элемента, элемент не добавляется
	 *
	 * @param filePath          путь к csv файлу
	 * @param lineReader        источник ввода
	 * @param collectionManager управленца коллекцией
	 */
	public void createCollectionFromFile(String filePath, LineReader lineReader, CollectionManager collectionManager) {
		List<String[]> lines = getLines(filePath);
		
		Header headerActual = new Header(lines.get(0));
		
		checkHeader(headerActual.getSet());
		
		Map<String, Integer> fieldToIndex = getFieldToIndex(headerActual.getSet(), headerActual.getList());
		
		for (int index = 1; index < lines.size(); index++) {
			String[] line = lines.get(index);
			checkForLineElementsLength(line);
			
			try {
				Flat flat = FlatCreator.getCreatedFlatFromFile(lineReader, line, fieldToIndex);
				collectionManager.addFlatToCollection(flat);
			} catch (InputErrorFull inputErrorFull) {
				System.out.println(inputErrorFull.getMessage());
			}
		}
	}
	
	/**
	 * Возвращает считанные строки из csv файла
	 * Если возникает какое то исключение, пробрасывает ошибку InputError
	 *
	 * @param filePath имя к csv файлу
	 * @return Лист считанных и разбитых строк в csv файле
	 */
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
	
	/**
	 * Проверяет заголовок csv файла
	 * Не важно в каком порядке идут имена переменных из заголовка в csv файле
	 * Если не хватает каких то полей, или какие то поля лишние, или и то и другое: пробрасывает исключение с информацией
	 *
	 * @param headerActualSet Сет имен переменных из заголовка в csv файле
	 */
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
	
	/**
	 * Возвращает сет имен переменных которые отсутвуют
	 *
	 * @param headerActual Сет имен переменных из заголовка в csv файле
	 * @return Сет имен переменных которые отсутвуют
	 */
	private Set<String> getMissingFields(Set<String> headerActual) {
		Set<String> missingFields = new HashSet<>(Variable.headerRequired.getSet());
		missingFields.removeAll(headerActual);
		return missingFields;
	}
	
	/**
	 * Возвращает сет имен переменных которые лишние
	 *
	 * @param headerActual Сет имен переменных из заголовка в csv файле
	 * @return Сет имен переменных которые лишние
	 */
	private Set<String> getExtraFields(Set<String> headerActual) {
		Set<String> extraFields = new HashSet<>(headerActual);
		extraFields.removeAll(Variable.headerRequired.getSet());
		return extraFields;
	}
	
	/**
	 * Возвращает созданный Словарь. Ключ: имя переменной квартиры из csv файла. Значение: номер столбца со значением поля квартиры из csv файла
	 *
	 * @param headerSet  Сет имен переменных из заголовка в csv файле
	 * @param headerList Лист имен переменных из заголовка в csv файле
	 * @return созданный Словарь. Ключ: имя переменной квартиры из csv файла. Значение: номер столбца со значением поля квартиры из csv файла
	 */
	private Map<String, Integer> getFieldToIndex(Set<String> headerSet, List<String> headerList) {
		Map<String, Integer> fieldToIndex = new HashMap<>();
		for (String fieldActual : headerSet)
			fieldToIndex.put(fieldActual, headerList.indexOf(fieldActual));
		return fieldToIndex;
	}
	
	/**
	 * Проверяет длинну элементов считанной строки
	 * Если не соответствует необходимой длинне строки, кидает ошибку с информацией
	 *
	 * @param line Считанная и разбитая линия csv файла
	 */
	private void checkForLineElementsLength(String[] line) {
		int headerRequiredLength = Variable.headerRequired.getLength();
		int headerActualLength = line.length;
		if (headerRequiredLength != headerActualLength)
			throw new WrongLineElementsLengthError(line, headerRequiredLength, headerActualLength);
	}
}
