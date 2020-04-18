package Utils;

import Input.Flat;
import SourseReaders.SourceReader;

public class FlatCreator {
	public Flat getCreatedFlatFromTerminal(LineReader lineReader) {
		lineReader.setRepeatOnException(true);
		
		Flat flat = new Flat();
		
		SourceReader sourceReader = lineReader.getSourceReaderActive();
		
		flat.generateId();
		flat.setFlatName(lineReader, sourceReader);
		
		flat.createCoordinates();
		flat.setX(lineReader, sourceReader);
		flat.setY(lineReader, sourceReader);
		
		flat.generateCreationDate();
		flat.setArea(lineReader, sourceReader);
		flat.setNumberOfRooms(lineReader, sourceReader);
		flat.setHeight(lineReader, sourceReader);
		flat.setIsNew(lineReader, sourceReader);
		flat.setTransport(lineReader, sourceReader);
		
		flat.createHouse();
		flat.setHouseName(lineReader, sourceReader);
		flat.setYear(lineReader, sourceReader);
		flat.setNumberOfFloors(lineReader, sourceReader);
		flat.setNumberOfLifts(lineReader, sourceReader);
		
		lineReader.setRepeatOnException(false);
		
		return flat;
	}
}
