package Input;

import Generators.CreationDateGenerator;
import Generators.IdGenerator;
import SourseReaders.SourceReader;
import Utils.LineReader;
import Utils.ValueParser;

import java.time.LocalDate;
import java.util.Comparator;

public class Flat implements Comparable<Flat> {
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
	
	
	public void generateId() {
		this.id = IdGenerator.generateId();
	}
	
	public void createCoordinates() {
		this.coordinates = new Coordinates();
	}
	
	public void setX(LineReader lineReader, SourceReader sourceReader) {
		this.coordinates.setX(ValueParser.getParsedOrNull(lineReader, sourceReader, Float.class, Variable.X));
	}
	
	public void setY(LineReader lineReader, SourceReader sourceReader) {
		this.coordinates.setY(ValueParser.getParsedOrNull(lineReader, sourceReader, Double.class, Variable.Y));
	}
	
	public void generateCreationDate() {
		this.creationDate = CreationDateGenerator.generateCreationDate();
	}
	
	public void setIsNew(LineReader lineReader, SourceReader sourceReader) {
		this.isNew = ValueParser.getParsedOrNull(lineReader, sourceReader, Boolean.class, Variable.IS_NEW);
	}
	
	public void createHouse() {
		this.house = new House();
	}
	
	public void setHouseName(LineReader lineReader, SourceReader sourceReader) {
		this.house.setHouseName(ValueParser.getParsedOrNull(lineReader, sourceReader, String.class, Variable.HOUSE_NAME, Object.class));
	}
	
	public void setYear(LineReader lineReader, SourceReader sourceReader) {
		this.house.setYear(ValueParser.getParsedOrNull(lineReader, sourceReader, Integer.class, Variable.YEAR));
	}
	
	public void setNumberOfFloors(LineReader lineReader, SourceReader sourceReader) {
		this.house.setNumberOfFloors(ValueParser.getParsedOrNull(lineReader, sourceReader, Long.class, Variable.NUMBER_OF_FLOORS));
	}
	
	public void setNumberOfLifts(LineReader lineReader, SourceReader sourceReader) {
		this.house.setNumberOfLifts(ValueParser.getParsedOrNull(lineReader, sourceReader, Long.class, Variable.NUMBER_OF_LIFTS));
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(LineReader lineReader, SourceReader sourceReader) {
		this.id = ValueParser.getParsedOrNull(lineReader, sourceReader, Long.class, Variable.ID);
	}
	
	public String getFlatName() {
		return flatName;
	}
	
	public void setFlatName(LineReader lineReader, SourceReader sourceReader) {
		this.flatName = ValueParser.getParsedOrNull(lineReader, sourceReader, String.class, Variable.FLAT_NAME, Object.class);
	}
	
	public Coordinates getCoordinates() {
		return coordinates;
	}
	
	public LocalDate getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(LineReader lineReader, SourceReader sourceReader) {
		this.creationDate = ValueParser.getParsedOrNull(lineReader, sourceReader, LocalDate.class, Variable.CREATION_DATE, "parse", CharSequence.class);
	}
	
	public int getArea() {
		return area;
	}
	
	public void setArea(LineReader lineReader, SourceReader sourceReader) {
		this.area = ValueParser.getParsedOrNull(lineReader, sourceReader, Integer.class, Variable.AREA);
	}
	
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	
	public void setNumberOfRooms(LineReader lineReader, SourceReader sourceReader) {
		this.numberOfRooms = ValueParser.getParsedOrNull(lineReader, sourceReader, Integer.class, Variable.NUMBER_OF_ROOMS);
	}
	
	public Integer getHeight() {
		return height;
	}
	
	public void setHeight(LineReader lineReader, SourceReader sourceReader) {
		this.height = ValueParser.getParsedOrNull(lineReader, sourceReader, Integer.class, Variable.HEIGHT);
	}
	
	public Boolean getNew() {
		return isNew;
	}
	
	public Transport getTransport() {
		return transport;
	}
	
	public void setTransport(LineReader lineReader, SourceReader sourceReader) {
		this.transport = ValueParser.getParsedOrNull(lineReader, sourceReader, Transport.class, Variable.TRANSPORT);
	}
	
	public House getHouse() {
		return house;
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
	
	@Override
	public int compareTo(Flat flat) {
		return Comparator
				.comparingInt(Flat::getArea)
				.thenComparingInt(Flat::getNumberOfRooms)
				.compare(this, flat);
	}
}
