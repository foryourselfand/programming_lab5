package Input;

import java.util.Objects;

public class House {
	private String houseName; //Поле не может быть null
	private Integer year; //Значение поля должно быть больше 0
	private Long numberOfFloors; //Поле может юыть null, Значение поля должно быть больше 0
	private long numberOfLifts; //Значение поля должно быть больше 0
	
	public String getHouseName() {
		return houseName;
	}
	
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public Long getNumberOfFloors() {
		return numberOfFloors;
	}
	
	public void setNumberOfFloors(Long numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}
	
	public Long getNumberOfLifts() {
		return numberOfLifts;
	}
	
	public void setNumberOfLifts(Long numberOfLifts) {
		this.numberOfLifts = numberOfLifts;
	}
	
	@Override
	public String toString() {
		return "House{" +
				"houseName='" + houseName + '\'' +
				", year=" + year +
				", numberOfFloors=" + numberOfFloors +
				", numberOfLifts=" + numberOfLifts +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (! (o instanceof House)) return false;
		House house = (House) o;
		return getHouseName().equals(house.getHouseName()) &&
				Objects.equals(getYear(), house.getYear()) &&
				Objects.equals(getNumberOfFloors(), house.getNumberOfFloors()) &&
				Objects.equals(getNumberOfLifts(), house.getNumberOfLifts());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getHouseName(), getYear(), getNumberOfFloors(), getNumberOfLifts());
	}
}
