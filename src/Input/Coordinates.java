package Input;

public class Coordinates {
	private float x; //Значение поля должно юыть больше -292
	private Double y; //Значение поля должно быть больше -747, Поле не может быть null
	
	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public Double getY() {
		return y;
	}
	
	public void setY(Double y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Coordinates{" +
				"x=" + x +
				", y=" + y +
				'}';
	}
}
