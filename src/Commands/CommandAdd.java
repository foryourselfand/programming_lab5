package Commands;

import Input.Flat;
import SourseReaders.SourceReader;
import Utils.Context;

public class CommandAdd extends Command {
	public CommandAdd(Context context) {
		super(context);
	}
	
	@Override
	public void execute(String[] commandArguments) {
		Flat flat = new Flat();
		
		this.context.lineReader.setRepeatOnException(true);
		SourceReader sourceReader = this.context.lineReader.getSourceReaderActive();
		
		flat.setLineReader(this.context.lineReader);
		
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
		
		this.context.lineReader.setRepeatOnException(false);
		
		this.context.collectionManager.addFlatToCollection(flat);
	}
	
	@Override
	public String getNameOfCommand() {
		return "add";
	}
}
