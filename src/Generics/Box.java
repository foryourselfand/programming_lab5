package Generics;

public class Box<T> {
	T obj;
	
	public void put(T obj) {
		this.obj = obj;
	}
	
	public T get() {
		return obj;
	}
}
