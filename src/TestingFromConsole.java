import Input.Flat;
import SourseReader.SourceReader;
import SourseReader.SourceReaderFactory;

public class TestingFromConsole {
	public static void main(String[] args) {
		Flat flat = new Flat();
		SourceReader sourceReaderTerminal = SourceReaderFactory.getSourceReaderTerminal();
		sourceReaderTerminal.setRepeatOnException(true);
		
		flat.setNumberOfRooms(sourceReaderTerminal);
	}
}
