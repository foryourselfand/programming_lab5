package Input;

import Generators.CreationDateGenerator;
import Generators.IdGenerator;
import SourseReader.SourceReader;
import Utils.LineReader;

import java.time.LocalDate;

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
		lineReader = new LineReader();
	}
	
	public void setId(SourceReader sourceReader) {
		this.id = Long.valueOf(lineReader.readLine(sourceReader, Variable.ID));
	}
	
	public void generateId() {
		this.id = IdGenerator.generateId();
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
	
	public void setCreationDate(SourceReader sourceReader) {
		this.creationDate = LocalDate.parse(lineReader.readLine(sourceReader, Variable.CREATION_DATE));
	}
	
	public void generateCreationDate() {
		this.creationDate = CreationDateGenerator.generateCreationDate();
	}
	
	public void setArea(SourceReader sourceReader) {
		this.area = Integer.parseInt(lineReader.readLine(sourceReader, Variable.AREA));
	}
	
	public void setNumberOfRooms(SourceReader sourceReader) {
		this.numberOfRooms = Integer.parseInt(lineReader.readLine(sourceReader, Variable.NUMBER_OF_ROOMS));
	}
	
	public void setHeight(SourceReader sourceReader) {
		this.height = Integer.parseInt(lineReader.readLine(sourceReader, Variable.HEIGHT));
	}
	
	public void setIsNew(SourceReader sourceReader) {
		this.isNew = Boolean.parseBoolean(lineReader.readLine(sourceReader, Variable.IS_NEW));
	}
	
	public void setTransport(SourceReader sourceReader) {
		this.transport = Transport.valueOf(lineReader.readLine(sourceReader, Variable.TRANSPORT));
	}
	
	public void createHouse() {
		this.house = new House();
	}
	
	public void setHouseName(SourceReader sourceReader) {
		this.house.setHouseName(lineReader.readLine(sourceReader, Variable.HOUSE_NAME));
	}
	
	public void setYear(SourceReader sourceReader) {
		this.house.setYear(Integer.valueOf(lineReader.readLine(sourceReader, Variable.YEAR)));
	}
	
	public void setNumberOfFloors(SourceReader sourceReader) {
		this.house.setNumberOfFloors(Long.parseLong(lineReader.readLine(sourceReader, Variable.NUMBER_OF_FLOORS)));
	}
	
	public void setNumberOfLifts(SourceReader sourceReader) {
		this.house.setNumberOfLifts(Long.parseLong(lineReader.readLine(sourceReader, Variable.NUMBER_OF_LIFTS)));
	}
	
	@Override
	public String toString() {
		return "Flat{" +
				"id=" + id +
				", flatName='" + flatName + '\'' +
				", coordinates=" + coordinates +
				", creationDate=" + creationDate +
				", area=" + area +
				", numberOfRooms=" + numberOfRooms +
				", height=" + height +
				", isNew=" + isNew +
				", transport=" + transport +
				", house=" + house +
				'}';
	}
}
