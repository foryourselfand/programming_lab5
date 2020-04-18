package Utils;

import Input.Flat;

public class FlatCreator {
	public Flat getCreatedFlatFromTerminal(LineReader lineReader) {
		lineReader.setRepeatOnException(true);
		
		Flat flat = new Flat();
		
		flat.generateId();
		flat.setFlatName(lineReader, lineReader.getSourceReaderActive());
		
		flat.createCoordinates();
		flat.setX(lineReader, lineReader.getSourceReaderActive());
		flat.setY(lineReader, lineReader.getSourceReaderActive());
		
		flat.generateCreationDate();
		flat.setArea(lineReader, lineReader.getSourceReaderActive());
		flat.setNumberOfRooms(lineReader, lineReader.getSourceReaderActive());
		flat.setHeight(lineReader, lineReader.getSourceReaderActive());
		flat.setIsNew(lineReader, lineReader.getSourceReaderActive());
		flat.setTransport(lineReader, lineReader.getSourceReaderActive());
		
		flat.createHouse();
		flat.setHouseName(lineReader, lineReader.getSourceReaderActive());
		flat.setYear(lineReader, lineReader.getSourceReaderActive());
		flat.setNumberOfFloors(lineReader, lineReader.getSourceReaderActive());
		flat.setNumberOfLifts(lineReader, lineReader.getSourceReaderActive());
		
		lineReader.setRepeatOnException(false);
		
		return flat;
	}
}
