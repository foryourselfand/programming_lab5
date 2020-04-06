package Input;

import SourseReader.SourceReader;
import SourseReader.SourceReaderFactory;
import Utils.LineReader;

public class Flat {
	private Long id; // Поле не может быть null, значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
	private String flatName; //Поле не может быть null, Строка не может быть пустой
	private Coordinates coordinates; //Поле не может быть null
	private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генирироваться автоматически
	private int area; //Значение поля должно быть больше 0
	private int numberOfRooms; //Максимальное значение поля: 11, Значение поля должно быть больше 0
	private Integer height; //Значение поля должно быть больше 0
	private Boolean isNew; //Поле может быть null
	private Transport transport; //Поле не может быть null
	private House house; //Поле не может быть null
	private LineReader lineReader;
	
	public Flat() {
		lineReader = new LineReader(SourceReaderFactory.getSourceReaderTerminal());
	}
	
	public void setId(SourceReader sourceReader) {
		this.id = Long.valueOf(lineReader.readLine(sourceReader, Variable.NUMBER_OF_ROOMS));
	}
	
	public void setFlatName(SourceReader sourceReader) {
		this.flatName = lineReader.readLine(sourceReader, Variable.FLAT_NAME);
	}
	
	public void createCoordinates() {
		this.coordinates = new Coordinates();
	}
	
	public void setX(SourceReader sourceReader) {
		this.coordinates.setX(Float.parseFloat(lineReader.readLine(sourceReader, Variable.X)));
	}
	
	public void setY(SourceReader sourceReader) {
		this.coordinates.setY(Double.parseDouble(lineReader.readLine(sourceReader, Variable.Y)));
	}
	
	public void setNumberOfRooms(SourceReader sourceReader) {
		this.numberOfRooms = Integer.parseInt(lineReader.readLine(sourceReader, Variable.NUMBER_OF_ROOMS));
	}
}
