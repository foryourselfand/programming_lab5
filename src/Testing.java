import Generics.Animal;
import Generics.Box;
import Generics.Cat;
import Generics.Dog;

public class Testing {
	public static void pack(Box<? super Animal> box) {
		System.out.println(box.get());
	}
	
	public static void main(String[] args) {
		Box<Cat> box = new Box();

//		box.put(new Animal());
//		pack(box);
//
//		box.put(new Cat());
//		pack(box);
//
//		box.put(new Dog());
//		pack(box);
	}
}
