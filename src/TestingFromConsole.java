import Input.Flat;
import SourseReader.SourceReader;
import SourseReader.SourceReaderFactory;

public class TestingFromConsole {
	public static void main(String[] args) {
		Flat flat = new Flat();
		
		SourceReader sourceReaderTerminal = SourceReaderFactory.getSourceReaderTerminal();
		sourceReaderTerminal.setRepeatOnException(true);
		
		flat.generateId();
		flat.setFlatName(sourceReaderTerminal);
		
		flat.createCoordinates();
		flat.setX(sourceReaderTerminal);
		flat.setY(sourceReaderTerminal);
		
		flat.generateCreationDate();
		flat.setArea(sourceReaderTerminal);
		flat.setNumberOfRooms(sourceReaderTerminal);
		flat.setHeight(sourceReaderTerminal);
		flat.setIsNew(sourceReaderTerminal);
		flat.setTransport(sourceReaderTerminal);
		
		flat.createHouse();
		flat.setHouseName(sourceReaderTerminal);
		flat.setYear(sourceReaderTerminal);
		flat.setNumberOfFloors(sourceReaderTerminal);
		flat.setNumberOfLifts(sourceReaderTerminal);
		
		System.out.println(flat);
	}
}
