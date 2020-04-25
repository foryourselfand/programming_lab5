package Input;

import Generators.CreationDateGenerator;
import Generators.IdGenerator;
import SourseReaders.SourceReader;
import Utils.LineReader;
import Utils.ValueReader;

import java.time.LocalDate;
import java.util.Comparator;

/**
 * Элемент хранящийся в коллекции
 * Содержит методы для создания, генерации, считывания (вместе с приведением к нужному типу), а так же геттеры
 */
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
	
	/**
	 * Возвращает результат сравнения на основании площади, потом количества комнат
	 *
	 * @param flat квартира для сравнения
	 * @return результат сравнения на основании площади, потом количества комнат
	 */
	@Override
	public int compareTo(Flat flat) {
		return Comparator
				.comparingInt(Flat::getArea)
				.thenComparingInt(Flat::getNumberOfRooms)
				.compare(this, flat);
	}
	
	public void generateId() {
		this.id = IdGenerator.generateId();
	}
	
	public void setId(LineReader lineReader, SourceReader sourceReader) {
		this.id = ValueReader.getRead(lineReader, sourceReader, Long.class, Variable.ID);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setFlatName(LineReader lineReader, SourceReader sourceReader) {
		this.flatName = ValueReader.getRead(lineReader, sourceReader, String.class, Variable.FLAT_NAME, Object.class);
	}
	
	public String getFlatName() {
		return flatName;
	}
	
	public void createCoordinates() {
		this.coordinates = new Coordinates();
	}
	
	public void setX(LineReader lineReader, SourceReader sourceReader) {
		this.coordinates.setX(ValueReader.getRead(lineReader, sourceReader, Float.class, Variable.X));
	}
	
	public void setY(LineReader lineReader, SourceReader sourceReader) {
		this.coordinates.setY(ValueReader.getRead(lineReader, sourceReader, Double.class, Variable.Y));
	}
	
	public Coordinates getCoordinates() {
		return coordinates;
	}
	
	public float getX() {
		return getCoordinates().getX();
	}
	
	public Double getY() {
		return getCoordinates().getY();
	}
	
	public void generateCreationDate() {
		this.creationDate = CreationDateGenerator.generateCreationDate();
	}
	
	public void setCreationDate(LineReader lineReader, SourceReader sourceReader) {
		this.creationDate = ValueReader.getRead(lineReader, sourceReader, LocalDate.class, Variable.CREATION_DATE, "parse", CharSequence.class);
	}
	
	public LocalDate getCreationDate() {
		return creationDate;
	}
	
	public void setArea(LineReader lineReader, SourceReader sourceReader) {
		this.area = ValueReader.getRead(lineReader, sourceReader, Integer.class, Variable.AREA);
	}
	
	public int getArea() {
		return area;
	}
	
	public void setNumberOfRooms(LineReader lineReader, SourceReader sourceReader) {
		this.numberOfRooms = ValueReader.getRead(lineReader, sourceReader, Integer.class, Variable.NUMBER_OF_ROOMS);
	}
	
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	
	public void setHeight(LineReader lineReader, SourceReader sourceReader) {
		this.height = ValueReader.getRead(lineReader, sourceReader, Integer.class, Variable.HEIGHT);
	}
	
	public Integer getHeight() {
		return height;
	}
	
	public void setIsNew(LineReader lineReader, SourceReader sourceReader) {
		this.isNew = ValueReader.getRead(lineReader, sourceReader, Boolean.class, Variable.IS_NEW);
	}
	
	public Boolean getIsNew() {
		return isNew;
	}
	
	public void setTransport(LineReader lineReader, SourceReader sourceReader) {
		this.transport = ValueReader.getRead(lineReader, sourceReader, Transport.class, Variable.TRANSPORT);
	}
	
	public Transport getTransport() {
		return transport;
	}
	
	public void createHouse() {
		this.house = new House();
	}
	
	public void setHouseName(LineReader lineReader, SourceReader sourceReader) {
		this.house.setHouseName(ValueReader.getRead(lineReader, sourceReader, String.class, Variable.HOUSE_NAME, Object.class));
	}
	
	public void setYear(LineReader lineReader, SourceReader sourceReader) {
		this.house.setYear(ValueReader.getRead(lineReader, sourceReader, Integer.class, Variable.YEAR));
	}
	
	public void setNumberOfFloors(LineReader lineReader, SourceReader sourceReader) {
		this.house.setNumberOfFloors(ValueReader.getRead(lineReader, sourceReader, Long.class, Variable.NUMBER_OF_FLOORS));
	}
	
	public void setNumberOfLifts(LineReader lineReader, SourceReader sourceReader) {
		this.house.setNumberOfLifts(ValueReader.getRead(lineReader, sourceReader, Long.class, Variable.NUMBER_OF_LIFTS));
	}
	
	public House getHouse() {
		return house;
	}
	
	public String getHouseName() {
		return getHouse().getHouseName();
	}
	
	public Integer getYear() {
		return getHouse().getYear();
	}
	
	public Long getNumberOfFloors() {
		return getHouse().getNumberOfFloors();
	}
	
	public long getNumberOfLifts() {
		return getHouse().getNumberOfLifts();
	}
}
