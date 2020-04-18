package Input;

import Generators.CreationDateGenerator;
import Generators.IdGenerator;
import SourseReaders.SourceReader;
import Utils.LineReader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
	private LineReader lineReader;
	
	public Flat() {
		this.lineReader = new LineReader();
	}
	
	public <T> T getParsedOrNull(SourceReader sourceReader, Class<T> type, Variable variable, String methodName, Class parameterType) {
		String valueRaw = lineReader.readLine(sourceReader, variable);
		
		if (valueRaw.equals(""))
			return null;
		
		try {
			Method valueOf = type.getDeclaredMethod(methodName, parameterType);
			return (T) valueOf.invoke(new Object(), valueRaw);
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public <T> T getParsedOrNull(SourceReader sourceReader, Class<T> type, Variable variable) {
		return getParsedOrNull(sourceReader, type, variable, "valueOf", String.class);
	}
	
	public <T> T getParsedOrNull(SourceReader sourceReader, Class<T> type, Variable variable, Class parameterType) {
		return getParsedOrNull(sourceReader, type, variable, "valueOf", parameterType);
	}
	
	public <T> T getParsedOrNull(SourceReader sourceReader, Class<T> type, Variable variable, String methodName) {
		return getParsedOrNull(sourceReader, type, variable, methodName, String.class);
	}
	
	public void generateId() {
		this.id = IdGenerator.generateId();
	}
	
	public void createCoordinates() {
		this.coordinates = new Coordinates();
	}
	
	public void setX(SourceReader sourceReader) {
		this.coordinates.setX(getParsedOrNull(sourceReader, Float.class, Variable.X));
	}
	
	public void setY(SourceReader sourceReader) {
		this.coordinates.setY(getParsedOrNull(sourceReader, Double.class, Variable.Y));
	}
	
	public void generateCreationDate() {
		this.creationDate = CreationDateGenerator.generateCreationDate();
	}
	
	public void setIsNew(SourceReader sourceReader) {
		this.isNew = getParsedOrNull(sourceReader, Boolean.class, Variable.IS_NEW);
	}
	
	public void createHouse() {
		this.house = new House();
	}
	
	public void setHouseName(SourceReader sourceReader) {
		this.house.setHouseName(getParsedOrNull(sourceReader, String.class, Variable.HOUSE_NAME, Object.class));
	}
	
	public void setYear(SourceReader sourceReader) {
		this.house.setYear(getParsedOrNull(sourceReader, Integer.class, Variable.YEAR));
	}
	
	public void setNumberOfFloors(SourceReader sourceReader) {
		this.house.setNumberOfFloors(getParsedOrNull(sourceReader, Long.class, Variable.NUMBER_OF_FLOORS));
	}
	
	public void setNumberOfLifts(SourceReader sourceReader) {
		this.house.setNumberOfLifts(getParsedOrNull(sourceReader, Long.class, Variable.NUMBER_OF_LIFTS));
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(SourceReader sourceReader) {
		this.id = getParsedOrNull(sourceReader, Long.class, Variable.ID);
	}
	
	public String getFlatName() {
		return flatName;
	}
	
	public void setFlatName(SourceReader sourceReader) {
		this.flatName = getParsedOrNull(sourceReader, String.class, Variable.FLAT_NAME, Object.class);
	}
	
	public Coordinates getCoordinates() {
		return coordinates;
	}
	
	public LocalDate getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(SourceReader sourceReader) {
		this.creationDate = getParsedOrNull(sourceReader, LocalDate.class, Variable.CREATION_DATE, "parse");
	}
	
	public int getArea() {
		return area;
	}
	
	public void setArea(SourceReader sourceReader) {
		this.area = getParsedOrNull(sourceReader, Integer.class, Variable.AREA);
	}
	
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	
	public void setNumberOfRooms(SourceReader sourceReader) {
		this.numberOfRooms = getParsedOrNull(sourceReader, Integer.class, Variable.NUMBER_OF_ROOMS);
	}
	
	public Integer getHeight() {
		return height;
	}
	
	public void setHeight(SourceReader sourceReader) {
		this.height = getParsedOrNull(sourceReader, Integer.class, Variable.HEIGHT);
	}
	
	public Boolean getNew() {
		return isNew;
	}
	
	public Transport getTransport() {
		return transport;
	}
	
	public void setTransport(SourceReader sourceReader) {
		this.transport = getParsedOrNull(sourceReader, Transport.class, Variable.TRANSPORT);
	}
	
	public House getHouse() {
		return house;
	}
	
	public LineReader getLineReader() {
		return lineReader;
	}
	
	public void setLineReader(LineReader lineReader) {
		this.lineReader = lineReader;
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
