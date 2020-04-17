package Utils;

import Input.Flat;
import SourseReaders.SourceReader;

public class FlatCreator {
	public Flat getCreatedFlatFromTerminal(LineReader lineReader) {
		lineReader.setRepeatOnException(true);
		
		Flat flat = new Flat();
		
		SourceReader sourceReader = lineReader.getSourceReaderActive();
		flat.setLineReader(lineReader);
		
		flat.generateId();
		flat.setFlatName(sourceReader);
		
		flat.createCoordinates();
		flat.setX(sourceReader);
		flat.setY(sourceReader);
		
		flat.generateCreationDate();
		flat.setArea(sourceReader);
		flat.setNumberOfRooms(sourceReader);
		flat.setHeight(sourceReader);
		flat.setIsNew(sourceReader);
		flat.setTransport(sourceReader);
		
		flat.createHouse();
		flat.setHouseName(sourceReader);
		flat.setYear(sourceReader);
		flat.setNumberOfFloors(sourceReader);
		flat.setNumberOfLifts(sourceReader);
		
		lineReader.setRepeatOnException(false);
		
		return flat;
	}
}
